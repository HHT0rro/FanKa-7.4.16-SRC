package com.zego.zegoavkit2.playaudiorecorder;

import com.zego.zegoavkit2.entities.ZegoAudioFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoPlayAudioRecorder implements IZegoPlayAudioRecorderCallback {
    private volatile IZegoPlayAudioRecorderCallback playAudioRecorderCallback = null;

    public static void enablePlayAudioRecorder(boolean z10, int i10, int i11) {
        ZegoPlayAudioRecorderJNI.enablePlayAudioRecorder(z10, i10, i11);
    }

    @Override // com.zego.zegoavkit2.playaudiorecorder.IZegoPlayAudioRecorderCallback
    public void onPlayAudioRecorder(String str, ZegoAudioFrame zegoAudioFrame) {
        IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback = this.playAudioRecorderCallback;
        if (iZegoPlayAudioRecorderCallback != null) {
            iZegoPlayAudioRecorderCallback.onPlayAudioRecorder(str, zegoAudioFrame);
        }
    }

    public void setPlayAudioRecorderCallback(IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback) {
        this.playAudioRecorderCallback = iZegoPlayAudioRecorderCallback;
        if (iZegoPlayAudioRecorderCallback != null) {
            ZegoPlayAudioRecorderJNI.setPlayAudioRecorderCallback(this);
        } else {
            ZegoPlayAudioRecorderJNI.setPlayAudioRecorderCallback(null);
        }
    }
}
