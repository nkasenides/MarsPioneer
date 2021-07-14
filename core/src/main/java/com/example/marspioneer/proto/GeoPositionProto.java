// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

import com.raylabz.jsec.HashType;

/**
 * Protobuf type {@code com.example.marspioneer.proto.GeoPositionProto}
 */
public final class GeoPositionProto extends
    com.google.protobuf.GeneratedMessageV3 implements com.nkasenides.athlos.proto.Modelable<com.example.marspioneer.model.GeoPosition> , 
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.GeoPositionProto)
    GeoPositionProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GeoPositionProto.newBuilder() to construct.
  private GeoPositionProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GeoPositionProto() {
    positionHash_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GeoPositionProto();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GeoPositionProto(
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
          case 13: {

            x_ = input.readFloat();
            break;
          }
          case 21: {

            y_ = input.readFloat();
            break;
          }
          case 29: {

            z_ = input.readFloat();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            positionHash_ = s;
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
    return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_GeoPositionProto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_GeoPositionProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.marspioneer.proto.GeoPositionProto.class, com.example.marspioneer.proto.GeoPositionProto.Builder.class);
  }

  public static final int X_FIELD_NUMBER = 1;
  private float x_;
  /**
   * <code>float x = 1;</code>
   * @return The x.
   */
  @java.lang.Override
  public float getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 2;
  private float y_;
  /**
   * <code>float y = 2;</code>
   * @return The y.
   */
  @java.lang.Override
  public float getY() {
    return y_;
  }

  public static final int Z_FIELD_NUMBER = 3;
  private float z_;
  /**
   * <code>float z = 3;</code>
   * @return The z.
   */
  @java.lang.Override
  public float getZ() {
    return z_;
  }

  public static final int POSITIONHASH_FIELD_NUMBER = 4;
  private volatile java.lang.Object positionHash_;
  /**
   * <code>string positionHash = 4;</code>
   * @return The positionHash.
   */
  @java.lang.Override
  public java.lang.String getPositionHash() {
    java.lang.Object ref = positionHash_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      positionHash_ = s;
      return s;
    }
  }
  /**
   * <code>string positionHash = 4;</code>
   * @return The bytes for positionHash.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPositionHashBytes() {
    java.lang.Object ref = positionHash_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      positionHash_ = b;
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
    if (x_ != 0F) {
      output.writeFloat(1, x_);
    }
    if (y_ != 0F) {
      output.writeFloat(2, y_);
    }
    if (z_ != 0F) {
      output.writeFloat(3, z_);
    }
    if (!getPositionHashBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, positionHash_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (x_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, x_);
    }
    if (y_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, y_);
    }
    if (z_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, z_);
    }
    if (!getPositionHashBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, positionHash_);
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
    if (!(obj instanceof com.example.marspioneer.proto.GeoPositionProto)) {
      return super.equals(obj);
    }
    com.example.marspioneer.proto.GeoPositionProto other = (com.example.marspioneer.proto.GeoPositionProto) obj;

    if (java.lang.Float.floatToIntBits(getX())
        != java.lang.Float.floatToIntBits(
            other.getX())) return false;
    if (java.lang.Float.floatToIntBits(getY())
        != java.lang.Float.floatToIntBits(
            other.getY())) return false;
    if (java.lang.Float.floatToIntBits(getZ())
        != java.lang.Float.floatToIntBits(
            other.getZ())) return false;
    if (!getPositionHash()
        .equals(other.getPositionHash())) return false;
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
    hash = (37 * hash) + X_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getX());
    hash = (37 * hash) + Y_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getY());
    hash = (37 * hash) + Z_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getZ());
    hash = (37 * hash) + POSITIONHASH_FIELD_NUMBER;
    hash = (53 * hash) + getPositionHash().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.GeoPositionProto parseFrom(
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
  public static Builder newBuilder(com.example.marspioneer.proto.GeoPositionProto prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.GeoPositionProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.GeoPositionProto)
      com.example.marspioneer.proto.GeoPositionProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_GeoPositionProto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_GeoPositionProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.marspioneer.proto.GeoPositionProto.class, com.example.marspioneer.proto.GeoPositionProto.Builder.class);
    }

    // Construct using com.example.marspioneer.proto.GeoPositionProto.newBuilder()
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
      x_ = 0F;

      y_ = 0F;

      z_ = 0F;

      positionHash_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_GeoPositionProto_descriptor;
    }

    @java.lang.Override
    public com.example.marspioneer.proto.GeoPositionProto getDefaultInstanceForType() {
      return com.example.marspioneer.proto.GeoPositionProto.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.marspioneer.proto.GeoPositionProto build() {
      com.example.marspioneer.proto.GeoPositionProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.marspioneer.proto.GeoPositionProto buildPartial() {
      com.example.marspioneer.proto.GeoPositionProto result = new com.example.marspioneer.proto.GeoPositionProto(this);
      result.x_ = x_;
      result.y_ = y_;
      result.z_ = z_;
      result.positionHash_ = positionHash_;
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
      if (other instanceof com.example.marspioneer.proto.GeoPositionProto) {
        return mergeFrom((com.example.marspioneer.proto.GeoPositionProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.marspioneer.proto.GeoPositionProto other) {
      if (other == com.example.marspioneer.proto.GeoPositionProto.getDefaultInstance()) return this;
      if (other.getX() != 0F) {
        setX(other.getX());
      }
      if (other.getY() != 0F) {
        setY(other.getY());
      }
      if (other.getZ() != 0F) {
        setZ(other.getZ());
      }
      if (!other.getPositionHash().isEmpty()) {
        positionHash_ = other.positionHash_;
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
      com.example.marspioneer.proto.GeoPositionProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.marspioneer.proto.GeoPositionProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float x_ ;
    /**
     * <code>float x = 1;</code>
     * @return The x.
     */
    @java.lang.Override
    public float getX() {
      return x_;
    }
    /**
     * <code>float x = 1;</code>
     * @param value The x to set.
     * @return This builder for chaining.
     */
    public Builder setX(float value) {
      
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float x = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearX() {
      
      x_ = 0F;
      onChanged();
      return this;
    }

    private float y_ ;
    /**
     * <code>float y = 2;</code>
     * @return The y.
     */
    @java.lang.Override
    public float getY() {
      return y_;
    }
    /**
     * <code>float y = 2;</code>
     * @param value The y to set.
     * @return This builder for chaining.
     */
    public Builder setY(float value) {
      
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float y = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearY() {
      
      y_ = 0F;
      onChanged();
      return this;
    }

    private float z_ ;
    /**
     * <code>float z = 3;</code>
     * @return The z.
     */
    @java.lang.Override
    public float getZ() {
      return z_;
    }
    /**
     * <code>float z = 3;</code>
     * @param value The z to set.
     * @return This builder for chaining.
     */
    public Builder setZ(float value) {
      
      z_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float z = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearZ() {
      
      z_ = 0F;
      onChanged();
      return this;
    }

    private java.lang.Object positionHash_ = "";
    /**
     * <code>string positionHash = 4;</code>
     * @return The positionHash.
     */
    public java.lang.String getPositionHash() {
      java.lang.Object ref = positionHash_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        positionHash_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string positionHash = 4;</code>
     * @return The bytes for positionHash.
     */
    public com.google.protobuf.ByteString
        getPositionHashBytes() {
      java.lang.Object ref = positionHash_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        positionHash_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string positionHash = 4;</code>
     * @param value The positionHash to set.
     * @return This builder for chaining.
     */
    public Builder setPositionHash(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      positionHash_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string positionHash = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPositionHash() {
      
      positionHash_ = getDefaultInstance().getPositionHash();
      onChanged();
      return this;
    }
    /**
     * <code>string positionHash = 4;</code>
     * @param value The bytes for positionHash to set.
     * @return This builder for chaining.
     */
    public Builder setPositionHashBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      positionHash_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.GeoPositionProto)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.GeoPositionProto)
  private static final com.example.marspioneer.proto.GeoPositionProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.marspioneer.proto.GeoPositionProto();
  }

  public static com.example.marspioneer.proto.GeoPositionProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GeoPositionProto>
      PARSER = new com.google.protobuf.AbstractParser<GeoPositionProto>() {
    @java.lang.Override
    public GeoPositionProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GeoPositionProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GeoPositionProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GeoPositionProto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.marspioneer.proto.GeoPositionProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

    @java.lang.Override    
    public com.example.marspioneer.model.GeoPosition toObject() {    
        com.example.marspioneer.model.GeoPosition item = new com.example.marspioneer.model.GeoPosition();        
        item.setX(getX());        
        item.setY(getY());        
        item.setZ(getZ());        
        return item;        
    }    
    


    public final double distanceTo(GeoPositionProto otherGeoPosition) {
        return Math.sqrt((Math.pow((getX() - otherGeoPosition.getX()), 2) + Math.pow((getY() - otherGeoPosition.getY()), 2) + Math.pow(getZ() - otherGeoPosition.getZ(), 2)));
    }

    public final String toHash() {
        return com.raylabz.jsec.Hashing.hash(HashType.MD5, getX() + "," + getY() + "," + getZ());
    }
    public final MatrixPositionProto toMatrixPosition() { 
      return MatrixPositionProto.newBuilder().setCol(Math.round(getY())).setRow((Math.round(getX()))).build();
    }

}

