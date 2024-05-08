package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class f10674a;

    /* renamed from: b, reason: collision with root package name */
    private static Object f10675b;

    public static final Object a() {
        if (f10675b == null) {
            try {
                synchronized (a.class) {
                    if (f10675b == null) {
                        if (f10674a == null) {
                            f10674a = Class.forName("android.app.ActivityThread");
                        }
                        f10675b = MethodUtils.invokeStaticMethod(f10674a, "currentActivityThread", new Object[0]);
                    }
                    if (f10675b == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.d.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    try {
                                        Object unused = a.f10675b = MethodUtils.invokeStaticMethod(a.f10674a, "currentActivityThread", new Object[0]);
                                        synchronized (Object.this) {
                                            Object.this.notify();
                                        }
                                    } catch (Exception e2) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e2);
                                        synchronized (Object.this) {
                                            Object.this.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (Object.this) {
                                        Object.this.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (f10675b == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e2) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e2);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e10);
            }
        }
        return f10675b;
    }
}
