package com.tencent.liteav.videobase.egl;

import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements g<EGLContext> {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f43401i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f43402j = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: b, reason: collision with root package name */
    private final int f43404b;

    /* renamed from: c, reason: collision with root package name */
    private final int f43405c;

    /* renamed from: g, reason: collision with root package name */
    private EGL10 f43409g;

    /* renamed from: h, reason: collision with root package name */
    private EGLConfig f43410h;

    /* renamed from: d, reason: collision with root package name */
    private EGLDisplay f43406d = EGL10.EGL_NO_DISPLAY;

    /* renamed from: e, reason: collision with root package name */
    private EGLContext f43407e = EGL10.EGL_NO_CONTEXT;

    /* renamed from: f, reason: collision with root package name */
    private EGLSurface f43408f = EGL10.EGL_NO_SURFACE;

    /* renamed from: a, reason: collision with root package name */
    private final String f43403a = "EGL10Helper@" + hashCode();

    private a(int i10, int i11) {
        this.f43404b = i10;
        this.f43405c = i11;
    }

    public static a a(EGLContext eGLContext, Surface surface, int i10, int i11) throws f {
        int i12;
        a aVar = new a(i10, i11);
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            aVar.f43409g = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            aVar.f43406d = eglGetDisplay;
            aVar.f43409g.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            aVar.f43409g.eglChooseConfig(aVar.f43406d, surface == null ? f43401i : f43402j, eGLConfigArr, 1, new int[1]);
            aVar.f43410h = eGLConfigArr[0];
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                try {
                    aVar.f43407e = aVar.a(aVar.f43406d, aVar.f43410h, 2, eGLContext);
                } catch (f unused) {
                    LiteavLog.i(aVar.f43403a, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                    aVar.f43407e = aVar.a(aVar.f43406d, aVar.f43410h, 3, eGLContext);
                    i12 = 3;
                }
            } else {
                aVar.f43407e = aVar.a(aVar.f43406d, aVar.f43410h, 2, eGLContext);
            }
            i12 = 2;
            LiteavLog.i(aVar.f43403a, "create eglContext " + ((Object) aVar.f43407e) + " sharedContext: " + ((Object) eGLContext) + " version:" + i12);
            if (surface == null) {
                aVar.f43408f = aVar.f43409g.eglCreatePbufferSurface(aVar.f43406d, aVar.f43410h, new int[]{12375, aVar.f43404b, 12374, aVar.f43405c, 12344});
            } else {
                try {
                    aVar.f43408f = aVar.f43409g.eglCreateWindowSurface(aVar.f43406d, aVar.f43410h, surface, null);
                } catch (Throwable th) {
                    throw new f(aVar.f43409g.eglGetError(), "", th);
                }
            }
            if (aVar.f43408f == EGL10.EGL_NO_SURFACE) {
                aVar.h();
            }
            EGL10 egl102 = aVar.f43409g;
            EGLDisplay eGLDisplay = aVar.f43406d;
            EGLSurface eGLSurface = aVar.f43408f;
            if (!egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, aVar.f43407e)) {
                aVar.h();
            }
            return aVar;
        } catch (f e2) {
            aVar.c();
            throw e2;
        }
    }

    private void g() throws f {
        if (this.f43408f != EGL10.EGL_NO_SURFACE) {
            d();
            if (!this.f43409g.eglDestroySurface(this.f43406d, this.f43408f)) {
                h();
            }
            this.f43408f = EGL10.EGL_NO_SURFACE;
        }
    }

    private void h() throws f {
        int eglGetError = this.f43409g.eglGetError();
        if (eglGetError != 12288) {
            throw new f(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void b() throws f {
        EGL10 egl10 = this.f43409g;
        EGLDisplay eGLDisplay = this.f43406d;
        EGLSurface eGLSurface = this.f43408f;
        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f43407e)) {
            return;
        }
        h();
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void c() throws f {
        if (this.f43406d != EGL10.EGL_NO_DISPLAY) {
            d();
            g();
            if (this.f43407e != EGL10.EGL_NO_CONTEXT) {
                LiteavLog.i(this.f43403a, "destroy eglContext " + ((Object) this.f43407e));
                this.f43409g.eglDestroyContext(this.f43406d, this.f43407e);
                this.f43407e = EGL10.EGL_NO_CONTEXT;
            }
            this.f43409g.eglTerminate(this.f43406d);
        }
        this.f43406d = EGL10.EGL_NO_DISPLAY;
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void d() {
        EGLDisplay eGLDisplay = this.f43406d;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.f43409g;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final Size e() {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        boolean eglQuerySurface = this.f43409g.eglQuerySurface(this.f43406d, this.f43408f, 12375, iArr);
        boolean eglQuerySurface2 = this.f43409g.eglQuerySurface(this.f43406d, this.f43408f, 12374, iArr2);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr2[0]);
        }
        return new Size(0, 0);
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final /* bridge */ /* synthetic */ EGLContext f() {
        return this.f43407e;
    }

    @Override // com.tencent.liteav.videobase.egl.g
    public final void a() throws f {
        GLES20.glFinish();
        if (this.f43409g.eglSwapBuffers(this.f43406d, this.f43408f)) {
            return;
        }
        h();
    }

    private EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10, EGLContext eGLContext) throws f {
        int[] iArr = {12440, i10, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.f43409g.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        h();
        return eglCreateContext;
    }
}
