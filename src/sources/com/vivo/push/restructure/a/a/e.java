package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DispatchNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends a<com.vivo.push.restructure.a.a> {
    public e(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("ClientDispatchNode", aVar, iVar);
    }

    private static PushMessageCallback b(com.vivo.push.restructure.a.a aVar) {
        try {
            return (PushMessageCallback) Class.forName(com.vivo.push.restructure.a.a().e().a(com.vivo.push.restructure.a.a().b(), aVar.b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            u.b("DispatchNode", "reflect e: ", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.a.a.a
    public int a(com.vivo.push.restructure.a.a aVar) {
        PushMessageCallback b4 = b(aVar);
        if (b4 == null) {
            return 2804;
        }
        int i10 = 0;
        if (aVar != null && aVar.g()) {
            com.vivo.push.restructure.request.d.a().a(aVar);
            return 0;
        }
        if (aVar != null) {
            int k10 = aVar.k();
            String l10 = aVar.l();
            if (k10 == 3) {
                String i11 = com.vivo.push.m.a().i();
                if (TextUtils.isEmpty(i11) || !TextUtils.equals(i11, l10)) {
                    i10 = 2810;
                }
            } else if (k10 == 4) {
                com.vivo.push.m.a();
                if (!com.vivo.push.m.c().contains(l10)) {
                    i10 = 2811;
                }
            }
            if (i10 != 0) {
                com.vivo.push.util.g.a().execute(new f(this, k10, l10));
                return i10;
            }
        }
        try {
            return com.vivo.push.m.a().a(aVar.b(), b4);
        } catch (Exception unused) {
            return 2808;
        }
    }
}
