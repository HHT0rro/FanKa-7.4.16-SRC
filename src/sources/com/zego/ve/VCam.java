package com.zego.ve;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.android.internal.logging.nano.MetricsProto;
import com.huawei.quickcard.base.Attributes;
import com.zego.ve.CameraAvailabilityCallback;
import com.zego.zegoliveroom.constants.ZegoConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VCam implements Handler.Callback {
    private static final int EXPOSURE_MODE_AUTO = 0;
    private static final int EXPOSURE_MODE_AUTO_EXPOSURE = 4;
    private static final int EXPOSURE_MODE_CONTINUOUS_AUTO_EXPOSURE = 5;
    private static final int EXPOSURE_MODE_CUSTOM = 1;
    private static final int FOCUS_MODE_AUTO = 0;
    private static final int FOCUS_MODE_AUTO_FOCUS = 8;
    private static final int FOCUS_MODE_CONTINUOUS_AUTO_FOCUS = 9;
    private static final int FOCUS_MODE_CONTINUOUS_PICTURE = 6;
    private static final int FOCUS_MODE_CONTINUOUS_VIDEO = 5;
    private static final int FOCUS_MODE_EDOF = 4;
    private static final int FOCUS_MODE_FIXED = 3;
    private static final int FOCUS_MODE_INFINITY = 1;
    private static final int FOCUS_MODE_MACRO = 2;
    private static final int MESSAGE_EXPOSURE_LOCK = 0;
    private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    private static final int SCENE_MODE_ACTION = 3;
    private static final int SCENE_MODE_LOW_LIGHT = 1;
    private static final int SCENE_MODE_NIGHT = 2;
    private static final int SCENE_MODE_NONE = 0;
    private static final int SCENE_MODE_PORTRAIT = 4;
    private static final String TAG = "vcap";
    private long mThis = 0;
    private Context mContext = null;
    private CameraAvailabilityCallback mCameraAvailabilityCallback = null;
    public int mWidth = 640;
    public int mHeight = 480;
    public int mFrameRate = 15;
    public boolean mNeedHack = false;
    public int mFocusMode = -1;
    public int mExposureMode = -1;
    public float mExposureCompensation = 0.0f;
    public float mFocusPointX = 0.0f;
    public float mFocusPointY = 0.0f;
    public float mExposurePointX = 0.0f;
    public float mExposurePointY = 0.0f;
    public int mFrontCameraId = -1;
    public int mBackCameraId = -1;
    public int mUseCameraId = -1;
    public int mFPSMode = 0;
    public boolean mUseFaceDetection = false;
    public boolean mIsFocusing = false;
    public int mAreaSize = 0;
    private Matrix matrix = new Matrix();
    public int mSceneMode = 0;
    private boolean mTryDefault = true;
    private boolean mCamera2Error = false;
    public boolean mLowLightBoost = false;
    private Handler mHandler = null;
    private int mExposureGeneration = 0;
    public int mFpsMin = -1000;
    public int mFpsMax = -1000;
    private final Set<byte[]> queuedBuffers = new HashSet();
    private int mFrameSize = 0;
    private CameraDev mCamDevice = null;
    private String[] mCameraIDList = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class Cam2Device extends CameraDev {
        private Handler mCam2Handler;
        private HandlerThread mCam2Thread;
        private CameraCaptureSession mCamCapSession;
        private CameraCharacteristics mCamCharacteristics;
        public CameraDevice mCamDevice;
        private CaptureRequest.Builder mCapRequestBuilder;
        private DevStateCallback mDevStateCallback;
        private ImageReader mImageReader;
        private Semaphore mOpenSem;
        private boolean mOpened;
        private SessionStateCallback mSessionStateCallback;
        private ImageReader mSnapshotImage;
        private SurfaceTexture mSurfaceTexture;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class DevStateCallback extends CameraDevice.StateCallback {
            public DevStateCallback() {
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onClosed(CameraDevice cameraDevice) {
                Cam2Device.this.mOpened = false;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                Cam2Device.this.mOpened = false;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("vcap: camera onError ");
                sb2.append(i10);
                if (i10 == 4 || i10 == 5) {
                    VCam.this.mCamera2Error = true;
                }
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                Cam2Device.this.mOpened = true;
                Cam2Device cam2Device = Cam2Device.this;
                cam2Device.mCamDevice = cameraDevice;
                cam2Device.mOpenSem.release();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class OnSnapshotCallback implements ImageReader.OnImageAvailableListener {
            public OnSnapshotCallback() {
            }

            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader imageReader) {
                Image acquireLatestImage = imageReader.acquireLatestImage();
                int format = acquireLatestImage.getFormat();
                Image.Plane[] planes = acquireLatestImage.getPlanes();
                if (256 == format) {
                    VCam.onSnapshotTaken(VCam.this.mThis, planes[0].getBuffer(), 0);
                }
                acquireLatestImage.close();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class SessionStateCallback extends CameraCaptureSession.StateCallback {
            public SessionStateCallback() {
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                VCam.this.mCamera2Error = true;
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                try {
                    Cam2Device.this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                    Cam2Device.this.mCamCapSession = cameraCaptureSession;
                    Cam2Device.this.mCamCapSession.setRepeatingRequest(Cam2Device.this.mCapRequestBuilder.build(), null, null);
                } catch (Exception e2) {
                    VCam.this.mCamera2Error = true;
                    e2.printStackTrace();
                }
            }
        }

        public Cam2Device() {
            super();
            this.mCamDevice = null;
            this.mCamCharacteristics = null;
            this.mCamCapSession = null;
            this.mCapRequestBuilder = null;
            this.mOpenSem = new Semaphore(0);
            this.mOpened = false;
            this.mSurfaceTexture = null;
            this.mSnapshotImage = null;
            this.mCam2Thread = null;
            this.mCam2Handler = null;
            this.mImageReader = null;
            this.mDevStateCallback = new DevStateCallback();
            this.mSessionStateCallback = new SessionStateCallback();
        }

        private Rect calculateArea2(float f10, float f11) {
            Rect rect = (Rect) this.mCamCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            int width = (int) (((f10 + 1.0f) / 2.0f) * rect.width());
            int height = (int) (((f11 + 1.0f) / 2.0f) * rect.height());
            int width2 = rect.width() / 10;
            VCam vCam = VCam.this;
            int i10 = (vCam.mWidth * width2) / vCam.mHeight;
            int i11 = width2 / 2;
            int i12 = i10 / 2;
            return new Rect(VCam.clamp(width - i11, 0, rect.width() - width2), VCam.clamp(height - i12, 0, rect.height() - i10), VCam.clamp(width + i11, 0, rect.width()), VCam.clamp(height + i12, 0, rect.height()));
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int closeTorch() {
            if (this.mCapRequestBuilder == null || !((Boolean) this.mCamCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
                return -1;
            }
            try {
                this.mCapRequestBuilder.set(CaptureRequest.FLASH_MODE, 0);
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int createCam(int i10) {
            if (this.mCamDevice != null) {
                return 0;
            }
            if (this.mCam2Thread == null) {
                HandlerThread handlerThread = new HandlerThread("cam2_thread");
                this.mCam2Thread = handlerThread;
                handlerThread.start();
                this.mCam2Handler = new Handler(this.mCam2Thread.getLooper(), null);
            }
            if (Build.VERSION.SDK_INT >= 23 && !VCam.this.checkPermission()) {
                return -1;
            }
            CameraManager cameraManager = (CameraManager) VCam.this.mContext.getSystemService(ZegoConstants.DeviceNameType.DeviceNameCamera);
            this.mOpened = false;
            try {
                cameraManager.openCamera(VCam.this.mCameraIDList[i10], this.mDevStateCallback, this.mCam2Handler);
                this.mCamCharacteristics = cameraManager.getCameraCharacteristics(VCam.this.mCameraIDList[i10]);
                if (VCam.this.isSupportCamera2()) {
                    VCam.this.registerCameraAvailabilityCallback(i10);
                }
                VCam.this.mUseCameraId = i10;
                return 0;
            } catch (CameraAccessException | RuntimeException e2) {
                Log.e(VCam.TAG, "trace interruption open " + VCam.this.GetCameraString(i10) + " failed, " + e2);
                VCam.this.mCamera2Error = true;
                return -1;
            }
        }

        public int doSetExposureCompensation(float f10) {
            Range range = (Range) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
            int intValue = ((Integer) range.getLower()).intValue();
            int intValue2 = ((Integer) range.getUpper()).intValue();
            if (intValue == 0 && intValue2 == 0) {
                return -1;
            }
            if (f10 < 0.0f) {
                intValue2 = -intValue;
            }
            int i10 = (int) (intValue2 * f10);
            try {
                this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(i10));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("vcap: set exposure compensation ");
                sb2.append(i10);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        public int doSetExposureMode(int i10) {
            if (i10 == -1) {
                return 0;
            }
            VCam.access$708(VCam.this);
            try {
                if (i10 == 0 || i10 == 5 || i10 == 4) {
                    this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
                } else if (i10 == 1) {
                    this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("vcap: set exposure mode ");
                sb2.append(i10);
                if (i10 == 4) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = Integer.valueOf(VCam.this.mExposureGeneration);
                    VCam.this.mHandler.sendMessageDelayed(obtain, 200L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            doSetExposureCompensation(VCam.this.mExposureCompensation);
            return 0;
        }

        public int doSetExposurePoint(float f10, float f11) {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue() != 0) {
                Rect calculateArea2 = calculateArea2(f10, f11);
                try {
                    this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(calculateArea2, 800)});
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("vcap: set exposure area ");
                    sb2.append(calculateArea2.toString());
                    return 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int doSetFocusMode(int r12) {
            /*
                r11 = this;
                r0 = 5
                r1 = 4
                r2 = 2
                r3 = 1
                if (r12 == 0) goto L16
                if (r12 == r2) goto L14
                r4 = 8
                if (r12 == r4) goto L16
                if (r12 == r1) goto L17
                if (r12 == r0) goto L12
                r0 = 4
                goto L17
            L12:
                r0 = 3
                goto L17
            L14:
                r0 = 2
                goto L17
            L16:
                r0 = 1
            L17:
                android.hardware.camera2.CameraCharacteristics r12 = r11.mCamCharacteristics
                android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES
                java.lang.Object r12 = r12.get(r1)
                int[] r12 = (int[]) r12
                int r1 = r12.length
                java.lang.String r4 = "vcap"
                r5 = 0
                if (r1 == 0) goto L80
                int r1 = r12.length
                r6 = 0
                r7 = 0
            L2a:
                if (r6 >= r1) goto L5d
                r8 = r12[r6]
                if (r8 != r0) goto L5a
                android.hardware.camera2.CaptureRequest$Builder r7 = r11.mCapRequestBuilder     // Catch: java.lang.Exception -> L50
                android.hardware.camera2.CaptureRequest$Key r9 = android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE     // Catch: java.lang.Exception -> L50
                java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L50
                r7.set(r9, r10)     // Catch: java.lang.Exception -> L50
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50
                r7.<init>()     // Catch: java.lang.Exception -> L50
                java.lang.String r9 = "vcap: set focus mode "
                r7.append(r9)     // Catch: java.lang.Exception -> L50
                r7.append(r8)     // Catch: java.lang.Exception -> L50
                java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L50
                com.zego.ve.Log.i(r4, r7)     // Catch: java.lang.Exception -> L50
                goto L59
            L50:
                r7 = move-exception
                java.lang.String r8 = "vcap: set focus mode failed"
                com.zego.ve.Log.e(r4, r8)
                r7.printStackTrace()
            L59:
                r7 = 1
            L5a:
                int r6 = r6 + 1
                goto L2a
            L5d:
                if (r7 != 0) goto L81
                r0 = r12[r5]
                android.hardware.camera2.CaptureRequest$Builder r12 = r11.mCapRequestBuilder     // Catch: java.lang.Exception -> L7a
                android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE     // Catch: java.lang.Exception -> L7a
                java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L7a
                r12.set(r1, r6)     // Catch: java.lang.Exception -> L7a
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7a
                r12.<init>()     // Catch: java.lang.Exception -> L7a
                java.lang.String r1 = "vcap: fallback focus mode "
                r12.append(r1)     // Catch: java.lang.Exception -> L7a
                r12.append(r0)     // Catch: java.lang.Exception -> L7a
                goto L7e
            L7a:
                r12 = move-exception
                r12.printStackTrace()
            L7e:
                r7 = 1
                goto L81
            L80:
                r7 = 0
            L81:
                if (r7 != 0) goto L8a
                java.lang.String r12 = "vcap: focus mode left unset"
                com.zego.ve.Log.i(r4, r12)
                r12 = -1
                return r12
            L8a:
                if (r0 == r3) goto L90
                if (r0 != r2) goto L8f
                goto L90
            L8f:
                r3 = 0
            L90:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.Cam2Device.doSetFocusMode(int):int");
        }

        public int doSetFocusPoint(float f10, float f11) {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() != 0) {
                Rect calculateArea2 = calculateArea2(f10, f11);
                try {
                    this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(calculateArea2, 800)});
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("vcap: set focus area ");
                    sb2.append(calculateArea2.toString());
                    return 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return -1;
        }

        public int getFrontCam() {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            return (cameraCharacteristics == null || ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) ? 0 : 1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int getMaxZoomRatio() {
            if (this.mCamDevice == null) {
                return 100;
            }
            return (int) (((Float) this.mCamCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() * 100.0f);
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int getOrientation() {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics != null) {
                return ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int handleExposureMode(int i10) {
            return doSetExposureMode(i10);
        }

        @Override // com.zego.ve.VCam.CameraDev
        public boolean isFocusSupported() {
            boolean z10;
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics == null) {
                return false;
            }
            for (int i10 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES)) {
                if (i10 == 1 || i10 == 3 || i10 == 4) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
            return !z10 ? z10 : ((Integer) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int openTorch() {
            if (this.mCapRequestBuilder == null || !((Boolean) this.mCamCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
                return -1;
            }
            try {
                this.mCapRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int releaseCam() {
            if (this.mCamDevice == null) {
                return 0;
            }
            try {
                CameraCaptureSession cameraCaptureSession = this.mCamCapSession;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                }
                this.mCamDevice.close();
                this.mCamDevice = null;
                this.mCamCapSession = null;
                this.mCapRequestBuilder = null;
                this.mCamCharacteristics = null;
                this.mSurfaceTexture = null;
                HandlerThread handlerThread = this.mCam2Thread;
                if (handlerThread != null) {
                    handlerThread.quit();
                    this.mCam2Thread = null;
                }
                this.mCam2Handler = null;
                this.mImageReader = null;
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setExposureCompensation(float f10) {
            if (this.mCapRequestBuilder == null || doSetExposureCompensation(f10) != 0) {
                return -1;
            }
            try {
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setExposureMode(int i10) {
            if (this.mCapRequestBuilder == null || doSetExposureMode(VCam.this.mExposureMode) != 0) {
                return -1;
            }
            try {
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setExposurePoint(float f10, float f11) {
            if (this.mCapRequestBuilder != null && !VCam.this.mUseFaceDetection) {
                doSetExposurePoint(f10, f11);
                try {
                    this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                    return 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setFocusMode(int i10) {
            CaptureRequest.Builder builder = this.mCapRequestBuilder;
            if (builder == null) {
                return -1;
            }
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            if (doSetFocusMode(VCam.this.mFocusMode) >= 0) {
                VCam vCam = VCam.this;
                if (!vCam.mUseFaceDetection) {
                    doSetFocusPoint(vCam.mFocusPointX, vCam.mFocusPointY);
                }
            } else if (((Integer) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
                this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, null);
            }
            try {
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setFocusPoint(float f10, float f11) {
            if (this.mCapRequestBuilder == null) {
                return -1;
            }
            VCam vCam = VCam.this;
            if (vCam.mUseFaceDetection || vCam.mIsFocusing) {
                return -1;
            }
            setFocusMode(vCam.mFocusMode);
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setImageReader(ImageReader imageReader) {
            this.mImageReader = imageReader;
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setRate(int i10) {
            if (this.mCapRequestBuilder == null) {
                return 0;
            }
            updateRate(i10);
            try {
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setSurfaceTexture(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public void setZoomFactor(float f10) {
            if (this.mCapRequestBuilder == null) {
                return;
            }
            Float f11 = (Float) this.mCamCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            if (f10 > f11.floatValue()) {
                f10 = f11.floatValue();
            }
            if (f10 < 1.0f) {
                f10 = 1.0f;
            }
            Rect rect = (Rect) this.mCamCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            int width = rect.width() / 2;
            int height = rect.height() / 2;
            int width2 = (int) ((rect.width() * 0.5f) / f10);
            int height2 = (int) ((rect.height() * 0.5f) / f10);
            Rect rect2 = new Rect();
            rect2.set(width - width2, height - height2, width + width2, height + height2);
            try {
                this.mCapRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, rect2);
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int startCam(boolean z10) {
            int i10;
            int i11;
            int i12;
            int i13;
            List<Surface> asList;
            int i14;
            if (!this.mOpenSem.tryAcquire(1000L, TimeUnit.MILLISECONDS)) {
                return -1;
            }
            if (!this.mOpened) {
                VCam.this.mCamera2Error = true;
                return -1;
            }
            VCam.this.mUseFaceDetection = (VCam.this.getFront() > 0) && z10 && ((Integer) this.mCamCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0;
            Size[] outputSizes = ((StreamConfigurationMap) this.mCamCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(35);
            if (outputSizes != null) {
                i10 = 0;
                i11 = 0;
                for (Size size : outputSizes) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("vcap: support size -- ");
                    sb2.append(size.getWidth());
                    sb2.append(LanguageTag.PRIVATEUSE);
                    sb2.append(size.getHeight());
                    if (size.getWidth() * size.getHeight() > i10 * i11 && (size.getWidth() * 3 == size.getHeight() * 4 || size.getWidth() * 9 == size.getHeight() * 16)) {
                        i10 = size.getWidth();
                        i11 = size.getHeight();
                    }
                }
                i12 = 0;
                i13 = 0;
                for (Size size2 : outputSizes) {
                    if (size2.getWidth() % 16 == 0 && size2.getHeight() % 16 == 0) {
                        if (size2.getWidth() >= VCam.this.mWidth) {
                            int height = size2.getHeight();
                            VCam vCam = VCam.this;
                            int i15 = vCam.mHeight;
                            if (height >= i15) {
                                if (i12 >= vCam.mWidth && i13 >= i15) {
                                    if (size2.getWidth() * size2.getHeight() < i12 * i13) {
                                        i12 = size2.getWidth();
                                        i13 = size2.getHeight();
                                    }
                                } else {
                                    i12 = size2.getWidth();
                                    i13 = size2.getHeight();
                                }
                            }
                        }
                        int width = size2.getWidth();
                        VCam vCam2 = VCam.this;
                        int i16 = vCam2.mWidth;
                        if (width >= i16) {
                            if (i12 < i16 || i13 < vCam2.mHeight) {
                                if (i12 < i16 && i13 < vCam2.mHeight) {
                                    i12 = size2.getWidth();
                                    i13 = size2.getHeight();
                                } else if (i12 >= i16 && size2.getHeight() > i13) {
                                    i12 = size2.getWidth();
                                    i13 = size2.getHeight();
                                } else if (size2.getWidth() * size2.getHeight() > i12 * i13) {
                                    i12 = size2.getWidth();
                                    i13 = size2.getHeight();
                                }
                            }
                        } else {
                            int height2 = size2.getHeight();
                            VCam vCam3 = VCam.this;
                            int i17 = vCam3.mHeight;
                            if (height2 >= i17 && (i12 < (i14 = vCam3.mWidth) || i13 < i17)) {
                                if (i12 < i14 && i13 < i17) {
                                    i12 = size2.getWidth();
                                    i13 = size2.getHeight();
                                } else if (i13 >= i17 && size2.getWidth() > i12) {
                                    i12 = size2.getWidth();
                                    i13 = size2.getHeight();
                                } else if (size2.getWidth() * size2.getHeight() > i12 * i13) {
                                    i12 = size2.getWidth();
                                    i13 = size2.getHeight();
                                }
                            }
                        }
                    }
                }
            } else {
                i10 = 0;
                i11 = 0;
                i12 = 0;
                i13 = 0;
            }
            if (i12 * i13 != 0) {
                VCam vCam4 = VCam.this;
                vCam4.mWidth = i12;
                vCam4.mHeight = i13;
            } else if (i10 * i11 != 0) {
                VCam vCam5 = VCam.this;
                vCam5.mWidth = i10;
                vCam5.mHeight = i11;
            } else {
                VCam vCam6 = VCam.this;
                vCam6.mWidth = 320;
                vCam6.mHeight = 240;
            }
            if (Build.MANUFACTURER.equals("PTAC") && Build.MODEL.equals("FIO-BD00")) {
                VCam vCam7 = VCam.this;
                if (vCam7.mWidth * vCam7.mHeight < 921600) {
                    vCam7.mWidth = 1280;
                    vCam7.mHeight = MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH;
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("vcap: preview size -- , candidate:");
            sb3.append(i12);
            sb3.append(LanguageTag.PRIVATEUSE);
            sb3.append(i13);
            sb3.append(", largest:");
            sb3.append(i10);
            sb3.append(LanguageTag.PRIVATEUSE);
            sb3.append(i11);
            sb3.append(", preview:");
            sb3.append(VCam.this.mWidth);
            sb3.append(LanguageTag.PRIVATEUSE);
            sb3.append(VCam.this.mHeight);
            VCam.this.mIsFocusing = false;
            try {
                CaptureRequest.Builder createCaptureRequest = this.mCamDevice.createCaptureRequest(1);
                this.mCapRequestBuilder = createCaptureRequest;
                createCaptureRequest.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                if (VCam.this.mUseFaceDetection) {
                    int i18 = 0;
                    for (int i19 : (int[]) this.mCamCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES)) {
                        if (i19 > i18) {
                            i18 = i19;
                        }
                    }
                    if (i18 > 0) {
                        this.mCapRequestBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i18));
                    }
                }
                if (doSetFocusMode(VCam.this.mFocusMode) >= 0) {
                    VCam vCam8 = VCam.this;
                    if (!vCam8.mUseFaceDetection) {
                        doSetFocusPoint(vCam8.mFocusPointX, vCam8.mFocusPointY);
                    }
                } else if (((Integer) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
                    this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, null);
                }
                if (doSetExposureMode(VCam.this.mExposureMode) == 0) {
                    VCam vCam9 = VCam.this;
                    if (!vCam9.mUseFaceDetection) {
                        doSetExposurePoint(vCam9.mExposurePointX, vCam9.mExposurePointY);
                    }
                }
                try {
                    VCam vCam10 = VCam.this;
                    ImageReader newInstance = ImageReader.newInstance(vCam10.mWidth, vCam10.mHeight, 256, 1);
                    this.mSnapshotImage = newInstance;
                    newInstance.setOnImageAvailableListener(new OnSnapshotCallback(), null);
                    SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                    VCam vCam11 = VCam.this;
                    surfaceTexture.setDefaultBufferSize(vCam11.mWidth, vCam11.mHeight);
                    Surface surface = new Surface(this.mSurfaceTexture);
                    this.mCapRequestBuilder.addTarget(surface);
                    ImageReader imageReader = this.mImageReader;
                    if (imageReader != null) {
                        this.mCapRequestBuilder.addTarget(imageReader.getSurface());
                        asList = Arrays.asList(surface, this.mImageReader.getSurface(), this.mSnapshotImage.getSurface());
                    } else {
                        asList = Arrays.asList(surface, this.mSnapshotImage.getSurface());
                    }
                    VCam vCam12 = VCam.this;
                    if (vCam12.mFPSMode != 0) {
                        updateRate(vCam12.mFrameRate);
                    }
                    this.mCamDevice.createCaptureSession(asList, this.mSessionStateCallback, this.mCam2Handler);
                    return 0;
                } catch (Exception e2) {
                    VCam.this.mCamera2Error = true;
                    e2.printStackTrace();
                    return -1;
                }
            } catch (Exception e10) {
                VCam.this.mCamera2Error = true;
                e10.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int stopCam() {
            if (this.mCamDevice == null) {
                return 0;
            }
            try {
                CameraCaptureSession cameraCaptureSession = this.mCamCapSession;
                if (cameraCaptureSession == null) {
                    return 0;
                }
                cameraCaptureSession.stopRepeating();
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int takeSnapshot(int i10) {
            CameraDevice cameraDevice = this.mCamDevice;
            if (cameraDevice == null || this.mCapRequestBuilder == null) {
                return -1;
            }
            try {
                CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(2);
                CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
                createCaptureRequest.set(key, this.mCapRequestBuilder.get(key));
                CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                createCaptureRequest.set(key2, this.mCapRequestBuilder.get(key2));
                CaptureRequest.Key key3 = CaptureRequest.CONTROL_AF_TRIGGER;
                createCaptureRequest.set(key3, this.mCapRequestBuilder.get(key3));
                CaptureRequest.Key key4 = CaptureRequest.CONTROL_AF_REGIONS;
                createCaptureRequest.set(key4, this.mCapRequestBuilder.get(key4));
                CaptureRequest.Key key5 = CaptureRequest.STATISTICS_FACE_DETECT_MODE;
                createCaptureRequest.set(key5, this.mCapRequestBuilder.get(key5));
                CaptureRequest.Key key6 = CaptureRequest.SCALER_CROP_REGION;
                createCaptureRequest.set(key6, this.mCapRequestBuilder.get(key6));
                CaptureRequest.Key key7 = CaptureRequest.FLASH_MODE;
                createCaptureRequest.set(key7, this.mCapRequestBuilder.get(key7));
                CaptureRequest.Key key8 = CaptureRequest.CONTROL_AE_LOCK;
                createCaptureRequest.set(key8, this.mCapRequestBuilder.get(key8));
                CaptureRequest.Key key9 = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
                createCaptureRequest.set(key9, this.mCapRequestBuilder.get(key9));
                CaptureRequest.Key key10 = CaptureRequest.CONTROL_AE_REGIONS;
                createCaptureRequest.set(key10, this.mCapRequestBuilder.get(key10));
                try {
                    createCaptureRequest.addTarget(this.mSnapshotImage.getSurface());
                    this.mCamCapSession.capture(createCaptureRequest.build(), null, null);
                    return 0;
                } catch (CameraAccessException e2) {
                    Log.i(VCam.TAG, "vcap: capture failed");
                    e2.printStackTrace();
                    return -3;
                }
            } catch (CameraAccessException e10) {
                Log.e(VCam.TAG, "vcap: createCaptureRequest failed");
                e10.printStackTrace();
                return -2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x0281  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x02b9  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02c8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int updateRate(int r18) {
            /*
                Method dump skipped, instructions count: 767
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.Cam2Device.updateRate(int):int");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class CamDevice extends CameraDev implements Camera.PreviewCallback {
        private boolean close_shutter_sound_;
        private int curr_volume_;
        private Camera mCam;
        private Camera.CameraInfo mCamInfo;
        private Camera.Parameters mParams;
        private int volume_mode_;

        public CamDevice() {
            super();
            this.mCam = null;
            this.mCamInfo = null;
            this.mParams = null;
            this.close_shutter_sound_ = false;
            this.volume_mode_ = -1;
            this.curr_volume_ = -1;
        }

        private Rect calculateArea(float f10, float f11) {
            int i10 = VCam.this.mAreaSize;
            float f12 = (i10 / r0.mWidth) * 2.0f;
            float f13 = (i10 / r0.mHeight) * 2.0f;
            float clamp2 = VCam.clamp2(f10 - (f12 / 2.0f), -1.0f, 1.0f - f12);
            float clamp22 = VCam.clamp2(f11 - (f13 / 2.0f), -1.0f, 1.0f - f13);
            return new Rect(VCam.clamp((int) (clamp2 * 1000.0f), -1000, 1000), VCam.clamp((int) (clamp22 * 1000.0f), -1000, 1000), VCam.clamp((int) ((clamp2 + f12) * 1000.0f), -1000, 1000), VCam.clamp((int) ((clamp22 + f13) * 1000.0f), -1000, 1000));
        }

        private void createPool() {
            VCam.this.queuedBuffers.clear();
            VCam vCam = VCam.this;
            vCam.mFrameSize = ((vCam.mWidth * vCam.mHeight) * 3) / 2;
            for (int i10 = 0; i10 < 3; i10++) {
                byte[] array = ByteBuffer.allocateDirect(VCam.this.mFrameSize).array();
                VCam.this.queuedBuffers.add(array);
                this.mCam.addCallbackBuffer(array);
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int closeTorch() {
            boolean z10;
            if (this.mCam == null) {
                return -1;
            }
            String flashMode = this.mParams.getFlashMode();
            if (!this.mParams.getSupportedFlashModes().contains("off") || flashMode.equals("off")) {
                z10 = false;
            } else {
                z10 = true;
                try {
                    this.mParams.setFlashMode("off");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (!z10) {
                return 0;
            }
            try {
                this.mCam.setParameters(this.mParams);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int createCam(int i10) {
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            if (this.mCam != null) {
                return 0;
            }
            this.mCamInfo = new Camera.CameraInfo();
            try {
                this.mCam = Camera.open(i10);
                Camera.getCameraInfo(i10, this.mCamInfo);
            } catch (RuntimeException e2) {
                Log.e(VCam.TAG, "trace interruption open " + VCam.this.GetCameraString(i10) + " failed, " + ((Object) e2));
                this.mCam = null;
            }
            VCam vCam = VCam.this;
            vCam.mUseCameraId = i10;
            if (this.mCam == null) {
                if (!vCam.mTryDefault) {
                    return -1;
                }
                try {
                    this.mCam = Camera.open();
                } catch (RuntimeException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("trace interruption open ");
                    VCam vCam2 = VCam.this;
                    sb2.append(vCam2.GetCameraString(vCam2.mBackCameraId));
                    sb2.append(" failed, ");
                    sb2.append((Object) e10);
                    Log.e(VCam.TAG, sb2.toString());
                    this.mCam = null;
                }
                if (this.mCam == null) {
                    return -1;
                }
                Camera.getCameraInfo(VCam.this.mBackCameraId, this.mCamInfo);
                VCam vCam3 = VCam.this;
                vCam3.mUseCameraId = vCam3.mBackCameraId;
            }
            Camera.Parameters parameters = this.mCam.getParameters();
            this.mParams = parameters;
            Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
            VCam vCam4 = VCam.this;
            boolean z10 = vCam4.mWidth >= 720 && vCam4.mSceneMode != 0;
            List<Camera.Size> supportedVideoSizes = this.mParams.getSupportedVideoSizes();
            if (supportedVideoSizes == null) {
                supportedVideoSizes = this.mParams.getSupportedPreviewSizes();
            }
            if (supportedVideoSizes != null) {
                i13 = 0;
                i14 = 0;
                for (Camera.Size size : supportedVideoSizes) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("vcap: support size -- ");
                    sb3.append(size.width);
                    sb3.append(LanguageTag.PRIVATEUSE);
                    sb3.append(size.height);
                    int i16 = size.width;
                    int i17 = size.height;
                    if (i16 * i17 > i13 * i14 && (i16 * 3 == i17 * 4 || i16 * 9 == i17 * 16)) {
                        i13 = i16;
                        i14 = i17;
                    }
                }
                i11 = 0;
                i12 = 0;
                for (Camera.Size size2 : supportedVideoSizes) {
                    int i18 = size2.width;
                    if (i18 % 16 == 0) {
                        int i19 = size2.height;
                        if (i19 % 16 == 0 && (!z10 || preferredPreviewSizeForVideo.height * i18 == preferredPreviewSizeForVideo.width * i19)) {
                            VCam vCam5 = VCam.this;
                            int i20 = vCam5.mWidth;
                            if (i18 >= i20 && i19 >= (i15 = vCam5.mHeight)) {
                                if (i11 >= i20 && i12 >= i15 && i18 * i19 >= i11 * i12) {
                                }
                                i12 = i19;
                                i11 = i18;
                            } else if (i18 >= i20) {
                            }
                        }
                    }
                }
            } else {
                i11 = 0;
                i12 = 0;
                i13 = 0;
                i14 = 0;
            }
            if (i11 * i12 != 0) {
                this.mParams.setPreviewSize(i11, i12);
                VCam vCam6 = VCam.this;
                vCam6.mWidth = i11;
                vCam6.mHeight = i12;
            } else if (i13 * i14 != 0) {
                this.mParams.setPreviewSize(i13, i14);
                VCam vCam7 = VCam.this;
                vCam7.mWidth = i13;
                vCam7.mHeight = i14;
            } else {
                this.mParams.setPreviewSize(320, 240);
                VCam vCam8 = VCam.this;
                vCam8.mWidth = 320;
                vCam8.mHeight = 240;
            }
            String str = Build.MANUFACTURER;
            if (str.equals("Xiaomi")) {
                Build.MODEL.equals("MI 4LTE");
            }
            boolean z11 = !VCam.this.mNeedHack;
            if (str.equals("PTAC") && Build.MODEL.equals("FIO-BD00")) {
                VCam vCam9 = VCam.this;
                if (vCam9.mWidth * vCam9.mHeight < 921600) {
                    this.mParams.setPreviewSize(1280, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH);
                    VCam vCam10 = VCam.this;
                    vCam10.mWidth = 1280;
                    vCam10.mHeight = MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH;
                    z11 = true;
                }
            }
            if (!z11 && preferredPreviewSizeForVideo != null) {
                this.mParams.setPreviewSize(preferredPreviewSizeForVideo.width, preferredPreviewSizeForVideo.height);
                VCam vCam11 = VCam.this;
                vCam11.mWidth = preferredPreviewSizeForVideo.width;
                vCam11.mHeight = preferredPreviewSizeForVideo.height;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("vcap: preview size -- perferred:");
            sb4.append(preferredPreviewSizeForVideo == null ? 0 : preferredPreviewSizeForVideo.width);
            sb4.append(LanguageTag.PRIVATEUSE);
            sb4.append(preferredPreviewSizeForVideo == null ? 0 : preferredPreviewSizeForVideo.height);
            sb4.append(", candidate:");
            sb4.append(i11);
            sb4.append(LanguageTag.PRIVATEUSE);
            sb4.append(i12);
            sb4.append(", preview:");
            sb4.append(VCam.this.mWidth);
            sb4.append(LanguageTag.PRIVATEUSE);
            sb4.append(VCam.this.mHeight);
            VCam vCam12 = VCam.this;
            if (vCam12.mFPSMode != 0) {
                updateRate(vCam12.mFrameRate, this.mParams);
            }
            this.mParams.setRecordingHint(z10);
            try {
                this.mCam.setParameters(this.mParams);
                Camera.Parameters parameters2 = this.mCam.getParameters();
                this.mParams = parameters2;
                VCam.this.mWidth = parameters2.getPreviewSize().width;
                VCam.this.mHeight = this.mParams.getPreviewSize().height;
                VCam vCam13 = VCam.this;
                vCam13.mAreaSize = vCam13.mWidth / 10;
                createPool();
                if (!VCam.this.isSupportCamera2()) {
                    return 0;
                }
                VCam.this.registerCameraAvailabilityCallback(i10);
                return 0;
            } catch (Exception e11) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("vcap: set camera parameters error with exception width:");
                sb5.append(this.mParams.getPreviewSize().width);
                sb5.append(" height:");
                sb5.append(this.mParams.getPreviewSize().height);
                sb5.append(".");
                e11.printStackTrace();
                this.mCam.release();
                this.mCam = null;
                VCam vCam14 = VCam.this;
                if (vCam14.mNeedHack) {
                    return -1;
                }
                vCam14.mNeedHack = true;
                return createCam(i10);
            }
        }

        public int doSetExposureCompensation(float f10, Camera.Parameters parameters) {
            int minExposureCompensation = (int) ((f10 < 0.0f ? parameters.getMinExposureCompensation() * (-1) : parameters.getMaxExposureCompensation()) * f10);
            try {
                parameters.setExposureCompensation(minExposureCompensation);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("vcap: set exposure compensation ");
                sb2.append(minExposureCompensation);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        public int doSetExposureMode(int i10, Camera.Parameters parameters) {
            if (i10 == -1) {
                return 0;
            }
            if (!parameters.isAutoExposureLockSupported()) {
                return -1;
            }
            VCam.access$708(VCam.this);
            try {
                if (i10 == 0 || i10 == 5 || i10 == 4) {
                    parameters.setAutoExposureLock(false);
                } else if (i10 == 1) {
                    parameters.setAutoExposureLock(true);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("vcap: set exposure mode ");
                sb2.append(i10);
                if (i10 == 4) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = Integer.valueOf(VCam.this.mExposureGeneration);
                    VCam.this.mHandler.sendMessageDelayed(obtain, 200L);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            doSetExposureCompensation(VCam.this.mExposureCompensation, parameters);
            return 0;
        }

        public int doSetExposurePoint(float f10, float f11, Camera.Parameters parameters) {
            if (parameters.getMaxNumMeteringAreas() == 0) {
                return -1;
            }
            Rect calculateArea = calculateArea(f10, f11);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateArea, 800));
            try {
                parameters.setMeteringAreas(arrayList);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("vcap: set exposure area ");
                sb2.append(calculateArea.toString());
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int doSetFocusMode(int r9, android.hardware.Camera.Parameters r10) {
            /*
                r8 = this;
                java.lang.String r0 = "macro"
                java.lang.String r1 = "auto"
                r2 = 1
                if (r9 == 0) goto L2a
                if (r9 == r2) goto L27
                r3 = 2
                if (r9 == r3) goto L25
                r3 = 3
                if (r9 == r3) goto L22
                r3 = 4
                if (r9 == r3) goto L1f
                r3 = 5
                if (r9 == r3) goto L1c
                r3 = 8
                if (r9 == r3) goto L2a
                java.lang.String r9 = "continuous-picture"
                goto L2b
            L1c:
                java.lang.String r9 = "continuous-video"
                goto L2b
            L1f:
                java.lang.String r9 = "edof"
                goto L2b
            L22:
                java.lang.String r9 = "fixed"
                goto L2b
            L25:
                r9 = r0
                goto L2b
            L27:
                java.lang.String r9 = "infinity"
                goto L2b
            L2a:
                r9 = r1
            L2b:
                java.util.List r3 = r10.getSupportedFocusModes()
                java.lang.String r4 = "vcap"
                r5 = 0
                if (r3 == 0) goto L7d
                boolean r6 = r3.contains(r9)
                if (r6 == 0) goto L5d
                r10.setFocusMode(r9)     // Catch: java.lang.Exception -> L52
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L52
                r6.<init>()     // Catch: java.lang.Exception -> L52
                java.lang.String r7 = "vcap: set focus mode "
                r6.append(r7)     // Catch: java.lang.Exception -> L52
                r6.append(r9)     // Catch: java.lang.Exception -> L52
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L52
                com.zego.ve.Log.i(r4, r6)     // Catch: java.lang.Exception -> L52
                goto L5b
            L52:
                r6 = move-exception
                java.lang.String r7 = "vcap: set focus mode failed"
                com.zego.ve.Log.e(r4, r7)
                r6.printStackTrace()
            L5b:
                r6 = 1
                goto L5e
            L5d:
                r6 = 0
            L5e:
                if (r6 != 0) goto L7e
                java.lang.Object r9 = r3.get(r5)
                java.lang.String r9 = (java.lang.String) r9
                r10.setFocusMode(r9)     // Catch: java.lang.Exception -> L77
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
                r10.<init>()     // Catch: java.lang.Exception -> L77
                java.lang.String r3 = "vcap: fallback focus mode "
                r10.append(r3)     // Catch: java.lang.Exception -> L77
                r10.append(r9)     // Catch: java.lang.Exception -> L77
                goto L7b
            L77:
                r10 = move-exception
                r10.printStackTrace()
            L7b:
                r6 = 1
                goto L7e
            L7d:
                r6 = 0
            L7e:
                if (r6 != 0) goto L87
                java.lang.String r9 = "vcap: focus mode left unset"
                com.zego.ve.Log.i(r4, r9)
                r9 = -1
                return r9
            L87:
                if (r9 == r1) goto L8d
                if (r9 != r0) goto L8c
                goto L8d
            L8c:
                r2 = 0
            L8d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.CamDevice.doSetFocusMode(int, android.hardware.Camera$Parameters):int");
        }

        public int doSetFocusPoint(float f10, float f11, Camera.Parameters parameters) {
            if (parameters.getMaxNumFocusAreas() == 0) {
                return -1;
            }
            Rect calculateArea = calculateArea(f10, f11);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateArea, 800));
            try {
                parameters.setFocusAreas(arrayList);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("vcap: set focus area ");
                sb2.append(calculateArea.toString());
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int getMaxZoomRatio() {
            if (this.mCam == null || !this.mParams.isZoomSupported()) {
                return 100;
            }
            List<Integer> zoomRatios = this.mParams.getZoomRatios();
            if (zoomRatios.size() == 0) {
                return 100;
            }
            return zoomRatios.get(this.mParams.getMaxZoom()).intValue();
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int getOrientation() {
            Camera.CameraInfo cameraInfo = this.mCamInfo;
            if (cameraInfo != null) {
                return cameraInfo.orientation;
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int handleExposureMode(int i10) {
            return doSetExposureMode(VCam.this.mExposureMode, this.mParams);
        }

        @Override // com.zego.ve.VCam.CameraDev
        public boolean isFocusSupported() {
            Camera.Parameters parameters = this.mParams;
            if (parameters == null) {
                return false;
            }
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            boolean z10 = supportedFocusModes != null && (supportedFocusModes.contains(Attributes.LayoutDirection.AUTO) || supportedFocusModes.contains("continuous-video") || supportedFocusModes.contains("continuous-picture"));
            return !z10 ? z10 : this.mParams.getMaxNumFocusAreas() > 0;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (VCam.this.queuedBuffers.contains(bArr)) {
                VCam.onBufferAvailable(VCam.this.mThis, bArr, VCam.this.mFrameRate);
                camera.addCallbackBuffer(bArr);
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int openTorch() {
            boolean z10;
            if (this.mCam == null) {
                return -1;
            }
            String flashMode = this.mParams.getFlashMode();
            if (!this.mParams.getSupportedFlashModes().contains("torch") || flashMode.equals("torch")) {
                z10 = false;
            } else {
                z10 = true;
                try {
                    this.mParams.setFlashMode("torch");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (!z10) {
                return 0;
            }
            try {
                this.mCam.setParameters(this.mParams);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int releaseCam() {
            Camera camera = this.mCam;
            if (camera != null) {
                camera.release();
                this.mCam = null;
            }
            this.mCamInfo = null;
            this.mParams = null;
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setExposureCompensation(float f10) {
            if (this.mCam == null || doSetExposureCompensation(f10, this.mParams) != 0) {
                return -1;
            }
            try {
                this.mCam.setParameters(this.mParams);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setExposureMode(int i10) {
            if (this.mCam == null || doSetExposureMode(VCam.this.mExposureMode, this.mParams) != 0) {
                return -1;
            }
            try {
                this.mCam.setParameters(this.mParams);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setExposurePoint(float f10, float f11) {
            if (this.mCam != null && !VCam.this.mUseFaceDetection) {
                doSetExposurePoint(f10, f11, this.mParams);
                try {
                    this.mCam.setParameters(this.mParams);
                    return 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setFocusMode(int i10) {
            Camera camera = this.mCam;
            if (camera == null) {
                return -1;
            }
            camera.cancelAutoFocus();
            int doSetFocusMode = doSetFocusMode(VCam.this.mFocusMode, this.mParams);
            if (doSetFocusMode >= 0) {
                VCam vCam = VCam.this;
                if (!vCam.mUseFaceDetection) {
                    doSetFocusPoint(vCam.mFocusPointX, vCam.mFocusPointY, this.mParams);
                }
            } else if (this.mParams.getMaxNumFocusAreas() > 0) {
                this.mParams.setFocusAreas(null);
            }
            try {
                this.mCam.setParameters(this.mParams);
                if (doSetFocusMode <= 0) {
                    return 0;
                }
                VCam.this.mIsFocusing = true;
                this.mCam.autoFocus(new Camera.AutoFocusCallback() { // from class: com.zego.ve.VCam.CamDevice.3
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z10, Camera camera2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("vcap: set focus success:");
                        sb2.append(z10);
                        VCam.this.mIsFocusing = false;
                    }
                });
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setFocusPoint(float f10, float f11) {
            if (this.mCam == null) {
                return -1;
            }
            VCam vCam = VCam.this;
            if (vCam.mUseFaceDetection || vCam.mIsFocusing) {
                return -1;
            }
            setFocusMode(vCam.mFocusMode);
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setImageReader(ImageReader imageReader) {
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setRate(int i10) {
            if (this.mCam == null) {
                return 0;
            }
            updateRate(i10, this.mParams);
            try {
                this.mCam.setParameters(this.mParams);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int setSurfaceTexture(SurfaceTexture surfaceTexture) {
            Camera camera = this.mCam;
            if (camera == null) {
                return -1;
            }
            try {
                camera.setPreviewTexture(surfaceTexture);
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public void setZoomFactor(float f10) {
            if (this.mCam != null && this.mParams.isZoomSupported()) {
                List<Integer> zoomRatios = this.mParams.getZoomRatios();
                if (zoomRatios.size() == 0) {
                    return;
                }
                int i10 = (int) (f10 * 100.0f);
                int i11 = 0;
                if (i10 != 100) {
                    int i12 = 1;
                    while (true) {
                        if (i12 >= zoomRatios.size()) {
                            break;
                        }
                        if (zoomRatios.get(i12).intValue() >= i10) {
                            i11 = i12;
                            break;
                        }
                        i12++;
                    }
                }
                this.mParams.setZoom(i11);
                try {
                    this.mCam.setParameters(this.mParams);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
        
            if (r14.contains("night") != false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
        
            r7 = "night";
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x005c, code lost:
        
            if (r14.contains("night") != false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x007e, code lost:
        
            if (r14.contains("sports") != false) goto L84;
         */
        @Override // com.zego.ve.VCam.CameraDev
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int startCam(boolean r14) {
            /*
                Method dump skipped, instructions count: 333
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.CamDevice.startCam(boolean):int");
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int stopCam() {
            VCam.access$708(VCam.this);
            Camera camera = this.mCam;
            if (camera != null) {
                if (VCam.this.mUseFaceDetection) {
                    camera.stopFaceDetection();
                }
                try {
                    this.mCam.setPreviewCallbackWithBuffer(null);
                    this.mCam.setPreviewTexture(null);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Thread(new Runnable() { // from class: com.zego.ve.VCam.CamDevice.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Log.i(VCam.TAG, "vcap: stopPreview on release thread");
                            CamDevice.this.mCam.stopPreview();
                            Log.i(VCam.TAG, "vcap: stopPreview on release thread done");
                        } catch (Exception unused) {
                            Log.i(VCam.TAG, "vcap: stopPreview failed");
                        }
                        countDownLatch.countDown();
                    }
                }).start();
                if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 500L)) {
                    Log.i(VCam.TAG, "vcap: stopPreview release timeout");
                    return -1;
                }
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int takeSnapshot(int i10) {
            boolean z10;
            if (this.mCam != null && 0 != VCam.this.mThis) {
                int i11 = this.mParams.getPreviewSize().width;
                int i12 = this.mParams.getPreviewSize().height;
                List<Camera.Size> supportedPictureSizes = this.mParams.getSupportedPictureSizes();
                Log.i(VCam.TAG, "vcap: preview picture size -- " + i11 + LanguageTag.PRIVATEUSE + i12);
                if (supportedPictureSizes != null) {
                    Collections.sort(supportedPictureSizes, new Comparator<Camera.Size>() { // from class: com.zego.ve.VCam.CamDevice.4
                        @Override // java.util.Comparator
                        public int compare(Camera.Size size, Camera.Size size2) {
                            int i13;
                            int i14 = size.width - size2.width;
                            if (i14 > 0) {
                                return -1;
                            }
                            if (i14 >= 0 && (i13 = size.height - size2.height) >= 0) {
                                return i13 > 0 ? -1 : 0;
                            }
                            return 1;
                        }
                    });
                    int i13 = i11;
                    int i14 = i12;
                    z10 = false;
                    for (Camera.Size size : supportedPictureSizes) {
                        Log.i(VCam.TAG, "vcap: support picture size -- " + size.width + LanguageTag.PRIVATEUSE + size.height);
                        int i15 = size.width;
                        int i16 = size.height;
                        if (i15 * i16 >= i11 * i12 || !z10) {
                            i14 = i16;
                            i13 = i15;
                            z10 = true;
                        }
                    }
                    i11 = i13;
                    i12 = i14;
                } else {
                    z10 = false;
                }
                if (z10) {
                    Log.i(VCam.TAG, "vcap: set picture size -- " + i11 + LanguageTag.PRIVATEUSE + i12);
                    if (i11 != 0 && i12 != 0) {
                        try {
                            this.mParams.setPictureSize(i11, i12);
                            this.mCam.setParameters(this.mParams);
                        } catch (Exception e2) {
                            Log.e(VCam.TAG, "vcap: failed to set picture size:" + e2.toString());
                            return -2;
                        }
                    }
                } else {
                    Log.i(VCam.TAG, "vcap: not found suitable picture size. using default size");
                }
                if (this.mCamInfo.canDisableShutterSound) {
                    if (!this.mCam.enableShutterSound(false)) {
                        Log.i(VCam.TAG, "vcap: failed to close shutter sound");
                    } else {
                        this.close_shutter_sound_ = true;
                    }
                } else {
                    Log.i(VCam.TAG, "vcap: not allow to close shutter sound");
                }
                this.mCam.takePicture(new Camera.ShutterCallback() { // from class: com.zego.ve.VCam.CamDevice.5
                    @Override // android.hardware.Camera.ShutterCallback
                    public void onShutter() {
                        Log.i(VCam.TAG, "vcap: ready take picture. stop preview");
                    }
                }, null, new Camera.PictureCallback() { // from class: com.zego.ve.VCam.CamDevice.6
                    @Override // android.hardware.Camera.PictureCallback
                    public void onPictureTaken(byte[] bArr, Camera camera) {
                        CamDevice.this.mCam.startPreview();
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
                        allocateDirect.put(bArr);
                        VCam.onSnapshotTaken(VCam.this.mThis, allocateDirect, 0);
                    }
                });
                return 0;
            }
            Log.e(VCam.TAG, "vcap: camera or pthis is null" + ((Object) this.mCam) + " " + VCam.this.mThis);
            return -1;
        }

        public int updateRate(int i10, Camera.Parameters parameters) {
            int i11;
            int i12;
            int i13;
            int i14;
            char c4;
            char c10;
            char c11;
            char c12;
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            char c13 = 0;
            if (supportedPreviewFpsRange != null) {
                VCam vCam = VCam.this;
                if (vCam.mFpsMin != -1000 && vCam.mFpsMax != -1000) {
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    for (int[] iArr : supportedPreviewFpsRange) {
                        Log.i(VCam.TAG, "cam fps:|" + (iArr[c13] / 1000) + "|" + (iArr[1] / 1000) + "|");
                        int abs = Math.abs(iArr[c13] - VCam.this.mFpsMin);
                        if (iArr[1] >= VCam.this.mFpsMax) {
                            if (i11 == 0 || iArr[1] < i11 || (iArr[1] == i11 && abs < i16)) {
                                c12 = 0;
                            } else if (iArr[1] == i11 && abs == i16) {
                                c12 = 0;
                                if (iArr[0] <= i13) {
                                }
                            }
                            i13 = iArr[c12];
                            i11 = iArr[1];
                            i16 = abs;
                        } else {
                            if (i12 == 0 || iArr[1] > i12 || (iArr[1] == i12 && abs < i15)) {
                                c11 = 0;
                            } else if (iArr[1] == i12 && abs == i15) {
                                c11 = 0;
                                if (iArr[0] <= i14) {
                                }
                            }
                            i14 = iArr[c11];
                            i12 = iArr[1];
                            i15 = abs;
                        }
                        c13 = 0;
                    }
                } else {
                    int i17 = vCam.mFrameRate * 1000;
                    if (vCam.mLowLightBoost) {
                        i11 = 0;
                        i12 = 0;
                        i13 = 0;
                        i14 = 0;
                        for (int[] iArr2 : supportedPreviewFpsRange) {
                            if (iArr2[1] >= i17) {
                                if (i11 == 0 || iArr2[1] < i11) {
                                    c10 = 0;
                                } else if (iArr2[1] == i11) {
                                    c10 = 0;
                                    if (iArr2[0] < i13) {
                                    }
                                }
                                i13 = iArr2[c10];
                                i11 = iArr2[1];
                            } else if (i12 == 0 || iArr2[1] > i12 || (iArr2[1] == i12 && iArr2[0] < i14)) {
                                i14 = iArr2[0];
                                i12 = iArr2[1];
                            }
                        }
                    } else {
                        i11 = 0;
                        i12 = 0;
                        i13 = 0;
                        i14 = 0;
                        for (int[] iArr3 : supportedPreviewFpsRange) {
                            if (iArr3[1] >= i17) {
                                if (i11 == 0 || iArr3[1] < i11) {
                                    c4 = 0;
                                } else if (iArr3[1] == i11) {
                                    c4 = 0;
                                    if (iArr3[0] > i13) {
                                    }
                                }
                                i13 = iArr3[c4];
                                i11 = iArr3[1];
                            } else if (i12 == 0 || iArr3[1] > i12 || (iArr3[1] == i12 && iArr3[0] > i14)) {
                                i14 = iArr3[0];
                                i12 = iArr3[1];
                            }
                        }
                    }
                }
                if (i11 != 0) {
                    parameters.setPreviewFpsRange(i13, i11);
                } else if (i12 != 0) {
                    parameters.setPreviewFpsRange(i14, i12);
                }
            }
            int[] iArr4 = new int[2];
            parameters.getPreviewFpsRange(iArr4);
            if (iArr4[0] == iArr4[1]) {
                VCam.this.mFrameRate = iArr4[0] / 1000;
            } else {
                VCam.this.mFrameRate = (iArr4[1] / 2) / 1000;
            }
            Log.i(VCam.TAG, "real fps:|" + (iArr4[0] / 1000) + "|" + (iArr4[1] / 1000) + "|");
            return 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public abstract class CameraDev {
        public CameraDev() {
        }

        public abstract int closeTorch();

        public abstract int createCam(int i10);

        public abstract int getMaxZoomRatio();

        public abstract int getOrientation();

        public abstract int handleExposureMode(int i10);

        public abstract boolean isFocusSupported();

        public abstract int openTorch();

        public abstract int releaseCam();

        public abstract int setExposureCompensation(float f10);

        public abstract int setExposureMode(int i10);

        public abstract int setExposurePoint(float f10, float f11);

        public abstract int setFocusMode(int i10);

        public abstract int setFocusPoint(float f10, float f11);

        public abstract int setImageReader(ImageReader imageReader);

        public abstract int setRate(int i10);

        public abstract int setSurfaceTexture(SurfaceTexture surfaceTexture);

        public abstract void setZoomFactor(float f10);

        public abstract int startCam(boolean z10);

        public abstract int stopCam();

        public abstract int takeSnapshot(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String GetCameraString(int i10) {
        return i10 == this.mFrontCameraId ? "front camera" : "back camera";
    }

    public static /* synthetic */ int access$708(VCam vCam) {
        int i10 = vCam.mExposureGeneration;
        vCam.mExposureGeneration = i10 + 1;
        return i10;
    }

    public static int clamp(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    public static float clamp2(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNumericString(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSupportCamera2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onBufferAvailable(long j10, byte[] bArr, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onCameraAvailable(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onCameraUnavailable(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onSnapshotTaken(long j10, ByteBuffer byteBuffer, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public void registerCameraAvailabilityCallback(int i10) {
        Context context = this.mContext;
        if (context != null) {
            try {
                CameraManager cameraManager = (CameraManager) context.getSystemService(ZegoConstants.DeviceNameType.DeviceNameCamera);
                CameraAvailabilityCallback cameraAvailabilityCallback = new CameraAvailabilityCallback(this.mThis, i10, new CameraAvailabilityCallback.Listener() { // from class: com.zego.ve.VCam.1
                    @Override // com.zego.ve.CameraAvailabilityCallback.Listener
                    public void onCameraAvailable(long j10, String str) {
                        Log.i(VCam.TAG, "trace interruption this: " + ((Object) VCam.this) + ", cameraId: " + str + " available, mUseCameraId: " + VCam.this.mUseCameraId);
                        if (VCam.this.isNumericString(str)) {
                            VCam.onCameraAvailable(j10, Integer.parseInt(str));
                        } else {
                            VCam.onCameraAvailable(j10, -1);
                        }
                    }

                    @Override // com.zego.ve.CameraAvailabilityCallback.Listener
                    public void onCameraUnavailable(long j10, String str) {
                        Log.i(VCam.TAG, "trace interruption this: " + ((Object) VCam.this) + ", cameraId: " + str + " unavailable, mUseCameraId: " + VCam.this.mUseCameraId);
                        if (VCam.this.isNumericString(str)) {
                            VCam.onCameraUnavailable(j10, Integer.parseInt(str));
                        } else {
                            VCam.onCameraUnavailable(j10, -1);
                        }
                    }
                });
                this.mCameraAvailabilityCallback = cameraAvailabilityCallback;
                cameraManager.registerAvailabilityCallback(cameraAvailabilityCallback, (Handler) null);
            } catch (Throwable th) {
                Log.e(TAG, "registerCameraAvailabilityCallback failed, " + th);
            }
        }
    }

    private void unregisterCameraAvailabilityCallback() {
        if (this.mContext != null) {
            try {
                CameraAvailabilityCallback cameraAvailabilityCallback = this.mCameraAvailabilityCallback;
                if (cameraAvailabilityCallback != null) {
                    cameraAvailabilityCallback.uninit();
                    ((CameraManager) this.mContext.getSystemService(ZegoConstants.DeviceNameType.DeviceNameCamera)).unregisterAvailabilityCallback(this.mCameraAvailabilityCallback);
                    this.mCameraAvailabilityCallback = null;
                }
            } catch (Throwable th) {
                Log.e(TAG, "unregisterCameraAvailabilityCallback failed, " + th);
            }
        }
    }

    public boolean checkPermission() {
        return PermissionChecker.checkSelfPermission(this.mContext, "android.permission.CAMERA");
    }

    public int closeTorch() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.closeTorch();
        }
        return 0;
    }

    public int createCam(int i10, int i11, boolean z10, boolean z11) {
        if (i10 == -1) {
            return -1;
        }
        this.mSceneMode = i11;
        this.mLowLightBoost = z10;
        int i12 = 0;
        if (z11 && isSupportCamera2() && !this.mCamera2Error) {
            this.mCamDevice = new Cam2Device();
            i12 = 1;
        } else {
            this.mCamDevice = new CamDevice();
        }
        Log.i(TAG, "create cameraid:" + i10 + " camera2:" + i12);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vcap -- board: ");
        sb2.append(Build.BOARD);
        sb2.append(" device: ");
        sb2.append(Build.DEVICE);
        sb2.append(" manufacturer: ");
        sb2.append(Build.MANUFACTURER);
        sb2.append(" brand: ");
        sb2.append(Build.BRAND);
        sb2.append(" model: ");
        sb2.append(Build.MODEL);
        sb2.append(" product: ");
        sb2.append(Build.PRODUCT);
        sb2.append(" sdk: ");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append(" cameraid:");
        sb2.append(i10);
        sb2.append(" camera2:");
        sb2.append(i12);
        return this.mCamDevice.createCam(i10);
    }

    public void enumerateCamera(boolean z10) {
        boolean z11;
        if (z10 && isSupportCamera2() && !this.mCamera2Error) {
            enumerateCamera2();
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || this.mCamera2Error) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i10 = 0; i10 < numberOfCameras; i10++) {
                Camera.getCameraInfo(i10, cameraInfo);
                int i11 = cameraInfo.facing;
                if (i11 == 0 && this.mBackCameraId == -1) {
                    this.mBackCameraId = i10;
                }
                if (i11 == 1 && this.mFrontCameraId == -1) {
                    this.mFrontCameraId = i10;
                }
            }
        }
        Log.i(TAG, "trace interruption enumerateCamera this: " + ((Object) this) + ", mFrontCameraId: " + this.mFrontCameraId + ", mBackCameraId: " + this.mBackCameraId);
    }

    public void enumerateCamera2() {
        int i10;
        this.mCameraIDList = new String[2];
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService(ZegoConstants.DeviceNameType.DeviceNameCamera);
        try {
            int i11 = 0;
            for (String str : cameraManager.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0 && this.mFrontCameraId == -1) {
                    this.mFrontCameraId = i11;
                    this.mCameraIDList[i11] = str;
                    i11++;
                }
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1 && this.mBackCameraId == -1) {
                    this.mBackCameraId = i11;
                    this.mCameraIDList[i11] = str;
                    i11++;
                }
            }
            if ((this.mFrontCameraId == -1 || this.mBackCameraId == -1) && this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.external")) {
                for (String str2 : cameraManager.getCameraIdList()) {
                    CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(str2);
                    if (((Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING)).intValue() == 2 && this.mFrontCameraId == -1) {
                        i10 = i11 + 1;
                        this.mFrontCameraId = i11;
                        this.mCameraIDList[i11] = str2;
                        Log.i(TAG, "cam external front:" + str2);
                    } else {
                        if (((Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING)).intValue() == 2 && this.mBackCameraId == -1) {
                            i10 = i11 + 1;
                            this.mBackCameraId = i11;
                            this.mCameraIDList[i11] = str2;
                            Log.i(TAG, "cam external back" + str2);
                        }
                    }
                    i11 = i10;
                }
            }
        } catch (Exception e2) {
            this.mCamera2Error = true;
            e2.printStackTrace();
        }
    }

    public int getBackCameraId() {
        return this.mBackCameraId;
    }

    public int getFramerate() {
        return this.mFrameRate;
    }

    public int getFront() {
        return (this.mCamDevice == null || this.mUseCameraId != this.mFrontCameraId) ? 0 : 1;
    }

    public int getFrontCameraId() {
        return this.mFrontCameraId;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getMaxZoomRatio() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.getMaxZoomRatio();
        }
        return 100;
    }

    public int getOrientation() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.getOrientation();
        }
        return 0;
    }

    public int getWidth() {
        return this.mWidth;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0 && ((Integer) message.obj).intValue() == this.mExposureGeneration) {
            this.mCamDevice.handleExposureMode(1);
        }
        return true;
    }

    public void init() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.myLooper(), this);
        }
    }

    public boolean isFocusSupported() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.isFocusSupported();
        }
        return false;
    }

    public boolean isSamsung() {
        return "samsung".equals(Build.MANUFACTURER.toLowerCase());
    }

    public int openTorch() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.openTorch();
        }
        return 0;
    }

    public int releaseCam() {
        if (isSupportCamera2()) {
            unregisterCameraAvailabilityCallback();
        }
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            cameraDev.releaseCam();
            this.mCamDevice = null;
        }
        this.mUseCameraId = -1;
        return 0;
    }

    public int setContext(long j10, Context context, boolean z10) {
        this.mThis = j10;
        this.mContext = context;
        this.mTryDefault = z10;
        return 0;
    }

    public int setExposureCompensation(float f10) {
        this.mExposureCompensation = f10;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setExposureCompensation(f10);
        }
        return 0;
    }

    public int setExposureMode(int i10) {
        this.mExposureMode = i10 == -1 ? 0 : i10;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setExposureMode(i10);
        }
        return 0;
    }

    public int setExposurePoint(float f10, float f11) {
        this.mExposurePointX = f10;
        this.mExposurePointY = f11;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setExposurePoint(f10, f11);
        }
        return 0;
    }

    public int setFPSRange(int i10, int i11) {
        this.mFpsMin = i10 * 1000;
        this.mFpsMax = i11 * 1000;
        return 0;
    }

    public int setFocusMode(int i10) {
        this.mFocusMode = i10;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setFocusMode(i10);
        }
        return 0;
    }

    public int setFocusPoint(float f10, float f11) {
        this.mFocusPointX = f10;
        this.mFocusPointY = f11;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setFocusPoint(f10, f11);
        }
        return 0;
    }

    public int setImageReader(ImageReader imageReader) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setImageReader(imageReader);
        }
        return 0;
    }

    public int setRate(int i10, int i11) {
        this.mFPSMode = i11;
        if (i11 == 0) {
            return 0;
        }
        if (i11 == 1) {
            i10 = 30;
        }
        this.mFrameRate = i10;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setRate(i10);
        }
        return 0;
    }

    public int setSize(int i10, int i11) {
        if (i10 < i11) {
            this.mWidth = i11;
            this.mHeight = i10;
        } else {
            this.mWidth = i10;
            this.mHeight = i11;
        }
        this.mNeedHack = false;
        return 0;
    }

    public int setSurfaceTexture(SurfaceTexture surfaceTexture) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setSurfaceTexture(surfaceTexture);
        }
        return 0;
    }

    public void setZoomFactor(float f10) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            cameraDev.setZoomFactor(f10);
        }
    }

    public int startCam(boolean z10) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.startCam(z10);
        }
        return 0;
    }

    public int stopCam() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.stopCam();
        }
        return 0;
    }

    public int takeSnapshot(int i10) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.takeSnapshot(i10);
        }
        return 0;
    }

    public void uninit() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(this);
            this.mHandler = null;
        }
    }
}
