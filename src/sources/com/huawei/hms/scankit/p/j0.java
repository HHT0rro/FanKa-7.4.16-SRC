package com.huawei.hms.scankit.p;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.TextureView;
import com.huawei.hms.scankit.p.k0;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: CameraManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private e0 f31133a;

    /* renamed from: b, reason: collision with root package name */
    private d f31134b;

    /* renamed from: c, reason: collision with root package name */
    private b f31135c;

    /* renamed from: d, reason: collision with root package name */
    private Camera.PreviewCallback f31136d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f31137e;

    /* renamed from: f, reason: collision with root package name */
    private i0 f31138f;

    /* renamed from: g, reason: collision with root package name */
    private h0 f31139g;

    /* renamed from: h, reason: collision with root package name */
    private n0 f31140h;

    /* renamed from: i, reason: collision with root package name */
    private l0 f31141i;

    /* renamed from: j, reason: collision with root package name */
    private Camera f31142j;

    /* renamed from: k, reason: collision with root package name */
    private f0 f31143k;

    /* renamed from: l, reason: collision with root package name */
    private String f31144l;

    /* renamed from: m, reason: collision with root package name */
    private c f31145m = c.CAMERA_CLOSED;

    /* renamed from: n, reason: collision with root package name */
    private int f31146n = -1;

    /* compiled from: CameraManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void a(Point point);
    }

    /* compiled from: CameraManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum c {
        CAMERA_CLOSED(1),
        CAMERA_OPENED(2),
        CAMERA_INITIALED(3),
        PREVIEW_STARTED(4),
        PREVIEW_STOPPED(5);


        /* renamed from: a, reason: collision with root package name */
        private final int f31153a;

        c(int i10) {
            this.f31153a = i10;
        }

        public int a() {
            return this.f31153a;
        }
    }

    /* compiled from: CameraManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface d {
        void a();

        void b();

        void c();
    }

    /* compiled from: CameraManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface e {
        void a(byte[] bArr);
    }

    /* compiled from: CameraManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class f implements Camera.PreviewCallback {
        private f() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    public j0(Context context, e0 e0Var) {
        if (context != null && e0Var != null) {
            this.f31137e = new WeakReference<>(context);
            this.f31133a = e0Var;
            this.f31144l = e0Var.f();
            this.f31143k = new f0();
            this.f31139g = new h0();
            this.f31140h = new n0();
            this.f31141i = new l0();
            return;
        }
        throw new IllegalArgumentException("CameraManager constructor param invalid");
    }

    public synchronized void a(e eVar) {
        if (eVar != null) {
            this.f31136d = new f6(eVar);
        } else {
            throw new IllegalArgumentException("CameraManager::setFrameCallback param invalid");
        }
    }

    public synchronized g0 b() {
        if (this.f31142j == null || this.f31145m.a() == c.CAMERA_CLOSED.a()) {
            return null;
        }
        try {
            return this.f31139g.a();
        } catch (Exception unused) {
            return null;
        }
    }

    public synchronized void c(int i10) {
        if (this.f31142j != null && this.f31145m.a() != c.CAMERA_CLOSED.a()) {
            this.f31139g.a(i10);
        }
    }

    public synchronized void d(int i10) {
        if (this.f31142j != null && this.f31145m.a() != c.CAMERA_CLOSED.a()) {
            this.f31140h.a(i10);
        }
    }

    public synchronized Point e() {
        return this.f31143k.a();
    }

    public synchronized c f() {
        return this.f31145m;
    }

    public synchronized m0 g() {
        if (this.f31142j != null && this.f31145m.a() != c.CAMERA_CLOSED.a()) {
            return this.f31140h.a();
        }
        return null;
    }

    public synchronized String h() {
        return this.f31144l;
    }

    public synchronized boolean i() {
        boolean z10;
        if (this.f31142j != null) {
            z10 = this.f31145m.a() >= c.CAMERA_OPENED.a();
        }
        return z10;
    }

    public synchronized boolean j() {
        return this.f31140h.b();
    }

    public synchronized void k() {
        this.f31135c = null;
    }

    public synchronized void l() {
        try {
            if (this.f31145m.a() == c.PREVIEW_STARTED.a()) {
                a();
                q();
                this.f31145m = c.PREVIEW_STOPPED;
            }
            if (h().equals("torch")) {
                a("off");
            }
            if (this.f31145m.a() >= c.CAMERA_OPENED.a()) {
                this.f31145m = c.CAMERA_CLOSED;
                Camera camera = this.f31142j;
                if (camera != null) {
                    camera.setPreviewCallback(null);
                    this.f31142j.stopPreview();
                    this.f31142j.release();
                    this.f31142j = null;
                }
                d dVar = this.f31134b;
                if (dVar != null) {
                    dVar.c();
                }
            }
        } catch (RuntimeException unused) {
        }
    }

    public synchronized void m() {
        c cVar = this.f31145m;
        if (cVar == c.CAMERA_CLOSED || cVar == c.PREVIEW_STOPPED) {
            int a10 = a(this.f31133a.b());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onResume: ");
            sb2.append(a10);
            try {
                this.f31142j = Camera.open(a10);
            } catch (RuntimeException e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CameraManager::Camera open failed, ");
                sb3.append(e2.getMessage());
            }
            if (this.f31142j == null) {
                d dVar = this.f31134b;
                if (dVar != null) {
                    dVar.b();
                }
            } else {
                d dVar2 = this.f31134b;
                if (dVar2 != null) {
                    dVar2.a();
                }
                this.f31145m = c.CAMERA_OPENED;
            }
        }
    }

    public synchronized void n() {
        Camera camera;
        if (this.f31145m.a() < c.CAMERA_OPENED.a()) {
            return;
        }
        if (this.f31133a.c() != 0 && (camera = this.f31142j) != null) {
            camera.setPreviewCallback(new f());
        }
    }

    public synchronized void o() {
        if (this.f31133a.c() == 1) {
            if (this.f31145m == c.PREVIEW_STOPPED) {
                return;
            }
            Camera camera = this.f31142j;
            if (camera != null) {
                camera.setOneShotPreviewCallback(this.f31136d);
            }
        } else if (this.f31133a.c() == 0) {
            if (this.f31145m == c.PREVIEW_STOPPED) {
                p();
            }
        } else if (this.f31133a.c() == 2) {
            if (this.f31145m == c.PREVIEW_STOPPED) {
                return;
            }
            Camera camera2 = this.f31142j;
            if (camera2 != null) {
                camera2.setPreviewCallback(this.f31136d);
            }
        }
    }

    public synchronized void p() {
        if (this.f31145m.a() < c.CAMERA_INITIALED.a()) {
            return;
        }
        Camera camera = this.f31142j;
        if (camera != null) {
            camera.startPreview();
            this.f31145m = c.PREVIEW_STARTED;
        }
    }

    public synchronized void q() {
        if (this.f31145m.a() < c.PREVIEW_STARTED.a()) {
            return;
        }
        Camera camera = this.f31142j;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.f31142j.stopPreview();
            this.f31145m = c.PREVIEW_STOPPED;
        }
    }

    public synchronized void a(d dVar) {
        if (dVar != null) {
            this.f31134b = dVar;
        } else {
            throw new IllegalArgumentException("CameraManager::setCameraStatusListener param invalid");
        }
    }

    public synchronized k0 c() {
        if (this.f31142j != null && this.f31145m.a() != c.CAMERA_CLOSED.a()) {
            return this.f31141i.a();
        }
        return null;
    }

    public synchronized int d() {
        return this.f31133a.d();
    }

    public synchronized void b(int i10) {
        if (this.f31133a != null && this.f31142j != null && this.f31145m.a() >= c.CAMERA_OPENED.a()) {
            this.f31133a.a(i10);
            try {
                this.f31142j.setDisplayOrientation(i10);
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public synchronized void a(TextureView textureView) throws IOException {
        if (textureView != null) {
            if (this.f31145m.a() != c.CAMERA_OPENED.a()) {
                m();
            }
            this.f31139g.a(this.f31142j);
            this.f31140h.a(this.f31142j);
            this.f31141i.a(this.f31142j);
            Camera camera = this.f31142j;
            if (camera != null) {
                camera.setPreviewTexture(textureView.getSurfaceTexture());
            }
            this.f31143k.a(this.f31142j, this.f31133a);
            Camera camera2 = this.f31142j;
            if (camera2 != null) {
                camera2.setDisplayOrientation(this.f31133a.d());
            }
            b bVar = this.f31135c;
            if (bVar != null) {
                bVar.a(this.f31143k.a());
            }
            this.f31145m = c.CAMERA_INITIALED;
        } else {
            throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
        }
    }

    public synchronized void a(String str) {
        if (this.f31142j != null && this.f31145m.a() != c.CAMERA_CLOSED.a()) {
            if ("off".equals(str) || "torch".equals(str)) {
                Camera.Parameters parameters = this.f31142j.getParameters();
                parameters.setFlashMode(str);
                this.f31142j.setParameters(parameters);
                this.f31144l = str;
            }
        }
    }

    public synchronized void a(Rect rect, boolean z10) {
        if (this.f31142j == null) {
            return;
        }
        if (this.f31138f == null) {
            this.f31138f = new i0(this.f31142j);
        }
        this.f31138f.a(rect, this.f31143k.a().x, this.f31143k.a().y, z10, this.f31133a.b() == 1);
    }

    public synchronized void a() {
        i0 i0Var = this.f31138f;
        if (i0Var != null) {
            i0Var.e();
            this.f31138f = null;
        }
    }

    public synchronized void a(List<k0.a> list) {
        if (this.f31142j != null && this.f31145m.a() != c.CAMERA_CLOSED.a()) {
            this.f31141i.a(list);
        }
    }

    private int a(int i10) {
        if (i10 != 0 && i10 != 1) {
            return 0;
        }
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i11 = 0; i11 < numberOfCameras; i11++) {
                Camera.getCameraInfo(i11, cameraInfo);
                if (cameraInfo.facing == i10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("findCameraId: ");
                    sb2.append(i11);
                    return i11;
                }
            }
        } catch (RuntimeException | Exception unused) {
        }
        return 0;
    }
}
