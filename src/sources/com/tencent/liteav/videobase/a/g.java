package com.tencent.liteav.videobase.a;

import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f43258a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f43259b;

    private g(Runnable runnable, CountDownLatch countDownLatch) {
        this.f43258a = runnable;
        this.f43259b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new g(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.lambda$runOnDrawAndWaitDone$4(this.f43258a, this.f43259b);
    }
}
