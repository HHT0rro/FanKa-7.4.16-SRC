package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h {
    private static volatile h avN;
    private List<a> avM = new CopyOnWriteArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(f fVar, int i10);
    }

    private h() {
    }

    public static h DN() {
        if (avN == null) {
            synchronized (h.class) {
                if (avN == null) {
                    avN = new h();
                }
            }
        }
        return avN;
    }

    public final void a(a aVar) {
        this.avM.add(aVar);
    }

    public final void b(f fVar, int i10) {
        Iterator<a> iterator2 = this.avM.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(fVar, i10);
        }
    }
}
