package ec;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.weibo.ssosdk.oaid.OAIDException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g implements ServiceConnection {

    /* renamed from: b, reason: collision with root package name */
    public final Context f49009b;

    /* renamed from: c, reason: collision with root package name */
    public final cc.b f49010c;

    /* renamed from: d, reason: collision with root package name */
    public final a f49011d;

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        String callRemoteInterface(IBinder iBinder);
    }

    public g(Context context, cc.b bVar, a aVar) {
        if (context instanceof Application) {
            this.f49009b = context;
        } else {
            this.f49009b = context.getApplicationContext();
        }
        this.f49010c = bVar;
        this.f49011d = aVar;
    }

    public static void a(Context context, Intent intent, cc.b bVar, a aVar) {
        new g(context, bVar, aVar).b(intent);
    }

    public final void b(Intent intent) {
        try {
            if (this.f49009b.bindService(intent, this, 1)) {
            } else {
                throw new OAIDException("Service binding failed");
            }
        } catch (Exception e2) {
            this.f49010c.onOAIDGetError(e2);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            try {
                String callRemoteInterface = this.f49011d.callRemoteInterface(iBinder);
                if (callRemoteInterface != null && callRemoteInterface.length() != 0) {
                    this.f49010c.onOAIDGetComplete(callRemoteInterface);
                    try {
                        this.f49009b.unbindService(this);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                throw new OAIDException("OAID/AAID acquire failed");
            } catch (Exception e2) {
                this.f49010c.onOAIDGetError(e2);
                try {
                    this.f49009b.unbindService(this);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            try {
                this.f49009b.unbindService(this);
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
