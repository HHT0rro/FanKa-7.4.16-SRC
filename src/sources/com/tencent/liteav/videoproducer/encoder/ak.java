package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44514a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44515b;

    private ak(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        this.f44514a = softwareEncoderWrapper;
        this.f44515b = i10;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, int i10) {
        return new ak(softwareEncoderWrapper, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$setFps$8(this.f44514a, this.f44515b);
    }
}
