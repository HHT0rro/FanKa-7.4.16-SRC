package x5;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.q;
import java.io.IOException;
import java.util.List;
import x5.g;

/* compiled from: BundledChunkExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements d5.e, g {

    /* renamed from: k, reason: collision with root package name */
    public static final g.a f54488k = new g.a() { // from class: x5.d
        @Override // x5.g.a
        public final g a(int i10, Format format, boolean z10, List list, TrackOutput trackOutput) {
            g g3;
            g3 = e.g(i10, format, z10, list, trackOutput);
            return g3;
        }
    };

    /* renamed from: l, reason: collision with root package name */
    public static final d5.n f54489l = new d5.n();

    /* renamed from: b, reason: collision with root package name */
    public final Extractor f54490b;

    /* renamed from: c, reason: collision with root package name */
    public final int f54491c;

    /* renamed from: d, reason: collision with root package name */
    public final Format f54492d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray<a> f54493e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f54494f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public g.b f54495g;

    /* renamed from: h, reason: collision with root package name */
    public long f54496h;

    /* renamed from: i, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.i f54497i;

    /* renamed from: j, reason: collision with root package name */
    public Format[] f54498j;

    /* compiled from: BundledChunkExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements TrackOutput {

        /* renamed from: a, reason: collision with root package name */
        public final int f54499a;

        /* renamed from: b, reason: collision with root package name */
        public final int f54500b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final Format f54501c;

        /* renamed from: d, reason: collision with root package name */
        public final com.google.android.exoplayer2.extractor.d f54502d = new com.google.android.exoplayer2.extractor.d();

        /* renamed from: e, reason: collision with root package name */
        public Format f54503e;

        /* renamed from: f, reason: collision with root package name */
        public TrackOutput f54504f;

        /* renamed from: g, reason: collision with root package name */
        public long f54505g;

        public a(int i10, int i11, @Nullable Format format) {
            this.f54499a = i10;
            this.f54500b = i11;
            this.f54501c = format;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ void a(ParsableByteArray parsableByteArray, int i10) {
            d5.p.b(this, parsableByteArray, i10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void b(Format format) {
            Format format2 = this.f54501c;
            if (format2 != null) {
                format = format.e(format2);
            }
            this.f54503e = format;
            ((TrackOutput) j0.j(this.f54504f)).b(this.f54503e);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public /* synthetic */ int c(o6.g gVar, int i10, boolean z10) {
            return d5.p.a(this, gVar, i10, z10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void d(long j10, int i10, int i11, int i12, @Nullable TrackOutput.CryptoData cryptoData) {
            long j11 = this.f54505g;
            if (j11 != -9223372036854775807L && j10 >= j11) {
                this.f54504f = this.f54502d;
            }
            ((TrackOutput) j0.j(this.f54504f)).d(j10, i10, i11, i12, cryptoData);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int e(o6.g gVar, int i10, boolean z10, int i11) throws IOException {
            return ((TrackOutput) j0.j(this.f54504f)).c(gVar, i10, z10);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void f(ParsableByteArray parsableByteArray, int i10, int i11) {
            ((TrackOutput) j0.j(this.f54504f)).a(parsableByteArray, i10);
        }

        public void g(@Nullable g.b bVar, long j10) {
            if (bVar == null) {
                this.f54504f = this.f54502d;
                return;
            }
            this.f54505g = j10;
            TrackOutput c4 = bVar.c(this.f54499a, this.f54500b);
            this.f54504f = c4;
            Format format = this.f54503e;
            if (format != null) {
                c4.b(format);
            }
        }
    }

    public e(Extractor extractor, int i10, Format format) {
        this.f54490b = extractor;
        this.f54491c = i10;
        this.f54492d = format;
    }

    public static /* synthetic */ g g(int i10, Format format, boolean z10, List list, TrackOutput trackOutput) {
        Extractor fVar;
        String str = format.f19543l;
        if (q.r(str)) {
            if (!"application/x-rawcc".equals(str)) {
                return null;
            }
            fVar = new k5.a(format);
        } else if (q.q(str)) {
            fVar = new i5.e(1);
        } else {
            fVar = new com.google.android.exoplayer2.extractor.mp4.f(z10 ? 4 : 0, null, null, list, trackOutput);
        }
        return new e(fVar, i10, format);
    }

    @Override // x5.g
    public boolean a(d5.d dVar) throws IOException {
        int f10 = this.f54490b.f(dVar, f54489l);
        com.google.android.exoplayer2.util.a.g(f10 != 1);
        return f10 == 0;
    }

    @Override // x5.g
    public void b(@Nullable g.b bVar, long j10, long j11) {
        this.f54495g = bVar;
        this.f54496h = j11;
        if (!this.f54494f) {
            this.f54490b.b(this);
            if (j10 != -9223372036854775807L) {
                this.f54490b.a(0L, j10);
            }
            this.f54494f = true;
            return;
        }
        Extractor extractor = this.f54490b;
        if (j10 == -9223372036854775807L) {
            j10 = 0;
        }
        extractor.a(0L, j10);
        for (int i10 = 0; i10 < this.f54493e.size(); i10++) {
            this.f54493e.valueAt(i10).g(bVar, j11);
        }
    }

    @Override // d5.e
    public TrackOutput c(int i10, int i11) {
        a aVar = this.f54493e.get(i10);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.g(this.f54498j == null);
            aVar = new a(i10, i11, i11 == this.f54491c ? this.f54492d : null);
            aVar.g(this.f54495g, this.f54496h);
            this.f54493e.put(i10, aVar);
        }
        return aVar;
    }

    @Override // x5.g
    @Nullable
    public com.google.android.exoplayer2.extractor.b d() {
        com.google.android.exoplayer2.extractor.i iVar = this.f54497i;
        if (iVar instanceof com.google.android.exoplayer2.extractor.b) {
            return (com.google.android.exoplayer2.extractor.b) iVar;
        }
        return null;
    }

    @Override // x5.g
    @Nullable
    public Format[] e() {
        return this.f54498j;
    }

    @Override // d5.e
    public void l() {
        Format[] formatArr = new Format[this.f54493e.size()];
        for (int i10 = 0; i10 < this.f54493e.size(); i10++) {
            formatArr[i10] = (Format) com.google.android.exoplayer2.util.a.i(this.f54493e.valueAt(i10).f54503e);
        }
        this.f54498j = formatArr;
    }

    @Override // d5.e
    public void r(com.google.android.exoplayer2.extractor.i iVar) {
        this.f54497i = iVar;
    }

    @Override // x5.g
    public void release() {
        this.f54490b.release();
    }
}
