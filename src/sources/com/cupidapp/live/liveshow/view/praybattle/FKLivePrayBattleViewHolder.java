package com.cupidapp.live.liveshow.view.praybattle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.PrayContestModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLivePrayBattleAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePrayBattleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15834c = new a(null);

    /* compiled from: FKLivePrayBattleAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLivePrayBattleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLivePrayBattleViewHolder(z.b(parent, R$layout.pray_battle_view_holder, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrayBattleViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.pray_battle_challenger_name)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.pray_battle_type)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.pray_battle_gift_count)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof PrayContestModel) {
            PrayContestModel prayContestModel = (PrayContestModel) obj;
            if (prayContestModel.getUserAvatar() == null) {
                ((ImageLoaderView) this.itemView.findViewById(R$id.pray_battle_challenger_avatar)).setImageResource(R$mipmap.icon_default_char);
            } else {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.pray_battle_challenger_avatar);
                s.h(imageLoaderView, "itemView.pray_battle_challenger_avatar");
                ImageLoaderView.g(imageLoaderView, prayContestModel.getUserAvatar(), null, null, 6, null);
            }
            TextView textView = (TextView) this.itemView.findViewById(R$id.pray_battle_challenger_name);
            String userName = prayContestModel.getUserName();
            if (userName == null) {
                userName = this.itemView.getContext().getString(R$string.leave_a_seat_vacant);
            }
            textView.setText(userName);
            ((TextView) this.itemView.findViewById(R$id.pray_battle_type)).setText(prayContestModel.getText());
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.pray_battle_gift_image);
            s.h(imageLoaderView2, "itemView.pray_battle_gift_image");
            ImageLoaderView.g(imageLoaderView2, prayContestModel.getIconImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.pray_battle_gift_count)).setText(String.valueOf(prayContestModel.getCount()));
        }
    }
}
