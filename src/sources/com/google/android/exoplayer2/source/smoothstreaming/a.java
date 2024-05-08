package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.extractor.mp4.f;
import com.google.android.exoplayer2.extractor.mp4.n;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.h;
import java.io.IOException;
import java.util.List;
import o6.r;
import o6.v;
import x5.e;
import x5.g;
import x5.h;
import x5.k;
import x5.o;

/* compiled from: DefaultSsChunkSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements com.google.android.exoplayer2.source.smoothstreaming.b {

    /* renamed from: a, reason: collision with root package name */
    public final r f22044a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22045b;

    /* renamed from: c, reason: collision with root package name */
    public final g[] f22046c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f22047d;

    /* renamed from: e, reason: collision with root package name */
    public ExoTrackSelection f22048e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f22049f;

    /* renamed from: g, reason: collision with root package name */
    public int f22050g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public IOException f22051h;

    /* compiled from: DefaultSsChunkSource.java */
    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0204a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0208a f22052a;

        public C0204a(a.InterfaceC0208a interfaceC0208a) {
            this.f22052a = interfaceC0208a;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public com.google.android.exoplayer2.source.smoothstreaming.b a(r rVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i10, ExoTrackSelection exoTrackSelection, @Nullable v vVar) {
            com.google.android.exoplayer2.upstream.a a10 = this.f22052a.a();
            if (vVar != null) {
                a10.d(vVar);
            }
            return new a(rVar, aVar, i10, exoTrackSelection, a10);
        }
    }

    /* compiled from: DefaultSsChunkSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends x5.b {

        /* renamed from: e, reason: collision with root package name */
        public final a.b f22053e;

        /* renamed from: f, reason: collision with root package name */
        public final int f22054f;

        public b(a.b bVar, int i10, int i11) {
            super(i11, bVar.f22122k - 1);
            this.f22053e = bVar;
            this.f22054f = i10;
        }

        @Override // x5.o
        public long a() {
            return b() + this.f22053e.c((int) d());
        }

        @Override // x5.o
        public long b() {
            c();
            return this.f22053e.e((int) d());
        }
    }

    public a(r rVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i10, ExoTrackSelection exoTrackSelection, com.google.android.exoplayer2.upstream.a aVar2) {
        this.f22044a = rVar;
        this.f22049f = aVar;
        this.f22045b = i10;
        this.f22048e = exoTrackSelection;
        this.f22047d = aVar2;
        a.b bVar = aVar.f22106f[i10];
        this.f22046c = new g[exoTrackSelection.length()];
        int i11 = 0;
        while (i11 < this.f22046c.length) {
            int c4 = exoTrackSelection.c(i11);
            Format format = bVar.f22121j[c4];
            TrackEncryptionBox[] trackEncryptionBoxArr = format.f19547p != null ? ((a.C0205a) com.google.android.exoplayer2.util.a.e(aVar.f22105e)).f22111c : null;
            int i12 = bVar.f22112a;
            int i13 = i11;
            this.f22046c[i13] = new e(new f(3, null, new n(c4, i12, bVar.f22114c, -9223372036854775807L, aVar.f22107g, format, 0, trackEncryptionBoxArr, i12 == 2 ? 4 : 0, null, null)), bVar.f22112a, format);
            i11 = i13 + 1;
        }
    }

    public static x5.n k(Format format, com.google.android.exoplayer2.upstream.a aVar, Uri uri, int i10, long j10, long j11, long j12, int i11, @Nullable Object obj, g gVar) {
        return new k(aVar, new com.google.android.exoplayer2.upstream.b(uri), format, i11, obj, j10, j11, j12, -9223372036854775807L, i10, 1, j10, gVar);
    }

    @Override // x5.j
    public void a() throws IOException {
        IOException iOException = this.f22051h;
        if (iOException == null) {
            this.f22044a.a();
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void b(ExoTrackSelection exoTrackSelection) {
        this.f22048e = exoTrackSelection;
    }

    @Override // x5.j
    public final void c(long j10, long j11, List<? extends x5.n> list, h hVar) {
        int f10;
        long j12 = j11;
        if (this.f22051h != null) {
            return;
        }
        a.b bVar = this.f22049f.f22106f[this.f22045b];
        if (bVar.f22122k == 0) {
            hVar.f54516b = !r4.f22104d;
            return;
        }
        if (list.isEmpty()) {
            f10 = bVar.d(j12);
        } else {
            f10 = (int) (list.get(list.size() - 1).f() - this.f22050g);
            if (f10 < 0) {
                this.f22051h = new BehindLiveWindowException();
                return;
            }
        }
        if (f10 >= bVar.f22122k) {
            hVar.f54516b = !this.f22049f.f22104d;
            return;
        }
        long j13 = j12 - j10;
        long l10 = l(j10);
        int length = this.f22048e.length();
        o[] oVarArr = new o[length];
        for (int i10 = 0; i10 < length; i10++) {
            oVarArr[i10] = new b(bVar, this.f22048e.c(i10), f10);
        }
        this.f22048e.i(j10, j13, l10, list, oVarArr);
        long e2 = bVar.e(f10);
        long c4 = e2 + bVar.c(f10);
        if (!list.isEmpty()) {
            j12 = -9223372036854775807L;
        }
        long j14 = j12;
        int i11 = f10 + this.f22050g;
        int a10 = this.f22048e.a();
        hVar.f54515a = k(this.f22048e.m(), this.f22047d, bVar.a(this.f22048e.c(a10), f10), i11, e2, c4, j14, this.f22048e.u(), this.f22048e.r(), this.f22046c[a10]);
    }

    @Override // x5.j
    public int d(long j10, List<? extends x5.n> list) {
        if (this.f22051h == null && this.f22048e.length() >= 2) {
            return this.f22048e.k(j10, list);
        }
        return list.size();
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void e(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b[] bVarArr = this.f22049f.f22106f;
        int i10 = this.f22045b;
        a.b bVar = bVarArr[i10];
        int i11 = bVar.f22122k;
        a.b bVar2 = aVar.f22106f[i10];
        if (i11 != 0 && bVar2.f22122k != 0) {
            int i12 = i11 - 1;
            long e2 = bVar.e(i12) + bVar.c(i12);
            long e10 = bVar2.e(0);
            if (e2 <= e10) {
                this.f22050g += i11;
            } else {
                this.f22050g += bVar.d(e10);
            }
        } else {
            this.f22050g += i11;
        }
        this.f22049f = aVar;
    }

    @Override // x5.j
    public void f(x5.f fVar) {
    }

    @Override // x5.j
    public long g(long j10, p1 p1Var) {
        a.b bVar = this.f22049f.f22106f[this.f22045b];
        int d10 = bVar.d(j10);
        long e2 = bVar.e(d10);
        return p1Var.a(j10, e2, (e2 >= j10 || d10 >= bVar.f22122k + (-1)) ? e2 : bVar.e(d10 + 1));
    }

    @Override // x5.j
    public boolean h(x5.f fVar, boolean z10, h.c cVar, com.google.android.exoplayer2.upstream.h hVar) {
        h.b b4 = hVar.b(com.google.android.exoplayer2.trackselection.c.a(this.f22048e), cVar);
        if (z10 && b4 != null && b4.f22890a == 2) {
            ExoTrackSelection exoTrackSelection = this.f22048e;
            if (exoTrackSelection.o(exoTrackSelection.t(fVar.f54509d), b4.f22891b)) {
                return true;
            }
        }
        return false;
    }

    @Override // x5.j
    public boolean j(long j10, x5.f fVar, List<? extends x5.n> list) {
        if (this.f22051h != null) {
            return false;
        }
        return this.f22048e.h(j10, fVar, list);
    }

    public final long l(long j10) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f22049f;
        if (!aVar.f22104d) {
            return -9223372036854775807L;
        }
        a.b bVar = aVar.f22106f[this.f22045b];
        int i10 = bVar.f22122k - 1;
        return (bVar.e(i10) + bVar.c(i10)) - j10;
    }

    @Override // x5.j
    public void release() {
        for (g gVar : this.f22046c) {
            gVar.release();
        }
    }
}
