package com.cupidapp.live.chat.transformer;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatRecommendPageTransformer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatRecommendPageTransformer implements ViewPager2.PageTransformer {
    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NotNull View page, float f10) {
        s.i(page, "page");
        if (f10 < -1.0f) {
            page.setAlpha(0.0f);
            return;
        }
        if (f10 <= 0.0f) {
            page.setAlpha(1 + f10);
            page.setPivotX(page.getWidth() * 0.5f);
            page.setPivotY(page.getHeight());
            page.setRotation(15 * f10);
            return;
        }
        if (f10 <= 1.0f) {
            float f11 = 1 - f10;
            page.setAlpha(f11);
            page.setPivotX(page.getWidth() * 0.5f);
            page.setPivotY(page.getHeight());
            float f12 = (f11 * 0.1f) + 0.9f;
            page.setScaleX(f12);
            page.setScaleY(f12);
            page.setTranslationX((-f10) * page.getWidth());
            return;
        }
        page.setAlpha(0.0f);
    }
}
