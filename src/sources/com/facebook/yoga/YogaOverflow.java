package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);

    private int mIntValue;

    YogaOverflow(int i10) {
        this.mIntValue = i10;
    }

    public static YogaOverflow fromInt(int i10) {
        if (i10 == 0) {
            return VISIBLE;
        }
        if (i10 == 1) {
            return HIDDEN;
        }
        if (i10 == 2) {
            return SCROLL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
