// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.CreatePlayerRequest}
 */
public final class CreatePlayerRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.CreatePlayerRequest)
    CreatePlayerRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreatePlayerRequest.newBuilder() to construct.
  private CreatePlayerRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreatePlayerRequest() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreatePlayerRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreatePlayerRequest(
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
            MPPlayerProto.Builder subBuilder = null;
            if (player_ != null) {
              subBuilder = player_.toBuilder();
            }
            player_ = input.readMessage(MPPlayerProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(player_);
              player_ = subBuilder.buildPartial();
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_CreatePlayerRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_CreatePlayerRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            CreatePlayerRequest.class, Builder.class);
  }

  public static final int PLAYER_FIELD_NUMBER = 1;
  private MPPlayerProto player_;
  /**
   * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
   * @return Whether the player field is set.
   */
  @Override
  public boolean hasPlayer() {
    return player_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
   * @return The player.
   */
  @Override
  public MPPlayerProto getPlayer() {
    return player_ == null ? MPPlayerProto.getDefaultInstance() : player_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
   */
  @Override
  public MPPlayerProtoOrBuilder getPlayerOrBuilder() {
    return getPlayer();
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
    if (player_ != null) {
      output.writeMessage(1, getPlayer());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (player_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPlayer());
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
    if (!(obj instanceof CreatePlayerRequest)) {
      return super.equals(obj);
    }
    CreatePlayerRequest other = (CreatePlayerRequest) obj;

    if (hasPlayer() != other.hasPlayer()) return false;
    if (hasPlayer()) {
      if (!getPlayer()
          .equals(other.getPlayer())) return false;
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
    if (hasPlayer()) {
      hash = (37 * hash) + PLAYER_FIELD_NUMBER;
      hash = (53 * hash) + getPlayer().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static CreatePlayerRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreatePlayerRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreatePlayerRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreatePlayerRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreatePlayerRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static CreatePlayerRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static CreatePlayerRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CreatePlayerRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static CreatePlayerRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static CreatePlayerRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static CreatePlayerRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static CreatePlayerRequest parseFrom(
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
  public static Builder newBuilder(CreatePlayerRequest prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.CreatePlayerRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.CreatePlayerRequest)
      CreatePlayerRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_CreatePlayerRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_CreatePlayerRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CreatePlayerRequest.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.CreatePlayerRequest.newBuilder()
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
      if (playerBuilder_ == null) {
        player_ = null;
      } else {
        player_ = null;
        playerBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_CreatePlayerRequest_descriptor;
    }

    @Override
    public CreatePlayerRequest getDefaultInstanceForType() {
      return CreatePlayerRequest.getDefaultInstance();
    }

    @Override
    public CreatePlayerRequest build() {
      CreatePlayerRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public CreatePlayerRequest buildPartial() {
      CreatePlayerRequest result = new CreatePlayerRequest(this);
      if (playerBuilder_ == null) {
        result.player_ = player_;
      } else {
        result.player_ = playerBuilder_.build();
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
      if (other instanceof CreatePlayerRequest) {
        return mergeFrom((CreatePlayerRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(CreatePlayerRequest other) {
      if (other == CreatePlayerRequest.getDefaultInstance()) return this;
      if (other.hasPlayer()) {
        mergePlayer(other.getPlayer());
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
      CreatePlayerRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (CreatePlayerRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private MPPlayerProto player_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MPPlayerProto, MPPlayerProto.Builder, MPPlayerProtoOrBuilder> playerBuilder_;
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     * @return Whether the player field is set.
     */
    public boolean hasPlayer() {
      return playerBuilder_ != null || player_ != null;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     * @return The player.
     */
    public MPPlayerProto getPlayer() {
      if (playerBuilder_ == null) {
        return player_ == null ? MPPlayerProto.getDefaultInstance() : player_;
      } else {
        return playerBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     */
    public Builder setPlayer(MPPlayerProto value) {
      if (playerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        player_ = value;
        onChanged();
      } else {
        playerBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     */
    public Builder setPlayer(
        MPPlayerProto.Builder builderForValue) {
      if (playerBuilder_ == null) {
        player_ = builderForValue.build();
        onChanged();
      } else {
        playerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     */
    public Builder mergePlayer(MPPlayerProto value) {
      if (playerBuilder_ == null) {
        if (player_ != null) {
          player_ =
            MPPlayerProto.newBuilder(player_).mergeFrom(value).buildPartial();
        } else {
          player_ = value;
        }
        onChanged();
      } else {
        playerBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     */
    public Builder clearPlayer() {
      if (playerBuilder_ == null) {
        player_ = null;
        onChanged();
      } else {
        player_ = null;
        playerBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     */
    public MPPlayerProto.Builder getPlayerBuilder() {
      
      onChanged();
      return getPlayerFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     */
    public MPPlayerProtoOrBuilder getPlayerOrBuilder() {
      if (playerBuilder_ != null) {
        return playerBuilder_.getMessageOrBuilder();
      } else {
        return player_ == null ?
            MPPlayerProto.getDefaultInstance() : player_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPlayerProto player = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MPPlayerProto, MPPlayerProto.Builder, MPPlayerProtoOrBuilder>
        getPlayerFieldBuilder() {
      if (playerBuilder_ == null) {
        playerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MPPlayerProto, MPPlayerProto.Builder, MPPlayerProtoOrBuilder>(
                getPlayer(),
                getParentForChildren(),
                isClean());
        player_ = null;
      }
      return playerBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.CreatePlayerRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.CreatePlayerRequest)
  private static final CreatePlayerRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new CreatePlayerRequest();
  }

  public static CreatePlayerRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreatePlayerRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreatePlayerRequest>() {
    @Override
    public CreatePlayerRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CreatePlayerRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreatePlayerRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<CreatePlayerRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public CreatePlayerRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

