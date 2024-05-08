package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videoconsumer.consumer.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43758a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f43759b;

    private r(b bVar, Runnable runnable) {
        this.f43758a = bVar;
        this.f43759b = runnable;
    }

    public static Runnable a(b bVar, Runnable runnable) {
        return new r(bVar, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43758a;
        Runnable runnable = this.f43759b;
        if (bVar.f43710s != b.EnumC0643b.STOPPED) {
            runnable.run();
        } else {
            bVar.f43706o.a(runnable);
        }
    }
}
