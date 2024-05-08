package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.internal.d;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z implements Handler.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f23700b;

    public z(y yVar) {
        this.f23700b = yVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i10 = message.what;
        if (i10 == 0) {
            hashMap = this.f23700b.f23694d;
            synchronized (hashMap) {
                d.a aVar = (d.a) message.obj;
                hashMap2 = this.f23700b.f23694d;
                a0 a0Var = (a0) hashMap2.get(aVar);
                if (a0Var != null && a0Var.h()) {
                    if (a0Var.d()) {
                        a0Var.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.f23700b.f23694d;
                    hashMap3.remove(aVar);
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        hashMap4 = this.f23700b.f23694d;
        synchronized (hashMap4) {
            d.a aVar2 = (d.a) message.obj;
            hashMap5 = this.f23700b.f23694d;
            a0 a0Var2 = (a0) hashMap5.get(aVar2);
            if (a0Var2 != null && a0Var2.f() == 3) {
                String valueOf = String.valueOf(aVar2);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 47);
                sb2.append("Timeout waiting for ServiceConnection callback ");
                sb2.append(valueOf);
                new Exception();
                ComponentName j10 = a0Var2.j();
                if (j10 == null) {
                    j10 = aVar2.c();
                }
                if (j10 == null) {
                    j10 = new ComponentName((String) h.h(aVar2.b()), "unknown");
                }
                a0Var2.onServiceDisconnected(j10);
            }
        }
        return true;
    }
}
