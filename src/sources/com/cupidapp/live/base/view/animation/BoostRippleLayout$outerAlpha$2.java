package com.cupidapp.live.base.view.animation;

import android.animation.PropertyValuesHolder;
import android.view.View;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: BoostRippleLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BoostRippleLayout$outerAlpha$2 extends Lambda implements Function0<PropertyValuesHolder> {
    public static final BoostRippleLayout$outerAlpha$2 INSTANCE = new BoostRippleLayout$outerAlpha$2();

    public BoostRippleLayout$outerAlpha$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PropertyValuesHolder invoke() {
        return PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f);
    }
}
