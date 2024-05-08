package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: WxCodeDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m8 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private Map<l1, Object> f31293a = new EnumMap(l1.class);

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        f3[] a10 = new h2(pVar.b()).a(map);
        int length = a10.length;
        if (length > 10) {
            return null;
        }
        int i10 = 3;
        char c4 = 0;
        if (length != 3) {
            int i11 = 0;
            while (i11 <= length - 3) {
                int i12 = i11 + 1;
                int i13 = i12;
                while (i13 <= length - 2) {
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (i15 <= length - 1) {
                        f3[] f3VarArr = new f3[i10];
                        f3VarArr[c4] = a10[i11];
                        f3VarArr[1] = a10[i13];
                        f3VarArr[2] = a10[i15];
                        int[] iArr = new int[i10];
                        iArr[c4] = i11;
                        iArr[1] = i13;
                        iArr[2] = i15;
                        u6.a(f3VarArr);
                        if (h2.a(f3VarArr[c4], f3VarArr[1], f3VarArr[2]) && !h2.a(f3VarArr, a10, iArr)) {
                            return a(a10[i11], a10[i13], a10[i15]);
                        }
                        i15++;
                        i10 = 3;
                        c4 = 0;
                    }
                    i13 = i14;
                }
                i11 = i12;
            }
        } else if (h2.a(a10[0], a10[1], a10[2])) {
            return a(a10[0], a10[1], a10[2]);
        }
        return null;
    }

    private s6 a(f3 f3Var, f3 f3Var2, f3 f3Var3) {
        return new s6("WXCODE_TEXT", null, new u6[]{new u6(f3Var.b(), f3Var.c()), new u6(f3Var2.b(), f3Var2.c()), new u6(f3Var3.b(), f3Var3.c())}, BarcodeFormat.WXCODE);
    }
}
