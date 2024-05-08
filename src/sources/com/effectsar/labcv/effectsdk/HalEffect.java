package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HalEffect {
    private volatile boolean mInited;
    private long mNativePtr;

    static {
        System.loadLibrary("effect");
    }

    private native int nativeAppendComposerNodes(String[] strArr);

    private native int nativeCleanPipeline();

    private native int nativeGetFaceDetectResult(BefFaceInfo befFaceInfo);

    private native int nativeInit(String str, String str2, boolean z10, int i10, int i11);

    private native int nativeProcessBuffer(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, int i14);

    private native int nativeProcessBufferWithFaceInfo(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, int i14, int i15, BefFaceInfo befFaceInfo);

    private native int nativeProcessGesture(int i10, float f10, float f11, float f12, float f13, float f14);

    private native int nativeProcessTouch(int i10, float f10, float f11, float f12, float f13, int i11, int i12);

    private native void nativeRelease();

    private native int nativeRemoveComposerNodes(String[] strArr);

    private native int nativeSetCameraPosition(boolean z10);

    private native int nativeSetComposer(String str);

    private native int nativeSetComposerNodes(String[] strArr, String[] strArr2);

    private native int nativeSetFilter(String str);

    private native int nativeSetRenderCacheTexture(String str, String str2);

    private native int nativeSetRenderCacheTexture(String str, ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14);

    private native int nativeSetSticker(String str);

    private native int nativeUpdateComposer(String str, String str2, float f10, boolean z10);

    private native int nativeUpdateIntensity(int i10, float f10);

    public int appendComposerNodes(String[] strArr) {
        if (this.mInited) {
            return nativeAppendComposerNodes(strArr);
        }
        return -1;
    }

    public boolean cleanPipeline() {
        return this.mInited && nativeCleanPipeline() == 0;
    }

    public BefFaceInfo getFaceDetectResult() {
        if (!this.mInited) {
            return null;
        }
        BefFaceInfo befFaceInfo = new BefFaceInfo();
        int nativeGetFaceDetectResult = nativeGetFaceDetectResult(befFaceInfo);
        if (nativeGetFaceDetectResult == 0) {
            return befFaceInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeGetFaceDetectResult return ");
        sb2.append(nativeGetFaceDetectResult);
        return null;
    }

    public int init(String str, String str2, boolean z10, int i10, int i11) {
        if (this.mInited) {
            return 0;
        }
        int nativeInit = nativeInit(str2, str, z10, i10, i11);
        this.mInited = nativeInit == 0;
        return nativeInit;
    }

    public boolean isInited() {
        return this.mInited;
    }

    @Deprecated
    public boolean processBuffer(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, int i14) {
        return this.mInited && nativeProcessBuffer(bArr, bArr2, i12, i13, i14, i10, i11) == 0;
    }

    @Deprecated
    public boolean processBufferWithFaceInfo(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, int i14, int i15, BefFaceInfo befFaceInfo) {
        return this.mInited && nativeProcessBufferWithFaceInfo(bArr, bArr2, i12, i13, i14, i10, i11, i15, befFaceInfo) == 0;
    }

    public int processGesture(EffectsSDKEffectConstants.GestureEventCode gestureEventCode, float f10, float f11, float f12, float f13, float f14) {
        return nativeProcessGesture(gestureEventCode.getCode(), f10, f11, f12, f13, f14);
    }

    public int processTouch(EffectsSDKEffectConstants.TouchEventCode touchEventCode, float f10, float f11, float f12, float f13, int i10, int i11) {
        return nativeProcessTouch(touchEventCode.getCode(), f10, f11, f12, f13, i10, i11);
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int removeComposerNodes(String[] strArr) {
        if (this.mInited) {
            return nativeRemoveComposerNodes(strArr);
        }
        return -1;
    }

    public boolean setCameraPostion(boolean z10) {
        return this.mInited && nativeSetCameraPosition(z10) == 0;
    }

    public int setComposerNodes(String[] strArr) {
        if (this.mInited) {
            return nativeSetComposerNodes(strArr, null);
        }
        return -1;
    }

    public int setComposerNodesWithTags(String[] strArr, String[] strArr2) {
        if (this.mInited) {
            return nativeSetComposerNodes(strArr, strArr2);
        }
        return -1;
    }

    public boolean setFilter(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetFilter(str) == 0;
    }

    public int setRenderCacheTexture(String str, String str2) {
        return nativeSetRenderCacheTexture(str, str2);
    }

    public int setRenderCacheTextureWithBuffer(String str, ByteBuffer byteBuffer, int i10, int i11, int i12, EffectsSDKEffectConstants.PixlFormat pixlFormat, EffectsSDKEffectConstants.Rotation rotation) {
        return nativeSetRenderCacheTexture(str, byteBuffer, i10, i11, i12, pixlFormat.getValue(), rotation.f19187id);
    }

    public boolean setSticker(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetSticker(str) == 0;
    }

    public int updateComposerNodes(String str, String str2, float f10, boolean z10) {
        if (this.mInited) {
            return nativeUpdateComposer(str, str2, f10, z10);
        }
        return -1;
    }

    public boolean updateIntensity(int i10, float f10) {
        return this.mInited && nativeUpdateIntensity(i10, f10) == 0;
    }
}
