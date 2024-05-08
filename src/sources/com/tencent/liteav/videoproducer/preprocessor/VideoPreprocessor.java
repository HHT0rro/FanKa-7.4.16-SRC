package com.tencent.liteav.videoproducer.preprocessor;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.a;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor;
import com.tencent.liteav.videoproducer.preprocessor.h;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoPreprocessor implements BeautyProcessor.a {
    private static final String TAG = "VideoPreprocessor";
    private final com.tencent.liteav.videobase.utils.a mAverageCostCalculator;
    private final h mPreprocessor;
    private final IVideoReporter mVideoReporter;
    private CustomHandler mWorkHandler;
    private final CyclicBarrier mLoadFrameCyclicBarrier = new CyclicBarrier(2);
    private final SparseArray<com.tencent.liteav.videobase.videobase.a> mConvertParamsList = new SparseArray<>();
    private float mLookupMixLevel = 0.5f;
    private long mTotalFrameCount = 0;
    private long mLastProcessTimestamp = 0;
    private CaptureSourceInterface.SourceType mSourceType = CaptureSourceInterface.SourceType.NONE;

    public VideoPreprocessor(@NonNull Context context, @NonNull BeautyProcessor beautyProcessor, @NonNull IVideoReporter iVideoReporter) {
        this.mPreprocessor = new h(context, beautyProcessor, iVideoReporter);
        this.mVideoReporter = iVideoReporter;
        beautyProcessor.setBeautyManagerStatusListener(this);
        com.tencent.liteav.beauty.a.a(iVideoReporter);
        this.mAverageCostCalculator = new com.tencent.liteav.videobase.utils.a("preprocess", new a.InterfaceC0641a(this) { // from class: com.tencent.liteav.videoproducer.preprocessor.q

            /* renamed from: a, reason: collision with root package name */
            private final VideoPreprocessor f44842a;

            {
                this.f44842a = this;
            }
        });
    }

    private void applyMetaData(PixelFrame pixelFrame) {
        FrameMetaData metaData = pixelFrame.getMetaData();
        if (metaData == null) {
            return;
        }
        pixelFrame.setRotation(Rotation.NORMAL);
        pixelFrame.postRotate(metaData.getPreprocessorRotation());
        pixelFrame.setMirrorHorizontal(metaData.isPreprocessorMirrorHorizontal());
        pixelFrame.setMirrorVertical(metaData.isPreprocessorMirrorVertical());
        Size renderSize = metaData.getRenderSize();
        if (renderSize.isValid()) {
            this.mPreprocessor.a(renderSize.width, renderSize.height);
        }
    }

    private GLConstants.GLScaleType getScaleTypeFromMetaData(PixelFrame pixelFrame) {
        FrameMetaData metaData = pixelFrame.getMetaData();
        if (metaData == null) {
            return this.mSourceType == CaptureSourceInterface.SourceType.SCREEN ? GLConstants.GLScaleType.FIT_CENTER : GLConstants.GLScaleType.CENTER_CROP;
        }
        return metaData.getPreprocessorScaleType();
    }

    public static /* synthetic */ void lambda$processFrame$2(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j10) {
        PixelFrame a10;
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        videoPreprocessor.applyMetaData(pixelFrame2);
        h hVar = videoPreprocessor.mPreprocessor;
        GLConstants.GLScaleType scaleTypeFromMetaData = videoPreprocessor.getScaleTypeFromMetaData(pixelFrame2);
        pixelFrame2.getGLContext();
        Object gLContext = pixelFrame2.getGLContext();
        if (!CommonUtil.equals(hVar.f44792l, gLContext)) {
            hVar.f44792l = gLContext;
            hVar.a();
            LiteavLog.i(hVar.f44781a, "set unique eglcore: %s", gLContext);
        }
        try {
            if (hVar.f44791k == null) {
                Object gLContext2 = pixelFrame2.getGLContext();
                LiteavLog.i(hVar.f44788h.a("initGL"), hVar.f44781a, "initialize internal, eglContextFromPixelFrame: %s", gLContext2);
                EGLCore eGLCore = new EGLCore();
                hVar.f44791k = eGLCore;
                eGLCore.initialize(gLContext2, null, 128, 128);
                hVar.f44791k.makeCurrent();
                com.tencent.liteav.videobase.frame.e eVar = new com.tencent.liteav.videobase.frame.e();
                hVar.f44794n = eVar;
                hVar.f44796p.a(eVar);
                hVar.f44786f.initialize(hVar.f44794n);
                hVar.b();
            }
            hVar.f44791k.makeCurrent();
            hVar.f44785e.a();
            if (hVar.f44793m == null) {
                hVar.f44793m = new com.tencent.liteav.videobase.frame.j(hVar.f44789i, hVar.f44790j);
            }
            OpenGlUtils.glViewport(0, 0, hVar.f44789i, hVar.f44790j);
            if (pixelFrame2.getHeight() == hVar.f44790j && pixelFrame2.getWidth() == hVar.f44789i && pixelFrame2.getRotation() == Rotation.NORMAL && !pixelFrame2.isMirrorVertical() && !pixelFrame2.isMirrorHorizontal() && pixelFrame2.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D) {
                pixelFrame2.retain();
                a10 = pixelFrame2;
            } else {
                com.tencent.liteav.videobase.frame.d a11 = hVar.f44794n.a(hVar.f44789i, hVar.f44790j);
                hVar.f44793m.a(pixelFrame2, scaleTypeFromMetaData, a11);
                a10 = a11.a(hVar.f44791k.getEglContext());
                a11.release();
            }
            hVar.f44787g.setTimestamp(pixelFrame2.getTimestamp());
            com.tencent.liteav.videobase.frame.d a12 = hVar.f44794n.a(hVar.f44789i, hVar.f44790j);
            a12.a(pixelFrame2.getMetaData());
            a12.a(pixelFrame2.getProducerChainTimestamp());
            a12.a(pixelFrame2.getConsumerChainTimestamp());
            hVar.f44787g.onDraw(a10.getTextureId(), a12, hVar.f44783c, hVar.f44784d);
            a10.release();
            a12.release();
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError == 0) {
                    break;
                }
                LiteavLog.e(hVar.f44788h.a("processFrame"), hVar.f44781a, "GL error occurred when preprocess frame, error :" + GLUtils.getEGLErrorString(glGetError), new Object[0]);
            }
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            LiteavLog.e(hVar.f44788h.a("make"), hVar.f44781a, "initializeEGL failed. " + e2.getMessage(), new Object[0]);
            hVar.a();
        }
        videoPreprocessor.mVideoReporter.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_PREPROCESS_TIME, Long.valueOf(SystemClock.elapsedRealtime() - j10));
        videoPreprocessor.reportProcessFrameRate();
        pixelFrame.release();
    }

    public static /* synthetic */ void lambda$registerVideoProcessedListener$3(VideoPreprocessor videoPreprocessor, int i10, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z10, ah ahVar) {
        h hVar = videoPreprocessor.mPreprocessor;
        h.c cVar = new h.c(i10, aVar, pixelBufferType, pixelFormatType, ahVar);
        if (!z10) {
            h.a(cVar, hVar.f44798r);
        } else {
            h.a(cVar, hVar.f44799s);
        }
        hVar.c();
        LiteavLog.i(hVar.f44781a, "register listener, identity:%d, bufferType:%s, formatType:%s, withWatermark:%b, listener:%s", Integer.valueOf(i10), pixelBufferType, pixelFormatType, Boolean.valueOf(z10), ahVar);
        videoPreprocessor.mConvertParamsList.put(i10, aVar);
        videoPreprocessor.recalculateProcessSizeInternal();
    }

    public static /* synthetic */ void lambda$setFilterMixLevel$7(VideoPreprocessor videoPreprocessor, float f10) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.f44785e.a(m.a(hVar, f10));
    }

    public static /* synthetic */ void lambda$setGaussianBlurLevel$12(VideoPreprocessor videoPreprocessor, float f10) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.f44785e.a(l.a(hVar, f10 / 4.0f));
    }

    public static /* synthetic */ void lambda$setGreenScreenFile$5(VideoPreprocessor videoPreprocessor, String str, boolean z10) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.f44785e.a(o.a(hVar, str, z10));
    }

    public static /* synthetic */ void lambda$setGreenScreenParam$6(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z10) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.f44785e.a(p.a(hVar, gLScaleType, z10));
    }

    public static /* synthetic */ void lambda$setInterceptorBeforeWatermark$14(VideoPreprocessor videoPreprocessor, com.tencent.liteav.videobase.a.a aVar) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.f44785e.a(i.a(hVar, aVar));
    }

    public static /* synthetic */ void lambda$setWatermark$10(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f10, float f11, float f12) {
        h hVar = videoPreprocessor.mPreprocessor;
        LiteavLog.d(hVar.f44781a, "setWatermark xOffsetRatio: %.2f, yOffsetRatio: %.2f, widthRatio: %.2f", Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12));
        hVar.f44785e.a(j.a(hVar, bitmap, f10, f11, f12));
    }

    public static /* synthetic */ void lambda$setWatermarkList$11(VideoPreprocessor videoPreprocessor, List list) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.f44785e.a(k.a(hVar, list));
    }

    public static /* synthetic */ void lambda$unregisterVideoProcessedListener$4(VideoPreprocessor videoPreprocessor, int i10, ah ahVar) {
        h hVar = videoPreprocessor.mPreprocessor;
        h.c a10 = h.a(i10, ahVar, hVar.f44798r);
        if (a10 != null || (a10 = h.a(i10, ahVar, hVar.f44799s)) != null) {
            hVar.f44796p.a(i10, a10);
            com.tencent.liteav.videobase.videobase.d dVar = hVar.f44797q;
            if (dVar != null) {
                dVar.a(i10, a10);
            }
            LiteavLog.i(hVar.f44781a, "unregister listener: identity: %d, listener: %s", Integer.valueOf(i10), ahVar);
        }
        videoPreprocessor.mConvertParamsList.remove(i10);
        videoPreprocessor.recalculateProcessSizeInternal();
    }

    private void recalculateProcessSizeInternal() {
        if (this.mConvertParamsList.size() == 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < this.mConvertParamsList.size(); i12++) {
            com.tencent.liteav.videobase.videobase.a valueAt = this.mConvertParamsList.valueAt(i12);
            Rotation rotation = valueAt.f43560c;
            boolean z10 = rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270;
            int i13 = z10 ? valueAt.f43559b : valueAt.f43558a;
            int i14 = z10 ? valueAt.f43558a : valueAt.f43559b;
            if (i10 * i14 != i11 * i13) {
                LiteavLog.w(TAG, "video preprocessor has different w/h ratio: %dx%d vs %dx%d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i13), Integer.valueOf(i14));
            }
            if (i13 * i14 > i10 * i11) {
                i11 = i14;
                i10 = i13;
            }
        }
        this.mPreprocessor.a(i10, i11);
    }

    private void reportProcessFrameRate() {
        this.mTotalFrameCount++;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime > 2000 + this.mLastProcessTimestamp) {
            this.mVideoReporter.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_PREPROCESS_FPS_IN, Double.valueOf((this.mTotalFrameCount * 1000.0d) / (elapsedRealtime - r2)));
            this.mTotalFrameCount = 0L;
            this.mLastProcessTimestamp = elapsedRealtime;
        }
    }

    public BeautyProcessor getBeautyProcessor() {
        return this.mPreprocessor.f44786f;
    }

    public void initialize() {
        LiteavLog.i(TAG, "initialize");
        HandlerThread handlerThread = new HandlerThread("video-preprocessor");
        handlerThread.start();
        this.mWorkHandler = new CustomHandler(handlerThread.getLooper());
    }

    @Override // com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor.a
    public void onBeautyStatsChanged(String str) {
        this.mVideoReporter.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_PREPROCESS_BEAUTY_SETTINGS, str);
    }

    public void postTaskToGlThread(Runnable runnable) {
        this.mWorkHandler.post(runnable);
    }

    public synchronized boolean processFrame(PixelFrame pixelFrame) {
        boolean post;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        pixelFrame.retain();
        pixelFrame.getProducerChainTimestamp().setPreprocessTimestamp(TimeUtil.a());
        post = this.mWorkHandler.post(aa.a(this, pixelFrame, elapsedRealtime));
        if (!post) {
            pixelFrame.release();
        }
        return post;
    }

    public void registerVideoProcessedListener(int i10, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z10, ah ahVar) {
        GLConstants.PixelBufferType pixelBufferType2 = GLConstants.PixelBufferType.TEXTURE_OES;
        if (pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D) {
            GLConstants.PixelFormatType pixelFormatType2 = GLConstants.PixelFormatType.RGBA;
        }
        this.mWorkHandler.post(ab.a(this, i10, aVar, pixelBufferType, pixelFormatType, z10, ahVar));
    }

    public void runTaskInGlThreadAndWaitDone(Runnable runnable) {
        this.mWorkHandler.runAndWaitDone(runnable);
    }

    @CalledByNative
    public void setFilterGroupImages(float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        postTaskToGlThread(r.a(this, f10, bitmap, f11, bitmap2, f12));
    }

    @CalledByNative
    public void setFilterMixLevel(float f10) {
        LiteavLog.i(TAG, "setFilterMixLevel: ".concat(String.valueOf(f10)));
        this.mLookupMixLevel = f10;
        this.mWorkHandler.post(af.a(this, f10));
    }

    public void setGaussianBlurLevel(float f10) {
        this.mWorkHandler.post(u.a(this, f10));
    }

    @CalledByNative
    public boolean setGreenScreenFile(String str, boolean z10) {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 18) {
            return false;
        }
        LiteavLog.i(TAG, "setGreenScreenFile: path=" + str + ", isLoop=" + z10);
        this.mWorkHandler.post(ad.a(this, str, z10));
        return true;
    }

    public void setGreenScreenParam(GLConstants.GLScaleType gLScaleType, boolean z10) {
        this.mWorkHandler.post(ae.a(this, gLScaleType, z10));
    }

    public void setInterceptorBeforeWatermark(com.tencent.liteav.videobase.a.a aVar) {
        this.mWorkHandler.post(y.a(this, aVar));
    }

    @CalledByNative
    public void setLookupImage(Bitmap bitmap) {
        LiteavLog.i(TAG, "setLookupImage: ".concat(String.valueOf(bitmap)));
        this.mWorkHandler.post(ag.a(this, bitmap));
    }

    public void setSourceType(CaptureSourceInterface.SourceType sourceType) {
        this.mWorkHandler.post(z.a(this, sourceType));
    }

    public void setWatermark(Bitmap bitmap, float f10, float f11, float f12) {
        this.mWorkHandler.post(s.a(this, bitmap, f10, f11, f12));
    }

    public void setWatermarkList(List<com.tencent.liteav.beauty.b.o> list) {
        this.mWorkHandler.post(t.a(this, list));
    }

    public void uninitialize() {
        LiteavLog.i(TAG, "uninitialize");
        this.mAverageCostCalculator.a();
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            h hVar = this.mPreprocessor;
            hVar.getClass();
            customHandler.post(w.a(hVar));
            customHandler.quitLooper();
        }
    }

    public void uninitializeGLComponents() {
        CustomHandler customHandler = this.mWorkHandler;
        h hVar = this.mPreprocessor;
        hVar.getClass();
        customHandler.post(x.a(hVar));
    }

    public void unregisterVideoProcessedListener(int i10, ah ahVar) {
        this.mWorkHandler.post(ac.a(this, i10, ahVar));
    }

    public void updateHomeOrientation(int i10) {
        this.mWorkHandler.post(v.a(this, i10));
    }
}
