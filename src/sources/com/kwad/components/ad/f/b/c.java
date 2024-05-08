package com.kwad.components.ad.f.b;

import android.view.View;
import com.kwad.components.core.video.l;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.f.a.a {
    private List<Integer> cB;
    private volatile boolean cC = false;

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cB = com.kwad.sdk.core.response.b.a.bm(com.kwad.sdk.core.response.b.e.dQ(this.mN.mAdTemplate));
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.c.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.adlog.c.bL(c.this.mN.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                c.this.c(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                c.this.cC = false;
                if (!c.this.mN.mAdTemplate.mPvReported) {
                    c.this.mN.mw.er();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                View view = (View) c.this.mN.mI.getParent();
                if (view != null) {
                    bVar.v(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.s.b.qY().a(c.this.mN.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.bK(c.this.mN.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                if (c.this.cC) {
                    return;
                }
                c.this.cC = true;
                com.kwad.components.core.o.a.qi().b(c.this.mN.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j10) {
        int ceil = (int) Math.ceil(((float) j10) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cB) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mN.mAdTemplate, ceil, (JSONObject) null);
                this.cB.remove(num);
                return;
            }
        }
    }
}
