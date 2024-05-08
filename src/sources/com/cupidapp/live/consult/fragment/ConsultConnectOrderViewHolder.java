package com.cupidapp.live.consult.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.consult.model.ConnectOrderModel;
import com.cupidapp.live.consult.model.ConsultConnectType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ConsultConnectOrderFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectOrderViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13768c = new a(null);

    /* compiled from: ConsultConnectOrderFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConsultConnectOrderViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ConsultConnectOrderViewHolder(z.b(parent, R$layout.view_holder_consult_connect_order, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultConnectOrderViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.connect_order_txt);
        s.h(textView, "itemView.connect_order_txt");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.connect_order_name_txt);
        s.h(textView2, "itemView.connect_order_name_txt");
        u.a(textView2);
        TextView textView3 = (TextView) itemView.findViewById(R$id.connect_state_txt);
        s.h(textView3, "itemView.connect_state_txt");
        u.a(textView3);
        TextView textView4 = (TextView) itemView.findViewById(R$id.my_order_txt);
        s.h(textView4, "itemView.my_order_txt");
        u.a(textView4);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ConnectOrderModel) {
            ConnectOrderModel connectOrderModel = (ConnectOrderModel) obj;
            String voiceConnectType = connectOrderModel.getVoiceConnectType();
            if (s.d(voiceConnectType, ConsultConnectType.NORMAL.getValue())) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.connect_order_avatar_img);
                s.h(imageLoaderView, "itemView.connect_order_avatar_img");
                ImageLoaderView.g(imageLoaderView, connectOrderModel.getUser().getAvatarImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(0.0f, 0, 3, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
            } else if (s.d(voiceConnectType, ConsultConnectType.ONE_ON_ONE.getValue())) {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.connect_order_avatar_img);
                s.h(imageLoaderView2, "itemView.connect_order_avatar_img");
                ImageLoaderView.f(imageLoaderView2, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.ic_consult_connect_anonymous_avatar), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
            }
            ((TextView) this.itemView.findViewById(R$id.connect_order_name_txt)).setText(connectOrderModel.getUser().getName());
            ((TextView) this.itemView.findViewById(R$id.connect_order_txt)).setText(String.valueOf(getAbsoluteAdapterPosition() + 1));
            ((TextView) this.itemView.findViewById(R$id.my_order_txt)).setVisibility(connectOrderModel.getUser().isMyself() ? 0 : 8);
            int state = connectOrderModel.getState();
            if (state == ConnectOrderState.WaitConnect.getState()) {
                TextView textView = (TextView) this.itemView.findViewById(R$id.connect_state_txt);
                textView.setTextColor(-5658199);
                textView.setText(this.itemView.getContext().getString(R$string.wait_connecting));
            } else if (state == ConnectOrderState.Connecting.getState()) {
                TextView textView2 = (TextView) this.itemView.findViewById(R$id.connect_state_txt);
                textView2.setTextColor(-16777216);
                textView2.setText(this.itemView.getContext().getString(R$string.connecting));
            }
        }
    }
}
