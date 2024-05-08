package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.BefActionRecognitionInfo;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ActionRecognition {
    private boolean mInited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nDestroy();

    private native int nDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, int i15, BefActionRecognitionInfo befActionRecognitionInfo);

    private native int nDetectPose(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, int i15, BefActionRecognitionInfo.PoseDetectResult poseDetectResult);

    private native int nInit(Context context, String str, String str2, boolean z10);

    private native int nSetTemplate(String str);

    private native int nSetTemplateThreshold(float f10);

    public void destroy() {
        if (this.mInited) {
            nDestroy();
        }
        this.mInited = false;
    }

    public BefActionRecognitionInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, int i13) {
        if (!this.mInited) {
            return null;
        }
        BefActionRecognitionInfo befActionRecognitionInfo = new BefActionRecognitionInfo();
        if (nDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, i13, befActionRecognitionInfo) != 0) {
            return null;
        }
        return befActionRecognitionInfo;
    }

    public BefActionRecognitionInfo.PoseDetectResult detectPose(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, BefActionRecognitionInfo.ActionRecognitionPoseType actionRecognitionPoseType, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefActionRecognitionInfo.PoseDetectResult poseDetectResult = new BefActionRecognitionInfo.PoseDetectResult();
        if (nDetectPose(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, actionRecognitionPoseType.f19156id, poseDetectResult) != 0) {
            return null;
        }
        return poseDetectResult;
    }

    public int init(Context context, String str, String str2, boolean z10) {
        int nInit = nInit(context, str, str2, z10);
        if (nInit != 0) {
            this.mInited = false;
            return nInit;
        }
        this.mInited = true;
        return nInit;
    }

    public int setTemplate(String str) {
        if (this.mInited) {
            return nSetTemplate(str);
        }
        return -1;
    }

    public int setThreshold(float f10) {
        if (this.mInited) {
            return nSetTemplateThreshold(f10);
        }
        return -1;
    }

    public int init(Context context, String str, String str2) {
        return init(context, str, str2, false);
    }
}
