package com.vivo.push;

import android.content.Intent;
import com.vivo.push.f.ah;

/* compiled from: PushClientFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l implements IPushClientFactory {

    /* renamed from: a, reason: collision with root package name */
    private ah f46242a = new ah();

    @Override // com.vivo.push.IPushClientFactory
    public final com.vivo.push.f.aa createReceiveTask(v vVar) {
        return ah.b(vVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final v createReceiverCommand(Intent intent) {
        v uVar;
        v tVar;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            uVar = new com.vivo.push.b.u();
        } else if (intExtra != 2016) {
            switch (intExtra) {
                case 1:
                case 2:
                    tVar = new com.vivo.push.b.t(intExtra);
                    uVar = tVar;
                    break;
                case 3:
                    uVar = new com.vivo.push.b.o();
                    break;
                case 4:
                    uVar = new com.vivo.push.b.q();
                    break;
                case 5:
                    uVar = new com.vivo.push.b.p();
                    break;
                case 6:
                    uVar = new com.vivo.push.b.r();
                    break;
                case 7:
                    uVar = new com.vivo.push.b.n();
                    break;
                case 8:
                    uVar = new com.vivo.push.b.m();
                    break;
                case 9:
                    uVar = new com.vivo.push.b.k();
                    break;
                case 10:
                case 11:
                    tVar = new com.vivo.push.b.i(intExtra);
                    uVar = tVar;
                    break;
                case 12:
                    uVar = new com.vivo.push.b.j();
                    break;
                default:
                    uVar = null;
                    break;
            }
        } else {
            uVar = new com.vivo.push.b.l();
        }
        if (uVar != null) {
            d a10 = d.a(intent);
            if (a10 == null) {
                com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            } else {
                uVar.b(a10);
            }
        }
        return uVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final s createTask(v vVar) {
        return ah.a(vVar);
    }
}
