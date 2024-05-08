package com.tencent.liteav.videobase.frame;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PixelFrameFactory {
    private EGLSurface mCallerEGLDrawSurface;
    private EGLSurface mCallerEGLReadSurface;
    private e mGLTexturePool;
    private final Size mLastFrameSize;
    private j mPixelFrameRenderer;
    private EGLCore mRenderEGLCore;
    private final com.tencent.liteav.base.b.b mThrottlers;
    private final String mTAG = "PixelFrameFactory_" + hashCode();
    private Object mSharedEGLContext = null;
    private EGLDisplay mCallerEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLContext mCallerEGLContext = EGL14.EGL_NO_CONTEXT;

    @CalledByNative
    public PixelFrameFactory() {
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        this.mCallerEGLReadSurface = eGLSurface;
        this.mCallerEGLDrawSurface = eGLSurface;
        this.mLastFrameSize = new Size();
        this.mThrottlers = new com.tencent.liteav.base.b.b();
    }

    private PixelFrame copyTexture(PixelFrame pixelFrame) {
        if (this.mGLTexturePool == null) {
            this.mGLTexturePool = new e();
        }
        d a10 = this.mGLTexturePool.a(pixelFrame.getWidth(), pixelFrame.getHeight());
        if (this.mLastFrameSize.width != pixelFrame.getWidth() || this.mLastFrameSize.height != pixelFrame.getHeight()) {
            j jVar = this.mPixelFrameRenderer;
            if (jVar != null) {
                jVar.a();
                this.mPixelFrameRenderer = null;
            }
            this.mLastFrameSize.width = pixelFrame.getWidth();
            this.mLastFrameSize.height = pixelFrame.getHeight();
        }
        if (this.mPixelFrameRenderer == null) {
            this.mPixelFrameRenderer = new j(pixelFrame.getWidth(), pixelFrame.getHeight());
        }
        this.mPixelFrameRenderer.a(pixelFrame, GLConstants.GLScaleType.FILL, a10);
        PixelFrame a11 = a10.a(pixelFrame.getGLContext());
        a10.release();
        return a11;
    }

    private PixelFrame deepCopyDataToPixelFrame(PixelFrame pixelFrame, Object obj) {
        if (obj instanceof byte[]) {
            byte[] a10 = com.tencent.liteav.videobase.utils.j.a(((byte[]) obj).length);
            if (a10 == null) {
                return null;
            }
            System.arraycopy(obj, 0, a10, 0, a10.length);
            pixelFrame.setData(a10);
        } else if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            ByteBuffer b4 = com.tencent.liteav.videobase.utils.j.b(byteBuffer.capacity());
            if (b4 == null) {
                return null;
            }
            byteBuffer.rewind();
            b4.put(byteBuffer);
            b4.rewind();
            pixelFrame.setBuffer(b4);
        }
        pixelFrame.retain();
        return pixelFrame;
    }

    private PixelFrame deepCopyTextureToPixelFrame(PixelFrame pixelFrame, Object obj) {
        saveCallerEGLContext();
        GLES20.glFinish();
        if (!CommonUtil.equals(this.mSharedEGLContext, obj)) {
            uninitOpenGLComponents();
            initRenderEGLContext(obj);
        }
        if (!makeCurrent()) {
            LiteavLog.e(this.mThrottlers.a("makeCurrent"), this.mTAG, "use origin texture when makeCurrent error", new Object[0]);
            pixelFrame.retain();
            return pixelFrame;
        }
        PixelFrame copyTexture = copyTexture(pixelFrame);
        GLES20.glFinish();
        restoreCallerEGLContext();
        return copyTexture;
    }

    private void initRenderEGLContext(Object obj) {
        if (this.mRenderEGLCore != null) {
            return;
        }
        LiteavLog.i(this.mTAG, "initRenderEGLContext");
        this.mSharedEGLContext = obj;
        EGLCore eGLCore = new EGLCore();
        this.mRenderEGLCore = eGLCore;
        try {
            eGLCore.initialize(obj, null, 128, 128);
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            this.mRenderEGLCore = null;
            LiteavLog.e(this.mThrottlers.a("initEGLCore"), this.mTAG, "create EGLCore failed.", e2);
        }
    }

    private boolean makeCurrent() {
        EGLCore eGLCore = this.mRenderEGLCore;
        if (eGLCore == null) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentNull"), this.mTAG, "makeCurrent on mEGLCore is null", new Object[0]);
            return false;
        }
        try {
            eGLCore.makeCurrent();
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.mThrottlers.a("makeCurrentError"), this.mTAG, "make current failed.", e2);
            return false;
        }
    }

    private void restoreCallerEGLContext() {
        if (!CommonUtil.equals(this.mCallerEGLContext, EGL14.EGL_NO_CONTEXT)) {
            EGL14.eglMakeCurrent(this.mCallerEGLDisplay, this.mCallerEGLDrawSurface, this.mCallerEGLReadSurface, this.mCallerEGLContext);
            return;
        }
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eglGetCurrentDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
    }

    private void saveCallerEGLContext() {
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (CommonUtil.equals(this.mCallerEGLContext, EGL14.EGL_NO_CONTEXT) || !CommonUtil.equals(eglGetCurrentContext, this.mCallerEGLContext)) {
            this.mCallerEGLContext = eglGetCurrentContext;
            this.mCallerEGLDisplay = EGL14.eglGetCurrentDisplay();
            this.mCallerEGLReadSurface = EGL14.eglGetCurrentSurface(12378);
            this.mCallerEGLDrawSurface = EGL14.eglGetCurrentSurface(12377);
        }
    }

    private PixelFrame shallowCopyDataToPixelFrame(PixelFrame pixelFrame, Object obj) {
        if (obj instanceof byte[]) {
            pixelFrame.setData((byte[]) obj);
        } else if (obj instanceof ByteBuffer) {
            pixelFrame.setBuffer((ByteBuffer) obj);
        }
        pixelFrame.retain();
        return pixelFrame;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r2 = deepCopyDataToPixelFrame(r0, r10);
     */
    @com.tencent.liteav.base.annotations.CalledByNative
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.tencent.liteav.videobase.frame.PixelFrame create(int r2, int r3, long r4, int r6, int r7, int r8, java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.tencent.liteav.videobase.frame.PixelFrame r0 = new com.tencent.liteav.videobase.frame.PixelFrame     // Catch: java.lang.Throwable -> L46
            r0.<init>()     // Catch: java.lang.Throwable -> L46
            r0.setWidth(r2)     // Catch: java.lang.Throwable -> L46
            r0.setHeight(r3)     // Catch: java.lang.Throwable -> L46
            r0.setTimestamp(r4)     // Catch: java.lang.Throwable -> L46
            r0.setGLContext(r9)     // Catch: java.lang.Throwable -> L46
            r0.setTextureId(r8)     // Catch: java.lang.Throwable -> L46
            com.tencent.liteav.videobase.base.GLConstants$PixelBufferType r2 = com.tencent.liteav.videobase.base.GLConstants.PixelBufferType.a(r6)     // Catch: java.lang.Throwable -> L46
            r0.setPixelBufferType(r2)     // Catch: java.lang.Throwable -> L46
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r2 = com.tencent.liteav.videobase.base.GLConstants.PixelFormatType.a(r7)     // Catch: java.lang.Throwable -> L46
            r0.setPixelFormatType(r2)     // Catch: java.lang.Throwable -> L46
            com.tencent.liteav.videobase.base.GLConstants$PixelBufferType r2 = r0.getPixelBufferType()     // Catch: java.lang.Throwable -> L46
            com.tencent.liteav.videobase.base.GLConstants$PixelBufferType r3 = com.tencent.liteav.videobase.base.GLConstants.PixelBufferType.BYTE_ARRAY     // Catch: java.lang.Throwable -> L46
            if (r2 == r3) goto L39
            com.tencent.liteav.videobase.base.GLConstants$PixelBufferType r2 = r0.getPixelBufferType()     // Catch: java.lang.Throwable -> L46
            com.tencent.liteav.videobase.base.GLConstants$PixelBufferType r3 = com.tencent.liteav.videobase.base.GLConstants.PixelBufferType.BYTE_BUFFER     // Catch: java.lang.Throwable -> L46
            if (r2 != r3) goto L34
            goto L39
        L34:
            com.tencent.liteav.videobase.frame.PixelFrame r2 = r1.deepCopyTextureToPixelFrame(r0, r9)     // Catch: java.lang.Throwable -> L46
            goto L44
        L39:
            if (r11 == 0) goto L40
            com.tencent.liteav.videobase.frame.PixelFrame r2 = r1.deepCopyDataToPixelFrame(r0, r10)     // Catch: java.lang.Throwable -> L46
            goto L44
        L40:
            com.tencent.liteav.videobase.frame.PixelFrame r2 = r1.shallowCopyDataToPixelFrame(r0, r10)     // Catch: java.lang.Throwable -> L46
        L44:
            monitor-exit(r1)
            return r2
        L46:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.frame.PixelFrameFactory.create(int, int, long, int, int, int, java.lang.Object, java.lang.Object, boolean):com.tencent.liteav.videobase.frame.PixelFrame");
    }

    @CalledByNative
    public synchronized void release(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            pixelFrame.release();
        }
    }

    @CalledByNative
    public synchronized void uninitOpenGLComponents() {
        if (this.mRenderEGLCore == null) {
            return;
        }
        LiteavLog.i(this.mTAG, "uninitOpenGLComponents");
        if (makeCurrent()) {
            e eVar = this.mGLTexturePool;
            if (eVar != null) {
                eVar.a();
                this.mGLTexturePool.b();
                this.mGLTexturePool = null;
            }
            j jVar = this.mPixelFrameRenderer;
            if (jVar != null) {
                jVar.a();
                this.mPixelFrameRenderer = null;
            }
        }
        EGLCore.destroy(this.mRenderEGLCore);
        this.mRenderEGLCore = null;
    }
}
