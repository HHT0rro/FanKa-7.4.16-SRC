package x5;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x5.j;

/* compiled from: ChunkSampleStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class i<T extends j> implements SampleStream, m0, Loader.b<f>, Loader.f {

    /* renamed from: b, reason: collision with root package name */
    public final int f54517b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f54518c;

    /* renamed from: d, reason: collision with root package name */
    public final Format[] f54519d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean[] f54520e;

    /* renamed from: f, reason: collision with root package name */
    public final T f54521f;

    /* renamed from: g, reason: collision with root package name */
    public final m0.a<i<T>> f54522g;

    /* renamed from: h, reason: collision with root package name */
    public final z.a f54523h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f54524i;

    /* renamed from: j, reason: collision with root package name */
    public final Loader f54525j;

    /* renamed from: k, reason: collision with root package name */
    public final h f54526k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<x5.a> f54527l;

    /* renamed from: m, reason: collision with root package name */
    public final List<x5.a> f54528m;

    /* renamed from: n, reason: collision with root package name */
    public final l0 f54529n;

    /* renamed from: o, reason: collision with root package name */
    public final l0[] f54530o;

    /* renamed from: p, reason: collision with root package name */
    public final c f54531p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public f f54532q;

    /* renamed from: r, reason: collision with root package name */
    public Format f54533r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public b<T> f54534s;

    /* renamed from: t, reason: collision with root package name */
    public long f54535t;

    /* renamed from: u, reason: collision with root package name */
    public long f54536u;

    /* renamed from: v, reason: collision with root package name */
    public int f54537v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public x5.a f54538w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f54539x;

    /* compiled from: ChunkSampleStream.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements SampleStream {

        /* renamed from: b, reason: collision with root package name */
        public final i<T> f54540b;

        /* renamed from: c, reason: collision with root package name */
        public final l0 f54541c;

        /* renamed from: d, reason: collision with root package name */
        public final int f54542d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f54543e;

        public a(i<T> iVar, l0 l0Var, int i10) {
            this.f54540b = iVar;
            this.f54541c = l0Var;
            this.f54542d = i10;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void a() {
        }

        public final void b() {
            if (this.f54543e) {
                return;
            }
            i.this.f54523h.i(i.this.f54518c[this.f54542d], i.this.f54519d[this.f54542d], 0, null, i.this.f54536u);
            this.f54543e = true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
            if (i.this.G()) {
                return -3;
            }
            if (i.this.f54538w != null && i.this.f54538w.h(this.f54542d + 1) <= this.f54541c.C()) {
                return -3;
            }
            b();
            return this.f54541c.S(s0Var, decoderInputBuffer, i10, i.this.f54539x);
        }

        public void d() {
            com.google.android.exoplayer2.util.a.g(i.this.f54520e[this.f54542d]);
            i.this.f54520e[this.f54542d] = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !i.this.G() && this.f54541c.K(i.this.f54539x);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int l(long j10) {
            if (i.this.G()) {
                return 0;
            }
            int E = this.f54541c.E(j10, i.this.f54539x);
            if (i.this.f54538w != null) {
                E = Math.min(E, i.this.f54538w.h(this.f54542d + 1) - this.f54541c.C());
            }
            this.f54541c.e0(E);
            if (E > 0) {
                b();
            }
            return E;
        }
    }

    /* compiled from: ChunkSampleStream.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b<T extends j> {
        void a(i<T> iVar);
    }

    public i(int i10, @Nullable int[] iArr, @Nullable Format[] formatArr, T t2, m0.a<i<T>> aVar, o6.b bVar, long j10, com.google.android.exoplayer2.drm.c cVar, b.a aVar2, com.google.android.exoplayer2.upstream.h hVar, z.a aVar3) {
        this.f54517b = i10;
        int i11 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f54518c = iArr;
        this.f54519d = formatArr == null ? new Format[0] : formatArr;
        this.f54521f = t2;
        this.f54522g = aVar;
        this.f54523h = aVar3;
        this.f54524i = hVar;
        this.f54525j = new Loader("ChunkSampleStream");
        this.f54526k = new h();
        ArrayList<x5.a> arrayList = new ArrayList<>();
        this.f54527l = arrayList;
        this.f54528m = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f54530o = new l0[length];
        this.f54520e = new boolean[length];
        int i12 = length + 1;
        int[] iArr2 = new int[i12];
        l0[] l0VarArr = new l0[i12];
        l0 k10 = l0.k(bVar, (Looper) com.google.android.exoplayer2.util.a.e(Looper.myLooper()), cVar, aVar2);
        this.f54529n = k10;
        iArr2[0] = i10;
        l0VarArr[0] = k10;
        while (i11 < length) {
            l0 l10 = l0.l(bVar);
            this.f54530o[i11] = l10;
            int i13 = i11 + 1;
            l0VarArr[i13] = l10;
            iArr2[i13] = this.f54518c[i11];
            i11 = i13;
        }
        this.f54531p = new c(iArr2, l0VarArr);
        this.f54535t = j10;
        this.f54536u = j10;
    }

    public final void A(int i10) {
        com.google.android.exoplayer2.util.a.g(!this.f54525j.j());
        int size = this.f54527l.size();
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (!E(i10)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return;
        }
        long j10 = D().f54513h;
        x5.a B = B(i10);
        if (this.f54527l.isEmpty()) {
            this.f54535t = this.f54536u;
        }
        this.f54539x = false;
        this.f54523h.D(this.f54517b, B.f54512g, j10);
    }

    public final x5.a B(int i10) {
        x5.a aVar = this.f54527l.get(i10);
        ArrayList<x5.a> arrayList = this.f54527l;
        j0.G0(arrayList, i10, arrayList.size());
        this.f54537v = Math.max(this.f54537v, this.f54527l.size());
        int i11 = 0;
        this.f54529n.u(aVar.h(0));
        while (true) {
            l0[] l0VarArr = this.f54530o;
            if (i11 >= l0VarArr.length) {
                return aVar;
            }
            l0 l0Var = l0VarArr[i11];
            i11++;
            l0Var.u(aVar.h(i11));
        }
    }

    public T C() {
        return this.f54521f;
    }

    public final x5.a D() {
        return this.f54527l.get(r0.size() - 1);
    }

    public final boolean E(int i10) {
        int C;
        x5.a aVar = this.f54527l.get(i10);
        if (this.f54529n.C() > aVar.h(0)) {
            return true;
        }
        int i11 = 0;
        do {
            l0[] l0VarArr = this.f54530o;
            if (i11 >= l0VarArr.length) {
                return false;
            }
            C = l0VarArr[i11].C();
            i11++;
        } while (C <= aVar.h(i11));
        return true;
    }

    public final boolean F(f fVar) {
        return fVar instanceof x5.a;
    }

    public boolean G() {
        return this.f54535t != -9223372036854775807L;
    }

    public final void H() {
        int M = M(this.f54529n.C(), this.f54537v - 1);
        while (true) {
            int i10 = this.f54537v;
            if (i10 > M) {
                return;
            }
            this.f54537v = i10 + 1;
            I(i10);
        }
    }

    public final void I(int i10) {
        x5.a aVar = this.f54527l.get(i10);
        Format format = aVar.f54509d;
        if (!format.equals(this.f54533r)) {
            this.f54523h.i(this.f54517b, format, aVar.f54510e, aVar.f54511f, aVar.f54512g);
        }
        this.f54533r = format;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void n(f fVar, long j10, long j11, boolean z10) {
        this.f54532q = null;
        this.f54538w = null;
        com.google.android.exoplayer2.source.m mVar = new com.google.android.exoplayer2.source.m(fVar.f54506a, fVar.f54507b, fVar.e(), fVar.d(), j10, j11, fVar.a());
        this.f54524i.c(fVar.f54506a);
        this.f54523h.r(mVar, fVar.f54508c, this.f54517b, fVar.f54509d, fVar.f54510e, fVar.f54511f, fVar.f54512g, fVar.f54513h);
        if (z10) {
            return;
        }
        if (G()) {
            P();
        } else if (F(fVar)) {
            B(this.f54527l.size() - 1);
            if (this.f54527l.isEmpty()) {
                this.f54535t = this.f54536u;
            }
        }
        this.f54522g.k(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void o(f fVar, long j10, long j11) {
        this.f54532q = null;
        this.f54521f.f(fVar);
        com.google.android.exoplayer2.source.m mVar = new com.google.android.exoplayer2.source.m(fVar.f54506a, fVar.f54507b, fVar.e(), fVar.d(), j10, j11, fVar.a());
        this.f54524i.c(fVar.f54506a);
        this.f54523h.u(mVar, fVar.f54508c, this.f54517b, fVar.f54509d, fVar.f54510e, fVar.f54511f, fVar.f54512g, fVar.f54513h);
        this.f54522g.k(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f1  */
    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.upstream.Loader.c q(x5.f r31, long r32, long r34, java.io.IOException r36, int r37) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.i.q(x5.f, long, long, java.io.IOException, int):com.google.android.exoplayer2.upstream.Loader$c");
    }

    public final int M(int i10, int i11) {
        do {
            i11++;
            if (i11 >= this.f54527l.size()) {
                return this.f54527l.size() - 1;
            }
        } while (this.f54527l.get(i11).h(0) <= i10);
        return i11 - 1;
    }

    public void N() {
        O(null);
    }

    public void O(@Nullable b<T> bVar) {
        this.f54534s = bVar;
        this.f54529n.R();
        for (l0 l0Var : this.f54530o) {
            l0Var.R();
        }
        this.f54525j.m(this);
    }

    public final void P() {
        this.f54529n.V();
        for (l0 l0Var : this.f54530o) {
            l0Var.V();
        }
    }

    public void Q(long j10) {
        boolean Z;
        this.f54536u = j10;
        if (G()) {
            this.f54535t = j10;
            return;
        }
        x5.a aVar = null;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= this.f54527l.size()) {
                break;
            }
            x5.a aVar2 = this.f54527l.get(i11);
            long j11 = aVar2.f54512g;
            if (j11 == j10 && aVar2.f54478k == -9223372036854775807L) {
                aVar = aVar2;
                break;
            } else if (j11 > j10) {
                break;
            } else {
                i11++;
            }
        }
        if (aVar != null) {
            Z = this.f54529n.Y(aVar.h(0));
        } else {
            Z = this.f54529n.Z(j10, j10 < f());
        }
        if (Z) {
            this.f54537v = M(this.f54529n.C(), 0);
            l0[] l0VarArr = this.f54530o;
            int length = l0VarArr.length;
            while (i10 < length) {
                l0VarArr[i10].Z(j10, true);
                i10++;
            }
            return;
        }
        this.f54535t = j10;
        this.f54539x = false;
        this.f54527l.clear();
        this.f54537v = 0;
        if (this.f54525j.j()) {
            this.f54529n.r();
            l0[] l0VarArr2 = this.f54530o;
            int length2 = l0VarArr2.length;
            while (i10 < length2) {
                l0VarArr2[i10].r();
                i10++;
            }
            this.f54525j.f();
            return;
        }
        this.f54525j.g();
        P();
    }

    public i<T>.a R(long j10, int i10) {
        for (int i11 = 0; i11 < this.f54530o.length; i11++) {
            if (this.f54518c[i11] == i10) {
                com.google.android.exoplayer2.util.a.g(!this.f54520e[i11]);
                this.f54520e[i11] = true;
                this.f54530o[i11].Z(j10, true);
                return new a(this, this.f54530o[i11], i11);
            }
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void a() throws IOException {
        this.f54525j.a();
        this.f54529n.N();
        if (this.f54525j.j()) {
            return;
        }
        this.f54521f.a();
    }

    @Override // com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        List<x5.a> list;
        long j11;
        if (this.f54539x || this.f54525j.j() || this.f54525j.i()) {
            return false;
        }
        boolean G = G();
        if (G) {
            list = Collections.emptyList();
            j11 = this.f54535t;
        } else {
            list = this.f54528m;
            j11 = D().f54513h;
        }
        this.f54521f.c(j10, j11, list, this.f54526k);
        h hVar = this.f54526k;
        boolean z10 = hVar.f54516b;
        f fVar = hVar.f54515a;
        hVar.a();
        if (z10) {
            this.f54535t = -9223372036854775807L;
            this.f54539x = true;
            return true;
        }
        if (fVar == null) {
            return false;
        }
        this.f54532q = fVar;
        if (F(fVar)) {
            x5.a aVar = (x5.a) fVar;
            if (G) {
                long j12 = aVar.f54512g;
                long j13 = this.f54535t;
                if (j12 != j13) {
                    this.f54529n.b0(j13);
                    for (l0 l0Var : this.f54530o) {
                        l0Var.b0(this.f54535t);
                    }
                }
                this.f54535t = -9223372036854775807L;
            }
            aVar.j(this.f54531p);
            this.f54527l.add(aVar);
        } else if (fVar instanceof m) {
            ((m) fVar).f(this.f54531p);
        }
        this.f54523h.A(new com.google.android.exoplayer2.source.m(fVar.f54506a, fVar.f54507b, this.f54525j.n(fVar, this, this.f54524i.d(fVar.f54508c))), fVar.f54508c, this.f54517b, fVar.f54509d, fVar.f54510e, fVar.f54511f, fVar.f54512g, fVar.f54513h);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
        if (G()) {
            return -3;
        }
        x5.a aVar = this.f54538w;
        if (aVar != null && aVar.h(0) <= this.f54529n.C()) {
            return -3;
        }
        H();
        return this.f54529n.S(s0Var, decoderInputBuffer, i10, this.f54539x);
    }

    @Override // com.google.android.exoplayer2.source.m0
    public long d() {
        if (this.f54539x) {
            return Long.MIN_VALUE;
        }
        if (G()) {
            return this.f54535t;
        }
        long j10 = this.f54536u;
        x5.a D = D();
        if (!D.g()) {
            if (this.f54527l.size() > 1) {
                D = this.f54527l.get(r2.size() - 2);
            } else {
                D = null;
            }
        }
        if (D != null) {
            j10 = Math.max(j10, D.f54513h);
        }
        return Math.max(j10, this.f54529n.z());
    }

    @Override // com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        if (this.f54525j.i() || G()) {
            return;
        }
        if (this.f54525j.j()) {
            f fVar = (f) com.google.android.exoplayer2.util.a.e(this.f54532q);
            if (!(F(fVar) && E(this.f54527l.size() - 1)) && this.f54521f.j(j10, fVar, this.f54528m)) {
                this.f54525j.f();
                if (F(fVar)) {
                    this.f54538w = (x5.a) fVar;
                    return;
                }
                return;
            }
            return;
        }
        int d10 = this.f54521f.d(j10, this.f54528m);
        if (d10 < this.f54527l.size()) {
            A(d10);
        }
    }

    @Override // com.google.android.exoplayer2.source.m0
    public long f() {
        if (G()) {
            return this.f54535t;
        }
        if (this.f54539x) {
            return Long.MIN_VALUE;
        }
        return D().f54513h;
    }

    public long g(long j10, p1 p1Var) {
        return this.f54521f.g(j10, p1Var);
    }

    @Override // com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f54525j.j();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return !G() && this.f54529n.K(this.f54539x);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void k() {
        this.f54529n.T();
        for (l0 l0Var : this.f54530o) {
            l0Var.T();
        }
        this.f54521f.release();
        b<T> bVar = this.f54534s;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int l(long j10) {
        if (G()) {
            return 0;
        }
        int E = this.f54529n.E(j10, this.f54539x);
        x5.a aVar = this.f54538w;
        if (aVar != null) {
            E = Math.min(E, aVar.h(0) - this.f54529n.C());
        }
        this.f54529n.e0(E);
        H();
        return E;
    }

    public void t(long j10, boolean z10) {
        if (G()) {
            return;
        }
        int x10 = this.f54529n.x();
        this.f54529n.q(j10, z10, true);
        int x11 = this.f54529n.x();
        if (x11 > x10) {
            long y10 = this.f54529n.y();
            int i10 = 0;
            while (true) {
                l0[] l0VarArr = this.f54530o;
                if (i10 >= l0VarArr.length) {
                    break;
                }
                l0VarArr[i10].q(y10, z10, this.f54520e[i10]);
                i10++;
            }
        }
        z(x11);
    }

    public final void z(int i10) {
        int min = Math.min(M(i10, 0), this.f54537v);
        if (min > 0) {
            j0.G0(this.f54527l, 0, min);
            this.f54537v -= min;
        }
    }
}
