package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FormatsList.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n3 {
    public static List<List<BarcodeFormat>> a(int i10) {
        int i11 = i10 <= 0 ? HmsScanBase.ALL_SCAN_TYPE : i10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        if (i11 > 0) {
            BarcodeFormat[] barcodeFormatArr = {BarcodeFormat.CODE_128, BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODABAR, BarcodeFormat.DATA_MATRIX, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.ITF, BarcodeFormat.QR_CODE, BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.PDF_417, BarcodeFormat.AZTEC, BarcodeFormat.HARMONY_CODE, BarcodeFormat.WXCODE};
            int[] iArr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
            if ((i11 & iArr[8]) != 0) {
                arrayList.add(barcodeFormatArr[8]);
            }
            if ((iArr[11] & i11) != 0) {
                arrayList3.add(barcodeFormatArr[11]);
            }
            int i12 = 0;
            for (int i13 = 15; i12 < i13; i13 = 15) {
                if ((i11 & iArr[i12]) != 0 && i12 != 8 && i12 != 11) {
                    if (i12 == 4) {
                        arrayList5.add(barcodeFormatArr[i12]);
                    } else if (i12 == 12) {
                        arrayList4.add(barcodeFormatArr[i12]);
                    } else if (i12 == 13) {
                        arrayList6.add(barcodeFormatArr[i12]);
                    } else if (i12 == 14) {
                        arrayList7.add(barcodeFormatArr[i12]);
                    } else {
                        arrayList2.add(barcodeFormatArr[i12]);
                    }
                }
                i12++;
            }
        }
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(arrayList);
        arrayList8.add(arrayList2);
        arrayList8.add(arrayList3);
        arrayList8.add(arrayList5);
        arrayList8.add(arrayList4);
        arrayList8.add(arrayList6);
        arrayList8.add(arrayList7);
        return arrayList8;
    }
}
