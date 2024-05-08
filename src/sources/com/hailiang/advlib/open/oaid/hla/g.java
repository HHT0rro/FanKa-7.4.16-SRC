package com.hailiang.advlib.open.oaid.hla;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.hailiang.advlib.open.oaid.OAIDException;

/* compiled from: OAIDService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27187a;

    /* renamed from: b, reason: collision with root package name */
    public final com.hailiang.advlib.open.oaid.a f27188b;

    /* renamed from: c, reason: collision with root package name */
    public final a f27189c;

    /* compiled from: OAIDService.java */
    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        String a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public g(Context context, com.hailiang.advlib.open.oaid.a aVar, a aVar2) {
        if (context instanceof Application) {
            this.f27187a = context;
        } else {
            this.f27187a = context.getApplicationContext();
        }
        this.f27188b = aVar;
        this.f27189c = aVar2;
    }

    public static void a(Context context, Intent intent, com.hailiang.advlib.open.oaid.a aVar, a aVar2) {
        new g(context, aVar, aVar2).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        String a10;
        try {
            try {
                try {
                    a10 = this.f27189c.a(iBinder);
                } catch (Throwable th) {
                    try {
                        this.f27187a.unbindService(this);
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.f27188b.a(e2);
                context = this.f27187a;
            }
            if (a10 != null && a10.length() != 0) {
                this.f27188b.a(a10);
                context = this.f27187a;
                context.unbindService(this);
                return;
            }
            throw new OAIDException("OAID/AAID acquire failed");
        } catch (Exception unused2) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    private void a(Intent intent) {
        try {
            if (this.f27187a.bindService(intent, this, 1)) {
            } else {
                throw new OAIDException("Service binding failed");
            }
        } catch (Exception e2) {
            this.f27188b.a(e2);
        }
    }
}
