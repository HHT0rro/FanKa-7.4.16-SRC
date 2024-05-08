package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefAvatarInfo {
    public float[] affineMat;
    public float[] alpha;
    public float[] beta;
    public int faceId;
    public float[] landmarks;
    public float[] mv;
    public float[] mvp;
    public float[] rot;
    public int success;

    public float[] getAffineMat() {
        return this.affineMat;
    }

    public float[] getAlpha() {
        return this.alpha;
    }

    public float[] getBeta() {
        return this.beta;
    }

    public int getFaceId() {
        return this.faceId;
    }

    public float[] getLandmarks() {
        return this.landmarks;
    }

    public float[] getMv() {
        return this.mv;
    }

    public float[] getMvp() {
        return this.mvp;
    }

    public float[] getRot() {
        return this.rot;
    }

    public int isSuccess() {
        return this.success;
    }

    public String toString() {
        return "BefAvatarInfo{success=" + this.success + ", faceId=" + this.faceId + ", affineMat=" + Arrays.toString(this.affineMat) + ", alpha=" + Arrays.toString(this.alpha) + ", beta=" + Arrays.toString(this.beta) + '}';
    }
}
