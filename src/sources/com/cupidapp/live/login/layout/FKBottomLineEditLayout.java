package com.cupidapp.live.login.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKBottomLineEditLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKBottomLineEditLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f16165b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f16166c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Integer f16167d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Integer f16168e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Integer f16169f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16170g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Function0<p> f16171h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16172i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBottomLineEditLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16172i = new LinkedHashMap();
        g();
    }

    public static final void e(FKBottomLineEditLayout this$0, View view, boolean z10) {
        s.i(this$0, "this$0");
        if (z10) {
            this$0.f16170g = false;
        }
    }

    public static final boolean f(FKBottomLineEditLayout this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        if (1 == motionEvent.getAction() && !this$0.f16170g) {
            Function0<p> function0 = this$0.f16171h;
            if (function0 != null) {
                function0.invoke();
            }
            this$0.f16170g = true;
        }
        int i10 = R$id.bottomLineEditText;
        ((EditText) this$0.c(i10)).requestFocus();
        Context context = this$0.getContext();
        s.h(context, "context");
        EditText bottomLineEditText = (EditText) this$0.c(i10);
        s.h(bottomLineEditText, "bottomLineEditText");
        h.v(context, bottomLineEditText);
        return false;
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f16172i;
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

    public final void d(@Nullable AttributeSet attributeSet) {
        Context context = getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.FKBottomLineEditLayout) : null;
        g();
        setSetText(obtainStyledAttributes != null ? obtainStyledAttributes.getString(4) : null);
        setHint(obtainStyledAttributes != null ? obtainStyledAttributes.getString(0) : null);
        setInputType(obtainStyledAttributes != null ? Integer.valueOf(obtainStyledAttributes.getInteger(1, 1)) : null);
        setSelection(obtainStyledAttributes != null ? Integer.valueOf(obtainStyledAttributes.getInteger(3, 0)) : null);
        setMaxLength(obtainStyledAttributes != null ? Integer.valueOf(obtainStyledAttributes.getInteger(2, Integer.MAX_VALUE)) : null);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        int i10 = R$id.bottomLineEditText;
        ((EditText) c(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.cupidapp.live.login.layout.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                FKBottomLineEditLayout.e(FKBottomLineEditLayout.this, view, z10);
            }
        });
        ((EditText) c(i10)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.login.layout.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f10;
                f10 = FKBottomLineEditLayout.f(FKBottomLineEditLayout.this, view, motionEvent);
                return f10;
            }
        });
    }

    public final void g() {
        z.a(this, R$layout.layout_bottom_line_edit_text, true);
    }

    @Nullable
    public final Function0<p> getEditTextClickListener() {
        return this.f16171h;
    }

    @NotNull
    public final String getGetText() {
        return ((EditText) c(R$id.bottomLineEditText)).getText().toString();
    }

    @Nullable
    public final String getHint() {
        return this.f16166c;
    }

    @Nullable
    public final Integer getInputType() {
        return this.f16167d;
    }

    @Nullable
    public final Integer getMaxLength() {
        return this.f16169f;
    }

    @Nullable
    public final Integer getSelection() {
        return this.f16168e;
    }

    @Nullable
    public final String getSetText() {
        return this.f16165b;
    }

    public final void setEditTextClickListener(@Nullable Function0<p> function0) {
        this.f16171h = function0;
    }

    public final void setHint(@Nullable String str) {
        this.f16166c = str;
        ((EditText) c(R$id.bottomLineEditText)).setHint(str);
    }

    public final void setInputType(@Nullable Integer num) {
        this.f16167d = num;
        if (num != null) {
            num.intValue();
            ((EditText) c(R$id.bottomLineEditText)).setInputType(num.intValue());
        }
    }

    public final void setMaxLength(@Nullable Integer num) {
        this.f16169f = num;
        if (num != null) {
            num.intValue();
            ((EditText) c(R$id.bottomLineEditText)).setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(num.intValue())});
        }
    }

    public final void setSelection(@Nullable Integer num) {
        this.f16168e = num;
        if (num != null) {
            num.intValue();
            ((EditText) c(R$id.bottomLineEditText)).setSelection(num.intValue());
        }
    }

    public final void setSetText(@Nullable String str) {
        this.f16165b = str;
        if (str != null) {
            ((EditText) c(R$id.bottomLineEditText)).setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBottomLineEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16172i = new LinkedHashMap();
        d(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBottomLineEditLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16172i = new LinkedHashMap();
        d(attributeSet);
    }
}
