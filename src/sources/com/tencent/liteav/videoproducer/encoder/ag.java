package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44506a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44507b;

    private ag(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        this.f44506a = softwareEncoderWrapper;
        this.f44507b = i10;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        return new ag(softwareEncoderWrapper, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$setRPSNearestREFSize$4(this.f44506a, this.f44507b);
    }
}
