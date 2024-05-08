package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class VideoSR {
    private boolean mInited;
    private int mMaxHeight;
    private int mMaxWidth;
    private long mNativePtr;
    private int mPowerLevel;
    private String mRwDir;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(String str, String str2, int i10, int i11, int i12, boolean z10, boolean z11, int i13);

    private native int nativeProcess(int i10, int i11, int i12, BefVideoSRInfo befVideoSRInfo);

    private native int nativeRelease();

    public int getmMaxHeight() {
        return this.mMaxHeight;
    }

    public int getmMaxWidth() {
        return this.mMaxWidth;
    }

    public int getmPowerLevel() {
        return this.mPowerLevel;
    }

    public int init(String str, String str2, int i10, int i11, EffectsSDKEffectConstants.ImageQulityPowerLevel imageQulityPowerLevel, boolean z10, boolean z11, EffectsSDKEffectConstants.LensVideoAlgType lensVideoAlgType) {
        this.mRwDir = str2;
        this.mMaxHeight = i10;
        this.mMaxWidth = i11;
        this.mPowerLevel = imageQulityPowerLevel.getLevel();
        int nativeCreate = nativeCreate(str, this.mRwDir, this.mMaxHeight, this.mMaxWidth, imageQulityPowerLevel.getLevel(), z10, z11, lensVideoAlgType.getValue());
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

    public BefVideoSRInfo process(int i10, int i11, int i12) {
        if (!this.mInited) {
            return null;
        }
        BefVideoSRInfo befVideoSRInfo = new BefVideoSRInfo();
        int nativeProcess = nativeProcess(i10, i11, i12, befVideoSRInfo);
        if (nativeProcess == 0) {
            return befVideoSRInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeVideoSrProcess ");
        sb2.append(nativeProcess);
        return null;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public void setmMaxHeight(int i10) {
        this.mMaxHeight = i10;
    }

    public void setmMaxWidth(int i10) {
        this.mMaxWidth = i10;
    }

    public void setmPowerLevel(int i10) {
        this.mPowerLevel = i10;
    }

    public int init(String str, String str2, int i10, int i11, EffectsSDKEffectConstants.ImageQulityPowerLevel imageQulityPowerLevel, boolean z10, EffectsSDKEffectConstants.LensVideoAlgType lensVideoAlgType) {
        return init(str, str2, i10, i11, imageQulityPowerLevel, false, z10, lensVideoAlgType);
    }
}
