package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.view.giftpicker.model.RechargeRewardModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FirstRechargeRewardLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FirstRechargeRewardViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15552c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f15553d;

    /* compiled from: FirstRechargeRewardLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FirstRechargeRewardViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FirstRechargeRewardViewHolder(z.b(parent, R$layout.view_holder_first_recharge_reward, false, 2, null));
        }
    }

    static {
        a aVar = new a(null);
        f15552c = aVar;
        f15553d = (z0.h.l(aVar) - z0.h.c(aVar, 48.0f)) / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirstRechargeRewardViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        View findViewById = itemView.findViewById(R$id.reward_bg_view);
        s.h(findViewById, "itemView.reward_bg_view");
        y.o(findViewById, Integer.valueOf(f15553d), null, 2, null);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof RechargeRewardModel) {
            RecyclerView.Adapter<? extends RecyclerView.ViewHolder> bindingAdapter = getBindingAdapter();
            int itemCount = bindingAdapter != null ? bindingAdapter.getItemCount() : 0;
            int absoluteAdapterPosition = getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition == 0) {
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                y.m(itemView, Integer.valueOf(z0.h.c(this, 16.0f)), null, null, null, 14, null);
            } else if (absoluteAdapterPosition == itemCount - 1) {
                View itemView2 = this.itemView;
                s.h(itemView2, "itemView");
                y.m(itemView2, null, null, Integer.valueOf(z0.h.c(this, 8.0f)), null, 11, null);
            }
            RechargeRewardModel rechargeRewardModel = (RechargeRewardModel) obj;
            ((TextView) this.itemView.findViewById(R$id.reward_name_textview)).setText(rechargeRewardModel.getTitle());
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.reward_imageview);
            s.h(imageLoaderView, "itemView.reward_imageview");
            ImageLoaderView.g(imageLoaderView, rechargeRewardModel.getIconImage(), null, null, 6, null);
        }
    }
}
