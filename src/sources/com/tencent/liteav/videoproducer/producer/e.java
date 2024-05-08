package com.tencent.liteav.videoproducer.producer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final d f44986a;

    private e(d dVar) {
        this.f44986a = dVar;
    }

    public static Runnable a(d dVar) {
        return new e(dVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b(this.f44986a);
    }
}
