package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class w {
    private final e aMP;
    private final boolean aMQ;

    public w(e eVar) {
        this.aMP = eVar;
        if (eVar instanceof f) {
            this.aMQ = false;
        } else {
            this.aMQ = true;
        }
    }

    private List<? extends t> gm(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aMP.am("tEXt", str));
        arrayList.addAll(this.aMP.am("zTXt", str));
        arrayList.addAll(this.aMP.am("iTXt", str));
        return arrayList;
    }

    public final String gn(String str) {
        List<? extends t> gm = gm(str);
        if (gm.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<? extends t> iterator2 = gm.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().Kx());
            sb2.append("\n");
        }
        return sb2.toString().trim();
    }
}
