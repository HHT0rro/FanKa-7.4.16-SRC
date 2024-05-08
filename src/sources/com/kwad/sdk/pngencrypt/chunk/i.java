package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i extends p {
    private int aKU;
    private int aKV;
    private int aMp;
    private int aMq;
    private int aMr;
    private int aMs;
    private int aMt;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Kt();
        }
    }

    private int JV() {
        return this.aKU;
    }

    private int JW() {
        return this.aKV;
    }

    private int Kp() {
        return this.aMp;
    }

    private int Kq() {
        return this.aMq;
    }

    private int Kr() {
        return this.aMt;
    }

    private void Kt() {
        dP(this.aLj.aKV);
        dQ(this.aLj.aKU);
        dR(this.aLj.aLn);
        com.kwad.sdk.pngencrypt.k kVar = this.aLj;
        int i10 = kVar.aLp ? 4 : 0;
        if (kVar.aLr) {
            i10++;
        }
        if (!kVar.aLq) {
            i10 += 2;
        }
        dS(i10);
        dT(0);
        dU(0);
        dV(0);
    }

    private void Kv() {
        if (this.aKV > 0 && this.aKU > 0 && this.aMr == 0 && this.aMs == 0) {
            int i10 = this.aMp;
            if (i10 != 1 && i10 != 2 && i10 != 4 && i10 != 8 && i10 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
            int i11 = this.aMt;
            if (i11 >= 0 && i11 <= 1) {
                int i12 = this.aMq;
                if (i12 != 0) {
                    if (i12 != 6 && i12 != 2) {
                        if (i12 == 3) {
                            if (i10 == 16) {
                                throw new PngjException("bad IHDR: bitdepth invalid");
                            }
                            return;
                        } else if (i12 != 4) {
                            throw new PngjException("bad IHDR: invalid colormodel");
                        }
                    }
                    if (i10 != 8 && i10 != 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                }
                return;
            }
            throw new PngjException("bad IHDR: interlace invalid");
        }
        throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
    }

    private void dP(int i10) {
        this.aKV = i10;
    }

    private void dQ(int i10) {
        this.aKU = i10;
    }

    private void dR(int i10) {
        this.aMp = i10;
    }

    private void dS(int i10) {
        this.aMq = i10;
    }

    private void dT(int i10) {
        this.aMr = 0;
    }

    private void dU(int i10) {
        this.aMs = 0;
    }

    private void dV(int i10) {
        this.aMt = 0;
    }

    public final boolean Ks() {
        return Kr() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Ku() {
        Kv();
        return new com.kwad.sdk.pngencrypt.k(JW(), JV(), Kp(), (Kq() & 4) != 0, Kq() == 0 || Kq() == 4, (Kq() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 13) {
            ByteArrayInputStream Kl = dVar.Kl();
            this.aKV = com.kwad.sdk.pngencrypt.n.f(Kl);
            this.aKU = com.kwad.sdk.pngencrypt.n.f(Kl);
            this.aMp = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMq = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMr = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMs = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMt = com.kwad.sdk.pngencrypt.n.e(Kl);
            return;
        }
        throw new PngjException("Bad IDHR len " + dVar.len);
    }
}
