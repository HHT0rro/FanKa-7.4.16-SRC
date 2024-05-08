package com.kwad.components.ad.reward;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends com.kwad.components.ad.k.b {
    private List<AdTemplate> oA;
    private boolean oB;
    private List<com.kwad.components.core.e.d.c> oC;
    private w.b oD;

    public d(List<AdTemplate> list, @Nullable JSONObject jSONObject, w.b bVar) {
        super(jSONObject, null);
        this.oB = false;
        this.oC = new ArrayList();
        this.oA = list;
        this.oD = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> iterator2 = this.oA.iterator2();
        while (iterator2.hasNext()) {
            this.oC.add(new com.kwad.components.core.e.d.c(iterator2.next()));
        }
    }

    @Override // com.kwad.components.ad.k.b
    public final String B(AdTemplate adTemplate) {
        List<AdTemplate> list = this.oA;
        if (list != null && list.size() >= 2) {
            return com.kwad.sdk.core.response.b.b.co(this.oA.get(1));
        }
        return super.B(adTemplate);
    }

    @Override // com.kwad.components.ad.k.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, int i10) {
        super.a(frameLayout, adBaseFrameLayout, this.oA, this.oC);
    }

    @Override // com.kwad.components.ad.k.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.oA);
    }

    @Override // com.kwad.components.ad.k.b
    public final boolean bx() {
        if (this.oB) {
            return this.HL;
        }
        return super.bx();
    }

    @Override // com.kwad.components.ad.k.b
    public final void fj() {
        super.fj();
        this.cL.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    @Override // com.kwad.components.ad.k.b
    public final boolean fk() {
        return false;
    }

    public final void fl() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.ss();
        }
    }

    @Override // com.kwad.components.ad.k.b
    public final void fm() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.k.b
    public final void fn() {
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, true, "middle_play_end_card", B(adTemplate));
    }

    @Override // com.kwad.components.ad.k.b
    public final void fo() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card", B(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.k.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public final void setShowLandingPage(boolean z10) {
        this.oB = z10;
    }

    @Override // com.kwad.components.ad.k.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.oA;
        w wVar = new w(new ArrayList(list.subList(1, list.size() - 1)));
        wVar.a(this.oD);
        aVar.a(wVar);
    }
}
