package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44613a;

    private bh(ax axVar) {
        this.f44613a = axVar;
    }

    public static Runnable a(ax axVar) {
        return new bh(axVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.c(this.f44613a);
    }
}
