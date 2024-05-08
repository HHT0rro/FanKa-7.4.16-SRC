package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import com.alibaba.security.common.log.RPLogging;
import com.huawei.quickcard.base.Attributes;
import java.util.Map;

/* compiled from: CameraManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ak {

    /* renamed from: b, reason: collision with root package name */
    private static final String f3064b = "ak";

    /* renamed from: c, reason: collision with root package name */
    private static final int f3065c = 240;

    /* renamed from: d, reason: collision with root package name */
    private static final int f3066d = 240;

    /* renamed from: e, reason: collision with root package name */
    private static final int f3067e = 1200;

    /* renamed from: f, reason: collision with root package name */
    private static final int f3068f = 675;

    /* renamed from: a, reason: collision with root package name */
    public Camera f3069a;

    /* renamed from: g, reason: collision with root package name */
    private final Context f3070g;

    /* renamed from: h, reason: collision with root package name */
    private final aj f3071h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f3072i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f3073j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3074k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3075l;

    /* renamed from: n, reason: collision with root package name */
    private int f3077n;

    /* renamed from: o, reason: collision with root package name */
    private int f3078o;

    /* renamed from: m, reason: collision with root package name */
    private int f3076m = -1;

    /* renamed from: p, reason: collision with root package name */
    private long f3079p = 0;

    /* renamed from: q, reason: collision with root package name */
    private long f3080q = 2000;

    public ak(Context context) {
        this.f3070g = context;
        this.f3071h = new aj(context);
    }

    public static int d() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras < 0) {
            return -1;
        }
        for (int i10 = 0; i10 < numberOfCameras; i10++) {
            Camera.getCameraInfo(i10, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i10;
            }
        }
        return -1;
    }

    private synchronized boolean e() {
        return this.f3069a != null;
    }

    private synchronized Rect f() {
        if (this.f3072i == null) {
            if (this.f3069a == null) {
                return null;
            }
            Point point = this.f3071h.f3059b;
            if (point == null) {
                return null;
            }
            int a10 = a(point.x, 1200);
            int a11 = a(point.y, 675);
            int i10 = (point.x - a10) / 2;
            int i11 = (point.y - a11) / 2;
            this.f3072i = new Rect(i10, i11, a10 + i10, a11 + i11);
        }
        return this.f3072i;
    }

    private synchronized Rect g() {
        if (this.f3073j == null) {
            Rect f10 = f();
            if (f10 == null) {
                return null;
            }
            Rect rect = new Rect(f10);
            aj ajVar = this.f3071h;
            Point point = ajVar.f3060c;
            Point point2 = ajVar.f3059b;
            if (point != null && point2 != null) {
                int i10 = rect.left;
                int i11 = point.x;
                int i12 = point2.x;
                rect.left = (i10 * i11) / i12;
                rect.right = (rect.right * i11) / i12;
                int i13 = rect.top;
                int i14 = point.y;
                int i15 = point2.y;
                rect.top = (i13 * i14) / i15;
                rect.bottom = (rect.bottom * i14) / i15;
                this.f3073j = rect;
            }
            return null;
        }
        return this.f3073j;
    }

    private int h() {
        return this.f3069a.getParameters().getZoom();
    }

    private int i() {
        return this.f3069a.getParameters().getMaxZoom();
    }

    private Camera j() {
        return this.f3069a;
    }

    private static void k() {
        try {
            Thread.currentThread();
            Thread.sleep(1000L);
        } catch (InterruptedException e2) {
            RPLogging.e(f3064b, e2.getLocalizedMessage());
        }
    }

    private void l() {
        this.f3069a.cancelAutoFocus();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9 A[Catch: all -> 0x00ef, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000d, B:8:0x0010, B:9:0x0015, B:11:0x0016, B:13:0x001f, B:15:0x0053, B:17:0x0092, B:18:0x0099, B:20:0x00a9, B:21:0x00b0, B:23:0x00b4, B:25:0x00b8, B:26:0x005b, B:28:0x0063, B:31:0x006c, B:33:0x0074, B:34:0x007e, B:36:0x0086, B:37:0x00bf, B:41:0x00cb, B:47:0x00d5, B:49:0x00dc, B:52:0x00e6, B:55:0x00c7), top: B:2:0x0001, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(android.view.SurfaceHolder r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.ak.a(android.view.SurfaceHolder):void");
    }

    public final synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        Camera camera = this.f3069a;
        if (camera != null && !this.f3075l) {
            camera.startPreview();
            String str = f3064b;
            RPLogging.i(str, "SQY: startPreview.theCamera.startPreview Costs" + (System.currentTimeMillis() - currentTimeMillis));
            this.f3075l = true;
            RPLogging.i(str, "SQY: startPreview new AutoFocusManager Costs" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final synchronized void c() {
        Camera camera = this.f3069a;
        if (camera != null && this.f3075l) {
            camera.stopPreview();
            this.f3075l = false;
        }
    }

    private static void c(long j10) {
        try {
            Thread.currentThread();
            Thread.sleep(j10 * 1000);
        } catch (InterruptedException e2) {
            RPLogging.e(f3064b, e2.getLocalizedMessage());
        }
    }

    private synchronized void b(int i10, int i11) {
        if (this.f3074k) {
            Point point = this.f3071h.f3059b;
            int i12 = point.x;
            if (i10 > i12) {
                i10 = i12;
            }
            int i13 = point.y;
            if (i11 > i13) {
                i11 = i13;
            }
            int i14 = (i12 - i10) / 2;
            int i15 = (i13 - i11) / 2;
            this.f3072i = new Rect(i14, i15, i10 + i14, i11 + i15);
            this.f3073j = null;
            return;
        }
        this.f3077n = i10;
        this.f3078o = i11;
    }

    private void b(int i10) {
        Camera.Parameters parameters = this.f3069a.getParameters();
        parameters.setZoom(i10);
        this.f3069a.setParameters(parameters);
    }

    private void b(long j10) {
        this.f3080q = j10;
    }

    public final synchronized void a() {
        try {
            Camera camera = this.f3069a;
            if (camera != null) {
                camera.release();
                this.f3069a = null;
                this.f3072i = null;
                this.f3073j = null;
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void a(boolean z10) {
        Camera camera;
        try {
            if (z10 != aj.a(this.f3069a) && (camera = this.f3069a) != null) {
                aj ajVar = this.f3071h;
                Camera.Parameters parameters = camera.getParameters();
                ajVar.a(parameters, z10, false);
                camera.setParameters(parameters);
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void a(Camera.PreviewCallback previewCallback) {
        Camera camera = this.f3069a;
        if (camera != null && this.f3075l) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    private static int a(int i10, int i11) {
        int i12 = (i10 * 5) / 8;
        if (i12 < 240) {
            return 240;
        }
        return i12 > i11 ? i11 : i12;
    }

    public final synchronized void a(int i10) {
        this.f3076m = i10;
    }

    private void a(long j10) {
        this.f3079p = j10;
    }

    private void a(Map<String, Integer> map) {
        this.f3071h.f3063f = map;
    }

    private void a(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback) {
        Camera camera = this.f3069a;
        if (camera != null) {
            camera.takePicture(shutterCallback, null, pictureCallback);
        }
    }

    public final void a(Camera.AutoFocusCallback autoFocusCallback) {
        Camera camera = this.f3069a;
        if (camera == null) {
            return;
        }
        String focusMode = camera.getParameters().getFocusMode();
        if (focusMode.equals(Attributes.LayoutDirection.AUTO) || focusMode.equals("macro")) {
            this.f3069a.autoFocus(autoFocusCallback);
        }
    }
}
