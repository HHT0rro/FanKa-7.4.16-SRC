package com.huawei.hms.scankit.p;

import com.huawei.appgallery.agd.api.AgdConstant;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: UPCEReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s7 extends q7 {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f31527i = {1, 1, 1, 1, 1, 1};

    /* renamed from: j, reason: collision with root package name */
    public static final int[][] f31528j = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: h, reason: collision with root package name */
    private final int[] f31529h = new int[4];

    private int b(r rVar, int[] iArr, int i10, int[][] iArr2) throws a {
        g5.a(rVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.45f;
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
        return rVar.a(i11, (i11 - i10) + i11, false, true);
    }

    @Override // com.huawei.hms.scankit.p.q7
    public int a(r rVar, int[] iArr, StringBuilder sb2) throws a {
        int[] iArr2 = this.f31529h;
        int i10 = 0;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e2 = rVar.e();
        int i11 = iArr[1];
        float f10 = 10000.0f;
        int i12 = 0;
        int i13 = 0;
        float f11 = 0.0f;
        while (i12 < 6 && i11 < e2) {
            int b4 = b(rVar, iArr2, i11, q7.f31437g);
            sb2.append((char) ((b4 % 10) + 48));
            int i14 = 0;
            float f12 = 0.0f;
            while (true) {
                if (i14 >= q7.f31437g[b4].length) {
                    break;
                }
                f12 += r17[b4][i14];
                i14++;
            }
            float f13 = (((iArr2[i10] + iArr2[1]) + iArr2[2]) + iArr2[3]) / f12;
            if (f13 > f11) {
                f11 = f13;
            }
            if (f13 < f10) {
                f10 = f13;
            }
            int length = iArr2.length;
            while (i10 < length) {
                i11 += iArr2[i10];
                i10++;
            }
            if (b4 >= 10) {
                i13 |= 1 << (5 - i12);
            }
            i12++;
            i10 = 0;
        }
        if (f11 / f10 <= 2.89d) {
            a(sb2, i13);
            return i11;
        }
        throw a.a();
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb2 = new StringBuilder(12);
        sb2.append(str.charAt(0));
        char c4 = cArr[5];
        switch (c4) {
            case '0':
            case '1':
            case '2':
                sb2.append(cArr, 0, 2);
                sb2.append(c4);
                sb2.append(AgdConstant.INSTALL_TYPE_DEFAULT);
                sb2.append(cArr, 2, 3);
                break;
            case '3':
                sb2.append(cArr, 0, 3);
                sb2.append("00000");
                sb2.append(cArr, 3, 2);
                break;
            case '4':
                sb2.append(cArr, 0, 4);
                sb2.append("00000");
                sb2.append(cArr[4]);
                break;
            default:
                sb2.append(cArr, 0, 5);
                sb2.append(AgdConstant.INSTALL_TYPE_DEFAULT);
                sb2.append(c4);
                break;
        }
        if (str.length() >= 8) {
            sb2.append(str.charAt(7));
        }
        return sb2.toString();
    }

    @Override // com.huawei.hms.scankit.p.q7
    public int[] a(r rVar, int i10) throws a {
        return q7.a(rVar, i10, true, f31527i);
    }

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(String str) throws a {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb2, int i10) throws a {
        for (int i11 = 0; i11 <= 1; i11++) {
            for (int i12 = 0; i12 < 10; i12++) {
                if (i10 == f31528j[i11][i12]) {
                    sb2.insert(0, (char) (i11 + 48));
                    sb2.append((char) (i12 + 48));
                    return;
                }
            }
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    public BarcodeFormat a() {
        return BarcodeFormat.UPC_E;
    }

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int[] iArr, int[] iArr2) throws a {
        return ((double) Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 9.0d))) + (-51))) <= 10.200000000000001d && Math.abs(1.0d - ((((double) (iArr[1] - iArr[0])) / 3.0d) / (((double) (iArr2[1] - iArr2[0])) / 6.0d))) < 0.2d;
    }
}
