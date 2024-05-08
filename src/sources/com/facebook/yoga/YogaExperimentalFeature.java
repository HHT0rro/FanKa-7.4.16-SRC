package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum YogaExperimentalFeature {
    WEB_FLEX_BASIS(0);

    private int mIntValue;

    YogaExperimentalFeature(int i10) {
        this.mIntValue = i10;
    }

    public static YogaExperimentalFeature fromInt(int i10) {
        if (i10 == 0) {
            return WEB_FLEX_BASIS;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i10);
    }

    public int intValue() {
        return this.mIntValue;
    }
}
