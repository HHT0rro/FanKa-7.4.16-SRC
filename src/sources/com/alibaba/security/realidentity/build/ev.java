package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: GetObjectACLRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ev extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3574a;

    /* renamed from: b, reason: collision with root package name */
    public String f3575b;

    private ev(String str, String str2) {
        this.f3574a = str;
        this.f3575b = str2;
    }

    private String a() {
        return this.f3574a;
    }

    private String b() {
        return this.f3575b;
    }

    private void a(String str) {
        this.f3574a = str;
    }

    private void b(String str) {
        this.f3575b = str;
    }
}
