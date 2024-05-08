package com.vivo.push.d;

import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f46165a;

    public i(h hVar) {
        this.f46165a = hVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.d.a.b bVar) {
        com.vivo.push.d.a.b bVar2 = bVar;
        if (this.f46165a.f46163a != null) {
            u.b("query success");
            this.f46165a.f46163a.onSuccess(bVar2.a());
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i10) {
        if (this.f46165a.f46163a != null) {
            u.b("query err : ".concat(String.valueOf(i10)));
            this.f46165a.f46163a.onError(i10);
        }
    }
}
