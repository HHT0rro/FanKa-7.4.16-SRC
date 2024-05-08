package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CaptureRequest;
import com.tencent.liteav.videoproducer.capture.b.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a.AnonymousClass4 f44371a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureRequest f44372b;

    private e(a.AnonymousClass4 anonymousClass4, CaptureRequest captureRequest) {
        this.f44371a = anonymousClass4;
        this.f44372b = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 anonymousClass4, CaptureRequest captureRequest) {
        return new e(anonymousClass4, captureRequest);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.AnonymousClass4.a(this.f44371a, this.f44372b);
    }
}
