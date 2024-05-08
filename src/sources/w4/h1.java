package w4;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import o6.e;
import w4.i1;

/* compiled from: AnalyticsCollector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class h1 implements Player.e, com.google.android.exoplayer2.audio.a, q6.x, com.google.android.exoplayer2.source.z, e.a, com.google.android.exoplayer2.drm.b {

    /* renamed from: b, reason: collision with root package name */
    public final Clock f54146b;

    /* renamed from: c, reason: collision with root package name */
    public final Timeline.b f54147c;

    /* renamed from: d, reason: collision with root package name */
    public final Timeline.c f54148d;

    /* renamed from: e, reason: collision with root package name */
    public final a f54149e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray<i1.a> f54150f;

    /* renamed from: g, reason: collision with root package name */
    public ListenerSet<i1> f54151g;

    /* renamed from: h, reason: collision with root package name */
    public Player f54152h;

    /* renamed from: i, reason: collision with root package name */
    public HandlerWrapper f54153i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f54154j;

    /* compiled from: AnalyticsCollector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Timeline.b f54155a;

        /* renamed from: b, reason: collision with root package name */
        public ImmutableList<s.a> f54156b = ImmutableList.of();

        /* renamed from: c, reason: collision with root package name */
        public ImmutableMap<s.a, Timeline> f54157c = ImmutableMap.of();

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public s.a f54158d;

        /* renamed from: e, reason: collision with root package name */
        public s.a f54159e;

        /* renamed from: f, reason: collision with root package name */
        public s.a f54160f;

        public a(Timeline.b bVar) {
            this.f54155a = bVar;
        }

        @Nullable
        public static s.a c(Player player, ImmutableList<s.a> immutableList, @Nullable s.a aVar, Timeline.b bVar) {
            Timeline E = player.E();
            int s2 = player.s();
            Object m10 = E.q() ? null : E.m(s2);
            int d10 = (player.f() || E.q()) ? -1 : E.f(s2, bVar).d(com.google.android.exoplayer2.h.d(player.getCurrentPosition()) - bVar.m());
            for (int i10 = 0; i10 < immutableList.size(); i10++) {
                s.a aVar2 = immutableList.get(i10);
                if (i(aVar2, m10, player.f(), player.l(), player.u(), d10)) {
                    return aVar2;
                }
            }
            if (immutableList.isEmpty() && aVar != null) {
                if (i(aVar, m10, player.f(), player.l(), player.u(), d10)) {
                    return aVar;
                }
            }
            return null;
        }

        public static boolean i(s.a aVar, @Nullable Object obj, boolean z10, int i10, int i11, int i12) {
            if (aVar.f21883a.equals(obj)) {
                return (z10 && aVar.f21884b == i10 && aVar.f21885c == i11) || (!z10 && aVar.f21884b == -1 && aVar.f21887e == i12);
            }
            return false;
        }

        public final void b(ImmutableMap.b<s.a, Timeline> bVar, @Nullable s.a aVar, Timeline timeline) {
            if (aVar == null) {
                return;
            }
            if (timeline.b(aVar.f21883a) != -1) {
                bVar.g(aVar, timeline);
                return;
            }
            Timeline timeline2 = this.f54157c.get(aVar);
            if (timeline2 != null) {
                bVar.g(aVar, timeline2);
            }
        }

        @Nullable
        public s.a d() {
            return this.f54158d;
        }

        @Nullable
        public s.a e() {
            if (this.f54156b.isEmpty()) {
                return null;
            }
            return (s.a) com.google.common.collect.g0.f(this.f54156b);
        }

        @Nullable
        public Timeline f(s.a aVar) {
            return this.f54157c.get(aVar);
        }

        @Nullable
        public s.a g() {
            return this.f54159e;
        }

        @Nullable
        public s.a h() {
            return this.f54160f;
        }

        public void j(Player player) {
            this.f54158d = c(player, this.f54156b, this.f54159e, this.f54155a);
        }

        public void k(List<s.a> list, @Nullable s.a aVar, Player player) {
            this.f54156b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f54159e = list.get(0);
                this.f54160f = (s.a) com.google.android.exoplayer2.util.a.e(aVar);
            }
            if (this.f54158d == null) {
                this.f54158d = c(player, this.f54156b, this.f54159e, this.f54155a);
            }
            m(player.E());
        }

        public void l(Player player) {
            this.f54158d = c(player, this.f54156b, this.f54159e, this.f54155a);
            m(player.E());
        }

        public final void m(Timeline timeline) {
            ImmutableMap.b<s.a, Timeline> builder = ImmutableMap.builder();
            if (this.f54156b.isEmpty()) {
                b(builder, this.f54159e, timeline);
                if (!com.google.common.base.l.a(this.f54160f, this.f54159e)) {
                    b(builder, this.f54160f, timeline);
                }
                if (!com.google.common.base.l.a(this.f54158d, this.f54159e) && !com.google.common.base.l.a(this.f54158d, this.f54160f)) {
                    b(builder, this.f54158d, timeline);
                }
            } else {
                for (int i10 = 0; i10 < this.f54156b.size(); i10++) {
                    b(builder, this.f54156b.get(i10), timeline);
                }
                if (!this.f54156b.contains(this.f54158d)) {
                    b(builder, this.f54158d, timeline);
                }
            }
            this.f54157c = builder.a();
        }
    }

    public h1(Clock clock) {
        this.f54146b = (Clock) com.google.android.exoplayer2.util.a.e(clock);
        this.f54151g = new ListenerSet<>(com.google.android.exoplayer2.util.j0.P(), clock, new ListenerSet.IterationFinishedEvent() { // from class: w4.a1
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                h1.W0((i1) obj, flagSet);
            }
        });
        Timeline.b bVar = new Timeline.b();
        this.f54147c = bVar;
        this.f54148d = new Timeline.c();
        this.f54149e = new a(bVar);
        this.f54150f = new SparseArray<>();
    }

    public static /* synthetic */ void G1(i1.a aVar, int i10, Player.f fVar, Player.f fVar2, i1 i1Var) {
        i1Var.Y(aVar, i10);
        i1Var.I(aVar, fVar, fVar2, i10);
    }

    public static /* synthetic */ void S1(i1.a aVar, String str, long j10, long j11, i1 i1Var) {
        i1Var.u(aVar, str, j10);
        i1Var.V(aVar, str, j11, j10);
        i1Var.e(aVar, 2, str, j10);
    }

    public static /* synthetic */ void U1(i1.a aVar, z4.d dVar, i1 i1Var) {
        i1Var.x(aVar, dVar);
        i1Var.w(aVar, 2, dVar);
    }

    public static /* synthetic */ void V1(i1.a aVar, z4.d dVar, i1 i1Var) {
        i1Var.i0(aVar, dVar);
        i1Var.D(aVar, 2, dVar);
    }

    public static /* synthetic */ void W0(i1 i1Var, FlagSet flagSet) {
    }

    public static /* synthetic */ void X1(i1.a aVar, Format format, DecoderReuseEvaluation decoderReuseEvaluation, i1 i1Var) {
        i1Var.Q(aVar, format);
        i1Var.S(aVar, format, decoderReuseEvaluation);
        i1Var.k(aVar, 2, format);
    }

    public static /* synthetic */ void Y1(i1.a aVar, q6.y yVar, i1 i1Var) {
        i1Var.f0(aVar, yVar);
        i1Var.n(aVar, yVar.f53148a, yVar.f53149b, yVar.f53150c, yVar.f53151d);
    }

    public static /* synthetic */ void Z0(i1.a aVar, String str, long j10, long j11, i1 i1Var) {
        i1Var.W(aVar, str, j10);
        i1Var.H(aVar, str, j11, j10);
        i1Var.e(aVar, 1, str, j10);
    }

    public static /* synthetic */ void b1(i1.a aVar, z4.d dVar, i1 i1Var) {
        i1Var.e0(aVar, dVar);
        i1Var.w(aVar, 1, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2() {
        this.f54151g.i();
    }

    public static /* synthetic */ void c1(i1.a aVar, z4.d dVar, i1 i1Var) {
        i1Var.L(aVar, dVar);
        i1Var.D(aVar, 1, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(Player player, i1 i1Var, FlagSet flagSet) {
        i1Var.G(player, new i1.b(flagSet, this.f54150f));
    }

    public static /* synthetic */ void d1(i1.a aVar, Format format, DecoderReuseEvaluation decoderReuseEvaluation, i1 i1Var) {
        i1Var.j(aVar, format);
        i1Var.i(aVar, format, decoderReuseEvaluation);
        i1Var.k(aVar, 1, format);
    }

    public static /* synthetic */ void n1(i1.a aVar, int i10, i1 i1Var) {
        i1Var.s(aVar);
        i1Var.j0(aVar, i10);
    }

    public static /* synthetic */ void r1(i1.a aVar, boolean z10, i1 i1Var) {
        i1Var.n0(aVar, z10);
        i1Var.F(aVar, z10);
    }

    @Override // q6.x
    public final void A(final Exception exc) {
        final i1.a V0 = V0();
        f2(V0, DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, new ListenerSet.Event() { // from class: w4.c0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).K(i1.a.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void B(int i10, @Nullable s.a aVar, final Exception exc) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1032, new ListenerSet.Event() { // from class: w4.e0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).A(i1.a.this, exc);
            }
        });
    }

    @Override // q6.x
    public final void C(final z4.d dVar) {
        final i1.a U0 = U0();
        f2(U0, 1025, new ListenerSet.Event() { // from class: w4.r0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.U1(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    @Override // q6.x
    public final void D(final Object obj, final long j10) {
        final i1.a V0 = V0();
        f2(V0, 1027, new ListenerSet.Event() { // from class: w4.g0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj2) {
                ((i1) obj2).g(i1.a.this, obj, j10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public /* synthetic */ void E(Format format) {
        x4.g.a(this, format);
    }

    @Override // com.google.android.exoplayer2.source.z
    public final void F(int i10, @Nullable s.a aVar, final com.google.android.exoplayer2.source.m mVar, final MediaLoadData mediaLoadData) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1001, new ListenerSet.Event() { // from class: w4.u
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).a(i1.a.this, mVar, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void G(int i10, @Nullable s.a aVar) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, new ListenerSet.Event() { // from class: w4.h0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).d(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void H(final int i10, final long j10, final long j11) {
        final i1.a V0 = V0();
        f2(V0, 1012, new ListenerSet.Event() { // from class: w4.h
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).O(i1.a.this, i10, j10, j11);
            }
        });
    }

    public final i1.a P0() {
        return R0(this.f54149e.d());
    }

    public final i1.a Q0(Timeline timeline, int i10, @Nullable s.a aVar) {
        long M;
        s.a aVar2 = timeline.q() ? null : aVar;
        long a10 = this.f54146b.a();
        boolean z10 = timeline.equals(this.f54152h.E()) && i10 == this.f54152h.A();
        long j10 = 0;
        if (aVar2 != null && aVar2.b()) {
            if (z10 && this.f54152h.l() == aVar2.f21884b && this.f54152h.u() == aVar2.f21885c) {
                j10 = this.f54152h.getCurrentPosition();
            }
        } else {
            if (z10) {
                M = this.f54152h.M();
                return new i1.a(a10, timeline, i10, aVar2, M, this.f54152h.E(), this.f54152h.A(), this.f54149e.d(), this.f54152h.getCurrentPosition(), this.f54152h.g());
            }
            if (!timeline.q()) {
                j10 = timeline.n(i10, this.f54148d).b();
            }
        }
        M = j10;
        return new i1.a(a10, timeline, i10, aVar2, M, this.f54152h.E(), this.f54152h.A(), this.f54149e.d(), this.f54152h.getCurrentPosition(), this.f54152h.g());
    }

    public final i1.a R0(@Nullable s.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f54152h);
        Timeline f10 = aVar == null ? null : this.f54149e.f(aVar);
        if (aVar != null && f10 != null) {
            return Q0(f10, f10.h(aVar.f21883a, this.f54147c).f19658c, aVar);
        }
        int A = this.f54152h.A();
        Timeline E = this.f54152h.E();
        if (!(A < E.p())) {
            E = Timeline.f19653a;
        }
        return Q0(E, A, null);
    }

    public final i1.a S0() {
        return R0(this.f54149e.e());
    }

    public final i1.a T0(int i10, @Nullable s.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f54152h);
        if (aVar != null) {
            if (this.f54149e.f(aVar) != null) {
                return R0(aVar);
            }
            return Q0(Timeline.f19653a, i10, aVar);
        }
        Timeline E = this.f54152h.E();
        if (!(i10 < E.p())) {
            E = Timeline.f19653a;
        }
        return Q0(E, i10, null);
    }

    public final i1.a U0() {
        return R0(this.f54149e.g());
    }

    public final i1.a V0() {
        return R0(this.f54149e.h());
    }

    @Override // q6.x
    public final void a(final String str) {
        final i1.a V0 = V0();
        f2(V0, 1024, new ListenerSet.Event() { // from class: w4.j0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).f(i1.a.this, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void b(final Exception exc) {
        final i1.a V0 = V0();
        f2(V0, 1018, new ListenerSet.Event() { // from class: w4.d0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).h0(i1.a.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.z
    public final void c(int i10, @Nullable s.a aVar, final com.google.android.exoplayer2.source.m mVar, final MediaLoadData mediaLoadData) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1002, new ListenerSet.Event() { // from class: w4.x
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).M(i1.a.this, mVar, mediaLoadData);
            }
        });
    }

    @Override // o6.e.a
    public final void d(final int i10, final long j10, final long j11) {
        final i1.a S0 = S0();
        f2(S0, 1006, new ListenerSet.Event() { // from class: w4.g
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).b(i1.a.this, i10, j10, j11);
            }
        });
    }

    public final void d2() {
        if (this.f54154j) {
            return;
        }
        final i1.a P0 = P0();
        this.f54154j = true;
        f2(P0, -1, new ListenerSet.Event() { // from class: w4.l
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).b0(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void e(final String str) {
        final i1.a V0 = V0();
        f2(V0, 1013, new ListenerSet.Event() { // from class: w4.i0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).c(i1.a.this, str);
            }
        });
    }

    @CallSuper
    public void e2() {
        final i1.a P0 = P0();
        this.f54150f.put(DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, P0);
        f2(P0, DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, new ListenerSet.Event() { // from class: w4.c1
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).T(i1.a.this);
            }
        });
        ((HandlerWrapper) com.google.android.exoplayer2.util.a.i(this.f54153i)).post(new Runnable() { // from class: w4.b1
            @Override // java.lang.Runnable
            public final void run() {
                h1.this.b2();
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void f(final String str, final long j10, final long j11) {
        final i1.a V0 = V0();
        f2(V0, 1009, new ListenerSet.Event() { // from class: w4.l0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.Z0(i1.a.this, str, j11, j10, (i1) obj);
            }
        });
    }

    public final void f2(i1.a aVar, int i10, ListenerSet.Event<i1> event) {
        this.f54150f.put(i10, aVar);
        this.f54151g.k(i10, event);
    }

    @Override // com.google.android.exoplayer2.source.z
    public final void g(int i10, @Nullable s.a aVar, final MediaLoadData mediaLoadData) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1005, new ListenerSet.Event() { // from class: w4.z
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).g0(i1.a.this, mediaLoadData);
            }
        });
    }

    @CallSuper
    public void g2(final Player player, Looper looper) {
        com.google.android.exoplayer2.util.a.g(this.f54152h == null || this.f54149e.f54156b.isEmpty());
        this.f54152h = (Player) com.google.android.exoplayer2.util.a.e(player);
        this.f54153i = this.f54146b.d(looper, null);
        this.f54151g = this.f54151g.d(looper, new ListenerSet.IterationFinishedEvent() { // from class: w4.z0
            @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                h1.this.c2(player, (i1) obj, flagSet);
            }
        });
    }

    @Override // q6.x
    public final void h(final z4.d dVar) {
        final i1.a V0 = V0();
        f2(V0, 1020, new ListenerSet.Event() { // from class: w4.o0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.V1(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    public final void h2(List<s.a> list, @Nullable s.a aVar) {
        this.f54149e.k(list, aVar, (Player) com.google.android.exoplayer2.util.a.e(this.f54152h));
    }

    @Override // q6.x
    public final void i(final int i10, final long j10) {
        final i1.a U0 = U0();
        f2(U0, 1023, new ListenerSet.Event() { // from class: w4.f
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).X(i1.a.this, i10, j10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void j(final z4.d dVar) {
        final i1.a U0 = U0();
        f2(U0, 1014, new ListenerSet.Event() { // from class: w4.q0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.b1(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void k(final Format format, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
        final i1.a V0 = V0();
        f2(V0, 1010, new ListenerSet.Event() { // from class: w4.m
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.d1(i1.a.this, format, decoderReuseEvaluation, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void l(int i10, @Nullable s.a aVar) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1031, new ListenerSet.Event() { // from class: w4.w
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).h(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void m(final Exception exc) {
        final i1.a V0 = V0();
        f2(V0, DownloadErrorCode.ERROR_TARGET_FILE_DELETE_FAILED, new ListenerSet.Event() { // from class: w4.f0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).q0(i1.a.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void n(int i10, @Nullable s.a aVar, final int i11) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1030, new ListenerSet.Event() { // from class: w4.g1
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.n1(i1.a.this, i11, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void o(final z4.d dVar) {
        final i1.a V0 = V0();
        f2(V0, 1008, new ListenerSet.Event() { // from class: w4.p0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.c1(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public void onAvailableCommandsChanged(final Player.b bVar) {
        final i1.a P0 = P0();
        f2(P0, 14, new ListenerSet.Event() { // from class: w4.s
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).p0(i1.a.this, bVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.e, e6.j
    public /* synthetic */ void onCues(List list) {
        com.google.android.exoplayer2.h1.d(this, list);
    }

    @Override // com.google.android.exoplayer2.Player.e, a5.c
    public /* synthetic */ void onDeviceInfoChanged(a5.b bVar) {
        com.google.android.exoplayer2.h1.e(this, bVar);
    }

    @Override // com.google.android.exoplayer2.Player.e, a5.c
    public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
        com.google.android.exoplayer2.h1.f(this, i10, z10);
    }

    @Override // com.google.android.exoplayer2.Player.c
    public /* synthetic */ void onEvents(Player player, Player.d dVar) {
        com.google.android.exoplayer2.h1.g(this, player, dVar);
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onIsLoadingChanged(final boolean z10) {
        final i1.a P0 = P0();
        f2(P0, 4, new ListenerSet.Event() { // from class: w4.t0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.r1(i1.a.this, z10, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public void onIsPlayingChanged(final boolean z10) {
        final i1.a P0 = P0();
        f2(P0, 8, new ListenerSet.Event() { // from class: w4.w0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).d0(i1.a.this, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public /* synthetic */ void onLoadingChanged(boolean z10) {
        com.google.android.exoplayer2.g1.d(this, z10);
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onMediaItemTransition(@Nullable final com.google.android.exoplayer2.w0 w0Var, final int i10) {
        final i1.a P0 = P0();
        f2(P0, 1, new ListenerSet.Event() { // from class: w4.o
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).t(i1.a.this, w0Var, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public void onMediaMetadataChanged(final MediaMetadata mediaMetadata) {
        final i1.a P0 = P0();
        f2(P0, 15, new ListenerSet.Event() { // from class: w4.p
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).m(i1.a.this, mediaMetadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.e, n5.e
    public final void onMetadata(final Metadata metadata) {
        final i1.a P0 = P0();
        f2(P0, 1007, new ListenerSet.Event() { // from class: w4.t
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).B(i1.a.this, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onPlayWhenReadyChanged(final boolean z10, final int i10) {
        final i1.a P0 = P0();
        f2(P0, 6, new ListenerSet.Event() { // from class: w4.y0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).Z(i1.a.this, z10, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onPlaybackParametersChanged(final com.google.android.exoplayer2.f1 f1Var) {
        final i1.a P0 = P0();
        f2(P0, 13, new ListenerSet.Event() { // from class: w4.r
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).U(i1.a.this, f1Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onPlaybackStateChanged(final int i10) {
        final i1.a P0 = P0();
        f2(P0, 5, new ListenerSet.Event() { // from class: w4.b
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).J(i1.a.this, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onPlaybackSuppressionReasonChanged(final int i10) {
        final i1.a P0 = P0();
        f2(P0, 7, new ListenerSet.Event() { // from class: w4.f1
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).N(i1.a.this, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onPlayerError(final PlaybackException playbackException) {
        com.google.android.exoplayer2.source.q qVar;
        final i1.a R0 = (!(playbackException instanceof ExoPlaybackException) || (qVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : R0(new s.a(qVar));
        if (R0 == null) {
            R0 = P0();
        }
        f2(R0, 11, new ListenerSet.Event() { // from class: w4.q
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).l0(i1.a.this, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        com.google.android.exoplayer2.h1.r(this, playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onPlayerStateChanged(final boolean z10, final int i10) {
        final i1.a P0 = P0();
        f2(P0, -1, new ListenerSet.Event() { // from class: w4.x0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).r(i1.a.this, z10, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public /* synthetic */ void onPositionDiscontinuity(int i10) {
        com.google.android.exoplayer2.g1.m(this, i10);
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onPositionDiscontinuity(final Player.f fVar, final Player.f fVar2, final int i10) {
        if (i10 == 1) {
            this.f54154j = false;
        }
        this.f54149e.j((Player) com.google.android.exoplayer2.util.a.e(this.f54152h));
        final i1.a P0 = P0();
        f2(P0, 12, new ListenerSet.Event() { // from class: w4.i
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.G1(i1.a.this, i10, fVar, fVar2, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.e, q6.l
    public /* synthetic */ void onRenderedFirstFrame() {
        com.google.android.exoplayer2.h1.u(this);
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onRepeatModeChanged(final int i10) {
        final i1.a P0 = P0();
        f2(P0, 9, new ListenerSet.Event() { // from class: w4.d
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).C(i1.a.this, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onSeekProcessed() {
        final i1.a P0 = P0();
        f2(P0, -1, new ListenerSet.Event() { // from class: w4.d1
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).m0(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onShuffleModeEnabledChanged(final boolean z10) {
        final i1.a P0 = P0();
        f2(P0, 10, new ListenerSet.Event() { // from class: w4.u0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).P(i1.a.this, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.e, x4.f
    public final void onSkipSilenceEnabledChanged(final boolean z10) {
        final i1.a V0 = V0();
        f2(V0, 1017, new ListenerSet.Event() { // from class: w4.v0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).a0(i1.a.this, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    @Deprecated
    public final void onStaticMetadataChanged(final List<Metadata> list) {
        final i1.a P0 = P0();
        f2(P0, 3, new ListenerSet.Event() { // from class: w4.m0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).E(i1.a.this, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.e, q6.l
    public void onSurfaceSizeChanged(final int i10, final int i11) {
        final i1.a V0 = V0();
        f2(V0, 1029, new ListenerSet.Event() { // from class: w4.e
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).R(i1.a.this, i10, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onTimelineChanged(Timeline timeline, final int i10) {
        this.f54149e.l((Player) com.google.android.exoplayer2.util.a.e(this.f54152h));
        final i1.a P0 = P0();
        f2(P0, 0, new ListenerSet.Event() { // from class: w4.c
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).q(i1.a.this, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.c
    public final void onTracksChanged(final TrackGroupArray trackGroupArray, final n6.h hVar) {
        final i1.a P0 = P0();
        f2(P0, 2, new ListenerSet.Event() { // from class: w4.b0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).p(i1.a.this, trackGroupArray, hVar);
            }
        });
    }

    @Override // q6.l
    public /* synthetic */ void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
        q6.k.a(this, i10, i11, i12, f10);
    }

    @Override // com.google.android.exoplayer2.Player.e, q6.l
    public final void onVideoSizeChanged(final q6.y yVar) {
        final i1.a V0 = V0();
        f2(V0, 1028, new ListenerSet.Event() { // from class: w4.n0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.Y1(i1.a.this, yVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player.e, x4.f
    public final void onVolumeChanged(final float f10) {
        final i1.a V0 = V0();
        f2(V0, 1019, new ListenerSet.Event() { // from class: w4.e1
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).z(i1.a.this, f10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.z
    public final void p(int i10, @Nullable s.a aVar, final com.google.android.exoplayer2.source.m mVar, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z10) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1003, new ListenerSet.Event() { // from class: w4.y
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).k0(i1.a.this, mVar, mediaLoadData, iOException, z10);
            }
        });
    }

    @Override // q6.x
    public final void q(final long j10, final int i10) {
        final i1.a U0 = U0();
        f2(U0, 1026, new ListenerSet.Event() { // from class: w4.k
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).l(i1.a.this, j10, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void r(int i10, @Nullable s.a aVar) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1033, new ListenerSet.Event() { // from class: w4.a
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).v(i1.a.this);
            }
        });
    }

    @Override // q6.x
    public final void s(final String str, final long j10, final long j11) {
        final i1.a V0 = V0();
        f2(V0, 1021, new ListenerSet.Event() { // from class: w4.k0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.S1(i1.a.this, str, j11, j10, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.z
    public final void t(int i10, @Nullable s.a aVar, final MediaLoadData mediaLoadData) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1004, new ListenerSet.Event() { // from class: w4.a0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).o0(i1.a.this, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.z
    public final void u(int i10, @Nullable s.a aVar, final com.google.android.exoplayer2.source.m mVar, final MediaLoadData mediaLoadData) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1000, new ListenerSet.Event() { // from class: w4.v
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).o(i1.a.this, mVar, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void v(int i10, @Nullable s.a aVar) {
        final i1.a T0 = T0(i10, aVar);
        f2(T0, 1034, new ListenerSet.Event() { // from class: w4.s0
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).c0(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public /* synthetic */ void w(int i10, s.a aVar) {
        b5.k.a(this, i10, aVar);
    }

    @Override // q6.x
    public /* synthetic */ void x(Format format) {
        q6.m.a(this, format);
    }

    @Override // q6.x
    public final void y(final Format format, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
        final i1.a V0 = V0();
        f2(V0, 1022, new ListenerSet.Event() { // from class: w4.n
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                h1.X1(i1.a.this, format, decoderReuseEvaluation, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void z(final long j10) {
        final i1.a V0 = V0();
        f2(V0, 1011, new ListenerSet.Event() { // from class: w4.j
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((i1) obj).y(i1.a.this, j10);
            }
        });
    }
}
