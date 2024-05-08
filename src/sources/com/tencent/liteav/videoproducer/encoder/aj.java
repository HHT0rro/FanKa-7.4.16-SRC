package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44512a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44513b;

    private aj(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        this.f44512a = softwareEncoderWrapper;
        this.f44513b = i10;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        return new aj(softwareEncoderWrapper, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$setBitrate$7(this.f44512a, this.f44513b);
    }
}
