package com.wangmai.ad.dex.allmodules.appb;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: EnlargementAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb {

    /* renamed from: appa, reason: collision with root package name */
    private View f46704appa;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: EnlargementAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa implements Animation.AnimationListener {
        appa() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            appb.this.appb();
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
    /* compiled from: EnlargementAnimation.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appb.appb$appb, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class RunnableC0677appb implements Runnable {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: EnlargementAnimation.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.appb.appb$appb$appa */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa implements Animation.AnimationListener {
            appa() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                appb.this.appc();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        RunnableC0677appb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.4f, 0.8f, 1.4f, 0.8f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setInterpolator(new AccelerateInterpolator());
            scaleAnimation.setAnimationListener(new appa());
            appb.this.f46704appa.startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: EnlargementAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements Runnable {
        appc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setInterpolator(new AccelerateInterpolator());
            appb.this.f46704appa.startAnimation(scaleAnimation);
        }
    }

    public appb(View view) {
        this.f46704appa = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appb() {
        this.f46704appa.post(new RunnableC0677appb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appc() {
        this.f46704appa.post(new appc());
    }

    public void appa() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setAnimationListener(new appa());
        this.f46704appa.startAnimation(scaleAnimation);
    }
}
