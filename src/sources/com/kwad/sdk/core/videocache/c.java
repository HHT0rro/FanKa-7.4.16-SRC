package com.kwad.sdk.core.videocache;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    public final File aBG;
    public final com.kwad.sdk.core.videocache.a.c aBH;
    public final com.kwad.sdk.core.videocache.a.a aBI;
    public final com.kwad.sdk.core.videocache.d.c aBJ;
    public final com.kwad.sdk.core.videocache.b.b aBK;
    public final int aBL;
    public final int aBM;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i10, int i11) {
        this.aBG = file;
        this.aBH = cVar;
        this.aBI = aVar;
        this.aBJ = cVar2;
        this.aBK = bVar;
        this.aBL = i10;
        this.aBM = i11;
    }

    public final File ex(String str) {
        return new File(this.aBG, this.aBH.generate(str));
    }
}
