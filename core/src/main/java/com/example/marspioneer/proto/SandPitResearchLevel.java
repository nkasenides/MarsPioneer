// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/MarsPioneerProto.proto

package com.example.marspioneer.proto;

/**
 * Protobuf enum {@code com.example.marspioneer.proto.SandPitResearchLevel}
 */
public enum SandPitResearchLevel
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>LEVEL_1_SandPitResearchLevel = 0;</code>
   */
  LEVEL_1_SandPitResearchLevel(0),
  /**
   * <code>LEVEL_2_SandPitResearchLevel = 1;</code>
   */
  LEVEL_2_SandPitResearchLevel(1),
  /**
   * <code>LEVEL_3_SandPitResearchLevel = 2;</code>
   */
  LEVEL_3_SandPitResearchLevel(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>LEVEL_1_SandPitResearchLevel = 0;</code>
   */
  public static final int LEVEL_1_SandPitResearchLevel_VALUE = 0;
  /**
   * <code>LEVEL_2_SandPitResearchLevel = 1;</code>
   */
  public static final int LEVEL_2_SandPitResearchLevel_VALUE = 1;
  /**
   * <code>LEVEL_3_SandPitResearchLevel = 2;</code>
   */
  public static final int LEVEL_3_SandPitResearchLevel_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @Deprecated
  public static SandPitResearchLevel valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static SandPitResearchLevel forNumber(int value) {
    switch (value) {
      case 0: return LEVEL_1_SandPitResearchLevel;
      case 1: return LEVEL_2_SandPitResearchLevel;
      case 2: return LEVEL_3_SandPitResearchLevel;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SandPitResearchLevel>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SandPitResearchLevel> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SandPitResearchLevel>() {
          public SandPitResearchLevel findValueByNumber(int number) {
            return SandPitResearchLevel.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new IllegalStateException(
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
    return MarsPioneerProto.getDescriptor().getEnumTypes().get(6);
  }

  private static final SandPitResearchLevel[] VALUES = values();

  public static SandPitResearchLevel valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private SandPitResearchLevel(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.example.marspioneer.proto.SandPitResearchLevel)
}

