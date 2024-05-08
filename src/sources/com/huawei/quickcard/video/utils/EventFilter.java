package com.huawei.quickcard.video.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class EventFilter {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f34360a = new a(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private static Map<Integer, WeakReference<IEventCallback>> f34361b = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IEventCallback {
        void onDo();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            EventFilter.b(message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(int i10) {
        synchronized (EventFilter.class) {
            WeakReference<IEventCallback> remove = f34361b.remove(Integer.valueOf(i10));
            if (remove == null) {
                return;
            }
            IEventCallback iEventCallback = remove.get();
            if (iEventCallback != null) {
                iEventCallback.onDo();
            }
        }
    }

    public static synchronized void a(Object obj, long j10, IEventCallback iEventCallback) {
        synchronized (EventFilter.class) {
            if (obj == null || iEventCallback == null) {
                return;
            }
            int hashCode = obj.hashCode();
            if (!f34361b.containsKey(Integer.valueOf(hashCode))) {
                f34361b.put(Integer.valueOf(hashCode), new WeakReference<>(iEventCallback));
                Handler handler = f34360a;
                handler.removeMessages(hashCode);
                handler.sendEmptyMessageDelayed(hashCode, j10);
            }
        }
    }
}
