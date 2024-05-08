package xc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService;
import xc.m;

/* compiled from: SamsungImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54652a;

    /* compiled from: SamsungImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdService asInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public o(Context context) {
        this.f54652a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54652a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        m.a(this.f54652a, intent, cVar, new a());
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54652a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}
