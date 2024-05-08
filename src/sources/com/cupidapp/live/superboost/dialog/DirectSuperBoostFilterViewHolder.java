package com.cupidapp.live.superboost.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.layout.FlowLayout;
import com.cupidapp.live.superboost.model.FilterItemUiModel;
import com.cupidapp.live.superboost.model.FilterOptionModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: DirectSuperBoostFilterViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DirectSuperBoostFilterViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18575d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Function2<FilterOptionModel, FilterItemUiModel, p> f18576c;

    /* compiled from: DirectSuperBoostFilterViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DirectSuperBoostFilterViewHolder a(@NotNull ViewGroup parent, @NotNull Function2<? super FilterOptionModel, ? super FilterItemUiModel, p> itemClick) {
            s.i(parent, "parent");
            s.i(itemClick, "itemClick");
            return new DirectSuperBoostFilterViewHolder(z.b(parent, R$layout.item_direct_boost_filter, false, 2, null), itemClick);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DirectSuperBoostFilterViewHolder(@NotNull View itemView, @NotNull Function2<? super FilterOptionModel, ? super FilterItemUiModel, p> itemClick) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(itemClick, "itemClick");
        this.f18576c = itemClick;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof FilterItemUiModel) {
            View view = this.itemView;
            int i10 = R$id.filter_title;
            FilterItemUiModel filterItemUiModel = (FilterItemUiModel) obj;
            ((TextView) view.findViewById(i10)).setText(filterItemUiModel.getTitle());
            TextView textView = (TextView) this.itemView.findViewById(i10);
            s.h(textView, "itemView.filter_title");
            u.a(textView);
            ((FlowLayout) this.itemView.findViewById(R$id.boost_filter_ll)).removeAllViews();
            int l10 = ((h.l(this) - h.c(this, 36.0f)) - h.c(this, 33.0f)) / 4;
            if (l10 <= 0) {
                l10 = h.c(this, 78.0f);
            }
            for (final FilterOptionModel filterOptionModel : filterItemUiModel.getOptions()) {
                View t2 = t(filterOptionModel);
                y.d(t2, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.DirectSuperBoostFilterViewHolder$config$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view2) {
                        invoke2(view2);
                        return p.f51048a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view2) {
                        DirectSuperBoostFilterViewHolder.this.s().mo1743invoke(filterOptionModel, obj);
                    }
                });
                ((FlowLayout) this.itemView.findViewById(R$id.boost_filter_ll)).addView(t2, new ViewGroup.MarginLayoutParams(l10, -2));
            }
        }
    }

    public final void r(FilterOptionModel filterOptionModel, TextView textView) {
        if (filterOptionModel.getChecked()) {
            textView.setSelected(true);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.yellow_FF9B00));
        } else {
            textView.setSelected(false);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.gray_7C7C7C));
        }
    }

    @NotNull
    public final Function2<FilterOptionModel, FilterItemUiModel, p> s() {
        return this.f18576c;
    }

    public final View t(FilterOptionModel filterOptionModel) {
        View itemView = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.item_direct_filter_mul_select_view, (ViewGroup) this.itemView.findViewById(R$id.filter_ll), false);
        TextView textView = (TextView) itemView.findViewById(R$id.item_con_txt);
        textView.setText(filterOptionModel.getLabel());
        textView.setSelected(filterOptionModel.getChecked());
        textView.getPaint().setFakeBoldText(filterOptionModel.getChecked());
        s.h(textView, "textView");
        r(filterOptionModel, textView);
        s.h(itemView, "itemView");
        return itemView;
    }
}
