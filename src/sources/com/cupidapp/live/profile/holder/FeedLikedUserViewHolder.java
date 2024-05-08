package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.UserIconViewLayout;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FeedLikedUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedLikedUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17806c = new a(null);

    /* compiled from: FeedLikedUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedLikedUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedLikedUserViewHolder(z.b(parent, R$layout.view_holder_feed_liked_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedLikedUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedLikedUserUiModel) {
            int l10 = (h.l(this) - (h.c(this, 10.0f) * 4)) / 3;
            View view = this.itemView;
            int i10 = R$id.feed_liked_user_root_layout;
            RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) view.findViewById(i10);
            s.h(roundedFrameLayout, "itemView.feed_liked_user_root_layout");
            y.n(roundedFrameLayout, Integer.valueOf(l10), Integer.valueOf((l10 * 4) / 3));
            ((RoundedFrameLayout) this.itemView.findViewById(i10)).setCornerRadius(h.c(this, 8.0f));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.feed_liked_user_avatar_img);
            s.h(imageLoaderView, "itemView.feed_liked_user_avatar_img");
            FeedLikedUserUiModel feedLikedUserUiModel = (FeedLikedUserUiModel) obj;
            ImageLoaderView.g(imageLoaderView, feedLikedUserUiModel.getAvatarImage(), null, null, 6, null);
            View view2 = this.itemView;
            int i11 = R$id.feed_liked_user_name_text;
            ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i11)).setText(feedLikedUserUiModel.getName());
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.feed_liked_user_vip_img);
            s.h(userIconViewLayout, "itemView.feed_liked_user_vip_img");
            UserIconViewLayout.d(userIconViewLayout, feedLikedUserUiModel.getVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Profile, false, 8, null);
        }
    }
}
