package com.google.rpc;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum Code implements ProtocolMessageEnum {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    UNAUTHENTICATED(16),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNRECOGNIZED(-1);

    public static final int ABORTED_VALUE = 10;
    public static final int ALREADY_EXISTS_VALUE = 6;
    public static final int CANCELLED_VALUE = 1;
    public static final int DATA_LOSS_VALUE = 15;
    public static final int DEADLINE_EXCEEDED_VALUE = 4;
    public static final int FAILED_PRECONDITION_VALUE = 9;
    public static final int INTERNAL_VALUE = 13;
    public static final int INVALID_ARGUMENT_VALUE = 3;
    public static final int NOT_FOUND_VALUE = 5;
    public static final int OK_VALUE = 0;
    public static final int OUT_OF_RANGE_VALUE = 11;
    public static final int PERMISSION_DENIED_VALUE = 7;
    public static final int RESOURCE_EXHAUSTED_VALUE = 8;
    public static final int UNAUTHENTICATED_VALUE = 16;
    public static final int UNAVAILABLE_VALUE = 14;
    public static final int UNIMPLEMENTED_VALUE = 12;
    public static final int UNKNOWN_VALUE = 2;
    private final int value;
    private static final Internal.EnumLiteMap<Code> internalValueMap = new Internal.EnumLiteMap<Code>() { // from class: com.google.rpc.Code.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Code findValueByNumber(int i10) {
            return Code.forNumber(i10);
        }
    };
    private static final Code[] VALUES = values();

    Code(int i10) {
        this.value = i10;
    }

    public static Code forNumber(int i10) {
        switch (i10) {
            case 0:
                return OK;
            case 1:
                return CANCELLED;
            case 2:
                return UNKNOWN;
            case 3:
                return INVALID_ARGUMENT;
            case 4:
                return DEADLINE_EXCEEDED;
            case 5:
                return NOT_FOUND;
            case 6:
                return ALREADY_EXISTS;
            case 7:
                return PERMISSION_DENIED;
            case 8:
                return RESOURCE_EXHAUSTED;
            case 9:
                return FAILED_PRECONDITION;
            case 10:
                return ABORTED;
            case 11:
                return OUT_OF_RANGE;
            case 12:
                return UNIMPLEMENTED;
            case 13:
                return INTERNAL;
            case 14:
                return UNAVAILABLE;
            case 15:
                return DATA_LOSS;
            case 16:
                return UNAUTHENTICATED;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return q8.a.a().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<Code> internalGetValueMap() {
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
    public static Code valueOf(int i10) {
        return forNumber(i10);
    }

    public static Code valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
