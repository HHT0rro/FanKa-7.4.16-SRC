package c;

import ar.com.hjg.pngj.PngjBadCrcException;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.PngjOutputException;
import ar.com.hjg.pngj.o;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;

/* compiled from: ChunkRaw.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f1492a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f1493b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1494c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f1495d;

    /* renamed from: e, reason: collision with root package name */
    public long f1496e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f1497f;

    /* renamed from: g, reason: collision with root package name */
    public CRC32 f1498g;

    public d(int i10, String str, boolean z10) {
        this.f1495d = null;
        this.f1496e = 0L;
        this.f1497f = new byte[4];
        this.f1492a = i10;
        this.f1494c = str;
        this.f1493b = b.h(str);
        for (int i11 = 0; i11 < 4; i11++) {
            byte[] bArr = this.f1493b;
            if (bArr[i11] < 65 || bArr[i11] > 122 || (bArr[i11] > 90 && bArr[i11] < 97)) {
                throw new PngjException("Bad id chunk: must be ascii letters " + str);
            }
        }
        if (z10) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f1495d;
        if (bArr == null || bArr.length < this.f1492a) {
            this.f1495d = new byte[this.f1492a];
        }
    }

    public void b() {
        int value = (int) this.f1498g.getValue();
        int i10 = o.i(this.f1497f, 0);
        if (value == i10) {
            return;
        }
        throw new PngjBadCrcException("chunk: " + toString() + " expected=" + i10 + " read=" + value);
    }

    public final void c() {
        CRC32 crc32 = new CRC32();
        this.f1498g = crc32;
        crc32.update(this.f1493b, 0, 4);
        int i10 = this.f1492a;
        if (i10 > 0) {
            this.f1498g.update(this.f1495d, 0, i10);
        }
        o.m((int) this.f1498g.getValue(), this.f1497f, 0);
    }

    public ByteArrayInputStream d() {
        return new ByteArrayInputStream(this.f1495d);
    }

    public long e() {
        return this.f1496e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f1494c;
        if (str == null) {
            if (dVar.f1494c != null) {
                return false;
            }
        } else if (!str.equals(dVar.f1494c)) {
            return false;
        }
        return this.f1496e == dVar.f1496e;
    }

    public void f(long j10) {
        this.f1496e = j10;
    }

    public void g(byte[] bArr, int i10, int i11) {
        if (this.f1498g == null) {
            this.f1498g = new CRC32();
        }
        this.f1498g.update(bArr, i10, i11);
    }

    public void h(OutputStream outputStream) {
        j(outputStream);
        int i10 = this.f1492a;
        if (i10 > 0) {
            byte[] bArr = this.f1495d;
            if (bArr != null) {
                o.k(outputStream, bArr, 0, i10);
            } else {
                throw new PngjOutputException("cannot write chunk, raw chunk data is null [" + this.f1494c + "]");
            }
        }
        c();
        i(outputStream);
    }

    public int hashCode() {
        String str = this.f1494c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f1496e;
        return ((hashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public void i(OutputStream outputStream) {
        o.k(outputStream, this.f1497f, 0, 4);
    }

    public void j(OutputStream outputStream) {
        if (this.f1493b.length == 4) {
            o.l(outputStream, this.f1492a);
            o.j(outputStream, this.f1493b);
        } else {
            throw new PngjOutputException("bad chunkid [" + this.f1494c + "]");
        }
    }

    public String toString() {
        return "chunkid=" + b.i(this.f1493b) + " len=" + this.f1492a;
    }

    public d(int i10, byte[] bArr, boolean z10) {
        this(i10, b.i(bArr), z10);
    }
}
