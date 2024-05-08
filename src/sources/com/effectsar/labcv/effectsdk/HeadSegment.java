package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.BefFaceInfo;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HeadSegment {
    private boolean inited = false;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreateHandle();

    private native int nativeInitModel(String str);

    private native int nativeProcess(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, float[][] fArr, BefHeadSegInfo befHeadSegInfo);

    private native int nativeRelease();

    private native int nativeSetParam(int i10, float f10);

    private float[][] serializeFace106(BefFaceInfo.Face106[] face106Arr) {
        if (face106Arr == null || face106Arr.length == 0) {
            return null;
        }
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, face106Arr.length, 212);
        for (int i10 = 0; i10 < face106Arr.length; i10++) {
            for (int i11 = 0; i11 < 106; i11++) {
                int i12 = i11 * 2;
                fArr[i10][i12] = face106Arr[i10].points_array[i11].f19164x;
                fArr[i10][i12 + 1] = face106Arr[i10].points_array[i11].f19165y;
            }
        }
        return fArr;
    }

    public synchronized int init(Context context, String str, String str2, boolean z10) {
        int i10;
        i10 = -1;
        if (!this.inited) {
            i10 = nativeCreateHandle();
            if (i10 == 0) {
                i10 = nativeCheckLicense(context, str2, z10);
            }
            boolean z11 = true;
            if (i10 == 0) {
                int nativeInitModel = nativeInitModel(str);
                setParam(EffectsSDKEffectConstants.HeadSegmentParamType.BEF_AI_HS_ENABLE_TRACKING, 1);
                setParam(EffectsSDKEffectConstants.HeadSegmentParamType.BEF_AI_HS_MAX_FACE, 2);
                i10 = nativeInitModel;
            }
            if (i10 != 0) {
                z11 = false;
            }
            this.inited = z11;
        }
        return i10;
    }

    public boolean isInited() {
        return this.inited;
    }

    public BefHeadSegInfo process(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, BefFaceInfo.Face106[] face106Arr) {
        BefHeadSegInfo befHeadSegInfo = new BefHeadSegInfo();
        float[][] serializeFace106 = serializeFace106(face106Arr);
        if (serializeFace106 == null) {
            return null;
        }
        int nativeProcess = nativeProcess(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, serializeFace106, befHeadSegInfo);
        if (nativeProcess == 0) {
            return befHeadSegInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headseg failed with ");
        sb2.append(nativeProcess);
        return null;
    }

    public synchronized void release() {
        if (this.inited) {
            nativeRelease();
        }
        this.inited = false;
    }

    public synchronized int setParam(EffectsSDKEffectConstants.HeadSegmentParamType headSegmentParamType, int i10) {
        return nativeSetParam(headSegmentParamType.getValue(), i10);
    }

    public synchronized int init(Context context, String str, String str2) {
        return init(context, str, str2, false);
    }
}
