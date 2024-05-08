package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45022a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayTarget f45023b;

    private k(i iVar, DisplayTarget displayTarget) {
        this.f45022a = iVar;
        this.f45023b = displayTarget;
    }

    public static Runnable a(i iVar, DisplayTarget displayTarget) {
        return new k(iVar, displayTarget);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45022a, this.f45023b);
    }
}
