package com.cupidapp.live.filter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.SuperRangerBar;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.z;

/* compiled from: FilterRangeBarLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterRangeBarLayout extends FrameLayout {

    /* renamed from: b */
    public int f14632b;

    /* renamed from: c */
    public int f14633c;

    /* renamed from: d */
    @NotNull
    public Map<Integer, View> f14634d;

    /* compiled from: FilterRangeBarLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends SuperRangerBar.b {

        /* renamed from: b */
        public final /* synthetic */ RangeMatchFilterViewModel f14636b;

        /* renamed from: c */
        public final /* synthetic */ String f14637c;

        public a(RangeMatchFilterViewModel rangeMatchFilterViewModel, String str) {
            this.f14636b = rangeMatchFilterViewModel;
            this.f14637c = str;
        }

        @Override // com.cupidapp.live.base.view.SuperRangerBar.b
        public void e(int i10, int i11, boolean z10, boolean z11) {
            if (z11 && z10) {
                FilterRangeBarLayout filterRangeBarLayout = FilterRangeBarLayout.this;
                int i12 = R$id.filter_range_content_text;
                ((TextView) filterRangeBarLayout.a(i12)).setText(FilterRangeBarLayout.this.getContext().getString(R$string.infinite));
                ((TextView) FilterRangeBarLayout.this.a(i12)).setTextColor(FilterRangeBarLayout.this.f14633c);
                ((TextView) FilterRangeBarLayout.this.a(i12)).getPaint().setFakeBoldText(false);
            } else if (z11 && !this.f14636b.getSearchHasMax()) {
                FilterRangeBarLayout filterRangeBarLayout2 = FilterRangeBarLayout.this;
                int i13 = R$id.filter_range_content_text;
                ((TextView) filterRangeBarLayout2.a(i13)).setText(FilterRangeBarLayout.this.getContext().getString(R$string.range_min, Integer.valueOf(i10), this.f14637c));
                ((TextView) FilterRangeBarLayout.this.a(i13)).setTextColor(FilterRangeBarLayout.this.f14632b);
                ((TextView) FilterRangeBarLayout.this.a(i13)).getPaint().setFakeBoldText(true);
            } else if (z10 && !this.f14636b.getSearchHasMin()) {
                FilterRangeBarLayout filterRangeBarLayout3 = FilterRangeBarLayout.this;
                int i14 = R$id.filter_range_content_text;
                ((TextView) filterRangeBarLayout3.a(i14)).setText(FilterRangeBarLayout.this.getContext().getString(R$string.range_max, Integer.valueOf(i11), this.f14637c));
                ((TextView) FilterRangeBarLayout.this.a(i14)).setTextColor(FilterRangeBarLayout.this.f14632b);
                ((TextView) FilterRangeBarLayout.this.a(i14)).getPaint().setFakeBoldText(true);
            } else {
                FilterRangeBarLayout filterRangeBarLayout4 = FilterRangeBarLayout.this;
                int i15 = R$id.filter_range_content_text;
                ((TextView) filterRangeBarLayout4.a(i15)).setText(FilterRangeBarLayout.this.getContext().getString(R$string.range_min_to_max_unit, Integer.valueOf(i10), Integer.valueOf(i11), this.f14637c));
                ((TextView) FilterRangeBarLayout.this.a(i15)).setTextColor(FilterRangeBarLayout.this.f14632b);
                ((TextView) FilterRangeBarLayout.this.a(i15)).getPaint().setFakeBoldText(true);
            }
            this.f14636b.setMin(i10);
            this.f14636b.setMax(i11);
            this.f14636b.getMatchFilterModel().setMinValue(i10);
            this.f14636b.getMatchFilterModel().setMaxValue(i11);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterRangeBarLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14634d = new LinkedHashMap();
        this.f14632b = -49088;
        this.f14633c = -5658199;
        f();
    }

    public static /* synthetic */ void e(FilterRangeBarLayout filterRangeBarLayout, RangeMatchFilterViewModel rangeMatchFilterViewModel, FilterBarUiModel filterBarUiModel, int i10, Object obj) {
        filterRangeBarLayout.d(rangeMatchFilterViewModel, (i10 & 2) != 0 ? new FilterBarUiModel(null, 0, null, 0, 0, 0, 0, 0, null, 511, null) : filterBarUiModel);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14634d;
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

    public final void d(@NotNull RangeMatchFilterViewModel model, @NotNull FilterBarUiModel uiModel) {
        s.i(model, "model");
        s.i(uiModel, "uiModel");
        this.f14632b = uiModel.getSelectContentSelectColor();
        this.f14633c = uiModel.getSelectContentDefaultColor();
        g(uiModel);
        ((TextView) a(R$id.filter_range_title_text)).setText(model.getMatchFilterModel().getName());
        String unit = model.getMatchFilterModel().getUnit();
        int i10 = R$id.filter_rangeBar;
        ((SuperRangerBar) a(i10)).setOnMoveListener(new a(model, unit));
        SuperRangerBar superRangerBar = (SuperRangerBar) a(i10);
        superRangerBar.h(model.getMatchFilterModel().getDefaultMin(), model.getMatchFilterModel().getDefaultMax());
        superRangerBar.setRange(model.getMatchFilterModel().getMinValue(), model.getMatchFilterModel().getMaxValue());
    }

    public final void f() {
        z.a(this, R$layout.view_filter_range_bar, true);
    }

    public final void g(FilterBarUiModel filterBarUiModel) {
        if (filterBarUiModel.getBgDrawable() != null) {
            ((ConstraintLayout) a(R$id.root_view)).setBackgroundResource(filterBarUiModel.getBgDrawable().intValue());
        }
        if (filterBarUiModel.getPadding().size() > 3) {
            ((ConstraintLayout) a(R$id.root_view)).setPadding(h.c(filterBarUiModel, filterBarUiModel.getPadding().get(0).floatValue()), h.c(filterBarUiModel, filterBarUiModel.getPadding().get(1).floatValue()), h.c(filterBarUiModel, filterBarUiModel.getPadding().get(2).floatValue()), h.c(filterBarUiModel, filterBarUiModel.getPadding().get(3).floatValue()));
        }
        if (filterBarUiModel.getTitleTextStyle() == TextStyle.BOLD) {
            ((TextView) a(R$id.filter_range_title_text)).setTypeface(null, 1);
        } else {
            TextView filter_range_title_text = (TextView) a(R$id.filter_range_title_text);
            s.h(filter_range_title_text, "filter_range_title_text");
            u.a(filter_range_title_text);
        }
        int i10 = R$id.filter_range_title_text;
        ((TextView) a(i10)).setTextSize(2, filterBarUiModel.getTitleTextSize());
        ((TextView) a(i10)).setTextColor(filterBarUiModel.getTitleTextColor());
        ((TextView) a(R$id.filter_range_content_text)).setTextSize(2, filterBarUiModel.getSelectContentSize());
        ((SuperRangerBar) a(R$id.filter_rangeBar)).setCoverLineColor(filterBarUiModel.getBarColor());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterRangeBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14634d = new LinkedHashMap();
        this.f14632b = -49088;
        this.f14633c = -5658199;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterRangeBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14634d = new LinkedHashMap();
        this.f14632b = -49088;
        this.f14633c = -5658199;
        f();
    }
}
