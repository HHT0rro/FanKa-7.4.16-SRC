package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends RenderViewHelperInterface {

    /* renamed from: a, reason: collision with root package name */
    private final String f44072a;

    /* renamed from: b, reason: collision with root package name */
    private final CustomHandler f44073b;

    /* renamed from: c, reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f44074c;

    /* renamed from: d, reason: collision with root package name */
    private Surface f44075d;

    public b(Surface surface, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceRenderHelper_" + hashCode();
        this.f44072a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f44073b = customHandler;
        this.f44074c = renderViewListener;
        if (surface == null) {
            LiteavLog.w(str, "surface is null.");
        } else {
            this.f44075d = surface;
            customHandler.post(c.a(this, surface));
        }
    }

    public static /* synthetic */ void a(b bVar, Surface surface) {
        LiteavLog.i(bVar.f44072a, "construct,surface=".concat(String.valueOf(surface)));
        RenderViewHelperInterface.RenderViewListener renderViewListener = bVar.f44074c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    public static /* synthetic */ void b(b bVar) {
        LiteavLog.i(bVar.f44072a, "release,mSurface=" + ((Object) bVar.f44075d));
        if (bVar.f44075d == null) {
            return;
        }
        RenderViewHelperInterface.RenderViewListener renderViewListener = bVar.f44074c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
        bVar.f44075d = null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.f44073b.post(e.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final Matrix getTransformMatrix(int i10, int i11) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, i10 / 2.0f, i11 / 2.0f);
        return matrix;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isUsingTextureView() {
        return false;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void release(boolean z10) {
        this.f44073b.post(d.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i10, int i11, boolean z10) {
    }

    public static /* synthetic */ void a(b bVar) {
        Surface surface = bVar.f44075d;
        if (surface == null) {
            LiteavLog.i(bVar.f44072a, "view is not available when surface is null");
        } else {
            if (surface.isValid()) {
                return;
            }
            LiteavLog.i(bVar.f44072a, "view is not available when %s is not valid", bVar.f44075d);
        }
    }
}
