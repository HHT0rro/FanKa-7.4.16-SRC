package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPCManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f46241a;

    public j(i iVar) {
        this.f46241a = iVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.u.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i10 = message.what;
        if (i10 == 1) {
            com.vivo.push.util.u.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f46241a.f46236f;
            if (atomicInteger.get() == 2) {
                this.f46241a.a(1);
            }
        } else if (i10 == 2) {
            atomicInteger2 = this.f46241a.f46236f;
            if (atomicInteger2.get() == 4) {
                this.f46241a.f();
            }
            this.f46241a.a(1);
        } else {
            com.vivo.push.util.u.b("AidlManager", "unknow msg what [" + message.what + "]");
        }
        return true;
    }
}
