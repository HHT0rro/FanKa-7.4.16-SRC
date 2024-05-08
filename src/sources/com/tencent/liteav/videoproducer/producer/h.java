package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final d f44990a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f44991b;

    private h(d dVar, Rotation rotation) {
        this.f44990a = dVar;
        this.f44991b = rotation;
    }

    public static Runnable a(d dVar, Rotation rotation) {
        return new h(dVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a(this.f44990a, this.f44991b);
    }
}
