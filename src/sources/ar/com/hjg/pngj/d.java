package ar.com.hjg.pngj;

import ar.com.hjg.pngj.ChunkReader;

/* compiled from: DeflatedChunkReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d extends ChunkReader {

    /* renamed from: f, reason: collision with root package name */
    public final DeflatedChunksSet f1153f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1154g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1155h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f1156i;

    /* renamed from: j, reason: collision with root package name */
    public int f1157j;

    public d(int i10, String str, boolean z10, long j10, DeflatedChunksSet deflatedChunksSet) {
        super(i10, str, j10, ChunkReader.ChunkReaderMode.PROCESS);
        this.f1154g = false;
        this.f1155h = false;
        this.f1157j = -1;
        this.f1153f = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f1155h = true;
            this.f1156i = new byte[4];
        }
        deflatedChunksSet.c(this);
    }

    @Override // ar.com.hjg.pngj.ChunkReader
    public void a() {
        int i10;
        if (!this.f1155h || !c().f1494c.equals("fdAT") || this.f1157j < 0 || (i10 = o.i(this.f1156i, 0)) == this.f1157j) {
            return;
        }
        throw new PngjInputException("bad chunk sequence for fDAT chunk " + i10 + " expected " + this.f1157j);
    }

    @Override // ar.com.hjg.pngj.ChunkReader
    public void e(int i10, byte[] bArr, int i11, int i12) {
        if (this.f1155h && i10 < 4) {
            while (i10 < 4 && i12 > 0) {
                this.f1156i[i10] = bArr[i11];
                i10++;
                i11++;
                i12--;
            }
        }
        if (i12 > 0) {
            this.f1153f.m(bArr, i11, i12);
            if (this.f1154g) {
                System.arraycopy((Object) bArr, i11, (Object) c().f1495d, this.f1025d, i12);
            }
        }
    }

    public void g(int i10) {
        this.f1157j = i10;
    }
}
