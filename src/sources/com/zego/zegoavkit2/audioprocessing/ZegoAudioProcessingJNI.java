package com.zego.zegoavkit2.audioprocessing;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoAudioProcessingJNI {
    public static native boolean enableReverb(boolean z10, int i10);

    public static native boolean enableSpeechEnhance(boolean z10, int i10);

    public static native boolean enableVirtualStereo(boolean z10, int i10);

    public static native boolean setAdvancedReverbParam(boolean z10, ZegoAudioAdvancedReverbParam zegoAudioAdvancedReverbParam);

    public static native boolean setAudioEqualizerGain(int i10, float f10);

    public static native boolean setElectronicEffects(boolean z10, int i10, int i11);

    public static native boolean setReverbEchoParam(ZegoReverbEchoParam zegoReverbEchoParam);

    public static native boolean setReverbParam(float f10, float f11);

    public static native boolean setReverbParam2(ZegoAudioReverbParam zegoAudioReverbParam);

    public static native boolean setReverbPreset(int i10);

    public static native boolean setVoiceChangerParam(float f10);

    public static native boolean setVoicePreset(int i10);
}
