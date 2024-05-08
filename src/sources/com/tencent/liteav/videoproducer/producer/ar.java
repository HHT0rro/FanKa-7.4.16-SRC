package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44950a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44951b;

    /* renamed from: c, reason: collision with root package name */
    private final PixelFrame f44952c;

    private ar(i iVar, int i10, PixelFrame pixelFrame) {
        this.f44950a = iVar;
        this.f44951b = i10;
        this.f44952c = pixelFrame;
    }

    public static Runnable a(i iVar, int i10, PixelFrame pixelFrame) {
        return new ar(iVar, i10, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44950a, this.f44951b, this.f44952c);
    }
}
