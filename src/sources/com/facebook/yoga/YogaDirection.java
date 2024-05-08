package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);

    private int mIntValue;

    YogaDirection(int i10) {
        this.mIntValue = i10;
    }

    public static YogaDirection fromInt(int i10) {
        if (i10 == 0) {
            return INHERIT;
        }
        if (i10 == 1) {
            return LTR;
        }
        if (i10 == 2) {
            return RTL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
