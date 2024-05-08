package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.PngjInputException;
import java.io.ByteArrayInputStream;

/* compiled from: PngChunkIHDR.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public int f1115i;

    /* renamed from: j, reason: collision with root package name */
    public int f1116j;

    /* renamed from: k, reason: collision with root package name */
    public int f1117k;

    /* renamed from: l, reason: collision with root package name */
    public int f1118l;

    /* renamed from: m, reason: collision with root package name */
    public int f1119m;

    /* renamed from: n, reason: collision with root package name */
    public int f1120n;

    /* renamed from: o, reason: collision with root package name */
    public int f1121o;

    public k(ar.com.hjg.pngj.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            k(kVar);
        }
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == 13) {
            ByteArrayInputStream d10 = dVar.d();
            this.f1115i = ar.com.hjg.pngj.o.h(d10);
            this.f1116j = ar.com.hjg.pngj.o.h(d10);
            this.f1117k = ar.com.hjg.pngj.o.e(d10);
            this.f1118l = ar.com.hjg.pngj.o.e(d10);
            this.f1119m = ar.com.hjg.pngj.o.e(d10);
            this.f1120n = ar.com.hjg.pngj.o.e(d10);
            this.f1121o = ar.com.hjg.pngj.o.e(d10);
            return;
        }
        throw new PngjException("Bad IDHR len " + dVar.f1492a);
    }

    public void h() {
        if (this.f1115i >= 1 && this.f1116j >= 1 && this.f1119m == 0 && this.f1120n == 0) {
            int i10 = this.f1117k;
            if (i10 != 1 && i10 != 2 && i10 != 4 && i10 != 8 && i10 != 16) {
                throw new PngjInputException("bad IHDR: bitdepth invalid");
            }
            int i11 = this.f1121o;
            if (i11 >= 0 && i11 <= 1) {
                int i12 = this.f1118l;
                if (i12 != 0) {
                    if (i12 != 6 && i12 != 2) {
                        if (i12 == 3) {
                            if (i10 == 16) {
                                throw new PngjInputException("bad IHDR: bitdepth invalid");
                            }
                            return;
                        } else if (i12 != 4) {
                            throw new PngjInputException("bad IHDR: invalid colormodel");
                        }
                    }
                    if (i10 != 8 && i10 != 16) {
                        throw new PngjInputException("bad IHDR: bitdepth invalid");
                    }
                    return;
                }
                return;
            }
            throw new PngjInputException("bad IHDR: interlace invalid");
        }
        throw new PngjInputException("bad IHDR: col/row/compmethod/filmethod invalid");
    }

    public ar.com.hjg.pngj.k i() {
        h();
        return new ar.com.hjg.pngj.k(n(), p(), l(), (m() & 4) != 0, m() == 0 || m() == 4, (m() & 1) != 0);
    }

    public c.d j() {
        c.d dVar = new c.d(13, c.b.f1487a, true);
        ar.com.hjg.pngj.o.m(this.f1115i, dVar.f1495d, 0);
        ar.com.hjg.pngj.o.m(this.f1116j, dVar.f1495d, 4);
        byte[] bArr = dVar.f1495d;
        bArr[8] = (byte) this.f1117k;
        bArr[9] = (byte) this.f1118l;
        bArr[10] = (byte) this.f1119m;
        bArr[11] = (byte) this.f1120n;
        bArr[12] = (byte) this.f1121o;
        return dVar;
    }

    public void k(ar.com.hjg.pngj.k kVar) {
        t(this.f1080e.f1180a);
        x(this.f1080e.f1181b);
        r(this.f1080e.f1182c);
        ar.com.hjg.pngj.k kVar2 = this.f1080e;
        int i10 = kVar2.f1184e ? 4 : 0;
        if (kVar2.f1186g) {
            i10++;
        }
        if (!kVar2.f1185f) {
            i10 += 2;
        }
        s(i10);
        u(0);
        v(0);
        w(0);
    }

    public int l() {
        return this.f1117k;
    }

    public int m() {
        return this.f1118l;
    }

    public int n() {
        return this.f1115i;
    }

    public int o() {
        return this.f1121o;
    }

    public int p() {
        return this.f1116j;
    }

    public boolean q() {
        return o() == 1;
    }

    public void r(int i10) {
        this.f1117k = i10;
    }

    public void s(int i10) {
        this.f1118l = i10;
    }

    public void t(int i10) {
        this.f1115i = i10;
    }

    public void u(int i10) {
        this.f1119m = i10;
    }

    public void v(int i10) {
        this.f1120n = i10;
    }

    public void w(int i10) {
        this.f1121o = i10;
    }

    public void x(int i10) {
        this.f1116j = i10;
    }
}
