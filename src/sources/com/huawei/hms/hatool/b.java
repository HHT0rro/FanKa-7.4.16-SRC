package com.huawei.hms.hatool;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public s0 f30064a;

    /* renamed from: b, reason: collision with root package name */
    public s0 f30065b;

    /* renamed from: c, reason: collision with root package name */
    public Context f30066c;

    /* renamed from: d, reason: collision with root package name */
    public String f30067d;

    public b(Context context) {
        if (context != null) {
            this.f30066c = context.getApplicationContext();
        }
        this.f30064a = new s0();
        this.f30065b = new s0();
    }

    public b a(int i10, String str) {
        s0 s0Var;
        v.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i10);
        if (!p1.b(str)) {
            str = "";
        }
        if (i10 == 0) {
            s0Var = this.f30064a;
        } else {
            if (i10 != 1) {
                v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            s0Var = this.f30065b;
        }
        s0Var.b(str);
        return this;
    }

    public b a(String str) {
        v.c("hmsSdk", "Builder.setAppID is execute");
        this.f30067d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z10) {
        v.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f30064a.j().a(z10);
        this.f30065b.j().a(z10);
        return this;
    }

    public void a() {
        if (this.f30066c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.c("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.f30064a));
        z0Var.a(new s0(this.f30065b));
        m.a().a(this.f30066c);
        g0.a().a(this.f30066c);
        q.c().a(z0Var);
        m.a().a(this.f30067d);
    }

    @Deprecated
    public b b(boolean z10) {
        v.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f30064a.j().b(z10);
        this.f30065b.j().b(z10);
        return this;
    }

    @Deprecated
    public b c(boolean z10) {
        v.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f30064a.j().c(z10);
        this.f30065b.j().c(z10);
        return this;
    }
}
