package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k extends b {
    private final AdLiveCallerContextListener sm = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.qo);
        }
    };
    private final com.kwad.components.core.l.a.a sn = new com.kwad.components.core.l.a.b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.c cVar) {
            super.c(cVar);
            if (k.this.qo.oJ.jM()) {
                k.this.qo.oJ.jN().onResume();
                if (com.kwad.components.core.s.a.ah(k.this.qo.mContext).qW()) {
                    k.this.qo.d(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.c cVar) {
            super.d(cVar);
            if (k.this.qo.oJ.jM()) {
                k.this.qo.oJ.jN().onPause();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.qo.oJ.jM()) {
            this.qo.oJ.jN().registerAdLiveCallerContextListener(this.sm);
            this.qo.Ms.add(this.sn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.qo.oJ.jM()) {
            this.qo.oJ.jN().unRegisterAdLiveCallerContextListener(this.sm);
            this.qo.Ms.remove(this.sn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
