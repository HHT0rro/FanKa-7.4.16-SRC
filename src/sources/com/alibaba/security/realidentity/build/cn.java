package com.alibaba.security.realidentity.build;

/* compiled from: OSSPlainTextAKSKCredentialProvider.java */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cn implements cj {

    /* renamed from: a, reason: collision with root package name */
    public String f3349a;

    /* renamed from: b, reason: collision with root package name */
    public String f3350b;

    private cn(String str, String str2) {
        this.f3349a = str.trim();
        this.f3350b = str2.trim();
    }

    private void a(String str) {
        this.f3349a = str;
    }

    private String b() {
        return this.f3349a;
    }

    private String c() {
        return this.f3350b;
    }

    @Override // com.alibaba.security.realidentity.build.cj
    public final cm a() {
        return null;
    }

    private void b(String str) {
        this.f3350b = str;
    }
}
