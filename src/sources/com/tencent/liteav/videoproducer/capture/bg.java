package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VirtualDisplayManager f44382a;

    private bg(VirtualDisplayManager virtualDisplayManager) {
        this.f44382a = virtualDisplayManager;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager) {
        return new bg(virtualDisplayManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44382a.a(false);
    }
}
