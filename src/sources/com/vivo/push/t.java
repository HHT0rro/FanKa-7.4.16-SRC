package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: PushClientThread.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f46372a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private static final HandlerThread f46373b;

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f46374c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f46373b = handlerThread;
        handlerThread.start();
        f46374c = new u(handlerThread.getLooper());
    }

    public static void a(s sVar) {
        if (sVar == null) {
            com.vivo.push.util.u.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a10 = sVar.a();
        Message message = new Message();
        message.what = a10;
        message.obj = sVar;
        f46374c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f46372a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f46374c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = f46374c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 15000L);
    }
}
