package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: SampleQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class l0 implements TrackOutput {
    public boolean A;

    @Nullable
    public Format B;

    @Nullable
    public Format C;
    public int D;
    public boolean E;
    public boolean F;
    public long G;
    public boolean H;

    /* renamed from: a, reason: collision with root package name */
    public final j0 f21772a;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.drm.c f21775d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final b.a f21776e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Looper f21777f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public d f21778g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Format f21779h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public DrmSession f21780i;

    /* renamed from: q, reason: collision with root package name */
    public int f21788q;

    /* renamed from: r, reason: collision with root package name */
    public int f21789r;

    /* renamed from: s, reason: collision with root package name */
    public int f21790s;

    /* renamed from: t, reason: collision with root package name */
    public int f21791t;

    /* renamed from: x, reason: collision with root package name */
    public boolean f21795x;

    /* renamed from: b, reason: collision with root package name */
    public final b f21773b = new b();

    /* renamed from: j, reason: collision with root package name */
    public int f21781j = 1000;

    /* renamed from: k, reason: collision with root package name */
    public int[] f21782k = new int[1000];

    /* renamed from: l, reason: collision with root package name */
    public long[] f21783l = new long[1000];

    /* renamed from: o, reason: collision with root package name */
    public long[] f21786o = new long[1000];

    /* renamed from: n, reason: collision with root package name */
    public int[] f21785n = new int[1000];

    /* renamed from: m, reason: collision with root package name */
    public int[] f21784m = new int[1000];

    /* renamed from: p, reason: collision with root package name */
    public TrackOutput.CryptoData[] f21787p = new TrackOutput.CryptoData[1000];

    /* renamed from: c, reason: collision with root package name */
    public final SpannedData<c> f21774c = new SpannedData<>(new Consumer() { // from class: com.google.android.exoplayer2.source.k0
        @Override // com.google.android.exoplayer2.util.Consumer
        public final void accept(Object obj) {
            l0.L((l0.c) obj);
        }
    });

    /* renamed from: u, reason: collision with root package name */
    public long f21792u = Long.MIN_VALUE;

    /* renamed from: v, reason: collision with root package name */
    public long f21793v = Long.MIN_VALUE;

    /* renamed from: w, reason: collision with root package name */
    public long f21794w = Long.MIN_VALUE;

    /* renamed from: z, reason: collision with root package name */
    public boolean f21797z = true;

    /* renamed from: y, reason: collision with root package name */
    public boolean f21796y = true;

    /* compiled from: SampleQueue.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f21798a;

        /* renamed from: b, reason: collision with root package name */
        public long f21799b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public TrackOutput.CryptoData f21800c;
    }

    /* compiled from: SampleQueue.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Format f21801a;

        /* renamed from: b, reason: collision with root package name */
        public final c.b f21802b;

        public c(Format format, c.b bVar) {
            this.f21801a = format;
            this.f21802b = bVar;
        }
    }

    /* compiled from: SampleQueue.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {
        void a(Format format);
    }

    public l0(o6.b bVar, @Nullable Looper looper, @Nullable com.google.android.exoplayer2.drm.c cVar, @Nullable b.a aVar) {
        this.f21777f = looper;
        this.f21775d = cVar;
        this.f21776e = aVar;
        this.f21772a = new j0(bVar);
    }

    public static /* synthetic */ void L(c cVar) {
        cVar.f21802b.release();
    }

    public static l0 k(o6.b bVar, Looper looper, com.google.android.exoplayer2.drm.c cVar, b.a aVar) {
        return new l0(bVar, (Looper) com.google.android.exoplayer2.util.a.e(looper), (com.google.android.exoplayer2.drm.c) com.google.android.exoplayer2.util.a.e(cVar), (b.a) com.google.android.exoplayer2.util.a.e(aVar));
    }

    public static l0 l(o6.b bVar) {
        return new l0(bVar, null, null, null);
    }

    public final synchronized long A() {
        return Math.max(this.f21793v, B(this.f21791t));
    }

    public final long B(int i10) {
        long j10 = Long.MIN_VALUE;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int D = D(i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = Math.max(j10, this.f21786o[D]);
            if ((this.f21785n[D] & 1) != 0) {
                break;
            }
            D--;
            if (D == -1) {
                D = this.f21781j - 1;
            }
        }
        return j10;
    }

    public final int C() {
        return this.f21789r + this.f21791t;
    }

    public final int D(int i10) {
        int i11 = this.f21790s + i10;
        int i12 = this.f21781j;
        return i11 < i12 ? i11 : i11 - i12;
    }

    public final synchronized int E(long j10, boolean z10) {
        int D = D(this.f21791t);
        if (H() && j10 >= this.f21786o[D]) {
            if (j10 > this.f21794w && z10) {
                return this.f21788q - this.f21791t;
            }
            int v2 = v(D, this.f21788q - this.f21791t, j10, true);
            if (v2 == -1) {
                return 0;
            }
            return v2;
        }
        return 0;
    }

    @Nullable
    public final synchronized Format F() {
        return this.f21797z ? null : this.C;
    }

    public final int G() {
        return this.f21789r + this.f21788q;
    }

    public final boolean H() {
        return this.f21791t != this.f21788q;
    }

    public final void I() {
        this.A = true;
    }

    public final synchronized boolean J() {
        return this.f21795x;
    }

    @CallSuper
    public synchronized boolean K(boolean z10) {
        Format format;
        boolean z11 = true;
        if (!H()) {
            if (!z10 && !this.f21795x && ((format = this.C) == null || format == this.f21779h)) {
                z11 = false;
            }
            return z11;
        }
        if (this.f21774c.get(C()).f21801a != this.f21779h) {
            return true;
        }
        return M(D(this.f21791t));
    }

    public final boolean M(int i10) {
        DrmSession drmSession = this.f21780i;
        return drmSession == null || drmSession.getState() == 4 || ((this.f21785n[i10] & 1073741824) == 0 && this.f21780i.b());
    }

    @CallSuper
    public void N() throws IOException {
        DrmSession drmSession = this.f21780i;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(this.f21780i.getError()));
        }
    }

    public final void O(Format format, s0 s0Var) {
        Format format2 = this.f21779h;
        boolean z10 = format2 == null;
        DrmInitData drmInitData = z10 ? null : format2.f19547p;
        this.f21779h = format;
        DrmInitData drmInitData2 = format.f19547p;
        com.google.android.exoplayer2.drm.c cVar = this.f21775d;
        s0Var.f21132b = cVar != null ? format.b(cVar.c(format)) : format;
        s0Var.f21131a = this.f21780i;
        if (this.f21775d == null) {
            return;
        }
        if (z10 || !com.google.android.exoplayer2.util.j0.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f21780i;
            DrmSession a10 = this.f21775d.a((Looper) com.google.android.exoplayer2.util.a.e(this.f21777f), this.f21776e, format);
            this.f21780i = a10;
            s0Var.f21131a = a10;
            if (drmSession != null) {
                drmSession.a(this.f21776e);
            }
        }
    }

    public final synchronized int P(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10, boolean z11, b bVar) {
        decoderInputBuffer.f19883e = false;
        if (!H()) {
            if (!z11 && !this.f21795x) {
                Format format = this.C;
                if (format == null || (!z10 && format == this.f21779h)) {
                    return -3;
                }
                O((Format) com.google.android.exoplayer2.util.a.e(format), s0Var);
                return -5;
            }
            decoderInputBuffer.o(4);
            return -4;
        }
        Format format2 = this.f21774c.get(C()).f21801a;
        if (!z10 && format2 == this.f21779h) {
            int D = D(this.f21791t);
            if (!M(D)) {
                decoderInputBuffer.f19883e = true;
                return -3;
            }
            decoderInputBuffer.o(this.f21785n[D]);
            long j10 = this.f21786o[D];
            decoderInputBuffer.f19884f = j10;
            if (j10 < this.f21792u) {
                decoderInputBuffer.g(Integer.MIN_VALUE);
            }
            bVar.f21798a = this.f21784m[D];
            bVar.f21799b = this.f21783l[D];
            bVar.f21800c = this.f21787p[D];
            return -4;
        }
        O(format2, s0Var);
        return -5;
    }

    public final synchronized int Q() {
        return H() ? this.f21782k[D(this.f21791t)] : this.D;
    }

    @CallSuper
    public void R() {
        r();
        U();
    }

    @CallSuper
    public int S(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10, boolean z10) {
        int P = P(s0Var, decoderInputBuffer, (i10 & 2) != 0, z10, this.f21773b);
        if (P == -4 && !decoderInputBuffer.m()) {
            boolean z11 = (i10 & 1) != 0;
            if ((i10 & 4) == 0) {
                if (z11) {
                    this.f21772a.f(decoderInputBuffer, this.f21773b);
                } else {
                    this.f21772a.m(decoderInputBuffer, this.f21773b);
                }
            }
            if (!z11) {
                this.f21791t++;
            }
        }
        return P;
    }

    @CallSuper
    public void T() {
        W(true);
        U();
    }

    public final void U() {
        DrmSession drmSession = this.f21780i;
        if (drmSession != null) {
            drmSession.a(this.f21776e);
            this.f21780i = null;
            this.f21779h = null;
        }
    }

    public final void V() {
        W(false);
    }

    @CallSuper
    public void W(boolean z10) {
        this.f21772a.n();
        this.f21788q = 0;
        this.f21789r = 0;
        this.f21790s = 0;
        this.f21791t = 0;
        this.f21796y = true;
        this.f21792u = Long.MIN_VALUE;
        this.f21793v = Long.MIN_VALUE;
        this.f21794w = Long.MIN_VALUE;
        this.f21795x = false;
        this.f21774c.clear();
        if (z10) {
            this.B = null;
            this.C = null;
            this.f21797z = true;
        }
    }

    public final synchronized void X() {
        this.f21791t = 0;
        this.f21772a.o();
    }

    public final synchronized boolean Y(int i10) {
        X();
        int i11 = this.f21789r;
        if (i10 >= i11 && i10 <= this.f21788q + i11) {
            this.f21792u = Long.MIN_VALUE;
            this.f21791t = i10 - i11;
            return true;
        }
        return false;
    }

    public final synchronized boolean Z(long j10, boolean z10) {
        X();
        int D = D(this.f21791t);
        if (H() && j10 >= this.f21786o[D] && (j10 <= this.f21794w || z10)) {
            int v2 = v(D, this.f21788q - this.f21791t, j10, true);
            if (v2 == -1) {
                return false;
            }
            this.f21792u = j10;
            this.f21791t += v2;
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ void a(ParsableByteArray parsableByteArray, int i10) {
        d5.p.b(this, parsableByteArray, i10);
    }

    public final void a0(long j10) {
        if (this.G != j10) {
            this.G = j10;
            I();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void b(Format format) {
        Format w3 = w(format);
        this.A = false;
        this.B = format;
        boolean c02 = c0(w3);
        d dVar = this.f21778g;
        if (dVar == null || !c02) {
            return;
        }
        dVar.a(w3);
    }

    public final void b0(long j10) {
        this.f21792u = j10;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public /* synthetic */ int c(o6.g gVar, int i10, boolean z10) {
        return d5.p.a(this, gVar, i10, z10);
    }

    public final synchronized boolean c0(Format format) {
        this.f21797z = false;
        if (com.google.android.exoplayer2.util.j0.c(format, this.C)) {
            return false;
        }
        if (!this.f21774c.isEmpty() && this.f21774c.getEndValue().f21801a.equals(format)) {
            this.C = this.f21774c.getEndValue().f21801a;
        } else {
            this.C = format;
        }
        Format format2 = this.C;
        this.E = com.google.android.exoplayer2.util.q.a(format2.f19544m, format2.f19541j);
        this.F = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(long r12, int r14, int r15, int r16, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput.CryptoData r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.A
            if (r0 == 0) goto L10
            com.google.android.exoplayer2.Format r0 = r8.B
            java.lang.Object r0 = com.google.android.exoplayer2.util.a.i(r0)
            com.google.android.exoplayer2.Format r0 = (com.google.android.exoplayer2.Format) r0
            r11.b(r0)
        L10:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = 1
            goto L19
        L18:
            r3 = 0
        L19:
            boolean r4 = r8.f21796y
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.f21796y = r1
        L22:
            long r4 = r8.G
            long r4 = r4 + r12
            boolean r6 = r8.E
            if (r6 == 0) goto L5e
            long r6 = r8.f21792u
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L30
            return
        L30:
            if (r0 != 0) goto L5e
            boolean r0 = r8.F
            if (r0 != 0) goto L5a
            com.google.android.exoplayer2.Format r0 = r8.C
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r6 = r0.length()
            int r6 = r6 + 50
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r7.append(r6)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            java.lang.String r6 = "SampleQueue"
            com.google.android.exoplayer2.util.m.h(r6, r0)
            r8.F = r2
        L5a:
            r0 = r14 | 1
            r6 = r0
            goto L5f
        L5e:
            r6 = r14
        L5f:
            boolean r0 = r8.H
            if (r0 == 0) goto L70
            if (r3 == 0) goto L6f
            boolean r0 = r11.h(r4)
            if (r0 != 0) goto L6c
            goto L6f
        L6c:
            r8.H = r1
            goto L70
        L6f:
            return
        L70:
            com.google.android.exoplayer2.source.j0 r0 = r8.f21772a
            long r0 = r0.e()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.i(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.l0.d(long, int, int, int, com.google.android.exoplayer2.extractor.TrackOutput$CryptoData):void");
    }

    public final void d0(@Nullable d dVar) {
        this.f21778g = dVar;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int e(o6.g gVar, int i10, boolean z10, int i11) throws IOException {
        return this.f21772a.p(gVar, i10, z10);
    }

    public final synchronized void e0(int i10) {
        boolean z10;
        if (i10 >= 0) {
            try {
                if (this.f21791t + i10 <= this.f21788q) {
                    z10 = true;
                    com.google.android.exoplayer2.util.a.a(z10);
                    this.f21791t += i10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z10 = false;
        com.google.android.exoplayer2.util.a.a(z10);
        this.f21791t += i10;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void f(ParsableByteArray parsableByteArray, int i10, int i11) {
        this.f21772a.q(parsableByteArray, i10);
    }

    public final void f0(int i10) {
        this.D = i10;
    }

    public final void g0() {
        this.H = true;
    }

    public final synchronized boolean h(long j10) {
        if (this.f21788q == 0) {
            return j10 > this.f21793v;
        }
        if (A() >= j10) {
            return false;
        }
        t(this.f21789r + j(j10));
        return true;
    }

    public final synchronized void i(long j10, int i10, long j11, int i11, @Nullable TrackOutput.CryptoData cryptoData) {
        c.b bVar;
        int i12 = this.f21788q;
        if (i12 > 0) {
            int D = D(i12 - 1);
            com.google.android.exoplayer2.util.a.a(this.f21783l[D] + ((long) this.f21784m[D]) <= j11);
        }
        this.f21795x = (536870912 & i10) != 0;
        this.f21794w = Math.max(this.f21794w, j10);
        int D2 = D(this.f21788q);
        this.f21786o[D2] = j10;
        this.f21783l[D2] = j11;
        this.f21784m[D2] = i11;
        this.f21785n[D2] = i10;
        this.f21787p[D2] = cryptoData;
        this.f21782k[D2] = this.D;
        if (this.f21774c.isEmpty() || !this.f21774c.getEndValue().f21801a.equals(this.C)) {
            com.google.android.exoplayer2.drm.c cVar = this.f21775d;
            if (cVar != null) {
                bVar = cVar.b((Looper) com.google.android.exoplayer2.util.a.e(this.f21777f), this.f21776e, this.C);
            } else {
                bVar = c.b.f19976a;
            }
            this.f21774c.appendSpan(G(), new c((Format) com.google.android.exoplayer2.util.a.e(this.C), bVar));
        }
        int i13 = this.f21788q + 1;
        this.f21788q = i13;
        int i14 = this.f21781j;
        if (i13 == i14) {
            int i15 = i14 + 1000;
            int[] iArr = new int[i15];
            long[] jArr = new long[i15];
            long[] jArr2 = new long[i15];
            int[] iArr2 = new int[i15];
            int[] iArr3 = new int[i15];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i15];
            int i16 = this.f21790s;
            int i17 = i14 - i16;
            System.arraycopy((Object) this.f21783l, i16, (Object) jArr, 0, i17);
            System.arraycopy((Object) this.f21786o, this.f21790s, (Object) jArr2, 0, i17);
            System.arraycopy((Object) this.f21785n, this.f21790s, (Object) iArr2, 0, i17);
            System.arraycopy((Object) this.f21784m, this.f21790s, (Object) iArr3, 0, i17);
            System.arraycopy(this.f21787p, this.f21790s, cryptoDataArr, 0, i17);
            System.arraycopy((Object) this.f21782k, this.f21790s, (Object) iArr, 0, i17);
            int i18 = this.f21790s;
            System.arraycopy((Object) this.f21783l, 0, (Object) jArr, i17, i18);
            System.arraycopy((Object) this.f21786o, 0, (Object) jArr2, i17, i18);
            System.arraycopy((Object) this.f21785n, 0, (Object) iArr2, i17, i18);
            System.arraycopy((Object) this.f21784m, 0, (Object) iArr3, i17, i18);
            System.arraycopy(this.f21787p, 0, cryptoDataArr, i17, i18);
            System.arraycopy((Object) this.f21782k, 0, (Object) iArr, i17, i18);
            this.f21783l = jArr;
            this.f21786o = jArr2;
            this.f21785n = iArr2;
            this.f21784m = iArr3;
            this.f21787p = cryptoDataArr;
            this.f21782k = iArr;
            this.f21790s = 0;
            this.f21781j = i15;
        }
    }

    public final int j(long j10) {
        int i10 = this.f21788q;
        int D = D(i10 - 1);
        while (i10 > this.f21791t && this.f21786o[D] >= j10) {
            i10--;
            D--;
            if (D == -1) {
                D = this.f21781j - 1;
            }
        }
        return i10;
    }

    public final synchronized long m(long j10, boolean z10, boolean z11) {
        int i10;
        int i11 = this.f21788q;
        if (i11 != 0) {
            long[] jArr = this.f21786o;
            int i12 = this.f21790s;
            if (j10 >= jArr[i12]) {
                if (z11 && (i10 = this.f21791t) != i11) {
                    i11 = i10 + 1;
                }
                int v2 = v(i12, i11, j10, z10);
                if (v2 == -1) {
                    return -1L;
                }
                return p(v2);
            }
        }
        return -1L;
    }

    public final synchronized long n() {
        int i10 = this.f21788q;
        if (i10 == 0) {
            return -1L;
        }
        return p(i10);
    }

    public synchronized long o() {
        int i10 = this.f21791t;
        if (i10 == 0) {
            return -1L;
        }
        return p(i10);
    }

    @GuardedBy("this")
    public final long p(int i10) {
        this.f21793v = Math.max(this.f21793v, B(i10));
        this.f21788q -= i10;
        int i11 = this.f21789r + i10;
        this.f21789r = i11;
        int i12 = this.f21790s + i10;
        this.f21790s = i12;
        int i13 = this.f21781j;
        if (i12 >= i13) {
            this.f21790s = i12 - i13;
        }
        int i14 = this.f21791t - i10;
        this.f21791t = i14;
        if (i14 < 0) {
            this.f21791t = 0;
        }
        this.f21774c.discardTo(i11);
        if (this.f21788q == 0) {
            int i15 = this.f21790s;
            if (i15 == 0) {
                i15 = this.f21781j;
            }
            return this.f21783l[i15 - 1] + this.f21784m[r6];
        }
        return this.f21783l[this.f21790s];
    }

    public final void q(long j10, boolean z10, boolean z11) {
        this.f21772a.b(m(j10, z10, z11));
    }

    public final void r() {
        this.f21772a.b(n());
    }

    public final void s() {
        this.f21772a.b(o());
    }

    public final long t(int i10) {
        int G = G() - i10;
        boolean z10 = false;
        com.google.android.exoplayer2.util.a.a(G >= 0 && G <= this.f21788q - this.f21791t);
        int i11 = this.f21788q - G;
        this.f21788q = i11;
        this.f21794w = Math.max(this.f21793v, B(i11));
        if (G == 0 && this.f21795x) {
            z10 = true;
        }
        this.f21795x = z10;
        this.f21774c.discardFrom(i10);
        int i12 = this.f21788q;
        if (i12 == 0) {
            return 0L;
        }
        return this.f21783l[D(i12 - 1)] + this.f21784m[r9];
    }

    public final void u(int i10) {
        this.f21772a.c(t(i10));
    }

    public final int v(int i10, int i11, long j10, boolean z10) {
        int i12 = -1;
        for (int i13 = 0; i13 < i11; i13++) {
            long[] jArr = this.f21786o;
            if (jArr[i10] > j10) {
                return i12;
            }
            if (!z10 || (this.f21785n[i10] & 1) != 0) {
                if (jArr[i10] == j10) {
                    return i13;
                }
                i12 = i13;
            }
            i10++;
            if (i10 == this.f21781j) {
                i10 = 0;
            }
        }
        return i12;
    }

    @CallSuper
    public Format w(Format format) {
        return (this.G == 0 || format.f19548q == Long.MAX_VALUE) ? format : format.a().i0(format.f19548q + this.G).E();
    }

    public final int x() {
        return this.f21789r;
    }

    public final synchronized long y() {
        return this.f21788q == 0 ? Long.MIN_VALUE : this.f21786o[this.f21790s];
    }

    public final synchronized long z() {
        return this.f21794w;
    }
}
