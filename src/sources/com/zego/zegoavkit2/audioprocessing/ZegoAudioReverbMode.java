package com.zego.zegoavkit2.audioprocessing;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoAudioReverbMode {
    SOFT_ROOM(0),
    WARM_CLUB(1),
    CONCERT_HALL(2),
    LARGE_AUDITORIUM(3);

    private int mCode;

    ZegoAudioReverbMode(int i10) {
        this.mCode = i10;
    }

    public int getCode() {
        return this.mCode;
    }
}
