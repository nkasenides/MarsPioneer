// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface GetWorldResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.GetWorldResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 1;</code>
   * @return Whether the world field is set.
   */
  boolean hasWorld();
  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 1;</code>
   * @return The world.
   */
  MPWorldProto getWorld();
  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 1;</code>
   */
  MPWorldProtoOrBuilder getWorldOrBuilder();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.com.example.marspioneer.proto.GetWorldResponse.Status status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.com.example.marspioneer.proto.GetWorldResponse.Status status = 3;</code>
   * @return The status.
   */
  GetWorldResponse.Status getStatus();
}
