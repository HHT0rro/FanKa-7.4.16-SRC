package com.zego.zegoavkit2.mediarecorder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoMediaRecordChannelIndex {
    MAIN(0),
    AUX(1),
    THIRD(2),
    FOURTH(3);

    private int mType;

    ZegoMediaRecordChannelIndex(int i10) {
        this.mType = i10;
    }

    public int value() {
        return this.mType;
    }
}
