package xc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager;
import xc.m;

/* compiled from: CoolpadImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54628a;

    /* compiled from: CoolpadImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdManager asInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID(b.this.f54628a.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public b(Context context) {
        if (context instanceof Application) {
            this.f54628a = context;
        } else {
            this.f54628a = context.getApplicationContext();
        }
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54628a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.f54628a, intent, cVar, new a());
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54628a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}
