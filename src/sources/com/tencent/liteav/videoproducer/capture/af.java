package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t.AnonymousClass1 f44267a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44268b;

    private af(t.AnonymousClass1 anonymousClass1, boolean z10) {
        this.f44267a = anonymousClass1;
        this.f44268b = z10;
    }

    public static Runnable a(t.AnonymousClass1 anonymousClass1, boolean z10) {
        return new af(anonymousClass1, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.AnonymousClass1.b(this.f44267a, this.f44268b);
    }
}
