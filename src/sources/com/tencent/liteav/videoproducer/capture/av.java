package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class av implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final au f44321a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureSourceListener f44322b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f44323c;

    /* renamed from: d, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44324d;

    private av(au auVar, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj, CaptureSourceInterface.CaptureParams captureParams) {
        this.f44321a = auVar;
        this.f44322b = captureSourceListener;
        this.f44323c = obj;
        this.f44324d = captureParams;
    }

    public static Runnable a(au auVar, CaptureSourceInterface.CaptureSourceListener captureSourceListener, Object obj, CaptureSourceInterface.CaptureParams captureParams) {
        return new av(auVar, captureSourceListener, obj, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        au.a(this.f44321a, this.f44322b, this.f44323c, this.f44324d);
    }
}
