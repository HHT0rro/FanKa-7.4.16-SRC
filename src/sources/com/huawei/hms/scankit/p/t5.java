package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417ScanningDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class t5 {

    /* renamed from: a, reason: collision with root package name */
    private static final a3 f31551a = new a3();

    public static w1 a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, int i10, int i11, Map<l1, ?> map) throws a {
        z1 b4;
        b2 b2Var = null;
        b2 b2Var2 = null;
        a0 a0Var = new a0(sVar, u6Var, u6Var2, u6Var3, u6Var4);
        boolean z10 = true;
        while (true) {
            if (u6Var != null) {
                b2Var = a(sVar, a0Var, u6Var, true, i10, i11);
            }
            if (u6Var3 != null) {
                b2Var2 = a(sVar, a0Var, u6Var3, false, i10, i11);
            }
            b4 = b(b2Var, b2Var2);
            if (b4 != null) {
                a0 i12 = b4.i();
                if (!z10 || i12 == null || (i12.f() >= a0Var.f() && i12.d() <= a0Var.d())) {
                    break;
                }
                a0Var = i12;
                z10 = false;
            } else {
                throw a.a();
            }
        }
        b4.a(a0Var);
        int f10 = b4.f() + 1;
        b4.a(0, b2Var);
        b4.a(f10, b2Var2);
        a(b4, b2Var, a0Var, f10, sVar, i10, i11);
        return a(b4, map);
    }

    private static boolean a(int i10, int i11, int i12) {
        return i11 + (-2) <= i10 && i10 <= i12 + 2;
    }

    private static z1 b(b2 b2Var, b2 b2Var2) throws a {
        k a10;
        if ((b2Var == null && b2Var2 == null) || (a10 = a(b2Var, b2Var2)) == null) {
            return null;
        }
        return new z1(a10, a0.a(a(b2Var), a(b2Var2)));
    }

    private static int c(int i10) {
        return 2 << i10;
    }

    private static int b(int[] iArr) {
        int i10 = -1;
        for (int i11 : iArr) {
            i10 = Math.max(i10, i11);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] b(com.huawei.hms.scankit.p.s r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.b(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.t5.b(com.huawei.hms.scankit.p.s, int, int, boolean, int, int):int[]");
    }

    private static int b(int i10) {
        return a(a(i10));
    }

    private static void a(z1 z1Var, b2 b2Var, a0 a0Var, int i10, s sVar, int i11, int i12) {
        a2 b2Var2;
        int i13;
        int i14;
        int i15;
        int i16;
        a2 a2Var;
        boolean z10 = b2Var != null;
        int i17 = i11;
        int i18 = i12;
        for (int i19 = 1; i19 <= i10; i19++) {
            int i20 = z10 ? i19 : i10 - i19;
            if (z1Var.a(i20) == null) {
                if (i20 != 0 && i20 != i10) {
                    b2Var2 = new a2(a0Var);
                } else {
                    b2Var2 = new b2(a0Var, i20 == 0);
                }
                a2 a2Var2 = b2Var2;
                z1Var.a(i20, a2Var2);
                int i21 = -1;
                int i22 = i17;
                int i23 = i18;
                int f10 = a0Var.f();
                int i24 = -1;
                while (f10 <= a0Var.d()) {
                    int a10 = a(z1Var, i20, f10, z10);
                    if (a10 >= 0 && a10 <= a0Var.c()) {
                        i13 = a10;
                    } else if (i24 == i21) {
                        i14 = i24;
                        i15 = f10;
                        i16 = i22;
                        a2Var = a2Var2;
                        i22 = i16;
                        i13 = i14;
                        f10 = i15 + 1;
                        a2Var2 = a2Var;
                        i24 = i13;
                        i21 = -1;
                    } else {
                        i13 = i24;
                    }
                    i14 = i24;
                    int i25 = f10;
                    int i26 = i23;
                    int i27 = i22;
                    a2Var = a2Var2;
                    x0 a11 = a(sVar, a0Var.e(), a0Var.c(), z10, i13, i25, i27, i26);
                    i15 = i25;
                    if (a11 != null) {
                        a2Var.a(i15, a11);
                        int min = Math.min(i27, a11.f());
                        i23 = Math.max(i26, a11.f());
                        i22 = min;
                        f10 = i15 + 1;
                        a2Var2 = a2Var;
                        i24 = i13;
                        i21 = -1;
                    } else {
                        i23 = i26;
                        i16 = i27;
                        i22 = i16;
                        i13 = i14;
                        f10 = i15 + 1;
                        a2Var2 = a2Var;
                        i24 = i13;
                        i21 = -1;
                    }
                }
                i17 = i22;
                i18 = i23;
            }
        }
    }

    private static a0 a(b2 b2Var) throws a {
        int[] d10;
        if (b2Var == null || (d10 = b2Var.d()) == null) {
            return null;
        }
        int b4 = b(d10);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : d10) {
            i11 += b4 - i12;
            if (i12 > 0) {
                break;
            }
        }
        x0[] b10 = b2Var.b();
        for (int i13 = 0; i11 > 0 && b10[i13] == null; i13++) {
            i11--;
        }
        for (int length = d10.length - 1; length >= 0; length--) {
            i10 += b4 - d10[length];
            if (d10[length] > 0) {
                break;
            }
        }
        for (int length2 = b10.length - 1; i10 > 0 && b10[length2] == null; length2--) {
            i10--;
        }
        return b2Var.a().a(i11, i10, b2Var.e());
    }

    private static k a(b2 b2Var, b2 b2Var2) throws a {
        k c4;
        k c10;
        if (b2Var == null || (c4 = b2Var.c()) == null) {
            if (b2Var2 == null) {
                return null;
            }
            return b2Var2.c();
        }
        if (b2Var2 == null || (c10 = b2Var2.c()) == null || c4.a() == c10.a() || c4.b() == c10.b() || c4.c() == c10.c()) {
            return c4;
        }
        return null;
    }

    private static b2 a(s sVar, a0 a0Var, u6 u6Var, boolean z10, int i10, int i11) {
        int b4;
        b2 b2Var = new b2(a0Var, z10);
        int i12 = 0;
        while (i12 < 2) {
            int i13 = i12 == 0 ? 1 : -1;
            int b10 = (int) u6Var.b();
            for (int c4 = (int) u6Var.c(); c4 <= a0Var.d() && c4 >= a0Var.f(); c4 += i13) {
                x0 a10 = a(sVar, 0, sVar.e(), z10, b10, c4, i10, i11);
                if (a10 != null) {
                    b2Var.a(c4, a10);
                    if (z10) {
                        b4 = a10.d();
                    } else {
                        b4 = a10.b();
                    }
                    b10 = b4;
                }
            }
            i12++;
        }
        return b2Var;
    }

    private static void a(z1 z1Var, m[][] mVarArr) throws a {
        m mVar = mVarArr[0][1];
        int[] a10 = mVar.a();
        int f10 = (z1Var.f() * z1Var.h()) - c(z1Var.g());
        if (a10.length != 0) {
            if (a10[0] != f10) {
                mVar.a(f10);
            }
        } else {
            if (f10 >= 1 && f10 <= 928) {
                mVar.a(f10);
                return;
            }
            throw a.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static w1 a(z1 z1Var, Map<l1, ?> map) throws a {
        m[][] a10 = a(z1Var);
        a(z1Var, a10);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[z1Var.h() * z1Var.f()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < z1Var.h(); i10++) {
            int i11 = 0;
            while (i11 < z1Var.f()) {
                int i12 = i11 + 1;
                int[] a11 = a10[i10][i12].a();
                int f10 = (z1Var.f() * i10) + i11;
                if (a11.length == 0) {
                    arrayList.add(Integer.valueOf(f10));
                } else if (a11.length == 1) {
                    iArr[f10] = a11[0];
                } else {
                    arrayList3.add(Integer.valueOf(f10));
                    arrayList2.add(a11);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return a(z1Var.g(), iArr, n5.a(arrayList), n5.a(arrayList3), iArr2, map);
    }

    private static w1 a(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4, Map<l1, ?> map) throws a {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i11 = 100;
        while (true) {
            int i12 = i11 - 1;
            if (i11 > 0) {
                for (int i13 = 0; i13 < length; i13++) {
                    iArr[iArr3[i13]] = iArr4[i13][iArr5[i13]];
                }
                try {
                    return a(iArr, i10, iArr2, map);
                } catch (a unused) {
                    if (length == 0) {
                        throw a.a();
                    }
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        if (iArr5[i14] < iArr4[i14].length - 1) {
                            iArr5[i14] = iArr5[i14] + 1;
                            break;
                        }
                        iArr5[i14] = 0;
                        if (i14 == length - 1) {
                            throw a.a();
                        }
                        i14++;
                    }
                    i11 = i12;
                }
            } else {
                throw a.a();
            }
        }
    }

    private static m[][] a(z1 z1Var) throws a {
        int c4;
        m[][] mVarArr = (m[][]) Array.newInstance((Class<?>) m.class, z1Var.h(), z1Var.f() + 2);
        for (int i10 = 0; i10 < mVarArr.length; i10++) {
            for (int i11 = 0; i11 < mVarArr[i10].length; i11++) {
                mVarArr[i10][i11] = new m();
            }
        }
        int i12 = 0;
        for (a2 a2Var : z1Var.j()) {
            if (a2Var != null) {
                for (x0 x0Var : a2Var.b()) {
                    if (x0Var != null && (c4 = x0Var.c()) >= 0 && c4 < mVarArr.length) {
                        mVarArr[c4][i12].a(x0Var.e());
                    }
                }
            }
            i12++;
        }
        return mVarArr;
    }

    private static boolean a(z1 z1Var, int i10) {
        return i10 >= 0 && i10 <= z1Var.f() + 1;
    }

    private static int a(z1 z1Var, int i10, int i11, boolean z10) {
        int i12 = z10 ? 1 : -1;
        int i13 = i10 - i12;
        x0 a10 = a(z1Var, i13) ? z1Var.a(i13).a(i11) : null;
        if (a10 != null) {
            return z10 ? a10.b() : a10.d();
        }
        x0 b4 = z1Var.a(i10).b(i11);
        if (b4 != null) {
            return z10 ? b4.d() : b4.b();
        }
        if (a(z1Var, i13)) {
            b4 = z1Var.a(i13).b(i11);
        }
        if (b4 != null) {
            return z10 ? b4.b() : b4.d();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (!a(z1Var, i10)) {
                return z10 ? z1Var.i().e() : z1Var.i().c();
            }
            for (x0 x0Var : z1Var.a(i10).b()) {
                if (x0Var != null) {
                    return (z10 ? x0Var.b() : x0Var.d()) + (i12 * i14 * (x0Var.b() - x0Var.d()));
                }
            }
            i14++;
        }
    }

    private static x0 a(s sVar, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int d10;
        int a10;
        int a11 = a(sVar, i10, i11, z10, i12, i13);
        int[] b4 = b(sVar, i10, i11, z10, a11, i13);
        if (b4 == null) {
            return null;
        }
        int a12 = s4.a(b4);
        if (z10) {
            i16 = a11 + a12;
        } else {
            for (int i17 = 0; i17 < b4.length / 2; i17++) {
                int i18 = b4[i17];
                b4[i17] = b4[(b4.length - 1) - i17];
                b4[(b4.length - 1) - i17] = i18;
            }
            a11 -= a12;
            i16 = a11;
        }
        if (a(a12, i14, i15) && (a10 = n5.a((d10 = m5.d(b4)))) != -1) {
            return new x0(a11, i16, b(d10), a10);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.huawei.hms.scankit.p.s r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.b(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.t5.a(com.huawei.hms.scankit.p.s, int, int, boolean, int, int):int");
    }

    private static w1 a(int[] iArr, int i10, int[] iArr2, Map<l1, ?> map) throws a, a {
        if (iArr.length != 0) {
            int i11 = 1 << (i10 + 1);
            int a10 = a(iArr, iArr2, i11);
            a(iArr, i11);
            w1 a11 = q1.a(iArr, String.valueOf(i10), map);
            a11.b(Integer.valueOf(a10));
            a11.a(Integer.valueOf(iArr2.length));
            return a11;
        }
        throw a.a();
    }

    private static int a(int[] iArr, int[] iArr2, int i10) throws a {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return f31551a.a(iArr, i10, iArr2);
        }
        throw a.a();
    }

    private static void a(int[] iArr, int i10) throws a {
        if (iArr.length >= 4) {
            int i11 = iArr[0];
            if (i11 > iArr.length) {
                throw a.a();
            }
            if (i11 == 0) {
                if (i10 < iArr.length) {
                    iArr[0] = iArr.length - i10;
                    return;
                }
                throw a.a();
            }
            return;
        }
        throw a.a();
    }

    private static int[] a(int i10) {
        int[] iArr = new int[8];
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i10 & 1;
            if (i13 != i11) {
                i12--;
                if (i12 < 0) {
                    return iArr;
                }
                i11 = i13;
            }
            iArr[i12] = iArr[i12] + 1;
            i10 >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
