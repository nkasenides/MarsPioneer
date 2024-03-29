// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.MPTeamProto}
 */
public final class MPTeamProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<com.example.marspioneer.model.MPTeam> , com.nkasenides.athlos.model.ITeam, 
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.MPTeamProto)
    MPTeamProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MPTeamProto.newBuilder() to construct.
  private MPTeamProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MPTeamProto() {
    color_ = 0;
    name_ = "";
    id_ = "";
    ownerID_ = "";
    playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new MPTeamProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MPTeamProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
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
            int rawValue = input.readEnum();

            color_ = rawValue;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();

            ownerID_ = s;
            break;
          }
          case 42: {
            String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              playerIDs_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            playerIDs_.add(s);
            break;
          }
          case 48: {

            playerLimit_ = input.readUInt32();
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        playerIDs_ = playerIDs_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTeamProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTeamProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            MPTeamProto.class, Builder.class);
  }

  public static final int COLOR_FIELD_NUMBER = 1;
  private int color_;
  /**
   * <code>.com.example.marspioneer.proto.TeamColor color = 1;</code>
   * @return The enum numeric value on the wire for color.
   */
  @Override public int getColorValue() {
    return color_;
  }
  /**
   * <code>.com.example.marspioneer.proto.TeamColor color = 1;</code>
   * @return The color.
   */
  @Override public TeamColor getColor() {
    @SuppressWarnings("deprecation")
    TeamColor result = TeamColor.valueOf(color_);
    return result == null ? TeamColor.UNRECOGNIZED : result;
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile Object name_;
  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  @Override
  public String getName() {
    Object ref = name_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  @Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    Object ref = name_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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

  public static final int OWNERID_FIELD_NUMBER = 4;
  private volatile Object ownerID_;
  /**
   * <code>string ownerID = 4;</code>
   * @return The ownerID.
   */
  @Override
  public String getOwnerID() {
    Object ref = ownerID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      ownerID_ = s;
      return s;
    }
  }
  /**
   * <code>string ownerID = 4;</code>
   * @return The bytes for ownerID.
   */
  @Override
  public com.google.protobuf.ByteString
      getOwnerIDBytes() {
    Object ref = ownerID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      ownerID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PLAYERIDS_FIELD_NUMBER = 5;
  private com.google.protobuf.LazyStringList playerIDs_;
  /**
   * <code>repeated string playerIDs = 5;</code>
   * @return A list containing the playerIDs.
   */
  public com.google.protobuf.ProtocolStringList
      getPlayerIDsList() {
    return playerIDs_;
  }
  /**
   * <code>repeated string playerIDs = 5;</code>
   * @return The count of playerIDs.
   */
  public int getPlayerIDsCount() {
    return playerIDs_.size();
  }
  /**
   * <code>repeated string playerIDs = 5;</code>
   * @param index The index of the element to return.
   * @return The playerIDs at the given index.
   */
  public String getPlayerIDs(int index) {
    return playerIDs_.get(index);
  }
  /**
   * <code>repeated string playerIDs = 5;</code>
   * @param index The index of the value to return.
   * @return The bytes of the playerIDs at the given index.
   */
  public com.google.protobuf.ByteString
      getPlayerIDsBytes(int index) {
    return playerIDs_.getByteString(index);
  }

  public static final int PLAYERLIMIT_FIELD_NUMBER = 6;
  private int playerLimit_;
  /**
   * <code>uint32 playerLimit = 6;</code>
   * @return The playerLimit.
   */
  @Override
  public int getPlayerLimit() {
    return playerLimit_;
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
    if (color_ != TeamColor.RED_TeamColor.getNumber()) {
      output.writeEnum(1, color_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
    }
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, id_);
    }
    if (!getOwnerIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, ownerID_);
    }
    for (int i = 0; i < playerIDs_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, playerIDs_.getRaw(i));
    }
    if (playerLimit_ != 0) {
      output.writeUInt32(6, playerLimit_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (color_ != TeamColor.RED_TeamColor.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, color_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
    }
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, id_);
    }
    if (!getOwnerIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, ownerID_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < playerIDs_.size(); i++) {
        dataSize += computeStringSizeNoTag(playerIDs_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getPlayerIDsList().size();
    }
    if (playerLimit_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(6, playerLimit_);
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
    if (!(obj instanceof MPTeamProto)) {
      return super.equals(obj);
    }
    MPTeamProto other = (MPTeamProto) obj;

    if (color_ != other.color_) return false;
    if (!getName()
        .equals(other.getName())) return false;
    if (!getId()
        .equals(other.getId())) return false;
    if (!getOwnerID()
        .equals(other.getOwnerID())) return false;
    if (!getPlayerIDsList()
        .equals(other.getPlayerIDsList())) return false;
    if (getPlayerLimit()
        != other.getPlayerLimit()) return false;
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
    hash = (37 * hash) + COLOR_FIELD_NUMBER;
    hash = (53 * hash) + color_;
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + OWNERID_FIELD_NUMBER;
    hash = (53 * hash) + getOwnerID().hashCode();
    if (getPlayerIDsCount() > 0) {
      hash = (37 * hash) + PLAYERIDS_FIELD_NUMBER;
      hash = (53 * hash) + getPlayerIDsList().hashCode();
    }
    hash = (37 * hash) + PLAYERLIMIT_FIELD_NUMBER;
    hash = (53 * hash) + getPlayerLimit();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static MPTeamProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPTeamProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPTeamProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPTeamProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPTeamProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPTeamProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPTeamProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPTeamProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPTeamProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static MPTeamProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPTeamProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPTeamProto parseFrom(
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
  public static Builder newBuilder(MPTeamProto prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.MPTeamProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements com.nkasenides.athlos.model.ITeam, com.nkasenides.athlos.proto.Modelable<com.example.marspioneer.model.MPTeam>, 
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.MPTeamProto)
      MPTeamProtoOrBuilder {    @Override
    public com.example.marspioneer.model.MPTeam toObject() {    
        com.example.marspioneer.model.MPTeam item = new com.example.marspioneer.model.MPTeam();        
        item.setColor(getColor());        
        item.setName(getName());        
        item.setId(getId());        
        item.setOwnerID(getOwnerID());        
        java.util.ArrayList<String> playerIDsList = new java.util.ArrayList<>();        
        for (int i = 0; i < getPlayerIDsCount(); i++) {        
            playerIDsList.add(getPlayerIDs(i));            
        }        
        item.setPlayerIDs(playerIDsList);        
        item.setPlayerLimit(getPlayerLimit());        
        return item;        
    }    
    
        public java.util.List<String> getPlayerIDs() {
        return playerIDs_;
    }
    

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTeamProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTeamProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MPTeamProto.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.MPTeamProto.newBuilder()
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
      color_ = 0;

      name_ = "";

      id_ = "";

      ownerID_ = "";

      playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      playerLimit_ = 0;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPTeamProto_descriptor;
    }

    @Override
    public MPTeamProto getDefaultInstanceForType() {
      return MPTeamProto.getDefaultInstance();
    }

    @Override
    public MPTeamProto build() {
      MPTeamProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public MPTeamProto buildPartial() {
      MPTeamProto result = new MPTeamProto(this);
      int from_bitField0_ = bitField0_;
      result.color_ = color_;
      result.name_ = name_;
      result.id_ = id_;
      result.ownerID_ = ownerID_;
      if (((bitField0_ & 0x00000001) != 0)) {
        playerIDs_ = playerIDs_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.playerIDs_ = playerIDs_;
      result.playerLimit_ = playerLimit_;
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
      if (other instanceof MPTeamProto) {
        return mergeFrom((MPTeamProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(MPTeamProto other) {
      if (other == MPTeamProto.getDefaultInstance()) return this;
      if (other.color_ != 0) {
        setColorValue(other.getColorValue());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (!other.getOwnerID().isEmpty()) {
        ownerID_ = other.ownerID_;
        onChanged();
      }
      if (!other.playerIDs_.isEmpty()) {
        if (playerIDs_.isEmpty()) {
          playerIDs_ = other.playerIDs_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensurePlayerIDsIsMutable();
          playerIDs_.addAll(other.playerIDs_);
        }
        onChanged();
      }
      if (other.getPlayerLimit() != 0) {
        setPlayerLimit(other.getPlayerLimit());
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
      MPTeamProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (MPTeamProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int color_ = 0;
    /**
     * <code>.com.example.marspioneer.proto.TeamColor color = 1;</code>
     * @return The enum numeric value on the wire for color.
     */
    @Override public int getColorValue() {
      return color_;
    }
    /**
     * <code>.com.example.marspioneer.proto.TeamColor color = 1;</code>
     * @param value The enum numeric value on the wire for color to set.
     * @return This builder for chaining.
     */
    public Builder setColorValue(int value) {
      
      color_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.TeamColor color = 1;</code>
     * @return The color.
     */
    @Override
    public TeamColor getColor() {
      @SuppressWarnings("deprecation")
      TeamColor result = TeamColor.valueOf(color_);
      return result == null ? TeamColor.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.example.marspioneer.proto.TeamColor color = 1;</code>
     * @param value The color to set.
     * @return This builder for chaining.
     */
    public Builder setColor(TeamColor value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      color_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.TeamColor color = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearColor() {
      
      color_ = 0;
      onChanged();
      return this;
    }

    private Object name_ = "";
    /**
     * <code>string name = 2;</code>
     * @return The name.
     */
    public String getName() {
      Object ref = name_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 2;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 2;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
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

    private Object ownerID_ = "";
    /**
     * <code>string ownerID = 4;</code>
     * @return The ownerID.
     */
    public String getOwnerID() {
      Object ref = ownerID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        ownerID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string ownerID = 4;</code>
     * @return The bytes for ownerID.
     */
    public com.google.protobuf.ByteString
        getOwnerIDBytes() {
      Object ref = ownerID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        ownerID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string ownerID = 4;</code>
     * @param value The ownerID to set.
     * @return This builder for chaining.
     */
    public Builder setOwnerID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ownerID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string ownerID = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearOwnerID() {
      
      ownerID_ = getDefaultInstance().getOwnerID();
      onChanged();
      return this;
    }
    /**
     * <code>string ownerID = 4;</code>
     * @param value The bytes for ownerID to set.
     * @return This builder for chaining.
     */
    public Builder setOwnerIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      ownerID_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensurePlayerIDsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        playerIDs_ = new com.google.protobuf.LazyStringArrayList(playerIDs_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @return A list containing the playerIDs.
     */
    public com.google.protobuf.ProtocolStringList
        getPlayerIDsList() {
      return playerIDs_.getUnmodifiableView();
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @return The count of playerIDs.
     */
    public int getPlayerIDsCount() {
      return playerIDs_.size();
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @param index The index of the element to return.
     * @return The playerIDs at the given index.
     */
    public String getPlayerIDs(int index) {
      return playerIDs_.get(index);
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @param index The index of the value to return.
     * @return The bytes of the playerIDs at the given index.
     */
    public com.google.protobuf.ByteString
        getPlayerIDsBytes(int index) {
      return playerIDs_.getByteString(index);
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @param index The index to set the value at.
     * @param value The playerIDs to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerIDs(
        int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePlayerIDsIsMutable();
      playerIDs_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @param value The playerIDs to add.
     * @return This builder for chaining.
     */
    public Builder addPlayerIDs(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensurePlayerIDsIsMutable();
      playerIDs_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @param values The playerIDs to add.
     * @return This builder for chaining.
     */
    public Builder addAllPlayerIDs(
        Iterable<String> values) {
      ensurePlayerIDsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, playerIDs_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlayerIDs() {
      playerIDs_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string playerIDs = 5;</code>
     * @param value The bytes of the playerIDs to add.
     * @return This builder for chaining.
     */
    public Builder addPlayerIDsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensurePlayerIDsIsMutable();
      playerIDs_.add(value);
      onChanged();
      return this;
    }

    private int playerLimit_ ;
    /**
     * <code>uint32 playerLimit = 6;</code>
     * @return The playerLimit.
     */
    @Override
    public int getPlayerLimit() {
      return playerLimit_;
    }
    /**
     * <code>uint32 playerLimit = 6;</code>
     * @param value The playerLimit to set.
     * @return This builder for chaining.
     */
    public Builder setPlayerLimit(int value) {
      
      playerLimit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 playerLimit = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlayerLimit() {
      
      playerLimit_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.MPTeamProto)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.MPTeamProto)
  private static final MPTeamProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new MPTeamProto();
  }

  public static MPTeamProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MPTeamProto>
      PARSER = new com.google.protobuf.AbstractParser<MPTeamProto>() {
    @Override
    public MPTeamProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MPTeamProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MPTeamProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<MPTeamProto> getParserForType() {
    return PARSER;
  }

  @Override
  public MPTeamProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @Override
    public com.example.marspioneer.model.MPTeam toObject() {    
        com.example.marspioneer.model.MPTeam item = new com.example.marspioneer.model.MPTeam();        
        item.setColor(getColor());        
        item.setName(getName());        
        item.setId(getId());        
        item.setOwnerID(getOwnerID());        
        java.util.ArrayList<String> playerIDsList = new java.util.ArrayList<>();        
        for (int i = 0; i < getPlayerIDsCount(); i++) {        
            playerIDsList.add(getPlayerIDs(i));            
        }        
        item.setPlayerIDs(playerIDsList);        
        item.setPlayerLimit(getPlayerLimit());        
        return item;        
    }    
    
        public java.util.List<String> getPlayerIDs() {
        return playerIDs_;
    }
    
}

