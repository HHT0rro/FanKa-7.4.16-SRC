package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44606a;

    /* renamed from: b, reason: collision with root package name */
    private final ServerVideoProducerConfig f44607b;

    private bd(ax axVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44606a = axVar;
        this.f44607b = serverVideoProducerConfig;
    }

    public static Runnable a(ax axVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new bd(axVar, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44606a.f44580n = this.f44607b;
    }
}
