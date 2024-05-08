package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.jc;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jd extends jf {

    /* renamed from: c, reason: collision with root package name */
    private static jd f6553c = new jd(new jc.a().a("amap-global-threadPool").b());

    private jd(jc jcVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(jcVar.a(), jcVar.b(), jcVar.d(), TimeUnit.SECONDS, jcVar.c(), jcVar);
            this.f6555a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            gy.b(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static jd a() {
        return f6553c;
    }

    @Deprecated
    public static synchronized jd b() {
        jd jdVar;
        synchronized (jd.class) {
            if (f6553c == null) {
                f6553c = new jd(new jc.a().b());
            }
            jdVar = f6553c;
        }
        return jdVar;
    }

    @Deprecated
    public static jd c() {
        return new jd(new jc.a().b());
    }

    public static jd a(jc jcVar) {
        return new jd(jcVar);
    }
}
