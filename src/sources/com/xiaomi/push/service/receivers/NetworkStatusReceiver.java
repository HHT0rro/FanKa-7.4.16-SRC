package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.f;
import com.xiaomi.mipush.sdk.h0;
import com.xiaomi.mipush.sdk.o0;
import com.xiaomi.mipush.sdk.z;
import com.xiaomi.push.j0;
import com.xiaomi.push.y5;
import fc.c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kc.u;
import lc.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public boolean f48323a = true;

    /* renamed from: e, reason: collision with root package name */
    public static BlockingQueue<Runnable> f48320e = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    public static int f48317b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f48318c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static int f48319d = 2;

    /* renamed from: f, reason: collision with root package name */
    public static ThreadPoolExecutor f48321f = new ThreadPoolExecutor(f48317b, f48318c, f48319d, TimeUnit.SECONDS, f48320e);

    /* renamed from: g, reason: collision with root package name */
    public static boolean f48322g = false;

    public NetworkStatusReceiver() {
    }

    public NetworkStatusReceiver(Object obj) {
        f48322g = true;
    }

    public static boolean c() {
        return f48322g;
    }

    public final void a(Context context) {
        if (!h0.g(context).E() && o0.c(context).s() && !o0.c(context).w()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                u.e(context).h(intent);
            } catch (Exception e2) {
                c.k(e2);
            }
        }
        y5.h(context);
        if (j0.p(context) && h0.g(context).K()) {
            h0.g(context).M();
        }
        if (j0.p(context)) {
            if ("syncing".equals(z.b(context).c(av.DISABLE_PUSH))) {
                MiPushClient.r(context);
            }
            if ("syncing".equals(z.b(context).c(av.ENABLE_PUSH))) {
                MiPushClient.s(context);
            }
            if ("syncing".equals(z.b(context).c(av.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.i0(context);
            }
            if ("syncing".equals(z.b(context).c(av.UPLOAD_FCM_TOKEN))) {
                MiPushClient.g0(context);
            }
            if ("syncing".equals(z.b(context).c(av.UPLOAD_COS_TOKEN))) {
                MiPushClient.f0(context);
            }
            if ("syncing".equals(z.b(context).c(av.UPLOAD_FTOS_TOKEN))) {
                MiPushClient.h0(context);
            }
            if (f.a() && f.d(context)) {
                f.c(context);
                f.b(context);
            }
            b.a(context);
            e.b(context);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f48323a) {
            return;
        }
        f48321f.execute(new a(this, context));
    }
}
