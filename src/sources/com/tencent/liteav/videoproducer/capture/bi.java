package com.tencent.liteav.videoproducer.capture;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VirtualDisplayManager f44390a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f44391b;

    private bi(VirtualDisplayManager virtualDisplayManager, Surface surface) {
        this.f44390a = virtualDisplayManager;
        this.f44391b = surface;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager, Surface surface) {
        return new bi(virtualDisplayManager, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VirtualDisplayManager.a(this.f44390a, this.f44391b);
    }
}
