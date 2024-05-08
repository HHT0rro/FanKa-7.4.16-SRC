package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44913a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f44914b;

    private ad(i iVar, Rotation rotation) {
        this.f44913a = iVar;
        this.f44914b = rotation;
    }

    public static Runnable a(i iVar, Rotation rotation) {
        return new ad(iVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b(this.f44913a, this.f44914b);
    }
}
