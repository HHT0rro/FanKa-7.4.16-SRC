package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e2 {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f30921g = {210, 236, 264, 244, 270, 280};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f30922h = {21, 25, 29, 33, 37, 41};

    /* renamed from: a, reason: collision with root package name */
    private final s f30923a;

    /* renamed from: b, reason: collision with root package name */
    private v6 f30924b;

    /* renamed from: c, reason: collision with root package name */
    private g3 f30925c;

    /* renamed from: d, reason: collision with root package name */
    private g3 f30926d;

    /* renamed from: e, reason: collision with root package name */
    private g3 f30927e;

    /* renamed from: f, reason: collision with root package name */
    private g3 f30928f;

    public e2(s sVar) {
        this.f30923a = sVar;
    }

    private float b(int i10, int i11, s sVar) throws a {
        int c4 = sVar.c();
        int[] iArr = new int[5];
        for (int i12 = 0; i12 < 5; i12++) {
            iArr[i12] = 0;
        }
        int i13 = i10;
        while (i13 >= 0 && sVar.b(i11, i13)) {
            iArr[2] = iArr[2] + 1;
            i13--;
        }
        if (i13 >= 0) {
            while (i13 >= 0 && !sVar.b(i11, i13)) {
                iArr[1] = iArr[1] + 1;
                i13--;
            }
            if (i13 >= 0) {
                while (i13 >= 0 && sVar.b(i11, i13)) {
                    iArr[0] = iArr[0] + 1;
                    i13--;
                }
                int i14 = i10 + 1;
                while (i14 < c4 && sVar.b(i11, i14)) {
                    iArr[2] = iArr[2] + 1;
                    i14++;
                }
                if (i14 != c4) {
                    while (i14 < c4 && !sVar.b(i11, i14)) {
                        iArr[3] = iArr[3] + 1;
                        i14++;
                    }
                    if (i14 != c4) {
                        while (i14 < c4 && sVar.b(i11, i14)) {
                            iArr[4] = iArr[4] + 1;
                            i14++;
                        }
                        return ((((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4]) / 6.0f;
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    public final g3[] a(Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.NEED_RESULT_POINT_CALLBACK);
        this.f30924b = v6Var;
        return new h3(this.f30923a, v6Var).a(map);
    }

    public final int a(g3[] g3VarArr, g3 g3Var) throws a {
        this.f30925c = g3VarArr[0];
        this.f30926d = g3VarArr[1];
        g3 g3Var2 = g3VarArr[2];
        this.f30927e = g3Var2;
        if (g3Var == null) {
            this.f30928f = new g3((g3Var2.b() - this.f30926d.b()) + this.f30925c.b(), (this.f30927e.c() - this.f30926d.c()) + this.f30925c.c(), 6.0f);
        } else {
            this.f30928f = g3Var;
        }
        float a10 = a(this.f30926d, this.f30927e, this.f30925c, this.f30923a);
        if (a10 >= 1.0f) {
            int a11 = a(this.f30926d, this.f30927e, this.f30925c, a10);
            if (a11 < 0 || a11 > 7) {
                throw a.a();
            }
            return a11;
        }
        throw a.a();
    }

    public final j2 a(int i10) throws a {
        s a10;
        int i11 = i10 - 1;
        double d10 = f30921g[i11];
        float cos = (float) ((Math.cos(0.7853981633974483d) * d10) + 300.0d);
        float cos2 = (float) (300.0d - (d10 * Math.cos(0.7853981633974483d)));
        s a11 = a(this.f30923a, a(this.f30926d, this.f30927e, this.f30925c, this.f30928f, new u6(cos2, cos2), new u6(cos, cos2), new u6(cos2, cos), new u6(cos, cos)), 600);
        int i12 = f30922h[i11];
        s sVar = new s(i12, i12);
        switch (i10) {
            case 1:
                a10 = e8.a(sVar, a11, i12, 300.0d);
                break;
            case 2:
                a10 = h8.a(sVar, a11, i12, 300.0d);
                break;
            case 3:
                a10 = g8.a(sVar, a11, i12, 300.0d);
                break;
            case 4:
                a10 = d8.a(sVar, a11, i12, 300.0d);
                break;
            case 5:
                a10 = c8.a(sVar, a11, i12, 300.0d);
                break;
            case 6:
                a10 = f8.a(sVar, a11, i12, 300.0d);
                break;
            default:
                throw a.a();
        }
        return new j2(a10, new u6[]{this.f30925c, this.f30926d, this.f30927e, this.f30928f});
    }

    private static d6 a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, u6 u6Var5, u6 u6Var6, u6 u6Var7, u6 u6Var8) throws a {
        return d6.a(u6Var5.b(), u6Var5.c(), u6Var6.b(), u6Var6.c(), u6Var8.b(), u6Var8.c(), u6Var7.b(), u6Var7.c(), u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), u6Var4.b(), u6Var4.c(), u6Var3.b(), u6Var3.c());
    }

    private static s a(s sVar, d6 d6Var, int i10) throws a {
        return s3.a().a(sVar, i10, i10, d6Var, false);
    }

    private static int a(u6 u6Var, u6 u6Var2, u6 u6Var3, float f10) throws a {
        float a10 = ((u6.a(u6Var, u6Var2) / f10) + (u6.a(u6Var, u6Var3) / f10)) / 2.0f;
        if (a10 >= 28.1f && a10 <= 31.1f) {
            return 1;
        }
        if (a10 >= 31.7f && a10 <= 34.7f) {
            return 2;
        }
        if (a10 >= 35.9f && a10 <= 38.9f) {
            return 3;
        }
        if (a10 >= 41.7f && a10 <= 44.7f) {
            return 4;
        }
        if (a10 >= 46.3f && a10 <= 49.3f) {
            return 5;
        }
        if (a10 < 54.4f || a10 > 57.4f) {
            return Math.round((a10 - 25.0f) / 4.0f);
        }
        return 6;
    }

    public final float a(u6 u6Var, u6 u6Var2, u6 u6Var3, s sVar) throws a {
        return (((((a((int) u6Var.b(), (int) u6Var.c(), sVar) + a((int) u6Var2.b(), (int) u6Var2.c(), sVar)) + a((int) u6Var3.b(), (int) u6Var3.c(), sVar)) + b((int) u6Var.c(), (int) u6Var.b(), sVar)) + b((int) u6Var2.c(), (int) u6Var2.b(), sVar)) + b((int) u6Var3.c(), (int) u6Var3.b(), sVar)) / 6.0f;
    }

    private float a(int i10, int i11, s sVar) throws a {
        int e2 = sVar.e();
        int[] iArr = new int[5];
        for (int i12 = 0; i12 < 5; i12++) {
            iArr[i12] = 0;
        }
        int i13 = i10;
        while (i13 >= 0 && sVar.b(i13, i11)) {
            iArr[2] = iArr[2] + 1;
            i13--;
        }
        if (i13 >= 0) {
            while (i13 >= 0 && !sVar.b(i13, i11)) {
                iArr[1] = iArr[1] + 1;
                i13--;
            }
            if (i13 >= 0) {
                while (i13 >= 0 && sVar.b(i13, i11)) {
                    iArr[0] = iArr[0] + 1;
                    i13--;
                }
                int i14 = i10 + 1;
                while (i14 < e2 && sVar.b(i14, i11)) {
                    iArr[2] = iArr[2] + 1;
                    i14++;
                }
                if (i14 != e2) {
                    while (i14 < e2 && !sVar.b(i14, i11)) {
                        iArr[3] = iArr[3] + 1;
                        i14++;
                    }
                    if (i14 != e2) {
                        while (i14 < e2 && sVar.b(i14, i11)) {
                            iArr[4] = iArr[4] + 1;
                            i14++;
                        }
                        return ((((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4]) / 6.0f;
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }
}
