package com.huawei.hms.scankit.p;

/* compiled from: Token.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
abstract class i7 {

    /* renamed from: b, reason: collision with root package name */
    public static final i7 f31127b = new a7(null, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final i7 f31128a;

    public i7(i7 i7Var) {
        this.f31128a = i7Var;
    }

    public final i7 a() {
        return this.f31128a;
    }

    public abstract void a(r rVar, byte[] bArr);

    public final i7 b(int i10, int i11) {
        return new q(this, i10, i11);
    }

    public final i7 a(int i10, int i11) {
        return new a7(this, i10, i11);
    }
}
