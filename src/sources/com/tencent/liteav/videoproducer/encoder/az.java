package com.tencent.liteav.videoproducer.encoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class az implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44596a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44597b;

    private az(ax axVar, int i10) {
        this.f44596a = axVar;
        this.f44597b = i10;
    }

    public static Runnable a(ax axVar, int i10) {
        return new az(axVar, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.b(this.f44596a, this.f44597b);
    }
}
