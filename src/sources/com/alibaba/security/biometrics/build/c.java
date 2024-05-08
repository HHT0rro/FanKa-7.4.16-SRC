package com.alibaba.security.biometrics.build;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Pair;
import android.view.WindowManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.video.VideoRecorderService;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Camera1Adapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c extends b {
    private Throwable A;
    private Throwable B;

    /* renamed from: n, reason: collision with root package name */
    public VideoRecorderService f2282n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2283o;

    /* renamed from: p, reason: collision with root package name */
    private Camera f2284p;

    /* renamed from: q, reason: collision with root package name */
    private final int f2285q;

    /* renamed from: r, reason: collision with root package name */
    private int f2286r;

    /* renamed from: s, reason: collision with root package name */
    private Camera.CameraInfo f2287s;

    /* renamed from: t, reason: collision with root package name */
    private List<Camera.Size> f2288t;

    /* renamed from: u, reason: collision with root package name */
    private List<int[]> f2289u;

    /* renamed from: v, reason: collision with root package name */
    private int[] f2290v;

    /* renamed from: w, reason: collision with root package name */
    private Camera.Parameters f2291w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f2292x;

    /* renamed from: y, reason: collision with root package name */
    private Throwable f2293y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f2294z;

    public c(Context context, ALBiometricsParams aLBiometricsParams) {
        super(context, aLBiometricsParams);
        this.f2285q = 30;
    }

    private void n() {
        this.f2294z = false;
        this.f2292x = false;
        this.B = null;
        this.A = null;
        this.f2293y = null;
    }

    private static Pair<Camera.CameraInfo, Integer> o() {
        return a(1);
    }

    private static Pair<Camera.CameraInfo, Integer> p() {
        return a(0);
    }

    @Override // com.alibaba.security.biometrics.build.b
    public final void c() {
        this.f2283o = false;
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final boolean j() {
        return this.f2284p != null;
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final void k() {
        if (this.f2282n == null) {
            this.f2282n = new VideoRecorderService(this.f2261f);
        }
        VideoRecorderService videoRecorderService = this.f2282n;
        Point point = this.f2260e;
        videoRecorderService.init(point.x, point.y, this.f2286r, this.f2265j);
        this.f2283o = true;
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final String l() {
        HashMap hashMap = new HashMap();
        hashMap.put("displayRate", Integer.valueOf(this.f2264i));
        hashMap.put("frameRate", Integer.valueOf(this.f2286r));
        hashMap.put("cameraRotate", Integer.valueOf(this.f2265j));
        hashMap.put("cameraInfo", JsonUtils.toJSON(this.f2287s));
        hashMap.put("previewSize", JsonUtils.toJSON(this.f2260e));
        hashMap.put("supportPreviewSize", JsonUtils.toJSON(this.f2288t));
        hashMap.put("supportPreviewFpsRange", JsonUtils.toJSON(this.f2289u));
        hashMap.put("currentPreviewFpsRange", JsonUtils.toJSON(this.f2290v));
        hashMap.put("cameraParameters", JsonUtils.toJSON(this.f2291w));
        hashMap.put("startCameraTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("isCameraOpen", Boolean.valueOf(this.f2292x));
        hashMap.put("openException", CommonUtils.getStackTrace(this.f2293y));
        return JsonUtils.toJSON(hashMap);
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final String m() {
        HashMap hashMap = new HashMap();
        hashMap.put("previewNumber", Integer.valueOf(this.f2268m));
        hashMap.put("finishCameraTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("isCameraClose", Boolean.valueOf(this.f2294z));
        hashMap.put("closeException", CommonUtils.getStackTrace(this.A));
        hashMap.put("previewException", CommonUtils.getStackTrace(this.B));
        return JsonUtils.toJSON(hashMap);
    }

    private static boolean a(Camera camera) {
        try {
            Field declaredField = camera.getClass().getDeclaredField("mHasPermission");
            declaredField.setAccessible(true);
            return ((Boolean) declaredField.get(camera)).booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }

    private int c(Camera.Parameters parameters) {
        this.f2289u = parameters.getSupportedPreviewFpsRange();
        int[] iArr = new int[2];
        this.f2290v = iArr;
        parameters.getPreviewFpsRange(iArr);
        for (int[] iArr2 : this.f2289u) {
            if (iArr2[0] == iArr2[1] && iArr2[0] == 30000) {
                parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                return iArr2[0];
            }
        }
        int[] iArr3 = this.f2290v;
        if (iArr3[0] == iArr3[1]) {
            return iArr3[0];
        }
        return iArr3[1] / 2;
    }

    @Override // com.alibaba.security.biometrics.build.b
    public final void b() {
        Camera camera = this.f2284p;
        if (camera == null) {
            return;
        }
        try {
            camera.stopPreview();
            this.f2284p.setOneShotPreviewCallback(null);
            this.f2284p.setPreviewCallback(null);
            this.f2284p.release();
            a((OnCameraVideoReorderListener) null, false);
            this.f2294z = true;
        } catch (Throwable th) {
            try {
                this.f2294z = false;
                this.A = th;
            } finally {
                this.f2284p = null;
            }
        }
    }

    @Override // com.alibaba.security.biometrics.build.b
    public final void a() {
        int i10;
        int i11;
        List<String> supportedFocusModes;
        if (j()) {
            e();
            return;
        }
        this.f2294z = false;
        this.f2292x = false;
        Point point = null;
        this.B = null;
        this.A = null;
        this.f2293y = null;
        try {
            Pair<Camera.CameraInfo, Integer> a10 = a(1);
            int intValue = a10 == null ? -1 : ((Integer) a10.second).intValue();
            if (intValue == -1) {
                a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "find camera id fail");
                return;
            }
            try {
                Camera open = Camera.open(intValue);
                this.f2284p = open;
                if (open == null) {
                    a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "camera open fail by camera is null");
                    return;
                }
                Camera.Parameters parameters = open.getParameters();
                this.f2291w = parameters;
                if (parameters == null) {
                    a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "start preview fail by camera parameters get fail");
                    return;
                }
                try {
                    this.f2284p.getParameters();
                    if (!a(this.f2284p)) {
                        a(GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION, "camera open fail by no permission");
                        return;
                    }
                    try {
                        this.f2291w.setPictureFormat(256);
                        this.f2291w.setPreviewFormat(17);
                        Camera.Parameters parameters2 = this.f2291w;
                        this.f2289u = parameters2.getSupportedPreviewFpsRange();
                        int[] iArr = new int[2];
                        this.f2290v = iArr;
                        parameters2.getPreviewFpsRange(iArr);
                        Iterator<int[]> iterator2 = this.f2289u.iterator2();
                        while (true) {
                            if (iterator2.hasNext()) {
                                int[] next = iterator2.next();
                                if (next[0] == next[1] && next[0] == 30000) {
                                    parameters2.setPreviewFpsRange(next[0], next[1]);
                                    i10 = next[0];
                                    break;
                                }
                            } else {
                                int[] iArr2 = this.f2290v;
                                if (iArr2[0] == iArr2[1]) {
                                    i10 = iArr2[0];
                                } else {
                                    i10 = iArr2[1] / 2;
                                }
                            }
                        }
                        this.f2286r = i10 / 1000;
                        this.f2291w.setRecordingHint(true);
                        Camera.Parameters parameters3 = this.f2291w;
                        List<Point> b4 = b(parameters3.getSupportedPictureSizes());
                        if (b4 != null) {
                            Collections.sort(b4, this.f2262g);
                            int i12 = 0;
                            for (Point point2 : b4) {
                                int i13 = point2.x;
                                if (i13 >= 600) {
                                    if (((double) Math.abs((((float) i13) / ((float) point2.y)) - 0.0f)) <= 0.05d) {
                                        break;
                                    }
                                }
                                i12++;
                            }
                            if (i12 == b4.size()) {
                                i12 = 0;
                            }
                            point = b4.get(i12);
                        }
                        this.f2259d = point;
                        parameters3.setPictureSize(point.x, point.y);
                        Camera.Parameters parameters4 = this.f2291w;
                        List<Camera.Size> supportedPreviewSizes = parameters4.getSupportedPreviewSizes();
                        this.f2288t = supportedPreviewSizes;
                        Point a11 = a(b(supportedPreviewSizes));
                        this.f2260e = a11;
                        parameters4.setPreviewSize(a11.x, a11.y);
                        Context context = this.f2261f;
                        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                        Camera.getCameraInfo(intValue, cameraInfo);
                        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
                        if (rotation != 0) {
                            if (rotation == 1) {
                                i11 = 90;
                            } else if (rotation == 2) {
                                i11 = 180;
                            } else if (rotation == 3) {
                                i11 = 270;
                            }
                            int i14 = (360 - ((cameraInfo.orientation + i11) % 360)) % 360;
                            this.f2264i = i14;
                            this.f2284p.setDisplayOrientation(i14);
                            supportedFocusModes = this.f2291w.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                                this.f2291w.setFocusMode("continuous-video");
                            }
                            this.f2287s = (Camera.CameraInfo) a10.first;
                            this.f2284p.setParameters(this.f2291w);
                            this.f2265j = this.f2287s.orientation;
                            e();
                            this.f2283o = false;
                            this.f2292x = true;
                        }
                        i11 = 0;
                        int i142 = (360 - ((cameraInfo.orientation + i11) % 360)) % 360;
                        this.f2264i = i142;
                        this.f2284p.setDisplayOrientation(i142);
                        supportedFocusModes = this.f2291w.getSupportedFocusModes();
                        if (supportedFocusModes != null) {
                            this.f2291w.setFocusMode("continuous-video");
                        }
                        this.f2287s = (Camera.CameraInfo) a10.first;
                        this.f2284p.setParameters(this.f2291w);
                        this.f2265j = this.f2287s.orientation;
                        e();
                        this.f2283o = false;
                        this.f2292x = true;
                    } catch (Throwable th) {
                        this.f2293y = th;
                        this.f2292x = false;
                        d();
                        a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "start preview fail: " + CommonUtils.getStackTrace(th));
                    }
                } catch (Throwable th2) {
                    this.f2293y = th2;
                    this.f2292x = false;
                    a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "camera open fail by parameters fail");
                }
            } catch (Throwable th3) {
                this.f2293y = th3;
                this.f2292x = false;
                a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "camera open fail");
            }
        } catch (Exception unused) {
            a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "find facing camera info fail");
        }
    }

    private void b(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        this.f2288t = supportedPreviewSizes;
        Point a10 = a(b(supportedPreviewSizes));
        this.f2260e = a10;
        parameters.setPreviewSize(a10.x, a10.y);
    }

    private static List<Point> b(List<Camera.Size> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : list) {
            Point point = new Point();
            point.x = size.width;
            point.y = size.height;
            arrayList.add(point);
        }
        return arrayList;
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final void a(SurfaceTexture surfaceTexture) {
        if (this.f2284p == null || this.f2266k) {
            return;
        }
        try {
            final int i10 = this.f2287s.orientation;
            this.f2284p.setPreviewTexture(surfaceTexture);
            this.f2284p.setPreviewCallback(new Camera.PreviewCallback() { // from class: com.alibaba.security.biometrics.build.c.1
                @Override // android.hardware.Camera.PreviewCallback
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    VideoRecorderService videoRecorderService;
                    c.this.a(bArr, i10);
                    c cVar = c.this;
                    if (!cVar.f2283o || (videoRecorderService = cVar.f2282n) == null) {
                        return;
                    }
                    videoRecorderService.record(bArr);
                }
            });
            this.f2284p.startPreview();
            this.f2266k = true;
        } catch (Throwable th) {
            this.B = th;
        }
    }

    private void a(Camera.Parameters parameters) {
        Point point;
        List<Point> b4 = b(parameters.getSupportedPictureSizes());
        if (b4 == null) {
            point = null;
        } else {
            Collections.sort(b4, this.f2262g);
            int i10 = 0;
            for (Point point2 : b4) {
                int i11 = point2.x;
                if (i11 >= 600) {
                    if (((double) Math.abs((((float) i11) / ((float) point2.y)) - 0.0f)) <= 0.05d) {
                        break;
                    }
                }
                i10++;
            }
            point = b4.get(i10 != b4.size() ? i10 : 0);
        }
        this.f2259d = point;
        parameters.setPictureSize(point.x, point.y);
    }

    private static Pair<Camera.CameraInfo, Integer> a(int i10) {
        Camera.CameraInfo cameraInfo;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i11 = 0;
        while (true) {
            if (i11 >= numberOfCameras) {
                cameraInfo = null;
                i11 = -1;
                break;
            }
            cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i11, cameraInfo);
            if (cameraInfo.facing == i10) {
                break;
            }
            i11++;
        }
        return new Pair<>(cameraInfo, Integer.valueOf(i11));
    }

    private void a(Context context, int i10) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i10, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i11 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i11 = 90;
            } else if (rotation == 2) {
                i11 = 180;
            } else if (rotation == 3) {
                i11 = 270;
            }
        }
        this.f2264i = (360 - ((cameraInfo.orientation + i11) % 360)) % 360;
    }

    @Override // com.alibaba.security.biometrics.build.d
    public final void a(OnCameraVideoReorderListener onCameraVideoReorderListener, boolean z10) {
        if (this.f2283o) {
            this.f2283o = false;
            this.f2282n.release(onCameraVideoReorderListener, z10);
            this.f2282n = null;
        } else if (onCameraVideoReorderListener != null) {
            onCameraVideoReorderListener.onFinish(null, this.f2265j);
        }
    }
}
