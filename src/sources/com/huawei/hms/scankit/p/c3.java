package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrectionLevel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum c3 {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: f, reason: collision with root package name */
    private static final c3[] f30795f;

    /* renamed from: a, reason: collision with root package name */
    private final int f30797a;

    static {
        c3 c3Var = L;
        c3 c3Var2 = M;
        c3 c3Var3 = Q;
        f30795f = new c3[]{c3Var2, c3Var, H, c3Var3};
    }

    c3(int i10) {
        this.f30797a = i10;
    }

    public static c3 a(int i10) {
        if (i10 >= 0) {
            c3[] c3VarArr = f30795f;
            if (i10 < c3VarArr.length) {
                return c3VarArr[i10];
            }
        }
        throw new IllegalArgumentException();
    }
}
