package com.cupidapp.live.match.holder;

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
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.SuperFilterModel;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: MulSelectFilterViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MulSelectFilterViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16807c = new a(null);

    /* compiled from: MulSelectFilterViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MulSelectFilterViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MulSelectFilterViewHolder(z.b(parent, R$layout.item_filter_mul_select, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulSelectFilterViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof SuperFilterModel) {
            View view = this.itemView;
            int i10 = R$id.filter_title;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.filter_title");
            u.a(textView);
            TextView textView2 = (TextView) this.itemView.findViewById(i10);
            SuperFilterModel superFilterModel = (SuperFilterModel) obj;
            textView2.setText(superFilterModel.getName());
            ((FlowLayout) this.itemView.findViewById(R$id.filter_ll)).removeAllViews();
            int l10 = ((h.l(this) - h.c(this, 26.0f)) - h.c(this, 40.0f)) / 4;
            if (l10 <= 0) {
                l10 = h.c(this, 78.0f);
            }
            for (final FilterOption filterOption : superFilterModel.getOptions()) {
                final View u10 = u(filterOption, l10);
                y.d(u10, new Function1<View, p>() { // from class: com.cupidapp.live.match.holder.MulSelectFilterViewHolder$config$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view2) {
                        invoke2(view2);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view2) {
                        boolean v2;
                        v2 = MulSelectFilterViewHolder.this.v(filterOption.getLabel(), ((SuperFilterModel) obj).getKey());
                        if (v2) {
                            return;
                        }
                        filterOption.setChecked(!r4.getChecked());
                        MulSelectFilterViewHolder mulSelectFilterViewHolder = MulSelectFilterViewHolder.this;
                        FilterOption filterOption2 = filterOption;
                        View findViewById = u10.findViewById(R$id.item_con_txt);
                        s.h(findViewById, "item.findViewById(R.id.item_con_txt)");
                        mulSelectFilterViewHolder.t(filterOption2, (TextView) findViewById);
                    }
                });
                ((FlowLayout) this.itemView.findViewById(R$id.filter_ll)).addView(u10);
            }
        }
    }

    public final void t(FilterOption filterOption, TextView textView) {
        if (filterOption.getChecked()) {
            textView.setSelected(true);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.secondaryRed));
        } else {
            textView.setSelected(false);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.gray_7C7C7C));
        }
    }

    public final View u(FilterOption filterOption, int i10) {
        View itemView = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.item_mul_select_view, (ViewGroup) this.itemView.findViewById(R$id.filter_ll), false);
        View rootView = itemView.findViewById(R$id.item_mul_root);
        s.h(rootView, "rootView");
        y.o(rootView, Integer.valueOf(i10), null, 2, null);
        TextView textView = (TextView) itemView.findViewById(R$id.item_con_txt);
        TextView tagTxtView = (TextView) itemView.findViewById(R$id.mul_select_tag_txt);
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
        t(filterOption, textView);
        s.h(itemView, "itemView");
        return itemView;
    }

    public final boolean v(String str, String str2) {
        if (c.f17839a.d()) {
            return false;
        }
        EventBus.c().l(new a3.a(str, true, kotlin.text.p.r("mbti", str2, true) ? VipPurchaseEntranceType.SuperFilterMBTI : VipPurchaseEntranceType.SuperFilter));
        return true;
    }
}
