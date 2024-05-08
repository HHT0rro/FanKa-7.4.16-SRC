package com.tencent.turingface.sdk.mfa;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Window;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class gELYz {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f45799a;

    /* renamed from: b, reason: collision with root package name */
    public static wmqhz f45800b;

    /* renamed from: e, reason: collision with root package name */
    public static WT9z5 f45803e;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<yMdp8> f45801c = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    public static final Set<Ww1Z6> f45802d = new CopyOnWriteArraySet();

    /* renamed from: f, reason: collision with root package name */
    public static boolean f45804f = false;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<String> f45805g = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    public static final spXPg f45806h = new spXPg();

    /* renamed from: i, reason: collision with root package name */
    public static final SkEpO f45807i = new SkEpO();

    /* renamed from: j, reason: collision with root package name */
    public static final ShGzN f45808j = new ShGzN();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ShGzN implements Ww1Z6 {
        @Override // com.tencent.turingface.sdk.mfa.Ww1Z6
        public final void a(String str) {
            Iterator<Ww1Z6> iterator2 = gELYz.f45802d.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(str);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class SkEpO implements hxUS9 {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg extends yLOCn {
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        @Override // com.tencent.turingface.sdk.mfa.yLOCn
        public final void a(Activity activity) {
            if (gELYz.f45805g.contains(activity.getClass().getName()) || gELYz.f45804f) {
                try {
                    SkEpO skEpO = gELYz.f45807i;
                    Window window = activity.getWindow();
                    String name = activity.getClass().getName();
                    Window.Callback callback = window.getCallback();
                    if (callback != null && !(callback instanceof FxCVY)) {
                        window.setCallback(new FxCVY(callback, skEpO, name));
                    }
                    Window window2 = activity.getWindow();
                    window2.getDecorView().getViewTreeObserver().addOnPreDrawListener(new FP21m(window2, activity.getClass().getName(), gELYz.f45808j));
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            gELYz.f45803e.onActivityPaused(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            a(activity);
            gELYz.f45803e.onActivityResumed(activity);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class wmqhz extends Handler {
        public wmqhz(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            if (message.what == 1 && (obj = message.obj) != null && (obj instanceof QmgHg)) {
                QmgHg qmgHg = (QmgHg) obj;
                Iterator<yMdp8> iterator2 = gELYz.f45801c.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().a(qmgHg);
                }
                if (!qmgHg.f45685e) {
                    synchronized (QmgHg.f45683c) {
                        qmgHg.f45686f = 0;
                        qmgHg.f45687g = 0;
                        qmgHg.f45688h = 0;
                        qmgHg.f45689i = 0.0f;
                        qmgHg.f45690j = 0.0f;
                        qmgHg.f45691k = 0.0f;
                        qmgHg.f45692l = 0.0f;
                        qmgHg.f45693m = "";
                        int i10 = QmgHg.f45682b;
                        if (i10 < 20) {
                            qmgHg.f45684d = QmgHg.f45681a;
                            qmgHg.f45685e = true;
                            QmgHg.f45681a = qmgHg;
                            QmgHg.f45682b = i10 + 1;
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Already recycled.");
            }
        }
    }

    public static void a(Context context, WT9z5 wT9z5) {
        f45803e = wT9z5;
        if (f45799a) {
            return;
        }
        f45799a = true;
        synchronized (gELYz.class) {
            HandlerThread handlerThread = new HandlerThread("TuringDispatch");
            handlerThread.start();
            f45800b = new wmqhz(handlerThread.getLooper());
        }
        Application application = (Application) context;
        synchronized (gELYz.class) {
            spXPg spxpg = f45806h;
            application.unregisterActivityLifecycleCallbacks(spxpg);
            application.registerActivityLifecycleCallbacks(spxpg);
        }
    }
}
