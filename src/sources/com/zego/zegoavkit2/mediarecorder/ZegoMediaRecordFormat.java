package com.zego.zegoavkit2.mediarecorder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoMediaRecordFormat {
    FLV(1),
    MP4(2),
    AAC(4),
    M3U(7);

    private int mType;

    ZegoMediaRecordFormat(int i10) {
        this.mType = i10;
    }

    public int value() {
        return this.mType;
    }
}
