package com.inno.innosdk.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: InnoThreadFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f35497a = new AtomicInteger(10);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f35498b = new AtomicInteger(3);

    /* renamed from: c, reason: collision with root package name */
    public final String f35499c;

    public e(String str) {
        this.f35499c = "innosdk" + f35497a.getAndIncrement() + "-thread-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f35499c + this.f35498b.getAndIncrement());
    }
}
