package com.vivo.push.f;

import com.vivo.push.cache.ClientConfigManagerImpl;

/* compiled from: InitTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class c extends com.vivo.push.s {
    public c(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f46360a).isDebug());
    }
}
