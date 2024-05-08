package com.kwad.components.core.s;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private Set<b> Ta;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static c Tb = new c(0);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void onPageClose();
    }

    public /* synthetic */ c(byte b4) {
        this();
    }

    public static c qZ() {
        return a.Tb;
    }

    public final void a(b bVar) {
        this.Ta.add(bVar);
    }

    public final void b(b bVar) {
        this.Ta.remove(bVar);
    }

    public final void ra() {
        if (this.Ta.size() == 0) {
            return;
        }
        Iterator<b> iterator2 = this.Ta.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onPageClose();
        }
    }

    private c() {
        this.Ta = new HashSet();
    }
}
