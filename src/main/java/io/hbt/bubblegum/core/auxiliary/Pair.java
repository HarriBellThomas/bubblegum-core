package io.hbt.bubblegum.core.auxiliary;

public class Pair<U,V> {
    private U first;
    private V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return this.first;
    }

    public V getSecond() {
        return this.second;
    }

    public void setFirst(U newFirst) {
        this.first = newFirst;
    }

    public void setSecond(V newSecond) {
        this.second = newSecond;
    }
}