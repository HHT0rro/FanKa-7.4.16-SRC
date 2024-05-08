package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f42877a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f42878b;

    private c(Runnable runnable, CountDownLatch countDownLatch) {
        this.f42877a = runnable;
        this.f42878b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new c(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomHandler.lambda$runAndWaitDone$1(this.f42877a, this.f42878b);
    }
}
