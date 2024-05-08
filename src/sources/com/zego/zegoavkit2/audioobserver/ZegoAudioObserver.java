package com.zego.zegoavkit2.audioobserver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoAudioObserver {
    public void setAudioObserverCallback(IZegoAudioObserverCallback iZegoAudioObserverCallback) {
        ZegoAudioObserverJNI.setAudioObserverCallback(iZegoAudioObserverCallback);
    }

    public boolean startAudioObserver(int i10, int i11, int i12) {
        return ZegoAudioObserverJNI.startAudioObserver(i10, i11, i12);
    }

    public void stopAudioObserver() {
        ZegoAudioObserverJNI.stopAudioObserver();
    }
}
