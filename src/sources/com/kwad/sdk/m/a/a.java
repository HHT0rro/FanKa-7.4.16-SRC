package com.kwad.sdk.m.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private final List<b> aNf = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.aNf.add(bVar);
        }
    }

    public final boolean onBackPressed() {
        Iterator<b> iterator2 = this.aNf.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.aNf.remove(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i10) {
        if (bVar != null) {
            this.aNf.add(i10, bVar);
        }
    }
}
