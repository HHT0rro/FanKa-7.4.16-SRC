package com.alibaba.security.realidentity.build;

/* compiled from: HeadObjectResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fc extends ft {

    /* renamed from: a, reason: collision with root package name */
    public fu f3592a = new fu();

    private void a(fu fuVar) {
        this.f3592a = fuVar;
    }

    private fu b() {
        return this.f3592a;
    }

    @Override // com.alibaba.security.realidentity.build.ft
    public final String toString() {
        return String.format("HeadObjectResult<%s>:\n metadata:%s", super.toString(), this.f3592a.toString());
    }
}
