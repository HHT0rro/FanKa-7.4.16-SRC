package com.tencent.liteav.audio.earmonitor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a f42654a;

    /* renamed from: b, reason: collision with root package name */
    private final int f42655b;

    private g(a aVar, int i10) {
        this.f42654a = aVar;
        this.f42655b = i10;
    }

    public static Runnable a(a aVar, int i10) {
        return new g(aVar, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f42654a, this.f42655b);
    }
}
