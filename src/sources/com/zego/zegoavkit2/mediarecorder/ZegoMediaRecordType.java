package com.zego.zegoavkit2.mediarecorder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoMediaRecordType {
    AUDIO(1),
    VIDEO(2),
    BOTH(3);

    private int mType;

    ZegoMediaRecordType(int i10) {
        this.mType = i10;
    }

    public int value() {
        return this.mType;
    }
}
