package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.HotViewModel;
import com.cupidapp.live.match.model.RegionModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: HotAreaViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HotAreaViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16798d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Function1<RegionModel, p> f16799c;

    /* compiled from: HotAreaViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HotAreaViewHolder a(@NotNull ViewGroup parent, @NotNull Function1<? super RegionModel, p> clickCallBack) {
            s.i(parent, "parent");
            s.i(clickCallBack, "clickCallBack");
            return new HotAreaViewHolder(z.b(parent, R$layout.item_hot_citys, false, 2, null), clickCallBack);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HotAreaViewHolder(@NotNull View itemView, @NotNull Function1<? super RegionModel, p> clickCallBack) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(clickCallBack, "clickCallBack");
        this.f16799c = clickCallBack;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof HotViewModel) {
            HotViewModel hotViewModel = (HotViewModel) obj;
            ((TextView) this.itemView.findViewById(R$id.title_city)).setText(hotViewModel.getTitle());
            GridLayout gridLayout = (GridLayout) this.itemView.findViewById(R$id.city_layout);
            gridLayout.removeAllViews();
            for (final RegionModel regionModel : hotViewModel.getRegions()) {
                View r10 = r(regionModel);
                y.d(r10, new Function1<View, p>() { // from class: com.cupidapp.live.match.holder.HotAreaViewHolder$config$1$1
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
                        HotAreaViewHolder.this.s().invoke(regionModel);
                    }
                });
                gridLayout.addView(r10);
            }
        }
    }

    public final View r(RegionModel regionModel) {
        TextView textView = new TextView(this.itemView.getContext());
        textView.setText(regionModel.getName());
        textView.setGravity(17);
        textView.setBackgroundResource(R$drawable.bg_hot_city);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1, 1.0f);
        layoutParams.height = h.c(this, 44.0f);
        layoutParams.setMarginEnd(h.c(this, 12.0f));
        layoutParams.topMargin = h.c(this, 12.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    @NotNull
    public final Function1<RegionModel, p> s() {
        return this.f16799c;
    }
}
