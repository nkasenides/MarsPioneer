// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface BuildWellRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.BuildWellRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string worldSessionID = 1;</code>
   * @return The worldSessionID.
   */
  String getWorldSessionID();
  /**
   * <code>string worldSessionID = 1;</code>
   * @return The bytes for worldSessionID.
   */
  com.google.protobuf.ByteString
      getWorldSessionIDBytes();

  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto position = 2;</code>
   * @return Whether the position field is set.
   */
  boolean hasPosition();
  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto position = 2;</code>
   * @return The position.
   */
  MatrixPositionProto getPosition();
  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto position = 2;</code>
   */
  MatrixPositionProtoOrBuilder getPositionOrBuilder();
}
