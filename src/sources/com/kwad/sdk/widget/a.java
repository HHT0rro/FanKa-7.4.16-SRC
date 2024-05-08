package com.kwad.sdk.widget;

import android.animation.ValueAnimator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public static ValueAnimator ofArgb(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        valueAnimator.setEvaluator(b.NR());
        return valueAnimator;
    }
}
