package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaPositionType {
    RELATIVE(0),
    ABSOLUTE(1);

    private int mIntValue;

    YogaPositionType(int i10) {
        this.mIntValue = i10;
    }

    public static YogaPositionType fromInt(int i10) {
        if (i10 == 0) {
            return RELATIVE;
        }
        if (i10 == 1) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
