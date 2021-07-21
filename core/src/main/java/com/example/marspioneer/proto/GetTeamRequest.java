// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.GetTeamRequest}
 */
public final class GetTeamRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.GetTeamRequest)
    GetTeamRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetTeamRequest.newBuilder() to construct.
  private GetTeamRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetTeamRequest() {
    gameSessionID_ = "";
    teamID_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetTeamRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetTeamRequest(
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
            String s = input.readStringRequireUtf8();

            teamID_ = s;
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_GetTeamRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_GetTeamRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetTeamRequest.class, Builder.class);
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

  public static final int TEAMID_FIELD_NUMBER = 2;
  private volatile Object teamID_;
  /**
   * <code>string teamID = 2;</code>
   * @return The teamID.
   */
  @Override
  public String getTeamID() {
    Object ref = teamID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      teamID_ = s;
      return s;
    }
  }
  /**
   * <code>string teamID = 2;</code>
   * @return The bytes for teamID.
   */
  @Override
  public com.google.protobuf.ByteString
      getTeamIDBytes() {
    Object ref = teamID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      teamID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getTeamIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, teamID_);
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
    if (!getTeamIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, teamID_);
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
    if (!(obj instanceof GetTeamRequest)) {
      return super.equals(obj);
    }
    GetTeamRequest other = (GetTeamRequest) obj;

    if (!getGameSessionID()
        .equals(other.getGameSessionID())) return false;
    if (!getTeamID()
        .equals(other.getTeamID())) return false;
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
    hash = (37 * hash) + TEAMID_FIELD_NUMBER;
    hash = (53 * hash) + getTeamID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GetTeamRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetTeamRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetTeamRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetTeamRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetTeamRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetTeamRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetTeamRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetTeamRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetTeamRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GetTeamRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetTeamRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetTeamRequest parseFrom(
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
  public static Builder newBuilder(GetTeamRequest prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.GetTeamRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.GetTeamRequest)
      GetTeamRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_GetTeamRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_GetTeamRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetTeamRequest.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.GetTeamRequest.newBuilder()
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

      teamID_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_GetTeamRequest_descriptor;
    }

    @Override
    public GetTeamRequest getDefaultInstanceForType() {
      return GetTeamRequest.getDefaultInstance();
    }

    @Override
    public GetTeamRequest build() {
      GetTeamRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GetTeamRequest buildPartial() {
      GetTeamRequest result = new GetTeamRequest(this);
      result.gameSessionID_ = gameSessionID_;
      result.teamID_ = teamID_;
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
      if (other instanceof GetTeamRequest) {
        return mergeFrom((GetTeamRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetTeamRequest other) {
      if (other == GetTeamRequest.getDefaultInstance()) return this;
      if (!other.getGameSessionID().isEmpty()) {
        gameSessionID_ = other.gameSessionID_;
        onChanged();
      }
      if (!other.getTeamID().isEmpty()) {
        teamID_ = other.teamID_;
        onChanged();
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
      GetTeamRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GetTeamRequest) e.getUnfinishedMessage();
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

    private Object teamID_ = "";
    /**
     * <code>string teamID = 2;</code>
     * @return The teamID.
     */
    public String getTeamID() {
      Object ref = teamID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        teamID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string teamID = 2;</code>
     * @return The bytes for teamID.
     */
    public com.google.protobuf.ByteString
        getTeamIDBytes() {
      Object ref = teamID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        teamID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string teamID = 2;</code>
     * @param value The teamID to set.
     * @return This builder for chaining.
     */
    public Builder setTeamID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      teamID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string teamID = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTeamID() {
      
      teamID_ = getDefaultInstance().getTeamID();
      onChanged();
      return this;
    }
    /**
     * <code>string teamID = 2;</code>
     * @param value The bytes for teamID to set.
     * @return This builder for chaining.
     */
    public Builder setTeamIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      teamID_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.GetTeamRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.GetTeamRequest)
  private static final GetTeamRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetTeamRequest();
  }

  public static GetTeamRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetTeamRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetTeamRequest>() {
    @Override
    public GetTeamRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetTeamRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetTeamRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetTeamRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public GetTeamRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

