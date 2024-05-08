package com.jd.ad.sdk.jad_xi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_vi implements jad_mz {
    public final Set<com.jd.ad.sdk.jad_bm.jad_er<?>> jad_an = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_an() {
        Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator2();
        while (iterator2.hasNext()) {
            ((com.jd.ad.sdk.jad_bm.jad_er) iterator2.next()).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_cp() {
        Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator2();
        while (iterator2.hasNext()) {
            ((com.jd.ad.sdk.jad_bm.jad_er) iterator2.next()).jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_dq() {
        Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator2();
        while (iterator2.hasNext()) {
            ((com.jd.ad.sdk.jad_bm.jad_er) iterator2.next()).jad_dq();
        }
    }
}
