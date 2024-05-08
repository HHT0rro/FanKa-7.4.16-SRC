package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.os.Handler;
import android.os.Looper;
import com.tencent.cloud.huiyansdkface.facelight.common.WbThreadFactory;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40629a = "com.tencent.cloud.huiyansdkface.facelight.c.b.d";

    /* renamed from: b, reason: collision with root package name */
    private Handler f40630b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f40631c = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfSub"));

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a<T> {
        void a(T t2);
    }

    public <T> void a(final Callable<T> callable, final a<T> aVar) {
        if (this.f40631c.isShutdown()) {
            WLogger.w(f40629a, "already shutDown!");
        } else {
            this.f40631c.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.d.1
                @Override // java.lang.Runnable
                public void run() {
                    final Object obj;
                    try {
                        obj = callable.call();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        obj = null;
                    }
                    d.this.f40630b.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.b.d.1.1
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
