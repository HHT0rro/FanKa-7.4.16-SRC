package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import u7.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum FieldBehavior implements ProtocolMessageEnum {
    FIELD_BEHAVIOR_UNSPECIFIED(0),
    OPTIONAL(1),
    REQUIRED(2),
    OUTPUT_ONLY(3),
    INPUT_ONLY(4),
    IMMUTABLE(5),
    UNORDERED_LIST(6),
    NON_EMPTY_DEFAULT(7),
    UNRECOGNIZED(-1);

    public static final int FIELD_BEHAVIOR_UNSPECIFIED_VALUE = 0;
    public static final int IMMUTABLE_VALUE = 5;
    public static final int INPUT_ONLY_VALUE = 4;
    public static final int NON_EMPTY_DEFAULT_VALUE = 7;
    public static final int OPTIONAL_VALUE = 1;
    public static final int OUTPUT_ONLY_VALUE = 3;
    public static final int REQUIRED_VALUE = 2;
    public static final int UNORDERED_LIST_VALUE = 6;
    private final int value;
    private static final Internal.EnumLiteMap<FieldBehavior> internalValueMap = new Internal.EnumLiteMap<FieldBehavior>() { // from class: com.google.api.FieldBehavior.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FieldBehavior findValueByNumber(int i10) {
            return FieldBehavior.forNumber(i10);
        }
    };
    private static final FieldBehavior[] VALUES = values();

    FieldBehavior(int i10) {
        this.value = i10;
    }

    public static FieldBehavior forNumber(int i10) {
        switch (i10) {
            case 0:
                return FIELD_BEHAVIOR_UNSPECIFIED;
            case 1:
                return OPTIONAL;
            case 2:
                return REQUIRED;
            case 3:
                return OUTPUT_ONLY;
            case 4:
                return INPUT_ONLY;
            case 5:
                return IMMUTABLE;
            case 6:
                return UNORDERED_LIST;
            case 7:
                return NON_EMPTY_DEFAULT;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return n.a().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<FieldBehavior> internalGetValueMap() {
        return internalValueMap;
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // com.google.protobuf.ProtocolMessageEnum
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this != UNRECOGNIZED) {
            return getDescriptor().getValues().get(ordinal());
        }
        throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }

    @Deprecated
    public static FieldBehavior valueOf(int i10) {
        return forNumber(i10);
    }

    public static FieldBehavior valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
