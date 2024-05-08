package com.kwad.components.ad.draw.b.a;

import android.view.View;
import com.kwad.components.core.s.b;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.widget.j;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.draw.a.a {
    private List<Integer> cB;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean bR = false;
    private volatile boolean cC = false;
    private j cD = new j() { // from class: com.kwad.components.ad.draw.b.a.a.1
        @Override // com.kwad.sdk.widget.j
        public final void ao() {
            l.el(a.this.mAdTemplate);
        }
    };
    private k mVideoPlayStateListener = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.draw.b.a.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            c.bL(a.this.mAdTemplate);
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
            a.this.bR = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            a.this.c(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            a.this.cC = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.bO.bN != null) {
                a.this.bO.bN.onAdShow();
            }
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
                a.this.bR = false;
            }
            b.qY().a(a.this.mAdTemplate, null, null);
            c.bK(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (a.this.bR) {
                a.this.bR = false;
                if (a.this.bO.bN != null) {
                    try {
                        a.this.bO.bN.onVideoPlayResume();
                        return;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        return;
                    }
                }
                return;
            }
            if (a.this.cC) {
                return;
            }
            a.this.cC = true;
            com.kwad.components.core.o.a.qi().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
        }
    };

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo dQ = e.dQ(adTemplate);
        this.mAdInfo = dQ;
        this.cB = com.kwad.sdk.core.response.b.a.bm(dQ);
        this.bO.bP.b(this.mVideoPlayStateListener);
        a(this.cD);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bO.bP.a(this.mVideoPlayStateListener);
        a((j) null);
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
                c.a(this.mAdTemplate, ceil, (JSONObject) null);
                this.cB.remove(num);
                return;
            }
        }
    }

    private void a(j jVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(jVar);
        }
    }
}
