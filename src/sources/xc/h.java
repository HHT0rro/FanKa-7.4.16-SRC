package xc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface;
import xc.m;

/* compiled from: LenovoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54639a;

    /* compiled from: LenovoImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceidInterface asInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (asInterface != null) {
                if (asInterface.isSupport()) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IDeviceidInterface#isSupport return false");
            }
            throw new OAIDException("IDeviceidInterface is null");
        }
    }

    public h(Context context) {
        this.f54639a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54639a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        m.a(this.f54639a, intent, cVar, new a());
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54639a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}
