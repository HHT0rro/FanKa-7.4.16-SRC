package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: EAN13Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class o2 extends q7 {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f31358j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    private String f31360i = "";

    /* renamed from: h, reason: collision with root package name */
    private final int[] f31359h = new int[4];

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int i10, int i11, r rVar) {
        return rVar.a(i11, (i11 - i10) + i11, false, false);
    }

    @Override // com.huawei.hms.scankit.p.q7
    public int a(r rVar, int[] iArr, StringBuilder sb2) throws a {
        int[] iArr2 = this.f31359h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e2 = rVar.e();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < e2; i12++) {
            int a10 = q7.a(rVar, iArr2, i10, q7.f31437g);
            sb2.append((char) ((a10 % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (a10 >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        a(sb2, i11);
        this.f31360i = sb2.substring(0, 1);
        int i14 = q7.a(rVar, i10, true, q7.f31434d)[1];
        for (int i15 = 0; i15 < 6 && i14 < e2; i15++) {
            sb2.append((char) (q7.a(rVar, iArr2, i14, q7.f31436f) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        if (a(sb2)) {
            return i14;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    public BarcodeFormat a() {
        return BarcodeFormat.EAN_13;
    }

    private static void a(StringBuilder sb2, int i10) throws a {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f31358j[i11]) {
                sb2.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw a.a();
    }

    private static boolean a(StringBuilder sb2) {
        int charAt = sb2.charAt(sb2.length() - 1) - '0';
        int i10 = 0;
        for (int i11 = 0; i11 < sb2.length() - 1; i11++) {
            i10 += i11 % 2 == 0 ? sb2.charAt(i11) - '0' : (sb2.charAt(i11) - '0') * 3;
        }
        return (i10 + charAt) % 10 == 0;
    }

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int[] iArr, int[] iArr2) throws a {
        int round = (int) Math.round((iArr2[1] - iArr[0]) / (((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0])) / 6.0d));
        return this.f31360i.equals("0") ? ((double) Math.abs(round + (-95))) <= 18.05d || ((double) Math.abs(round + (-113))) <= 21.47d : ((double) Math.abs(round + (-95))) <= 18.05d;
    }
}
