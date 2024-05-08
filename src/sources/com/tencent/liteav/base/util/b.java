package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f42875a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f42876b;

    private b(Runnable runnable, CountDownLatch countDownLatch) {
        this.f42875a = runnable;
        this.f42876b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new b(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomHandler.lambda$runAndWaitDone$0(this.f42875a, this.f42876b);
    }
}
