package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44412a;

    /* renamed from: b, reason: collision with root package name */
    private final ServerVideoProducerConfig f44413b;

    private l(CameraCaptureSingleton cameraCaptureSingleton, ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44412a = cameraCaptureSingleton;
        this.f44413b = serverVideoProducerConfig;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, ServerVideoProducerConfig serverVideoProducerConfig) {
        return new l(cameraCaptureSingleton, serverVideoProducerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setServerConfig$1(this.f44412a, this.f44413b);
    }
}
