package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKItemSingleChoiceLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKItemSingleChoiceLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Boolean f12511b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12512c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemSingleChoiceLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12512c = new LinkedHashMap();
        d(this, null, 1, null);
    }

    public static /* synthetic */ void d(FKItemSingleChoiceLayout fKItemSingleChoiceLayout, AttributeSet attributeSet, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initView");
        }
        if ((i10 & 1) != 0) {
            attributeSet = null;
        }
        fKItemSingleChoiceLayout.c(attributeSet);
    }

    public static final void e(Function1 listener, CompoundButton compoundButton, boolean z10) {
        kotlin.jvm.internal.s.i(listener, "$listener");
        if (compoundButton.isPressed()) {
            listener.invoke(Boolean.valueOf(z10));
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f12512c;
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
        boolean z10 = true;
        z.a(this, R$layout.layout_fk_item_single_choice, true);
        Context context = getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.FKItemSingleChoiceLayout) : null;
        if (obtainStyledAttributes == null) {
            return;
        }
        int i10 = R$id.titleTextView;
        ((TextView) b(i10)).setText(obtainStyledAttributes.getString(3));
        ((TextView) b(i10)).getPaint().setFakeBoldText(obtainStyledAttributes.getBoolean(4, true));
        String string = obtainStyledAttributes.getString(1);
        if (!(string == null || string.length() == 0)) {
            int i11 = R$id.subTitleTextView;
            ((TextView) b(i11)).setVisibility(0);
            ((TextView) b(i11)).setText(string);
        }
        String string2 = obtainStyledAttributes.getString(2);
        if (string2 != null && string2.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            int i12 = R$id.contentTextView;
            ((TextView) b(i12)).setText(string2);
            ((TextView) b(i12)).setVisibility(0);
            ((RelativeLayout) b(R$id.rootLayout)).getLayoutParams().height = -2;
        }
        setHasBottomLine(Boolean.valueOf(obtainStyledAttributes.getBoolean(0, false)));
        obtainStyledAttributes.recycle();
    }

    @Nullable
    public final Boolean getHasBottomLine() {
        return this.f12511b;
    }

    public final void setCheckboxClickable(boolean z10) {
        ((CheckBox) b(R$id.singleChoiceButton)).setClickable(z10);
    }

    public final void setChecked(boolean z10) {
        ((CheckBox) b(R$id.singleChoiceButton)).setChecked(z10);
    }

    public final void setHasBottomLine(@Nullable Boolean bool) {
        this.f12511b = bool;
        b(R$id.bottomLineView).setVisibility(kotlin.jvm.internal.s.d(bool, Boolean.TRUE) ? 0 : 4);
    }

    public final void setItemFirstContent(@Nullable String str) {
        if (str == null || str.length() == 0) {
            ((TextView) b(R$id.subTitleTextView)).setVisibility(8);
            return;
        }
        int i10 = R$id.subTitleTextView;
        ((TextView) b(i10)).setVisibility(0);
        ((TextView) b(i10)).setText(str);
    }

    public final void setOnCheckedChangeListener(@NotNull final Function1<? super Boolean, kotlin.p> listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        ((CheckBox) b(R$id.singleChoiceButton)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.base.view.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FKItemSingleChoiceLayout.e(Function1.this, compoundButton, z10);
            }
        });
    }

    public final void setSecondContent(@Nullable String str) {
        if (str == null || str.length() == 0) {
            ((TextView) b(R$id.contentTextView)).setVisibility(8);
            return;
        }
        int i10 = R$id.contentTextView;
        ((TextView) b(i10)).setVisibility(0);
        ((TextView) b(i10)).setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemSingleChoiceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12512c = new LinkedHashMap();
        c(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemSingleChoiceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12512c = new LinkedHashMap();
        c(attributeSet);
    }
}
