// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.SubscribeResponse}
 */
public final class SubscribeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.SubscribeResponse)
    SubscribeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SubscribeResponse.newBuilder() to construct.
  private SubscribeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SubscribeResponse() {
    message_ = "";
    status_ = 0;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new SubscribeResponse();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SubscribeResponse(
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
            MPPartialStateProto.Builder subBuilder = null;
            if (partialState_ != null) {
              subBuilder = partialState_.toBuilder();
            }
            partialState_ = input.readMessage(MPPartialStateProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(partialState_);
              partialState_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_SubscribeResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_SubscribeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            SubscribeResponse.class, Builder.class);
  }

  /**
   * Protobuf enum {@code com.example.marspioneer.proto.SubscribeResponse.Status}
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
        throw new IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
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
        throw new IllegalStateException(
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
      return SubscribeResponse.getDescriptor().getEnumTypes().get(0);
    }

    private static final Status[] VALUES = values();

    public static Status valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
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

    // @@protoc_insertion_point(enum_scope:com.example.marspioneer.proto.SubscribeResponse.Status)
  }

  public static final int PARTIALSTATE_FIELD_NUMBER = 1;
  private MPPartialStateProto partialState_;
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   * @return Whether the partialState field is set.
   */
  @Override
  public boolean hasPartialState() {
    return partialState_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   * @return The partialState.
   */
  @Override
  public MPPartialStateProto getPartialState() {
    return partialState_ == null ? MPPartialStateProto.getDefaultInstance() : partialState_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   */
  @Override
  public MPPartialStateProtoOrBuilder getPartialStateOrBuilder() {
    return getPartialState();
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile Object message_;
  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  @Override
  public String getMessage() {
    Object ref = message_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  @Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    Object ref = message_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 3;
  private int status_;
  /**
   * <code>.com.example.marspioneer.proto.SubscribeResponse.Status status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  @Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.com.example.marspioneer.proto.SubscribeResponse.Status status = 3;</code>
   * @return The status.
   */
  @Override public Status getStatus() {
    @SuppressWarnings("deprecation")
    Status result = Status.valueOf(status_);
    return result == null ? Status.UNRECOGNIZED : result;
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
    if (partialState_ != null) {
      output.writeMessage(1, getPartialState());
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    if (status_ != Status.SERVER_ERROR.getNumber()) {
      output.writeEnum(3, status_);
    }
    unknownFields.writeTo(output);
  }

  @Override
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
    if (status_ != Status.SERVER_ERROR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, status_);
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
    if (!(obj instanceof SubscribeResponse)) {
      return super.equals(obj);
    }
    SubscribeResponse other = (SubscribeResponse) obj;

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

  @Override
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

  public static SubscribeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SubscribeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SubscribeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SubscribeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SubscribeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static SubscribeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static SubscribeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SubscribeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static SubscribeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static SubscribeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static SubscribeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static SubscribeResponse parseFrom(
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
  public static Builder newBuilder(SubscribeResponse prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.SubscribeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.SubscribeResponse)
      SubscribeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_SubscribeResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_SubscribeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              SubscribeResponse.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.SubscribeResponse.newBuilder()
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

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_SubscribeResponse_descriptor;
    }

    @Override
    public SubscribeResponse getDefaultInstanceForType() {
      return SubscribeResponse.getDefaultInstance();
    }

    @Override
    public SubscribeResponse build() {
      SubscribeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public SubscribeResponse buildPartial() {
      SubscribeResponse result = new SubscribeResponse(this);
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
      if (other instanceof SubscribeResponse) {
        return mergeFrom((SubscribeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(SubscribeResponse other) {
      if (other == SubscribeResponse.getDefaultInstance()) return this;
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

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      SubscribeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (SubscribeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private MPPartialStateProto partialState_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MPPartialStateProto, MPPartialStateProto.Builder, MPPartialStateProtoOrBuilder> partialStateBuilder_;
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
    public MPPartialStateProto getPartialState() {
      if (partialStateBuilder_ == null) {
        return partialState_ == null ? MPPartialStateProto.getDefaultInstance() : partialState_;
      } else {
        return partialStateBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public Builder setPartialState(MPPartialStateProto value) {
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
        MPPartialStateProto.Builder builderForValue) {
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
    public Builder mergePartialState(MPPartialStateProto value) {
      if (partialStateBuilder_ == null) {
        if (partialState_ != null) {
          partialState_ =
            MPPartialStateProto.newBuilder(partialState_).mergeFrom(value).buildPartial();
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
    public MPPartialStateProto.Builder getPartialStateBuilder() {
      
      onChanged();
      return getPartialStateFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    public MPPartialStateProtoOrBuilder getPartialStateOrBuilder() {
      if (partialStateBuilder_ != null) {
        return partialStateBuilder_.getMessageOrBuilder();
      } else {
        return partialState_ == null ?
            MPPartialStateProto.getDefaultInstance() : partialState_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MPPartialStateProto, MPPartialStateProto.Builder, MPPartialStateProtoOrBuilder>
        getPartialStateFieldBuilder() {
      if (partialStateBuilder_ == null) {
        partialStateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MPPartialStateProto, MPPartialStateProto.Builder, MPPartialStateProtoOrBuilder>(
                getPartialState(),
                getParentForChildren(),
                isClean());
        partialState_ = null;
      }
      return partialStateBuilder_;
    }

    private Object message_ = "";
    /**
     * <code>string message = 2;</code>
     * @return The message.
     */
    public String getMessage() {
      Object ref = message_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
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
        String value) {
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
     * <code>.com.example.marspioneer.proto.SubscribeResponse.Status status = 3;</code>
     * @return The enum numeric value on the wire for status.
     */
    @Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.com.example.marspioneer.proto.SubscribeResponse.Status status = 3;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.SubscribeResponse.Status status = 3;</code>
     * @return The status.
     */
    @Override
    public Status getStatus() {
      @SuppressWarnings("deprecation")
      Status result = Status.valueOf(status_);
      return result == null ? Status.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.example.marspioneer.proto.SubscribeResponse.Status status = 3;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(Status value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.SubscribeResponse.Status status = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.SubscribeResponse)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.SubscribeResponse)
  private static final SubscribeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new SubscribeResponse();
  }

  public static SubscribeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SubscribeResponse>
      PARSER = new com.google.protobuf.AbstractParser<SubscribeResponse>() {
    @Override
    public SubscribeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SubscribeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SubscribeResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<SubscribeResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public SubscribeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

