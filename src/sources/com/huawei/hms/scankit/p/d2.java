package com.huawei.hms.scankit.p;

/* compiled from: Detector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d2 {

    /* renamed from: a, reason: collision with root package name */
    private final s f30834a;

    /* renamed from: b, reason: collision with root package name */
    private final j8 f30835b;

    public d2(s sVar) throws a {
        this.f30834a = sVar;
        this.f30835b = new j8(sVar);
    }

    private u6[] b(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[3];
        u6 u6Var4 = u6VarArr[2];
        int a10 = a(u6Var, u6Var2);
        int a11 = a(u6Var2, u6Var3);
        int a12 = a(u6Var3, u6Var4);
        int a13 = a(u6Var4, u6Var);
        u6[] u6VarArr2 = {u6Var4, u6Var, u6Var2, u6Var3};
        if (a10 > a11) {
            u6VarArr2[0] = u6Var;
            u6VarArr2[1] = u6Var2;
            u6VarArr2[2] = u6Var3;
            u6VarArr2[3] = u6Var4;
            a10 = a11;
        }
        if (a10 > a12) {
            u6VarArr2[0] = u6Var2;
            u6VarArr2[1] = u6Var3;
            u6VarArr2[2] = u6Var4;
            u6VarArr2[3] = u6Var;
        } else {
            a12 = a10;
        }
        if (a12 > a13) {
            u6VarArr2[0] = u6Var3;
            u6VarArr2[1] = u6Var4;
            u6VarArr2[2] = u6Var;
            u6VarArr2[3] = u6Var2;
        }
        return u6VarArr2;
    }

    private u6[] c(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[2];
        u6 u6Var4 = u6VarArr[3];
        int a10 = (a(u6Var, u6Var4) + 1) * 4;
        if (a(a(u6Var2, u6Var3, a10), u6Var) < a(a(u6Var3, u6Var2, a10), u6Var4)) {
            u6VarArr[0] = u6Var;
            u6VarArr[1] = u6Var2;
            u6VarArr[2] = u6Var3;
            u6VarArr[3] = u6Var4;
        } else {
            u6VarArr[0] = u6Var2;
            u6VarArr[1] = u6Var3;
            u6VarArr[2] = u6Var4;
            u6VarArr[3] = u6Var;
        }
        return u6VarArr;
    }

    private u6[] d(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[2];
        u6 u6Var4 = u6VarArr[3];
        int a10 = a(u6Var, u6Var4) + 1;
        u6 a11 = a(u6Var, u6Var2, (a(u6Var3, u6Var4) + 1) * 4);
        u6 a12 = a(u6Var3, u6Var2, a10 * 4);
        int a13 = a(a11, u6Var4) + 1;
        int a14 = a(a12, u6Var4) + 1;
        if ((a13 & 1) == 1) {
            a13++;
        }
        if ((a14 & 1) == 1) {
            a14++;
        }
        float b4 = (((u6Var.b() + u6Var2.b()) + u6Var3.b()) + u6Var4.b()) / 4.0f;
        float c4 = (((u6Var.c() + u6Var2.c()) + u6Var3.c()) + u6Var4.c()) / 4.0f;
        u6 a15 = a(u6Var, b4, c4);
        u6 a16 = a(u6Var2, b4, c4);
        u6 a17 = a(u6Var3, b4, c4);
        u6 a18 = a(u6Var4, b4, c4);
        int i10 = a14 * 4;
        int i11 = a13 * 4;
        return new u6[]{a(a(a15, a16, i10), a18, i11), a(a(a16, a15, i10), a17, i11), a(a(a17, a18, i10), a16, i11), a(a(a18, a17, i10), a15, i11)};
    }

    public j2 a() throws a {
        int i10;
        int i11;
        u6[] c4 = c(b(this.f30835b.a()));
        c4[3] = a(c4);
        if (c4[3] != null) {
            u6[] d10 = d(c4);
            u6 u6Var = d10[0];
            u6 u6Var2 = d10[1];
            u6 u6Var3 = d10[2];
            u6 u6Var4 = d10[3];
            int a10 = a(u6Var, u6Var4) + 1;
            int a11 = a(u6Var3, u6Var4) + 1;
            if ((a10 & 1) == 1) {
                a10++;
            }
            if ((a11 & 1) == 1) {
                a11++;
            }
            if (a10 * 4 >= a11 * 7 || a11 * 4 >= a10 * 7) {
                i10 = a10;
                i11 = a11;
            } else {
                i10 = Math.max(a10, a11);
                i11 = i10;
            }
            return new j2(a(this.f30834a, u6Var, u6Var2, u6Var3, u6Var4, i10, i11), new u6[]{u6Var, u6Var2, u6Var3, u6Var4});
        }
        throw a.a();
    }

    private static u6 a(u6 u6Var, u6 u6Var2, int i10) {
        float f10 = i10 + 1;
        return new u6(u6Var.b() + ((u6Var2.b() - u6Var.b()) / f10), u6Var.c() + ((u6Var2.c() - u6Var.c()) / f10));
    }

    private static u6 a(u6 u6Var, float f10, float f11) {
        float b4 = u6Var.b();
        float c4 = u6Var.c();
        return new u6(b4 < f10 ? b4 - 1.0f : b4 + 1.0f, c4 < f11 ? c4 - 1.0f : c4 + 1.0f);
    }

    private u6 a(u6[] u6VarArr) {
        u6 u6Var = u6VarArr[0];
        u6 u6Var2 = u6VarArr[1];
        u6 u6Var3 = u6VarArr[2];
        u6 u6Var4 = u6VarArr[3];
        int a10 = a(u6Var, u6Var4);
        u6 a11 = a(u6Var, u6Var2, (a(u6Var2, u6Var4) + 1) * 4);
        u6 a12 = a(u6Var3, u6Var2, (a10 + 1) * 4);
        int a13 = a(a11, u6Var4);
        int a14 = a(a12, u6Var4);
        float f10 = a13 + 1;
        u6 u6Var5 = new u6(u6Var4.b() + ((u6Var3.b() - u6Var2.b()) / f10), u6Var4.c() + ((u6Var3.c() - u6Var2.c()) / f10));
        float f11 = a14 + 1;
        u6 u6Var6 = new u6(u6Var4.b() + ((u6Var.b() - u6Var2.b()) / f11), u6Var4.c() + ((u6Var.c() - u6Var2.c()) / f11));
        if (a(u6Var5)) {
            return (a(u6Var6) && a(a11, u6Var5) + a(a12, u6Var5) <= a(a11, u6Var6) + a(a12, u6Var6)) ? u6Var6 : u6Var5;
        }
        if (a(u6Var6)) {
            return u6Var6;
        }
        return null;
    }

    private boolean a(u6 u6Var) {
        return u6Var.b() >= 0.0f && u6Var.b() < ((float) this.f30834a.e()) && u6Var.c() > 0.0f && u6Var.c() < ((float) this.f30834a.c());
    }

    private static s a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, int i10, int i11) throws a {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return s3.a().a(sVar, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, u6Var.b(), u6Var.c(), u6Var4.b(), u6Var4.c(), u6Var3.b(), u6Var3.c(), u6Var2.b(), u6Var2.c());
    }

    private int a(u6 u6Var, u6 u6Var2) {
        int i10;
        boolean z10;
        d2 d2Var = this;
        int b4 = (int) u6Var.b();
        int c4 = (int) u6Var.c();
        int b10 = (int) u6Var2.b();
        int c10 = (int) u6Var2.c();
        boolean z11 = Math.abs(c10 - c4) > Math.abs(b10 - b4);
        if (!z11) {
            c4 = b4;
            b4 = c4;
            c10 = b10;
            b10 = c10;
        }
        int abs = Math.abs(c10 - c4);
        int abs2 = Math.abs(b10 - b4);
        int i11 = (-abs) / 2;
        int i12 = b4 < b10 ? 1 : -1;
        int i13 = c4 < c10 ? 1 : -1;
        boolean b11 = d2Var.f30834a.b(z11 ? b4 : c4, z11 ? c4 : b4);
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (c4 != c10) {
            boolean b12 = d2Var.f30834a.b(z11 ? b4 : c4, z11 ? c4 : b4);
            i14++;
            if (b12 != b11) {
                i10 = c10;
                z10 = z11;
                if (i14 > Math.ceil(i15 / 1.5d)) {
                    i16++;
                    i15 -= (i15 - i14) / i16;
                    b11 = b12;
                    i14 = 0;
                }
            } else {
                i10 = c10;
                z10 = z11;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (b4 == b10) {
                    break;
                }
                b4 += i12;
                i11 -= abs;
            }
            c4 += i13;
            d2Var = this;
            z11 = z10;
            c10 = i10;
        }
        return i16;
    }
}
