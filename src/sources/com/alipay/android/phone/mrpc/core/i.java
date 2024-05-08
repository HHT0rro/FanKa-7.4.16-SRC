package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class i implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aa f4233a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f4234b;

    public i(h hVar, aa aaVar) {
        this.f4234b = hVar;
        this.f4233a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final String a() {
        return this.f4233a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final ab b() {
        Context context;
        context = this.f4234b.f4232a;
        return l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final aa c() {
        return this.f4233a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.f4233a.c();
    }
}
