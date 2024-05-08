package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aj extends k implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static byte[] f40017d;

    /* renamed from: a, reason: collision with root package name */
    private byte f40018a;

    /* renamed from: b, reason: collision with root package name */
    private String f40019b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f40020c;

    public aj() {
        this.f40018a = (byte) 0;
        this.f40019b = "";
        this.f40020c = null;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40018a, 0);
        jVar.a(this.f40019b, 1);
        byte[] bArr = this.f40020c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
    }

    public aj(byte b4, String str, byte[] bArr) {
        this.f40018a = b4;
        this.f40019b = str;
        this.f40020c = bArr;
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40018a = iVar.a(this.f40018a, 0, true);
        this.f40019b = iVar.b(1, true);
        if (f40017d == null) {
            f40017d = r0;
            byte[] bArr = {0};
        }
        this.f40020c = iVar.c(2, false);
    }
}
