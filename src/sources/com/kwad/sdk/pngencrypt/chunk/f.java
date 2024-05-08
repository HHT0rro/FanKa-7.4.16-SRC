package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends e {
    private final List<PngChunk> aMi;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + Kn().size() + " queue: " + this.aMi.size();
    }
}
