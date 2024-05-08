package com.tencent.liteav.videoproducer.encoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44617a;

    private bk(ax axVar) {
        this.f44617a = axVar;
    }

    public static Runnable a(ax axVar) {
        return new bk(axVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.a(this.f44617a);
    }
}
