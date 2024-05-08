package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: EAN8Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class q2 extends q7 {

    /* renamed from: h, reason: collision with root package name */
    private final int[] f31420h = new int[4];

    private int b(r rVar, int[] iArr, int i10, int[][] iArr2) throws a {
        g5.a(rVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.43f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float a10 = g5.a(iArr, iArr2[i12], 0.7f);
            if (a10 < f10) {
                i11 = i12;
                f10 = a10;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int i10, int i11, r rVar) {
        return rVar.a(i11, ((int) ((i11 - i10) * 1.5d)) + i11, false, true);
    }

    @Override // com.huawei.hms.scankit.p.q7
    public int a(r rVar, int[] iArr, StringBuilder sb2) throws a {
        int[] iArr2 = this.f31420h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e2 = rVar.e();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < e2; i11++) {
            sb2.append((char) (b(rVar, iArr2, i10, q7.f31436f) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = q7.a(rVar, i10, true, q7.f31434d)[1];
        for (int i14 = 0; i14 < 4 && i13 < e2; i14++) {
            sb2.append((char) (b(rVar, iArr2, i13, q7.f31436f) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // com.huawei.hms.scankit.p.q7
    public BarcodeFormat a() {
        return BarcodeFormat.EAN_8;
    }

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int[] iArr, int[] iArr2) throws a {
        return ((double) Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 6.0d))) + (-67))) <= 6.7d && Math.abs(1.0d - ((((double) (iArr[1] - iArr[0])) / 3.0d) / (((double) (iArr2[1] - iArr2[0])) / 3.0d))) < 0.2d;
    }
}
