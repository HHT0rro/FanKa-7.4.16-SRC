package com.huawei.hms.scankit.p;

import com.android.internal.logging.nano.MetricsProto;
import java.util.Formatter;

/* compiled from: DetectionResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class z1 {

    /* renamed from: a, reason: collision with root package name */
    private final k f31778a;

    /* renamed from: b, reason: collision with root package name */
    private final a2[] f31779b;

    /* renamed from: c, reason: collision with root package name */
    private a0 f31780c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31781d;

    public z1(k kVar, a0 a0Var) {
        this.f31778a = kVar;
        int a10 = kVar.a();
        this.f31781d = a10;
        this.f31780c = a0Var;
        this.f31779b = new a2[a10 + 2];
    }

    private void a(a2 a2Var) throws a {
        if (a2Var != null) {
            try {
                ((b2) a2Var).a(this.f31778a);
            } catch (ClassCastException unused) {
                throw a.a();
            }
        }
    }

    private int b() {
        c();
        return d() + e();
    }

    private void c() {
        a2[] a2VarArr = this.f31779b;
        if (a2VarArr[0] == null || a2VarArr[this.f31781d + 1] == null) {
            return;
        }
        x0[] b4 = a2VarArr[0].b();
        x0[] b10 = this.f31779b[this.f31781d + 1].b();
        for (int i10 = 0; i10 < b4.length; i10++) {
            if (b4[i10] != null && b10[i10] != null && b4[i10].c() == b10[i10].c()) {
                for (int i11 = 1; i11 <= this.f31781d; i11++) {
                    x0 x0Var = this.f31779b[i11].b()[i10];
                    if (x0Var != null) {
                        x0Var.b(b4[i10].c());
                        if (!x0Var.g()) {
                            this.f31779b[i11].b()[i10] = null;
                        }
                    }
                }
            }
        }
    }

    private int d() {
        a2[] a2VarArr = this.f31779b;
        if (a2VarArr[0] == null) {
            return 0;
        }
        x0[] b4 = a2VarArr[0].b();
        int i10 = 0;
        for (int i11 = 0; i11 < b4.length; i11++) {
            if (b4[i11] != null) {
                int c4 = b4[i11].c();
                int i12 = 0;
                for (int i13 = 1; i13 < this.f31781d + 1 && i12 < 2; i13++) {
                    x0 x0Var = this.f31779b[i13].b()[i11];
                    if (x0Var != null) {
                        i12 = a(c4, i12, x0Var);
                        if (!x0Var.g()) {
                            i10++;
                        }
                    }
                }
            }
        }
        return i10;
    }

    private int e() {
        a2[] a2VarArr = this.f31779b;
        int i10 = this.f31781d + 1;
        if (a2VarArr[i10] == null) {
            return 0;
        }
        x0[] b4 = a2VarArr[i10].b();
        int i11 = 0;
        for (int i12 = 0; i12 < b4.length; i12++) {
            if (b4[i12] != null) {
                int c4 = b4[i12].c();
                int i13 = 0;
                for (int i14 = this.f31781d + 1; i14 > 0 && i13 < 2; i14--) {
                    x0 x0Var = this.f31779b[i14].b()[i12];
                    if (x0Var != null) {
                        i13 = a(c4, i13, x0Var);
                        if (!x0Var.g()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    public int f() {
        return this.f31781d;
    }

    public int g() {
        return this.f31778a.b();
    }

    public int h() {
        return this.f31778a.c();
    }

    public a0 i() {
        return this.f31780c;
    }

    public a2[] j() throws a {
        a(this.f31779b[0]);
        a(this.f31779b[this.f31781d + 1]);
        int i10 = MetricsProto.MetricsEvent.FIELD_QS_VALUE;
        while (true) {
            int a10 = a();
            if (a10 <= 0 || a10 >= i10) {
                break;
            }
            i10 = a10;
        }
        return this.f31779b;
    }

    public String toString() {
        a2[] a2VarArr = this.f31779b;
        a2 a2Var = a2VarArr[0];
        if (a2Var == null) {
            a2Var = a2VarArr[this.f31781d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < a2Var.b().length; i10++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i10));
                for (int i11 = 0; i11 < this.f31781d + 2; i11++) {
                    a2[] a2VarArr2 = this.f31779b;
                    if (a2VarArr2[i11] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        x0 x0Var = a2VarArr2[i11].b()[i10];
                        if (x0Var == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(x0Var.c()), Integer.valueOf(x0Var.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    formatter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private int a() {
        int b4 = b();
        if (b4 == 0) {
            return 0;
        }
        for (int i10 = 1; i10 < this.f31781d + 1; i10++) {
            x0[] b10 = this.f31779b[i10].b();
            for (int i11 = 0; i11 < b10.length; i11++) {
                if (b10[i11] != null && !b10[i11].g()) {
                    a(i10, i11, b10);
                }
            }
        }
        return b4;
    }

    private static int a(int i10, int i11, x0 x0Var) {
        if (x0Var == null || x0Var.g()) {
            return i11;
        }
        if (!x0Var.a(i10)) {
            return i11 + 1;
        }
        x0Var.b(i10);
        return 0;
    }

    private void a(int i10, int i11, x0[] x0VarArr) {
        x0 x0Var = x0VarArr[i11];
        x0[] b4 = this.f31779b[i10 - 1].b();
        a2[] a2VarArr = this.f31779b;
        int i12 = i10 + 1;
        x0[] b10 = a2VarArr[i12] != null ? a2VarArr[i12].b() : b4;
        x0[] x0VarArr2 = new x0[14];
        x0VarArr2[2] = b4[i11];
        x0VarArr2[3] = b10[i11];
        if (i11 > 0) {
            int i13 = i11 - 1;
            x0VarArr2[0] = x0VarArr[i13];
            x0VarArr2[4] = b4[i13];
            x0VarArr2[5] = b10[i13];
        }
        if (i11 > 1) {
            int i14 = i11 - 2;
            x0VarArr2[8] = x0VarArr[i14];
            x0VarArr2[10] = b4[i14];
            x0VarArr2[11] = b10[i14];
        }
        if (i11 < x0VarArr.length - 1) {
            int i15 = i11 + 1;
            x0VarArr2[1] = x0VarArr[i15];
            x0VarArr2[6] = b4[i15];
            x0VarArr2[7] = b10[i15];
        }
        if (i11 < x0VarArr.length - 2) {
            int i16 = i11 + 2;
            x0VarArr2[9] = x0VarArr[i16];
            x0VarArr2[12] = b4[i16];
            x0VarArr2[13] = b10[i16];
        }
        for (int i17 = 0; i17 < 14 && !a(x0Var, x0VarArr2[i17]); i17++) {
        }
    }

    private static boolean a(x0 x0Var, x0 x0Var2) {
        if (x0Var2 == null || !x0Var2.g() || x0Var2.a() != x0Var.a()) {
            return false;
        }
        x0Var.b(x0Var2.c());
        return true;
    }

    public void a(a0 a0Var) {
        this.f31780c = a0Var;
    }

    public void a(int i10, a2 a2Var) {
        this.f31779b[i10] = a2Var;
    }

    public a2 a(int i10) {
        return this.f31779b[i10];
    }
}
