package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: DeleteObjectRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ei extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3550a;

    /* renamed from: b, reason: collision with root package name */
    public String f3551b;

    private ei(String str, String str2) {
        this.f3550a = str;
        this.f3551b = str2;
    }

    private String a() {
        return this.f3550a;
    }

    private String b() {
        return this.f3551b;
    }

    private void a(String str) {
        this.f3550a = str;
    }

    private void b(String str) {
        this.f3551b = str;
    }
}
