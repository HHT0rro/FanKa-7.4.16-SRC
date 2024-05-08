package com.tencent.liteav.videoproducer.encoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44611a;

    private bf(ax axVar) {
        this.f44611a = axVar;
    }

    public static Runnable a(ax axVar) {
        return new bf(axVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.d(this.f44611a);
    }
}
