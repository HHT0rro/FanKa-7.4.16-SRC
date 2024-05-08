package com.tencent.liteav.videoconsumer.consumer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.a;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ap;
import com.tencent.liteav.videoconsumer.decoder.bl;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public final PriorityQueue<a> A;
    public final Runnable B;
    public final bl C;
    private final VideoRenderListener D;

    /* renamed from: a, reason: collision with root package name */
    public final String f43692a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.base.util.l f43693b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f43694c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.liteav.videoconsumer.renderer.s f43695d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.liteav.videoconsumer.renderer.t f43696e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.liteav.videoconsumer.consumer.a f43697f;

    /* renamed from: g, reason: collision with root package name */
    public final VideoDecodeController f43698g;

    /* renamed from: h, reason: collision with root package name */
    public VideoRenderListener f43699h;

    /* renamed from: i, reason: collision with root package name */
    public final VideoRenderListener f43700i;

    /* renamed from: j, reason: collision with root package name */
    public final BroadcastReceiver f43701j;

    /* renamed from: k, reason: collision with root package name */
    public DisplayTarget f43702k;

    /* renamed from: l, reason: collision with root package name */
    public GLConstants.GLScaleType f43703l;

    /* renamed from: m, reason: collision with root package name */
    public Rotation f43704m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f43705n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.videobase.utils.d f43706o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f43707p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f43708q;

    /* renamed from: r, reason: collision with root package name */
    public final com.tencent.liteav.videobase.utils.f f43709r;

    /* renamed from: s, reason: collision with root package name */
    public EnumC0643b f43710s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f43711t;

    /* renamed from: u, reason: collision with root package name */
    public int f43712u;

    /* renamed from: v, reason: collision with root package name */
    public int f43713v;

    /* renamed from: w, reason: collision with root package name */
    public VideoDecoderDef.ConsumerScene f43714w;

    /* renamed from: x, reason: collision with root package name */
    public Object f43715x;

    /* renamed from: y, reason: collision with root package name */
    public final AtomicLong f43716y;

    /* renamed from: z, reason: collision with root package name */
    public final com.tencent.liteav.videobase.utils.m f43717z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        private final long f43722a;

        /* renamed from: b, reason: collision with root package name */
        private final int f43723b;

        public a(long j10, int i10) {
            this.f43722a = j10;
            this.f43723b = i10;
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
            return (int) (this.f43722a - aVar.f43722a);
        }
    }

    /* renamed from: com.tencent.liteav.videoconsumer.consumer.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum EnumC0643b {
        STOPPED,
        STARTED,
        PAUSED
    }

    public b(@NonNull IVideoReporter iVideoReporter) {
        String str = "VideoConsumer" + hashCode();
        this.f43692a = str;
        this.D = new VideoRenderListener() { // from class: com.tencent.liteav.videoconsumer.consumer.b.1
            @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
            public final void onRenderFrame(PixelFrame pixelFrame, VideoRenderListener.a aVar) {
                VideoRenderListener videoRenderListener;
                if (pixelFrame != null) {
                    b.this.f43694c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_CONSUMER_FINISH_HANDLE_FRAME, pixelFrame.getConsumerChainTimestamp());
                }
                b.this.f43695d.a(true, aVar, pixelFrame);
                if (aVar == VideoRenderListener.a.RENDER_FAILED || (videoRenderListener = b.this.f43699h) == null) {
                    return;
                }
                videoRenderListener.onRenderFrame(pixelFrame, aVar);
            }
        };
        this.f43700i = new VideoRenderListener() { // from class: com.tencent.liteav.videoconsumer.consumer.b.2
            @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
            public final void onRenderFrame(PixelFrame pixelFrame, VideoRenderListener.a aVar) {
                if (pixelFrame != null) {
                    b.this.f43694c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_CONSUMER_FINISH_HANDLE_FRAME, pixelFrame.getConsumerChainTimestamp());
                }
                b.this.f43695d.a(false, aVar, pixelFrame);
            }

            @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
            public final void onRenderSurfaceChanged(Surface surface) {
                VideoDecodeController videoDecodeController = b.this.f43698g;
                videoDecodeController.a(ap.a(videoDecodeController, surface));
            }
        };
        this.f43701j = new BroadcastReceiver() { // from class: com.tencent.liteav.videoconsumer.consumer.b.3
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (intent != null && context != null) {
                    String action = intent.getAction();
                    if ("com.tencent.liteav.video.action.OUT_OF_MEMORY".equals(action)) {
                        LiteavLog.d(b.this.f43692a, "onReceive, action:".concat(String.valueOf(action)));
                        b.this.f43694c.notifyWarning(h.c.WARNING_OUT_OF_MEMORY, null);
                        return;
                    }
                    return;
                }
                LiteavLog.w(b.this.f43692a, "onReceive, intent or context is null!");
            }
        };
        this.f43703l = GLConstants.GLScaleType.CENTER_CROP;
        this.f43704m = Rotation.NORMAL;
        this.f43705n = false;
        this.f43706o = new com.tencent.liteav.videobase.utils.d();
        this.f43707p = false;
        this.f43708q = false;
        this.f43710s = EnumC0643b.STOPPED;
        this.f43711t = false;
        this.f43712u = 0;
        this.f43713v = 0;
        this.f43714w = VideoDecoderDef.ConsumerScene.UNKNOWN;
        this.f43715x = null;
        this.f43716y = new AtomicLong(0L);
        this.f43717z = new com.tencent.liteav.videobase.utils.m();
        this.A = new PriorityQueue<>();
        this.B = c.a(this);
        this.C = new AnonymousClass4();
        this.f43694c = iVideoReporter;
        this.f43695d = new com.tencent.liteav.videoconsumer.renderer.s(iVideoReporter);
        this.f43698g = new VideoDecodeController(iVideoReporter);
        this.f43709r = new com.tencent.liteav.videobase.utils.f("VideoConsumer", new f.a(this) { // from class: com.tencent.liteav.videoconsumer.consumer.n

            /* renamed from: a, reason: collision with root package name */
            private final b f43752a;

            {
                this.f43752a = this;
            }

            @Override // com.tencent.liteav.videobase.utils.f.a
            public final void a(double d10) {
                this.f43752a.f43694c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CONSUMER_RECEIVE_FPS, Double.valueOf(d10));
            }
        });
        this.f43693b = new com.tencent.liteav.base.util.l(15, str);
        this.f43697f = new com.tencent.liteav.videoconsumer.consumer.a(a.EnumC0642a.f43689a);
    }

    public final void a(boolean z10) {
        a(v.a(this, z10), false);
    }

    public final void a(com.tencent.liteav.videoconsumer.renderer.r rVar) {
        if (rVar == null) {
            return;
        }
        boolean z10 = rVar instanceof com.tencent.liteav.videoconsumer.consumer.a;
        rVar.a(z10 ? this.D : this.f43700i);
        rVar.a(this.f43702k, true);
        rVar.a(this.f43704m);
        rVar.a(this.f43703l);
        rVar.b(this.f43705n);
        this.f43695d.a(z10);
    }

    /* renamed from: com.tencent.liteav.videoconsumer.consumer.b$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass4 extends bl {
        public AnonymousClass4() {
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.bl
        public final void a(PixelFrame pixelFrame, long j10) {
            if (pixelFrame != null) {
                b bVar = b.this;
                if (bVar.f43710s != EnumC0643b.STARTED) {
                    return;
                }
                bVar.f43717z.a(pixelFrame);
                b bVar2 = b.this;
                bVar2.a(bVar2.B, false);
            }
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.bl
        public final void a() {
            b.this.a(z.a(this), false);
        }
    }

    public final void a(Runnable runnable, boolean z10) {
        if (z10) {
            this.f43693b.a(r.a(this, runnable));
        } else {
            this.f43693b.a(runnable);
        }
    }

    public final List<com.tencent.liteav.videoconsumer.renderer.r> a() {
        ArrayList arrayList = new ArrayList();
        com.tencent.liteav.videoconsumer.renderer.t tVar = this.f43696e;
        if (tVar != null) {
            arrayList.add(tVar);
        }
        arrayList.add(this.f43697f);
        return arrayList;
    }
}
