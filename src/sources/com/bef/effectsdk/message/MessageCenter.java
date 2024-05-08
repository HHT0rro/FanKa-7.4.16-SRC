package com.bef.effectsdk.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

@h0.a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MessageCenter {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f10517a;

    /* renamed from: b, reason: collision with root package name */
    public static HandlerThread f10518b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f10519c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final List<a> f10520d = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void onMessageReceived(int i10, int i11, int i12, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MessageCenter.d(message);
        }
    }

    public static void b(a aVar) {
        List<a> list = f10520d;
        synchronized (list) {
            if (list.isEmpty()) {
                e();
            }
            list.add(aVar);
        }
    }

    public static void c() {
        List<a> list = f10520d;
        synchronized (list) {
            if (list.isEmpty()) {
                synchronized (f10519c) {
                    Handler handler = f10517a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        f10517a = null;
                    }
                    HandlerThread handlerThread = f10518b;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        f10518b = null;
                    }
                }
                list.clear();
            }
        }
    }

    public static void d(Message message) {
        int size;
        a[] aVarArr;
        List<a> list = f10520d;
        synchronized (list) {
            size = list.size();
            aVarArr = new a[size];
            list.toArray(aVarArr);
        }
        if (size <= 0) {
            return;
        }
        for (int i10 = 0; i10 < size; i10++) {
            aVarArr[i10].onMessageReceived(message.what, message.arg1, message.arg2, (String) message.obj);
        }
    }

    public static void e() {
        synchronized (f10519c) {
            HandlerThread handlerThread = f10518b;
            if (handlerThread == null || !handlerThread.isAlive() || f10518b.getLooper() == null) {
                HandlerThread handlerThread2 = new HandlerThread("MessageCenter");
                f10518b = handlerThread2;
                handlerThread2.start();
                f10517a = new b(f10518b.getLooper());
            }
        }
    }

    public static void f(a aVar) {
        List<a> list = f10520d;
        synchronized (list) {
            list.remove(aVar);
            if (list.isEmpty()) {
                c();
            }
        }
    }

    public static void g(a aVar) {
        synchronized (f10520d) {
            b(aVar);
        }
    }

    @h0.a
    private static void postMessage(int i10, int i11, int i12, String str) {
        synchronized (f10519c) {
            Handler handler = f10517a;
            if (handler == null) {
                return;
            }
            Message.obtain(handler, i10, i11, i12, str).sendToTarget();
        }
    }
}
