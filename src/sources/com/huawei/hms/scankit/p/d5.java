package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultipleBarcodeDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d5 {

    /* renamed from: a, reason: collision with root package name */
    public List<i2> f30840a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f30841b = 0;

    public void a(boolean z10, byte[] bArr, int i10, int i11, int i12, boolean z11) {
        float[] multiBarcodeDetect = LoadOpencvJNIUtil.multiBarcodeDetect(bArr, i10, i11, i12, z11);
        if (multiBarcodeDetect != null) {
            this.f30841b = multiBarcodeDetect.length / 10;
        } else {
            this.f30841b = 0;
        }
        for (int i13 = 0; i13 < this.f30841b; i13++) {
            int i14 = i13 * 10;
            if (w7.a(multiBarcodeDetect, i14)) {
                int i15 = i14 + 1;
                if (w7.a(multiBarcodeDetect, i15)) {
                    int i16 = i14 + 2;
                    if (w7.a(multiBarcodeDetect, i16)) {
                        int i17 = i14 + 3;
                        if (w7.a(multiBarcodeDetect, i17)) {
                            int i18 = i14 + 4;
                            if (w7.a(multiBarcodeDetect, i18)) {
                                int i19 = i14 + 5;
                                if (w7.a(multiBarcodeDetect, i19)) {
                                    int i20 = i14 + 6;
                                    if (w7.a(multiBarcodeDetect, i20)) {
                                        int i21 = i14 + 7;
                                        if (w7.a(multiBarcodeDetect, i21)) {
                                            int i22 = i14 + 8;
                                            if (w7.a(multiBarcodeDetect, i22)) {
                                                int i23 = i14 + 9;
                                                if (w7.a(multiBarcodeDetect, i23)) {
                                                    this.f30840a.add(new i2(z10, multiBarcodeDetect[i14], multiBarcodeDetect[i15], multiBarcodeDetect[i16], multiBarcodeDetect[i17], multiBarcodeDetect[i18], multiBarcodeDetect[i19], multiBarcodeDetect[i20], multiBarcodeDetect[i21], multiBarcodeDetect[i22], multiBarcodeDetect[i23]));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
