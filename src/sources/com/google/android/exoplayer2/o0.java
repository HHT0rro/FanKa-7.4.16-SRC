package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.d1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ExoPlayerImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o0 extends e implements p {
    public p1 A;
    public ShuffleOrder B;
    public boolean C;
    public Player.b D;
    public MediaMetadata E;
    public MediaMetadata F;
    public e1 G;
    public int H;
    public int I;
    public long J;

    /* renamed from: b, reason: collision with root package name */
    public final TrackSelectorResult f20969b;

    /* renamed from: c, reason: collision with root package name */
    public final Player.b f20970c;

    /* renamed from: d, reason: collision with root package name */
    public final l1[] f20971d;

    /* renamed from: e, reason: collision with root package name */
    public final n6.i f20972e;

    /* renamed from: f, reason: collision with root package name */
    public final HandlerWrapper f20973f;

    /* renamed from: g, reason: collision with root package name */
    public final ExoPlayerImplInternal.c f20974g;

    /* renamed from: h, reason: collision with root package name */
    public final ExoPlayerImplInternal f20975h;

    /* renamed from: i, reason: collision with root package name */
    public final ListenerSet<Player.c> f20976i;

    /* renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArraySet<p.a> f20977j;

    /* renamed from: k, reason: collision with root package name */
    public final Timeline.b f20978k;

    /* renamed from: l, reason: collision with root package name */
    public final List<a> f20979l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f20980m;

    /* renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.a0 f20981n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public final w4.h1 f20982o;

    /* renamed from: p, reason: collision with root package name */
    public final Looper f20983p;

    /* renamed from: q, reason: collision with root package name */
    public final o6.e f20984q;

    /* renamed from: r, reason: collision with root package name */
    public final long f20985r;

    /* renamed from: s, reason: collision with root package name */
    public final long f20986s;

    /* renamed from: t, reason: collision with root package name */
    public final Clock f20987t;

    /* renamed from: u, reason: collision with root package name */
    public int f20988u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f20989v;

    /* renamed from: w, reason: collision with root package name */
    public int f20990w;

    /* renamed from: x, reason: collision with root package name */
    public int f20991x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f20992y;

    /* renamed from: z, reason: collision with root package name */
    public int f20993z;

    /* compiled from: ExoPlayerImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements b1 {

        /* renamed from: a, reason: collision with root package name */
        public final Object f20994a;

        /* renamed from: b, reason: collision with root package name */
        public Timeline f20995b;

        public a(Object obj, Timeline timeline) {
            this.f20994a = obj;
            this.f20995b = timeline;
        }

        @Override // com.google.android.exoplayer2.b1
        public Timeline a() {
            return this.f20995b;
        }

        @Override // com.google.android.exoplayer2.b1
        public Object getUid() {
            return this.f20994a;
        }
    }

    public o0(l1[] l1VarArr, n6.i iVar, com.google.android.exoplayer2.source.a0 a0Var, v0 v0Var, o6.e eVar, @Nullable w4.h1 h1Var, boolean z10, p1 p1Var, long j10, long j11, u0 u0Var, long j12, boolean z11, Clock clock, Looper looper, @Nullable Player player, Player.b bVar) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = com.google.android.exoplayer2.util.j0.f22994e;
        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length());
        sb2.append("Init ");
        sb2.append(hexString);
        sb2.append(" [");
        sb2.append("ExoPlayerLib/2.15.1");
        sb2.append("] [");
        sb2.append(str);
        sb2.append("]");
        com.google.android.exoplayer2.util.m.f("ExoPlayerImpl", sb2.toString());
        com.google.android.exoplayer2.util.a.g(l1VarArr.length > 0);
        this.f20971d = (l1[]) com.google.android.exoplayer2.util.a.e(l1VarArr);
        this.f20972e = (n6.i) com.google.android.exoplayer2.util.a.e(iVar);
        this.f20981n = a0Var;
        this.f20984q = eVar;
        this.f20982o = h1Var;
        this.f20980m = z10;
        this.A = p1Var;
        this.f20985r = j10;
        this.f20986s = j11;
        this.C = z11;
        this.f20983p = looper;
        this.f20987t = clock;
        this.f20988u = 0;
        final Player player2 = player != null ? player : this;
        this.f20976i = new ListenerSet<>(looper, clock, new ListenerSet.IterationFinishedEvent() { // from class: com.google.android.exoplayer2.e0
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                o0.a1(Player.this, (Player.c) obj, flagSet);
            }
        });
        this.f20977j = new CopyOnWriteArraySet<>();
        this.f20979l = new ArrayList();
        this.B = new ShuffleOrder.a(0);
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[l1VarArr.length], new ExoTrackSelection[l1VarArr.length], null);
        this.f20969b = trackSelectorResult;
        this.f20978k = new Timeline.b();
        Player.b e2 = new Player.b.a().c(1, 2, 12, 13, 14, 15, 16, 17, 18, 19).b(bVar).e();
        this.f20970c = e2;
        this.D = new Player.b.a().b(e2).a(3).a(9).e();
        MediaMetadata mediaMetadata = MediaMetadata.E;
        this.E = mediaMetadata;
        this.F = mediaMetadata;
        this.H = -1;
        this.f20973f = clock.d(looper, null);
        ExoPlayerImplInternal.c cVar = new ExoPlayerImplInternal.c() { // from class: com.google.android.exoplayer2.q
            @Override // com.google.android.exoplayer2.ExoPlayerImplInternal.c
            public final void a(ExoPlayerImplInternal.b bVar2) {
                o0.this.c1(bVar2);
            }
        };
        this.f20974g = cVar;
        this.G = e1.k(trackSelectorResult);
        if (h1Var != null) {
            h1Var.g2(player2, looper);
            N(h1Var);
            eVar.a(new Handler(looper), h1Var);
        }
        this.f20975h = new ExoPlayerImplInternal(l1VarArr, iVar, trackSelectorResult, v0Var, eVar, this.f20988u, this.f20989v, h1Var, p1Var, u0Var, j12, z11, looper, clock, cVar);
    }

    public static long X0(e1 e1Var) {
        Timeline.c cVar = new Timeline.c();
        Timeline.b bVar = new Timeline.b();
        e1Var.f19994a.h(e1Var.f19995b.f21883a, bVar);
        if (e1Var.f19996c == -9223372036854775807L) {
            return e1Var.f19994a.n(bVar.f19658c, cVar).c();
        }
        return bVar.m() + e1Var.f19996c;
    }

    public static boolean Z0(e1 e1Var) {
        return e1Var.f19998e == 3 && e1Var.f20005l && e1Var.f20006m == 0;
    }

    public static /* synthetic */ void a1(Player player, Player.c cVar, FlagSet flagSet) {
        cVar.onEvents(player, new Player.d(flagSet));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(final ExoPlayerImplInternal.b bVar) {
        this.f20973f.post(new Runnable() { // from class: com.google.android.exoplayer2.f0
            @Override // java.lang.Runnable
            public final void run() {
                o0.this.b1(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(Player.c cVar) {
        cVar.onMediaMetadataChanged(this.E);
    }

    public static /* synthetic */ void e1(Player.c cVar) {
        cVar.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(Player.c cVar) {
        cVar.onAvailableCommandsChanged(this.D);
    }

    public static /* synthetic */ void j1(e1 e1Var, Player.c cVar) {
        cVar.onPlayerErrorChanged(e1Var.f19999f);
    }

    public static /* synthetic */ void k1(e1 e1Var, Player.c cVar) {
        cVar.onPlayerError(e1Var.f19999f);
    }

    public static /* synthetic */ void l1(e1 e1Var, n6.h hVar, Player.c cVar) {
        cVar.onTracksChanged(e1Var.f20001h, hVar);
    }

    public static /* synthetic */ void m1(e1 e1Var, Player.c cVar) {
        cVar.onStaticMetadataChanged(e1Var.f20003j);
    }

    public static /* synthetic */ void o1(e1 e1Var, Player.c cVar) {
        cVar.onLoadingChanged(e1Var.f20000g);
        cVar.onIsLoadingChanged(e1Var.f20000g);
    }

    public static /* synthetic */ void p1(e1 e1Var, Player.c cVar) {
        cVar.onPlayerStateChanged(e1Var.f20005l, e1Var.f19998e);
    }

    public static /* synthetic */ void q1(e1 e1Var, Player.c cVar) {
        cVar.onPlaybackStateChanged(e1Var.f19998e);
    }

    public static /* synthetic */ void r1(e1 e1Var, int i10, Player.c cVar) {
        cVar.onPlayWhenReadyChanged(e1Var.f20005l, i10);
    }

    public static /* synthetic */ void s1(e1 e1Var, Player.c cVar) {
        cVar.onPlaybackSuppressionReasonChanged(e1Var.f20006m);
    }

    public static /* synthetic */ void t1(e1 e1Var, Player.c cVar) {
        cVar.onIsPlayingChanged(Z0(e1Var));
    }

    public static /* synthetic */ void u1(e1 e1Var, Player.c cVar) {
        cVar.onPlaybackParametersChanged(e1Var.f20007n);
    }

    public static /* synthetic */ void v1(e1 e1Var, int i10, Player.c cVar) {
        cVar.onTimelineChanged(e1Var.f19994a, i10);
    }

    public static /* synthetic */ void w1(int i10, Player.f fVar, Player.f fVar2, Player.c cVar) {
        cVar.onPositionDiscontinuity(i10);
        cVar.onPositionDiscontinuity(fVar, fVar2, i10);
    }

    @Override // com.google.android.exoplayer2.Player
    public int A() {
        int R0 = R0();
        if (R0 == -1) {
            return 0;
        }
        return R0;
    }

    public void A1(Player.c cVar) {
        this.f20976i.j(cVar);
    }

    public final e1 B1(int i10, int i11) {
        boolean z10 = false;
        com.google.android.exoplayer2.util.a.a(i10 >= 0 && i11 >= i10 && i11 <= this.f20979l.size());
        int A = A();
        Timeline E = E();
        int size = this.f20979l.size();
        this.f20990w++;
        C1(i10, i11);
        Timeline J0 = J0();
        e1 x12 = x1(this.G, J0, S0(E, J0));
        int i12 = x12.f19998e;
        if (i12 != 1 && i12 != 4 && i10 < i11 && i11 == size && A >= x12.f19994a.p()) {
            z10 = true;
        }
        if (z10) {
            x12 = x12.h(4);
        }
        this.f20975h.m0(i10, i11, this.B);
        return x12;
    }

    public final void C1(int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            this.f20979l.remove(i12);
        }
        this.B = this.B.h(i10, i11);
    }

    @Override // com.google.android.exoplayer2.Player
    public int D() {
        return this.G.f20006m;
    }

    public void D1(List<com.google.android.exoplayer2.source.s> list) {
        E1(list, true);
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline E() {
        return this.G.f19994a;
    }

    public void E1(List<com.google.android.exoplayer2.source.s> list, boolean z10) {
        F1(list, -1, -9223372036854775807L, z10);
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper F() {
        return this.f20983p;
    }

    public final void F1(List<com.google.android.exoplayer2.source.s> list, int i10, long j10, boolean z10) {
        int i11;
        long j11;
        int R0 = R0();
        long currentPosition = getCurrentPosition();
        this.f20990w++;
        if (!this.f20979l.isEmpty()) {
            C1(0, this.f20979l.size());
        }
        List<d1.c> I0 = I0(0, list);
        Timeline J0 = J0();
        if (!J0.q() && i10 >= J0.p()) {
            throw new IllegalSeekPositionException(J0, i10, j10);
        }
        if (z10) {
            j11 = -9223372036854775807L;
            i11 = J0.a(this.f20989v);
        } else if (i10 == -1) {
            i11 = R0;
            j11 = currentPosition;
        } else {
            i11 = i10;
            j11 = j10;
        }
        e1 x12 = x1(this.G, J0, T0(J0, i11, j11));
        int i12 = x12.f19998e;
        if (i11 != -1 && i12 != 1) {
            i12 = (J0.q() || i11 >= J0.p()) ? 4 : 2;
        }
        e1 h10 = x12.h(i12);
        this.f20975h.L0(I0, i11, h.d(j11), this.B);
        J1(h10, 0, 1, false, (this.G.f19995b.f21883a.equals(h10.f19995b.f21883a) || this.G.f19994a.q()) ? false : true, 4, Q0(h10), -1);
    }

    public void G0(p.a aVar) {
        this.f20977j.add(aVar);
    }

    public void G1(boolean z10, int i10, int i11) {
        e1 e1Var = this.G;
        if (e1Var.f20005l == z10 && e1Var.f20006m == i10) {
            return;
        }
        this.f20990w++;
        e1 e2 = e1Var.e(z10, i10);
        this.f20975h.O0(z10, i10);
        J1(e2, 0, i11, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public void H(@Nullable TextureView textureView) {
    }

    public void H0(Player.c cVar) {
        this.f20976i.c(cVar);
    }

    public void H1(boolean z10, @Nullable ExoPlaybackException exoPlaybackException) {
        e1 b4;
        if (z10) {
            b4 = B1(0, this.f20979l.size()).f(null);
        } else {
            e1 e1Var = this.G;
            b4 = e1Var.b(e1Var.f19995b);
            b4.f20010q = b4.f20012s;
            b4.f20011r = 0L;
        }
        e1 h10 = b4.h(1);
        if (exoPlaybackException != null) {
            h10 = h10.f(exoPlaybackException);
        }
        e1 e1Var2 = h10;
        this.f20990w++;
        this.f20975h.f1();
        J1(e1Var2, 0, 1, false, e1Var2.f19994a.q() && !this.G.f19994a.q(), 4, Q0(e1Var2), -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public n6.h I() {
        return new n6.h(this.G.f20002i.selections);
    }

    public final List<d1.c> I0(int i10, List<com.google.android.exoplayer2.source.s> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            d1.c cVar = new d1.c(list.get(i11), this.f20980m);
            arrayList.add(cVar);
            this.f20979l.add(i11 + i10, new a(cVar.f19877b, cVar.f19876a.Q()));
        }
        this.B = this.B.i(i10, arrayList.size());
        return arrayList;
    }

    public final void I1() {
        Player.b bVar = this.D;
        Player.b U = U(this.f20970c);
        this.D = U;
        if (U.equals(bVar)) {
            return;
        }
        this.f20976i.h(14, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.i0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                o0.this.h1((Player.c) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player
    public void J(int i10, long j10) {
        Timeline timeline = this.G.f19994a;
        if (i10 >= 0 && (timeline.q() || i10 < timeline.p())) {
            this.f20990w++;
            if (f()) {
                com.google.android.exoplayer2.util.m.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal.b bVar = new ExoPlayerImplInternal.b(this.G);
                bVar.b(1);
                this.f20974g.a(bVar);
                return;
            }
            int i11 = getPlaybackState() != 1 ? 2 : 1;
            int A = A();
            e1 x12 = x1(this.G.h(i11), timeline, T0(timeline, i10, j10));
            this.f20975h.z0(timeline, i10, h.d(j10));
            J1(x12, 0, 1, true, true, 1, Q0(x12), A);
            return;
        }
        throw new IllegalSeekPositionException(timeline, i10, j10);
    }

    public final Timeline J0() {
        return new i1(this.f20979l, this.B);
    }

    public final void J1(final e1 e1Var, final int i10, final int i11, boolean z10, boolean z11, final int i12, long j10, int i13) {
        e1 e1Var2 = this.G;
        this.G = e1Var;
        Pair<Boolean, Integer> M0 = M0(e1Var, e1Var2, z11, i12, !e1Var2.f19994a.equals(e1Var.f19994a));
        boolean booleanValue = ((Boolean) M0.first).booleanValue();
        final int intValue = ((Integer) M0.second).intValue();
        MediaMetadata mediaMetadata = this.E;
        if (booleanValue) {
            r3 = e1Var.f19994a.q() ? null : e1Var.f19994a.n(e1Var.f19994a.h(e1Var.f19995b.f21883a, this.f20978k).f19658c, this.f19991a).f19669c;
            mediaMetadata = r3 != null ? r3.f23165d : MediaMetadata.E;
        }
        if (!e1Var2.f20003j.equals(e1Var.f20003j)) {
            mediaMetadata = mediaMetadata.a().I(e1Var.f20003j).F();
        }
        boolean z12 = !mediaMetadata.equals(this.E);
        this.E = mediaMetadata;
        if (!e1Var2.f19994a.equals(e1Var.f19994a)) {
            this.f20976i.h(0, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.y
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.v1(e1.this, i10, (Player.c) obj);
                }
            });
        }
        if (z11) {
            final Player.f W0 = W0(i12, e1Var2, i13);
            final Player.f V0 = V0(j10);
            this.f20976i.h(12, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.g0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.w1(i12, W0, V0, (Player.c) obj);
                }
            });
        }
        if (booleanValue) {
            this.f20976i.h(1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.j0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.c) obj).onMediaItemTransition(w0.this, intValue);
                }
            });
        }
        if (e1Var2.f19999f != e1Var.f19999f) {
            this.f20976i.h(11, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.n0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.j1(e1.this, (Player.c) obj);
                }
            });
            if (e1Var.f19999f != null) {
                this.f20976i.h(11, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.l0
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        o0.k1(e1.this, (Player.c) obj);
                    }
                });
            }
        }
        TrackSelectorResult trackSelectorResult = e1Var2.f20002i;
        TrackSelectorResult trackSelectorResult2 = e1Var.f20002i;
        if (trackSelectorResult != trackSelectorResult2) {
            this.f20972e.d(trackSelectorResult2.info);
            final n6.h hVar = new n6.h(e1Var.f20002i.selections);
            this.f20976i.h(2, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.z
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.l1(e1.this, hVar, (Player.c) obj);
                }
            });
        }
        if (!e1Var2.f20003j.equals(e1Var.f20003j)) {
            this.f20976i.h(3, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.r
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.m1(e1.this, (Player.c) obj);
                }
            });
        }
        if (z12) {
            final MediaMetadata mediaMetadata2 = this.E;
            this.f20976i.h(15, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.k0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.c) obj).onMediaMetadataChanged(MediaMetadata.this);
                }
            });
        }
        if (e1Var2.f20000g != e1Var.f20000g) {
            this.f20976i.h(4, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.u
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.o1(e1.this, (Player.c) obj);
                }
            });
        }
        if (e1Var2.f19998e != e1Var.f19998e || e1Var2.f20005l != e1Var.f20005l) {
            this.f20976i.h(-1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.m0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.p1(e1.this, (Player.c) obj);
                }
            });
        }
        if (e1Var2.f19998e != e1Var.f19998e) {
            this.f20976i.h(5, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.w
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.q1(e1.this, (Player.c) obj);
                }
            });
        }
        if (e1Var2.f20005l != e1Var.f20005l) {
            this.f20976i.h(6, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.x
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.r1(e1.this, i11, (Player.c) obj);
                }
            });
        }
        if (e1Var2.f20006m != e1Var.f20006m) {
            this.f20976i.h(7, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.v
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.s1(e1.this, (Player.c) obj);
                }
            });
        }
        if (Z0(e1Var2) != Z0(e1Var)) {
            this.f20976i.h(8, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.s
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.t1(e1.this, (Player.c) obj);
                }
            });
        }
        if (!e1Var2.f20007n.equals(e1Var.f20007n)) {
            this.f20976i.h(13, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.t
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.u1(e1.this, (Player.c) obj);
                }
            });
        }
        if (z10) {
            this.f20976i.h(-1, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.d0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.c) obj).onSeekProcessed();
                }
            });
        }
        I1();
        this.f20976i.e();
        if (e1Var2.f20008o != e1Var.f20008o) {
            Iterator<p.a> iterator2 = this.f20977j.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().u(e1Var.f20008o);
            }
        }
        if (e1Var2.f20009p != e1Var.f20009p) {
            Iterator<p.a> iterator22 = this.f20977j.iterator2();
            while (iterator22.hasNext()) {
                iterator22.next().d(e1Var.f20009p);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.b K() {
        return this.D;
    }

    public final List<com.google.android.exoplayer2.source.s> K0(List<w0> list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(this.f20981n.b(list.get(i10)));
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.Player
    public q6.y L() {
        return q6.y.f53146e;
    }

    public PlayerMessage L0(PlayerMessage.Target target) {
        return new PlayerMessage(this.f20975h, target, this.G.f19994a, A(), this.f20987t, this.f20975h.A());
    }

    @Override // com.google.android.exoplayer2.Player
    public long M() {
        if (f()) {
            e1 e1Var = this.G;
            e1Var.f19994a.h(e1Var.f19995b.f21883a, this.f20978k);
            e1 e1Var2 = this.G;
            if (e1Var2.f19996c == -9223372036854775807L) {
                return e1Var2.f19994a.n(A(), this.f19991a).b();
            }
            return this.f20978k.l() + h.e(this.G.f19996c);
        }
        return getCurrentPosition();
    }

    public final Pair<Boolean, Integer> M0(e1 e1Var, e1 e1Var2, boolean z10, int i10, boolean z11) {
        Timeline timeline = e1Var2.f19994a;
        Timeline timeline2 = e1Var.f19994a;
        if (timeline2.q() && timeline.q()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i11 = 3;
        if (timeline2.q() != timeline.q()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (timeline.n(timeline.h(e1Var2.f19995b.f21883a, this.f20978k).f19658c, this.f19991a).f19667a.equals(timeline2.n(timeline2.h(e1Var.f19995b.f21883a, this.f20978k).f19658c, this.f19991a).f19667a)) {
            if (z10 && i10 == 0 && e1Var2.f19995b.f21886d < e1Var.f19995b.f21886d) {
                return new Pair<>(Boolean.TRUE, 0);
            }
            return new Pair<>(Boolean.FALSE, -1);
        }
        if (z10 && i10 == 0) {
            i11 = 1;
        } else if (z10 && i10 == 1) {
            i11 = 2;
        } else if (!z11) {
            throw new IllegalStateException();
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(i11));
    }

    @Override // com.google.android.exoplayer2.Player
    public void N(Player.e eVar) {
        H0(eVar);
    }

    public boolean N0() {
        return this.G.f20009p;
    }

    @Override // com.google.android.exoplayer2.Player
    public long O() {
        if (f()) {
            e1 e1Var = this.G;
            if (e1Var.f20004k.equals(e1Var.f19995b)) {
                return h.e(this.G.f20010q);
            }
            return getDuration();
        }
        return w();
    }

    public void O0(long j10) {
        this.f20975h.t(j10);
    }

    @Override // com.google.android.exoplayer2.Player
    public void P(@Nullable SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.Player
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public ImmutableList<e6.a> C() {
        return ImmutableList.of();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean Q() {
        return this.f20989v;
    }

    public final long Q0(e1 e1Var) {
        if (e1Var.f19994a.q()) {
            return h.d(this.J);
        }
        if (e1Var.f19995b.b()) {
            return e1Var.f20012s;
        }
        return z1(e1Var.f19994a, e1Var.f19995b, e1Var.f20012s);
    }

    public final int R0() {
        if (this.G.f19994a.q()) {
            return this.H;
        }
        e1 e1Var = this.G;
        return e1Var.f19994a.h(e1Var.f19995b.f21883a, this.f20978k).f19658c;
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata S() {
        return this.E;
    }

    @Nullable
    public final Pair<Object, Long> S0(Timeline timeline, Timeline timeline2) {
        long M = M();
        if (!timeline.q() && !timeline2.q()) {
            Pair<Object, Long> j10 = timeline.j(this.f19991a, this.f20978k, A(), h.d(M));
            Object obj = ((Pair) com.google.android.exoplayer2.util.j0.j(j10)).first;
            if (timeline2.b(obj) != -1) {
                return j10;
            }
            Object x02 = ExoPlayerImplInternal.x0(this.f19991a, this.f20978k, this.f20988u, this.f20989v, obj, timeline, timeline2);
            if (x02 != null) {
                timeline2.h(x02, this.f20978k);
                int i10 = this.f20978k.f19658c;
                return T0(timeline2, i10, timeline2.n(i10, this.f19991a).b());
            }
            return T0(timeline2, -1, -9223372036854775807L);
        }
        boolean z10 = !timeline.q() && timeline2.q();
        int R0 = z10 ? -1 : R0();
        if (z10) {
            M = -9223372036854775807L;
        }
        return T0(timeline2, R0, M);
    }

    @Override // com.google.android.exoplayer2.Player
    public long T() {
        return this.f20985r;
    }

    @Nullable
    public final Pair<Object, Long> T0(Timeline timeline, int i10, long j10) {
        if (timeline.q()) {
            this.H = i10;
            if (j10 == -9223372036854775807L) {
                j10 = 0;
            }
            this.J = j10;
            this.I = 0;
            return null;
        }
        if (i10 == -1 || i10 >= timeline.p()) {
            i10 = timeline.a(this.f20989v);
            j10 = timeline.n(i10, this.f19991a).b();
        }
        return timeline.j(this.f19991a, this.f20978k, i10, h.d(j10));
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public ExoPlaybackException k() {
        return this.G.f19999f;
    }

    public final Player.f V0(long j10) {
        Object obj;
        int i10;
        int A = A();
        Object obj2 = null;
        if (this.G.f19994a.q()) {
            obj = null;
            i10 = -1;
        } else {
            e1 e1Var = this.G;
            Object obj3 = e1Var.f19995b.f21883a;
            e1Var.f19994a.h(obj3, this.f20978k);
            i10 = this.G.f19994a.b(obj3);
            obj = obj3;
            obj2 = this.G.f19994a.n(A, this.f19991a).f19667a;
        }
        long e2 = h.e(j10);
        long e10 = this.G.f19995b.b() ? h.e(X0(this.G)) : e2;
        s.a aVar = this.G.f19995b;
        return new Player.f(obj2, A, obj, i10, e2, e10, aVar.f21884b, aVar.f21885c);
    }

    public final Player.f W0(int i10, e1 e1Var, int i11) {
        int i12;
        Object obj;
        Object obj2;
        int i13;
        long j10;
        long X0;
        Timeline.b bVar = new Timeline.b();
        if (e1Var.f19994a.q()) {
            i12 = i11;
            obj = null;
            obj2 = null;
            i13 = -1;
        } else {
            Object obj3 = e1Var.f19995b.f21883a;
            e1Var.f19994a.h(obj3, bVar);
            int i14 = bVar.f19658c;
            i12 = i14;
            obj2 = obj3;
            i13 = e1Var.f19994a.b(obj3);
            obj = e1Var.f19994a.n(i14, this.f19991a).f19667a;
        }
        if (i10 == 0) {
            j10 = bVar.f19660e + bVar.f19659d;
            if (e1Var.f19995b.b()) {
                s.a aVar = e1Var.f19995b;
                j10 = bVar.b(aVar.f21884b, aVar.f21885c);
                X0 = X0(e1Var);
            } else {
                if (e1Var.f19995b.f21887e != -1 && this.G.f19995b.b()) {
                    j10 = X0(this.G);
                }
                X0 = j10;
            }
        } else if (e1Var.f19995b.b()) {
            j10 = e1Var.f20012s;
            X0 = X0(e1Var);
        } else {
            j10 = bVar.f19660e + e1Var.f20012s;
            X0 = j10;
        }
        long e2 = h.e(j10);
        long e10 = h.e(X0);
        s.a aVar2 = e1Var.f19995b;
        return new Player.f(obj, i12, obj2, i13, e2, e10, aVar2.f21884b, aVar2.f21885c);
    }

    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public final void b1(ExoPlayerImplInternal.b bVar) {
        long j10;
        boolean z10;
        long j11;
        int i10 = this.f20990w - bVar.f19519c;
        this.f20990w = i10;
        boolean z11 = true;
        if (bVar.f19520d) {
            this.f20991x = bVar.f19521e;
            this.f20992y = true;
        }
        if (bVar.f19522f) {
            this.f20993z = bVar.f19523g;
        }
        if (i10 == 0) {
            Timeline timeline = bVar.f19518b.f19994a;
            if (!this.G.f19994a.q() && timeline.q()) {
                this.H = -1;
                this.J = 0L;
                this.I = 0;
            }
            if (!timeline.q()) {
                List<Timeline> E = ((i1) timeline).E();
                com.google.android.exoplayer2.util.a.g(E.size() == this.f20979l.size());
                for (int i11 = 0; i11 < E.size(); i11++) {
                    this.f20979l.get(i11).f20995b = E.get(i11);
                }
            }
            if (this.f20992y) {
                if (bVar.f19518b.f19995b.equals(this.G.f19995b) && bVar.f19518b.f19997d == this.G.f20012s) {
                    z11 = false;
                }
                if (z11) {
                    if (!timeline.q() && !bVar.f19518b.f19995b.b()) {
                        e1 e1Var = bVar.f19518b;
                        j11 = z1(timeline, e1Var.f19995b, e1Var.f19997d);
                    } else {
                        j11 = bVar.f19518b.f19997d;
                    }
                    j10 = j11;
                } else {
                    j10 = -9223372036854775807L;
                }
                z10 = z11;
            } else {
                j10 = -9223372036854775807L;
                z10 = false;
            }
            this.f20992y = false;
            J1(bVar.f19518b, 1, this.f20993z, false, z10, this.f20991x, j10, -1);
        }
    }

    @Override // com.google.android.exoplayer2.p
    @Nullable
    public n6.i a() {
        return this.f20972e;
    }

    @Override // com.google.android.exoplayer2.p
    public void b(com.google.android.exoplayer2.source.s sVar) {
        D1(Collections.singletonList(sVar));
    }

    @Override // com.google.android.exoplayer2.Player
    public void c(f1 f1Var) {
        if (f1Var == null) {
            f1Var = f1.f20696d;
        }
        if (this.G.f20007n.equals(f1Var)) {
            return;
        }
        e1 g3 = this.G.g(f1Var);
        this.f20990w++;
        this.f20975h.Q0(f1Var);
        J1(g3, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public f1 d() {
        return this.G.f20007n;
    }

    @Override // com.google.android.exoplayer2.Player
    public void e(@Nullable Surface surface) {
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean f() {
        return this.G.f19995b.b();
    }

    @Override // com.google.android.exoplayer2.Player
    public long g() {
        return h.e(this.G.f20011r);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        return h.e(Q0(this.G));
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        if (f()) {
            e1 e1Var = this.G;
            s.a aVar = e1Var.f19995b;
            e1Var.f19994a.h(aVar.f21883a, this.f20978k);
            return h.e(this.f20978k.b(aVar.f21884b, aVar.f21885c));
        }
        return V();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.G.f19998e;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.f20988u;
    }

    @Override // com.google.android.exoplayer2.Player
    public void h(Player.e eVar) {
        A1(eVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public void i(List<w0> list, boolean z10) {
        E1(K0(list), z10);
    }

    @Override // com.google.android.exoplayer2.Player
    public void j(@Nullable SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.Player
    public int l() {
        if (f()) {
            return this.G.f19995b.f21884b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray n() {
        return this.G.f20001h;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean o() {
        return this.G.f20005l;
    }

    @Override // com.google.android.exoplayer2.Player
    public void p(final boolean z10) {
        if (this.f20989v != z10) {
            this.f20989v = z10;
            this.f20975h.V0(z10);
            this.f20976i.h(10, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.a0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.c) obj).onShuffleModeEnabledChanged(z10);
                }
            });
            I1();
            this.f20976i.e();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        e1 e1Var = this.G;
        if (e1Var.f19998e != 1) {
            return;
        }
        e1 f10 = e1Var.f(null);
        e1 h10 = f10.h(f10.f19994a.q() ? 4 : 2);
        this.f20990w++;
        this.f20975h.h0();
        J1(h10, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public void q(boolean z10) {
        H1(z10, null);
    }

    @Override // com.google.android.exoplayer2.Player
    public int r() {
        return 3000;
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = com.google.android.exoplayer2.util.j0.f22994e;
        String b4 = r0.b();
        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + String.valueOf(b4).length());
        sb2.append("Release ");
        sb2.append(hexString);
        sb2.append(" [");
        sb2.append("ExoPlayerLib/2.15.1");
        sb2.append("] [");
        sb2.append(str);
        sb2.append("] [");
        sb2.append(b4);
        sb2.append("]");
        com.google.android.exoplayer2.util.m.f("ExoPlayerImpl", sb2.toString());
        if (!this.f20975h.j0()) {
            this.f20976i.k(11, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.c0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    o0.e1((Player.c) obj);
                }
            });
        }
        this.f20976i.i();
        this.f20973f.d(null);
        w4.h1 h1Var = this.f20982o;
        if (h1Var != null) {
            this.f20984q.g(h1Var);
        }
        e1 h10 = this.G.h(1);
        this.G = h10;
        e1 b10 = h10.b(h10.f19995b);
        this.G = b10;
        b10.f20010q = b10.f20012s;
        this.G.f20011r = 0L;
    }

    @Override // com.google.android.exoplayer2.Player
    public int s() {
        if (this.G.f19994a.q()) {
            return this.I;
        }
        e1 e1Var = this.G;
        return e1Var.f19994a.b(e1Var.f19995b.f21883a);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z10) {
        G1(z10, 0, 1);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(final int i10) {
        if (this.f20988u != i10) {
            this.f20988u = i10;
            this.f20975h.S0(i10);
            this.f20976i.h(9, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.b0
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.c) obj).onRepeatModeChanged(i10);
                }
            });
            I1();
            this.f20976i.e();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setVolume(float f10) {
    }

    @Override // com.google.android.exoplayer2.Player
    public void t(@Nullable TextureView textureView) {
    }

    @Override // com.google.android.exoplayer2.Player
    public int u() {
        if (f()) {
            return this.G.f19995b.f21885c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public long v() {
        return this.f20986s;
    }

    @Override // com.google.android.exoplayer2.Player
    public long w() {
        if (this.G.f19994a.q()) {
            return this.J;
        }
        e1 e1Var = this.G;
        if (e1Var.f20004k.f21886d != e1Var.f19995b.f21886d) {
            return e1Var.f19994a.n(A(), this.f19991a).d();
        }
        long j10 = e1Var.f20010q;
        if (this.G.f20004k.b()) {
            e1 e1Var2 = this.G;
            Timeline.b h10 = e1Var2.f19994a.h(e1Var2.f20004k.f21883a, this.f20978k);
            long f10 = h10.f(this.G.f20004k.f21884b);
            j10 = f10 == Long.MIN_VALUE ? h10.f19659d : f10;
        }
        e1 e1Var3 = this.G;
        return h.e(z1(e1Var3.f19994a, e1Var3.f20004k, j10));
    }

    public final e1 x1(e1 e1Var, Timeline timeline, @Nullable Pair<Object, Long> pair) {
        long j10;
        com.google.android.exoplayer2.util.a.a(timeline.q() || pair != null);
        Timeline timeline2 = e1Var.f19994a;
        e1 j11 = e1Var.j(timeline);
        if (timeline.q()) {
            s.a l10 = e1.l();
            long d10 = h.d(this.J);
            e1 b4 = j11.c(l10, d10, d10, d10, 0L, TrackGroupArray.f21171e, this.f20969b, ImmutableList.of()).b(l10);
            b4.f20010q = b4.f20012s;
            return b4;
        }
        Object obj = j11.f19995b.f21883a;
        boolean z10 = !obj.equals(((Pair) com.google.android.exoplayer2.util.j0.j(pair)).first);
        s.a aVar = z10 ? new s.a(pair.first) : j11.f19995b;
        long longValue = ((Long) pair.second).longValue();
        long d11 = h.d(M());
        if (!timeline2.q()) {
            d11 -= timeline2.h(obj, this.f20978k).m();
        }
        if (z10 || longValue < d11) {
            com.google.android.exoplayer2.util.a.g(!aVar.b());
            e1 b10 = j11.c(aVar, longValue, longValue, longValue, 0L, z10 ? TrackGroupArray.f21171e : j11.f20001h, z10 ? this.f20969b : j11.f20002i, z10 ? ImmutableList.of() : j11.f20003j).b(aVar);
            b10.f20010q = longValue;
            return b10;
        }
        if (longValue == d11) {
            int b11 = timeline.b(j11.f20004k.f21883a);
            if (b11 == -1 || timeline.f(b11, this.f20978k).f19658c != timeline.h(aVar.f21883a, this.f20978k).f19658c) {
                timeline.h(aVar.f21883a, this.f20978k);
                if (aVar.b()) {
                    j10 = this.f20978k.b(aVar.f21884b, aVar.f21885c);
                } else {
                    j10 = this.f20978k.f19659d;
                }
                j11 = j11.c(aVar, j11.f20012s, j11.f20012s, j11.f19997d, j10 - j11.f20012s, j11.f20001h, j11.f20002i, j11.f20003j).b(aVar);
                j11.f20010q = j10;
            }
        } else {
            com.google.android.exoplayer2.util.a.g(!aVar.b());
            long max = Math.max(0L, j11.f20011r - (longValue - d11));
            long j12 = j11.f20010q;
            if (j11.f20004k.equals(j11.f19995b)) {
                j12 = longValue + max;
            }
            j11 = j11.c(aVar, longValue, longValue, longValue, max, j11.f20001h, j11.f20002i, j11.f20003j);
            j11.f20010q = j12;
        }
        return j11;
    }

    public void y1(Metadata metadata) {
        MediaMetadata F = this.E.a().H(metadata).F();
        if (F.equals(this.E)) {
            return;
        }
        this.E = F;
        this.f20976i.k(15, new ListenerSet.Event() { // from class: com.google.android.exoplayer2.h0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                o0.this.d1((Player.c) obj);
            }
        });
    }

    public final long z1(Timeline timeline, s.a aVar, long j10) {
        timeline.h(aVar.f21883a, this.f20978k);
        return j10 + this.f20978k.m();
    }
}
