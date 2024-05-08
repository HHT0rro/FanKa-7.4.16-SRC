package w9;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.api.ConnectConfig;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import com.huawei.appgallery.coreservice.internal.service.installhiapp.GuideInstallAppGallery;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.huawei.appmarket.framework.coreservice.DataHolder;
import com.huawei.appmarket.framework.coreservice.Status;
import com.huawei.appmarket.framework.coreservice.a;
import com.huawei.appmarket.framework.coreservice.b;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.constant.u;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e implements c, ServiceConnection {

    /* renamed from: j, reason: collision with root package name */
    public static AtomicInteger f54293j = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public String f54294b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f54295c;

    /* renamed from: e, reason: collision with root package name */
    public com.huawei.appmarket.framework.coreservice.b f54297e;

    /* renamed from: h, reason: collision with root package name */
    public ConnectConfig f54300h;

    /* renamed from: d, reason: collision with root package name */
    public final Set<ApiClient.ConnectionCallback> f54296d = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public boolean f54298f = false;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicInteger f54299g = new AtomicInteger();

    /* renamed from: i, reason: collision with root package name */
    public final ApiClient.ConnectionCallback f54301i = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements ApiClient.ConnectionCallback {
        public a() {
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnected() {
            m.a("InnerApiClientImpl", "ConnectionCallback : onConnected()");
            Iterator iterator2 = e.this.f54296d.iterator2();
            while (iterator2.hasNext()) {
                ((ApiClient.ConnectionCallback) iterator2.next()).onConnected();
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionFailed(IConnectionResult iConnectionResult) {
            m.a("InnerApiClientImpl", "OnConnectionFailedListener : onConnectionFailed()");
            Iterator iterator2 = e.this.f54296d.iterator2();
            while (iterator2.hasNext()) {
                ((ApiClient.ConnectionCallback) iterator2.next()).onConnectionFailed(iConnectionResult);
            }
        }

        @Override // com.huawei.appgallery.coreservice.api.ApiClient.ConnectionCallback
        public void onConnectionSuspended(int i10) {
            m.a("InnerApiClientImpl", "ConnectionCallback : onConnectionSuspended()");
            Iterator iterator2 = e.this.f54296d.iterator2();
            while (iterator2.hasNext()) {
                ((ApiClient.ConnectionCallback) iterator2.next()).onConnectionSuspended(i10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<e> f54303b;

        /* renamed from: c, reason: collision with root package name */
        public int f54304c;

        public b(e eVar, int i10) {
            this.f54304c = i10;
            this.f54303b = new WeakReference<>(eVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            WeakReference<e> weakReference = this.f54303b;
            if (weakReference == null || (eVar = weakReference.get()) == null) {
                m.d("InnerApiClientImpl", "innerApiClient already null");
                return;
            }
            int i10 = this.f54304c;
            if (i10 != 1) {
                if (i10 == 2) {
                    eVar.q();
                    return;
                }
                return;
            }
            m.d("InnerApiClientImpl", "delay bind core service");
            boolean z10 = false;
            try {
                z10 = eVar.o();
            } catch (SecurityException e2) {
                m.b("InnerApiClientImpl", "bindCoreService Execption", e2);
            }
            if (z10) {
                return;
            }
            eVar.p();
        }
    }

    public e(Context context) {
        this.f54295c = context;
    }

    public static String h(Context context) {
        String str;
        try {
            return new ServiceVerifyKit.Builder().e(context).f(new Intent("com.huawei.appmarket.service.intent.ACTION_CORE_SERVICE"), ServiceVerifyKit.Builder.ComponentType.SERVICE).a(u.W, "FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212").a(u.W, "3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F").b();
        } catch (RuntimeException unused) {
            str = "get market pkg RuntimeException!";
            m.c("InnerApiClientImpl", str);
            return "";
        } catch (Exception unused2) {
            str = "get market pkg Exception!";
            m.c("InnerApiClientImpl", str);
            return "";
        }
    }

    public static w9.b k(Context context) {
        return new w9.b(4, GuideInstallAppGallery.a(context));
    }

    @Override // w9.c
    public void a(DataHolder dataHolder, a.AbstractBinderC0260a abstractBinderC0260a) {
        try {
            com.huawei.appmarket.framework.coreservice.b bVar = this.f54297e;
            if (bVar != null) {
                bVar.a(dataHolder, abstractBinderC0260a);
            } else if (abstractBinderC0260a != null) {
                f(abstractBinderC0260a, "mTransportService is null");
            }
        } catch (RemoteException unused) {
            f(abstractBinderC0260a, "asyncCall RemoteExecption");
        }
    }

    public String b(Context context) {
        String str;
        try {
            return new ServiceVerifyKit.Builder().e(context).f(new Intent(this.f54300h.getConnectServiceAction()), ServiceVerifyKit.Builder.ComponentType.SERVICE).c(this.f54300h.getAppSignCertchain()).d(this.f54300h.getAppFingerprintSignature()).b();
        } catch (RuntimeException unused) {
            str = "get market pkg RuntimeException!";
            m.c("InnerApiClientImpl", str);
            return "";
        } catch (Exception unused2) {
            str = "get market pkg Exception!";
            m.c("InnerApiClientImpl", str);
            return "";
        }
    }

    public void d() {
        m.d("InnerApiClientImpl", "disconnect()");
        this.f54299g.decrementAndGet();
        r();
    }

    public void e(ConnectConfig connectConfig) {
        this.f54300h = connectConfig;
    }

    public final void f(a.AbstractBinderC0260a abstractBinderC0260a, String str) {
        m.c("InnerApiClientImpl", "call Failed:" + str);
        try {
            abstractBinderC0260a.call(new Status(4));
        } catch (RemoteException unused) {
            m.c("InnerApiClientImpl", str);
        }
    }

    public void g(Set<ApiClient.ConnectionCallback> set) {
        m.d("InnerApiClientImpl", "connect()");
        this.f54299g.incrementAndGet();
        this.f54298f = true;
        this.f54296d.addAll(set);
        if (s()) {
            boolean z10 = false;
            try {
                z10 = o();
            } catch (SecurityException e2) {
                m.b("InnerApiClientImpl", "bind Execption", e2);
            }
            if (z10) {
                m.d("InnerApiClientImpl", "bind success!");
            } else {
                n.a(new b(this, 2), 200L);
            }
        }
    }

    public boolean i() {
        com.huawei.appmarket.framework.coreservice.b bVar = this.f54297e;
        return bVar != null && bVar.asBinder().isBinderAlive();
    }

    public boolean m() {
        return this.f54298f;
    }

    public final boolean o() {
        if (TextUtils.isEmpty(this.f54294b)) {
            return false;
        }
        Intent a10 = d.a(this.f54294b, this.f54300h);
        a10.putExtra("mediaPkg", this.f54295c.getPackageName());
        a10.putExtra(bg.e.Code, 9);
        if (Build.VERSION.SDK_INT >= 29) {
            a10.setIdentifier(this.f54295c.getPackageName() + "-" + f54293j.getAndIncrement());
        }
        return this.f54295c.bindService(a10, this, 1);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m.d("InnerApiClientImpl", "Enter onServiceConnected.");
        this.f54297e = b.a.a(iBinder);
        this.f54301i.onConnected();
        this.f54298f = false;
        if (this.f54299g.get() <= 0) {
            m.d("InnerApiClientImpl", "service expect to unbind");
            r();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        m.d("InnerApiClientImpl", "Enter onServiceDisconnected.");
        this.f54297e = null;
        this.f54298f = false;
        this.f54301i.onConnectionSuspended(1);
    }

    public final void p() {
        this.f54298f = false;
        this.f54301i.onConnectionFailed(new w9.b(2));
    }

    public final void q() {
        try {
            m.d("InnerApiClientImpl", "start transparent activity");
            Intent intent = new Intent();
            intent.setAction("com.huawei.appmarket.intent.coreservice.LAUNCH_APP");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(this.f54294b);
            intent.setFlags(268435456);
            this.f54295c.startActivity(intent);
            n.a(new b(this, 1), 200L);
        } catch (ActivityNotFoundException unused) {
            m.c("InnerApiClientImpl", "transparent activity not found!");
            p();
        }
    }

    public final void r() {
        this.f54298f = false;
        try {
            if (i()) {
                this.f54295c.unbindService(this);
            } else {
                m.d("InnerApiClientImpl", "service does not connected");
            }
            this.f54297e = null;
        } catch (IllegalArgumentException e2) {
            m.c("InnerApiClientImpl", e2.toString());
        }
    }

    public final boolean s() {
        this.f54294b = this.f54300h != null ? b(this.f54295c) : h(this.f54295c);
        if (TextUtils.isEmpty(this.f54294b)) {
            m.c("InnerApiClientImpl", "can not found AppGallery or invalid sign");
            this.f54298f = false;
            ConnectConfig connectConfig = this.f54300h;
            this.f54301i.onConnectionFailed(new w9.b(4, connectConfig != null ? GuideInstallAppGallery.b(this.f54295c, connectConfig, this.f54294b) : GuideInstallAppGallery.a(this.f54295c)));
            return false;
        }
        try {
            if (l.a(this.f54295c.getPackageManager().getPackageInfo(this.f54294b, 128))) {
                return true;
            }
            m.c("InnerApiClientImpl", "unsupport agd");
            this.f54298f = false;
            ConnectConfig connectConfig2 = this.f54300h;
            this.f54301i.onConnectionFailed(new w9.b(7, connectConfig2 != null ? GuideInstallAppGallery.b(this.f54295c, connectConfig2, this.f54294b) : GuideInstallAppGallery.a(this.f54295c)));
            return false;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            m.c("InnerApiClientImpl", "can not found AppGallery");
            this.f54298f = false;
            ConnectConfig connectConfig3 = this.f54300h;
            this.f54301i.onConnectionFailed(new w9.b(4, connectConfig3 != null ? GuideInstallAppGallery.b(this.f54295c, connectConfig3, this.f54294b) : GuideInstallAppGallery.a(this.f54295c)));
            return false;
        }
    }
}
