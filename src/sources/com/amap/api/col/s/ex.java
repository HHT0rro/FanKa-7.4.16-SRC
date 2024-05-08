package com.amap.api.col.s;

import com.amap.api.col.s.ew;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ex extends ez {

    /* renamed from: c, reason: collision with root package name */
    private static ex f7963c = new ex(new ew.a().a("amap-global-threadPool").a());

    private ex(ew ewVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(ewVar.a(), ewVar.b(), ewVar.d(), TimeUnit.SECONDS, ewVar.c(), ewVar);
            this.f7965a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            df.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static ex a() {
        return f7963c;
    }
}
