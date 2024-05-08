package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.cache.ClientConfigManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendCommandTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ai extends com.vivo.push.s {
    public ai(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        Context context = this.f46360a;
        if (context == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + ((Object) vVar) + " ; mContext is Null");
            return;
        }
        if (vVar == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        com.vivo.push.model.b a10 = com.vivo.push.util.aa.a(context, com.vivo.push.restructure.a.a().f());
        int b4 = vVar.b();
        if (b4 == 2009) {
            com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f46360a).isDebug());
            if (com.vivo.push.util.u.b()) {
                com.vivo.push.m.a();
                com.vivo.push.restructure.a.a().e().e();
                com.vivo.push.util.c cVar = new com.vivo.push.util.c();
                cVar.a(this.f46360a, "com.vivo.push_preferences.hybridapptoken_v1");
                cVar.a();
                com.vivo.push.util.c cVar2 = new com.vivo.push.util.c();
                cVar2.a(this.f46360a, "com.vivo.push_preferences.appconfig_v1");
                cVar2.a();
                if (!com.vivo.push.m.a().f()) {
                    ClientConfigManagerImpl.getInstance(this.f46360a).clearPush();
                }
            }
        } else if (b4 != 2011) {
            switch (b4) {
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                    if (a10 != null && !a10.c()) {
                        com.vivo.push.b.c cVar3 = (com.vivo.push.b.c) vVar;
                        int a11 = com.vivo.push.util.y.a(cVar3);
                        if (a11 != 0) {
                            com.vivo.push.m.a().a(cVar3.f(), a11);
                            return;
                        }
                    } else {
                        com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1005);
                        break;
                    }
                    break;
            }
        } else {
            com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f46360a).isDebug(((com.vivo.push.b.w) vVar).d()));
        }
        if (a10 == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + ((Object) vVar) + " ; pushPkgInfo is Null");
            return;
        }
        String a12 = a10.a();
        if (a10.c()) {
            try {
                com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1004);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            vVar = new com.vivo.push.b.e();
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + ((Object) vVar) + " ; pkgName is InBlackList ");
        }
        com.vivo.push.a.a.a(this.f46360a, a12, vVar);
    }
}
