package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a5 implements o6 {
    public static boolean a(s6 s6Var, float f10, float f11) {
        double abs = Math.abs(s6Var.j()[0].b() - s6Var.j()[1].b()) / f10;
        return (abs < 0.55d && ((double) f11) > 1.5d) || abs < 0.3d;
    }

    public s6 b(p pVar, p pVar2, p pVar3, Map<l1, ?> map, m4 m4Var, i2 i2Var) throws a {
        if (pVar3 != null) {
            return b(pVar3, m4Var, map, i2Var);
        }
        return a(pVar, pVar2, m4Var, map);
    }

    public s6 c(p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        s6 s6Var;
        int e2 = pVar.e();
        int c4 = pVar.c();
        if (e2 >= c4) {
            e2 = c4;
        }
        float f10 = (e2 * 1.0f) / 500.0f;
        p g3 = m4Var.g(pVar, f10);
        try {
            s6Var = a(g3, a(map), map);
            if (s6Var != null) {
                try {
                    if (s6Var.k() != null) {
                        k2.a(s6Var.j(), f10, i2Var);
                        return s6Var;
                    }
                } catch (a unused) {
                    try {
                        g3.a(n1.a(g3.d(), g3.e(), g3.c(), true));
                        s6 a10 = a(g3, a(map), map);
                        if (a10 != null && a10.k() != null) {
                            k2.a(a10.j(), f10, i2Var);
                            return a10;
                        }
                        throw a.a();
                    } catch (a unused2) {
                        if (s6Var != null) {
                            return s6Var;
                        }
                        throw a.a();
                    }
                }
            }
            throw a.a();
        } catch (a unused3) {
            s6Var = null;
        }
    }

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return a(pVar, a(map), map);
    }

    public s6 b(p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        int e2 = pVar.e();
        int c4 = pVar.c();
        int i10 = e2 < c4 ? e2 : c4;
        float f10 = i10 * 1.0f;
        float f11 = f10 / 128.0f;
        if (f11 < 1.0f && r3.f31448c) {
            pVar = m4Var.e(pVar, f11);
        }
        p pVar2 = pVar;
        float f12 = f10 / 500.0f;
        float f13 = f12 >= 1.0f ? f12 : 1.0f;
        try {
            s6 a10 = a(m4Var.g(pVar2, f13), a(map), map);
            if (a10 != null && a10.k() != null) {
                k2.a(a10.j(), f13, i2Var);
                return a10;
            }
            if (!r3.f31448c && a10 != null && a10.k() == null && a10.j().length >= 3) {
            }
            throw a.a();
        } catch (a unused) {
            s6 a11 = a(i10, pVar2, m4Var, map, i2Var);
            if (a11 == null) {
                throw a.a();
            }
            if (0 != 0) {
                a11.a();
                a11.b((u6[]) null);
                k2.a(a11.j(), f13, i2Var);
            }
            return a11;
        }
    }

    public o6[] a(Map<l1, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(l1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new z4(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new j6());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new h1());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new h());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new r5());
            }
            if (collection.contains(BarcodeFormat.HARMONY_CODE)) {
                arrayList.add(new z3());
            }
            if (collection.contains(BarcodeFormat.WXCODE)) {
                arrayList.add(new m8());
            }
        }
        return (o6[]) arrayList.toArray(new o6[arrayList.size()]);
    }

    private s6 a(p pVar, o6[] o6VarArr, Map<l1, ?> map) throws a {
        if (o6VarArr != null) {
            for (o6 o6Var : o6VarArr) {
                try {
                    s6 a10 = o6Var.a(pVar, map);
                    if (a10 != null && a10.j() != null) {
                        int i10 = 0;
                        for (u6 u6Var : a10.j()) {
                            if (u6Var != null) {
                                i10++;
                            }
                        }
                        if (i10 == 0 && a10.c() == BarcodeFormat.PDF_417) {
                            throw a.a();
                            break;
                        }
                    }
                    return a10;
                } catch (a unused) {
                }
            }
        }
        throw a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r10, com.huawei.hms.scankit.p.p r11, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r12, com.huawei.hms.scankit.p.m4 r13, com.huawei.hms.scankit.p.i2 r14) throws com.huawei.hms.scankit.p.a {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.l1 r0 = com.huawei.hms.scankit.p.l1.PHOTO_MODE
            boolean r0 = r12.containsKey(r0)
            r1 = 2
            float[] r6 = new float[r1]
            r6 = {x0066: FILL_ARRAY_DATA , data: [1065353216, 0} // fill-array
            r1 = 0
            r8 = 1
            if (r11 == 0) goto L1b
            r2 = r9
            r3 = r11
            r4 = r13
            r5 = r12
            r7 = r14
            com.huawei.hms.scankit.p.s6 r11 = r2.a(r3, r4, r5, r6, r7)
        L19:
            r12 = 0
            goto L31
        L1b:
            if (r0 != 0) goto L24
            boolean r11 = com.huawei.hms.scankit.p.r3.f31446a
            if (r11 != 0) goto L22
            goto L24
        L22:
            r11 = 0
            goto L19
        L24:
            com.huawei.hms.scankit.p.s6 r11 = r9.a(r10, r13, r12, r6)
            r12 = r6[r8]
            r13 = 1065353216(0x3f800000, float:1.0)
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L19
            r12 = 1
        L31:
            if (r11 == 0) goto L60
            if (r12 == 0) goto L5f
            com.huawei.hms.scankit.p.u6[] r12 = r11.j()
            if (r12 == 0) goto L5f
        L3b:
            int r13 = r12.length
            if (r1 >= r13) goto L5f
            r13 = r12[r1]
            if (r13 == 0) goto L5c
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6
            r14 = r12[r1]
            float r14 = r14.c()
            int r0 = r10.c()
            int r0 = r0 - r8
            float r0 = (float) r0
            r2 = r12[r1]
            float r2 = r2.b()
            float r0 = r0 - r2
            r13.<init>(r14, r0)
            r12[r1] = r13
        L5c:
            int r1 = r1 + 1
            goto L3b
        L5f:
            return r11
        L60:
            com.huawei.hms.scankit.p.a r10 = com.huawei.hms.scankit.p.a.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.p, java.util.Map, com.huawei.hms.scankit.p.m4, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r11, com.huawei.hms.scankit.p.m4 r12, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r13, float[] r14, com.huawei.hms.scankit.p.i2 r15) throws com.huawei.hms.scankit.p.a {
        /*
            r10 = this;
            float r0 = r15.n()
            int r1 = r11.e()
            int r2 = r11.c()
            if (r1 >= r2) goto L13
            int r1 = r11.e()
            goto L17
        L13:
            int r1 = r11.c()
        L17:
            float r1 = (float) r1
            r2 = 1140457472(0x43fa0000, float:500.0)
            float r2 = r1 / r2
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L24
            r2 = 1065353216(0x3f800000, float:1.0)
        L24:
            com.huawei.hms.scankit.p.p r4 = r12.g(r11, r2)
            com.huawei.hms.scankit.p.o6[] r5 = r10.a(r13)
            float r6 = r15.a()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L3f
            float r6 = r15.b()
            float r7 = r15.a()
            float r6 = r6 / r7
            goto L41
        L3f:
            r6 = 1065353216(0x3f800000, float:1.0)
        L41:
            r7 = 0
            com.huawei.hms.scankit.p.s6 r8 = r10.a(r4, r5, r13)     // Catch: com.huawei.hms.scankit.p.a -> L56
            float r9 = r0 / r2
            boolean r9 = a(r8, r9, r6)     // Catch: com.huawei.hms.scankit.p.a -> L54
            if (r9 != 0) goto L4f
            goto Laa
        L4f:
            com.huawei.hms.scankit.p.a r8 = com.huawei.hms.scankit.p.a.a()     // Catch: com.huawei.hms.scankit.p.a -> L56
            throw r8     // Catch: com.huawei.hms.scankit.p.a -> L56
        L54:
            r7 = r8
            goto L57
        L56:
        L57:
            boolean r8 = com.huawei.hms.scankit.p.r3.f31461p
            if (r8 == 0) goto La9
            r2 = 1132068864(0x437a0000, float:250.0)
            float r1 = r1 / r2
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 >= 0) goto L63
            goto L64
        L63:
            r3 = r1
        L64:
            com.huawei.hms.scankit.p.p r4 = r12.f(r11, r3)
            com.huawei.hms.scankit.p.l1 r11 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM     // Catch: com.huawei.hms.scankit.p.a -> L88
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: com.huawei.hms.scankit.p.a -> L88
            r13.put(r11, r1)     // Catch: com.huawei.hms.scankit.p.a -> L88
            com.huawei.hms.scankit.p.p r11 = r12.e(r4)     // Catch: com.huawei.hms.scankit.p.a -> L88
            com.huawei.hms.scankit.p.s6 r8 = r10.a(r11, r5, r13)     // Catch: com.huawei.hms.scankit.p.a -> L88
            float r11 = r0 / r3
            boolean r11 = a(r8, r11, r6)     // Catch: com.huawei.hms.scankit.p.a -> L88
            if (r11 != 0) goto L83
            goto La2
        L83:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()     // Catch: com.huawei.hms.scankit.p.a -> L88
            throw r11     // Catch: com.huawei.hms.scankit.p.a -> L88
        L88:
            com.huawei.hms.scankit.p.l1 r11 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM
            r1 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13.put(r11, r1)
            com.huawei.hms.scankit.p.p r11 = r12.f(r4)
            com.huawei.hms.scankit.p.s6 r8 = r10.a(r11, r5, r13)
            float r0 = r0 / r3
            boolean r11 = a(r8, r0, r6)
            if (r11 != 0) goto La4
        La2:
            r2 = r3
            goto Laa
        La4:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()
            throw r11
        La9:
            r8 = r7
        Laa:
            r11 = 0
            r14[r11] = r2
            if (r8 == 0) goto Lb6
            com.huawei.hms.scankit.p.s r11 = r4.b()
            com.huawei.hms.scankit.p.k2.a(r11, r8, r2, r15)
        Lb6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, float[], com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        r10 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.huawei.hms.scankit.p.m4] */
    /* JADX WARN: Type inference failed for: r10v10, types: [com.huawei.hms.scankit.p.s6] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.huawei.hms.scankit.p.s6] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r9, com.huawei.hms.scankit.p.m4 r10, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r11, float[] r12) throws com.huawei.hms.scankit.p.a {
        /*
            r8 = this;
            int r0 = r9.c()
            int r1 = r9.e()
            int r0 = java.lang.Math.min(r0, r1)
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r2 = 1149698048(0x44870000, float:1080.0)
            float r0 = r0 / r2
            boolean r2 = com.huawei.hms.scankit.p.r3.f31446a
            if (r2 == 0) goto L1d
            com.huawei.hms.scankit.p.p r9 = r10.a(r9, r0)
            goto L29
        L1d:
            r2 = 1069547520(0x3fc00000, float:1.5)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L24
            r1 = r0
        L24:
            com.huawei.hms.scankit.p.p r9 = r10.a(r9, r1)
            r0 = r1
        L29:
            com.huawei.hms.scankit.p.o6[] r1 = r8.a(r11)
            boolean r2 = com.huawei.hms.scankit.p.r3.f31447b
            r3 = 0
            r4 = 0
            if (r2 != 0) goto L45
            boolean r2 = com.huawei.hms.scankit.p.r3.f31446a
            if (r2 == 0) goto L45
            com.huawei.hms.scankit.p.l1 r10 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r11.put(r10, r2)
            com.huawei.hms.scankit.p.s6 r10 = r8.a(r9, r1, r11)
            goto L81
        L45:
            r5 = r3
            r2 = 0
        L47:
            r6 = 2
            if (r2 >= r6) goto L80
            r6 = 1
            if (r2 != r6) goto L5e
            com.huawei.hms.scankit.p.p r7 = com.huawei.hms.scankit.p.l4.a(r9)
            com.huawei.hms.scankit.p.p r7 = r10.c(r7)     // Catch: com.huawei.hms.scankit.p.a -> L7d
            com.huawei.hms.scankit.p.s6 r5 = r8.a(r7, r1, r11)     // Catch: com.huawei.hms.scankit.p.a -> L7d
            r7 = 1073741824(0x40000000, float:2.0)
            r12[r6] = r7     // Catch: com.huawei.hms.scankit.p.a -> L7d
            goto L80
        L5e:
            com.huawei.hms.scankit.p.p r7 = r10.b(r9)     // Catch: com.huawei.hms.scankit.p.a -> L67
            com.huawei.hms.scankit.p.s6 r10 = r8.a(r7, r1, r11)     // Catch: com.huawei.hms.scankit.p.a -> L67
            goto L81
        L67:
            boolean r7 = com.huawei.hms.scankit.p.r3.f31461p     // Catch: com.huawei.hms.scankit.p.a -> L7d
            if (r7 == 0) goto L7d
            com.huawei.hms.scankit.p.l1 r7 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM     // Catch: com.huawei.hms.scankit.p.a -> L7d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: com.huawei.hms.scankit.p.a -> L7d
            r11.put(r7, r6)     // Catch: com.huawei.hms.scankit.p.a -> L7d
            com.huawei.hms.scankit.p.p r6 = r10.d(r9)     // Catch: com.huawei.hms.scankit.p.a -> L7d
            com.huawei.hms.scankit.p.s6 r10 = r8.a(r6, r1, r11)     // Catch: com.huawei.hms.scankit.p.a -> L7d
            goto L81
        L7d:
            int r2 = r2 + 1
            goto L47
        L80:
            r10 = r5
        L81:
            if (r10 == 0) goto L8a
            com.huawei.hms.scankit.p.s r9 = r9.b()
            com.huawei.hms.scankit.p.k2.a(r9, r10, r0, r3)
        L8a:
            r12[r4] = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, float[]):com.huawei.hms.scankit.p.s6");
    }

    public s6 a(p pVar, p pVar2, p pVar3, Map<l1, ?> map, m4 m4Var, i2 i2Var) throws a {
        s6 a10 = pVar3 != null ? a(pVar3, m4Var, map, i2Var) : null;
        if (a10 != null) {
            return a10;
        }
        throw a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.huawei.hms.scankit.p.u6[]] */
    private s6 a(p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        u6[] u6VarArr;
        boolean z10;
        s6 a10;
        int e2 = pVar.e();
        int c4 = pVar.c();
        if (e2 >= c4) {
            e2 = c4;
        }
        float f10 = (e2 * 1.0f) / 900.0f;
        p i10 = m4Var.i(pVar, f10);
        s6 s6Var = null;
        try {
            s6 a11 = a(i10, a(map), map);
            if (a11 != null) {
                try {
                    if (a11.k() != null) {
                        k2.a(a11.j(), f10, i2Var);
                        return a11;
                    }
                } catch (a unused) {
                    z10 = false;
                    u6VarArr = s6Var;
                    s6Var = a11;
                    try {
                        i10.a(n1.a(i10.d(), i10.e(), i10.c(), false));
                        a10 = a(i10, a(map), map);
                        if (a10 == null && a10.k() != null) {
                            k2.a(a10.j(), f10, i2Var);
                            return a10;
                        }
                        throw a.a();
                    } catch (a unused2) {
                        if (s6Var == null) {
                            throw a.a();
                        }
                        if (z10) {
                            s6Var.a();
                            s6Var.b(u6VarArr);
                            k2.a(s6Var.j(), f10, i2Var);
                        }
                        return s6Var;
                    }
                }
            }
            if (r3.f31448c || a11 == null || a11.k() != null || a11.j().length < 3) {
                z10 = false;
            } else {
                z10 = true;
                try {
                    s6Var = (u6[]) a11.j().clone();
                } catch (a unused3) {
                    u6VarArr = s6Var;
                    s6Var = a11;
                    i10.a(n1.a(i10.d(), i10.e(), i10.c(), false));
                    a10 = a(i10, a(map), map);
                    if (a10 == null) {
                    }
                    throw a.a();
                }
            }
            throw a.a();
        } catch (a unused4) {
            u6VarArr = null;
            z10 = false;
        }
    }

    private s6 a(int i10, p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        float f10 = (i10 * 1.0f) / 250.0f;
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        p f11 = m4Var.f(pVar, f10);
        o6[] a10 = a(map);
        try {
            try {
                s6 a11 = a(m4Var.e(f11), a10, map);
                if (a11 != null && a11.k() != null) {
                    k2.a(a11.j(), f10, i2Var);
                    return a11;
                }
                throw a.a();
            } catch (a unused) {
                s6 a12 = a(new p(new e4(pVar.a().c())), a10, map);
                if (a12 != null && a12.k() != null) {
                    k2.a(a12.j(), 1.0f, i2Var);
                }
                return a12;
            }
        } catch (a unused2) {
            s6 a13 = a(m4Var.f(f11), a10, map);
            if (a13 != null && a13.k() != null) {
                k2.a(a13.j(), f10, i2Var);
                return a13;
            }
            throw a.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r10, com.huawei.hms.scankit.p.p r11, com.huawei.hms.scankit.p.m4 r12, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r13) throws com.huawei.hms.scankit.p.a {
        /*
            r9 = this;
            int r0 = r10.e()
            int r1 = r10.c()
            if (r0 >= r1) goto Lc
            r3 = r0
            goto Ld
        Lc:
            r3 = r1
        Ld:
            float r0 = (float) r3
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r2 = 1149698048(0x44870000, float:1080.0)
            float r0 = r0 / r2
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L1a
            goto L1c
        L1a:
            r0 = 1065353216(0x3f800000, float:1.0)
        L1c:
            boolean r2 = com.huawei.hms.scankit.p.r3.f31446a
            if (r2 == 0) goto L25
            com.huawei.hms.scankit.p.p r1 = r12.a(r10, r0)
            goto L33
        L25:
            r2 = 1069547520(0x3fc00000, float:1.5)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L2c
            r1 = r0
        L2c:
            com.huawei.hms.scankit.p.p r0 = r12.a(r10, r1)
            r8 = r1
            r1 = r0
            r0 = r8
        L33:
            com.huawei.hms.scankit.p.o6[] r2 = r9.a(r13)
            r4 = 0
            r5 = 0
            com.huawei.hms.scankit.p.s6 r1 = r9.a(r1, r2, r13)     // Catch: com.huawei.hms.scankit.p.a -> L79
            if (r1 == 0) goto L4d
            java.lang.String r2 = r1.k()     // Catch: com.huawei.hms.scankit.p.a -> L79
            if (r2 == 0) goto L4d
            com.huawei.hms.scankit.p.u6[] r2 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L79
            com.huawei.hms.scankit.p.k2.a(r2, r0, r4)     // Catch: com.huawei.hms.scankit.p.a -> L79
            return r1
        L4d:
            boolean r0 = com.huawei.hms.scankit.p.r3.f31448c     // Catch: com.huawei.hms.scankit.p.a -> L79
            if (r0 != 0) goto L71
            if (r1 == 0) goto L71
            java.lang.String r0 = r1.k()     // Catch: com.huawei.hms.scankit.p.a -> L79
            if (r0 != 0) goto L71
            com.huawei.hms.scankit.p.u6[] r0 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L79
            int r0 = r0.length     // Catch: com.huawei.hms.scankit.p.a -> L79
            r2 = 3
            if (r0 < r2) goto L71
            r5 = 1
            com.huawei.hms.scankit.p.u6[] r0 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L6e
            java.lang.Object r0 = r0.clone()     // Catch: com.huawei.hms.scankit.p.a -> L6e
            com.huawei.hms.scankit.p.u6[] r0 = (com.huawei.hms.scankit.p.u6[]) r0     // Catch: com.huawei.hms.scankit.p.a -> L6e
            r4 = r0
            goto L71
        L6e:
            r0 = r4
            r1 = 1
            goto L7b
        L71:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()     // Catch: com.huawei.hms.scankit.p.a -> L76
            throw r0     // Catch: com.huawei.hms.scankit.p.a -> L76
        L76:
            r0 = r4
            r1 = r5
            goto L7b
        L79:
            r0 = r4
            r1 = 0
        L7b:
            r2 = r9
            r4 = r12
            r5 = r10
            r6 = r11
            r7 = r13
            com.huawei.hms.scankit.p.s6 r10 = r2.a(r3, r4, r5, r6, r7)
            if (r10 == 0) goto L8f
            if (r1 == 0) goto L8e
            r10.a()
            r10.b(r0)
        L8e:
            return r10
        L8f:
            com.huawei.hms.scankit.p.a r10 = com.huawei.hms.scankit.p.a.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map):com.huawei.hms.scankit.p.s6");
    }

    private s6 a(int i10, m4 m4Var, p pVar, p pVar2, Map<l1, ?> map) throws a {
        o6[] a10 = a(map);
        try {
            if (r3.f31446a) {
                float f10 = (i10 * 1.0f) / 500.0f;
                if (f10 <= 1.0f) {
                    f10 = 1.0f;
                }
                s6 a11 = a(m4Var.g(m4Var.g(pVar, f10)), a10, map);
                if (a11 != null && a11.k() != null) {
                    k2.a(a11.j(), f10, (i2) null);
                    return a11;
                }
            }
            throw a.a();
        } catch (a unused) {
            float f11 = (i10 * 1.0f) / 1080.0f;
            float f12 = f11 > 1.0f ? f11 : 1.0f;
            s6 a12 = a(m4Var.b(pVar2, f12), a10, map);
            if (a12 != null && a12.k() != null) {
                k2.a(a12.j(), f12, (i2) null);
            }
            return a12;
        }
    }
}
