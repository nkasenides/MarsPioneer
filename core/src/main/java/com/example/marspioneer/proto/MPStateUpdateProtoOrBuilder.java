// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

public interface MPStateUpdateProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.marspioneer.proto.MPStateUpdateProto)
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
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; updatedTerrainCells = 2;</code>
   */
  int getUpdatedTerrainCellsCount();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; updatedTerrainCells = 2;</code>
   */
  boolean containsUpdatedTerrainCells(
      String key);
  /**
   * Use {@link #getUpdatedTerrainCellsMap()} instead.
   */
  @Deprecated
  java.util.Map<String, MPTerrainCellProto>
  getUpdatedTerrainCells();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; updatedTerrainCells = 2;</code>
   */
  java.util.Map<String, MPTerrainCellProto>
  getUpdatedTerrainCellsMap();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; updatedTerrainCells = 2;</code>
   */

  MPTerrainCellProto getUpdatedTerrainCellsOrDefault(
      String key,
      MPTerrainCellProto defaultValue);
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; updatedTerrainCells = 2;</code>
   */

  MPTerrainCellProto getUpdatedTerrainCellsOrThrow(
      String key);

  /**
   * <code>repeated string removedEntities = 3;</code>
   * @return A list containing the removedEntities.
   */
  java.util.List<String>
      getRemovedEntitiesList();
  /**
   * <code>repeated string removedEntities = 3;</code>
   * @return The count of removedEntities.
   */
  int getRemovedEntitiesCount();
  /**
   * <code>repeated string removedEntities = 3;</code>
   * @param index The index of the element to return.
   * @return The removedEntities at the given index.
   */
  String getRemovedEntities(int index);
  /**
   * <code>repeated string removedEntities = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the removedEntities at the given index.
   */
  com.google.protobuf.ByteString
      getRemovedEntitiesBytes(int index);

  /**
   * <code>repeated string removedTerrainCells = 4;</code>
   * @return A list containing the removedTerrainCells.
   */
  java.util.List<String>
      getRemovedTerrainCellsList();
  /**
   * <code>repeated string removedTerrainCells = 4;</code>
   * @return The count of removedTerrainCells.
   */
  int getRemovedTerrainCellsCount();
  /**
   * <code>repeated string removedTerrainCells = 4;</code>
   * @param index The index of the element to return.
   * @return The removedTerrainCells at the given index.
   */
  String getRemovedTerrainCells(int index);
  /**
   * <code>repeated string removedTerrainCells = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the removedTerrainCells at the given index.
   */
  com.google.protobuf.ByteString
      getRemovedTerrainCellsBytes(int index);

  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; newTerrainCells = 5;</code>
   */
  int getNewTerrainCellsCount();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; newTerrainCells = 5;</code>
   */
  boolean containsNewTerrainCells(
      String key);
  /**
   * Use {@link #getNewTerrainCellsMap()} instead.
   */
  @Deprecated
  java.util.Map<String, MPTerrainCellProto>
  getNewTerrainCells();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; newTerrainCells = 5;</code>
   */
  java.util.Map<String, MPTerrainCellProto>
  getNewTerrainCellsMap();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; newTerrainCells = 5;</code>
   */

  MPTerrainCellProto getNewTerrainCellsOrDefault(
      String key,
      MPTerrainCellProto defaultValue);
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPTerrainCellProto&gt; newTerrainCells = 5;</code>
   */

  MPTerrainCellProto getNewTerrainCellsOrThrow(
      String key);

  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; newEntities = 6;</code>
   */
  int getNewEntitiesCount();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; newEntities = 6;</code>
   */
  boolean containsNewEntities(
      String key);
  /**
   * Use {@link #getNewEntitiesMap()} instead.
   */
  @Deprecated
  java.util.Map<String, MPEntityProto>
  getNewEntities();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; newEntities = 6;</code>
   */
  java.util.Map<String, MPEntityProto>
  getNewEntitiesMap();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; newEntities = 6;</code>
   */

  MPEntityProto getNewEntitiesOrDefault(
      String key,
      MPEntityProto defaultValue);
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; newEntities = 6;</code>
   */

  MPEntityProto getNewEntitiesOrThrow(
      String key);

  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; updatedEntities = 7;</code>
   */
  int getUpdatedEntitiesCount();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; updatedEntities = 7;</code>
   */
  boolean containsUpdatedEntities(
      String key);
  /**
   * Use {@link #getUpdatedEntitiesMap()} instead.
   */
  @Deprecated
  java.util.Map<String, MPEntityProto>
  getUpdatedEntities();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; updatedEntities = 7;</code>
   */
  java.util.Map<String, MPEntityProto>
  getUpdatedEntitiesMap();
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; updatedEntities = 7;</code>
   */

  MPEntityProto getUpdatedEntitiesOrDefault(
      String key,
      MPEntityProto defaultValue);
  /**
   * <code>map&lt;string, .com.example.marspioneer.proto.MPEntityProto&gt; updatedEntities = 7;</code>
   */

  MPEntityProto getUpdatedEntitiesOrThrow(
      String key);

  /**
   * <code>uint64 timestamp = 8;</code>
   * @return The timestamp.
   */
  long getTimestamp();
}