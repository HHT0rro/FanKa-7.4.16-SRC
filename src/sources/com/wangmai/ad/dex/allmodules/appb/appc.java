package com.wangmai.ad.dex.allmodules.appb;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: FadeinAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appc {

    /* renamed from: appa, reason: collision with root package name */
    private View f46709appa;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: FadeinAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa implements Animation.AnimationListener {
        appa() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            appc.this.appb();
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
    /* compiled from: FadeinAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements Runnable {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: FadeinAnimation.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa implements Animation.AnimationListener {
            appa() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                appc.this.appc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        appb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.2f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            alphaAnimation.setAnimationListener(new appa());
            appc.this.f46709appa.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: FadeinAnimation.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appb.appc$appc, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class RunnableC0678appc implements Runnable {
        RunnableC0678appc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            appc.this.f46709appa.startAnimation(alphaAnimation);
        }
    }

    public appc(View view) {
        this.f46709appa = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appb() {
        this.f46709appa.post(new appb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appc() {
        this.f46709appa.post(new RunnableC0678appc());
    }

    public void appa() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new appa());
        this.f46709appa.startAnimation(alphaAnimation);
    }
}
