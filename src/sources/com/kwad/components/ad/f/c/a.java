package com.kwad.components.ad.f.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.j.b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends b {
    private com.kwad.components.core.widget.a.b bQ;
    private KsAdVideoPlayConfig dU;
    private final c df;
    private boolean eQ;
    private a.b eY;

    /* renamed from: fa, reason: collision with root package name */
    private OfflineOnAudioConflictListener f36435fa;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;
    private boolean no;
    private boolean np;
    private l nq;

    public a(@NonNull final AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.df = new c() { // from class: com.kwad.components.ad.f.c.a.3
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                com.kwad.components.core.j.a.oG().a(a.this.getCurrentVoiceItem());
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                com.kwad.components.core.j.a.oG().c(a.this.eY);
                a.this.pause();
            }
        };
        this.f36435fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.f.c.a.5
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.bQ = bVar;
        AdInfo dQ = e.dQ(this.mAdTemplate);
        this.mAdInfo = dQ;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.no = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.no = com.kwad.sdk.core.response.b.a.bT(dQ);
        }
        this.dU = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
        l lVar = new l() { // from class: com.kwad.components.ad.f.c.a.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                super.onMediaPlayError(i10, i11);
                com.kwad.components.core.o.a.qi().c(adTemplate, i10, i11);
            }
        };
        this.nq = lVar;
        this.Hs.c(lVar);
        aL();
        this.Hs.a(new c.e() { // from class: com.kwad.components.ad.f.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    if (a.this.eC() && a.this.bQ.dW()) {
                        a.this.Hs.a(com.kwad.sdk.contentalliance.a.a.a.bD(a.this.mAdTemplate));
                        com.kwad.components.core.j.a.oG().a(a.this.getCurrentVoiceItem());
                        a.this.Hs.start();
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }

    private void aL() {
        this.Hs.a(new b.a(this.mAdTemplate).cR(e.dS(this.mAdTemplate)).cS(h.b(e.dR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).bl(this.hasNoCache).b(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate)).Bb(), true, true, this.mDetailVideoView);
        setAudioEnabled(g(this.no));
        if (eC()) {
            this.Hs.prepareAsync();
            com.kwad.components.core.s.a.ah(this.mContext).a(this.f36435fa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eC() {
        if (this.np) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ag.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return ag.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ag.isMobileConnected(this.mContext));
            }
        }
        if (com.kwad.sdk.core.response.b.a.bU(this.mAdInfo) && ag.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.bV(this.mAdInfo) && ag.isWifiConnected(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.f.c.a.4
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.g(aVar.no));
                }
            });
        }
        return this.eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z10) {
        this.Hs.setAudioEnabled(z10);
    }

    public final void aJ() {
        com.kwad.sdk.utils.l.el(this.mAdTemplate);
        if (this.Hs.rs() == null) {
            aL();
        }
        if (eC() && this.bQ.dW()) {
            this.Hs.a(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate));
            com.kwad.components.core.j.a.oG().a(getCurrentVoiceItem());
            this.Hs.start();
        }
        this.bQ.a(this.df);
    }

    public final void aK() {
        com.kwad.sdk.utils.l.ej(this.mAdTemplate);
        this.bQ.b(this.df);
        this.Hs.release();
        com.kwad.components.core.j.a.oG().c(this.eY);
        com.kwad.components.core.s.a.ah(this.mContext).b(this.f36435fa);
    }

    public final void eD() {
        this.np = true;
        if (this.bQ.dW()) {
            com.kwad.sdk.utils.l.ek(this.mAdTemplate);
            this.Hs.a(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate));
            com.kwad.components.core.j.a.oG().a(getCurrentVoiceItem());
            this.Hs.start();
        }
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        com.kwad.components.core.j.a.oG().a(getCurrentVoiceItem());
        setAudioEnabled(g(this.no));
        if (eC()) {
            super.resume();
        }
    }

    public static /* synthetic */ boolean c(a aVar, boolean z10) {
        aVar.eQ = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z10) {
        if (!z10) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.j.a.oG();
            if (!com.kwad.components.core.j.a.b(this.eY)) {
                return false;
            }
        }
        if (!d.gs()) {
            if (com.kwad.components.core.s.a.ah(this.mContext).qX()) {
                return !com.kwad.components.core.s.a.ah(this.mContext).qW();
            }
            return com.kwad.components.core.s.a.ah(this.mContext).aN(false);
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.s.a.ah(this.mContext).aN(true);
        }
        return this.eQ;
    }
}
