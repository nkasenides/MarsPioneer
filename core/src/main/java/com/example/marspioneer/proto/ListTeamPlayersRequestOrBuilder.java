// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface ListTeamPlayersRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.ListTeamPlayersRequest)
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
   * <code>string teamID = 2;</code>
   * @return The teamID.
   */
  String getTeamID();
  /**
   * <code>string teamID = 2;</code>
   * @return The bytes for teamID.
   */
  com.google.protobuf.ByteString
      getTeamIDBytes();
}
