package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.w0;

/* compiled from: ProgressiveMediaSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h0 extends com.google.android.exoplayer2.source.a implements g0.b {

    /* renamed from: h, reason: collision with root package name */
    public final w0 f21431h;

    /* renamed from: i, reason: collision with root package name */
    public final w0.g f21432i;

    /* renamed from: j, reason: collision with root package name */
    public final a.InterfaceC0208a f21433j;

    /* renamed from: k, reason: collision with root package name */
    public final c0.a f21434k;

    /* renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f21435l;

    /* renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21436m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21437n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21438o;

    /* renamed from: p, reason: collision with root package name */
    public long f21439p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21440q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21441r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public o6.v f21442s;

    /* compiled from: ProgressiveMediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a extends k {
        public a(h0 h0Var, Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
            super.g(i10, bVar, z10);
            bVar.f19661f = true;
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.Timeline
        public Timeline.c o(int i10, Timeline.c cVar, long j10) {
            super.o(i10, cVar, j10);
            cVar.f19678l = true;
            return cVar;
        }
    }

    /* compiled from: ProgressiveMediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0208a f21443a;

        /* renamed from: b, reason: collision with root package name */
        public c0.a f21444b;

        /* renamed from: c, reason: collision with root package name */
        public b5.u f21445c;

        /* renamed from: d, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.h f21446d;

        /* renamed from: e, reason: collision with root package name */
        public int f21447e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public String f21448f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public Object f21449g;

        public b(a.InterfaceC0208a interfaceC0208a) {
            this(interfaceC0208a, new d5.c());
        }

        public static /* synthetic */ c0 e(d5.i iVar) {
            return new com.google.android.exoplayer2.source.b(iVar);
        }

        @Override // com.google.android.exoplayer2.source.a0
        public int[] a() {
            return new int[]{4};
        }

        @Override // com.google.android.exoplayer2.source.a0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h0 b(w0 w0Var) {
            com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
            w0.g gVar = w0Var.f23163b;
            boolean z10 = gVar.f23223h == null && this.f21449g != null;
            boolean z11 = gVar.f23221f == null && this.f21448f != null;
            if (z10 && z11) {
                w0Var = w0Var.a().s(this.f21449g).b(this.f21448f).a();
            } else if (z10) {
                w0Var = w0Var.a().s(this.f21449g).a();
            } else if (z11) {
                w0Var = w0Var.a().b(this.f21448f).a();
            }
            w0 w0Var2 = w0Var;
            return new h0(w0Var2, this.f21443a, this.f21444b, this.f21445c.a(w0Var2), this.f21446d, this.f21447e, null);
        }

        public b(a.InterfaceC0208a interfaceC0208a, final d5.i iVar) {
            this(interfaceC0208a, new c0.a() { // from class: com.google.android.exoplayer2.source.i0
                @Override // com.google.android.exoplayer2.source.c0.a
                public final c0 a() {
                    c0 e2;
                    e2 = h0.b.e(d5.i.this);
                    return e2;
                }
            });
        }

        public b(a.InterfaceC0208a interfaceC0208a, c0.a aVar) {
            this.f21443a = interfaceC0208a;
            this.f21444b = aVar;
            this.f21445c = new com.google.android.exoplayer2.drm.a();
            this.f21446d = new com.google.android.exoplayer2.upstream.f();
            this.f21447e = 1048576;
        }
    }

    public /* synthetic */ h0(w0 w0Var, a.InterfaceC0208a interfaceC0208a, c0.a aVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.h hVar, int i10, a aVar2) {
        this(w0Var, interfaceC0208a, aVar, cVar, hVar, i10);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable o6.v vVar) {
        this.f21442s = vVar;
        this.f21435l.prepare();
        E();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.f21435l.release();
    }

    public final void E() {
        Timeline n0Var = new n0(this.f21439p, this.f21440q, false, this.f21441r, null, this.f21431h);
        if (this.f21438o) {
            n0Var = new a(this, n0Var);
        }
        C(n0Var);
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21431h;
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        com.google.android.exoplayer2.upstream.a a10 = this.f21433j.a();
        o6.v vVar = this.f21442s;
        if (vVar != null) {
            a10.d(vVar);
        }
        return new g0(this.f21432i.f23216a, a10, this.f21434k.a(), this.f21435l, u(aVar), this.f21436m, w(aVar), this, bVar, this.f21432i.f23221f, this.f21437n);
    }

    @Override // com.google.android.exoplayer2.source.s
    public void f() {
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        ((g0) pVar).b0();
    }

    @Override // com.google.android.exoplayer2.source.g0.b
    public void m(long j10, boolean z10, boolean z11) {
        if (j10 == -9223372036854775807L) {
            j10 = this.f21439p;
        }
        if (!this.f21438o && this.f21439p == j10 && this.f21440q == z10 && this.f21441r == z11) {
            return;
        }
        this.f21439p = j10;
        this.f21440q = z10;
        this.f21441r = z11;
        this.f21438o = false;
        E();
    }

    public h0(w0 w0Var, a.InterfaceC0208a interfaceC0208a, c0.a aVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.h hVar, int i10) {
        this.f21432i = (w0.g) com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
        this.f21431h = w0Var;
        this.f21433j = interfaceC0208a;
        this.f21434k = aVar;
        this.f21435l = cVar;
        this.f21436m = hVar;
        this.f21437n = i10;
        this.f21438o = true;
        this.f21439p = -9223372036854775807L;
    }
}
