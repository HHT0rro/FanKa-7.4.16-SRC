package com.kwad.components.ad.splashscreen.c.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.ad.splashscreen.c.e implements View.OnClickListener, com.kwad.sdk.widget.c {
    private CloseCountDownView EB;
    private ViewGroup ED;
    private ViewGroup EE;
    private ImageView EF;
    private TextView EG;
    private TextView EH;
    private CloseCountDownView.a EI = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.c.a.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void df() {
            a.C0516a c0516a = new a.C0516a();
            com.kwad.components.ad.splashscreen.monitor.a.kT().l(c.this.Dg.mAdTemplate);
            if (c.this.Dg.mTimerHelper != null) {
                c0516a.duration = c.this.Dg.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.Dg.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(1).b(c0516a).cT(6), (JSONObject) null);
            c.this.Dg.kO();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void lb() {
            a.C0516a c0516a = new a.C0516a();
            if (c.this.Dg.mTimerHelper != null) {
                c0516a.duration = c.this.Dg.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.Dg.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(14).b(c0516a).cT(6), (JSONObject) null);
            c.this.Dg.kS();
        }
    };

    private void t(View view) {
        if (view == this.ED) {
            this.Dg.c(2, view.getContext(), 104, 2);
            return;
        }
        if (view == this.EE) {
            this.Dg.c(2, view.getContext(), 26, 1);
            return;
        }
        if (view == this.EF) {
            this.Dg.c(2, view.getContext(), 15, 2);
        } else if (view == this.EG) {
            this.Dg.c(2, view.getContext(), 16, 2);
        } else if (view == this.EH) {
            this.Dg.c(2, view.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EB.setOnViewClickListener(this.EI);
        this.EE.setOnClickListener(this);
        new com.kwad.sdk.widget.f(this.EE.getContext(), this.EE, this);
        if (com.kwad.sdk.core.response.b.b.df(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate))) {
            this.ED.setOnClickListener(this);
            this.EF.setOnClickListener(this);
            this.EG.setOnClickListener(this);
            this.EH.setOnClickListener(this);
            new com.kwad.sdk.widget.f(this.EE.getContext(), this.ED, this);
            new com.kwad.sdk.widget.f(this.EE.getContext(), this.EF, this);
            new com.kwad.sdk.widget.f(this.EE.getContext(), this.EG, this);
            new com.kwad.sdk.widget.f(this.EE.getContext(), this.EH, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        t(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.EB = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.ED = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.EE = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
        this.EF = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.EG = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.EH = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        t(view);
    }
}
