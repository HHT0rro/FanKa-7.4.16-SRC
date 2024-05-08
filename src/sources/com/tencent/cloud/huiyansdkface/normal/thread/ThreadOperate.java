package com.tencent.cloud.huiyansdkface.normal.thread;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ThreadOperate {
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static ExecutorService mExecutorService = Executors.newFixedThreadPool(3);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface UiThreadCallback<T> {
        void callback(T t2);
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static <T> Future<T> runOnSubThread(final Callable<T> callable) {
        return mExecutorService.submit(new Callable<T>() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.2
            @Override // java.util.concurrent.Callable
            public T call() {
                try {
                    return (T) Callable.this.call();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        });
    }

    public static void runOnSubThread(final Runnable runnable) {
        mExecutorService.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.1
            @Override // java.lang.Runnable
            public void run() {
                Runnable.this.run();
            }
        });
    }

    public static <T> void runOnSubThread(final Callable<T> callable, final UiThreadCallback<T> uiThreadCallback) {
        mExecutorService.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.3
            @Override // java.lang.Runnable
            public void run() {
                final Object obj;
                try {
                    obj = Callable.this.call();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    obj = null;
                }
                ThreadOperate.mHandler.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UiThreadCallback uiThreadCallback2 = uiThreadCallback;
                        if (uiThreadCallback2 != null) {
                            try {
                                uiThreadCallback2.callback(obj);
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    public static void runOnUiThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            mHandler.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j10) {
        mHandler.postDelayed(runnable, j10);
    }
}
