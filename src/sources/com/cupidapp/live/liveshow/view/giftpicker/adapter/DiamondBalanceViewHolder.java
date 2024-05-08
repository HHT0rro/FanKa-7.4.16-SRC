package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.view.giftpicker.model.DiamondModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: DiamondBalanceAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondBalanceViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15423c = new a(null);

    /* compiled from: DiamondBalanceAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiamondBalanceViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new DiamondBalanceViewHolder(z.b(parent, R$layout.view_holder_diamond_balance, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondBalanceViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.diamond_count_textview);
        s.h(textView, "itemView.diamond_count_textview");
        u.a(textView);
        y.o(itemView, Integer.valueOf((h.l(this) - h.c(this, 48.0f)) / 3), null, 2, null);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof DiamondModel) {
            int ceil = (int) Math.ceil((getBindingAdapter() != null ? r0.getItemCount() : 0) / 3.0f);
            int ceil2 = (int) Math.ceil((getAbsoluteAdapterPosition() + 1) / 3.0f);
            int c4 = h.c(this, 4.0f);
            if (getAbsoluteAdapterPosition() / 3 == 0) {
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                y.l(itemView, Integer.valueOf(c4), 0, Integer.valueOf(c4), Integer.valueOf(c4));
            } else if (ceil2 == ceil) {
                View itemView2 = this.itemView;
                s.h(itemView2, "itemView");
                y.l(itemView2, Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4), 0);
            } else {
                View itemView3 = this.itemView;
                s.h(itemView3, "itemView");
                y.l(itemView3, Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4));
            }
            View view = this.itemView;
            int i10 = R$id.diamond_count_textview;
            DiamondModel diamondModel = (DiamondModel) obj;
            ((TextView) view.findViewById(i10)).setText(diamondModel.getTitle());
            View view2 = this.itemView;
            int i11 = R$id.price_textview;
            ((TextView) view2.findViewById(i11)).setText(diamondModel.getPriceFormatted());
            this.itemView.setBackgroundResource(diamondModel.isSelect() ? R$drawable.rect_cor_8_sk_ff4040_sd_26ff4040 : R$drawable.rect_cor_8_sd_f2f2f2);
            ((TextView) this.itemView.findViewById(i10)).setTextColor(diamondModel.isSelect() ? -49088 : -12566464);
            ((TextView) this.itemView.findViewById(i11)).setTextColor(diamondModel.isSelect() ? -49088 : -5658199);
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.subscript_imageview);
            s.h(imageView, "itemView.subscript_imageview");
            imageView.setVisibility(diamondModel.isSelect() ? 0 : 8);
        }
    }
}
