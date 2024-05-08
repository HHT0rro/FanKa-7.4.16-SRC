package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.BanUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: BanUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BanUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17801c = new a(null);

    /* compiled from: BanUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BanUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new BanUserViewHolder(z.b(parent, R$layout.item_ban_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BanUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof BanUserModel) {
            BanUserModel banUserModel = (BanUserModel) obj;
            if (banUserModel.getBottomSpaceHeight() > 0) {
                View view = this.itemView;
                int i10 = R$id.ban_footer_space;
                view.findViewById(i10).setVisibility(0);
                View findViewById = this.itemView.findViewById(i10);
                s.h(findViewById, "itemView.ban_footer_space");
                y.o(findViewById, null, Integer.valueOf(banUserModel.getBottomSpaceHeight()), 1, null);
                return;
            }
            this.itemView.findViewById(R$id.ban_footer_space).setVisibility(8);
        }
    }
}
