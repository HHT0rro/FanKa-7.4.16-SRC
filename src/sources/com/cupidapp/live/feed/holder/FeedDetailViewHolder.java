package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.feed.model.FeedModel;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedDetailViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailViewHolder extends BaseFeedViewHolder {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f14382j = new a(null);

    /* compiled from: FeedDetailViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedDetailViewHolder a(@NotNull ViewGroup parent, @NotNull b feedListPraiseListener, @NotNull c baseFeedListener, @Nullable FeedSensorContext feedSensorContext, @Nullable Map<String, ? extends Object> map) {
            s.i(parent, "parent");
            s.i(feedListPraiseListener, "feedListPraiseListener");
            s.i(baseFeedListener, "baseFeedListener");
            FeedDetailViewHolder feedDetailViewHolder = new FeedDetailViewHolder(z.b(parent, R$layout.view_holder_feed, false, 2, null));
            feedDetailViewHolder.M(feedListPraiseListener);
            feedDetailViewHolder.P(feedSensorContext);
            feedDetailViewHolder.O(map);
            feedDetailViewHolder.L(baseFeedListener);
            return feedDetailViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        N(false);
    }

    @Override // com.cupidapp.live.feed.holder.BaseFeedViewHolder, com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        super.n(obj);
        ((TextView) this.itemView.findViewById(R$id.privateChatButton)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.feedMenuBarLayout)).setVisibility(8);
        this.itemView.findViewById(R$id.bottomLine).setVisibility(0);
        if (obj instanceof FeedModel) {
            ((ImageView) this.itemView.findViewById(R$id.close_friend_can_see_icon)).setVisibility(((FeedModel) obj).getCloseFriendOnly() ? 0 : 8);
        }
    }
}
