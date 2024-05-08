package com.zego.zegoavkit2.playaudiorecorder;

import com.zego.zegoavkit2.entities.ZegoAudioFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoPlayAudioRecorderJNI {
    private static volatile IZegoPlayAudioRecorderCallback sCallback;

    public static native void enablePlayAudioRecorder(boolean z10, int i10, int i11);

    public static void onPlayAudioRecorder(String str, ZegoAudioFrame zegoAudioFrame) {
        IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback = sCallback;
        if (iZegoPlayAudioRecorderCallback != null) {
            iZegoPlayAudioRecorderCallback.onPlayAudioRecorder(str, zegoAudioFrame);
        }
    }

    public static void setPlayAudioRecorderCallback(IZegoPlayAudioRecorderCallback iZegoPlayAudioRecorderCallback) {
        sCallback = iZegoPlayAudioRecorderCallback;
    }
}
