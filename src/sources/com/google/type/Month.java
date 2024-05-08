package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import s8.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum Month implements ProtocolMessageEnum {
    MONTH_UNSPECIFIED(0),
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12),
    UNRECOGNIZED(-1);

    public static final int APRIL_VALUE = 4;
    public static final int AUGUST_VALUE = 8;
    public static final int DECEMBER_VALUE = 12;
    public static final int FEBRUARY_VALUE = 2;
    public static final int JANUARY_VALUE = 1;
    public static final int JULY_VALUE = 7;
    public static final int JUNE_VALUE = 6;
    public static final int MARCH_VALUE = 3;
    public static final int MAY_VALUE = 5;
    public static final int MONTH_UNSPECIFIED_VALUE = 0;
    public static final int NOVEMBER_VALUE = 11;
    public static final int OCTOBER_VALUE = 10;
    public static final int SEPTEMBER_VALUE = 9;
    private final int value;
    private static final Internal.EnumLiteMap<Month> internalValueMap = new Internal.EnumLiteMap<Month>() { // from class: com.google.type.Month.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month findValueByNumber(int i10) {
            return Month.forNumber(i10);
        }
    };
    private static final Month[] VALUES = values();

    Month(int i10) {
        this.value = i10;
    }

    public static Month forNumber(int i10) {
        switch (i10) {
            case 0:
                return MONTH_UNSPECIFIED;
            case 1:
                return JANUARY;
            case 2:
                return FEBRUARY;
            case 3:
                return MARCH;
            case 4:
                return APRIL;
            case 5:
                return MAY;
            case 6:
                return JUNE;
            case 7:
                return JULY;
            case 8:
                return AUGUST;
            case 9:
                return SEPTEMBER;
            case 10:
                return OCTOBER;
            case 11:
                return NOVEMBER;
            case 12:
                return DECEMBER;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return m.a().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<Month> internalGetValueMap() {
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
    public static Month valueOf(int i10) {
        return forNumber(i10);
    }

    public static Month valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
