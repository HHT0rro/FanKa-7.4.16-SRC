package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private List<b> aDH = new CopyOnWriteArrayList();

    public final void a(b bVar) {
        this.aDH.add(bVar);
    }

    public final void b(b bVar) {
        this.aDH.remove(bVar);
    }

    public final void j(View view, boolean z10) {
        Iterator<b> it = this.aDH.iterator();
        while (it.hasNext()) {
            it.next().i(view, z10);
        }
    }
}
