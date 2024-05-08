package com.huawei.hms.scankit.p;

import java.util.Arrays;
import java.util.Map;

/* compiled from: OneDReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class g5 implements o6 {
    private s6 b(p pVar, Map<l1, ?> map) throws a {
        int e2 = pVar.e();
        int c4 = pVar.c();
        r rVar = new r(e2);
        int max = Math.max(1, c4 >> 5);
        int i10 = c4 / 2;
        if (map != null) {
            l1 l1Var = l1.PHOTO_MODE_NUM;
            if (map.containsKey(l1Var)) {
                i10 += (((Integer) map.get(l1Var)).intValue() * max) / 3;
            }
        }
        int i11 = i10;
        int i12 = 0;
        while (i12 < 15) {
            int i13 = i12 + 1;
            int i14 = i13 / 2;
            if (!((i12 & 1) == 0)) {
                i14 = -i14;
            }
            int i15 = i11 + (i14 * max);
            if (i15 < 0 || i15 >= c4) {
                break;
            }
            s6 a10 = a(pVar, rVar, map, i15, e2);
            if (a10 != null && a10.k() != null) {
                return a10;
            }
            i12 = i13;
        }
        throw a.a();
    }

    public abstract s6 a(int i10, r rVar, Map<l1, ?> map) throws a;

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return b(pVar, map);
    }

    private s6 a(p pVar, r rVar, Map<l1, ?> map, int i10, int i11) throws a {
        int i12 = 0;
        while (true) {
            int i13 = 3;
            if (i12 >= 3) {
                return null;
            }
            if (i12 == 0) {
                try {
                    rVar = pVar.a(i10, rVar);
                } catch (a unused) {
                    continue;
                }
            } else if (i12 == 1) {
                rVar = pVar.b().a(i10, rVar);
                i13 = 1;
            } else if (i12 == 2) {
                if (r3.f31465t) {
                    rVar = pVar.a(i10, 1);
                } else {
                    continue;
                    i12++;
                }
            }
            if (a(rVar.d())) {
                s6 a10 = a(rVar, !r3.f31448c ? 1 : i13, map, i10, i11);
                if (a10 != null && a10.k() != null) {
                    return a10;
                }
            } else {
                continue;
            }
            i12++;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:14|(2:16|(6:18|19|20|(1:24)|25|(2:30|31)(2:27|28))))|38|19|20|(2:22|24)|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
    
        if (r7 == 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        r19.h();
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.r r19, int r20, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r23
            r1 = 0
            r3 = r20
            r2 = r21
            r4 = 0
        L8:
            if (r4 >= r3) goto La3
            if (r4 != 0) goto Lf
            r19.c()
        Lf:
            r5 = 1
            if (r4 != r5) goto L15
            r19.i()
        L15:
            r6 = 2
            if (r4 != r6) goto L1e
            r19.g()
            r19.j()
        L1e:
            r7 = 0
        L1f:
            if (r7 >= r6) goto L99
            if (r7 != r5) goto L45
            r19.h()
            if (r2 == 0) goto L45
            com.huawei.hms.scankit.p.l1 r8 = com.huawei.hms.scankit.p.l1.NEED_RESULT_POINT_CALLBACK
            boolean r9 = r2.containsKey(r8)
            if (r9 == 0) goto L45
            java.util.EnumMap r9 = new java.util.EnumMap
            java.lang.Class<com.huawei.hms.scankit.p.l1> r10 = com.huawei.hms.scankit.p.l1.class
            r9.<init>(r10)
            r9.putAll(r2)
            r9.remove(r8)
            r8 = r18
            r10 = r22
            r2 = r9
            r9 = r19
            goto L4b
        L45:
            r8 = r18
            r9 = r19
            r10 = r22
        L4b:
            com.huawei.hms.scankit.p.s6 r11 = r8.a(r10, r9, r2)     // Catch: com.huawei.hms.scankit.p.a -> L8f
            if (r7 != r5) goto L87
            com.huawei.hms.scankit.p.u6[] r12 = r11.j()     // Catch: com.huawei.hms.scankit.p.a -> L8f
            if (r12 == 0) goto L87
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6     // Catch: com.huawei.hms.scankit.p.a -> L8f
            float r14 = (float) r0     // Catch: com.huawei.hms.scankit.p.a -> L8f
            r15 = r12[r1]     // Catch: com.huawei.hms.scankit.p.a -> L8f
            float r15 = r15.b()     // Catch: com.huawei.hms.scankit.p.a -> L8f
            float r15 = r14 - r15
            r16 = 1065353216(0x3f800000, float:1.0)
            float r15 = r15 - r16
            r17 = r12[r1]     // Catch: com.huawei.hms.scankit.p.a -> L8f
            float r6 = r17.c()     // Catch: com.huawei.hms.scankit.p.a -> L8f
            r13.<init>(r15, r6)     // Catch: com.huawei.hms.scankit.p.a -> L8f
            r12[r1] = r13     // Catch: com.huawei.hms.scankit.p.a -> L8f
            com.huawei.hms.scankit.p.u6 r6 = new com.huawei.hms.scankit.p.u6     // Catch: com.huawei.hms.scankit.p.a -> L8f
            r13 = r12[r5]     // Catch: com.huawei.hms.scankit.p.a -> L8f
            float r13 = r13.b()     // Catch: com.huawei.hms.scankit.p.a -> L8f
            float r14 = r14 - r13
            float r14 = r14 - r16
            r13 = r12[r5]     // Catch: com.huawei.hms.scankit.p.a -> L8f
            float r13 = r13.c()     // Catch: com.huawei.hms.scankit.p.a -> L8f
            r6.<init>(r14, r13)     // Catch: com.huawei.hms.scankit.p.a -> L8f
            r12[r5] = r6     // Catch: com.huawei.hms.scankit.p.a -> L8f
        L87:
            boolean r6 = a(r11, r0)     // Catch: com.huawei.hms.scankit.p.a -> L8f
            if (r6 != 0) goto L8e
            goto L95
        L8e:
            return r11
        L8f:
            if (r7 != r5) goto L95
            r19.h()
        L95:
            int r7 = r7 + 1
            r6 = 2
            goto L1f
        L99:
            r8 = r18
            r9 = r19
            r10 = r22
            int r4 = r4 + 1
            goto L8
        La3:
            r8 = r18
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.g5.a(com.huawei.hms.scankit.p.r, int, java.util.Map, int, int):com.huawei.hms.scankit.p.s6");
    }

    private static boolean a(int[] iArr) {
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < iArr.length && i10 < 20; i12++) {
            i10 += Integer.bitCount((i11 | (iArr[i12] << 1)) ^ iArr[i12]);
            i11 = (iArr[i12] >> 31) & 1;
        }
        return i10 >= 20;
    }

    private static boolean a(s6 s6Var, int i10) {
        u6[] j10 = s6Var.j();
        return Math.abs(((double) j10[1].b()) - ((double) j10[0].b())) / ((double) i10) > 0.4d;
    }

    public static void a(r rVar, int i10, int[] iArr) throws a {
        int length = iArr.length;
        int i11 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int e2 = rVar.e();
        if (i10 < e2) {
            boolean z10 = !rVar.b(i10);
            while (i10 < e2) {
                if (rVar.b(i10) == z10) {
                    i11++;
                    if (i11 == length) {
                        break;
                    }
                    if (i11 >= 0 && i11 < iArr.length) {
                        iArr[i11] = 1;
                        z10 = !z10;
                    } else {
                        throw a.a();
                    }
                } else if (i11 >= 0 && i11 < iArr.length) {
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    throw a.a();
                }
                i10++;
            }
            if (i11 != length) {
                if (i11 != length - 1 || i10 != e2) {
                    throw a.a();
                }
                return;
            }
            return;
        }
        throw a.a();
    }

    public static float a(int[] iArr, int[] iArr2, float f10) {
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
}
