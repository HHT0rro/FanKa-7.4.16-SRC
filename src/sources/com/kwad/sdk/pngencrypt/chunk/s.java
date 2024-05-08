package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s extends p {
    private int aMJ;
    private int aMK;
    private int aML;
    private int aMM;
    private int[] aMN;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.aMN = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.aLj;
        if (kVar.aLq) {
            this.aMJ = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (kVar.aLr) {
            int length = dVar.data.length;
            this.aMN = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.aMN[i10] = dVar.data[i10] & 255;
            }
            return;
        }
        this.aMK = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        this.aML = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
        this.aMM = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
    }
}
