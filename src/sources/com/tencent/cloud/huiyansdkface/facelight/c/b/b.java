package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.os.Handler;
import android.os.Looper;
import com.tencent.cloud.huiyansdkface.facelight.common.WbThreadFactory;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40614a = "com.tencent.cloud.huiyansdkface.facelight.c.b.b";

    /* renamed from: b, reason: collision with root package name */
    private static Handler f40615b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private static ExecutorService f40616c = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfFaceDetect"));

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a<T> {
        void a(T t2);
    }

    public static void a(Runnable runnable) {
        f40616c.submit(runnable);
    }

    public static <T> void a(final Callable<T> callable, final a<T> aVar) {
        if (f40616c.isShutdown()) {
            WLogger.w(f40614a, "already shutDown!");
        } else {
            f40616c.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    final Object obj;
                    try {
                        obj = Callable.this.call();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        obj = null;
                    }
                    b.f40615b.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                try {
                                    aVar2.a(obj);
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                    });
                }
            });
        }
    }
}
