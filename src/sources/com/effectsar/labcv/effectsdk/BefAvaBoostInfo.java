package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefAvaBoostInfo {
    public float[] beta;
    public float[] pose;

    public float[] getBeta() {
        return this.beta;
    }

    public float[] getPose() {
        return this.pose;
    }

    public String toString() {
        return "BefAvaBoostInfo{beta=" + Arrays.toString(this.beta) + ", pose=" + Arrays.toString(this.pose) + '}';
    }
}
