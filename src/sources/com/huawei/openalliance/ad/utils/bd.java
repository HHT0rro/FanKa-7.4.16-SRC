package com.huawei.openalliance.ad.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bd {
    private static final int Code = 300;

    public static void Code(ViewGroup viewGroup) {
        boolean z10;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 < childCount) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt != null && childAt.getVisibility() == 0) {
                    z10 = true;
                    break;
                }
                i11++;
            } else {
                z10 = false;
                break;
            }
        }
        if (!z10 || viewGroup.getVisibility() == 0) {
            if (z10) {
                return;
            }
            i10 = 8;
            if (viewGroup.getVisibility() == 8) {
                return;
            }
        }
        viewGroup.setVisibility(i10);
    }

    public static boolean Code(View view, int i10) {
        return Code(view, i10, 300, 0);
    }

    public static boolean Code(View view, int i10, int i11, int i12) {
        if (view == null || view.getVisibility() == i10) {
            return false;
        }
        view.setVisibility(i10);
        boolean z10 = i10 == 0;
        float f10 = z10 ? 0.0f : 1.0f;
        float f11 = z10 ? 1.0f : 0.0f;
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f10, f11);
        alphaAnimation.setDuration(i11);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        if (i12 > 0) {
            alphaAnimation.setStartOffset(i12);
        }
        view.startAnimation(alphaAnimation);
        return true;
    }

    public static boolean Code(View view, boolean z10) {
        int i10 = z10 ? 0 : 8;
        if (view == null || view.getVisibility() == i10) {
            return false;
        }
        view.setVisibility(i10);
        return true;
    }
}
