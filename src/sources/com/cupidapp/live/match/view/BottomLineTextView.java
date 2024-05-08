package com.cupidapp.live.match.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BottomLineTextView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BottomLineTextView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f16840b;

    /* renamed from: c, reason: collision with root package name */
    public int f16841c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f16842d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16843e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16844f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16845g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomLineTextView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16845g = new LinkedHashMap();
        this.f16840b = -65536;
        this.f16841c = -7829368;
        this.f16843e = true;
        b(context, null);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16845g;
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

    public final void b(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        z0.z.a(this, R$layout.layout_bottom_line_text, true);
        if (context != null && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomLineTextView);
            kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr…eable.BottomLineTextView)");
            this.f16840b = obtainStyledAttributes.getColor(1, -15066598);
            this.f16841c = obtainStyledAttributes.getColor(2, com.cupidapp.live.base.utils.h.a(-15066598, 0.3f));
            setText(obtainStyledAttributes.getString(0));
            obtainStyledAttributes.recycle();
        }
        int i10 = R$id.tabTextView;
        ((TextView) a(i10)).getPaint().setFakeBoldText(true);
        ((TextView) a(i10)).setText(this.f16842d);
        ((TextView) a(i10)).setTextColor(this.f16840b);
    }

    public final int getCheckedColor() {
        return this.f16840b;
    }

    @Nullable
    public final String getText() {
        return this.f16842d;
    }

    public final int getUncheckedColor() {
        return this.f16841c;
    }

    public final boolean getUnderLineEnable() {
        return this.f16843e;
    }

    public final void setChecked(boolean z10) {
        this.f16844f = z10;
        a(R$id.underLineView).setVisibility((z10 && this.f16843e) ? 0 : 4);
        ((TextView) a(R$id.tabTextView)).setTextColor(z10 ? this.f16840b : this.f16841c);
    }

    public final void setCheckedColor(int i10) {
        this.f16840b = i10;
    }

    public final void setText(@Nullable String str) {
        this.f16842d = str;
        ((TextView) a(R$id.tabTextView)).setText(str);
    }

    public final void setUncheckedColor(int i10) {
        this.f16841c = i10;
    }

    public final void setUnderLineEnable(boolean z10) {
        this.f16843e = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomLineTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16845g = new LinkedHashMap();
        this.f16840b = -65536;
        this.f16841c = -7829368;
        this.f16843e = true;
        b(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomLineTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16845g = new LinkedHashMap();
        this.f16840b = -65536;
        this.f16841c = -7829368;
        this.f16843e = true;
        b(context, attributeSet);
    }
}
