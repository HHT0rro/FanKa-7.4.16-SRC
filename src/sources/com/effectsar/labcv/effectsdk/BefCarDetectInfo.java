package com.effectsar.labcv.effectsdk;

import androidx.exifinterface.media.ExifInterface;
import com.effectsar.labcv.effectsdk.BefPublicDefine;
import com.huawei.hms.ads.ContentClassification;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefCarDetectInfo {
    private double blurScore;
    private BefBrandInfo[] brandInfos;
    private BefCarRect[] carRects;
    private double grayScore;
    private int carCount = 0;
    private int brandCount = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefBrandInfo {
        public int brandId;
        public int[] brandOcr;
        private String[] ocrTable = {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z", "云", "京", "冀", "吉", "宁", "川", "新", "晋", "桂", "沪", "津", "浙", "渝", "湘", "琼", "甘", "皖", "粤", "苏", "蒙", "藏", "豫", "贵", "赣", "辽", "鄂", "闽", "陕", "青", "鲁", "黑"};
        public BefPublicDefine.BefPointF[] points;

        public int getBrandId() {
            return this.brandId;
        }

        public int[] getBrandOcr() {
            return this.brandOcr;
        }

        public String getBrandOcrString() {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 : this.brandOcr) {
                sb2.append(this.ocrTable[i10]);
            }
            return sb2.toString();
        }

        public BefPublicDefine.BefPointF[] getPoints() {
            return this.points;
        }

        public void setBrandId(int i10) {
            this.brandId = i10;
        }

        public void setPoints(BefPublicDefine.BefPointF[] befPointFArr) {
            this.points = befPointFArr;
        }
    }

    public double getBlurScore() {
        return this.blurScore;
    }

    public int getBrandCount() {
        return this.brandCount;
    }

    public BefBrandInfo[] getBrandInfos() {
        return this.brandInfos;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public BefCarRect[] getCarRects() {
        return this.carRects;
    }

    public double getGrayScore() {
        return this.grayScore;
    }

    public void setBrandCount(int i10) {
        this.brandCount = i10;
    }

    public void setBrandInfos(BefBrandInfo[] befBrandInfoArr) {
        this.brandInfos = befBrandInfoArr;
    }

    public void setCarCount(int i10) {
        this.carCount = i10;
    }

    public void setCarRects(BefCarRect[] befCarRectArr) {
        this.carRects = befCarRectArr;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class BefCarRect extends BefPublicDefine.BefRect {
        private int orientation;

        public BefCarRect(int i10, int i11, int i12, int i13) {
            super(i10, i11, i12, i13);
            this.orientation = 0;
        }

        public int getOrientation() {
            return this.orientation;
        }

        public void setOrientation(int i10) {
            this.orientation = i10;
        }

        public BefCarRect(int i10, int i11, int i12, int i13, int i14) {
            super(i10, i11, i12, i13);
            this.orientation = i14;
        }
    }
}
