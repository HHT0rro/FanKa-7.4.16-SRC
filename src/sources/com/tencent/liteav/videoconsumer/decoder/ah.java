package com.tencent.liteav.videoconsumer.decoder;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.l;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.ad;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ah extends ad implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: i, reason: collision with root package name */
    private EGLCore f43849i;

    /* renamed from: j, reason: collision with root package name */
    private int f43850j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.l f43851k;

    /* renamed from: l, reason: collision with root package name */
    private SurfaceTexture f43852l;

    /* renamed from: m, reason: collision with root package name */
    private Surface f43853m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f43854n;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.e f43855o;

    public ah(com.tencent.liteav.videobase.utils.h hVar, Size size, IVideoReporter iVideoReporter, boolean z10, ad.b bVar, CustomHandler customHandler) {
        super(hVar, size, iVideoReporter, z10, bVar, customHandler);
        this.f43850j = -1;
        this.f43829a = "MediaCodecOutputOESTextureDecoder";
    }

    private boolean c() {
        try {
            EGLCore eGLCore = this.f43849i;
            if (eGLCore == null) {
                return true;
            }
            eGLCore.makeCurrent();
            return true;
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(this.f43835g.a("makeCurrent"), this.f43829a, "makeCurrent failed.", e2);
            return false;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        am.a(mediaCodec, mediaFormat, this.f43853m);
        LiteavLog.i(this.f43829a, "configure mediacodec with " + ((Object) this.f43853m));
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final void b() {
        super.b();
        LiteavLog.i(this.f43829a, "uninitialize gl components");
        if (c()) {
            com.tencent.liteav.videobase.frame.l lVar = this.f43851k;
            if (lVar != null) {
                lVar.b();
            }
            Surface surface = this.f43853m;
            if (surface != null) {
                surface.release();
                this.f43853m = null;
            }
            SurfaceTexture surfaceTexture = this.f43852l;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f43852l = null;
            }
            com.tencent.liteav.videobase.frame.e eVar = this.f43855o;
            if (eVar != null) {
                eVar.b();
                this.f43855o = null;
            }
            com.tencent.liteav.videobase.frame.j jVar = this.f43854n;
            if (jVar != null) {
                jVar.a();
                this.f43854n = null;
            }
            OpenGlUtils.deleteTexture(this.f43850j);
            this.f43850j = -1;
            EGLCore.destroy(this.f43849i);
            this.f43849i = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        a(ai.a(this, surfaceTexture));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final void a(MediaCodec mediaCodec) {
        if (Build.VERSION.SDK_INT >= 23) {
            mediaCodec.setOutputSurface(this.f43853m);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(Object obj) {
        return b(obj);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad
    public final boolean a(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i10) {
        mediaCodec.releaseOutputBuffer(i10, true);
        if ((bufferInfo.flags & 4) == 0) {
            return true;
        }
        LiteavLog.i(this.f43829a, "meet end of stream.");
        ad.b bVar = this.f43830b;
        if (bVar == null) {
            return false;
        }
        bVar.a((PixelFrame) null, true);
        return false;
    }

    public static /* synthetic */ void a(ah ahVar, SurfaceTexture surfaceTexture) {
        l.b bVar;
        SurfaceTexture surfaceTexture2 = ahVar.f43852l;
        if (surfaceTexture2 == null || surfaceTexture != surfaceTexture2) {
            return;
        }
        ahVar.c();
        try {
            bVar = ahVar.f43851k.a();
        } catch (InterruptedException unused) {
            LiteavLog.w(ahVar.f43829a, "textureholderpool obtain interrupted.");
            bVar = null;
        }
        int i10 = ahVar.f43850j;
        Size size = ahVar.f43831c;
        bVar.a(36197, i10, size.width, size.height);
        PixelFrame a10 = bVar.a(ahVar.f43849i.getEglContext());
        if (a10.getMatrix() == null) {
            a10.setMatrix(new float[16]);
        }
        try {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(a10.getMatrix());
        } catch (Throwable th) {
            LiteavLog.w(ahVar.f43835g.a("updateImage"), ahVar.f43829a, "updateTexImage exception: ".concat(String.valueOf(th)), new Object[0]);
        }
        long millis = TimeUnit.NANOSECONDS.toMillis(surfaceTexture.getTimestamp());
        if (millis == 0) {
            millis = TimeUnit.MICROSECONDS.toMillis(ahVar.f43832d.presentationTimeUs);
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() <= 22) {
            int width = a10.getWidth();
            int height = a10.getHeight();
            com.tencent.liteav.videobase.frame.j jVar = ahVar.f43854n;
            if (jVar != null) {
                Size size2 = new Size(jVar.f43460a, jVar.f43461b);
                if (size2.width != width || size2.height != height) {
                    ahVar.f43854n.a();
                    ahVar.f43854n = null;
                }
            }
            if (ahVar.f43854n == null) {
                ahVar.f43854n = new com.tencent.liteav.videobase.frame.j(width, height);
            }
            if (ahVar.f43855o == null) {
                ahVar.f43855o = new com.tencent.liteav.videobase.frame.e();
            }
            OpenGlUtils.glViewport(0, 0, width, height);
            com.tencent.liteav.videobase.frame.d a11 = ahVar.f43855o.a(width, height);
            ahVar.f43854n.a(a10, GLConstants.GLScaleType.CENTER_CROP, a11);
            PixelFrame a12 = a11.a(ahVar.f43849i.getEglContext());
            GLES20.glFinish();
            a11.release();
            a10.release();
            a10 = a12;
        }
        a10.setTimestamp(millis);
        ahVar.f43830b.a(a10, false);
        bVar.release();
        a10.release();
    }

    private boolean b(Object obj) {
        if (this.f43849i != null) {
            LiteavLog.w(this.f43829a, "Decoder already started.");
            return true;
        }
        EGLCore eGLCore = new EGLCore();
        this.f43849i = eGLCore;
        try {
            eGLCore.initialize(obj, null, 128, 128);
            this.f43849i.makeCurrent();
            this.f43850j = OpenGlUtils.generateTextureOES();
            this.f43851k = new com.tencent.liteav.videobase.frame.l();
            try {
                this.f43852l = new SurfaceTexture(this.f43850j);
                this.f43853m = new Surface(this.f43852l);
                this.f43852l.setOnFrameAvailableListener(this);
                LiteavLog.i(this.f43835g.a("initGL"), this.f43829a, "initialize gl components", new Object[0]);
                return true;
            } catch (Surface.OutOfResourcesException e2) {
                LiteavLog.e(this.f43835g.a("surface"), this.f43829a, "create SurfaceTexture failed.", e2);
                h.c cVar = h.c.WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE;
                ad.b bVar = this.f43830b;
                if (bVar != null) {
                    bVar.a(cVar, "VideoDecode: insufficient resource, Start decoder failed:" + e2.getMessage());
                }
                this.f43834f.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_HW_DECODE_START_ERROR_TYPE, Integer.valueOf(cVar.mValue));
                return false;
            }
        } catch (com.tencent.liteav.videobase.egl.f e10) {
            LiteavLog.e(this.f43835g.a("initGL"), this.f43829a, "create EGLCore failed.", e10);
            h.c cVar2 = h.c.WARNING_VIDEO_DECODE_EGL_CORE_CREATE_FAILED;
            ad.b bVar2 = this.f43830b;
            if (bVar2 != null) {
                bVar2.a(cVar2, "VideoDecode: create EGLCore failed errorCode:" + e10.getMessage());
            }
            this.f43834f.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_HW_DECODE_START_ERROR_TYPE, Integer.valueOf(cVar2.mValue));
            return false;
        }
    }
}
