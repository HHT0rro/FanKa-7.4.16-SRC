package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.ax;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax.AnonymousClass1 f44621a;

    private bm(ax.AnonymousClass1 anonymousClass1) {
        this.f44621a = anonymousClass1;
    }

    public static Runnable a(ax.AnonymousClass1 anonymousClass1) {
        return new bm(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.this.f44587u.f44642h = true;
    }
}
