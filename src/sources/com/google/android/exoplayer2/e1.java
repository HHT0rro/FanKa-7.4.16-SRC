package com.google.android.exoplayer2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: PlaybackInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e1 {

    /* renamed from: t, reason: collision with root package name */
    public static final s.a f19993t = new s.a(new Object());

    /* renamed from: a, reason: collision with root package name */
    public final Timeline f19994a;

    /* renamed from: b, reason: collision with root package name */
    public final s.a f19995b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19996c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19997d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19998e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final ExoPlaybackException f19999f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f20000g;

    /* renamed from: h, reason: collision with root package name */
    public final TrackGroupArray f20001h;

    /* renamed from: i, reason: collision with root package name */
    public final TrackSelectorResult f20002i;

    /* renamed from: j, reason: collision with root package name */
    public final List<Metadata> f20003j;

    /* renamed from: k, reason: collision with root package name */
    public final s.a f20004k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f20005l;

    /* renamed from: m, reason: collision with root package name */
    public final int f20006m;

    /* renamed from: n, reason: collision with root package name */
    public final f1 f20007n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f20008o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f20009p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f20010q;

    /* renamed from: r, reason: collision with root package name */
    public volatile long f20011r;

    /* renamed from: s, reason: collision with root package name */
    public volatile long f20012s;

    public e1(Timeline timeline, s.a aVar, long j10, long j11, int i10, @Nullable ExoPlaybackException exoPlaybackException, boolean z10, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list, s.a aVar2, boolean z11, int i11, f1 f1Var, long j12, long j13, long j14, boolean z12, boolean z13) {
        this.f19994a = timeline;
        this.f19995b = aVar;
        this.f19996c = j10;
        this.f19997d = j11;
        this.f19998e = i10;
        this.f19999f = exoPlaybackException;
        this.f20000g = z10;
        this.f20001h = trackGroupArray;
        this.f20002i = trackSelectorResult;
        this.f20003j = list;
        this.f20004k = aVar2;
        this.f20005l = z11;
        this.f20006m = i11;
        this.f20007n = f1Var;
        this.f20010q = j12;
        this.f20011r = j13;
        this.f20012s = j14;
        this.f20008o = z12;
        this.f20009p = z13;
    }

    public static e1 k(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.f19653a;
        s.a aVar = f19993t;
        return new e1(timeline, aVar, -9223372036854775807L, 0L, 1, null, false, TrackGroupArray.f21171e, trackSelectorResult, ImmutableList.of(), aVar, false, 0, f1.f20696d, 0L, 0L, 0L, false, false);
    }

    public static s.a l() {
        return f19993t;
    }

    @CheckResult
    public e1 a(boolean z10) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, this.f19998e, this.f19999f, z10, this.f20001h, this.f20002i, this.f20003j, this.f20004k, this.f20005l, this.f20006m, this.f20007n, this.f20010q, this.f20011r, this.f20012s, this.f20008o, this.f20009p);
    }

    @CheckResult
    public e1 b(s.a aVar) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, this.f19998e, this.f19999f, this.f20000g, this.f20001h, this.f20002i, this.f20003j, aVar, this.f20005l, this.f20006m, this.f20007n, this.f20010q, this.f20011r, this.f20012s, this.f20008o, this.f20009p);
    }

    @CheckResult
    public e1 c(s.a aVar, long j10, long j11, long j12, long j13, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list) {
        return new e1(this.f19994a, aVar, j11, j12, this.f19998e, this.f19999f, this.f20000g, trackGroupArray, trackSelectorResult, list, this.f20004k, this.f20005l, this.f20006m, this.f20007n, this.f20010q, j13, j10, this.f20008o, this.f20009p);
    }

    @CheckResult
    public e1 d(boolean z10) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, this.f19998e, this.f19999f, this.f20000g, this.f20001h, this.f20002i, this.f20003j, this.f20004k, this.f20005l, this.f20006m, this.f20007n, this.f20010q, this.f20011r, this.f20012s, z10, this.f20009p);
    }

    @CheckResult
    public e1 e(boolean z10, int i10) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, this.f19998e, this.f19999f, this.f20000g, this.f20001h, this.f20002i, this.f20003j, this.f20004k, z10, i10, this.f20007n, this.f20010q, this.f20011r, this.f20012s, this.f20008o, this.f20009p);
    }

    @CheckResult
    public e1 f(@Nullable ExoPlaybackException exoPlaybackException) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, this.f19998e, exoPlaybackException, this.f20000g, this.f20001h, this.f20002i, this.f20003j, this.f20004k, this.f20005l, this.f20006m, this.f20007n, this.f20010q, this.f20011r, this.f20012s, this.f20008o, this.f20009p);
    }

    @CheckResult
    public e1 g(f1 f1Var) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, this.f19998e, this.f19999f, this.f20000g, this.f20001h, this.f20002i, this.f20003j, this.f20004k, this.f20005l, this.f20006m, f1Var, this.f20010q, this.f20011r, this.f20012s, this.f20008o, this.f20009p);
    }

    @CheckResult
    public e1 h(int i10) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, i10, this.f19999f, this.f20000g, this.f20001h, this.f20002i, this.f20003j, this.f20004k, this.f20005l, this.f20006m, this.f20007n, this.f20010q, this.f20011r, this.f20012s, this.f20008o, this.f20009p);
    }

    @CheckResult
    public e1 i(boolean z10) {
        return new e1(this.f19994a, this.f19995b, this.f19996c, this.f19997d, this.f19998e, this.f19999f, this.f20000g, this.f20001h, this.f20002i, this.f20003j, this.f20004k, this.f20005l, this.f20006m, this.f20007n, this.f20010q, this.f20011r, this.f20012s, this.f20008o, z10);
    }

    @CheckResult
    public e1 j(Timeline timeline) {
        return new e1(timeline, this.f19995b, this.f19996c, this.f19997d, this.f19998e, this.f19999f, this.f20000g, this.f20001h, this.f20002i, this.f20003j, this.f20004k, this.f20005l, this.f20006m, this.f20007n, this.f20010q, this.f20011r, this.f20012s, this.f20008o, this.f20009p);
    }
}
