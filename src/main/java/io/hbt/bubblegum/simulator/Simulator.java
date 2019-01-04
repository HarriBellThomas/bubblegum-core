package io.hbt.bubblegum.simulator;

import com.google.common.base.Charsets;
import io.hbt.bubblegum.core.Bubblegum;
import io.hbt.bubblegum.core.Configuration;
import io.hbt.bubblegum.core.kademlia.BubblegumNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Simulator {

    private SimulationConfig config;

    // Simulation details
    private Bubblegum bubblegum;

    private int totalBackgroundTasks = 1;
    private int backgroundSoftFails = 0;
    private AtomicInteger backgroundTasksCompleted;
    private Queue<Runnable> bootstrapActions = new LinkedList<>();

    private List<String> backgroundNetworks = new ArrayList<>();

    public Simulator(SimulationConfig config) {
        this.config = config;
        this.bubblegum = new Bubblegum(false);
        this.setupBackgroundNetwork();
    }

    private void runBootstrap(BubblegumNode oldNode, BubblegumNode newNode, int attempt) {
        boolean success = newNode.bootstrap(
            oldNode.getServer().getLocal(),
            oldNode.getServer().getPort(),
            oldNode.getRecipientID()
        );

        if(!success || newNode.getRoutingTable().getSize() < 2) {
            backgroundSoftFails++;
            if(attempt >= 5) System.err.println("Failed to bootstrap node");
            else bootstrapActions.add(() -> this.runBootstrap(oldNode, newNode, attempt + 1));
        }
        else {
            int completed = backgroundTasksCompleted.getAndIncrement();
            System.out.print(
                "\r[Background Network] " +
                    String.format("%.2f", (100 * ((float) (completed + 1) / totalBackgroundTasks))) +
                    "% completed " +
                    "(" + backgroundSoftFails + " soft fails)"
            );
        }
    }

    private void runBootstrap(BubblegumNode oldNode) {
        BubblegumNode newNode = this.bubblegum.createNode();
        this.runBootstrap(oldNode, newNode, 1);
    }

    private void setupBackgroundNetwork() {
        System.out.println("[Background Network] Initialising...");

        this.backgroundTasksCompleted = new AtomicInteger(0);
        long start = System.currentTimeMillis();
        this.totalBackgroundTasks = this.config.getNumNetworks() * this.config.getNumNetworkNodes();

        List<Runnable> tasks = new ArrayList<>();
        for(int i = 0; i < this.config.getNumNetworks(); i++) {
            BubblegumNode node = this.bubblegum.createNode();
            for (int j = 1; j < this.config.getNumNetworkNodes(); j++) {
                tasks.add(() -> runBootstrap(node));
            }
        }

        Collections.shuffle(tasks, new Random());
        bootstrapActions.addAll(tasks);
        tasks.clear();
        System.out.println("[Background Network] " + bootstrapActions.size() + " tasks prepared...");

        int threadPoolSize = 20;
        Thread[] executors = new Thread[threadPoolSize];
        for(int i = 0; i < threadPoolSize; i++) {
            executors[i] = new Thread(() -> {
                Runnable task;
                while(!bootstrapActions.isEmpty()) {
                    synchronized (bootstrapActions) {
                        task = bootstrapActions.poll();
                    }

                    if(task == null) break;
                    else task.run();
                }
            });
            executors[i].start();
        }

        for(Thread t : executors) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.print("\r[Background Network] Completed " + totalBackgroundTasks + " nodes in " + (end - start) + "ms\n");
        System.gc();
        this.validateBootstrap();
        this.backgroundChatter();
    }

    private void validateBootstrap() {
        System.out.println("[Background Network] Validating bootstrapping...");

        int fails = 0;
        for(String id : this.bubblegum.getNodeIdentifiers()) {
            if(this.bubblegum.getNode(id).getRoutingTable().getSize() < 2) fails++;
        }

        int numNodes = this.bubblegum.getNodeIdentifiers().size();
        System.out.println("[Background Network] " + (numNodes - fails) + " succeeded, " + fails + " failed");
    }

    private void backgroundChatter() {
        System.out.println("[Background Network] Running chatter...");

        Set<String> backgroundNodes = this.bubblegum.getNodeIdentifiers();

        int postRate = this.config.getNewPostsEveryHour();
        float postsPerNodePerHour = (float)postRate / backgroundNodes.size();
        float nodeSecondsPerPost = 3600 / postsPerNodePerHour;
        int feedRate = this.config.getFeedRetrievalsEveryHour();
        float feedPerNodePerHour = (float)feedRate / backgroundNodes.size();
        float nodeSecondPerFeed = 3600 / feedPerNodePerHour;

        int randomNum, randomNum2;
        for(String id : backgroundNodes) {
            BubblegumNode node = this.bubblegum.getNode(id);

            randomNum = ThreadLocalRandom.current().nextInt(0, (int)Math.ceil(nodeSecondsPerPost));
            node.getExecutionContext().scheduleTask(() -> {
                node.savePost(randomText(100));
            }, randomNum, (long)Math.ceil(nodeSecondsPerPost), TimeUnit.SECONDS);

            randomNum2 = ThreadLocalRandom.current().nextInt(0, (int)Math.ceil(nodeSecondPerFeed));
            node.getExecutionContext().scheduleTask(() -> {
                System.out.println("Started ANQ for " + node.getNodeIdentifier().toString());
                AsyncNetworkQuery q = new AsyncNetworkQuery(node);
                long current = System.currentTimeMillis() / Configuration.BIN_EPOCH_DURATION;
                q.addID(current);
                q.run();
                q.onChange(() -> System.out.println("ANQ change for " + node.getNodeIdentifier().toString()));
            }, randomNum2, (long)Math.ceil(nodeSecondsPerPost), TimeUnit.SECONDS);
        }
    }

    private String randomText(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        return new String(array, Charsets.US_ASCII);
    }

    public static void main(String[] args) {
        SimulationConfig config = new SimulationConfig("simulation.yml");
        new Simulator(config);
        while(true) {}
    }
}
