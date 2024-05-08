package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f10696e;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f10697a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f10698b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Runnable> f10699c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, Runnable> f10700d = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (f10696e == null) {
            synchronized (b.class) {
                if (f10696e == null) {
                    f10696e = new b();
                }
            }
        }
        return f10696e;
    }
}
