package xc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;

/* compiled from: OAIDService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m implements ServiceConnection {

    /* renamed from: b, reason: collision with root package name */
    public final Context f54646b;

    /* renamed from: c, reason: collision with root package name */
    public final wc.c f54647c;

    /* renamed from: d, reason: collision with root package name */
    public final a f54648d;

    /* compiled from: OAIDService.java */
    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a {
        String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public m(Context context, wc.c cVar, a aVar) {
        if (context instanceof Application) {
            this.f54646b = context;
        } else {
            this.f54646b = context.getApplicationContext();
        }
        this.f54647c = cVar;
        this.f54648d = aVar;
    }

    public static void a(Context context, Intent intent, wc.c cVar, a aVar) {
        new m(context, cVar, aVar).b(intent);
    }

    public final void b(Intent intent) {
        try {
            if (this.f54646b.bindService(intent, this, 1)) {
                wc.f.a("Service has been bound: " + ((Object) intent));
                return;
            }
            throw new OAIDException("Service binding failed");
        } catch (Exception e2) {
            this.f54647c.oaidError(e2);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        wc.f.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String callRemoteInterface = this.f54648d.callRemoteInterface(iBinder);
                if (callRemoteInterface != null && callRemoteInterface.length() != 0) {
                    wc.f.a("OAID/AAID acquire success: " + callRemoteInterface);
                    this.f54647c.oaidSucc(callRemoteInterface);
                    try {
                        this.f54646b.unbindService(this);
                        wc.f.a("Service has been unbound: " + componentName.getClassName());
                        return;
                    } catch (Exception e2) {
                        wc.f.a(e2);
                        return;
                    }
                }
                throw new OAIDException("OAID/AAID acquire failed");
            } catch (Exception e10) {
                wc.f.a(e10);
                this.f54647c.oaidError(e10);
                try {
                    this.f54646b.unbindService(this);
                    wc.f.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e11) {
                    wc.f.a(e11);
                }
            }
        } catch (Throwable th) {
            try {
                this.f54646b.unbindService(this);
                wc.f.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e12) {
                wc.f.a(e12);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        wc.f.a("Service has been disconnected: " + componentName.getClassName());
    }
}
