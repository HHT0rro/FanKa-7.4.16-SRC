package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.profile.model.AlohaCancelUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AlohaCancelViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AlohaCancelViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17800c = new a(null);

    /* compiled from: AlohaCancelViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlohaCancelViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AlohaCancelViewHolder(z.b(parent, R$layout.item_aloha_cancel, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlohaCancelViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AlohaCancelUserModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.aloha_cancel_user_avatar);
            s.h(imageLoaderView, "itemView.aloha_cancel_user_avatar");
            AlohaCancelUserModel alohaCancelUserModel = (AlohaCancelUserModel) obj;
            ImageLoaderView.g(imageLoaderView, alohaCancelUserModel.getUser().getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.aloha_cancel_user_name;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i10)).setText(alohaCancelUserModel.getUser().getName());
            ((TextView) this.itemView.findViewById(R$id.del_time)).setText(alohaCancelUserModel.getCancelTime());
            ((UserIconViewLayout) this.itemView.findViewById(R$id.aloha_cancel_vip)).c(alohaCancelUserModel.getUser().getUserVipModel(), SensorPosition.CancelAloha, UserIconViewLayout.VipIconPositionRef.Other, false);
        }
    }
}
