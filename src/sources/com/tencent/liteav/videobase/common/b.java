package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum b {
    UNKNOWN(-1),
    HDR10(0),
    HLG(1),
    UNSUPPORTED(2);

    public final int mValue;

    b(int i10) {
        this.mValue = i10;
    }

    public static b a(int i10) {
        if (i10 == 0) {
            return HDR10;
        }
        if (i10 == 1) {
            return HLG;
        }
        if (i10 != 2) {
            return UNKNOWN;
        }
        return UNSUPPORTED;
    }
}
