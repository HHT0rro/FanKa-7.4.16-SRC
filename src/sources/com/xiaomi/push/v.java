package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class v implements x {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f48412i;

    /* renamed from: b, reason: collision with root package name */
    public Context f48413b;

    /* renamed from: c, reason: collision with root package name */
    public ServiceConnection f48414c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f48415d = 0;

    /* renamed from: e, reason: collision with root package name */
    public volatile String f48416e = null;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f48417f = false;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f48418g = null;

    /* renamed from: h, reason: collision with root package name */
    public final Object f48419h = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                v.this.f48416e = b.a(iBinder);
                v.this.f48417f = b.b(iBinder);
                v.this.j();
                v.this.f48415d = 2;
                synchronized (v.this.f48419h) {
                    try {
                        v.this.f48419h.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                v.this.j();
                v.this.f48415d = 2;
                synchronized (v.this.f48419h) {
                    try {
                        v.this.f48419h.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                v.this.j();
                v.this.f48415d = 2;
                synchronized (v.this.f48419h) {
                    try {
                        v.this.f48419h.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {
        public static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public static boolean b(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public v(Context context) {
        this.f48413b = context;
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r5) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L24
            r2 = 24
            r3 = 0
            java.lang.String r4 = "aaid"
            if (r1 < r2) goto L19
            android.content.Context r1 = r5.createDeviceProtectedStorageContext()     // Catch: java.lang.Exception -> L24
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r4, r3)     // Catch: java.lang.Exception -> L24
            java.lang.String r1 = r1.getString(r4, r0)     // Catch: java.lang.Exception -> L24
            if (r1 == 0) goto L1a
            return r1
        L19:
            r1 = r0
        L1a:
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r4, r3)     // Catch: java.lang.Exception -> L23
            java.lang.String r5 = r5.getString(r4, r0)     // Catch: java.lang.Exception -> L23
            goto L25
        L23:
            r0 = r1
        L24:
            r5 = r0
        L25:
            if (r5 != 0) goto L29
            java.lang.String r5 = ""
        L29:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.v.c(android.content.Context):java.lang.String");
    }

    public static boolean h(Context context) {
        boolean z10;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z10 = (packageInfo.applicationInfo.flags & 1) != 0;
            f48412i = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z10;
    }

    @Override // com.xiaomi.push.x
    public String a() {
        return null;
    }

    @Override // com.xiaomi.push.x
    /* renamed from: a */
    public boolean mo2931a() {
        return f48412i;
    }

    @Override // com.xiaomi.push.x
    public String b() {
        g("getOAID");
        return this.f48416e;
    }

    @Override // com.xiaomi.push.x
    public String c() {
        return null;
    }

    @Override // com.xiaomi.push.x
    public String d() {
        if (this.f48418g == null) {
            synchronized (this) {
                if (this.f48418g == null) {
                    this.f48418g = c(this.f48413b);
                }
            }
        }
        return this.f48418g;
    }

    public final void e() {
        boolean z10;
        this.f48414c = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z10 = this.f48413b.bindService(intent, this.f48414c, 1);
        } catch (Exception unused) {
            z10 = false;
        }
        this.f48415d = z10 ? 1 : 2;
    }

    public final void g(String str) {
        if (this.f48415d != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f48419h) {
            try {
                fc.c.i("huawei's " + str + " wait...");
                this.f48419h.wait(com.huawei.openalliance.ad.ipc.c.Code);
            } catch (Exception unused) {
            }
        }
    }

    public final void j() {
        ServiceConnection serviceConnection = this.f48414c;
        if (serviceConnection != null) {
            try {
                this.f48413b.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }
}
