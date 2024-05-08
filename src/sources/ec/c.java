package ec;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.weibo.ssosdk.oaid.OAIDException;
import com.weibo.ssosdk.oaid.repeackage.ext.deviceidservice.IDeviceidInterface;
import ec.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49004a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // ec.g.a
        public String callRemoteInterface(IBinder iBinder) {
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

    public c(Context context) {
        this.f49004a = context;
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        g.a(this.f49004a, intent, bVar, new a());
    }

    @Override // cc.c
    public boolean supported() {
        try {
            return this.f49004a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
