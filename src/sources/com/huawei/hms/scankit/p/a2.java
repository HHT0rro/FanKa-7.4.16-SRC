package com.huawei.hms.scankit.p;

import java.util.Formatter;

/* compiled from: DetectionResultColumn.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class a2 {

    /* renamed from: a, reason: collision with root package name */
    private final a0 f30689a;

    /* renamed from: b, reason: collision with root package name */
    private final x0[] f30690b;

    public a2(a0 a0Var) {
        this.f30689a = new a0(a0Var);
        this.f30690b = new x0[(a0Var.d() - a0Var.f()) + 1];
    }

    public final void a(int i10, x0 x0Var) {
        this.f30690b[c(i10)] = x0Var;
    }

    public final x0 b(int i10) {
        x0 x0Var;
        x0 x0Var2;
        x0 a10 = a(i10);
        if (a10 != null) {
            return a10;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            int c4 = c(i10) - i11;
            if (c4 >= 0 && (x0Var2 = this.f30690b[c4]) != null) {
                return x0Var2;
            }
            int c10 = c(i10) + i11;
            x0[] x0VarArr = this.f30690b;
            if (c10 < x0VarArr.length && (x0Var = x0VarArr[c10]) != null) {
                return x0Var;
            }
        }
        return null;
    }

    public final int c(int i10) {
        return i10 - this.f30689a.f();
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i10 = 0;
            for (x0 x0Var : this.f30690b) {
                if (x0Var == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i10));
                    i10++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i10), Integer.valueOf(x0Var.c()), Integer.valueOf(x0Var.e()));
                    i10++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                formatter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final x0 a(int i10) {
        return this.f30690b[c(i10)];
    }

    public final a0 a() {
        return this.f30689a;
    }

    public final x0[] b() {
        return this.f30690b;
    }
}
