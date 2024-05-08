package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.feed.layout.PostSendMsgLayout;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import com.cupidapp.live.setting.model.LimitRangeType;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: PostLimitViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14405d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final FKSensorContext f14406c;

    /* compiled from: PostLimitViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostLimitViewHolder a(@NotNull ViewGroup parent, @Nullable FKSensorContext fKSensorContext) {
            s.i(parent, "parent");
            return new PostLimitViewHolder(z.b(parent, R$layout.item_post_detail, false, 2, null), fKSensorContext);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitViewHolder(@NotNull View itemView, @Nullable FKSensorContext fKSensorContext) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14406c = fKSensorContext;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        UserVipDetailModel userVipModel;
        if (obj instanceof PostLimitDetailModel) {
            View view = this.itemView;
            int i10 = R$id.post_img;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView, "itemView.post_img");
            y.n(imageLoaderView, Integer.valueOf(z0.h.l(this)), Integer.valueOf(z0.h.k(this) - z0.h.c(this, 80.0f)));
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.post_img");
            PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) obj;
            ImageLoaderView.g(imageLoaderView2, postLimitDetailModel.getImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, ContextCompat.getColor(this.itemView.getContext(), R$color.app_transparent), 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 4, null);
            TextView textView = (TextView) this.itemView.findViewById(R$id.post_user_name);
            User user = postLimitDetailModel.getUser();
            textView.setText(user != null ? user.getName() : null);
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(R$id.post_user_avatar);
            s.h(imageLoaderView3, "itemView.post_user_avatar");
            User user2 = postLimitDetailModel.getUser();
            ImageLoaderView.g(imageLoaderView3, user2 != null ? user2.getAvatarImage() : null, null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.post_expire_time)).setText(postLimitDetailModel.getTimeContent());
            User user3 = postLimitDetailModel.getUser();
            if (user3 != null && (userVipModel = user3.getUserVipModel()) != null) {
                UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
                s.h(userIconViewLayout, "itemView.vipIconImageView");
                UserIconViewLayout.d(userIconViewLayout, userVipModel, SensorPosition.PostLimit, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            }
            com.cupidapp.live.profile.logic.c cVar = com.cupidapp.live.profile.logic.c.f17839a;
            User user4 = postLimitDetailModel.getUser();
            if (cVar.a(user4 != null ? user4.userId() : null)) {
                ((ImageView) this.itemView.findViewById(R$id.more_img)).setVisibility(8);
                this.itemView.findViewById(R$id.post_concern_layout).setVisibility(8);
                ((PostSendMsgLayout) this.itemView.findViewById(R$id.post_send_msg_layout)).setVisibility(8);
                this.itemView.findViewById(R$id.viewer_layout).setVisibility(0);
                u(postLimitDetailModel);
                return;
            }
            ((ImageView) this.itemView.findViewById(R$id.more_img)).setVisibility(8);
            this.itemView.findViewById(R$id.viewer_layout).setVisibility(8);
            t(postLimitDetailModel);
        }
    }

    public final void r() {
        if (o() instanceof PostLimitDetailModel) {
            Object o10 = o();
            s.g(o10, "null cannot be cast to non-null type com.cupidapp.live.feed.model.PostLimitDetailModel");
            if (s((PostLimitDetailModel) o10)) {
                ((PostSendMsgLayout) this.itemView.findViewById(R$id.post_send_msg_layout)).w();
            }
        }
    }

    public final boolean s(PostLimitDetailModel postLimitDetailModel) {
        if (postLimitDetailModel.getMessageLimit() != LimitRangeType.PUBLIC.getValue()) {
            User user = postLimitDetailModel.getUser();
            if (!(user != null && user.isAlohaMatched())) {
                User user2 = postLimitDetailModel.getUser();
                if (!(user2 != null && user2.isFollowed()) || postLimitDetailModel.getMessageLimit() == LimitRangeType.MATCH.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
    
        if ((r0 != null && r0.getAlohaGet()) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t(com.cupidapp.live.feed.model.PostLimitDetailModel r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.holder.PostLimitViewHolder.t(com.cupidapp.live.feed.model.PostLimitDetailModel):void");
    }

    public final void u(PostLimitDetailModel postLimitDetailModel) {
        View findViewById = this.itemView.findViewById(R$id.viewer_layout);
        List<User> viewers = postLimitDetailModel.getViewers();
        if (viewers == null || viewers.isEmpty()) {
            ((LinearLayout) findViewById.findViewById(R$id.post_viewer_rl)).setVisibility(4);
        } else {
            ((LinearLayout) findViewById.findViewById(R$id.post_viewer_rl)).setVisibility(0);
            if (!postLimitDetailModel.getViewers().isEmpty()) {
                int i10 = R$id.viewer_first_avatar;
                ((ImageLoaderView) findViewById.findViewById(i10)).setVisibility(0);
                ImageLoaderView imageLoaderView = (ImageLoaderView) findViewById.findViewById(i10);
                s.h(imageLoaderView, "viewerLayout.viewer_first_avatar");
                ImageLoaderView.g(imageLoaderView, postLimitDetailModel.getViewers().get(0).getAvatarImage(), null, null, 6, null);
            }
            if (postLimitDetailModel.getViewers().size() > 1) {
                int i11 = R$id.viewer_second_avatar;
                ((ImageLoaderView) findViewById.findViewById(i11)).setVisibility(0);
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) findViewById.findViewById(i11);
                s.h(imageLoaderView2, "viewerLayout.viewer_second_avatar");
                ImageLoaderView.g(imageLoaderView2, postLimitDetailModel.getViewers().get(1).getAvatarImage(), null, null, 6, null);
            }
            int i12 = R$id.viewer_number;
            ((TextView) findViewById.findViewById(i12)).setVisibility(0);
            ((TextView) findViewById.findViewById(i12)).setText(postLimitDetailModel.getViewCount());
            TextView textView = (TextView) findViewById.findViewById(i12);
            s.h(textView, "viewerLayout.viewer_number");
            u.a(textView);
        }
        if (postLimitDetailModel.getExpired()) {
            ((TextView) findViewById.findViewById(R$id.publish_limit_post)).setVisibility(4);
        } else {
            ((TextView) findViewById.findViewById(R$id.publish_limit_post)).setVisibility(0);
        }
    }

    public final void v() {
        ((PostSendMsgLayout) this.itemView.findViewById(R$id.post_send_msg_layout)).z();
    }
}
