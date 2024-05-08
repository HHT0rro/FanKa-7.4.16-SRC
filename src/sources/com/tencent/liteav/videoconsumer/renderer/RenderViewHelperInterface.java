package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.rtmp.ui.TXCloudVideoView;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class RenderViewHelperInterface {
    private static final String TAG = "RenderViewHelperInterface";

    /* renamed from: com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44032a;

        static {
            int[] iArr = new int[DisplayTarget.a.values().length];
            f44032a = iArr;
            try {
                iArr[DisplayTarget.a.SURFACEVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44032a[DisplayTarget.a.TEXTUREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44032a[DisplayTarget.a.SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44032a[DisplayTarget.a.TXCLOUDVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface RenderViewListener {
        void onRequestRedraw(@NonNull Bitmap bitmap);

        void onSurfaceChanged(Surface surface, boolean z10);

        void onSurfaceDestroy();
    }

    @CalledByNative
    public static RenderViewHelperInterface create(DisplayTarget displayTarget, RenderViewListener renderViewListener) {
        Surface surface;
        TextureView textureView;
        SurfaceView surfaceView;
        TXCloudVideoView tXCloudVideoView;
        if (displayTarget != null && displayTarget.getType() != null) {
            int i10 = AnonymousClass1.f44032a[displayTarget.getType().ordinal()];
            if (i10 == 1) {
                surface = null;
                textureView = null;
                surfaceView = displayTarget.getSurfaceView();
                tXCloudVideoView = null;
            } else if (i10 != 2) {
                if (i10 == 3) {
                    surface = displayTarget.getSurface();
                    tXCloudVideoView = null;
                } else if (i10 != 4) {
                    surface = null;
                    tXCloudVideoView = null;
                } else {
                    TXCloudVideoView tXCloudVideoView2 = displayTarget.getTXCloudVideoView();
                    if (tXCloudVideoView2 == null) {
                        LiteavLog.w(TAG, "txCloudVideoView is null.");
                        surfaceView = null;
                        textureView = null;
                        tXCloudVideoView = tXCloudVideoView2;
                        surface = null;
                    } else {
                        SurfaceView surfaceView2 = tXCloudVideoView2.getSurfaceView();
                        textureView = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView2);
                        surfaceView = surfaceView2;
                        tXCloudVideoView = tXCloudVideoView2;
                        surface = null;
                    }
                }
                surfaceView = tXCloudVideoView;
                textureView = surfaceView;
            } else {
                surface = null;
                tXCloudVideoView = null;
                textureView = displayTarget.getTextureView();
                surfaceView = null;
            }
            if (surfaceView != null) {
                return new f(surfaceView, renderViewListener);
            }
            if (textureView != null) {
                return new k(textureView, renderViewListener);
            }
            if (surface != null) {
                return new b(surface, renderViewListener);
            }
            if (tXCloudVideoView != null) {
                return new k(tXCloudVideoView, renderViewListener);
            }
            LiteavLog.w(TAG, "RenderViewHelper not created. displayTarget=".concat(String.valueOf(displayTarget)));
            return null;
        }
        LiteavLog.w(TAG, "displayTarget or type is null. displayTarget=".concat(String.valueOf(displayTarget)));
        return null;
    }

    @CalledByNative
    public static GLConstants.GLScaleType createScaleType(int i10) {
        return GLConstants.GLScaleType.a(i10);
    }

    @CalledByNative
    public abstract void checkViewAvailability();

    @CalledByNative
    public abstract Matrix getTransformMatrix(int i10, int i11);

    @CalledByNative
    public abstract boolean isUsingTextureView();

    @CalledByNative
    public abstract void release(boolean z10);

    @CalledByNative
    public abstract void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i10, int i11, boolean z10);
}
