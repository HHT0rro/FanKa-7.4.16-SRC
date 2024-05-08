package com.tencent.bugly.idasc.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aq extends BroadcastReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static aq f39603d;

    /* renamed from: b, reason: collision with root package name */
    private Context f39605b;

    /* renamed from: c, reason: collision with root package name */
    private String f39606c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f39607e = true;

    /* renamed from: a, reason: collision with root package name */
    private IntentFilter f39604a = new IntentFilter();

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            if (f39603d == null) {
                f39603d = new aq();
            }
            aqVar = f39603d;
        }
        return aqVar;
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f39607e) {
                    this.f39607e = false;
                    return true;
                }
                String c4 = ab.c(this.f39605b);
                al.c("is Connect BC ".concat(String.valueOf(c4)), new Object[0]);
                al.a("network %s changed to %s", this.f39606c, String.valueOf(c4));
                if (c4 == null) {
                    this.f39606c = null;
                    return true;
                }
                String str = this.f39606c;
                this.f39606c = c4;
                long currentTimeMillis = System.currentTimeMillis();
                ac a10 = ac.a();
                ai a11 = ai.a();
                aa a12 = aa.a(context);
                if (a10 != null && a11 != null && a12 != null) {
                    if (!c4.equals(str) && currentTimeMillis - a11.a(at.f39633a) > 30000) {
                        al.a("try to upload crash on network changed.", new Object[0]);
                        at a13 = at.a();
                        if (a13 != null) {
                            a13.a(0L);
                        }
                        al.a("try to upload userinfo on network changed.", new Object[0]);
                        s.f39927b.b();
                    }
                    return true;
                }
                al.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }

    public final synchronized void a(Context context) {
        this.f39605b = context;
        ap.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.aq.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    al.a(aq.f39603d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        aq.this.f39605b.registerReceiver(aq.f39603d, aq.this.f39604a, "com.tencent.bugly.idasc.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final synchronized void a(String str) {
        if (!this.f39604a.hasAction(str)) {
            this.f39604a.addAction(str);
        }
        al.c("add action %s", str);
    }

    public final synchronized void b(Context context) {
        try {
            al.a(aq.class, "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f39605b = context;
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
