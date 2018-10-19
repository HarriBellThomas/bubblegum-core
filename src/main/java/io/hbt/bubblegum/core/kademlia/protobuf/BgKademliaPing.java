// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BgKademliaPing.proto

package io.hbt.bubblegum.core.kademlia.protobuf;

public final class BgKademliaPing {
  private BgKademliaPing() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface KademliaPingOrBuilder extends
      // @@protoc_insertion_point(interface_extends:io.hbt.bubblegum.core.kademlia.protobuf.KademliaPing)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * Deliberately blank
     * </pre>
     *
     * <code>bool reply = 1;</code>
     */
    boolean getReply();

    /**
     * <code>string networkID = 2;</code>
     */
    java.lang.String getNetworkID();
    /**
     * <code>string networkID = 2;</code>
     */
    com.google.protobuf.ByteString
        getNetworkIDBytes();
  }
  /**
   * Protobuf type {@code io.hbt.bubblegum.core.kademlia.protobuf.KademliaPing}
   */
  public  static final class KademliaPing extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:io.hbt.bubblegum.core.kademlia.protobuf.KademliaPing)
      KademliaPingOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use KademliaPing.newBuilder() to construct.
    private KademliaPing(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private KademliaPing() {
      reply_ = false;
      networkID_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private KademliaPing(
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
            case 8: {

              reply_ = input.readBool();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              networkID_ = s;
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
      return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing.class, io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing.Builder.class);
    }

    public static final int REPLY_FIELD_NUMBER = 1;
    private boolean reply_;
    /**
     * <pre>
     * Deliberately blank
     * </pre>
     *
     * <code>bool reply = 1;</code>
     */
    public boolean getReply() {
      return reply_;
    }

    public static final int NETWORKID_FIELD_NUMBER = 2;
    private volatile java.lang.Object networkID_;
    /**
     * <code>string networkID = 2;</code>
     */
    public java.lang.String getNetworkID() {
      java.lang.Object ref = networkID_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        networkID_ = s;
        return s;
      }
    }
    /**
     * <code>string networkID = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNetworkIDBytes() {
      java.lang.Object ref = networkID_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        networkID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (reply_ != false) {
        output.writeBool(1, reply_);
      }
      if (!getNetworkIDBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, networkID_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (reply_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(1, reply_);
      }
      if (!getNetworkIDBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, networkID_);
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
      if (!(obj instanceof io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing)) {
        return super.equals(obj);
      }
      io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing other = (io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing) obj;

      boolean result = true;
      result = result && (getReply()
          == other.getReply());
      result = result && getNetworkID()
          .equals(other.getNetworkID());
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
      hash = (37 * hash) + REPLY_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getReply());
      hash = (37 * hash) + NETWORKID_FIELD_NUMBER;
      hash = (53 * hash) + getNetworkID().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parseFrom(
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
    public static Builder newBuilder(io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing prototype) {
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
     * Protobuf type {@code io.hbt.bubblegum.core.kademlia.protobuf.KademliaPing}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:io.hbt.bubblegum.core.kademlia.protobuf.KademliaPing)
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing.class, io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing.Builder.class);
      }

      // Construct using io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing.newBuilder()
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
        reply_ = false;

        networkID_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_descriptor;
      }

      @java.lang.Override
      public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing getDefaultInstanceForType() {
        return io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing.getDefaultInstance();
      }

      @java.lang.Override
      public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing build() {
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing buildPartial() {
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing result = new io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing(this);
        result.reply_ = reply_;
        result.networkID_ = networkID_;
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
        if (other instanceof io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing) {
          return mergeFrom((io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing other) {
        if (other == io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing.getDefaultInstance()) return this;
        if (other.getReply() != false) {
          setReply(other.getReply());
        }
        if (!other.getNetworkID().isEmpty()) {
          networkID_ = other.networkID_;
          onChanged();
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
        io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private boolean reply_ ;
      /**
       * <pre>
       * Deliberately blank
       * </pre>
       *
       * <code>bool reply = 1;</code>
       */
      public boolean getReply() {
        return reply_;
      }
      /**
       * <pre>
       * Deliberately blank
       * </pre>
       *
       * <code>bool reply = 1;</code>
       */
      public Builder setReply(boolean value) {
        
        reply_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Deliberately blank
       * </pre>
       *
       * <code>bool reply = 1;</code>
       */
      public Builder clearReply() {
        
        reply_ = false;
        onChanged();
        return this;
      }

      private java.lang.Object networkID_ = "";
      /**
       * <code>string networkID = 2;</code>
       */
      public java.lang.String getNetworkID() {
        java.lang.Object ref = networkID_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          networkID_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string networkID = 2;</code>
       */
      public com.google.protobuf.ByteString
          getNetworkIDBytes() {
        java.lang.Object ref = networkID_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          networkID_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string networkID = 2;</code>
       */
      public Builder setNetworkID(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        networkID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string networkID = 2;</code>
       */
      public Builder clearNetworkID() {
        
        networkID_ = getDefaultInstance().getNetworkID();
        onChanged();
        return this;
      }
      /**
       * <code>string networkID = 2;</code>
       */
      public Builder setNetworkIDBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        networkID_ = value;
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


      // @@protoc_insertion_point(builder_scope:io.hbt.bubblegum.core.kademlia.protobuf.KademliaPing)
    }

    // @@protoc_insertion_point(class_scope:io.hbt.bubblegum.core.kademlia.protobuf.KademliaPing)
    private static final io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing();
    }

    public static io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<KademliaPing>
        PARSER = new com.google.protobuf.AbstractParser<KademliaPing>() {
      @java.lang.Override
      public KademliaPing parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new KademliaPing(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<KademliaPing> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<KademliaPing> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public io.hbt.bubblegum.core.kademlia.protobuf.BgKademliaPing.KademliaPing getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024BgKademliaPing.proto\022\'io.hbt.bubblegum" +
      ".core.kademlia.protobuf\"0\n\014KademliaPing\022" +
      "\r\n\005reply\030\001 \001(\010\022\021\n\tnetworkID\030\002 \001(\tb\006proto" +
      "3"
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
    internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_hbt_bubblegum_core_kademlia_protobuf_KademliaPing_descriptor,
        new java.lang.String[] { "Reply", "NetworkID", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
