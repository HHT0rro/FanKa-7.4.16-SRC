package com.huawei.hms.ads.identifier;

import a.a;
import a.b;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.IOException;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdvertisingIdClient {
    public static final String SETTINGS_AD_ID = "pps_oaid";
    public static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Info {
        public final String advertisingId;
        public final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z10) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z10;
        }

        @Keep
        public final String getId() {
            return this.advertisingId;
        }

        @Keep
        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class XI implements Runnable {

        /* renamed from: XI, reason: collision with root package name */
        public final /* synthetic */ Context f29304XI;

        public XI(Context context) {
            this.f29304XI = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.f29304XI);
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new Info(string, Boolean.valueOf(string2).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    @Keep
    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid");
            return !r4.queryIntentServices(r2, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static Info requestAdvertisingIdInfo(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            b bVar = new b();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (!context.bindService(intent, bVar, 1)) {
                    throw new IOException("bind failed");
                }
                try {
                    if (!bVar.f659b) {
                        bVar.f659b = true;
                        IBinder take = bVar.f660c.take();
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        try {
                            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                            take.transact(1, obtain, obtain2, 0);
                            obtain2.readException();
                            String readString = obtain2.readString();
                            obtain2.recycle();
                            obtain.recycle();
                            obtain = Parcel.obtain();
                            obtain2 = Parcel.obtain();
                            try {
                                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                                take.transact(2, obtain, obtain2, 0);
                                obtain2.readException();
                                boolean z10 = obtain2.readInt() != 0;
                                obtain2.recycle();
                                obtain.recycle();
                                Info info = new Info(readString, z10);
                                try {
                                    context.unbindService(bVar);
                                } catch (Throwable unused) {
                                }
                                return info;
                            } finally {
                            }
                        } finally {
                        }
                    }
                    throw new IllegalStateException();
                } catch (RemoteException unused2) {
                    throw new IOException("bind hms service RemoteException");
                } catch (InterruptedException unused3) {
                    throw new IOException("bind hms service InterruptedException");
                }
            } catch (Throwable th) {
                try {
                    context.unbindService(bVar);
                } catch (Throwable unused4) {
                }
                throw th;
            }
        } catch (PackageManager.NameNotFoundException unused5) {
            throw new IOException("Service not found");
        }
    }

    public static void updateAdvertisingIdInfo(Context context) {
        a.f657a.execute(new XI(context));
    }

    @Keep
    public static boolean verifyAdId(Context context, String str, boolean z10) {
        Info requestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
        if (requestAdvertisingIdInfo != null && TextUtils.equals(str, requestAdvertisingIdInfo.getId())) {
            if (z10 == requestAdvertisingIdInfo.isLimitAdTrackingEnabled()) {
                return true;
            }
        }
        return false;
    }
}
