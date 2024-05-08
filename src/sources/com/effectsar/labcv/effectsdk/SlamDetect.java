package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.BefSlamInfo;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SlamDetect {
    private long mNativePtr;
    private volatile boolean mInited = false;
    private volatile boolean mCreateSuc = false;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeChecklicense(Context context, String str, boolean z10);

    private native void nativeDestroy();

    private native BefSlamInfo.SlamPose nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, double d10, BefSlamInfo.SlamClickFlag slamClickFlag);

    private native BefSlamInfo.Points[] nativeGetFeaturePoints();

    private native BefSlamInfo.SlamCameraIntrinsic nativeGetIntrinsic(String str, String str2, int i10, int i11);

    private native BefSlamInfo.SlamPlane nativeGetPlane(BefSlamInfo.SlamPose slamPose, int i10, BefSlamInfo.SlamClickFlag slamClickFlag);

    private native BefSlamInfo.SlamPose nativeGetPlanePose(BefSlamInfo.SlamPose slamPose, int i10, BefSlamInfo.SlamClickFlag slamClickFlag);

    private native int nativeInit(String str, String str2, BefSlamInfo.SlamCameraInfo slamCameraInfo, BefSlamInfo.SlamImuInfo slamImuInfo, int i10);

    private native void nativeInitCameraInfo(BefSlamInfo.SlamCameraInfo slamCameraInfo);

    private native int nativeResetStatues();

    private native int nativeSetImuData(int i10, BefSlamInfo.SlamImuData slamImuData);

    private native int nativeSetRotationVector(double[] dArr, double d10);

    private native int nativeSetVersion(int i10);

    public int checklicense(Context context, String str, boolean z10) {
        if (!this.mCreateSuc) {
            return -1;
        }
        int nativeChecklicense = nativeChecklicense(context, str, z10);
        if (nativeChecklicense != 0) {
            this.mInited = false;
        } else {
            this.mInited = true;
        }
        return nativeChecklicense;
    }

    public void destory() {
        if (this.mInited) {
            nativeDestroy();
        }
    }

    public BefSlamInfo.SlamCameraIntrinsic getCameraIntrinsic(String str, String str2, int i10, int i11) {
        if (this.mInited) {
            return nativeGetIntrinsic(str, str2, i10, i11);
        }
        return null;
    }

    public BefSlamInfo.Points[] getFeaturePoints() {
        if (this.mInited) {
            return nativeGetFeaturePoints();
        }
        return null;
    }

    public BefSlamInfo.SlamPlane getPlane(BefSlamInfo.SlamPose slamPose, int i10, BefSlamInfo.SlamClickFlag slamClickFlag) {
        if (this.mInited && slamPose != null) {
            return nativeGetPlane(slamPose, i10, slamClickFlag);
        }
        return null;
    }

    public BefSlamInfo.SlamPose getPlanePose(BefSlamInfo.SlamPose slamPose, int i10, BefSlamInfo.SlamClickFlag slamClickFlag) {
        if (this.mInited && slamPose != null) {
            return nativeGetPlanePose(slamPose, i10, slamClickFlag);
        }
        return null;
    }

    public int init(String str, String str2, BefSlamInfo.SlamImuInfo slamImuInfo, BefSlamInfo.SlamCameraInfo slamCameraInfo, EffectsSDKEffectConstants.SlamVersion slamVersion) {
        int nativeInit = nativeInit(str, str2, slamCameraInfo, slamImuInfo, slamVersion.getValue());
        if (nativeInit != 0) {
            this.mCreateSuc = false;
        } else {
            this.mCreateSuc = true;
        }
        return nativeInit;
    }

    public void initCameraInfo(BefSlamInfo.SlamCameraInfo slamCameraInfo) {
        nativeInitCameraInfo(slamCameraInfo);
    }

    public int resetStatues() {
        if (this.mInited) {
            return nativeResetStatues();
        }
        return 0;
    }

    public int setImuData(EffectsSDKEffectConstants.SlamImuDataType slamImuDataType, BefSlamInfo.SlamImuData slamImuData) {
        if (slamImuData == null || !this.mInited) {
            return -1;
        }
        return nativeSetImuData(slamImuDataType.getValue(), slamImuData);
    }

    public int setRotationVector(double[] dArr, double d10) {
        if (dArr == null || !this.mInited) {
            return -1;
        }
        return nativeSetRotationVector(dArr, d10);
    }

    public int setVersion(EffectsSDKEffectConstants.SlamVersion slamVersion) {
        if (this.mInited) {
            return nativeSetVersion(slamVersion.getValue());
        }
        return 0;
    }

    public BefSlamInfo.SlamPose slamDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, EffectsSDKEffectConstants.SlamDeviceOrientation slamDeviceOrientation, double d10, BefSlamInfo.SlamClickFlag slamClickFlag) {
        if (this.mInited && byteBuffer != null) {
            return nativeDetect(byteBuffer, i10, i11, i12, i13, slamDeviceOrientation.getValue(), d10, slamClickFlag);
        }
        return null;
    }
}
