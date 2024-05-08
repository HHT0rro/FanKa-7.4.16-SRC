package com.zego.zegoavkit2.audiodevice;

import com.zego.zegoavkit2.entities.ZegoAudioFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoExternalAudioDevice {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioSourceType {
        public static final int ExternalCapture = 1;
        public static final int None = -1;
        public static final int Player = 2;
        public static final int SameAsMainPublishChannel = 0;
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AuxPublishChannelAudioSrcType {
        public static final int ExternalCapture = 1;
        public static final int None = -1;
        public static final int Player = 2;
        public static final int SameAsMainPublishChannel = 0;
    }

    @Deprecated
    public static native void enableExternalAudioDevice(boolean z10);

    public static native boolean onPlaybackAudioFrame(ZegoAudioFrame zegoAudioFrame);

    public static native int onRecordAudioFrame(int i10, ZegoAudioFrame zegoAudioFrame);

    public static boolean onRecordAudioFrame(ZegoAudioFrame zegoAudioFrame) {
        return onRecordAudioFrame(0, zegoAudioFrame) == 0;
    }

    public static native boolean onReferenceAudioFrame(ZegoAudioFrame zegoAudioFrame);

    public static native int setAudioSource(int i10, int i11);

    @Deprecated
    public static native int setAudioSrcForAuxiliaryPublishChannel(int i10);

    public static native int startCapture(int i10);

    public static boolean startCapture() {
        return startCapture(0) == 0;
    }

    public static native boolean startRender();

    public static native int stopCapture(int i10);

    public static boolean stopCapture() {
        return stopCapture(0) == 0;
    }

    public static native boolean stopRender();
}
