package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43739a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayTarget f43740b;

    private i(b bVar, DisplayTarget displayTarget) {
        this.f43739a = bVar;
        this.f43740b = displayTarget;
    }

    public static Runnable a(b bVar, DisplayTarget displayTarget) {
        return new i(bVar, displayTarget);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43739a;
        DisplayTarget displayTarget = this.f43740b;
        LiteavLog.i(bVar.f43692a, "setDisplayTarget: ".concat(String.valueOf(displayTarget)));
        bVar.f43702k = displayTarget;
        if (displayTarget != null && displayTarget.getTXCloudVideoView() != null && bVar.f43702k.getTXCloudVideoView().getOpenGLContext() != null) {
            bVar.f43715x = bVar.f43702k.getTXCloudVideoView().getOpenGLContext();
        }
        for (com.tencent.liteav.videoconsumer.renderer.r rVar : bVar.a()) {
            if (rVar != null) {
                rVar.a(displayTarget, true);
            }
        }
    }
}
