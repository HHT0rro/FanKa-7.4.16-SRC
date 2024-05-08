package com.kwad.components.core.j;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private CopyOnWriteArrayList<b> Mk = new CopyOnWriteArrayList<>();
    private volatile boolean Ml;

    /* renamed from: com.kwad.components.core.j.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0467a {
        private static final a Mm = new a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        private final c Mn;
        public boolean Mo;

        public b(c cVar) {
            this.Mn = cVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void bk();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Mo;
    }

    public static a oG() {
        return C0467a.Mm;
    }

    public final void a(b bVar) {
        if (this.Mk.contains(bVar)) {
            return;
        }
        if (!this.Ml) {
            this.Ml = true;
            bVar.Mo = true;
        }
        this.Mk.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Mo) {
            bVar.Mo = false;
            this.Ml = false;
        }
        this.Mk.remove(bVar);
        if (this.Mk.size() == 0 || this.Ml) {
            return;
        }
        this.Mk.get(0).Mo = true;
        this.Ml = true;
        this.Mk.get(0).Mn.bk();
    }
}
