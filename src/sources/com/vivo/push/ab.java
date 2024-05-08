package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Worker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class ab {

    /* renamed from: a, reason: collision with root package name */
    public Context f46074a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f46075b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f46076c = new Object();

    /* compiled from: Worker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ab.this.b(message);
        }
    }

    public ab() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f46075b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f46074a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f46076c) {
            Handler handler = this.f46075b;
            if (handler == null) {
                String str = "Dead worker dropping a message: " + message.what;
                com.vivo.push.util.u.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                handler.sendMessage(message);
            }
        }
    }
}
