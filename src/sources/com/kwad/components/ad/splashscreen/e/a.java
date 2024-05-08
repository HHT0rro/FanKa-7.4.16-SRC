package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.j.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends b implements c {
    private boolean Fm;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean no;
    private String xL;
    private final List<h.a> xO;
    private OfflineOnAudioConflictListener xQ;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.xO = new ArrayList();
        this.xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.e.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (a.this.xO) {
                    Iterator iterator2 = a.this.xO.iterator2();
                    while (iterator2.hasNext()) {
                        ((h.a) iterator2.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.xO) {
                    Iterator iterator2 = a.this.xO.iterator2();
                    while (iterator2.hasNext()) {
                        ((h.a) iterator2.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String aZ = com.kwad.sdk.core.response.b.a.aZ(e.dQ(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(aZ);
        if (bV != null && bV.exists()) {
            this.xL = bV.getAbsolutePath();
        }
        this.Hs.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.e.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new ay() { // from class: com.kwad.components.ad.splashscreen.e.a.2.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        boolean a10 = bq.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared" + a10);
                        if (a10) {
                            a.this.Hs.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.s.a.ah(this.mContext).a(this.xQ);
    }

    private void aL() {
        this.Hs.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).cR(this.xL).cS(com.kwad.sdk.core.response.b.h.b(e.dR(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate)).Bb(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Hs.prepareAsync();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        resume();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        pause();
    }

    public final void ae(boolean z10) {
        this.Fm = true;
    }

    public final long getCurrentPosition() {
        return this.Hs.getCurrentPosition();
    }

    public final void lO() {
        if (this.Hs.rs() == null) {
            aL();
        }
        this.Hs.start();
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.ah(this.mContext).b(this.xQ);
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        super.resume();
        if (this.no && this.Fm) {
            com.kwad.components.core.s.a.ah(this.mContext).aN(false);
            if (com.kwad.components.core.s.a.ah(this.mContext).qW()) {
                this.no = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.j.a
    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.no = z10;
        if (z10 && z11) {
            com.kwad.components.core.s.a.ah(this.mContext).aN(true);
        }
        this.Hs.setAudioEnabled(z10);
    }

    public final void a(h.a aVar) {
        this.xO.add(aVar);
    }

    public final void b(h.a aVar) {
        this.xO.remove(aVar);
    }
}
