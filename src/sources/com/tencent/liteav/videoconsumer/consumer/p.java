package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43754a;

    private p(b bVar) {
        this.f43754a = bVar;
    }

    public static Runnable a(b bVar) {
        return new p(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43754a;
        LiteavLog.i(bVar.f43692a, "uninitialize videoConsumer");
        com.tencent.liteav.videoconsumer.renderer.t tVar = bVar.f43696e;
        if (tVar != null) {
            tVar.a((DisplayTarget) null, false);
            bVar.f43696e = null;
        }
        bVar.f43697f.a(true);
        bVar.f43697f.a();
        VideoDecodeController videoDecodeController = bVar.f43698g;
        LiteavLog.i(videoDecodeController.f43774a, "uninitialize");
        final com.tencent.liteav.videobase.utils.n nVar = videoDecodeController.f43793t;
        nVar.getClass();
        videoDecodeController.a(new Runnable(nVar) { // from class: com.tencent.liteav.videoconsumer.decoder.at

            /* renamed from: a, reason: collision with root package name */
            private final com.tencent.liteav.videobase.utils.n f43876a;

            {
                this.f43876a = nVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f43876a.b();
            }
        });
        bVar.f43715x = null;
        bVar.f43702k = null;
        bVar.f43699h = null;
        com.tencent.liteav.videobase.utils.i.a().a(bVar.f43701j);
    }
}
