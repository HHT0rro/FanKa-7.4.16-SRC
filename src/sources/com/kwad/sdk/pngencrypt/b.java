package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b implements f, Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] aJY;
    private final int aJZ;
    private byte[] aKa;
    private int aKb;
    public boolean aKc;
    public boolean aKd;
    private int aKe;
    private long aKf;
    private DeflatedChunksSet aKg;
    private ChunkReader aKh;
    private long aKi;
    private ErrorBehaviour aKj;
    public boolean closed;

    public b() {
        this(n.Kd());
    }

    private static String JE() {
        return "IHDR";
    }

    private static String JF() {
        return "IEND";
    }

    private ChunkReader a(String str, int i10, long j10, boolean z10) {
        return new ChunkReader(i10, str, j10, z10 ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void JA() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i11, byte[] bArr, int i12, int i13) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    private static void h(byte[] bArr) {
        if (Arrays.equals(bArr, n.Kd())) {
            return;
        }
        com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    public boolean JB() {
        return true;
    }

    public final long JC() {
        return this.aKf;
    }

    public final DeflatedChunksSet JD() {
        return this.aKg;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i10, int i11) {
        if (this.closed) {
            return -1;
        }
        if (i11 == 0) {
            return 0;
        }
        if (i11 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen. Bad length: " + i11));
        }
        if (this.aKc) {
            ChunkReader chunkReader = this.aKh;
            if (chunkReader != null && !chunkReader.isDone()) {
                int b4 = this.aKh.b(bArr, i10, i11);
                if (b4 < 0) {
                    return -1;
                }
                int i12 = b4 + 0;
                this.aKf += b4;
                return i12;
            }
            int i13 = this.aKb;
            int i14 = 8 - i13;
            if (i14 <= i11) {
                i11 = i14;
            }
            System.arraycopy((Object) bArr, i10, (Object) this.aKa, i13, i11);
            int i15 = this.aKb + i11;
            this.aKb = i15;
            int i16 = i11 + 0;
            this.aKf += i11;
            if (i15 != 8) {
                return i16;
            }
            this.aKe++;
            c(n.g(this.aKa, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aKa, 4), this.aKf - 8);
            this.aKb = 0;
            return i16;
        }
        int i17 = this.aJZ;
        int i18 = this.aKb;
        int i19 = i17 - i18;
        if (i19 <= i11) {
            i11 = i19;
        }
        System.arraycopy((Object) bArr, i10, (Object) this.aKa, i18, i11);
        int i20 = this.aKb + i11;
        this.aKb = i20;
        if (i20 == this.aJZ) {
            h(this.aKa);
            this.aKb = 0;
            this.aKc = true;
        }
        int i21 = i11 + 0;
        this.aKf += i11;
        return i21;
    }

    public void c(int i10, String str, long j10) {
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.aLZ.matcher(str).matches()) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i10 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk len: " + i10));
        }
        if (str.equals("IDAT")) {
            this.aKi += i10;
        }
        boolean JB = JB();
        boolean t2 = t(i10, str);
        boolean ge = ge(str);
        DeflatedChunksSet deflatedChunksSet = this.aKg;
        boolean gh = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aKg.gh(str);
        if (ge && !t2) {
            if (!gh) {
                DeflatedChunksSet deflatedChunksSet2 = this.aKg;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.aKg = gd(str);
            }
            this.aKh = new d(i10, str, JB, j10, this.aKg) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void JA() {
                    super.JA();
                    b.this.a(this);
                }
            };
        } else {
            this.aKh = a(str, i10, j10, t2);
        }
        ChunkReader chunkReader = this.aKh;
        if (chunkReader == null || JB) {
            return;
        }
        chunkReader.bG(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aKg;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    public abstract DeflatedChunksSet gd(String str);

    public boolean ge(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aKd;
    }

    public boolean t(int i10, String str) {
        return false;
    }

    private b(byte[] bArr) {
        this.aKa = new byte[8];
        this.aKb = 0;
        this.aKc = false;
        this.aKd = false;
        this.closed = false;
        this.aKe = 0;
        this.aKf = 0L;
        this.aKj = ErrorBehaviour.STRICT;
        this.aJY = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aJZ = length;
        this.aKc = length <= 0;
    }

    public void a(ChunkReader chunkReader) {
        if (this.aKe == 1 && !JE().equals(chunkReader.Jz().ahi)) {
            String str = "Bad first chunk: " + chunkReader.Jz().ahi + " expected: " + JE();
            if (this.aKj.f36651c < ErrorBehaviour.SUPER_LENIENT.f36651c) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", str);
            }
        }
        JF();
        if (chunkReader.Jz().ahi.equals(JF())) {
            this.aKd = true;
            close();
        }
    }
}
