package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g {
    private static volatile g Ji;
    private ConcurrentHashMap<String, WeakReference<Object>> Jh = new ConcurrentHashMap<>();

    private static String al(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.dJ(adTemplate) + "-" + com.kwad.sdk.core.response.b.e.ea(adTemplate);
    }

    private static String b(h hVar) {
        return hVar.mG() + "-" + hVar.mM();
    }

    @NonNull
    public static g mF() {
        if (Ji == null) {
            synchronized (g.class) {
                if (Ji == null) {
                    Ji = new g();
                }
            }
        }
        return Ji;
    }

    public final boolean a(h hVar) {
        String b4 = b(hVar);
        com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains key: " + b4);
        boolean z10 = false;
        if (!this.Jh.containsKey(b4)) {
            return false;
        }
        WeakReference<Object> weakReference = this.Jh.get(b4);
        if (weakReference != null && weakReference.get() != null) {
            z10 = true;
        }
        if (z10) {
            com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z10;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Jh.put(al(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void ak(AdTemplate adTemplate) {
        this.Jh.remove(al(adTemplate));
    }
}
