// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BgKademliaNode.proto

package io.hbt.bubblegum.core.kademlia.protobuf;

public final class BgKademliaNode {
  private BgKademliaNode() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface KademliaNodeOrBuilder extends
      // @@protoc_insertion_point(interface_extends:io.hbt.bubblegum.core.kademlia.protobuf.KademliaNode)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string hash = 1;</code>
     */
    java.lang.String getHash();
    /**
     * <code>string hash = 1;</code>
     */
    com.google.protobuf.ByteString
        getHashBytes();

    /**
     * <code>string ipAddress = 2;</code>
     */
    java.lang.String getIpAddress();
    /**
     * <code>string ipAddress = 2;</code>
     */
    com.google.protobuf.ByteString
        getIpAddressBytes();

    /**
     * <code>int32 port = 3;</code>
     */
    int getPort();
  }
  /**
   * Protobuf type {@code io.hbt.bubblegum.core.kademlia.protobuf.KademliaNode}
   */
  public  static final class KademliaNode extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:io.hbt.bubblegum.core.kademlia.protobuf.KademliaNode)
      KademliaNodeOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use KademliaNode.newBuilder() to construct.
    private KademliaNode(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private KademliaNode() {
      hash_ = "";
      ipAddress_ = "";
      port_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private KademliaNode(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              hash_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              ipAddress_ = s;
              break;
            }
            case 24: {

              port_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode.class, io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode.Builder.class);
    }

    public static final int HASH_FIELD_NUMBER = 1;
    private volatile java.lang.Object hash_;
    /**
     * <code>string hash = 1;</code>
     */
    public java.lang.String getHash() {
      java.lang.Object ref = hash_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hash_ = s;
        return s;
      }
    }
    /**
     * <code>string hash = 1;</code>
     */
    public com.google.protobuf.ByteString
        getHashBytes() {
      java.lang.Object ref = hash_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        hash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int IPADDRESS_FIELD_NUMBER = 2;
    private volatile java.lang.Object ipAddress_;
    /**
     * <code>string ipAddress = 2;</code>
     */
    public java.lang.String getIpAddress() {
      java.lang.Object ref = ipAddress_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ipAddress_ = s;
        return s;
      }
    }
    /**
     * <code>string ipAddress = 2;</code>
     */
    public com.google.protobuf.ByteString
        getIpAddressBytes() {
      java.lang.Object ref = ipAddress_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ipAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PORT_FIELD_NUMBER = 3;
    private int port_;
    /**
     * <code>int32 port = 3;</code>
     */
    public int getPort() {
      return port_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getHashBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, hash_);
      }
      if (!getIpAddressBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, ipAddress_);
      }
      if (port_ != 0) {
        output.writeInt32(3, port_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getHashBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, hash_);
      }
      if (!getIpAddressBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, ipAddress_);
      }
      if (port_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, port_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode)) {
        return super.equals(obj);
      }
      io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode other = (io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode) obj;

      boolean result = true;
      result = result && getHash()
          .equals(other.getHash());
      result = result && getIpAddress()
          .equals(other.getIpAddress());
      result = result && (getPort()
          == other.getPort());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + HASH_FIELD_NUMBER;
      hash = (53 * hash) + getHash().hashCode();
      hash = (37 * hash) + IPADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getIpAddress().hashCode();
      hash = (37 * hash) + PORT_FIELD_NUMBER;
      hash = (53 * hash) + getPort();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code io.hbt.bubblegum.core.kademlia.protobuf.KademliaNode}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:io.hbt.bubblegum.core.kademlia.protobuf.KademliaNode)
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNodeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode.class, io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode.Builder.class);
      }

      // Construct using io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        hash_ = "";

        ipAddress_ = "";

        port_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_descriptor;
      }

      @java.lang.Override
      public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode getDefaultInstanceForType() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode.getDefaultInstance();
      }

      @java.lang.Override
      public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode build() {
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode buildPartial() {
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode result = new io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode(this);
        result.hash_ = hash_;
        result.ipAddress_ = ipAddress_;
        result.port_ = port_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode) {
          return mergeFrom((io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode other) {
        if (other == io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode.getDefaultInstance()) return this;
        if (!other.getHash().isEmpty()) {
          hash_ = other.hash_;
          onChanged();
        }
        if (!other.getIpAddress().isEmpty()) {
          ipAddress_ = other.ipAddress_;
          onChanged();
        }
        if (other.getPort() != 0) {
          setPort(other.getPort());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object hash_ = "";
      /**
       * <code>string hash = 1;</code>
       */
      public java.lang.String getHash() {
        java.lang.Object ref = hash_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          hash_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string hash = 1;</code>
       */
      public com.google.protobuf.ByteString
          getHashBytes() {
        java.lang.Object ref = hash_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          hash_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string hash = 1;</code>
       */
      public Builder setHash(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        hash_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string hash = 1;</code>
       */
      public Builder clearHash() {
        
        hash_ = getDefaultInstance().getHash();
        onChanged();
        return this;
      }
      /**
       * <code>string hash = 1;</code>
       */
      public Builder setHashBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        hash_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object ipAddress_ = "";
      /**
       * <code>string ipAddress = 2;</code>
       */
      public java.lang.String getIpAddress() {
        java.lang.Object ref = ipAddress_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          ipAddress_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string ipAddress = 2;</code>
       */
      public com.google.protobuf.ByteString
          getIpAddressBytes() {
        java.lang.Object ref = ipAddress_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          ipAddress_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string ipAddress = 2;</code>
       */
      public Builder setIpAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        ipAddress_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string ipAddress = 2;</code>
       */
      public Builder clearIpAddress() {
        
        ipAddress_ = getDefaultInstance().getIpAddress();
        onChanged();
        return this;
      }
      /**
       * <code>string ipAddress = 2;</code>
       */
      public Builder setIpAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        ipAddress_ = value;
        onChanged();
        return this;
      }

      private int port_ ;
      /**
       * <code>int32 port = 3;</code>
       */
      public int getPort() {
        return port_;
      }
      /**
       * <code>int32 port = 3;</code>
       */
      public Builder setPort(int value) {
        
        port_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 port = 3;</code>
       */
      public Builder clearPort() {
        
        port_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:io.hbt.bubblegum.core.kademlia.protobuf.KademliaNode)
    }

    // @@protoc_insertion_point(class_scope:io.hbt.bubblegum.core.kademlia.protobuf.KademliaNode)
    private static final io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode();
    }

    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<KademliaNode>
        PARSER = new com.google.protobuf.AbstractParser<KademliaNode>() {
      @java.lang.Override
      public KademliaNode parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new KademliaNode(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<KademliaNode> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<KademliaNode> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaNode.KademliaNode getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024BgKademliaNode.proto\022\'io.hbt.bubblegum" +
      ".core.kademlia.protobuf\"=\n\014KademliaNode\022" +
      "\014\n\004hash\030\001 \001(\t\022\021\n\tipAddress\030\002 \001(\t\022\014\n\004port" +
      "\030\003 \001(\005b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaNode_descriptor,
        new java.lang.String[] { "Hash", "IpAddress", "Port", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}