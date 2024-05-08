package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44965a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.SourceType f44966b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoProducerDef.CameraCaptureMode f44967c;

    /* renamed from: d, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44968d;

    private aw(i iVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        this.f44965a = iVar;
        this.f44966b = sourceType;
        this.f44967c = cameraCaptureMode;
        this.f44968d = captureParams;
    }

    public static Runnable a(i iVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        return new aw(iVar, sourceType, cameraCaptureMode, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44965a, this.f44966b, this.f44967c, this.f44968d);
    }
}
