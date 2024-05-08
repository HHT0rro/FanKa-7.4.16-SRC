package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t.AnonymousClass1 f44269a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44270b;

    private ag(t.AnonymousClass1 anonymousClass1, boolean z10) {
        this.f44269a = anonymousClass1;
        this.f44270b = z10;
    }

    public static Runnable a(t.AnonymousClass1 anonymousClass1, boolean z10) {
        return new ag(anonymousClass1, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.AnonymousClass1.a(this.f44269a, this.f44270b);
    }
}
