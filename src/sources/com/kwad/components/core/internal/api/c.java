package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {

    @NonNull
    private List<b> Mh = new CopyOnWriteArrayList();
    private boolean Mi = false;
    private boolean Mj = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Mh.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Mh.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdEnter: " + ((Object) aVar) + ", hadNotifiedEnter: " + this.Mj);
        if (this.Mj) {
            return;
        }
        Iterator<b> iterator2 = this.Mh.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().c(aVar);
        }
        this.Mj = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.e.c.d("KsAdListenerHolder", "notifyAdExit: " + ((Object) aVar) + ", hadNotifiedExit: " + this.Mi);
        if (this.Mi) {
            return;
        }
        Iterator<b> iterator2 = this.Mh.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().d(aVar);
        }
        this.Mi = true;
    }
}
