package com.kwad.components.ad.splashscreen.c;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends e {
    private List<Integer> cB;
    private final com.kwad.components.core.video.k mVideoPlayStateListener = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.c.d.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.ld();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            d.this.c(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.lc();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j10) {
        int ceil = (int) Math.ceil(((float) j10) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> iterator2 = this.cB.iterator2();
        while (iterator2.hasNext()) {
            if (ceil >= iterator2.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.Dg.mAdTemplate, ceil, (JSONObject) null);
                iterator2.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lc() {
        com.kwad.sdk.core.adlog.c.bK(this.Dg.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        com.kwad.sdk.core.adlog.c.bL(this.Dg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cB = com.kwad.sdk.core.response.b.a.bm(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate));
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.a aVar = this.Dg.Cq;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }
}
