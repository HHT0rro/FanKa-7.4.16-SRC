package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ActionBarAppLandscape extends LinearLayout implements c {
    private AppScoreView Br;
    private TextProgressBar Bs;
    private View Bt;
    private a Bu;
    private KsAppDownloadListener cx;
    private ImageView dE;
    private TextView dF;
    private TextView dH;
    private TextView eF;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void N(boolean z10);
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.Bs.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.Bs.e(com.kwad.sdk.core.response.b.a.bY(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.Bs.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.Bs.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Bt.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    ActionBarAppLandscape.this.Bs.e(com.kwad.sdk.core.response.b.a.dn(i10), i10);
                    ActionBarAppLandscape.this.Bt.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    ActionBarAppLandscape.this.Bs.e(com.kwad.sdk.core.response.b.a.dm(i10), i10);
                    ActionBarAppLandscape.this.Bt.setVisibility(8);
                }
            };
        }
        return this.cx;
    }

    private void initView() {
        l.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_title);
        this.eF = (TextView) findViewById(R.id.ksad_app_desc);
        this.Br = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.dH = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.Bs = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.d.a.a.a(getContext(), 16.0f));
        this.Bs.setTextColor(-1);
        this.Bt = findViewById(R.id.ksad_download_bar_cover);
    }

    private void kh() {
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z10 = aA >= 3.0f;
        if (z10) {
            this.Br.setScore(aA);
            this.Br.setVisibility(0);
        }
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        boolean isEmpty = true ^ TextUtils.isEmpty(az);
        if (isEmpty) {
            this.dH.setText(az);
            this.dH.setVisibility(0);
        }
        if (!isEmpty && !z10) {
            this.eF.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.Br.setVisibility(8);
            this.dH.setVisibility(8);
            this.eF.setVisibility(0);
            return;
        }
        this.eF.setVisibility(8);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo dQ = e.dQ(adTemplate);
        this.mAdInfo = dQ;
        this.Bu = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(dQ), adTemplate, 12);
        this.dF.setText(com.kwad.sdk.core.response.b.a.cc(this.mAdInfo));
        kh();
        this.Bs.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), 0);
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.Bt, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dF(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    private void b(View view, final boolean z10) {
        com.kwad.components.core.e.d.a.a(new a.C0461a(view.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.Bs).an(view == this.Bt ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.Bu != null) {
                    ActionBarAppLandscape.this.Bu.N(z10);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
