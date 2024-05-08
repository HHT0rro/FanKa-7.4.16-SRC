package com.cupidapp.live.feed.adapter;

import android.view.View;
import android.view.ViewGroup;
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
import z0.h;
import z0.z;

/* compiled from: RainbowRecommendAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RainbowRecommendViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14189c = new a(null);

    /* compiled from: RainbowRecommendAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RainbowRecommendViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new RainbowRecommendViewHolder(z.b(parent, R$layout.view_holder_rainbow_recommend, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RainbowRecommendViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof User) {
            if (getAbsoluteAdapterPosition() / 3 == 0) {
                this.itemView.setPadding(h.c(this, 0.5f), h.c(this, 16.0f), h.c(this, 0.5f), h.c(this, 0.5f));
            } else {
                this.itemView.setPadding(h.c(this, 0.5f), h.c(this, 0.5f), h.c(this, 0.5f), h.c(this, 0.5f));
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.recommend_user_avatar_imageview);
            s.h(imageLoaderView, "itemView.recommend_user_avatar_imageview");
            User user = (User) obj;
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.recommend_user_name_textview)).setText(user.getName());
            String distance = user.getDistance();
            if (distance == null || distance.length() == 0) {
                TextView textView = (TextView) this.itemView.findViewById(R$id.distance_textview);
                s.h(textView, "itemView.distance_textview");
                textView.setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.distance_textview;
                TextView textView2 = (TextView) view.findViewById(i10);
                s.h(textView2, "itemView.distance_textview");
                textView2.setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(user.getDistance());
            }
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.recommend_vip_icon_view);
            s.h(userIconViewLayout, "itemView.recommend_vip_icon_view");
            UserIconViewLayout.d(userIconViewLayout, user.getUserVipModel(), SensorPosition.RainbowRecommend, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
        }
    }
}
