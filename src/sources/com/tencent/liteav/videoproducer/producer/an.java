package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class an implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44939a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44940b;

    private an(i iVar, boolean z10) {
        this.f44939a = iVar;
        this.f44940b = z10;
    }

    public static Runnable a(i iVar, boolean z10) {
        return new an(iVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b(this.f44939a, this.f44940b);
    }
}
