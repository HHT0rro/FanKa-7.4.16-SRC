package ar.com.hjg.pngj;

import ar.com.hjg.pngj.ChunkReader;
import java.util.Arrays;

/* compiled from: ChunkSeqReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1048a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f1049b;

    /* renamed from: c, reason: collision with root package name */
    public int f1050c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1051d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1052e;

    /* renamed from: f, reason: collision with root package name */
    public int f1053f;

    /* renamed from: g, reason: collision with root package name */
    public long f1054g;

    /* renamed from: h, reason: collision with root package name */
    public DeflatedChunksSet f1055h;

    /* renamed from: i, reason: collision with root package name */
    public ChunkReader f1056i;

    /* renamed from: j, reason: collision with root package name */
    public long f1057j;

    /* compiled from: ChunkSeqReader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends d {
        public a(int i10, String str, boolean z10, long j10, DeflatedChunksSet deflatedChunksSet) {
            super(i10, str, z10, j10, deflatedChunksSet);
        }

        @Override // ar.com.hjg.pngj.d, ar.com.hjg.pngj.ChunkReader
        public void a() {
            super.a();
            b.this.l(this);
        }
    }

    /* compiled from: ChunkSeqReader.java */
    /* renamed from: ar.com.hjg.pngj.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class C0019b extends ChunkReader {
        public C0019b(int i10, String str, long j10, ChunkReader.ChunkReaderMode chunkReaderMode) {
            super(i10, str, j10, chunkReaderMode);
        }

        @Override // ar.com.hjg.pngj.ChunkReader
        public void a() {
            b.this.l(this);
        }

        @Override // ar.com.hjg.pngj.ChunkReader
        public void e(int i10, byte[] bArr, int i11, int i12) {
            throw new PngjExceptionInternal("should never happen");
        }
    }

    public b() {
        this(true);
    }

    @Override // ar.com.hjg.pngj.f
    public int a(byte[] bArr, int i10, int i11) {
        if (this.f1052e) {
            return -1;
        }
        if (i11 == 0) {
            return 0;
        }
        if (i11 >= 0) {
            if (this.f1051d) {
                ChunkReader chunkReader = this.f1056i;
                if (chunkReader != null && !chunkReader.d()) {
                    int b4 = this.f1056i.b(bArr, i10, i11);
                    int i12 = b4 + 0;
                    this.f1054g += b4;
                    return i12;
                }
                int i13 = this.f1050c;
                int i14 = 8 - i13;
                if (i14 <= i11) {
                    i11 = i14;
                }
                System.arraycopy((Object) bArr, i10, (Object) this.f1049b, i13, i11);
                int i15 = this.f1050c + i11;
                this.f1050c = i15;
                int i16 = 0 + i11;
                this.f1054g += i11;
                if (i15 != 8) {
                    return i16;
                }
                this.f1053f++;
                o(o.i(this.f1049b, 0), c.b.j(this.f1049b, 4, 4), this.f1054g - 8);
                this.f1050c = 0;
                return i16;
            }
            int i17 = this.f1050c;
            int i18 = 8 - i17;
            if (i18 <= i11) {
                i11 = i18;
            }
            System.arraycopy((Object) bArr, i10, (Object) this.f1049b, i17, i11);
            int i19 = this.f1050c + i11;
            this.f1050c = i19;
            if (i19 == 8) {
                b(this.f1049b);
                this.f1050c = 0;
                this.f1051d = true;
            }
            int i20 = 0 + i11;
            this.f1054g += i11;
            return i20;
        }
        throw new PngjInputException("Bad len: " + i11);
    }

    public void b(byte[] bArr) {
        if (!Arrays.equals(bArr, o.b())) {
            throw new PngjInputException("Bad PNG signature");
        }
    }

    public void c() {
        DeflatedChunksSet deflatedChunksSet = this.f1055h;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.d();
        }
        this.f1052e = true;
    }

    public ChunkReader d(String str, int i10, long j10, boolean z10) {
        return new C0019b(i10, str, j10, z10 ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER);
    }

    public DeflatedChunksSet e(String str) {
        throw null;
    }

    public String f() {
        return "IEND";
    }

    public String g() {
        return "IHDR";
    }

    public long h() {
        return this.f1054g;
    }

    public DeflatedChunksSet i() {
        return this.f1055h;
    }

    public boolean j() {
        return this.f1052e;
    }

    public boolean k(String str) {
        throw null;
    }

    public void l(ChunkReader chunkReader) {
        String g3;
        if (this.f1053f == 1 && (g3 = g()) != null && !g3.equals(chunkReader.c().f1494c)) {
            throw new PngjInputException("Bad first chunk: " + chunkReader.c().f1494c + " expected: " + g());
        }
        if (chunkReader.c().f1494c.equals(f())) {
            this.f1052e = true;
        }
    }

    public boolean m(int i10, String str) {
        throw null;
    }

    public boolean n(int i10, String str) {
        return false;
    }

    public void o(int i10, String str, long j10) {
        if (str.equals("IDAT")) {
            this.f1057j += i10;
        }
        boolean m10 = m(i10, str);
        boolean n10 = n(i10, str);
        boolean k10 = k(str);
        DeflatedChunksSet deflatedChunksSet = this.f1055h;
        boolean a10 = deflatedChunksSet != null ? deflatedChunksSet.a(str) : false;
        if (k10 && !n10) {
            if (!a10) {
                DeflatedChunksSet deflatedChunksSet2 = this.f1055h;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.i()) {
                    throw new PngjInputException("new IDAT-like chunk when previous was not done");
                }
                this.f1055h = e(str);
            }
            this.f1056i = new a(i10, str, m10, j10, this.f1055h);
            return;
        }
        ChunkReader d10 = d(str, i10, j10, n10);
        this.f1056i = d10;
        if (m10) {
            return;
        }
        d10.f(false);
    }

    public b(boolean z10) {
        this.f1049b = new byte[8];
        this.f1050c = 0;
        this.f1052e = false;
        this.f1053f = 0;
        this.f1054g = 0L;
        this.f1048a = z10;
        this.f1051d = !z10;
    }
}
