package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44259a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44260b;

    private aa(t tVar, CaptureSourceInterface.CaptureParams captureParams) {
        this.f44259a = tVar;
        this.f44260b = captureParams;
    }

    public static Runnable a(t tVar, CaptureSourceInterface.CaptureParams captureParams) {
        return new aa(tVar, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44259a, this.f44260b);
    }
}
