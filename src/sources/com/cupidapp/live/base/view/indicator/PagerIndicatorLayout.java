package com.cupidapp.live.base.view.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.o;

/* compiled from: PagerIndicatorLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PagerIndicatorLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f12783b;

    /* renamed from: c, reason: collision with root package name */
    public int f12784c;

    /* renamed from: d, reason: collision with root package name */
    public int f12785d;

    /* renamed from: e, reason: collision with root package name */
    public int f12786e;

    /* renamed from: f, reason: collision with root package name */
    public int f12787f;

    /* renamed from: g, reason: collision with root package name */
    public int f12788g;

    /* renamed from: h, reason: collision with root package name */
    public int f12789h;

    /* renamed from: i, reason: collision with root package name */
    public int f12790i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12791j = new LinkedHashMap();

    public PagerIndicatorLayout(@Nullable Context context) {
        super(context);
        this.f12787f = R$mipmap.page_dot_white;
        this.f12788g = R$mipmap.page_dot_gray;
        d(this, context, null, 2, null);
    }

    public static /* synthetic */ void d(PagerIndicatorLayout pagerIndicatorLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        pagerIndicatorLayout.c(context, attributeSet);
    }

    public final void a() {
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ImageView) {
                boolean z10 = i10 == this.f12784c;
                ImageView imageView = (ImageView) childAt;
                imageView.setImageResource(z10 ? this.f12787f : this.f12788g);
                int i11 = z10 ? this.f12789h : this.f12790i;
                if (i11 != 0) {
                    o.b(imageView, i11);
                }
            }
            i10++;
        }
    }

    public final void b() {
        removeAllViews();
        int i10 = this.f12783b;
        if (i10 > 1) {
            int i11 = 0;
            while (i11 < i10) {
                ImageView imageView = new ImageView(getContext());
                int i12 = this.f12785d;
                int i13 = this.f12786e;
                imageView.setLayoutParams(new LinearLayout.LayoutParams((i13 * 2) + i12, i12 + (i13 * 2)));
                int i14 = this.f12786e;
                imageView.setPadding(i14, i14, i14, i14);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                boolean z10 = i11 == this.f12784c;
                imageView.setImageResource(z10 ? this.f12787f : this.f12788g);
                int i15 = z10 ? this.f12789h : this.f12790i;
                if (i15 != 0) {
                    o.b(imageView, i15);
                }
                addView(imageView);
                i11++;
            }
        }
        setGravity(17);
        requestLayout();
        invalidate();
    }

    public final void c(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        int c4;
        int c10;
        int i10;
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.PagerIndicatorLayout) : null;
        if (obtainStyledAttributes != null) {
            c4 = obtainStyledAttributes.getDimensionPixelSize(5, h.c(this, 6.0f));
        } else {
            c4 = h.c(this, 6.0f);
        }
        this.f12785d = c4;
        if (obtainStyledAttributes != null) {
            c10 = obtainStyledAttributes.getDimensionPixelSize(1, h.c(this, 3.0f));
        } else {
            c10 = h.c(this, 3.0f);
        }
        this.f12786e = c10;
        if (obtainStyledAttributes != null) {
            i10 = obtainStyledAttributes.getResourceId(4, this.f12787f);
        } else {
            i10 = this.f12787f;
        }
        this.f12787f = i10;
        this.f12788g = obtainStyledAttributes != null ? obtainStyledAttributes.getResourceId(2, this.f12788g) : this.f12788g;
        this.f12789h = obtainStyledAttributes != null ? obtainStyledAttributes.getColor(3, 0) : 0;
        this.f12790i = obtainStyledAttributes != null ? obtainStyledAttributes.getColor(0, 0) : 0;
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        b();
    }

    public final int getColor() {
        return this.f12790i;
    }

    public final int getCurrentPager() {
        return this.f12784c;
    }

    public final int getPagerCount() {
        return this.f12783b;
    }

    public final int getSelectedColor() {
        return this.f12789h;
    }

    public final void setColor(int i10) {
        this.f12790i = i10;
    }

    public final void setCurrentPager(int i10) {
        this.f12784c = i10;
        a();
    }

    public final void setPagerCount(int i10) {
        this.f12783b = i10;
        b();
    }

    public final void setSelectedColor(int i10) {
        this.f12789h = i10;
    }

    public PagerIndicatorLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12787f = R$mipmap.page_dot_white;
        this.f12788g = R$mipmap.page_dot_gray;
        c(context, attributeSet);
    }

    public PagerIndicatorLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12787f = R$mipmap.page_dot_white;
        this.f12788g = R$mipmap.page_dot_gray;
        c(context, attributeSet);
    }
}
