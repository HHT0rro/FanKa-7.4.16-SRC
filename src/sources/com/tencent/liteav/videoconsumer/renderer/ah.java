package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ah implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44068a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f44069b;

    private ah(t tVar, Rotation rotation) {
        this.f44068a = tVar;
        this.f44069b = rotation;
    }

    public static Runnable a(t tVar, Rotation rotation) {
        return new ah(tVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44068a, this.f44069b);
    }
}
