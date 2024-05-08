package XI.vs.K0;

import XI.vs.XI.XI;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class XI {
    public XI.vs.XI.XI K0;
    public ServiceConnection kM;

    /* renamed from: XI, reason: collision with root package name */
    public Context f650XI = null;
    public K0 xo = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface K0<T> {
        void serviceConnected(T t2, XI xi);
    }

    /* renamed from: XI.vs.K0.XI$XI, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class ServiceConnectionC0006XI implements ServiceConnection {
        public ServiceConnectionC0006XI() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            XI.this.K0 = XI.AbstractBinderC0007XI.XI(iBinder);
            XI xi = XI.this;
            K0 k02 = xi.xo;
            if (k02 != null) {
                k02.serviceConnected("Deviceid Service Connected", xi);
            }
            Objects.requireNonNull(XI.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            XI.this.K0 = null;
        }
    }

    public int XI(Context context, K0<String> k02) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.f650XI = context;
        this.xo = k02;
        this.kM = new ServiceConnectionC0006XI();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return this.f650XI.bindService(intent, this.kM, 1) ? 1 : -1;
    }
}
