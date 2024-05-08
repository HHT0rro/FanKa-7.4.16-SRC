package com.kwad.sdk.pngencrypt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class p {
    public int aKT;
    public int aKW;
    public int aKX;
    public int aKY;
    public int aKZ;
    public final e aKn;
    public final boolean aLL;
    public int aLM;
    public int aLN;
    public int aLO;
    public int aLP;
    public int aLQ;
    public int aLR;
    public int aLS;
    public final k aLj;
    public byte[] buf;

    public p(k kVar, e eVar) {
        this.aLj = kVar;
        this.aKn = eVar;
        this.aLL = eVar != null;
    }

    public final void h(byte[] bArr, int i10) {
        this.buf = bArr;
        this.aLS = i10;
    }

    public final void update(int i10) {
        this.aLM = i10;
        if (this.aLL) {
            this.aKT = this.aKn.JU();
            e eVar = this.aKn;
            this.aKX = eVar.aKX;
            this.aKW = eVar.aKW;
            this.aKZ = eVar.aKZ;
            this.aKY = eVar.aKY;
            this.aLN = eVar.JT();
            this.aLO = this.aKn.JS();
            this.aLP = this.aKn.JV();
            int JW = this.aKn.JW();
            this.aLQ = JW;
            this.aLR = ((this.aLj.aLt * JW) + 7) / 8;
            return;
        }
        this.aKT = 1;
        this.aKW = 1;
        this.aKX = 1;
        this.aKY = 0;
        this.aKZ = 0;
        this.aLO = i10;
        this.aLN = i10;
        k kVar = this.aLj;
        this.aLP = kVar.aKU;
        this.aLQ = kVar.aKV;
        this.aLR = kVar.aLv;
    }
}
