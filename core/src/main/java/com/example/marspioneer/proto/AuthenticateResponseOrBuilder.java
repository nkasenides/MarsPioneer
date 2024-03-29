// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface AuthenticateResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.AuthenticateResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string message = 1;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <code>string message = 1;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSession = 2;</code>
   * @return Whether the gameSession field is set.
   */
  boolean hasGameSession();
  /**
   * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSession = 2;</code>
   * @return The gameSession.
   */
  MPGameSessionProto getGameSession();
  /**
   * <code>.com.example.marspioneer.proto.MPGameSessionProto gameSession = 2;</code>
   */
  MPGameSessionProtoOrBuilder getGameSessionOrBuilder();

  /**
   * <code>.com.example.marspioneer.proto.AuthenticateResponse.Status status = 3;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.com.example.marspioneer.proto.AuthenticateResponse.Status status = 3;</code>
   * @return The status.
   */
  AuthenticateResponse.Status getStatus();
}
