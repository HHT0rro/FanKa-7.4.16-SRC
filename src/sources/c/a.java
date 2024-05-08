package c;

import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.l;
import ar.com.hjg.pngj.chunks.m;
import ar.com.hjg.pngj.chunks.n;
import ar.com.hjg.pngj.chunks.o;
import ar.com.hjg.pngj.chunks.p;
import ar.com.hjg.pngj.chunks.q;
import ar.com.hjg.pngj.chunks.r;
import ar.com.hjg.pngj.chunks.s;
import ar.com.hjg.pngj.chunks.t;
import ar.com.hjg.pngj.chunks.v;

/* compiled from: ChunkFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a implements ar.com.hjg.pngj.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1486a;

    public a() {
        this(true);
    }

    @Override // ar.com.hjg.pngj.g
    public final PngChunk a(d dVar, ar.com.hjg.pngj.k kVar) {
        PngChunk c4 = c(dVar.f1494c, kVar);
        if (c4 == null) {
            c4 = b(dVar.f1494c, kVar);
        }
        if (c4 == null) {
            c4 = d(dVar.f1494c, kVar);
        }
        c4.g(dVar);
        if (this.f1486a && dVar.f1495d != null) {
            c4.e(dVar);
        }
        return c4;
    }

    public PngChunk b(String str, ar.com.hjg.pngj.k kVar) {
        if (str.equals("oFFs")) {
            return new l(kVar);
        }
        if (str.equals("sTER")) {
            return new r(kVar);
        }
        return null;
    }

    public final PngChunk c(String str, ar.com.hjg.pngj.k kVar) {
        if (str.equals("IDAT")) {
            return new ar.com.hjg.pngj.chunks.i(kVar);
        }
        if (str.equals("IHDR")) {
            return new ar.com.hjg.pngj.chunks.k(kVar);
        }
        if (str.equals("PLTE")) {
            return new n(kVar);
        }
        if (str.equals("IEND")) {
            return new ar.com.hjg.pngj.chunks.j(kVar);
        }
        if (str.equals("tEXt")) {
            return new i(kVar);
        }
        if (str.equals("iTXt")) {
            return new f(kVar);
        }
        if (str.equals("zTXt")) {
            return new j(kVar);
        }
        if (str.equals("bKGD")) {
            return new ar.com.hjg.pngj.chunks.b(kVar);
        }
        if (str.equals("gAMA")) {
            return new ar.com.hjg.pngj.chunks.f(kVar);
        }
        if (str.equals("pHYs")) {
            return new m(kVar);
        }
        if (str.equals("iCCP")) {
            return new ar.com.hjg.pngj.chunks.h(kVar);
        }
        if (str.equals("tIME")) {
            return new s(kVar);
        }
        if (str.equals("tRNS")) {
            return new t(kVar);
        }
        if (str.equals("cHRM")) {
            return new ar.com.hjg.pngj.chunks.c(kVar);
        }
        if (str.equals("sBIT")) {
            return new o(kVar);
        }
        if (str.equals("sRGB")) {
            return new q(kVar);
        }
        if (str.equals("hIST")) {
            return new ar.com.hjg.pngj.chunks.g(kVar);
        }
        if (str.equals("sPLT")) {
            return new p(kVar);
        }
        if (str.equals("fdAT")) {
            return new ar.com.hjg.pngj.chunks.e(kVar);
        }
        if (str.equals("acTL")) {
            return new ar.com.hjg.pngj.chunks.a(kVar);
        }
        if (str.equals("fcTL")) {
            return new ar.com.hjg.pngj.chunks.d(kVar);
        }
        return null;
    }

    public final PngChunk d(String str, ar.com.hjg.pngj.k kVar) {
        return new v(str, kVar);
    }

    public a(boolean z10) {
        this.f1486a = z10;
    }
}
