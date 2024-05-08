package com.cupidapp.live.base.view.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: TopIndicatorLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TopIndicatorLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f12792b;

    /* renamed from: c, reason: collision with root package name */
    public int f12793c;

    /* renamed from: d, reason: collision with root package name */
    public int f12794d;

    /* renamed from: e, reason: collision with root package name */
    public int f12795e;

    /* renamed from: f, reason: collision with root package name */
    public int f12796f;

    /* renamed from: g, reason: collision with root package name */
    public int f12797g;

    /* renamed from: h, reason: collision with root package name */
    public int f12798h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12799i = new LinkedHashMap();

    public TopIndicatorLayout(@Nullable Context context) {
        super(context);
        this.f12797g = R$drawable.top_indicator_w;
        this.f12798h = R$drawable.top_indicator_g;
        d(this, context, null, 2, null);
    }

    public static /* synthetic */ void d(TopIndicatorLayout topIndicatorLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        topIndicatorLayout.c(context, attributeSet);
    }

    public final void a() {
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ImageView) {
                ((ImageView) childAt).setImageResource(i10 == this.f12793c ? this.f12797g : this.f12798h);
            }
            i10++;
        }
    }

    public final void b() {
        removeAllViews();
        int i10 = this.f12792b;
        if (i10 > 1) {
            int i11 = 0;
            while (i11 < i10) {
                ImageView imageView = new ImageView(getContext());
                int i12 = this.f12796f;
                int i13 = this.f12795e;
                int i14 = this.f12792b;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((i12 - (i13 * i14)) / i14, this.f12794d);
                layoutParams.setMarginStart(this.f12795e / 2);
                layoutParams.setMarginEnd(this.f12795e / 2);
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(i11 == this.f12793c ? this.f12797g : this.f12798h);
                addView(imageView);
                i11++;
            }
        }
        requestLayout();
        invalidate();
    }

    public final void c(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        int c4;
        int c10;
        int i10;
        int c11;
        int c12;
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.TopIndicatorLayout) : null;
        if (obtainStyledAttributes != null) {
            c4 = obtainStyledAttributes.getDimensionPixelSize(4, h.c(this, 2.0f));
        } else {
            c4 = h.c(this, 2.0f);
        }
        this.f12794d = c4;
        if (obtainStyledAttributes != null) {
            c10 = obtainStyledAttributes.getDimensionPixelSize(1, h.c(this, 3.0f));
        } else {
            c10 = h.c(this, 3.0f);
        }
        this.f12795e = c10;
        if (obtainStyledAttributes != null) {
            i10 = obtainStyledAttributes.getResourceId(3, this.f12797g);
        } else {
            i10 = this.f12797g;
        }
        this.f12797g = i10;
        this.f12798h = obtainStyledAttributes != null ? obtainStyledAttributes.getResourceId(2, this.f12798h) : this.f12798h;
        if (obtainStyledAttributes != null) {
            c11 = obtainStyledAttributes.getDimensionPixelSize(5, h.c(this, 23.0f));
        } else {
            c11 = h.c(this, 23.0f);
        }
        if (obtainStyledAttributes != null) {
            c12 = obtainStyledAttributes.getDimensionPixelSize(0, h.c(this, 23.0f));
        } else {
            c12 = h.c(this, 23.0f);
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.f12796f = (h.l(this) - c11) - c12;
        b();
    }

    public final int getCurrentPager() {
        return this.f12793c;
    }

    public final int getPagerCount() {
        return this.f12792b;
    }

    public final void setCurrentPager(int i10) {
        this.f12793c = i10;
        a();
    }

    public final void setPagerCount(int i10) {
        this.f12792b = i10;
        b();
    }

    public TopIndicatorLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12797g = R$drawable.top_indicator_w;
        this.f12798h = R$drawable.top_indicator_g;
        c(context, attributeSet);
    }

    public TopIndicatorLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12797g = R$drawable.top_indicator_w;
        this.f12798h = R$drawable.top_indicator_g;
        c(context, attributeSet);
    }
}
