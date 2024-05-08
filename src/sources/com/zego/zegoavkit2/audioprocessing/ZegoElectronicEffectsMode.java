package com.zego.zegoavkit2.audioprocessing;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoElectronicEffectsMode {
    MAJOR(0),
    MINOR(1),
    HARMONIC_MINOR(2);

    private int mCode;

    ZegoElectronicEffectsMode(int i10) {
        this.mCode = i10;
    }

    public int getCode() {
        return this.mCode;
    }
}
