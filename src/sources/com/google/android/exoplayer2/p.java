package com.google.android.exoplayer2;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.Clock;

/* compiled from: ExoPlayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface p extends Player {

    /* compiled from: ExoPlayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void d(boolean z10);

        void u(boolean z10);
    }

    /* compiled from: ExoPlayer.java */
    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final l1[] f21035a;

        /* renamed from: b, reason: collision with root package name */
        public Clock f21036b;

        /* renamed from: c, reason: collision with root package name */
        public n6.i f21037c;

        /* renamed from: d, reason: collision with root package name */
        public com.google.android.exoplayer2.source.a0 f21038d;

        /* renamed from: e, reason: collision with root package name */
        public v0 f21039e;

        /* renamed from: f, reason: collision with root package name */
        public o6.e f21040f;

        /* renamed from: g, reason: collision with root package name */
        public Looper f21041g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public w4.h1 f21042h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f21043i;

        /* renamed from: j, reason: collision with root package name */
        public p1 f21044j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f21045k;

        /* renamed from: l, reason: collision with root package name */
        public long f21046l;

        /* renamed from: m, reason: collision with root package name */
        public u0 f21047m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f21048n;

        /* renamed from: o, reason: collision with root package name */
        public long f21049o;

        public p a() {
            com.google.android.exoplayer2.util.a.g(!this.f21048n);
            this.f21048n = true;
            o0 o0Var = new o0(this.f21035a, this.f21037c, this.f21038d, this.f21039e, this.f21040f, this.f21042h, this.f21043i, this.f21044j, 5000L, 15000L, this.f21047m, this.f21046l, this.f21045k, this.f21036b, this.f21041g, null, Player.b.f19636b);
            long j10 = this.f21049o;
            if (j10 > 0) {
                o0Var.O0(j10);
            }
            return o0Var;
        }
    }

    @Nullable
    n6.i a();

    void b(com.google.android.exoplayer2.source.s sVar);
}
