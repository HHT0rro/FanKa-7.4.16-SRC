package com.jd.ad.sdk.jad_xi;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_an implements jad_ly {
    public final Set<jad_mz> jad_an = Collections.newSetFromMap(new WeakHashMap());
    public boolean jad_bo;
    public boolean jad_cp;

    public void jad_an() {
        this.jad_cp = true;
        Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator2();
        while (iterator2.hasNext()) {
            ((jad_mz) iterator2.next()).jad_dq();
        }
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_ly
    public void jad_an(@NonNull jad_mz jad_mzVar) {
        this.jad_an.add(jad_mzVar);
        if (this.jad_cp) {
            jad_mzVar.jad_dq();
        } else if (this.jad_bo) {
            jad_mzVar.jad_cp();
        } else {
            jad_mzVar.jad_an();
        }
    }

    public void jad_bo() {
        this.jad_bo = true;
        Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator2();
        while (iterator2.hasNext()) {
            ((jad_mz) iterator2.next()).jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_ly
    public void jad_bo(@NonNull jad_mz jad_mzVar) {
        this.jad_an.remove(jad_mzVar);
    }

    public void jad_cp() {
        this.jad_bo = false;
        Iterator iterator2 = ((ArrayList) com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an)).iterator2();
        while (iterator2.hasNext()) {
            ((jad_mz) iterator2.next()).jad_an();
        }
    }
}