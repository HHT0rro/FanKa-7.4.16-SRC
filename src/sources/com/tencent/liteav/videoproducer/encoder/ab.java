package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44497a;

    private ab(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f44497a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new ab(softwareEncoderWrapper);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$stopSync$10(this.f44497a);
    }
}
