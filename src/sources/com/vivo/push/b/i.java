package com.vivo.push.b;

import com.tencent.connect.common.Constants;

/* compiled from: OnAppReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f46097a;

    /* renamed from: b, reason: collision with root package name */
    private String f46098b;

    /* renamed from: c, reason: collision with root package name */
    private String f46099c;

    /* renamed from: d, reason: collision with root package name */
    private String f46100d;

    public i(int i10) {
        super(i10);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.f46097a);
        dVar.a(Constants.PARAM_CLIENT_ID, this.f46098b);
        dVar.a("client_token", this.f46099c);
        dVar.a("client_token_validity_period", this.f46100d);
    }

    public final String d() {
        return this.f46097a;
    }

    public final String e() {
        return this.f46099c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46097a = dVar.a("app_id");
        this.f46098b = dVar.a(Constants.PARAM_CLIENT_ID);
        this.f46099c = dVar.a("client_token");
        this.f46100d = dVar.a("client_token_validity_period");
    }
}
