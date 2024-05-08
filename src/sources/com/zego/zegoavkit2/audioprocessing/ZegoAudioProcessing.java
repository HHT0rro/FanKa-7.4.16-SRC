package com.zego.zegoavkit2.audioprocessing;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoAudioProcessing {

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVoiceChangerCategory {
        public static final float MEN_TO_CHILD = 8.0f;
        public static final float MEN_TO_WOMEN = 4.0f;
        public static final float NONE = 0.0f;
        public static final float WOMEN_TO_CHILD = 6.0f;
        public static final float WOMEN_TO_MEN = -3.0f;
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVoiceChangerType {
        public static final int AI_ROBOT = 2;
        public static final int CHANGER_OFF = 0;
        public static final int ELUSIVE = 4;
        public static final int FEMALE_FRESH = 6;
        public static final int FOREIGNER = 3;
        public static final int MALE_MAGNETIC = 5;
        public static final int MEN_TO_CHILD = 7;
        public static final int MEN_TO_WOMEN = 8;
        public static final int OPTIMUS_PRIME = 1;
        public static final int WOMEN_TO_CHILD = 9;
        public static final int WOMEN_TO_MEN = 10;
    }

    @Deprecated
    public static boolean enableReverb(boolean z10, ZegoAudioReverbMode zegoAudioReverbMode) {
        if (zegoAudioReverbMode == null) {
            return false;
        }
        return ZegoAudioProcessingJNI.enableReverb(z10, zegoAudioReverbMode.getCode());
    }

    public static boolean enableSpeechEnhance(boolean z10, int i10) {
        return ZegoAudioProcessingJNI.enableSpeechEnhance(z10, i10);
    }

    public static boolean enableVirtualStereo(boolean z10, int i10) {
        return ZegoAudioProcessingJNI.enableVirtualStereo(z10, i10);
    }

    public static boolean setAdvancedReverbParam(boolean z10, ZegoAudioAdvancedReverbParam zegoAudioAdvancedReverbParam) {
        if (z10 || zegoAudioAdvancedReverbParam != null) {
            return ZegoAudioProcessingJNI.setAdvancedReverbParam(z10, zegoAudioAdvancedReverbParam);
        }
        return false;
    }

    public static boolean setAudioEqualizerGain(int i10, float f10) {
        return ZegoAudioProcessingJNI.setAudioEqualizerGain(i10, f10);
    }

    public static boolean setElectronicEffects(boolean z10, ZegoElectronicEffectsMode zegoElectronicEffectsMode, int i10) {
        return ZegoAudioProcessingJNI.setElectronicEffects(z10, zegoElectronicEffectsMode.getCode(), i10);
    }

    public static boolean setReverbEchoParam(ZegoReverbEchoParam zegoReverbEchoParam) {
        return ZegoAudioProcessingJNI.setReverbEchoParam(zegoReverbEchoParam);
    }

    public static boolean setReverbParam(float f10, float f11) {
        return ZegoAudioProcessingJNI.setReverbParam(f10, f11);
    }

    public static boolean setReverbPreset(ZegoVoiceReverbType zegoVoiceReverbType) {
        if (zegoVoiceReverbType == null) {
            return false;
        }
        return ZegoAudioProcessingJNI.setReverbPreset(zegoVoiceReverbType.getCode());
    }

    public static boolean setVoiceChangerParam(float f10) {
        return ZegoAudioProcessingJNI.setVoiceChangerParam(f10);
    }

    @Deprecated
    public static boolean setVoicePreset(int i10) {
        return ZegoAudioProcessingJNI.setVoicePreset(i10);
    }

    public static boolean setReverbParam(ZegoAudioReverbParam zegoAudioReverbParam) {
        return ZegoAudioProcessingJNI.setReverbParam2(zegoAudioReverbParam);
    }

    public static boolean setVoicePreset(com.zego.zegoavkit2.audioprocessing.ZegoVoiceChangerType zegoVoiceChangerType) {
        if (zegoVoiceChangerType == null) {
            return false;
        }
        return ZegoAudioProcessingJNI.setVoicePreset(zegoVoiceChangerType.getCode());
    }
}
