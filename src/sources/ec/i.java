package ec;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.weibo.ssosdk.oaid.OAIDException;
import com.weibo.ssosdk.oaid.repeackage.ext.deviceidservice.IDeviceIdService;
import ec.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class i implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49015a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // ec.g.a
        public String callRemoteInterface(IBinder iBinder) {
            IDeviceIdService asInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public i(Context context) {
        this.f49015a = context;
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        g.a(this.f49015a, intent, bVar, new a());
    }

    @Override // cc.c
    public boolean supported() {
        try {
            return this.f49015a.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
