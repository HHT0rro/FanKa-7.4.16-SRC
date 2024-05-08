package com.vivo.push.f;

import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnMessageReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t extends aa {
    public t(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.o oVar = (com.vivo.push.b.o) vVar;
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(oVar.f())));
        if (!ClientConfigManagerImpl.getInstance(this.f46360a).isEnablePush()) {
            com.vivo.push.util.u.d("OnMessageTask", "command  " + ((Object) vVar) + " is ignore by disable push ");
            super.a(1020);
            return;
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f46360a), oVar.d(), oVar.g())) {
            super.a(1021);
            return;
        }
        UnvarnishedMessage e2 = oVar.e();
        if (e2 != null) {
            com.vivo.push.util.u.d("OnMessageTask", "tragetType is " + e2.getTargetType() + " ; messageId is " + e2.getMsgId());
            ((aa) this).f46183b.onTransmissionMessage(this.f46360a, e2);
            super.a(0);
            return;
        }
        super.a(2807);
        com.vivo.push.util.u.a("OnMessageTask", " message is null");
    }
}
