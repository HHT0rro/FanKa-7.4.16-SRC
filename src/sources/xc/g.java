package xc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import xc.m;

/* compiled from: HuaweiImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54636a;

    /* renamed from: b, reason: collision with root package name */
    public String f54637b;

    /* compiled from: HuaweiImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (!asInterface.isOaidTrackLimited()) {
                return asInterface.getOaid();
            }
            throw new OAIDException("User has disabled advertising identifier");
        }
    }

    public g(Context context) {
        this.f54636a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        Context context = this.f54636a;
        if (context == null || cVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), AdvertisingIdClient.SETTINGS_AD_ID);
                if (!TextUtils.isEmpty(string)) {
                    wc.f.a("Get oaid from global settings: " + string);
                    cVar.oaidSucc(string);
                    return;
                }
            } catch (Exception e2) {
                wc.f.a(e2);
            }
        }
        if (TextUtils.isEmpty(this.f54637b) && !supported()) {
            cVar.oaidError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f54637b);
        m.a(this.f54636a, intent, cVar, new a());
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54636a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f54637b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f54637b = "com.huawei.hwid.tv";
            } else {
                this.f54637b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}
