package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    private final List<f> Lu;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final g Lv = new g(0);
    }

    public /* synthetic */ g(byte b4) {
        this();
    }

    public static g or() {
        return a.Lv;
    }

    public final void a(f fVar) {
        this.Lu.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.Lu.remove(fVar);
        }
    }

    public final void os() {
        Iterator<f> iterator2 = this.Lu.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().show();
        }
    }

    public final void ot() {
        Iterator<f> iterator2 = this.Lu.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().dismiss();
        }
    }

    private g() {
        this.Lu = new CopyOnWriteArrayList();
    }
}
