package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnBindAppReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h extends aa {
    public h(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        String e2 = iVar.e();
        com.vivo.push.util.u.d("OnBindTask", "doTask,订阅APP结果 = " + iVar.i() + " clientToken= " + e2);
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), e2);
        com.vivo.push.t.b(new i(this, e2, iVar));
    }
}
