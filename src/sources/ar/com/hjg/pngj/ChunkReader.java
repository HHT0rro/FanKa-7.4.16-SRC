package ar.com.hjg.pngj;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ChunkReader {

    /* renamed from: a, reason: collision with root package name */
    public final ChunkReaderMode f1022a;

    /* renamed from: b, reason: collision with root package name */
    public final c.d f1023b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1024c;

    /* renamed from: d, reason: collision with root package name */
    public int f1025d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f1026e = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i10, String str, long j10, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode != null && str.length() == 4 && i10 >= 0) {
            this.f1022a = chunkReaderMode;
            c.d dVar = new c.d(i10, str, chunkReaderMode == ChunkReaderMode.BUFFER);
            this.f1023b = dVar;
            dVar.f(j10);
            this.f1024c = chunkReaderMode != ChunkReaderMode.SKIP;
            return;
        }
        throw new PngjExceptionInternal("Bad chunk paramenters: " + ((Object) chunkReaderMode));
    }

    public abstract void a();

    public final int b(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        if (i11 == 0) {
            return 0;
        }
        if (i11 >= 0) {
            if (this.f1025d == 0 && this.f1026e == 0 && this.f1024c) {
                c.d dVar = this.f1023b;
                dVar.g(dVar.f1493b, 0, 4);
            }
            c.d dVar2 = this.f1023b;
            int i13 = dVar2.f1492a - this.f1025d;
            if (i13 > i11) {
                i13 = i11;
            }
            if (i13 > 0 || this.f1026e == 0) {
                if (this.f1024c && this.f1022a != ChunkReaderMode.BUFFER && i13 > 0) {
                    dVar2.g(bArr, i10, i13);
                }
                ChunkReaderMode chunkReaderMode = this.f1022a;
                if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                    byte[] bArr2 = this.f1023b.f1495d;
                    if (bArr2 != bArr && i13 > 0) {
                        System.arraycopy((Object) bArr, i10, (Object) bArr2, this.f1025d, i13);
                    }
                } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                    e(this.f1025d, bArr, i10, i13);
                }
                this.f1025d += i13;
                i10 += i13;
                i11 -= i13;
            }
            int i14 = this.f1025d;
            c.d dVar3 = this.f1023b;
            if (i14 == dVar3.f1492a) {
                int i15 = this.f1026e;
                int i16 = 4 - i15;
                if (i16 <= i11) {
                    i11 = i16;
                }
                if (i11 > 0) {
                    byte[] bArr3 = dVar3.f1497f;
                    if (bArr != bArr3) {
                        System.arraycopy((Object) bArr, i10, (Object) bArr3, i15, i11);
                    }
                    int i17 = this.f1026e + i11;
                    this.f1026e = i17;
                    if (i17 == 4) {
                        if (this.f1024c) {
                            if (this.f1022a == ChunkReaderMode.BUFFER) {
                                c.d dVar4 = this.f1023b;
                                dVar4.g(dVar4.f1495d, 0, dVar4.f1492a);
                            }
                            this.f1023b.b();
                        }
                        a();
                    }
                }
                i12 = i11;
            }
            return i13 + i12;
        }
        throw new PngjException("negative length??");
    }

    public c.d c() {
        return this.f1023b;
    }

    public final boolean d() {
        return this.f1026e == 4;
    }

    public abstract void e(int i10, byte[] bArr, int i11, int i12);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        c.d dVar = this.f1023b;
        if (dVar == null) {
            if (chunkReader.f1023b != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.f1023b)) {
            return false;
        }
        return true;
    }

    public void f(boolean z10) {
        if (this.f1025d != 0 && z10 && !this.f1024c) {
            throw new PngjException("too late!");
        }
        this.f1024c = z10;
    }

    public int hashCode() {
        c.d dVar = this.f1023b;
        return 31 + (dVar == null ? 0 : dVar.hashCode());
    }

    public String toString() {
        return this.f1023b.toString();
    }
}
