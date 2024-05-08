package com.inno.innosdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.quickcard.base.Attributes;
import com.inno.innosdk.bean.FcDeviceInfo;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: ActivityLifeListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Boolean> f35557a;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference<Activity> f35558b;

    /* renamed from: c, reason: collision with root package name */
    public static long f35559c = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f35560d = false;

    /* renamed from: e, reason: collision with root package name */
    public static int f35561e;

    /* renamed from: f, reason: collision with root package name */
    public int f35562f;

    public static void a() {
        try {
            int i10 = f35561e;
            if (i10 > 20) {
                return;
            }
            f35561e = i10 + 1;
            if (com.inno.innosdk.b.b.f35505d == -1) {
                com.inno.innosdk.b.b.a(com.inno.innosdk.a.c.m(), "error");
            }
            String b4 = q.b(com.inno.innosdk.a.c.k(), "inno_isupimei", "0");
            if (com.inno.innosdk.b.b.f35509h == 0 && "0".equals(b4) && com.inno.innosdk.a.c.m() != null && !TextUtils.isEmpty(com.inno.innosdk.a.c.m().imei)) {
                com.inno.innosdk.b.b.a(com.inno.innosdk.a.c.m(), "upimei");
            }
            if (com.inno.innosdk.b.b.f35510i <= 0 || System.currentTimeMillis() - com.inno.innosdk.b.b.f35511j <= com.inno.innosdk.b.b.f35510i) {
                return;
            }
            try {
                if (System.currentTimeMillis() - Long.parseLong(q.b(com.inno.innosdk.a.c.k(), "inno_YKsuccessTime", "0")) > com.inno.innosdk.b.b.f35510i) {
                    com.inno.innosdk.b.b.a(new FcDeviceInfo("heart"));
                }
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        } catch (Throwable th2) {
            com.inno.innosdk.utils.u.a.a(th2);
        }
    }

    private void b() {
        try {
            if (c()) {
                return;
            }
            try {
                m mVar = m.f35618d;
                if (mVar != null) {
                    mVar.f();
                }
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
            if (f35559c == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.inno.innosdk.b.a.a(currentTimeMillis);
            com.inno.innosdk.b.a.b((currentTimeMillis - f35559c) / 1000);
            f35559c = 0L;
            f35560d = false;
        } catch (Throwable th2) {
            com.inno.innosdk.utils.u.a.a(th2);
        }
    }

    private boolean c() {
        return this.f35562f > 0;
    }

    public void d() {
        try {
            if (f35560d) {
                return;
            }
            f35560d = true;
            long g3 = com.inno.innosdk.b.a.g();
            com.inno.innosdk.b.a.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (f35559c == 0) {
                f35559c = currentTimeMillis;
            }
            if (currentTimeMillis - 30000 <= g3 || g3 == 0) {
                return;
            }
            com.inno.innosdk.b.a.b();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        com.inno.innosdk.utils.u.a.a((Object) "activity created");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            if (activity == com.inno.innosdk.a.c.k()) {
                NetworkConnectChangedReceiver.a();
                com.inno.innosdk.a.c.x();
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            a();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            try {
                if (!AppInfomation.l(activity).contains("push") && c()) {
                    if (!com.inno.innosdk.b.b.f35512k && System.currentTimeMillis() - com.inno.innosdk.a.c.f35486n > 10000) {
                        com.inno.innosdk.b.b.a(com.inno.innosdk.a.c.m(), Attributes.LayoutDirection.AUTO);
                    }
                    String b4 = com.inno.innosdk.utils.v.a.a(com.inno.innosdk.a.c.k()).b();
                    if (!com.inno.innosdk.b.b.f35513l && !TextUtils.isEmpty(b4)) {
                        com.inno.innosdk.b.b.a(com.inno.innosdk.a.c.m(), "abs");
                    }
                    try {
                        m.b(com.inno.innosdk.a.c.k());
                        if (com.inno.innosdk.a.c.m() != null && AppInfomation.d(com.inno.innosdk.a.c.m().cid)) {
                            com.inno.innosdk.a.c.m().isvir2 = "1";
                        }
                    } catch (Throwable th) {
                        com.inno.innosdk.utils.u.a.a(th);
                    }
                }
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
            }
            try {
                f35558b = new WeakReference<>(activity);
            } catch (Throwable th3) {
                com.inno.innosdk.utils.u.a.a(th3);
            }
            a();
            d();
        } catch (Throwable th4) {
            com.inno.innosdk.utils.u.a.a(th4);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f35562f++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f35562f--;
        b();
    }
}
