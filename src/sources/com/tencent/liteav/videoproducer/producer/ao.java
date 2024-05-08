package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ao implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44941a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44942b;

    private ao(i iVar, boolean z10) {
        this.f44941a = iVar;
        this.f44942b = z10;
    }

    public static Runnable a(i iVar, boolean z10) {
        return new ao(iVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44941a, this.f44942b);
    }
}
