package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k extends RenderViewHelperInterface {

    /* renamed from: a, reason: collision with root package name */
    public TextureView f44097a;

    /* renamed from: b, reason: collision with root package name */
    private final String f44098b;

    /* renamed from: c, reason: collision with root package name */
    private final CustomHandler f44099c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f44100d;

    /* renamed from: e, reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f44101e;

    /* renamed from: f, reason: collision with root package name */
    private final TXCloudVideoView f44102f;

    /* renamed from: g, reason: collision with root package name */
    private final Size f44103g;

    /* renamed from: h, reason: collision with root package name */
    private GLConstants.GLScaleType f44104h;

    /* renamed from: i, reason: collision with root package name */
    private SurfaceTexture f44105i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f44106j;

    /* renamed from: k, reason: collision with root package name */
    private Matrix f44107k;

    /* renamed from: l, reason: collision with root package name */
    private SurfaceTexture f44108l;

    /* renamed from: m, reason: collision with root package name */
    private final Size f44109m;

    /* renamed from: n, reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f44110n;

    /* renamed from: com.tencent.liteav.videoconsumer.renderer.k$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            LiteavLog.i(k.this.f44100d.a("surfaceCreate"), k.this.f44098b, "onSurfaceTextureAvailable, size: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
            k.this.a(k.a(k.this, surfaceTexture));
            k kVar = k.this;
            kVar.b(kVar.f44097a);
            k.this.f44109m.width = i10;
            k.this.f44109m.height = i11;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            LiteavLog.i(k.this.f44098b, "onSurfaceTextureDestroyed");
            k.this.a();
            if (k.this.f44097a == null) {
                return true;
            }
            k.this.f44105i = surfaceTexture;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            LiteavLog.i(k.this.f44100d.a("surfaceSizeChanged"), k.this.f44098b, "onSurfaceTextureSizeChanged, size: %dx%d", Integer.valueOf(i10), Integer.valueOf(i11));
            k.this.a(surfaceTexture);
            k kVar = k.this;
            kVar.b(kVar.f44097a);
            if ((k.this.f44109m.width > k.this.f44109m.height) != (i10 > i11)) {
                k.g(k.this);
            }
            k.this.f44109m.width = i10;
            k.this.f44109m.height = i11;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (k.this.f44106j) {
                return;
            }
            k.j(k.this);
            k.this.f44099c.post(q.a(this));
        }
    }

    public k(TXCloudVideoView tXCloudVideoView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.f44098b = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f44099c = customHandler;
        this.f44100d = new com.tencent.liteav.base.b.b();
        this.f44103g = new Size();
        this.f44104h = null;
        this.f44105i = null;
        this.f44106j = false;
        this.f44107k = new Matrix();
        this.f44109m = new Size();
        this.f44110n = new AnonymousClass1();
        this.f44101e = renderViewListener;
        this.f44102f = tXCloudVideoView;
        if (tXCloudVideoView == null) {
            LiteavLog.w(str, "txCloudVideoView is null.");
            return;
        }
        LiteavLog.i(str, "construct,txCloudVideoView=".concat(String.valueOf(tXCloudVideoView)));
        TextureView textureView = new TextureView(tXCloudVideoView.getContext());
        this.f44097a = textureView;
        customHandler.post(l.a(this, tXCloudVideoView, textureView));
    }

    public static /* synthetic */ void a(k kVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        TXCCloudVideoViewMethodInvoker.addView(tXCloudVideoView, textureView);
        kVar.a(textureView);
    }

    public static /* synthetic */ void g(k kVar) {
        TextureView textureView;
        Bitmap bitmap;
        if (kVar.f44101e == null || (textureView = kVar.f44097a) == null || (bitmap = textureView.getBitmap()) == null) {
            return;
        }
        kVar.f44101e.onRequestRedraw(bitmap);
    }

    public static /* synthetic */ boolean j(k kVar) {
        kVar.f44106j = true;
        return true;
    }

    public static /* synthetic */ void l(k kVar) {
        TextureView textureView;
        TXCloudVideoView tXCloudVideoView = kVar.f44102f;
        if (tXCloudVideoView == null || (textureView = kVar.f44097a) == null) {
            return;
        }
        TXCCloudVideoViewMethodInvoker.removeDeprecatedViews(tXCloudVideoView, textureView);
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.f44099c.post(o.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final Matrix getTransformMatrix(int i10, int i11) {
        Matrix matrix = new Matrix(this.f44107k);
        matrix.postScale(1.0f, -1.0f, i10 / 2.0f, i11 / 2.0f);
        return matrix;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isUsingTextureView() {
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void release(boolean z10) {
        this.f44099c.post(n.a(this, z10));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final synchronized void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i10, int i11, boolean z10) {
        if (this.f44104h == gLScaleType) {
            Size size = this.f44103g;
            if (i10 == size.width && i11 == size.height) {
                return;
            }
        }
        this.f44104h = gLScaleType;
        this.f44103g.set(i10, i11);
        this.f44099c.runOrPost(p.a(this));
    }

    public static /* synthetic */ void b(k kVar) {
        TextureView textureView = kVar.f44097a;
        if (textureView == null) {
            LiteavLog.i(kVar.f44098b, "view is not available when textureView is null");
            return;
        }
        if (textureView.isAvailable() && kVar.f44097a.getWidth() != 0 && kVar.f44097a.getHeight() != 0 && kVar.f44097a.isShown()) {
            return;
        }
        String str = kVar.f44098b;
        TextureView textureView2 = kVar.f44097a;
        LiteavLog.i(str, "%s is not available when surface available:%b, isShown:%b", textureView2, Boolean.valueOf(textureView2.isAvailable()), Boolean.valueOf(kVar.f44097a.isShown()));
    }

    public static /* synthetic */ void a(k kVar, boolean z10) {
        LiteavLog.i(kVar.f44098b, "release,mTextureView=" + ((Object) kVar.f44097a));
        if (kVar.f44097a == null) {
            return;
        }
        kVar.a();
        if (kVar.f44097a.getSurfaceTextureListener() == kVar.f44110n) {
            kVar.f44097a.setSurfaceTextureListener(null);
        }
        SurfaceTexture surfaceTexture = kVar.f44105i;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            kVar.f44105i = null;
        }
        if (kVar.f44102f != null) {
            LiteavLog.i(kVar.f44098b, "clearLastImage=" + z10 + ",mHasFirstFrameRendered=" + kVar.f44106j);
            TXCCloudVideoViewMethodInvoker.removeView(kVar.f44102f, kVar.f44097a, z10 | (kVar.f44106j ^ true));
        }
        kVar.f44097a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(TextureView textureView) {
        double d10;
        if (textureView == null) {
            return;
        }
        Size size = new Size(textureView.getWidth(), textureView.getHeight());
        if (this.f44103g.isValid() && size.isValid()) {
            double aspectRatio = size.aspectRatio();
            double aspectRatio2 = this.f44103g.aspectRatio();
            double d11 = 1.0d;
            if (aspectRatio2 < aspectRatio) {
                GLConstants.GLScaleType gLScaleType = this.f44104h;
                if (gLScaleType != GLConstants.GLScaleType.FIT_CENTER) {
                    if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
                        d10 = aspectRatio / aspectRatio2;
                    }
                    d10 = 1.0d;
                }
                double d12 = aspectRatio2 / aspectRatio;
                d10 = 1.0d;
                d11 = d12;
            } else {
                GLConstants.GLScaleType gLScaleType2 = this.f44104h;
                if (gLScaleType2 != GLConstants.GLScaleType.FIT_CENTER) {
                    if (gLScaleType2 == GLConstants.GLScaleType.CENTER_CROP) {
                        double d122 = aspectRatio2 / aspectRatio;
                        d10 = 1.0d;
                        d11 = d122;
                    }
                    d10 = 1.0d;
                }
                d10 = aspectRatio / aspectRatio2;
            }
            Matrix matrix = new Matrix();
            matrix.setScale((float) d11, (float) d10, size.width / 2.0f, size.height / 2.0f);
            if (!matrix.equals(textureView.getTransform(new Matrix()))) {
                textureView.setTransform(matrix);
                textureView.postInvalidate();
                LiteavLog.i(this.f44100d.a("updateTextureViewMatrix"), this.f44098b, "view: %s, scaleX: %.2f, scaleY: %.2f, frame: %s, view: %s", textureView, Double.valueOf(d11), Double.valueOf(d10), this.f44103g, size);
            }
            this.f44107k = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView == null) {
            LiteavLog.w(this.f44098b, "setup,textureView is null.");
            return;
        }
        if (textureView.isAvailable()) {
            Size size = new Size(textureView.getWidth(), textureView.getHeight());
            LiteavLog.i(this.f44098b, "setup,textureView=" + ((Object) textureView) + "," + ((Object) size));
            a(textureView.getSurfaceTexture());
        } else {
            LiteavLog.i(this.f44098b, "setup,textureView not available.");
        }
        textureView.setSurfaceTextureListener(this.f44110n);
        b(textureView);
    }

    public k(TextureView textureView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.f44098b = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f44099c = customHandler;
        this.f44100d = new com.tencent.liteav.base.b.b();
        this.f44103g = new Size();
        this.f44104h = null;
        this.f44105i = null;
        this.f44106j = false;
        this.f44107k = new Matrix();
        this.f44109m = new Size();
        this.f44110n = new AnonymousClass1();
        this.f44101e = renderViewListener;
        this.f44102f = null;
        if (textureView == null) {
            LiteavLog.w(str, "textureView is null.");
            return;
        }
        LiteavLog.i(str, "construct,textureView=".concat(String.valueOf(textureView)));
        this.f44097a = textureView;
        customHandler.post(m.a(this, textureView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        if (this.f44108l == surfaceTexture) {
            return;
        }
        this.f44108l = surfaceTexture;
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f44101e;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(new Surface(surfaceTexture), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f44108l = null;
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f44101e;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }

    public static /* synthetic */ SurfaceTexture a(k kVar, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = kVar.f44105i;
        if (surfaceTexture2 == null || kVar.f44097a == null || com.tencent.liteav.base.util.i.a(surfaceTexture, surfaceTexture2)) {
            return surfaceTexture;
        }
        kVar.f44097a.setSurfaceTexture(kVar.f44105i);
        SurfaceTexture surfaceTexture3 = kVar.f44105i;
        kVar.f44105i = null;
        return surfaceTexture3;
    }
}
