package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.TextureView;
import androidx.constraintlayout.motion.widget.Key;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.e0;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.f5;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.k0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.m0;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.v3;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* compiled from: CaptureHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    public static final String H = "b";
    public static volatile v3 I;
    public static volatile w3 J;
    private IOnErrorCallback D;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f30545a;

    /* renamed from: b, reason: collision with root package name */
    private final int f30546b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f30547c;

    /* renamed from: d, reason: collision with root package name */
    private Context f30548d;

    /* renamed from: e, reason: collision with root package name */
    private com.huawei.hms.scankit.a f30549e;

    /* renamed from: f, reason: collision with root package name */
    private f5 f30550f;

    /* renamed from: g, reason: collision with root package name */
    private j0 f30551g;

    /* renamed from: h, reason: collision with root package name */
    private ViewfinderView f30552h;

    /* renamed from: i, reason: collision with root package name */
    public TextureView f30553i;

    /* renamed from: j, reason: collision with root package name */
    private TextureView.SurfaceTextureListener f30554j;

    /* renamed from: k, reason: collision with root package name */
    private Collection<BarcodeFormat> f30555k;

    /* renamed from: l, reason: collision with root package name */
    private Map<l1, ?> f30556l;

    /* renamed from: m, reason: collision with root package name */
    private String f30557m;

    /* renamed from: o, reason: collision with root package name */
    private String f30559o;

    /* renamed from: q, reason: collision with root package name */
    private float f30561q;

    /* renamed from: u, reason: collision with root package name */
    private boolean f30565u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f30566v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f30567w;

    /* renamed from: x, reason: collision with root package name */
    private IObjectWrapper f30568x;

    /* renamed from: y, reason: collision with root package name */
    private e5 f30569y;

    /* renamed from: z, reason: collision with root package name */
    private IOnResultCallback f30570z;

    /* renamed from: p, reason: collision with root package name */
    private boolean f30560p = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f30562r = true;

    /* renamed from: s, reason: collision with root package name */
    private boolean f30563s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f30564t = true;
    private boolean A = false;
    private boolean B = false;
    private boolean E = true;
    private boolean F = false;
    private boolean G = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f30558n = false;
    private boolean C = false;

    /* compiled from: CaptureHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f30551g.m();
        }
    }

    /* compiled from: CaptureHelper.java */
    /* renamed from: com.huawei.hms.scankit.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class C0325b implements j0.d {
        public C0325b() {
        }

        @Override // com.huawei.hms.scankit.p.j0.d
        public void a() {
        }

        @Override // com.huawei.hms.scankit.p.j0.d
        public void b() {
            if (b.this.D != null) {
                try {
                    b.this.D.onError(-1000);
                } catch (RemoteException unused) {
                    o4.b(b.H, "RemoteException");
                }
            }
        }

        @Override // com.huawei.hms.scankit.p.j0.d
        public void c() {
        }
    }

    /* compiled from: CaptureHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements TextureView.SurfaceTextureListener {
        public c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            b.this.B = false;
            if (surfaceTexture == null) {
                o4.b(b.H, "*** WARNING *** surfaceCreated() gave us a null surface!");
            }
            if (b.this.f30558n) {
                return;
            }
            b.this.f30558n = true;
            if (b.this.f30548d.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0) {
                if (b.this.G || !(b.this.f30548d instanceof Activity) || Build.VERSION.SDK_INT < 23) {
                    return;
                }
                b.this.B = true;
                ((Activity) b.this.f30548d).requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
                return;
            }
            b bVar = b.this;
            bVar.a(bVar.f30553i);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.f30558n = false;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: CaptureHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d implements f5 {
        public d() {
        }

        @Override // com.huawei.hms.scankit.p.f5
        public void a(HmsScan[] hmsScanArr, Bitmap bitmap, float f10) {
            b.this.a(hmsScanArr, bitmap);
        }
    }

    public b(Context context, TextureView textureView, ViewfinderView viewfinderView, Rect rect, int i10, IObjectWrapper iObjectWrapper, boolean z10, String str, boolean z11) {
        this.f30548d = context;
        this.f30552h = viewfinderView;
        this.f30568x = iObjectWrapper;
        this.f30553i = textureView;
        this.f30545a = rect;
        this.f30546b = i10;
        this.f30547c = z10;
        this.f30559o = str;
        this.f30566v = z11;
    }

    private void j() {
        com.huawei.hms.scankit.a aVar = this.f30549e;
        if (aVar != null) {
            aVar.e();
            this.f30549e = null;
        }
        this.f30551g.l();
    }

    public void f() {
        TextureView textureView;
        TextureView textureView2;
        this.C = false;
        try {
            I = new v3((Bundle) ObjectWrapper.unwrap(this.f30568x), this.f30559o);
            I.h();
        } catch (RuntimeException unused) {
            o4.b(H, "RuntimeException");
        } catch (Exception unused2) {
            o4.b(H, "Exception");
        }
        if (!this.A && !this.f30558n && (textureView2 = this.f30553i) != null) {
            textureView2.setSurfaceTextureListener(this.f30554j);
            if (this.f30558n) {
                a(this.f30553i);
            } else {
                this.f30553i.setSurfaceTextureListener(this.f30554j);
            }
        }
        if (this.B && this.f30548d.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0 && (textureView = this.f30553i) != null) {
            this.B = false;
            a(textureView);
        }
    }

    public void g() {
        this.C = false;
        TextureView textureView = this.f30553i;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.f30554j);
            this.A = true;
            if (this.f30558n) {
                a(this.f30553i);
            } else {
                this.f30553i.setSurfaceTextureListener(this.f30554j);
            }
        }
    }

    public void h() {
        this.C = true;
        if (I != null) {
            I.i();
        }
        I = null;
        if (this.A) {
            j();
        }
    }

    public void i() {
        try {
            j0 j0Var = this.f30551g;
            if (j0Var != null) {
                j0Var.d(1);
            }
        } catch (RuntimeException unused) {
            o4.b(H, "RuntimeException in reset zoomValue");
        } catch (Exception unused2) {
            o4.b(H, "Exception in reset zoomValue");
        }
    }

    public void c() {
        this.C = false;
        try {
            J = new w3((Bundle) ObjectWrapper.unwrap(this.f30568x), this.f30559o);
            J.a("single");
        } catch (RuntimeException unused) {
            o4.b(H, "RuntimeException");
        } catch (Exception unused2) {
            o4.b(H, "Exception");
        }
        if (this.f30548d.getPackageManager() == null || this.f30548d.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            this.f30551g = new j0(this.f30548d, a(this.f30548d));
            new Thread(new a()).start();
            this.f30551g.a(new C0325b());
            this.f30554j = new c();
            this.f30550f = new d();
        }
    }

    public void d() {
        this.C = true;
        this.f30553i.setSurfaceTextureListener(null);
        this.f30551g.k();
        J.f31653l.b();
        J = null;
    }

    public void e() {
        this.C = true;
        if (this.A) {
            return;
        }
        j();
    }

    public boolean b(MotionEvent motionEvent) {
        j0 j0Var = this.f30551g;
        if (j0Var == null || !this.f30560p || j0Var.f().a() < j0.c.CAMERA_OPENED.a() || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float a10 = a(motionEvent);
            float f10 = this.f30561q;
            if (a10 > f10 + 6.0f) {
                a(true, this.f30551g);
            } else if (a10 < f10 - 6.0f) {
                a(false, this.f30551g);
            } else {
                o4.d("CaptureHelper", "MotionEvent.ACTION_MOVE no handleZoom");
            }
            this.f30561q = a10;
        } else if (action == 5) {
            this.f30561q = a(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView != null && textureView.getSurfaceTexture() != null) {
            try {
                this.f30551g.a(textureView);
                this.f30551g.a(Collections.singletonList(new k0.a(new Rect(-150, -150, 150, 150), 1000)));
                try {
                    this.f30551g.n();
                } catch (Exception unused) {
                    o4.b(H, "initCamera() get exception");
                }
                if (this.f30549e == null) {
                    com.huawei.hms.scankit.a aVar = new com.huawei.hms.scankit.a(this.f30548d, this.f30552h, this.f30550f, this.f30555k, this.f30556l, this.f30557m, this.f30551g, this.f30545a, this.f30546b, this.f30566v, this.E);
                    this.f30549e = aVar;
                    aVar.c(this.f30565u);
                    this.f30549e.a(this.f30567w);
                    this.f30549e.b(this.f30562r);
                    this.f30549e.a(this.f30569y);
                    return;
                }
                return;
            } catch (Exception e2) {
                if (I != null) {
                    I.c(-1002);
                }
                o4.a(H, "initCamera IOException", e2);
                return;
            }
        }
        o4.e(H, "initCamera() no surface view");
    }

    public void b(boolean z10) {
        this.E = z10;
    }

    public boolean b() {
        return this.F;
    }

    public void c(boolean z10) {
        this.G = z10;
    }

    private void a(boolean z10, j0 j0Var) {
        try {
            m0 g3 = j0Var.g();
            if (j0Var.j()) {
                int c4 = g3.c();
                int b4 = g3.b();
                if (z10 && b4 < c4) {
                    b4++;
                } else if (b4 > 0) {
                    b4--;
                } else {
                    o4.d(H, "handleZoom  zoom not change");
                }
                j0Var.d(b4);
                return;
            }
            o4.d(H, "zoom not supported");
        } catch (RuntimeException unused) {
        }
    }

    private float a(MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        double sqrt = Math.sqrt((x10 * x10) + (y10 * y10));
        if (Double.isInfinite(sqrt) || Double.isNaN(sqrt)) {
            return 0.0f;
        }
        return BigDecimal.valueOf(sqrt).floatValue();
    }

    public void a(HmsScan[] hmsScanArr, Bitmap bitmap) {
        o4.a("scan-time", "decode time:" + System.currentTimeMillis());
        try {
            String str = H;
            o4.d(str, "result onResult");
            if (this.f30569y.a()) {
                o4.d(str, "result intercepted");
                return;
            }
            if (I != null) {
                I.a(hmsScanArr);
            }
            if (!this.f30547c) {
                hmsScanArr = w7.a(hmsScanArr);
            }
            if (this.f30569y != null) {
                if (this.f30552h != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                    o4.d(str, "result draw result point");
                    if (this.f30548d instanceof Activity) {
                        this.f30552h.a(hmsScanArr[0].getBorderRect(), w7.c((Activity) this.f30548d), this.f30551g.e());
                    }
                    this.C = false;
                }
                this.f30569y.a(hmsScanArr);
            }
            if (this.f30570z != null) {
                try {
                    o4.d(str, "result callback end: pauseStatus" + this.C);
                    if (this.C) {
                        return;
                    }
                    if (this.f30567w && hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                        Context context = this.f30548d;
                        if (context instanceof Activity) {
                            hmsScanArr[0].originalBitmap = w7.a(bitmap, ((Activity) context).getWindowManager().getDefaultDisplay().getRotation());
                        }
                    }
                    this.f30570z.onResult(hmsScanArr);
                } catch (RemoteException e2) {
                    if (I != null) {
                        I.c(-1003);
                    }
                    o4.e("CaptureHelper", "onResult  RemoteException  e:" + ((Object) e2));
                }
            }
        } catch (RuntimeException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onResult:RuntimeException ");
            sb2.append((Object) e10);
        } catch (Exception e11) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onResult:Exception: ");
            sb3.append((Object) e11);
        }
    }

    public b a(boolean z10) {
        this.f30567w = z10;
        com.huawei.hms.scankit.a aVar = this.f30549e;
        if (aVar != null) {
            aVar.a(z10);
        }
        return this;
    }

    public b a(e5 e5Var) {
        this.f30569y = e5Var;
        return this;
    }

    public void a(IOnResultCallback iOnResultCallback) {
        this.f30570z = iOnResultCallback;
    }

    public j0 a() {
        return this.f30551g;
    }

    public void a(IOnErrorCallback iOnErrorCallback) {
        this.D = iOnErrorCallback;
    }

    private e0 a(Context context) {
        e0 a10;
        Activity activity = (Activity) context;
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initCameraConfig:");
        sb2.append(false);
        sb2.append(Key.ROTATION);
        sb2.append(rotation);
        if (rotation == 0) {
            a10 = new e0.b().a(new Point(1920, 1080)).a(1).b(90).b(false).a(true).a();
        } else if (rotation == 1) {
            a10 = new e0.b().a(new Point(1920, 1080)).a(1).b(0).b(false).a(true).a();
        } else if (rotation == 2) {
            a10 = new e0.b().a(new Point(1920, 1080)).a(1).b(270).b(false).a(true).a();
        } else if (rotation != 3) {
            a10 = new e0.b().a(new Point(1920, 1080)).a(1).b(90).b(false).a(true).a();
        } else {
            a10 = new e0.b().a(new Point(1920, 1080)).a(1).b(180).b(false).a(true).a();
        }
        if (w7.f(context) || w7.b(activity) || w7.e(context)) {
            a10.a(new Point(1080, 1080));
            this.F = true;
        }
        if ("ceres-c3".equals(Build.DEVICE)) {
            a10 = new e0.b().a(new Point(1080, 1920)).a(1).b(false).a(true).a();
        }
        boolean b4 = w7.b();
        boolean e2 = w7.e();
        if ((!w7.e(context) || b4) && (!w7.b(activity) || e2)) {
            return a10;
        }
        e0 a11 = new e0.b().a(new Point(1080, 1080)).a(1).b(90).b(false).a(true).a();
        this.F = true;
        return a11;
    }
}
