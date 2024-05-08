package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videoconsumer.renderer.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final k.AnonymousClass1 f44121a;

    private q(k.AnonymousClass1 anonymousClass1) {
        this.f44121a = anonymousClass1;
    }

    public static Runnable a(k.AnonymousClass1 anonymousClass1) {
        return new q(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.l(k.this);
    }
}
