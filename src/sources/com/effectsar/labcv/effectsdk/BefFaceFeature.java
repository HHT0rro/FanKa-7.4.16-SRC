package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.BefFaceInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefFaceFeature {
    private BefFaceInfo.Face106[] baseInfo;
    private float[][] features;
    private int validFaceNum;

    public BefFaceInfo.Face106[] getBaseInfo() {
        return this.baseInfo;
    }

    public float[][] getFeatures() {
        return this.features;
    }

    public int getValidFaceNum() {
        return this.validFaceNum;
    }

    public String toString() {
        return "BefFaceFeature{ validFaceNum =" + this.validFaceNum + " baseInfo = " + this.baseInfo.toString() + " features =" + this.features.toString();
    }
}
