package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import com.huawei.quickcard.base.Attributes;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: CameraConfigImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    private e0 f30961a;

    /* renamed from: b, reason: collision with root package name */
    private Point f30962b;

    /* renamed from: c, reason: collision with root package name */
    private Point f30963c;

    private void b(Camera.Parameters parameters) {
        if (parameters.isZoomSupported()) {
            parameters.setZoom(1);
        }
    }

    private void c(Camera.Parameters parameters) {
        String str;
        String[] strArr = {"continuous-picture", "continuous-video", Attributes.LayoutDirection.AUTO};
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= 3) {
                str = null;
                break;
            }
            str = strArr[i10];
            if (supportedFocusModes.contains(str)) {
                break;
            } else {
                i10++;
            }
        }
        if (str != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setFocusMode: ");
            sb2.append(str);
            parameters.setFocusMode(str);
        }
    }

    public void a(Camera camera, e0 e0Var) {
        if (camera != null && e0Var != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.f30961a = e0Var;
            this.f30962b = a(parameters, e0Var.a(), false);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initCameraParameters previewCameraSize: ");
            sb2.append(this.f30962b.toString());
            if (e0Var.c() == 0) {
                this.f30963c = a(parameters, e0Var.a(), true);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("initCameraParameters pictureCameraSize: ");
                sb3.append(this.f30963c.toString());
            }
            a(camera, this.f30962b, this.f30963c);
            return;
        }
        throw new IllegalArgumentException("initCameraParameters param is invalid");
    }

    public Point a() {
        return this.f30962b;
    }

    private void a(Camera camera, Point point, Point point2) {
        if (this.f30961a == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(point.x, point.y);
        if (this.f30961a.c() == 0) {
            parameters.setPictureSize(point2.x, point2.y);
        }
        if (this.f30961a.b() != 1) {
            a(parameters);
        }
        c(parameters);
        b(parameters);
        if (this.f30961a.e()) {
            parameters.setRecordingHint(true);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            a(parameters, true);
        }
        camera.setParameters(parameters);
    }

    public static void a(Camera.Parameters parameters, boolean z10) {
        try {
            Method method = Camera.Parameters.class.getMethod("setScanOptEnable", Boolean.TYPE);
            if (method != null) {
                method.invoke(parameters, Boolean.valueOf(z10));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setScanOptEnable isOpt ");
                sb2.append(z10);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | Exception unused) {
        }
    }

    private Point a(Camera.Parameters parameters, Point point, boolean z10) {
        List<Camera.Size> supportedPictureSizes;
        if (!z10) {
            supportedPictureSizes = parameters.getSupportedPreviewSizes();
        } else {
            supportedPictureSizes = parameters.getSupportedPictureSizes();
        }
        if (supportedPictureSizes != null && !supportedPictureSizes.isEmpty()) {
            return a(supportedPictureSizes, point);
        }
        return new Point(0, 0);
    }

    private Point a(List<Camera.Size> list, Point point) {
        double d10 = point.x / point.y;
        int i10 = 0;
        double d11 = Double.MAX_VALUE;
        int i11 = 0;
        for (Camera.Size size : list) {
            int i12 = size.width;
            int i13 = size.height;
            if (i12 == point.x && i13 == point.y) {
                return new Point(i12, i13);
            }
            if (i12 * i13 >= 153600.0d) {
                double d12 = (i12 / i13) - d10;
                if (Math.abs(d12) < d11) {
                    d11 = Math.abs(d12);
                    i11 = i13;
                    i10 = i12;
                }
            }
        }
        return new Point(i10, i11);
    }

    private void a(Camera.Parameters parameters) {
        e0 e0Var = this.f30961a;
        if (e0Var == null) {
            return;
        }
        String f10 = e0Var.f();
        if (!f10.equals("off") && !f10.equals("torch")) {
            f10 = "off";
        }
        parameters.setFlashMode(f10);
    }
}
