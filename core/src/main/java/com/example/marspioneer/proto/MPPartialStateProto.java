// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.MPPartialStateProto}
 */
public final class MPPartialStateProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.model.IPartialState, 
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.MPPartialStateProto)
    MPPartialStateProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MPPartialStateProto.newBuilder() to construct.
  private MPPartialStateProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MPPartialStateProto() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new MPPartialStateProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MPPartialStateProto(
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
          case 10: {
            MPWorldSessionProto.Builder subBuilder = null;
            if (worldSession_ != null) {
              subBuilder = worldSession_.toBuilder();
            }
            worldSession_ = input.readMessage(MPWorldSessionProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(worldSession_);
              worldSession_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              cells_ = com.google.protobuf.MapField.newMapField(
                  CellsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<String, MPTerrainCellProto>
            cells__ = input.readMessage(
                CellsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            cells_.getMutableMap().put(
                cells__.getKey(), cells__.getValue());
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000002) != 0)) {
              entities_ = com.google.protobuf.MapField.newMapField(
                  EntitiesDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000002;
            }
            com.google.protobuf.MapEntry<String, MPEntityProto>
            entities__ = input.readMessage(
                EntitiesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            entities_.getMutableMap().put(
                entities__.getKey(), entities__.getValue());
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPPartialStateProto_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 2:
        return internalGetCells();
      case 3:
        return internalGetEntities();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPPartialStateProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            MPPartialStateProto.class, Builder.class);
  }

  public static final int WORLDSESSION_FIELD_NUMBER = 1;
  private MPWorldSessionProto worldSession_;
  /**
   * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
   * @return Whether the worldSession field is set.
   */
  @Override
  public boolean hasWorldSession() {
    return worldSession_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
   * @return The worldSession.
   */
  @Override
  public MPWorldSessionProto getWorldSession() {
    return worldSession_ == null ? MPWorldSessionProto.getDefaultInstance() : worldSession_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
   */
  @Override
  public MPWorldSessionProtoOrBuilder getWorldSessionOrBuilder() {
    return getWorldSession();
  }

  public static final int CELLS_FIELD_NUMBER = 2;
  private static final class CellsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        String, MPTerrainCellProto> defaultEntry =
            com.google.protobuf.MapEntry
            .<String, MPTerrainCellProto>newDefaultInstance(
                MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPPartialStateProto_CellsEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                MPTerrainCellProto.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      String, MPTerrainCellProto> cells_;
  private com.google.protobuf.MapField<String, MPTerrainCellProto>
  internalGetCells() {
    if (cells_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          CellsDefaultEntryHolder.defaultEntry);
    }
    return cells_;
  }

  public int getCellsCount() {
    return internalGetCells().getMap().size();
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
   */

  @Override
  public boolean containsCells(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    return internalGetCells().getMap().containsKey(key);
  }
  /**
   * Use {@link #getCellsMap()} instead.
   */
  @Override
  @Deprecated
  public java.util.Map<String, MPTerrainCellProto> getCells() {
    return getCellsMap();
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
   */
  @Override

  public java.util.Map<String, MPTerrainCellProto> getCellsMap() {
    return internalGetCells().getMap();
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
   */
  @Override

  public MPTerrainCellProto getCellsOrDefault(
      String key,
      MPTerrainCellProto defaultValue) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, MPTerrainCellProto> map =
        internalGetCells().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
   */
  @Override

  public MPTerrainCellProto getCellsOrThrow(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, MPTerrainCellProto> map =
        internalGetCells().getMap();
    if (!map.containsKey(key)) {
      throw new IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int ENTITIES_FIELD_NUMBER = 3;
  private static final class EntitiesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        String, MPEntityProto> defaultEntry =
            com.google.protobuf.MapEntry
            .<String, MPEntityProto>newDefaultInstance(
                MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPPartialStateProto_EntitiesEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                MPEntityProto.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      String, MPEntityProto> entities_;
  private com.google.protobuf.MapField<String, MPEntityProto>
  internalGetEntities() {
    if (entities_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          EntitiesDefaultEntryHolder.defaultEntry);
    }
    return entities_;
  }

  public int getEntitiesCount() {
    return internalGetEntities().getMap().size();
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
   */

  @Override
  public boolean containsEntities(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    return internalGetEntities().getMap().containsKey(key);
  }
  /**
   * Use {@link #getEntitiesMap()} instead.
   */
  @Override
  @Deprecated
  public java.util.Map<String, MPEntityProto> getEntities() {
    return getEntitiesMap();
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
   */
  @Override

  public java.util.Map<String, MPEntityProto> getEntitiesMap() {
    return internalGetEntities().getMap();
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
   */
  @Override

  public MPEntityProto getEntitiesOrDefault(
      String key,
      MPEntityProto defaultValue) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, MPEntityProto> map =
        internalGetEntities().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
   */
  @Override

  public MPEntityProto getEntitiesOrThrow(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, MPEntityProto> map =
        internalGetEntities().getMap();
    if (!map.containsKey(key)) {
      throw new IllegalArgumentException();
    }
    return map.get(key);
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
    if (worldSession_ != null) {
      output.writeMessage(1, getWorldSession());
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetCells(),
        CellsDefaultEntryHolder.defaultEntry,
        2);
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetEntities(),
        EntitiesDefaultEntryHolder.defaultEntry,
        3);
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (worldSession_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getWorldSession());
    }
    for (java.util.Map.Entry<String, MPTerrainCellProto> entry
         : internalGetCells().getMap().entrySet()) {
      com.google.protobuf.MapEntry<String, MPTerrainCellProto>
      cells__ = CellsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, cells__);
    }
    for (java.util.Map.Entry<String, MPEntityProto> entry
         : internalGetEntities().getMap().entrySet()) {
      com.google.protobuf.MapEntry<String, MPEntityProto>
      entities__ = EntitiesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, entities__);
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
    if (!(obj instanceof MPPartialStateProto)) {
      return super.equals(obj);
    }
    MPPartialStateProto other = (MPPartialStateProto) obj;

    if (hasWorldSession() != other.hasWorldSession()) return false;
    if (hasWorldSession()) {
      if (!getWorldSession()
          .equals(other.getWorldSession())) return false;
    }
    if (!internalGetCells().equals(
        other.internalGetCells())) return false;
    if (!internalGetEntities().equals(
        other.internalGetEntities())) return false;
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
    if (hasWorldSession()) {
      hash = (37 * hash) + WORLDSESSION_FIELD_NUMBER;
      hash = (53 * hash) + getWorldSession().hashCode();
    }
    if (!internalGetCells().getMap().isEmpty()) {
      hash = (37 * hash) + CELLS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetCells().hashCode();
    }
    if (!internalGetEntities().getMap().isEmpty()) {
      hash = (37 * hash) + ENTITIES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetEntities().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static MPPartialStateProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPPartialStateProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPPartialStateProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPPartialStateProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPPartialStateProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MPPartialStateProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MPPartialStateProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPPartialStateProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPPartialStateProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static MPPartialStateProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static MPPartialStateProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MPPartialStateProto parseFrom(
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
  public static Builder newBuilder(MPPartialStateProto prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.MPPartialStateProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements com.nkasenides.athlos.model.IPartialState, 
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.MPPartialStateProto)
      MPPartialStateProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPPartialStateProto_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetCells();
        case 3:
          return internalGetEntities();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetMutableCells();
        case 3:
          return internalGetMutableEntities();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPPartialStateProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MPPartialStateProto.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.MPPartialStateProto.newBuilder()
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
      if (worldSessionBuilder_ == null) {
        worldSession_ = null;
      } else {
        worldSession_ = null;
        worldSessionBuilder_ = null;
      }
      internalGetMutableCells().clear();
      internalGetMutableEntities().clear();
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_MPPartialStateProto_descriptor;
    }

    @Override
    public MPPartialStateProto getDefaultInstanceForType() {
      return MPPartialStateProto.getDefaultInstance();
    }

    @Override
    public MPPartialStateProto build() {
      MPPartialStateProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public MPPartialStateProto buildPartial() {
      MPPartialStateProto result = new MPPartialStateProto(this);
      int from_bitField0_ = bitField0_;
      if (worldSessionBuilder_ == null) {
        result.worldSession_ = worldSession_;
      } else {
        result.worldSession_ = worldSessionBuilder_.build();
      }
      result.cells_ = internalGetCells();
      result.cells_.makeImmutable();
      result.entities_ = internalGetEntities();
      result.entities_.makeImmutable();
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
      if (other instanceof MPPartialStateProto) {
        return mergeFrom((MPPartialStateProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(MPPartialStateProto other) {
      if (other == MPPartialStateProto.getDefaultInstance()) return this;
      if (other.hasWorldSession()) {
        mergeWorldSession(other.getWorldSession());
      }
      internalGetMutableCells().mergeFrom(
          other.internalGetCells());
      internalGetMutableEntities().mergeFrom(
          other.internalGetEntities());
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
      MPPartialStateProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (MPPartialStateProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private MPWorldSessionProto worldSession_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MPWorldSessionProto, MPWorldSessionProto.Builder, MPWorldSessionProtoOrBuilder> worldSessionBuilder_;
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     * @return Whether the worldSession field is set.
     */
    public boolean hasWorldSession() {
      return worldSessionBuilder_ != null || worldSession_ != null;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     * @return The worldSession.
     */
    public MPWorldSessionProto getWorldSession() {
      if (worldSessionBuilder_ == null) {
        return worldSession_ == null ? MPWorldSessionProto.getDefaultInstance() : worldSession_;
      } else {
        return worldSessionBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     */
    public Builder setWorldSession(MPWorldSessionProto value) {
      if (worldSessionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        worldSession_ = value;
        onChanged();
      } else {
        worldSessionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     */
    public Builder setWorldSession(
        MPWorldSessionProto.Builder builderForValue) {
      if (worldSessionBuilder_ == null) {
        worldSession_ = builderForValue.build();
        onChanged();
      } else {
        worldSessionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     */
    public Builder mergeWorldSession(MPWorldSessionProto value) {
      if (worldSessionBuilder_ == null) {
        if (worldSession_ != null) {
          worldSession_ =
            MPWorldSessionProto.newBuilder(worldSession_).mergeFrom(value).buildPartial();
        } else {
          worldSession_ = value;
        }
        onChanged();
      } else {
        worldSessionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     */
    public Builder clearWorldSession() {
      if (worldSessionBuilder_ == null) {
        worldSession_ = null;
        onChanged();
      } else {
        worldSession_ = null;
        worldSessionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     */
    public MPWorldSessionProto.Builder getWorldSessionBuilder() {
      
      onChanged();
      return getWorldSessionFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     */
    public MPWorldSessionProtoOrBuilder getWorldSessionOrBuilder() {
      if (worldSessionBuilder_ != null) {
        return worldSessionBuilder_.getMessageOrBuilder();
      } else {
        return worldSession_ == null ?
            MPWorldSessionProto.getDefaultInstance() : worldSession_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPWorldSessionProto worldSession = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MPWorldSessionProto, MPWorldSessionProto.Builder, MPWorldSessionProtoOrBuilder>
        getWorldSessionFieldBuilder() {
      if (worldSessionBuilder_ == null) {
        worldSessionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MPWorldSessionProto, MPWorldSessionProto.Builder, MPWorldSessionProtoOrBuilder>(
                getWorldSession(),
                getParentForChildren(),
                isClean());
        worldSession_ = null;
      }
      return worldSessionBuilder_;
    }

    private com.google.protobuf.MapField<
        String, MPTerrainCellProto> cells_;
    private com.google.protobuf.MapField<String, MPTerrainCellProto>
    internalGetCells() {
      if (cells_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            CellsDefaultEntryHolder.defaultEntry);
      }
      return cells_;
    }
    private com.google.protobuf.MapField<String, MPTerrainCellProto>
    internalGetMutableCells() {
      onChanged();;
      if (cells_ == null) {
        cells_ = com.google.protobuf.MapField.newMapField(
            CellsDefaultEntryHolder.defaultEntry);
      }
      if (!cells_.isMutable()) {
        cells_ = cells_.copy();
      }
      return cells_;
    }

    public int getCellsCount() {
      return internalGetCells().getMap().size();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
     */

    @Override
    public boolean containsCells(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetCells().getMap().containsKey(key);
    }
    /**
     * Use {@link #getCellsMap()} instead.
     */
    @Override
    @Deprecated
    public java.util.Map<String, MPTerrainCellProto> getCells() {
      return getCellsMap();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
     */
    @Override

    public java.util.Map<String, MPTerrainCellProto> getCellsMap() {
      return internalGetCells().getMap();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
     */
    @Override

    public MPTerrainCellProto getCellsOrDefault(
        String key,
        MPTerrainCellProto defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, MPTerrainCellProto> map =
          internalGetCells().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
     */
    @Override

    public MPTerrainCellProto getCellsOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, MPTerrainCellProto> map =
          internalGetCells().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearCells() {
      internalGetMutableCells().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
     */

    public Builder removeCells(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      internalGetMutableCells().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @Deprecated
    public java.util.Map<String, MPTerrainCellProto>
    getMutableCells() {
      return internalGetMutableCells().getMutableMap();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
     */
    public Builder putCells(
        String key,
        MPTerrainCellProto value) {
      if (key == null) { throw new NullPointerException(); }
      if (value == null) { throw new NullPointerException(); }
      internalGetMutableCells().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; cells = 2;</code>
     */

    public Builder putAllCells(
        java.util.Map<String, MPTerrainCellProto> values) {
      internalGetMutableCells().getMutableMap()
          .putAll(values);
      return this;
    }

    private com.google.protobuf.MapField<
        String, MPEntityProto> entities_;
    private com.google.protobuf.MapField<String, MPEntityProto>
    internalGetEntities() {
      if (entities_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            EntitiesDefaultEntryHolder.defaultEntry);
      }
      return entities_;
    }
    private com.google.protobuf.MapField<String, MPEntityProto>
    internalGetMutableEntities() {
      onChanged();;
      if (entities_ == null) {
        entities_ = com.google.protobuf.MapField.newMapField(
            EntitiesDefaultEntryHolder.defaultEntry);
      }
      if (!entities_.isMutable()) {
        entities_ = entities_.copy();
      }
      return entities_;
    }

    public int getEntitiesCount() {
      return internalGetEntities().getMap().size();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
     */

    @Override
    public boolean containsEntities(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetEntities().getMap().containsKey(key);
    }
    /**
     * Use {@link #getEntitiesMap()} instead.
     */
    @Override
    @Deprecated
    public java.util.Map<String, MPEntityProto> getEntities() {
      return getEntitiesMap();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
     */
    @Override

    public java.util.Map<String, MPEntityProto> getEntitiesMap() {
      return internalGetEntities().getMap();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
     */
    @Override

    public MPEntityProto getEntitiesOrDefault(
        String key,
        MPEntityProto defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, MPEntityProto> map =
          internalGetEntities().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
     */
    @Override

    public MPEntityProto getEntitiesOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, MPEntityProto> map =
          internalGetEntities().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearEntities() {
      internalGetMutableEntities().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
     */

    public Builder removeEntities(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      internalGetMutableEntities().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @Deprecated
    public java.util.Map<String, MPEntityProto>
    getMutableEntities() {
      return internalGetMutableEntities().getMutableMap();
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
     */
    public Builder putEntities(
        String key,
        MPEntityProto value) {
      if (key == null) { throw new NullPointerException(); }
      if (value == null) { throw new NullPointerException(); }
      internalGetMutableEntities().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; entities = 3;</code>
     */

    public Builder putAllEntities(
        java.util.Map<String, MPEntityProto> values) {
      internalGetMutableEntities().getMutableMap()
          .putAll(values);
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.MPPartialStateProto)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.MPPartialStateProto)
  private static final MPPartialStateProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new MPPartialStateProto();
  }

  public static MPPartialStateProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MPPartialStateProto>
      PARSER = new com.google.protobuf.AbstractParser<MPPartialStateProto>() {
    @Override
    public MPPartialStateProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MPPartialStateProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MPPartialStateProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<MPPartialStateProto> getParserForType() {
    return PARSER;
  }

  @Override
  public MPPartialStateProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

