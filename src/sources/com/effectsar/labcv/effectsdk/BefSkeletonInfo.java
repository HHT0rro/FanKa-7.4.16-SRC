package com.effectsar.labcv.effectsdk;

import android.graphics.PointF;
import com.effectsar.labcv.effectsdk.BefFaceInfo;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefSkeletonInfo {
    private int skeletonNum;
    private Skeleton[] skeletons;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Skeleton {
        public SkeletonPoint[] keypoints;
        public BefFaceInfo.FaceRect skeletonRect;

        public SkeletonPoint[] getKeypoints() {
            SkeletonPoint[] skeletonPointArr = this.keypoints;
            return skeletonPointArr == null ? new SkeletonPoint[0] : skeletonPointArr;
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
        public float f19174x;

        /* renamed from: y, reason: collision with root package name */
        public float f19175y;

        public SkeletonPoint(float f10, float f11, boolean z10, float f12) {
            this.f19174x = f10;
            this.f19175y = f11;
            this.is_detect = z10;
            this.score = f12;
        }

        public PointF asPoint() {
            return new PointF(this.f19174x, this.f19175y);
        }

        public float getScore() {
            return this.score;
        }

        public float getX() {
            return this.f19174x;
        }

        public float getY() {
            return this.f19175y;
        }

        public boolean isDetect() {
            return this.is_detect;
        }

        public boolean isIs_detect() {
            return this.is_detect;
        }

        public void setIs_detect(boolean z10) {
            this.is_detect = z10;
        }

        public void setScore(float f10) {
            this.score = f10;
        }

        public void setX(float f10) {
            this.f19174x = f10;
        }

        public void setY(float f10) {
            this.f19175y = f10;
        }

        public String toString() {
            return "SkeletonPoint{x=" + this.f19174x + ", y=" + this.f19175y + ", score=" + this.score + ", is_detect=" + this.is_detect + '}';
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
