package com.tencent.liteav.videoproducer.producer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor;
import com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoProducerProxy {
    private final i mProducer;

    @CalledByNative
    public VideoProducerProxy(boolean z10, @NonNull IVideoReporter iVideoReporter) {
        this(ContextUtils.getApplicationContext(), z10, iVideoReporter);
    }

    @CalledByNative
    public static VideoEncoderDef.EncodeAbility getEncodeAbility() {
        return i.a();
    }

    @CalledByNative
    public void ackRPSRecvFrameIndex(VideoProducerDef.StreamType streamType, int i10, int i11) {
        i iVar = this.mProducer;
        iVar.a(z.a(iVar, streamType, i10, i11));
    }

    @CalledByNative
    public void appendCustomCaptureFrame(PixelFrame pixelFrame) {
        i iVar = this.mProducer;
        if (pixelFrame != null && pixelFrame.isFrameDataValid()) {
            pixelFrame.getProducerChainTimestamp().setCaptureTimestamp(TimeUtil.a());
            pixelFrame.retain();
            if (iVar.a(ah.a(iVar, pixelFrame))) {
                return;
            }
            pixelFrame.release();
            return;
        }
        LiteavLog.w(iVar.f44992a, "appendCustomCaptureFrame: frame is not valid.");
    }

    @CalledByNative
    public BeautyProcessor getBeautyProcessor() {
        return this.mProducer.f44995d;
    }

    @CalledByNative
    public VideoPreprocessor getVideoPreprocessor() {
        return this.mProducer.f44994c;
    }

    @CalledByNative
    public void initialize() {
        i iVar = this.mProducer;
        synchronized (iVar) {
            if (iVar.f44997f) {
                LiteavLog.w(iVar.f44992a, "videoproducer already initialized.");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("videoProducer_" + iVar.hashCode());
            handlerThread.start();
            iVar.f44996e = new CustomHandler(handlerThread.getLooper());
            iVar.f44997f = true;
            iVar.f44996e.runAndWaitDone(j.a(iVar));
        }
    }

    @CalledByNative
    public void pauseCapture() {
        i iVar = this.mProducer;
        iVar.a(ay.a(iVar));
    }

    @CalledByNative
    public void requestKeyFrame(VideoProducerDef.StreamType streamType) {
        i iVar = this.mProducer;
        iVar.a(aa.a(iVar, streamType));
    }

    @CalledByNative
    public void resumeCapture() {
        i iVar = this.mProducer;
        iVar.a(az.a(iVar));
    }

    @CalledByNative
    public int setCameraFocusPosition(int i10, int i11) {
        i iVar = this.mProducer;
        iVar.a(r.a(iVar, i10, i11));
        return 0;
    }

    @CalledByNative
    public void setCaptureParams(CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        i iVar = this.mProducer;
        iVar.a(aw.a(iVar, sourceType, cameraCaptureMode, captureParams));
    }

    @CalledByNative
    public void setCustomRenderListener(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        i iVar = this.mProducer;
        iVar.a(aj.a(iVar, pixelFormatType, pixelBufferType, videoRenderListener));
    }

    @CalledByNative
    public void setCustomVideoProcessListener(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        i iVar = this.mProducer;
        iVar.a(al.a(iVar, pixelFormatType, pixelBufferType, customVideoProcessListener));
    }

    @CalledByNative
    public void setDisplayView(DisplayTarget displayTarget) {
        i iVar = this.mProducer;
        iVar.a(k.a(iVar, displayTarget));
    }

    @CalledByNative
    public void setEncodeMirrorEnabled(boolean z10) {
        i iVar = this.mProducer;
        iVar.a(o.a(iVar, z10));
    }

    @CalledByNative
    public void setEncodeParams(VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, GLConstants.ResolutionMode resolutionMode) {
        i iVar = this.mProducer;
        iVar.a(v.a(iVar, streamType, videoEncodeParams, resolutionMode));
    }

    @CalledByNative
    public void setEncodeRotation(Rotation rotation) {
        i iVar = this.mProducer;
        iVar.a(p.a(iVar, rotation));
    }

    @CalledByNative
    public void setEncodeStrategy(VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        i iVar = this.mProducer;
        iVar.a(n.a(iVar, streamType, encodeStrategy));
    }

    @CalledByNative
    public void setGSensorMode(VideoProducerDef.GSensorMode gSensorMode) {
        i iVar = this.mProducer;
        iVar.a(s.a(iVar, gSensorMode));
    }

    @CalledByNative
    public void setHWEncoderDeviceRelatedParams(String str) {
        i iVar = this.mProducer;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        iVar.a(q.a(iVar, str));
    }

    @CalledByNative
    public void setHomeOrientation(VideoProducerDef.HomeOrientation homeOrientation) {
        i iVar = this.mProducer;
        iVar.a(t.a(iVar, homeOrientation));
    }

    @CalledByNative
    public void setPausedImage(Bitmap bitmap, int i10) {
        i iVar = this.mProducer;
        iVar.a(ax.a(iVar, bitmap, i10));
    }

    @CalledByNative
    public void setPerspectiveCorrectionPoints(float[] fArr, float[] fArr2) {
        i iVar = this.mProducer;
        iVar.a(w.a(iVar, com.tencent.liteav.videobase.utils.e.a(fArr), com.tencent.liteav.videobase.utils.e.a(fArr2)));
    }

    @CalledByNative
    public void setRPSIFrameFPS(VideoProducerDef.StreamType streamType, int i10) {
        i iVar = this.mProducer;
        iVar.a(x.a(iVar, i10, streamType));
    }

    @CalledByNative
    public void setRPSNearestREFSize(VideoProducerDef.StreamType streamType, int i10) {
        i iVar = this.mProducer;
        iVar.a(y.a(iVar, i10, streamType));
    }

    @CalledByNative
    public void setRenderMirrorMode(GLConstants.MirrorMode mirrorMode) {
        i iVar = this.mProducer;
        iVar.a(ab.a(iVar, mirrorMode));
    }

    @CalledByNative
    public void setRenderRotation(Rotation rotation) {
        i iVar = this.mProducer;
        iVar.a(ad.a(iVar, rotation));
    }

    @CalledByNative
    public void setRenderScaleType(GLConstants.GLScaleType gLScaleType) {
        i iVar = this.mProducer;
        iVar.a(ac.a(iVar, gLScaleType));
    }

    @CalledByNative
    public void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
        i iVar = this.mProducer;
        iVar.a(af.a(iVar, serverVideoProducerConfig));
    }

    @CalledByNative
    public void setWatermark(Bitmap bitmap, float f10, float f11, float f12) {
        i iVar = this.mProducer;
        iVar.a(ak.a(iVar, bitmap, f10, f11, f12));
    }

    @CalledByNative
    public void startCapture(CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        i iVar = this.mProducer;
        CaptureSourceInterface.SourceType sourceType2 = CaptureSourceInterface.SourceType.CAMERA;
        if (sourceType != sourceType2 && sourceType != CaptureSourceInterface.SourceType.SCREEN && sourceType != CaptureSourceInterface.SourceType.VIRTUAL_CAMERA) {
            throw new IllegalArgumentException("type: ".concat(String.valueOf(sourceType)));
        }
        if (sourceType == sourceType2 && !(captureParams instanceof CameraCaptureParams)) {
            throw new IllegalArgumentException("CaptureParams is not CameraCaptureParams");
        }
        if (sourceType == CaptureSourceInterface.SourceType.SCREEN) {
            if (captureParams instanceof ScreenCapturer.ScreenCaptureParams) {
                if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
                    iVar.f44993b.notifyError(h.a.ERR_VIDEO_CAPTURE_SCREEN_UNSUPPORTED, "not support screen capture");
                }
            } else {
                throw new IllegalArgumentException("CaptureParams is not ScreenCaptureParams");
            }
        }
        if (sourceType == CaptureSourceInterface.SourceType.VIRTUAL_CAMERA && !(captureParams instanceof VirtualCamera.VirtualCameraParams)) {
            throw new IllegalArgumentException("CaptureParams is not VirtualCameraParams");
        }
        iVar.a(aq.a(iVar, sourceType, cameraCaptureMode, captureParams));
    }

    @CalledByNative
    public void startCustomCapture() {
        i iVar = this.mProducer;
        iVar.a(ag.a(iVar));
    }

    @CalledByNative
    public void startEncodeStream(VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        i iVar = this.mProducer;
        iVar.a(l.a(iVar, streamType, videoEncodeParams, videoEncoderDataListener));
    }

    @CalledByNative
    public void stopCapture(int i10) {
        i iVar = this.mProducer;
        iVar.a(av.a(iVar), i10);
    }

    @CalledByNative
    public void stopCustomCapture() {
        i iVar = this.mProducer;
        iVar.a(ai.a(iVar));
    }

    @CalledByNative
    public void stopEncodeStream(VideoProducerDef.StreamType streamType) {
        i iVar = this.mProducer;
        iVar.a(m.a(iVar, streamType), 2000L);
    }

    @CalledByNative
    public void takeSnapshot(SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        i iVar = this.mProducer;
        iVar.a(ae.a(iVar, snapshotSourceType, takeSnapshotListener));
    }

    @CalledByNative
    public void uninitialize() {
        i iVar = this.mProducer;
        iVar.a(u.a(iVar));
    }

    public VideoProducerProxy(@NonNull Context context, boolean z10, @NonNull IVideoReporter iVideoReporter) {
        this.mProducer = new i(context, z10, iVideoReporter);
    }
}
