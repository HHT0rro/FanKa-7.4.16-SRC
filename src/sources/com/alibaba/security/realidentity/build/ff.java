package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: InitiateMultipartUploadRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ff extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3598a;

    /* renamed from: b, reason: collision with root package name */
    public String f3599b;

    /* renamed from: c, reason: collision with root package name */
    public String f3600c;

    /* renamed from: d, reason: collision with root package name */
    public fu f3601d;

    private ff(String str, String str2) {
        this(str, str2, null);
    }

    private String a() {
        return this.f3599b;
    }

    private String b() {
        return this.f3600c;
    }

    private fu c() {
        return this.f3601d;
    }

    public ff(String str, String str2, fu fuVar) {
        this.f3599b = str;
        this.f3600c = str2;
        this.f3601d = fuVar;
    }

    private void a(String str) {
        this.f3599b = str;
    }

    private void b(String str) {
        this.f3600c = str;
    }

    private void a(fu fuVar) {
        this.f3601d = fuVar;
    }
}
