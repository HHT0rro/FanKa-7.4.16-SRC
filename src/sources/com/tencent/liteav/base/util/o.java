package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f42905a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f42906b;

    private o(Runnable runnable, CountDownLatch countDownLatch) {
        this.f42905a = runnable;
        this.f42906b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new o(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f42905a;
        CountDownLatch countDownLatch = this.f42906b;
        runnable.run();
        countDownLatch.countDown();
    }
}
