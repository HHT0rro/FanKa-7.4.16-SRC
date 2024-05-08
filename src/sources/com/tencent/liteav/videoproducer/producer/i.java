package com.tencent.liteav.videoproducer.producer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.FrameMetaData;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.a;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;
import com.tencent.liteav.videoproducer.decider.CaptureResolutionDecider;
import com.tencent.liteav.videoproducer.decider.ResolutionDecider;
import com.tencent.liteav.videoproducer.decider.VideoMirrorDecider;
import com.tencent.liteav.videoproducer.decider.VideoRotationDecider;
import com.tencent.liteav.videoproducer.encoder.EncodeAbilityProvider;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.ba;
import com.tencent.liteav.videoproducer.encoder.bb;
import com.tencent.liteav.videoproducer.encoder.bc;
import com.tencent.liteav.videoproducer.encoder.be;
import com.tencent.liteav.videoproducer.encoder.bf;
import com.tencent.liteav.videoproducer.encoder.bg;
import com.tencent.liteav.videoproducer.encoder.bk;
import com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor;
import com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import com.tencent.liteav.videoproducer.producer.d;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i implements CaptureSourceInterface.CaptureSourceListener, com.tencent.liteav.videoproducer.preprocessor.ah, d.a, com.tencent.rtmp.ui.a, com.tencent.rtmp.ui.b {
    private volatile VideoRenderListener A;
    private a E;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f44993b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final VideoPreprocessor f44994c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final BeautyProcessor f44995d;

    /* renamed from: e, reason: collision with root package name */
    public CustomHandler f44996e;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final com.tencent.liteav.videoconsumer.renderer.s f44998g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final Context f44999h;

    /* renamed from: j, reason: collision with root package name */
    private EGLCore f45001j;

    /* renamed from: l, reason: collision with root package name */
    private ServerVideoProducerConfig f45003l;

    /* renamed from: m, reason: collision with root package name */
    private d f45004m;

    /* renamed from: o, reason: collision with root package name */
    private CaptureSourceInterface f45006o;

    /* renamed from: p, reason: collision with root package name */
    private CaptureSourceInterface.CaptureParams f45007p;

    /* renamed from: q, reason: collision with root package name */
    private PixelFrame f45008q;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    private final ConcurrentHashMap<VideoProducerDef.StreamType, com.tencent.liteav.videoproducer.encoder.ax> f45015x;

    /* renamed from: y, reason: collision with root package name */
    private DisplayTarget f45016y;

    /* renamed from: a, reason: collision with root package name */
    public final String f44992a = "VideoProducer_" + hashCode();

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final com.tencent.liteav.base.b.b f45000i = new com.tencent.liteav.base.b.b();

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f44997f = false;

    /* renamed from: k, reason: collision with root package name */
    private Object f45002k = null;

    /* renamed from: n, reason: collision with root package name */
    private volatile CaptureSourceInterface.SourceType f45005n = CaptureSourceInterface.SourceType.NONE;

    /* renamed from: r, reason: collision with root package name */
    private final CaptureResolutionDecider f45009r = new CaptureResolutionDecider();

    /* renamed from: s, reason: collision with root package name */
    private final VideoRotationDecider f45010s = new VideoRotationDecider();

    /* renamed from: t, reason: collision with root package name */
    private final VideoMirrorDecider f45011t = new VideoMirrorDecider();

    /* renamed from: u, reason: collision with root package name */
    private final ResolutionDecider f45012u = new ResolutionDecider();

    /* renamed from: v, reason: collision with root package name */
    private JSONArray f45013v = null;

    /* renamed from: w, reason: collision with root package name */
    private final Map<VideoProducerDef.StreamType, VideoEncoderDef.EncodeStrategy> f45014w = new HashMap<VideoProducerDef.StreamType, VideoEncoderDef.EncodeStrategy>() { // from class: com.tencent.liteav.videoproducer.producer.i.1
        {
            VideoProducerDef.StreamType streamType = VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO;
            VideoEncoderDef.EncodeStrategy encodeStrategy = VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE;
            put(streamType, encodeStrategy);
            put(VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO, VideoEncoderDef.EncodeStrategy.USE_SOFTWARE_ONLY);
            put(VideoProducerDef.StreamType.STREAM_TYPE_SUB_VIDEO, encodeStrategy);
        }
    };

    /* renamed from: z, reason: collision with root package name */
    private GLConstants.GLScaleType f45017z = GLConstants.GLScaleType.CENTER_CROP;
    private com.tencent.liteav.videoconsumer.renderer.r B = null;
    private com.tencent.liteav.videoconsumer.consumer.a C = null;
    private final BroadcastReceiver D = new BroadcastReceiver() { // from class: com.tencent.liteav.videoproducer.producer.i.2
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                LiteavLog.w(i.this.f44992a, "onReceive, intent or context is null!");
                return;
            }
            String action = intent.getAction();
            if ("com.tencent.liteav.video.action.OUT_OF_MEMORY".equals(action)) {
                LiteavLog.d(i.this.f44992a, "onReceive, action:".concat(String.valueOf(action)));
                i.this.f44993b.notifyWarning(h.c.WARNING_OUT_OF_MEMORY, null);
            }
        }
    };

    @NonNull
    private com.tencent.liteav.videobase.videobase.a F = new com.tencent.liteav.videobase.videobase.a();

    @NonNull
    private com.tencent.liteav.videobase.videobase.a G = new com.tencent.liteav.videobase.videobase.a();
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private final VideoRenderListener L = new VideoRenderListener() { // from class: com.tencent.liteav.videoproducer.producer.i.3
        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderFrame(PixelFrame pixelFrame, VideoRenderListener.a aVar) {
            i.this.f44998g.a(false, aVar, pixelFrame);
        }
    };
    private final VideoRenderListener M = new VideoRenderListener() { // from class: com.tencent.liteav.videoproducer.producer.i.4
        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderFrame(@Nullable PixelFrame pixelFrame, VideoRenderListener.a aVar) {
            i.this.f44998g.a(true, aVar, pixelFrame);
            if (aVar == VideoRenderListener.a.RENDER_FAILED || i.this.A == null) {
                return;
            }
            i.this.A.onRenderFrame(pixelFrame, aVar);
        }
    };

    public i(@NonNull Context context, boolean z10, @NonNull IVideoReporter iVideoReporter) {
        this.f44999h = context;
        this.f44993b = iVideoReporter;
        this.f44998g = new com.tencent.liteav.videoconsumer.renderer.s(iVideoReporter);
        BeautyProcessor beautyProcessor = new BeautyProcessor(context, z10, iVideoReporter);
        this.f44995d = beautyProcessor;
        this.f44994c = new VideoPreprocessor(context, beautyProcessor, iVideoReporter);
        this.f45015x = new ConcurrentHashMap<>();
    }

    public static /* synthetic */ void a(i iVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        ServerVideoProducerConfig serverVideoProducerConfig2;
        LiteavLog.i(iVar.f44992a, "setServerConfig=".concat(String.valueOf(serverVideoProducerConfig)));
        iVar.f45003l = serverVideoProducerConfig;
        for (com.tencent.liteav.videoproducer.encoder.ax axVar : iVar.f45015x.values()) {
            if (axVar != null) {
                axVar.a(serverVideoProducerConfig);
            }
        }
        CameraCaptureSingleton.getInstance().setServerConfig(serverVideoProducerConfig);
        d dVar = iVar.f45004m;
        if (dVar == null || (serverVideoProducerConfig2 = iVar.f45003l) == null) {
            return;
        }
        dVar.a(serverVideoProducerConfig2.getGsensorRotationCorrection());
    }

    public static /* synthetic */ void b(i iVar) {
        LiteavLog.i(iVar.f44992a, "uninitialize");
        iVar.b();
        for (com.tencent.liteav.videoproducer.encoder.ax axVar : iVar.f45015x.values()) {
            if (axVar != null) {
                axVar.b();
                axVar.c();
                axVar.a();
            }
        }
        iVar.f45015x.clear();
        synchronized (iVar) {
            if (!iVar.f44997f) {
                LiteavLog.w(iVar.f44992a, "videoproducer already uninitialize.");
                return;
            }
            CustomHandler customHandler = iVar.f44996e;
            iVar.f44996e = null;
            iVar.f44997f = false;
            com.tencent.liteav.videobase.utils.i.a().a(iVar.D);
            iVar.f44994c.uninitialize();
            iVar.f45009r.uninitialize();
            iVar.f45011t.uninitialize();
            iVar.f45010s.uninitialize();
            iVar.f45012u.uninitialize();
            iVar.B = null;
            com.tencent.liteav.videoconsumer.consumer.a aVar = iVar.C;
            if (aVar != null) {
                aVar.a();
                iVar.C = null;
            }
            iVar.d();
            if (customHandler != null) {
                customHandler.quitLooper();
            }
        }
    }

    public static /* synthetic */ void g(i iVar) {
        iVar.f45009r.initialize();
        iVar.f45011t.initialize();
        iVar.f45010s.initialize();
        iVar.f45012u.initialize();
        iVar.f44994c.initialize();
        iVar.B = new com.tencent.liteav.videoconsumer.renderer.t(iVar.f44996e.getLooper(), iVar.f44993b);
        com.tencent.liteav.videobase.utils.i.a().a(iVar.D, new IntentFilter("com.tencent.liteav.video.action.OUT_OF_MEMORY"));
    }

    public static /* synthetic */ void i(i iVar) {
        LiteavLog.i(iVar.f44992a, "pauseCaptureInternal");
        if (iVar.f45005n == CaptureSourceInterface.SourceType.CUSTOM) {
            LiteavLog.w(iVar.f44992a, "ignore invoking pauseCapture() when using custom input");
            return;
        }
        CaptureSourceInterface captureSourceInterface = iVar.f45006o;
        if (captureSourceInterface != null) {
            captureSourceInterface.pause();
        }
    }

    public static /* synthetic */ void j(i iVar) {
        LiteavLog.i(iVar.f44992a, "resumeCaptureInternal");
        if (iVar.f45005n == CaptureSourceInterface.SourceType.CUSTOM) {
            LiteavLog.w(iVar.f44992a, "ignore invoking resumeCapture() when using custom input");
            return;
        }
        CaptureSourceInterface captureSourceInterface = iVar.f45006o;
        if (captureSourceInterface != null) {
            captureSourceInterface.resume();
        }
    }

    public static /* synthetic */ void k(i iVar) {
        if (iVar.f45005n != CaptureSourceInterface.SourceType.NONE) {
            LiteavLog.w(iVar.f44992a, "can't Start when sourceType isn't NONE");
            return;
        }
        LiteavLog.i(iVar.f44992a, "Start custom capture");
        iVar.a(com.tencent.liteav.videoproducer.capture.ax.a().b());
        iVar.c();
        iVar.f45005n = CaptureSourceInterface.SourceType.CUSTOM;
        iVar.a(iVar.f45005n, (VideoProducerDef.CameraCaptureMode) null, (CaptureSourceInterface.CaptureParams) null);
        iVar.f44994c.setSourceType(iVar.f45005n);
        iVar.a(iVar.B);
        iVar.a((com.tencent.liteav.videoconsumer.renderer.r) iVar.C);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public final void onCameraTouchEnable(boolean z10) {
        LiteavLog.i(this.f44992a, "onCameraTouchEnable enableTouch:".concat(String.valueOf(z10)));
        a(an.a(this, z10));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public final void onCameraZoomEnable(boolean z10) {
        LiteavLog.i(this.f44992a, "onCameraZoomEnable enableZoom:".concat(String.valueOf(z10)));
        a(ao.a(this, z10));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public final void onCaptureError() {
        LiteavLog.i(this.f44992a, "onCaptureError");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public final void onCaptureFirstFrame() {
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public final void onFrameAvailable(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            pixelFrame.retain();
            pixelFrame.getProducerChainTimestamp().setCaptureTimestamp(TimeUtil.a());
            if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                GLES20.glFinish();
            }
            if (a(ap.a(this, pixelFrame, captureSourceInterface))) {
                return;
            }
            pixelFrame.release();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public final void onScreenDisplayOrientationChanged(Rotation rotation) {
        LiteavLog.i(this.f44992a, "onScreenDisplayOrientationChanged rotation:".concat(String.valueOf(rotation)));
        a(am.a(this, rotation));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureSourceListener
    public final void onStartFinish(boolean z10) {
        LiteavLog.i(this.f44992a, "onStartFinish success:".concat(String.valueOf(z10)));
    }

    @Override // com.tencent.rtmp.ui.a
    public final void onTap(int i10, int i11, int i12, int i13) {
        PixelFrame pixelFrame = this.f45008q;
        if (pixelFrame == null || i12 <= 0 || i13 <= 0) {
            return;
        }
        a(at.a(this, OpenGlUtils.reverseMappingPoint(GLConstants.GLScaleType.CENTER_CROP, this.f45008q.getRotation(), new Point(i10, i11), new Size(i12, i13), new Size(pixelFrame.getWidth(), this.f45008q.getHeight())), i10, i11, i12, i13));
    }

    @Override // com.tencent.rtmp.ui.b
    public final void onZoom(float f10) {
        a(au.a(this, f10));
    }

    public static /* synthetic */ void c(i iVar, boolean z10) {
        LiteavLog.i(iVar.f44992a, "setEncodeMirrorEnabled: ".concat(String.valueOf(z10)));
        iVar.f45011t.setEncodeMirrorByUser(z10);
    }

    private void d() {
        LiteavLog.i(this.f45000i.a("uninitGL"), this.f44992a, "uninitOpenGLComponents", new Object[0]);
        EGLCore.destroy(this.f45001j);
        this.f45001j = null;
        this.f44994c.uninitializeGLComponents();
    }

    private List<com.tencent.liteav.videoconsumer.renderer.r> e() {
        ArrayList arrayList = new ArrayList();
        com.tencent.liteav.videoconsumer.renderer.r rVar = this.B;
        if (rVar != null) {
            arrayList.add(rVar);
        }
        com.tencent.liteav.videoconsumer.consumer.a aVar = this.C;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public static /* synthetic */ void c(i iVar, Rotation rotation) {
        LiteavLog.i(iVar.f44992a, "setEncodeRotation: %s", rotation);
        iVar.f45010s.setEncodeRotationByUser(rotation);
        iVar.f45012u.setEncodeRotation(rotation);
        iVar.f45009r.setEncodeRotation(rotation);
    }

    private void c() {
        CaptureSourceInterface captureSourceInterface = this.f45006o;
        if (captureSourceInterface != null) {
            captureSourceInterface.stop();
            this.f45006o = null;
        }
        this.f45007p = null;
        this.f45008q = null;
    }

    public static /* synthetic */ void a(i iVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        LiteavLog.i(iVar.f44992a, "setCaptureParams " + ((Object) sourceType) + " ,mode = " + ((Object) cameraCaptureMode) + " , " + captureParams.toString());
        LiteavLog.d(iVar.f44992a, "setCaptureParamInternal ".concat(String.valueOf(sourceType)));
        if (iVar.f45005n != sourceType) {
            LiteavLog.i(iVar.f44992a, "setCaptureParamInternal sourcetype not match: " + ((Object) sourceType) + " , current is " + ((Object) iVar.f45005n));
            return;
        }
        if (iVar.f45006o != null && iVar.f45007p != null) {
            iVar.f44995d.setPerformanceMode(cameraCaptureMode == VideoProducerDef.CameraCaptureMode.PERFORMANCE);
            if (captureParams instanceof CameraCaptureParams) {
                iVar.f45007p = new CameraCaptureParams((CameraCaptureParams) captureParams);
            } else if (captureParams instanceof VirtualCamera.VirtualCameraParams) {
                iVar.f45007p = new VirtualCamera.VirtualCameraParams((VirtualCamera.VirtualCameraParams) captureParams);
            } else if (captureParams instanceof ScreenCapturer.ScreenCaptureParams) {
                iVar.f45007p = new ScreenCapturer.ScreenCaptureParams((ScreenCapturer.ScreenCaptureParams) captureParams);
            } else {
                iVar.f45007p = new CaptureSourceInterface.CaptureParams(captureParams);
            }
            iVar.a(sourceType, cameraCaptureMode, captureParams);
            iVar.a(iVar.f45007p);
            b(iVar.f45007p);
            return;
        }
        LiteavLog.i(iVar.f44992a, "setCaptureParamInternal capturesource is " + ((Object) iVar.f45006o) + ", " + ((Object) iVar.f45007p));
    }

    public static /* synthetic */ void a(i iVar, Bitmap bitmap, int i10) {
        if (iVar.f45006o == null) {
            return;
        }
        int width = bitmap != null ? bitmap.getWidth() : 64;
        int height = bitmap != null ? bitmap.getHeight() : 64;
        CaptureSourceInterface captureSourceInterface = iVar.f45006o;
        if (captureSourceInterface instanceof com.tencent.liteav.videoproducer.capture.ak) {
            ((com.tencent.liteav.videoproducer.capture.ak) captureSourceInterface).a(bitmap, i10, width, height);
        } else if (captureSourceInterface instanceof VirtualCamera) {
            LiteavLog.w(iVar.f44992a, "setPausedImage in Start param.");
        } else {
            LiteavLog.w(iVar.f44992a, "setPausedImage failed!");
        }
    }

    public static /* synthetic */ void b(i iVar, int i10, VideoProducerDef.StreamType streamType) {
        LiteavLog.i(iVar.f44992a, "setRPSIFrameFPS: %d", Integer.valueOf(i10));
        com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(streamType);
        if (axVar == null) {
            LiteavLog.w(iVar.f44992a, "setRPSIFrameFPS with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            axVar.a(com.tencent.liteav.videoproducer.encoder.az.a(axVar, i10), "setRPSIFrameFPS");
        }
    }

    public static /* synthetic */ void b(i iVar, Rotation rotation) {
        LiteavLog.i(iVar.f44992a, "setRenderRotation: %s", rotation);
        iVar.f45010s.setRenderRotationByUser(rotation);
    }

    private static void b(CaptureSourceInterface.CaptureParams captureParams) {
        if (captureParams instanceof CameraCaptureParams) {
            ((CameraCaptureParams) captureParams).f44172a = null;
        }
    }

    public static /* synthetic */ void a(i iVar, DisplayTarget displayTarget) {
        if (CommonUtil.equals(iVar.f45016y, displayTarget)) {
            return;
        }
        iVar.a(displayTarget);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        LiteavLog.i(this.f44992a, "stopCaptureInternal");
        this.f44994c.unregisterVideoProcessedListener(1, this);
        this.f44994c.unregisterVideoProcessedListener(2, this);
        for (com.tencent.liteav.videoconsumer.renderer.r rVar : e()) {
            if (rVar != null) {
                rVar.a(true);
                this.f44998g.b(rVar instanceof com.tencent.liteav.videoconsumer.consumer.a);
            }
        }
        c();
        d dVar = this.f45004m;
        if (dVar != null) {
            dVar.disable();
            this.f45004m = null;
        }
        this.f45005n = CaptureSourceInterface.SourceType.NONE;
        this.f44994c.setSourceType(this.f45005n);
        this.H = false;
        this.I = false;
        this.F = new com.tencent.liteav.videobase.videobase.a();
        this.G = new com.tencent.liteav.videobase.videobase.a();
        d();
    }

    public static /* synthetic */ void a(i iVar, VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        VideoEncoderDef.EncodeStrategy encodeStrategy2;
        if (streamType == VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO || (encodeStrategy2 = iVar.f45014w.get(streamType)) == null || encodeStrategy2 == encodeStrategy) {
            return;
        }
        LiteavLog.i(iVar.f44992a, "setEncodeStrategy: " + ((Object) streamType) + " " + ((Object) encodeStrategy));
        iVar.f45014w.put(streamType, encodeStrategy);
        com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(streamType);
        if (axVar != null) {
            axVar.a(encodeStrategy);
        }
    }

    public static /* synthetic */ void a(i iVar, String str) {
        try {
            LiteavLog.i(iVar.f44992a, "setHWEncoderDeviceRelatedParams: ".concat(String.valueOf(str)));
            iVar.f45013v = new JSONArray(str);
        } catch (JSONException e2) {
            LiteavLog.e(iVar.f44992a, "setHWEncoderDeviceRelatedParams error ".concat(String.valueOf(e2)));
        }
    }

    public static /* synthetic */ void a(i iVar, int i10, int i11) {
        DisplayTarget displayTarget = iVar.f45016y;
        if (displayTarget != null) {
            Size size = displayTarget.getSize();
            iVar.onTap(i10, i11, size.width, size.height);
        }
    }

    public static /* synthetic */ void a(i iVar, VideoProducerDef.GSensorMode gSensorMode) {
        LiteavLog.i(iVar.f44992a, "setGSensorMode: %s", gSensorMode);
        iVar.f45011t.setGSensorMode(gSensorMode);
        iVar.f45010s.setGSensorMode(gSensorMode);
        iVar.f45012u.setGSensorMode(gSensorMode);
    }

    public static /* synthetic */ void b(i iVar, boolean z10) {
        iVar.J = z10;
        DisplayTarget displayTarget = iVar.f45016y;
        TXCloudVideoView tXCloudVideoView = displayTarget != null ? displayTarget.getTXCloudVideoView() : null;
        if (tXCloudVideoView != null) {
            if (!z10) {
                iVar = null;
            }
            TXCCloudVideoViewMethodInvoker.setTouchToFocusEnabled(tXCloudVideoView, z10, iVar);
        }
    }

    public static /* synthetic */ void a(i iVar, VideoProducerDef.HomeOrientation homeOrientation) {
        LiteavLog.i(iVar.f44992a, "setHomeOrientation: %s", homeOrientation);
        iVar.f45011t.setHomeOrientation(homeOrientation);
        iVar.f45010s.setHomeOrientation(homeOrientation);
        iVar.f45012u.setHomeOrientation(homeOrientation);
    }

    private void b(PixelFrame pixelFrame) {
        FrameMetaData metaData = pixelFrame.getMetaData();
        if (metaData == null || this.f45005n == CaptureSourceInterface.SourceType.NONE) {
            return;
        }
        Size renderSize = metaData.getRenderSize();
        Size encodeSize = metaData.getEncodeSize();
        Rotation encodeRotation = metaData.getEncodeRotation();
        metaData.setEncodeRotation(Rotation.NORMAL);
        com.tencent.liteav.videobase.videobase.a aVar = this.F;
        if (aVar.f43558a == renderSize.width && aVar.f43559b == renderSize.height) {
            com.tencent.liteav.videobase.videobase.a aVar2 = this.G;
            if (aVar2.f43558a == encodeSize.width && aVar2.f43559b == encodeSize.height && aVar2.f43560c == encodeRotation) {
                return;
            }
        }
        this.f44994c.unregisterVideoProcessedListener(2, this);
        this.f44994c.unregisterVideoProcessedListener(1, this);
        com.tencent.liteav.videobase.videobase.a aVar3 = new com.tencent.liteav.videobase.videobase.a(renderSize.width, renderSize.height);
        this.F = aVar3;
        VideoPreprocessor videoPreprocessor = this.f44994c;
        GLConstants.PixelBufferType pixelBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
        GLConstants.PixelFormatType pixelFormatType = GLConstants.PixelFormatType.RGBA;
        videoPreprocessor.registerVideoProcessedListener(2, aVar3, pixelBufferType, pixelFormatType, false, this);
        com.tencent.liteav.videobase.videobase.a aVar4 = new com.tencent.liteav.videobase.videobase.a(encodeSize.width, encodeSize.height, encodeRotation);
        this.G = aVar4;
        this.f44994c.registerVideoProcessedListener(1, aVar4, pixelBufferType, pixelFormatType, true, this);
    }

    public static /* synthetic */ void a(i iVar, List list, List list2) {
        com.tencent.liteav.videoconsumer.renderer.r rVar = iVar.B;
        if (rVar != null) {
            rVar.a((List<PointF>) list, (List<PointF>) list2);
        }
    }

    private void a(VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams) {
        CaptureSourceInterface captureSourceInterface;
        if (streamType == VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO || videoEncodeParams == null || this.f45007p == null) {
            return;
        }
        boolean z10 = false;
        Size captureSize = this.f45009r.getCaptureSize();
        int i10 = captureSize.width;
        CaptureSourceInterface.CaptureParams captureParams = this.f45007p;
        boolean z11 = true;
        if (i10 != captureParams.f44182c || captureSize.height != captureParams.f44183d) {
            captureParams.f44182c = i10;
            captureParams.f44183d = captureSize.height;
            z10 = true;
        }
        int i11 = videoEncodeParams.fps;
        if (i11 > captureParams.f44181b) {
            captureParams.f44181b = i11;
        } else {
            z11 = z10;
        }
        if (!z11 || (captureSourceInterface = this.f45006o) == null) {
            return;
        }
        captureSourceInterface.updateParams(captureParams);
    }

    public static /* synthetic */ void a(i iVar, int i10, VideoProducerDef.StreamType streamType) {
        LiteavLog.i(iVar.f44992a, "setRPSNearestREFSize: %d", Integer.valueOf(i10));
        com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(streamType);
        if (axVar == null) {
            LiteavLog.w(iVar.f44992a, "setRPSNearestREFSize with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            axVar.a(ba.a(axVar, i10), "setRPSNearestREFSize");
        }
    }

    public static /* synthetic */ void b(i iVar, VideoProducerDef.StreamType streamType) {
        com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(streamType);
        if (axVar != null) {
            axVar.b();
            axVar.c();
            axVar.a();
            iVar.f45015x.remove(streamType);
        }
    }

    public static /* synthetic */ void a(i iVar, VideoProducerDef.StreamType streamType, int i10, int i11) {
        com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(streamType);
        if (axVar == null) {
            LiteavLog.w(iVar.f44992a, "ackRPSRecvFrameIndex with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            axVar.a(bb.a(axVar, i10, i11), "ackRPSRecvFrameIndex");
        }
    }

    public static /* synthetic */ void b(i iVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        LiteavLog.i(iVar.f44992a, "startCaptureInternal sourceType:" + ((Object) sourceType) + ",mode:" + ((Object) cameraCaptureMode) + ",captureParams:" + ((Object) captureParams));
        if (iVar.f45005n == CaptureSourceInterface.SourceType.NONE && iVar.f45005n != CaptureSourceInterface.SourceType.CUSTOM) {
            iVar.a(com.tencent.liteav.videoproducer.capture.ax.a().b());
            iVar.f45005n = sourceType;
            iVar.f45007p = captureParams;
            iVar.a(sourceType, cameraCaptureMode, captureParams);
            iVar.a(iVar.f45007p);
            iVar.f44995d.setPerformanceMode(cameraCaptureMode == VideoProducerDef.CameraCaptureMode.PERFORMANCE);
            iVar.f44994c.setSourceType(iVar.f45005n);
            if (sourceType == CaptureSourceInterface.SourceType.CAMERA) {
                iVar.f45006o = new com.tencent.liteav.videoproducer.capture.ak(iVar.f44999h, Looper.myLooper(), iVar.f44993b);
                if (iVar.f45004m == null) {
                    iVar.f45004m = new d(iVar.f44999h, iVar);
                }
                iVar.f45004m.enable();
                ServerVideoProducerConfig serverVideoProducerConfig = iVar.f45003l;
                if (serverVideoProducerConfig != null) {
                    iVar.f45004m.a(serverVideoProducerConfig.getGsensorRotationCorrection());
                }
            } else if (sourceType == CaptureSourceInterface.SourceType.SCREEN) {
                iVar.f45006o = new com.tencent.liteav.videoproducer.capture.ak(iVar.f44999h, Looper.myLooper(), iVar.f44993b);
            } else if (sourceType == CaptureSourceInterface.SourceType.VIRTUAL_CAMERA) {
                iVar.f45006o = new VirtualCamera(Looper.myLooper(), iVar.f44993b);
            }
            CaptureSourceInterface captureSourceInterface = iVar.f45006o;
            EGLCore eGLCore = iVar.f45001j;
            captureSourceInterface.start(eGLCore != null ? eGLCore.getEglContext() : null, captureParams, iVar);
            iVar.a(iVar.f45016y);
            iVar.a(iVar.B);
            iVar.a((com.tencent.liteav.videoconsumer.renderer.r) iVar.C);
            b(iVar.f45007p);
            return;
        }
        LiteavLog.w(iVar.f44992a, "can't Start when sourceType isn't NONE. current is " + iVar.f45005n.name());
    }

    public static /* synthetic */ void a(i iVar, VideoProducerDef.StreamType streamType) {
        LiteavLog.i(iVar.f44992a, "requestKeyFrame");
        com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(streamType);
        if (axVar == null) {
            LiteavLog.w(iVar.f44992a, "requestKeyFrame with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            axVar.a(bk.a(axVar), "restartIDRFrame");
        }
    }

    public static /* synthetic */ void a(i iVar, GLConstants.MirrorMode mirrorMode) {
        LiteavLog.i(iVar.f44992a, "setRenderMirrorMode: %s", mirrorMode);
        iVar.f45011t.setRenderMirrorModeByUser(mirrorMode);
    }

    public static /* synthetic */ void a(i iVar, GLConstants.GLScaleType gLScaleType) {
        if (iVar.f45017z == gLScaleType) {
            return;
        }
        LiteavLog.i(iVar.f44992a, "setRenderScaleType: %s", gLScaleType.name());
        iVar.f45017z = gLScaleType;
        for (com.tencent.liteav.videoconsumer.renderer.r rVar : iVar.e()) {
            if (rVar != null) {
                rVar.a(gLScaleType);
            }
        }
    }

    public static /* synthetic */ void a(i iVar, PixelFrame pixelFrame) {
        if (iVar.f45005n != CaptureSourceInterface.SourceType.CUSTOM) {
            pixelFrame.release();
            return;
        }
        if (pixelFrame.getTimestamp() == 0) {
            pixelFrame.setTimestamp(TimeUtil.a());
        }
        iVar.f44993b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_INCOME_FRAME, 0);
        iVar.f44993b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CAPTURE_FRAME, 0);
        iVar.a(pixelFrame);
        iVar.b(pixelFrame);
        if (pixelFrame.getGLContext() != null && !CommonUtil.equals(iVar.f45002k, pixelFrame.getGLContext())) {
            iVar.d();
            iVar.a(pixelFrame.getGLContext());
        }
        if (iVar.f45001j != null && pixelFrame.getGLContext() == null) {
            pixelFrame.setGLContext(iVar.f45001j.getEglContext());
        }
        iVar.f44994c.processFrame(pixelFrame);
        pixelFrame.release();
    }

    public static /* synthetic */ void a(i iVar) {
        LiteavLog.i(iVar.f44992a, "Stop custom capture");
        iVar.b();
    }

    public static /* synthetic */ void a(i iVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        LiteavLog.i(iVar.f44992a, "setCustomRenderListener PixelFormatType = " + ((Object) pixelFormatType) + ",  PixelBufferType = " + ((Object) pixelBufferType) + " listener= " + ((Object) videoRenderListener));
        iVar.A = videoRenderListener;
        if (iVar.A != null) {
            if (iVar.C == null) {
                iVar.C = new com.tencent.liteav.videoconsumer.consumer.a(a.EnumC0642a.f43690b);
            }
            iVar.a((com.tencent.liteav.videoconsumer.renderer.r) iVar.C);
            iVar.C.a(pixelFormatType, pixelBufferType);
        } else {
            com.tencent.liteav.videoconsumer.consumer.a aVar = iVar.C;
            if (aVar != null) {
                aVar.a(true);
                iVar.C.a();
                iVar.C = null;
            }
            iVar.f44998g.b(true);
        }
        iVar.f44998g.c(iVar.A != null);
    }

    public static /* synthetic */ void a(i iVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        LiteavLog.i(iVar.f44992a, "setCustomVideoProcessListener PixelFormatType = " + ((Object) pixelFormatType) + ",  PixelBufferType = " + ((Object) pixelBufferType) + " listener= " + ((Object) customVideoProcessListener));
        if (iVar.E == null) {
            iVar.E = new a(iVar.f44993b);
        }
        a aVar = iVar.E;
        LiteavLog.i("CustomVideoProcessListenerAdapter", "setCustomVideoProcessListener PixelFormatType = " + ((Object) pixelFormatType) + ",  PixelBufferType = " + ((Object) pixelBufferType) + " listener= " + ((Object) customVideoProcessListener));
        aVar.f44888b.a(b.a(aVar, pixelFormatType, pixelBufferType, customVideoProcessListener));
        iVar.f44994c.setInterceptorBeforeWatermark(iVar.E);
    }

    private void a(Object obj) {
        if (!CommonUtil.equals(this.f45002k, obj)) {
            d();
        }
        if (this.f45001j != null) {
            return;
        }
        LiteavLog.i(this.f45000i.a("initGL"), this.f44992a, "initOpenGLComponents", new Object[0]);
        this.f45002k = obj;
        EGLCore eGLCore = new EGLCore();
        this.f45001j = eGLCore;
        try {
            eGLCore.initialize(obj, null, 128, 128);
        } catch (com.tencent.liteav.videobase.egl.f e2) {
            this.f45001j = null;
            LiteavLog.e(this.f45000i.a("initGLError"), this.f44992a, "EGLCore create failed.", e2);
        }
    }

    private void a(CaptureSourceInterface.SourceType sourceType, VideoProducerDef.CameraCaptureMode cameraCaptureMode, CaptureSourceInterface.CaptureParams captureParams) {
        this.f45009r.setSourceType(sourceType);
        this.f45012u.setSourceType(sourceType);
        this.f45011t.setSourceType(sourceType);
        this.f45010s.setSourceType(sourceType);
        if (captureParams instanceof ScreenCapturer.ScreenCaptureParams) {
            this.f45012u.setScreenAutoRotateEnable(((ScreenCapturer.ScreenCaptureParams) captureParams).f44210a);
        }
        if (cameraCaptureMode != null) {
            this.f45009r.setCameraCaptureMode(cameraCaptureMode);
            this.f45012u.setCameraCaptureMode(cameraCaptureMode);
        } else if (sourceType == CaptureSourceInterface.SourceType.CUSTOM) {
            CaptureResolutionDecider captureResolutionDecider = this.f45009r;
            VideoProducerDef.CameraCaptureMode cameraCaptureMode2 = VideoProducerDef.CameraCaptureMode.MANUAL;
            captureResolutionDecider.setCameraCaptureMode(cameraCaptureMode2);
            this.f45012u.setCameraCaptureMode(cameraCaptureMode2);
        }
        if (captureParams != null) {
            this.f45009r.setManualCaptureSize(captureParams.f44182c, captureParams.f44183d);
        }
    }

    private void a(CaptureSourceInterface.CaptureParams captureParams) {
        if (captureParams == null) {
            return;
        }
        Size captureSize = this.f45009r.getCaptureSize();
        int i10 = captureSize.width;
        if (i10 == captureParams.f44182c && captureSize.height == captureParams.f44183d) {
            return;
        }
        captureParams.f44182c = i10;
        captureParams.f44183d = captureSize.height;
        CaptureSourceInterface captureSourceInterface = this.f45006o;
        if (captureSourceInterface != null) {
            captureSourceInterface.updateParams(captureParams);
        }
    }

    private void a(DisplayTarget displayTarget) {
        LiteavLog.i(this.f44992a, "setDisplayView ".concat(String.valueOf(displayTarget)));
        this.f45016y = displayTarget;
        TXCloudVideoView tXCloudVideoView = displayTarget != null ? displayTarget.getTXCloudVideoView() : null;
        if (tXCloudVideoView != null) {
            TXCCloudVideoViewMethodInvoker.setTouchToFocusEnabled(tXCloudVideoView, this.J, this);
            TXCCloudVideoViewMethodInvoker.setZoomEnabled(tXCloudVideoView, this.K, this);
        }
        for (com.tencent.liteav.videoconsumer.renderer.r rVar : e()) {
            if (rVar != null) {
                rVar.a(this.f45016y, true);
            }
        }
    }

    private void a(VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, GLConstants.ResolutionMode resolutionMode) {
        if (streamType == VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO) {
            return;
        }
        if (resolutionMode != null) {
            this.f45009r.setResolutionMode(resolutionMode);
            this.f45011t.setResolutionMode(resolutionMode);
            this.f45010s.setResolutionMode(resolutionMode);
            this.f45012u.setResolutionMode(resolutionMode);
        }
        if (videoEncodeParams != null) {
            this.f45009r.setEncodeSize(videoEncodeParams.width, videoEncodeParams.height);
            this.f45012u.setEncodeSize(videoEncodeParams.width, videoEncodeParams.height);
        }
    }

    public static /* synthetic */ void a(i iVar, boolean z10) {
        iVar.K = z10;
        DisplayTarget displayTarget = iVar.f45016y;
        TXCloudVideoView tXCloudVideoView = displayTarget != null ? displayTarget.getTXCloudVideoView() : null;
        if (tXCloudVideoView != null) {
            if (!z10) {
                iVar = null;
            }
            TXCCloudVideoViewMethodInvoker.setZoomEnabled(tXCloudVideoView, z10, iVar);
        }
    }

    public static /* synthetic */ void a(i iVar, PixelFrame pixelFrame, CaptureSourceInterface captureSourceInterface) {
        iVar.f44993b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CAPTURE_FRAME, 0);
        if (!iVar.H) {
            iVar.H = true;
            iVar.f44993b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_FIRST_FRAME, (Object) null, "capture first frame");
            LiteavLog.d(iVar.f44992a, "receive first capture frame! ");
        }
        iVar.a(pixelFrame);
        iVar.b(pixelFrame);
        if (a(captureSourceInterface) != null) {
            PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
            iVar.f45008q = pixelFrame2;
            pixelFrame2.setRotation(com.tencent.liteav.videoproducer.capture.t.b());
        }
        if (iVar.f45001j != null && pixelFrame.getGLContext() == null) {
            pixelFrame.setGLContext(iVar.f45001j.getEglContext());
        }
        iVar.f44994c.processFrame(pixelFrame);
        pixelFrame.release();
    }

    private void a(PixelFrame pixelFrame) {
        this.f45011t.setFront(CameraCaptureSingleton.getInstance().isFrontCamera());
        this.f45011t.setCaptureMirror(pixelFrame.isMirrorHorizontal(), pixelFrame.isMirrorVertical());
        this.f45011t.setCaptureRotation(pixelFrame.getRotation());
        this.f45010s.setFront(CameraCaptureSingleton.getInstance().isFrontCamera());
        this.f45010s.setCaptureRotation(pixelFrame.getRotation());
        this.f45012u.setPreprocessRotation(this.f45010s.getPreprocessorRotation(false));
        this.f45012u.setRealCaptureFrameSize(pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getRotation(), false);
        this.f45009r.setRealCaptureFrameSize(pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getRotation(), false);
        FrameMetaData frameMetaData = new FrameMetaData();
        frameMetaData.setPreprocessorMirror(this.f45011t.getPreprocessorMirrorInfo());
        frameMetaData.setPreprocessorRotation(this.f45010s.getPreprocessorRotation(true));
        frameMetaData.setPreprocessorScaleType(this.f45005n == CaptureSourceInterface.SourceType.SCREEN ? GLConstants.GLScaleType.FIT_CENTER : GLConstants.GLScaleType.CENTER_CROP);
        frameMetaData.setRenderMirror(this.f45011t.getRenderMirrorInfo(this.f45010s.getPreprocessorRotation(false)));
        frameMetaData.setRenderRotation(this.f45010s.getRenderRotation());
        frameMetaData.setRenderSize(this.f45012u.getRenderSize());
        frameMetaData.setEncodeMirror(this.f45011t.getEncodeMirrorInfo());
        frameMetaData.setEncodeRotation(this.f45010s.getEncodeRotation());
        frameMetaData.setEncodeSize(this.f45012u.getEncodeSize());
        FrameMetaData metaData = pixelFrame.getMetaData();
        if (metaData != null) {
            frameMetaData.setIsBlackFrame(metaData.isBlackFrame());
        }
        pixelFrame.setMetaData(frameMetaData);
    }

    private void a(com.tencent.liteav.videoconsumer.renderer.r rVar) {
        if (rVar != null) {
            rVar.a(this.f45016y, true);
            boolean z10 = rVar instanceof com.tencent.liteav.videoconsumer.consumer.a;
            rVar.a(z10 ? this.M : this.L);
            rVar.a(this.f45017z);
            this.f44998g.a(z10);
        }
    }

    @Override // com.tencent.liteav.videoproducer.preprocessor.ah
    public final void a(int i10, PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        if (!this.I) {
            this.I = true;
            LiteavLog.d(this.f44992a, "preprocess first frame out!");
        }
        GLES20.glFinish();
        pixelFrame.retain();
        if (a(ar.a(this, i10, pixelFrame))) {
            return;
        }
        pixelFrame.release();
    }

    @Override // com.tencent.liteav.videoproducer.producer.d.a
    public final void a(Rotation rotation, Rotation rotation2) {
        a(as.a(this, rotation, rotation2));
    }

    public static /* synthetic */ void a(i iVar, Rotation rotation, Rotation rotation2) {
        LiteavLog.i(iVar.f44992a, "onOrientationChanged, sensorRotation=%s, displayRotation=%s", rotation, rotation2);
        iVar.f45011t.setSensorRotation(rotation);
        iVar.f45011t.setDisplayRotation(rotation2);
        iVar.f45010s.setSensorRotation(rotation);
        iVar.f45010s.setDisplayRotation(rotation2);
    }

    public static /* synthetic */ void a(i iVar, Point point, int i10, int i11, int i12, int i13) {
        com.tencent.liteav.videoproducer.capture.t a10;
        if (iVar.f45005n == CaptureSourceInterface.SourceType.CAMERA && (a10 = a(iVar.f45006o)) != null && com.tencent.liteav.videoproducer.capture.t.a()) {
            a10.a(point.x, point.y);
            DisplayTarget displayTarget = iVar.f45016y;
            TXCloudVideoView tXCloudVideoView = displayTarget != null ? displayTarget.getTXCloudVideoView() : null;
            if (tXCloudVideoView != null) {
                TXCCloudVideoViewMethodInvoker.showFocusView(tXCloudVideoView, i10, i11, i12, i13);
            }
        }
    }

    public static /* synthetic */ void a(i iVar, float f10) {
        com.tencent.liteav.videoproducer.capture.t a10;
        if (iVar.f45005n == CaptureSourceInterface.SourceType.CAMERA && (a10 = a(iVar.f45006o)) != null) {
            a10.a(f10);
        }
    }

    public static VideoEncoderDef.EncodeAbility a() {
        return EncodeAbilityProvider.getInstance().getEncodeAbility();
    }

    private static void a(PixelFrame pixelFrame, com.tencent.liteav.videoconsumer.renderer.r rVar) {
        if (rVar == null) {
            return;
        }
        rVar.a(pixelFrame);
    }

    public final boolean a(Runnable runnable) {
        CustomHandler customHandler = this.f44996e;
        if (!this.f44997f || customHandler == null) {
            return false;
        }
        if (Looper.myLooper() == customHandler.getLooper()) {
            runnable.run();
            return true;
        }
        return customHandler.post(runnable);
    }

    public final boolean a(Runnable runnable, long j10) {
        CustomHandler customHandler = this.f44996e;
        if (!this.f44997f || customHandler == null) {
            return false;
        }
        if (Looper.myLooper() == customHandler.getLooper()) {
            runnable.run();
            return true;
        }
        return customHandler.runAndWaitDone(runnable, j10);
    }

    private static com.tencent.liteav.videoproducer.capture.t a(CaptureSourceInterface captureSourceInterface) {
        if (!(captureSourceInterface instanceof com.tencent.liteav.videoproducer.capture.ak)) {
            return null;
        }
        CaptureSourceInterface captureSourceInterface2 = ((com.tencent.liteav.videoproducer.capture.ak) captureSourceInterface).f44278a;
        if (captureSourceInterface2 instanceof com.tencent.liteav.videoproducer.capture.t) {
            return (com.tencent.liteav.videoproducer.capture.t) captureSourceInterface2;
        }
        return null;
    }

    public static /* synthetic */ void a(i iVar, int i10, PixelFrame pixelFrame) {
        if (iVar.f45001j != null) {
            if (pixelFrame.getGLContext() != null) {
                pixelFrame.setGLContext(iVar.f45001j.getEglContext());
            }
            if (i10 == 1) {
                for (com.tencent.liteav.videoproducer.encoder.ax axVar : iVar.f45015x.values()) {
                    if (axVar != null) {
                        com.tencent.liteav.videoproducer.encoder.b bVar = axVar.f44575h;
                        synchronized (bVar.f44598a) {
                            ProducerChainTimestamp producerChainTimestamp = pixelFrame.getProducerChainTimestamp();
                            producerChainTimestamp.setEncodeTimestamp(TimeUtil.a());
                            bVar.f44598a.put(Long.valueOf(pixelFrame.getTimestamp()), producerChainTimestamp);
                        }
                        if (pixelFrame.getGLContext() != null) {
                            GLES20.glFinish();
                        }
                        axVar.a(bf.a(axVar), "");
                        if (!axVar.f44571d && (axVar.f44574g || axVar.f44570c.a(pixelFrame.getTimestamp()))) {
                            axVar.f44569b.a(pixelFrame);
                            axVar.a(bg.a(axVar), "encodeFrameInternal");
                        }
                    }
                }
            } else if (i10 == 2) {
                a(pixelFrame, iVar.B);
                a(pixelFrame, iVar.C);
            }
        }
        pixelFrame.release();
    }

    public static /* synthetic */ void a(i iVar, SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        com.tencent.liteav.videoconsumer.renderer.r rVar;
        LiteavLog.i(iVar.f44992a, "takeSnapshotInternal sourceType: " + ((Object) snapshotSourceType) + ", listener: " + ((Object) takeSnapshotListener));
        if (snapshotSourceType == SnapshotSourceType.STREAM) {
            com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO);
            if (axVar != null) {
                axVar.a(takeSnapshotListener);
                return;
            }
            for (com.tencent.liteav.videoproducer.encoder.ax axVar2 : iVar.f45015x.values()) {
                if (axVar2 != null) {
                    axVar2.a(takeSnapshotListener);
                    return;
                }
            }
            return;
        }
        if (snapshotSourceType == SnapshotSourceType.VIEW) {
            if (iVar.f45016y != null && (rVar = iVar.B) != null) {
                rVar.a(takeSnapshotListener);
                return;
            }
            com.tencent.liteav.videoconsumer.consumer.a aVar = iVar.C;
            if (aVar != null) {
                aVar.a(takeSnapshotListener);
                return;
            }
            LiteavLog.w(iVar.f44992a, "takeSnapshotInternal return null, no match render.");
            if (takeSnapshotListener != null) {
                takeSnapshotListener.onComplete(null);
            }
        }
    }

    public static /* synthetic */ void a(i iVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, GLConstants.ResolutionMode resolutionMode) {
        iVar.a(streamType, videoEncodeParams, resolutionMode);
        iVar.a(streamType, videoEncodeParams);
        com.tencent.liteav.videoproducer.encoder.ax axVar = iVar.f45015x.get(streamType);
        if (axVar != null) {
            axVar.a(bc.a(axVar, videoEncodeParams), "reconfig");
        }
    }

    public static /* synthetic */ void a(i iVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        if (iVar.f45015x.get(streamType) != null) {
            LiteavLog.w(iVar.f44992a, "%s video encoder is started", streamType.toString());
            return;
        }
        LiteavLog.i(iVar.f44992a, "startEncodeStreamInternal: " + ((Object) streamType) + "; " + ((Object) videoEncodeParams));
        iVar.a(streamType, videoEncodeParams, (GLConstants.ResolutionMode) null);
        iVar.a(streamType, videoEncodeParams);
        videoEncodeParams.mediaCodecDeviceRelatedParams = iVar.f45013v;
        com.tencent.liteav.videoproducer.encoder.ax axVar = new com.tencent.liteav.videoproducer.encoder.ax(iVar.f44993b, streamType, videoEncodeParams.isTranscodingMode());
        synchronized (axVar) {
            if (axVar.f44573f) {
                LiteavLog.i(axVar.f44568a, "already initialzied");
            } else {
                LiteavLog.i(axVar.f44568a, "initialzie");
                HandlerThread handlerThread = new HandlerThread("video-encoder");
                handlerThread.start();
                axVar.f44572e = new CustomHandler(handlerThread.getLooper());
                axVar.f44573f = true;
            }
        }
        axVar.a(iVar.f45003l);
        axVar.a(iVar.f45014w.get(streamType));
        iVar.f45015x.put(streamType, axVar);
        axVar.a(be.a(axVar, videoEncodeParams, videoEncoderDataListener), "Start");
    }
}
