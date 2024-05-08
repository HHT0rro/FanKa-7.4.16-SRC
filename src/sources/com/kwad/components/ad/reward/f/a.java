package com.kwad.components.ad.reward.f;

import androidx.annotation.NonNull;
import com.kwad.components.core.video.g;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.j.a<g> {
    private IAdLivePlayModule eV;
    private List<g> rB;
    private long rC;
    private AdLivePlayStateListener rD;

    public a(@NonNull AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule) {
        super(adTemplate);
        this.rB = new CopyOnWriteArrayList();
        this.rC = 30000L;
        this.rD = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z10) {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    @Override // com.kwad.sdk.g.a
                    public final /* bridge */ /* synthetic */ void accept(g gVar) {
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    private static void c(g gVar) {
                        gVar.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    private static void c(g gVar) {
                        gVar.onLivePlayEnd();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    private static void c(g gVar) {
                        gVar.onMediaPlayPaused();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j10) {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: c, reason: merged with bridge method [inline-methods] */
                    public void accept(g gVar) {
                        gVar.onMediaPlayProgress(a.this.rC, j10);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    private static void c(g gVar) {
                        gVar.onLivePlayResume();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    private static void c(g gVar) {
                        gVar.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.a(new com.kwad.sdk.g.a<g>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    private static void c(g gVar) {
                        gVar.onMediaPrepared();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(g gVar) {
                        c(gVar);
                    }
                });
            }
        };
        this.eV = iAdLivePlayModule;
        if (e.dK(adTemplate) == 2) {
            this.rC = com.kwad.sdk.core.response.b.a.ag(e.dQ(adTemplate));
        }
        this.eV.registerAdLivePlayStateListener(this.rD);
    }

    private void gU() {
        try {
            this.rB.clear();
            this.eV.unRegisterAdLivePlayStateListener(this.rD);
            this.eV.onDestroy();
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.eV.getCurrentShowShopItemInfo();
    }

    @Override // com.kwad.components.ad.j.a
    public final long getPlayDuration() {
        return this.eV.getPlayDuration();
    }

    public final void onPause() {
        this.eV.onPause();
    }

    public final void onResume() {
        this.eV.onResume();
    }

    @Override // com.kwad.components.ad.j.a
    public final void pause() {
        this.eV.pause();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.eV.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    @Override // com.kwad.components.ad.j.a
    public final void release() {
        super.release();
        gU();
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.eV.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.ad.j.a
    public final void resume() {
        this.eV.resume();
    }

    @Override // com.kwad.components.ad.j.a
    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.eV.setAudioEnabled(z10, z11);
    }

    @Override // com.kwad.components.ad.j.a
    public final void skipToEnd() {
        this.eV.skipToEnd();
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.eV.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.j.a
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(g gVar) {
        if (gVar != null) {
            this.rB.remove(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.g.a<g> aVar) {
        if (aVar != null) {
            Iterator<g> iterator2 = this.rB.iterator2();
            while (iterator2.hasNext()) {
                aVar.accept(iterator2.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.j.a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(g gVar) {
        if (gVar != null) {
            this.rB.add(gVar);
        }
    }
}
