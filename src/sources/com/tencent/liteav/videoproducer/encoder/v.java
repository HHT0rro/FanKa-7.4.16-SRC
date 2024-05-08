package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final s.AnonymousClass1 f44721a;

    private v(s.AnonymousClass1 anonymousClass1) {
        this.f44721a = anonymousClass1;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1) {
        return new v(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1.a(this.f44721a);
    }
}
