package com.alibaba.security.realidentity.build;

import java.io.InputStream;

/* compiled from: GetObjectResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ey extends ft {

    /* renamed from: a, reason: collision with root package name */
    public fu f3584a = new fu();

    /* renamed from: b, reason: collision with root package name */
    public long f3585b;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f3586c;

    private void a(fu fuVar) {
        this.f3584a = fuVar;
    }

    private fu b() {
        return this.f3584a;
    }

    private InputStream c() {
        return this.f3586c;
    }

    private long d() {
        return this.f3585b;
    }

    private void a(InputStream inputStream) {
        this.f3586c = inputStream;
    }

    private void a(long j10) {
        this.f3585b = j10;
    }

    @Override // com.alibaba.security.realidentity.build.ft
    public final Long a() {
        InputStream inputStream = this.f3586c;
        if (inputStream != null && (inputStream instanceof db)) {
            return Long.valueOf(((db) inputStream).f3420a);
        }
        return super.a();
    }
}
