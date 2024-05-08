package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UPCEANExtension5Support.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class o7 {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f31379c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    private final int[] f31380a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f31381b = new StringBuilder();

    public s6 a(int i10, r rVar, int[] iArr) throws a {
        StringBuilder sb2 = this.f31381b;
        sb2.setLength(0);
        float f10 = i10;
        return new s6(sb2.toString(), null, new u6[]{new u6((iArr[0] + iArr[1]) / 2.0f, f10), new u6(a(rVar, iArr, sb2), f10)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    private int a(r rVar, int[] iArr, StringBuilder sb2) throws a {
        int[] iArr2 = this.f31380a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e2 = rVar.e();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 5 && i10 < e2; i12++) {
            int a10 = q7.a(rVar, iArr2, i10, q7.f31437g);
            sb2.append((char) ((a10 % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (a10 >= 10) {
                i11 |= 1 << (4 - i12);
            }
            if (i12 != 4) {
                i10 = rVar.d(rVar.c(i10));
            }
        }
        if (sb2.length() == 5) {
            if (a(sb2.toString()) == a(i11)) {
                return i10;
            }
            throw a.a();
        }
        throw a.a();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 2; i11 >= 0; i11 -= 2) {
            i10 += charSequence.charAt(i11) - '0';
        }
        int i12 = i10 * 3;
        for (int i13 = length - 1; i13 >= 0; i13 -= 2) {
            i12 += charSequence.charAt(i13) - '0';
        }
        return (i12 * 3) % 10;
    }

    private static int a(int i10) throws a {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f31379c[i11]) {
                return i11;
            }
        }
        throw a.a();
    }
}
