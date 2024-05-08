package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44056a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44057b;

    private ac(t tVar, boolean z10) {
        this.f44056a = tVar;
        this.f44057b = z10;
    }

    public static Runnable a(t tVar, boolean z10) {
        return new ac(tVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.c(this.f44056a, this.f44057b);
    }
}
