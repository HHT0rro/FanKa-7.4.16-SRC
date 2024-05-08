package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: CodaBarReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p0 extends g5 {

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f31384e = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f31385f = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: g, reason: collision with root package name */
    private static final char[] f31386g = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f31387a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private int[] f31388b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    private int f31389c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f31390d;

    private int b() throws a {
        for (int i10 = 1; i10 < this.f31389c; i10 += 2) {
            int b4 = b(i10);
            if (b4 != -1 && a(f31386g, f31384e[b4])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f31388b[i12];
                }
                if (i10 == 1 || this.f31388b[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw a.a();
    }

    private void c(int i10) throws a {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f31387a.length() - 1;
        int i11 = 0;
        int i12 = i10;
        int i13 = 0;
        while (true) {
            int i14 = f31385f[this.f31387a.charAt(i13)];
            for (int i15 = 6; i15 >= 0; i15--) {
                int i16 = (i15 & 1) + ((i14 & 1) * 2);
                iArr[i16] = iArr[i16] + this.f31388b[i12 + i15];
                iArr2[i16] = iArr2[i16] + 1;
                i14 >>= 1;
            }
            if (i13 >= length) {
                break;
            }
            i12 += 8;
            i13++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i17 = 0; i17 < 2; i17++) {
            fArr2[i17] = 0.0f;
            int i18 = i17 + 2;
            fArr2[i18] = ((iArr[i17] / iArr2[i17]) + (iArr[i18] / iArr2[i18])) / 2.0f;
            fArr[i17] = fArr2[i18];
            fArr[i18] = ((iArr[i18] * 2.0f) + 1.5f) / iArr2[i18];
        }
        loop3: while (true) {
            int i19 = f31385f[this.f31387a.charAt(i11)];
            for (int i20 = 6; i20 >= 0; i20--) {
                int i21 = (i20 & 1) + ((i19 & 1) * 2);
                float f10 = this.f31388b[i10 + i20];
                if (f10 < fArr2[i21] || f10 > fArr[i21]) {
                    break loop3;
                }
                i19 >>= 1;
            }
            if (i11 >= length) {
                return;
            }
            i10 += 8;
            i11++;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a {
        Arrays.fill(this.f31388b, 0);
        a(rVar);
        int[] a10 = a();
        int i11 = a10[0];
        int i12 = a10[1];
        for (int i13 = 0; i13 < this.f31387a.length(); i13++) {
            StringBuilder sb2 = this.f31387a;
            sb2.setCharAt(i13, f31384e[sb2.charAt(i13)]);
        }
        char charAt = this.f31387a.charAt(0);
        char[] cArr = f31386g;
        if (a(cArr, charAt)) {
            StringBuilder sb3 = this.f31387a;
            if (a(cArr, sb3.charAt(sb3.length() - 1))) {
                if (this.f31387a.length() > 3) {
                    int i14 = this.f31390d;
                    for (int i15 = 0; i15 < i11; i15++) {
                        i14 += this.f31388b[i15];
                    }
                    float f10 = i14;
                    while (i11 < i12 - 1) {
                        i14 += this.f31388b[i11];
                        i11++;
                    }
                    float f11 = i10;
                    return new s6(this.f31387a.toString(), null, new u6[]{new u6(f10, f11), new u6(i14, f11)}, BarcodeFormat.CODABAR);
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private int b(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.f31389c) {
            return -1;
        }
        int[] iArr = this.f31388b;
        HashSet hashSet = new HashSet();
        for (int i12 = i10; i12 < i11; i12++) {
            hashSet.add(Integer.valueOf(iArr[i12]));
        }
        Iterator<E> iterator2 = hashSet.iterator2();
        int i13 = 0;
        int i14 = 0;
        while (iterator2.hasNext()) {
            i14 += ((Integer) iterator2.next()).intValue();
        }
        if (hashSet.size() > 0) {
            int size = i14 / hashSet.size();
            int i15 = 128;
            int i16 = 0;
            for (int i17 = 0; i17 < 7; i17++) {
                i15 >>= 1;
                if (iArr[i10 + i17] > size) {
                    i16 |= i15;
                }
            }
            while (true) {
                int[] iArr2 = f31385f;
                if (i13 >= iArr2.length) {
                    break;
                }
                if (iArr2[i13] == i16) {
                    return i13;
                }
                i13++;
            }
        }
        return -1;
    }

    private int[] a() throws a {
        int b4 = b();
        this.f31387a.setLength(0);
        int i10 = b4;
        do {
            int b10 = b(i10);
            if (b10 != -1) {
                this.f31387a.append((char) b10);
                i10 += 8;
                if (this.f31387a.length() > 1 && a(f31386g, f31384e[b10])) {
                    break;
                }
            } else {
                throw a.a();
            }
        } while (i10 < this.f31389c);
        int i11 = this.f31388b[i10 - 1];
        int i12 = 0;
        for (int i13 = -8; i13 < -1; i13++) {
            i12 += this.f31388b[i10 + i13];
        }
        if (i10 < this.f31389c && i11 < i12 / 2) {
            throw a.a();
        }
        c(b4);
        return new int[]{b4, i10};
    }

    private void a(r rVar) throws a {
        int i10 = 0;
        this.f31389c = 0;
        int d10 = rVar.d(0);
        this.f31390d = d10;
        int e2 = rVar.e();
        if (d10 < e2) {
            boolean z10 = true;
            while (d10 < e2) {
                if (rVar.b(d10) != z10) {
                    i10++;
                } else {
                    a(i10);
                    z10 = !z10;
                    i10 = 1;
                }
                d10++;
            }
            a(i10);
            return;
        }
        throw a.a();
    }

    private void a(int i10) throws a {
        try {
            int[] iArr = this.f31388b;
            int i11 = this.f31389c;
            iArr[i11] = i10;
            int i12 = i11 + 1;
            this.f31389c = i12;
            if (i12 >= iArr.length) {
                int[] iArr2 = new int[i12 * 2];
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i12);
                this.f31388b = iArr2;
            }
        } catch (NumberFormatException unused) {
            throw a.a();
        }
    }

    public static boolean a(char[] cArr, char c4) {
        if (cArr != null) {
            for (char c10 : cArr) {
                if (c10 == c4) {
                    return true;
                }
            }
        }
        return false;
    }
}
