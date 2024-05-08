package com.vivo.push.f;

/* compiled from: OnDispatcherReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o extends aa {
    public o(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) vVar;
        int d10 = lVar.d();
        int e2 = lVar.e();
        com.vivo.push.util.ad.b().a("key_dispatch_environment", d10);
        com.vivo.push.util.ad.b().a("key_dispatch_area", e2);
    }
}
