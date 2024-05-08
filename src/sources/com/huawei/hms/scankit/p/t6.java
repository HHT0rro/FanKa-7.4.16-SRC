package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.util.SparseArray;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: ResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class t6 {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<Integer> f31552a;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>();
        f31552a = sparseArray;
        sparseArray.put(BarcodeFormat.AZTEC.ordinal(), Integer.valueOf(HmsScanBase.AZTEC_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODABAR.ordinal(), Integer.valueOf(HmsScanBase.CODABAR_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_39.ordinal(), Integer.valueOf(HmsScanBase.CODE39_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_93.ordinal(), Integer.valueOf(HmsScanBase.CODE93_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.CODE_128.ordinal(), Integer.valueOf(HmsScanBase.CODE128_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.DATA_MATRIX.ordinal(), Integer.valueOf(HmsScanBase.DATAMATRIX_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_8.ordinal(), Integer.valueOf(HmsScanBase.EAN8_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.EAN_13.ordinal(), Integer.valueOf(HmsScanBase.EAN13_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.ITF.ordinal(), Integer.valueOf(HmsScanBase.ITF14_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.PDF_417.ordinal(), Integer.valueOf(HmsScanBase.PDF417_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.QR_CODE.ordinal(), Integer.valueOf(HmsScanBase.QRCODE_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_A.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_A_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.UPC_E.ordinal(), Integer.valueOf(HmsScanBase.UPCCODE_E_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.WXCODE.ordinal(), Integer.valueOf(HmsScanBase.WX_SCAN_TYPE));
        sparseArray.put(BarcodeFormat.HARMONY_CODE.ordinal(), Integer.valueOf(HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE));
    }

    public static int a(BarcodeFormat barcodeFormat) {
        if (barcodeFormat == null) {
            return HmsScanBase.FORMAT_UNKNOWN;
        }
        Integer num = f31552a.get(barcodeFormat.ordinal());
        return num == null ? HmsScanBase.FORMAT_UNKNOWN : num.intValue();
    }

    public static String b(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length - 1);
        sb2.append(str.toCharArray(), 0, indexOf);
        boolean z10 = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z10 || charAt != '\\') {
                sb2.append(charAt);
                z10 = false;
            } else {
                z10 = true;
            }
            indexOf++;
        }
        return sb2.toString();
    }

    public abstract HmsScan b(s6 s6Var);

    public static Point[] a(u6[] u6VarArr) {
        if (u6VarArr == null || u6VarArr.length <= 0) {
            return new Point[0];
        }
        Point[] pointArr = new Point[u6VarArr.length];
        for (int i10 = 0; i10 < u6VarArr.length; i10++) {
            if (u6VarArr[i10] != null) {
                pointArr[i10] = new Point((int) u6VarArr[i10].b(), (int) u6VarArr[i10].c());
            }
        }
        return pointArr;
    }

    public static String a(s6 s6Var) {
        String k10 = s6Var.k();
        return k10 == null ? "" : k10.startsWith("\ufeff") ? k10.substring(1) : k10;
    }

    public static String a(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < str.length() ? str.substring(0, length) : str;
    }
}
