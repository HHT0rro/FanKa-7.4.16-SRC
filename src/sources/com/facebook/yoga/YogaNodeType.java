package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaNodeType {
    DEFAULT(0),
    TEXT(1);

    private int mIntValue;

    YogaNodeType(int i10) {
        this.mIntValue = i10;
    }

    public static YogaNodeType fromInt(int i10) {
        if (i10 == 0) {
            return DEFAULT;
        }
        if (i10 == 1) {
            return TEXT;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
