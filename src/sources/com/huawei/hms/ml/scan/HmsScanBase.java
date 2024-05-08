package com.huawei.hms.ml.scan;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.hmsscankit.DetailRect;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class HmsScanBase implements Parcelable {
    public static final int ALL_SCAN_TYPE = 8191;
    public static final int OTHER_FORM = -1;
    public static final String SCAN_ERROR_CHECK_FLAG = "ScanErrorCheck";
    public static final String SCAN_FORMAT_FLAG = "ScanFormatValue";
    public static final String SCAN_GUIDE_FLAG = "ScanGuide";
    public static final String SCAN_VIEW_FLAG = "ScanViewValue";
    private int HMS_SCAN_VERSION;
    public Point[] cornerPoints;
    public HmsScanAnalyzerOptions options;
    public byte[] originValueByte;
    public Bitmap originalBitmap;
    public String originalValue;
    public int scanType;
    public int scanTypeForm;
    public String showResult;
    public double zoomValue;
    public static final int FORMAT_UNKNOWN = SCAN_TYPE.FORMAT_UNKNOWN.getUnKnown();
    public static final int QRCODE_SCAN_TYPE = SCAN_TYPE.QRCODE_SCAN_TYPE.getScanType();
    public static final int AZTEC_SCAN_TYPE = SCAN_TYPE.AZTEC_SCAN_TYPE.getScanType();
    public static final int DATAMATRIX_SCAN_TYPE = SCAN_TYPE.DATAMATRIX_SCAN_TYPE.getScanType();
    public static final int PDF417_SCAN_TYPE = SCAN_TYPE.PDF417_SCAN_TYPE.getScanType();
    public static final int CODE39_SCAN_TYPE = SCAN_TYPE.CODE39_SCAN_TYPE.getScanType();
    public static final int CODE93_SCAN_TYPE = SCAN_TYPE.CODE93_SCAN_TYPE.getScanType();
    public static final int CODE128_SCAN_TYPE = SCAN_TYPE.CODE128_SCAN_TYPE.getScanType();
    public static final int EAN13_SCAN_TYPE = SCAN_TYPE.EAN13_SCAN_TYPE.getScanType();
    public static final int EAN8_SCAN_TYPE = SCAN_TYPE.EAN8_SCAN_TYPE.getScanType();
    public static final int ITF14_SCAN_TYPE = SCAN_TYPE.ITF14_SCAN_TYPE.getScanType();
    public static final int UPCCODE_A_SCAN_TYPE = SCAN_TYPE.UPCCODE_A_SCAN_TYPE.getScanType();
    public static final int UPCCODE_E_SCAN_TYPE = SCAN_TYPE.UPCCODE_E_SCAN_TYPE.getScanType();
    public static final int CODABAR_SCAN_TYPE = SCAN_TYPE.CODABAR_SCAN_TYPE.getScanType();
    public static final int MULTI_FUNCTIONAL_SCAN_TYPE = SCAN_TYPE.MULTI_FUNCTIONAL_SCAN_TYPE.getScanType();
    public static final int WX_SCAN_TYPE = SCAN_TYPE.WX_SCAN_TYPE.getScanType();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum SCAN_TYPE {
        FORMAT_UNKNOWN(-1),
        ALL_SCAN_TYPE(0),
        QRCODE_SCAN_TYPE(0),
        AZTEC_SCAN_TYPE(1),
        DATAMATRIX_SCAN_TYPE(2),
        PDF417_SCAN_TYPE(3),
        CODE39_SCAN_TYPE(4),
        CODE93_SCAN_TYPE(5),
        CODE128_SCAN_TYPE(6),
        EAN13_SCAN_TYPE(7),
        EAN8_SCAN_TYPE(8),
        ITF14_SCAN_TYPE(9),
        UPCCODE_A_SCAN_TYPE(10),
        UPCCODE_E_SCAN_TYPE(11),
        CODABAR_SCAN_TYPE(12),
        MULTI_FUNCTIONAL_SCAN_TYPE(13),
        WX_SCAN_TYPE(14);

        private final int scanType;

        SCAN_TYPE(int i10) {
            this.scanType = i10;
        }

        public int getScanType() {
            return 1 << this.scanType;
        }

        public int getUnKnown() {
            return this.scanType;
        }
    }

    public HmsScanBase() {
        this.HMS_SCAN_VERSION = 3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract void detailTrans(Parcel parcel);

    public abstract void detailTransOut(Parcel parcel, int i10);

    public Rect getBorderRect() {
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = 0;
        while (true) {
            Point[] pointArr = this.cornerPoints;
            if (i14 < pointArr.length) {
                Point point = pointArr[i14];
                i12 = Math.min(i12, point.x);
                i13 = Math.min(i13, point.y);
                i10 = Math.max(i10, point.x);
                i11 = Math.max(i11, point.y);
                i14++;
            } else {
                return new Rect(i12, i13, i10, i11);
            }
        }
    }

    public Point[] getCornerPoints() {
        return this.cornerPoints;
    }

    public byte[] getOriginValueByte() {
        return this.originValueByte;
    }

    public Bitmap getOriginalBitmap() {
        return this.originalBitmap;
    }

    public String getOriginalValue() {
        return this.originalValue;
    }

    public int getScanType() {
        return this.scanType;
    }

    public int getScanTypeForm() {
        return this.scanTypeForm;
    }

    public String getShowResult() {
        return this.showResult;
    }

    public double getZoomValue() {
        return this.zoomValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.HMS_SCAN_VERSION);
        parcel.writeInt(this.scanType);
        parcel.writeString(this.originalValue);
        parcel.writeInt(this.scanTypeForm);
        parcel.writeString(this.showResult);
        parcel.writeTypedArray(this.cornerPoints, i10);
        parcel.writeDouble(this.zoomValue);
        parcel.writeByteArray(this.originValueByte);
        detailTransOut(parcel, i10);
        if (DetailRect.HMSSCAN_SDK_VALUE >= 3) {
            parcel.writeParcelable(this.originalBitmap, i10);
        }
    }

    public HmsScanBase(String str, int i10, String str2, int i11, byte[] bArr, Point[] pointArr, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        this.HMS_SCAN_VERSION = 3;
        this.originalValue = str;
        this.scanType = i10;
        this.showResult = str2;
        this.scanTypeForm = i11;
        this.originValueByte = bArr;
        this.cornerPoints = pointArr;
        this.options = hmsScanAnalyzerOptions;
    }

    public HmsScanBase(Parcel parcel) {
        this.HMS_SCAN_VERSION = 3;
        int readInt = parcel.readInt();
        this.HMS_SCAN_VERSION = readInt;
        if (readInt >= 1) {
            this.scanType = parcel.readInt();
            this.originalValue = parcel.readString();
            this.scanTypeForm = parcel.readInt();
            this.showResult = parcel.readString();
            this.cornerPoints = (Point[]) parcel.createTypedArray(Point.CREATOR);
            this.zoomValue = parcel.readDouble();
            this.originValueByte = parcel.createByteArray();
            detailTrans(parcel);
        }
        if (this.HMS_SCAN_VERSION >= 3) {
            this.originalBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        }
    }
}
