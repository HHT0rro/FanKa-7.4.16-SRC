package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44614a;

    private bi(ax axVar) {
        this.f44614a = axVar;
    }

    public static Runnable a(ax axVar) {
        return new bi(axVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.b(this.f44614a);
    }
}
