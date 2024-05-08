package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44447a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44448b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureSourceListener f44449c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f44450d;

    private y(t tVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj) {
        this.f44447a = tVar;
        this.f44448b = captureParams;
        this.f44449c = captureSourceListener;
        this.f44450d = obj;
    }

    public static Runnable a(t tVar, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj) {
        return new y(tVar, captureParams, captureSourceListener, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44447a, this.f44448b, this.f44449c, this.f44450d);
    }
}
