// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface CreatePlayerResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.CreatePlayerResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string message = 1;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 1;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.com.example.marspioneer.proto.MPPlayerProto player = 2;</code>
   * @return Whether the player field is set.
   */
  boolean hasPlayer();
  /**
   * <code>.com.example.marspioneer.proto.MPPlayerProto player = 2;</code>
   * @return The player.
   */
  com.example.marspioneer.proto.MPPlayerProto getPlayer();
  /**
   * <code>.com.example.marspioneer.proto.MPPlayerProto player = 2;</code>
   */
  com.example.marspioneer.proto.MPPlayerProtoOrBuilder getPlayerOrBuilder();

  /**
   * <code>.com.example.marspioneer.proto.CreatePlayerResponse.Status status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.com.example.marspioneer.proto.CreatePlayerResponse.Status status = 3;</code>
   * @return The status.
   */
  com.example.marspioneer.proto.CreatePlayerResponse.Status getStatus();
}
