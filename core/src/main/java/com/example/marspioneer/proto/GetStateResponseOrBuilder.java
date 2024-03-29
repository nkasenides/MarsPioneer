// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface GetStateResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.GetStateResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   * @return Whether the partialState field is set.
   */
  boolean hasPartialState();
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   * @return The partialState.
   */
  MPPartialStateProto getPartialState();
  /**
   * <code>.com.example.marspioneer.proto.MPPartialStateProto partialState = 1;</code>
   */
  MPPartialStateProtoOrBuilder getPartialStateOrBuilder();

  /**
   * <code>.com.example.marspioneer.proto.ResourceSetProto resourceSet = 2;</code>
   * @return Whether the resourceSet field is set.
   */
  boolean hasResourceSet();
  /**
   * <code>.com.example.marspioneer.proto.ResourceSetProto resourceSet = 2;</code>
   * @return The resourceSet.
   */
  ResourceSetProto getResourceSet();
  /**
   * <code>.com.example.marspioneer.proto.ResourceSetProto resourceSet = 2;</code>
   */
  ResourceSetProtoOrBuilder getResourceSetOrBuilder();

  /**
   * <code>string message = 3;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <code>string message = 3;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.com.example.marspioneer.proto.GetStateResponse.Status status = 4;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.com.example.marspioneer.proto.GetStateResponse.Status status = 4;</code>
   * @return The status.
   */
  GetStateResponse.Status getStatus();
}
