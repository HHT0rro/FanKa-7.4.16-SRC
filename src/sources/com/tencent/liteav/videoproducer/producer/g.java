package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.Rotation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final d f44988a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f44989b;

    private g(d dVar, Rotation rotation) {
        this.f44988a = dVar;
        this.f44989b = rotation;
    }

    public static Runnable a(d dVar, Rotation rotation) {
        return new g(dVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b(this.f44988a, this.f44989b);
    }
}
