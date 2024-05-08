package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final s.AnonymousClass1 f44719a;

    /* renamed from: b, reason: collision with root package name */
    private final h.a f44720b;

    private u(s.AnonymousClass1 anonymousClass1, h.a aVar) {
        this.f44719a = anonymousClass1;
        this.f44720b = aVar;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1, h.a aVar) {
        return new u(anonymousClass1, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1.a(this.f44719a, this.f44720b);
    }
}
