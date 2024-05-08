package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ay implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44972a;

    private ay(i iVar) {
        this.f44972a = iVar;
    }

    public static Runnable a(i iVar) {
        return new ay(iVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.i(this.f44972a);
    }
}
