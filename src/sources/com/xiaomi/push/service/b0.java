package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;
import java.io.IOException;
import java.util.Collection;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b0 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public XMPushService f48257c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f48258d;

    /* renamed from: e, reason: collision with root package name */
    public String f48259e;

    /* renamed from: f, reason: collision with root package name */
    public String f48260f;

    /* renamed from: g, reason: collision with root package name */
    public String f48261g;

    public b0(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f48257c = xMPushService;
        this.f48259e = str;
        this.f48258d = bArr;
        this.f48260f = str2;
        this.f48261g = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        aq.b next;
        z a10 = a0.a(this.f48257c);
        if (a10 == null) {
            try {
                a10 = a0.b(this.f48257c, this.f48259e, this.f48260f, this.f48261g);
            } catch (IOException | JSONException e2) {
                fc.c.k(e2);
            }
        }
        if (a10 == null) {
            fc.c.n("no account for mipush");
            kc.j0.a(this.f48257c, 70000002, "no account.");
            return;
        }
        Collection<aq.b> f10 = aq.c().f("5");
        if (f10.isEmpty()) {
            next = a10.a(this.f48257c);
            j0.i(this.f48257c, next);
            aq.c().l(next);
        } else {
            next = f10.iterator2().next();
        }
        if (!this.f48257c.a0()) {
            this.f48257c.F(true);
            return;
        }
        try {
            aq.c cVar = next.f48234m;
            if (cVar == aq.c.binded) {
                j0.k(this.f48257c, this.f48259e, this.f48258d);
            } else if (cVar == aq.c.unbind) {
                XMPushService xMPushService = this.f48257c;
                xMPushService.getClass();
                xMPushService.w(new XMPushService.a(next));
            }
        } catch (gh e10) {
            fc.c.k(e10);
            this.f48257c.r(10, e10);
        }
    }
}
