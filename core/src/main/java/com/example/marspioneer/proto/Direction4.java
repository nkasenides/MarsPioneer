// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf enum {@code com.example.marspioneer.proto.Direction4}
 */
public enum Direction4
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NORTH = 0;</code>
   */
  NORTH(0),
  /**
   * <code>EAST = 1;</code>
   */
  EAST(1),
  /**
   * <code>SOUTH = 2;</code>
   */
  SOUTH(2),
  /**
   * <code>WEST = 3;</code>
   */
  WEST(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NORTH = 0;</code>
   */
  public static final int NORTH_VALUE = 0;
  /**
   * <code>EAST = 1;</code>
   */
  public static final int EAST_VALUE = 1;
  /**
   * <code>SOUTH = 2;</code>
   */
  public static final int SOUTH_VALUE = 2;
  /**
   * <code>WEST = 3;</code>
   */
  public static final int WEST_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Direction4 valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Direction4 forNumber(int value) {
    switch (value) {
      case 0: return NORTH;
      case 1: return EAST;
      case 2: return SOUTH;
      case 3: return WEST;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Direction4>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Direction4> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Direction4>() {
          public Direction4 findValueByNumber(int number) {
            return Direction4.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.example.marspioneer.proto.MarsPioneerProto.getDescriptor().getEnumTypes().get(7);
  }

  private static final Direction4[] VALUES = values();

  public static Direction4 valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Direction4(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.example.marspioneer.proto.Direction4)
}

