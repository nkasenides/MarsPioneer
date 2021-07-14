// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.DeAuthenticateRequest}
 */
public final class DeAuthenticateRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.DeAuthenticateRequest)
    DeAuthenticateRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeAuthenticateRequest.newBuilder() to construct.
  private DeAuthenticateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeAuthenticateRequest() {
    gameSessionID_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DeAuthenticateRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DeAuthenticateRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
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
            java.lang.String s = input.readStringRequireUtf8();

            gameSessionID_ = s;
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
    return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_DeAuthenticateRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_DeAuthenticateRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.marspioneer.proto.DeAuthenticateRequest.class, com.example.marspioneer.proto.DeAuthenticateRequest.Builder.class);
  }

  public static final int GAMESESSIONID_FIELD_NUMBER = 1;
  private volatile java.lang.Object gameSessionID_;
  /**
   * <code>string gameSessionID = 1;</code>
   * @return The gameSessionID.
   */
  @java.lang.Override
  public java.lang.String getGameSessionID() {
    java.lang.Object ref = gameSessionID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gameSessionID_ = s;
      return s;
    }
  }
  /**
   * <code>string gameSessionID = 1;</code>
   * @return The bytes for gameSessionID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getGameSessionIDBytes() {
    java.lang.Object ref = gameSessionID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gameSessionID_ = b;
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
    if (!getGameSessionIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, gameSessionID_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getGameSessionIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, gameSessionID_);
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
    if (!(obj instanceof com.example.marspioneer.proto.DeAuthenticateRequest)) {
      return super.equals(obj);
    }
    com.example.marspioneer.proto.DeAuthenticateRequest other = (com.example.marspioneer.proto.DeAuthenticateRequest) obj;

    if (!getGameSessionID()
        .equals(other.getGameSessionID())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + GAMESESSIONID_FIELD_NUMBER;
    hash = (53 * hash) + getGameSessionID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.DeAuthenticateRequest parseFrom(
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
  public static Builder newBuilder(com.example.marspioneer.proto.DeAuthenticateRequest prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.DeAuthenticateRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.DeAuthenticateRequest)
      com.example.marspioneer.proto.DeAuthenticateRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_DeAuthenticateRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_DeAuthenticateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.marspioneer.proto.DeAuthenticateRequest.class, com.example.marspioneer.proto.DeAuthenticateRequest.Builder.class);
    }

    // Construct using com.example.marspioneer.proto.DeAuthenticateRequest.newBuilder()
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
      gameSessionID_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_DeAuthenticateRequest_descriptor;
    }

    @java.lang.Override
    public com.example.marspioneer.proto.DeAuthenticateRequest getDefaultInstanceForType() {
      return com.example.marspioneer.proto.DeAuthenticateRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.marspioneer.proto.DeAuthenticateRequest build() {
      com.example.marspioneer.proto.DeAuthenticateRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.marspioneer.proto.DeAuthenticateRequest buildPartial() {
      com.example.marspioneer.proto.DeAuthenticateRequest result = new com.example.marspioneer.proto.DeAuthenticateRequest(this);
      result.gameSessionID_ = gameSessionID_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.marspioneer.proto.DeAuthenticateRequest) {
        return mergeFrom((com.example.marspioneer.proto.DeAuthenticateRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.marspioneer.proto.DeAuthenticateRequest other) {
      if (other == com.example.marspioneer.proto.DeAuthenticateRequest.getDefaultInstance()) return this;
      if (!other.getGameSessionID().isEmpty()) {
        gameSessionID_ = other.gameSessionID_;
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
      com.example.marspioneer.proto.DeAuthenticateRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.marspioneer.proto.DeAuthenticateRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object gameSessionID_ = "";
    /**
     * <code>string gameSessionID = 1;</code>
     * @return The gameSessionID.
     */
    public java.lang.String getGameSessionID() {
      java.lang.Object ref = gameSessionID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gameSessionID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string gameSessionID = 1;</code>
     * @return The bytes for gameSessionID.
     */
    public com.google.protobuf.ByteString
        getGameSessionIDBytes() {
      java.lang.Object ref = gameSessionID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
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
        java.lang.String value) {
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
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.DeAuthenticateRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.DeAuthenticateRequest)
  private static final com.example.marspioneer.proto.DeAuthenticateRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.marspioneer.proto.DeAuthenticateRequest();
  }

  public static com.example.marspioneer.proto.DeAuthenticateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeAuthenticateRequest>
      PARSER = new com.google.protobuf.AbstractParser<DeAuthenticateRequest>() {
    @java.lang.Override
    public DeAuthenticateRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DeAuthenticateRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeAuthenticateRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeAuthenticateRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.marspioneer.proto.DeAuthenticateRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

