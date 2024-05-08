package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: HarmonyCodeDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class z3 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private Map<l1, Object> f31786a = new EnumMap(l1.class);

    /* renamed from: b, reason: collision with root package name */
    private final u1 f31787b = new u1();

    private s6 a(int i10, e2 e2Var, Map<l1, ?> map) throws a {
        int i11 = 1;
        int max = Math.max(1, i10 - 2);
        int min = Math.min(6, i10 + 2);
        int max2 = Math.max(Math.abs(i10 - max), Math.abs(i10 - min));
        int i12 = 0;
        j2 j2Var = null;
        while (i12 <= max2 * 2) {
            i10 += i12 * i11;
            if (i10 >= max && i10 <= min) {
                try {
                    j2Var = e2Var.a(i10);
                    w1 a10 = this.f31787b.a(j2Var.a(), map);
                    if (a10.d() != null) {
                        return new s6(a10.d(), a10.c(), j2Var.d(), BarcodeFormat.HARMONY_CODE);
                    }
                    continue;
                } catch (a unused) {
                    continue;
                }
            }
            i12++;
            i11 *= -1;
        }
        if (j2Var == null || j2Var.d().length <= 3) {
            return null;
        }
        return new s6(null, null, j2Var.d(), BarcodeFormat.HARMONY_CODE);
    }

    private s6 a(int i10, int i11, g3[] g3VarArr, e2 e2Var, Map<l1, ?> map) throws a {
        float b4;
        float c4;
        float max;
        float max2;
        s6 a10;
        char c10 = 0;
        int i12 = 0;
        while (i12 <= i10 - 2) {
            int i13 = i12 + 1;
            int i14 = i13;
            while (i14 <= i10 - 1) {
                int i15 = i14 + 1;
                int i16 = i15;
                while (i16 <= i10) {
                    int i17 = i10;
                    while (i17 < i11) {
                        g3[] g3VarArr2 = new g3[3];
                        g3VarArr2[c10] = g3VarArr[i12];
                        g3VarArr2[1] = g3VarArr[i14];
                        g3VarArr2[2] = g3VarArr[i16];
                        u6.a(g3VarArr2);
                        g3 g3Var = g3VarArr[i17];
                        try {
                            b4 = (g3VarArr2[2].b() - g3VarArr2[1].b()) + g3VarArr2[c10].b();
                            c4 = (g3VarArr2[2].c() - g3VarArr2[1].c()) + g3VarArr2[c10].c();
                            max = Math.max(Math.abs(g3VarArr2[1].b() - g3VarArr2[c10].b()), Math.abs(g3VarArr2[1].b() - g3VarArr2[2].b()));
                            try {
                                max2 = Math.max(Math.abs(g3VarArr2[1].c() - g3VarArr2[0].c()), Math.abs(g3VarArr2[1].c() - g3VarArr2[2].c()));
                            } catch (a unused) {
                            }
                        } catch (a unused2) {
                        }
                        if (Math.abs(b4 - g3Var.b()) < max / 2.0f && Math.abs(c4 - g3Var.c()) < max2 / 2.0f) {
                            try {
                                a10 = a(e2Var.a(g3VarArr2, g3Var), e2Var, map);
                            } catch (a unused3) {
                                continue;
                            }
                            if (a10 != null) {
                                return a10;
                            }
                            i17++;
                            c10 = 0;
                        }
                        i17++;
                        c10 = 0;
                    }
                    i16++;
                    c10 = 0;
                }
                i14 = i15;
            }
            i12 = i13;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        e2 e2Var = new e2(pVar.b());
        g3[] a10 = e2Var.a(map);
        int length = a10.length;
        if (length == 3) {
            u6.a(a10);
            s6 a11 = a(e2Var.a(a10, null), e2Var, map);
            if (a11 != null) {
                return a11;
            }
        } else {
            if (length == 4) {
                g3[] g3VarArr = new g3[3];
                for (int i10 = 0; i10 < 3; i10++) {
                    g3VarArr[i10] = a10[i10];
                }
                u6.a(g3VarArr);
                s6 a12 = a(e2Var.a(g3VarArr, a10[3]), e2Var, map);
                if (a12 != null) {
                    return a12;
                }
            } else {
                float e2 = ((a10[0].e() + a10[1].e()) + a10[2].e()) / 3.0f;
                float e10 = a10[length - 1].e();
                int i11 = length - 2;
                while (i11 > 2 && Math.abs(a10[i11].e() - e2) >= Math.abs(a10[i11].e() - e10)) {
                    e10 = (((r6 - 1) * e10) + a10[i11].e()) / (length - i11);
                    i11--;
                }
                return a(i11, length, a10, e2Var, map);
            }
        }
        throw a.a();
    }
}
