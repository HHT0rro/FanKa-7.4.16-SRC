package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111lIl extends l111l1111lI1l {
    private final Context l1111l111111Il;
    private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l11111lIl.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l111l11111lIl.this.l111l11111lIl.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public l111l11111lIl(Context context) {
        this.l1111l111111Il = context;
    }

    private String l1111l111111Il(Context context) {
        if (!l1111l111111Il(context, "com.huawei.hwid")) {
            if (l1111l111111Il(context, "com.huawei.hms")) {
                return "com.huawei.hms";
            }
            if (l1111l111111Il(context, "com.huawei.hwid.tv")) {
                return "com.huawei.hwid.tv";
            }
        }
        return "com.huawei.hwid";
    }

    private boolean l1111l111111Il(Context context, String str) {
        return l111l11111lIl(context, str) != null;
    }

    private static boolean l1111l111111Il(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.replaceAll("0", "").replaceAll("-", "").isEmpty();
    }

    private static PackageInfo l111l11111lIl(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 128);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        String string;
        String str = "com.huawei.hwid";
        try {
            string = Settings.Global.getString(this.l1111l111111Il.getContentResolver(), AdvertisingIdClient.SETTINGS_AD_ID);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!(TextUtils.isEmpty(string) ? true : string.replaceAll("0", "").replaceAll("-", "").isEmpty())) {
            return string;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        Context context = this.l1111l111111Il;
        if (!l1111l111111Il(context, "com.huawei.hwid")) {
            if (l1111l111111Il(context, "com.huawei.hms")) {
                str = "com.huawei.hms";
            } else if (l1111l111111Il(context, "com.huawei.hwid.tv")) {
                str = "com.huawei.hwid.tv";
            }
        }
        intent.setPackage(str);
        if (this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1)) {
            try {
                try {
                    IBinder take = this.l111l11111lIl.take();
                    String str2 = null;
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                        take.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        str2 = obtain2.readString();
                        obtain.recycle();
                    } catch (Throwable th) {
                        try {
                            th.printStackTrace();
                            obtain.recycle();
                        } catch (Throwable th2) {
                            obtain.recycle();
                            obtain2.recycle();
                            throw th2;
                        }
                    }
                    obtain2.recycle();
                    return str2;
                } catch (Exception unused) {
                }
            } finally {
                this.l1111l111111Il.unbindService(this.l111l11111I1l);
            }
        }
        return "";
    }
}
