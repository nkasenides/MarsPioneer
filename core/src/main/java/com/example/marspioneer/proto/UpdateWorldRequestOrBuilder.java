// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface UpdateWorldRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.UpdateWorldRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string gameSessionID = 1;</code>
   * @return The gameSessionID.
   */
  String getGameSessionID();
  /**
   * <code>string gameSessionID = 1;</code>
   * @return The bytes for gameSessionID.
   */
  com.google.protobuf.ByteString
      getGameSessionIDBytes();

  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
   * @return Whether the world field is set.
   */
  boolean hasWorld();
  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
   * @return The world.
   */
  MPWorldProto getWorld();
  /**
   * <code>.com.example.marspioneer.proto.MPWorldProto world = 2;</code>
   */
  MPWorldProtoOrBuilder getWorldOrBuilder();
}
