package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static Map<String, WeakReference<C0529a>> aAu = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0529a {
        private HandlerThread aAv;
        private Handler fS;

        public C0529a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aAv = handlerThread;
            handlerThread.start();
            this.fS = new Handler(this.aAv.getLooper());
        }

        public final Handler getHandler() {
            return this.fS;
        }
    }

    public static synchronized Handler Fy() {
        Handler handler;
        synchronized (a.class) {
            handler = es("commonHT").getHandler();
        }
        return handler;
    }

    public static synchronized Handler Fz() {
        Handler handler;
        synchronized (a.class) {
            handler = es("reportHT").getHandler();
        }
        return handler;
    }

    @NonNull
    private static C0529a es(String str) {
        WeakReference<C0529a> weakReference = aAu.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0529a c0529a = new C0529a(str);
        aAu.put(str, new WeakReference<>(c0529a));
        return c0529a;
    }
}
