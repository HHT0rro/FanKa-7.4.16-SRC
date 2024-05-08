package com.kwad.components.core.page.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends Presenter {
    private int Ow;
    private FeedVideoView Ox;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) Jx();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Ox = feedVideoView;
        feedVideoView.b(com.kwad.sdk.core.response.b.c.dB(eVar.adTemplate));
        this.Ox.a(build, eVar.Kz);
        this.Ox.setVisibility(0);
        final AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(eVar.adTemplate);
        this.Ox.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (com.kwad.sdk.core.response.b.a.aF(dQ)) {
                        if (eVar.Kz != null) {
                            com.kwad.components.core.e.d.a.a(new a.C0461a(a.this.getActivity()).ao(false).ap(false).at(true).aq(eVar.adTemplate).ar(false));
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Ox.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.PU;
                    if (recyclerView == null || recyclerView.getAdapter() == null || eVar.PU.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    eVar.PU.scrollToPosition(1);
                    com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, a.this.Ox.getTouchCoords());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aq(dQ)) {
            this.Ox.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (com.kwad.sdk.core.response.b.a.aF(dQ)) {
                            if (eVar.Kz != null) {
                                com.kwad.components.core.e.d.a.a(new a.C0461a(a.this.getActivity()).ao(false).ap(false).at(true).aq(eVar.adTemplate).ar(false));
                                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.Ox.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = eVar.PU;
                        if (recyclerView == null || recyclerView.getAdapter() == null || eVar.PU.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        eVar.PU.scrollToPosition(1);
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 171, a.this.Ox.getTouchCoords());
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
        this.Ox.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.c.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void pq() {
                RecyclerView recyclerView = eVar.PU;
                if (recyclerView != null) {
                    a.this.Ow = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void pr() {
                RecyclerView recyclerView = eVar.PU;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(a.this.Ow);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Ox.release();
    }
}
