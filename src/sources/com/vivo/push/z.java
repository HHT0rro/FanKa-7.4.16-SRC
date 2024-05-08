package com.vivo.push;

import android.text.TextUtils;

/* compiled from: SubscribeImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class z implements k {

    /* renamed from: a, reason: collision with root package name */
    private y f46466a = new y();

    /* renamed from: b, reason: collision with root package name */
    private y f46467b = new y();

    /* renamed from: c, reason: collision with root package name */
    private com.vivo.push.c.a f46468c;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f46469d;

    /* renamed from: e, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f46470e;

    public z(com.vivo.push.c.a aVar, com.vivo.push.restructure.b.a aVar2) {
        this.f46468c = aVar;
        this.f46470e = aVar2;
    }

    private void d(String str) {
        this.f46469d = str;
        this.f46470e.c(this.f46469d);
    }

    @Override // com.vivo.push.k
    public final String b() {
        if (!TextUtils.isEmpty(this.f46469d)) {
            return this.f46469d;
        }
        String d10 = d();
        if (TextUtils.isEmpty(d10)) {
            d10 = this.f46470e.f();
            t.c(new aa(this, d10));
        }
        this.f46469d = d10;
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(d10)));
        return d10;
    }

    @Override // com.vivo.push.k
    public final void c(String str) {
        d(str);
    }

    private int c() {
        if (!this.f46468c.d()) {
            return 8013;
        }
        if (this.f46467b.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe 两秒内重复调用  ");
            return 1002;
        }
        int i10 = 1;
        try {
            String a10 = new e(1, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(a10)));
            String a11 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), a10);
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(a11)));
            if (!TextUtils.isEmpty(a11)) {
                i10 = 1 ^ (Boolean.parseBoolean(g.f46225a.a(a11).b()) ? 1 : 0);
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("SubscribeImpl", "isAppSubscribe", e2);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i10)));
        return i10;
    }

    @Override // com.vivo.push.k
    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (!this.f46468c.c() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(8012);
        } else {
            m.a().b(iPushActionListener, str, str2);
        }
    }

    private String d() {
        String str = "";
        if (!this.f46468c.d()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk 系统不支持查询regid  ");
            return "";
        }
        if (this.f46466a.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk 两秒内重复调用  ");
            return "";
        }
        try {
            String a10 = new e(2, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(a10)));
            String a11 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), a10);
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(a11)));
            if (!TextUtils.isEmpty(a11)) {
                str = g.f46225a.a(a11).b();
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("SubscribeImpl", "getRegidByCoreSdk", e2);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(str)));
        return str;
    }

    @Override // com.vivo.push.k
    public final int a() {
        return c();
    }

    @Override // com.vivo.push.k
    public final void a(String str, String str2, String str3) {
        d(str);
        this.f46470e.a(str2);
        this.f46470e.b(str3);
    }

    @Override // com.vivo.push.k
    public final void a(String str) {
        d(str);
        this.f46470e.d();
        this.f46470e.b();
    }

    @Override // com.vivo.push.k
    public final void b(String str) {
        d(str);
        m.a().e();
        this.f46470e.h();
        this.f46470e.d();
        this.f46470e.b();
    }
}
