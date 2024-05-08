package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefPublicDefine {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefCapturedImageInfo {
        public int format;
        public int height;
        public int rotate;
        public int stride;
        public int width;

        public String toString() {
            return "BefCapturedImageInfo{width=" + this.width + ", height=" + this.height + ", stride=" + this.stride + ", format=" + this.format + ", rotate=" + this.rotate;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefKeyPoint {
        private boolean isDetect;

        /* renamed from: x, reason: collision with root package name */
        private float f19170x;

        /* renamed from: y, reason: collision with root package name */
        private float f19171y;

        public BefKeyPoint(float f10, float f11, boolean z10) {
            this.f19170x = f10;
            this.f19171y = f11;
            this.isDetect = z10;
        }

        public float getX() {
            return this.f19170x;
        }

        public float getY() {
            return this.f19171y;
        }

        public boolean isDetect() {
            return this.isDetect;
        }

        public void setDetect(boolean z10) {
            this.isDetect = z10;
        }

        public void setX(float f10) {
            this.f19170x = f10;
        }

        public void setY(float f10) {
            this.f19171y = f10;
        }

        public String toString() {
            return "BefKeyPoint{x=" + this.f19170x + ", y=" + this.f19171y + ", isDetected=" + this.isDetect + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefPointF {

        /* renamed from: x, reason: collision with root package name */
        private float f19172x;

        /* renamed from: y, reason: collision with root package name */
        private float f19173y;

        public BefPointF(float f10, float f11) {
            this.f19172x = f10;
            this.f19173y = f11;
        }

        public float getX() {
            return this.f19172x;
        }

        public float getY() {
            return this.f19173y;
        }

        public void setX(float f10) {
            this.f19172x = f10;
        }

        public void setY(float f10) {
            this.f19173y = f10;
        }

        public String toString() {
            return "BefPointF{x=" + this.f19172x + ", y=" + this.f19173y;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefRect {
        private int bottom;
        private int left;
        private int right;
        private int top;

        public BefRect(int i10, int i11, int i12, int i13) {
            this.left = i10;
            this.top = i11;
            this.right = i12;
            this.bottom = i13;
        }

        public int getBottom() {
            return this.bottom;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getTop() {
            return this.top;
        }

        public String toString() {
            return "BefRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
    }
}
