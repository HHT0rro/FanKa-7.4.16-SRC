package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnClearCacheReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k extends aa {
    public k(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.u.d("OnClearCacheTask", "delete push info " + this.f46360a.getPackageName());
        com.vivo.push.util.af.b(this.f46360a).a();
    }
}
