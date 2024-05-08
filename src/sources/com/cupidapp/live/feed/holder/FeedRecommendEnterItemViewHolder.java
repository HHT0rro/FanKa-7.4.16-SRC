package com.cupidapp.live.feed.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRecommendResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.m;
import z0.u;
import z0.z;

/* compiled from: FeedRecommendEnterItemViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRecommendEnterItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14389c = new a(null);

    /* compiled from: FeedRecommendEnterItemViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedRecommendEnterItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedRecommendEnterItemViewHolder(z.b(parent, R$layout.view_holder_feed_recommend_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedRecommendEnterItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        FeedModel post;
        String title;
        if (!(obj instanceof FeedRecommendResult) || (post = ((FeedRecommendResult) obj).getPost()) == null) {
            return;
        }
        ImageModel imageListFirst = post.getImageListFirst();
        if (imageListFirst != null) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.enterCoverImageView);
            s.h(imageLoaderView, "itemView.enterCoverImageView");
            ImageLoaderView.g(imageLoaderView, imageListFirst, null, null, 6, null);
        }
        TextView textView = (TextView) this.itemView.findViewById(R$id.enterTitle);
        String title2 = post.getTitle();
        if (title2 == null || title2.length() == 0) {
            title = post.getDescription();
        } else {
            title = post.getTitle();
        }
        textView.setText(title);
        ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.avatarImg);
        s.h(imageLoaderView2, "itemView.avatarImg");
        ImageLoaderView.g(imageLoaderView2, post.getUser().getAvatarImage(), null, null, 6, null);
        ((TextView) this.itemView.findViewById(R$id.userNameTxt)).setText(post.getUser().getName());
        View view = this.itemView;
        int i10 = R$id.linkcountTxt;
        TextView textView2 = (TextView) view.findViewById(i10);
        int likeCount = post.getLikeCount();
        Context context = ((TextView) this.itemView.findViewById(i10)).getContext();
        s.h(context, "itemView.linkcountTxt.context");
        textView2.setText(m.e(likeCount, context));
        r(post);
        if (post.getVideo() == null && post.getImageListCount() <= 1) {
            ((ImageView) this.itemView.findViewById(R$id.videoOrMultiImageIcon)).setVisibility(8);
            return;
        }
        View view2 = this.itemView;
        int i11 = R$id.videoOrMultiImageIcon;
        ((ImageView) view2.findViewById(i11)).setVisibility(0);
        ((ImageView) this.itemView.findViewById(i11)).setImageResource(post.getVideo() != null ? R$mipmap.icon_video_play : R$mipmap.icon_multi_images);
    }

    public final void r(FeedModel feedModel) {
        TextView textView = (TextView) this.itemView.findViewById(R$id.linkcountTxt);
        s.h(textView, "itemView.linkcountTxt");
        u.e(textView, feedModel.getLiked() ? R$mipmap.icon_small_yellow_like : R$mipmap.icon_small_like, 0, 0, 0, 14, null);
    }
}
