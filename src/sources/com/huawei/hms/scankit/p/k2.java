package com.huawei.hms.scankit.p;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.List;

/* compiled from: DetectorRotate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k2 {

    /* renamed from: a, reason: collision with root package name */
    private static d5 f31206a;

    /* renamed from: b, reason: collision with root package name */
    private static p f31207b;

    public static List<i2> a(boolean z10, p pVar, int i10, boolean z11) {
        int e2 = pVar.e();
        int c4 = pVar.c();
        byte[] b4 = pVar.a().c().b();
        d5 d5Var = new d5();
        f31206a = d5Var;
        d5Var.a(z10, b4, c4, e2, i10, z11);
        return f31206a.f30840a;
    }

    public static boolean a(boolean z10, p pVar, i2 i2Var) throws a {
        float i10;
        int e2 = pVar.e();
        int c4 = pVar.c();
        float[] fArr = {i2Var.j(), i2Var.k(), i2Var.f(), i2Var.c()};
        if (z10) {
            i2Var.f31103n = Math.max(i2Var.m(), i2Var.l());
            i2Var.f31104o = Math.min(i2Var.m(), i2Var.l());
            i10 = i2Var.i();
            if (i2Var.g() == 11.0f || i2Var.g() == 0.0f) {
                i10 = 0.0f;
            }
            i2Var.f31111v = Math.max(fArr[2], fArr[3]);
            i2Var.f31107r = (int) Math.max(fArr[0] - (fArr[2] * 0.5d), ShadowDrawableWrapper.COS_45);
            i2Var.f31108s = (int) Math.max(fArr[1] - (fArr[3] * 0.5d), ShadowDrawableWrapper.COS_45);
        } else {
            i10 = i2Var.i();
            i2Var.f31111v = Math.max(fArr[2], fArr[3]);
            i2Var.f31107r = (int) i2Var.d();
            i2Var.f31108s = (int) i2Var.e();
        }
        i2Var.f31105p = Math.min(e2 - i2Var.f31107r, (int) fArr[2]);
        int min = Math.min(c4 - i2Var.f31108s, (int) fArr[3]);
        i2Var.f31106q = min;
        int i11 = i2Var.f31105p;
        if (i11 > 0 && min > 0) {
            p a10 = pVar.a(i2Var.f31107r, i2Var.f31108s, i11, min);
            f31207b = a10;
            a(a10, i10, i2Var, fArr);
            return true;
        }
        throw a.a("crop_w <= 0 || crop_h <= 0");
    }

    private static void a(p pVar, float f10, i2 i2Var, float[] fArr) {
        byte[] b4;
        float min;
        float max;
        float radians = (float) Math.toRadians(f10);
        double d10 = radians;
        int abs = (int) ((i2Var.f31105p * Math.abs(Math.sin(d10))) + (i2Var.f31106q * Math.abs(Math.cos(d10))));
        int abs2 = (int) ((i2Var.f31106q * Math.abs(Math.sin(d10))) + (i2Var.f31105p * Math.abs(Math.cos(d10))));
        float[] fArr2 = i2Var.f31102m;
        fArr2[0] = abs2 * 0.5f;
        fArr2[1] = abs * 0.5f;
        fArr2[2] = (abs2 - i2Var.f31105p) * 0.5f;
        fArr2[3] = (abs - i2Var.f31106q) * 0.5f;
        fArr2[4] = radians;
        if (!r3.f31447b) {
            b4 = LoadOpencvJNIUtil.removeMoirePattern(pVar.a().c().b(), i2Var.f31106q, i2Var.f31105p);
        } else {
            b4 = pVar.a().c().b();
        }
        byte[] bArr = b4;
        if (f10 == 0.0f) {
            i2Var.f31109t = 0;
            i2Var.f31110u = 0;
            int i10 = i2Var.f31105p;
            int i11 = i2Var.f31106q;
            i2Var.f31101l = new p(new q3(new e6(bArr, i10, i11, 0, 0, i10, i11, false)));
            return;
        }
        p pVar2 = new p(new q3(new e6(LoadOpencvJNIUtil.imageRotate(bArr, i2Var.f31106q, i2Var.f31105p, abs, abs2, f10, 1.0d), abs2, abs, 0, 0, abs2, abs, false)));
        if ((i2Var.g() == 3.0f || i2Var.g() == 4.0f) && pVar2.c() > pVar2.e()) {
            min = Math.min(fArr[2], fArr[3]);
            max = Math.max(fArr[2], fArr[3]);
        } else {
            min = Math.max(fArr[2], fArr[3]);
            max = Math.min(fArr[2], fArr[3]);
        }
        i2Var.f31109t = (int) Math.max((abs2 * 0.5d) - (min * 0.5d), ShadowDrawableWrapper.COS_45);
        i2Var.f31110u = (int) Math.max((abs * 0.5d) - (max * 0.5d), ShadowDrawableWrapper.COS_45);
        i2Var.f31101l = pVar2.a(i2Var.f31109t, i2Var.f31110u, Math.min(abs2 - i2Var.f31109t, (int) min), Math.min(abs - i2Var.f31110u, (int) max));
    }

    public static void a(s sVar, s6 s6Var, float f10, i2 i2Var) {
        int c4;
        int c10;
        u6[] j10 = s6Var.j();
        float min = Math.min(j10[0].b(), j10[1].b());
        float max = Math.max(j10[0].b(), j10[1].b());
        float c11 = j10[0].c();
        if (max > sVar.e() - 1) {
            max = sVar.e() - 1;
        }
        float f11 = max;
        float c12 = c11 > ((float) (sVar.c() - 1)) ? sVar.c() - 1 : c11;
        int c13 = sVar.c();
        try {
            int[] a10 = a(sVar, j10, min, f11, c12, c13, new int[c13]);
            c4 = a10[0];
            c10 = a10[1];
        } catch (IndexOutOfBoundsException unused) {
            c4 = (int) j10[0].c();
            c10 = (int) j10[0].c();
        }
        float f12 = c4;
        float f13 = c10;
        u6[] u6VarArr = {new u6(min, f12), new u6(f11, f12), new u6(f11, f13), new u6(min, f13)};
        if (i2Var != null) {
            a(u6VarArr, f10, i2Var);
        }
        s6Var.a();
        s6Var.a(u6VarArr);
    }

    private static int[] a(s sVar, u6[] u6VarArr, float f10, float f11, float f12, int i10, int[] iArr) {
        int i11;
        int i12;
        int i13;
        int i14 = (int) f10;
        int i15 = i14;
        int i16 = 0;
        while (true) {
            i11 = ((int) f11) - 1;
            if (i15 >= i11) {
                break;
            }
            int i17 = (int) f12;
            boolean b4 = sVar.b(i15, i17);
            i15++;
            if (sVar.b(i15, i17) ^ b4) {
                i16++;
            }
        }
        int i18 = 0;
        for (int i19 = 0; i19 < i10; i19++) {
            int i20 = i14;
            int i21 = 0;
            while (i20 < i11) {
                boolean b10 = sVar.b(i20, i19);
                i20++;
                if (b10 ^ sVar.b(i20, i19)) {
                    i21++;
                }
            }
            float f13 = i16;
            if (i21 > 1.5f * f13) {
                i21 = 0;
            }
            if (i21 < f13 * 0.5f) {
                i21 = 0;
            }
            iArr[i19] = i21;
            if (iArr[i19] > i18) {
                i18 = iArr[i19];
            }
        }
        if (i18 > 0) {
            float[] fArr = new float[i10];
            for (int i22 = 0; i22 < i10; i22++) {
                fArr[i22] = iArr[i22] / i18;
            }
            float f14 = 0.0f;
            for (int i23 = 0; i23 < i10; i23++) {
                f14 += fArr[i23];
            }
            float f15 = f14 / i10;
            if (f15 > 1.0d) {
                f15 = 0.99f;
            }
            i12 = (int) f12;
            i13 = i12;
            while (true) {
                if (i13 < 0) {
                    i13 = 0;
                    break;
                }
                if (fArr[i13] < f15) {
                    break;
                }
                i13--;
            }
            while (true) {
                if (i12 >= i10) {
                    i12 = 0;
                    break;
                }
                if (fArr[i12] < f15) {
                    break;
                }
                i12++;
            }
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (i13 == 0 && i12 == 0) {
            i13 = ((int) u6VarArr[0].c()) + (-10) < 0 ? 0 : ((int) u6VarArr[0].c()) - 10;
            i12 = i10 - 1;
            if (((int) u6VarArr[0].c()) + 10 <= i12) {
                i12 = ((int) u6VarArr[0].c()) + 10;
            }
        }
        return new int[]{i13, i12};
    }

    private static u6 a(float f10, float f11, i2 i2Var) {
        float[] fArr = i2Var.f31102m;
        if (fArr != null && fArr.length == 5) {
            float f12 = -fArr[4];
            double d10 = f10 - fArr[0];
            double d11 = f12;
            double cos = (d10 * Math.cos(d11)) + ((f11 - i2Var.f31102m[1]) * Math.sin(d11));
            float[] fArr2 = i2Var.f31102m;
            int i10 = (int) (cos + fArr2[0]);
            int sin = (int) (((-(f10 - fArr2[0])) * Math.sin(d11)) + ((f11 - i2Var.f31102m[1]) * Math.cos(d11)) + i2Var.f31102m[1]);
            float[] fArr3 = i2Var.f31102m;
            return new u6((i10 - fArr3[2]) + i2Var.f31107r, (sin - fArr3[3]) + i2Var.f31108s);
        }
        return new u6(f10, f11);
    }

    public static void a(u6[] u6VarArr, float f10, i2 i2Var) {
        if (i2Var == null || u6VarArr == null) {
            return;
        }
        for (int i10 = 0; i10 < u6VarArr.length; i10++) {
            u6VarArr[i10] = a((u6VarArr[i10].b() * f10) + i2Var.f31109t, (u6VarArr[i10].c() * f10) + i2Var.f31110u, i2Var);
        }
    }
}
