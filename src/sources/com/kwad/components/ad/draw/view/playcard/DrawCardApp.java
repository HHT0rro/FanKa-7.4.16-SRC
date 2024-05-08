package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener cx;
    private a dk;
    private ImageView dl;
    private ImageView dm;
    private TextView dn;

    /* renamed from: do, reason: not valid java name */
    private ViewGroup f203do;
    private AppScoreView dp;
    private TextView dq;
    private TextView dr;
    private KsLogoView ds;
    private DrawDownloadProgressBar dt;
    private ValueAnimator du;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private int mHeight;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void av();

        void aw();
    }

    public DrawCardApp(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.ksad_draw_card_app, this);
        this.dl = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.dm = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.dn = (TextView) findViewById(R.id.ksad_card_app_name);
        this.f203do = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.dp = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.dq = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.dr = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.ds = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.dt = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.d.a.a.a(context, 156.0f);
    }

    private void aG() {
        ValueAnimator valueAnimator = this.du;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.du.cancel();
        }
    }

    private void aP() {
        d(this.mHeight, 0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.bY(DrawCardApp.this.mAdTemplate), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.aE(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.ac(DrawCardApp.this.mAdInfo), DrawCardApp.this.dt.getMax());
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    super.onPaused(i10);
                    DrawCardApp.this.dt.e(com.kwad.sdk.core.response.b.a.Fg(), i10);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    DrawCardApp.this.dt.e(i10 + "%", i10);
                }
            };
        }
        return this.cx;
    }

    public final void aO() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dl) {
            aP();
            a aVar = this.dk;
            if (aVar != null) {
                aVar.av();
                return;
            }
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0461a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.dt).an(view == this.dt ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardApp.this.dk != null) {
                    DrawCardApp.this.dk.aw();
                }
            }
        }));
    }

    public final void release() {
        aG();
        this.mApkDownloadHelper = null;
    }

    private void d(int i10, int i11) {
        aG();
        ValueAnimator b4 = n.b(this, i10, i11);
        this.du = b4;
        b4.setInterpolator(new DecelerateInterpolator(2.0f));
        this.du.setDuration(300L);
        this.du.start();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dQ(adTemplate);
        this.dk = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.dm, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), adTemplate, 11);
        this.dn.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z10 = aA >= 3.0f;
        if (z10) {
            this.dp.setScore(aA);
            this.dp.setVisibility(0);
        }
        boolean z11 = !TextUtils.isEmpty(az);
        if (z11) {
            this.dq.setText(az);
            this.dq.setVisibility(0);
        }
        if (!z10 && !z11) {
            this.f203do.setVisibility(8);
        } else {
            this.f203do.setVisibility(0);
        }
        this.ds.aD(this.mAdTemplate);
        this.dr.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.dl.setOnClickListener(this);
        this.dt.setOnClickListener(this);
        setOnClickListener(this);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        B(context);
    }
}
