package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements c {
    private HashMap<String, n> aCE = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aCE.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eJ(String str) {
        if (this.aCE.containsKey(str)) {
            return this.aCE.get(str);
        }
        return null;
    }
}
