package com.huawei.hms.scankit.p;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f30973a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f30974b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f30975c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f30976d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: e, reason: collision with root package name */
    private static boolean f30977e;

    public static o5 a(p pVar, Map<l1, ?> map, boolean z10) throws a {
        s b4 = pVar.b();
        a(false);
        List<u6[]> a10 = a(z10, b4);
        if (a10.isEmpty()) {
            b4 = b4.clone();
            b4.f();
            a10 = a(z10, b4);
            a(true);
        }
        return new o5(b4, a10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r4 = r0.iterator2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        r5 = (com.huawei.hms.scankit.p.u6[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r5[1] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (r5[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].c());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.huawei.hms.scankit.p.u6[]> a(boolean r8, com.huawei.hms.scankit.p.s r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.c()
            if (r3 >= r6) goto L7e
            com.huawei.hms.scankit.p.u6[] r4 = a(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 != 0) goto L20
            goto L7e
        L20:
            java.util.Iterator r4 = r0.iterator2()
        L24:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L50
            java.lang.Object r5 = r4.next()
            com.huawei.hms.scankit.p.u6[] r5 = (com.huawei.hms.scankit.p.u6[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L40
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.c()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L40:
            r7 = r5[r6]
            if (r7 == 0) goto L24
            r5 = r5[r6]
            float r5 = r5.c()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L24
        L50:
            int r3 = r3 + 5
            goto L8
        L53:
            r0.add(r4)
            if (r8 != 0) goto L59
            goto L7e
        L59:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6c
            r5 = r4[r3]
            float r5 = r5.b()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.c()
            goto L7a
        L6c:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.b()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.c()
        L7a:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.f2.a(boolean, com.huawei.hms.scankit.p.s):java.util.List");
    }

    private static u6[] a(s sVar, int i10, int i11) {
        int c4 = sVar.c();
        int e2 = sVar.e();
        u6[] u6VarArr = new u6[8];
        a(u6VarArr, a(sVar, c4, e2, i10, i11, f30975c), f30973a);
        if (u6VarArr[4] != null) {
            i11 = (int) u6VarArr[4].b();
            i10 = (int) u6VarArr[4].c();
        }
        a(u6VarArr, a(sVar, c4, e2, i10, i11, f30976d), f30974b);
        return u6VarArr;
    }

    private static void a(u6[] u6VarArr, u6[] u6VarArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            u6VarArr[iArr[i10]] = u6VarArr2[i10];
        }
    }

    private static u6[] a(s sVar, int i10, int i11, int i12, int i13, int[] iArr) {
        boolean z10;
        int i14;
        int i15;
        int i16;
        u6[] u6VarArr = new u6[4];
        int[] iArr2 = new int[iArr.length];
        int i17 = i12;
        while (true) {
            if (i17 >= i10) {
                z10 = false;
                break;
            }
            int[] a10 = a(sVar, i13, i17, i11, false, iArr, iArr2);
            if (a10 != null) {
                int i18 = i17;
                int[] iArr3 = a10;
                int i19 = i18;
                while (true) {
                    if (i19 <= 0) {
                        i16 = i19;
                        break;
                    }
                    int i20 = i19 - 1;
                    int[] a11 = a(sVar, i13, i20, i11, false, iArr, iArr2);
                    if (a11 == null) {
                        i16 = i20 + 1;
                        break;
                    }
                    iArr3 = a11;
                    i19 = i20;
                }
                float f10 = i16;
                u6VarArr[0] = new u6(iArr3[0], f10);
                u6VarArr[1] = new u6(iArr3[1], f10);
                i17 = i16;
                z10 = true;
            } else {
                i17 += 5;
            }
        }
        int i21 = i17 + 1;
        if (z10) {
            int[] iArr4 = {(int) u6VarArr[0].b(), (int) u6VarArr[1].b()};
            int i22 = i21;
            int i23 = 0;
            while (true) {
                if (i22 >= i10) {
                    i14 = i23;
                    i15 = i22;
                    break;
                }
                i14 = i23;
                i15 = i22;
                int[] a12 = a(sVar, iArr4[0], i22, i11, false, iArr, iArr2);
                if (a12 != null && Math.abs(iArr4[0] - a12[0]) < 5 && Math.abs(iArr4[1] - a12[1]) < 5) {
                    iArr4 = a12;
                    i23 = 0;
                } else {
                    if (i14 > 25) {
                        break;
                    }
                    i23 = i14 + 1;
                }
                i22 = i15 + 1;
            }
            i21 = i15 - (i14 + 1);
            float f11 = i21;
            u6VarArr[2] = new u6(iArr4[0], f11);
            u6VarArr[3] = new u6(iArr4[1], f11);
        }
        if (i21 - i17 < 10) {
            Arrays.fill(u6VarArr, (Object) null);
        }
        return u6VarArr;
    }

    private static int[] a(s sVar, int i10, int i11, int i12, boolean z10, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (sVar.b(i10, i11) && i10 > 0) {
            int i14 = i13 + 1;
            if (i13 >= 3) {
                break;
            }
            i10--;
            i13 = i14;
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i15 = 0;
        int i16 = i10;
        while (i10 < i12) {
            if (sVar.b(i10, i11) != z11) {
                iArr2[i15] = iArr2[i15] + 1;
            } else {
                if (i15 != length - 1) {
                    i15++;
                } else {
                    if (a(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i16, i10};
                    }
                    i16 += iArr2[0] + iArr2[1];
                    int i17 = i15 - 1;
                    System.arraycopy((Object) iArr2, 2, (Object) iArr2, 0, i17);
                    iArr2[i17] = 0;
                    iArr2[i15] = 0;
                    i15--;
                }
                iArr2[i15] = 1;
                z11 = !z11;
            }
            i10++;
        }
        if (i15 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i16, i10 - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    public static void a(boolean z10) {
        f30977e = z10;
    }

    public static boolean a() {
        return f30977e;
    }
}
