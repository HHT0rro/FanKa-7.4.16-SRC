package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43746a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.PixelFormatType f43747b;

    /* renamed from: c, reason: collision with root package name */
    private final GLConstants.PixelBufferType f43748c;

    /* renamed from: d, reason: collision with root package name */
    private final VideoRenderListener f43749d;

    private l(b bVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        this.f43746a = bVar;
        this.f43747b = pixelFormatType;
        this.f43748c = pixelBufferType;
        this.f43749d = videoRenderListener;
    }

    public static Runnable a(b bVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        return new l(bVar, pixelFormatType, pixelBufferType, videoRenderListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43746a;
        GLConstants.PixelFormatType pixelFormatType = this.f43747b;
        GLConstants.PixelBufferType pixelBufferType = this.f43748c;
        VideoRenderListener videoRenderListener = this.f43749d;
        LiteavLog.i(bVar.f43692a, "setCustomRenderListener: formatType = " + ((Object) pixelFormatType) + " bufferType = " + ((Object) pixelBufferType) + " ," + ((Object) videoRenderListener));
        bVar.f43699h = videoRenderListener;
        if (videoRenderListener != null) {
            bVar.f43697f.a(pixelFormatType, pixelBufferType);
            bVar.a(bVar.f43697f);
        } else {
            bVar.f43697f.a(true);
            bVar.f43695d.b(true);
        }
        final VideoDecodeController videoDecodeController = bVar.f43698g;
        final boolean z10 = bVar.f43699h != null;
        videoDecodeController.a(new Runnable(videoDecodeController, z10) { // from class: com.tencent.liteav.videoconsumer.decoder.ao

            /* renamed from: a, reason: collision with root package name */
            private final VideoDecodeController f43867a;

            /* renamed from: b, reason: collision with root package name */
            private final boolean f43868b;

            {
                this.f43867a = videoDecodeController;
                this.f43868b = z10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f43867a.f43786m = this.f43868b;
            }
        });
        bVar.f43695d.c(bVar.f43699h != null);
    }
}
