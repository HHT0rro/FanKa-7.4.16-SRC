package com.zego.zegoavkit2.audioobserver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ZegoAudioObserverSource {
    CAPTURE(1),
    PLAYBACK(2),
    MIX(4);

    private int mSource;

    ZegoAudioObserverSource(int i10) {
        this.mSource = i10;
    }

    public int value() {
        return this.mSource;
    }
}
