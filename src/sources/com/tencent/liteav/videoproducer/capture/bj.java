package com.tencent.liteav.videoproducer.capture;

import android.media.projection.MediaProjection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VirtualDisplayManager f44392a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaProjection f44393b;

    private bj(VirtualDisplayManager virtualDisplayManager, MediaProjection mediaProjection) {
        this.f44392a = virtualDisplayManager;
        this.f44393b = mediaProjection;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager, MediaProjection mediaProjection) {
        return new bj(virtualDisplayManager, mediaProjection);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VirtualDisplayManager.a(this.f44392a, this.f44393b);
    }
}
