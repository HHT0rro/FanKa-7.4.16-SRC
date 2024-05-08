package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44164a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f44165b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44166c;

    private y(t tVar, Surface surface, boolean z10) {
        this.f44164a = tVar;
        this.f44165b = surface;
        this.f44166c = z10;
    }

    public static Runnable a(t tVar, Surface surface, boolean z10) {
        return new y(tVar, surface, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44164a, this.f44165b, this.f44166c);
    }
}
