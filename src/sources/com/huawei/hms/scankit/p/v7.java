package com.huawei.hms.scankit.p;

import java.util.List;

/* compiled from: Util.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class v7 {
    public static List<s6> a(List<s6> list) {
        for (int i10 = 0; i10 < list.size() - 1; i10++) {
            for (int size = list.size() - 1; size > i10; size--) {
                if (list.get(i10).k().equals(list.get(size).k()) && a(r2.j(), r3.j()) > 0.5d) {
                    list.remove(size);
                }
            }
        }
        return list;
    }

    public static float a(u6[] u6VarArr, u6[] u6VarArr2) {
        float f10 = Float.MAX_VALUE;
        float f11 = Float.MIN_VALUE;
        float f12 = Float.MIN_VALUE;
        float f13 = Float.MAX_VALUE;
        float f14 = Float.MIN_VALUE;
        float f15 = Float.MAX_VALUE;
        for (u6 u6Var : u6VarArr) {
            if (u6Var.b() > f12) {
                f12 = u6Var.b();
            }
            if (u6Var.b() < f13) {
                f13 = u6Var.b();
            }
            if (u6Var.c() > f14) {
                f14 = u6Var.c();
            }
            if (u6Var.c() < f15) {
                f15 = u6Var.c();
            }
        }
        float f16 = Float.MAX_VALUE;
        float f17 = Float.MIN_VALUE;
        for (u6 u6Var2 : u6VarArr2) {
            if (u6Var2.b() > f11) {
                f11 = u6Var2.b();
            }
            if (u6Var2.b() < f10) {
                f10 = u6Var2.b();
            }
            if (u6Var2.c() > f17) {
                f17 = u6Var2.c();
            }
            if (u6Var2.c() < f16) {
                f16 = u6Var2.c();
            }
        }
        float f18 = (f11 < f12 ? f11 : f12) - (f10 > f13 ? f10 : f13);
        float f19 = (f17 < f14 ? f17 : f14) - (f16 > f15 ? f16 : f15);
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        if (f19 < 0.0f) {
            f19 = 0.0f;
        }
        float f20 = f18 * f19;
        return f20 / ((((f12 - f13) * (f14 - f15)) + ((f11 - f10) * (f17 - f16))) - f20);
    }
}
