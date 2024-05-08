package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class am implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44937a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f44938b;

    private am(i iVar, Rotation rotation) {
        this.f44937a = iVar;
        this.f44938b = rotation;
    }

    public static Runnable a(i iVar, Rotation rotation) {
        return new am(iVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44937a.f45012u.setScreenDisplayRotation(this.f44938b);
    }
}
