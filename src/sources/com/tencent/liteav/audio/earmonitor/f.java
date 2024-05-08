package com.tencent.liteav.audio.earmonitor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a f42652a;

    /* renamed from: b, reason: collision with root package name */
    private final int f42653b;

    private f(a aVar, int i10) {
        this.f42652a = aVar;
        this.f42653b = i10;
    }

    public static Runnable a(a aVar, int i10) {
        return new f(aVar, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.b(this.f42652a, this.f42653b);
    }
}
