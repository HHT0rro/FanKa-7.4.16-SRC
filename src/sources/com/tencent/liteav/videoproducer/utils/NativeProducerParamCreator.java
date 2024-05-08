package com.tencent.liteav.videoproducer.utils;

import android.graphics.Bitmap;
import android.media.projection.MediaProjection;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;
import com.tencent.liteav.videoproducer.encoder.NativeEncoderDataListener;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeProducerParamCreator {
    private static final String TAG = "CaptureParamsHelper";

    @CalledByNative
    public static Boolean createBooleanWithValue(boolean z10) {
        return Boolean.valueOf(z10);
    }

    @CalledByNative
    public static VideoProducerDef.CameraCaptureMode createCameraCaptureMode(int i10) {
        return VideoProducerDef.CameraCaptureMode.a(i10);
    }

    @CalledByNative
    public static CameraCaptureParams createCameraParams(Boolean bool, int i10, int i11, int i12) {
        CameraCaptureParams cameraCaptureParams = new CameraCaptureParams();
        cameraCaptureParams.f44172a = bool;
        cameraCaptureParams.f44181b = i10;
        cameraCaptureParams.f44182c = i11;
        cameraCaptureParams.f44183d = i12;
        return cameraCaptureParams;
    }

    @CalledByNative
    public static VideoEncoderDef.EncodeStrategy createEncoderStrategy(int i10) {
        return VideoEncoderDef.EncodeStrategy.a(i10);
    }

    @CalledByNative
    public static VideoProducerDef.GSensorMode createGSensorMode(int i10) {
        return VideoProducerDef.GSensorMode.a(i10);
    }

    @CalledByNative
    public static VideoProducerDef.HomeOrientation createHomeOrientation(int i10) {
        return VideoProducerDef.HomeOrientation.a(i10);
    }

    @CalledByNative
    public static GLConstants.MirrorMode createMirrorMode(int i10) {
        return GLConstants.MirrorMode.a(i10);
    }

    @CalledByNative
    public static NativeEncoderDataListener createNativeEncoderDataListener(long j10, int i10) {
        return new NativeEncoderDataListener(j10, i10);
    }

    @CalledByNative
    public static GLConstants.PixelBufferType createPixelBufferType(int i10) {
        return GLConstants.PixelBufferType.a(i10);
    }

    @CalledByNative
    public static GLConstants.PixelFormatType createPixelFormatType(int i10) {
        return GLConstants.PixelFormatType.a(i10);
    }

    @CalledByNative
    public static GLConstants.ResolutionMode createResolutionMode(int i10) {
        return GLConstants.ResolutionMode.a(i10);
    }

    @CalledByNative
    public static Rotation createRotation(int i10) {
        return Rotation.a(i10);
    }

    @CalledByNative
    public static GLConstants.GLScaleType createScaleType(int i10) {
        return GLConstants.GLScaleType.a(i10);
    }

    @CalledByNative
    public static ScreenCapturer.ScreenCaptureParams createScreenParams(boolean z10, int i10, int i11, int i12, MediaProjection mediaProjection, boolean z11) {
        ScreenCapturer.ScreenCaptureParams screenCaptureParams = new ScreenCapturer.ScreenCaptureParams();
        screenCaptureParams.f44210a = z10;
        screenCaptureParams.f44181b = i10;
        screenCaptureParams.f44182c = i11;
        screenCaptureParams.f44183d = i12;
        screenCaptureParams.f44211f = mediaProjection;
        screenCaptureParams.f44212g = z11;
        return screenCaptureParams;
    }

    @CalledByNative
    public static SnapshotSourceType createSnapshotSourceType(int i10) {
        return SnapshotSourceType.a(i10);
    }

    @CalledByNative
    public static CaptureSourceInterface.SourceType createSourceType(int i10) {
        return CaptureSourceInterface.SourceType.a(i10);
    }

    @CalledByNative
    public static VideoProducerDef.StreamType createStreamType(int i10) {
        return VideoProducerDef.StreamType.a(i10);
    }

    @CalledByNative
    public static VirtualCamera.VirtualCameraParams createVirtualParams(Bitmap bitmap, int i10, int i11, int i12) {
        VirtualCamera.VirtualCameraParams virtualCameraParams = new VirtualCamera.VirtualCameraParams();
        virtualCameraParams.f44220a = bitmap;
        virtualCameraParams.f44181b = i10;
        virtualCameraParams.f44182c = i11;
        virtualCameraParams.f44183d = i12;
        return virtualCameraParams;
    }
}
