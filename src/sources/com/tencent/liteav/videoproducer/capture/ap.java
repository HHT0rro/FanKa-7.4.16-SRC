package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ap implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ak f44309a;

    private ap(ak akVar) {
        this.f44309a = akVar;
    }

    public static Runnable a(ak akVar) {
        return new ap(akVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak.b(this.f44309a);
    }
}
