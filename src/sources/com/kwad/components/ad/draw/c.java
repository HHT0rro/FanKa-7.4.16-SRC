package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import com.kwad.sdk.n.l;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {

    @Nullable
    private KsDrawAd.AdInteractionListener bN;
    private b bY;

    @NonNull
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    private final com.kwad.sdk.core.h.b bT = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.draw.c.1
        @Override // com.kwad.sdk.core.h.b
        public final void ah() {
            c.this.bZ.h(c.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void ai() {
            c.this.bZ.i(c.this);
        }
    };

    /* renamed from: ca, reason: collision with root package name */
    private final KsDrawAd.AdInteractionListener f36415ca = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.2
        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.bN != null) {
                c.this.bN.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.bN != null) {
                c.this.bN.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }
    };

    public c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.br(e.dQ(adTemplate)).getUrl(), this.mAdTemplate);
        com.kwad.components.ad.h.b.eI().a(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        if (context == null || !k.zd().ys()) {
            return null;
        }
        try {
            context = l.wrapContextIfNeed(context);
            com.kwad.sdk.j.a.ak("draw", "show");
            if (this.bY == null) {
                b bVar = new b(context);
                this.bY = bVar;
                bVar.setPageExitListener(this.bT);
                this.bY.setAdInteractionListener(this.bN);
                this.bY.a(this.mAdTemplate);
            } else {
                com.kwad.sdk.core.e.c.i("KSDrawAdControl", "mDrawVideoView is not null");
            }
            com.kwad.sdk.j.a.al("draw", "show");
        } catch (Throwable th) {
            if (k.zd().yp()) {
                RuntimeException runtimeException = new RuntimeException("context:" + context.getClass().getName() + "--classloader:" + ((Object) context.getClass().getClassLoader()));
                runtimeException.addSuppressed(th);
                com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
            } else {
                throw th;
            }
        }
        return this.bY;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(e.dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(e.dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(e.dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bN = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j10, long j11) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j10;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j11);
    }
}
