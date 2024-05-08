package com.effectsar.labcv.effectsdk;

import android.content.Context;
import android.os.SystemClock;
import com.effectsar.labcv.effectsdk.BefPublicDefine;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class RenderManager {
    public static boolean mLoadLib;
    private volatile boolean mInited;
    private long mNativePtr;

    public RenderManager() {
        if (mLoadLib) {
            return;
        }
        loadLib();
        mLoadLib = true;
    }

    public static String formatErrorCode(int i10) {
        return nativeFormatErrorCode(i10);
    }

    public static String getSDKVersion() {
        if (!mLoadLib) {
            loadLib();
            mLoadLib = true;
        }
        return nativeGetSDKVersion();
    }

    public static void loadLib() throws UnsatisfiedLinkError {
        try {
            System.loadLibrary("effect");
            System.err.println("RenderManager_jni: library load!");
        } catch (UnsatisfiedLinkError e2) {
            System.err.println("WARNING: RenderManager_jni Could not load library in default path!");
            System.err.print(e2);
        }
    }

    private native int nativeAlgorithmBuffer(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, double d10);

    private native int nativeAlgorithmTextureWithBuffer(int i10, ByteBuffer byteBuffer, int i11, int i12, int i13, int i14, int i15, double d10);

    private native int nativeAppendComposerNodes(String[] strArr);

    private native int nativeCleanPipeline();

    private native int nativeDeviceConfig(boolean z10, boolean z11, boolean z12, boolean z13);

    private static native String nativeFormatErrorCode(int i10);

    private native int nativeGetAvailableFeatures(String[] strArr);

    private native int nativeGetCapturedImageWithKey(String str, ByteBuffer byteBuffer, BefPublicDefine.BefCapturedImageInfo befCapturedImageInfo);

    private native int nativeGetFaceDetectResult(BefFaceInfo befFaceInfo);

    private native int nativeGetFaceMaskResult(int i10, BefFaceInfo befFaceInfo);

    private native int nativeGetHandDetectResult(BefHandInfo befHandInfo);

    public static native String nativeGetSDKVersion();

    private native int nativeGetSkeletonDetectResult(BefSkeletonInfo befSkeletonInfo);

    private native int nativeInit(Context context, String str, String str2, String str3, boolean z10, boolean z11, int i10);

    private native int nativeInit(Context context, String str, String str2, boolean z10);

    private native int nativeInit(Context context, String str, String str2, boolean z10, boolean z11, int i10);

    private native int nativeLoadWithTimeout(int i10);

    private native int nativeOnAcceleratorChanged(double d10, double d11, double d12, double d13);

    private native int nativeOnGravityChanged(double d10, double d11, double d12, double d13);

    private native int nativeOnGyroscopeChanged(double d10, double d11, double d12, double d13);

    private native int nativeOnOrientationChanged(double[] dArr, int i10, double d10);

    private native int nativeProcess(int i10, int i11, int i12, int i13, int i14, double d10);

    private native int nativeProcessBuffer(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, byte[] bArr, int i15, double d10);

    private native int nativeProcessGesture(int i10, float f10, float f11, float f12, float f13, float f14);

    private native int nativeProcessTexture(int i10, int i11, int i12, int i13, int i14, double d10);

    private native int nativeProcessTouch(int i10, float f10, float f11, float f12, float f13, int i11, int i12);

    private native void nativeRelease();

    private native int nativeRemoveComposerNodes(String[] strArr);

    private native int nativeScaleSlam(float f10);

    private native int nativeSendMessage(int i10, long j10, long j11, String str);

    private native int nativeSet3buffer(boolean z10);

    private native int nativeSetAlgorithmForceDetect(boolean z10);

    private native int nativeSetBeauty(String str);

    private native int nativeSetCameraPosition(boolean z10);

    private native int nativeSetComposer(String str);

    private native int nativeSetComposerMode(int i10, int i11);

    private native int nativeSetComposerNodes(String[] strArr, String[] strArr2);

    private native int nativeSetDeviceRotation(float[] fArr);

    private native int nativeSetFilter(String str);

    private native int nativeSetImageMode(boolean z10);

    private native int nativeSetMakeUp(String str);

    private native int nativeSetPipeline(boolean z10);

    private native int nativeSetRenderAPI(int i10);

    private native int nativeSetRenderCacheTexture(String str, String str2);

    private native int nativeSetRenderCacheTexture(String str, ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14);

    private native int nativeSetReshape(String str);

    private native int nativeSetResourceLicense(String str);

    private native int nativeSetSticker(String str);

    private native int nativeUpdateComposer(String str, String str2, float f10);

    private native int nativeUpdateIntensity(int i10, float f10);

    private native int nativeUpdateReshape(float f10, float f11);

    private native int nativeUseBuiltinSensor(boolean z10);

    public int SetFaceForceDetect(boolean z10) {
        return nativeSetAlgorithmForceDetect(z10);
    }

    public boolean algorithmBuffer(ByteBuffer byteBuffer, EffectsSDKEffectConstants.Rotation rotation, int i10, int i11, int i12, int i13, long j10) {
        return this.mInited && nativeAlgorithmBuffer(byteBuffer, rotation.f19187id, i10, i11, i12, i13, getSurfaceTimeStamp(j10)) == 0;
    }

    public boolean algorithmTextureWithBuffer(int i10, ByteBuffer byteBuffer, EffectsSDKEffectConstants.Rotation rotation, int i11, int i12, int i13, int i14, long j10) {
        return this.mInited && nativeAlgorithmTextureWithBuffer(i10, byteBuffer, rotation.f19187id, i11, i12, i13, i14, getSurfaceTimeStamp(j10)) == 0;
    }

    public int appendComposerNodes(String[] strArr) {
        return nativeAppendComposerNodes(strArr);
    }

    public boolean cleanPipeline() {
        return this.mInited && nativeCleanPipeline() == 0;
    }

    public int deviceConfig(boolean z10, boolean z11, boolean z12, boolean z13) {
        return nativeDeviceConfig(z10, z11, z12, z13);
    }

    public boolean getAvailableFeatures(String[] strArr) {
        return nativeGetAvailableFeatures(strArr) == 0;
    }

    public int getCapturedImageWithKey(String str, ByteBuffer byteBuffer, BefPublicDefine.BefCapturedImageInfo befCapturedImageInfo) {
        return nativeGetCapturedImageWithKey(str, byteBuffer, befCapturedImageInfo);
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

    public void getFaceMaskResult(EffectsSDKEffectConstants.FaceMaskType faceMaskType, BefFaceInfo befFaceInfo) {
        int nativeGetFaceMaskResult;
        if (!this.mInited || befFaceInfo == null || (nativeGetFaceMaskResult = nativeGetFaceMaskResult(faceMaskType.getValue(), befFaceInfo)) == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getFaceMaskResult type:");
        sb2.append((Object) faceMaskType);
        sb2.append(" return ");
        sb2.append(nativeGetFaceMaskResult);
    }

    public BefHandInfo getHandDetectResult() {
        if (!this.mInited) {
            return null;
        }
        BefHandInfo befHandInfo = new BefHandInfo();
        int nativeGetHandDetectResult = nativeGetHandDetectResult(befHandInfo);
        if (nativeGetHandDetectResult == 0) {
            return befHandInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeGetHandDetectResult return ");
        sb2.append(nativeGetHandDetectResult);
        return null;
    }

    public BefSkeletonInfo getSkeletonDetectResult() {
        if (!this.mInited) {
            return null;
        }
        BefSkeletonInfo befSkeletonInfo = new BefSkeletonInfo();
        int nativeGetSkeletonDetectResult = nativeGetSkeletonDetectResult(befSkeletonInfo);
        if (nativeGetSkeletonDetectResult == 0) {
            return befSkeletonInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeGetSkeletonDetectResult return ");
        sb2.append(nativeGetSkeletonDetectResult);
        return null;
    }

    public double getSurfaceTimeStamp(long j10) {
        long abs = Math.abs(System.nanoTime() - j10);
        long abs2 = Math.abs(SystemClock.elapsedRealtimeNanos() - j10);
        return (r0 - Math.min(Math.min(abs, abs2), Math.abs((SystemClock.uptimeMillis() * 1000000) - j10))) / 1.0E9d;
    }

    public int init(Context context, String str, String str2) {
        return init(context, str, str2, true, 0);
    }

    public boolean isInited() {
        return this.mInited;
    }

    public boolean loadResourceWithTimeout(int i10) {
        return this.mInited && nativeLoadWithTimeout(i10) == 0;
    }

    public int onAcceleratorChanged(double d10, double d11, double d12, double d13) {
        return nativeOnAcceleratorChanged(d10, d11, d12, d13);
    }

    public int onGravityChanged(double d10, double d11, double d12, double d13) {
        return nativeOnGravityChanged(d10, d11, d12, d13);
    }

    public int onGyroscopeChanged(double d10, double d11, double d12, double d13) {
        return nativeOnGyroscopeChanged(d10, d11, d12, d13);
    }

    public int onOrientationChanged(double[] dArr, int i10, double d10) {
        return nativeOnOrientationChanged(dArr, i10, d10);
    }

    @Deprecated
    public boolean processBuffer(ByteBuffer byteBuffer, EffectsSDKEffectConstants.Rotation rotation, int i10, int i11, int i12, int i13, byte[] bArr, int i14) {
        if (this.mInited) {
            return nativeProcessBuffer(byteBuffer, rotation.f19187id, i10, i11, i12, i13, bArr, i14, (double) System.nanoTime()) == 0;
        }
        return false;
    }

    public int processGesture(EffectsSDKEffectConstants.GestureEventCode gestureEventCode, float f10, float f11, float f12, float f13, float f14) {
        return nativeProcessGesture(gestureEventCode.getCode(), f10, f11, f12, f13, f14);
    }

    public boolean processTexture(int i10, int i11, int i12, int i13, EffectsSDKEffectConstants.Rotation rotation, long j10) {
        return this.mInited && nativeProcess(i10, i11, i12, i13, rotation.f19187id, getSurfaceTimeStamp(j10)) == 0;
    }

    public boolean processTextureOnly(int i10, int i11, int i12, int i13, EffectsSDKEffectConstants.Rotation rotation, long j10) {
        return this.mInited && nativeProcessTexture(i10, i11, i12, i13, rotation.f19187id, getSurfaceTimeStamp(j10)) == 0;
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
        return nativeRemoveComposerNodes(strArr);
    }

    public int scaleSlam(float f10) {
        return nativeScaleSlam(f10);
    }

    public void sendMessage(int i10, long j10, long j11, String str) {
        nativeSendMessage(i10, j10, j11, str);
    }

    public boolean set3Buffer(boolean z10) {
        return this.mInited && nativeSet3buffer(z10) == 0;
    }

    @Deprecated
    public boolean setBeauty(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetBeauty(str) == 0;
    }

    public boolean setCameraPostion(boolean z10) {
        return this.mInited && nativeSetCameraPosition(z10) == 0;
    }

    public int setComposer(String str) {
        return nativeSetComposer(str);
    }

    public int setComposerMode(int i10, int i11) {
        return nativeSetComposerMode(i10, i11);
    }

    public int setComposerNodes(String[] strArr) {
        return nativeSetComposerNodes(strArr, null);
    }

    public int setComposerNodesWithTags(String[] strArr, String[] strArr2) {
        return nativeSetComposerNodes(strArr, strArr2);
    }

    public int setDeviceRotation(float[] fArr) {
        return nativeSetDeviceRotation(fArr);
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

    public boolean setImageMode(boolean z10) {
        return this.mInited && nativeSetImageMode(z10) == 0;
    }

    @Deprecated
    public boolean setMakeUp(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetMakeUp(str) == 0;
    }

    public boolean setPipeline(boolean z10) {
        return this.mInited && nativeSetPipeline(z10) == 0;
    }

    public boolean setRenderAPI(int i10) {
        return nativeSetRenderAPI(i10) == 0;
    }

    public int setRenderCacheTexture(String str, String str2) {
        return nativeSetRenderCacheTexture(str, str2);
    }

    public int setRenderCacheTextureWithBuffer(String str, ByteBuffer byteBuffer, int i10, int i11, int i12, EffectsSDKEffectConstants.PixlFormat pixlFormat, EffectsSDKEffectConstants.Rotation rotation) {
        return nativeSetRenderCacheTexture(str, byteBuffer, i10, i11, i12, pixlFormat.getValue(), rotation.f19187id);
    }

    @Deprecated
    public boolean setReshape(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetReshape(str) == 0;
    }

    public int setResourceLicense(String str) {
        return nativeSetResourceLicense(str);
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

    public int updateComposerNodes(String str, String str2, float f10) {
        return nativeUpdateComposer(str, str2, f10);
    }

    public boolean updateIntensity(int i10, float f10) {
        return nativeUpdateIntensity(i10, f10) == 0;
    }

    @Deprecated
    public boolean updateReshape(float f10, float f11) {
        return nativeUpdateReshape(f10, f11) == 0;
    }

    public int useBuiltinSensor(boolean z10) {
        return nativeUseBuiltinSensor(z10);
    }

    public int init(Context context, String str, String str2, boolean z10, boolean z11, int i10) {
        if (this.mInited) {
            return 0;
        }
        int nativeInit = nativeInit(context, str, str2, z10, z11, i10);
        this.mInited = nativeInit == 0;
        return nativeInit;
    }

    public int init(Context context, String str, String str2, String str3, boolean z10, boolean z11, int i10) {
        if (this.mInited) {
            return 0;
        }
        int nativeInit = nativeInit(context, str, str2, str3, z10, z11, i10);
        this.mInited = nativeInit == 0;
        return nativeInit;
    }

    public int init(Context context, String str, String str2, boolean z10, int i10) {
        return init(context, str, str2, z10, false, i10);
    }
}
