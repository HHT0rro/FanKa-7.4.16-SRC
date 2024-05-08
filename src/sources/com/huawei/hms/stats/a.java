package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AnalyticsCacheManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final a f31809f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Object f31810a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f31811b = false;

    /* renamed from: c, reason: collision with root package name */
    private final List<Runnable> f31812c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f31813d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f31814e = new RunnableC0326a();

    /* compiled from: AnalyticsCacheManager.java */
    /* renamed from: com.huawei.hms.stats.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class RunnableC0326a implements Runnable {
        public RunnableC0326a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (!HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.a();
            } else {
                a.this.b();
            }
        }
    }

    private a() {
    }

    public static a c() {
        return f31809f;
    }

    public void a(Runnable runnable) {
        synchronized (this.f31810a) {
            if (runnable == null) {
                return;
            }
            if (this.f31811b) {
                return;
            }
            if (this.f31812c.size() >= 60) {
                return;
            }
            this.f31812c.add(runnable);
            this.f31813d.removeCallbacks(this.f31814e);
            this.f31813d.postDelayed(this.f31814e, 10000L);
        }
    }

    public void b() {
        synchronized (this.f31810a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f31812c.size());
            this.f31811b = true;
            try {
                Iterator<Runnable> iterator2 = this.f31812c.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().run();
                    iterator2.remove();
                }
            } catch (Throwable th) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());
                a();
            }
            this.f31811b = false;
        }
    }

    public void a() {
        synchronized (this.f31810a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f31812c.clear();
        }
    }
}
