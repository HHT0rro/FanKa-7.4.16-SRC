package com.huawei.uikit.hwviewpager.widget;

import android.view.animation.Interpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float f11 = f10 - 1.0f;
        return (f11 * f11 * f11 * f11 * f11) + 1.0f;
    }
}
