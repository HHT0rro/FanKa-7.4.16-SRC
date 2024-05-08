package com.huawei.appgallery.agd.common.gcd;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class QueueThreadFactory implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f27355b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    public String f27356c;

    public QueueThreadFactory(String str) {
        this.f27356c = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f27356c + "#" + this.f27355b.incrementAndGet());
    }
}
