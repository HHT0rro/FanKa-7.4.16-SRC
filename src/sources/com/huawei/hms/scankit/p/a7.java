package com.huawei.hms.scankit.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SimpleToken.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a7 extends i7 {

    /* renamed from: c, reason: collision with root package name */
    private final short f30708c;

    /* renamed from: d, reason: collision with root package name */
    private final short f30709d;

    public a7(i7 i7Var, int i10, int i11) {
        super(i7Var);
        this.f30708c = (short) i10;
        this.f30709d = (short) i11;
    }

    @Override // com.huawei.hms.scankit.p.i7
    public void a(r rVar, byte[] bArr) {
        rVar.a(this.f30708c, this.f30709d);
    }

    public String toString() {
        short s2 = this.f30708c;
        int i10 = 1 << this.f30709d;
        return '<' + Integer.toBinaryString((s2 & (i10 - 1)) | i10 | (1 << this.f30709d)).substring(1) + '>';
    }
}
