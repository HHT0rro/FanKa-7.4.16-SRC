package com.kwad.components.ad.interstitial.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g extends com.kwad.components.ad.interstitial.e.b {
    private static int kS = 4;
    private c jK;
    private a kQ = new a();
    private b kR = new b();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private ImageView kT;
        private TextView kU;
        private TextView kV;
        private KsPriceView kW;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {
        private String appIconUrl;
        private String kX;
        private CharSequence kY;
        private String kZ;

        /* renamed from: la, reason: collision with root package name */
        private String f36531la;
        private String price;

        public final void a(CharSequence charSequence) {
            this.kY = charSequence;
        }

        public final String dA() {
            return this.f36531la;
        }

        public final String dx() {
            return this.kX;
        }

        public final CharSequence dy() {
            return this.kY;
        }

        public final String dz() {
            return this.kZ;
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void r(String str) {
            this.appIconUrl = str;
        }

        public final void s(String str) {
            this.kX = str;
        }

        public final void t(String str) {
            this.kZ = str;
        }

        public final void u(String str) {
            this.price = str;
        }

        public final void v(String str) {
            this.f36531la = str;
        }
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.kT;
        if (!TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.b.a.bZ(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, kS);
            }
        } else {
            imageView.setVisibility(8);
        }
        aVar.kU.setText(bVar.dx());
        if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.bZ(adInfo) == 3) {
            aVar.kW.d(bVar.getPrice(), bVar.dz(), true);
            aVar.kW.setVisibility(0);
            aVar.kV.setVisibility(8);
            dw();
        } else {
            aVar.kV.setText(bVar.dy());
        }
        this.jK.jL.g(bVar.dA(), 0);
    }

    private void d(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bZ(adInfo) == 2) {
            this.kR.r(com.kwad.sdk.core.response.b.a.cI(adInfo));
            this.kR.s(com.kwad.sdk.core.response.b.a.ce(adInfo));
            CharSequence b4 = com.kwad.sdk.core.response.b.a.b(adInfo, com.kwad.components.core.widget.e.acq);
            if (TextUtils.isEmpty(b4)) {
                b4 = com.kwad.sdk.core.response.b.a.cH(adInfo);
            }
            this.kR.a(b4);
            if (com.kwad.sdk.core.response.b.a.cE(adInfo)) {
                this.kR.v(com.kwad.components.ad.d.b.X());
                return;
            } else {
                this.kR.v(com.kwad.components.ad.d.b.aa());
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.bZ(adInfo) == 3) {
            AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(adInfo);
            this.kR.r(cP.icon);
            this.kR.s(cP.name);
            this.kR.t(cP.originPrice);
            this.kR.u(cP.price);
            this.kR.v(com.kwad.components.ad.d.b.Y());
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            this.kR.r(com.kwad.sdk.core.response.b.a.cf(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.av(adInfo))) {
                this.kR.s(com.kwad.sdk.core.response.b.a.av(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.kR.s(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.kR.s(getContext().getString(R.string.ksad_ad_default_username_normal));
            }
            this.kR.a(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.kR.v(com.kwad.sdk.core.response.b.a.aE(adInfo));
            return;
        }
        this.kR.r(com.kwad.sdk.core.response.b.a.cf(adInfo));
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.ax(adInfo))) {
            this.kR.s(com.kwad.sdk.core.response.b.a.ax(adInfo));
        } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
            this.kR.s(adInfo.advertiserInfo.adAuthorText);
        } else {
            this.kR.s(getContext().getString(R.string.ksad_ad_default_username_normal));
        }
        this.kR.a(com.kwad.sdk.core.response.b.a.au(adInfo));
        this.kR.v(com.kwad.sdk.core.response.b.a.aE(adInfo));
    }

    private void dw() {
        View findViewById = this.jK.jL.findViewById(R.id.ksad_ad_desc_layout);
        View findViewById2 = this.jK.jL.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setVisibility(8);
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        c cVar = (c) Jx();
        this.jK = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.kQ.kT = (ImageView) this.jK.jL.findViewById(R.id.ksad_app_icon);
        this.kQ.kU = (TextView) this.jK.jL.findViewById(R.id.ksad_app_title);
        this.kQ.kV = (TextView) this.jK.jL.findViewById(R.id.ksad_app_desc);
        this.kQ.kW = (KsPriceView) this.jK.jL.findViewById(R.id.ksad_product_price);
        d(this.mAdInfo);
        a(this.kQ, this.kR, this.mAdInfo, this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
