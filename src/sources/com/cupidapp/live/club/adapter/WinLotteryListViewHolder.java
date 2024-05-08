package com.cupidapp.live.club.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.club.model.WinLotteryUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: WinLotteryListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WinLotteryListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13519c = new a(null);

    /* compiled from: WinLotteryListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinLotteryListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new WinLotteryListViewHolder(z.b(parent, R$layout.view_holder_win_lottery_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinLotteryListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.win_lottery_name_textview);
        s.h(textView, "itemView.win_lottery_name_textview");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.meal_ticket_textview);
        s.h(textView2, "itemView.meal_ticket_textview");
        u.a(textView2);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof WinLotteryUserModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.win_lottery_avatar_imageview);
            s.h(imageLoaderView, "itemView.win_lottery_avatar_imageview");
            WinLotteryUserModel winLotteryUserModel = (WinLotteryUserModel) obj;
            ImageLoaderView.g(imageLoaderView, winLotteryUserModel.getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.win_lottery_name_textview)).setText(winLotteryUserModel.getNickname());
            ((TextView) this.itemView.findViewById(R$id.meal_ticket_textview)).setText(this.itemView.getContext().getString(R$string.food_stamps, winLotteryUserModel.getTicket()));
            TextView textView = (TextView) this.itemView.findViewById(R$id.best_luck_textview);
            s.h(textView, "itemView.best_luck_textview");
            textView.setVisibility(winLotteryUserModel.getTheBest() ? 0 : 8);
        }
    }
}
