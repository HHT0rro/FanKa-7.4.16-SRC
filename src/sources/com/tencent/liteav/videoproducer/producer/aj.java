package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44924a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.PixelFormatType f44925b;

    /* renamed from: c, reason: collision with root package name */
    private final GLConstants.PixelBufferType f44926c;

    /* renamed from: d, reason: collision with root package name */
    private final VideoRenderListener f44927d;

    private aj(i iVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        this.f44924a = iVar;
        this.f44925b = pixelFormatType;
        this.f44926c = pixelBufferType;
        this.f44927d = videoRenderListener;
    }

    public static Runnable a(i iVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        return new aj(iVar, pixelFormatType, pixelBufferType, videoRenderListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44924a, this.f44925b, this.f44926c, this.f44927d);
    }
}
