package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.Rotation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45035a;

    /* renamed from: b, reason: collision with root package name */
    private final Rotation f45036b;

    private p(i iVar, Rotation rotation) {
        this.f45035a = iVar;
        this.f45036b = rotation;
    }

    public static Runnable a(i iVar, Rotation rotation) {
        return new p(iVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.c(this.f45035a, this.f45036b);
    }
}
