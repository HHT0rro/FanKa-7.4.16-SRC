package com.huawei.flexiblelayout;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: AnimationUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class q {
    public static AnimatorSet a(float f10, int i10, View... viewArr) {
        if (viewArr == null || viewArr.length == 0) {
            return null;
        }
        return a(new float[]{f10, 1.0f}, i10, viewArr);
    }

    public static AnimatorSet b(float f10, int i10, View... viewArr) {
        if (viewArr == null || viewArr.length == 0) {
            return null;
        }
        return a(new float[]{1.0f, f10}, i10, viewArr);
    }

    private static AnimatorSet a(float[] fArr, int i10, View... viewArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        for (View view : viewArr) {
            if (view != null) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", fArr), ObjectAnimator.ofFloat(view, "scaleY", fArr));
            }
        }
        animatorSet.setDuration(i10).start();
        return animatorSet;
    }
}
