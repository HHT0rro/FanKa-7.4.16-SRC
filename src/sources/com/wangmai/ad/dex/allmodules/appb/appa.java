package com.wangmai.ad.dex.allmodules.appb;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.wangmai.ad.dex.allmodules.appb.appd;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AnimationManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AnimationManager.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appb.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class AnimationAnimationListenerC0675appa implements Animation.AnimationListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ View f46702appa;
        final /* synthetic */ float appb;
        final /* synthetic */ float appc;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: AnimationManager.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.appb.appa$appa$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class RunnableC0676appa implements Runnable {
            RunnableC0676appa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimationAnimationListenerC0675appa animationAnimationListenerC0675appa = AnimationAnimationListenerC0675appa.this;
                appe appeVar = new appe(-90.0f, 0.0f, animationAnimationListenerC0675appa.appb, animationAnimationListenerC0675appa.appc, 310.0f, false);
                appeVar.setDuration(450L);
                appeVar.setFillAfter(true);
                appeVar.setInterpolator(new DecelerateInterpolator());
                AnimationAnimationListenerC0675appa.this.f46702appa.startAnimation(appeVar);
            }
        }

        AnimationAnimationListenerC0675appa(View view, float f10, float f11) {
            this.f46702appa = view;
            this.appb = f10;
            this.appc = f11;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f46702appa.post(new RunnableC0676appa());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static void appa(View view, int i10) {
        try {
            if (i10 == 1) {
                appd(view);
            } else if (i10 == 2) {
                appe(view);
            } else if (i10 == 3) {
                appc(view);
            } else {
                if (i10 != 4) {
                    if (i10 == 5) {
                        appa(view);
                    }
                }
                appb(view);
            }
        } catch (Exception unused) {
        }
    }

    static void appb(View view) {
        try {
            new appc(view).appa();
        } catch (Exception unused) {
        }
    }

    static void appc(View view) {
        try {
            appd.appb appbVar = appd.appb.EVertical;
            int[] iArr = new int[6];
            iArr[0] = -(view.getHeight() != 0 ? view.getHeight() : (int) ((view.getContext().getResources().getDisplayMetrics().widthPixels * 3.0f) / 20.0f));
            iArr[1] = 40;
            iArr[2] = -30;
            iArr[3] = 20;
            iArr[4] = -10;
            iArr[5] = 0;
            appd appdVar = new appd(appbVar, iArr);
            appdVar.setDuration(1000L);
            appdVar.setFillAfter(true);
            appdVar.setInterpolator(new AccelerateInterpolator());
            view.startAnimation(appdVar);
        } catch (Exception unused) {
        }
    }

    static void appd(View view) {
        try {
            float width = (view.getWidth() != 0 ? view.getWidth() : view.getContext().getResources().getDisplayMetrics().widthPixels) / 2.0f;
            float height = view.getHeight() / 2.0f;
            appe appeVar = new appe(0.0f, 90.0f, width, height, 310.0f, true);
            appeVar.setDuration(450L);
            appeVar.setFillAfter(true);
            appeVar.setInterpolator(new AccelerateInterpolator());
            appeVar.setAnimationListener(new AnimationAnimationListenerC0675appa(view, width, height));
            view.startAnimation(appeVar);
        } catch (Exception unused) {
        }
    }

    static void appe(View view) {
        try {
            appd.appb appbVar = appd.appb.EHorizontal;
            int[] iArr = new int[6];
            iArr[0] = view.getWidth() != 0 ? view.getWidth() : view.getContext().getResources().getDisplayMetrics().widthPixels;
            iArr[1] = -60;
            iArr[2] = 50;
            iArr[3] = -40;
            iArr[4] = 30;
            iArr[5] = 0;
            appd appdVar = new appd(appbVar, iArr);
            appdVar.setDuration(1000L);
            appdVar.setFillAfter(true);
            appdVar.setInterpolator(new AccelerateInterpolator());
            view.startAnimation(appdVar);
        } catch (Exception unused) {
        }
    }

    static void appa(View view) {
        try {
            new appb(view).appa();
        } catch (Exception unused) {
        }
    }
}
