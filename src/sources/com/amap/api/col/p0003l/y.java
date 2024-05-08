package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import com.android.internal.os.Zygote;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLTextureView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class y extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    private static final j f6970a = new j(0);

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<y> f6971b;

    /* renamed from: c, reason: collision with root package name */
    private i f6972c;

    /* renamed from: d, reason: collision with root package name */
    private GLSurfaceView.Renderer f6973d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6974e;

    /* renamed from: f, reason: collision with root package name */
    private e f6975f;

    /* renamed from: g, reason: collision with root package name */
    private f f6976g;

    /* renamed from: h, reason: collision with root package name */
    private g f6977h;

    /* renamed from: i, reason: collision with root package name */
    private k f6978i;

    /* renamed from: j, reason: collision with root package name */
    private int f6979j;

    /* renamed from: k, reason: collision with root package name */
    private int f6980k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6981l;

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public abstract class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public int[] f6982a;

        public a(int[] iArr) {
            this.f6982a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (y.this.f6980k != 2 && y.this.f6980k != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i10 = length - 1;
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i10);
            iArr2[i10] = 12352;
            if (y.this.f6980k == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.col.3l.y.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f6982a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i10 = iArr[0];
            if (i10 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i10];
                if (egl10.eglChooseConfig(eGLDisplay, this.f6982a, eGLConfigArr, i10, iArr)) {
                    EGLConfig a10 = a(egl10, eGLDisplay, eGLConfigArr);
                    if (a10 != null) {
                        return a10;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class c implements f {
        private c() {
        }

        @Override // com.amap.api.col.3l.y.f
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, y.this.f6980k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (y.this.f6980k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.col.3l.y.f
        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            StringBuilder sb2 = new StringBuilder("display:");
            sb2.append((Object) eGLDisplay);
            sb2.append(" context: ");
            sb2.append((Object) eGLContext);
            h.a("eglDestroyContex", egl10.eglGetError());
        }

        public /* synthetic */ c(y yVar, byte b4) {
            this();
        }
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d implements g {
        private d() {
        }

        public /* synthetic */ d(byte b4) {
            this();
        }

        @Override // com.amap.api.col.3l.y.g
        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Override // com.amap.api.col.3l.y.g
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class i extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6999a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f7000b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f7001c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7002d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f7003e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f7004f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f7005g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f7006h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f7007i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f7008j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f7009k;

        /* renamed from: p, reason: collision with root package name */
        private boolean f7014p;

        /* renamed from: s, reason: collision with root package name */
        private h f7017s;

        /* renamed from: t, reason: collision with root package name */
        private WeakReference<y> f7018t;

        /* renamed from: q, reason: collision with root package name */
        private ArrayList<Runnable> f7015q = new ArrayList<>();

        /* renamed from: r, reason: collision with root package name */
        private boolean f7016r = true;

        /* renamed from: l, reason: collision with root package name */
        private int f7010l = 0;

        /* renamed from: m, reason: collision with root package name */
        private int f7011m = 0;

        /* renamed from: o, reason: collision with root package name */
        private boolean f7013o = true;

        /* renamed from: n, reason: collision with root package name */
        private int f7012n = 1;

        public i(WeakReference<y> weakReference) {
            this.f7018t = weakReference;
        }

        public static /* synthetic */ boolean a(i iVar) {
            iVar.f7000b = true;
            return true;
        }

        private void k() {
            if (this.f7007i) {
                this.f7007i = false;
                this.f7017s.e();
            }
        }

        private void l() {
            if (this.f7006h) {
                this.f7017s.f();
                this.f7006h = false;
                y.f6970a.c(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:177:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 557
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.y.i.m():void");
        }

        private boolean n() {
            return this.f7006h && this.f7007i && o();
        }

        private boolean o() {
            if (this.f7002d || !this.f7003e || this.f7004f || this.f7010l <= 0 || this.f7011m <= 0) {
                return false;
            }
            return this.f7013o || this.f7012n == 1;
        }

        public final void b() {
            synchronized (y.f6970a) {
                this.f7013o = true;
                y.f6970a.notifyAll();
            }
        }

        public final void c() {
            synchronized (y.f6970a) {
                this.f7003e = true;
                this.f7008j = false;
                y.f6970a.notifyAll();
                while (this.f7005g && !this.f7008j && !this.f7000b) {
                    try {
                        y.f6970a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void d() {
            synchronized (y.f6970a) {
                this.f7003e = false;
                y.f6970a.notifyAll();
                while (!this.f7005g && !this.f7000b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            y.f6970a.wait();
                        } else {
                            y.f6970a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void e() {
            synchronized (y.f6970a) {
                this.f7001c = true;
                y.f6970a.notifyAll();
                while (!this.f7000b && !this.f7002d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            y.f6970a.wait();
                        } else {
                            y.f6970a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void f() {
            synchronized (y.f6970a) {
                this.f7001c = false;
                this.f7013o = true;
                this.f7014p = false;
                y.f6970a.notifyAll();
                while (!this.f7000b && this.f7002d && !this.f7014p) {
                    try {
                        y.f6970a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void g() {
            synchronized (y.f6970a) {
                this.f6999a = true;
                y.f6970a.notifyAll();
                while (!this.f7000b) {
                    try {
                        y.f6970a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void h() {
            this.f7009k = true;
            y.f6970a.notifyAll();
        }

        public final int i() {
            int i10;
            synchronized (y.f6970a) {
                i10 = this.f7010l;
            }
            return i10;
        }

        public final int j() {
            int i10;
            synchronized (y.f6970a) {
                i10 = this.f7011m;
            }
            return i10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            try {
                m();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                y.f6970a.a(this);
                throw th;
            }
            y.f6970a.a(this);
        }

        public final void a(int i10) {
            if (i10 >= 0 && i10 <= 1) {
                synchronized (y.f6970a) {
                    this.f7012n = i10;
                    y.f6970a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public final int a() {
            int i10;
            synchronized (y.f6970a) {
                i10 = this.f7012n;
            }
            return i10;
        }

        public final void a(int i10, int i11) {
            synchronized (y.f6970a) {
                this.f7010l = i10;
                this.f7011m = i11;
                this.f7016r = true;
                this.f7013o = true;
                this.f7014p = false;
                y.f6970a.notifyAll();
                while (!this.f7000b && !this.f7002d && !this.f7014p && n()) {
                    try {
                        y.f6970a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (y.f6970a) {
                    this.f7015q.add(runnable);
                    y.f6970a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface k {
        GL a();
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class l extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f7026a = new StringBuilder();

        private void a() {
            if (this.f7026a.length() > 0) {
                this.f7026a.toString();
                StringBuilder sb2 = this.f7026a;
                sb2.delete(0, sb2.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                char c4 = cArr[i10 + i12];
                if (c4 == '\n') {
                    a();
                } else {
                    this.f7026a.append(c4);
                }
            }
        }
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class m extends b {
        public m() {
            super();
        }
    }

    public y(Context context) {
        super(context, null);
        this.f6971b = new WeakReference<>(this);
        a();
    }

    public void finalize() throws Throwable {
        try {
            i iVar = this.f6972c;
            if (iVar != null) {
                iVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.f6972c.a();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6974e && this.f6973d != null) {
            i iVar = this.f6972c;
            int a10 = iVar != null ? iVar.a() : 1;
            i iVar2 = new i(this.f6971b);
            this.f6972c = iVar2;
            if (a10 != 1) {
                iVar2.a(a10);
            }
            this.f6972c.start();
        }
        this.f6974e = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        i iVar = this.f6972c;
        if (iVar != null) {
            iVar.g();
        }
        this.f6974e = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i12 - i10, i13 - i11);
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        this.f6972c.c();
        if (!f() && !MapsInitializer.getTextureSizeChangedInvoked()) {
            if (this.f6972c.i() == i10 && this.f6972c.j() == i11) {
                return;
            }
            onSurfaceTextureSizeChanged(surfaceTexture, i10, i11);
            return;
        }
        onSurfaceTextureSizeChanged(surfaceTexture, i10, i11);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f6972c.d();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        this.f6972c.a(i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.f6972c.a(runnable);
    }

    public void requestRender() {
        this.f6972c.b();
    }

    public void setRenderMode(int i10) {
        this.f6972c.a(i10);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        e();
        if (this.f6975f == null) {
            this.f6975f = new m();
        }
        byte b4 = 0;
        if (this.f6976g == null) {
            this.f6976g = new c(this, b4);
        }
        if (this.f6977h == null) {
            this.f6977h = new d(b4);
        }
        this.f6973d = renderer;
        i iVar = new i(this.f6971b);
        this.f6972c = iVar;
        iVar.start();
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    private void e() {
        if (this.f6972c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static boolean f() {
        return Build.VERSION.SDK_INT < 23;
    }

    public void b() {
        this.f6972c.e();
    }

    public void c() {
        this.f6972c.f();
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private static String f7019a = "GLThreadManager";

        /* renamed from: b, reason: collision with root package name */
        private boolean f7020b;

        /* renamed from: c, reason: collision with root package name */
        private int f7021c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7022d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f7023e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f7024f;

        /* renamed from: g, reason: collision with root package name */
        private i f7025g;

        private j() {
        }

        public /* synthetic */ j(byte b4) {
            this();
        }

        public final synchronized void a(i iVar) {
            i.a(iVar);
            if (this.f7025g == iVar) {
                this.f7025g = null;
            }
            notifyAll();
        }

        public final boolean b(i iVar) {
            i iVar2 = this.f7025g;
            if (iVar2 != iVar && iVar2 != null) {
                c();
                if (this.f7023e) {
                    return true;
                }
                i iVar3 = this.f7025g;
                if (iVar3 == null) {
                    return false;
                }
                iVar3.h();
                return false;
            }
            this.f7025g = iVar;
            notifyAll();
            return true;
        }

        public final void c(i iVar) {
            if (this.f7025g == iVar) {
                this.f7025g = null;
            }
            notifyAll();
        }

        private void c() {
            if (this.f7020b) {
                return;
            }
            this.f7021c = 131072;
            this.f7023e = true;
            this.f7020b = true;
        }

        public final synchronized boolean a() {
            return this.f7024f;
        }

        public final synchronized void a(GL10 gl10) {
            if (!this.f7022d && gl10 != null) {
                c();
                String glGetString = gl10.glGetString(7937);
                if (this.f7021c < 131072) {
                    this.f7023e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f7024f = this.f7023e ? false : true;
                this.f7022d = true;
            }
        }

        public final synchronized boolean b() {
            c();
            return !this.f7023e;
        }
    }

    public final void a(f fVar) {
        e();
        this.f6976g = fVar;
    }

    public final void a(e eVar) {
        e();
        this.f6975f = eVar;
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b extends a {

        /* renamed from: c, reason: collision with root package name */
        public int f6984c;

        /* renamed from: d, reason: collision with root package name */
        public int f6985d;

        /* renamed from: e, reason: collision with root package name */
        public int f6986e;

        /* renamed from: f, reason: collision with root package name */
        public int f6987f;

        /* renamed from: g, reason: collision with root package name */
        public int f6988g;

        /* renamed from: h, reason: collision with root package name */
        public int f6989h;

        /* renamed from: j, reason: collision with root package name */
        private int[] f6991j;

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
            this.f6991j = new int[1];
            this.f6984c = 8;
            this.f6985d = 8;
            this.f6986e = 8;
            this.f6987f = 0;
            this.f6988g = 16;
            this.f6989h = 0;
        }

        @Override // com.amap.api.col.3l.y.a
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a10 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a11 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a10 >= this.f6988g && a11 >= this.f6989h) {
                    int a12 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a13 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a14 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a15 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a12 == this.f6984c && a13 == this.f6985d && a14 == this.f6986e && a15 == this.f6987f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i10, this.f6991j)) {
                return this.f6991j[0];
            }
            return 0;
        }
    }

    /* compiled from: GLTextureView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public EGL10 f6993a;

        /* renamed from: b, reason: collision with root package name */
        public EGLDisplay f6994b;

        /* renamed from: c, reason: collision with root package name */
        public EGLSurface f6995c;

        /* renamed from: d, reason: collision with root package name */
        public EGLConfig f6996d;

        /* renamed from: e, reason: collision with root package name */
        public EGLContext f6997e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<y> f6998f;

        public h(WeakReference<y> weakReference) {
            this.f6998f = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f6995c;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f6993a.eglMakeCurrent(this.f6994b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            y yVar = this.f6998f.get();
            if (yVar != null) {
                yVar.f6977h.a(this.f6993a, this.f6994b, this.f6995c);
            }
            this.f6995c = null;
        }

        public final void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f6993a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f6994b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f6993a.eglInitialize(eglGetDisplay, new int[2])) {
                    y yVar = this.f6998f.get();
                    if (yVar != null) {
                        this.f6996d = yVar.f6975f.chooseConfig(this.f6993a, this.f6994b);
                        this.f6997e = yVar.f6976g.createContext(this.f6993a, this.f6994b, this.f6996d);
                    } else {
                        this.f6996d = null;
                        this.f6997e = null;
                    }
                    EGLContext eGLContext = this.f6997e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f6997e = null;
                        a("createContext");
                    }
                    this.f6995c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public final boolean b() {
            if (this.f6993a != null) {
                if (this.f6994b != null) {
                    if (this.f6996d != null) {
                        g();
                        y yVar = this.f6998f.get();
                        if (yVar != null) {
                            this.f6995c = yVar.f6977h.a(this.f6993a, this.f6994b, this.f6996d, yVar.getSurfaceTexture());
                        } else {
                            this.f6995c = null;
                        }
                        EGLSurface eGLSurface = this.f6995c;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f6993a.eglMakeCurrent(this.f6994b, eGLSurface, eGLSurface, this.f6997e)) {
                                return true;
                            }
                            a("EGLHelper", "eglMakeCurrent", this.f6993a.eglGetError());
                            return false;
                        }
                        this.f6993a.eglGetError();
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public final GL c() {
            GL gl = this.f6997e.getGL();
            y yVar = this.f6998f.get();
            if (yVar == null) {
                return gl;
            }
            if (yVar.f6978i != null) {
                gl = yVar.f6978i.a();
            }
            if ((yVar.f6979j & 3) != 0) {
                return GLDebugHelper.wrap(gl, (yVar.f6979j & 1) != 0 ? 1 : 0, (yVar.f6979j & 2) != 0 ? new l() : null);
            }
            return gl;
        }

        public final int d() {
            return !this.f6993a.eglSwapBuffers(this.f6994b, this.f6995c) ? this.f6993a.eglGetError() : Zygote.API_ENFORCEMENT_POLICY_MASK;
        }

        public final void e() {
            g();
        }

        public final void f() {
            if (this.f6997e != null) {
                y yVar = this.f6998f.get();
                if (yVar != null) {
                    yVar.f6976g.destroyContext(this.f6993a, this.f6994b, this.f6997e);
                }
                this.f6997e = null;
            }
            EGLDisplay eGLDisplay = this.f6994b;
            if (eGLDisplay != null) {
                this.f6993a.eglTerminate(eGLDisplay);
                this.f6994b = null;
            }
        }

        private void a(String str) {
            a(str, this.f6993a.eglGetError());
        }

        public static void a(String str, int i10) {
            throw new RuntimeException(b(str, i10));
        }

        public static void a(String str, String str2, int i10) {
            b(str2, i10);
        }

        private static String b(String str, int i10) {
            return str + " failed: " + i10;
        }
    }
}
