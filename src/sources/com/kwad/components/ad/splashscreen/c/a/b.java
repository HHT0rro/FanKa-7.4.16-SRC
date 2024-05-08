package com.kwad.components.ad.splashscreen.c.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.splashscreen.c.e implements View.OnClickListener {
    private AdInfo.DownloadSafeInfo EA;
    private TextView Ev;
    private TextView Ew;
    private TextView Ex;
    private TextView Ey;
    private TextView Ez;

    private void initView() {
        this.Ev = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.Ew = (TextView) findViewById(R.id.ksad_ad_permission_text);
        this.Ex = (TextView) findViewById(R.id.ksad_ad_introduction_text);
        this.Ey = (TextView) findViewById(R.id.ksad_ad_privacy_text);
        this.Ez = (TextView) findViewById(R.id.ksad_ad_developer_text);
    }

    private void lB() {
        if (com.kwad.sdk.core.response.b.a.aP(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate))) {
            StringBuilder sb2 = new StringBuilder();
            String str = this.EA.appVersion;
            if (bg.gP(str)) {
                sb2.append("版本号 ");
                sb2.append(str);
            }
            if (bg.gP(sb2.toString())) {
                this.Ev.setText(sb2);
            }
            String str2 = this.EA.introductionInfoUrl;
            if (bg.gP(str2)) {
                this.Ex.setText("功能");
                this.Ex.setOnClickListener(this);
            }
            AdInfo.DownloadSafeInfo downloadSafeInfo = this.EA;
            String str3 = downloadSafeInfo.appPermissionInfoUrl;
            String str4 = downloadSafeInfo.appPrivacyUrl;
            if (bg.gP(str3)) {
                StringBuilder sb3 = new StringBuilder();
                if (bg.gP(str2)) {
                    sb3.append(" | ");
                }
                sb3.append("权限");
                this.Ew.setText(sb3);
                this.Ew.setOnClickListener(this);
            }
            if (bg.gP(str4)) {
                StringBuilder sb4 = new StringBuilder();
                if (bg.gP(str3) || bg.gP(str2)) {
                    sb4.append(" | ");
                }
                sb4.append("隐私");
                this.Ey.setText(sb4);
                this.Ey.setOnClickListener(this);
            }
            StringBuilder sb5 = new StringBuilder();
            String str5 = this.EA.appName;
            if (bg.gP(str5)) {
                sb5.append(str5);
            }
            String str6 = this.EA.corporationName;
            if (bg.gP(str6)) {
                if (bg.gP(str5)) {
                    sb5.append(" ");
                }
                sb5.append(str6);
            }
            if (bg.gP(sb5.toString())) {
                this.Ez.setText(sb5);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EA = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate).downloadSafeInfo;
        lB();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Ey) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0472a().as("隐私政策").at(this.EA.appPrivacyUrl).aC(true).as(this.Dg.mAdTemplate).pl());
        } else if (view == this.Ew) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0472a().as("权限信息").aC(true).at(this.EA.appPermissionInfoUrl).as(this.Dg.mAdTemplate).pl());
        } else if (view == this.Ex) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0472a().as("功能介绍").aC(true).at(this.EA.introductionInfoUrl).as(this.Dg.mAdTemplate).pl());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
