package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class r5 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private static final s6[] f31472a = new s6[0];

    private static int b(u6 u6Var, u6 u6Var2) {
        if (u6Var == null || u6Var2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(u6Var.b() - u6Var2.b());
    }

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        s6[] a10 = a(pVar, map, false);
        if (a10.length != 0 && a10[0] != null) {
            return a10[0];
        }
        throw a.a();
    }

    private static int b(u6[] u6VarArr) {
        return Math.min(Math.min(b(u6VarArr[0], u6VarArr[4]), (b(u6VarArr[6], u6VarArr[2]) * 17) / 18), Math.min(b(u6VarArr[1], u6VarArr[5]), (b(u6VarArr[7], u6VarArr[3]) * 17) / 18));
    }

    private static s6[] a(p pVar, Map<l1, ?> map, boolean z10) throws a {
        ArrayList arrayList = new ArrayList();
        o5 a10 = f2.a(pVar, map, z10);
        for (u6[] u6VarArr : a10.b()) {
            w1 a11 = t5.a(a10.a(), u6VarArr[4], u6VarArr[5], u6VarArr[6], u6VarArr[7], b(u6VarArr), a(u6VarArr), map);
            if (f2.a()) {
                for (int i10 = 0; i10 < u6VarArr.length; i10++) {
                    if (u6VarArr[i10] != null) {
                        u6VarArr[i10] = new u6((pVar.e() - 1) - u6VarArr[i10].b(), (pVar.c() - 1) - u6VarArr[i10].c());
                    }
                }
            }
            if (u6VarArr.length == 8) {
                if (u6VarArr[0] == null && u6VarArr[1] == null && u6VarArr[4] == null && u6VarArr[5] == null) {
                    u6VarArr[0] = u6VarArr[6];
                    u6VarArr[1] = u6VarArr[7];
                    u6VarArr[4] = u6VarArr[2];
                    u6VarArr[5] = u6VarArr[3];
                } else if (u6VarArr[2] == null && u6VarArr[3] == null && u6VarArr[6] == null && u6VarArr[7] == null) {
                    u6VarArr[2] = u6VarArr[4];
                    u6VarArr[3] = u6VarArr[5];
                    u6VarArr[6] = u6VarArr[0];
                    u6VarArr[7] = u6VarArr[1];
                }
                arrayList.add(new s6(a11.d(), a11.c(), u6VarArr, BarcodeFormat.PDF_417));
            } else {
                throw a.a("pdf417 points size incorrect!");
            }
        }
        return (s6[]) arrayList.toArray(f31472a);
    }

    private static int a(u6 u6Var, u6 u6Var2) {
        if (u6Var == null || u6Var2 == null) {
            return 0;
        }
        return (int) Math.abs(u6Var.b() - u6Var2.b());
    }

    private static int a(u6[] u6VarArr) {
        return Math.max(Math.max(a(u6VarArr[0], u6VarArr[4]), (a(u6VarArr[6], u6VarArr[2]) * 17) / 18), Math.max(a(u6VarArr[1], u6VarArr[5]), (a(u6VarArr[7], u6VarArr[3]) * 17) / 18));
    }
}
