package com.kwad.components.core.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ay;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {
    private static volatile b SY;

    private b() {
    }

    @NonNull
    public static b qY() {
        if (SY == null) {
            synchronized (b.class) {
                if (SY == null) {
                    SY = new b();
                }
            }
        }
        return SY;
    }

    public final boolean a(final AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        boolean z10 = false;
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.e.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (bVar != null) {
            bVar.b(adTemplate, null, null, null);
        }
        boolean b4 = com.kwad.sdk.core.adlog.c.b(adTemplate, jSONObject, bVar);
        try {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null && sceneImpl.adStyle == 10000) {
                z10 = true;
            }
            int i10 = adTemplate.adStyle;
            if (i10 == 3 || i10 == 2 || i10 == 13 || z10) {
                com.kwad.sdk.core.response.b.e.dQ(adTemplate);
                if (b4 && com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                    com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.s.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.components.core.c.a mu = com.kwad.components.core.c.a.mu();
                if (mu != null) {
                    mu.r(com.kwad.sdk.core.response.b.e.ea(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.mF().ak(adTemplate);
        return b4;
    }
}
