package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaDisplay {
    FLEX(0),
    NONE(1);

    private int mIntValue;

    YogaDisplay(int i10) {
        this.mIntValue = i10;
    }

    public static YogaDisplay fromInt(int i10) {
        if (i10 == 0) {
            return FLEX;
        }
        if (i10 == 1) {
            return NONE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
