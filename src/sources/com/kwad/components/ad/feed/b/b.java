package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    public ImageView dE;
    public TextView dF;
    private TextView dM;
    public TextView eB;
    public ImageView eC;
    public ImageView eD;
    public RatioFrameLayout eE;
    public TextView eF;
    private TextView eG;
    private View eH;
    public DownloadProgressView eI;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public KsLogoView mLogoView;

    public b(@NonNull Context context) {
        super(context);
    }

    private void bd() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.eG = (TextView) findViewById(R.id.ksad_h5_desc);
        this.dM = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.eH = findViewById(R.id.ksad_h5_open_cover);
        this.eG.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.eH.setOnClickListener(this);
        this.eG.setOnClickListener(this);
        this.dM.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        new com.kwad.sdk.widget.f(getContext(), this.dM, this);
    }

    private void be() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.eF = textView;
        com.kwad.sdk.d.a.a.a(this, this.dE, this.dF, textView);
        new com.kwad.sdk.widget.f(getContext(), this.dE, this);
        new com.kwad.sdk.widget.f(getContext(), this.dF, this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.dE.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 8);
        this.eF.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        bb();
        this.eI.ai(this.mAdTemplate);
        this.eI.setOnClickListener(this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.eI.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_image_container);
        this.eE = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.eC = (ImageView) findViewById(R.id.ksad_ad_image);
        this.eD = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.eI = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i10;
        if (view == this.eB) {
            i10 = 25;
        } else if (view == this.eC) {
            i10 = 100;
        } else if (view == this.eI || view == this.dM || view == this.eH) {
            i10 = 1;
        } else if (view == this.dE) {
            i10 = 13;
        } else if (view == this.dF) {
            i10 = 14;
        } else {
            i10 = (view == this.eF || view == this.eG) ? 101 : 35;
        }
        a(view, i10);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((b) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.mLogoView.aD(this.mAdTemplate);
        this.eC.post(new ay() { // from class: com.kwad.components.ad.feed.b.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(b.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.aU(dQ).height > com.kwad.sdk.core.response.b.a.aU(dQ).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.eE.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.eE.setRatio(1.7857142686843872d);
                    b.this.eE.setLayoutParams(layoutParams);
                }
                List<String> ba2 = com.kwad.sdk.core.response.b.a.ba(b.this.mAdInfo);
                if (ba2.size() > 0) {
                    KSImageLoader.loadFeeImage(b.this.eC, ba2.get(0), b.this.mAdTemplate, b.this.ez);
                } else {
                    com.kwad.sdk.core.e.c.e("BaseFeedTextImageView", "getImageUrlList size less than one");
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            be();
        } else {
            bd();
        }
        com.kwad.sdk.d.a.a.a(this, this.eB, this.eC, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    private void a(View view, final int i10) {
        if (view == this.eD) {
            tk();
        } else {
            ba();
            com.kwad.components.core.e.d.a.a(new a.C0461a(getContext()).aq(this.mAdTemplate).al(5).am(i10).b(this.mApkDownloadHelper).an(view == this.eI ? 1 : 2).ao(view == this.eI).a(new a.b() { // from class: com.kwad.components.ad.feed.b.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.aL(i10);
                }
            }));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            a(view, 153);
        }
    }
}
