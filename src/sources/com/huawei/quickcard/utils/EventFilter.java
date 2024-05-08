package com.huawei.quickcard.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class EventFilter {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f34266a = new Handler(Looper.getMainLooper()) { // from class: com.huawei.quickcard.utils.EventFilter.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            EventFilter.b(message.what);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static Map<Integer, IEventCallback> f34267b = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface IEventCallback {
        void onDo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(int i10) {
        synchronized (EventFilter.class) {
            IEventCallback remove = f34267b.remove(Integer.valueOf(i10));
            if (remove != null) {
                remove.onDo();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        if (com.huawei.quickcard.utils.EventFilter.f34267b.containsKey(java.lang.Integer.valueOf(r2.hashCode())) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void start(java.lang.Object r2, boolean r3, long r4, com.huawei.quickcard.utils.EventFilter.IEventCallback r6) {
        /*
            java.lang.Class<com.huawei.quickcard.utils.EventFilter> r0 = com.huawei.quickcard.utils.EventFilter.class
            monitor-enter(r0)
            if (r2 == 0) goto L3c
            if (r6 != 0) goto L8
            goto L3c
        L8:
            if (r3 != 0) goto L1a
            java.util.Map<java.lang.Integer, com.huawei.quickcard.utils.EventFilter$IEventCallback> r3 = com.huawei.quickcard.utils.EventFilter.f34267b     // Catch: java.lang.Throwable -> L39
            int r1 = r2.hashCode()     // Catch: java.lang.Throwable -> L39
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L39
            boolean r3 = r3.containsKey(r1)     // Catch: java.lang.Throwable -> L39
            if (r3 != 0) goto L37
        L1a:
            java.util.Map<java.lang.Integer, com.huawei.quickcard.utils.EventFilter$IEventCallback> r3 = com.huawei.quickcard.utils.EventFilter.f34267b     // Catch: java.lang.Throwable -> L39
            int r1 = r2.hashCode()     // Catch: java.lang.Throwable -> L39
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L39
            r3.put(r1, r6)     // Catch: java.lang.Throwable -> L39
            android.os.Handler r3 = com.huawei.quickcard.utils.EventFilter.f34266a     // Catch: java.lang.Throwable -> L39
            int r6 = r2.hashCode()     // Catch: java.lang.Throwable -> L39
            r3.removeMessages(r6)     // Catch: java.lang.Throwable -> L39
            int r2 = r2.hashCode()     // Catch: java.lang.Throwable -> L39
            r3.sendEmptyMessageDelayed(r2, r4)     // Catch: java.lang.Throwable -> L39
        L37:
            monitor-exit(r0)
            return
        L39:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L3c:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.utils.EventFilter.start(java.lang.Object, boolean, long, com.huawei.quickcard.utils.EventFilter$IEventCallback):void");
    }
}
