package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.profile.model.User;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: PostViewerViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostViewerViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14407c = new a(null);

    /* compiled from: PostViewerViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostViewerViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new PostViewerViewHolder(z.b(parent, R$layout.item_post_viewer, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostViewerViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            if (user.getCanSendInboxMessage()) {
                ((ImageView) this.itemView.findViewById(R$id.viewer_relation_img)).setImageResource(R$mipmap.icon_feed_chat_online);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.viewer_relation_img)).setImageResource(R$mipmap.icon_feed_super_like);
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.viewer_avatar);
            s.h(imageLoaderView, "itemView.viewer_avatar");
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.viewer_name;
            ((TextView) view.findViewById(i10)).setText(user.getName());
            TextView textView = (TextView) this.itemView.findViewById(i10);
            s.h(textView, "itemView.viewer_name");
            u.a(textView);
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
            s.h(userIconViewLayout, "itemView.vipIconImageView");
            UserIconViewLayout.d(userIconViewLayout, user.getUserVipModel(), SensorPosition.PostLimit, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
        }
    }
}
