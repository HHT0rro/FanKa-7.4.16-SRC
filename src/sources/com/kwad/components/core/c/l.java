package com.kwad.components.core.c;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ay;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class l implements c {
    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.request.model.a aVar) {
        a mu = a.mu();
        if (mu == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> a10 = mu.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.s(aVar.getPosId()).mB());
        if (com.kwad.sdk.core.config.d.Cy()) {
            k(a10);
        }
        if (a10 == null || a10.size() <= 0) {
            return null;
        }
        Collections.sort(a10);
        return h.j(a10.subList(0, Math.min(a10.size(), adNum)));
    }

    private static void k(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            h next = iterator2.next();
            if (g.mF().a(next)) {
                com.kwad.sdk.core.e.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.mM());
                iterator2.remove();
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final void c(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.FH().submit(new ay() { // from class: com.kwad.components.core.c.l.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                AdResultData d10 = l.d(aVar);
                if (d10 != null && !d10.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, d10, true);
                } else {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    n.a(aVar2, new j(aVar2));
                }
            }
        });
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }
}
