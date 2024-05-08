package com.zego.zegorangeaudio;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoRangeAudioJNI {
    private static volatile IJniZegoRangeAudioCallback sJniZegoRangeAudioCallback;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface IJniZegoRangeAudioCallback {
        void onRangAudioMicrophone(int i10, int i11);
    }

    public static native boolean enableRangeAudioCallback(boolean z10);

    public static native void enableRangeAudioMicrophone(boolean z10);

    public static native void enableRangeAudioSpeaker(boolean z10);

    public static native void enableSpatializer(boolean z10);

    public static native boolean initRangeAudio();

    public static native void muteRangeAudioUser(String str, boolean z10);

    public static void onRangAudioMicrophone(int i10, int i11) {
        IJniZegoRangeAudioCallback iJniZegoRangeAudioCallback = sJniZegoRangeAudioCallback;
        if (iJniZegoRangeAudioCallback != null) {
            iJniZegoRangeAudioCallback.onRangAudioMicrophone(i10, i11);
        }
    }

    public static native int setAudioRecvRange(float f10, float f11);

    public static native void setAudioRecvRange(float f10);

    public static native void setPositionUpdateFrequency(int i10);

    public static boolean setRangeAudioJNICallback(IJniZegoRangeAudioCallback iJniZegoRangeAudioCallback) {
        sJniZegoRangeAudioCallback = iJniZegoRangeAudioCallback;
        return enableRangeAudioCallback(iJniZegoRangeAudioCallback != null);
    }

    public static native void setRangeAudioMode(int i10);

    public static native void setRangeAudioTeamID(String str);

    public static native void setRangeAudioVolume(int i10);

    public static native void unInitRangeAudio();

    public static native void updateAudioSource(String str, float[] fArr);

    public static native void updateSelfPosition(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    public static native void updateStreamPosition(String str, float[] fArr);

    public static native int updateStreamVocalRange(String str, float f10, float f11);

    public static native void updateStreamVocalRange(String str, float f10);
}
