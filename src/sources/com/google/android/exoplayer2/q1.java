package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r1;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: SimpleExoPlayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class q1 extends e implements p {
    public boolean A;

    @Nullable
    public TextureView B;
    public int C;
    public int D;
    public int E;

    @Nullable
    public z4.d F;

    @Nullable
    public z4.d G;
    public int H;
    public x4.d I;
    public float J;
    public boolean K;
    public List<e6.a> L;
    public boolean M;
    public boolean N;

    @Nullable
    public PriorityTaskManager O;
    public boolean P;
    public boolean Q;
    public a5.b R;
    public q6.y S;

    /* renamed from: b, reason: collision with root package name */
    public final l1[] f21061b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f21062c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f21063d;

    /* renamed from: e, reason: collision with root package name */
    public final o0 f21064e;

    /* renamed from: f, reason: collision with root package name */
    public final c f21065f;

    /* renamed from: g, reason: collision with root package name */
    public final d f21066g;

    /* renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArraySet<q6.l> f21067h;

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArraySet<x4.f> f21068i;

    /* renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArraySet<e6.j> f21069j;

    /* renamed from: k, reason: collision with root package name */
    public final CopyOnWriteArraySet<n5.e> f21070k;

    /* renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArraySet<a5.c> f21071l;

    /* renamed from: m, reason: collision with root package name */
    public final w4.h1 f21072m;

    /* renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.b f21073n;

    /* renamed from: o, reason: collision with root package name */
    public final com.google.android.exoplayer2.d f21074o;

    /* renamed from: p, reason: collision with root package name */
    public final r1 f21075p;

    /* renamed from: q, reason: collision with root package name */
    public final t1 f21076q;

    /* renamed from: r, reason: collision with root package name */
    public final u1 f21077r;

    /* renamed from: s, reason: collision with root package name */
    public final long f21078s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public Format f21079t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public Format f21080u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public AudioTrack f21081v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public Object f21082w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public Surface f21083x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public SurfaceHolder f21084y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public SphericalGLSurfaceView f21085z;

    /* compiled from: SimpleExoPlayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f21086a;

        /* renamed from: b, reason: collision with root package name */
        public final o1 f21087b;

        /* renamed from: c, reason: collision with root package name */
        public Clock f21088c;

        /* renamed from: d, reason: collision with root package name */
        public long f21089d;

        /* renamed from: e, reason: collision with root package name */
        public n6.i f21090e;

        /* renamed from: f, reason: collision with root package name */
        public com.google.android.exoplayer2.source.a0 f21091f;

        /* renamed from: g, reason: collision with root package name */
        public v0 f21092g;

        /* renamed from: h, reason: collision with root package name */
        public o6.e f21093h;

        /* renamed from: i, reason: collision with root package name */
        public w4.h1 f21094i;

        /* renamed from: j, reason: collision with root package name */
        public Looper f21095j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public PriorityTaskManager f21096k;

        /* renamed from: l, reason: collision with root package name */
        public x4.d f21097l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f21098m;

        /* renamed from: n, reason: collision with root package name */
        public int f21099n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f21100o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f21101p;

        /* renamed from: q, reason: collision with root package name */
        public int f21102q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f21103r;

        /* renamed from: s, reason: collision with root package name */
        public p1 f21104s;

        /* renamed from: t, reason: collision with root package name */
        public long f21105t;

        /* renamed from: u, reason: collision with root package name */
        public long f21106u;

        /* renamed from: v, reason: collision with root package name */
        public u0 f21107v;

        /* renamed from: w, reason: collision with root package name */
        public long f21108w;

        /* renamed from: x, reason: collision with root package name */
        public long f21109x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f21110y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f21111z;

        public b(Context context) {
            this(context, new n(context), new d5.c());
        }

        public b A(com.google.android.exoplayer2.source.a0 a0Var) {
            com.google.android.exoplayer2.util.a.g(!this.f21111z);
            this.f21091f = a0Var;
            return this;
        }

        public q1 z() {
            com.google.android.exoplayer2.util.a.g(!this.f21111z);
            this.f21111z = true;
            return new q1(this);
        }

        public b(Context context, o1 o1Var, d5.i iVar) {
            this(context, o1Var, new DefaultTrackSelector(context), new com.google.android.exoplayer2.source.i(context, iVar), new l(), o6.n.m(context), new w4.h1(Clock.f22902a));
        }

        public b(Context context, o1 o1Var, n6.i iVar, com.google.android.exoplayer2.source.a0 a0Var, v0 v0Var, o6.e eVar, w4.h1 h1Var) {
            this.f21086a = context;
            this.f21087b = o1Var;
            this.f21090e = iVar;
            this.f21091f = a0Var;
            this.f21092g = v0Var;
            this.f21093h = eVar;
            this.f21094i = h1Var;
            this.f21095j = com.google.android.exoplayer2.util.j0.P();
            this.f21097l = x4.d.f54384f;
            this.f21099n = 0;
            this.f21102q = 1;
            this.f21103r = true;
            this.f21104s = p1.f21055g;
            this.f21105t = 5000L;
            this.f21106u = 15000L;
            this.f21107v = new k.b().a();
            this.f21088c = Clock.f22902a;
            this.f21108w = 500L;
            this.f21109x = 2000L;
        }
    }

    /* compiled from: SimpleExoPlayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements q6.x, com.google.android.exoplayer2.audio.a, e6.j, n5.e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, d.b, b.InterfaceC0186b, r1.b, Player.c, p.a {
        public c() {
        }

        @Override // q6.x
        public void A(Exception exc) {
            q1.this.f21072m.A(exc);
        }

        @Override // q6.x
        public void C(z4.d dVar) {
            q1.this.f21072m.C(dVar);
            q1.this.f21079t = null;
            q1.this.F = null;
        }

        @Override // q6.x
        public void D(Object obj, long j10) {
            q1.this.f21072m.D(obj, j10);
            if (q1.this.f21082w == obj) {
                Iterator iterator2 = q1.this.f21067h.iterator2();
                while (iterator2.hasNext()) {
                    ((q6.l) iterator2.next()).onRenderedFirstFrame();
                }
            }
        }

        @Override // com.google.android.exoplayer2.audio.a
        public /* synthetic */ void E(Format format) {
            x4.g.a(this, format);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void H(int i10, long j10, long j11) {
            q1.this.f21072m.H(i10, j10, j11);
        }

        @Override // q6.x
        public void a(String str) {
            q1.this.f21072m.a(str);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void b(Exception exc) {
            q1.this.f21072m.b(exc);
        }

        @Override // com.google.android.exoplayer2.b.InterfaceC0186b
        public void c() {
            q1.this.q1(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.p.a
        public void d(boolean z10) {
            q1.this.r1();
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void e(String str) {
            q1.this.f21072m.e(str);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void f(String str, long j10, long j11) {
            q1.this.f21072m.f(str, j10, j11);
        }

        @Override // com.google.android.exoplayer2.r1.b
        public void g(int i10) {
            a5.b W0 = q1.W0(q1.this.f21075p);
            if (W0.equals(q1.this.R)) {
                return;
            }
            q1.this.R = W0;
            Iterator iterator2 = q1.this.f21071l.iterator2();
            while (iterator2.hasNext()) {
                ((a5.c) iterator2.next()).onDeviceInfoChanged(W0);
            }
        }

        @Override // q6.x
        public void h(z4.d dVar) {
            q1.this.F = dVar;
            q1.this.f21072m.h(dVar);
        }

        @Override // q6.x
        public void i(int i10, long j10) {
            q1.this.f21072m.i(i10, j10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void j(z4.d dVar) {
            q1.this.f21072m.j(dVar);
            q1.this.f21080u = null;
            q1.this.G = null;
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void k(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            q1.this.f21080u = format;
            q1.this.f21072m.k(format, decoderReuseEvaluation);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void l(Surface surface) {
            q1.this.o1(null);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void m(Exception exc) {
            q1.this.f21072m.m(exc);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void n(Surface surface) {
            q1.this.o1(surface);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void o(z4.d dVar) {
            q1.this.G = dVar;
            q1.this.f21072m.o(dVar);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onAvailableCommandsChanged(Player.b bVar) {
            g1.a(this, bVar);
        }

        @Override // e6.j
        public void onCues(List<e6.a> list) {
            q1.this.L = list;
            Iterator iterator2 = q1.this.f21069j.iterator2();
            while (iterator2.hasNext()) {
                ((e6.j) iterator2.next()).onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onEvents(Player player, Player.d dVar) {
            g1.b(this, player, dVar);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onIsLoadingChanged(boolean z10) {
            if (q1.this.O != null) {
                if (z10 && !q1.this.P) {
                    q1.this.O.a(0);
                    q1.this.P = true;
                } else {
                    if (z10 || !q1.this.P) {
                        return;
                    }
                    q1.this.O.c(0);
                    q1.this.P = false;
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            g1.c(this, z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            g1.d(this, z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onMediaItemTransition(w0 w0Var, int i10) {
            g1.f(this, w0Var, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            g1.g(this, mediaMetadata);
        }

        @Override // n5.e
        public void onMetadata(Metadata metadata) {
            q1.this.f21072m.onMetadata(metadata);
            q1.this.f21064e.y1(metadata);
            Iterator iterator2 = q1.this.f21070k.iterator2();
            while (iterator2.hasNext()) {
                ((n5.e) iterator2.next()).onMetadata(metadata);
            }
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlayWhenReadyChanged(boolean z10, int i10) {
            q1.this.r1();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlaybackParametersChanged(f1 f1Var) {
            g1.h(this, f1Var);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlaybackStateChanged(int i10) {
            q1.this.r1();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            g1.i(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            g1.j(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            g1.k(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
            g1.l(this, z10, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPositionDiscontinuity(int i10) {
            g1.m(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPositionDiscontinuity(Player.f fVar, Player.f fVar2, int i10) {
            g1.n(this, fVar, fVar2, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onRepeatModeChanged(int i10) {
            g1.o(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onSeekProcessed() {
            g1.p(this);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            g1.q(this, z10);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void onSkipSilenceEnabledChanged(boolean z10) {
            if (q1.this.K == z10) {
                return;
            }
            q1.this.K = z10;
            q1.this.c1();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onStaticMetadataChanged(List list) {
            g1.r(this, list);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            q1.this.n1(surfaceTexture);
            q1.this.b1(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            q1.this.o1(null);
            q1.this.b1(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            q1.this.b1(i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
            g1.s(this, timeline, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, n6.h hVar) {
            g1.t(this, trackGroupArray, hVar);
        }

        @Override // q6.x
        public void onVideoSizeChanged(q6.y yVar) {
            q1.this.S = yVar;
            q1.this.f21072m.onVideoSizeChanged(yVar);
            Iterator iterator2 = q1.this.f21067h.iterator2();
            while (iterator2.hasNext()) {
                q6.l lVar = (q6.l) iterator2.next();
                lVar.onVideoSizeChanged(yVar);
                lVar.onVideoSizeChanged(yVar.f53148a, yVar.f53149b, yVar.f53150c, yVar.f53151d);
            }
        }

        @Override // com.google.android.exoplayer2.r1.b
        public void p(int i10, boolean z10) {
            Iterator iterator2 = q1.this.f21071l.iterator2();
            while (iterator2.hasNext()) {
                ((a5.c) iterator2.next()).onDeviceVolumeChanged(i10, z10);
            }
        }

        @Override // q6.x
        public void q(long j10, int i10) {
            q1.this.f21072m.q(j10, i10);
        }

        @Override // com.google.android.exoplayer2.d.b
        public void r(float f10) {
            q1.this.l1();
        }

        @Override // q6.x
        public void s(String str, long j10, long j11) {
            q1.this.f21072m.s(str, j10, j11);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            q1.this.b1(i11, i12);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (q1.this.A) {
                q1.this.o1(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (q1.this.A) {
                q1.this.o1(null);
            }
            q1.this.b1(0, 0);
        }

        @Override // com.google.android.exoplayer2.d.b
        public void t(int i10) {
            boolean o10 = q1.this.o();
            q1.this.q1(o10, i10, q1.Y0(o10, i10));
        }

        @Override // com.google.android.exoplayer2.p.a
        public /* synthetic */ void u(boolean z10) {
            o.a(this, z10);
        }

        @Override // q6.x
        public /* synthetic */ void x(Format format) {
            q6.m.a(this, format);
        }

        @Override // q6.x
        public void y(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            q1.this.f21079t = format;
            q1.this.f21072m.y(format, decoderReuseEvaluation);
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void z(long j10) {
            q1.this.f21072m.z(j10);
        }
    }

    /* compiled from: SimpleExoPlayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements q6.h, com.google.android.exoplayer2.video.spherical.a, PlayerMessage.Target {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public q6.h f21113b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.video.spherical.a f21114c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public q6.h f21115d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.video.spherical.a f21116e;

        public d() {
        }

        @Override // q6.h
        public void a(long j10, long j11, Format format, @Nullable MediaFormat mediaFormat) {
            q6.h hVar = this.f21115d;
            if (hVar != null) {
                hVar.a(j10, j11, format, mediaFormat);
            }
            q6.h hVar2 = this.f21113b;
            if (hVar2 != null) {
                hVar2.a(j10, j11, format, mediaFormat);
            }
        }

        @Override // com.google.android.exoplayer2.video.spherical.a
        public void c(long j10, float[] fArr) {
            com.google.android.exoplayer2.video.spherical.a aVar = this.f21116e;
            if (aVar != null) {
                aVar.c(j10, fArr);
            }
            com.google.android.exoplayer2.video.spherical.a aVar2 = this.f21114c;
            if (aVar2 != null) {
                aVar2.c(j10, fArr);
            }
        }

        @Override // com.google.android.exoplayer2.video.spherical.a
        public void d() {
            com.google.android.exoplayer2.video.spherical.a aVar = this.f21116e;
            if (aVar != null) {
                aVar.d();
            }
            com.google.android.exoplayer2.video.spherical.a aVar2 = this.f21114c;
            if (aVar2 != null) {
                aVar2.d();
            }
        }

        @Override // com.google.android.exoplayer2.PlayerMessage.Target
        public void i(int i10, @Nullable Object obj) {
            if (i10 == 6) {
                this.f21113b = (q6.h) obj;
                return;
            }
            if (i10 == 7) {
                this.f21114c = (com.google.android.exoplayer2.video.spherical.a) obj;
                return;
            }
            if (i10 != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f21115d = null;
                this.f21116e = null;
            } else {
                this.f21115d = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f21116e = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    public q1(b bVar) {
        q1 q1Var;
        c cVar;
        d dVar;
        Handler handler;
        o0 o0Var;
        com.google.android.exoplayer2.util.e eVar = new com.google.android.exoplayer2.util.e();
        this.f21062c = eVar;
        try {
            Context applicationContext = bVar.f21086a.getApplicationContext();
            this.f21063d = applicationContext;
            w4.h1 h1Var = bVar.f21094i;
            this.f21072m = h1Var;
            this.O = bVar.f21096k;
            this.I = bVar.f21097l;
            this.C = bVar.f21102q;
            this.K = bVar.f21101p;
            this.f21078s = bVar.f21109x;
            cVar = new c();
            this.f21065f = cVar;
            dVar = new d();
            this.f21066g = dVar;
            this.f21067h = new CopyOnWriteArraySet<>();
            this.f21068i = new CopyOnWriteArraySet<>();
            this.f21069j = new CopyOnWriteArraySet<>();
            this.f21070k = new CopyOnWriteArraySet<>();
            this.f21071l = new CopyOnWriteArraySet<>();
            handler = new Handler(bVar.f21095j);
            l1[] a10 = bVar.f21087b.a(handler, cVar, cVar, cVar, cVar);
            this.f21061b = a10;
            this.J = 1.0f;
            if (com.google.android.exoplayer2.util.j0.f22990a < 21) {
                this.H = a1(0);
            } else {
                this.H = h.a(applicationContext);
            }
            this.L = Collections.emptyList();
            this.M = true;
            try {
                o0Var = new o0(a10, bVar.f21090e, bVar.f21091f, bVar.f21092g, bVar.f21093h, h1Var, bVar.f21103r, bVar.f21104s, bVar.f21105t, bVar.f21106u, bVar.f21107v, bVar.f21108w, bVar.f21110y, bVar.f21088c, bVar.f21095j, this, new Player.b.a().c(20, 21, 22, 23, 24, 25, 26, 27).e());
                q1Var = this;
            } catch (Throwable th) {
                th = th;
                q1Var = this;
            }
        } catch (Throwable th2) {
            th = th2;
            q1Var = this;
        }
        try {
            q1Var.f21064e = o0Var;
            o0Var.H0(cVar);
            o0Var.G0(cVar);
            if (bVar.f21089d > 0) {
                o0Var.O0(bVar.f21089d);
            }
            com.google.android.exoplayer2.b bVar2 = new com.google.android.exoplayer2.b(bVar.f21086a, handler, cVar);
            q1Var.f21073n = bVar2;
            bVar2.b(bVar.f21100o);
            com.google.android.exoplayer2.d dVar2 = new com.google.android.exoplayer2.d(bVar.f21086a, handler, cVar);
            q1Var.f21074o = dVar2;
            dVar2.m(bVar.f21098m ? q1Var.I : null);
            r1 r1Var = new r1(bVar.f21086a, handler, cVar);
            q1Var.f21075p = r1Var;
            r1Var.h(com.google.android.exoplayer2.util.j0.c0(q1Var.I.f54388c));
            t1 t1Var = new t1(bVar.f21086a);
            q1Var.f21076q = t1Var;
            t1Var.a(bVar.f21099n != 0);
            u1 u1Var = new u1(bVar.f21086a);
            q1Var.f21077r = u1Var;
            u1Var.a(bVar.f21099n == 2);
            q1Var.R = W0(r1Var);
            q1Var.S = q6.y.f53146e;
            q1Var.k1(1, 102, Integer.valueOf(q1Var.H));
            q1Var.k1(2, 102, Integer.valueOf(q1Var.H));
            q1Var.k1(1, 3, q1Var.I);
            q1Var.k1(2, 4, Integer.valueOf(q1Var.C));
            q1Var.k1(1, 101, Boolean.valueOf(q1Var.K));
            q1Var.k1(2, 6, dVar);
            q1Var.k1(6, 7, dVar);
            eVar.e();
        } catch (Throwable th3) {
            th = th3;
            q1Var.f21062c.e();
            throw th;
        }
    }

    public static a5.b W0(r1 r1Var) {
        return new a5.b(0, r1Var.d(), r1Var.c());
    }

    public static int Y0(boolean z10, int i10) {
        return (!z10 || i10 == 1) ? 1 : 2;
    }

    @Override // com.google.android.exoplayer2.Player
    public int A() {
        s1();
        return this.f21064e.A();
    }

    @Override // com.google.android.exoplayer2.Player
    public List<e6.a> C() {
        s1();
        return this.L;
    }

    @Override // com.google.android.exoplayer2.Player
    public int D() {
        s1();
        return this.f21064e.D();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline E() {
        s1();
        return this.f21064e.E();
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper F() {
        return this.f21064e.F();
    }

    @Override // com.google.android.exoplayer2.Player
    public void H(@Nullable TextureView textureView) {
        s1();
        if (textureView == null) {
            U0();
            return;
        }
        h1();
        this.B = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            com.google.android.exoplayer2.util.m.h("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f21065f);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            o1(null);
            b1(0, 0);
        } else {
            n1(surfaceTexture);
            b1(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public n6.h I() {
        s1();
        return this.f21064e.I();
    }

    @Override // com.google.android.exoplayer2.Player
    public void J(int i10, long j10) {
        s1();
        this.f21072m.d2();
        this.f21064e.J(i10, j10);
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.b K() {
        s1();
        return this.f21064e.K();
    }

    @Override // com.google.android.exoplayer2.Player
    public q6.y L() {
        return this.S;
    }

    @Override // com.google.android.exoplayer2.Player
    public long M() {
        s1();
        return this.f21064e.M();
    }

    @Override // com.google.android.exoplayer2.Player
    public void N(Player.e eVar) {
        com.google.android.exoplayer2.util.a.e(eVar);
        O0(eVar);
        T0(eVar);
        S0(eVar);
        R0(eVar);
        P0(eVar);
        Q0(eVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public long O() {
        s1();
        return this.f21064e.O();
    }

    @Deprecated
    public void O0(x4.f fVar) {
        com.google.android.exoplayer2.util.a.e(fVar);
        this.f21068i.add(fVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public void P(@Nullable SurfaceView surfaceView) {
        s1();
        V0(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Deprecated
    public void P0(a5.c cVar) {
        com.google.android.exoplayer2.util.a.e(cVar);
        this.f21071l.add(cVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean Q() {
        s1();
        return this.f21064e.Q();
    }

    @Deprecated
    public void Q0(Player.c cVar) {
        com.google.android.exoplayer2.util.a.e(cVar);
        this.f21064e.H0(cVar);
    }

    @Deprecated
    public void R0(n5.e eVar) {
        com.google.android.exoplayer2.util.a.e(eVar);
        this.f21070k.add(eVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata S() {
        return this.f21064e.S();
    }

    @Deprecated
    public void S0(e6.j jVar) {
        com.google.android.exoplayer2.util.a.e(jVar);
        this.f21069j.add(jVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public long T() {
        s1();
        return this.f21064e.T();
    }

    @Deprecated
    public void T0(q6.l lVar) {
        com.google.android.exoplayer2.util.a.e(lVar);
        this.f21067h.add(lVar);
    }

    public void U0() {
        s1();
        h1();
        o1(null);
        b1(0, 0);
    }

    public void V0(@Nullable SurfaceHolder surfaceHolder) {
        s1();
        if (surfaceHolder == null || surfaceHolder != this.f21084y) {
            return;
        }
        U0();
    }

    public boolean X0() {
        s1();
        return this.f21064e.N0();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public ExoPlaybackException k() {
        s1();
        return this.f21064e.k();
    }

    @Override // com.google.android.exoplayer2.p
    @Nullable
    public n6.i a() {
        s1();
        return this.f21064e.a();
    }

    public final int a1(int i10) {
        AudioTrack audioTrack = this.f21081v;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i10) {
            this.f21081v.release();
            this.f21081v = null;
        }
        if (this.f21081v == null) {
            this.f21081v = new AudioTrack(3, 4000, 4, 2, 2, 0, i10);
        }
        return this.f21081v.getAudioSessionId();
    }

    @Override // com.google.android.exoplayer2.p
    public void b(com.google.android.exoplayer2.source.s sVar) {
        s1();
        this.f21064e.b(sVar);
    }

    public final void b1(int i10, int i11) {
        if (i10 == this.D && i11 == this.E) {
            return;
        }
        this.D = i10;
        this.E = i11;
        this.f21072m.onSurfaceSizeChanged(i10, i11);
        Iterator<q6.l> iterator2 = this.f21067h.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSurfaceSizeChanged(i10, i11);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void c(f1 f1Var) {
        s1();
        this.f21064e.c(f1Var);
    }

    public final void c1() {
        this.f21072m.onSkipSilenceEnabledChanged(this.K);
        Iterator<x4.f> iterator2 = this.f21068i.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onSkipSilenceEnabledChanged(this.K);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public f1 d() {
        s1();
        return this.f21064e.d();
    }

    @Deprecated
    public void d1(x4.f fVar) {
        this.f21068i.remove(fVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public void e(@Nullable Surface surface) {
        s1();
        h1();
        o1(surface);
        int i10 = surface == null ? 0 : -1;
        b1(i10, i10);
    }

    @Deprecated
    public void e1(a5.c cVar) {
        this.f21071l.remove(cVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean f() {
        s1();
        return this.f21064e.f();
    }

    @Deprecated
    public void f1(Player.c cVar) {
        this.f21064e.A1(cVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public long g() {
        s1();
        return this.f21064e.g();
    }

    @Deprecated
    public void g1(n5.e eVar) {
        this.f21070k.remove(eVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        s1();
        return this.f21064e.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        s1();
        return this.f21064e.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        s1();
        return this.f21064e.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        s1();
        return this.f21064e.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public void h(Player.e eVar) {
        com.google.android.exoplayer2.util.a.e(eVar);
        d1(eVar);
        j1(eVar);
        i1(eVar);
        g1(eVar);
        e1(eVar);
        f1(eVar);
    }

    public final void h1() {
        if (this.f21085z != null) {
            this.f21064e.L0(this.f21066g).setType(10000).setPayload(null).send();
            this.f21085z.i(this.f21065f);
            this.f21085z = null;
        }
        TextureView textureView = this.B;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f21065f) {
                com.google.android.exoplayer2.util.m.h("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.B.setSurfaceTextureListener(null);
            }
            this.B = null;
        }
        SurfaceHolder surfaceHolder = this.f21084y;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f21065f);
            this.f21084y = null;
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void i(List<w0> list, boolean z10) {
        s1();
        this.f21064e.i(list, z10);
    }

    @Deprecated
    public void i1(e6.j jVar) {
        this.f21069j.remove(jVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public void j(@Nullable SurfaceView surfaceView) {
        s1();
        if (surfaceView instanceof q6.g) {
            h1();
            o1(surfaceView);
            m1(surfaceView.getHolder());
        } else {
            if (surfaceView instanceof SphericalGLSurfaceView) {
                h1();
                this.f21085z = (SphericalGLSurfaceView) surfaceView;
                this.f21064e.L0(this.f21066g).setType(10000).setPayload(this.f21085z).send();
                this.f21085z.d(this.f21065f);
                o1(this.f21085z.getVideoSurface());
                m1(surfaceView.getHolder());
                return;
            }
            p1(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    @Deprecated
    public void j1(q6.l lVar) {
        this.f21067h.remove(lVar);
    }

    public final void k1(int i10, int i11, @Nullable Object obj) {
        for (l1 l1Var : this.f21061b) {
            if (l1Var.g() == i10) {
                this.f21064e.L0(l1Var).setType(i11).setPayload(obj).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int l() {
        s1();
        return this.f21064e.l();
    }

    public final void l1() {
        k1(1, 2, Float.valueOf(this.J * this.f21074o.g()));
    }

    public final void m1(SurfaceHolder surfaceHolder) {
        this.A = false;
        this.f21084y = surfaceHolder;
        surfaceHolder.addCallback(this.f21065f);
        Surface surface = this.f21084y.getSurface();
        if (surface != null && surface.isValid()) {
            Rect surfaceFrame = this.f21084y.getSurfaceFrame();
            b1(surfaceFrame.width(), surfaceFrame.height());
        } else {
            b1(0, 0);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray n() {
        s1();
        return this.f21064e.n();
    }

    public final void n1(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        o1(surface);
        this.f21083x = surface;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean o() {
        s1();
        return this.f21064e.o();
    }

    public final void o1(@Nullable Object obj) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        l1[] l1VarArr = this.f21061b;
        int length = l1VarArr.length;
        int i10 = 0;
        while (true) {
            z10 = true;
            if (i10 >= length) {
                break;
            }
            l1 l1Var = l1VarArr[i10];
            if (l1Var.g() == 2) {
                arrayList.add(this.f21064e.L0(l1Var).setType(1).setPayload(obj).send());
            }
            i10++;
        }
        Object obj2 = this.f21082w;
        if (obj2 == null || obj2 == obj) {
            z10 = false;
        } else {
            try {
                Iterator<E> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    ((PlayerMessage) iterator2.next()).blockUntilDelivered(this.f21078s);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z10 = false;
            Object obj3 = this.f21082w;
            Surface surface = this.f21083x;
            if (obj3 == surface) {
                surface.release();
                this.f21083x = null;
            }
        }
        this.f21082w = obj;
        if (z10) {
            this.f21064e.H1(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void p(boolean z10) {
        s1();
        this.f21064e.p(z10);
    }

    public void p1(@Nullable SurfaceHolder surfaceHolder) {
        s1();
        if (surfaceHolder == null) {
            U0();
            return;
        }
        h1();
        this.A = true;
        this.f21084y = surfaceHolder;
        surfaceHolder.addCallback(this.f21065f);
        Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            o1(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            b1(surfaceFrame.width(), surfaceFrame.height());
        } else {
            o1(null);
            b1(0, 0);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        s1();
        boolean o10 = o();
        int p10 = this.f21074o.p(o10, 2);
        q1(o10, p10, Y0(o10, p10));
        this.f21064e.prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void q(boolean z10) {
        s1();
        this.f21074o.p(o(), 1);
        this.f21064e.q(z10);
        this.L = Collections.emptyList();
    }

    public final void q1(boolean z10, int i10, int i11) {
        int i12 = 0;
        boolean z11 = z10 && i10 != -1;
        if (z11 && i10 != 1) {
            i12 = 1;
        }
        this.f21064e.G1(z11, i12, i11);
    }

    @Override // com.google.android.exoplayer2.Player
    public int r() {
        s1();
        return this.f21064e.r();
    }

    public final void r1() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.f21076q.b(o() && !X0());
                this.f21077r.b(o());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.f21076q.b(false);
        this.f21077r.b(false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        AudioTrack audioTrack;
        s1();
        if (com.google.android.exoplayer2.util.j0.f22990a < 21 && (audioTrack = this.f21081v) != null) {
            audioTrack.release();
            this.f21081v = null;
        }
        this.f21073n.b(false);
        this.f21075p.g();
        this.f21076q.b(false);
        this.f21077r.b(false);
        this.f21074o.i();
        this.f21064e.release();
        this.f21072m.e2();
        h1();
        Surface surface = this.f21083x;
        if (surface != null) {
            surface.release();
            this.f21083x = null;
        }
        if (this.P) {
            ((PriorityTaskManager) com.google.android.exoplayer2.util.a.e(this.O)).c(0);
            this.P = false;
        }
        this.L = Collections.emptyList();
        this.Q = true;
    }

    @Override // com.google.android.exoplayer2.Player
    public int s() {
        s1();
        return this.f21064e.s();
    }

    public final void s1() {
        this.f21062c.b();
        if (Thread.currentThread() != F().getThread()) {
            String D = com.google.android.exoplayer2.util.j0.D("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), F().getThread().getName());
            if (!this.M) {
                com.google.android.exoplayer2.util.m.i("SimpleExoPlayer", D, this.N ? null : new IllegalStateException());
                this.N = true;
                return;
            }
            throw new IllegalStateException(D);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z10) {
        s1();
        int p10 = this.f21074o.p(z10, getPlaybackState());
        q1(z10, p10, Y0(z10, p10));
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i10) {
        s1();
        this.f21064e.setRepeatMode(i10);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVolume(float f10) {
        s1();
        float q10 = com.google.android.exoplayer2.util.j0.q(f10, 0.0f, 1.0f);
        if (this.J == q10) {
            return;
        }
        this.J = q10;
        l1();
        this.f21072m.onVolumeChanged(q10);
        Iterator<x4.f> iterator2 = this.f21068i.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onVolumeChanged(q10);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void t(@Nullable TextureView textureView) {
        s1();
        if (textureView == null || textureView != this.B) {
            return;
        }
        U0();
    }

    @Override // com.google.android.exoplayer2.Player
    public int u() {
        s1();
        return this.f21064e.u();
    }

    @Override // com.google.android.exoplayer2.Player
    public long v() {
        s1();
        return this.f21064e.v();
    }

    @Override // com.google.android.exoplayer2.Player
    public long w() {
        s1();
        return this.f21064e.w();
    }
}
