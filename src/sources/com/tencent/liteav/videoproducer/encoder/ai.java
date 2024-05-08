package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44511a;

    private ai(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f44511a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new ai(softwareEncoderWrapper);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$restartIDRFrame$6(this.f44511a);
    }
}
