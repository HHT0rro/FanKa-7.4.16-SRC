package com.danlan.android.videogift;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* renamed from: m, reason: collision with root package name */
    public static final k f19077m = new k();

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<GLTextureView> f19078b;

    /* renamed from: c, reason: collision with root package name */
    public j f19079c;

    /* renamed from: d, reason: collision with root package name */
    public n f19080d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19081e;

    /* renamed from: f, reason: collision with root package name */
    public f f19082f;

    /* renamed from: g, reason: collision with root package name */
    public g f19083g;

    /* renamed from: h, reason: collision with root package name */
    public h f19084h;

    /* renamed from: i, reason: collision with root package name */
    public l f19085i;

    /* renamed from: j, reason: collision with root package name */
    public int f19086j;

    /* renamed from: k, reason: collision with root package name */
    public int f19087k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19088l;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public abstract class b implements f {

        /* renamed from: a, reason: collision with root package name */
        public int[] f19089a;

        public b(int[] iArr) {
            this.f19089a = b(iArr);
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public final int[] b(int[] iArr) {
            if (GLTextureView.this.f19087k != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i10 = length - 1;
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i10);
            iArr2[i10] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // com.danlan.android.videogift.GLTextureView.f
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f19089a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i10 = iArr[0];
            if (i10 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i10];
                if (egl10.eglChooseConfig(eGLDisplay, this.f19089a, eGLConfigArr, i10, iArr)) {
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

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c extends b {

        /* renamed from: c, reason: collision with root package name */
        public int[] f19091c;

        /* renamed from: d, reason: collision with root package name */
        public int f19092d;

        /* renamed from: e, reason: collision with root package name */
        public int f19093e;

        /* renamed from: f, reason: collision with root package name */
        public int f19094f;

        /* renamed from: g, reason: collision with root package name */
        public int f19095g;

        /* renamed from: h, reason: collision with root package name */
        public int f19096h;

        /* renamed from: i, reason: collision with root package name */
        public int f19097i;

        public c(int i10, int i11, int i12, int i13, int i14, int i15) {
            super(new int[]{12324, i10, 12323, i11, 12322, i12, 12321, i13, 12325, i14, 12326, i15, 12344});
            this.f19091c = new int[1];
            this.f19092d = i10;
            this.f19093e = i11;
            this.f19094f = i12;
            this.f19095g = i13;
            this.f19096h = i14;
            this.f19097i = i15;
        }

        @Override // com.danlan.android.videogift.GLTextureView.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int c4 = c(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int c10 = c(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (c4 >= this.f19096h && c10 >= this.f19097i) {
                    int c11 = c(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int c12 = c(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int c13 = c(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int c14 = c(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (c11 == this.f19092d && c12 == this.f19093e && c13 == this.f19094f && c14 == this.f19095g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public final int c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10, int i11) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i10, this.f19091c) ? this.f19091c[0] : i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public int f19099a;

        public d() {
            this.f19099a = 12440;
        }

        @Override // com.danlan.android.videogift.GLTextureView.g
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f19099a, GLTextureView.this.f19087k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.f19087k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.danlan.android.videogift.GLTextureView.g
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("display:");
            sb2.append((Object) eGLDisplay);
            sb2.append(" context: ");
            sb2.append((Object) eGLContext);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("tid=");
            sb3.append(Thread.currentThread().getId());
            i.k("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class e implements h {
        public e() {
        }

        @Override // com.danlan.android.videogift.GLTextureView.h
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Override // com.danlan.android.videogift.GLTextureView.h
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface f {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface g {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface h {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<GLTextureView> f19101a;

        /* renamed from: b, reason: collision with root package name */
        public EGL10 f19102b;

        /* renamed from: c, reason: collision with root package name */
        public EGLDisplay f19103c;

        /* renamed from: d, reason: collision with root package name */
        public EGLSurface f19104d;

        /* renamed from: e, reason: collision with root package name */
        public EGLConfig f19105e;

        /* renamed from: f, reason: collision with root package name */
        public EGLContext f19106f;

        public i(WeakReference<GLTextureView> weakReference) {
            this.f19101a = weakReference;
        }

        public static String f(String str, int i10) {
            return str + " failed: " + i10;
        }

        public static void g(String str, String str2, int i10) {
            f(str2, i10);
        }

        public static void k(String str, int i10) {
            String f10 = f(str, i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("throwEglException tid=");
            sb2.append(Thread.currentThread().getId());
            sb2.append(" ");
            sb2.append(f10);
            throw new RuntimeException(f10);
        }

        public GL a() {
            GL gl = this.f19106f.getGL();
            GLTextureView gLTextureView = this.f19101a.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.f19085i != null) {
                gl = gLTextureView.f19085i.wrap(gl);
            }
            if ((gLTextureView.f19086j & 3) != 0) {
                return GLDebugHelper.wrap(gl, (gLTextureView.f19086j & 1) != 0 ? 1 : 0, (gLTextureView.f19086j & 2) != 0 ? new m() : null);
            }
            return gl;
        }

        public boolean b() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("createSurface()  tid=");
            sb2.append(Thread.currentThread().getId());
            if (this.f19102b != null) {
                if (this.f19103c != null) {
                    if (this.f19105e != null) {
                        d();
                        GLTextureView gLTextureView = this.f19101a.get();
                        if (gLTextureView != null) {
                            this.f19104d = gLTextureView.f19084h.createWindowSurface(this.f19102b, this.f19103c, this.f19105e, gLTextureView.getSurfaceTexture());
                        } else {
                            this.f19104d = null;
                        }
                        EGLSurface eGLSurface = this.f19104d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f19102b.eglMakeCurrent(this.f19103c, eGLSurface, eGLSurface, this.f19106f)) {
                                return true;
                            }
                            g("EGLHelper", "eglMakeCurrent", this.f19102b.eglGetError());
                            return false;
                        }
                        this.f19102b.eglGetError();
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("destroySurface()  tid=");
            sb2.append(Thread.currentThread().getId());
            d();
        }

        public final void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f19104d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f19102b.eglMakeCurrent(this.f19103c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f19101a.get();
            if (gLTextureView != null) {
                gLTextureView.f19084h.destroySurface(this.f19102b, this.f19103c, this.f19104d);
            }
            this.f19104d = null;
        }

        public void e() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("finish() tid=");
            sb2.append(Thread.currentThread().getId());
            if (this.f19106f != null) {
                GLTextureView gLTextureView = this.f19101a.get();
                if (gLTextureView != null) {
                    gLTextureView.f19083g.destroyContext(this.f19102b, this.f19103c, this.f19106f);
                }
                this.f19106f = null;
            }
            EGLDisplay eGLDisplay = this.f19103c;
            if (eGLDisplay != null) {
                this.f19102b.eglTerminate(eGLDisplay);
                this.f19103c = null;
            }
        }

        public void h() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("start() tid=");
            sb2.append(Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f19102b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f19103c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f19102b.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.f19101a.get();
                    if (gLTextureView == null) {
                        this.f19105e = null;
                        this.f19106f = null;
                    } else {
                        this.f19105e = gLTextureView.f19082f.chooseConfig(this.f19102b, this.f19103c);
                        this.f19106f = gLTextureView.f19083g.createContext(this.f19102b, this.f19103c, this.f19105e);
                    }
                    EGLContext eGLContext = this.f19106f;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f19106f = null;
                        j("createContext");
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("createContext ");
                    sb3.append((Object) this.f19106f);
                    sb3.append(" tid=");
                    sb3.append(Thread.currentThread().getId());
                    this.f19104d = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int i() {
            return !this.f19102b.eglSwapBuffers(this.f19103c, this.f19104d) ? this.f19102b.eglGetError() : Zygote.API_ENFORCEMENT_POLICY_MASK;
        }

        public final void j(String str) {
            k(str, this.f19102b.eglGetError());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class j extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public boolean f19107b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19108c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f19109d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f19110e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19111f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f19112g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f19113h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f19114i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f19115j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f19116k;

        /* renamed from: p, reason: collision with root package name */
        public boolean f19121p;

        /* renamed from: s, reason: collision with root package name */
        public i f19124s;

        /* renamed from: t, reason: collision with root package name */
        public WeakReference<GLTextureView> f19125t;

        /* renamed from: q, reason: collision with root package name */
        public ArrayList<Runnable> f19122q = new ArrayList<>();

        /* renamed from: r, reason: collision with root package name */
        public boolean f19123r = true;

        /* renamed from: l, reason: collision with root package name */
        public int f19117l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f19118m = 0;

        /* renamed from: o, reason: collision with root package name */
        public boolean f19120o = true;

        /* renamed from: n, reason: collision with root package name */
        public int f19119n = 1;

        public j(WeakReference<GLTextureView> weakReference) {
            this.f19125t = weakReference;
        }

        public boolean a() {
            return this.f19114i && this.f19115j && h();
        }

        public int c() {
            int i10;
            synchronized (GLTextureView.f19077m) {
                i10 = this.f19119n;
            }
            return i10;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:64:0x0370
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
            */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01d2 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void d() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 900
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.videogift.GLTextureView.j.d():void");
        }

        public void e() {
            synchronized (GLTextureView.f19077m) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onPause tid=");
                sb2.append(getId());
                this.f19109d = true;
                GLTextureView.f19077m.notifyAll();
                while (!this.f19108c && !this.f19110e) {
                    try {
                        GLTextureView.f19077m.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (GLTextureView.f19077m) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onResume tid=");
                sb2.append(getId());
                this.f19109d = false;
                this.f19120o = true;
                this.f19121p = false;
                GLTextureView.f19077m.notifyAll();
                while (!this.f19108c && this.f19110e && !this.f19121p) {
                    try {
                        GLTextureView.f19077m.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g(int i10, int i11) {
            synchronized (GLTextureView.f19077m) {
                this.f19117l = i10;
                this.f19118m = i11;
                this.f19123r = true;
                this.f19120o = true;
                this.f19121p = false;
                GLTextureView.f19077m.notifyAll();
                while (!this.f19108c && !this.f19110e && !this.f19121p && a()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onWindowResize waiting for render complete from tid=");
                    sb2.append(getId());
                    try {
                        GLTextureView.f19077m.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final boolean h() {
            return !this.f19110e && this.f19111f && !this.f19112g && this.f19117l > 0 && this.f19118m > 0 && (this.f19120o || this.f19119n == 1);
        }

        public void i() {
            synchronized (GLTextureView.f19077m) {
                this.f19107b = true;
                GLTextureView.f19077m.notifyAll();
                while (!this.f19108c) {
                    try {
                        GLTextureView.f19077m.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void j() {
            this.f19116k = true;
            GLTextureView.f19077m.notifyAll();
        }

        public void k() {
            synchronized (GLTextureView.f19077m) {
                this.f19120o = true;
                GLTextureView.f19077m.notifyAll();
            }
        }

        public void l(int i10) {
            if (i10 >= 0 && i10 <= 1) {
                synchronized (GLTextureView.f19077m) {
                    this.f19119n = i10;
                    GLTextureView.f19077m.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public final void m() {
            if (this.f19114i) {
                this.f19124s.e();
                this.f19114i = false;
                GLTextureView.f19077m.c(this);
            }
        }

        public final void n() {
            if (this.f19115j) {
                this.f19115j = false;
                this.f19124s.c();
            }
        }

        public void o() {
            synchronized (GLTextureView.f19077m) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("surfaceCreated tid=");
                sb2.append(getId());
                this.f19111f = true;
                GLTextureView.f19077m.notifyAll();
                while (this.f19113h && !this.f19108c) {
                    try {
                        GLTextureView.f19077m.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void p() {
            synchronized (GLTextureView.f19077m) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("surfaceDestroyed tid=");
                sb2.append(getId());
                this.f19111f = false;
                GLTextureView.f19077m.notifyAll();
                while (!this.f19113h && !this.f19108c) {
                    try {
                        GLTextureView.f19077m.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("starting tid=");
            sb2.append(getId());
            try {
                d();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.f19077m.f(this);
                throw th;
            }
            GLTextureView.f19077m.f(this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19126a;

        /* renamed from: b, reason: collision with root package name */
        public int f19127b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19128c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f19129d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f19130e;

        /* renamed from: f, reason: collision with root package name */
        public j f19131f;

        public k() {
        }

        public synchronized void a(GL10 gl10) {
            if (!this.f19128c) {
                b();
                String glGetString = gl10.glGetString(7937);
                if (this.f19127b < 131072) {
                    this.f19129d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f19130e = this.f19129d ? false : true;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("checkGLDriver renderer = \"");
                sb2.append(glGetString);
                sb2.append("\" multipleContextsAllowed = ");
                sb2.append(this.f19129d);
                sb2.append(" mLimitedGLESContexts = ");
                sb2.append(this.f19130e);
                this.f19128c = true;
            }
        }

        public final void b() {
            if (this.f19126a) {
                return;
            }
            this.f19126a = true;
        }

        public void c(j jVar) {
            if (this.f19131f == jVar) {
                this.f19131f = null;
            }
            notifyAll();
        }

        public synchronized boolean d() {
            return this.f19130e;
        }

        public synchronized boolean e() {
            b();
            return !this.f19129d;
        }

        public synchronized void f(j jVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exiting tid=");
            sb2.append(jVar.getId());
            jVar.f19108c = true;
            if (this.f19131f == jVar) {
                this.f19131f = null;
            }
            notifyAll();
        }

        public boolean g(j jVar) {
            j jVar2 = this.f19131f;
            if (jVar2 != jVar && jVar2 != null) {
                b();
                if (this.f19129d) {
                    return true;
                }
                j jVar3 = this.f19131f;
                if (jVar3 == null) {
                    return false;
                }
                jVar3.j();
                return false;
            }
            this.f19131f = jVar;
            notifyAll();
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface l {
        GL wrap(GL gl);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class m extends Writer {

        /* renamed from: b, reason: collision with root package name */
        public StringBuilder f19132b = new StringBuilder();

        public final void a() {
            if (this.f19132b.length() > 0) {
                this.f19132b.toString();
                StringBuilder sb2 = this.f19132b;
                sb2.delete(0, sb2.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                char c4 = cArr[i10 + i12];
                if (c4 == '\n') {
                    a();
                } else {
                    this.f19132b.append(c4);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface n {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i10, int i11);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class o extends c {
        public o(boolean z10) {
            super(8, 8, 8, 0, z10 ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.f19078b = new WeakReference<>(this);
        k();
    }

    private void k() {
        setSurfaceTextureListener(this);
    }

    public void finalize() throws Throwable {
        try {
            j jVar = this.f19079c;
            if (jVar != null) {
                jVar.i();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.f19086j;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f19088l;
    }

    public int getRenderMode() {
        return this.f19079c.c();
    }

    public final void j() {
        if (this.f19079c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void l() {
        this.f19079c.e();
    }

    public void m() {
        this.f19079c.f();
    }

    public void o() {
        this.f19079c.k();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAttachedToWindow reattach =");
        sb2.append(this.f19081e);
        if (this.f19081e && this.f19080d != null) {
            j jVar = this.f19079c;
            int c4 = jVar != null ? jVar.c() : 1;
            j jVar2 = new j(this.f19078b);
            this.f19079c = jVar2;
            if (c4 != 1) {
                jVar2.l(c4);
            }
            this.f19079c.start();
        }
        this.f19081e = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        j jVar = this.f19079c;
        if (jVar != null) {
            jVar.i();
        }
        this.f19081e = true;
        super.onDetachedFromWindow();
    }

    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        p(getSurfaceTexture(), 0, i12 - i10, i13 - i11);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        q(surfaceTexture);
        p(surfaceTexture, 0, i10, i11);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        r(surfaceTexture);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        p(surfaceTexture, 0, i10, i11);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        o();
    }

    public void p(SurfaceTexture surfaceTexture, int i10, int i11, int i12) {
        this.f19079c.g(i11, i12);
    }

    public void q(SurfaceTexture surfaceTexture) {
        this.f19079c.o();
    }

    public void r(SurfaceTexture surfaceTexture) {
        this.f19079c.p();
    }

    public void setDebugFlags(int i10) {
        this.f19086j = i10;
    }

    public void setEGLConfigChooser(f fVar) {
        j();
        this.f19082f = fVar;
    }

    public void setEGLContextClientVersion(int i10) {
        j();
        this.f19087k = i10;
    }

    public void setEGLContextFactory(g gVar) {
        j();
        this.f19083g = gVar;
    }

    public void setEGLWindowSurfaceFactory(h hVar) {
        j();
        this.f19084h = hVar;
    }

    public void setGLWrapper(l lVar) {
        this.f19085i = lVar;
    }

    public void setPreserveEGLContextOnPause(boolean z10) {
        this.f19088l = z10;
    }

    public void setRenderMode(int i10) {
        this.f19079c.l(i10);
    }

    public void setRenderer(n nVar) {
        j();
        if (this.f19082f == null) {
            this.f19082f = new o(true);
        }
        if (this.f19083g == null) {
            this.f19083g = new d();
        }
        if (this.f19084h == null) {
            this.f19084h = new e();
        }
        this.f19080d = nVar;
        j jVar = new j(this.f19078b);
        this.f19079c = jVar;
        jVar.start();
    }

    public void setEGLConfigChooser(boolean z10) {
        setEGLConfigChooser(new o(z10));
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19078b = new WeakReference<>(this);
        k();
    }

    public void setEGLConfigChooser(int i10, int i11, int i12, int i13, int i14, int i15) {
        setEGLConfigChooser(new c(i10, i11, i12, i13, i14, i15));
    }
}
