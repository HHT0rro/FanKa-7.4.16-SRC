package com.cupidapp.live.base.view.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKUniversalButton.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKUniversalButton extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    public int f12653b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12654c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKUniversalButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12654c = new LinkedHashMap();
        this.f12653b = h.c(this, 100.0f);
        e(this, context, null, 2, null);
    }

    public static /* synthetic */ Drawable c(FKUniversalButton fKUniversalButton, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = fKUniversalButton.f12653b;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        return fKUniversalButton.b(i10, i11, i12, i13);
    }

    public static /* synthetic */ void e(FKUniversalButton fKUniversalButton, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        fKUniversalButton.d(context, attributeSet);
    }

    public final void a(boolean z10) {
        if (z10) {
            setEnabled(true);
            setBackground(c(this, -49088, this.f12653b, 0, 0, 12, null));
        } else {
            setEnabled(false);
            setBackground(c(this, -2302756, this.f12653b, 0, 0, 12, null));
        }
    }

    @NotNull
    public final Drawable b(@ColorInt int i10, int i11, int i12, @ColorInt int i13) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(h.c(gradientDrawable, i11));
        gradientDrawable.setStroke(i12, i13);
        return gradientDrawable;
    }

    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKUniversalButton);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…leable.FKUniversalButton)");
        int color = obtainStyledAttributes.getColor(0, -49088);
        this.f12653b = obtainStyledAttributes.getDimensionPixelSize(1, this.f12653b);
        setBackground(b(color, this.f12653b, obtainStyledAttributes.getDimensionPixelSize(3, 0), obtainStyledAttributes.getColor(2, 0)));
        setTextColor(obtainStyledAttributes.getColor(4, -1));
        setTextSize(obtainStyledAttributes.getFloat(5, 16.0f));
        obtainStyledAttributes.recycle();
        getPaint().setFakeBoldText(true);
        setGravity(17);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            setMeasuredDimension(size, h.c(this, 52.0f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKUniversalButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12654c = new LinkedHashMap();
        this.f12653b = h.c(this, 100.0f);
        d(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKUniversalButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12654c = new LinkedHashMap();
        this.f12653b = h.c(this, 100.0f);
        d(context, attributeSet);
    }
}
