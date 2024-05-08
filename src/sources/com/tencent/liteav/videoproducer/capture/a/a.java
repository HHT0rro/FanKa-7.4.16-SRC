package com.tencent.liteav.videoproducer.capture.a;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.huawei.quickcard.base.Attributes;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;
import com.tencent.liteav.videoproducer.capture.CaptureCloudConfig;
import com.tencent.liteav.videoproducer.capture.ai;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends CameraControllerInterface implements Camera.ErrorCallback {

    /* renamed from: b, reason: collision with root package name */
    private Camera f44241b;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceTexture f44243d;

    /* renamed from: e, reason: collision with root package name */
    private Size f44244e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f44245f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f44246g;

    /* renamed from: j, reason: collision with root package name */
    private CameraEventCallback f44249j;

    /* renamed from: l, reason: collision with root package name */
    private float f44251l;

    /* renamed from: a, reason: collision with root package name */
    private boolean f44240a = true;

    /* renamed from: c, reason: collision with root package name */
    private Rotation f44242c = Rotation.NORMAL;

    /* renamed from: h, reason: collision with root package name */
    private boolean f44247h = true;

    /* renamed from: i, reason: collision with root package name */
    private int f44248i = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f44250k = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f44252m = false;

    /* renamed from: n, reason: collision with root package name */
    private float f44253n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    private ServerVideoProducerConfig f44254o = null;

    /* renamed from: p, reason: collision with root package name */
    private CaptureCloudConfig f44255p = null;

    /* renamed from: q, reason: collision with root package name */
    private final Camera.AutoFocusCallback f44256q = b.a();

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableTapToFocus(boolean z10) {
        Camera.Parameters a10;
        this.f44247h = z10;
        if (this.f44241b == null || (a10 = a()) == null) {
            return;
        }
        try {
            a(a10, z10);
            this.f44241b.setParameters(a10);
        } catch (Throwable th) {
            LiteavLog.e("CameraController", "enableTapToFocus failed.", th);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final Rotation getCameraRotation() {
        return this.f44242c;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getCameraRotationValue() {
        return this.f44242c.mValue;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getMaxZoom() {
        int i10 = this.f44248i;
        if (i10 != 0) {
            return i10;
        }
        if (this.f44241b != null) {
            Camera.Parameters a10 = a();
            if (a10 == null) {
                return this.f44248i;
            }
            if (a10.getMaxZoom() > 0 && a10.isZoomSupported()) {
                this.f44248i = a10.getMaxZoom();
            }
        }
        return this.f44248i;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final Size getPreviewSize() {
        return this.f44244e;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraAutoFocusFaceModeSupported() {
        Camera.Parameters a10;
        return (this.f44241b == null || (a10 = a()) == null || a10.getMaxNumDetectedFaces() <= 0) ? false : true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraFocusPositionInPreviewSupported() {
        return this.f44245f;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCurrentPreviewSizeAspectRatioMatch(int i10, int i11, boolean z10) {
        boolean z11 = false;
        if (this.f44241b != null) {
            Camera.Parameters a10 = a();
            if (a10 == null) {
                return true;
            }
            Size a11 = a(a10, this.f44242c, i10, i11);
            if (a11 != null) {
                int i12 = a11.width * a11.height;
                Size size = this.f44244e;
                boolean z12 = i12 <= size.height * size.width;
                if (!z10 || Math.abs(a11.aspectRatio() - this.f44244e.aspectRatio()) <= 0.001d) {
                    z11 = z12;
                }
                LiteavLog.i("CameraController", "isCurrentPreviewSizeAspectRatioMatch : ".concat(String.valueOf(z11)));
                return z11;
            }
        }
        z11 = true;
        LiteavLog.i("CameraController", "isCurrentPreviewSizeAspectRatioMatch : ".concat(String.valueOf(z11)));
        return z11;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isTorchSupported() {
        Camera.Parameters a10;
        List<String> supportedFlashModes;
        return (this.f44241b == null || (a10 = a()) == null || (supportedFlashModes = a10.getSupportedFlashModes()) == null || !supportedFlashModes.contains("torch")) ? false : true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isZoomSupported() {
        Camera.Parameters a10;
        return this.f44241b != null && (a10 = a()) != null && a10.getMaxZoom() > 0 && a10.isZoomSupported();
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i10, Camera camera) {
        CameraEventCallback cameraEventCallback;
        LiteavLog.e("CameraController", "onError, error:".concat(String.valueOf(i10)));
        if ((i10 == 1 || i10 == 2 || i10 == 100) && (cameraEventCallback = this.f44249j) != null) {
            cameraEventCallback.onCameraError(this);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setCloudConfig(CaptureCloudConfig captureCloudConfig) {
        this.f44255p = captureCloudConfig;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setExposureCompensation(float f10) {
        this.f44251l = f10;
        this.f44250k = true;
        if (this.f44241b == null) {
            return;
        }
        this.f44250k = false;
        Camera.Parameters a10 = a();
        if (a10 == null) {
            return;
        }
        a10.setExposureCompensation(a(a10, f10));
        try {
            this.f44241b.setParameters(a10);
        } catch (Throwable th) {
            LiteavLog.e("CameraController", "set exposure compensation failed.", th);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f44254o = serverVideoProducerConfig;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setZoom(float f10) {
        this.f44253n = f10;
        this.f44252m = true;
        if (this.f44241b == null) {
            return;
        }
        this.f44252m = false;
        Camera.Parameters a10 = a();
        if (a10 == null) {
            return;
        }
        if (a10.getMaxZoom() > 0 && a10.isZoomSupported()) {
            int maxZoom = a10.getMaxZoom();
            try {
                a10.setZoom(h.a(Math.round(f10 * maxZoom), 0, maxZoom));
                this.f44241b.setParameters(a10);
                return;
            } catch (Throwable th) {
                LiteavLog.e("CameraController", "set zoom failed.", th);
                return;
            }
        }
        LiteavLog.i("CameraController", "camera doesn't support zoom!");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void startAutoFocusAtPosition(int i10, int i11) {
        if (this.f44247h) {
            if (i10 >= 0) {
                Size size = this.f44244e;
                if (i10 < size.width && i11 >= 0 && i11 < size.height) {
                    LiteavLog.i("CameraController", "Start auto focus at (%d, %d)", Integer.valueOf(i10), Integer.valueOf(i11));
                    try {
                        this.f44241b.cancelAutoFocus();
                        Camera.Parameters a10 = a();
                        if (a10 == null) {
                            return;
                        }
                        if (this.f44245f) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new Camera.Area(a(i10, i11, 2.0f), 1000));
                            a10.setFocusAreas(arrayList);
                        }
                        if (this.f44246g) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(new Camera.Area(a(i10, i11, 3.0f), 1000));
                            a10.setMeteringAreas(arrayList2);
                        }
                        try {
                            this.f44241b.setParameters(a10);
                            this.f44241b.autoFocus(this.f44256q);
                            return;
                        } catch (Throwable th) {
                            LiteavLog.e("CameraController", "auto focus failed.", th);
                            return;
                        }
                    } catch (Throwable th2) {
                        LiteavLog.e("CameraController", "cancel auto focus failed.", th2);
                        return;
                    }
                }
            }
            LiteavLog.w("CameraController", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0146 A[Catch: all -> 0x017d, TryCatch #0 {all -> 0x017d, blocks: (B:5:0x000b, B:7:0x0010, B:10:0x0017, B:12:0x003a, B:14:0x0046, B:15:0x007c, B:18:0x00ab, B:21:0x00b6, B:23:0x00c1, B:25:0x00cb, B:27:0x00d1, B:28:0x00e5, B:30:0x00e9, B:31:0x00f4, B:33:0x0113, B:34:0x0133, B:35:0x013c, B:37:0x0146, B:38:0x015d, B:40:0x0154, B:41:0x0123, B:43:0x012b, B:46:0x0055, B:48:0x0059, B:50:0x0065, B:51:0x0074, B:52:0x0175, B:53:0x017c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0154 A[Catch: all -> 0x017d, TryCatch #0 {all -> 0x017d, blocks: (B:5:0x000b, B:7:0x0010, B:10:0x0017, B:12:0x003a, B:14:0x0046, B:15:0x007c, B:18:0x00ab, B:21:0x00b6, B:23:0x00c1, B:25:0x00cb, B:27:0x00d1, B:28:0x00e5, B:30:0x00e9, B:31:0x00f4, B:33:0x0113, B:34:0x0133, B:35:0x013c, B:37:0x0146, B:38:0x015d, B:40:0x0154, B:41:0x0123, B:43:0x012b, B:46:0x0055, B:48:0x0059, B:50:0x0065, B:51:0x0074, B:52:0x0175, B:53:0x017c), top: B:2:0x0007 }] */
    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams r8, android.graphics.SurfaceTexture r9, com.tencent.liteav.videoproducer.capture.CameraEventCallback r10) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.a.a.startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams, android.graphics.SurfaceTexture, com.tencent.liteav.videoproducer.capture.CameraEventCallback):boolean");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void stopCapture() {
        LiteavLog.i("CameraController", "stopCapture");
        try {
            Camera camera = this.f44241b;
            if (camera != null) {
                camera.setErrorCallback(null);
                this.f44241b.stopPreview();
                this.f44241b.release();
                this.f44241b = null;
            }
        } catch (Throwable th) {
            LiteavLog.e("CameraController", "closeCamera fail, Exception:".concat(String.valueOf(th)));
        }
        this.f44243d = null;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void turnOnTorch(boolean z10) {
        List<String> supportedFlashModes;
        if (this.f44241b == null) {
            return;
        }
        String str = z10 ? "torch" : "off";
        Camera.Parameters a10 = a();
        if (a10 == null || (supportedFlashModes = a10.getSupportedFlashModes()) == null || !supportedFlashModes.contains(str)) {
            return;
        }
        try {
            a10.setFlashMode(str);
            this.f44241b.setParameters(a10);
        } catch (Throwable th) {
            LiteavLog.e("CameraController", "enable torch failed.", th);
        }
    }

    private Rect a(float f10, float f11, float f12) {
        int i10 = (int) (f12 * 200.0f);
        Size size = this.f44244e;
        int i11 = (int) (((f10 / size.width) * 2000.0f) - 1000.0f);
        int i12 = (int) (((f11 / size.height) * 2000.0f) - 1000.0f);
        int i13 = i10 / 2;
        int a10 = h.a(i11 - i13, -1000, 1000);
        int a11 = h.a(a10 + i10, -1000, 1000);
        int a12 = h.a(i12 - i13, -1000, 1000);
        return new Rect(a10, a12, a11, h.a(i10 + a12, -1000, 1000));
    }

    private static int a(Camera.Parameters parameters, float f10) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        if (minExposureCompensation == 0 && maxExposureCompensation == 0) {
            LiteavLog.i("CameraController", "camera doesn't support exposure compensation");
            return minExposureCompensation;
        }
        com.tencent.liteav.base.a.a.a();
        return h.a((int) (h.a(f10, -1.0f, 1.0f) * maxExposureCompensation), minExposureCompensation, maxExposureCompensation);
    }

    private static int a(boolean z10, Camera.CameraInfo cameraInfo) {
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < Camera.getNumberOfCameras(); i12++) {
            Camera.getCameraInfo(i12, cameraInfo);
            LiteavLog.i("CameraController", "get camera info, index: " + i12 + ", facing: " + cameraInfo.facing);
            if (i10 == -1 && cameraInfo.facing == 1) {
                i10 = i12;
            } else if (i11 == -1 && cameraInfo.facing == 0) {
                i11 = i12;
            }
        }
        if (!z10 ? i11 != -1 : i10 == -1) {
            i10 = i11;
        }
        Camera.getCameraInfo(i10, cameraInfo);
        return i10;
    }

    private static Size a(Camera.Parameters parameters, Rotation rotation, int i10, int i11) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes != null) {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new Size(size.width, size.height));
            }
        }
        return ai.a(arrayList, rotation, i10, i11);
    }

    private static void a(Camera.Parameters parameters, boolean z10) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return;
        }
        if (z10 && supportedFocusModes.contains(Attributes.LayoutDirection.AUTO)) {
            parameters.setFocusMode(Attributes.LayoutDirection.AUTO);
            LiteavLog.i("CameraController", "set focus mode to auto");
        } else if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            LiteavLog.i("CameraController", "set focus mode to continuous-video");
        }
    }

    private int a(int i10) {
        Camera.Parameters a10 = a();
        if (a10 == null) {
            return 1;
        }
        List<Integer> supportedPreviewFrameRates = a10.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null && !supportedPreviewFrameRates.isEmpty()) {
            int intValue = supportedPreviewFrameRates.get(0).intValue();
            Iterator<Integer> iterator2 = supportedPreviewFrameRates.iterator2();
            while (iterator2.hasNext()) {
                int intValue2 = iterator2.next().intValue();
                if (Math.abs(i10 - intValue2) < Math.abs(i10 - intValue)) {
                    intValue = intValue2;
                }
            }
            LiteavLog.i("CameraController", "best matched frame rate: %d", Integer.valueOf(intValue));
            return intValue;
        }
        LiteavLog.e("CameraController", "supported preview frame rates is empty");
        return 1;
    }

    private static int[] a(Camera.Parameters parameters, int i10) {
        int i11 = i10 * 1000;
        LiteavLog.i("CameraController", "preferred fps: ".concat(String.valueOf(i11)));
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int[] iArr = null;
        if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() > 0) {
            Collections.sort(supportedPreviewFpsRange, c.a());
            Iterator<int[]> iterator2 = supportedPreviewFpsRange.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                int[] next = iterator2.next();
                LiteavLog.i("CameraController", "supported fps range: " + next[0] + "->" + next[1]);
                if (next[0] <= i11 && i11 <= next[1]) {
                    iArr = next;
                    break;
                }
            }
            if (iArr != null) {
                LiteavLog.i("CameraController", "choosed fps range: " + iArr[0] + "->" + iArr[1]);
            }
        }
        return iArr;
    }

    public static /* synthetic */ int a(int[] iArr, int[] iArr2) {
        return iArr[1] - iArr2[1];
    }

    private Camera.Parameters a() {
        try {
            Camera camera = this.f44241b;
            if (camera != null) {
                return camera.getParameters();
            }
            return null;
        } catch (Throwable th) {
            LiteavLog.e("CameraController", "getCameraParameters failed.", th);
            return null;
        }
    }
}
