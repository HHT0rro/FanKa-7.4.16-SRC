package com.tencent.liteav.videobase.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements g<EGLContext> {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f43411h = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f43412i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: d, reason: collision with root package name */
    private final int f43416d;

    /* renamed from: e, reason: collision with root package name */
    private final int f43417e;

    /* renamed from: f, reason: collision with root package name */
    private EGLConfig f43418f = null;

    /* renamed from: a, reason: collision with root package name */
    public EGLDisplay f43413a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: g, reason: collision with root package name */
    private EGLContext f43419g = EGL14.EGL_NO_CONTEXT;

    /* renamed from: b, reason: collision with root package name */
    public EGLSurface f43414b = EGL14.EGL_NO_SURFACE;

    /* renamed from: c, reason: collision with root package name */
    private final String f43415c = "EGL14Helper@" + hashCode();

    private b(int i10, int i11) {
        this.f43416d = i10;
        this.f43417e = i11;
    }

    public static b a(EGLContext eGLContext, Surface surface, int i10, int i11) throws f {
        int i12;
        b bVar = new b(i10, i11);
        try {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            bVar.f43413a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    bVar.f43413a = null;
                    LiteavLog.e(bVar.f43415c, "unable to initialize EGL14");
                    throw new f(0);
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(bVar.f43413a, surface == null ? f43412i : f43411h, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    bVar.f43418f = eGLConfigArr[0];
                    if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                        try {
                            bVar.f43419g = a(bVar.f43413a, bVar.f43418f, 2, eGLContext);
                        } catch (f unused) {
                            LiteavLog.i(bVar.f43415c, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                            bVar.f43419g = a(bVar.f43413a, bVar.f43418f, 3, eGLContext);
                            i12 = 3;
                        }
                    } else {
                        bVar.f43419g = a(bVar.f43413a, bVar.f43418f, 2, eGLContext);
                    }
                    i12 = 2;
                    LiteavLog.i(bVar.f43415c, "create eglContext " + ((Object) bVar.f43419g) + " sharedContext: " + ((Object) eGLContext) + " version:" + i12);
                    if (surface == null) {
                        bVar.f43414b = EGL14.eglCreatePbufferSurface(bVar.f43413a, bVar.f43418f, new int[]{12375, bVar.f43416d, 12374, bVar.f43417e, 12344}, 0);
                    } else {
                        try {
                            bVar.f43414b = EGL14.eglCreateWindowSurface(bVar.f43413a, bVar.f43418f, surface, new int[]{12344}, 0);
                        } catch (Throwable th) {
                            throw new f(EGL14.eglGetError(), "", th);
                        }
                    }
                    g();
                    EGLDisplay eGLDisplay = bVar.f43413a;
                    EGLSurface eGLSurface = bVar.f43414b;
                    if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, bVar.f43419g)) {
                        g();
                    }
                    return bVar;
                }
                throw new f(0);
            }
            LiteavLog.e(bVar.f43415c, "unable to get EGL14 display");
            throw new f(0);
        } catch (f e2) {
            bVar.c();
            throw e2;
        }
    }

    private static void g() throws f {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new f(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void b() throws f {
        EGLDisplay eGLDisplay = this.f43413a;
        EGLSurface eGLSurface = this.f43414b;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f43419g)) {
            return;
        }
        g();
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void c() {
        EGLDisplay eGLDisplay = this.f43413a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.f43414b;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.f43413a, eGLSurface2);
                this.f43414b = EGL14.EGL_NO_SURFACE;
            }
            if (this.f43419g != EGL14.EGL_NO_CONTEXT) {
                LiteavLog.i(this.f43415c, "destroy eglContext " + ((Object) this.f43419g));
                EGL14.eglDestroyContext(this.f43413a, this.f43419g);
                this.f43419g = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f43413a);
        }
        this.f43413a = EGL14.EGL_NO_DISPLAY;
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void d() {
        EGLDisplay eGLDisplay = this.f43413a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final Size e() {
        int[] iArr = new int[2];
        boolean eglQuerySurface = EGL14.eglQuerySurface(this.f43413a, this.f43414b, 12375, iArr, 0);
        boolean eglQuerySurface2 = EGL14.eglQuerySurface(this.f43413a, this.f43414b, 12374, iArr, 1);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr[1]);
        }
        return new Size(0, 0);
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final /* bridge */ /* synthetic */ EGLContext f() {
        return this.f43419g;
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void a() throws f {
        GLES20.glFinish();
        if (EGL14.eglSwapBuffers(this.f43413a, this.f43414b)) {
            return;
        }
        g();
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10, EGLContext eGLContext) throws f {
        int[] iArr = {12440, i10, 12344};
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
        g();
        return eglCreateContext;
    }
}
