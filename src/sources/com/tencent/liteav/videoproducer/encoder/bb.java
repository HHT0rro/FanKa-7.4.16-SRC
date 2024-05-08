package com.tencent.liteav.videoproducer.encoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44601a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44602b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44603c;

    private bb(ax axVar, int i10, int i11) {
        this.f44601a = axVar;
        this.f44602b = i10;
        this.f44603c = i11;
    }

    public static Runnable a(ax axVar, int i10, int i11) {
        return new bb(axVar, i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.a(this.f44601a, this.f44602b, this.f44603c);
    }
}
