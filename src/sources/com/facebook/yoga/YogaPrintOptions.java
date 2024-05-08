package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaPrintOptions {
    LAYOUT(1),
    STYLE(2),
    CHILDREN(4);

    private int mIntValue;

    YogaPrintOptions(int i10) {
        this.mIntValue = i10;
    }

    public static YogaPrintOptions fromInt(int i10) {
        if (i10 == 1) {
            return LAYOUT;
        }
        if (i10 == 2) {
            return STYLE;
        }
        if (i10 == 4) {
            return CHILDREN;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
