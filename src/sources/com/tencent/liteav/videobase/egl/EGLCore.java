package com.tencent.liteav.videobase.egl;

import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.l;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EGLCore {
    private static final long DESTROY_EGL_CORE_DELAY_TIME_MS = 100;
    private static final int MAX_EGL_CORE_COUNT = 50;
    private static final String TAG = "EGLCore";
    private g<?> mEglHelper;
    private boolean mIsOffScreen = false;
    private Object mSharedContext;
    private static final l sSequenceTaskRunner = new l();
    private static final AtomicInteger sEGLCoreCount = new AtomicInteger();

    @CalledByNative
    public static EGLCore create(Object obj) {
        EGLCore eGLCore = new EGLCore();
        try {
            eGLCore.initialize(obj, null, 128, 128);
            eGLCore.makeCurrent();
            return eGLCore;
        } catch (f e2) {
            LiteavLog.e(TAG, "create EGLCore failed.", e2);
            return null;
        }
    }

    @CalledByNative
    public static void destroy(@Nullable EGLCore eGLCore) {
        if (eGLCore == null) {
            return;
        }
        eGLCore.unmakeCurrent();
        Runnable a10 = e.a(eGLCore);
        if (!eGLCore.mIsOffScreen) {
            a10.run();
        } else {
            sSequenceTaskRunner.b(a10, 100L);
        }
    }

    public static /* synthetic */ void lambda$destroy$0(@Nullable EGLCore eGLCore) {
        try {
            eGLCore.uninitialize();
            LiteavLog.i(TAG, "EGLCore destroy success. ".concat(String.valueOf(eGLCore)));
        } catch (f e2) {
            LiteavLog.e(TAG, "EGLCore destroy failed.", e2);
        }
    }

    private void uninitialize() throws f {
        g<?> gVar = this.mEglHelper;
        if (gVar != null) {
            gVar.c();
            this.mEglHelper = null;
        }
        this.mSharedContext = null;
        sEGLCoreCount.decrementAndGet();
    }

    public Object getEglContext() {
        g<?> gVar = this.mEglHelper;
        if (gVar == null) {
            return null;
        }
        return gVar.f();
    }

    public Object getSharedContext() {
        return this.mSharedContext;
    }

    public Size getSurfaceSize() {
        g<?> gVar = this.mEglHelper;
        return gVar == null ? new Size(0, 0) : gVar.e();
    }

    public void initialize(Object obj, Surface surface, int i10, int i11) throws f {
        this.mIsOffScreen = surface == null;
        if (obj == null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                this.mEglHelper = b.a((EGLContext) null, surface, i10, i11);
            } else {
                this.mEglHelper = a.a((javax.microedition.khronos.egl.EGLContext) null, surface, i10, i11);
            }
        } else if (obj instanceof javax.microedition.khronos.egl.EGLContext) {
            this.mEglHelper = a.a((javax.microedition.khronos.egl.EGLContext) obj, surface, i10, i11);
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (obj instanceof EGLContext)) {
            this.mEglHelper = b.a((EGLContext) obj, surface, i10, i11);
        } else {
            throw new f(0, "sharedContext isn't EGLContext");
        }
        this.mSharedContext = obj;
        LiteavLog.i(TAG, "EGLCore created in thread " + Thread.currentThread().getId() + ", sharedContext: " + obj + ", Surface: " + ((Object) surface) + ", width: " + i10 + ", height: " + i11 + ", eglCoreCount: " + sEGLCoreCount.incrementAndGet());
    }

    public void makeCurrent() throws f {
        g<?> gVar = this.mEglHelper;
        if (gVar != null) {
            gVar.b();
        }
    }

    public void setPresentationTime(long j10) {
        g<?> gVar = this.mEglHelper;
        if (gVar == null || !(gVar instanceof b)) {
            return;
        }
        b bVar = (b) gVar;
        EGLExt.eglPresentationTimeANDROID(bVar.f43413a, bVar.f43414b, j10);
    }

    public void swapBuffers() throws f {
        g<?> gVar = this.mEglHelper;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void unmakeCurrent() {
        g<?> gVar = this.mEglHelper;
        if (gVar != null) {
            gVar.d();
        }
    }
}
