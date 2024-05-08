package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44555a;

    /* renamed from: b, reason: collision with root package name */
    private final ServerVideoProducerConfig f44556b;

    private aq(am amVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44555a = amVar;
        this.f44556b = serverVideoProducerConfig;
    }

    public static Runnable a(am amVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new aq(amVar, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44555a.f44533i = this.f44556b;
    }
}
