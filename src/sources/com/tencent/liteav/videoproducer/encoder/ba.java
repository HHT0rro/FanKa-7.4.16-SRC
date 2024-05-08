package com.tencent.liteav.videoproducer.encoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44599a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44600b;

    private ba(ax axVar, int i10) {
        this.f44599a = axVar;
        this.f44600b = i10;
    }

    public static Runnable a(ax axVar, int i10) {
        return new ba(axVar, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.a(this.f44599a, this.f44600b);
    }
}
