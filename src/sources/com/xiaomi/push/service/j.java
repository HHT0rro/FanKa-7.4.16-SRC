package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.l7;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j implements kc.e {

    /* renamed from: f, reason: collision with root package name */
    public static volatile j f48294f;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f48295a;

    /* renamed from: b, reason: collision with root package name */
    public long f48296b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f48297c = false;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<String, a> f48298d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public Context f48299e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public String f48300b;

        /* renamed from: c, reason: collision with root package name */
        public long f48301c;

        public a(String str, long j10) {
            this.f48300b = str;
            this.f48301c = j10;
        }

        public abstract void a(j jVar);

        @Override // java.lang.Runnable
        public void run() {
            if (j.f48294f != null) {
                Context context = j.f48294f.f48299e;
                if (com.xiaomi.push.j0.q(context)) {
                    if (System.currentTimeMillis() - j.f48294f.f48295a.getLong(":ts-" + this.f48300b, 0L) > this.f48301c || com.xiaomi.push.k.b(context)) {
                        l7.a(j.f48294f.f48295a.edit().putLong(":ts-" + this.f48300b, System.currentTimeMillis()));
                        a(j.f48294f);
                    }
                }
            }
        }
    }

    public j(Context context) {
        this.f48299e = context.getApplicationContext();
        this.f48295a = context.getSharedPreferences("sync", 0);
    }

    public static j c(Context context) {
        if (f48294f == null) {
            synchronized (j.class) {
                if (f48294f == null) {
                    f48294f = new j(context);
                }
            }
        }
        return f48294f;
    }

    @Override // kc.e
    public void a() {
        if (this.f48297c) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f48296b < 3600000) {
            return;
        }
        this.f48296b = currentTimeMillis;
        this.f48297c = true;
        com.xiaomi.push.n.c(this.f48299e).h(new k(this), (int) (Math.random() * 10.0d));
    }

    public String d(String str, String str2) {
        return this.f48295a.getString(str + com.huawei.openalliance.ad.constant.u.bD + str2, "");
    }

    public void f(a aVar) {
        if (this.f48298d.putIfAbsent(aVar.f48300b, aVar) == null) {
            com.xiaomi.push.n.c(this.f48299e).h(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void g(String str, String str2, String str3) {
        l7.a(f48294f.f48295a.edit().putString(str + com.huawei.openalliance.ad.constant.u.bD + str2, str3));
    }
}
