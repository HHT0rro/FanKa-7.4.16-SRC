package m9;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.impl.device.OaidUtil;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    public ServiceConnection f51949a;

    /* renamed from: b, reason: collision with root package name */
    public CountDownLatch f51950b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            n9.a aVar = n9.a.f52175d;
            aVar.i("OaidServiceTask", "hms service connected");
            OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            try {
                c.g().b(asInterface.getOaid());
                boolean isOaidTrackLimited = asInterface.isOaidTrackLimited();
                c.g().c(isOaidTrackLimited);
                aVar.i("OaidServiceTask", "get oaid success: isLimitReport:" + isOaidTrackLimited);
            } catch (RemoteException unused) {
                n9.a.f52175d.e("OaidServiceTask", "onServiceConnected error!");
            }
            d.this.h();
            d.this.k();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            n9.a.f52175d.i("OaidServiceTask", "ServiceDisconnected!");
            d.this.f51949a = null;
        }
    }

    public d() {
        this.f51949a = null;
        this.f51950b = null;
    }

    public static void d() {
        if (OaidUtil.getEnable()) {
            c.g().d(false);
            new d().execute(new Void[0]);
        }
    }

    public static void j() {
        if (OaidUtil.getEnable()) {
            if (!c.g().e()) {
                n9.a.f52175d.i("OaidServiceTask", "allready request oaid!");
                return;
            }
            c.g().d(false);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new d(countDownLatch).execute(new Void[0]);
            try {
                boolean await = countDownLatch.await(50L, TimeUnit.MILLISECONDS);
                n9.a.f52175d.i("OaidServiceTask", "synExecute get oaid status:" + await);
            } catch (InterruptedException unused) {
                c.g().d(false);
                n9.a.f52175d.e("OaidServiceTask", "wait oaid exception!");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "OaidServiceTask"
            com.huawei.hms.utils.HMSPackageManager r5 = com.huawei.hms.utils.HMSPackageManager.getInstance(r5)     // Catch: java.lang.Exception -> L21
            java.lang.String r5 = r5.getHMSPackageName()     // Catch: java.lang.Exception -> L21
            n9.a r1 = n9.a.f52175d     // Catch: java.lang.Exception -> L22
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L22
            r2.<init>()     // Catch: java.lang.Exception -> L22
            java.lang.String r3 = "hmsPackageName = "
            r2.append(r3)     // Catch: java.lang.Exception -> L22
            r2.append(r5)     // Catch: java.lang.Exception -> L22
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L22
            r1.d(r0, r2)     // Catch: java.lang.Exception -> L22
            goto L29
        L21:
            r5 = 0
        L22:
            n9.a r1 = n9.a.f52175d
            java.lang.String r2 = "getHmsPackageName fail"
            r1.w(r0, r2)
        L29:
            boolean r0 = com.huawei.appgallery.agd.common.utils.StringUtils.isBlank(r5)
            if (r0 == 0) goto L31
            java.lang.String r5 = ""
        L31:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.d.b(android.content.Context):java.lang.String");
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        i();
        return null;
    }

    public final boolean g() {
        return true;
    }

    public final void h() {
        CountDownLatch countDownLatch = this.f51950b;
        if (countDownLatch == null || countDownLatch.getCount() <= 0) {
            return;
        }
        this.f51950b.countDown();
        n9.a.f52175d.i("OaidServiceTask", "release countDown wait!");
    }

    public final void i() {
        boolean bindService;
        if (!g()) {
            n9.a.f52175d.w("OaidServiceTask", "skip startInitOaid, hms may crash");
            return;
        }
        if (this.f51949a != null) {
            n9.a.f52175d.i("OaidServiceTask", "oaid service is existing!");
            h();
            return;
        }
        try {
            Context context = ApplicationWrapper.getInstance().getContext();
            this.f51949a = new b();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(b(context));
            n9.a aVar = n9.a.f52175d;
            aVar.i("OaidServiceTask", "binding hms service...");
            if (Build.VERSION.SDK_INT >= 29) {
                bindService = context.bindService(intent, 1, Executors.newSingleThreadExecutor(), this.f51949a);
            } else {
                h();
                bindService = context.bindService(intent, this.f51949a, 1);
            }
            if (bindService) {
                return;
            }
            aVar.w("OaidServiceTask", "bindService failed!");
        } catch (Exception unused) {
            n9.a.f52175d.e("OaidServiceTask", "bindService error!");
            h();
        }
    }

    public final void k() {
        if (this.f51949a == null) {
            n9.a.f52175d.i("OaidServiceTask", "oaid service is disconnected!");
            return;
        }
        try {
            ApplicationWrapper.getInstance().getContext().unbindService(this.f51949a);
        } catch (Exception unused) {
            n9.a.f52175d.e("OaidServiceTask", "unbind service Exception!");
        }
        this.f51949a = null;
    }

    public d(CountDownLatch countDownLatch) {
        this.f51949a = null;
        this.f51950b = countDownLatch;
    }
}
