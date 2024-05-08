package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h2 {

    /* renamed from: a, reason: collision with root package name */
    private final s f31049a;

    /* renamed from: b, reason: collision with root package name */
    private v6 f31050b;

    public h2(s sVar) {
        this.f31049a = sVar;
    }

    private static float b(float f10, float f11, float f12) {
        return Math.min(Math.min(f10, f11), f12);
    }

    public final f3[] a(Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.NEED_RESULT_POINT_CALLBACK);
        this.f31050b = v6Var;
        return new j3(this.f31049a, v6Var).a(map);
    }

    public static boolean a(f3 f3Var, f3 f3Var2, f3 f3Var3) {
        float[] fArr = new float[3];
        a(f3Var, f3Var2, f3Var3, fArr);
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float sqrt = (float) Math.sqrt(f11);
        float sqrt2 = (float) Math.sqrt(f12);
        float sqrt3 = (float) Math.sqrt(f10);
        if (sqrt / sqrt2 >= 1.8f || sqrt2 / sqrt >= 1.8f || b(sqrt, sqrt2, sqrt3) <= a(f3Var.e(), f3Var2.e(), f3Var3.e()) * 6.0f) {
            return false;
        }
        float f13 = ((f11 + f12) - f10) / ((sqrt * 2.0f) * sqrt2);
        float f14 = sqrt3 * 2.0f;
        float f15 = ((f10 + f11) - f12) / (sqrt * f14);
        float f16 = ((f10 + f12) - f11) / (f14 * sqrt2);
        return Math.abs(f13) <= 0.342f && f15 >= 0.5736f && f15 <= 0.8191f && f16 >= 0.5736f && f16 <= 0.8191f;
    }

    private static void a(f3 f3Var, f3 f3Var2, f3 f3Var3, float[] fArr) {
        float b4 = f3Var.b() - f3Var2.b();
        float c4 = f3Var.c() - f3Var2.c();
        float f10 = (b4 * b4) + (c4 * c4);
        float b10 = f3Var.b() - f3Var3.b();
        float c10 = f3Var.c() - f3Var3.c();
        float f11 = (b10 * b10) + (c10 * c10);
        float b11 = f3Var2.b() - f3Var3.b();
        float c11 = f3Var2.c() - f3Var3.c();
        float f12 = (b11 * b11) + (c11 * c11);
        if (f10 > f12 && f10 > f11) {
            fArr[0] = f10;
            fArr[1] = f11;
            fArr[2] = f12;
        } else if (f12 > f10 && f12 > f11) {
            fArr[0] = f12;
            fArr[1] = f10;
            fArr[2] = f11;
        } else {
            fArr[0] = f11;
            fArr[1] = f10;
            fArr[2] = f12;
        }
    }

    private static float a(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    public static boolean a(f3[] f3VarArr, f3[] f3VarArr2, int[] iArr) {
        f3 f3Var = f3VarArr[0];
        f3 f3Var2 = f3VarArr[1];
        f3 f3Var3 = f3VarArr[2];
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        float b4 = (f3Var3.b() - f3Var2.b()) + f3Var.b();
        float c4 = (f3Var3.c() - f3Var2.c()) + f3Var.c();
        float e2 = ((f3Var.e() + f3Var2.e()) + f3Var3.e()) / 3.0f;
        for (int i13 = 0; i13 < f3VarArr2.length; i13++) {
            if (i13 != i10 && i13 != i11 && i13 != i12) {
                f3 f3Var4 = f3VarArr2[i13];
                float b10 = b4 - f3Var4.b();
                float c10 = c4 - f3Var4.c();
                if (((float) Math.sqrt((b10 * b10) + (c10 * c10))) < 10.0f * e2) {
                    return true;
                }
            }
        }
        return false;
    }
}
