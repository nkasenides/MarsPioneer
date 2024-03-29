// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf type {@code com.example.marspioneer.proto.UpdateStateRequest}
 */
public final class UpdateStateRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.marspioneer.proto.UpdateStateRequest)
    UpdateStateRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateStateRequest.newBuilder() to construct.
  private UpdateStateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateStateRequest() {
    worldSessionID_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateStateRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateStateRequest(
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

            worldSessionID_ = s;
            break;
          }
          case 26: {
            MPActionProto.Builder subBuilder = null;
            if (action_ != null) {
              subBuilder = action_.toBuilder();
            }
            action_ = input.readMessage(MPActionProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(action_);
              action_ = subBuilder.buildPartial();
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
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            UpdateStateRequest.class, Builder.class);
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

  public static final int WORLDSESSIONID_FIELD_NUMBER = 2;
  private volatile Object worldSessionID_;
  /**
   * <code>string worldSessionID = 2;</code>
   * @return The worldSessionID.
   */
  @Override
  public String getWorldSessionID() {
    Object ref = worldSessionID_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      worldSessionID_ = s;
      return s;
    }
  }
  /**
   * <code>string worldSessionID = 2;</code>
   * @return The bytes for worldSessionID.
   */
  @Override
  public com.google.protobuf.ByteString
      getWorldSessionIDBytes() {
    Object ref = worldSessionID_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      worldSessionID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACTION_FIELD_NUMBER = 3;
  private MPActionProto action_;
  /**
   * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
   * @return Whether the action field is set.
   */
  @Override
  public boolean hasAction() {
    return action_ != null;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
   * @return The action.
   */
  @Override
  public MPActionProto getAction() {
    return action_ == null ? MPActionProto.getDefaultInstance() : action_;
  }
  /**
   * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
   */
  @Override
  public MPActionProtoOrBuilder getActionOrBuilder() {
    return getAction();
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
    if (!getWorldSessionIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, worldSessionID_);
    }
    if (action_ != null) {
      output.writeMessage(3, getAction());
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
    if (!getWorldSessionIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, worldSessionID_);
    }
    if (action_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getAction());
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
    if (!(obj instanceof UpdateStateRequest)) {
      return super.equals(obj);
    }
    UpdateStateRequest other = (UpdateStateRequest) obj;

    if (hasPartialState() != other.hasPartialState()) return false;
    if (hasPartialState()) {
      if (!getPartialState()
          .equals(other.getPartialState())) return false;
    }
    if (!getWorldSessionID()
        .equals(other.getWorldSessionID())) return false;
    if (hasAction() != other.hasAction()) return false;
    if (hasAction()) {
      if (!getAction()
          .equals(other.getAction())) return false;
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
    if (hasPartialState()) {
      hash = (37 * hash) + PARTIALSTATE_FIELD_NUMBER;
      hash = (53 * hash) + getPartialState().hashCode();
    }
    hash = (37 * hash) + WORLDSESSIONID_FIELD_NUMBER;
    hash = (53 * hash) + getWorldSessionID().hashCode();
    if (hasAction()) {
      hash = (37 * hash) + ACTION_FIELD_NUMBER;
      hash = (53 * hash) + getAction().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static UpdateStateRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateStateRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateStateRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateStateRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateStateRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static UpdateStateRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static UpdateStateRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UpdateStateRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static UpdateStateRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static UpdateStateRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static UpdateStateRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static UpdateStateRequest parseFrom(
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
  public static Builder newBuilder(UpdateStateRequest prototype) {
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
   * Protobuf type {@code com.example.marspioneer.proto.UpdateStateRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.marspioneer.proto.UpdateStateRequest)
      UpdateStateRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              UpdateStateRequest.class, Builder.class);
    }

    // Construct using com.example.marspioneer.proto.UpdateStateRequest.newBuilder()
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
      worldSessionID_ = "";

      if (actionBuilder_ == null) {
        action_ = null;
      } else {
        action_ = null;
        actionBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return MarsPioneerProto.internal_static_com_example_marspioneer_proto_UpdateStateRequest_descriptor;
    }

    @Override
    public UpdateStateRequest getDefaultInstanceForType() {
      return UpdateStateRequest.getDefaultInstance();
    }

    @Override
    public UpdateStateRequest build() {
      UpdateStateRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public UpdateStateRequest buildPartial() {
      UpdateStateRequest result = new UpdateStateRequest(this);
      if (partialStateBuilder_ == null) {
        result.partialState_ = partialState_;
      } else {
        result.partialState_ = partialStateBuilder_.build();
      }
      result.worldSessionID_ = worldSessionID_;
      if (actionBuilder_ == null) {
        result.action_ = action_;
      } else {
        result.action_ = actionBuilder_.build();
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
      if (other instanceof UpdateStateRequest) {
        return mergeFrom((UpdateStateRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(UpdateStateRequest other) {
      if (other == UpdateStateRequest.getDefaultInstance()) return this;
      if (other.hasPartialState()) {
        mergePartialState(other.getPartialState());
      }
      if (!other.getWorldSessionID().isEmpty()) {
        worldSessionID_ = other.worldSessionID_;
        onChanged();
      }
      if (other.hasAction()) {
        mergeAction(other.getAction());
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
      UpdateStateRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (UpdateStateRequest) e.getUnfinishedMessage();
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

    private Object worldSessionID_ = "";
    /**
     * <code>string worldSessionID = 2;</code>
     * @return The worldSessionID.
     */
    public String getWorldSessionID() {
      Object ref = worldSessionID_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        worldSessionID_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @return The bytes for worldSessionID.
     */
    public com.google.protobuf.ByteString
        getWorldSessionIDBytes() {
      Object ref = worldSessionID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        worldSessionID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @param value The worldSessionID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldSessionID(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      worldSessionID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearWorldSessionID() {
      
      worldSessionID_ = getDefaultInstance().getWorldSessionID();
      onChanged();
      return this;
    }
    /**
     * <code>string worldSessionID = 2;</code>
     * @param value The bytes for worldSessionID to set.
     * @return This builder for chaining.
     */
    public Builder setWorldSessionIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      worldSessionID_ = value;
      onChanged();
      return this;
    }

    private MPActionProto action_;
    private com.google.protobuf.SingleFieldBuilderV3<
        MPActionProto, MPActionProto.Builder, MPActionProtoOrBuilder> actionBuilder_;
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     * @return Whether the action field is set.
     */
    public boolean hasAction() {
      return actionBuilder_ != null || action_ != null;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     * @return The action.
     */
    public MPActionProto getAction() {
      if (actionBuilder_ == null) {
        return action_ == null ? MPActionProto.getDefaultInstance() : action_;
      } else {
        return actionBuilder_.getMessage();
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     */
    public Builder setAction(MPActionProto value) {
      if (actionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        action_ = value;
        onChanged();
      } else {
        actionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     */
    public Builder setAction(
        MPActionProto.Builder builderForValue) {
      if (actionBuilder_ == null) {
        action_ = builderForValue.build();
        onChanged();
      } else {
        actionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     */
    public Builder mergeAction(MPActionProto value) {
      if (actionBuilder_ == null) {
        if (action_ != null) {
          action_ =
            MPActionProto.newBuilder(action_).mergeFrom(value).buildPartial();
        } else {
          action_ = value;
        }
        onChanged();
      } else {
        actionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     */
    public Builder clearAction() {
      if (actionBuilder_ == null) {
        action_ = null;
        onChanged();
      } else {
        action_ = null;
        actionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     */
    public MPActionProto.Builder getActionBuilder() {
      
      onChanged();
      return getActionFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     */
    public MPActionProtoOrBuilder getActionOrBuilder() {
      if (actionBuilder_ != null) {
        return actionBuilder_.getMessageOrBuilder();
      } else {
        return action_ == null ?
            MPActionProto.getDefaultInstance() : action_;
      }
    }
    /**
     * <code>.com.example.marspioneer.proto.MPActionProto action = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        MPActionProto, MPActionProto.Builder, MPActionProtoOrBuilder>
        getActionFieldBuilder() {
      if (actionBuilder_ == null) {
        actionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            MPActionProto, MPActionProto.Builder, MPActionProtoOrBuilder>(
                getAction(),
                getParentForChildren(),
                isClean());
        action_ = null;
      }
      return actionBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.example.marspioneer.proto.UpdateStateRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.marspioneer.proto.UpdateStateRequest)
  private static final UpdateStateRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new UpdateStateRequest();
  }

  public static UpdateStateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateStateRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateStateRequest>() {
    @Override
    public UpdateStateRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateStateRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateStateRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<UpdateStateRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public UpdateStateRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

