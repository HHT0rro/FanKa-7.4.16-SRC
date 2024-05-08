package com.kwad.sdk.pngencrypt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aJS;
    private final com.kwad.sdk.pngencrypt.chunk.d aJT;
    private boolean aJW;
    public int aJU = 0;
    private int aJV = 0;
    public ErrorBehaviour aJX = ErrorBehaviour.STRICT;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i10, String str, long j10, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i10 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk paramenters: " + ((Object) chunkReaderMode)));
        }
        this.aJS = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i10, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.aJT = dVar;
        dVar.aD(j10);
        this.aJW = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public abstract void JA();

    public final com.kwad.sdk.pngencrypt.chunk.d Jz() {
        return this.aJT;
    }

    public abstract void a(int i10, byte[] bArr, int i11, int i12);

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        if (i11 == 0) {
            return 0;
        }
        if (i11 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("negative length??"));
        }
        if (this.aJU == 0 && this.aJV == 0 && this.aJW) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aJT;
            dVar.f(dVar.aMa, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aJT;
        int i13 = dVar2.len - this.aJU;
        if (i13 > i11) {
            i13 = i11;
        }
        if (i13 > 0 || this.aJV == 0) {
            if (this.aJW && this.aJS != ChunkReaderMode.BUFFER && i13 > 0) {
                dVar2.f(bArr, i10, i13);
            }
            ChunkReaderMode chunkReaderMode = this.aJS;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aJT.data;
                if (bArr2 != bArr && i13 > 0) {
                    System.arraycopy((Object) bArr, i10, (Object) bArr2, this.aJU, i13);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aJU, bArr, i10, i13);
            }
            this.aJU += i13;
            i10 += i13;
            i11 -= i13;
        }
        int i14 = this.aJU;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.aJT;
        if (i14 == dVar3.len) {
            int i15 = this.aJV;
            int i16 = 4 - i15;
            if (i16 <= i11) {
                i11 = i16;
            }
            if (i11 > 0) {
                byte[] bArr3 = dVar3.aMc;
                if (bArr != bArr3) {
                    System.arraycopy((Object) bArr, i10, (Object) bArr3, i15, i11);
                }
                int i17 = this.aJV + i11;
                this.aJV = i17;
                if (i17 == 4) {
                    if (this.aJW) {
                        if (this.aJS == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.aJT;
                            dVar4.f(dVar4.data, 0, dVar4.len);
                        }
                        this.aJT.bI(this.aJX == ErrorBehaviour.STRICT);
                    }
                    JA();
                }
            }
            i12 = i11;
        }
        if (i13 > 0 || i12 > 0) {
            return i13 + i12;
        }
        return -1;
    }

    public final void bG(boolean z10) {
        this.aJW = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aJT;
        if (dVar == null) {
            if (chunkReader.aJT != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.aJT)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aJT;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aJV == 4;
    }

    public String toString() {
        return this.aJT.toString();
    }
}
