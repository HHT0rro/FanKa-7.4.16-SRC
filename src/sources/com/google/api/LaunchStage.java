package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import u7.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum LaunchStage implements ProtocolMessageEnum {
    LAUNCH_STAGE_UNSPECIFIED(0),
    UNIMPLEMENTED(6),
    PRELAUNCH(7),
    EARLY_ACCESS(1),
    ALPHA(2),
    BETA(3),
    GA(4),
    DEPRECATED(5),
    UNRECOGNIZED(-1);

    public static final int ALPHA_VALUE = 2;
    public static final int BETA_VALUE = 3;
    public static final int DEPRECATED_VALUE = 5;
    public static final int EARLY_ACCESS_VALUE = 1;
    public static final int GA_VALUE = 4;
    public static final int LAUNCH_STAGE_UNSPECIFIED_VALUE = 0;
    public static final int PRELAUNCH_VALUE = 7;
    public static final int UNIMPLEMENTED_VALUE = 6;
    private final int value;
    private static final Internal.EnumLiteMap<LaunchStage> internalValueMap = new Internal.EnumLiteMap<LaunchStage>() { // from class: com.google.api.LaunchStage.a
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LaunchStage findValueByNumber(int i10) {
            return LaunchStage.forNumber(i10);
        }
    };
    private static final LaunchStage[] VALUES = values();

    LaunchStage(int i10) {
        this.value = i10;
    }

    public static LaunchStage forNumber(int i10) {
        switch (i10) {
            case 0:
                return LAUNCH_STAGE_UNSPECIFIED;
            case 1:
                return EARLY_ACCESS;
            case 2:
                return ALPHA;
            case 3:
                return BETA;
            case 4:
                return GA;
            case 5:
                return DEPRECATED;
            case 6:
                return UNIMPLEMENTED;
            case 7:
                return PRELAUNCH;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return r.a().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<LaunchStage> internalGetValueMap() {
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
    public static LaunchStage valueOf(int i10) {
        return forNumber(i10);
    }

    public static LaunchStage valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
}
