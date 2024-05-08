package com.effectsar.labcv.effectsdk;

import android.graphics.PointF;
import com.effectsar.labcv.effectsdk.BefFaceInfo;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefBachSkeletonInfo {
    private int skeletonNum;
    private Skeleton[] skeletons;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Skeleton {

        /* renamed from: id, reason: collision with root package name */
        public int f19157id;
        public SkeletonPoint[] keypoints;
        public int orientation;
        public BefFaceInfo.FaceRect skeletonRect;

        public int getId() {
            return this.f19157id;
        }

        public SkeletonPoint[] getKeypoints() {
            SkeletonPoint[] skeletonPointArr = this.keypoints;
            return skeletonPointArr == null ? new SkeletonPoint[0] : skeletonPointArr;
        }

        public int getOrientation() {
            return this.orientation;
        }

        public BefFaceInfo.FaceRect getSkeletonRect() {
            return this.skeletonRect;
        }

        public String toString() {
            return "Skeleton{keypoints=" + Arrays.toString(this.keypoints) + ", skeletonRect=" + ((Object) this.skeletonRect) + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SkeletonPoint {
        public boolean is_detect;
        public float score;

        /* renamed from: x, reason: collision with root package name */
        public float f19158x;

        /* renamed from: y, reason: collision with root package name */
        public float f19159y;

        public SkeletonPoint(float f10, float f11, boolean z10, float f12) {
            this.f19158x = f10;
            this.f19159y = f11;
            this.is_detect = z10;
            this.score = f12;
        }

        public PointF asPoint() {
            return new PointF(this.f19158x, this.f19159y);
        }

        public float getScore() {
            return this.score;
        }

        public float getX() {
            return this.f19158x;
        }

        public float getY() {
            return this.f19159y;
        }

        public boolean isDetect() {
            return this.is_detect;
        }

        public void setIs_detect(boolean z10) {
            this.is_detect = z10;
        }

        public void setX(float f10) {
            this.f19158x = f10;
        }

        public void setY(float f10) {
            this.f19159y = f10;
        }

        public String toString() {
            return "FacePoint{x=" + this.f19158x + ", y=" + this.f19159y + ", isdetect=" + String.valueOf(this.is_detect) + '}';
        }
    }

    public int getSkeletonNum() {
        return this.skeletonNum;
    }

    public Skeleton[] getSkeletons() {
        Skeleton[] skeletonArr = this.skeletons;
        return skeletonArr == null ? new Skeleton[0] : skeletonArr;
    }

    public void setSkeletonNum(int i10) {
        this.skeletonNum = i10;
    }

    public String toString() {
        return "BefSkeletonInfo{skeletons=" + Arrays.toString(this.skeletons) + ", skeletonNum=" + this.skeletonNum + '}';
    }
}
