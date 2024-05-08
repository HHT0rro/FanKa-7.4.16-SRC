package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ao implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ak f44308a;

    private ao(ak akVar) {
        this.f44308a = akVar;
    }

    public static Runnable a(ak akVar) {
        return new ao(akVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak.c(this.f44308a);
    }
}
