package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.ClientException;

/* compiled from: OSSFederationCredentialProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class cl implements cj {

    /* renamed from: a, reason: collision with root package name */
    private volatile cm f3344a;

    private cm c() {
        return this.f3344a;
    }

    @Override // com.alibaba.security.realidentity.build.cj
    public abstract cm a() throws ClientException;

    public final synchronized cm b() throws ClientException {
        if (this.f3344a == null || cr.a() / 1000 > this.f3344a.f3348d - 300) {
            if (this.f3344a != null) {
                cd.b("token expired! current time: " + (cr.a() / 1000) + " token expired: " + this.f3344a.f3348d);
            }
            this.f3344a = a();
        }
        return this.f3344a;
    }
}
