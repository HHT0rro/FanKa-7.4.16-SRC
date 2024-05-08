package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AdaptiveSharpen {
    private float mAmount;
    private int mDiffImgSmoothEnable;
    private float mEdgeWeightGamma;
    private boolean mInited;
    private int mMaxHeight;
    private int mMaxWidth;
    private long mNativePtr;
    private float mOverRatio;
    private int mPowerLevel;
    private int mSceneMode;
    private int mFrameWidth = 0;
    private int mFrameHeight = 0;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(String str, int i10, int i11, int i12, int i13, float f10, float f11, float f12, int i14, boolean z10);

    private native int nativeProcess(int i10, Integer num);

    private native int nativeRelease();

    private native int nativeSetProperty(int i10, int i11, int i12, int i13, float f10, float f11, float f12, int i14);

    public float getmAmount() {
        return this.mAmount;
    }

    public int getmDiffImgSmoothEnable() {
        return this.mDiffImgSmoothEnable;
    }

    public float getmEdgeWeightGamma() {
        return this.mEdgeWeightGamma;
    }

    public int getmMaxHeight() {
        return this.mMaxHeight;
    }

    public int getmMaxWidth() {
        return this.mMaxWidth;
    }

    public float getmOverRatio() {
        return this.mOverRatio;
    }

    public int getmPowerLevel() {
        return this.mPowerLevel;
    }

    public int getmSceneMode() {
        return this.mSceneMode;
    }

    public int init(String str, int i10, int i11, int i12, int i13, float f10, float f11, float f12, int i14, boolean z10) {
        this.mMaxHeight = i10;
        this.mMaxWidth = i11;
        this.mSceneMode = i12;
        this.mPowerLevel = i13;
        this.mAmount = f10;
        this.mOverRatio = f11;
        this.mEdgeWeightGamma = f12;
        this.mDiffImgSmoothEnable = i14;
        int nativeCreate = nativeCreate(str, i12, i13, i11, i10, f10, f11, f12, i14, z10);
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

    public int process(int i10, Integer num) {
        if (!this.mInited) {
            return -1;
        }
        int nativeProcess = nativeProcess(i10, num);
        if (nativeProcess != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("nativeNightSceneProcess ");
            sb2.append(nativeProcess);
        }
        return nativeProcess;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int setProperty(int i10, int i11, int i12, int i13, float f10, float f11, float f12, int i14) {
        if (!this.mInited) {
            return -1;
        }
        int nativeSetProperty = nativeSetProperty(i10, i11, i12, i13, f10, f11, f12, i14);
        if (nativeSetProperty != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("nativeSetProperty ");
            sb2.append(nativeSetProperty);
            return nativeSetProperty;
        }
        this.mFrameHeight = i13;
        this.mFrameWidth = i12;
        this.mSceneMode = i10;
        this.mPowerLevel = i11;
        this.mAmount = f10;
        this.mOverRatio = f11;
        this.mEdgeWeightGamma = f12;
        this.mDiffImgSmoothEnable = i14;
        return nativeSetProperty;
    }

    public void setmAmount(float f10) {
        this.mAmount = f10;
    }

    public void setmDiffImgSmoothEnable(int i10) {
        this.mDiffImgSmoothEnable = i10;
    }

    public void setmEdgeWeightGamma(float f10) {
        this.mEdgeWeightGamma = f10;
    }

    public void setmMaxHeight(int i10) {
        this.mMaxHeight = i10;
    }

    public void setmMaxWidth(int i10) {
        this.mMaxWidth = i10;
    }

    public void setmOverRatio(float f10) {
        this.mOverRatio = f10;
    }

    public void setmPowerLevel(int i10) {
        this.mPowerLevel = i10;
    }

    public void setmSceneMode(int i10) {
        this.mSceneMode = i10;
    }

    public int init(String str, int i10, int i11, int i12, int i13, float f10, float f11, float f12, int i14) {
        return init(str, i10, i11, i12, i13, f10, f11, f12, i14, false);
    }
}
