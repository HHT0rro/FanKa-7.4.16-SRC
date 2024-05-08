package com.tencent.liteav.videoproducer.capture;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Looper;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.egl.EGLCore;
import javax.microedition.khronos.egl.EGL10;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ax f44326a;

    /* renamed from: b, reason: collision with root package name */
    private Object f44327b;

    /* renamed from: c, reason: collision with root package name */
    private EGLCore f44328c;

    private ax() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            new CustomHandler(Looper.getMainLooper()).runAndWaitDone(ay.a(this));
        }
    }

    public static ax a() {
        if (f44326a == null) {
            synchronized (ax.class) {
                if (f44326a == null) {
                    f44326a = new ax();
                }
            }
        }
        return f44326a;
    }

    private void c() {
        EGLCore eGLCore = new EGLCore();
        this.f44328c = eGLCore;
        try {
            eGLCore.initialize(null, null, 128, 128);
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e("GlobalContextManager", "initializeEGL failed.", e2);
            this.f44328c = null;
        }
        EGLCore eGLCore2 = this.f44328c;
        if (eGLCore2 != null) {
            this.f44327b = eGLCore2.getEglContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f44327b != null) {
            return;
        }
        LiteavLog.i("GlobalContextManager", "context before creating: " + ((Object) EGL14.eglGetCurrentContext()));
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12378);
            EGLSurface eglGetCurrentSurface2 = EGL14.eglGetCurrentSurface(12377);
            EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
            c();
            EGL14.eglMakeCurrent(eglGetDisplay, eglGetCurrentSurface2, eglGetCurrentSurface, eglGetCurrentContext);
        } else {
            EGL10 egl10 = (EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
            javax.microedition.khronos.egl.EGLDisplay eglGetDisplay2 = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface3 = egl10.eglGetCurrentSurface(12378);
            javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface4 = egl10.eglGetCurrentSurface(12377);
            javax.microedition.khronos.egl.EGLContext eglGetCurrentContext2 = egl10.eglGetCurrentContext();
            c();
            egl10.eglMakeCurrent(eglGetDisplay2, eglGetCurrentSurface4, eglGetCurrentSurface3, eglGetCurrentContext2);
        }
        LiteavLog.i("GlobalContextManager", "context after creating: " + ((Object) EGL14.eglGetCurrentContext()) + ", global context: " + this.f44327b);
    }

    public final synchronized Object b() {
        return this.f44327b;
    }
}
