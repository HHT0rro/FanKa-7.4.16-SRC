package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t.AnonymousClass1 f44262a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44263b;

    private ac(t.AnonymousClass1 anonymousClass1, boolean z10) {
        this.f44262a = anonymousClass1;
        this.f44263b = z10;
    }

    public static Runnable a(t.AnonymousClass1 anonymousClass1, boolean z10) {
        return new ac(anonymousClass1, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.AnonymousClass1.c(this.f44262a, this.f44263b);
    }
}
