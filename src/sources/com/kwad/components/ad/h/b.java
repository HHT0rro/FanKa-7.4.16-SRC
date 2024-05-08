package com.kwad.components.ad.h;

import com.kwad.components.core.proxy.h;
import com.kwad.components.core.proxy.i;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements com.kwad.components.core.internal.api.b {
    private static final Object nF = new Object();
    private static volatile b nG;
    private Set<Integer> nH = new HashSet();
    private List<c> nI = new ArrayList();
    private Map<com.kwad.components.core.internal.api.a, Object> nJ = new WeakHashMap();
    private Map<com.kwad.components.core.proxy.c, Object> nK = new WeakHashMap();
    private i nL = new i() { // from class: com.kwad.components.ad.h.b.1
        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(com.kwad.components.core.proxy.c cVar) {
            super.d(cVar);
            b.this.nK.put(cVar, b.nF);
        }

        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(com.kwad.components.core.proxy.c cVar) {
            super.c(cVar);
            b.this.nK.remove(cVar);
            if (b.this.nK.isEmpty()) {
                b.this.eJ();
            }
        }
    };

    private b() {
        h.qg().a(this.nL);
        this.nH.add(2);
        this.nH.add(3);
        this.nH.add(13);
        this.nH.add(6);
    }

    private boolean A(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return this.nH.contains(Integer.valueOf(adTemplate.adStyle));
    }

    private void e(com.kwad.components.core.internal.api.a aVar) {
        this.nJ.put(aVar, nF);
        if (g(aVar)) {
            c cVar = new c(aVar);
            cVar.eM();
            this.nI.add(cVar);
        }
    }

    public static b eI() {
        if (nG == null) {
            synchronized (b.class) {
                if (nG == null) {
                    nG = new b();
                }
            }
        }
        return nG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eJ() {
        boolean eK = eK();
        com.kwad.sdk.core.e.c.d("KsAdGlobalWatcher", "checkCurrentPage noSDKPage: " + eK);
        if (eK) {
            Iterator<c> iterator2 = this.nI.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().eO();
            }
        }
    }

    private void f(com.kwad.components.core.internal.api.a aVar) {
        this.nJ.remove(aVar);
        Iterator<c> iterator2 = this.nI.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().d(aVar);
        }
        if (A(aVar.getAdTemplate())) {
            eJ();
        }
    }

    private static boolean g(com.kwad.components.core.internal.api.a aVar) {
        if (aVar.ag()) {
            return com.kwad.sdk.core.response.b.a.cU(com.kwad.sdk.core.response.b.e.dQ(aVar.getAdTemplate()));
        }
        return false;
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void c(com.kwad.components.core.internal.api.a aVar) {
        e(aVar);
    }

    @Override // com.kwad.components.core.internal.api.b
    public final void d(com.kwad.components.core.internal.api.a aVar) {
        f(aVar);
        b(aVar);
    }

    public final synchronized boolean eK() {
        Iterator<com.kwad.components.core.internal.api.a> iterator2 = this.nJ.h().iterator2();
        while (iterator2.hasNext()) {
            if (A(iterator2.next().getAdTemplate())) {
                return false;
            }
        }
        return this.nK.isEmpty();
    }

    public final void a(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void b(com.kwad.components.core.internal.api.a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.nI.remove(cVar);
        }
    }
}
