package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j extends com.kwad.components.ad.k.b {

    @Nullable
    private com.kwad.components.ad.reward.c.d qg;
    private WeakReference<g> qh;

    public j(g gVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.qh = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.ad.k.b
    public final void fm() {
        WeakReference<g> weakReference = this.qh;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.k.b
    public final void fn() {
        WeakReference<g> weakReference = this.qh;
        boolean z10 = (weakReference != null ? weakReference.get() : null) != null;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, z10, "end_card", B(adTemplate));
    }

    @Override // com.kwad.components.ad.k.b
    public final void fo() {
        WeakReference<g> weakReference = this.qh;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card", B(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    public final void a(@Nullable com.kwad.components.ad.reward.c.d dVar) {
        this.qg = dVar;
    }

    @Override // com.kwad.components.ad.k.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.i.b(this.cL.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar) {
                if (j.this.qg != null) {
                    j.this.qg.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.h(new com.kwad.components.core.webview.jshandler.n() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(com.kwad.components.core.webview.jshandler.h hVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    hVar.a(com.kwad.components.ad.reward.c.a.gL().gM());
                }
            }
        }));
        WeakReference<g> weakReference = this.qh;
        aVar.b(new p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.cO));
    }
}
