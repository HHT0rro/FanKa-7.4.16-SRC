package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y6 {

    /* renamed from: a, reason: collision with root package name */
    public static int f48524a = Integer.MAX_VALUE;

    public static void a(x6 x6Var, byte b4) {
        b(x6Var, b4, f48524a);
    }

    public static void b(x6 x6Var, byte b4, int i10) {
        if (i10 <= 0) {
            throw new jg("Maximum skip depth exceeded");
        }
        int i11 = 0;
        switch (b4) {
            case 2:
                x6Var.y();
                return;
            case 3:
                x6Var.a();
                return;
            case 4:
                x6Var.b();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                x6Var.l();
                return;
            case 8:
                x6Var.c();
                return;
            case 10:
                x6Var.d();
                return;
            case 11:
                x6Var.k();
                return;
            case 12:
                x6Var.i();
                while (true) {
                    byte b10 = x6Var.e().f48410b;
                    if (b10 == 0) {
                        x6Var.D();
                        return;
                    } else {
                        b(x6Var, b10, i10 - 1);
                        x6Var.E();
                    }
                }
            case 13:
                w6 g3 = x6Var.g();
                while (i11 < g3.f48461c) {
                    int i12 = i10 - 1;
                    b(x6Var, g3.f48459a, i12);
                    b(x6Var, g3.f48460b, i12);
                    i11++;
                }
                x6Var.F();
                return;
            case 14:
                z6 h10 = x6Var.h();
                while (i11 < h10.f48542b) {
                    b(x6Var, h10.f48541a, i10 - 1);
                    i11++;
                }
                x6Var.H();
                return;
            case 15:
                v6 f10 = x6Var.f();
                while (i11 < f10.f48448b) {
                    b(x6Var, f10.f48447a, i10 - 1);
                    i11++;
                }
                x6Var.G();
                return;
        }
    }
}
