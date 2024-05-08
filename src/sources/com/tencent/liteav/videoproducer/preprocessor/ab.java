package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44748a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44749b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.liteav.videobase.videobase.a f44750c;

    /* renamed from: d, reason: collision with root package name */
    private final GLConstants.PixelBufferType f44751d;

    /* renamed from: e, reason: collision with root package name */
    private final GLConstants.PixelFormatType f44752e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44753f;

    /* renamed from: g, reason: collision with root package name */
    private final ah f44754g;

    private ab(VideoPreprocessor videoPreprocessor, int i10, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z10, ah ahVar) {
        this.f44748a = videoPreprocessor;
        this.f44749b = i10;
        this.f44750c = aVar;
        this.f44751d = pixelBufferType;
        this.f44752e = pixelFormatType;
        this.f44753f = z10;
        this.f44754g = ahVar;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i10, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z10, ah ahVar) {
        return new ab(videoPreprocessor, i10, aVar, pixelBufferType, pixelFormatType, z10, ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$registerVideoProcessedListener$3(this.f44748a, this.f44749b, this.f44750c, this.f44751d, this.f44752e, this.f44753f, this.f44754g);
    }
}
