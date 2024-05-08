package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a;
import com.hailiang.advlib.open.oaid.hla.g;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;

/* compiled from: HuaweiImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27180a;

    /* renamed from: b, reason: collision with root package name */
    public String f27181b;

    /* compiled from: HuaweiImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // com.hailiang.advlib.open.oaid.hla.g.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.hailiang.advlib.open.oaid.hl.hld.hl.hl.a a10 = a.b.a(iBinder);
            if (!a10.b()) {
                return a10.h();
            }
            throw new OAIDException("User has disabled advertising identifier");
        }
    }

    public c(Context context) {
        this.f27180a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f27180a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f27181b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f27181b = "com.huawei.hwid.tv";
            } else {
                this.f27181b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        Context context = this.f27180a;
        if (context == null || aVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), AdvertisingIdClient.SETTINGS_AD_ID);
                if (!TextUtils.isEmpty(string)) {
                    aVar.a(string);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(this.f27181b) && !a()) {
            aVar.a(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f27181b);
        g.a(this.f27180a, intent, aVar, new a());
    }
}
