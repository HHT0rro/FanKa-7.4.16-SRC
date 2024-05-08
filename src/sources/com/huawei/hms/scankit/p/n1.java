package com.huawei.hms.scankit.p;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    private p4 f31295a;

    /* renamed from: b, reason: collision with root package name */
    private p f31296b;

    /* renamed from: c, reason: collision with root package name */
    private p f31297c;

    /* renamed from: d, reason: collision with root package name */
    private p f31298d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f31299e;

    /* renamed from: g, reason: collision with root package name */
    private float f31301g;

    /* renamed from: f, reason: collision with root package name */
    private float f31300f = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f31302h = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f31304j = 1.778f;

    /* renamed from: k, reason: collision with root package name */
    private int f31305k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f31306l = 0;

    /* renamed from: i, reason: collision with root package name */
    public m4 f31303i = new m4();

    public n1(p4 p4Var) {
        this.f31299e = false;
        this.f31301g = 0.0f;
        this.f31295a = p4Var;
        this.f31296b = new p(new q3(this.f31295a));
        this.f31297c = new p(new e4(this.f31295a));
        this.f31299e = false;
        this.f31301g = 0.0f;
    }

    public static s6 a(List<i2> list, n1 n1Var) {
        for (i2 i2Var : list) {
            if (r3.f31447b || i2Var.h() > 0.4d) {
                int j10 = (int) i2Var.j();
                int k10 = (int) i2Var.k();
                if (j10 > n1Var.f31295a.c() / 3 && j10 < (n1Var.f31295a.c() * 2) / 3 && k10 > n1Var.f31295a.a() / 3 && k10 < (n1Var.f31295a.a() * 2) / 3) {
                    float c4 = n1Var.c(n1Var.f31298d);
                    s6 s6Var = new s6(1.0f);
                    s6Var.a(c4);
                    s6Var.a(i2Var);
                    return s6Var;
                }
            }
        }
        return null;
    }

    public s6 b(List<BarcodeFormat> list, i2 i2Var) {
        s6 b4;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        try {
            if (i2Var != null) {
                b4 = a5Var.b(this.f31296b, this.f31297c, this.f31298d, hashMap, this.f31303i, i2Var);
            } else {
                b4 = a5Var.b(this.f31296b, this.f31297c, null, hashMap, this.f31303i, null);
            }
            try {
                if (r3.f31448c || b4 == null || b4.k() != null || b4.j() == null || b4.j().length < 3) {
                    return b4;
                }
                float b10 = o8.b(this.f31295a.c(), this.f31295a.a(), b4.j());
                if (Math.abs(1.0f - b10) <= 0.001d) {
                    return b4;
                }
                this.f31302h = b10;
                this.f31299e = true;
                return b4;
            } catch (a unused) {
                return b4;
            }
        } catch (a unused2) {
            return null;
        }
    }

    public s6 c(List<BarcodeFormat> list, i2 i2Var) {
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        s6 s6Var = null;
        if (i2Var != null) {
            try {
                s6Var = a5Var.a(this.f31296b, this.f31297c, this.f31298d, hashMap, this.f31303i, i2Var);
            } catch (a unused) {
            }
        }
        if (!r3.f31448c && s6Var != null && s6Var.k() == null && s6Var.j() != null && s6Var.j().length >= 3) {
            float b4 = o8.b(this.f31295a.c(), this.f31295a.a(), new u6[]{new u6(i2Var.d(), i2Var.e()), new u6(i2Var.d() + i2Var.f(), i2Var.e()), new u6(i2Var.d(), i2Var.e() + i2Var.c())});
            if (Math.abs(1.0f - b4) > 0.001d) {
                this.f31302h = b4;
                this.f31299e = true;
            }
            boolean z10 = this.f31299e;
        }
        return s6Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ed A[Catch: a -> 0x00f5, TRY_ENTER, TRY_LEAVE, TryCatch #3 {a -> 0x00f5, blocks: (B:11:0x0038, B:16:0x00ed, B:27:0x0056, B:29:0x0064, B:35:0x007e, B:37:0x0089, B:39:0x009c, B:42:0x0094), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0089 A[Catch: a -> 0x00f5, TryCatch #3 {a -> 0x00f5, blocks: (B:11:0x0038, B:16:0x00ed, B:27:0x0056, B:29:0x0064, B:35:0x007e, B:37:0x0089, B:39:0x009c, B:42:0x0094), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 d(java.util.List<com.huawei.hms.scankit.aiscan.common.BarcodeFormat> r31, com.huawei.hms.scankit.p.i2 r32) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.d(java.util.List, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    public s6 e(List<BarcodeFormat> list, i2 i2Var) {
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        if (i2Var != null) {
            r3.f31457l = true;
            s6 a10 = a(hashMap, i2Var);
            r3.f31457l = false;
            if (a10 != null && a10.k() == null && r3.f31461p) {
                r3.f31458m = true;
                a10 = g(list, i2Var);
                r3.f31458m = false;
            }
            if (a10 != null && a10.k() == null && r3.f31462q) {
                r3.f31459n = true;
                a10 = a(hashMap, i2Var);
                r3.f31459n = false;
            }
            if ((a10 != null && a10.k() != null) || !r3.f31463r) {
                return a10;
            }
            r3.f31460o = true;
            s6 a11 = a(hashMap, i2Var);
            r3.f31460o = false;
            return a11;
        }
        s6 a12 = a(hashMap);
        if (a12 != null && a12.k() == null && r3.f31462q) {
            r3.f31458m = true;
            a12 = a(hashMap);
            r3.f31458m = false;
        }
        s6 s6Var = a12;
        if (s6Var == null || s6Var.k() != null || !r3.f31463r) {
            return s6Var;
        }
        r3.f31459n = true;
        s6 a13 = a(hashMap);
        r3.f31459n = false;
        return a13;
    }

    public s6 f(List<BarcodeFormat> list, i2 i2Var) {
        p4 p4Var;
        p4 p4Var2;
        float f10;
        p pVar;
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        try {
            if (i2Var != null) {
                p4Var = this.f31298d.a().c();
            } else {
                p4Var = this.f31295a;
            }
            if (!r3.f31446a || (this.f31296b.e() <= 800 && this.f31296b.c() <= 800)) {
                p4Var2 = p4Var;
                f10 = 1.0f;
            } else {
                float e2 = (this.f31296b.e() > this.f31296b.c() ? this.f31296b.e() : this.f31296b.c()) / 800.0f;
                p4Var2 = this.f31303i.h(new p(new q3(p4Var)), e2).a().c();
                f10 = e2;
            }
            if (p4Var2 != null) {
                if (r3.f31446a && !r3.f31447b) {
                    s a10 = a(p4Var2.b(), p4Var2.c(), p4Var2.a(), false);
                    pVar = new p(new q3(p4Var2));
                    pVar.a(a10);
                } else {
                    pVar = new p(new q3(p4Var2));
                }
                a5 a5Var = new a5();
                try {
                    s6 a11 = a5Var.a(pVar, hashMap);
                    if (a11 != null && a11.k() != null) {
                        k2.a(a11.j(), f10, i2Var);
                        return a11;
                    }
                    throw a.a();
                } catch (a unused) {
                    return a(a5Var, p4Var2, pVar, hashMap, f10, i2Var);
                }
            }
            throw a.a();
        } catch (a unused2) {
            return null;
        }
    }

    public s6 g(List<BarcodeFormat> list, i2 i2Var) {
        p pVar;
        p pVar2;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        float f10 = 1.0f;
        if (i2Var == null) {
            if (r3.f31446a && (this.f31296b.e() > 500 || this.f31296b.c() > 500)) {
                f10 = (this.f31296b.e() > this.f31296b.c() ? this.f31296b.e() : this.f31296b.c()) / 500.0f;
                pVar = this.f31303i.c(this.f31296b, f10);
            } else {
                pVar = this.f31296b;
            }
        } else if (r3.f31446a && (pVar2 = this.f31298d) != null && (pVar2.e() > 500 || this.f31298d.c() > 500)) {
            f10 = (this.f31298d.e() > this.f31298d.c() ? this.f31298d.e() : this.f31298d.c()) / 500.0f;
            pVar = this.f31303i.g(this.f31298d, f10);
        } else {
            pVar = this.f31298d;
        }
        try {
            s6 a10 = a5Var.a(pVar, hashMap);
            if (a10 == null) {
                return a10;
            }
            try {
                if (a10.k() == null) {
                    return a10;
                }
                k2.a(a10.j(), f10, i2Var);
                return a10;
            } catch (a unused) {
                return a10;
            }
        } catch (a unused2) {
            return null;
        }
    }

    public s6 h(List<BarcodeFormat> list, i2 i2Var) {
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        s6 s6Var = null;
        if (i2Var != null) {
            try {
                s6Var = a5Var.c(this.f31298d, this.f31303i, hashMap, i2Var);
            } catch (a unused) {
            }
        }
        if (!r3.f31448c && s6Var != null && s6Var.k() == null && s6Var.j() != null && s6Var.j().length >= 3) {
            float b4 = o8.b(this.f31295a.c(), this.f31295a.a(), s6Var.j());
            if (Math.abs(1.0f - b4) > 0.001d) {
                this.f31302h = b4;
                this.f31299e = true;
            }
        }
        return s6Var;
    }

    private p b(p pVar) {
        int e2 = pVar.e();
        int c4 = pVar.c();
        if (e2 < c4) {
            if (c4 / e2 <= 1.2d) {
                return pVar;
            }
            int i10 = (int) (e2 * 1.2d);
            int i11 = (c4 - i10) / 2;
            this.f31306l = i11;
            return pVar.a(0, i11, e2, i10);
        }
        if (e2 / c4 <= 1.2d) {
            return pVar;
        }
        int i12 = (int) (c4 * 1.2d);
        int i13 = (e2 - i12) / 2;
        this.f31305k = i13;
        return pVar.a(i13, 0, i12, c4);
    }

    public p a() {
        return this.f31296b;
    }

    public static s6 a(n1 n1Var) {
        float c4 = n1Var.c(n1Var.f31296b);
        s6 s6Var = new s6(1.0f);
        s6Var.b(c4);
        s6Var.b(new i2(false, 0.0f, 0.0f, n1Var.f31296b.e(), n1Var.f31296b.e(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        return s6Var;
    }

    public float c(p pVar) {
        if (((pVar == null || (pVar.a() == null && pVar.a().c() == null)) ? null : pVar.a().c().b()) == null) {
            return 1.0f;
        }
        long j10 = 0;
        int e2 = pVar.e();
        int c4 = pVar.c();
        for (int i10 = c4 / 4; i10 < (c4 * 3) / 4; i10++) {
            for (int i11 = e2 / 4; i11 < (e2 * 3) / 4; i11++) {
                j10 += r0[(i10 * e2) + i11] & 255;
            }
        }
        return (float) ((j10 / r0.length) * 4);
    }

    public void b(i2 i2Var) {
        try {
            if (r3.f31446a) {
                k2.a(r3.f31447b, this.f31296b, i2Var);
                this.f31298d = i2Var.f31101l;
            }
        } catch (a unused) {
        }
    }

    public static boolean a(List<i2> list, boolean z10) {
        if (!z10 && !r3.f31447b) {
            float[] a10 = a(list.get(0));
            float a11 = a(a10);
            r3.f31470y = a10;
            if (a11 >= 0.6f) {
                r3.f31471z++;
            } else {
                r3.f31471z = 1;
            }
            o4.d("DecodeProcessor", "iou: " + a11 + " focusAreaFrameCount: " + r3.f31471z);
            if (r3.f31471z < 8) {
                return false;
            }
            o4.d("DecodeProcessor", "need area focus");
            r3.f31471z = 1;
            return true;
        }
        r3.f31470y = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        r3.f31471z = 0;
        return false;
    }

    public boolean b() {
        return this.f31299e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b0, code lost:
    
        if (a(r13.f31296b, r0) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b2, code lost:
    
        r1 = com.huawei.hms.scankit.p.r3.f31456k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b5, code lost:
    
        if (r1 <= 4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
    
        com.huawei.hms.scankit.p.r3.f31456k = r1 + 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.util.List<com.huawei.hms.scankit.p.i2> r14) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.b(java.util.List):boolean");
    }

    public float c() {
        return this.f31300f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (a(r17.f31296b, r2) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e4, code lost:
    
        r3 = com.huawei.hms.scankit.p.r3.f31456k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e7, code lost:
    
        if (r3 <= 4) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ea, code lost:
    
        com.huawei.hms.scankit.p.r3.f31456k = r3 + 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(java.util.List<com.huawei.hms.scankit.p.i2> r18) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.c(java.util.List):boolean");
    }

    public float e() {
        return this.f31301g;
    }

    public float d() {
        return this.f31302h;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r14, com.huawei.hms.scankit.p.i2 r15) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(java.util.Map, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    public static boolean b(p pVar, i2 i2Var) {
        if (r3.f31446a && !r3.f31447b) {
            float d10 = i2Var.d();
            float e2 = i2Var.e();
            float f10 = i2Var.f();
            float c4 = i2Var.c();
            float f11 = d10 - ((f10 * 0.2f) / 2.0f);
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            float f12 = e2 - ((0.2f * c4) / 2.0f);
            float f13 = f12 >= 0.0f ? f12 : 0.0f;
            float f14 = (f10 * 1.2f) + f11;
            if (f14 > pVar.e()) {
                f14 = pVar.e();
            }
            float f15 = (c4 * 1.2f) + f13;
            if (f15 > pVar.c()) {
                f15 = pVar.c();
            }
            List<i2> a10 = k2.a(r3.f31447b, pVar.a((int) f11, (int) f13, (int) (f14 - f11), (int) (f15 - f13)), 0, true);
            if (!a10.isEmpty() && a10.get(0).g() == 6.0f) {
                return true;
            }
        }
        return false;
    }

    public static float a(float[] fArr) {
        float[] fArr2 = r3.f31470y;
        float f10 = (fArr2[2] - fArr2[0]) * (fArr2[3] - fArr2[1]);
        if (f10 == ShadowDrawableWrapper.COS_45) {
            return 0.0f;
        }
        float f11 = f10 + ((fArr[2] - fArr[0]) * (fArr[3] - fArr[1]));
        float max = Math.max(fArr2[1], fArr[1]);
        float min = Math.min(r3.f31470y[3], fArr[3]);
        float max2 = Math.max(r3.f31470y[0], fArr[0]);
        float min2 = Math.min(r3.f31470y[2], fArr[2]);
        if (max >= min || max2 >= min2) {
            return 0.0f;
        }
        float f12 = (min - max) * (min2 - max2);
        return (f12 / (f11 - f12)) * 1.0f;
    }

    public static float[] a(i2 i2Var) {
        return new float[]{i2Var.f31108s, i2Var.f31107r, r1 + i2Var.f31106q, r2 + i2Var.f31105p};
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0166 A[Catch: a -> 0x01f2, TRY_LEAVE, TryCatch #2 {a -> 0x01f2, blocks: (B:43:0x011c, B:45:0x0166, B:60:0x01bb, B:62:0x01c8, B:64:0x01ce, B:66:0x01d3, B:68:0x01e9, B:70:0x01ed, B:71:0x01f1, B:47:0x0185, B:49:0x018b, B:51:0x0191, B:53:0x0196, B:55:0x01af, B:57:0x01b3, B:58:0x01b7), top: B:42:0x011c, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r22, com.huawei.hms.scankit.p.s6 r23, com.huawei.hms.scankit.p.s6 r24, com.huawei.hms.scankit.p.a5 r25, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r26, float r27, com.huawei.hms.scankit.p.i2 r28) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.s6, com.huawei.hms.scankit.p.s6, com.huawei.hms.scankit.p.a5, java.util.Map, float, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r14) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(java.util.Map):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.a5 r15, com.huawei.hms.scankit.p.p4 r16, com.huawei.hms.scankit.p.s6 r17, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r18, float r19, int r20, int r21) {
        /*
            r14 = this;
            r7 = r14
            r4 = r17
            r5 = r18
            r6 = r19
            r0 = r20
            r1 = r21
            boolean r2 = com.huawei.hms.scankit.p.r3.f31446a
            r3 = 0
            if (r2 == 0) goto L99
            r2 = 3
            com.huawei.hms.scankit.p.q3 r8 = new com.huawei.hms.scankit.p.q3     // Catch: com.huawei.hms.scankit.p.a -> L4a
            r9 = r16
            r8.<init>(r9)     // Catch: com.huawei.hms.scankit.p.a -> L48
            com.huawei.hms.scankit.p.p r10 = new com.huawei.hms.scankit.p.p     // Catch: com.huawei.hms.scankit.p.a -> L48
            r10.<init>(r8)     // Catch: com.huawei.hms.scankit.p.a -> L48
            r8 = r15
            com.huawei.hms.scankit.p.s6 r3 = r15.a(r10, r5)     // Catch: com.huawei.hms.scankit.p.a -> L46
            if (r3 == 0) goto L2f
            java.lang.String r11 = r3.k()     // Catch: com.huawei.hms.scankit.p.a -> L46
            if (r11 == 0) goto L2f
            com.huawei.hms.scankit.p.s6 r0 = r14.a(r3, r6, r0, r1)     // Catch: com.huawei.hms.scankit.p.a -> L46
            return r0
        L2f:
            if (r3 == 0) goto L4e
            com.huawei.hms.scankit.p.u6[] r11 = r3.j()     // Catch: com.huawei.hms.scankit.p.a -> L46
            if (r11 == 0) goto L4e
            com.huawei.hms.scankit.p.u6[] r11 = r3.j()     // Catch: com.huawei.hms.scankit.p.a -> L46
            int r11 = r11.length     // Catch: com.huawei.hms.scankit.p.a -> L46
            if (r11 < r2) goto L4e
            com.huawei.hms.scankit.p.u6[] r3 = r3.j()     // Catch: com.huawei.hms.scankit.p.a -> L46
            r4.b(r3)     // Catch: com.huawei.hms.scankit.p.a -> L46
            goto L4e
        L46:
            r3 = r10
            goto L4d
        L48:
            r8 = r15
            goto L4d
        L4a:
            r8 = r15
            r9 = r16
        L4d:
            r10 = r3
        L4e:
            if (r4 == 0) goto L8a
            com.huawei.hms.scankit.p.u6[] r3 = r17.j()     // Catch: com.huawei.hms.scankit.p.a -> L8a
            if (r3 == 0) goto L8a
            com.huawei.hms.scankit.p.u6[] r3 = r17.j()     // Catch: com.huawei.hms.scankit.p.a -> L8a
            int r3 = r3.length     // Catch: com.huawei.hms.scankit.p.a -> L8a
            if (r3 < r2) goto L8a
            boolean r3 = com.huawei.hms.scankit.p.r3.f31458m     // Catch: com.huawei.hms.scankit.p.a -> L8a
            if (r3 != 0) goto L8a
            r3 = 6
            double[] r3 = new double[r3]     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r11 = 0
            r12 = 0
            r3[r11] = r12     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r11 = 1
            r3[r11] = r12     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r11 = 2
            r3[r11] = r12     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r3[r2] = r12     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r2 = 4
            r3[r2] = r12     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r2 = 5
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r3[r2] = r11     // Catch: com.huawei.hms.scankit.p.a -> L8a
            com.huawei.hms.scankit.p.s6 r2 = r14.a(r10, r5, r4, r3)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            if (r2 == 0) goto L8a
            java.lang.String r3 = r2.k()     // Catch: com.huawei.hms.scankit.p.a -> L8a
            if (r3 == 0) goto L8a
            com.huawei.hms.scankit.p.s6 r0 = r14.a(r2, r6, r0, r1)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            return r0
        L8a:
            r0 = r14
            r1 = r10
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            com.huawei.hms.scankit.p.s6 r3 = r0.a(r1, r2, r3, r4, r5, r6)
        L99:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(com.huawei.hms.scankit.p.a5, com.huawei.hms.scankit.p.p4, com.huawei.hms.scankit.p.s6, java.util.Map, float, int, int):com.huawei.hms.scankit.p.s6");
    }

    private s6 a(p pVar, a5 a5Var, p4 p4Var, s6 s6Var, Map<l1, Object> map, float f10) {
        s6 s6Var2 = null;
        try {
            j6.a(this.f31295a, s6Var);
            if (r3.f31448c && r3.f31467v[1]) {
                r3.f31464s = true;
                s6Var2 = a5Var.a(this.f31296b, map);
                r3.f31464s = false;
                if (s6Var2 != null && s6Var2.k() != null) {
                    return a(s6Var2, f10, 0, 0);
                }
            }
        } catch (a unused) {
            r3.f31464s = false;
        }
        float e2 = pVar.e() / pVar.c();
        if (e2 < 1.0f) {
            e2 = 1.0f / e2;
        }
        if (!r3.f31458m && !r3.f31459n) {
            double d10 = e2;
            if (d10 > 1.27d && d10 < 1.272d) {
                r3.f31466u = true;
                try {
                    s6Var2 = a5Var.a(new p(new e4(p4Var)), map);
                    if (s6Var2 != null && s6Var2.k() != null) {
                        return a(s6Var2, f10, 0, 0);
                    }
                } catch (a unused2) {
                }
                r3.f31466u = false;
            }
        }
        return s6Var2;
    }

    private s6 a(a5 a5Var, p4 p4Var, p pVar, Map<l1, Object> map, float f10, i2 i2Var) throws a {
        p pVar2;
        s6 a10;
        p pVar3;
        s6 s6Var = null;
        if (r3.f31446a && !r3.f31447b) {
            try {
                pVar3 = new p(new q3(p4Var));
                try {
                    s6 a11 = a5Var.a(pVar3, map);
                    if (a11 != null) {
                        try {
                            if (a11.k() != null) {
                                k2.a(a11.j(), f10, i2Var);
                                return a11;
                            }
                        } catch (a unused) {
                            s6Var = a11;
                            pVar = pVar3;
                            pVar3 = pVar;
                            if (s6Var != null) {
                                try {
                                    s6Var = a(pVar3, map, s6Var, new double[]{ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, 1.0d});
                                    if (s6Var != null) {
                                        k2.a(s6Var.j(), f10, i2Var);
                                        return s6Var;
                                    }
                                } catch (a unused2) {
                                }
                            }
                            pVar2 = new p(new e4(p4Var));
                            a10 = a5Var.a(pVar2, map);
                            if (a10 == null) {
                            }
                            throw a.a();
                        }
                    }
                    s6Var = a11;
                } catch (a unused3) {
                }
            } catch (a unused4) {
            }
            if (s6Var != null && s6Var.j() != null && s6Var.j().length >= 3) {
                s6Var = a(pVar3, map, s6Var, new double[]{ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, 1.0d});
                if (s6Var != null && s6Var.k() != null) {
                    k2.a(s6Var.j(), f10, i2Var);
                    return s6Var;
                }
            }
        }
        pVar2 = new p(new e4(p4Var));
        try {
            a10 = a5Var.a(pVar2, map);
            if (a10 == null && a10.k() != null) {
                k2.a(a10.j(), f10, i2Var);
                return a10;
            }
            throw a.a();
        } catch (a unused5) {
            if (r3.f31446a && !r3.f31447b && s6Var != null && s6Var.j() != null && s6Var.j().length >= 3 && (s6Var = a(pVar2, map, s6Var, new double[]{ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, 1.0d})) != null && s6Var.k() != null) {
                k2.a(s6Var.j(), f10, i2Var);
            }
            return s6Var;
        }
    }

    public s6 a(List<BarcodeFormat> list, i2 i2Var) {
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        if (r3.f31448c) {
            hashMap.put(l1.PHOTO_MODE, Boolean.valueOf(r3.f31448c));
        }
        s6 s6Var = null;
        try {
            if (i2Var != null) {
                s6Var = a5Var.a(this.f31296b, this.f31298d, hashMap, this.f31303i, i2Var);
            } else {
                s6Var = a5Var.a(this.f31296b, (p) null, hashMap, this.f31303i, (i2) null);
            }
        } catch (a unused) {
        }
        if (s6Var != null || r3.f31447b || i2Var == null || !r3.f31448c || i2Var.h() >= 0.8d) {
            return s6Var;
        }
        float i10 = i2Var.i() % 180.0f;
        boolean z10 = true;
        boolean z11 = ((double) i2Var.c()) > ((double) this.f31296b.c()) * 0.97d && ((i10 < 5.0f && i10 > -5.0f) || i10 < -175.0f || i10 > 175.0f);
        if (i2Var.b() <= this.f31296b.e() * 0.97d || ((i10 >= 95.0f || i10 <= 85.0f) && (i10 >= -85.0f || i10 <= -95.0f))) {
            z10 = false;
        }
        if (!z11 && !z10) {
            return s6Var;
        }
        this.f31303i.a();
        try {
            return a5Var.a(this.f31296b, (p) null, hashMap, this.f31303i, (i2) null);
        } catch (a unused2) {
            return s6Var;
        }
    }

    public List<i2> a(int i10, boolean z10) {
        List<i2> a10;
        ArrayList arrayList = new ArrayList();
        if (!r3.f31446a) {
            return arrayList;
        }
        boolean z11 = r3.f31447b;
        if (!z11) {
            byte[] c4 = y4.c();
            byte[] a11 = y4.a();
            byte[] b4 = y4.b();
            LoadOpencvJNIUtil.setModel(c4, c4.length, a11, a11.length, b4, b4.length);
            p pVar = this.f31296b;
            long currentTimeMillis = System.currentTimeMillis() % 10;
            boolean z12 = currentTimeMillis % 2 == 0;
            boolean z13 = currentTimeMillis % 3 == 0;
            if (i10 == 0 && !r3.f31448c && z12) {
                pVar = b(this.f31296b);
            } else if (i10 == 0 && !r3.f31448c && z13) {
                pVar = a(b(this.f31296b));
            }
            a10 = k2.a(r3.f31447b, pVar, i10, z10);
        } else {
            a10 = k2.a(z11, this.f31296b, i10, z10);
        }
        List<i2> list = a10;
        a(list);
        return list;
    }

    private p a(p pVar) {
        int e2 = pVar.e();
        int c4 = pVar.c();
        int i10 = (int) (e2 * 0.75d);
        int i11 = (int) (c4 * 0.75d);
        int i12 = (e2 - i10) / 2;
        this.f31305k += i12;
        int i13 = (c4 - i11) / 2;
        this.f31306l += i13;
        return pVar.a(i12, i13, i10, i11);
    }

    private void a(List<i2> list) {
        for (i2 i2Var : list) {
            i2Var.a(this.f31295a.c(), this.f31295a.a(), this.f31305k, this.f31306l);
            float min = Math.min(Math.abs(i2Var.i() % 90.0f), 90.0f - Math.abs(i2Var.i() % 90.0f));
            if (i2Var.c() * i2Var.f() > this.f31295a.a() * 0.9f * this.f31295a.c() && min < 5.0f) {
                i2Var.b(this.f31295a.c(), this.f31295a.a());
            }
        }
    }

    private s6 a(p pVar, Map<l1, Object> map, s6 s6Var, double[] dArr) throws a {
        s6 s6Var2;
        if (pVar == null) {
            return null;
        }
        a5 a5Var = new a5();
        int[] iArr = {0, 0};
        e6 e6Var = new e6(k7.a(pVar, map, s6Var, iArr, dArr), iArr[0], iArr[1], 0, 0, iArr[0], iArr[1], false);
        try {
            s6Var2 = a5Var.a(new p(new q3(e6Var)), map);
            if (s6Var2 != null) {
                try {
                    if (s6Var2.k() != null) {
                        u6[] a10 = k7.a(s6Var2.j(), pVar.e(), pVar.c(), dArr);
                        s6Var2.a();
                        s6Var2.b(a10);
                        return s6Var2;
                    }
                } catch (a unused) {
                    p pVar2 = new p(new e4(e6Var));
                    try {
                        s6 a11 = a5Var.a(pVar2, map);
                        if (a11 != null && a11.k() != null) {
                            u6[] a12 = k7.a(a11.j(), pVar.e(), pVar.c(), dArr);
                            a11.a();
                            a11.b(a12);
                            return a11;
                        }
                        throw a.a();
                    } catch (a unused2) {
                        pVar2.a(a(e6Var.b(), e6Var.c(), e6Var.a(), false));
                        try {
                            s6 a13 = a5Var.a(pVar2, map);
                            if (a13 != null && a13.k() != null) {
                                u6[] a14 = k7.a(a13.j(), pVar.e(), pVar.c(), dArr);
                                a13.a();
                                a13.b(a14);
                                return a13;
                            }
                            throw a.a();
                        } catch (a unused3) {
                            return s6Var2;
                        }
                    }
                }
            }
            throw a.a();
        } catch (a unused4) {
            s6Var2 = s6Var;
        }
    }

    private s6 a(s6 s6Var, float f10, int i10, int i11) {
        if (s6Var != null && s6Var.j().length == 4 && (Math.abs(f10 - 1.0f) >= 1.0E-6f || i10 != 0 || i11 != 0)) {
            u6[] u6VarArr = new u6[4];
            for (int i12 = 0; i12 < 4; i12++) {
                u6VarArr[i12] = new u6((s6Var.j()[i12].b() * f10) + i10, (s6Var.j()[i12].c() * f10) + i11);
            }
            s6Var.a();
            s6Var.a(u6VarArr);
        }
        return s6Var;
    }

    public static s a(byte[] bArr, int i10, int i11, boolean z10) throws a {
        int i12 = i10 / 11;
        byte[] adaptivebinary = LoadOpencvJNIUtil.adaptivebinary(bArr, i11, i10, (i12 + (i12 % 2)) - 1, z10);
        if (adaptivebinary != null) {
            s sVar = new s(i10, i11);
            for (int i13 = 0; i13 < i11; i13++) {
                for (int i14 = 0; i14 < i10; i14++) {
                    if (adaptivebinary[(i13 * i10) + i14] == 0) {
                        sVar.c(i14, i13);
                    }
                }
            }
            return sVar;
        }
        throw a.a();
    }

    public static p a(byte[] bArr, int i10, int i11) throws a {
        byte[] sharpen = LoadOpencvJNIUtil.sharpen(bArr, i11, i10);
        if (sharpen != null) {
            return new p(new e4(new e6(sharpen, i10, i11, 0, 0, i10, i11, false)));
        }
        throw a.a();
    }

    private static boolean a(p pVar, i2 i2Var) {
        if (r3.f31446a && !r3.f31447b) {
            float d10 = i2Var.d();
            float e2 = i2Var.e();
            float f10 = i2Var.f();
            float c4 = i2Var.c();
            float f11 = d10 - ((f10 * 0.2f) / 2.0f);
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            float f12 = e2 - ((0.2f * c4) / 2.0f);
            float f13 = f12 >= 0.0f ? f12 : 0.0f;
            float f14 = (f10 * 1.2f) + f11;
            if (f14 > pVar.e()) {
                f14 = pVar.e();
            }
            float f15 = (c4 * 1.2f) + f13;
            if (f15 > pVar.c()) {
                f15 = pVar.c();
            }
            float f16 = f14 - f11;
            float f17 = f15 - f13;
            if (f16 < pVar.e() / 2.0f && f17 < pVar.c() / 2.0f) {
                for (i2 i2Var2 : k2.a(r3.f31447b, pVar.a((int) f11, (int) f13, (int) f16, (int) f17), 0, true)) {
                    boolean z10 = i2Var2.g() == 1.0f && ((double) i2Var2.h()) > 0.5d;
                    boolean z11 = i2Var.g() == 2.0f && i2Var2.g() == 2.0f && ((double) i2Var2.h()) > 0.7d;
                    boolean z12 = i2Var.g() == 3.0f && i2Var2.g() == 3.0f && ((double) i2Var2.h()) > 0.7d;
                    boolean z13 = i2Var.g() == 7.0f && i2Var2.g() == 7.0f && ((double) i2Var2.h()) > 0.7d;
                    boolean z14 = i2Var.g() == 6.0f && i2Var2.g() == 6.0f && ((double) i2Var2.h()) > 0.7d;
                    if (z10 || z11 || z12 || z13 || z14) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}
