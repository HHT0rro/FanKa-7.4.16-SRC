package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final au f44325a;

    private aw(au auVar) {
        this.f44325a = auVar;
    }

    public static Runnable a(au auVar) {
        return new aw(auVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44325a.a();
    }
}
