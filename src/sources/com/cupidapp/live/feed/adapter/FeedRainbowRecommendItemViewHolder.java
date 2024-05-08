package com.cupidapp.live.feed.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.UserWithPostLimitStatusModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FeedRainbowRecommendAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRainbowRecommendItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14184c = new a(null);

    /* compiled from: FeedRainbowRecommendAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedRainbowRecommendItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedRainbowRecommendItemViewHolder(z.b(parent, R$layout.view_holder_rainbow_recommend_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedRainbowRecommendItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.recommend_textview);
        s.h(textView, "itemView.recommend_textview");
        u.a(textView);
        float l10 = (h.l(this) - (h.c(this, 12.0f) * 4)) / 3.5f;
        y.n(itemView, Integer.valueOf((int) l10), Integer.valueOf((int) ((4 * l10) / 3)));
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedRainbowRecommendItemModel) {
            FeedRainbowRecommendItemModel feedRainbowRecommendItemModel = (FeedRainbowRecommendItemModel) obj;
            UserWithPostLimitStatusModel user = feedRainbowRecommendItemModel.getUser();
            TextView textView = (TextView) this.itemView.findViewById(R$id.recommend_textview);
            s.h(textView, "itemView.recommend_textview");
            Boolean me2 = user.getMe();
            Boolean bool = Boolean.TRUE;
            textView.setVisibility(s.d(me2, bool) && !feedRainbowRecommendItemModel.getOpenRecommend() ? 0 : 8);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.rainbow_recommend_avatar_imageview);
            s.h(imageLoaderView, "itemView.rainbow_recommend_avatar_imageview");
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.recommend_name_textview)).setText(user.getName());
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.aloha_imageview);
            s.h(imageView, "itemView.aloha_imageview");
            imageView.setVisibility((s.d(user.getAloha(), bool) || s.d(user.getMe(), bool)) ? false : true ? 0 : 8);
        }
    }
}
