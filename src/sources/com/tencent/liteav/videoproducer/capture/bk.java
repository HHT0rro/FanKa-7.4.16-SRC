package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VirtualDisplayManager f44394a;

    private bk(VirtualDisplayManager virtualDisplayManager) {
        this.f44394a = virtualDisplayManager;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager) {
        return new bk(virtualDisplayManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VirtualDisplayManager.c(this.f44394a);
    }
}
