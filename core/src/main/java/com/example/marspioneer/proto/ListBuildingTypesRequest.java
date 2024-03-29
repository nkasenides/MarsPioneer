// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.ListBuildingTypesRequest}
 */
public final class ListBuildingTypesRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.ListBuildingTypesRequest)
    ListBuildingTypesRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListBuildingTypesRequest.newBuilder() to construct.
  private ListBuildingTypesRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListBuildingTypesRequest() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new ListBuildingTypesRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ListBuildingTypesRequest(
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
            MPGameSessionProto.Builder subBuilder = null;
            if (gameSessionID_ != null) {
              subBuilder = gameSessionID_.toBuilder();
            }
            gameSessionID_ = input.readMessage(MPGameSessionProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(gameSessionID_);
              gameSessionID_ = subBuilder.buildPartial();
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_ListBuildingTypesRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_ListBuildingTypesRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ListBuildingTypesRequest.class, Builder.class);
  }

  public static final int GAMESESSIONID_FIELD_NUMBER = 1;
  private MPGameSessionProto gameSessionID_;
  /**
   * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
   * @return Whether the gameSessionID field is set.
   */
  @Override
  public boolean hasGameSessionID() {
    return gameSessionID_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
   * @return The gameSessionID.
   */
  @Override
  public MPGameSessionProto getGameSessionID() {
    return gameSessionID_ == null ? MPGameSessionProto.getDefaultInstance() : gameSessionID_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
   */
  @Override
  public MPGameSessionProtoOrBuilder getGameSessionIDOrBuilder() {
    return getGameSessionID();
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
    if (gameSessionID_ != null) {
      output.writeMessage(1, getGameSessionID());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (gameSessionID_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getGameSessionID());
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
    if (!(obj instanceof ListBuildingTypesRequest)) {
      return super.equals(obj);
    }
    ListBuildingTypesRequest other = (ListBuildingTypesRequest) obj;

    if (hasGameSessionID() != other.hasGameSessionID()) return false;
    if (hasGameSessionID()) {
      if (!getGameSessionID()
          .equals(other.getGameSessionID())) return false;
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
    if (hasGameSessionID()) {
      hash = (37 * hash) + GAMESESSIONID_FIELD_NUMBER;
      hash = (53 * hash) + getGameSessionID().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ListBuildingTypesRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ListBuildingTypesRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ListBuildingTypesRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ListBuildingTypesRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ListBuildingTypesRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ListBuildingTypesRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ListBuildingTypesRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ListBuildingTypesRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ListBuildingTypesRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ListBuildingTypesRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ListBuildingTypesRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ListBuildingTypesRequest parseFrom(
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
  public static Builder newBuilder(ListBuildingTypesRequest prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.ListBuildingTypesRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.ListBuildingTypesRequest)
      ListBuildingTypesRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_ListBuildingTypesRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_ListBuildingTypesRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ListBuildingTypesRequest.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.ListBuildingTypesRequest.newBuilder()
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
      if (gameSessionIDBuilder_ == null) {
        gameSessionID_ = null;
      } else {
        gameSessionID_ = null;
        gameSessionIDBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_ListBuildingTypesRequest_descriptor;
    }

    @Override
    public ListBuildingTypesRequest getDefaultInstanceForType() {
      return ListBuildingTypesRequest.getDefaultInstance();
    }

    @Override
    public ListBuildingTypesRequest build() {
      ListBuildingTypesRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public ListBuildingTypesRequest buildPartial() {
      ListBuildingTypesRequest result = new ListBuildingTypesRequest(this);
      if (gameSessionIDBuilder_ == null) {
        result.gameSessionID_ = gameSessionID_;
      } else {
        result.gameSessionID_ = gameSessionIDBuilder_.build();
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
      if (other instanceof ListBuildingTypesRequest) {
        return mergeFrom((ListBuildingTypesRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ListBuildingTypesRequest other) {
      if (other == ListBuildingTypesRequest.getDefaultInstance()) return this;
      if (other.hasGameSessionID()) {
        mergeGameSessionID(other.getGameSessionID());
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
      ListBuildingTypesRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ListBuildingTypesRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private MPGameSessionProto gameSessionID_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MPGameSessionProto, MPGameSessionProto.Builder, MPGameSessionProtoOrBuilder> gameSessionIDBuilder_;
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     * @return Whether the gameSessionID field is set.
     */
    public boolean hasGameSessionID() {
      return gameSessionIDBuilder_ != null || gameSessionID_ != null;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     * @return The gameSessionID.
     */
    public MPGameSessionProto getGameSessionID() {
      if (gameSessionIDBuilder_ == null) {
        return gameSessionID_ == null ? MPGameSessionProto.getDefaultInstance() : gameSessionID_;
      } else {
        return gameSessionIDBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     */
    public Builder setGameSessionID(MPGameSessionProto value) {
      if (gameSessionIDBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        gameSessionID_ = value;
        onChanged();
      } else {
        gameSessionIDBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     */
    public Builder setGameSessionID(
        MPGameSessionProto.Builder builderForValue) {
      if (gameSessionIDBuilder_ == null) {
        gameSessionID_ = builderForValue.build();
        onChanged();
      } else {
        gameSessionIDBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     */
    public Builder mergeGameSessionID(MPGameSessionProto value) {
      if (gameSessionIDBuilder_ == null) {
        if (gameSessionID_ != null) {
          gameSessionID_ =
            MPGameSessionProto.newBuilder(gameSessionID_).mergeFrom(value).buildPartial();
        } else {
          gameSessionID_ = value;
        }
        onChanged();
      } else {
        gameSessionIDBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     */
    public Builder clearGameSessionID() {
      if (gameSessionIDBuilder_ == null) {
        gameSessionID_ = null;
        onChanged();
      } else {
        gameSessionID_ = null;
        gameSessionIDBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     */
    public MPGameSessionProto.Builder getGameSessionIDBuilder() {
      
      onChanged();
      return getGameSessionIDFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     */
    public MPGameSessionProtoOrBuilder getGameSessionIDOrBuilder() {
      if (gameSessionIDBuilder_ != null) {
        return gameSessionIDBuilder_.getMessageOrBuilder();
      } else {
        return gameSessionID_ == null ?
            MPGameSessionProto.getDefaultInstance() : gameSessionID_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSessionID = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MPGameSessionProto, MPGameSessionProto.Builder, MPGameSessionProtoOrBuilder>
        getGameSessionIDFieldBuilder() {
      if (gameSessionIDBuilder_ == null) {
        gameSessionIDBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MPGameSessionProto, MPGameSessionProto.Builder, MPGameSessionProtoOrBuilder>(
                getGameSessionID(),
                getParentForChildren(),
                isClean());
        gameSessionID_ = null;
      }
      return gameSessionIDBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.ListBuildingTypesRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.ListBuildingTypesRequest)
  private static final ListBuildingTypesRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ListBuildingTypesRequest();
  }

  public static ListBuildingTypesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListBuildingTypesRequest>
      PARSER = new com.google.protobuf.AbstractParser<ListBuildingTypesRequest>() {
    @Override
    public ListBuildingTypesRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ListBuildingTypesRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListBuildingTypesRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<ListBuildingTypesRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public ListBuildingTypesRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

