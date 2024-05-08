package com.cupidapp.live.filter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.feed.layout.FlowLayout;
import com.cupidapp.live.filter.model.FilterTopOptionsUiModel;
import com.cupidapp.live.match.model.FilterOption;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FilterOptionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterOptionLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14631d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterOptionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f14631d = new LinkedHashMap();
        j();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f14631d;
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

    public final void g(@Nullable FilterTopOptionsUiModel filterTopOptionsUiModel, @NotNull final OptionUiModel uiModel) {
        s.i(uiModel, "uiModel");
        if (filterTopOptionsUiModel == null) {
            return;
        }
        ((RelativeLayout) e(R$id.filter_option_root)).setBackgroundResource(uiModel.getBgDrawable());
        int i10 = R$id.filter_title;
        TextView filter_title = (TextView) e(i10);
        s.h(filter_title, "filter_title");
        u.a(filter_title);
        ((TextView) e(i10)).setText(filterTopOptionsUiModel.getName());
        ((TextView) e(i10)).setTextColor(uiModel.getTitleTextColor());
        ((FlowLayout) e(R$id.filter_ll)).removeAllViews();
        int l10 = ((h.l(this) - h.c(this, 15.0f)) - h.c(this, 32.0f)) / 4;
        if (l10 <= 0) {
            l10 = h.c(this, 78.0f);
        }
        for (final FilterOption filterOption : filterTopOptionsUiModel.getOptions()) {
            final View i11 = i(filterOption, l10, uiModel);
            y.d(i11, new Function1<View, p>() { // from class: com.cupidapp.live.filter.view.FilterOptionLayout$configData$1$1
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
                    FilterOption.this.setChecked(!r4.getChecked());
                    FilterOptionLayout filterOptionLayout = this;
                    FilterOption filterOption2 = FilterOption.this;
                    View findViewById = i11.findViewById(R$id.item_con_txt);
                    s.h(findViewById, "item.findViewById(R.id.item_con_txt)");
                    filterOptionLayout.h(filterOption2, (TextView) findViewById, uiModel);
                }
            });
            ((FlowLayout) e(R$id.filter_ll)).addView(i11);
        }
    }

    public final void h(FilterOption filterOption, TextView textView, OptionUiModel optionUiModel) {
        if (filterOption.getChecked()) {
            textView.setSelected(true);
            textView.setTextColor(optionUiModel.getItemSelectedColor());
        } else {
            textView.setSelected(false);
            textView.setTextColor(optionUiModel.getItemDefaultTextColor());
        }
    }

    public final View i(FilterOption filterOption, int i10, OptionUiModel optionUiModel) {
        View itemView = LayoutInflater.from(getContext()).inflate(R$layout.item_mul_select_view, (ViewGroup) e(R$id.filter_ll), false);
        View rootView = itemView.findViewById(R$id.item_mul_root);
        s.h(rootView, "rootView");
        y.o(rootView, Integer.valueOf(i10), null, 2, null);
        TextView textView = (TextView) itemView.findViewById(R$id.item_con_txt);
        TextView tagTxtView = (TextView) itemView.findViewById(R$id.mul_select_tag_txt);
        textView.setBackgroundResource(optionUiModel.getItemBgDrawable());
        String tag = filterOption.getTag();
        if (tag == null || tag.length() == 0) {
            tagTxtView.setVisibility(4);
        } else {
            tagTxtView.setVisibility(0);
            tagTxtView.setText(filterOption.getTag());
            s.h(tagTxtView, "tagTxtView");
            u.a(tagTxtView);
        }
        textView.setText(filterOption.getLabel());
        textView.setSelected(filterOption.getChecked());
        s.h(textView, "textView");
        h(filterOption, textView, optionUiModel);
        s.h(itemView, "itemView");
        return itemView;
    }

    public final void j() {
        z.a(this, R$layout.layout_filter_option, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterOptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f14631d = new LinkedHashMap();
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterOptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f14631d = new LinkedHashMap();
        j();
    }
}
