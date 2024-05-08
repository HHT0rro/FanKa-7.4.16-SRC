package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    private ImageView dE;
    private TextView dF;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: na, reason: collision with root package name */
    private ViewGroup f36426na;

    /* renamed from: nb, reason: collision with root package name */
    private TextView f36427nb;

    /* renamed from: nc, reason: collision with root package name */
    private KsAppDownloadListener f36428nc = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.f.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.f36427nb.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.f36427nb.setText(com.kwad.sdk.core.response.b.a.bY(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.f36427nb.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.f36427nb.setText(com.kwad.sdk.core.response.b.a.ac(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
        }
    };

    private void G(int i10) {
        com.kwad.components.ad.f.c.a aVar;
        a.C0461a b4 = new a.C0461a(this.f36426na.getContext()).aq(this.mAdTemplate).an(i10).b(this.mApkDownloadHelper);
        com.kwad.components.ad.f.a.b bVar = this.mN;
        com.kwad.components.core.e.d.a.a(b4.v((bVar == null || (aVar = bVar.mO) == null) ? 0L : aVar.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.f.b.f.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(f.this.mAdTemplate, 2, f.this.mN.mI.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex() {
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 12);
        this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.f36427nb.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.f36428nc);
        }
        this.f36426na.setOnClickListener(this);
        this.f36426na.setVisibility(0);
    }

    private void notifyAdClick() {
        this.mN.mw.l(this.f36426na);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.mN.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.mApkDownloadHelper = this.mN.mApkDownloadHelper;
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.f.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                try {
                    f.this.ex();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    com.kwad.components.core.d.a.reportSdkCaughtException(th);
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
        this.f36426na.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f36426na) {
            G(2);
            notifyAdClick();
        } else if (view == this.f36427nb) {
            G(1);
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36426na = (ViewGroup) findViewById(R.id.ksad_video_complete_app_container);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_name);
        this.f36427nb = (TextView) findViewById(R.id.ksad_app_download);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.f36428nc);
        }
    }
}
