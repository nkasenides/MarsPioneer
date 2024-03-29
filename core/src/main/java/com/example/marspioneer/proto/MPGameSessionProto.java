// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.MPGameSessionProto}
 */
public final class MPGameSessionProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<com.example.marspioneer.model.MPGameSession> , com.nkasenides.athlos.model.IGameSession, 
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.MPGameSessionProto)
    MPGameSessionProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MPGameSessionProto.newBuilder() to construct.
  private MPGameSessionProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MPGameSessionProto() {
    ipAddress_ = "";
    id_ = "";
    playerID_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new MPGameSessionProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MPGameSessionProto(
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

            ipAddress_ = s;
            break;
          }
          case 16: {

            expiresOn_ = input.readUInt64();
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 32: {

            createdOn_ = input.readUInt64();
            break;
          }
          case 42: {
            String s = input.readStringRequireUtf8();

            playerID_ = s;
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPGameSessionProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPGameSessionProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            MPGameSessionProto.class, Builder.class);
  }

  public static final int IPADDRESS_FIELD_NUMBER = 1;
  private volatile Object ipAddress_;
  /**
   * <code>string ipAddress = 1;</code>
   * @return The ipAddress.
   */
  @Override
  public String getIpAddress() {
    Object ref = ipAddress_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      ipAddress_ = s;
      return s;
    }
  }
  /**
   * <code>string ipAddress = 1;</code>
   * @return The bytes for ipAddress.
   */
  @Override
  public com.google.protobuf.ByteString
      getIpAddressBytes() {
    Object ref = ipAddress_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      ipAddress_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EXPIRESON_FIELD_NUMBER = 2;
  private long expiresOn_;
  /**
   * <code>uint64 expiresOn = 2;</code>
   * @return The expiresOn.
   */
  @Override
  public long getExpiresOn() {
    return expiresOn_;
  }

  public static final int ID_FIELD_NUMBER = 3;
  private volatile Object id_;
  /**
   * <code>string id = 3;</code>
   * @return The id.
   */
  @Override
  public String getId() {
    Object ref = id_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 3;</code>
   * @return The bytes for id.
   */
  @Override
  public com.google.protobuf.ByteString
      getIdBytes() {
    Object ref = id_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CREATEDON_FIELD_NUMBER = 4;
  private long createdOn_;
  /**
   * <code>uint64 createdOn = 4;</code>
   * @return The createdOn.
   */
  @Override
  public long getCreatedOn() {
    return createdOn_;
  }

  public static final int PLAYERID_FIELD_NUMBER = 5;
  private volatile Object playerID_;
  /**
   * <code>string playerID = 5;</code>
   * @return The playerID.
   */
  @Override
  public String getPlayerID() {
    Object ref = playerID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      playerID_ = s;
      return s;
    }
  }
  /**
   * <code>string playerID = 5;</code>
   * @return The bytes for playerID.
   */
  @Override
  public com.google.protobuf.ByteString
      getPlayerIDBytes() {
    Object ref = playerID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      playerID_ = b;
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
    if (!getIpAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, ipAddress_);
    }
    if (expiresOn_ != 0L) {
      output.writeUInt64(2, expiresOn_);
    }
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, id_);
    }
    if (createdOn_ != 0L) {
      output.writeUInt64(4, createdOn_);
    }
    if (!getPlayerIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, playerID_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIpAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, ipAddress_);
    }
    if (expiresOn_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, expiresOn_);
    }
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, id_);
    }
    if (createdOn_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(4, createdOn_);
    }
    if (!getPlayerIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, playerID_);
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
    if (!(obj instanceof MPGameSessionProto)) {
      return super.equals(obj);
    }
    MPGameSessionProto other = (MPGameSessionProto) obj;

    if (!getIpAddress()
        .equals(other.getIpAddress())) return false;
    if (getExpiresOn()
        != other.getExpiresOn()) return false;
    if (!getId()
        .equals(other.getId())) return false;
    if (getCreatedOn()
        != other.getCreatedOn()) return false;
    if (!getPlayerID()
        .equals(other.getPlayerID())) return false;
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
    hash = (37 * hash) + IPADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getIpAddress().hashCode();
    hash = (37 * hash) + EXPIRESON_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getExpiresOn());
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + CREATEDON_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCreatedOn());
    hash = (37 * hash) + PLAYERID_FIELD_NUMBER;
    hash = (53 * hash) + getPlayerID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static MPGameSessionProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPGameSessionProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPGameSessionProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPGameSessionProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPGameSessionProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPGameSessionProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPGameSessionProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPGameSessionProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPGameSessionProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static MPGameSessionProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPGameSessionProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPGameSessionProto parseFrom(
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
  public static Builder newBuilder(MPGameSessionProto prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.MPGameSessionProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements com.nkasenides.athlos.model.IGameSession, com.nkasenides.athlos.proto.Modelable<com.example.marspioneer.model.MPGameSession>, 
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.MPGameSessionProto)
      MPGameSessionProtoOrBuilder {    @Override
    public com.example.marspioneer.model.MPGameSession toObject() {    
        com.example.marspioneer.model.MPGameSession item = new com.example.marspioneer.model.MPGameSession();        
        item.setIpAddress(getIpAddress());        
        item.setExpiresOn(getExpiresOn());        
        item.setId(getId());        
        item.setCreatedOn(getCreatedOn());        
        item.setPlayerID(getPlayerID());        
        return item;        
    }    
    

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPGameSessionProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPGameSessionProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MPGameSessionProto.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.MPGameSessionProto.newBuilder()
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
      ipAddress_ = "";

      expiresOn_ = 0L;

      id_ = "";

      createdOn_ = 0L;

      playerID_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPGameSessionProto_descriptor;
    }

    @Override
    public MPGameSessionProto getDefaultInstanceForType() {
      return MPGameSessionProto.getDefaultInstance();
    }

    @Override
    public MPGameSessionProto build() {
      MPGameSessionProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public MPGameSessionProto buildPartial() {
      MPGameSessionProto result = new MPGameSessionProto(this);
      result.ipAddress_ = ipAddress_;
      result.expiresOn_ = expiresOn_;
      result.id_ = id_;
      result.createdOn_ = createdOn_;
      result.playerID_ = playerID_;
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
      if (other instanceof MPGameSessionProto) {
        return mergeFrom((MPGameSessionProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(MPGameSessionProto other) {
      if (other == MPGameSessionProto.getDefaultInstance()) return this;
      if (!other.getIpAddress().isEmpty()) {
        ipAddress_ = other.ipAddress_;
        onChanged();
      }
      if (other.getExpiresOn() != 0L) {
        setExpiresOn(other.getExpiresOn());
      }
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (other.getCreatedOn() != 0L) {
        setCreatedOn(other.getCreatedOn());
      }
      if (!other.getPlayerID().isEmpty()) {
        playerID_ = other.playerID_;
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
      MPGameSessionProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (MPGameSessionProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object ipAddress_ = "";
    /**
     * <code>string ipAddress = 1;</code>
     * @return The ipAddress.
     */
    public String getIpAddress() {
      Object ref = ipAddress_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        ipAddress_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string ipAddress = 1;</code>
     * @return The bytes for ipAddress.
     */
    public com.google.protobuf.ByteString
        getIpAddressBytes() {
      Object ref = ipAddress_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        ipAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string ipAddress = 1;</code>
     * @param value The ipAddress to set.
     * @return This builder for chaining.
     */
    public Builder setIpAddress(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ipAddress_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string ipAddress = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIpAddress() {
      
      ipAddress_ = getDefaultInstance().getIpAddress();
      onChanged();
      return this;
    }
    /**
     * <code>string ipAddress = 1;</code>
     * @param value The bytes for ipAddress to set.
     * @return This builder for chaining.
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

    private long expiresOn_ ;
    /**
     * <code>uint64 expiresOn = 2;</code>
     * @return The expiresOn.
     */
    @Override
    public long getExpiresOn() {
      return expiresOn_;
    }
    /**
     * <code>uint64 expiresOn = 2;</code>
     * @param value The expiresOn to set.
     * @return This builder for chaining.
     */
    public Builder setExpiresOn(long value) {
      
      expiresOn_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 expiresOn = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearExpiresOn() {
      
      expiresOn_ = 0L;
      onChanged();
      return this;
    }

    private Object id_ = "";
    /**
     * <code>string id = 3;</code>
     * @return The id.
     */
    public String getId() {
      Object ref = id_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string id = 3;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 3;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 3;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private long createdOn_ ;
    /**
     * <code>uint64 createdOn = 4;</code>
     * @return The createdOn.
     */
    @Override
    public long getCreatedOn() {
      return createdOn_;
    }
    /**
     * <code>uint64 createdOn = 4;</code>
     * @param value The createdOn to set.
     * @return This builder for chaining.
     */
    public Builder setCreatedOn(long value) {
      
      createdOn_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 createdOn = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCreatedOn() {
      
      createdOn_ = 0L;
      onChanged();
      return this;
    }

    private Object playerID_ = "";
    /**
     * <code>string playerID = 5;</code>
     * @return The playerID.
     */
    public String getPlayerID() {
      Object ref = playerID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        playerID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string playerID = 5;</code>
     * @return The bytes for playerID.
     */
    public com.google.protobuf.ByteString
        getPlayerIDBytes() {
      Object ref = playerID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        playerID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string playerID = 5;</code>
     * @param value The playerID to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      playerID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string playerID = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlayerID() {
      
      playerID_ = getDefaultInstance().getPlayerID();
      onChanged();
      return this;
    }
    /**
     * <code>string playerID = 5;</code>
     * @param value The bytes for playerID to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      playerID_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.MPGameSessionProto)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.MPGameSessionProto)
  private static final MPGameSessionProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new MPGameSessionProto();
  }

  public static MPGameSessionProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MPGameSessionProto>
      PARSER = new com.google.protobuf.AbstractParser<MPGameSessionProto>() {
    @Override
    public MPGameSessionProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MPGameSessionProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MPGameSessionProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<MPGameSessionProto> getParserForType() {
    return PARSER;
  }

  @Override
  public MPGameSessionProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public com.example.marspioneer.model.MPGameSession toObject() {    
        com.example.marspioneer.model.MPGameSession item = new com.example.marspioneer.model.MPGameSession();        
        item.setIpAddress(getIpAddress());        
        item.setExpiresOn(getExpiresOn());        
        item.setId(getId());        
        item.setCreatedOn(getCreatedOn());        
        item.setPlayerID(getPlayerID());        
        return item;        
    }    
    
}

