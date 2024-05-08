package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.d1;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import n6.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ExoPlayerImplInternal implements Handler.Callback, p.a, i.a, d1.d, m.a, PlayerMessage.Sender {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;

    @Nullable
    public e K;
    public long L;
    public int M;
    public boolean N;

    @Nullable
    public ExoPlaybackException O;
    public long P;

    /* renamed from: b, reason: collision with root package name */
    public final l1[] f19487b;

    /* renamed from: c, reason: collision with root package name */
    public final n1[] f19488c;

    /* renamed from: d, reason: collision with root package name */
    public final n6.i f19489d;

    /* renamed from: e, reason: collision with root package name */
    public final TrackSelectorResult f19490e;

    /* renamed from: f, reason: collision with root package name */
    public final v0 f19491f;

    /* renamed from: g, reason: collision with root package name */
    public final o6.e f19492g;

    /* renamed from: h, reason: collision with root package name */
    public final HandlerWrapper f19493h;

    /* renamed from: i, reason: collision with root package name */
    public final HandlerThread f19494i;

    /* renamed from: j, reason: collision with root package name */
    public final Looper f19495j;

    /* renamed from: k, reason: collision with root package name */
    public final Timeline.c f19496k;

    /* renamed from: l, reason: collision with root package name */
    public final Timeline.b f19497l;

    /* renamed from: m, reason: collision with root package name */
    public final long f19498m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f19499n;

    /* renamed from: o, reason: collision with root package name */
    public final m f19500o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList<a> f19501p;

    /* renamed from: q, reason: collision with root package name */
    public final Clock f19502q;

    /* renamed from: r, reason: collision with root package name */
    public final c f19503r;

    /* renamed from: s, reason: collision with root package name */
    public final a1 f19504s;

    /* renamed from: t, reason: collision with root package name */
    public final d1 f19505t;

    /* renamed from: u, reason: collision with root package name */
    public final u0 f19506u;

    /* renamed from: v, reason: collision with root package name */
    public final long f19507v;

    /* renamed from: w, reason: collision with root package name */
    public p1 f19508w;

    /* renamed from: x, reason: collision with root package name */
    public e1 f19509x;

    /* renamed from: y, reason: collision with root package name */
    public b f19510y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f19511z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class MediaSourceListUpdateMessage {
        private final List<d1.c> mediaSourceHolders;
        private final long positionUs;
        private final ShuffleOrder shuffleOrder;
        private final int windowIndex;

        private MediaSourceListUpdateMessage(List<d1.c> list, ShuffleOrder shuffleOrder, int i10, long j10) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder;
            this.windowIndex = i10;
            this.positionUs = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i10, int i11, int i12, ShuffleOrder shuffleOrder) {
            this.fromIndex = i10;
            this.toIndex = i11;
            this.newFromIndex = i12;
            this.shuffleOrder = shuffleOrder;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: b, reason: collision with root package name */
        public final PlayerMessage f19513b;

        /* renamed from: c, reason: collision with root package name */
        public int f19514c;

        /* renamed from: d, reason: collision with root package name */
        public long f19515d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public Object f19516e;

        public a(PlayerMessage playerMessage) {
            this.f19513b = playerMessage;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            Object obj = this.f19516e;
            if ((obj == null) != (aVar.f19516e == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i10 = this.f19514c - aVar.f19514c;
            return i10 != 0 ? i10 : com.google.android.exoplayer2.util.j0.p(this.f19515d, aVar.f19515d);
        }

        public void b(int i10, long j10, Object obj) {
            this.f19514c = i10;
            this.f19515d = j10;
            this.f19516e = obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19517a;

        /* renamed from: b, reason: collision with root package name */
        public e1 f19518b;

        /* renamed from: c, reason: collision with root package name */
        public int f19519c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f19520d;

        /* renamed from: e, reason: collision with root package name */
        public int f19521e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19522f;

        /* renamed from: g, reason: collision with root package name */
        public int f19523g;

        public b(e1 e1Var) {
            this.f19518b = e1Var;
        }

        public void b(int i10) {
            this.f19517a |= i10 > 0;
            this.f19519c += i10;
        }

        public void c(int i10) {
            this.f19517a = true;
            this.f19522f = true;
            this.f19523g = i10;
        }

        public void d(e1 e1Var) {
            this.f19517a |= this.f19518b != e1Var;
            this.f19518b = e1Var;
        }

        public void e(int i10) {
            if (this.f19520d && this.f19521e != 5) {
                com.google.android.exoplayer2.util.a.a(i10 == 5);
                return;
            }
            this.f19517a = true;
            this.f19520d = true;
            this.f19521e = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void a(b bVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final s.a f19524a;

        /* renamed from: b, reason: collision with root package name */
        public final long f19525b;

        /* renamed from: c, reason: collision with root package name */
        public final long f19526c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f19527d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f19528e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f19529f;

        public d(s.a aVar, long j10, long j11, boolean z10, boolean z11, boolean z12) {
            this.f19524a = aVar;
            this.f19525b = j10;
            this.f19526c = j11;
            this.f19527d = z10;
            this.f19528e = z11;
            this.f19529f = z12;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Timeline f19530a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19531b;

        /* renamed from: c, reason: collision with root package name */
        public final long f19532c;

        public e(Timeline timeline, int i10, long j10) {
            this.f19530a = timeline;
            this.f19531b = i10;
            this.f19532c = j10;
        }
    }

    public ExoPlayerImplInternal(l1[] l1VarArr, n6.i iVar, TrackSelectorResult trackSelectorResult, v0 v0Var, o6.e eVar, int i10, boolean z10, @Nullable w4.h1 h1Var, p1 p1Var, u0 u0Var, long j10, boolean z11, Looper looper, Clock clock, c cVar) {
        this.f19503r = cVar;
        this.f19487b = l1VarArr;
        this.f19489d = iVar;
        this.f19490e = trackSelectorResult;
        this.f19491f = v0Var;
        this.f19492g = eVar;
        this.E = i10;
        this.F = z10;
        this.f19508w = p1Var;
        this.f19506u = u0Var;
        this.f19507v = j10;
        this.P = j10;
        this.A = z11;
        this.f19502q = clock;
        this.f19498m = v0Var.e();
        this.f19499n = v0Var.a();
        e1 k10 = e1.k(trackSelectorResult);
        this.f19509x = k10;
        this.f19510y = new b(k10);
        this.f19488c = new n1[l1VarArr.length];
        for (int i11 = 0; i11 < l1VarArr.length; i11++) {
            l1VarArr[i11].f(i11);
            this.f19488c[i11] = l1VarArr[i11].s();
        }
        this.f19500o = new m(this, clock);
        this.f19501p = new ArrayList<>();
        this.f19496k = new Timeline.c();
        this.f19497l = new Timeline.b();
        iVar.b(this, eVar);
        this.N = true;
        Handler handler = new Handler(looper);
        this.f19504s = new a1(h1Var, handler);
        this.f19505t = new d1(this, h1Var, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f19494i = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f19495j = looper2;
        this.f19493h = clock.d(looper2, this);
    }

    public static boolean O(l1 l1Var) {
        return l1Var.getState() != 0;
    }

    public static boolean Q(e1 e1Var, Timeline.b bVar) {
        s.a aVar = e1Var.f19995b;
        Timeline timeline = e1Var.f19994a;
        return timeline.q() || timeline.h(aVar.f21883a, bVar).f19661f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean R() {
        return Boolean.valueOf(this.f19511z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(PlayerMessage playerMessage) {
        try {
            j(playerMessage);
        } catch (ExoPlaybackException e2) {
            com.google.android.exoplayer2.util.m.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    public static void s0(Timeline timeline, a aVar, Timeline.c cVar, Timeline.b bVar) {
        int i10 = timeline.n(timeline.h(aVar.f19516e, bVar).f19658c, cVar).f19682p;
        Object obj = timeline.g(i10, bVar, true).f19657b;
        long j10 = bVar.f19659d;
        aVar.b(i10, j10 != -9223372036854775807L ? j10 - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean t0(a aVar, Timeline timeline, Timeline timeline2, int i10, boolean z10, Timeline.c cVar, Timeline.b bVar) {
        Object obj = aVar.f19516e;
        if (obj == null) {
            Pair<Object, Long> w02 = w0(timeline, new e(aVar.f19513b.getTimeline(), aVar.f19513b.getWindowIndex(), aVar.f19513b.getPositionMs() == Long.MIN_VALUE ? -9223372036854775807L : h.d(aVar.f19513b.getPositionMs())), false, i10, z10, cVar, bVar);
            if (w02 == null) {
                return false;
            }
            aVar.b(timeline.b(w02.first), ((Long) w02.second).longValue(), w02.first);
            if (aVar.f19513b.getPositionMs() == Long.MIN_VALUE) {
                s0(timeline, aVar, cVar, bVar);
            }
            return true;
        }
        int b4 = timeline.b(obj);
        if (b4 == -1) {
            return false;
        }
        if (aVar.f19513b.getPositionMs() == Long.MIN_VALUE) {
            s0(timeline, aVar, cVar, bVar);
            return true;
        }
        aVar.f19514c = b4;
        timeline2.h(aVar.f19516e, bVar);
        if (bVar.f19661f && timeline2.n(bVar.f19658c, cVar).f19681o == timeline2.b(aVar.f19516e)) {
            Pair<Object, Long> j10 = timeline.j(cVar, bVar, timeline.h(aVar.f19516e, bVar).f19658c, aVar.f19515d + bVar.m());
            aVar.b(timeline.b(j10.first), ((Long) j10.second).longValue(), j10.first);
        }
        return true;
    }

    public static d v0(Timeline timeline, e1 e1Var, @Nullable e eVar, a1 a1Var, int i10, boolean z10, Timeline.c cVar, Timeline.b bVar) {
        long j10;
        int i11;
        s.a aVar;
        long j11;
        int i12;
        boolean z11;
        boolean z12;
        boolean z13;
        int i13;
        int i14;
        boolean z14;
        a1 a1Var2;
        long j12;
        int i15;
        boolean z15;
        int i16;
        boolean z16;
        boolean z17;
        if (timeline.q()) {
            return new d(e1.l(), 0L, -9223372036854775807L, false, true, false);
        }
        s.a aVar2 = e1Var.f19995b;
        Object obj = aVar2.f21883a;
        boolean Q = Q(e1Var, bVar);
        if (!e1Var.f19995b.b() && !Q) {
            j10 = e1Var.f20012s;
        } else {
            j10 = e1Var.f19996c;
        }
        long j13 = j10;
        boolean z18 = false;
        if (eVar != null) {
            i11 = -1;
            Pair<Object, Long> w02 = w0(timeline, eVar, true, i10, z10, cVar, bVar);
            if (w02 == null) {
                i16 = timeline.a(z10);
                j11 = j13;
                z15 = false;
                z16 = false;
                z17 = true;
            } else {
                if (eVar.f19532c == -9223372036854775807L) {
                    i16 = timeline.h(w02.first, bVar).f19658c;
                    j11 = j13;
                    z15 = false;
                } else {
                    obj = w02.first;
                    j11 = ((Long) w02.second).longValue();
                    z15 = true;
                    i16 = -1;
                }
                z16 = e1Var.f19998e == 4;
                z17 = false;
            }
            z13 = z15;
            z11 = z16;
            z12 = z17;
            i12 = i16;
            aVar = aVar2;
        } else {
            i11 = -1;
            if (e1Var.f19994a.q()) {
                i13 = timeline.a(z10);
            } else if (timeline.b(obj) == -1) {
                Object x02 = x0(cVar, bVar, i10, z10, obj, e1Var.f19994a, timeline);
                if (x02 == null) {
                    i14 = timeline.a(z10);
                    z14 = true;
                } else {
                    i14 = timeline.h(x02, bVar).f19658c;
                    z14 = false;
                }
                i12 = i14;
                z12 = z14;
                j11 = j13;
                aVar = aVar2;
                z11 = false;
                z13 = false;
            } else if (j13 == -9223372036854775807L) {
                i13 = timeline.h(obj, bVar).f19658c;
            } else if (Q) {
                aVar = aVar2;
                e1Var.f19994a.h(aVar.f21883a, bVar);
                if (e1Var.f19994a.n(bVar.f19658c, cVar).f19681o == e1Var.f19994a.b(aVar.f21883a)) {
                    Pair<Object, Long> j14 = timeline.j(cVar, bVar, timeline.h(obj, bVar).f19658c, j13 + bVar.m());
                    obj = j14.first;
                    j11 = ((Long) j14.second).longValue();
                } else {
                    j11 = j13;
                }
                i12 = -1;
                z11 = false;
                z12 = false;
                z13 = true;
            } else {
                aVar = aVar2;
                j11 = j13;
                i12 = -1;
                z11 = false;
                z12 = false;
                z13 = false;
            }
            i12 = i13;
            j11 = j13;
            aVar = aVar2;
            z11 = false;
            z12 = false;
            z13 = false;
        }
        if (i12 != i11) {
            Pair<Object, Long> j15 = timeline.j(cVar, bVar, i12, -9223372036854775807L);
            obj = j15.first;
            j11 = ((Long) j15.second).longValue();
            a1Var2 = a1Var;
            j12 = -9223372036854775807L;
        } else {
            a1Var2 = a1Var;
            j12 = j11;
        }
        s.a A = a1Var2.A(timeline, obj, j11);
        boolean z19 = A.f21887e == i11 || ((i15 = aVar.f21887e) != i11 && A.f21884b >= i15);
        boolean equals = aVar.f21883a.equals(obj);
        boolean z20 = equals && !aVar.b() && !A.b() && z19;
        timeline.h(obj, bVar);
        if (equals && !Q && j13 == j12 && ((A.b() && bVar.p(A.f21884b)) || (aVar.b() && bVar.p(aVar.f21884b)))) {
            z18 = true;
        }
        if (z20 || z18) {
            A = aVar;
        }
        if (A.b()) {
            if (A.equals(aVar)) {
                j11 = e1Var.f20012s;
            } else {
                timeline.h(A.f21883a, bVar);
                j11 = A.f21885c == bVar.j(A.f21884b) ? bVar.g() : 0L;
            }
        }
        return new d(A, j11, j12, z11, z12, z13);
    }

    public static Format[] w(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i10 = 0; i10 < length; i10++) {
            formatArr[i10] = exoTrackSelection.p(i10);
        }
        return formatArr;
    }

    @Nullable
    public static Pair<Object, Long> w0(Timeline timeline, e eVar, boolean z10, int i10, boolean z11, Timeline.c cVar, Timeline.b bVar) {
        Pair<Object, Long> j10;
        Object x02;
        Timeline timeline2 = eVar.f19530a;
        if (timeline.q()) {
            return null;
        }
        Timeline timeline3 = timeline2.q() ? timeline : timeline2;
        try {
            j10 = timeline3.j(cVar, bVar, eVar.f19531b, eVar.f19532c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (timeline.equals(timeline3)) {
            return j10;
        }
        if (timeline.b(j10.first) != -1) {
            return (timeline3.h(j10.first, bVar).f19661f && timeline3.n(bVar.f19658c, cVar).f19681o == timeline3.b(j10.first)) ? timeline.j(cVar, bVar, timeline.h(j10.first, bVar).f19658c, eVar.f19532c) : j10;
        }
        if (z10 && (x02 = x0(cVar, bVar, i10, z11, j10.first, timeline3, timeline)) != null) {
            return timeline.j(cVar, bVar, timeline.h(x02, bVar).f19658c, -9223372036854775807L);
        }
        return null;
    }

    @Nullable
    public static Object x0(Timeline.c cVar, Timeline.b bVar, int i10, boolean z10, Object obj, Timeline timeline, Timeline timeline2) {
        int b4 = timeline.b(obj);
        int i11 = timeline.i();
        int i12 = b4;
        int i13 = -1;
        for (int i14 = 0; i14 < i11 && i13 == -1; i14++) {
            i12 = timeline.d(i12, bVar, cVar, i10, z10);
            if (i12 == -1) {
                break;
            }
            i13 = timeline2.b(timeline.m(i12));
        }
        if (i13 == -1) {
            return null;
        }
        return timeline2.m(i13);
    }

    public Looper A() {
        return this.f19495j;
    }

    public final void A0(boolean z10) throws ExoPlaybackException {
        s.a aVar = this.f19504s.p().f23237f.f23249a;
        long D0 = D0(aVar, this.f19509x.f20012s, true, false);
        if (D0 != this.f19509x.f20012s) {
            e1 e1Var = this.f19509x;
            this.f19509x = K(aVar, D0, e1Var.f19996c, e1Var.f19997d, z10, 5);
        }
    }

    public final long B() {
        return C(this.f19509x.f20010q);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ab A[Catch: all -> 0x0147, TryCatch #1 {all -> 0x0147, blocks: (B:6:0x00a1, B:8:0x00ab, B:15:0x00b1, B:17:0x00b7, B:18:0x00ba, B:19:0x00c0, B:21:0x00ca, B:23:0x00d2, B:27:0x00da, B:28:0x00e4, B:30:0x00f4, B:34:0x00fe, B:37:0x0110, B:40:0x0119), top: B:5:0x00a1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B0(com.google.android.exoplayer2.ExoPlayerImplInternal.e r20) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.B0(com.google.android.exoplayer2.ExoPlayerImplInternal$e):void");
    }

    public final long C(long j10) {
        x0 j11 = this.f19504s.j();
        if (j11 == null) {
            return 0L;
        }
        return Math.max(0L, j10 - j11.y(this.L));
    }

    public final long C0(s.a aVar, long j10, boolean z10) throws ExoPlaybackException {
        return D0(aVar, j10, this.f19504s.p() != this.f19504s.q(), z10);
    }

    public final void D(com.google.android.exoplayer2.source.p pVar) {
        if (this.f19504s.v(pVar)) {
            this.f19504s.y(this.L);
            T();
        }
    }

    public final long D0(s.a aVar, long j10, boolean z10, boolean z11) throws ExoPlaybackException {
        h1();
        this.C = false;
        if (z11 || this.f19509x.f19998e == 3) {
            Y0(2);
        }
        x0 p10 = this.f19504s.p();
        x0 x0Var = p10;
        while (x0Var != null && !aVar.equals(x0Var.f23237f.f23249a)) {
            x0Var = x0Var.j();
        }
        if (z10 || p10 != x0Var || (x0Var != null && x0Var.z(j10) < 0)) {
            for (l1 l1Var : this.f19487b) {
                m(l1Var);
            }
            if (x0Var != null) {
                while (this.f19504s.p() != x0Var) {
                    this.f19504s.b();
                }
                this.f19504s.z(x0Var);
                x0Var.x(0L);
                q();
            }
        }
        if (x0Var != null) {
            this.f19504s.z(x0Var);
            if (!x0Var.f23235d) {
                x0Var.f23237f = x0Var.f23237f.b(j10);
            } else if (x0Var.f23236e) {
                long h10 = x0Var.f23232a.h(j10);
                x0Var.f23232a.t(h10 - this.f19498m, this.f19499n);
                j10 = h10;
            }
            r0(j10);
            T();
        } else {
            this.f19504s.f();
            r0(j10);
        }
        F(false);
        this.f19493h.h(2);
        return j10;
    }

    public final void E(IOException iOException, int i10) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i10);
        x0 p10 = this.f19504s.p();
        if (p10 != null) {
            createForSource = createForSource.copyWithMediaPeriodId(p10.f23237f.f23249a);
        }
        com.google.android.exoplayer2.util.m.d("ExoPlayerImplInternal", "Playback error", createForSource);
        g1(false, false);
        this.f19509x = this.f19509x.f(createForSource);
    }

    public final void E0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            F0(playerMessage);
            return;
        }
        if (this.f19509x.f19994a.q()) {
            this.f19501p.add(new a(playerMessage));
            return;
        }
        a aVar = new a(playerMessage);
        Timeline timeline = this.f19509x.f19994a;
        if (t0(aVar, timeline, timeline, this.E, this.F, this.f19496k, this.f19497l)) {
            this.f19501p.add(aVar);
            Collections.sort(this.f19501p);
        } else {
            playerMessage.markAsProcessed(false);
        }
    }

    public final void F(boolean z10) {
        long i10;
        x0 j10 = this.f19504s.j();
        s.a aVar = j10 == null ? this.f19509x.f19995b : j10.f23237f.f23249a;
        boolean z11 = !this.f19509x.f20004k.equals(aVar);
        if (z11) {
            this.f19509x = this.f19509x.b(aVar);
        }
        e1 e1Var = this.f19509x;
        if (j10 == null) {
            i10 = e1Var.f20012s;
        } else {
            i10 = j10.i();
        }
        e1Var.f20010q = i10;
        this.f19509x.f20011r = B();
        if ((z11 || z10) && j10 != null && j10.f23235d) {
            k1(j10.n(), j10.o());
        }
    }

    public final void F0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() == this.f19495j) {
            j(playerMessage);
            int i10 = this.f19509x.f19998e;
            if (i10 == 3 || i10 == 2) {
                this.f19493h.h(2);
                return;
            }
            return;
        }
        this.f19493h.c(15, playerMessage).sendToTarget();
    }

    public final void G(Timeline timeline, boolean z10) throws ExoPlaybackException {
        boolean z11;
        d v02 = v0(timeline, this.f19509x, this.K, this.f19504s, this.E, this.F, this.f19496k, this.f19497l);
        s.a aVar = v02.f19524a;
        long j10 = v02.f19526c;
        boolean z12 = v02.f19527d;
        long j11 = v02.f19525b;
        boolean z13 = (this.f19509x.f19995b.equals(aVar) && j11 == this.f19509x.f20012s) ? false : true;
        e eVar = null;
        try {
            if (v02.f19528e) {
                if (this.f19509x.f19998e != 1) {
                    Y0(4);
                }
                p0(false, false, false, true);
            }
            try {
                if (!z13) {
                    z11 = false;
                    if (!this.f19504s.F(timeline, this.L, y())) {
                        A0(false);
                    }
                } else {
                    z11 = false;
                    if (!timeline.q()) {
                        for (x0 p10 = this.f19504s.p(); p10 != null; p10 = p10.j()) {
                            if (p10.f23237f.f23249a.equals(aVar)) {
                                p10.f23237f = this.f19504s.r(timeline, p10.f23237f);
                                p10.A();
                            }
                        }
                        j11 = C0(aVar, j11, z12);
                    }
                }
                e1 e1Var = this.f19509x;
                j1(timeline, aVar, e1Var.f19994a, e1Var.f19995b, v02.f19529f ? j11 : -9223372036854775807L);
                if (z13 || j10 != this.f19509x.f19996c) {
                    e1 e1Var2 = this.f19509x;
                    Object obj = e1Var2.f19995b.f21883a;
                    Timeline timeline2 = e1Var2.f19994a;
                    this.f19509x = K(aVar, j11, j10, this.f19509x.f19997d, z13 && z10 && !timeline2.q() && !timeline2.h(obj, this.f19497l).f19661f, timeline.b(obj) == -1 ? 4 : 3);
                }
                q0();
                u0(timeline, this.f19509x.f19994a);
                this.f19509x = this.f19509x.j(timeline);
                if (!timeline.q()) {
                    this.K = null;
                }
                F(z11);
            } catch (Throwable th) {
                th = th;
                eVar = null;
                e1 e1Var3 = this.f19509x;
                e eVar2 = eVar;
                j1(timeline, aVar, e1Var3.f19994a, e1Var3.f19995b, v02.f19529f ? j11 : -9223372036854775807L);
                if (z13 || j10 != this.f19509x.f19996c) {
                    e1 e1Var4 = this.f19509x;
                    Object obj2 = e1Var4.f19995b.f21883a;
                    Timeline timeline3 = e1Var4.f19994a;
                    this.f19509x = K(aVar, j11, j10, this.f19509x.f19997d, z13 && z10 && !timeline3.q() && !timeline3.h(obj2, this.f19497l).f19661f, timeline.b(obj2) == -1 ? 4 : 3);
                }
                q0();
                u0(timeline, this.f19509x.f19994a);
                this.f19509x = this.f19509x.j(timeline);
                if (!timeline.q()) {
                    this.K = eVar2;
                }
                F(false);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void G0(final PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (!looper.getThread().isAlive()) {
            com.google.android.exoplayer2.util.m.h("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
        } else {
            this.f19502q.d(looper, null).post(new Runnable() { // from class: com.google.android.exoplayer2.q0
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImplInternal.this.S(playerMessage);
                }
            });
        }
    }

    public final void H(com.google.android.exoplayer2.source.p pVar) throws ExoPlaybackException {
        if (this.f19504s.v(pVar)) {
            x0 j10 = this.f19504s.j();
            j10.p(this.f19500o.d().f20698a, this.f19509x.f19994a);
            k1(j10.n(), j10.o());
            if (j10 == this.f19504s.p()) {
                r0(j10.f23237f.f23250b);
                q();
                e1 e1Var = this.f19509x;
                s.a aVar = e1Var.f19995b;
                long j11 = j10.f23237f.f23250b;
                this.f19509x = K(aVar, j11, e1Var.f19996c, j11, false, 5);
            }
            T();
        }
    }

    public final void H0(long j10) {
        for (l1 l1Var : this.f19487b) {
            if (l1Var.l() != null) {
                I0(l1Var, j10);
            }
        }
    }

    public final void I(f1 f1Var, float f10, boolean z10, boolean z11) throws ExoPlaybackException {
        if (z10) {
            if (z11) {
                this.f19510y.b(1);
            }
            this.f19509x = this.f19509x.g(f1Var);
        }
        n1(f1Var.f20698a);
        for (l1 l1Var : this.f19487b) {
            if (l1Var != null) {
                l1Var.u(f10, f1Var.f20698a);
            }
        }
    }

    public final void I0(l1 l1Var, long j10) {
        l1Var.p();
        if (l1Var instanceof e6.k) {
            ((e6.k) l1Var).V(j10);
        }
    }

    public final void J(f1 f1Var, boolean z10) throws ExoPlaybackException {
        I(f1Var, f1Var.f20698a, true, z10);
    }

    public final void J0(boolean z10, @Nullable AtomicBoolean atomicBoolean) {
        if (this.G != z10) {
            this.G = z10;
            if (!z10) {
                for (l1 l1Var : this.f19487b) {
                    if (!O(l1Var)) {
                        l1Var.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckResult
    public final e1 K(s.a aVar, long j10, long j11, long j12, boolean z10, int i10) {
        List list;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray n10;
        TrackSelectorResult o10;
        this.N = (!this.N && j10 == this.f19509x.f20012s && aVar.equals(this.f19509x.f19995b)) ? false : true;
        q0();
        e1 e1Var = this.f19509x;
        TrackGroupArray trackGroupArray2 = e1Var.f20001h;
        TrackSelectorResult trackSelectorResult2 = e1Var.f20002i;
        List list2 = e1Var.f20003j;
        if (this.f19505t.s()) {
            x0 p10 = this.f19504s.p();
            if (p10 == null) {
                n10 = TrackGroupArray.f21171e;
            } else {
                n10 = p10.n();
            }
            if (p10 == null) {
                o10 = this.f19490e;
            } else {
                o10 = p10.o();
            }
            List u10 = u(o10.selections);
            if (p10 != null) {
                y0 y0Var = p10.f23237f;
                if (y0Var.f23251c != j11) {
                    p10.f23237f = y0Var.a(j11);
                }
            }
            trackGroupArray = n10;
            trackSelectorResult = o10;
            list = u10;
        } else if (aVar.equals(this.f19509x.f19995b)) {
            list = list2;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        } else {
            trackGroupArray = TrackGroupArray.f21171e;
            trackSelectorResult = this.f19490e;
            list = ImmutableList.of();
        }
        if (z10) {
            this.f19510y.e(i10);
        }
        return this.f19509x.c(aVar, j10, j11, j12, B(), trackGroupArray, trackSelectorResult, list);
    }

    public final void K0(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.f19510y.b(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.K = new e(new i1(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        G(this.f19505t.C(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    public final boolean L(l1 l1Var, x0 x0Var) {
        x0 j10 = x0Var.j();
        return x0Var.f23237f.f23254f && j10.f23235d && ((l1Var instanceof e6.k) || l1Var.m() >= j10.m());
    }

    public void L0(List<d1.c> list, int i10, long j10, ShuffleOrder shuffleOrder) {
        this.f19493h.c(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i10, j10)).sendToTarget();
    }

    public final boolean M() {
        x0 q10 = this.f19504s.q();
        if (!q10.f23235d) {
            return false;
        }
        int i10 = 0;
        while (true) {
            l1[] l1VarArr = this.f19487b;
            if (i10 >= l1VarArr.length) {
                return true;
            }
            l1 l1Var = l1VarArr[i10];
            SampleStream sampleStream = q10.f23234c[i10];
            if (l1Var.l() != sampleStream || (sampleStream != null && !l1Var.h() && !L(l1Var, q10))) {
                break;
            }
            i10++;
        }
        return false;
    }

    public final void M0(boolean z10) {
        if (z10 == this.I) {
            return;
        }
        this.I = z10;
        e1 e1Var = this.f19509x;
        int i10 = e1Var.f19998e;
        if (!z10 && i10 != 4 && i10 != 1) {
            this.f19493h.h(2);
        } else {
            this.f19509x = e1Var.d(z10);
        }
    }

    public final boolean N() {
        x0 j10 = this.f19504s.j();
        return (j10 == null || j10.k() == Long.MIN_VALUE) ? false : true;
    }

    public final void N0(boolean z10) throws ExoPlaybackException {
        this.A = z10;
        q0();
        if (!this.B || this.f19504s.q() == this.f19504s.p()) {
            return;
        }
        A0(true);
        F(false);
    }

    public void O0(boolean z10, int i10) {
        this.f19493h.e(1, z10 ? 1 : 0, i10).sendToTarget();
    }

    public final boolean P() {
        x0 p10 = this.f19504s.p();
        long j10 = p10.f23237f.f23253e;
        return p10.f23235d && (j10 == -9223372036854775807L || this.f19509x.f20012s < j10 || !b1());
    }

    public final void P0(boolean z10, int i10, boolean z11, int i11) throws ExoPlaybackException {
        this.f19510y.b(z11 ? 1 : 0);
        this.f19510y.c(i11);
        this.f19509x = this.f19509x.e(z10, i10);
        this.C = false;
        e0(z10);
        if (!b1()) {
            h1();
            m1();
            return;
        }
        int i12 = this.f19509x.f19998e;
        if (i12 == 3) {
            e1();
            this.f19493h.h(2);
        } else if (i12 == 2) {
            this.f19493h.h(2);
        }
    }

    public void Q0(f1 f1Var) {
        this.f19493h.c(4, f1Var).sendToTarget();
    }

    public final void R0(f1 f1Var) throws ExoPlaybackException {
        this.f19500o.c(f1Var);
        J(this.f19500o.d(), true);
    }

    public void S0(int i10) {
        this.f19493h.e(11, i10, 0).sendToTarget();
    }

    public final void T() {
        boolean a12 = a1();
        this.D = a12;
        if (a12) {
            this.f19504s.j().d(this.L);
        }
        i1();
    }

    public final void T0(int i10) throws ExoPlaybackException {
        this.E = i10;
        if (!this.f19504s.G(this.f19509x.f19994a, i10)) {
            A0(true);
        }
        F(false);
    }

    public final void U() {
        this.f19510y.d(this.f19509x);
        if (this.f19510y.f19517a) {
            this.f19503r.a(this.f19510y);
            this.f19510y = new b(this.f19509x);
        }
    }

    public final void U0(p1 p1Var) {
        this.f19508w = p1Var;
    }

    public final boolean V(long j10, long j11) {
        if (this.I && this.H) {
            return false;
        }
        y0(j10, j11);
        return true;
    }

    public void V0(boolean z10) {
        this.f19493h.e(12, z10 ? 1 : 0, 0).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0074, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0045, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void W(long r8, long r10) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.W(long, long):void");
    }

    public final void W0(boolean z10) throws ExoPlaybackException {
        this.F = z10;
        if (!this.f19504s.H(this.f19509x.f19994a, z10)) {
            A0(true);
        }
        F(false);
    }

    public final void X() throws ExoPlaybackException {
        y0 o10;
        this.f19504s.y(this.L);
        if (this.f19504s.D() && (o10 = this.f19504s.o(this.L, this.f19509x)) != null) {
            x0 g3 = this.f19504s.g(this.f19488c, this.f19489d, this.f19491f.g(), this.f19505t, o10, this.f19490e);
            g3.f23232a.p(this, o10.f23250b);
            if (this.f19504s.p() == g3) {
                r0(g3.m());
            }
            F(false);
        }
        if (this.D) {
            this.D = N();
            i1();
        } else {
            T();
        }
    }

    public final void X0(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.f19510y.b(1);
        G(this.f19505t.D(shuffleOrder), false);
    }

    public final void Y() throws ExoPlaybackException {
        boolean z10 = false;
        while (Z0()) {
            if (z10) {
                U();
            }
            x0 p10 = this.f19504s.p();
            x0 b4 = this.f19504s.b();
            y0 y0Var = b4.f23237f;
            s.a aVar = y0Var.f23249a;
            long j10 = y0Var.f23250b;
            e1 K = K(aVar, j10, y0Var.f23251c, j10, true, 0);
            this.f19509x = K;
            Timeline timeline = K.f19994a;
            j1(timeline, b4.f23237f.f23249a, timeline, p10.f23237f.f23249a, -9223372036854775807L);
            q0();
            m1();
            z10 = true;
        }
    }

    public final void Y0(int i10) {
        e1 e1Var = this.f19509x;
        if (e1Var.f19998e != i10) {
            this.f19509x = e1Var.h(i10);
        }
    }

    public final void Z() {
        x0 q10 = this.f19504s.q();
        if (q10 == null) {
            return;
        }
        int i10 = 0;
        if (q10.j() != null && !this.B) {
            if (M()) {
                if (q10.j().f23235d || this.L >= q10.j().m()) {
                    TrackSelectorResult o10 = q10.o();
                    x0 c4 = this.f19504s.c();
                    TrackSelectorResult o11 = c4.o();
                    if (c4.f23235d && c4.f23232a.i() != -9223372036854775807L) {
                        H0(c4.m());
                        return;
                    }
                    for (int i11 = 0; i11 < this.f19487b.length; i11++) {
                        boolean isRendererEnabled = o10.isRendererEnabled(i11);
                        boolean isRendererEnabled2 = o11.isRendererEnabled(i11);
                        if (isRendererEnabled && !this.f19487b[i11].j()) {
                            boolean z10 = this.f19488c[i11].g() == 7;
                            RendererConfiguration rendererConfiguration = o10.rendererConfigurations[i11];
                            RendererConfiguration rendererConfiguration2 = o11.rendererConfigurations[i11];
                            if (!isRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z10) {
                                I0(this.f19487b[i11], c4.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!q10.f23237f.f23257i && !this.B) {
            return;
        }
        while (true) {
            l1[] l1VarArr = this.f19487b;
            if (i10 >= l1VarArr.length) {
                return;
            }
            l1 l1Var = l1VarArr[i10];
            SampleStream sampleStream = q10.f23234c[i10];
            if (sampleStream != null && l1Var.l() == sampleStream && l1Var.h()) {
                long j10 = q10.f23237f.f23253e;
                I0(l1Var, (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? -9223372036854775807L : q10.l() + q10.f23237f.f23253e);
            }
            i10++;
        }
    }

    public final boolean Z0() {
        x0 p10;
        x0 j10;
        return b1() && !this.B && (p10 = this.f19504s.p()) != null && (j10 = p10.j()) != null && this.L >= j10.m() && j10.f23238g;
    }

    @Override // n6.i.a
    public void a() {
        this.f19493h.h(10);
    }

    public final void a0() throws ExoPlaybackException {
        x0 q10 = this.f19504s.q();
        if (q10 == null || this.f19504s.p() == q10 || q10.f23238g || !n0()) {
            return;
        }
        q();
    }

    public final boolean a1() {
        long y10;
        if (!N()) {
            return false;
        }
        x0 j10 = this.f19504s.j();
        long C = C(j10.k());
        if (j10 == this.f19504s.p()) {
            y10 = j10.y(this.L);
        } else {
            y10 = j10.y(this.L) - j10.f23237f.f23250b;
        }
        return this.f19491f.d(y10, C, this.f19500o.d().f20698a);
    }

    @Override // com.google.android.exoplayer2.d1.d
    public void b() {
        this.f19493h.h(22);
    }

    public final void b0() throws ExoPlaybackException {
        G(this.f19505t.i(), true);
    }

    public final boolean b1() {
        e1 e1Var = this.f19509x;
        return e1Var.f20005l && e1Var.f20006m == 0;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void c(PlayerMessage playerMessage) {
        if (!this.f19511z && this.f19494i.isAlive()) {
            this.f19493h.c(14, playerMessage).sendToTarget();
            return;
        }
        com.google.android.exoplayer2.util.m.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    public final void c0(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.f19510y.b(1);
        G(this.f19505t.v(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    public final boolean c1(boolean z10) {
        if (this.J == 0) {
            return P();
        }
        if (!z10) {
            return false;
        }
        e1 e1Var = this.f19509x;
        if (!e1Var.f20000g) {
            return true;
        }
        long c4 = d1(e1Var.f19994a, this.f19504s.p().f23237f.f23249a) ? this.f19506u.c() : -9223372036854775807L;
        x0 j10 = this.f19504s.j();
        return (j10.q() && j10.f23237f.f23257i) || (j10.f23237f.f23249a.b() && !j10.f23235d) || this.f19491f.f(B(), this.f19500o.d().f20698a, this.C, c4);
    }

    public final void d0() {
        for (x0 p10 = this.f19504s.p(); p10 != null; p10 = p10.j()) {
            for (ExoTrackSelection exoTrackSelection : p10.o().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.d();
                }
            }
        }
    }

    public final boolean d1(Timeline timeline, s.a aVar) {
        if (aVar.b() || timeline.q()) {
            return false;
        }
        timeline.n(timeline.h(aVar.f21883a, this.f19497l).f19658c, this.f19496k);
        if (!this.f19496k.f()) {
            return false;
        }
        Timeline.c cVar = this.f19496k;
        return cVar.f19675i && cVar.f19672f != -9223372036854775807L;
    }

    public final void e0(boolean z10) {
        for (x0 p10 = this.f19504s.p(); p10 != null; p10 = p10.j()) {
            for (ExoTrackSelection exoTrackSelection : p10.o().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.s(z10);
                }
            }
        }
    }

    public final void e1() throws ExoPlaybackException {
        this.C = false;
        this.f19500o.g();
        for (l1 l1Var : this.f19487b) {
            if (O(l1Var)) {
                l1Var.start();
            }
        }
    }

    public final void f0() {
        for (x0 p10 = this.f19504s.p(); p10 != null; p10 = p10.j()) {
            for (ExoTrackSelection exoTrackSelection : p10.o().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.n();
                }
            }
        }
    }

    public void f1() {
        this.f19493h.a(6).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.m0.a
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void k(com.google.android.exoplayer2.source.p pVar) {
        this.f19493h.c(9, pVar).sendToTarget();
    }

    public final void g1(boolean z10, boolean z11) {
        p0(z10 || !this.G, false, true, false);
        this.f19510y.b(z11 ? 1 : 0);
        this.f19491f.h();
        Y0(1);
    }

    public final void h(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i10) throws ExoPlaybackException {
        this.f19510y.b(1);
        d1 d1Var = this.f19505t;
        if (i10 == -1) {
            i10 = d1Var.q();
        }
        G(d1Var.f(i10, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    public void h0() {
        this.f19493h.a(0).sendToTarget();
    }

    public final void h1() throws ExoPlaybackException {
        this.f19500o.h();
        for (l1 l1Var : this.f19487b) {
            if (O(l1Var)) {
                s(l1Var);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        x0 q10;
        try {
            switch (message.what) {
                case 0:
                    i0();
                    break;
                case 1:
                    P0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    o();
                    break;
                case 3:
                    B0((e) message.obj);
                    break;
                case 4:
                    R0((f1) message.obj);
                    break;
                case 5:
                    U0((p1) message.obj);
                    break;
                case 6:
                    g1(false, true);
                    break;
                case 7:
                    k0();
                    return true;
                case 8:
                    H((com.google.android.exoplayer2.source.p) message.obj);
                    break;
                case 9:
                    D((com.google.android.exoplayer2.source.p) message.obj);
                    break;
                case 10:
                    o0();
                    break;
                case 11:
                    T0(message.arg1);
                    break;
                case 12:
                    W0(message.arg1 != 0);
                    break;
                case 13:
                    J0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    E0((PlayerMessage) message.obj);
                    break;
                case 15:
                    G0((PlayerMessage) message.obj);
                    break;
                case 16:
                    J((f1) message.obj, false);
                    break;
                case 17:
                    K0((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    h((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    c0((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    l0(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    X0((ShuffleOrder) message.obj);
                    break;
                case 22:
                    b0();
                    break;
                case 23:
                    N0(message.arg1 != 0);
                    break;
                case 24:
                    M0(message.arg1 == 1);
                    break;
                case 25:
                    i();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (q10 = this.f19504s.q()) != null) {
                e = e.copyWithMediaPeriodId(q10.f23237f.f23249a);
            }
            if (e.isRecoverable && this.O == null) {
                com.google.android.exoplayer2.util.m.i("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.O = e;
                HandlerWrapper handlerWrapper = this.f19493h;
                handlerWrapper.f(handlerWrapper.c(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.O;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.O;
                }
                com.google.android.exoplayer2.util.m.d("ExoPlayerImplInternal", "Playback error", e);
                g1(true, false);
                this.f19509x = this.f19509x.f(e);
            }
        } catch (ParserException e10) {
            int i10 = e10.dataType;
            if (i10 == 1) {
                r2 = e10.contentIsMalformed ? 3001 : 3003;
            } else if (i10 == 4) {
                r2 = e10.contentIsMalformed ? 3002 : 3004;
            }
            E(e10, r2);
        } catch (DrmSession.DrmSessionException e11) {
            E(e11, e11.errorCode);
        } catch (BehindLiveWindowException e12) {
            E(e12, 1002);
        } catch (DataSourceException e13) {
            E(e13, e13.reason);
        } catch (IOException e14) {
            E(e14, 2000);
        } catch (RuntimeException e15) {
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e15, ((e15 instanceof IllegalStateException) || (e15 instanceof IllegalArgumentException)) ? 1004 : 1000);
            com.google.android.exoplayer2.util.m.d("ExoPlayerImplInternal", "Playback error", createForUnexpected);
            g1(true, false);
            this.f19509x = this.f19509x.f(createForUnexpected);
        }
        U();
        return true;
    }

    public final void i() throws ExoPlaybackException {
        A0(true);
    }

    public final void i0() {
        this.f19510y.b(1);
        p0(false, false, false, true);
        this.f19491f.onPrepared();
        Y0(this.f19509x.f19994a.q() ? 4 : 2);
        this.f19505t.w(this.f19492g.h());
        this.f19493h.h(2);
    }

    public final void i1() {
        x0 j10 = this.f19504s.j();
        boolean z10 = this.D || (j10 != null && j10.f23232a.isLoading());
        e1 e1Var = this.f19509x;
        if (z10 != e1Var.f20000g) {
            this.f19509x = e1Var.a(z10);
        }
    }

    public final void j(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().i(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    public synchronized boolean j0() {
        if (!this.f19511z && this.f19494i.isAlive()) {
            this.f19493h.h(7);
            o1(new com.google.common.base.t() { // from class: com.google.android.exoplayer2.p0
                @Override // com.google.common.base.t
                public final Object get() {
                    Boolean R;
                    R = ExoPlayerImplInternal.this.R();
                    return R;
                }
            }, this.f19507v);
            return this.f19511z;
        }
        return true;
    }

    public final void j1(Timeline timeline, s.a aVar, Timeline timeline2, s.a aVar2, long j10) {
        if (!timeline.q() && d1(timeline, aVar)) {
            timeline.n(timeline.h(aVar.f21883a, this.f19497l).f19658c, this.f19496k);
            this.f19506u.a((w0.f) com.google.android.exoplayer2.util.j0.j(this.f19496k.f19677k));
            if (j10 != -9223372036854775807L) {
                this.f19506u.e(x(timeline, aVar.f21883a, j10));
                return;
            }
            if (com.google.android.exoplayer2.util.j0.c(timeline2.q() ? null : timeline2.n(timeline2.h(aVar2.f21883a, this.f19497l).f19658c, this.f19496k).f19667a, this.f19496k.f19667a)) {
                return;
            }
            this.f19506u.e(-9223372036854775807L);
            return;
        }
        float f10 = this.f19500o.d().f20698a;
        f1 f1Var = this.f19509x.f20007n;
        if (f10 != f1Var.f20698a) {
            this.f19500o.c(f1Var);
        }
    }

    public final void k0() {
        p0(true, false, true, false);
        this.f19491f.c();
        Y0(1);
        this.f19494i.quit();
        synchronized (this) {
            this.f19511z = true;
            notifyAll();
        }
    }

    public final void k1(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.f19491f.b(this.f19487b, trackGroupArray, trackSelectorResult.selections);
    }

    public final void l0(int i10, int i11, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.f19510y.b(1);
        G(this.f19505t.A(i10, i11, shuffleOrder), false);
    }

    public final void l1() throws ExoPlaybackException, IOException {
        if (this.f19509x.f19994a.q() || !this.f19505t.s()) {
            return;
        }
        X();
        Z();
        a0();
        Y();
    }

    public final void m(l1 l1Var) throws ExoPlaybackException {
        if (O(l1Var)) {
            this.f19500o.a(l1Var);
            s(l1Var);
            l1Var.e();
            this.J--;
        }
    }

    public void m0(int i10, int i11, ShuffleOrder shuffleOrder) {
        this.f19493h.g(20, i10, i11, shuffleOrder).sendToTarget();
    }

    public final void m1() throws ExoPlaybackException {
        x0 p10 = this.f19504s.p();
        if (p10 == null) {
            return;
        }
        long i10 = p10.f23235d ? p10.f23232a.i() : -9223372036854775807L;
        if (i10 != -9223372036854775807L) {
            r0(i10);
            if (i10 != this.f19509x.f20012s) {
                e1 e1Var = this.f19509x;
                this.f19509x = K(e1Var.f19995b, i10, e1Var.f19996c, i10, true, 5);
            }
        } else {
            long i11 = this.f19500o.i(p10 != this.f19504s.q());
            this.L = i11;
            long y10 = p10.y(i11);
            W(this.f19509x.f20012s, y10);
            this.f19509x.f20012s = y10;
        }
        this.f19509x.f20010q = this.f19504s.j().i();
        this.f19509x.f20011r = B();
        e1 e1Var2 = this.f19509x;
        if (e1Var2.f20005l && e1Var2.f19998e == 3 && d1(e1Var2.f19994a, e1Var2.f19995b) && this.f19509x.f20007n.f20698a == 1.0f) {
            float b4 = this.f19506u.b(v(), B());
            if (this.f19500o.d().f20698a != b4) {
                this.f19500o.c(this.f19509x.f20007n.b(b4));
                I(this.f19509x.f20007n, this.f19500o.d().f20698a, false, false);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.p.a
    public void n(com.google.android.exoplayer2.source.p pVar) {
        this.f19493h.c(8, pVar).sendToTarget();
    }

    public final boolean n0() throws ExoPlaybackException {
        x0 q10 = this.f19504s.q();
        TrackSelectorResult o10 = q10.o();
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            l1[] l1VarArr = this.f19487b;
            if (i10 >= l1VarArr.length) {
                return !z10;
            }
            l1 l1Var = l1VarArr[i10];
            if (O(l1Var)) {
                boolean z11 = l1Var.l() != q10.f23234c[i10];
                if (!o10.isRendererEnabled(i10) || z11) {
                    if (!l1Var.j()) {
                        l1Var.r(w(o10.selections[i10]), q10.f23234c[i10], q10.m(), q10.l());
                    } else if (l1Var.b()) {
                        m(l1Var);
                    } else {
                        z10 = true;
                    }
                }
            }
            i10++;
        }
    }

    public final void n1(float f10) {
        for (x0 p10 = this.f19504s.p(); p10 != null; p10 = p10.j()) {
            for (ExoTrackSelection exoTrackSelection : p10.o().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.q(f10);
                }
            }
        }
    }

    public final void o() throws ExoPlaybackException, IOException {
        boolean z10;
        boolean z11;
        int i10;
        boolean z12;
        long b4 = this.f19502q.b();
        l1();
        int i11 = this.f19509x.f19998e;
        if (i11 != 1 && i11 != 4) {
            x0 p10 = this.f19504s.p();
            if (p10 == null) {
                y0(b4, 10L);
                return;
            }
            com.google.android.exoplayer2.util.g0.a("doSomeWork");
            m1();
            if (p10.f23235d) {
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                p10.f23232a.t(this.f19509x.f20012s - this.f19498m, this.f19499n);
                int i12 = 0;
                z10 = true;
                z11 = true;
                while (true) {
                    l1[] l1VarArr = this.f19487b;
                    if (i12 >= l1VarArr.length) {
                        break;
                    }
                    l1 l1Var = l1VarArr[i12];
                    if (O(l1Var)) {
                        l1Var.k(this.L, elapsedRealtime);
                        z10 = z10 && l1Var.b();
                        boolean z13 = p10.f23234c[i12] != l1Var.l();
                        boolean z14 = z13 || (!z13 && l1Var.h()) || l1Var.isReady() || l1Var.b();
                        z11 = z11 && z14;
                        if (!z14) {
                            l1Var.q();
                        }
                    }
                    i12++;
                }
            } else {
                p10.f23232a.s();
                z10 = true;
                z11 = true;
            }
            long j10 = p10.f23237f.f23253e;
            boolean z15 = z10 && p10.f23235d && (j10 == -9223372036854775807L || j10 <= this.f19509x.f20012s);
            if (z15 && this.B) {
                this.B = false;
                P0(false, this.f19509x.f20006m, false, 5);
            }
            if (z15 && p10.f23237f.f23257i) {
                Y0(4);
                h1();
            } else if (this.f19509x.f19998e == 2 && c1(z11)) {
                Y0(3);
                this.O = null;
                if (b1()) {
                    e1();
                }
            } else if (this.f19509x.f19998e == 3 && (this.J != 0 ? !z11 : !P())) {
                this.C = b1();
                Y0(2);
                if (this.C) {
                    f0();
                    this.f19506u.d();
                }
                h1();
            }
            if (this.f19509x.f19998e == 2) {
                int i13 = 0;
                while (true) {
                    l1[] l1VarArr2 = this.f19487b;
                    if (i13 >= l1VarArr2.length) {
                        break;
                    }
                    if (O(l1VarArr2[i13]) && this.f19487b[i13].l() == p10.f23234c[i13]) {
                        this.f19487b[i13].q();
                    }
                    i13++;
                }
                e1 e1Var = this.f19509x;
                if (!e1Var.f20000g && e1Var.f20011r < 500000 && N()) {
                    throw new IllegalStateException("Playback stuck buffering and not loading");
                }
            }
            boolean z16 = this.I;
            e1 e1Var2 = this.f19509x;
            if (z16 != e1Var2.f20008o) {
                this.f19509x = e1Var2.d(z16);
            }
            if ((b1() && this.f19509x.f19998e == 3) || (i10 = this.f19509x.f19998e) == 2) {
                z12 = !V(b4, 10L);
            } else {
                if (this.J != 0 && i10 != 4) {
                    y0(b4, 1000L);
                } else {
                    this.f19493h.j(2);
                }
                z12 = false;
            }
            e1 e1Var3 = this.f19509x;
            if (e1Var3.f20009p != z12) {
                this.f19509x = e1Var3.i(z12);
            }
            this.H = false;
            com.google.android.exoplayer2.util.g0.c();
            return;
        }
        this.f19493h.j(2);
    }

    public final void o0() throws ExoPlaybackException {
        float f10 = this.f19500o.d().f20698a;
        x0 q10 = this.f19504s.q();
        boolean z10 = true;
        for (x0 p10 = this.f19504s.p(); p10 != null && p10.f23235d; p10 = p10.j()) {
            TrackSelectorResult v2 = p10.v(f10, this.f19509x.f19994a);
            if (!v2.isEquivalent(p10.o())) {
                if (z10) {
                    x0 p11 = this.f19504s.p();
                    boolean z11 = this.f19504s.z(p11);
                    boolean[] zArr = new boolean[this.f19487b.length];
                    long b4 = p11.b(v2, this.f19509x.f20012s, z11, zArr);
                    e1 e1Var = this.f19509x;
                    boolean z12 = (e1Var.f19998e == 4 || b4 == e1Var.f20012s) ? false : true;
                    e1 e1Var2 = this.f19509x;
                    this.f19509x = K(e1Var2.f19995b, b4, e1Var2.f19996c, e1Var2.f19997d, z12, 5);
                    if (z12) {
                        r0(b4);
                    }
                    boolean[] zArr2 = new boolean[this.f19487b.length];
                    int i10 = 0;
                    while (true) {
                        l1[] l1VarArr = this.f19487b;
                        if (i10 >= l1VarArr.length) {
                            break;
                        }
                        l1 l1Var = l1VarArr[i10];
                        zArr2[i10] = O(l1Var);
                        SampleStream sampleStream = p11.f23234c[i10];
                        if (zArr2[i10]) {
                            if (sampleStream != l1Var.l()) {
                                m(l1Var);
                            } else if (zArr[i10]) {
                                l1Var.n(this.L);
                            }
                        }
                        i10++;
                    }
                    r(zArr2);
                } else {
                    this.f19504s.z(p10);
                    if (p10.f23235d) {
                        p10.a(v2, Math.max(p10.f23237f.f23250b, p10.y(this.L)), false);
                    }
                }
                F(true);
                if (this.f19509x.f19998e != 4) {
                    T();
                    m1();
                    this.f19493h.h(2);
                    return;
                }
                return;
            }
            if (p10 == q10) {
                z10 = false;
            }
        }
    }

    public final synchronized void o1(com.google.common.base.t<Boolean> tVar, long j10) {
        long a10 = this.f19502q.a() + j10;
        boolean z10 = false;
        while (!tVar.get().booleanValue() && j10 > 0) {
            try {
                this.f19502q.c();
                wait(j10);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            j10 = a10 - this.f19502q.a();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.google.android.exoplayer2.m.a
    public void onPlaybackParametersChanged(f1 f1Var) {
        this.f19493h.c(16, f1Var).sendToTarget();
    }

    public final void p(int i10, boolean z10) throws ExoPlaybackException {
        l1 l1Var = this.f19487b[i10];
        if (O(l1Var)) {
            return;
        }
        x0 q10 = this.f19504s.q();
        boolean z11 = q10 == this.f19504s.p();
        TrackSelectorResult o10 = q10.o();
        RendererConfiguration rendererConfiguration = o10.rendererConfigurations[i10];
        Format[] w3 = w(o10.selections[i10]);
        boolean z12 = b1() && this.f19509x.f19998e == 3;
        boolean z13 = !z10 && z12;
        this.J++;
        l1Var.v(rendererConfiguration, w3, q10.f23234c[i10], this.L, z13, z11, q10.m(), q10.l());
        l1Var.i(103, new l1.a() { // from class: com.google.android.exoplayer2.ExoPlayerImplInternal.1
            @Override // com.google.android.exoplayer2.l1.a
            public void a() {
                ExoPlayerImplInternal.this.f19493h.h(2);
            }

            @Override // com.google.android.exoplayer2.l1.a
            public void b(long j10) {
                if (j10 >= 2000) {
                    ExoPlayerImplInternal.this.H = true;
                }
            }
        });
        this.f19500o.b(l1Var);
        if (z12) {
            l1Var.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p0(boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.p0(boolean, boolean, boolean, boolean):void");
    }

    public final void q() throws ExoPlaybackException {
        r(new boolean[this.f19487b.length]);
    }

    public final void q0() {
        x0 p10 = this.f19504s.p();
        this.B = p10 != null && p10.f23237f.f23256h && this.A;
    }

    public final void r(boolean[] zArr) throws ExoPlaybackException {
        x0 q10 = this.f19504s.q();
        TrackSelectorResult o10 = q10.o();
        for (int i10 = 0; i10 < this.f19487b.length; i10++) {
            if (!o10.isRendererEnabled(i10)) {
                this.f19487b[i10].reset();
            }
        }
        for (int i11 = 0; i11 < this.f19487b.length; i11++) {
            if (o10.isRendererEnabled(i11)) {
                p(i11, zArr[i11]);
            }
        }
        q10.f23238g = true;
    }

    public final void r0(long j10) throws ExoPlaybackException {
        x0 p10 = this.f19504s.p();
        if (p10 != null) {
            j10 = p10.z(j10);
        }
        this.L = j10;
        this.f19500o.e(j10);
        for (l1 l1Var : this.f19487b) {
            if (O(l1Var)) {
                l1Var.n(this.L);
            }
        }
        d0();
    }

    public final void s(l1 l1Var) throws ExoPlaybackException {
        if (l1Var.getState() == 2) {
            l1Var.stop();
        }
    }

    public void t(long j10) {
        this.P = j10;
    }

    public final ImmutableList<Metadata> u(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z10 = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.p(0).f19542k;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z10 = true;
                }
            }
        }
        return z10 ? aVar.k() : ImmutableList.of();
    }

    public final void u0(Timeline timeline, Timeline timeline2) {
        if (timeline.q() && timeline2.q()) {
            return;
        }
        for (int size = this.f19501p.size() - 1; size >= 0; size--) {
            if (!t0(this.f19501p.get(size), timeline, timeline2, this.E, this.F, this.f19496k, this.f19497l)) {
                this.f19501p.get(size).f19513b.markAsProcessed(false);
                this.f19501p.remove(size);
            }
        }
        Collections.sort(this.f19501p);
    }

    public final long v() {
        e1 e1Var = this.f19509x;
        return x(e1Var.f19994a, e1Var.f19995b.f21883a, e1Var.f20012s);
    }

    public final long x(Timeline timeline, Object obj, long j10) {
        timeline.n(timeline.h(obj, this.f19497l).f19658c, this.f19496k);
        Timeline.c cVar = this.f19496k;
        if (cVar.f19672f != -9223372036854775807L && cVar.f()) {
            Timeline.c cVar2 = this.f19496k;
            if (cVar2.f19675i) {
                return h.d(cVar2.a() - this.f19496k.f19672f) - (j10 + this.f19497l.m());
            }
        }
        return -9223372036854775807L;
    }

    public final long y() {
        x0 q10 = this.f19504s.q();
        if (q10 == null) {
            return 0L;
        }
        long l10 = q10.l();
        if (!q10.f23235d) {
            return l10;
        }
        int i10 = 0;
        while (true) {
            l1[] l1VarArr = this.f19487b;
            if (i10 >= l1VarArr.length) {
                return l10;
            }
            if (O(l1VarArr[i10]) && this.f19487b[i10].l() == q10.f23234c[i10]) {
                long m10 = this.f19487b[i10].m();
                if (m10 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l10 = Math.max(m10, l10);
            }
            i10++;
        }
    }

    public final void y0(long j10, long j11) {
        this.f19493h.j(2);
        this.f19493h.i(2, j10 + j11);
    }

    public final Pair<s.a, Long> z(Timeline timeline) {
        if (timeline.q()) {
            return Pair.create(e1.l(), 0L);
        }
        Pair<Object, Long> j10 = timeline.j(this.f19496k, this.f19497l, timeline.a(this.F), -9223372036854775807L);
        s.a A = this.f19504s.A(timeline, j10.first, 0L);
        long longValue = ((Long) j10.second).longValue();
        if (A.b()) {
            timeline.h(A.f21883a, this.f19497l);
            longValue = A.f21885c == this.f19497l.j(A.f21884b) ? this.f19497l.g() : 0L;
        }
        return Pair.create(A, Long.valueOf(longValue));
    }

    public void z0(Timeline timeline, int i10, long j10) {
        this.f19493h.c(3, new e(timeline, i10, j10)).sendToTarget();
    }
}
