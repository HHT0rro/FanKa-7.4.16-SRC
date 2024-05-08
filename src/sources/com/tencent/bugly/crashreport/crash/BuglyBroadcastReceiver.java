package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static BuglyBroadcastReceiver f39153d;

    /* renamed from: b, reason: collision with root package name */
    private Context f39155b;

    /* renamed from: c, reason: collision with root package name */
    private String f39156c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f39157e = true;

    /* renamed from: a, reason: collision with root package name */
    private IntentFilter f39154a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f39153d == null) {
                f39153d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f39153d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f39154a.hasAction(str)) {
            this.f39154a.addAction(str);
        }
        x.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f39155b = context;
        z.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.a(BuglyBroadcastReceiver.f39153d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f39155b.registerReceiver(BuglyBroadcastReceiver.f39153d, BuglyBroadcastReceiver.this.f39154a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f39155b = context;
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f39157e) {
                    this.f39157e = false;
                    return true;
                }
                String b4 = com.tencent.bugly.crashreport.common.info.b.b(this.f39155b);
                x.c("is Connect BC " + b4, new Object[0]);
                x.a("network %s changed to %s", this.f39156c, b4);
                if (b4 == null) {
                    this.f39156c = null;
                    return true;
                }
                String str = this.f39156c;
                this.f39156c = b4;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a a10 = com.tencent.bugly.crashreport.common.strategy.a.a();
                u a11 = u.a();
                com.tencent.bugly.crashreport.common.info.a a12 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a10 != null && a11 != null && a12 != null) {
                    if (!b4.equals(str) && currentTimeMillis - a11.a(c.f39237a) > 30000) {
                        x.a("try to upload crash on network changed.", new Object[0]);
                        c a13 = c.a();
                        if (a13 != null) {
                            a13.a(0L);
                        }
                        x.a("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.b.f39069a.b();
                    }
                    return true;
                }
                x.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
