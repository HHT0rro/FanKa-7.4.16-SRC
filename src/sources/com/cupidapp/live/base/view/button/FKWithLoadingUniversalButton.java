package com.cupidapp.live.base.view.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.view.loading.CircularLoadingView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.z;

/* compiled from: FKWithLoadingUniversalButton.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKWithLoadingUniversalButton extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f12656b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12657c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWithLoadingUniversalButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12657c = new LinkedHashMap();
        this.f12656b = h.c(this, 100.0f);
        e(this, context, null, 2, null);
    }

    public static /* synthetic */ void e(FKWithLoadingUniversalButton fKWithLoadingUniversalButton, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        fKWithLoadingUniversalButton.d(context, attributeSet);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12657c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final Drawable b(@ColorInt int i10, int i11, int i12, @ColorInt int i13) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(h.c(gradientDrawable, i11));
        gradientDrawable.setStroke(i12, i13);
        return gradientDrawable;
    }

    public final void c() {
        int i10 = R$id.universal_btn_loading;
        ((CircularLoadingView) a(i10)).setVisibility(8);
        ((CircularLoadingView) a(i10)).f();
        ((TextView) a(R$id.universal_btn_text)).setVisibility(0);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        z.a(this, R$layout.layout_universal_button, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKWithLoadingUniversalButton);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…thLoadingUniversalButton)");
        int color = obtainStyledAttributes.getColor(0, -49088);
        this.f12656b = obtainStyledAttributes.getDimensionPixelSize(1, this.f12656b);
        ((ConstraintLayout) a(R$id.universal_btn_root_layout)).setBackground(b(color, this.f12656b, obtainStyledAttributes.getDimensionPixelSize(5, 0), obtainStyledAttributes.getColor(4, 0)));
        int i10 = R$id.universal_btn_text;
        ((TextView) a(i10)).setTextColor(obtainStyledAttributes.getColor(7, -1));
        ((TextView) a(i10)).setTextSize(obtainStyledAttributes.getFloat(8, 16.0f));
        ((TextView) a(i10)).setText(obtainStyledAttributes.getResourceId(6, R$string.complete));
        int i11 = R$id.universal_btn_loading;
        ((CircularLoadingView) a(i11)).setMLoadingColor(obtainStyledAttributes.getColor(2, -1));
        ((CircularLoadingView) a(i11)).setMLoadingStrokeWidth(obtainStyledAttributes.getDimension(3, h.c(this, 3.0f)));
        obtainStyledAttributes.recycle();
        TextView universal_btn_text = (TextView) a(i10);
        s.h(universal_btn_text, "universal_btn_text");
        u.a(universal_btn_text);
    }

    public final void f() {
        ((TextView) a(R$id.universal_btn_text)).setVisibility(8);
        int i10 = R$id.universal_btn_loading;
        ((CircularLoadingView) a(i10)).setVisibility(0);
        ((CircularLoadingView) a(i10)).h();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            setMeasuredDimension(size, h.c(this, 52.0f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWithLoadingUniversalButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12657c = new LinkedHashMap();
        this.f12656b = h.c(this, 100.0f);
        d(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWithLoadingUniversalButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12657c = new LinkedHashMap();
        this.f12656b = h.c(this, 100.0f);
        d(context, attributeSet);
    }
}
