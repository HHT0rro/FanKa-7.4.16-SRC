package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f42903a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f42904b;

    private n(Runnable runnable, CountDownLatch countDownLatch) {
        this.f42903a = runnable;
        this.f42904b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new n(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f42903a;
        CountDownLatch countDownLatch = this.f42904b;
        runnable.run();
        countDownLatch.countDown();
    }
}
