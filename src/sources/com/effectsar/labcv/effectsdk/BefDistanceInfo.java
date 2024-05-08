package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.BefFaceInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefDistanceInfo {
    private float[] dists;
    private int faceCount;
    private BefFaceInfo.FaceRect[] faceRects;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefDistance {
        private float dis;
        private BefFaceInfo.FaceRect faceRect;

        public BefDistance(BefFaceInfo.FaceRect faceRect, float f10) {
            this.faceRect = faceRect;
            this.dis = f10;
        }

        public float getDis() {
            return this.dis;
        }

        public BefFaceInfo.FaceRect getFaceRect() {
            return this.faceRect;
        }
    }

    public BefDistance[] getBefDistance() {
        BefDistance[] befDistanceArr = new BefDistance[this.faceCount];
        for (int i10 = 0; i10 < this.faceCount; i10++) {
            befDistanceArr[i10] = new BefDistance(this.faceRects[i10], this.dists[i10]);
        }
        return befDistanceArr;
    }

    public float[] getDists() {
        return this.dists;
    }

    public int getFaceCount() {
        return this.faceCount;
    }

    public BefFaceInfo.FaceRect[] getFaceRects() {
        return this.faceRects;
    }

    public String toString() {
        return "";
    }
}
