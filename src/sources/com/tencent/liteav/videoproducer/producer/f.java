package com.tencent.liteav.videoproducer.producer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final d f44987a;

    private f(d dVar) {
        this.f44987a = dVar;
    }

    public static Runnable a(d dVar) {
        return new f(dVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a(this.f44987a);
    }
}
