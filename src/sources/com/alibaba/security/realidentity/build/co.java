package com.alibaba.security.realidentity.build;

/* compiled from: OSSStsTokenCredentialProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class co implements cj {

    /* renamed from: a, reason: collision with root package name */
    private String f3351a;

    /* renamed from: b, reason: collision with root package name */
    private String f3352b;

    /* renamed from: c, reason: collision with root package name */
    private String f3353c;

    private co(String str, String str2, String str3) {
        this.f3351a = str.trim();
        this.f3352b = str2.trim();
        this.f3353c = str3.trim();
    }

    private void a(String str) {
        this.f3351a = str;
    }

    private String b() {
        return this.f3351a;
    }

    private String c() {
        return this.f3352b;
    }

    private String d() {
        return this.f3353c;
    }

    private void b(String str) {
        this.f3352b = str;
    }

    private void c(String str) {
        this.f3353c = str;
    }

    @Override // com.alibaba.security.realidentity.build.cj
    public final cm a() {
        return new cm(this.f3351a, this.f3352b, this.f3353c, Long.MAX_VALUE);
    }

    private co(cm cmVar) {
        this.f3351a = cmVar.f3345a.trim();
        this.f3352b = cmVar.f3346b.trim();
        this.f3353c = cmVar.f3347c.trim();
    }
}
