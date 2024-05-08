package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class al implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44933a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.PixelFormatType f44934b;

    /* renamed from: c, reason: collision with root package name */
    private final GLConstants.PixelBufferType f44935c;

    /* renamed from: d, reason: collision with root package name */
    private final CustomVideoProcessListener f44936d;

    private al(i iVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        this.f44933a = iVar;
        this.f44934b = pixelFormatType;
        this.f44935c = pixelBufferType;
        this.f44936d = customVideoProcessListener;
    }

    public static Runnable a(i iVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        return new al(iVar, pixelFormatType, pixelBufferType, customVideoProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44933a, this.f44934b, this.f44935c, this.f44936d);
    }
}
