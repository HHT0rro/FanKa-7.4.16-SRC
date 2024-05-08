package com.tencent.cloud.huiyansdkface.a.f;

import com.tencent.cloud.huiyansdkface.a.a.a.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {
    public static final d a(d dVar, d dVar2) {
        int i10 = dVar2.f40295a;
        int i11 = (int) (dVar.f40296b / (dVar.f40295a / i10));
        int i12 = dVar2.f40296b;
        if (i11 <= i12) {
            return new d(i10, i11);
        }
        return new d((int) (i10 / (i11 / i12)), i12);
    }

    public static final d b(d dVar, d dVar2) {
        int i10 = dVar2.f40295a;
        int i11 = (int) (dVar.f40296b / (dVar.f40295a / i10));
        int i12 = dVar2.f40296b;
        if (i11 >= i12) {
            return new d(i10, i11);
        }
        return new d((int) (i10 / (i11 / i12)), i12);
    }
}
