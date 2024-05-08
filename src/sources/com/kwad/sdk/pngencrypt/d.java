package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d extends ChunkReader {
    public final DeflatedChunksSet aKB;
    public boolean aKC;
    public boolean aKD;
    public byte[] aKE;
    public int aKF;

    public d(int i10, String str, long j10, DeflatedChunksSet deflatedChunksSet) {
        super(i10, str, j10, ChunkReader.ChunkReaderMode.PROCESS);
        this.aKC = false;
        this.aKD = false;
        this.aKF = -1;
        this.aKB = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void JA() {
        int g3;
        if (!this.aKD || this.aKF < 0 || (g3 = n.g(this.aKE, 0)) == this.aKF) {
            return;
        }
        com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g3 + " expected " + this.aKF));
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i10, byte[] bArr, int i11, int i12) {
        if (this.aKD && i10 < 4) {
            while (i10 < 4 && i12 > 0) {
                this.aKE[i10] = bArr[i11];
                i10++;
                i11++;
                i12--;
            }
        }
        if (i12 > 0) {
            this.aKB.c(bArr, i11, i12);
            if (this.aKC) {
                System.arraycopy((Object) bArr, i11, (Object) Jz().data, this.aJU, i12);
            }
        }
    }

    public final void dD(int i10) {
        this.aKF = i10;
    }
}
