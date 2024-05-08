package cn.shuzilm.core;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class q implements Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1780a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f1781b;

    public q(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.f1780a = atomicReference;
        this.f1781b = countDownLatch;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(String str) {
        this.f1780a.set(str);
        this.f1781b.countDown();
    }
}
