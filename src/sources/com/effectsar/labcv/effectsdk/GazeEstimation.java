package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class GazeEstimation {
    private boolean mInited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(String str, boolean z10);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefFaceInfo befFaceInfo, float f10, BefGazeEstimationInfo befGazeEstimationInfo);

    private native int nativeRelease();

    private native int nativeSetModel(int i10, String str);

    private native int nativeSetParam(int i10, float f10);

    public BefGazeEstimationInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, BefFaceInfo befFaceInfo, float f10) {
        if (!this.mInited) {
            return null;
        }
        BefGazeEstimationInfo befGazeEstimationInfo = new BefGazeEstimationInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befFaceInfo, f10, befGazeEstimationInfo);
        if (nativeDetect == 0) {
            return befGazeEstimationInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("native detect return ");
        sb2.append(nativeDetect);
        return null;
    }

    public int init(String str, boolean z10) {
        int nativeCreate = nativeCreate(str, z10);
        if (nativeCreate != 0) {
            this.mInited = false;
            return nativeCreate;
        }
        this.mInited = true;
        return nativeCreate;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int setModel(EffectsSDKEffectConstants.GazeEstimationModelType gazeEstimationModelType, String str) {
        return nativeSetModel(gazeEstimationModelType.getValue(), str);
    }

    public int setParam(EffectsSDKEffectConstants.GazeEstimationParamType gazeEstimationParamType, float f10) {
        return nativeSetParam(gazeEstimationParamType.getValue(), f10);
    }

    public int init(String str) {
        return init(str, false);
    }
}
