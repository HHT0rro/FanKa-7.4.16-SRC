package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class az implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44973a;

    private az(i iVar) {
        this.f44973a = iVar;
    }

    public static Runnable a(i iVar) {
        return new az(iVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.j(this.f44973a);
    }
}
