package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g2 {

    /* renamed from: a, reason: collision with root package name */
    private final s f31024a;

    /* renamed from: b, reason: collision with root package name */
    private v6 f31025b;

    public g2(s sVar) {
        this.f31024a = sVar;
    }

    private static d6 a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, u6 u6Var5, int i10) {
        float b4;
        float c4;
        float f10;
        float f11;
        float f12 = i10 - 3.5f;
        if (u6Var4 != null) {
            float b10 = u6Var4.b();
            b4 = b10;
            c4 = u6Var4.c();
            f10 = u6Var5.b();
            f11 = u6Var5.c();
        } else {
            b4 = (u6Var2.b() - u6Var.b()) + u6Var3.b();
            c4 = (u6Var2.c() - u6Var.c()) + u6Var3.c();
            f10 = f12;
            f11 = f10;
        }
        return d6.a(3.5f, 3.5f, f12, 3.5f, f10, f11, 3.5f, f12, u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), b4, c4, u6Var3.b(), u6Var3.c());
    }

    private float b(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float a10 = a(i10, i11, i12, i13);
        int i14 = i10 - (i12 - i10);
        if (i10 == i14) {
            return Float.NaN;
        }
        int i15 = 0;
        if (i14 < 0) {
            f10 = i10 / (i10 - i14);
            i14 = 0;
        } else if (i14 >= this.f31024a.e()) {
            f10 = ((this.f31024a.e() - 1) - i10) / (i14 - i10);
            i14 = this.f31024a.e() - 1;
        } else {
            f10 = 1.0f;
        }
        float f12 = i11;
        int i16 = (int) (f12 - ((i13 - i11) * f10));
        if (i11 == i16) {
            return Float.NaN;
        }
        if (i16 < 0) {
            f11 = f12 / (i11 - i16);
        } else if (i16 >= this.f31024a.c()) {
            f11 = ((this.f31024a.c() - 1) - i11) / (i16 - i11);
            i15 = this.f31024a.c() - 1;
        } else {
            i15 = i16;
            f11 = 1.0f;
        }
        float a11 = a(i10, i11, (int) (i10 + ((i14 - i10) * f11)), i15);
        if (Math.max(a10, a11) > Math.min(a10, a11) * 1.5d) {
            return Float.NaN;
        }
        return (a10 + a11) - 1.0f;
    }

    private static s a(s sVar, d6 d6Var, int i10) throws a {
        return s3.a().a(sVar, i10, i10, d6Var, true);
    }

    private static int a(u6 u6Var, u6 u6Var2, u6 u6Var3, float f10) throws a {
        int a10;
        int i10;
        try {
            a10 = ((s4.a(u6.a(u6Var, u6Var2) / f10) + s4.a(u6.a(u6Var, u6Var3) / f10)) / 2) + 7;
            i10 = a10 & 3;
        } catch (a unused) {
            a10 = ((((int) (u6.a(u6Var, u6Var2) / f10)) + ((int) (u6.a(u6Var, u6Var3) / f10))) / 2) + 7;
            int i11 = a10 & 3;
            if (i11 != 0) {
                if (i11 != 2) {
                    return i11 != 3 ? a10 : a10 + 2;
                }
            }
        }
        if (i10 != 0) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return a10;
                }
                throw a.a();
            }
            return a10 - 1;
        }
        return a10 + 1;
    }

    public final j2 a(Map<l1, ?> map) throws a {
        this.f31025b = map == null ? null : (v6) map.get(l1.NEED_RESULT_POINT_CALLBACK);
        return a(new i3(this.f31024a, this.f31025b).b());
    }

    public final j2 a(k3 k3Var) throws a {
        e3 b4 = k3Var.b();
        e3 c4 = k3Var.c();
        e3 a10 = k3Var.a();
        try {
            float a11 = a(b4, c4, a10);
            if (a11 >= 1.0f) {
                return a(b4, c4, a10, a11);
            }
            throw a.a();
        } catch (a unused) {
            float e2 = ((b4.e() + c4.e()) + a10.e()) / 3.0f;
            if (e2 >= 1.0f) {
                return a(b4, c4, a10, e2);
            }
            throw a.a();
        }
    }

    private j2 a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f10) throws a {
        d[] dVarArr;
        d[] dVarArr2;
        d[] dVarArr3;
        char c4;
        int i10;
        d6 d6Var;
        u6[] u6VarArr;
        int a10 = a((u6) e3Var, (u6) e3Var2, (u6) e3Var3, f10);
        r3.f31468w.push(Integer.valueOf(a10));
        b8 b4 = b8.b(a10);
        if (r3.f31464s && r3.f31448c) {
            return a(e3Var, e3Var2, e3Var3, f10, a10);
        }
        int d10 = b4.d() - 7;
        int length = b4.c().length;
        int i11 = length * length;
        d[] dVarArr4 = new d[i11];
        d[] dVarArr5 = new d[i11];
        d[] dVarArr6 = new d[2];
        if (b4.c().length > 0) {
            dVarArr = dVarArr6;
            c4 = 2;
            dVarArr2 = dVarArr5;
            dVarArr3 = dVarArr4;
            i10 = a(e3Var, e3Var2, e3Var3, f10, a10, b4, dVarArr4, dVarArr5, length, d10, dVarArr);
        } else {
            dVarArr = dVarArr6;
            dVarArr2 = dVarArr5;
            dVarArr3 = dVarArr4;
            c4 = 2;
            i10 = 0;
        }
        d dVar = dVarArr[0];
        d6 a11 = a(e3Var, e3Var2, e3Var3, dVar, dVarArr[1], a10);
        if (r3.f31461p && r3.f31458m) {
            d6Var = a11;
            a(a11, length, a10, e3Var, e3Var2, e3Var3, dVarArr3, i10, dVarArr2);
        } else {
            d6Var = a11;
        }
        s a12 = a(this.f31024a, d6Var, a10);
        if (dVar == null) {
            u6VarArr = new u6[3];
            u6VarArr[0] = e3Var3;
            u6VarArr[1] = e3Var;
            u6VarArr[c4] = e3Var2;
        } else {
            u6VarArr = new u6[4];
            u6VarArr[0] = e3Var3;
            u6VarArr[1] = e3Var;
            u6VarArr[c4] = e3Var2;
            u6VarArr[3] = dVar;
        }
        float[] fArr = new float[8];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f11 = a10;
        fArr[c4] = f11;
        fArr[3] = 0.0f;
        fArr[4] = f11;
        fArr[5] = f11;
        fArr[6] = 0.0f;
        fArr[7] = f11;
        d6Var.a(fArr);
        u6 u6Var = new u6(fArr[0], fArr[1], e3Var.d());
        u6 u6Var2 = new u6(fArr[c4], fArr[3], e3Var2.d());
        u6 u6Var3 = new u6(fArr[4], fArr[5], e3Var3.d());
        u6[] u6VarArr2 = new u6[4];
        u6VarArr2[0] = a(new u6(fArr[6], fArr[7]));
        u6VarArr2[1] = a(u6Var);
        u6VarArr2[c4] = a(u6Var2);
        u6VarArr2[3] = a(u6Var3);
        return new j2(a12, u6VarArr, u6VarArr2, f10);
    }

    private int a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f10, int i10, b8 b8Var, d[] dVarArr, d[] dVarArr2, int i11, int i12, d[] dVarArr3) {
        int i13;
        int i14;
        float b4 = (e3Var2.b() - e3Var.b()) + e3Var3.b();
        float c4 = (e3Var2.c() - e3Var.c()) + e3Var3.c();
        float f11 = i12;
        float f12 = 3.0f / f11;
        float f13 = 1.0f - f12;
        int b10 = (int) (e3Var.b() + ((b4 - e3Var.b()) * f13));
        int c10 = (int) (e3Var.c() + (f13 * (c4 - e3Var.c())));
        if (r3.f31467v[0] && i12 == 22) {
            i13 = 2;
            i14 = 8;
        } else {
            i13 = 4;
            i14 = 16;
        }
        for (int i15 = i13; i15 <= i14; i15 <<= 1) {
            try {
                dVarArr3[0] = a(f10, b10, c10, i15);
                break;
            } catch (a unused) {
            }
        }
        float f14 = i10 - 6.5f;
        dVarArr3[1] = new d(f14, f14, e3Var3.e());
        if (dVarArr3[0] != null && s4.a(b10, c10, dVarArr3[0].b(), dVarArr3[0].c()) > f10 * 4.0f) {
            dVarArr3[0] = null;
        }
        if (dVarArr3[0] == null && i11 > 2) {
            int i16 = i11 - 2;
            dVarArr3[1] = new d(b8Var.c()[i16] + 0.5f, f14, e3Var3.e());
            int c11 = (int) (e3Var3.c() - (f12 * (e3Var3.c() - e3Var.c())));
            int b11 = (int) ((((b8Var.c()[i16] - 3.0f) / f11) * (e3Var2.b() - e3Var.b())) + e3Var3.b());
            while (i13 <= i14) {
                try {
                    dVarArr3[0] = a(f10, b11, c11, i13);
                    break;
                } catch (a unused2) {
                    i13 <<= 1;
                }
            }
            if (dVarArr3[0] != null && s4.a(b11, c11, dVarArr3[0].b(), dVarArr3[0].c()) > f10 * 4.0f) {
                dVarArr3[0] = null;
            }
        }
        if (r3.f31461p && r3.f31458m) {
            return a(b8Var, i12, e3Var2, e3Var, e3Var3, f10, i11, 0, dVarArr, dVarArr2);
        }
        return 0;
    }

    private int a(b8 b8Var, int i10, e3 e3Var, e3 e3Var2, e3 e3Var3, float f10, int i11, int i12, d[] dVarArr, d[] dVarArr2) {
        int i13;
        int i14;
        int i15;
        float f11;
        int i16 = i11;
        int i17 = i12;
        int i18 = 0;
        while (i18 < i16) {
            if (i18 == 0) {
                i13 = i16 - 1;
                i14 = 1;
            } else {
                i13 = i16;
                i14 = 0;
            }
            int i19 = i18 != i16 + (-1) ? i14 : 1;
            float f12 = 3.0f;
            float f13 = i10;
            float b4 = (((b8Var.c()[i18] - 3.0f) * (e3Var.b() - e3Var2.b())) / f13) + e3Var2.b();
            float c4 = (((b8Var.c()[i18] - 3.0f) * (e3Var.c() - e3Var2.c())) / f13) + e3Var2.c();
            while (i19 < i13) {
                int c10 = (int) (c4 - (((b8Var.c()[i19] - f12) * (e3Var2.c() - e3Var3.c())) / f13));
                int b10 = (int) (b4 - (((b8Var.c()[i19] - f12) * (e3Var2.b() - e3Var3.b())) / f13));
                int i20 = 4;
                int i21 = 4;
                while (true) {
                    if (i21 > i20) {
                        i15 = i13;
                        f11 = b4;
                        break;
                    }
                    int i22 = (i18 * i16) + i19;
                    try {
                        dVarArr[i22] = a(f10, b10, c10, i21);
                        i15 = i13;
                    } catch (a unused) {
                        i15 = i13;
                    }
                    try {
                        f11 = b4;
                        try {
                            dVarArr2[i22] = new d(b8Var.c()[i18] + 0.5f, b8Var.c()[i19] + 0.5f, e3Var3.e());
                            i17++;
                            break;
                        } catch (a unused2) {
                            continue;
                        }
                    } catch (a unused3) {
                        f11 = b4;
                        i21 <<= 1;
                        i16 = i11;
                        b4 = f11;
                        i13 = i15;
                        i20 = 4;
                    }
                    i21 <<= 1;
                    i16 = i11;
                    b4 = f11;
                    i13 = i15;
                    i20 = 4;
                }
                i19++;
                i16 = i11;
                b4 = f11;
                i13 = i15;
                f12 = 3.0f;
            }
            i18++;
            i16 = i11;
        }
        return i17;
    }

    private void a(d6 d6Var, int i10, int i11, e3 e3Var, e3 e3Var2, e3 e3Var3, d[] dVarArr, int i12, d[] dVarArr2) {
        int i13 = i12 + 3;
        int i14 = i13 * 2;
        float[] fArr = new float[i14];
        float[] fArr2 = new float[i14];
        fArr[0] = e3Var.b();
        fArr[1] = e3Var.c();
        fArr[2] = e3Var2.b();
        fArr[3] = e3Var2.c();
        fArr[4] = e3Var3.b();
        fArr[5] = e3Var3.c();
        fArr2[0] = 3.5f;
        fArr2[1] = 3.5f;
        float f10 = i11 - 3.5f;
        fArr2[2] = f10;
        fArr2[3] = 3.5f;
        fArr2[4] = 3.5f;
        fArr2[5] = f10;
        int i15 = 6;
        int i16 = 6;
        for (int i17 = 0; i17 < i10 * i10; i17++) {
            if (dVarArr[i17] != null) {
                int i18 = i16 + 1;
                fArr[i16] = dVarArr[i17].b();
                i16 = i18 + 1;
                fArr[i18] = dVarArr[i17].c();
                int i19 = i15 + 1;
                fArr2[i15] = dVarArr2[i17].b();
                i15 = i19 + 1;
                fArr2[i19] = dVarArr2[i17].c();
            }
        }
        float[] QuadFitting = LoadOpencvJNIUtil.QuadFitting(fArr2, i13, fArr);
        if (QuadFitting.length != 0) {
            d6Var.a(QuadFitting[0], QuadFitting[1], QuadFitting[2], QuadFitting[3], QuadFitting[4], QuadFitting[5], QuadFitting[6], QuadFitting[7], QuadFitting[8], QuadFitting[9], QuadFitting[10], QuadFitting[11], QuadFitting[12], QuadFitting[13]);
        }
    }

    private j2 a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f10, int i10) {
        s sVar = new s(i10, i10);
        float f11 = i10;
        float c4 = this.f31024a.c() / f11;
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                double d10 = c4 * 0.5d;
                int i13 = (int) ((i12 * c4) + d10);
                int i14 = (int) ((i11 * c4) + d10);
                if (i13 >= -1 && i13 <= this.f31024a.e() && i14 >= -1 && i14 <= this.f31024a.c()) {
                    if (this.f31024a.b(i13, i14)) {
                        sVar.c(i12, i11);
                    }
                } else {
                    sVar.c(i12, i11);
                }
            }
        }
        u6[] u6VarArr = {e3Var3, e3Var, e3Var2};
        float[] fArr = {0.0f, 0.0f, f11, 0.0f, f11, f11, 0.0f, f11};
        a(e3Var, e3Var2, e3Var3, null, null, i10).a(fArr);
        return new j2(sVar, u6VarArr, new u6[]{a(new u6(fArr[6], fArr[7])), a(new u6(fArr[0], fArr[1])), a(new u6(fArr[2], fArr[3])), a(new u6(fArr[4], fArr[5]))}, f10);
    }

    public final float a(u6 u6Var, u6 u6Var2, u6 u6Var3) {
        return (a(u6Var, u6Var2) + a(u6Var, u6Var3)) / 2.0f;
    }

    private float a(u6 u6Var, u6 u6Var2) {
        float b4 = b((int) u6Var.b(), (int) u6Var.c(), (int) u6Var2.b(), (int) u6Var2.c());
        float b10 = b((int) u6Var2.b(), (int) u6Var2.c(), (int) u6Var.b(), (int) u6Var.c());
        return Float.isNaN(b4) ? b10 / 7.0f : Float.isNaN(b10) ? b4 / 7.0f : (b4 + b10) / 14.0f;
    }

    private float a(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        g2 g2Var;
        boolean z10;
        boolean z11;
        int i19 = 1;
        boolean z12 = Math.abs(i13 - i11) > Math.abs(i12 - i10);
        if (z12) {
            i15 = i10;
            i14 = i11;
            i17 = i12;
            i16 = i13;
        } else {
            i14 = i10;
            i15 = i11;
            i16 = i12;
            i17 = i13;
        }
        int abs = Math.abs(i16 - i14);
        int abs2 = Math.abs(i17 - i15);
        int i20 = (-abs) / 2;
        int i21 = i14 < i16 ? 1 : -1;
        int i22 = i15 < i17 ? 1 : -1;
        int i23 = i16 + i21;
        int i24 = i14;
        int i25 = i15;
        int i26 = 0;
        while (true) {
            if (i24 == i23) {
                i18 = i23;
                break;
            }
            int i27 = z12 ? i25 : i24;
            int i28 = z12 ? i24 : i25;
            if (i26 == i19) {
                g2Var = this;
                z10 = z12;
                i18 = i23;
                z11 = true;
            } else {
                g2Var = this;
                z10 = z12;
                i18 = i23;
                z11 = false;
            }
            if (z11 == g2Var.f31024a.b(i27, i28)) {
                if (i26 == 2) {
                    return s4.a(i24, i25, i14, i15);
                }
                i26++;
            }
            i20 += abs2;
            if (i20 > 0) {
                if (i25 == i17) {
                    break;
                }
                i25 += i22;
                i20 -= abs;
            }
            i24 += i21;
            i23 = i18;
            z12 = z10;
            i19 = 1;
        }
        if (i26 == 2) {
            return s4.a(i18, i17, i14, i15);
        }
        return Float.NaN;
    }

    public final d a(float f10, int i10, int i11, float f11) throws a {
        int i12 = (int) (f11 * f10);
        int max = Math.max(0, i10 - i12);
        int min = Math.min(this.f31024a.e() - 1, i10 + i12) - max;
        float f12 = 3.0f * f10;
        if (min >= f12) {
            int max2 = Math.max(0, i11 - i12);
            int min2 = Math.min(this.f31024a.c() - 1, i11 + i12) - max2;
            if (min2 >= f12) {
                return new e(this.f31024a, max, max2, min, min2, f10, this.f31025b).a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private u6 a(u6 u6Var) {
        float b4 = u6Var.b();
        float c4 = u6Var.c();
        int e2 = this.f31024a.e() - 1;
        int c10 = this.f31024a.c() - 1;
        if (b4 < 0.0f) {
            b4 = 0.0f;
        }
        float f10 = e2;
        if (b4 > f10) {
            b4 = f10;
        }
        if (c4 < 0.0f) {
            c4 = 0.0f;
        }
        float f11 = c10;
        if (c4 > f11) {
            c4 = f11;
        }
        return new u6(b4, c4, u6Var.d());
    }
}
