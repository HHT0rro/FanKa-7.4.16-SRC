package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static volatile boolean aFc;
    private static volatile boolean aFd;
    private static Handler WA = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aFe = {"c++_shared", "kscutils", "exception-handler"};
    private static boolean aFf = false;
    private static boolean aFg = false;

    public static boolean Hd() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aFe) {
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable unused) {
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void He() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.HG(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i10, ExceptionMessage exceptionMessage) {
                e.Hu().b(i10, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final File Hp() {
                return new File(com.kwad.sdk.crash.a.a.HE(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    private static synchronized void Hf() {
        synchronized (b.class) {
            if (!aFc) {
                aFc = true;
                com.kwad.sdk.core.threads.a.Fy().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.Hg();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(d.aFI));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Hg() {
        Hh();
        if (aFf) {
            Hi();
        }
        if (aFg) {
            Hj();
        }
    }

    private static void Hh() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.HK().getUploader());
        fVar.C(com.kwad.sdk.crash.a.a.HF());
    }

    private static void Hi() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.C(com.kwad.sdk.crash.a.a.HG());
    }

    private static void Hj() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.C(com.kwad.sdk.crash.a.a.HH());
    }

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || aFd) {
            return;
        }
        aFd = true;
        aFf = cVar.aFf;
        aFg = cVar.aFg;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.a.a.init(cVar.context, cVar.aFt);
            e.Hu().a(cVar);
            bu(cVar.context);
            if (!bt(cVar.context) && (aFf || aFg)) {
                g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                    @Override // com.kwad.sdk.crash.g.a
                    public final void Hn() {
                        b.WA.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.kwad.sdk.core.e.c.w("AdExceptionCollector", "ExceptionSoLoadHelper.init onLoad");
                                if (b.aFf) {
                                    b.He();
                                }
                                if (b.aFg) {
                                    b.c(false, "/sdcard/");
                                }
                            }
                        });
                    }

                    @Override // com.kwad.sdk.crash.g.a
                    public final void Ho() {
                        com.kwad.sdk.core.e.c.w("AdExceptionCollector", "ExceptionSoLoadHelper.init fail");
                    }
                });
            }
            Hf();
        } catch (Throwable unused) {
        }
    }

    private static boolean bt(Context context) {
        return context == null || y.cb(context) >= 3;
    }

    private static void bu(Context context) {
        com.kwad.sdk.crash.handler.c.HK().init(com.kwad.sdk.crash.a.a.HF(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i10, ExceptionMessage exceptionMessage) {
                e.Hu().b(i10, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final File Hp() {
                return new File(com.kwad.sdk.crash.a.a.HE(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z10, String str) {
        if (com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.HH())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.HH(), z10, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.e
                public final File Hp() {
                    return new File(com.kwad.sdk.crash.a.a.HE(), "native_crash_log/upload");
                }

                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    com.kwad.sdk.core.e.c.d("AdExceptionCollector", "Native upload");
                    a(exceptionMessage, 4, countDownLatch);
                }
            });
        }
    }

    public static void n(@NonNull final Throwable th) {
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.o(Throwable.this)) {
                        com.kwad.sdk.crash.handler.a.p(Throwable.this);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.c.printStackTrace(th2);
                }
            }
        });
    }
}
