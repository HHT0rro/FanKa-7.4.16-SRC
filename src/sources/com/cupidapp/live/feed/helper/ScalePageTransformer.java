package com.cupidapp.live.feed.helper;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScalePageTransformer.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ScalePageTransformer implements ViewPager2.PageTransformer {
    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NotNull View page, float f10) {
        s.i(page, "page");
        float abs = Math.abs(f10);
        float f11 = abs > 1.0f ? 0.0f : 1 - (abs / 5);
        page.setScaleX(f11);
        page.setScaleY(f11);
    }
}
