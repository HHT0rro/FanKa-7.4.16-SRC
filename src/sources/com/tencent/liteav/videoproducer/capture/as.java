package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.ak;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class as implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ak.AnonymousClass1 f44313a;

    private as(ak.AnonymousClass1 anonymousClass1) {
        this.f44313a = anonymousClass1;
    }

    public static Runnable a(ak.AnonymousClass1 anonymousClass1) {
        return new as(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak.this.f44291n.a();
    }
}
