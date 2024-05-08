package com.google.cloud;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum OperationResponseMapping implements ProtocolMessageEnum {
    UNDEFINED(0),
    NAME(1),
    STATUS(2),
    ERROR_CODE(3),
    ERROR_MESSAGE(4),
    UNRECOGNIZED(-1);

    public static final int ERROR_CODE_VALUE = 3;
    public static final int ERROR_MESSAGE_VALUE = 4;
    public static final int NAME_VALUE = 1;
    public static final int STATUS_VALUE = 2;
    public static final int UNDEFINED_VALUE = 0;
    private final int value;
    private static final Internal.EnumLiteMap<OperationResponseMapping> internalValueMap = new Internal.EnumLiteMap<OperationResponseMapping>() { // from class: com.google.cloud.OperationResponseMapping.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OperationResponseMapping findValueByNumber(int i10) {
            return OperationResponseMapping.forNumber(i10);
        }
    };
    private static final OperationResponseMapping[] VALUES = values();

    OperationResponseMapping(int i10) {
        this.value = i10;
    }

    public static OperationResponseMapping forNumber(int i10) {
        if (i10 == 0) {
            return UNDEFINED;
        }
        if (i10 == 1) {
            return NAME;
        }
        if (i10 == 2) {
            return STATUS;
        }
        if (i10 == 3) {
            return ERROR_CODE;
        }
        if (i10 != 4) {
            return null;
        }
        return ERROR_MESSAGE;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return v7.a.a().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<OperationResponseMapping> internalGetValueMap() {
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
    public static OperationResponseMapping valueOf(int i10) {
        return forNumber(i10);
    }

    public static OperationResponseMapping valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
