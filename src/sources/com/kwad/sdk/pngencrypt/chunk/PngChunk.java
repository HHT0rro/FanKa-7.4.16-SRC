package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class PngChunk {
    public final com.kwad.sdk.pngencrypt.k aLj;
    public final boolean aMj;
    public final boolean aMk;
    public final boolean aMl;
    public d aMm;
    private boolean aMn = false;
    public int aMo = -1;
    public final String ahi;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i10, boolean z10) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i10 < 4 : this == BEFORE_PLTE_AND_IDAT ? i10 < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z10 ? i10 < 4 : i10 < 4 && i10 > 2 : this == AFTER_IDAT && i10 > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.ahi = str;
        this.aLj = kVar;
        this.aMj = b.gj(str);
        this.aMk = b.gk(str);
        this.aMl = b.gl(str);
    }

    private long Km() {
        d dVar = this.aMm;
        if (dVar != null) {
            return dVar.Km();
        }
        return -1L;
    }

    private int Ko() {
        d dVar = this.aMm;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    public abstract void a(d dVar);

    public final void b(d dVar) {
        this.aMm = dVar;
    }

    public final void dO(int i10) {
        this.aMo = i10;
    }

    public String toString() {
        return "chunk id= " + this.ahi + " (len=" + Ko() + " offset=" + Km() + ")";
    }
}
