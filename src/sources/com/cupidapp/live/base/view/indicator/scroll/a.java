package com.cupidapp.live.base.view.indicator.scroll;

import com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractViewPagerAttacher.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class a<T> implements ScrollingPagerIndicator.a<T> {
    public final void c(@NotNull ScrollingPagerIndicator indicator, int i10, float f10) {
        s.i(indicator, "indicator");
        if (f10 < 0.0f) {
            f10 = 0.0f;
        } else if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        indicator.p(i10, f10);
    }
}
