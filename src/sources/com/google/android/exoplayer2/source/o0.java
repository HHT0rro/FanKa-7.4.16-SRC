package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: SingleSampleMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o0 implements p, Loader.b<c> {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f21848b;

    /* renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0208a f21849c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final o6.v f21850d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21851e;

    /* renamed from: f, reason: collision with root package name */
    public final z.a f21852f;

    /* renamed from: g, reason: collision with root package name */
    public final TrackGroupArray f21853g;

    /* renamed from: i, reason: collision with root package name */
    public final long f21855i;

    /* renamed from: k, reason: collision with root package name */
    public final Format f21857k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f21858l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21859m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f21860n;

    /* renamed from: o, reason: collision with root package name */
    public int f21861o;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<b> f21854h = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public final Loader f21856j = new Loader("SingleSampleMediaPeriod");

    /* compiled from: SingleSampleMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements SampleStream {

        /* renamed from: b, reason: collision with root package name */
        public int f21862b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21863c;

        public b() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void a() throws IOException {
            o0 o0Var = o0.this;
            if (o0Var.f21858l) {
                return;
            }
            o0Var.f21856j.a();
        }

        public final void b() {
            if (this.f21863c) {
                return;
            }
            o0.this.f21852f.i(com.google.android.exoplayer2.util.q.l(o0.this.f21857k.f19544m), o0.this.f21857k, 0, null, 0L);
            this.f21863c = true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
            b();
            o0 o0Var = o0.this;
            boolean z10 = o0Var.f21859m;
            if (z10 && o0Var.f21860n == null) {
                this.f21862b = 2;
            }
            int i11 = this.f21862b;
            if (i11 == 2) {
                decoderInputBuffer.g(4);
                return -4;
            }
            if ((i10 & 2) != 0 || i11 == 0) {
                s0Var.f21132b = o0Var.f21857k;
                this.f21862b = 1;
                return -5;
            }
            if (!z10) {
                return -3;
            }
            com.google.android.exoplayer2.util.a.e(o0Var.f21860n);
            decoderInputBuffer.g(1);
            decoderInputBuffer.f19884f = 0L;
            if ((i10 & 4) == 0) {
                decoderInputBuffer.q(o0.this.f21861o);
                ByteBuffer byteBuffer = decoderInputBuffer.f19882d;
                o0 o0Var2 = o0.this;
                byteBuffer.put(o0Var2.f21860n, 0, o0Var2.f21861o);
            }
            if ((i10 & 1) == 0) {
                this.f21862b = 2;
            }
            return -4;
        }

        public void d() {
            if (this.f21862b == 2) {
                this.f21862b = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return o0.this.f21859m;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int l(long j10) {
            b();
            if (j10 <= 0 || this.f21862b == 2) {
                return 0;
            }
            this.f21862b = 2;
            return 1;
        }
    }

    /* compiled from: SingleSampleMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Loader.e {

        /* renamed from: a, reason: collision with root package name */
        public final long f21865a = m.a();

        /* renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.b f21866b;

        /* renamed from: c, reason: collision with root package name */
        public final o6.t f21867c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public byte[] f21868d;

        public c(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.upstream.a aVar) {
            this.f21866b = bVar;
            this.f21867c = new o6.t(aVar);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void load() throws IOException {
            this.f21867c.v();
            try {
                this.f21867c.a(this.f21866b);
                int i10 = 0;
                while (i10 != -1) {
                    int n10 = (int) this.f21867c.n();
                    byte[] bArr = this.f21868d;
                    if (bArr == null) {
                        this.f21868d = new byte[1024];
                    } else if (n10 == bArr.length) {
                        this.f21868d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    o6.t tVar = this.f21867c;
                    byte[] bArr2 = this.f21868d;
                    i10 = tVar.read(bArr2, n10, bArr2.length - n10);
                }
            } finally {
                com.google.android.exoplayer2.util.j0.n(this.f21867c);
            }
        }
    }

    public o0(com.google.android.exoplayer2.upstream.b bVar, a.InterfaceC0208a interfaceC0208a, @Nullable o6.v vVar, Format format, long j10, com.google.android.exoplayer2.upstream.h hVar, z.a aVar, boolean z10) {
        this.f21848b = bVar;
        this.f21849c = interfaceC0208a;
        this.f21850d = vVar;
        this.f21857k = format;
        this.f21855i = j10;
        this.f21851e = hVar;
        this.f21852f = aVar;
        this.f21858l = z10;
        this.f21853g = new TrackGroupArray(new TrackGroup(format));
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        if (this.f21859m || this.f21856j.j() || this.f21856j.i()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.a a10 = this.f21849c.a();
        o6.v vVar = this.f21850d;
        if (vVar != null) {
            a10.d(vVar);
        }
        c cVar = new c(this.f21848b, a10);
        this.f21852f.A(new m(cVar.f21865a, this.f21848b, this.f21856j.n(cVar, this, this.f21851e.d(1))), 1, -1, this.f21857k, 0, null, 0L, this.f21855i);
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void n(c cVar, long j10, long j11, boolean z10) {
        o6.t tVar = cVar.f21867c;
        m mVar = new m(cVar.f21865a, cVar.f21866b, tVar.t(), tVar.u(), j10, j11, tVar.n());
        this.f21851e.c(cVar.f21865a);
        this.f21852f.r(mVar, 1, -1, null, 0, null, 0L, this.f21855i);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        return this.f21859m ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        return (this.f21859m || this.f21856j.j()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        for (int i10 = 0; i10 < this.f21854h.size(); i10++) {
            this.f21854h.get(i10).d();
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f21856j.j();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            if (sampleStreamArr[i10] != null && (exoTrackSelectionArr[i10] == null || !zArr[i10])) {
                this.f21854h.remove(sampleStreamArr[i10]);
                sampleStreamArr[i10] = null;
            }
            if (sampleStreamArr[i10] == null && exoTrackSelectionArr[i10] != null) {
                b bVar = new b();
                this.f21854h.add(bVar);
                sampleStreamArr[i10] = bVar;
                zArr2[i10] = true;
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void o(c cVar, long j10, long j11) {
        this.f21861o = (int) cVar.f21867c.n();
        this.f21860n = (byte[]) com.google.android.exoplayer2.util.a.e(cVar.f21868d);
        this.f21859m = true;
        o6.t tVar = cVar.f21867c;
        m mVar = new m(cVar.f21865a, cVar.f21866b, tVar.t(), tVar.u(), j10, j11, this.f21861o);
        this.f21851e.c(cVar.f21865a);
        this.f21852f.u(mVar, 1, -1, this.f21857k, 0, null, 0L, this.f21855i);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Loader.c q(c cVar, long j10, long j11, IOException iOException, int i10) {
        Loader.c cVar2;
        o6.t tVar = cVar.f21867c;
        m mVar = new m(cVar.f21865a, cVar.f21866b, tVar.t(), tVar.u(), j10, j11, tVar.n());
        long a10 = this.f21851e.a(new h.c(mVar, new MediaLoadData(1, -1, this.f21857k, 0, null, 0L, com.google.android.exoplayer2.h.e(this.f21855i)), iOException, i10));
        boolean z10 = a10 == -9223372036854775807L || i10 >= this.f21851e.d(1);
        if (this.f21858l && z10) {
            com.google.android.exoplayer2.util.m.i("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f21859m = true;
            cVar2 = Loader.f22732f;
        } else if (a10 != -9223372036854775807L) {
            cVar2 = Loader.h(false, a10);
        } else {
            cVar2 = Loader.f22733g;
        }
        Loader.c cVar3 = cVar2;
        boolean z11 = !cVar3.c();
        this.f21852f.w(mVar, 1, -1, this.f21857k, 0, null, 0L, this.f21855i, iOException, z11);
        if (z11) {
            this.f21851e.c(cVar.f21865a);
        }
        return cVar3;
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        return this.f21853g;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        aVar.n(this);
    }

    public void r() {
        this.f21856j.l();
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() {
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
    }
}
