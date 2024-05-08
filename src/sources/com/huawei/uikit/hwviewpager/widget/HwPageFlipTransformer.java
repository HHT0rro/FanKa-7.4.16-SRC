package com.huawei.uikit.hwviewpager.widget;

import android.view.View;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwPageFlipTransformer implements HwViewPager.PageTransformer {

    /* renamed from: a, reason: collision with root package name */
    public HwViewPager f35299a;

    public HwPageFlipTransformer(HwViewPager hwViewPager) {
        this.f35299a = hwViewPager;
        hwViewPager.setAutoRtlLayoutEnabled(true);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.PageTransformer
    public void transformPage(View view, float f10) {
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        if (Float.compare(f10, -1.0f) >= 0 && Float.compare(f10, 1.0f) <= 0) {
            if ((Float.compare(f10, 0.0f) <= 0 && this.f35299a.getReverseDrawingOrder()) || (Float.compare(f10, 0.0f) > 0 && !this.f35299a.getReverseDrawingOrder())) {
                if (this.f35299a.isRtlLayout()) {
                    view.setTranslationX(width * f10);
                    return;
                } else {
                    view.setTranslationX(width * (-f10));
                    return;
                }
            }
            view.setTranslationX(0.0f);
            return;
        }
        view.setTranslationX(0.0f);
    }
}
