package com.tencent.liteav.videoproducer.encoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44612a;

    private bg(ax axVar) {
        this.f44612a = axVar;
    }

    public static Runnable a(ax axVar) {
        return new bg(axVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.q(this.f44612a);
    }
}
