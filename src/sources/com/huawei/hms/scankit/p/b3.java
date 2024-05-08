package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrectionLevel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum b3 {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: f, reason: collision with root package name */
    private static final b3[] f30734f;

    /* renamed from: a, reason: collision with root package name */
    private final int f30736a;

    static {
        b3 b3Var = L;
        b3 b3Var2 = M;
        b3 b3Var3 = Q;
        f30734f = new b3[]{b3Var2, b3Var, H, b3Var3};
    }

    b3(int i10) {
        this.f30736a = i10;
    }

    public int a() {
        return this.f30736a;
    }

    public static b3 a(int i10) {
        if (i10 >= 0) {
            b3[] b3VarArr = f30734f;
            if (i10 < b3VarArr.length) {
                return b3VarArr[i10];
            }
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e2) {
            throw e2;
        }
    }
}
