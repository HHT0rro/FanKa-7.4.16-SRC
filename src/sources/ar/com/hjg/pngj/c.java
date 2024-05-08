package ar.com.hjg.pngj;

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.chunks.ChunkLoadBehaviour;
import ar.com.hjg.pngj.chunks.PngChunk;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ChunkSeqReaderPng.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c extends b {

    /* renamed from: k, reason: collision with root package name */
    public k f1060k;

    /* renamed from: l, reason: collision with root package name */
    public k f1061l;

    /* renamed from: m, reason: collision with root package name */
    public e f1062m;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f1065p;

    /* renamed from: n, reason: collision with root package name */
    public int f1063n = -1;

    /* renamed from: o, reason: collision with root package name */
    public c.e f1064o = null;

    /* renamed from: q, reason: collision with root package name */
    public long f1066q = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1067r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1068s = false;

    /* renamed from: t, reason: collision with root package name */
    public Set<String> f1069t = new HashSet();

    /* renamed from: u, reason: collision with root package name */
    public long f1070u = 0;

    /* renamed from: v, reason: collision with root package name */
    public long f1071v = 0;

    /* renamed from: w, reason: collision with root package name */
    public long f1072w = 0;

    /* renamed from: y, reason: collision with root package name */
    public ChunkLoadBehaviour f1074y = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;

    /* renamed from: x, reason: collision with root package name */
    public g f1073x = new c.a();

    /* compiled from: ChunkSeqReaderPng.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1075a;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            f1075a = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1075a[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z10) {
        this.f1065p = z10;
    }

    public void A(long j10) {
        this.f1072w = j10;
    }

    public void B(long j10) {
        this.f1070u = j10;
    }

    public void C(long j10) {
        this.f1071v = j10;
    }

    public final void D(String str) {
        if (str.equals("IHDR")) {
            if (this.f1063n < 0) {
                this.f1063n = 0;
                return;
            }
            throw new PngjInputException("unexpected chunk " + str);
        }
        if (str.equals("PLTE")) {
            int i10 = this.f1063n;
            if (i10 != 0 && i10 != 1) {
                throw new PngjInputException("unexpected chunk " + str);
            }
            this.f1063n = 2;
            return;
        }
        if (str.equals("IDAT")) {
            int i11 = this.f1063n;
            if (i11 >= 0 && i11 <= 4) {
                this.f1063n = 4;
                return;
            }
            throw new PngjInputException("unexpected chunk " + str);
        }
        if (str.equals("IEND")) {
            if (this.f1063n >= 4) {
                this.f1063n = 6;
                return;
            }
            throw new PngjInputException("unexpected chunk " + str);
        }
        int i12 = this.f1063n;
        if (i12 <= 1) {
            this.f1063n = 1;
        } else if (i12 <= 3) {
            this.f1063n = 3;
        } else {
            this.f1063n = 5;
        }
    }

    public void E(k kVar) {
        if (!kVar.equals(this.f1061l)) {
            this.f1061l = kVar;
        }
        if (this.f1062m != null) {
            this.f1062m = new e(this.f1061l);
        }
    }

    @Override // ar.com.hjg.pngj.b, ar.com.hjg.pngj.f
    public int a(byte[] bArr, int i10, int i11) {
        return super.a(bArr, i10, i11);
    }

    @Override // ar.com.hjg.pngj.b
    public void c() {
        if (this.f1063n != 6) {
            this.f1063n = 6;
        }
        super.c();
    }

    @Override // ar.com.hjg.pngj.b
    public DeflatedChunksSet e(String str) {
        j jVar = new j(str, u(), this.f1062m);
        jVar.p(this.f1065p);
        return jVar;
    }

    @Override // ar.com.hjg.pngj.b
    public void l(ChunkReader chunkReader) {
        super.l(chunkReader);
        if (chunkReader.c().f1494c.equals("IHDR")) {
            ar.com.hjg.pngj.chunks.k kVar = new ar.com.hjg.pngj.chunks.k(null);
            kVar.e(chunkReader.c());
            k i10 = kVar.i();
            this.f1060k = i10;
            this.f1061l = i10;
            if (kVar.q()) {
                this.f1062m = new e(this.f1061l);
            }
            this.f1064o = new c.e(this.f1060k);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.f1022a;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && q(chunkReader.c().f1494c)) {
            this.f1066q += chunkReader.c().f1492a;
        }
        if (chunkReader.f1022a == chunkReaderMode2 || this.f1068s) {
            this.f1064o.a(this.f1073x.a(chunkReader.c(), y()), this.f1063n);
        }
        if (j()) {
            z();
        }
    }

    @Override // ar.com.hjg.pngj.b
    public boolean m(int i10, String str) {
        return this.f1067r;
    }

    @Override // ar.com.hjg.pngj.b
    public boolean n(int i10, String str) {
        if (super.n(i10, str)) {
            return true;
        }
        if (c.b.c(str)) {
            return false;
        }
        if (this.f1070u > 0 && i10 + h() > this.f1070u) {
            throw new PngjInputException("Maximum total bytes to read exceeeded: " + this.f1070u + " offset:" + h() + " len=" + i10);
        }
        if (this.f1069t.contains(str)) {
            return true;
        }
        long j10 = this.f1071v;
        if (j10 > 0 && i10 > j10) {
            return true;
        }
        long j11 = this.f1072w;
        if (j11 > 0 && i10 > j11 - this.f1066q) {
            return true;
        }
        int i11 = a.f1075a[this.f1074y.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return true;
            }
        } else if (!c.b.e(str)) {
            return true;
        }
        return false;
    }

    @Override // ar.com.hjg.pngj.b
    public void o(int i10, String str, long j10) {
        D(str);
        super.o(i10, str, j10);
    }

    public void p(String str) {
        this.f1069t.add(str);
    }

    public boolean q(String str) {
        return !c.b.c(str);
    }

    public void r(String str) {
        this.f1069t.remove(str);
    }

    public boolean s() {
        return v() < 4;
    }

    public List<PngChunk> t() {
        return this.f1064o.f();
    }

    public k u() {
        return this.f1061l;
    }

    public int v() {
        return this.f1063n;
    }

    public e w() {
        return this.f1062m;
    }

    public j x() {
        DeflatedChunksSet i10 = i();
        if (i10 instanceof j) {
            return (j) i10;
        }
        return null;
    }

    public k y() {
        return this.f1060k;
    }

    public void z() {
    }
}
