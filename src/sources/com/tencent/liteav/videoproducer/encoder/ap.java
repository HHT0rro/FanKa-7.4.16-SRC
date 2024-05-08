package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ap implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44554a;

    private ap(am amVar) {
        this.f44554a = amVar;
    }

    public static Runnable a(am amVar) {
        return new ap(amVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        am.a(this.f44554a);
    }
}
