package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import com.huawei.quickcard.views.image.processor.AltAttribute;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKItemLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Integer f12493b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f12494c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Boolean f12495d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Boolean f12496e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Integer f12497f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Integer f12498g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f12499h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f12500i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Boolean f12501j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public Boolean f12502k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Boolean f12503l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public Boolean f12504m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public Integer f12505n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public Integer f12506o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public Integer f12507p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public Integer f12508q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public Integer f12509r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12510s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12510s = new LinkedHashMap();
        this.f12506o = 0;
        b();
    }

    public static /* synthetic */ void setContentTextMargin$default(FKItemLayout fKItemLayout, Integer num, Integer num2, Integer num3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        if ((i10 & 8) != 0) {
            num4 = null;
        }
        fKItemLayout.setContentTextMargin(num, num2, num3, num4);
    }

    private final void setFkTitleTextColor(Integer num) {
        this.f12507p = num;
        if (num != null) {
            ((TextView) a(R$id.titleTextView)).setTextColor(num.intValue());
        }
    }

    private final void setFkValueTextBackground(Integer num) {
        this.f12506o = num;
        if (num != null) {
            ((TextView) a(R$id.valueTextView)).setBackgroundResource(num.intValue());
        }
    }

    public static /* synthetic */ void setHeadLayoutMargin$default(FKItemLayout fKItemLayout, Integer num, Integer num2, Integer num3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        if ((i10 & 8) != 0) {
            num4 = null;
        }
        fKItemLayout.setHeadLayoutMargin(num, num2, num3, num4);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12510s;
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

    public final void b() {
        z.a(this, R$layout.layout_app_item, true);
    }

    public final void c(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        kotlin.jvm.internal.s.i(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKItemLayout);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.FKItemLayout)");
        b();
        setFkTitleText(obtainStyledAttributes.getString(7));
        setFkTitleLeftImageRes(Integer.valueOf(obtainStyledAttributes.getResourceId(10, 0)));
        setFkTitleRightImageRes(Integer.valueOf(obtainStyledAttributes.getResourceId(11, 0)));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize > 0) {
            ((TextView) a(R$id.titleTextView)).setTextSize(0, dimensionPixelSize);
        }
        ((TextView) a(R$id.titleTextView)).setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(5, 0));
        setFkContentText(obtainStyledAttributes.getString(3));
        setFkValueText(obtainStyledAttributes.getString(13));
        setFkBottomLine(Boolean.valueOf(obtainStyledAttributes.getBoolean(1, false)));
        setFkNextIndicator(Boolean.valueOf(obtainStyledAttributes.getBoolean(6, false)));
        setFkValueTextBackground(Integer.valueOf(obtainStyledAttributes.getResourceId(14, 0)));
        setFkValueTextColor(Integer.valueOf(obtainStyledAttributes.getColor(16, -5658199)));
        setFkTitleTextColor(Integer.valueOf(obtainStyledAttributes.getColor(9, -15066598)));
        setFkTitleBold(Boolean.valueOf(obtainStyledAttributes.getBoolean(8, true)));
        setFkValueBold(Boolean.valueOf(obtainStyledAttributes.getBoolean(15, true)));
        setFkContentBold(Boolean.valueOf(obtainStyledAttributes.getBoolean(4, true)));
        setFkItemBackground(Integer.valueOf(obtainStyledAttributes.getResourceId(0, R$color.app_white)));
        setBottomLineColor(Integer.valueOf(obtainStyledAttributes.getColor(2, AltAttribute.DEFAULT_ALT)));
        obtainStyledAttributes.recycle();
    }

    @Nullable
    public final Integer getBottomLineColor() {
        return this.f12509r;
    }

    @Nullable
    public final Boolean getFkBottomLine() {
        return this.f12503l;
    }

    @Nullable
    public final Boolean getFkContentBold() {
        return this.f12496e;
    }

    @Nullable
    public final String getFkContentText() {
        return this.f12499h;
    }

    @Nullable
    public final Integer getFkItemBackground() {
        return this.f12493b;
    }

    @Nullable
    public final Boolean getFkNextIndicator() {
        return this.f12504m;
    }

    @Nullable
    public final Boolean getFkTitleBold() {
        return this.f12495d;
    }

    @Nullable
    public final Integer getFkTitleLeftImageRes() {
        return this.f12497f;
    }

    @Nullable
    public final Integer getFkTitleRightImageRes() {
        return this.f12498g;
    }

    @Nullable
    public final String getFkTitleText() {
        return this.f12494c;
    }

    @Nullable
    public final Boolean getFkValueBold() {
        return this.f12502k;
    }

    @Nullable
    public final Integer getFkValueImage() {
        return this.f12508q;
    }

    @Nullable
    public final Boolean getFkValueRedTip() {
        return this.f12501j;
    }

    @Nullable
    public final String getFkValueText() {
        return this.f12500i;
    }

    @Nullable
    public final Integer getFkValueTextColor() {
        return this.f12505n;
    }

    public final void setBottomLineColor(@Nullable Integer num) {
        this.f12509r = num;
        if (num != null) {
            num.intValue();
            a(R$id.bottomLineView).setBackgroundColor(num.intValue());
        }
    }

    public final void setContentTextMargin(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        TextView contentTextView = (TextView) a(R$id.contentTextView);
        kotlin.jvm.internal.s.h(contentTextView, "contentTextView");
        y.l(contentTextView, num, num2, num3, num4);
    }

    public final void setFkBottomLine(@Nullable Boolean bool) {
        this.f12503l = bool;
        a(R$id.bottomLineView).setVisibility(kotlin.jvm.internal.s.d(bool, Boolean.TRUE) ? 0 : 4);
    }

    public final void setFkContentBold(@Nullable Boolean bool) {
        this.f12496e = bool;
        ((TextView) a(R$id.contentTextView)).getPaint().setFakeBoldText(bool != null ? bool.booleanValue() : false);
    }

    public final void setFkContentText(@Nullable String str) {
        this.f12499h = str;
        if (str == null || str.length() == 0) {
            ((TextView) a(R$id.contentTextView)).setVisibility(8);
            return;
        }
        int i10 = R$id.contentTextView;
        ((TextView) a(i10)).setVisibility(0);
        ((TextView) a(i10)).setText(str);
    }

    public final void setFkItemBackground(@Nullable Integer num) {
        this.f12493b = num;
        ((RelativeLayout) a(R$id.item_container_layout)).setBackgroundResource(num != null ? num.intValue() : R$color.app_white);
    }

    public final void setFkNextIndicator(@Nullable Boolean bool) {
        this.f12504m = bool;
        ((ImageView) a(R$id.nextIndicatorView)).setVisibility(kotlin.jvm.internal.s.d(bool, Boolean.TRUE) ? 0 : 8);
    }

    public final void setFkTitleBold(@Nullable Boolean bool) {
        this.f12495d = bool;
        ((TextView) a(R$id.titleTextView)).getPaint().setFakeBoldText(bool != null ? bool.booleanValue() : true);
    }

    public final void setFkTitleLeftImageRes(@Nullable Integer num) {
        this.f12497f = num;
        TextView textView = (TextView) a(R$id.titleTextView);
        int intValue = num != null ? num.intValue() : 0;
        Integer num2 = this.f12498g;
        textView.setCompoundDrawablesWithIntrinsicBounds(intValue, 0, num2 != null ? num2.intValue() : 0, 0);
    }

    public final void setFkTitleRightImageRes(@Nullable Integer num) {
        this.f12498g = num;
        TextView textView = (TextView) a(R$id.titleTextView);
        Integer num2 = this.f12497f;
        textView.setCompoundDrawablesWithIntrinsicBounds(num2 != null ? num2.intValue() : 0, 0, num != null ? num.intValue() : 0, 0);
    }

    public final void setFkTitleText(@Nullable String str) {
        this.f12494c = str;
        ((TextView) a(R$id.titleTextView)).setText(str);
    }

    public final void setFkValueBold(@Nullable Boolean bool) {
        this.f12502k = bool;
        ((TextView) a(R$id.valueTextView)).getPaint().setFakeBoldText(bool != null ? bool.booleanValue() : true);
    }

    public final void setFkValueImage(@Nullable Integer num) {
        this.f12508q = num;
        if (num != null) {
            ((ImageView) a(R$id.valueImageView)).setImageResource(num.intValue());
        }
        ((ImageView) a(R$id.valueImageView)).setVisibility(num != null ? 0 : 8);
    }

    public final void setFkValueRedTip(@Nullable Boolean bool) {
        this.f12501j = bool;
        a(R$id.value_red_tip).setVisibility(kotlin.jvm.internal.s.d(bool, Boolean.TRUE) ? 0 : 8);
    }

    public final void setFkValueText(@Nullable String str) {
        this.f12500i = str;
        int i10 = R$id.valueTextView;
        ((TextView) a(i10)).setMaxWidth(z0.h.l(this) / 2);
        ((TextView) a(i10)).setText(str);
        ((TextView) a(i10)).setVisibility(str == null || str.length() == 0 ? 8 : 0);
    }

    public final void setFkValueTextColor(@Nullable Integer num) {
        this.f12505n = num;
        if (num != null) {
            ((TextView) a(R$id.valueTextView)).setTextColor(num.intValue());
        }
    }

    public final void setHeadLayoutMargin(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        LinearLayout headLayout = (LinearLayout) a(R$id.headLayout);
        kotlin.jvm.internal.s.h(headLayout, "headLayout");
        y.l(headLayout, num, num2, num3, num4);
    }

    public final void setValueLayoutEmpty() {
        ((LinearLayout) a(R$id.valueLayout)).setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12510s = new LinkedHashMap();
        this.f12506o = 0;
        c(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12510s = new LinkedHashMap();
        this.f12506o = 0;
        c(context, attributeSet);
    }
}
