package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: RemoteService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private ServiceConnection f30454a;

    /* renamed from: b, reason: collision with root package name */
    private Messenger f30455b = null;

    /* compiled from: RemoteService.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f30456a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30457b;

        public a(Bundle bundle, Context context) {
            this.f30456a = bundle;
            this.f30457b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("RemoteService", "remote service onConnected");
            r.this.f30455b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f30456a);
            try {
                r.this.f30455b.send(obtain);
            } catch (RemoteException unused) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f30457b.unbindService(r.this.f30454a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            r.this.f30455b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f30454a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f30454a, 1);
    }
}
