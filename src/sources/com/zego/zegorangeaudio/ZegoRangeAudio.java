package com.zego.zegorangeaudio;

import android.os.Handler;
import android.os.Looper;
import com.zego.zegorangeaudio.ZegoRangeAudioJNI;
import com.zego.zegorangeaudio.callback.IZegoRangeAudioCallbcak;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoRangeAudio implements ZegoRangeAudioJNI.IJniZegoRangeAudioCallback {
    private static ZegoRangeAudio instance;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private IZegoRangeAudioCallbcak mZegoRangeAudioCallbcak;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class ZegoRangeAudioMicrophoneState {
        public static final int Failed = 4;
        public static final int Opening = 1;
        public static final int Success = 2;
        public static final int TempBroken = 3;

        public ZegoRangeAudioMicrophoneState() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class ZegoRangeAudioMode {
        public static final int SecreteTeam = 3;
        public static final int Team = 2;
        public static final int World = 1;

        public ZegoRangeAudioMode() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoReceiveRangeParam {
        public float min = 0.0f;
        public float max = 0.0f;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVocalRangeParam {
        public float min = 0.0f;
        public float max = 0.0f;
    }

    private ZegoRangeAudio() {
    }

    public static ZegoRangeAudio getInstance() {
        if (instance == null) {
            instance = new ZegoRangeAudio();
        }
        return instance;
    }

    public void enableMicrophone(boolean z10) {
        ZegoRangeAudioJNI.enableRangeAudioMicrophone(z10);
    }

    public void enableSpatializer(boolean z10) {
        ZegoRangeAudioJNI.enableSpatializer(z10);
    }

    public void enableSpeaker(boolean z10) {
        ZegoRangeAudioJNI.enableRangeAudioSpeaker(z10);
    }

    public boolean init() {
        return ZegoRangeAudioJNI.initRangeAudio();
    }

    public void muteUser(String str, boolean z10) {
        ZegoRangeAudioJNI.muteRangeAudioUser(str, z10);
    }

    @Override // com.zego.zegorangeaudio.ZegoRangeAudioJNI.IJniZegoRangeAudioCallback
    public void onRangAudioMicrophone(final int i10, final int i11) {
        final IZegoRangeAudioCallbcak iZegoRangeAudioCallbcak = this.mZegoRangeAudioCallbcak;
        if (iZegoRangeAudioCallbcak != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegorangeaudio.ZegoRangeAudio.1
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRangeAudioCallbcak.onRangAudioMicrophone(i10, i11);
                }
            });
        }
    }

    public void setAudioRecvRange(float f10) {
        ZegoRangeAudioJNI.setAudioRecvRange(f10);
    }

    public boolean setCallback(IZegoRangeAudioCallbcak iZegoRangeAudioCallbcak) {
        this.mZegoRangeAudioCallbcak = iZegoRangeAudioCallbcak;
        return ZegoRangeAudioJNI.setRangeAudioJNICallback(this);
    }

    public void setMode(int i10) {
        ZegoRangeAudioJNI.setRangeAudioMode(i10);
    }

    public void setPositionUpdateFrequency(int i10) {
        ZegoRangeAudioJNI.setPositionUpdateFrequency(i10);
    }

    public void setRangeAudioVolume(int i10) {
        ZegoRangeAudioJNI.setRangeAudioVolume(i10);
    }

    public void setTeamID(String str) {
        ZegoRangeAudioJNI.setRangeAudioTeamID(str);
    }

    public void unInit() {
        ZegoRangeAudioJNI.unInitRangeAudio();
    }

    public void updateAudioSource(String str, float[] fArr) {
        ZegoRangeAudioJNI.updateAudioSource(str, fArr);
    }

    public void updateSelfPosition(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        ZegoRangeAudioJNI.updateSelfPosition(fArr, fArr2, fArr3, fArr4);
    }

    public void updateStreamPosition(String str, float[] fArr) {
        ZegoRangeAudioJNI.updateStreamPosition(str, fArr);
    }

    public void updateStreamVocalRange(String str, float f10) {
        ZegoRangeAudioJNI.updateStreamVocalRange(str, f10);
    }

    public int setAudioRecvRange(ZegoReceiveRangeParam zegoReceiveRangeParam) {
        return ZegoRangeAudioJNI.setAudioRecvRange(zegoReceiveRangeParam.min, zegoReceiveRangeParam.max);
    }

    public int updateStreamVocalRange(String str, ZegoVocalRangeParam zegoVocalRangeParam) {
        return ZegoRangeAudioJNI.updateStreamVocalRange(str, zegoVocalRangeParam.min, zegoVocalRangeParam.max);
    }
}
