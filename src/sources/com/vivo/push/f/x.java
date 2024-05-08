package com.vivo.push.f;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnNotificationClickTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class x extends aa {
    public x(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        Context context = this.f46360a;
        if (com.vivo.push.util.aa.c(context, context.getPackageName())) {
            e eVar = new e(vVar);
            eVar.a(((aa) this).f46183b);
            eVar.a(vVar);
        } else {
            d dVar = new d(vVar);
            dVar.a(((aa) this).f46183b);
            dVar.a(vVar);
        }
    }
}
