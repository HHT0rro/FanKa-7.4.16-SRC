package com.zego.zegoavkit2.camera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoCameraFocusMode {
    AUTO(0),
    INFINITY(1),
    MACRO(2),
    FIXED(3),
    EDOF(4),
    CONTINUOUS_VIDEO(5);

    private int mCode;

    ZegoCameraFocusMode(int i10) {
        this.mCode = i10;
    }

    public int getCode() {
        return this.mCode;
    }
}
