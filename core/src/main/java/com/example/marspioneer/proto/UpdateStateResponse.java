// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.UpdateStateResponse}
 */
public final class UpdateStateResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.UpdateStateResponse)
    UpdateStateResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateStateResponse.newBuilder() to construct.
  private UpdateStateResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateStateResponse() {
    message_ = "";
    status_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateStateResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateStateResponse(
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
            com.example.marspioneer.proto.MPPartialStateProto.Builder subBuilder = null;
            if (partialState_ != null) {
              subBuilder = partialState_.toBuilder();
            }
            partialState_ = input.readMessage(com.example.marspioneer.proto.MPPartialStateProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(partialState_);
              partialState_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            status_ = rawValue;
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
    return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.marspioneer.proto.UpdateStateResponse.class, com.example.marspioneer.proto.UpdateStateResponse.Builder.class);
  }

  /**
   * Protobuf enum {@code com.example.marspioneer.proto.UpdateStateResponse.Status}
   */
  public enum Status
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>SERVER_ERROR = 0;</code>
     */
    SERVER_ERROR(0),
    /**
     * <code>NO_SUCH_WORLD_SESSION = 1;</code>
     */
    NO_SUCH_WORLD_SESSION(1),
    /**
     * <code>INVALID_DATA = 2;</code>
     */
    INVALID_DATA(2),
    /**
     * <code>NOT_AUTHORIZED = 3;</code>
     */
    NOT_AUTHORIZED(3),
    /**
     * <code>CANNOT_COMPOSE_STATE = 4;</code>
     */
    CANNOT_COMPOSE_STATE(4),
    /**
     * <code>OK = 5;</code>
     */
    OK(5),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>SERVER_ERROR = 0;</code>
     */
    public static final int SERVER_ERROR_VALUE = 0;
    /**
     * <code>NO_SUCH_WORLD_SESSION = 1;</code>
     */
    public static final int NO_SUCH_WORLD_SESSION_VALUE = 1;
    /**
     * <code>INVALID_DATA = 2;</code>
     */
    public static final int INVALID_DATA_VALUE = 2;
    /**
     * <code>NOT_AUTHORIZED = 3;</code>
     */
    public static final int NOT_AUTHORIZED_VALUE = 3;
    /**
     * <code>CANNOT_COMPOSE_STATE = 4;</code>
     */
    public static final int CANNOT_COMPOSE_STATE_VALUE = 4;
    /**
     * <code>OK = 5;</code>
     */
    public static final int OK_VALUE = 5;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Status valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Status forNumber(int value) {
      switch (value) {
        case 0: return SERVER_ERROR;
        case 1: return NO_SUCH_WORLD_SESSION;
        case 2: return INVALID_DATA;
        case 3: return NOT_AUTHORIZED;
        case 4: return CANNOT_COMPOSE_STATE;
        case 5: return OK;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Status>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Status> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Status>() {
            public Status findValueByNumber(int number) {
              return Status.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.example.marspioneer.proto.UpdateStateResponse.getDescriptor().getEnumTypes().get(0);
    }

    private static final Status[] VALUES = values();

    public static Status valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Status(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.example.marspioneer.proto.UpdateStateResponse.Status)
  }

  public static final int PARTIALSTATE_FIELD_NUMBER = 1;
  private com.example.marspioneer.proto.MPPartialStateProto partialState_;
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   * @return Whether the partialState field is set.
   */
  @java.lang.Override
  public boolean hasPartialState() {
    return partialState_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   * @return The partialState.
   */
  @java.lang.Override
  public com.example.marspioneer.proto.MPPartialStateProto getPartialState() {
    return partialState_ == null ? com.example.marspioneer.proto.MPPartialStateProto.getDefaultInstance() : partialState_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   */
  @java.lang.Override
  public com.example.marspioneer.proto.MPPartialStateProtoOrBuilder getPartialStateOrBuilder() {
    return getPartialState();
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object message_;
  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 3;
  private int status_;
  /**
   * <code>.com.example.marspioneer.proto.UpdateStateResponse.Status status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  @java.lang.Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.com.example.marspioneer.proto.UpdateStateResponse.Status status = 3;</code>
   * @return The status.
   */
  @java.lang.Override public com.example.marspioneer.proto.UpdateStateResponse.Status getStatus() {
    @SuppressWarnings("deprecation")
    com.example.marspioneer.proto.UpdateStateResponse.Status result = com.example.marspioneer.proto.UpdateStateResponse.Status.valueOf(status_);
    return result == null ? com.example.marspioneer.proto.UpdateStateResponse.Status.UNRECOGNIZED : result;
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
    if (partialState_ != null) {
      output.writeMessage(1, getPartialState());
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    if (status_ != com.example.marspioneer.proto.UpdateStateResponse.Status.SERVER_ERROR.getNumber()) {
      output.writeEnum(3, status_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (partialState_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPartialState());
    }
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
    }
    if (status_ != com.example.marspioneer.proto.UpdateStateResponse.Status.SERVER_ERROR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, status_);
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
    if (!(obj instanceof com.example.marspioneer.proto.UpdateStateResponse)) {
      return super.equals(obj);
    }
    com.example.marspioneer.proto.UpdateStateResponse other = (com.example.marspioneer.proto.UpdateStateResponse) obj;

    if (hasPartialState() != other.hasPartialState()) return false;
    if (hasPartialState()) {
      if (!getPartialState()
          .equals(other.getPartialState())) return false;
    }
    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (status_ != other.status_) return false;
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
    if (hasPartialState()) {
      hash = (37 * hash) + PARTIALSTATE_FIELD_NUMBER;
      hash = (53 * hash) + getPartialState().hashCode();
    }
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.marspioneer.proto.UpdateStateResponse parseFrom(
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
  public static Builder newBuilder(com.example.marspioneer.proto.UpdateStateResponse prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.UpdateStateResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.UpdateStateResponse)
      com.example.marspioneer.proto.UpdateStateResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.marspioneer.proto.UpdateStateResponse.class, com.example.marspioneer.proto.UpdateStateResponse.Builder.class);
    }

    // Construct using com.example.marspioneer.proto.UpdateStateResponse.newBuilder()
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
      if (partialStateBuilder_ == null) {
        partialState_ = null;
      } else {
        partialState_ = null;
        partialStateBuilder_ = null;
      }
      message_ = "";

      status_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.marspioneer.proto.MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateResponse_descriptor;
    }

    @java.lang.Override
    public com.example.marspioneer.proto.UpdateStateResponse getDefaultInstanceForType() {
      return com.example.marspioneer.proto.UpdateStateResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.marspioneer.proto.UpdateStateResponse build() {
      com.example.marspioneer.proto.UpdateStateResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.marspioneer.proto.UpdateStateResponse buildPartial() {
      com.example.marspioneer.proto.UpdateStateResponse result = new com.example.marspioneer.proto.UpdateStateResponse(this);
      if (partialStateBuilder_ == null) {
        result.partialState_ = partialState_;
      } else {
        result.partialState_ = partialStateBuilder_.build();
      }
      result.message_ = message_;
      result.status_ = status_;
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
      if (other instanceof com.example.marspioneer.proto.UpdateStateResponse) {
        return mergeFrom((com.example.marspioneer.proto.UpdateStateResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.marspioneer.proto.UpdateStateResponse other) {
      if (other == com.example.marspioneer.proto.UpdateStateResponse.getDefaultInstance()) return this;
      if (other.hasPartialState()) {
        mergePartialState(other.getPartialState());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
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
      com.example.marspioneer.proto.UpdateStateResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.marspioneer.proto.UpdateStateResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.example.marspioneer.proto.MPPartialStateProto partialState_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.marspioneer.proto.MPPartialStateProto, com.example.marspioneer.proto.MPPartialStateProto.Builder, com.example.marspioneer.proto.MPPartialStateProtoOrBuilder> partialStateBuilder_;
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     * @return Whether the partialState field is set.
     */
    public boolean hasPartialState() {
      return partialStateBuilder_ != null || partialState_ != null;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     * @return The partialState.
     */
    public com.example.marspioneer.proto.MPPartialStateProto getPartialState() {
      if (partialStateBuilder_ == null) {
        return partialState_ == null ? com.example.marspioneer.proto.MPPartialStateProto.getDefaultInstance() : partialState_;
      } else {
        return partialStateBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public Builder setPartialState(com.example.marspioneer.proto.MPPartialStateProto value) {
      if (partialStateBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        partialState_ = value;
        onChanged();
      } else {
        partialStateBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public Builder setPartialState(
        com.example.marspioneer.proto.MPPartialStateProto.Builder builderForValue) {
      if (partialStateBuilder_ == null) {
        partialState_ = builderForValue.build();
        onChanged();
      } else {
        partialStateBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public Builder mergePartialState(com.example.marspioneer.proto.MPPartialStateProto value) {
      if (partialStateBuilder_ == null) {
        if (partialState_ != null) {
          partialState_ =
            com.example.marspioneer.proto.MPPartialStateProto.newBuilder(partialState_).mergeFrom(value).buildPartial();
        } else {
          partialState_ = value;
        }
        onChanged();
      } else {
        partialStateBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public Builder clearPartialState() {
      if (partialStateBuilder_ == null) {
        partialState_ = null;
        onChanged();
      } else {
        partialState_ = null;
        partialStateBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public com.example.marspioneer.proto.MPPartialStateProto.Builder getPartialStateBuilder() {
      
      onChanged();
      return getPartialStateFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public com.example.marspioneer.proto.MPPartialStateProtoOrBuilder getPartialStateOrBuilder() {
      if (partialStateBuilder_ != null) {
        return partialStateBuilder_.getMessageOrBuilder();
      } else {
        return partialState_ == null ?
            com.example.marspioneer.proto.MPPartialStateProto.getDefaultInstance() : partialState_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.example.marspioneer.proto.MPPartialStateProto, com.example.marspioneer.proto.MPPartialStateProto.Builder, com.example.marspioneer.proto.MPPartialStateProtoOrBuilder> 
        getPartialStateFieldBuilder() {
      if (partialStateBuilder_ == null) {
        partialStateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.example.marspioneer.proto.MPPartialStateProto, com.example.marspioneer.proto.MPPartialStateProto.Builder, com.example.marspioneer.proto.MPPartialStateProtoOrBuilder>(
                getPartialState(),
                getParentForChildren(),
                isClean());
        partialState_ = null;
      }
      return partialStateBuilder_;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 2;</code>
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.com.example.marspioneer.proto.UpdateStateResponse.Status status = 3;</code>
     * @return The enum numeric value on the wire for status.
     */
    @java.lang.Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.com.example.marspioneer.proto.UpdateStateResponse.Status status = 3;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.UpdateStateResponse.Status status = 3;</code>
     * @return The status.
     */
    @java.lang.Override
    public com.example.marspioneer.proto.UpdateStateResponse.Status getStatus() {
      @SuppressWarnings("deprecation")
      com.example.marspioneer.proto.UpdateStateResponse.Status result = com.example.marspioneer.proto.UpdateStateResponse.Status.valueOf(status_);
      return result == null ? com.example.marspioneer.proto.UpdateStateResponse.Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.example.marspioneer.proto.UpdateStateResponse.Status status = 3;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(com.example.marspioneer.proto.UpdateStateResponse.Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.UpdateStateResponse.Status status = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.UpdateStateResponse)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.UpdateStateResponse)
  private static final com.example.marspioneer.proto.UpdateStateResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.marspioneer.proto.UpdateStateResponse();
  }

  public static com.example.marspioneer.proto.UpdateStateResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateStateResponse>
      PARSER = new com.google.protobuf.AbstractParser<UpdateStateResponse>() {
    @java.lang.Override
    public UpdateStateResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateStateResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateStateResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateStateResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.marspioneer.proto.UpdateStateResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

