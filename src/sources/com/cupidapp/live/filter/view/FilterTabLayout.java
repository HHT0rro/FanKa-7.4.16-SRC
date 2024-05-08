package com.cupidapp.live.filter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.match.model.FilterTabKey;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FilterTabLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterTabLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public List<FilterItemModel> f14638d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14639e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTabLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14639e = new LinkedHashMap();
        k();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f14639e;
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

    public final void g(FilterItemModel filterItemModel, View view) {
        if (view == null) {
            return;
        }
        if (s.d(filterItemModel.getKey(), FilterTabKey.MBTI.getValue())) {
            if (filterItemModel.isSelected()) {
                g.f52734a.P2(Boolean.FALSE);
                view.setVisibility(8);
                return;
            } else {
                if (s.d(g.f52734a.n0(), Boolean.TRUE)) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
        }
        view.setVisibility(8);
    }

    public final void h(FilterItemModel filterItemModel) {
        View childAt;
        View childAt2;
        List<FilterItemModel> list = this.f14638d;
        if (list != null) {
            int i10 = 0;
            for (FilterItemModel filterItemModel2 : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                FilterItemModel filterItemModel3 = filterItemModel2;
                boolean d10 = s.d(filterItemModel.getKey(), filterItemModel3.getKey());
                filterItemModel3.setSelected(d10);
                int i12 = R$id.filter_tab_ll;
                LinearLayout linearLayout = (LinearLayout) e(i12);
                TextView textView = null;
                g(filterItemModel3, (linearLayout == null || (childAt2 = linearLayout.getChildAt(i10)) == null) ? null : childAt2.findViewById(R$id.red_dot));
                LinearLayout linearLayout2 = (LinearLayout) e(i12);
                if (linearLayout2 != null && (childAt = linearLayout2.getChildAt(i10)) != null) {
                    textView = (TextView) childAt.findViewById(R$id.item_con_txt);
                }
                j(d10, textView);
                i10 = i11;
            }
        }
    }

    public final void i(@NotNull List<FilterItemModel> list, @NotNull final b itemClick) {
        s.i(list, "list");
        s.i(itemClick, "itemClick");
        this.f14638d = list;
        ((LinearLayout) e(R$id.filter_tab_ll)).removeAllViews();
        for (final FilterItemModel filterItemModel : list) {
            LayoutInflater from = LayoutInflater.from(getContext());
            int i10 = R$id.filter_tab_ll;
            View inflate = from.inflate(R$layout.item_filter_tab_view, (ViewGroup) e(i10), false);
            TextView textView = (TextView) inflate.findViewById(R$id.item_con_txt);
            View findViewById = inflate.findViewById(R$id.red_dot);
            s.h(textView, "textView");
            u.a(textView);
            textView.setText(filterItemModel.getContent());
            textView.setSelected(filterItemModel.isSelected());
            y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.filter.view.FilterTabLayout$configData$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    if (FilterItemModel.this.isSelected()) {
                        return;
                    }
                    this.h(FilterItemModel.this);
                    itemClick.I0(FilterItemModel.this);
                }
            });
            j(filterItemModel.isSelected(), textView);
            g(filterItemModel, findViewById);
            ((LinearLayout) e(i10)).addView(inflate, new LinearLayout.LayoutParams(-2, -2));
            if (filterItemModel.isSelected()) {
                itemClick.I0(filterItemModel);
            }
        }
    }

    public final void j(boolean z10, TextView textView) {
        if (textView == null) {
            return;
        }
        if (z10) {
            textView.setSelected(true);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.white_FEFFFE));
        } else {
            textView.setSelected(false);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.gray_A9A9A9));
        }
    }

    public final void k() {
        z.a(this, R$layout.layout_filter_tab, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14639e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14639e = new LinkedHashMap();
        k();
    }
}
