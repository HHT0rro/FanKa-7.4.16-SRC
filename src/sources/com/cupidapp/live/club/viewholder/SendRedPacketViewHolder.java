package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.club.model.ClubRedPacketModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: SendRedPacketViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendRedPacketViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13697c = new a(null);

    /* compiled from: SendRedPacketViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SendRedPacketViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SendRedPacketViewHolder(z.b(parent, R$layout.view_holder_send_red_packet, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendRedPacketViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        int i10 = R$id.red_packet_name_text;
        TextView textView = (TextView) itemView.findViewById(i10);
        s.h(textView, "itemView.red_packet_name_text");
        u.f(textView, 14);
        TextView textView2 = (TextView) itemView.findViewById(i10);
        s.h(textView2, "itemView.red_packet_name_text");
        u.a(textView2);
        TextView textView3 = (TextView) itemView.findViewById(R$id.red_packet_price_text);
        s.h(textView3, "itemView.red_packet_price_text");
        u.f(textView3, 12);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ClubRedPacketModel) {
            ClubRedPacketModel clubRedPacketModel = (ClubRedPacketModel) obj;
            ((TextView) this.itemView.findViewById(R$id.red_packet_name_text)).setText(clubRedPacketModel.getGiftName());
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.red_packet_img);
            s.h(imageLoaderView, "itemView.red_packet_img");
            ImageLoaderView.g(imageLoaderView, clubRedPacketModel.getGiftImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.red_packet_price_text)).setText(this.itemView.getContext().getString(R$string.club_red_packet_price, clubRedPacketModel.getPrice()));
            ((ConstraintLayout) this.itemView.findViewById(R$id.red_packet_root_layout)).setBackgroundResource(clubRedPacketModel.isSelected() ? R$drawable.rect_cor_12_sk_d5b293_sd_fdf0e5 : R$drawable.rect_cor_12_sd_fdf0e5);
        }
    }
}
