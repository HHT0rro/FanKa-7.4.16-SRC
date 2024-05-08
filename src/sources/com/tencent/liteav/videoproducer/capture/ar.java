package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ak f44311a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44312b;

    private ar(ak akVar, CaptureSourceInterface.CaptureParams captureParams) {
        this.f44311a = akVar;
        this.f44312b = captureParams;
    }

    public static Runnable a(ak akVar, CaptureSourceInterface.CaptureParams captureParams) {
        return new ar(akVar, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak.a(this.f44311a, this.f44312b);
    }
}
