package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.ip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: f, reason: collision with root package name */
        public static volatile a f47032f;

        /* renamed from: a, reason: collision with root package name */
        public Context f47033a;

        /* renamed from: b, reason: collision with root package name */
        public String f47034b;

        /* renamed from: c, reason: collision with root package name */
        public Boolean f47035c;

        /* renamed from: d, reason: collision with root package name */
        public C0713a f47036d = new C0713a();

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList<hu> f47037e = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.n$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class C0713a {

            /* renamed from: c, reason: collision with root package name */
            public ScheduledFuture<?> f47040c;

            /* renamed from: a, reason: collision with root package name */
            public ScheduledThreadPoolExecutor f47038a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: b, reason: collision with root package name */
            public final ArrayList<hu> f47039b = new ArrayList<>();

            /* renamed from: d, reason: collision with root package name */
            public final Runnable f47041d = new w(this);

            public C0713a() {
            }

            public final void c() {
                if (this.f47040c == null) {
                    this.f47040c = this.f47038a.scheduleAtFixedRate(this.f47041d, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            public void e(hu huVar) {
                this.f47038a.execute(new v(this, huVar));
            }

            public final void f() {
                hu remove = this.f47039b.remove(0);
                for (ip ipVar : kc.z.b(Arrays.asList(remove), a.this.f47033a.getPackageName(), o0.c(a.this.f47033a).d(), 30720)) {
                    fc.c.m("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    h0.g(a.this.f47033a).v(ipVar, hq.Notification, true, null);
                }
            }
        }

        public static a b() {
            if (f47032f == null) {
                synchronized (a.class) {
                    if (f47032f == null) {
                        f47032f = new a();
                    }
                }
            }
            return f47032f;
        }

        public void c(Context context) {
            if (context == null) {
                fc.c.i("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f47033a = context;
            this.f47035c = Boolean.valueOf(f(context));
            h("com.xiaomi.xmpushsdk.tinydataPending.init");
        }

        public final void d(hu huVar) {
            synchronized (this.f47037e) {
                if (!this.f47037e.contains(huVar)) {
                    this.f47037e.add(huVar);
                    if (this.f47037e.size() > 100) {
                        this.f47037e.remove(0);
                    }
                }
            }
        }

        public boolean e() {
            return this.f47033a != null;
        }

        public final boolean f(Context context) {
            if (!h0.g(context).E()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a3, code lost:
        
            r0 = "MiTinyDataClient Pending " + r6.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel";
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized boolean g(com.xiaomi.push.hu r6) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.n.a.g(com.xiaomi.push.hu):boolean");
        }

        public void h(String str) {
            fc.c.m("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f47037e) {
                arrayList.addAll(this.f47037e);
                this.f47037e.clear();
            }
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                g((hu) iterator2.next());
            }
        }

        public final boolean i(Context context) {
            return o0.c(context).d() == null && !f(this.f47033a);
        }

        public final boolean j(hu huVar) {
            if (kc.z.d(huVar, false)) {
                return false;
            }
            if (!this.f47035c.booleanValue()) {
                this.f47036d.e(huVar);
                return true;
            }
            fc.c.m("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + huVar.d());
            h0.g(this.f47033a).q(huVar);
            return true;
        }
    }

    public static boolean a(Context context, hu huVar) {
        fc.c.m("MiTinyDataClient.upload " + huVar.d());
        if (!a.b().e()) {
            a.b().c(context);
        }
        return a.b().g(huVar);
    }

    public static boolean b(String str, String str2, long j10, String str3) {
        hu huVar = new hu();
        huVar.d(str);
        huVar.c(str2);
        huVar.a(j10);
        huVar.b(str3);
        return a.b().g(huVar);
    }
}
