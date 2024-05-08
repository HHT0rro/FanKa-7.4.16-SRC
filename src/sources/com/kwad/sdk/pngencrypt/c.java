package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends b {
    public k aKl;
    public k aKm;
    public e aKn;
    public int aKo = -1;
    public com.kwad.sdk.pngencrypt.chunk.e aKp = null;
    private long aKr = 0;
    private boolean aKs = true;
    private boolean aKt = false;
    private Set<String> aKu = new HashSet();
    private long aKv = 0;
    private long aKw = 0;
    private long aKx = 0;
    private ChunkLoadBehaviour aKz = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    public final boolean aKq = false;
    private g aKy = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] aKA;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aKA = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aKA[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z10) {
    }

    private int JG() {
        return this.aKo;
    }

    private k JL() {
        return this.aKm;
    }

    private void gf(String str) {
        if (str.equals("IHDR")) {
            if (this.aKo < 0) {
                this.aKo = 0;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("PLTE")) {
            int i10 = this.aKo;
            if (i10 != 0 && i10 != 1) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk here " + str));
                return;
            }
            this.aKo = 2;
            return;
        }
        if (str.equals("IDAT")) {
            int i11 = this.aKo;
            if (i11 >= 0 && i11 <= 4) {
                this.aKo = 4;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("IEND")) {
            if (this.aKo >= 4) {
                this.aKo = 6;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        int i12 = this.aKo;
        if (i12 <= 1) {
            this.aKo = 1;
        } else if (i12 <= 3) {
            this.aKo = 3;
        } else {
            this.aKo = 5;
        }
    }

    private static boolean gg(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.gj(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean JB() {
        return this.aKs;
    }

    public final boolean JH() {
        return JG() < 4;
    }

    public final j JI() {
        DeflatedChunksSet JD = JD();
        if (JD instanceof j) {
            return (j) JD;
        }
        return null;
    }

    public final k JJ() {
        return this.aKl;
    }

    public final e JK() {
        return this.aKn;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.Jz().ahi.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.Jz());
            k Ku = iVar.Ku();
            this.aKl = Ku;
            this.aKm = Ku;
            if (iVar.Ks()) {
                this.aKn = new e(this.aKm);
            }
            this.aKp = new com.kwad.sdk.pngencrypt.chunk.e(this.aKl);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aJS;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && gg(chunkReader.Jz().ahi)) {
            this.aKr += chunkReader.Jz().len;
        }
        if (chunkReader.aJS == chunkReaderMode2 || this.aKt) {
            try {
                this.aKp.a(this.aKy.a(chunkReader.Jz(), JJ()), this.aKo);
            } catch (PngjException e2) {
                throw e2;
            }
        }
    }

    public final void aA(long j10) {
        this.aKv = j10;
    }

    public final void aB(long j10) {
        this.aKw = j10;
    }

    public final void aC(long j10) {
        this.aKx = j10;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i10, int i11) {
        return super.b(bArr, i10, i11);
    }

    public final void bH(boolean z10) {
        this.aKs = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i10, String str, long j10) {
        gf(str);
        super.c(i10, str, j10);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aKo != 6) {
            this.aKo = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet gd(String str) {
        return new j(str, this.aKq, JL(), this.aKn);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean ge(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean t(int i10, String str) {
        if (super.t(i10, str)) {
            return true;
        }
        if (this.aKv > 0 && i10 + JC() > this.aKv) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.aKv + " offset:" + JC() + " len=" + i10));
        }
        if (this.aKu.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.gj(str)) {
            return false;
        }
        long j10 = this.aKw;
        if (j10 > 0 && i10 > j10) {
            return true;
        }
        long j11 = this.aKx;
        if (j11 > 0 && i10 > j11 - this.aKr) {
            return true;
        }
        int i11 = AnonymousClass1.aKA[this.aKz.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.gl(str)) {
            return true;
        }
        return false;
    }
}
