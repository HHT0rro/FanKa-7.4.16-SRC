package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44946a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.SourceType f44947b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoProducerDef.CameraCaptureMode f44948c;

    /* renamed from: d, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44949d;

    private aq(i iVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        this.f44946a = iVar;
        this.f44947b = sourceType;
        this.f44948c = cameraCaptureMode;
        this.f44949d = captureParams;
    }

    public static Runnable a(i iVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        return new aq(iVar, sourceType, cameraCaptureMode, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b(this.f44946a, this.f44947b, this.f44948c, this.f44949d);
    }
}
