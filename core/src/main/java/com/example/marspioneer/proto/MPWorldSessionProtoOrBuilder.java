// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface MPWorldSessionProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.MPWorldSessionProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string worldID = 1;</code>
   * @return The worldID.
   */
  String getWorldID();
  /**
   * <code>string worldID = 1;</code>
   * @return The bytes for worldID.
   */
  com.google.protobuf.ByteString
      getWorldIDBytes();

  /**
   * <code>string ipAddress = 2;</code>
   * @return The ipAddress.
   */
  String getIpAddress();
  /**
   * <code>string ipAddress = 2;</code>
   * @return The bytes for ipAddress.
   */
  com.google.protobuf.ByteString
      getIpAddressBytes();

  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto cameraPosition = 3;</code>
   * @return Whether the cameraPosition field is set.
   */
  boolean hasCameraPosition();
  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto cameraPosition = 3;</code>
   * @return The cameraPosition.
   */
  MatrixPositionProto getCameraPosition();
  /**
   * <code>.com.example.marspioneer.proto.MatrixPositionProto cameraPosition = 3;</code>
   */
  MatrixPositionProtoOrBuilder getCameraPositionOrBuilder();

  /**
   * <code>uint64 expiresOn = 4;</code>
   * @return The expiresOn.
   */
  long getExpiresOn();

  /**
   * <code>string id = 5;</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 5;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>uint64 createdOn = 6;</code>
   * @return The createdOn.
   */
  long getCreatedOn();

  /**
   * <code>string playerID = 7;</code>
   * @return The playerID.
   */
  String getPlayerID();
  /**
   * <code>string playerID = 7;</code>
   * @return The bytes for playerID.
   */
  com.google.protobuf.ByteString
      getPlayerIDBytes();
}
