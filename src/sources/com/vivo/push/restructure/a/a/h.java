package com.vivo.push.restructure.a.a;

import android.content.Context;
import com.vivo.push.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h extends a<com.vivo.push.restructure.a.a> {
    public h(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("InitNode", aVar, iVar);
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        Context b4 = com.vivo.push.restructure.a.a().b();
        com.vivo.push.m.a().a(b4);
        u.d("InitNode", "PushMessageReceiver " + b4.getPackageName() + " ; requestId = " + aVar.c());
        return 0;
    }
}
