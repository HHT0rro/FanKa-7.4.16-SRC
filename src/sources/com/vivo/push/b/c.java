package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.vivo.push.util.aa;

/* compiled from: BaseAppCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f46085a;

    /* renamed from: b, reason: collision with root package name */
    private String f46086b;

    /* renamed from: c, reason: collision with root package name */
    private long f46087c;

    /* renamed from: d, reason: collision with root package name */
    private int f46088d;

    /* renamed from: e, reason: collision with root package name */
    private int f46089e;

    /* renamed from: f, reason: collision with root package name */
    private String f46090f;

    /* renamed from: g, reason: collision with root package name */
    private String f46091g;

    /* renamed from: h, reason: collision with root package name */
    private String f46092h;

    public c(int i10, String str) {
        super(i10);
        this.f46087c = -1L;
        this.f46088d = -1;
        this.f46085a = null;
        this.f46086b = str;
    }

    public final int a(Context context) {
        if (this.f46088d == -1) {
            String str = this.f46086b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.u.a("BaseAppCommand", "pkg name is null");
                String a10 = a();
                if (TextUtils.isEmpty(a10)) {
                    com.vivo.push.util.u.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = a10;
            }
            this.f46088d = aa.b(context, str);
            if (!TextUtils.isEmpty(this.f46090f)) {
                this.f46088d = 2;
            }
        }
        return this.f46088d;
    }

    public final void b(int i10) {
        this.f46089e = i10;
    }

    public final void c(String str) {
        this.f46092h = str;
    }

    public final int d() {
        return this.f46089e;
    }

    public final void e() {
        this.f46090f = null;
    }

    public final String f() {
        return this.f46085a;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final void b(String str) {
        this.f46085a = str;
    }

    @Override // com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        dVar.a(ExposeManager.UtArgsNames.reqId, this.f46085a);
        dVar.a("package_name", this.f46086b);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_APP_STATUS", this.f46088d);
        if (!TextUtils.isEmpty(this.f46090f)) {
            dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f46090f);
        }
        dVar.a("BaseAppCommand.EXTRA_APPID", this.f46092h);
        dVar.a("BaseAppCommand.EXTRA_APPKEY", this.f46091g);
    }

    public final void d(String str) {
        this.f46091g = str;
    }

    @Override // com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        this.f46085a = dVar.a(ExposeManager.UtArgsNames.reqId);
        this.f46086b = dVar.a("package_name");
        this.f46087c = dVar.b("sdk_version", 0L);
        this.f46088d = dVar.b("PUSH_APP_STATUS", 0);
        this.f46090f = dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f46092h = dVar.a("BaseAppCommand.EXTRA_APPID");
        this.f46091g = dVar.a("BaseAppCommand.EXTRA_APPKEY");
    }
}
