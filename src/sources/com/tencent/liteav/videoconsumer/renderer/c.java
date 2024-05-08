package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f44076a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f44077b;

    private c(b bVar, Surface surface) {
        this.f44076a = bVar;
        this.f44077b = surface;
    }

    public static Runnable a(b bVar, Surface surface) {
        return new c(bVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f44076a, this.f44077b);
    }
}
