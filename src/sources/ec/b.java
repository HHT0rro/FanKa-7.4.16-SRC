package ec;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.weibo.ssosdk.oaid.OAIDException;
import com.weibo.ssosdk.oaid.repeackage.ext.aidl.OpenDeviceIdentifierService;
import ec.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49001a;

    /* renamed from: b, reason: collision with root package name */
    public String f49002b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // ec.g.a
        public String callRemoteInterface(IBinder iBinder) {
            OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (!asInterface.isOaidTrackLimited()) {
                return asInterface.getOaid();
            }
            throw new OAIDException("User has disabled advertising identifier");
        }
    }

    public b(Context context) {
        this.f49001a = context;
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(this.f49001a.getContentResolver(), AdvertisingIdClient.SETTINGS_AD_ID);
                if (!TextUtils.isEmpty(string)) {
                    bVar.onOAIDGetComplete(string);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(this.f49002b) && !supported()) {
            bVar.onOAIDGetError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f49002b);
        g.a(this.f49001a, intent, bVar, new a());
    }

    @Override // cc.c
    public boolean supported() {
        PackageManager packageManager;
        boolean z10 = true;
        try {
            packageManager = this.f49001a.getPackageManager();
        } catch (Exception unused) {
            z10 = false;
        }
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
            this.f49002b = "com.huawei.hwid";
        } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
            this.f49002b = "com.huawei.hwid.tv";
        } else {
            this.f49002b = "com.huawei.hms";
            if (packageManager.getPackageInfo("com.huawei.hms", 0) != null) {
                z10 = false;
            }
            z10 = false;
        }
        return z10;
    }
}
