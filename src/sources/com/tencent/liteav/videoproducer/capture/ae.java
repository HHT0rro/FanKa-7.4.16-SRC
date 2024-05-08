package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t.AnonymousClass1 f44266a;

    private ae(t.AnonymousClass1 anonymousClass1) {
        this.f44266a = anonymousClass1;
    }

    public static Runnable a(t.AnonymousClass1 anonymousClass1) {
        return new ae(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.AnonymousClass1.a(this.f44266a);
    }
}
