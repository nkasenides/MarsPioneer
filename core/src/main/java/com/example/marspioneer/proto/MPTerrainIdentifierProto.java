// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.MPTerrainIdentifierProto}
 */
public final class MPTerrainIdentifierProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.MPTerrainIdentifierProto)
    MPTerrainIdentifierProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MPTerrainIdentifierProto.newBuilder() to construct.
  private MPTerrainIdentifierProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MPTerrainIdentifierProto() {
    id_ = "";
    chunkID_ = "";
    worldID_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new MPTerrainIdentifierProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MPTerrainIdentifierProto(
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

            id_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            chunkID_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            worldID_ = s;
            break;
          }
          case 34: {
            MatrixPositionProto.Builder subBuilder = null;
            if (chunkPosition_ != null) {
              subBuilder = chunkPosition_.toBuilder();
            }
            chunkPosition_ = input.readMessage(MatrixPositionProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(chunkPosition_);
              chunkPosition_ = subBuilder.buildPartial();
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTerrainIdentifierProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTerrainIdentifierProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            MPTerrainIdentifierProto.class, Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private volatile Object id_;
  /**
   * <code>string id = 1;</code>
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
   * <code>string id = 1;</code>
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

  public static final int CHUNKID_FIELD_NUMBER = 2;
  private volatile Object chunkID_;
  /**
   * <code>string chunkID = 2;</code>
   * @return The chunkID.
   */
  @Override
  public String getChunkID() {
    Object ref = chunkID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      chunkID_ = s;
      return s;
    }
  }
  /**
   * <code>string chunkID = 2;</code>
   * @return The bytes for chunkID.
   */
  @Override
  public com.google.protobuf.ByteString
      getChunkIDBytes() {
    Object ref = chunkID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      chunkID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int WORLDID_FIELD_NUMBER = 3;
  private volatile Object worldID_;
  /**
   * <code>string worldID = 3;</code>
   * @return The worldID.
   */
  @Override
  public String getWorldID() {
    Object ref = worldID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      worldID_ = s;
      return s;
    }
  }
  /**
   * <code>string worldID = 3;</code>
   * @return The bytes for worldID.
   */
  @Override
  public com.google.protobuf.ByteString
      getWorldIDBytes() {
    Object ref = worldID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      worldID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHUNKPOSITION_FIELD_NUMBER = 4;
  private MatrixPositionProto chunkPosition_;
  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
   * @return Whether the chunkPosition field is set.
   */
  @Override
  public boolean hasChunkPosition() {
    return chunkPosition_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
   * @return The chunkPosition.
   */
  @Override
  public MatrixPositionProto getChunkPosition() {
    return chunkPosition_ == null ? MatrixPositionProto.getDefaultInstance() : chunkPosition_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
   */
  @Override
  public MatrixPositionProtoOrBuilder getChunkPositionOrBuilder() {
    return getChunkPosition();
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
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
    }
    if (!getChunkIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, chunkID_);
    }
    if (!getWorldIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, worldID_);
    }
    if (chunkPosition_ != null) {
      output.writeMessage(4, getChunkPosition());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
    }
    if (!getChunkIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, chunkID_);
    }
    if (!getWorldIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, worldID_);
    }
    if (chunkPosition_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getChunkPosition());
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
    if (!(obj instanceof MPTerrainIdentifierProto)) {
      return super.equals(obj);
    }
    MPTerrainIdentifierProto other = (MPTerrainIdentifierProto) obj;

    if (!getId()
        .equals(other.getId())) return false;
    if (!getChunkID()
        .equals(other.getChunkID())) return false;
    if (!getWorldID()
        .equals(other.getWorldID())) return false;
    if (hasChunkPosition() != other.hasChunkPosition()) return false;
    if (hasChunkPosition()) {
      if (!getChunkPosition()
          .equals(other.getChunkPosition())) return false;
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + CHUNKID_FIELD_NUMBER;
    hash = (53 * hash) + getChunkID().hashCode();
    hash = (37 * hash) + WORLDID_FIELD_NUMBER;
    hash = (53 * hash) + getWorldID().hashCode();
    if (hasChunkPosition()) {
      hash = (37 * hash) + CHUNKPOSITION_FIELD_NUMBER;
      hash = (53 * hash) + getChunkPosition().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static MPTerrainIdentifierProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPTerrainIdentifierProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPTerrainIdentifierProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPTerrainIdentifierProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPTerrainIdentifierProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPTerrainIdentifierProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPTerrainIdentifierProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPTerrainIdentifierProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPTerrainIdentifierProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static MPTerrainIdentifierProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPTerrainIdentifierProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPTerrainIdentifierProto parseFrom(
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
  public static Builder newBuilder(MPTerrainIdentifierProto prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.MPTerrainIdentifierProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.MPTerrainIdentifierProto)
      MPTerrainIdentifierProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTerrainIdentifierProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTerrainIdentifierProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MPTerrainIdentifierProto.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.MPTerrainIdentifierProto.newBuilder()
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
      id_ = "";

      chunkID_ = "";

      worldID_ = "";

      if (chunkPositionBuilder_ == null) {
        chunkPosition_ = null;
      } else {
        chunkPosition_ = null;
        chunkPositionBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTerrainIdentifierProto_descriptor;
    }

    @Override
    public MPTerrainIdentifierProto getDefaultInstanceForType() {
      return MPTerrainIdentifierProto.getDefaultInstance();
    }

    @Override
    public MPTerrainIdentifierProto build() {
      MPTerrainIdentifierProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public MPTerrainIdentifierProto buildPartial() {
      MPTerrainIdentifierProto result = new MPTerrainIdentifierProto(this);
      result.id_ = id_;
      result.chunkID_ = chunkID_;
      result.worldID_ = worldID_;
      if (chunkPositionBuilder_ == null) {
        result.chunkPosition_ = chunkPosition_;
      } else {
        result.chunkPosition_ = chunkPositionBuilder_.build();
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
      if (other instanceof MPTerrainIdentifierProto) {
        return mergeFrom((MPTerrainIdentifierProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(MPTerrainIdentifierProto other) {
      if (other == MPTerrainIdentifierProto.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (!other.getChunkID().isEmpty()) {
        chunkID_ = other.chunkID_;
        onChanged();
      }
      if (!other.getWorldID().isEmpty()) {
        worldID_ = other.worldID_;
        onChanged();
      }
      if (other.hasChunkPosition()) {
        mergeChunkPosition(other.getChunkPosition());
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
      MPTerrainIdentifierProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (MPTerrainIdentifierProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object id_ = "";
    /**
     * <code>string id = 1;</code>
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
     * <code>string id = 1;</code>
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
     * <code>string id = 1;</code>
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
     * <code>string id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
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

    private Object chunkID_ = "";
    /**
     * <code>string chunkID = 2;</code>
     * @return The chunkID.
     */
    public String getChunkID() {
      Object ref = chunkID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        chunkID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string chunkID = 2;</code>
     * @return The bytes for chunkID.
     */
    public com.google.protobuf.ByteString
        getChunkIDBytes() {
      Object ref = chunkID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        chunkID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string chunkID = 2;</code>
     * @param value The chunkID to set.
     * @return This builder for chaining.
     */
    public Builder setChunkID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      chunkID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string chunkID = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearChunkID() {
      
      chunkID_ = getDefaultInstance().getChunkID();
      onChanged();
      return this;
    }
    /**
     * <code>string chunkID = 2;</code>
     * @param value The bytes for chunkID to set.
     * @return This builder for chaining.
     */
    public Builder setChunkIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      chunkID_ = value;
      onChanged();
      return this;
    }

    private Object worldID_ = "";
    /**
     * <code>string worldID = 3;</code>
     * @return The worldID.
     */
    public String getWorldID() {
      Object ref = worldID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        worldID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string worldID = 3;</code>
     * @return The bytes for worldID.
     */
    public com.google.protobuf.ByteString
        getWorldIDBytes() {
      Object ref = worldID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        worldID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string worldID = 3;</code>
     * @param value The worldID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      worldID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string worldID = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearWorldID() {
      
      worldID_ = getDefaultInstance().getWorldID();
      onChanged();
      return this;
    }
    /**
     * <code>string worldID = 3;</code>
     * @param value The bytes for worldID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      worldID_ = value;
      onChanged();
      return this;
    }

    private MatrixPositionProto chunkPosition_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder> chunkPositionBuilder_;
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     * @return Whether the chunkPosition field is set.
     */
    public boolean hasChunkPosition() {
      return chunkPositionBuilder_ != null || chunkPosition_ != null;
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     * @return The chunkPosition.
     */
    public MatrixPositionProto getChunkPosition() {
      if (chunkPositionBuilder_ == null) {
        return chunkPosition_ == null ? MatrixPositionProto.getDefaultInstance() : chunkPosition_;
      } else {
        return chunkPositionBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     */
    public Builder setChunkPosition(MatrixPositionProto value) {
      if (chunkPositionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        chunkPosition_ = value;
        onChanged();
      } else {
        chunkPositionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     */
    public Builder setChunkPosition(
        MatrixPositionProto.Builder builderForValue) {
      if (chunkPositionBuilder_ == null) {
        chunkPosition_ = builderForValue.build();
        onChanged();
      } else {
        chunkPositionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     */
    public Builder mergeChunkPosition(MatrixPositionProto value) {
      if (chunkPositionBuilder_ == null) {
        if (chunkPosition_ != null) {
          chunkPosition_ =
            MatrixPositionProto.newBuilder(chunkPosition_).mergeFrom(value).buildPartial();
        } else {
          chunkPosition_ = value;
        }
        onChanged();
      } else {
        chunkPositionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     */
    public Builder clearChunkPosition() {
      if (chunkPositionBuilder_ == null) {
        chunkPosition_ = null;
        onChanged();
      } else {
        chunkPosition_ = null;
        chunkPositionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     */
    public MatrixPositionProto.Builder getChunkPositionBuilder() {
      
      onChanged();
      return getChunkPositionFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     */
    public MatrixPositionProtoOrBuilder getChunkPositionOrBuilder() {
      if (chunkPositionBuilder_ != null) {
        return chunkPositionBuilder_.getMessageOrBuilder();
      } else {
        return chunkPosition_ == null ?
            MatrixPositionProto.getDefaultInstance() : chunkPosition_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MatrixPositionProto chunkPosition = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>
        getChunkPositionFieldBuilder() {
      if (chunkPositionBuilder_ == null) {
        chunkPositionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MatrixPositionProto, MatrixPositionProto.Builder, MatrixPositionProtoOrBuilder>(
                getChunkPosition(),
                getParentForChildren(),
                isClean());
        chunkPosition_ = null;
      }
      return chunkPositionBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.MPTerrainIdentifierProto)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.MPTerrainIdentifierProto)
  private static final MPTerrainIdentifierProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new MPTerrainIdentifierProto();
  }

  public static MPTerrainIdentifierProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MPTerrainIdentifierProto>
      PARSER = new com.google.protobuf.AbstractParser<MPTerrainIdentifierProto>() {
    @Override
    public MPTerrainIdentifierProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MPTerrainIdentifierProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MPTerrainIdentifierProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<MPTerrainIdentifierProto> getParserForType() {
    return PARSER;
  }

  @Override
  public MPTerrainIdentifierProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

