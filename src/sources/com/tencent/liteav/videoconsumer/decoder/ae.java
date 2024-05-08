package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoconsumer.decoder.ad;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ae extends ad {

    /* renamed from: i, reason: collision with root package name */
    public Surface f43844i;

    public ae(com.tencent.liteav.videobase.utils.h hVar, Size size, IVideoReporter iVideoReporter, boolean z10, ad.b bVar, CustomHandler customHandler) {
        super(hVar, size, iVideoReporter, z10, bVar, customHandler);
        this.f43829a = "MediaCodecHDRDecoder";
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final void a(MediaCodec mediaCodec) {
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        Surface surface = this.f43844i;
        if (surface == null) {
            return false;
        }
        am.a(mediaCodec, mediaFormat, surface);
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(Object obj) {
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i10) {
        mediaCodec.releaseOutputBuffer(i10, true);
        if ((bufferInfo.flags & 4) != 0) {
            LiteavLog.i(this.f43829a, "meet end of stream.");
            ad.b bVar = this.f43830b;
            if (bVar != null) {
                bVar.a((PixelFrame) null, true);
            }
        } else {
            PixelFrame pixelFrame = new PixelFrame();
            pixelFrame.setWidth(this.f43831c.width);
            pixelFrame.setHeight(this.f43831c.height);
            pixelFrame.setTimestamp(TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs));
            ad.b bVar2 = this.f43830b;
            if (bVar2 != null) {
                bVar2.a(pixelFrame, false);
            }
        }
        return false;
    }

    public final void a(Surface surface) {
        a(af.a(this, surface));
    }
}
