package com.kwad.sdk.pngencrypt.chunk;

import com.android.internal.os.PowerProfile;
import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l extends p {
    private long aMx;
    private long aMy;
    private int aMz;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 9) {
            long g3 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
            this.aMx = g3;
            if (g3 < 0) {
                this.aMx = g3 + PowerProfile.SUBSYSTEM_MODEM;
            }
            long g10 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
            this.aMy = g10;
            if (g10 < 0) {
                this.aMy = g10 + PowerProfile.SUBSYSTEM_MODEM;
            }
            this.aMz = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
            return;
        }
        throw new PngjException("bad chunk length " + ((Object) dVar));
    }
}
