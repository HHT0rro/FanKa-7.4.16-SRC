package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface bq {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a extends VideoEncoderDef.VideoEncoderDataListener {
        public void a() {
        }

        public void a(boolean z10, int i10) {
        }
    }

    void a();

    void a(int i10);

    void a(int i10, int i11);

    void a(TakeSnapshotListener takeSnapshotListener);

    void a(PixelFrame pixelFrame);

    void a(ServerVideoProducerConfig serverVideoProducerConfig);

    boolean a(VideoEncodeParams videoEncodeParams, a aVar);

    void b();

    void b(int i10);

    void c();

    void c(int i10);

    void d();

    void d(int i10);

    VideoEncodeParams e();

    void f();

    VideoEncoderDef.a g();
}
