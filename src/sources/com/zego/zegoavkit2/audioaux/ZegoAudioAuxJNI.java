package com.zego.zegoavkit2.audioaux;

import com.zego.zegoavkit2.entities.AuxDataEx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoAudioAuxJNI {
    private static volatile IJniZegoAuxCallback sJNIzegoAuxCallback;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface IJniZegoAuxCallback {
        AuxDataEx onAuxCallback(int i10);
    }

    public static native boolean enableAux(boolean z10);

    public static native boolean muteAux(boolean z10);

    public static AuxDataEx onAuxCallback(int i10) {
        IJniZegoAuxCallback iJniZegoAuxCallback = sJNIzegoAuxCallback;
        if (iJniZegoAuxCallback != null) {
            return iJniZegoAuxCallback.onAuxCallback(i10);
        }
        return null;
    }

    public static native void setAuxPlayVolume(int i10);

    public static native void setAuxPublishVolume(int i10);

    public static native void setAuxVolume(int i10);

    public static void setCallback(IJniZegoAuxCallback iJniZegoAuxCallback) {
        sJNIzegoAuxCallback = iJniZegoAuxCallback;
    }
}
