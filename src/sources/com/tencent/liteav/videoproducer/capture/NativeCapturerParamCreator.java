package com.tencent.liteav.videoproducer.capture;

import android.graphics.Bitmap;
import android.media.projection.MediaProjection;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeCapturerParamCreator {
    @CalledByNative
    public static Boolean createBooleanWithValue(boolean z10) {
        return Boolean.valueOf(z10);
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
    public static ScreenCapturer.ScreenCaptureParams createScreenParams(boolean z10, int i10, int i11, int i12, MediaProjection mediaProjection) {
        ScreenCapturer.ScreenCaptureParams screenCaptureParams = new ScreenCapturer.ScreenCaptureParams();
        screenCaptureParams.f44210a = z10;
        screenCaptureParams.f44181b = i10;
        screenCaptureParams.f44182c = i11;
        screenCaptureParams.f44183d = i12;
        screenCaptureParams.f44211f = mediaProjection;
        return screenCaptureParams;
    }

    @CalledByNative
    public static CaptureSourceInterface.SourceType createSourceType(int i10) {
        return CaptureSourceInterface.SourceType.a(i10);
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
