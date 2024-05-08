package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ah implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44508a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44509b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44510c;

    private ah(SoftwareEncoderWrapper softwareEncoderWrapper, int i10, int i11) {
        this.f44508a = softwareEncoderWrapper;
        this.f44509b = i10;
        this.f44510c = i11;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, int i10, int i11) {
        return new ah(softwareEncoderWrapper, i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$ackRPSRecvFrameIndex$5(this.f44508a, this.f44509b, this.f44510c);
    }
}
