package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnbindAppSendCommandTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aj extends com.vivo.push.s {
    public aj(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
        com.vivo.push.model.b a10 = com.vivo.push.util.aa.a(this.f46360a, com.vivo.push.restructure.a.a().f());
        if (a10 == null) {
            com.vivo.push.m.a().a(cVar.f(), 1005, new Object[0]);
            return;
        }
        String a11 = a10.a();
        if (a10.c()) {
            com.vivo.push.m.a().a(cVar.f(), 1004, new Object[0]);
            vVar = new com.vivo.push.b.e();
        } else {
            int a12 = com.vivo.push.util.y.a(cVar);
            if (a12 != 0) {
                com.vivo.push.m.a().a(cVar.f(), a12, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f46360a, a11, vVar);
    }
}
