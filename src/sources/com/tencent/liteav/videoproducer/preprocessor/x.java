package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44861a;

    private x(h hVar) {
        this.f44861a = hVar;
    }

    public static Runnable a(h hVar) {
        return new x(hVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44861a.a();
    }
}
