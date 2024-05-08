package com.alibaba.security.realidentity.build;

/* compiled from: GetBucketInfoResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eo extends ft {

    /* renamed from: a, reason: collision with root package name */
    public fr f3564a;

    private void a(fr frVar) {
        this.f3564a = frVar;
    }

    private fr b() {
        return this.f3564a;
    }

    @Override // com.alibaba.security.realidentity.build.ft
    public final String toString() {
        return String.format("GetBucketInfoResult<%s>:\n bucket:%s", super.toString(), this.f3564a.toString());
    }
}
