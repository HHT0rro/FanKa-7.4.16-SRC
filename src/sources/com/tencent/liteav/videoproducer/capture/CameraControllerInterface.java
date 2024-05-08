package com.tencent.liteav.videoproducer.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class CameraControllerInterface {
    private static final String TAG = "CameraControllerInterface";

    /* renamed from: com.tencent.liteav.videoproducer.capture.CameraControllerInterface$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44175a;

        static {
            int[] iArr = new int[a.values().length];
            f44175a = iArr;
            try {
                iArr[a.CAMERA_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44175a[a.CAMERA_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        MOCK(0),
        CAMERA_1(1),
        CAMERA_2(2);

        private final int mValue;

        a(int i10) {
            this.mValue = i10;
        }

        public static a a(int i10) {
            for (a aVar : values()) {
                if (aVar.mValue == i10) {
                    return aVar;
                }
            }
            return CAMERA_1;
        }
    }

    @CalledByNative
    public static CameraControllerInterface createCameraController(int i10, @NonNull final Handler handler) {
        CameraControllerInterface aVar;
        a a10 = a.a(i10);
        if (AnonymousClass1.f44175a[a10.ordinal()] != 1) {
            aVar = new com.tencent.liteav.videoproducer.capture.a.a();
        } else {
            handler.getClass();
            aVar = new com.tencent.liteav.videoproducer.capture.b.a(new com.tencent.liteav.base.util.v(handler) { // from class: com.tencent.liteav.videoproducer.capture.ah

                /* renamed from: a, reason: collision with root package name */
                private final Handler f44271a;

                {
                    this.f44271a = handler;
                }

                @Override // com.tencent.liteav.base.util.v
                public final void a(Runnable runnable) {
                    this.f44271a.post(runnable);
                }
            });
        }
        LiteavLog.i(TAG, "createCameraController, CameraAPIType:" + ((Object) a10) + ", return camera controller: " + ((Object) aVar));
        return aVar;
    }

    @CalledByNative
    public abstract void enableTapToFocus(boolean z10);

    public abstract Rotation getCameraRotation();

    @CalledByNative
    public abstract int getCameraRotationValue();

    @CalledByNative
    public abstract int getMaxZoom();

    @CalledByNative
    public abstract Size getPreviewSize();

    @CalledByNative
    public abstract boolean isCameraAutoFocusFaceModeSupported();

    @CalledByNative
    public abstract boolean isCameraFocusPositionInPreviewSupported();

    @CalledByNative
    public abstract boolean isCurrentPreviewSizeAspectRatioMatch(int i10, int i11, boolean z10);

    @CalledByNative
    public abstract boolean isTorchSupported();

    @CalledByNative
    public abstract boolean isZoomSupported();

    @CalledByNative
    public abstract void setCloudConfig(CaptureCloudConfig captureCloudConfig);

    @CalledByNative
    public abstract void setExposureCompensation(float f10);

    public abstract void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig);

    @CalledByNative
    public abstract void setZoom(float f10);

    @CalledByNative
    public abstract void startAutoFocusAtPosition(int i10, int i11);

    @CalledByNative
    public abstract boolean startCapture(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, CameraEventCallback cameraEventCallback);

    @CalledByNative
    public abstract void stopCapture();

    @CalledByNative
    public abstract void turnOnTorch(boolean z10);
}
