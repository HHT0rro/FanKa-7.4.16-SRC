package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class b extends KSFrameLayout {
    private Animator FQ;
    private boolean FR;

    public b(@NonNull Context context) {
        this(context, null, 0);
    }

    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        Animator animator = this.FQ;
        if (animator != null) {
            animator.cancel();
        }
    }

    public abstract int getAnimationDelayTime();

    public abstract View getInteractionView();

    public abstract void lR();

    public abstract Animator lS();

    public abstract void lT();

    public final void lU() {
        this.FR = true;
        Animator animator = this.FQ;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public final void lo() {
        Animator animator = this.FQ;
        if (animator != null) {
            animator.cancel();
            this.FQ = null;
        }
        Animator lS = lS();
        this.FQ = lS;
        if (lS != null) {
            lS.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    b.this.lT();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (b.this.FR) {
                        return;
                    }
                    b.this.getInteractionView().postDelayed(new ay() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            if (b.this.FQ != null) {
                                b.this.FQ.start();
                            }
                        }
                    }, b.this.getAnimationDelayTime());
                }
            });
            this.FQ.start();
        }
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.FR = false;
        a(context, attributeSet, i10);
        lR();
    }
}
