package com.tencent.liteav.videoproducer.capture;

import android.graphics.SurfaceTexture;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.l;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CameraCaptureSingleton implements SurfaceTexture.OnFrameAvailableListener, CameraEventCallback {
    private static final int DELAY_FOR_RESTART_CAMERA = 2000;
    private static final int HOLD_POOL_MAX_SIZE = 1;
    private static final String TAG = "CameraCaptureSingleton";
    private static final boolean USE_DEFAULT_FRONT_CAMERA = true;
    private static volatile CameraCaptureSingleton sInstance;
    private CameraControllerInterface mCameraController;
    private volatile Rotation mCameraRotation;
    private CaptureCloudConfig mCloudConfig;
    public EGLCore mEGLCore;
    private boolean mEnableTapToFocus;
    private boolean mEnableZoom;
    private final AtomicBoolean mExpectFrontCamera;
    private float mExposureCompensation;
    public com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private boolean mIsCameraAutoFocusFaceModeSupported;
    private boolean mIsCameraSuccessfullyOpened;
    private boolean mIsFirstFrameCaptured;
    private boolean mIsFocusPositionInPreviewSupported;
    private boolean mIsTorchSupported;
    private boolean mIsZoomSupported;
    private int mMaxZoomLevel;
    private int mOESTextureId;
    private PixelFrame mPixelFrame;
    private final Runnable mRestartCameraRunnable;
    private final com.tencent.liteav.base.util.l mSequenceTaskRunner;
    private ServerVideoProducerConfig mServerConfig;
    private Object mSharedContext;
    private SurfaceTexture mSurfaceTexture;
    private com.tencent.liteav.videobase.frame.l mTextureHolderPool;
    private float mZoomPercent;
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    private final float[] mMatrix = new float[16];
    private boolean mNeedNotifyStartFinish = true;
    private final at mListenerManager = new at();
    private final ai mCameraSupervisor = new ai();
    public int mPausedCount = 0;
    public CameraCaptureParams mCurrentCaptureParams = null;

    /* renamed from: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44174a;

        static {
            int[] iArr = new int[CameraControllerInterface.a.values().length];
            f44174a = iArr;
            try {
                iArr[CameraControllerInterface.a.MOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44174a[CameraControllerInterface.a.CAMERA_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44174a[CameraControllerInterface.a.CAMERA_1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private CameraCaptureSingleton() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.mExpectFrontCamera = atomicBoolean;
        this.mOESTextureId = -1;
        this.mEnableTapToFocus = false;
        this.mEnableZoom = false;
        this.mZoomPercent = 0.0f;
        this.mExposureCompensation = 0.0f;
        this.mCameraRotation = Rotation.NORMAL;
        this.mIsFirstFrameCaptured = false;
        this.mIsZoomSupported = false;
        this.mIsTorchSupported = false;
        this.mIsFocusPositionInPreviewSupported = false;
        this.mIsCameraAutoFocusFaceModeSupported = false;
        this.mMaxZoomLevel = 0;
        this.mIsCameraSuccessfullyOpened = false;
        this.mServerConfig = null;
        this.mCloudConfig = null;
        this.mRestartCameraRunnable = new Runnable() { // from class: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.1
            @Override // java.lang.Runnable
            public final void run() {
                CameraCaptureSingleton cameraCaptureSingleton;
                CameraCaptureParams cameraCaptureParams;
                LiteavLog.i(CameraCaptureSingleton.TAG, "restart camera runnable.");
                if (LiteavSystemInfo.getAppBackgroundState() == 1) {
                    LiteavLog.i(CameraCaptureSingleton.TAG, "not in Foreground");
                    CameraCaptureSingleton.this.scheduleRestartCameraTask();
                } else {
                    if (CameraCaptureSingleton.this.mCameraController != null || (cameraCaptureParams = (cameraCaptureSingleton = CameraCaptureSingleton.this).mCurrentCaptureParams) == null) {
                        return;
                    }
                    cameraCaptureSingleton.openCamera(cameraCaptureParams);
                }
            }
        };
        this.mSequenceTaskRunner = new com.tencent.liteav.base.util.l();
        atomicBoolean.set(true);
    }

    private void checkFirstFrameCaptured() {
        if (this.mIsFirstFrameCaptured) {
            return;
        }
        this.mIsFirstFrameCaptured = true;
        LiteavLog.d(TAG, "camera capture first frame.");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void closeCamera() {
        /*
            r5 = this;
            java.lang.String r0 = "CameraCaptureSingleton"
            java.lang.String r1 = "closeCamera"
            com.tencent.liteav.base.util.LiteavLog.i(r0, r1)
            r1 = 0
            r2 = 0
            com.tencent.liteav.videoproducer.capture.CameraControllerInterface r3 = r5.mCameraController     // Catch: java.lang.Throwable -> L19
            if (r3 == 0) goto L10
            r3.stopCapture()     // Catch: java.lang.Throwable -> L19
        L10:
            com.tencent.liteav.base.util.Rotation r0 = com.tencent.liteav.base.util.Rotation.NORMAL
            r5.mCameraRotation = r0
            r5.mCameraController = r2
            r5.mMaxZoomLevel = r1
            goto L28
        L19:
            r3 = move-exception
            java.lang.String r4 = "closeCamera fail, Exception:"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = r4.concat(r3)     // Catch: java.lang.Throwable -> L3e
            com.tencent.liteav.base.util.LiteavLog.e(r0, r3)     // Catch: java.lang.Throwable -> L3e
            goto L10
        L28:
            android.graphics.SurfaceTexture r0 = r5.mSurfaceTexture
            if (r0 == 0) goto L31
            r0.release()
            r5.mSurfaceTexture = r2
        L31:
            int r0 = r5.mOESTextureId
            com.tencent.liteav.videobase.utils.OpenGlUtils.deleteTexture(r0)
            r0 = -1
            r5.mOESTextureId = r0
            r5.mPixelFrame = r2
            r5.mIsFirstFrameCaptured = r1
            return
        L3e:
            r0 = move-exception
            com.tencent.liteav.base.util.Rotation r3 = com.tencent.liteav.base.util.Rotation.NORMAL
            r5.mCameraRotation = r3
            r5.mCameraController = r2
            r5.mMaxZoomLevel = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.closeCamera():void");
    }

    private CameraControllerInterface createCameraController(CameraControllerInterface.a aVar) {
        CameraControllerInterface cameraControllerInterface;
        int i10 = AnonymousClass2.f44174a[aVar.ordinal()];
        if (i10 == 1) {
            Object obj = null;
            try {
                obj = Class.forName("com.tencent.liteav.videoengine.demo.mock.camera.MockCameraController").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            cameraControllerInterface = (CameraControllerInterface) obj;
        } else if (i10 != 2) {
            cameraControllerInterface = new com.tencent.liteav.videoproducer.capture.a.a();
        } else {
            cameraControllerInterface = new com.tencent.liteav.videoproducer.capture.b.a(this.mSequenceTaskRunner);
        }
        if (cameraControllerInterface != null) {
            cameraControllerInterface.setServerConfig(this.mServerConfig);
            cameraControllerInterface.setCloudConfig(this.mCloudConfig);
        }
        LiteavLog.i(TAG, "createCameraController, CameraAPIType:" + ((Object) aVar) + ", return camera controller: " + ((Object) cameraControllerInterface));
        return cameraControllerInterface;
    }

    @CalledByNative
    public static CameraCaptureSingleton getInstance() {
        if (sInstance == null) {
            synchronized (CameraCaptureSingleton.class) {
                if (sInstance == null) {
                    sInstance = new CameraCaptureSingleton();
                }
            }
        }
        return sInstance;
    }

    private void getMockCameraMatrix(float[] fArr) {
        try {
            this.mCameraController.getClass().getDeclaredMethod("getTransformMatrix", float[].class).invoke(this.mCameraController, fArr);
        } catch (Throwable th) {
            LiteavLog.e(TAG, "getMockCameraMatrix with exception: ".concat(String.valueOf(th)));
        }
    }

    private void handleCameraStartFailed() {
        LiteavLog.e(TAG, "camera start failed. params: %s", this.mCurrentCaptureParams);
        CameraControllerInterface cameraControllerInterface = this.mCameraController;
        if (cameraControllerInterface != null) {
            cameraControllerInterface.stopCapture();
        }
        this.mCameraController = null;
        if (this.mIsCameraSuccessfullyOpened) {
            scheduleRestartCameraTask();
            return;
        }
        CameraControllerInterface.a a10 = this.mCameraSupervisor.a();
        ai aiVar = this.mCameraSupervisor;
        if (aiVar.f44272a == CameraControllerInterface.a.CAMERA_2) {
            aiVar.f44274c = true;
        }
        if (a10 != aiVar.a()) {
            LiteavLog.w(TAG, "camera switch from " + ((Object) a10) + " to " + ((Object) this.mCameraSupervisor.a()));
            scheduleRestartCameraTask();
            return;
        }
        if (this.mNeedNotifyStartFinish) {
            this.mNeedNotifyStartFinish = false;
            this.mListenerManager.onStartFinish(false);
        }
    }

    private void handleCameraStartSuccess() {
        if (this.mCameraController != null && this.mSurfaceTexture != null) {
            LiteavLog.i(TAG, "camera start success. params: %s", this.mCurrentCaptureParams);
            this.mCameraRotation = this.mCameraController.getCameraRotation();
            this.mIsZoomSupported = this.mCameraController.isZoomSupported();
            this.mIsTorchSupported = this.mCameraController.isTorchSupported();
            this.mIsCameraAutoFocusFaceModeSupported = this.mCameraController.isCameraAutoFocusFaceModeSupported();
            this.mIsFocusPositionInPreviewSupported = this.mCameraController.isCameraFocusPositionInPreviewSupported();
            this.mMaxZoomLevel = this.mCameraController.getMaxZoom();
            Size previewSize = this.mCameraController.getPreviewSize();
            Rotation rotation = this.mCameraRotation;
            Object obj = this.mSharedContext;
            if (obj == null) {
                obj = this.mEGLCore.getEglContext();
            }
            this.mPixelFrame = initOutputPixelFrame(previewSize, rotation, obj, this.mOESTextureId);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
            if (this.mNeedNotifyStartFinish) {
                this.mNeedNotifyStartFinish = false;
                this.mListenerManager.onStartFinish(true);
            }
            this.mIsCameraSuccessfullyOpened = true;
            return;
        }
        LiteavLog.e(TAG, "camera start success, but mCameraController or mSurfaceTexture is null.");
    }

    private void initGLComponents(Object obj) {
        if (this.mEGLCore != null) {
            return;
        }
        this.mEGLCore = new EGLCore();
        if (this.mTextureHolderPool == null) {
            this.mTextureHolderPool = new com.tencent.liteav.videobase.frame.l();
        }
        try {
            this.mEGLCore.initialize(obj, null, 128, 128);
            this.mEGLCore.makeCurrent();
            this.mSharedContext = obj;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.mThrottlers.a("initGL"), TAG, "initializeEGL failed.", e2);
            this.mListenerManager.onCaptureError();
            this.mEGLCore = null;
        }
        if (this.mEGLCore != null) {
            this.mGLTexturePool = new com.tencent.liteav.videobase.frame.e();
        }
    }

    private static PixelFrame initOutputPixelFrame(Size size, Rotation rotation, Object obj, int i10) {
        PixelFrame pixelFrame = new PixelFrame();
        if (rotation != Rotation.ROTATION_90 && rotation != Rotation.ROTATION_270) {
            pixelFrame.setWidth(size.width);
            pixelFrame.setHeight(size.height);
        } else {
            pixelFrame.setWidth(size.height);
            pixelFrame.setHeight(size.width);
        }
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_OES);
        pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        pixelFrame.setRotation(Rotation.NORMAL);
        pixelFrame.setGLContext(obj);
        pixelFrame.setTextureId(i10);
        return pixelFrame;
    }

    private boolean isNeedRestartCamera(CameraCaptureParams cameraCaptureParams) {
        boolean isCurrentPreviewSizeAspectRatioMatch;
        boolean z10;
        Boolean bool = cameraCaptureParams.f44172a;
        CameraCaptureParams cameraCaptureParams2 = this.mCurrentCaptureParams;
        if (bool != cameraCaptureParams2.f44172a) {
            cameraCaptureParams2.f44172a = bool;
            cameraCaptureParams2.f44182c = cameraCaptureParams.f44182c;
            cameraCaptureParams2.f44183d = cameraCaptureParams.f44183d;
            isCurrentPreviewSizeAspectRatioMatch = true;
            z10 = true;
        } else {
            CameraControllerInterface cameraControllerInterface = this.mCameraController;
            if (cameraControllerInterface == null) {
                isCurrentPreviewSizeAspectRatioMatch = false;
            } else {
                isCurrentPreviewSizeAspectRatioMatch = cameraControllerInterface.isCurrentPreviewSizeAspectRatioMatch(cameraCaptureParams.f44182c, cameraCaptureParams.f44183d, this.mListenerManager.a() <= 1);
            }
            if (!isCurrentPreviewSizeAspectRatioMatch) {
                CameraCaptureParams cameraCaptureParams3 = this.mCurrentCaptureParams;
                cameraCaptureParams3.f44182c = cameraCaptureParams.f44182c;
                cameraCaptureParams3.f44183d = cameraCaptureParams.f44183d;
            }
            z10 = false;
        }
        if ((this.mListenerManager.a() <= 1 && this.mCurrentCaptureParams.f44181b != cameraCaptureParams.f44181b) || (this.mListenerManager.a() > 1 && this.mCurrentCaptureParams.f44181b < cameraCaptureParams.f44181b)) {
            this.mCurrentCaptureParams.f44181b = cameraCaptureParams.f44181b;
            z10 = true;
        }
        return z10 || !isCurrentPreviewSizeAspectRatioMatch;
    }

    public static /* synthetic */ void lambda$enableCameraZoom$7(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        cameraCaptureSingleton.mEnableZoom = z10;
        cameraCaptureSingleton.mListenerManager.onCameraZoomEnable(z10);
    }

    public static /* synthetic */ void lambda$enableTapToFocus$5(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        cameraCaptureSingleton.mEnableTapToFocus = z10;
        CameraControllerInterface cameraControllerInterface = cameraCaptureSingleton.mCameraController;
        if (cameraControllerInterface != null) {
            cameraControllerInterface.enableTapToFocus(z10);
        }
        cameraCaptureSingleton.mListenerManager.onCameraTouchEnable(z10);
    }

    public static /* synthetic */ void lambda$onCameraError$12(CameraCaptureSingleton cameraCaptureSingleton, CameraControllerInterface cameraControllerInterface) {
        CameraControllerInterface cameraControllerInterface2 = cameraCaptureSingleton.mCameraController;
        if (cameraControllerInterface2 == null || cameraControllerInterface2 != cameraControllerInterface) {
            return;
        }
        LiteavLog.w(TAG, "VideoCapture: camera error");
        cameraCaptureSingleton.closeCamera();
        cameraCaptureSingleton.scheduleRestartCameraTask();
    }

    public static /* synthetic */ void lambda$onFrameAvailable$13(CameraCaptureSingleton cameraCaptureSingleton, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = cameraCaptureSingleton.mSurfaceTexture;
        if (surfaceTexture2 == null || surfaceTexture != surfaceTexture2) {
            return;
        }
        if (!cameraCaptureSingleton.makeCurrent()) {
            LiteavLog.e(cameraCaptureSingleton.mThrottlers.a("onFrameAvailable"), TAG, "make current failed.", new Object[0]);
        } else {
            cameraCaptureSingleton.checkFirstFrameCaptured();
            cameraCaptureSingleton.onCaptureFrameAvailable();
        }
    }

    public static /* synthetic */ void lambda$setCameraAPIType$11(CameraCaptureSingleton cameraCaptureSingleton, int i10) {
        CameraControllerInterface.a a10 = cameraCaptureSingleton.mCameraSupervisor.a();
        if (i10 == 1) {
            cameraCaptureSingleton.mCameraSupervisor.f44273b = CameraControllerInterface.a.CAMERA_1;
        } else if (i10 == 2) {
            cameraCaptureSingleton.mCameraSupervisor.f44273b = CameraControllerInterface.a.CAMERA_2;
        } else {
            cameraCaptureSingleton.mCameraSupervisor.f44273b = null;
        }
        if (cameraCaptureSingleton.mCameraController != null && cameraCaptureSingleton.mCurrentCaptureParams != null) {
            if (a10 == cameraCaptureSingleton.mCameraSupervisor.a()) {
                LiteavLog.i(TAG, "setCameraAPIType,decided api type is not changed.");
                return;
            } else {
                cameraCaptureSingleton.restartCamera(cameraCaptureSingleton.mCurrentCaptureParams);
                return;
            }
        }
        LiteavLog.i(TAG, "setCameraAPIType,mCameraController is null.");
    }

    public static /* synthetic */ void lambda$setCaptureCloudConfig$2(CameraCaptureSingleton cameraCaptureSingleton, CaptureCloudConfig captureCloudConfig) {
        cameraCaptureSingleton.mCloudConfig = captureCloudConfig;
        cameraCaptureSingleton.mCameraSupervisor.a(captureCloudConfig.getCamera2SupportMinApiLevel());
        LiteavLog.i(TAG, "setCaptureCloudConfig minApiLevel:" + captureCloudConfig.getCamera2SupportMinApiLevel());
    }

    public static /* synthetic */ void lambda$setExposureCompensation$10(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        cameraCaptureSingleton.mExposureCompensation = f10;
        CameraControllerInterface cameraControllerInterface = cameraCaptureSingleton.mCameraController;
        if (cameraControllerInterface != null) {
            cameraControllerInterface.setExposureCompensation(f10);
        }
    }

    public static /* synthetic */ void lambda$setServerConfig$1(CameraCaptureSingleton cameraCaptureSingleton, ServerVideoProducerConfig serverVideoProducerConfig) {
        cameraCaptureSingleton.mServerConfig = serverVideoProducerConfig;
        cameraCaptureSingleton.mCameraSupervisor.a(serverVideoProducerConfig.getCamera2SupportMinApiLevel());
        LiteavLog.i(TAG, "setServerConfig minApiLevel:" + serverVideoProducerConfig.getCamera2SupportMinApiLevel());
    }

    public static /* synthetic */ void lambda$setZoomLevel$8(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        int i10 = cameraCaptureSingleton.mMaxZoomLevel;
        if (i10 <= 0) {
            LiteavLog.w(TAG, "setZoomLevel maxZoomLevel=".concat(String.valueOf(i10)));
        } else {
            cameraCaptureSingleton.setZoomInternal(f10 / i10);
        }
    }

    public static /* synthetic */ void lambda$start$14(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        LiteavLog.i(TAG, "start,captureParams=".concat(String.valueOf(cameraCaptureParams)));
        cameraCaptureSingleton.mListenerManager.a(captureSourceListener);
        if (cameraCaptureSingleton.mEGLCore != null && cameraCaptureSingleton.mCurrentCaptureParams != null) {
            cameraCaptureSingleton.restartIfCaptureParamsChanged(cameraCaptureParams, captureSourceListener);
        } else {
            cameraCaptureSingleton.initGLComponents(ax.a().b());
            cameraCaptureSingleton.openCamera(cameraCaptureParams);
        }
    }

    public static /* synthetic */ void lambda$startAutoFocusAtPosition$6(CameraCaptureSingleton cameraCaptureSingleton, int i10, int i11) {
        CameraControllerInterface cameraControllerInterface;
        if (cameraCaptureSingleton.mEnableTapToFocus && (cameraControllerInterface = cameraCaptureSingleton.mCameraController) != null) {
            cameraControllerInterface.startAutoFocusAtPosition(i10, i11);
        }
    }

    public static /* synthetic */ void lambda$stopAndWaitDone$15(CameraCaptureSingleton cameraCaptureSingleton) {
        LiteavLog.i(TAG, "stop camera begin");
        cameraCaptureSingleton.stopInternal();
        LiteavLog.i(TAG, "stop camera end");
    }

    public static /* synthetic */ void lambda$switchCamera$3(CameraCaptureSingleton cameraCaptureSingleton) {
        boolean z10 = cameraCaptureSingleton.mExpectFrontCamera.get();
        CameraCaptureParams cameraCaptureParams = cameraCaptureSingleton.mCurrentCaptureParams;
        if (cameraCaptureParams == null || cameraCaptureParams.f44172a.booleanValue() == z10) {
            return;
        }
        cameraCaptureSingleton.mZoomPercent = 0.0f;
        cameraCaptureSingleton.mNeedNotifyStartFinish = true;
        cameraCaptureSingleton.mCurrentCaptureParams.f44172a = Boolean.valueOf(z10);
        cameraCaptureSingleton.restartCamera(cameraCaptureSingleton.mCurrentCaptureParams);
    }

    public static /* synthetic */ void lambda$turnOnTorch$4(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        CameraControllerInterface cameraControllerInterface = cameraCaptureSingleton.mCameraController;
        if (cameraControllerInterface != null) {
            cameraControllerInterface.turnOnTorch(z10);
        }
    }

    public static /* synthetic */ void lambda$updateParams$17(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams, CaptureSourceInterface.CaptureParams captureParams) {
        CameraCaptureParams cameraCaptureParams2;
        LiteavLog.i(TAG, "updateParams,captureParams=".concat(String.valueOf(cameraCaptureParams)));
        if (cameraCaptureSingleton.mEGLCore != null && (cameraCaptureParams2 = cameraCaptureSingleton.mCurrentCaptureParams) != null) {
            if (cameraCaptureParams.f44172a == null) {
                cameraCaptureParams.f44172a = cameraCaptureParams2.f44172a;
                LiteavLog.i(TAG, "params not set frontCamera, use mCurrentCaptureParams frontCamera:" + ((Object) cameraCaptureSingleton.mCurrentCaptureParams.f44172a));
            }
            if (!cameraCaptureSingleton.isNeedRestartCamera(cameraCaptureParams)) {
                LiteavLog.i(TAG, "updateParams, no need restart camera: ".concat(String.valueOf(captureParams)));
                return;
            } else {
                cameraCaptureSingleton.restartCamera(cameraCaptureParams);
                return;
            }
        }
        LiteavLog.i(TAG, "camera is closed, cannot update params.");
    }

    private void onCaptureFrameAvailable() {
        com.tencent.liteav.videobase.frame.l lVar;
        l.b bVar;
        if (this.mGLTexturePool != null && (lVar = this.mTextureHolderPool) != null) {
            try {
                bVar = lVar.a();
            } catch (InterruptedException unused) {
                bVar = null;
            }
            if (this.mPixelFrame.getMatrix() == null) {
                this.mPixelFrame.setMatrix(this.mMatrix);
            }
            try {
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mMatrix);
            } catch (Throwable th) {
                LiteavLog.w(this.mThrottlers.a("updateTexImage"), TAG, "updateTexImage exception: ".concat(String.valueOf(th)), new Object[0]);
            }
            if (this.mCameraSupervisor.a() == CameraControllerInterface.a.MOCK) {
                getMockCameraMatrix(this.mMatrix);
            }
            bVar.a(36197, this.mOESTextureId, this.mPixelFrame.getWidth(), this.mPixelFrame.getHeight());
            PixelFrame a10 = bVar.a(this.mPixelFrame.getGLContext());
            a10.setMirrorHorizontal(isFrontCamera());
            a10.setMatrix(this.mMatrix);
            a10.setTimestamp(TimeUtil.a());
            FrameMetaData frameMetaData = new FrameMetaData();
            frameMetaData.setCaptureMetaData(isFrontCamera(), false, 0, isFrontCamera(), a10.getWidth(), a10.getHeight());
            a10.setMetaData(frameMetaData);
            if (a10.getGLContext() == null) {
                a10.setGLContext(this.mEGLCore.getEglContext());
            }
            this.mListenerManager.onFrameAvailable(null, a10);
            bVar.release();
            a10.release();
            return;
        }
        LiteavLog.w(TAG, "onCaptureFrameAvailable mGLTexturePool:" + ((Object) this.mGLTexturePool) + " mTextureHolderPool:" + ((Object) this.mTextureHolderPool));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openCamera(@NonNull CameraCaptureParams cameraCaptureParams) {
        if (this.mCameraController != null) {
            LiteavLog.e(TAG, "camera is opened, you should Stop it first.");
            return true;
        }
        boolean openCameraInternal = openCameraInternal(cameraCaptureParams);
        if (openCameraInternal) {
            handleCameraStartSuccess();
        } else {
            handleCameraStartFailed();
        }
        return openCameraInternal;
    }

    private boolean openCameraInternal(@NonNull CameraCaptureParams cameraCaptureParams) {
        if (!makeCurrent()) {
            LiteavLog.e(TAG, "openCameraInternal: set opengl context fail.");
            return false;
        }
        this.mOESTextureId = OpenGlUtils.generateTextureOES();
        this.mSurfaceTexture = new SurfaceTexture(this.mOESTextureId);
        this.mCameraController = createCameraController(this.mCameraSupervisor.a());
        if (cameraCaptureParams.f44172a == null) {
            cameraCaptureParams.f44172a = Boolean.valueOf(this.mExpectFrontCamera.get());
            LiteavLog.w(TAG, "openCameraInternal frontCamera not set, use expect front camera:" + ((Object) cameraCaptureParams.f44172a));
        }
        this.mCurrentCaptureParams = cameraCaptureParams;
        this.mCameraController.enableTapToFocus(this.mEnableTapToFocus);
        this.mCameraController.setExposureCompensation(this.mExposureCompensation);
        this.mCameraController.setZoom(this.mZoomPercent);
        this.mListenerManager.onCameraTouchEnable(this.mEnableTapToFocus);
        this.mListenerManager.onCameraZoomEnable(this.mEnableZoom);
        return this.mCameraController.startCapture(this.mCurrentCaptureParams, this.mSurfaceTexture, this);
    }

    private void restartCamera(@NonNull CameraCaptureParams cameraCaptureParams) {
        LiteavLog.i(TAG, "restart camera params: ".concat(String.valueOf(cameraCaptureParams)));
        closeCamera();
        openCamera(cameraCaptureParams);
    }

    private void restartIfCaptureParamsChanged(CameraCaptureParams cameraCaptureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        if (cameraCaptureParams.f44172a == null) {
            cameraCaptureParams.f44172a = this.mCurrentCaptureParams.f44172a;
            LiteavLog.i(TAG, "params not set frontCamera, use mCurrentCaptureParams frontCamera:" + ((Object) this.mCurrentCaptureParams.f44172a));
        }
        boolean isNeedRestartCamera = isNeedRestartCamera(cameraCaptureParams);
        StringBuilder sb2 = new StringBuilder("Camera is opened, has new params, is need restart camera? ");
        sb2.append(isNeedRestartCamera ? "yes." : "no.");
        LiteavLog.i(TAG, sb2.toString());
        if (isNeedRestartCamera) {
            this.mNeedNotifyStartFinish = true;
            restartCamera(cameraCaptureParams);
        } else if (captureSourceListener != null) {
            captureSourceListener.onCameraTouchEnable(this.mEnableTapToFocus);
            captureSourceListener.onCameraZoomEnable(this.mEnableZoom);
            captureSourceListener.onStartFinish(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleRestartCameraTask() {
        this.mSequenceTaskRunner.c(this.mRestartCameraRunnable);
        this.mSequenceTaskRunner.b(this.mRestartCameraRunnable, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoomInternal(float f10) {
        CameraControllerInterface cameraControllerInterface;
        LiteavLog.i(TAG, "setZoomInternal ".concat(String.valueOf(f10)));
        if (Math.abs(this.mZoomPercent - f10) >= 0.001d && (cameraControllerInterface = this.mCameraController) != null) {
            this.mZoomPercent = f10;
            cameraControllerInterface.setZoom(f10);
        }
    }

    private void stopInternal() {
        LiteavLog.i(TAG, "stop listener count: " + this.mListenerManager.a());
        if (this.mListenerManager.a() == 0) {
            closeCamera();
            this.mZoomPercent = 0.0f;
            this.mNeedNotifyStartFinish = true;
            this.mIsCameraSuccessfullyOpened = false;
            this.mCurrentCaptureParams = null;
            this.mSequenceTaskRunner.c(this.mRestartCameraRunnable);
            uninitGLComponents();
        }
    }

    @CalledByNative
    public void enableCameraZoom(boolean z10) {
        LiteavLog.i(TAG, "enableCameraZoom ".concat(String.valueOf(z10)));
        runInGLThread(r.a(this, z10));
    }

    @CalledByNative
    public void enableMockCamera(boolean z10) {
        this.mCameraSupervisor.f44273b = z10 ? CameraControllerInterface.a.MOCK : null;
    }

    @CalledByNative
    public void enableTapToFocus(boolean z10) {
        LiteavLog.i(TAG, "enableTapToFocus ".concat(String.valueOf(z10)));
        runInGLThread(p.a(this, z10));
    }

    public CameraControllerInterface.a getCameraAPIType() {
        return this.mCameraSupervisor.a();
    }

    public Rotation getCameraRotation() {
        return this.mCameraRotation;
    }

    @CalledByNative
    public int getMaxZoomLevel() {
        return this.mMaxZoomLevel;
    }

    @CalledByNative
    public boolean isAutoFocusEnabled() {
        return !this.mEnableTapToFocus;
    }

    @CalledByNative
    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.mIsCameraAutoFocusFaceModeSupported;
    }

    @CalledByNative
    public boolean isCameraFocusPositionInPreviewSupported() {
        return this.mIsFocusPositionInPreviewSupported;
    }

    @CalledByNative
    public boolean isFrontCamera() {
        Boolean bool;
        CameraCaptureParams cameraCaptureParams = this.mCurrentCaptureParams;
        if (cameraCaptureParams == null || (bool = cameraCaptureParams.f44172a) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @CalledByNative
    public boolean isTorchSupported() {
        return this.mIsTorchSupported;
    }

    @CalledByNative
    public boolean isZoomSupported() {
        return this.mIsZoomSupported;
    }

    public boolean makeCurrent() {
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore == null) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentNull"), TAG, "makeCurrent on mEGLCore is null", new Object[0]);
            return false;
        }
        try {
            eGLCore.makeCurrent();
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentError"), TAG, "make current failed.", e2);
            this.mListenerManager.onCaptureError();
            return false;
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraEventCallback
    public void onCameraError(CameraControllerInterface cameraControllerInterface) {
        runInGLThread(e.a(this, cameraControllerInterface));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        runInGLThread(f.a(this, surfaceTexture));
    }

    public void pause() {
        LiteavLog.i(TAG, "pause");
        runInGLThread(i.a(this));
    }

    public void pauseInternal() {
        this.mPausedCount++;
        int a10 = this.mListenerManager.a();
        LiteavLog.i(TAG, "pauseInternal paused cnt= " + this.mPausedCount + " , listener cnt=" + a10);
        if (this.mPausedCount > a10) {
            this.mPausedCount = a10;
        }
        if (a10 != this.mPausedCount) {
            LiteavLog.i(TAG, "pauseInternal listeners is not zero.");
        } else {
            closeCamera();
        }
    }

    public void removeListener(CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        runInGLThread(a.a(this, captureSourceListener));
    }

    public void resume() {
        LiteavLog.i(TAG, "resume");
        runInGLThread(j.a(this));
    }

    public void resumeInternal(CameraCaptureParams cameraCaptureParams) {
        LiteavLog.i(TAG, "resumeInternal pausedCount %d, listeners size = %d", Integer.valueOf(this.mPausedCount), Integer.valueOf(this.mListenerManager.a()));
        if (this.mListenerManager.a() == this.mPausedCount) {
            openCamera(cameraCaptureParams);
        }
        int i10 = this.mPausedCount - 1;
        this.mPausedCount = i10;
        if (i10 < 0) {
            this.mPausedCount = 0;
        }
    }

    public void runInGLThread(Runnable runnable) {
        this.mSequenceTaskRunner.a(runnable);
    }

    @CalledByNative
    public void setCameraAPIType(int i10) {
        LiteavLog.i(TAG, "setCameraAPIType ".concat(String.valueOf(i10)));
        runInGLThread(d.a(this, i10));
    }

    public void setCaptureCloudConfig(CaptureCloudConfig captureCloudConfig) {
        runInGLThread(m.a(this, captureCloudConfig));
    }

    @CalledByNative
    public void setExposureCompensation(float f10) {
        LiteavLog.i(TAG, "setExposureCompensation ".concat(String.valueOf(f10)));
        runInGLThread(c.a(this, f10));
    }

    public void setPercentOfMaxZoomLevel(float f10) {
        runInGLThread(b.a(this, f10));
    }

    public void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
        runInGLThread(l.a(this, serverVideoProducerConfig));
    }

    @CalledByNative
    public void setZoomLevel(float f10) {
        LiteavLog.i(TAG, "setZoomLevel ".concat(String.valueOf(f10)));
        runInGLThread(s.a(this, f10));
    }

    public void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        runInGLThread(g.a(this, new CameraCaptureParams((CameraCaptureParams) captureParams), captureSourceListener));
    }

    @CalledByNative
    public void startAutoFocusAtPosition(int i10, int i11) {
        LiteavLog.i(TAG, "startAutoFocusAtPosition " + i10 + ", " + i11);
        runInGLThread(q.a(this, i10, i11));
    }

    public void stopAndWaitDone(int i10) {
        this.mSequenceTaskRunner.a(h.a(this), i10);
    }

    @CalledByNative
    public void switchCamera(boolean z10) {
        LiteavLog.i(TAG, "switchCamera ".concat(String.valueOf(z10)));
        this.mExpectFrontCamera.set(z10);
        runInGLThread(n.a(this));
    }

    @CalledByNative
    public void turnOnTorch(boolean z10) {
        LiteavLog.i(TAG, "turnOnTorch ".concat(String.valueOf(z10)));
        runInGLThread(o.a(this, z10));
    }

    public void uninitGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        com.tencent.liteav.videobase.frame.l lVar = this.mTextureHolderPool;
        if (lVar != null) {
            lVar.b();
            this.mTextureHolderPool = null;
        }
        try {
            this.mEGLCore.makeCurrent();
            com.tencent.liteav.videobase.frame.e eVar = this.mGLTexturePool;
            if (eVar != null) {
                eVar.b();
                this.mGLTexturePool = null;
            }
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.mThrottlers.a("uninitGL"), TAG, "EGLCore destroy failed.", e2);
        }
        this.mSharedContext = null;
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
    }

    public void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        runInGLThread(k.a(this, new CameraCaptureParams((CameraCaptureParams) captureParams), captureParams));
    }
}
