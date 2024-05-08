package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.c.b;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.proxy.e;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ay;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends e {
    private FeedVideoView NZ;
    private LinearLayout Oa;
    private SplitScrollWebView PX;
    private Presenter PY;
    private com.kwad.components.core.page.splitLandingPage.view.a PZ;
    private com.kwad.components.core.page.c.a Qa;
    private boolean Qb;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    public static a at(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void initView() {
        com.kwad.components.core.page.recycle.e eVar = new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.PY.k(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.Kz));
        this.PZ = aVar;
        aVar.a(new a.InterfaceC0474a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0474a
            public final boolean pX() {
                return a.this.pU();
            }
        });
        this.NZ.post(new ay() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.PX.setTranslationY(a.this.PX.getTranslationY() + a.this.NZ.getHeight());
            }
        });
        this.PX.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void d(float f10) {
                a.this.PX.setTranslationY(a.this.PX.getTranslationY() - f10);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean pY() {
                if (!a.this.PZ.pZ() && d.Bv() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator a10 = n.a((View) a.this.PX, (Interpolator) null, a.this.PX.getTranslationY(), 0.0f);
                if (d.Bv() == 2) {
                    if (!a.this.NZ.isComplete()) {
                        animatorSet.playSequentially(a10, a.this.PZ.aH(true));
                    } else {
                        animatorSet.playTogether(a10);
                    }
                } else if (d.Bv() == 1) {
                    animatorSet.playTogether(a10);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.NZ.pW();
                        if (d.Bv() != 2 || a.this.NZ.isComplete()) {
                            return;
                        }
                        a.this.PZ.qa();
                    }
                });
                animatorSet.start();
                return true;
            }
        });
    }

    private void j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.PY = presenter;
        presenter.G(viewGroup);
        b bVar = new b();
        bVar.G(this.PX);
        com.kwad.components.core.page.c.a aVar = new com.kwad.components.core.page.c.a();
        this.Qa = aVar;
        aVar.G(this.NZ);
        this.PY.a(bVar);
        this.PY.a(this.Qa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pU() {
        SplitScrollWebView splitScrollWebView = this.PX;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.Qb) {
            return false;
        }
        this.PX.setDisableAnimation(false);
        this.Qb = true;
        SplitScrollWebView splitScrollWebView2 = this.PX;
        Animator a10 = n.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.NZ.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (d.Bv() == 2 && this.PZ.isVisible()) {
            this.PZ.pW();
            animatorSet.playSequentially(this.PZ.aH(false), a10);
        } else {
            animatorSet.play(a10);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.pV();
                a.this.NZ.qa();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV() {
        this.Qa.lW();
        this.Qa.G(this.NZ);
        this.Qa.k(new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    private void w(View view) {
        this.Oa = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.Oa.setVisibility(8);
            }
        });
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
        boolean bw = com.kwad.sdk.core.response.b.a.bw(dQ);
        String bs = com.kwad.sdk.core.response.b.a.bs(dQ);
        if (bw) {
            this.Oa.setVisibility(0);
            textView.setText(bs);
            textView.setSelected(true);
            return;
        }
        this.Oa.setVisibility(8);
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.m.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.PX;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.PX.goBack();
            return true;
        }
        if (pU()) {
            return true;
        }
        FeedVideoView feedVideoView = this.NZ;
        if (feedVideoView != null) {
            return feedVideoView.tq();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.NZ = (FeedVideoView) findViewById(R.id.ksad_split_land_ad_feed_video);
        this.PX = (SplitScrollWebView) findViewById(R.id.ksad_video_webView);
        w(view);
        j(this.lD);
        initView();
    }

    public final void pW() {
        this.NZ.pW();
    }

    @Override // com.kwad.components.core.proxy.e
    public final int pc() {
        return R.layout.ksad_split_land_page;
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.Qb = false;
        return false;
    }
}
