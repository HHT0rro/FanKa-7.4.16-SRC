package com.effectsar.labcv.effectsdk;

import android.graphics.Rect;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefLicenseCakeInfo {
    private LicenseCakeInfo[] licenseCakeInfos;
    private int licenseCakeNum;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BBoxRect {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public BBoxRect(int i10, int i11, int i12, int i13) {
            this.left = i10;
            this.right = i12;
            this.top = i11;
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

        public void setBottom(int i10) {
            this.bottom = i10;
        }

        public void setLeft(int i10) {
            this.left = i10;
        }

        public void setRight(int i10) {
            this.right = i10;
        }

        public void setTop(int i10) {
            this.top = i10;
        }

        public Rect toRect() {
            return new Rect(this.left, this.top, this.right, this.bottom);
        }

        public String toString() {
            return "FaceRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class LicenseCakeInfo {
        private float det_score = 0.0f;

        /* renamed from: id, reason: collision with root package name */
        private int f19169id;
        private int label;
        private BBoxRect rect;

        public float getDet_score() {
            return this.det_score;
        }

        public int getId() {
            return this.f19169id;
        }

        public int getLabel() {
            return this.label;
        }

        public BBoxRect getRect() {
            return this.rect;
        }

        public void setDet_score(float f10) {
            this.det_score = f10;
        }

        public void setId(int i10) {
            this.f19169id = i10;
        }

        public void setLabel(int i10) {
            this.label = i10;
        }

        public void setRect(BBoxRect bBoxRect) {
            this.rect = bBoxRect;
        }

        public String toString() {
            return "LicenseCakeInfo{id=" + this.f19169id + ", label=" + this.label + ", det_score=" + this.det_score + ", rect=" + ((Object) this.rect) + '}';
        }
    }

    public LicenseCakeInfo[] getLicenseCakeInfos() {
        return this.licenseCakeInfos;
    }

    public int getLicenseCakeNum() {
        return this.licenseCakeNum;
    }

    public void setLicenseCakeInfos(LicenseCakeInfo[] licenseCakeInfoArr) {
        this.licenseCakeInfos = licenseCakeInfoArr;
    }

    public void setLicenseCakeNum(int i10) {
        this.licenseCakeNum = i10;
    }

    public String toString() {
        return "BefLicenseCakeInfo{licenseCakeInfos=" + Arrays.toString(this.licenseCakeInfos) + ", licenseCakeNum=" + this.licenseCakeNum + '}';
    }
}
