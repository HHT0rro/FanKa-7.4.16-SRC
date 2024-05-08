package com.zego.zegoavkit2.camera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoCameraExposureMode {
    AUTO(0),
    CUSTOM(1);

    private int mCode;

    ZegoCameraExposureMode(int i10) {
        this.mCode = i10;
    }

    public int getCode() {
        return this.mCode;
    }
}
