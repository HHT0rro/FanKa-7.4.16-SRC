package com.tencent.liteav.videoproducer.capture;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.Locale;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class VirtualCamera extends au {

    /* renamed from: f, reason: collision with root package name */
    private PixelFrame f44213f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.liteav.base.util.w f44214g;

    /* renamed from: h, reason: collision with root package name */
    private VirtualCameraParams f44215h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f44216i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f44217j;

    /* renamed from: k, reason: collision with root package name */
    private final w.a f44218k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class VirtualCameraParams extends CaptureSourceInterface.CaptureParams {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f44220a;

        public VirtualCameraParams() {
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof VirtualCameraParams) {
                return super.equals(obj) && com.tencent.liteav.base.util.i.a(this.f44220a, ((VirtualCameraParams) obj).f44220a);
            }
            return false;
        }

        @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
        @NonNull
        public String toString() {
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[4];
            objArr[0] = super.toString();
            objArr[1] = Boolean.valueOf(this.f44220a != null);
            Bitmap bitmap = this.f44220a;
            objArr[2] = Integer.valueOf(bitmap != null ? bitmap.getWidth() : 0);
            Bitmap bitmap2 = this.f44220a;
            objArr[3] = Integer.valueOf(bitmap2 != null ? bitmap2.getHeight() : 0);
            return String.format(locale, "%s, hasBitmap:%b, w*h:%d*%d", objArr);
        }

        public VirtualCameraParams(VirtualCameraParams virtualCameraParams) {
            super(virtualCameraParams);
            this.f44220a = virtualCameraParams.f44220a;
        }
    }

    public VirtualCamera(@NonNull Looper looper, @NonNull IVideoReporter iVideoReporter) {
        super(looper, iVideoReporter);
        this.f44216i = true;
        this.f44217j = false;
        this.f44218k = new w.a() { // from class: com.tencent.liteav.videoproducer.capture.VirtualCamera.1
            @Override // com.tencent.liteav.base.util.w.a
            public final void onTimeout() {
                VirtualCamera virtualCamera = VirtualCamera.this;
                CaptureSourceInterface.CaptureSourceListener captureSourceListener = virtualCamera.f44318d;
                if (captureSourceListener == null || !virtualCamera.c()) {
                    return;
                }
                if (VirtualCamera.this.f44213f != null) {
                    VirtualCamera.this.f44213f.setTimestamp(TimeUtil.a());
                }
                VirtualCamera virtualCamera2 = VirtualCamera.this;
                captureSourceListener.onFrameAvailable(virtualCamera2, virtualCamera2.f44213f);
            }
        };
    }

    private void e() {
        if (this.f44317c == null) {
            LiteavLog.e("VirtualCameraImpl", "Start virtual camera, mEGLCore is null!");
            return;
        }
        if (!this.f44216i) {
            LiteavLog.e("VirtualCameraImpl", "virtual camera is started.");
            return;
        }
        this.f44216i = false;
        PixelFrame pixelFrame = new PixelFrame();
        this.f44213f = pixelFrame;
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_2D);
        this.f44213f.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        this.f44213f.setGLContext(this.f44317c.getEglContext());
        this.f44213f.setWidth(Math.max((this.f44215h.f44182c / 2) * 2, 2));
        this.f44213f.setHeight(Math.max((this.f44215h.f44183d / 2) * 2, 2));
        this.f44213f.setTextureId(-1);
        VirtualCameraParams virtualCameraParams = this.f44215h;
        if (virtualCameraParams.f44182c == 64 && virtualCameraParams.f44183d == 64 && virtualCameraParams.f44220a == null) {
            FrameMetaData frameMetaData = new FrameMetaData();
            frameMetaData.setIsBlackFrame(true);
            this.f44213f.setMetaData(frameMetaData);
        }
        Bitmap bitmap = null;
        try {
            bitmap = a(this.f44215h.f44220a);
        } catch (Throwable th) {
            LiteavLog.e("VirtualCameraImpl", "Create new bitmap from bitmap fail ", th);
        }
        if (bitmap != null) {
            this.f44213f.setWidth(bitmap.getWidth());
            this.f44213f.setHeight(bitmap.getHeight());
            this.f44213f.setTextureId(OpenGlUtils.loadTexture(bitmap, -1, false));
        }
        LiteavLog.i("VirtualCameraImpl", "Start virtual camera, bitmap:" + this.f44213f.getWidth() + LanguageTag.PRIVATEUSE + this.f44213f.getHeight());
        if (bitmap != null && bitmap != this.f44215h.f44220a) {
            bitmap.recycle();
        }
        this.f44214g = new com.tencent.liteav.base.util.w(this.f44315a.getLooper(), this.f44218k);
        this.f44214g.a(0, 1000 / Math.max(this.f44215h.f44181b, 1));
    }

    private void f() {
        LiteavLog.i("VirtualCameraImpl", "Stop virtual camera");
        com.tencent.liteav.base.util.w wVar = this.f44214g;
        if (wVar != null) {
            wVar.a();
            this.f44214g = null;
        }
        PixelFrame pixelFrame = this.f44213f;
        if (pixelFrame != null) {
            OpenGlUtils.deleteTexture(pixelFrame.getTextureId());
            this.f44213f = null;
        }
        this.f44216i = true;
    }

    @Override // com.tencent.liteav.videoproducer.capture.au
    public final void b() {
        f();
        this.f44217j = false;
        this.f44316b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_STOP_SUCCESS, (Object) null, "Stop virtual camera success");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void pause() {
        f();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void resume() {
        e();
        if (this.f44217j) {
            this.f44217j = false;
            this.f44316b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_SIZE_CHANGE_SUCCESS, (Object) null, "Start virtual camera success params:" + ((Object) this.f44215h));
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public final void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        this.f44215h = new VirtualCameraParams((VirtualCameraParams) captureParams);
        if (this.f44216i) {
            this.f44217j = true;
            return;
        }
        f();
        e();
        this.f44316b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_SIZE_CHANGE_SUCCESS, (Object) null, "Start virtual camera success params:" + ((Object) this.f44215h));
    }

    @Override // com.tencent.liteav.videoproducer.capture.au
    public final void a(CaptureSourceInterface.CaptureParams captureParams) {
        this.f44215h = new VirtualCameraParams((VirtualCameraParams) captureParams);
        e();
        this.f44316b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_START_SUCCESS, (Object) null, "Start virtual camera success params:" + ((Object) this.f44215h));
    }

    private Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max((this.f44215h.f44182c / 2) * 2, 2), Math.max((this.f44215h.f44183d / 2) * 2, 2), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawARGB(255, 0, 0, 0);
            return createBitmap;
        }
        if (bitmap.getWidth() % 2 != 1 && bitmap.getHeight() % 2 != 1) {
            return bitmap;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(Math.max((bitmap.getWidth() / 2) * 2, 2), Math.max((bitmap.getHeight() / 2) * 2, 2), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap2;
    }
}
