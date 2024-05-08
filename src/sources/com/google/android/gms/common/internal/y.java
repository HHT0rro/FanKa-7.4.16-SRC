package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.google.android.gms.common.internal.d;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y extends d {

    /* renamed from: e, reason: collision with root package name */
    public final Context f23695e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f23696f;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<d.a, a0> f23694d = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public final a7.a f23697g = a7.a.a();

    /* renamed from: h, reason: collision with root package name */
    public final long f23698h = 5000;

    /* renamed from: i, reason: collision with root package name */
    public final long f23699i = com.huawei.openalliance.ad.constant.u.as;

    public y(Context context) {
        this.f23695e = context.getApplicationContext();
        this.f23696f = new i7.c(context.getMainLooper(), new z(this));
    }

    @Override // com.google.android.gms.common.internal.d
    public final boolean d(d.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d10;
        h.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f23694d) {
            a0 a0Var = this.f23694d.get(aVar);
            if (a0Var == null) {
                a0Var = new a0(this, aVar);
                a0Var.a(serviceConnection, serviceConnection, str);
                a0Var.c(str);
                this.f23694d.put(aVar, a0Var);
            } else {
                this.f23696f.removeMessages(0, aVar);
                if (!a0Var.e(serviceConnection)) {
                    a0Var.a(serviceConnection, serviceConnection, str);
                    int f10 = a0Var.f();
                    if (f10 == 1) {
                        serviceConnection.onServiceConnected(a0Var.j(), a0Var.i());
                    } else if (f10 == 2) {
                        a0Var.c(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 81);
                    sb2.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb2.append(valueOf);
                    throw new IllegalStateException(sb2.toString());
                }
            }
            d10 = a0Var.d();
        }
        return d10;
    }

    @Override // com.google.android.gms.common.internal.d
    public final void e(d.a aVar, ServiceConnection serviceConnection, String str) {
        h.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f23694d) {
            a0 a0Var = this.f23694d.get(aVar);
            if (a0Var != null) {
                if (a0Var.e(serviceConnection)) {
                    a0Var.b(serviceConnection, str);
                    if (a0Var.h()) {
                        this.f23696f.sendMessageDelayed(this.f23696f.obtainMessage(0, aVar), this.f23698h);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 76);
                    sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb2.append(valueOf);
                    throw new IllegalStateException(sb2.toString());
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 50);
                sb3.append("Nonexistent connection status for service config: ");
                sb3.append(valueOf2);
                throw new IllegalStateException(sb3.toString());
            }
        }
    }
}
