package com.kwad.components.ad.draw.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.draw.a.a implements View.OnClickListener {
    private ViewGroup co;
    private TextView cp;
    private TextView cq;
    private TextView cr;
    private DrawDownloadProgressBar cs;
    private ValueAnimator ct;
    private int cu;
    private int cv;
    private int cw;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            if (j11 >= c.this.cw * 1000) {
                c.this.bO.ch.ap();
            } else if (j11 >= c.this.cv * 1000) {
                c.this.an();
            } else if (j11 >= c.this.cu * 1000) {
                c.this.al();
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
        }
    };
    private KsAppDownloadListener cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.b.c.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.bY(c.this.mAdTemplate));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.bY(c.this.mAdTemplate), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            super.onPaused(i10);
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.Fg());
            c.this.cs.e(com.kwad.sdk.core.response.b.a.Fg(), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            c.this.cr.setText(i10 + "%");
            c.this.cs.e(i10 + "%", i10);
        }
    };

    private void ak() {
        this.cu = com.kwad.sdk.core.response.b.a.bo(this.mAdInfo);
        this.cv = com.kwad.sdk.core.response.b.a.bp(this.mAdInfo);
        this.cw = com.kwad.sdk.core.response.b.a.bq(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (this.cr.getVisibility() == 0 || this.cs.getVisibility() == 0) {
            return;
        }
        this.cr.setOnClickListener(this);
        this.cr.setVisibility(0);
        TextView textView = this.cr;
        ValueAnimator b4 = n.b(textView, 0, com.kwad.sdk.d.a.a.a(textView.getContext(), 44.0f));
        this.ct = b4;
        b4.setInterpolator(new DecelerateInterpolator(2.0f));
        this.ct.setDuration(300L);
        this.ct.start();
    }

    private void am() {
        ValueAnimator valueAnimator = this.ct;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.ct.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        if (this.cs.getVisibility() == 0) {
            return;
        }
        this.cs.setOnClickListener(this);
        this.cs.setVisibility(0);
        this.cr.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dQ(adTemplate);
        this.mApkDownloadHelper = this.bO.mApkDownloadHelper;
        ak();
        this.mLogoView.aD(this.mAdTemplate);
        this.cr.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.cr.setVisibility(8);
        this.cs.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), this.cs.getMax());
        this.cs.setVisibility(8);
        this.co.setVisibility(0);
        this.co.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.cp.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
            this.cp.setVisibility(0);
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.cx);
            }
        } else {
            this.cp.setVisibility(8);
        }
        this.cq.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.bO.bP.b(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.co) {
            an();
            a(false, 2);
        } else if (view == this.cr) {
            an();
            a(true, 1);
        } else if (view == this.cs) {
            a(true, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.co = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.cp = (TextView) findViewById(R.id.ksad_ad_normal_title);
        this.cq = (TextView) findViewById(R.id.ksad_ad_normal_des);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_normal_logo);
        this.cr = (TextView) findViewById(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_ad_light_convert_btn);
        this.cs = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        am();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.cx) != null) {
            cVar.c(ksAppDownloadListener);
        }
        this.bO.bP.a(this.mVideoPlayStateListener);
    }

    private void a(boolean z10, int i10) {
        com.kwad.components.core.e.d.a.a(new a.C0461a(this.co.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(i10).ao(z10).a(new a.b() { // from class: com.kwad.components.ad.draw.b.c.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(c.this.mAdTemplate, 1, c.this.bO.mRootContainer.getTouchCoords());
                if (c.this.bO.bN != null) {
                    c.this.bO.bN.onAdClicked();
                }
            }
        }));
    }
}
