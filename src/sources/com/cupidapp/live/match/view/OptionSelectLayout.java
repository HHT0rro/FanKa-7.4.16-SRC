package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.feed.layout.FlowLayout;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OptionSelectLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OptionSelectLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16994d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OptionSelectLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16994d = new LinkedHashMap();
        l();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16994d;
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

    public final void h(@NotNull final OptionSelectTransModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        ((FlowLayout) e(R$id.filter_fl)).removeAllViews();
        List<FilterOption> options = model.getOptions();
        if (options != null) {
            for (final FilterOption filterOption : options) {
                final View j10 = j(filterOption, model.getItemWidth());
                z0.y.d(j10, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.OptionSelectLayout$configData$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                        invoke2(view);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view) {
                        boolean k10;
                        k10 = OptionSelectLayout.this.k(model.getNeedPurchaseFirst(), filterOption.getLabel(), model.getProductType(), model.getEntranceType());
                        if (k10) {
                            return;
                        }
                        filterOption.setChecked(!r5.getChecked());
                        OptionSelectLayout optionSelectLayout = OptionSelectLayout.this;
                        FilterOption filterOption2 = filterOption;
                        View findViewById = j10.findViewById(R$id.item_con_txt);
                        kotlin.jvm.internal.s.h(findViewById, "item.findViewById(R.id.item_con_txt)");
                        optionSelectLayout.i(filterOption2, (TextView) findViewById);
                    }
                });
                ((FlowLayout) e(R$id.filter_fl)).addView(j10);
            }
        }
    }

    public final void i(FilterOption filterOption, TextView textView) {
        if (filterOption.getChecked()) {
            textView.setSelected(true);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.secondaryRed));
        } else {
            textView.setSelected(false);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.gray_7C7C7C));
        }
    }

    public final View j(FilterOption filterOption, int i10) {
        View itemView = LayoutInflater.from(getContext()).inflate(R$layout.item_mul_select_view, (ViewGroup) e(R$id.filter_fl), false);
        View rootView = itemView.findViewById(R$id.item_mul_root);
        kotlin.jvm.internal.s.h(rootView, "rootView");
        z0.y.o(rootView, Integer.valueOf(i10), null, 2, null);
        TextView textView = (TextView) itemView.findViewById(R$id.item_con_txt);
        TextView tagTxtView = (TextView) itemView.findViewById(R$id.mul_select_tag_txt);
        String tag = filterOption.getTag();
        if (tag == null || tag.length() == 0) {
            tagTxtView.setVisibility(4);
        } else {
            tagTxtView.setVisibility(0);
            tagTxtView.setText(filterOption.getTag());
            kotlin.jvm.internal.s.h(tagTxtView, "tagTxtView");
            z0.u.a(tagTxtView);
        }
        textView.setText(filterOption.getLabel());
        textView.setSelected(filterOption.getChecked());
        kotlin.jvm.internal.s.h(textView, "textView");
        i(filterOption, textView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        return itemView;
    }

    public final boolean k(boolean z10, String str, int i10, VipPurchaseEntranceType vipPurchaseEntranceType) {
        if (z10) {
            return PurchaseProductType.Companion.e(str, i10, vipPurchaseEntranceType);
        }
        return false;
    }

    public final void l() {
        z0.z.a(this, R$layout.layout_option_select, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OptionSelectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16994d = new LinkedHashMap();
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OptionSelectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16994d = new LinkedHashMap();
        l();
    }
}
