package com.cupidapp.live.base.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: CustomIndicator.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CustomIndicator extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f12432b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12433c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12434d;

    /* renamed from: e, reason: collision with root package name */
    public int f12435e;

    /* renamed from: f, reason: collision with root package name */
    public int f12436f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ValueAnimator f12437g;

    /* renamed from: h, reason: collision with root package name */
    public int f12438h;

    /* renamed from: i, reason: collision with root package name */
    public int f12439i;

    /* renamed from: j, reason: collision with root package name */
    public int f12440j;

    /* renamed from: k, reason: collision with root package name */
    public int f12441k;

    /* renamed from: l, reason: collision with root package name */
    public int f12442l;

    /* renamed from: m, reason: collision with root package name */
    public int f12443m;

    /* renamed from: n, reason: collision with root package name */
    public int f12444n;

    /* renamed from: o, reason: collision with root package name */
    public int f12445o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public LinearLayout f12446p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12447q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomIndicator(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12447q = new LinkedHashMap();
        this.f12433c = R$mipmap.selected_circle_bg;
        this.f12434d = R$mipmap.unselected_circle_bg;
        this.f12444n = 4;
        i(this, context, null, 2, null);
    }

    public static /* synthetic */ void d(CustomIndicator customIndicator, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        customIndicator.c(i10, z10, z11);
    }

    public static /* synthetic */ void f(CustomIndicator customIndicator, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        customIndicator.e(z10, z11);
    }

    public static /* synthetic */ void i(CustomIndicator customIndicator, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        customIndicator.h(context, attributeSet);
    }

    public static final void m(CustomIndicator this$0, ValueAnimator it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.f12438h = intValue;
        LinearLayout linearLayout = this$0.f12446p;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setTranslationX(-intValue);
    }

    public final void b(int i10) {
        d(this, this.f12445o, false, false, 6, null);
        d(this, i10, true, false, 4, null);
        this.f12445o = i10;
    }

    public final void c(int i10, boolean z10, boolean z11) {
        LinearLayout linearLayout = this.f12446p;
        View childAt = linearLayout != null ? linearLayout.getChildAt(i10) : null;
        kotlin.jvm.internal.s.g(childAt, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) childAt;
        imageView.setImageResource(z10 ? this.f12433c : this.f12434d);
        int i11 = z10 ? this.f12442l : this.f12443m;
        if (i11 != 0) {
            z0.o.b(imageView, i11);
        }
        int i12 = z11 ? this.f12440j : this.f12439i;
        y.n(imageView, Integer.valueOf(i12), Integer.valueOf(i12));
    }

    public final void e(boolean z10, boolean z11) {
        int i10 = z11 ? this.f12440j : this.f12439i;
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(z10 ? this.f12433c : this.f12434d);
        int i11 = z10 ? this.f12442l : this.f12443m;
        if (i11 != 0) {
            z0.o.b(imageView, i11);
        }
        LinearLayout linearLayout = this.f12446p;
        if (linearLayout != null) {
            linearLayout.addView(imageView, i10, i10);
        }
        y.l(imageView, Integer.valueOf(this.f12441k), 0, Integer.valueOf(this.f12441k), 0);
    }

    public final void g() {
        int i10;
        int i11;
        if (this.f12432b <= 1) {
            return;
        }
        this.f12445o = 0;
        this.f12435e = 0;
        this.f12436f = this.f12444n - 1;
        this.f12438h = 0;
        removeAllViews();
        int i12 = this.f12432b;
        int i13 = this.f12444n;
        if (i12 > i13) {
            int i14 = this.f12439i;
            int i15 = this.f12441k;
            i10 = ((i14 + (i15 * 2)) * (i13 - 1)) + this.f12440j + (i15 * 2);
        } else {
            i10 = -2;
        }
        y.o(this, Integer.valueOf(i10), null, 2, null);
        int i16 = this.f12432b;
        int i17 = this.f12444n;
        if (i16 > i17) {
            int i18 = this.f12439i;
            int i19 = this.f12441k;
            i11 = ((i18 + (i19 * 2)) * i17) + ((this.f12440j + (i19 * 2)) * (i16 - i17));
        } else {
            i11 = (this.f12439i + (this.f12441k * 2)) * i16;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(i11, -2));
        linearLayout.setGravity(16);
        this.f12446p = linearLayout;
        addView(linearLayout);
        int i20 = this.f12432b;
        for (int i21 = 0; i21 < i20; i21++) {
            if (i21 < this.f12444n - 1) {
                if (i21 == 0) {
                    f(this, true, false, 2, null);
                } else {
                    f(this, false, false, 3, null);
                }
            } else if (i21 == this.f12432b - 1) {
                f(this, false, false, 3, null);
            } else {
                f(this, false, true, 1, null);
            }
        }
    }

    public final int getPagerCount() {
        return this.f12432b;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CustomIndicator);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.CustomIndicator)");
        this.f12439i = obtainStyledAttributes.getDimensionPixelSize(3, z0.h.c(this, 4.0f));
        this.f12440j = obtainStyledAttributes.getDimensionPixelSize(5, z0.h.c(this, 3.0f));
        this.f12441k = obtainStyledAttributes.getDimensionPixelSize(1, z0.h.c(this, 2.5f));
        this.f12442l = obtainStyledAttributes.getColor(2, 0);
        this.f12443m = obtainStyledAttributes.getColor(0, 0);
        this.f12444n = obtainStyledAttributes.getInteger(4, 4);
        obtainStyledAttributes.recycle();
        g();
    }

    public final void j(int i10) {
        int i11 = this.f12435e;
        if (i10 == i11 && i11 > 0) {
            this.f12436f--;
            this.f12435e = i11 - 1;
            b(i10);
            d(this, this.f12436f, false, true, 2, null);
            l();
            return;
        }
        b(i10);
    }

    public final void k(int i10) {
        int i11 = this.f12436f;
        if (i10 == i11 && i11 < this.f12432b - 1) {
            this.f12436f = i11 + 1;
            this.f12435e++;
            b(i10);
            d(this, this.f12435e, false, true, 2, null);
            l();
            return;
        }
        b(i10);
    }

    public final void l() {
        ValueAnimator valueAnimator = this.f12437g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f12438h, (this.f12440j + (this.f12441k * 2)) * this.f12435e);
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.base.view.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CustomIndicator.m(CustomIndicator.this, valueAnimator2);
            }
        });
        this.f12437g = ofInt;
        ofInt.start();
    }

    public final void n(int i10) {
        if (this.f12432b > this.f12444n) {
            if (this.f12445o > i10) {
                j(i10);
                return;
            } else {
                k(i10);
                return;
            }
        }
        b(i10);
    }

    public final void setPagerCount(int i10) {
        this.f12432b = i10;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12447q = new LinkedHashMap();
        this.f12433c = R$mipmap.selected_circle_bg;
        this.f12434d = R$mipmap.unselected_circle_bg;
        this.f12444n = 4;
        h(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12447q = new LinkedHashMap();
        this.f12433c = R$mipmap.selected_circle_bg;
        this.f12434d = R$mipmap.unselected_circle_bg;
        this.f12444n = 4;
        h(context, attributeSet);
    }
}
