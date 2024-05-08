package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ah implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44921a;

    /* renamed from: b, reason: collision with root package name */
    private final PixelFrame f44922b;

    private ah(i iVar, PixelFrame pixelFrame) {
        this.f44921a = iVar;
        this.f44922b = pixelFrame;
    }

    public static Runnable a(i iVar, PixelFrame pixelFrame) {
        return new ah(iVar, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44921a, this.f44922b);
    }
}
