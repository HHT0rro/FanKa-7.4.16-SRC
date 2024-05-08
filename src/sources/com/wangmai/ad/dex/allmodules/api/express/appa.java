package com.wangmai.ad.dex.allmodules.api.express;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import com.wangmai.ad.dex.allmodules.R$id;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiNativeViewComponentsController.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa {

    /* renamed from: appa, reason: collision with root package name */
    private boolean f46522appa;
    private boolean appb;
    private View appc;
    private View appd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiNativeViewComponentsController.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.express.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class AnimationAnimationListenerC0660appa implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ View f46523appa;
        final /* synthetic */ TranslateAnimation appb;

        AnimationAnimationListenerC0660appa(View view, TranslateAnimation translateAnimation) {
            this.f46523appa = view;
            this.appb = translateAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (appa.this.appc != null) {
                this.f46523appa.startAnimation(this.appb);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiNativeViewComponentsController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ AlphaAnimation f46524appa;

        appb(AlphaAnimation alphaAnimation) {
            this.f46524appa = alphaAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (appa.this.appc != null) {
                appa.this.appc.startAnimation(this.f46524appa);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiNativeViewComponentsController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Handler f46525appa;
        final /* synthetic */ AlphaAnimation appb;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiNativeViewComponentsController.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.express.appa$appc$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class RunnableC0661appa implements Runnable {
            RunnableC0661appa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                appa.this.appc.startAnimation(appc.this.appb);
            }
        }

        appc(Handler handler, AlphaAnimation alphaAnimation) {
            this.f46525appa = handler;
            this.appb = alphaAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f46525appa.postDelayed(new RunnableC0661appa(), 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiNativeViewComponentsController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ AlphaAnimation f46527appa;

        appd(AlphaAnimation alphaAnimation) {
            this.f46527appa = alphaAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            appa.this.appd.startAnimation(this.f46527appa);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiNativeViewComponentsController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ View f46528appa;
        final /* synthetic */ RotateAnimation appb;

        appe(appa appaVar, View view, RotateAnimation rotateAnimation) {
            this.f46528appa = view;
            this.appb = rotateAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f46528appa.startAnimation(this.appb);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiNativeViewComponentsController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Handler f46529appa;
        final /* synthetic */ AlphaAnimation appb;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiNativeViewComponentsController.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.express.appa$appf$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class RunnableC0662appa implements Runnable {
            RunnableC0662appa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                appa.this.appd.startAnimation(appf.this.appb);
            }
        }

        appf(Handler handler, AlphaAnimation alphaAnimation) {
            this.f46529appa = handler;
            this.appb = alphaAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f46529appa.postDelayed(new RunnableC0662appa(), 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public appa(Context context, View view) {
        if (view != null) {
            appa(context, view);
        }
    }

    private void appd() {
        try {
            Handler handler = new Handler();
            View findViewById = this.appd.findViewById(R$id.wm_express_shake_hand);
            RotateAnimation rotateAnimation = new RotateAnimation(315.0f, 405.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(200L);
            rotateAnimation.setRepeatCount(5);
            rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            rotateAnimation.setRepeatMode(2);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setFillBefore(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setFillBefore(true);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(200L);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setFillBefore(true);
            rotateAnimation.setAnimationListener(new appd(alphaAnimation2));
            alphaAnimation.setAnimationListener(new appe(this, findViewById, rotateAnimation));
            alphaAnimation2.setAnimationListener(new appf(handler, alphaAnimation));
            findViewById.startAnimation(rotateAnimation);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ComponentsController", "start rotate animation error:" + th.toString());
        }
    }

    private void appe() {
        try {
            Handler handler = new Handler();
            View findViewById = this.appc.findViewById(R$id.wm_express_swipe_hand);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setFillBefore(true);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(20L);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setFillBefore(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.2f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setFillBefore(false);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            alphaAnimation.setAnimationListener(new AnimationAnimationListenerC0660appa(findViewById, translateAnimation));
            translateAnimation.setAnimationListener(new appb(alphaAnimation2));
            alphaAnimation2.setAnimationListener(new appc(handler, alphaAnimation));
            this.appc.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ComponentsController", "start swipe animation error:" + th.toString());
        }
    }

    public void appc() {
        this.f46522appa = true;
    }

    public void appa(Context context, View view) {
        try {
            this.appc = view.findViewById(R$id.wm_native_swipe_view);
            this.appd = view.findViewById(R$id.wm_native_shake_view);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ComponentsController", "int error:" + th.toString());
        }
    }

    public void appb() {
        this.appb = true;
    }

    public void appa(boolean z10) {
        try {
            if (z10) {
                if (this.f46522appa) {
                    this.appc.setVisibility(0);
                    appe();
                }
                if (this.appb) {
                    this.appd.setVisibility(0);
                    appd();
                    return;
                }
                return;
            }
            this.appc.clearAnimation();
            this.appd.clearAnimation();
            this.appc.setVisibility(4);
            this.appd.setVisibility(4);
            this.appc.clearAnimation();
            this.appd.clearAnimation();
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ComponentsController", "sync view state error:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void appa() {
        try {
            if (this.appd != null) {
                this.appd.clearAnimation();
            }
            if (this.appc != null) {
                this.appc.clearAnimation();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ComponentsController", "destroy error:" + th.toString());
        }
    }
}
