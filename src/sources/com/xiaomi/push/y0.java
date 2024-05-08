package com.xiaomi.push;

import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y0 implements x4 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f48504b;

    public y0(x0 x0Var) {
        this.f48504b = x0Var;
    }

    @Override // com.xiaomi.push.x4
    public void a(u4 u4Var, int i10, Exception exc) {
        u4 u4Var2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Slim] ");
        sb2.append(this.f48504b.f48463a.format(new Date()));
        sb2.append(" Connection closed (");
        u4Var2 = this.f48504b.f48464b;
        sb2.append(u4Var2.hashCode());
        sb2.append(")");
        fc.c.m(sb2.toString());
    }

    @Override // com.xiaomi.push.x4
    public void b(u4 u4Var, Exception exc) {
        u4 u4Var2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Slim] ");
        sb2.append(this.f48504b.f48463a.format(new Date()));
        sb2.append(" Reconnection failed due to an exception (");
        u4Var2 = this.f48504b.f48464b;
        sb2.append(u4Var2.hashCode());
        sb2.append(")");
        fc.c.m(sb2.toString());
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.x4
    public void c(u4 u4Var) {
        u4 u4Var2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Slim] ");
        sb2.append(this.f48504b.f48463a.format(new Date()));
        sb2.append(" Connection started (");
        u4Var2 = this.f48504b.f48464b;
        sb2.append(u4Var2.hashCode());
        sb2.append(")");
        fc.c.m(sb2.toString());
    }

    @Override // com.xiaomi.push.x4
    public void d(u4 u4Var) {
        u4 u4Var2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Slim] ");
        sb2.append(this.f48504b.f48463a.format(new Date()));
        sb2.append(" Connection reconnected (");
        u4Var2 = this.f48504b.f48464b;
        sb2.append(u4Var2.hashCode());
        sb2.append(")");
        fc.c.m(sb2.toString());
    }
}
