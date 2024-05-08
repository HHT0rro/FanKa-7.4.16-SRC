package com.cupidapp.live.mentionuser.atuser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: RecommendAtUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RecommendAtUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17483c = new a(null);

    /* compiled from: RecommendAtUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecommendAtUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new RecommendAtUserViewHolder(z.b(parent, R$layout.item_recommend_at_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendAtUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof User) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.rect_userAvatarImageView);
            s.h(imageLoaderView, "itemView.rect_userAvatarImageView");
            User user = (User) obj;
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.rect_userNameTextView)).setText(user.getName());
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.rect_vipIconImageView);
            s.h(userIconViewLayout, "itemView.rect_vipIconImageView");
            UserIconViewLayout.d(userIconViewLayout, user.getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            if (user.getOnlineShowOpen()) {
                ((TextView) this.itemView.findViewById(R$id.rect_matchSignView)).setVisibility(4);
                ((ImageView) this.itemView.findViewById(R$id.rect_liveShowSignView)).setVisibility(0);
            } else if (user.getMatch()) {
                ((TextView) this.itemView.findViewById(R$id.rect_matchSignView)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(R$id.rect_liveShowSignView)).setVisibility(4);
            } else {
                ((TextView) this.itemView.findViewById(R$id.rect_matchSignView)).setVisibility(4);
                ((ImageView) this.itemView.findViewById(R$id.rect_liveShowSignView)).setVisibility(4);
            }
        }
    }
}
