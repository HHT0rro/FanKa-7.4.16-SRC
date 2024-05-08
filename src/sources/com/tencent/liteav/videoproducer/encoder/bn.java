package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.ax;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax.AnonymousClass1 f44622a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44623b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44624c;

    private bn(ax.AnonymousClass1 anonymousClass1, boolean z10, int i10) {
        this.f44622a = anonymousClass1;
        this.f44623b = z10;
        this.f44624c = i10;
    }

    public static Runnable a(ax.AnonymousClass1 anonymousClass1, boolean z10, int i10) {
        return new bn(anonymousClass1, z10, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.AnonymousClass1.a(this.f44622a, this.f44623b, this.f44624c);
    }
}
