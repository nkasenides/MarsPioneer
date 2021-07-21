// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.UpdateWorldRequest}
 */
public final class UpdateWorldRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.UpdateWorldRequest)
    UpdateWorldRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateWorldRequest.newBuilder() to construct.
  private UpdateWorldRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateWorldRequest() {
    gameSessionID_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateWorldRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateWorldRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
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
            String s = input.readStringRequireUtf8();

            gameSessionID_ = s;
            break;
          }
          case 18: {
            MPWorldProto.Builder subBuilder = null;
            if (world_ != null) {
              subBuilder = world_.toBuilder();
            }
            world_ = input.readMessage(MPWorldProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(world_);
              world_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateWorldRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateWorldRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            UpdateWorldRequest.class, Builder.class);
  }

  public static final int GAMESESSIONID_FIELD_NUMBER = 1;
  private volatile Object gameSessionID_;
  /**
   * <code>string gameSessionID = 1;</code>
   * @return The gameSessionID.
   */
  @Override
  public String getGameSessionID() {
    Object ref = gameSessionID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      gameSessionID_ = s;
      return s;
    }
  }
  /**
   * <code>string gameSessionID = 1;</code>
   * @return The bytes for gameSessionID.
   */
  @Override
  public com.google.protobuf.ByteString
      getGameSessionIDBytes() {
    Object ref = gameSessionID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      gameSessionID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int WORLD_FIELD_NUMBER = 2;
  private MPWorldProto world_;
  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
   * @return Whether the world field is set.
   */
  @Override
  public boolean hasWorld() {
    return world_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
   * @return The world.
   */
  @Override
  public MPWorldProto getWorld() {
    return world_ == null ? MPWorldProto.getDefaultInstance() : world_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
   */
  @Override
  public MPWorldProtoOrBuilder getWorldOrBuilder() {
    return getWorld();
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getGameSessionIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, gameSessionID_);
    }
    if (world_ != null) {
      output.writeMessage(2, getWorld());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getGameSessionIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, gameSessionID_);
    }
    if (world_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getWorld());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof UpdateWorldRequest)) {
      return super.equals(obj);
    }
    UpdateWorldRequest other = (UpdateWorldRequest) obj;

    if (!getGameSessionID()
        .equals(other.getGameSessionID())) return false;
    if (hasWorld() != other.hasWorld()) return false;
    if (hasWorld()) {
      if (!getWorld()
          .equals(other.getWorld())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + GAMESESSIONID_FIELD_NUMBER;
    hash = (53 * hash) + getGameSessionID().hashCode();
    if (hasWorld()) {
      hash = (37 * hash) + WORLD_FIELD_NUMBER;
      hash = (53 * hash) + getWorld().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static UpdateWorldRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateWorldRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateWorldRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateWorldRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateWorldRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateWorldRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateWorldRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UpdateWorldRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static UpdateWorldRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static UpdateWorldRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static UpdateWorldRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UpdateWorldRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(UpdateWorldRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.example.marspioneer.proto.UpdateWorldRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.UpdateWorldRequest)
      UpdateWorldRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateWorldRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateWorldRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              UpdateWorldRequest.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.UpdateWorldRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      gameSessionID_ = "";

      if (worldBuilder_ == null) {
        world_ = null;
      } else {
        world_ = null;
        worldBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateWorldRequest_descriptor;
    }

    @Override
    public UpdateWorldRequest getDefaultInstanceForType() {
      return UpdateWorldRequest.getDefaultInstance();
    }

    @Override
    public UpdateWorldRequest build() {
      UpdateWorldRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public UpdateWorldRequest buildPartial() {
      UpdateWorldRequest result = new UpdateWorldRequest(this);
      result.gameSessionID_ = gameSessionID_;
      if (worldBuilder_ == null) {
        result.world_ = world_;
      } else {
        result.world_ = worldBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof UpdateWorldRequest) {
        return mergeFrom((UpdateWorldRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(UpdateWorldRequest other) {
      if (other == UpdateWorldRequest.getDefaultInstance()) return this;
      if (!other.getGameSessionID().isEmpty()) {
        gameSessionID_ = other.gameSessionID_;
        onChanged();
      }
      if (other.hasWorld()) {
        mergeWorld(other.getWorld());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      UpdateWorldRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (UpdateWorldRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object gameSessionID_ = "";
    /**
     * <code>string gameSessionID = 1;</code>
     * @return The gameSessionID.
     */
    public String getGameSessionID() {
      Object ref = gameSessionID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        gameSessionID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string gameSessionID = 1;</code>
     * @return The bytes for gameSessionID.
     */
    public com.google.protobuf.ByteString
        getGameSessionIDBytes() {
      Object ref = gameSessionID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        gameSessionID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string gameSessionID = 1;</code>
     * @param value The gameSessionID to set.
     * @return This builder for chaining.
     */
    public Builder setGameSessionID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      gameSessionID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string gameSessionID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGameSessionID() {
      
      gameSessionID_ = getDefaultInstance().getGameSessionID();
      onChanged();
      return this;
    }
    /**
     * <code>string gameSessionID = 1;</code>
     * @param value The bytes for gameSessionID to set.
     * @return This builder for chaining.
     */
    public Builder setGameSessionIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      gameSessionID_ = value;
      onChanged();
      return this;
    }

    private MPWorldProto world_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MPWorldProto, MPWorldProto.Builder, MPWorldProtoOrBuilder> worldBuilder_;
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     * @return Whether the world field is set.
     */
    public boolean hasWorld() {
      return worldBuilder_ != null || world_ != null;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     * @return The world.
     */
    public MPWorldProto getWorld() {
      if (worldBuilder_ == null) {
        return world_ == null ? MPWorldProto.getDefaultInstance() : world_;
      } else {
        return worldBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     */
    public Builder setWorld(MPWorldProto value) {
      if (worldBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        world_ = value;
        onChanged();
      } else {
        worldBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     */
    public Builder setWorld(
        MPWorldProto.Builder builderForValue) {
      if (worldBuilder_ == null) {
        world_ = builderForValue.build();
        onChanged();
      } else {
        worldBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     */
    public Builder mergeWorld(MPWorldProto value) {
      if (worldBuilder_ == null) {
        if (world_ != null) {
          world_ =
            MPWorldProto.newBuilder(world_).mergeFrom(value).buildPartial();
        } else {
          world_ = value;
        }
        onChanged();
      } else {
        worldBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     */
    public Builder clearWorld() {
      if (worldBuilder_ == null) {
        world_ = null;
        onChanged();
      } else {
        world_ = null;
        worldBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     */
    public MPWorldProto.Builder getWorldBuilder() {
      
      onChanged();
      return getWorldFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     */
    public MPWorldProtoOrBuilder getWorldOrBuilder() {
      if (worldBuilder_ != null) {
        return worldBuilder_.getMessageOrBuilder();
      } else {
        return world_ == null ?
            MPWorldProto.getDefaultInstance() : world_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MPWorldProto, MPWorldProto.Builder, MPWorldProtoOrBuilder>
        getWorldFieldBuilder() {
      if (worldBuilder_ == null) {
        worldBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MPWorldProto, MPWorldProto.Builder, MPWorldProtoOrBuilder>(
                getWorld(),
                getParentForChildren(),
                isClean());
        world_ = null;
      }
      return worldBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.UpdateWorldRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.UpdateWorldRequest)
  private static final UpdateWorldRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new UpdateWorldRequest();
  }

  public static UpdateWorldRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateWorldRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateWorldRequest>() {
    @Override
    public UpdateWorldRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateWorldRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateWorldRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<UpdateWorldRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public UpdateWorldRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

