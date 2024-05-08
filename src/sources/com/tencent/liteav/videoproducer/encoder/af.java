package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44504a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44505b;

    private af(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        this.f44504a = softwareEncoderWrapper;
        this.f44505b = i10;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        return new af(softwareEncoderWrapper, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$setRPSIFrameFPS$3(this.f44504a, this.f44505b);
    }
}
