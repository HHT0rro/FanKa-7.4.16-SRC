package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ay implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44329a;

    private ay(ax axVar) {
        this.f44329a = axVar;
    }

    public static Runnable a(ax axVar) {
        return new ay(axVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44329a.d();
    }
}
