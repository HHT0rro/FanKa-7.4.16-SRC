package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44918a;

    /* renamed from: b, reason: collision with root package name */
    private final ServerVideoProducerConfig f44919b;

    private af(i iVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44918a = iVar;
        this.f44919b = serverVideoProducerConfig;
    }

    public static Runnable a(i iVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new af(iVar, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44918a, this.f44919b);
    }
}
