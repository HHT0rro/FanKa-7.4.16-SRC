package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class an implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ak f44304a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44305b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureSourceListener f44306c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f44307d;

    private an(ak akVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj) {
        this.f44304a = akVar;
        this.f44305b = captureParams;
        this.f44306c = captureSourceListener;
        this.f44307d = obj;
    }

    public static Runnable a(ak akVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj) {
        return new an(akVar, captureParams, captureSourceListener, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak.a(this.f44304a, this.f44305b, this.f44306c, this.f44307d);
    }
}
