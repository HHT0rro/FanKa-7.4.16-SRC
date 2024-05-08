package com.kwad.components.ad.interstitial.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends KSFrameLayout implements com.kwad.sdk.widget.c {
    private ImageView dE;
    private TextView eF;
    private ImageView eM;
    private KSFrameLayout kL;
    private KSFrameLayout kr;
    private String lF;

    @Nullable
    private View lG;
    private ImageView lH;
    private TextProgressBar lI;
    private ViewGroup lJ;
    private ViewGroup lK;
    private ImageView lL;
    private View lM;
    private View lN;
    private TextView lO;
    private ImageView lP;
    private TextView lQ;
    private TextView lR;
    private TextView lS;
    private TextProgressBar lT;
    private TextView lU;
    private e lV;
    private final a lW;
    private boolean lX;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private boolean lZ = false;

        /* renamed from: ma, reason: collision with root package name */
        private boolean f36534ma = false;

        /* renamed from: mb, reason: collision with root package name */
        private int f36535mb = 0;

        /* renamed from: mc, reason: collision with root package name */
        private boolean f36536mc = true;

        public final void F(int i10) {
            this.f36535mb = i10;
        }

        public final int ej() {
            return this.f36535mb;
        }

        public final boolean ek() {
            return this.f36536mc;
        }

        public final void v(boolean z10) {
            this.lZ = z10;
        }

        public final void w(boolean z10) {
            this.f36534ma = z10;
        }

        public final void x(boolean z10) {
            this.f36536mc = z10;
        }
    }

    public d(@NonNull Context context, a aVar) {
        super(context);
        this.lF = "%s秒后进入试玩页";
        this.lX = false;
        this.lW = aVar;
        l.inflate(context, aVar.ek() ? R.layout.ksad_interstitial_native_above : R.layout.ksad_interstitial_native, this);
        s(aVar.lZ);
    }

    private void d(View view, int i10) {
        com.kwad.sdk.d.a.a.b(view, 0, com.kwad.sdk.d.a.a.a(getContext(), i10), 0, 0);
    }

    private void ed() {
        a(this.lP, 40, 40);
        a(this.lT, 130, 30);
        this.lR.setTextSize(14.0f);
        d(this.lT, 11);
        d(this.lR, 7);
        d(this.lS, 7);
    }

    private void s(boolean z10) {
        setClickable(true);
        this.kr = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_container);
        this.kL = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.lG = findViewById(R.id.ksad_interstitial_full_bg);
        this.lH = (ImageView) findViewById(R.id.ksad_interstitial_tail_frame);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.lJ = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.lK = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.lI = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.lM = findViewById(R.id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.lI;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.d.a.a.a(getContext(), 10.0f));
            this.lI.setTextColor(-1);
        }
        this.lL = (ImageView) findViewById(R.id.ksad_interstitial_mute);
        this.lO = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.lP = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.lR = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.lS = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.lT = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.lN = findViewById(R.id.ksad_ad_download_container);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.lQ = (TextView) findViewById(R.id.ksad_app_title);
        this.eF = (TextView) findViewById(R.id.ksad_app_desc);
        new f(this, this);
        new f(this.eM, this);
        new f(this.lI, this);
        new f(this.lT, this);
        new f(this.lM, this);
        new f(this.lK, this);
        new f(this.lO, this);
        new f(this.lN, this);
        new f(this.dE, this);
        new f(this.lQ, this);
        new f(this.eF, this);
        new f(this.lP, this);
        new f(this.lR, this);
        new f(this.lS, this);
        this.lL.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.g.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.lL.setSelected(!d.this.lL.isSelected());
                if (d.this.lV != null) {
                    d.this.lV.o(d.this.lL.isSelected());
                }
            }
        });
        this.lU = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.kL, z10);
        if (ai.isOrientationPortrait()) {
            return;
        }
        ed();
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (bg.isNullString(str)) {
            return;
        }
        this.eM.setImageDrawable(null);
        KSImageLoader.loadImage(this.eM, str, adTemplate);
    }

    public final void ee() {
        TextView textView = this.lO;
        if (textView != null) {
            textView.setVisibility(8);
            this.lX = true;
        }
    }

    public final void ef() {
        View view = this.lM;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void eg() {
        t(false);
        this.lK.setVisibility(0);
        this.lH.setVisibility(0);
    }

    public final void eh() {
        this.lK.setVisibility(8);
        this.lH.setVisibility(8);
        t(true);
    }

    public final boolean ei() {
        ViewGroup viewGroup = this.lK;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public final void f(int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i10;
        marginLayoutParams.height = i11;
        setLayoutParams(marginLayoutParams);
    }

    public final void g(String str, int i10) {
        TextProgressBar textProgressBar = this.lI;
        if (textProgressBar != null) {
            textProgressBar.e(str, 0);
        }
        TextProgressBar textProgressBar2 = this.lT;
        if (textProgressBar2 != null) {
            textProgressBar2.e(str, 0);
        }
    }

    @Nullable
    public final View getBlurBgView() {
        return this.lG;
    }

    public final ImageView getTailFrameView() {
        return this.lH;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(e eVar) {
        this.lV = eVar;
    }

    public final void t(boolean z10) {
        ViewGroup viewGroup = this.lJ;
        if (viewGroup != null) {
            viewGroup.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void u(boolean z10) {
        ImageView imageView = this.lL;
        if (imageView != null) {
            imageView.setSelected(z10);
        }
    }

    public final void w(String str) {
        TextView textView = this.lO;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.lW.f36534ma || this.lX || this.lO.getVisibility() == 0) {
            return;
        }
        this.lO.setVisibility(0);
    }

    public final void y(AdTemplate adTemplate) {
        this.mLogoView.aD(adTemplate);
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z10) {
        kSFrameLayout.setClickable(true);
        new f(kSFrameLayout, this);
        this.kL.setWidthBasedRatio(!z10);
    }

    public final void b(boolean z10, int i10) {
        TextView textView = this.lU;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i10 >= 0) {
            this.lU.setText(String.format(this.lF, String.valueOf(i10)));
        }
    }

    public final void c(boolean z10, boolean z11) {
        ImageView imageView = this.eM;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
            this.eM.setClickable(z11);
        }
    }

    private void a(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = com.kwad.sdk.d.a.a.a(getContext(), i10);
        layoutParams.height = com.kwad.sdk.d.a.a.a(getContext(), i11);
        view.setLayoutParams(layoutParams);
    }

    private void b(View view, boolean z10) {
        e eVar;
        e eVar2;
        e eVar3 = this.lV;
        if (eVar3 != null) {
            eVar3.p(z10);
            this.lV.a(this.kr);
        }
        if (view.equals(this)) {
            e eVar4 = this.lV;
            if (eVar4 != null) {
                eVar4.dg();
                return;
            }
            return;
        }
        if (view.equals(this.lM)) {
            if (!(1 == this.lW.ej()) || (eVar2 = this.lV) == null) {
                return;
            }
            eVar2.df();
            return;
        }
        if (view.equals(this.lT)) {
            e eVar5 = this.lV;
            if (eVar5 != null) {
                eVar5.dh();
                return;
            }
            return;
        }
        if (view.equals(this.lK)) {
            e eVar6 = this.lV;
            if (eVar6 != null) {
                eVar6.ds();
                return;
            }
            return;
        }
        if (view.equals(this.lI)) {
            e eVar7 = this.lV;
            if (eVar7 != null) {
                eVar7.di();
                return;
            }
            return;
        }
        if (view.equals(this.lN)) {
            e eVar8 = this.lV;
            if (eVar8 != null) {
                eVar8.dl();
                return;
            }
            return;
        }
        if (view.equals(this.kL)) {
            e eVar9 = this.lV;
            if (eVar9 != null) {
                eVar9.dj();
                return;
            }
            return;
        }
        if (view.equals(this.eM)) {
            e eVar10 = this.lV;
            if (eVar10 != null) {
                eVar10.dk();
                return;
            }
            return;
        }
        if (view.equals(this.dE)) {
            e eVar11 = this.lV;
            if (eVar11 != null) {
                eVar11.dm();
                return;
            }
            return;
        }
        if (view.equals(this.lQ)) {
            e eVar12 = this.lV;
            if (eVar12 != null) {
                eVar12.dn();
                return;
            }
            return;
        }
        if (view.equals(this.eF)) {
            e eVar13 = this.lV;
            if (eVar13 != null) {
                eVar13.mo2861do();
                return;
            }
            return;
        }
        if (view.equals(this.lP)) {
            e eVar14 = this.lV;
            if (eVar14 != null) {
                eVar14.dp();
                return;
            }
            return;
        }
        if (view.equals(this.lR)) {
            e eVar15 = this.lV;
            if (eVar15 != null) {
                eVar15.dq();
                return;
            }
            return;
        }
        if (!view.equals(this.lS) || (eVar = this.lV) == null) {
            return;
        }
        eVar.dr();
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        ImageView imageView = this.lP;
        int i10 = R.drawable.ksad_default_app_icon;
        imageView.setImageResource(i10);
        if (com.kwad.sdk.core.response.b.a.ca(adInfo) == 2) {
            KSImageLoader.loadCircleIcon(this.lP, com.kwad.sdk.core.response.b.a.cI(adInfo), getContext().getResources().getDrawable(i10));
            this.lR.setText(com.kwad.sdk.core.response.b.a.ce(adInfo));
            this.lS.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            if (com.kwad.sdk.core.response.b.a.cE(adInfo)) {
                this.lT.e(com.kwad.components.ad.d.b.X(), 0);
                return;
            } else {
                this.lT.e(com.kwad.components.ad.d.b.aa(), 0);
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.cL() && com.kwad.sdk.core.response.b.a.ca(adInfo) == 3) {
            AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(adInfo);
            KSImageLoader.loadWithRadius(this.lP, cP.icon, adTemplate, 4);
            this.lR.setText(cP.name);
            this.lS.setVisibility(8);
            this.lT.e(com.kwad.components.ad.d.b.Y(), 0);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            KSImageLoader.loadWithRadius(this.lP, com.kwad.sdk.core.response.b.a.cf(adInfo), adTemplate, 4);
            this.lR.setText(com.kwad.sdk.core.response.b.a.av(adInfo));
            this.lS.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.lT.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
            return;
        }
        KSImageLoader.loadWithRadius(this.lP, com.kwad.sdk.core.response.b.e.dV(adTemplate), adTemplate, 4);
        this.lR.setText(com.kwad.sdk.core.response.b.a.cc(adInfo));
        this.lS.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
        this.lT.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
    }

    public final void a(float f10, com.kwad.sdk.core.video.videoview.a aVar) {
        this.kL.setRatio(f10);
        this.kL.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            b(view, false);
        }
    }
}
