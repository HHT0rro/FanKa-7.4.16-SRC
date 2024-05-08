package com.cupidapp.live.match.view;

import android.view.animation.LinearInterpolator;

/* compiled from: FKSwipeCardView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i extends LinearInterpolator {
    @Override // android.view.animation.LinearInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return f10 * 4;
    }
}
