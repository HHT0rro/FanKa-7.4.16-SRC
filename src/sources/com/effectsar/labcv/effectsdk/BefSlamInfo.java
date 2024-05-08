package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefSlamInfo {
    public SlamPose cameraPose;
    public Points[] featurePoints;
    public SlamCameraIntrinsic intrinsic;
    public boolean isClicked;
    public SlamPlane planeInfo;
    public SlamPose planePose;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Points {

        /* renamed from: x, reason: collision with root package name */
        public float f19176x;

        /* renamed from: y, reason: collision with root package name */
        public float f19177y;

        public Points(float f10, float f11) {
            this.f19176x = f10;
            this.f19177y = f11;
        }

        public float getX() {
            return this.f19176x;
        }

        public float getY() {
            return this.f19177y;
        }

        public void setX(float f10) {
            this.f19176x = f10;
        }

        public void setY(float f10) {
            this.f19177y = f10;
        }

        public String toString() {
            return "Points{x=" + this.f19176x + ", y=" + this.f19177y + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SlamCameraInfo {
        public SlamCameraIntrinsic cameraIntrinsic;
        public int color;
        public int disable_internal_time_delay;
        public int easyInit;
        public int enableFusion;
        public int height;
        public float horizontal_fov;
        public int isFront;
        public int isVideo;
        public int level;
        public boolean low_texture_enhanced;
        public int orienation;
        public int resolution;
        public int runGba;
        public int width;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SlamCameraIntrinsic {
        public float cx;
        public float cy;
        public float fx;
        public float fy;

        public SlamCameraIntrinsic(float f10, float f11, float f12, float f13) {
            this.fx = f10;
            this.fy = f11;
            this.cx = f12;
            this.cy = f13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SlamClickFlag {
        public int isClicked;

        /* renamed from: x, reason: collision with root package name */
        public float f19178x;

        /* renamed from: y, reason: collision with root package name */
        public float f19179y;

        public int getIsClicked() {
            return this.isClicked;
        }

        public float getX() {
            return this.f19178x;
        }

        public float getY() {
            return this.f19179y;
        }

        public void setIsClicked(int i10) {
            this.isClicked = i10;
        }

        public void setX(float f10) {
            this.f19178x = f10;
        }

        public void setY(float f10) {
            this.f19179y = f10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SlamImuData {
        public double timeStamp;

        /* renamed from: x, reason: collision with root package name */
        public double f19180x;

        /* renamed from: y, reason: collision with root package name */
        public double f19181y;

        /* renamed from: z, reason: collision with root package name */
        public double f19182z;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SlamImuInfo {
        public int hasAccelerometer;
        public int hasGravity;
        public int hasGyroscope;
        public int hasOrientation;

        public void setHasAccelerometer(int i10) {
            this.hasAccelerometer = i10;
        }

        public void setHasGravity(int i10) {
            this.hasGravity = i10;
        }

        public void setHasGyroscope(int i10) {
            this.hasGyroscope = i10;
        }

        public void setHasOrientation(int i10) {
            this.hasOrientation = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SlamPlane {
        public float[] boundary;
        public int hasPlane;
        public float[] normal;
        public float offset;
        public float[] origin;
        public float[] originWorld;
        public int[] planePointsIds;

        public SlamPlane(int i10, float[] fArr, float f10, float[] fArr2, float[] fArr3, float[] fArr4, int[] iArr) {
            this.hasPlane = i10;
            this.normal = fArr;
            this.offset = f10;
            this.originWorld = fArr2;
            this.origin = fArr3;
            this.boundary = fArr4;
            this.planePointsIds = iArr;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class SlamPose {
        public float[] R;
        public float[] T;
        public int planeDetected;
        public double timeStamp;
        public int trackingState;

        public SlamPose(float[] fArr, float[] fArr2, int i10, int i11, double d10) {
            this.R = fArr;
            this.T = fArr2;
            this.planeDetected = i10;
            this.timeStamp = d10;
            this.trackingState = i11;
        }

        public int getPlaneDetected() {
            return this.planeDetected;
        }

        public float[] getR() {
            return this.R;
        }

        public float[] getT() {
            return this.T;
        }

        public double getTimeStamp() {
            return this.timeStamp;
        }

        public int getTrackingState() {
            return this.trackingState;
        }

        public String toString() {
            return "SlamPose{R=" + Arrays.toString(this.R) + ", T=" + Arrays.toString(this.T) + ", planeDetected=" + this.planeDetected + ", trackingState=" + this.trackingState + '}';
        }
    }
}
