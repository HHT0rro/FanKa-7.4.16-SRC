package com.tencent.liteav.videoconsumer.consumer;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoconsumer.decoder.SoftwareVideoDecoder;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.b;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoConsumerProxy {
    private final b mConsumer;

    @CalledByNative
    public VideoConsumerProxy(@NonNull IVideoReporter iVideoReporter) {
        this.mConsumer = new b(iVideoReporter);
    }

    @CalledByNative
    public static VideoDecoderDef.DecodeAbility getDecodeAbility() {
        com.tencent.liteav.videoconsumer.decoder.b bVar;
        bVar = b.a.f43887a;
        bVar.f43885a.f43812a = SoftwareVideoDecoder.nativeIsRpsDecodeSupport();
        return bVar.f43885a;
    }

    @CalledByNative
    public void appendNALPacket(EncodedVideoFrame encodedVideoFrame) {
        b bVar = this.mConsumer;
        if (encodedVideoFrame != null && encodedVideoFrame.data != null) {
            encodedVideoFrame.consumerChainTimestamp.setDeliverTimestamp(TimeUtil.a());
            bVar.a(y.a(bVar, encodedVideoFrame), false);
        } else {
            LiteavLog.w(bVar.f43692a, "packet or packet.data is null,packet={%s}", encodedVideoFrame);
        }
    }

    @CalledByNative
    public long getCurrentRenderTimeStamp() {
        return this.mConsumer.f43716y.get();
    }

    @CalledByNative
    public int getWritableState() {
        VideoDecoderDef.a aVar;
        VideoDecodeController videoDecodeController = this.mConsumer.f43698g;
        int d10 = videoDecodeController.d();
        if (!videoDecodeController.f43794u.get()) {
            aVar = d10 > 0 ? VideoDecoderDef.a.FAST_UNWRITABLE : VideoDecoderDef.a.FAST_WRITABLE;
        } else {
            aVar = d10 > 0 ? VideoDecoderDef.a.NORMAL_UNWRITABLE : VideoDecoderDef.a.NORMAL_WRITABLE;
        }
        return aVar.mValue;
    }

    @CalledByNative
    public void initialize() {
        b bVar = this.mConsumer;
        LiteavLog.i(bVar.f43692a, "initialize videoConsumer");
        bVar.a(o.a(bVar), false);
    }

    @CalledByNative
    public void pause() {
        b bVar = this.mConsumer;
        bVar.a(w.a(bVar), false);
    }

    @CalledByNative
    public void preloadDecoder(int i10) {
        b bVar = this.mConsumer;
        bVar.a(t.a(bVar, CodecType.a(i10)), false);
    }

    @CalledByNative
    public void resume() {
        b bVar = this.mConsumer;
        bVar.a(x.a(bVar), false);
    }

    @CalledByNative
    public void setCustomRenderListener(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        b bVar = this.mConsumer;
        bVar.a(l.a(bVar, pixelFormatType, pixelBufferType, videoRenderListener), false);
    }

    @CalledByNative
    public void setDecoderStrategy(VideoDecodeController.DecodeStrategy decodeStrategy) {
        b bVar = this.mConsumer;
        bVar.a(h.a(bVar, decodeStrategy), true);
    }

    @CalledByNative
    public void setDisplayTarget(DisplayTarget displayTarget) {
        b bVar = this.mConsumer;
        bVar.a(i.a(bVar, displayTarget), false);
    }

    @CalledByNative
    public void setHWDecoderDeviceRelatedParams(String str) {
        b bVar = this.mConsumer;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bVar.a(k.a(bVar, str), true);
    }

    @CalledByNative
    public void setPerspectiveCorrectionPoints(float[] fArr, float[] fArr2) {
        b bVar = this.mConsumer;
        bVar.a(q.a(bVar, com.tencent.liteav.videobase.utils.e.a(fArr), com.tencent.liteav.videobase.utils.e.a(fArr2)), false);
    }

    @CalledByNative
    public void setRenderMirrorEnabled(boolean z10) {
        b bVar = this.mConsumer;
        bVar.a(e.a(bVar, z10), true);
    }

    @CalledByNative
    public void setRenderRotation(Rotation rotation) {
        b bVar = this.mConsumer;
        bVar.a(f.a(bVar, rotation), true);
    }

    @CalledByNative
    public void setScaleType(GLConstants.GLScaleType gLScaleType) {
        b bVar = this.mConsumer;
        bVar.a(g.a(bVar, gLScaleType), true);
    }

    @CalledByNative
    public void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
        b bVar = this.mConsumer;
        bVar.a(d.a(bVar, consumerScene), false);
    }

    @CalledByNative
    public void setServerConfig(VideoConsumerServerConfig videoConsumerServerConfig) {
        b bVar = this.mConsumer;
        bVar.a(s.a(bVar, videoConsumerServerConfig), true);
    }

    @CalledByNative
    public void setSharedEGLContext(Object obj) {
        b bVar = this.mConsumer;
        LiteavLog.i(bVar.f43692a, "setSharedEGLContext(object:" + obj + ")");
        bVar.a(m.a(bVar, obj), false);
    }

    @CalledByNative
    public void start() {
        b bVar = this.mConsumer;
        bVar.a(u.a(bVar), false);
    }

    @CalledByNative
    public void stop(boolean z10) {
        this.mConsumer.a(z10);
    }

    @CalledByNative
    public void takeSnapshot(SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        b bVar = this.mConsumer;
        bVar.a(j.a(bVar, snapshotSourceType, takeSnapshotListener), false);
    }

    @CalledByNative
    public void uninitialize() {
        b bVar = this.mConsumer;
        bVar.a(false);
        bVar.a(p.a(bVar), false);
    }
}
