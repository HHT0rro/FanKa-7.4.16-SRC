package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final k f44117a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44118b;

    private n(k kVar, boolean z10) {
        this.f44117a = kVar;
        this.f44118b = z10;
    }

    public static Runnable a(k kVar, boolean z10) {
        return new n(kVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.a(this.f44117a, this.f44118b);
    }
}
