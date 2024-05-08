package com.kwad.components.ad.reward.m;

import android.content.Context;
import androidx.annotation.MainThread;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends com.kwad.components.ad.j.b implements g.a {
    private boolean kI;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean no;
    private l nq;
    private g qo;
    private String xL;
    private AtomicBoolean xM;
    private boolean xN;
    private final List<h.a> xO;
    private final List<Object> xP;
    private OfflineOnAudioConflictListener xQ;

    public d(g gVar, DetailVideoView detailVideoView) {
        super(gVar.mAdTemplate, detailVideoView);
        this.xM = new AtomicBoolean(false);
        this.xN = false;
        this.kI = false;
        this.xO = new ArrayList();
        this.xP = new ArrayList();
        this.xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                d.a(d.this, true);
                if (d.this.Hs != null) {
                    d.this.Hs.setAudioEnabled(false);
                }
                synchronized (d.this.xO) {
                    Iterator iterator2 = d.this.xO.iterator2();
                    while (iterator2.hasNext()) {
                        ((h.a) iterator2.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (d.this.xO) {
                    Iterator iterator2 = d.this.xO.iterator2();
                    while (iterator2.hasNext()) {
                        ((h.a) iterator2.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.qo = gVar;
        this.mContext = gVar.mContext;
        this.mVideoPlayConfig = gVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.xL = getVideoUrl();
    }

    private void aL() {
        if (jK()) {
            return;
        }
        this.Hs.a(new b.a(this.mAdTemplate).cR(this.xL).cS(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dR(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate)).Bb(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Hs.prepareAsync();
    }

    private String getVideoUrl() {
        return jK() ? "" : j.f(this.mContext, this.mAdTemplate);
    }

    private boolean jK() {
        return com.kwad.sdk.core.response.b.a.cL(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
    }

    private void stop() {
        pause();
        this.kI = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fU() {
        this.xN = false;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        if (this.kI) {
            return;
        }
        resume();
        if (this.no || (com.kwad.components.ad.reward.a.b.gs() && this.xN)) {
            com.kwad.components.core.s.a.ah(this.mContext).aN(com.kwad.components.ad.reward.a.b.gs());
            if (com.kwad.components.ad.reward.a.b.gs() && this.xN) {
                this.xN = false;
                this.no = true;
                setAudioEnabled(true, false);
            } else {
                if (this.qo.oH || !com.kwad.components.core.s.a.ah(this.mContext).qW()) {
                    return;
                }
                this.no = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fW() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fX() {
        com.kwad.components.core.video.b bVar;
        this.xN = false;
        if (!this.xM.get() || (bVar = this.Hs) == null) {
            return;
        }
        bVar.d(this.nq);
        this.Hs.release();
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final long getPlayDuration() {
        if (this.xM.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    public final void jI() {
        if (this.xM.get()) {
            return;
        }
        this.xM.set(true);
        aL();
        l lVar = new l() { // from class: com.kwad.components.ad.reward.m.d.2
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                super.onMediaPlayError(i10, i11);
                com.kwad.components.core.o.a.qi().c(d.this.mAdTemplate, i10, i11);
            }
        };
        this.nq = lVar;
        this.Hs.c(lVar);
        this.Hs.a(new c.e() { // from class: com.kwad.components.ad.reward.m.d.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.c.b.DD();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        d.this.Hs.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        this.Hs.start();
        com.kwad.components.core.s.a.ah(this.mContext).a(this.xQ);
    }

    public final void jJ() {
        Iterator<Object> iterator2 = this.xP.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next();
        }
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void pause() {
        if (!this.xM.get() || this.Hs == null || jK()) {
            return;
        }
        super.pause();
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.ah(this.mContext).b(this.xQ);
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        this.kI = false;
        if (!this.xM.get() || this.Hs == null || jK() || g.b(this.qo)) {
            return;
        }
        super.resume();
    }

    @Override // com.kwad.components.ad.j.a
    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.no = z10;
        if (!this.xM.get() || this.Hs == null) {
            return;
        }
        if (z10 && z11) {
            com.kwad.components.core.s.a.ah(this.mContext).aN(true);
        }
        this.Hs.setAudioEnabled(z10);
    }

    @Override // com.kwad.components.ad.j.a
    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (!this.xM.get() || (bVar = this.Hs) == null) {
            return;
        }
        bVar.onPlayStateChanged(9);
        stop();
    }

    public static /* synthetic */ boolean a(d dVar, boolean z10) {
        dVar.xN = true;
        return true;
    }

    public final void b(h.a aVar) {
        this.xO.remove(aVar);
    }

    public final void a(h.a aVar) {
        this.xO.add(aVar);
    }
}
