package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;

/* compiled from: ParserRegister.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class v5 {

    /* renamed from: a, reason: collision with root package name */
    private static final t6[] f31633a = {new t2(), new n4(), new f7(), new w6(), new k8(), new z(), new x7(), new y7(), new t3(), new u7(), new q4(), new x(), new c(), new i4(), new g6(), new n2()};

    public static HmsScan a(s6 s6Var) {
        if (s6Var == null) {
            return null;
        }
        for (t6 t6Var : f31633a) {
            HmsScan b4 = t6Var.b(s6Var);
            if (b4 != null) {
                return b4;
            }
        }
        return null;
    }
}
