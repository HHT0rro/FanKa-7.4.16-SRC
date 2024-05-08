package com.wangmai.ad.dex.allmodules.api.splash;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.common.utils.Utils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiSplashViewComponentsController.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa {

    /* renamed from: appa, reason: collision with root package name */
    private boolean f46674appa;
    private boolean appb;
    private boolean appc;
    private Context appd;
    private View appe;
    private View appf;
    private View appg;
    private View apph;
    private View appi;
    private View appj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiSplashViewComponentsController.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.splash.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class AnimationAnimationListenerC0669appa implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Handler f46675appa;
        final /* synthetic */ View appb;
        final /* synthetic */ RotateAnimation appc;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiSplashViewComponentsController.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.splash.appa$appa$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class RunnableC0670appa implements Runnable {
            RunnableC0670appa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimationAnimationListenerC0669appa animationAnimationListenerC0669appa = AnimationAnimationListenerC0669appa.this;
                animationAnimationListenerC0669appa.appb.startAnimation(animationAnimationListenerC0669appa.appc);
            }
        }

        AnimationAnimationListenerC0669appa(appa appaVar, Handler handler, View view, RotateAnimation rotateAnimation) {
            this.f46675appa = handler;
            this.appb = view;
            this.appc = rotateAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f46675appa.postDelayed(new RunnableC0670appa(), 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public appa(Context context, View view, int i10) {
        appa(context, view, i10);
    }

    private void appc() {
        Handler handler = new Handler();
        View findViewById = this.apph.findViewById(R$id.wm_splash_shake_hand);
        RotateAnimation rotateAnimation = new RotateAnimation(315.0f, 405.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200L);
        rotateAnimation.setRepeatCount(5);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setAnimationListener(new AnimationAnimationListenerC0669appa(this, handler, findViewById, rotateAnimation));
        findViewById.startAnimation(rotateAnimation);
    }

    private void appd() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 2.6f, 1, 0.4f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setRepeatCount(100);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setRepeatMode(1);
        this.appi.findViewById(R$id.wm_splash_swipe_hand).startAnimation(translateAnimation);
    }

    public void appa(Context context, View view, int i10) {
        this.appd = context;
        this.f46674appa = i10 != 0;
        this.appj = view.findViewById(R$id.wm_splash_interaction_view);
        this.appe = view.findViewById(R$id.wm_click_region);
        this.appf = view.findViewById(R$id.wm_shake_click_region);
        this.apph = view.findViewById(R$id.wm_splash_shake_view);
        this.appi = view.findViewById(R$id.wm_splash_swipe_view);
        this.appg = view.findViewById(R$id.wm_swipe_click_region);
    }

    public void appb() {
        this.appb = true;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.appe.setOnClickListener(onClickListener);
        this.appf.setOnClickListener(onClickListener);
        this.apph.setOnClickListener(onClickListener);
        this.appg.setOnClickListener(onClickListener);
    }

    public void appa() {
        this.appc = true;
    }

    public void appa(boolean z10) {
        this.appj.getLocationOnScreen(new int[2]);
        if (this.appd.getResources().getConfiguration().orientation == 1) {
            int windowHeight = Utils.getWindowHeight(this.appd);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.appj.getLayoutParams();
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, z10 ? (windowHeight * 1) / 4 : 150);
            this.appj.setLayoutParams(layoutParams);
        }
        this.appe.setVisibility(8);
        this.appf.setVisibility(8);
        this.apph.setVisibility(8);
        this.appi.setVisibility(8);
        this.appg.setVisibility(8);
        if (this.appc && this.appb) {
            this.appf.setVisibility(0);
            this.appi.setVisibility(0);
            appd();
            return;
        }
        if (this.f46674appa && this.appc) {
            this.appf.setVisibility(0);
            this.apph.setVisibility(0);
            appc();
            return;
        }
        if (this.f46674appa && this.appb) {
            this.appg.setVisibility(0);
            this.appi.setVisibility(0);
            appd();
        } else if (this.appc) {
            this.apph.setVisibility(0);
            appc();
        } else if (this.appb) {
            this.appi.setVisibility(0);
            appd();
        } else if (this.f46674appa) {
            this.appe.setVisibility(0);
        }
    }
}
