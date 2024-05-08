package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements View.OnClickListener {
    private final boolean alK;
    private final boolean alL;
    private View alM;
    private ImageView alN;
    private TextView alO;
    private Button alP;
    private int alQ;
    private int alR;
    private boolean alS;
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;

    @NonNull
    private final Context mContext;

    @NonNull
    private View mRootView = zU();

    public e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z10, boolean z11, boolean z12) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        this.alK = z10;
        this.alL = z11;
        this.alS = z12;
        lR();
    }

    private Animator B(View view) {
        ObjectAnimator ofFloat;
        if (this.alK && this.alL) {
            ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0.0f, this.alR);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f, -this.alQ);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    private void c(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_height);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_card_margin);
        this.alQ = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        }
        layoutParams.gravity = 48;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        layoutParams.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.alQ);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void d(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int screenWidth = bi.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_left);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ksad_install_tips_bottom_margin_bottom);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ksad_install_tips_bottom_height);
        this.alR = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        }
        layoutParams.gravity = 80;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.alR);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void lR() {
        this.alP.setText(this.alK ? "安装" : "打开");
        this.alM.setOnClickListener(this);
        this.alP.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.alN, com.kwad.sdk.core.response.b.a.cf(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate)), this.mAdTemplate, 8);
        String av = com.kwad.sdk.core.response.b.a.av(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
        if (av.length() >= 8) {
            av = av.substring(0, 7) + "...";
        }
        this.alO.setText(this.mContext.getString(this.alK ? R.string.ksad_install_tips : R.string.ksad_launch_tips, av));
    }

    private void show() {
        ObjectAnimator ofFloat;
        if (this.alK && this.alL) {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_X, this.alR, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_Y, -this.alQ, 0.0f);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private View zU() {
        if (this.alK && this.alL) {
            this.mRootView = l.inflate(this.mContext, R.layout.ksad_install_tips_bottom, null);
        } else {
            this.mRootView = l.inflate(this.mContext, R.layout.ksad_install_tips, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.ksad_install_tips_card_elevation));
        this.alM = this.mRootView.findViewById(R.id.ksad_install_tips_close);
        this.alN = (ImageView) this.mRootView.findViewById(R.id.ksad_install_tips_icon);
        this.alO = (TextView) this.mRootView.findViewById(R.id.ksad_install_tips_content);
        this.alP = (Button) this.mRootView.findViewById(R.id.ksad_install_tips_install);
        return this.mRootView;
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator B = B(this.mRootView);
        B.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        B.start();
        c.zM().zR();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.ksad_install_tips_install) {
            if (this.alK) {
                if (this.alS) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.cM(29);
                    bVar.cT(23);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar);
                } else {
                    com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 45);
                }
                ak.a(com.kwad.sdk.core.response.b.a.H(this.mAdInfo), new ak.a() { // from class: com.kwad.sdk.a.a.e.3
                    @Override // com.kwad.sdk.utils.ak.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.ak.a
                    public final void ol() {
                        com.kwad.sdk.core.adlog.c.h(e.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.aY(e.this.mAdTemplate);
                    }
                });
                return;
            }
            if (ak.ap(this.mContext, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
                com.kwad.sdk.core.adlog.c.bH(this.mAdTemplate);
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 47);
            return;
        }
        if (view.getId() == R.id.ksad_install_tips_close) {
            if (this.alK) {
                if (this.alS) {
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    bVar2.cM(69);
                    bVar2.cT(23);
                    bVar2.cX(1);
                    com.kwad.sdk.core.adlog.c.e(this.mAdTemplate, (JSONObject) null, bVar2);
                    return;
                }
                com.kwad.sdk.core.adlog.c.o(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 48);
        }
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.alK && this.alL) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new ay() { // from class: com.kwad.sdk.a.a.e.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                e.this.dismiss();
            }
        }, 10000L);
    }
}
