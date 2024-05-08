package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKItemCheckLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKItemCheckLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12492b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemCheckLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12492b = new LinkedHashMap();
        d(this, null, 1, null);
    }

    public static /* synthetic */ void d(FKItemCheckLayout fKItemCheckLayout, AttributeSet attributeSet, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initView");
        }
        if ((i10 & 1) != 0) {
            attributeSet = null;
        }
        fKItemCheckLayout.c(attributeSet);
    }

    public static final void e(Function1 listener, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.s.i(listener, "$listener");
        if (compoundButton.isPressed()) {
            listener.invoke(Boolean.valueOf(z10));
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f12492b;
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

    public final void c(@Nullable AttributeSet attributeSet) {
        z.a(this, R$layout.layout_fk_item_switch_big_icon, true);
        Context context = getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.FKItemCheckLayout) : null;
        if (obtainStyledAttributes == null) {
            return;
        }
        int i10 = R$id.titleTextView;
        ((TextView) b(i10)).setText(obtainStyledAttributes.getString(2));
        ((TextView) b(i10)).getPaint().setFakeBoldText(obtainStyledAttributes.getBoolean(3, true));
        String string = obtainStyledAttributes.getString(0);
        if (!(string == null || string.length() == 0)) {
            int i11 = R$id.contentTextView;
            ((TextView) b(i11)).setText(string);
            ((TextView) b(i11)).setVisibility(0);
            ((ConstraintLayout) b(R$id.rootLayout)).getLayoutParams().height = -2;
        }
        ((TextView) b(R$id.contentTextView)).getPaint().setFakeBoldText(obtainStyledAttributes.getBoolean(1, true));
        ((TextView) b(i10)).setTextColor(obtainStyledAttributes.getColor(4, -15066598));
        obtainStyledAttributes.recycle();
    }

    public final void f() {
        ImageView imageView = (ImageView) b(R$id.text_vip_promotion);
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    public final void setChecked(boolean z10) {
        ((CheckBox) b(R$id.switchButton)).setChecked(z10);
    }

    public final void setItemSwitchClickable(boolean z10) {
        ((CheckBox) b(R$id.switchButton)).setEnabled(z10);
    }

    public final void setOnCheckedChangeListener(@NotNull final Function1<? super Boolean, kotlin.p> listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        ((CheckBox) b(R$id.switchButton)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.base.view.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FKItemCheckLayout.e(Function1.this, compoundButton, z10);
            }
        });
    }

    public final void setTitleDrawableEnd(@Nullable Integer num) {
        int i10 = R$id.titleTextView;
        ((TextView) b(i10)).setCompoundDrawablesWithIntrinsicBounds(0, 0, num != null ? num.intValue() : 0, 0);
        ((TextView) b(i10)).setCompoundDrawablePadding(z0.h.c(this, 6.0f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemCheckLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12492b = new LinkedHashMap();
        c(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemCheckLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12492b = new LinkedHashMap();
        c(attributeSet);
    }
}
