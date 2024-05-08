package com.zego.zegoavkit2.audioobserver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoAudioObserverCallback {
    void onAudioObserverError(int i10);

    void onCapturedAudioData(byte[] bArr, int i10, int i11, int i12);

    void onMixAudioData(byte[] bArr, int i10, int i11, int i12);

    void onPlaybackAudioData(byte[] bArr, int i10, int i11, int i12);
}
