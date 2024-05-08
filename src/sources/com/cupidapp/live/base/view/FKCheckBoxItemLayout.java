package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKCheckBoxItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKCheckBoxItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f12459b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Boolean f12460c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12461d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12462e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKCheckBoxItemLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12462e = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12462e;
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

    public final void b(@Nullable AttributeSet attributeSet) {
        Context context = getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.FKCheckBoxItemLayout) : null;
        c();
        setTitleTextValue(obtainStyledAttributes != null ? obtainStyledAttributes.getString(1) : null);
        setBottomLineValue(obtainStyledAttributes != null ? Boolean.valueOf(obtainStyledAttributes.getBoolean(0, false)) : null);
        setChecked(obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(2, false) : false);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
    }

    public final void c() {
        z.a(this, R$layout.layout_checkbox_item, true);
    }

    @Nullable
    public final Boolean getBottomLineValue() {
        return this.f12460c;
    }

    @Nullable
    public final String getTitleTextValue() {
        return this.f12459b;
    }

    public final void setBottomLineValue(@Nullable Boolean bool) {
        this.f12460c = bool;
        a(R$id.itemLineView).setVisibility(kotlin.jvm.internal.s.d(bool, Boolean.TRUE) ? 0 : 4);
    }

    public final void setChecked(boolean z10) {
        this.f12461d = z10;
        ((ImageView) a(R$id.checkImageView)).setVisibility(z10 ? 0 : 4);
    }

    public final void setTitleTextValue(@Nullable String str) {
        this.f12459b = str;
        int i10 = R$id.contentTextView;
        ((TextView) a(i10)).getPaint().setFakeBoldText(true);
        ((TextView) a(i10)).setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKCheckBoxItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12462e = new LinkedHashMap();
        b(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKCheckBoxItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12462e = new LinkedHashMap();
        b(attributeSet);
    }
}
