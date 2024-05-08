package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaDimension {
    WIDTH(0),
    HEIGHT(1);

    private int mIntValue;

    YogaDimension(int i10) {
        this.mIntValue = i10;
    }

    public static YogaDimension fromInt(int i10) {
        if (i10 == 0) {
            return WIDTH;
        }
        if (i10 == 1) {
            return HEIGHT;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
