package com.mobile.auth.l;

import com.mobile.auth.k.e;
import com.mobile.auth.n.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends c {

    /* renamed from: b, reason: collision with root package name */
    private final e f37487b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f37488c;

    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.f37488c = false;
        this.f37487b = eVar;
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        if (this.f37488c) {
            return;
        }
        com.mobile.auth.k.a c4 = this.f37487b.c();
        if (!aVar.b("isCloseIpv4", false)) {
            c4.q(p.a(true));
        }
        if (!aVar.b("isCloseIpv6", false)) {
            c4.r(p.b(true));
        }
        c4.n(c4.u(aVar.b(com.alipay.sdk.sys.a.f4665f)));
        this.f37487b.a(c4);
        this.f37487b.a(true);
        this.f37489a = this.f37487b.b().toString();
        this.f37488c = true;
    }
}
