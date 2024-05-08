package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class l implements ab {

    /* renamed from: b, reason: collision with root package name */
    private static l f4241b;

    /* renamed from: i, reason: collision with root package name */
    private static final ThreadFactory f4242i = new n();

    /* renamed from: a, reason: collision with root package name */
    public Context f4243a;

    /* renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f4244c;

    /* renamed from: d, reason: collision with root package name */
    private b f4245d = b.a("android");

    /* renamed from: e, reason: collision with root package name */
    private long f4246e;

    /* renamed from: f, reason: collision with root package name */
    private long f4247f;

    /* renamed from: g, reason: collision with root package name */
    private long f4248g;

    /* renamed from: h, reason: collision with root package name */
    private int f4249h;

    private l(Context context) {
        this.f4243a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f4242i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f4244c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f4243a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        l lVar = f4241b;
        return lVar != null ? lVar : b(context);
    }

    private static final synchronized l b(Context context) {
        synchronized (l.class) {
            l lVar = f4241b;
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l(context);
            f4241b = lVar2;
            return lVar2;
        }
    }

    public final b a() {
        return this.f4245d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f4243a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f4244c.getActiveCount());
            objArr[1] = Long.valueOf(this.f4244c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f4244c.getTaskCount());
            long j10 = this.f4248g;
            objArr[3] = Long.valueOf(j10 == 0 ? 0L : ((this.f4246e * 1000) / j10) >> 10);
            int i10 = this.f4249h;
            objArr[4] = Long.valueOf(i10 != 0 ? this.f4247f / i10 : 0L);
            objArr[5] = Long.valueOf(this.f4246e);
            objArr[6] = Long.valueOf(this.f4247f);
            objArr[7] = Long.valueOf(this.f4248g);
            objArr[8] = Integer.valueOf(this.f4249h);
            String.format(str, objArr);
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f4244c.execute(mVar);
        return mVar;
    }

    public final void a(long j10) {
        this.f4246e += j10;
    }

    public final void b(long j10) {
        this.f4247f += j10;
        this.f4249h++;
    }

    public final void c(long j10) {
        this.f4248g += j10;
    }
}
