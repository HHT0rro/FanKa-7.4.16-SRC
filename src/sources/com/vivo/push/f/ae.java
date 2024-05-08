package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnUnBindAppReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ae extends aa {
    public ae(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        com.vivo.push.util.u.c("OnUnBindTask", "doTask,解订阅APP结果 = " + iVar.i() + " clientToken= " + iVar.e());
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), new Object[0]);
        com.vivo.push.t.b(new af(this, iVar));
    }
}
