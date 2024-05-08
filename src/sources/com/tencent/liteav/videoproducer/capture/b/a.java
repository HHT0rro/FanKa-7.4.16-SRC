package com.tencent.liteav.videoproducer.capture.b;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.base.util.v;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;
import com.tencent.liteav.videoproducer.capture.CaptureCloudConfig;
import com.tencent.liteav.videoproducer.capture.ai;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.zego.zegoliveroom.constants.ZegoConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends CameraControllerInterface {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f44334c;

    /* renamed from: g, reason: collision with root package name */
    private final v f44339g;

    /* renamed from: l, reason: collision with root package name */
    private CaptureRequest f44344l;

    /* renamed from: m, reason: collision with root package name */
    private CaptureRequest.Builder f44345m;

    /* renamed from: n, reason: collision with root package name */
    private Size f44346n;

    /* renamed from: p, reason: collision with root package name */
    private SurfaceTexture f44348p;

    /* renamed from: w, reason: collision with root package name */
    private CountDownLatch f44355w;

    /* renamed from: x, reason: collision with root package name */
    private CountDownLatch f44356x;

    /* renamed from: y, reason: collision with root package name */
    private CameraEventCallback f44357y;

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, CameraCharacteristics> f44333b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static String f44335d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f44336e = "";

    /* renamed from: f, reason: collision with root package name */
    private final Handler f44338f = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f44340h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicReference<CameraDevice> f44341i = new AtomicReference<>();

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f44342j = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    private final AtomicReference<CameraCaptureSession> f44343k = new AtomicReference<>();

    /* renamed from: o, reason: collision with root package name */
    private Rotation f44347o = Rotation.NORMAL;

    /* renamed from: q, reason: collision with root package name */
    private boolean f44349q = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f44350r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f44351s = true;

    /* renamed from: t, reason: collision with root package name */
    private int f44352t = -1;

    /* renamed from: u, reason: collision with root package name */
    private EnumC0645a f44353u = EnumC0645a.IDLE;

    /* renamed from: v, reason: collision with root package name */
    private boolean f44354v = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f44337a = false;

    /* renamed from: z, reason: collision with root package name */
    private float f44358z = 0.0f;
    private float A = 0.0f;
    private final CameraDevice.StateCallback B = new CameraDevice.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.1
        private void a(CameraDevice cameraDevice) {
            if (a.this.f44340h.get()) {
                a.c(a.this);
            } else {
                a.this.a(false, cameraDevice);
            }
        }

        private static String b(@Nullable CameraDevice cameraDevice) {
            if (cameraDevice == null) {
                return "null";
            }
            return "CameraDevice[id:" + cameraDevice.getId() + "]";
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(@NonNull CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onClosed!" + b(cameraDevice));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(@NonNull CameraDevice cameraDevice) {
            LiteavLog.e("Camera2Controller", "CameraDevice onDisconnected!" + b(cameraDevice));
            a(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(@NonNull CameraDevice cameraDevice, int i10) {
            LiteavLog.e("Camera2Controller", "CameraDevice onError!" + b(cameraDevice) + ", error:" + i10);
            a(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(@NonNull CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onOpen!" + b(cameraDevice));
            a.this.a(true, cameraDevice);
        }
    };
    private final CameraCaptureSession.StateCallback C = new CameraCaptureSession.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.2
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            LiteavLog.e("Camera2Controller", "CameraCaptureSession onConfigureFailed!");
            a.this.a(false, cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            LiteavLog.i("Camera2Controller", "CameraCaptureSession onConfigured!");
            a.this.a(true, cameraCaptureSession);
        }
    };
    private final CameraManager.AvailabilityCallback D = new CameraManager.AvailabilityCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.3
        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAccessPrioritiesChanged() {
            super.onCameraAccessPrioritiesChanged();
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAvailable(@NonNull String str) {
            super.onCameraAvailable(str);
            LiteavLog.i("Camera2Controller", "onCameraAvailable: ".concat(String.valueOf(str)));
            if (!a.this.g() && a.b(a.this.f44349q).equals(str) && a.this.f44340h.get()) {
                LiteavLog.w("Camera2Controller", "Current camera is available, it could be interrupted by system app.");
                a aVar = a.this;
                aVar.a(false, (CameraDevice) aVar.f44341i.get());
                a.c(a.this);
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraUnavailable(@NonNull String str) {
            super.onCameraUnavailable(str);
            LiteavLog.i("Camera2Controller", "onCameraUnavailable: ".concat(String.valueOf(str)));
        }
    };
    private final CameraCaptureSession.CaptureCallback E = new AnonymousClass4();

    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum EnumC0645a {
        IDLE,
        PREVIEWING
    }

    public a(v vVar) {
        this.f44339g = vVar;
    }

    private void c() {
        CameraDevice andSet = this.f44341i.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th) {
                LiteavLog.e("Camera2Controller", "closeCamera fail, Exception:".concat(String.valueOf(th)));
            }
        }
        ((CameraManager) ContextUtils.getApplicationContext().getSystemService(ZegoConstants.DeviceNameType.DeviceNameCamera)).unregisterAvailabilityCallback(this.D);
    }

    public static /* synthetic */ boolean g(a aVar) {
        aVar.f44354v = false;
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableTapToFocus(boolean z10) {
        this.f44350r = z10;
        c(z10);
        d();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final Rotation getCameraRotation() {
        return this.f44347o;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getCameraRotationValue() {
        return this.f44347o.mValue;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getMaxZoom() {
        return 100;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final Size getPreviewSize() {
        return this.f44346n;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraAutoFocusFaceModeSupported() {
        return a() != null && ((Integer) a().get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraFocusPositionInPreviewSupported() {
        return a() != null && ((Integer) a().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCurrentPreviewSizeAspectRatioMatch(int i10, int i11, boolean z10) {
        Size a10 = ai.a(e(), this.f44347o, i10, i11);
        boolean z11 = (!z10 || Math.abs(a10.aspectRatio() - this.f44346n.aspectRatio()) <= 0.001d) ? a10.getArea() <= this.f44346n.getArea() : false;
        LiteavLog.i("Camera2Controller", "isCurrentPreviewSizeAspectRatioMatch:".concat(String.valueOf(z11)));
        return z11;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isTorchSupported() {
        return a() != null && ((Boolean) a().get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isZoomSupported() {
        return a() != null && ((Float) a().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() > 0.0f;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setCloudConfig(CaptureCloudConfig captureCloudConfig) {
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setExposureCompensation(float f10) {
        this.f44358z = f10;
        b(f10);
        d();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setZoom(float f10) {
        this.A = f10;
        a(f10);
        d();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void startAutoFocusAtPosition(int i10, int i11) {
        double d10;
        double d11;
        if (this.f44350r && this.f44351s) {
            if (!g() && !this.f44354v) {
                CameraCaptureSession cameraCaptureSession = this.f44343k.get();
                if (cameraCaptureSession == null) {
                    LiteavLog.e("Camera2Controller", "CameraCaptureSession get fail");
                    return;
                }
                if (i10 >= 0) {
                    Size size = this.f44346n;
                    if (i10 < size.width && i11 >= 0 && i11 < size.height) {
                        LiteavLog.i("Camera2Controller", "Start auto focus at (%d, %d)", Integer.valueOf(i10), Integer.valueOf(i11));
                        double d12 = i10;
                        double d13 = i11;
                        Rect rect = (Rect) this.f44344l.get(CaptureRequest.SCALER_CROP_REGION);
                        if (rect == null) {
                            LiteavLog.e("Camera2Controller", "getMeteringRect can't get crop region");
                            rect = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        }
                        int width = rect.width();
                        int height = rect.height();
                        Size size2 = this.f44346n;
                        int i12 = size2.height;
                        int i13 = i12 * width;
                        int i14 = size2.width;
                        int i15 = i14 * height;
                        double d14 = ShadowDrawableWrapper.COS_45;
                        if (i13 > i15) {
                            d10 = (height * 1.0d) / i12;
                            d11 = 0.0d;
                            d14 = (width - (i14 * d10)) / 2.0d;
                        } else {
                            d10 = (width * 1.0d) / i14;
                            d11 = (height - (i12 * d10)) / 2.0d;
                        }
                        double d15 = (d12 * d10) + d14 + rect.left;
                        double d16 = (d13 * d10) + d11 + rect.top;
                        Rect rect2 = new Rect();
                        rect2.left = h.a((int) (d15 - (rect.width() * 0.05d)), 0, rect.width());
                        rect2.right = h.a((int) (d15 + (rect.width() * 0.05d)), 0, rect.width());
                        rect2.top = h.a((int) (d16 - (rect.height() * 0.05d)), 0, rect.height());
                        rect2.bottom = h.a((int) (d16 + (rect.height() * 0.05d)), 0, rect.height());
                        try {
                            this.f44345m.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
                            this.f44345m.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
                            this.f44345m.set(CaptureRequest.CONTROL_AF_MODE, 1);
                            this.f44345m.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                            this.f44345m.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                            this.f44354v = true;
                            this.f44337a = false;
                            this.f44345m.setTag(this);
                            cameraCaptureSession.setRepeatingRequest(this.f44345m.build(), this.E, this.f44338f);
                            return;
                        } catch (Throwable th) {
                            LiteavLog.e("Camera2Controller", "startAutoFocusAtPosition exception:".concat(String.valueOf(th)));
                            return;
                        }
                    }
                }
                LiteavLog.w("Camera2Controller", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i10), Integer.valueOf(i11));
                return;
            }
            LiteavLog.e("Camera2Controller", "autoFocus not preview, mCameraStatus:" + ((Object) this.f44353u) + " mIsAutoFocusing:" + this.f44354v);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0113  */
    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams r13, android.graphics.SurfaceTexture r14, com.tencent.liteav.videoproducer.capture.CameraEventCallback r15) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.b.a.startCapture(com.tencent.liteav.videoproducer.capture.CameraCaptureParams, android.graphics.SurfaceTexture, com.tencent.liteav.videoproducer.capture.CameraEventCallback):boolean");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void stopCapture() {
        CountDownLatch countDownLatch = this.f44355w;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        this.f44355w = null;
        CountDownLatch countDownLatch2 = this.f44356x;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        this.f44356x = null;
        b();
        c();
        this.f44344l = null;
        this.f44337a = false;
        this.f44340h.set(false);
        this.f44348p = null;
        this.f44352t = -1;
        this.f44353u = EnumC0645a.IDLE;
        LiteavLog.i("Camera2Controller", "stopCapture success");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void turnOnTorch(boolean z10) {
        if (g()) {
            LiteavLog.e("Camera2Controller", "turnOnTorch error mCameraStatus:" + ((Object) this.f44353u));
            return;
        }
        boolean z11 = true;
        if (z10 && this.f44352t != 2) {
            this.f44352t = 2;
        } else if (z10) {
            z11 = false;
        } else {
            this.f44352t = 0;
        }
        LiteavLog.i("Camera2Controller", "turnOnTorch:" + z10 + ", mode:" + this.f44352t + ", updateView:" + z11);
        if (z11) {
            this.f44345m.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.f44352t));
            d();
        }
    }

    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass4 extends CameraCaptureSession.CaptureCallback {
        public AnonymousClass4() {
        }

        private static boolean a(CaptureRequest captureRequest) {
            return (captureRequest.getTag() instanceof a) && !((a) captureRequest.getTag()).f44337a;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            a.this.f44339g.a(d.a(this, totalCaptureResult, captureRequest));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            LiteavLog.e("Camera2Controller", "onCaptureFailed failure reason:" + captureFailure.getReason());
            a.this.f44339g.a(e.a(this, captureRequest));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        }

        private void a(CaptureRequest captureRequest, boolean z10) {
            if (a.this.g()) {
                return;
            }
            a.g(a.this);
            try {
                a.this.f44345m.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                a.this.f44345m.set(CaptureRequest.CONTROL_AE_MODE, 1);
                a.this.f44345m.set(CaptureRequest.CONTROL_AF_MODE, 3);
                a.this.d();
                if (captureRequest.getTag() instanceof a) {
                    a.a((a) captureRequest.getTag(), z10);
                }
            } catch (Throwable th) {
                LiteavLog.e("Camera2Controller", "mAfCaptureCallback exception:".concat(String.valueOf(th)));
            }
        }

        public static /* synthetic */ void a(@NonNull AnonymousClass4 anonymousClass4, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                a.g(a.this);
            } else {
                anonymousClass4.a(captureRequest, false);
            }
        }

        public static /* synthetic */ void a(@NonNull AnonymousClass4 anonymousClass4, @NonNull TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                a.g(a.this);
                return;
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num == null) {
                LiteavLog.e("Camera2Controller", "handleCaptureCompleted get afState fail");
                anonymousClass4.a(captureRequest, false);
            } else if (4 == num.intValue() || 5 == num.intValue()) {
                anonymousClass4.a(captureRequest, true);
            }
        }
    }

    private void b(float f10) {
        if (this.f44345m != null && a() != null) {
            Range range = (Range) a().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
            int intValue = ((Integer) range.getLower()).intValue();
            int intValue2 = ((Integer) range.getUpper()).intValue();
            if (intValue == 0 && intValue2 == 0) {
                LiteavLog.i("Camera2Controller", "camera doesn't support exposure compensation");
                return;
            } else {
                this.f44345m.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(h.a(((int) (((intValue2 - intValue) * (h.a(f10, -1.0f, 1.0f) - (-1.0f))) / 2.0f)) + intValue, intValue, intValue2)));
                return;
            }
        }
        LiteavLog.e("Camera2Controller", "setExposureCompensation fail, value:" + f10 + " mCameraStatus:" + ((Object) this.f44353u));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CaptureRequest.Builder builder;
        CameraCaptureSession cameraCaptureSession = this.f44343k.get();
        if (cameraCaptureSession == null || (builder = this.f44345m) == null) {
            return;
        }
        try {
            cameraCaptureSession.setRepeatingRequest(builder.build(), null, null);
        } catch (Throwable th) {
            LiteavLog.e("Camera2Controller", "updatePreview exception:".concat(String.valueOf(th)));
        }
    }

    private List<Size> e() {
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes error, Characteristics is null");
            return null;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a().get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes map null");
            return null;
        }
        android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (outputSizes == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes choices is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : outputSizes) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    private List<int[]> f() {
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "getPreviewFps error, Characteristics: ", a());
            return null;
        }
        Range[] rangeArr = (Range[]) a().get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        ArrayList arrayList = new ArrayList();
        if (rangeArr != null) {
            for (Range range : rangeArr) {
                arrayList.add(new int[]{((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue()});
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return a() == null || this.f44345m == null || this.f44353u != EnumC0645a.PREVIEWING;
    }

    private void a(float f10) {
        if (this.f44345m != null && a() != null) {
            this.f44345m.set(CaptureRequest.SCALER_CROP_REGION, c(f10));
            return;
        }
        LiteavLog.e("Camera2Controller", "setZoom fail, scale:" + f10 + " mPreviewBuilder is null.");
    }

    private void c(boolean z10) {
        CaptureRequest.Builder builder = this.f44345m;
        if (builder == null) {
            return;
        }
        int i10 = z10 ? 1 : 3;
        builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i10));
        LiteavLog.i("Camera2Controller", "setFocusModeWithoutUpdatePreview to ".concat(String.valueOf(i10)));
    }

    public static /* synthetic */ void a(a aVar) {
        if (aVar.g()) {
            LiteavLog.e("Camera2Controller", "onCameraError, but camera is invalid, do not send camera error.");
            return;
        }
        CameraEventCallback cameraEventCallback = aVar.f44357y;
        if (cameraEventCallback != null) {
            cameraEventCallback.onCameraError(aVar);
        }
    }

    private Rect c(float f10) {
        Rect rect = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        float floatValue = ((Float) a().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        float f11 = floatValue - 1.0f;
        float a10 = (h.a(f10, 0.0f, 1.0f) * f11) + 1.0f;
        int width = (int) (rect.width() / floatValue);
        int width2 = rect.width() - width;
        int height = rect.height() - ((int) (rect.height() / floatValue));
        float f12 = a10 - 1.0f;
        int i10 = (int) (((width2 * f12) / f11) / 2.0f);
        int i11 = (int) (((height * f12) / f11) / 2.0f);
        Rect rect2 = new Rect(i10, i11, rect.width() - i10, rect.height() - i11);
        LiteavLog.i("Camera2Controller", "calculateZoomRect calculatedZoomLevel:" + a10 + " rect:" + ((Object) rect) + " newRect2:" + ((Object) rect2));
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, CameraDevice cameraDevice) {
        CountDownLatch countDownLatch = this.f44355w;
        this.f44340h.set(z10);
        this.f44341i.set(cameraDevice);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(boolean z10) {
        return z10 ? !TextUtils.isEmpty(f44336e) ? f44336e : f44335d : !TextUtils.isEmpty(f44335d) ? f44335d : f44336e;
    }

    private void b() {
        CameraCaptureSession andSet = this.f44343k.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th) {
                LiteavLog.e("Camera2Controller", "closePreviewSession fail, Exception:".concat(String.valueOf(th)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, CameraCaptureSession cameraCaptureSession) {
        CountDownLatch countDownLatch = this.f44356x;
        this.f44342j.set(z10);
        this.f44343k.set(cameraCaptureSession);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public static /* synthetic */ void c(a aVar) {
        aVar.f44339g.a(b.a(aVar));
    }

    private CameraCharacteristics a() {
        String b4 = b(this.f44349q);
        if (TextUtils.isEmpty(b4)) {
            return null;
        }
        return f44333b.get(b4);
    }

    private boolean a(int i10, int i11) {
        String b4 = b(this.f44349q);
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "openCamera fail getCameraCharacteristics null");
            return false;
        }
        this.f44347o = Rotation.a(((Integer) a().get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue());
        this.f44346n = ai.a(e(), this.f44347o, i10, i11);
        StringBuilder sb2 = new StringBuilder("openCamera ,id:");
        sb2.append(b4);
        sb2.append(",");
        sb2.append(this.f44349q ? "front camera" : "back camera");
        sb2.append(" mPreviewSize ");
        sb2.append((Object) this.f44346n);
        sb2.append(" mCameraRotation ");
        sb2.append((Object) this.f44347o);
        sb2.append(" mIsCameraSupportAutoFocus ");
        sb2.append(this.f44351s);
        LiteavLog.i("Camera2Controller", sb2.toString());
        try {
            this.f44355w = new CountDownLatch(1);
            ((CameraManager) ContextUtils.getApplicationContext().getSystemService(ZegoConstants.DeviceNameType.DeviceNameCamera)).openCamera(b4, this.B, this.f44338f);
            this.f44355w.await();
        } catch (Throwable th) {
            LiteavLog.e("Camera2Controller", "openCamera exception:".concat(String.valueOf(th)));
            a(false, (CameraDevice) null);
        }
        return this.f44340h.get();
    }

    private boolean a(SurfaceTexture surfaceTexture) {
        CameraDevice cameraDevice;
        try {
            cameraDevice = this.f44341i.get();
        } catch (Throwable th) {
            LiteavLog.e("Camera2Controller", "startPreview exception", th);
            a(false, (CameraCaptureSession) null);
        }
        if (cameraDevice != null && surfaceTexture != null) {
            b();
            SurfaceTexture surfaceTexture2 = this.f44348p;
            Size size = this.f44346n;
            surfaceTexture2.setDefaultBufferSize(size.width, size.height);
            Surface surface = new Surface(this.f44348p);
            CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(3);
            this.f44345m = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            List<Surface> singletonList = Collections.singletonList(surface);
            this.f44356x = new CountDownLatch(1);
            cameraDevice.createCaptureSession(singletonList, this.C, this.f44338f);
            this.f44356x.await();
            return this.f44342j.get();
        }
        throw new IOException("startPreview cameraDevice null!");
    }

    private Range<Integer> a(int i10) {
        LiteavLog.i("Camera2Controller", "preferred fps: ".concat(String.valueOf(i10)));
        Range<Integer> range = new Range<>(Integer.valueOf(i10), Integer.valueOf(i10));
        List<int[]> f10 = f();
        if (com.tencent.liteav.videobase.utils.c.a(f10)) {
            return range;
        }
        Collections.sort(f10, c.a());
        int[] iArr = null;
        Iterator<int[]> iterator2 = f10.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            int[] next = iterator2.next();
            if (next[0] <= i10 && i10 <= next[1]) {
                iArr = next;
                break;
            }
        }
        return (iArr == null || iArr.length < 2) ? range : new Range<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
    }

    public static /* synthetic */ int a(int[] iArr, int[] iArr2) {
        return iArr[1] - iArr2[1];
    }

    public static /* synthetic */ void a(a aVar, boolean z10) {
        LiteavLog.i("Camera2Controller", "onFocusCallback success:".concat(String.valueOf(z10)));
        aVar.f44337a = true;
    }
}
