package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class aw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44566a;

    private aw(am amVar) {
        this.f44566a = amVar;
    }

    public static Runnable a(am amVar) {
        return new aw(amVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        am amVar = this.f44566a;
        amVar.f();
        amVar.f44527c.removeMessages(10);
        amVar.a(amVar.f44528d);
        amVar.f44528d = null;
    }
}
