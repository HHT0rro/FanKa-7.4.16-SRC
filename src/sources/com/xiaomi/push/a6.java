package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a6 implements aq.b.a {

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f47115a;

    /* renamed from: b, reason: collision with root package name */
    public aq.b f47116b;

    /* renamed from: c, reason: collision with root package name */
    public u4 f47117c;

    /* renamed from: e, reason: collision with root package name */
    public int f47119e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f47120f = false;

    /* renamed from: d, reason: collision with root package name */
    public aq.c f47118d = aq.c.binding;

    public a6(XMPushService xMPushService, aq.b bVar) {
        this.f47115a = xMPushService;
        this.f47116b = bVar;
    }

    @Override // com.xiaomi.push.service.aq.b.a
    public void a(aq.c cVar, aq.c cVar2, int i10) {
        if (!this.f47120f && cVar == aq.c.binding) {
            this.f47118d = cVar2;
            this.f47119e = i10;
            this.f47120f = true;
        }
        this.f47115a.w(new b6(this, 4));
    }

    public void b() {
        this.f47116b.i(this);
        this.f47117c = this.f47115a.e();
    }

    public final void d() {
        this.f47116b.n(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r4 = this;
            r4.d()
            boolean r0 = r4.f47120f
            if (r0 != 0) goto L8
            return
        L8:
            int r0 = r4.f47119e
            r1 = 11
            if (r0 != r1) goto Lf
            return
        Lf:
            com.xiaomi.push.f6 r0 = com.xiaomi.push.f6.f()
            com.xiaomi.push.fm r0 = r0.a()
            int[] r1 = com.xiaomi.push.c6.f47162a
            com.xiaomi.push.service.aq$c r2 = r4.f47118d
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L31
            r3 = 3
            if (r1 == r3) goto L28
            goto L5c
        L28:
            com.xiaomi.push.fl r1 = com.xiaomi.push.fl.BIND_SUCCESS
        L2a:
            int r1 = r1.a()
            r0.f271a = r1
            goto L5c
        L31:
            int r1 = r4.f47119e
            r3 = 17
            if (r1 != r3) goto L3a
            com.xiaomi.push.fl r1 = com.xiaomi.push.fl.BIND_TCP_READ_TIMEOUT
            goto L2a
        L3a:
            r3 = 21
            if (r1 != r3) goto L41
            com.xiaomi.push.fl r1 = com.xiaomi.push.fl.BIND_TIMEOUT
            goto L2a
        L41:
            com.xiaomi.push.e6 r1 = com.xiaomi.push.f6.e()     // Catch: java.lang.NullPointerException -> L5b
            java.lang.Exception r1 = r1.e()     // Catch: java.lang.NullPointerException -> L5b
            com.xiaomi.push.d6$a r1 = com.xiaomi.push.d6.d(r1)     // Catch: java.lang.NullPointerException -> L5b
            com.xiaomi.push.fl r3 = r1.f47181a     // Catch: java.lang.NullPointerException -> L5b
            int r3 = r3.a()     // Catch: java.lang.NullPointerException -> L5b
            r0.f271a = r3     // Catch: java.lang.NullPointerException -> L5b
            java.lang.String r1 = r1.f47182b     // Catch: java.lang.NullPointerException -> L5b
            r0.c(r1)     // Catch: java.lang.NullPointerException -> L5b
            goto L5c
        L5b:
            r0 = 0
        L5c:
            if (r0 == 0) goto L83
            com.xiaomi.push.u4 r1 = r4.f47117c
            java.lang.String r1 = r1.d()
            r0.b(r1)
            com.xiaomi.push.service.aq$b r1 = r4.f47116b
            java.lang.String r1 = r1.f48223b
            r0.d(r1)
            r0.f274b = r2
            com.xiaomi.push.service.aq$b r1 = r4.f47116b     // Catch: java.lang.NumberFormatException -> L7c
            java.lang.String r1 = r1.f48229h     // Catch: java.lang.NumberFormatException -> L7c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L7c
            byte r1 = (byte) r1     // Catch: java.lang.NumberFormatException -> L7c
            r0.a(r1)     // Catch: java.lang.NumberFormatException -> L7c
        L7c:
            com.xiaomi.push.f6 r1 = com.xiaomi.push.f6.f()
            r1.i(r0)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.a6.e():void");
    }
}
