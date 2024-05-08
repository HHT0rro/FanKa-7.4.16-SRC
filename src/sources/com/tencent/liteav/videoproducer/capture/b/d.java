package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.tencent.liteav.videoproducer.capture.b.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a.AnonymousClass4 f44368a;

    /* renamed from: b, reason: collision with root package name */
    private final TotalCaptureResult f44369b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureRequest f44370c;

    private d(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
        this.f44368a = anonymousClass4;
        this.f44369b = totalCaptureResult;
        this.f44370c = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
        return new d(anonymousClass4, totalCaptureResult, captureRequest);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.AnonymousClass4.a(this.f44368a, this.f44369b, this.f44370c);
    }
}
