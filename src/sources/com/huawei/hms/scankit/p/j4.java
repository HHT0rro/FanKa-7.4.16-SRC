package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* compiled from: ITFReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j4 extends g5 {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f31163c = {6, 8, 10, 12, 14};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f31164d = {1, 1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    private static final int[][] f31165e = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: f, reason: collision with root package name */
    public static final int[][] f31166f = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    private int f31167a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f31168b = -1;

    private int[] b(r rVar) throws a {
        int c4 = c(rVar);
        while (true) {
            int[] c10 = c(rVar, c4, f31164d);
            this.f31167a = (c10[1] - c10[0]) / 4;
            if (a(rVar, c10[0])) {
                return c10;
            }
            c4 = c10[2];
        }
    }

    private static int c(r rVar) throws a {
        int e2 = rVar.e();
        int c4 = rVar.c(0);
        if (c4 != e2) {
            return c4;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a, a {
        boolean z10;
        int[] b4 = b(rVar);
        int[] a10 = a(rVar);
        StringBuilder sb2 = new StringBuilder(20);
        a(rVar, b4[1], a10[0], sb2);
        String sb3 = sb2.toString();
        int[] iArr = f31163c;
        int length = sb3.length();
        int length2 = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= length2) {
                z10 = false;
                break;
            }
            int i13 = iArr[i11];
            if (length == i13) {
                z10 = true;
                break;
            }
            if (i13 > i12) {
                i12 = i13;
            }
            i11++;
        }
        if (!z10 && length > i12) {
            z10 = true;
        }
        if (z10) {
            float f10 = i10;
            return new s6(sb3, null, new u6[]{new u6(b4[0], f10), new u6(a10[1], f10)}, BarcodeFormat.ITF);
        }
        throw a.a();
    }

    private int[] c(r rVar, int i10, int[] iArr) throws a {
        int i11;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int e2 = rVar.e();
        char c4 = 0;
        int i12 = i10;
        int i13 = i12;
        boolean z10 = false;
        int i14 = 0;
        while (i12 < e2) {
            if (rVar.b(i12) == z10) {
                if (i14 == length - 1) {
                    Arrays.sort((int[]) iArr2.clone());
                    i11 = e2;
                    if (((r10[2] + r10[3]) * 0.5d) / ((r10[c4] + r10[1]) * 0.5d) < 4.0d && (r10[3] * 1.0d) / r10[0] <= 3.0d) {
                        int[] iArr3 = new int[10];
                        g5.a(rVar, i12, iArr3);
                        this.f31168b = -1;
                        for (int i15 = 0; i15 < 10; i15++) {
                            if (iArr3[i15] > this.f31168b) {
                                this.f31168b = iArr3[i15];
                            }
                        }
                        return new int[]{i13, i12, i13 + iArr2[0] + iArr2[1]};
                    }
                    i13 += iArr2[0] + iArr2[1];
                    int i16 = i14 - 1;
                    System.arraycopy((Object) iArr2, 2, (Object) iArr2, 0, i16);
                    iArr2[i16] = 0;
                    iArr2[i14] = 0;
                    i14--;
                } else {
                    i11 = e2;
                    i14++;
                }
                iArr2[i14] = 1;
                z10 = !z10;
            } else if (i14 >= 0 && i14 < length) {
                iArr2[i14] = iArr2[i14] + 1;
                i11 = e2;
            } else {
                throw a.a();
            }
            i12++;
            e2 = i11;
            c4 = 0;
        }
        throw a.a();
    }

    private int[] b(r rVar, int i10, int[] iArr) throws a {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int e2 = rVar.e();
        int i11 = i10;
        int i12 = i11;
        boolean z10 = false;
        int i13 = 0;
        while (i11 < e2) {
            if (rVar.b(i11) == z10) {
                if (i13 != length - 1) {
                    i13++;
                } else if (Math.min(iArr2[0], iArr2[1]) != 0 && Math.max(iArr2[0], iArr2[1]) != 0) {
                    float f10 = (iArr2[2] * 2.0f) / (iArr2[0] + iArr2[1]);
                    if (Math.max(iArr2[0], iArr2[1]) / Math.min(iArr2[0], iArr2[1]) <= 3.0f && ((double) f10) > 1.5d && f10 < 4.0f) {
                        return new int[]{i12, i11, i12 + iArr2[0] + iArr2[1]};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i14 = i13 - 1;
                    System.arraycopy((Object) iArr2, 2, (Object) iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i13--;
                } else {
                    throw a.a();
                }
                iArr2[i13] = 1;
                z10 = !z10;
            } else if (i13 >= 0 && i13 < length) {
                iArr2[i13] = iArr2[i13] + 1;
            } else {
                throw a.a();
            }
            i11++;
        }
        throw a.a();
    }

    private static void a(r rVar, int i10, int i11, StringBuilder sb2) throws a {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i10 < i11) {
            g5.a(rVar, i10, iArr);
            int i12 = -1;
            int i13 = 10000;
            for (int i14 = 0; i14 < 10; i14++) {
                if (i12 <= iArr[i14]) {
                    i12 = iArr[i14];
                }
                if (i13 >= iArr[i14]) {
                    i13 = iArr[i14];
                }
            }
            if (i12 / i13 <= 8) {
                for (int i15 = 0; i15 < 5; i15++) {
                    int i16 = i15 * 2;
                    iArr2[i15] = iArr[i16];
                    iArr3[i15] = iArr[i16 + 1];
                }
                sb2.append((char) (b(iArr2) + 48));
                sb2.append((char) (b(iArr3) + 48));
                for (int i17 = 0; i17 < 10; i17++) {
                    i10 += iArr[i17];
                }
            } else {
                throw a.a();
            }
        }
        if (i10 != i11) {
            throw a.a();
        }
    }

    private static int b(int[] iArr) throws a {
        int length = f31166f.length;
        float f10 = 0.3f;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            float a10 = g5.a(iArr, f31166f[i11], 0.75f);
            if (a10 < f10) {
                i10 = i11;
                f10 = a10;
            } else if (Math.abs(a10 - f10) < 1.0E-7d) {
                i10 = -1;
            }
        }
        if (i10 >= 0) {
            return i10 % 10;
        }
        throw a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.huawei.hms.scankit.p.r r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f31167a
            int r0 = r0 * 10
            int r1 = r5.f31168b
            double r1 = (double) r1
            r3 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r1 = r1 * r3
            int r1 = (int) r1
            if (r0 >= r1) goto Lf
            r0 = r1
        Lf:
            r1 = 1
            int r7 = r7 - r1
        L11:
            if (r0 <= 0) goto L21
            if (r7 < 0) goto L21
            boolean r2 = r6.b(r7)
            if (r2 == 0) goto L1c
            goto L21
        L1c:
            int r0 = r0 + (-1)
            int r7 = r7 + (-1)
            goto L11
        L21:
            if (r0 == 0) goto L25
            r6 = 0
            return r6
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j4.a(com.huawei.hms.scankit.p.r, int):boolean");
    }

    private int[] a(r rVar) throws a {
        try {
            rVar.h();
            int c4 = c(rVar);
            while (true) {
                int[] b4 = b(rVar, c4, f31165e[0]);
                if (a(rVar, b4[0])) {
                    int i10 = b4[0];
                    b4[0] = rVar.e() - b4[1];
                    b4[1] = rVar.e() - i10;
                    return b4;
                }
                c4 = b4[2];
            }
        } finally {
            rVar.h();
        }
    }
}
