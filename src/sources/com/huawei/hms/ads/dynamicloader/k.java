package com.huawei.hms.ads.dynamicloader;

import com.huawei.hms.ads.uiengineloader.aa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29170a = "SafeRunnable";

    /* renamed from: b, reason: collision with root package name */
    private Runnable f29171b;

    public k(Runnable runnable) {
        this.f29171b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f29171b;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                aa.d(f29170a, "exception in task run: " + th.getClass().getSimpleName());
            }
        }
    }
}
