package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {
    private float iY;

    @SlideType
    private int iZ;
    private Map<Integer, com.kwad.components.ad.interstitial.g.c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    private void a(View view, View view2, float f10) {
        if (this.iZ == 0 && f10 != 0.0f) {
            float f11 = this.iY;
            if (f11 != 0.0f) {
                if (f10 > f11) {
                    this.iZ = 1;
                } else {
                    this.iZ = 2;
                }
            }
        }
        if (this.iZ == 1 && view2 != null) {
            if (f10 <= 0.5d && f10 > 0.0f) {
                view2.setTranslationX(240.0f * f10);
            } else {
                view2.setTranslationX((1.0f - f10) * 240.0f);
            }
        }
        if (this.iZ == 2 && view != null) {
            if (f10 <= 0.5d && f10 >= 0.0f) {
                view.setTranslationX((-240.0f) * f10);
            } else {
                view.setTranslationX((1.0f - f10) * (-240.0f));
            }
        }
        this.iY = f10;
        if (f10 == 0.0f) {
            this.iZ = 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i10, float f10, int i11) {
        a(y(i10), y(i10 + 1), f10);
        super.onPageScrolled(i10, f10, i11);
    }

    public final com.kwad.components.ad.interstitial.g.c y(int i10) {
        return this.map.get(Integer.valueOf(i10));
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.iZ = 0;
    }

    public final void a(int i10, com.kwad.components.ad.interstitial.g.c cVar) {
        this.map.put(Integer.valueOf(i10), cVar);
    }
}
