package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.ext.c;
import com.kwad.sdk.utils.bn;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {
    private static volatile i ajl;
    private static Set<String> ajn = new HashSet();

    @Nullable
    private static a ajo;
    private e ajm;
    private volatile boolean mHasInit = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void b(String str, File file);

        void d(String str, Throwable th);

        int getCorePoolSize();

        int getMaxRetryCount();

        boolean xh();
    }

    private i() {
    }

    private static ExecutorService bN(int i10) {
        return new ThreadPoolExecutor(i10, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                try {
                    i.ajn.add(thread.getName());
                } catch (Throwable th) {
                    com.kwad.library.solder.lib.a.e("Sodler", Log.getStackTraceString(th));
                }
                return thread;
            }
        });
    }

    private synchronized void init(Context context) {
        if (this.mHasInit) {
            return;
        }
        c.a bP = new c.a().bP("sodler");
        a aVar = ajo;
        c.a bh = bP.bQ(aVar != null ? aVar.getMaxRetryCount() : 1).bh(false);
        a aVar2 = ajo;
        c.a bi = bh.bi(aVar2 != null && aVar2.xh());
        a aVar3 = ajo;
        c.a a10 = bi.a(bN(aVar3 != null ? aVar3.getCorePoolSize() : 0));
        a aVar4 = ajo;
        com.kwad.library.solder.lib.ext.c xJ = a10.bR(aVar4 != null ? aVar4.getCorePoolSize() : 0).xJ();
        d dVar = new d(context);
        c cVar = new c(context, xJ);
        f fVar = new f(context);
        fVar.a(new f.a() { // from class: com.kwad.library.solder.lib.i.2
            @Override // com.kwad.library.solder.lib.a.f.a
            public final void a(com.kwad.library.solder.lib.a.e eVar, File file) {
                if (i.ajo != null) {
                    try {
                        i.ajo.b(eVar.getDownloadUrl(), file);
                    } catch (Throwable th) {
                        i.ajo.d(eVar.getDownloadUrl(), th);
                        throw new PluginError.UpdateError(th.getMessage(), 2010);
                    }
                }
            }
        });
        this.ajm = new e(dVar, fVar, cVar, xJ, new com.kwad.library.solder.lib.ext.a());
        this.mHasInit = true;
    }

    public static i xe() {
        if (ajl == null) {
            synchronized (i.class) {
                if (ajl == null) {
                    ajl = new i();
                }
            }
        }
        return ajl;
    }

    public final void j(Context context, final String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (wY() == null || wY().xI() == null) {
            return;
        }
        wY().xI().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    i.this.ajm.xb().bE(str);
                } catch (Throwable th) {
                    Log.getStackTraceString(th);
                }
            }
        });
    }

    @Nullable
    public final com.kwad.library.solder.lib.a.a k(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        e eVar = this.ajm;
        if (eVar != null) {
            return eVar.wZ().bG(str);
        }
        return null;
    }

    public final com.kwad.library.solder.lib.ext.c wY() {
        if (this.mHasInit) {
            return this.ajm.wY();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public static void a(a aVar) {
        ajo = aVar;
    }

    public final <P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> void a(Context context, @NonNull R r10, com.kwad.library.solder.lib.ext.b<P, R> bVar) {
        init(context);
        r10.bP(this.ajm.wY().getRetryCount());
        r10.a(new b<P, R>(bVar, new b.C0507b()) { // from class: com.kwad.library.solder.lib.i.3
            /* JADX WARN: Incorrect types in method signature: (TR;Lcom/kwad/library/solder/lib/ext/PluginError;)V */
            @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b
            public final void a(final com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                super.a((AnonymousClass3<P, R>) eVar, pluginError);
                com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + u.bD + pluginError.getMessage());
                i.this.ajm.i(eVar);
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (eVar.xo()) {
                            i.this.ajm.a(eVar, 16);
                        }
                    }
                }, eVar.xn() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        });
        this.ajm.a(r10, 16);
    }
}
