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
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.m;
import z0.u;
import z0.z;

/* compiled from: RecommendFeedViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RecommendFeedViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14413c = new a(null);

    /* compiled from: RecommendFeedViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecommendFeedViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new RecommendFeedViewHolder(z.b(parent, R$layout.item_recommend_feed, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendFeedViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String title;
        if (obj instanceof FeedRecommendResult) {
            FeedRecommendResult feedRecommendResult = (FeedRecommendResult) obj;
            if (feedRecommendResult.getPost() == null) {
                return;
            }
            ImageModel imageListFirst = feedRecommendResult.getPost().getImageListFirst();
            boolean z10 = true;
            if (imageListFirst != null) {
                float width = imageListFirst.getWidth() / imageListFirst.getHeight();
                if (width > 1.0f) {
                    width = 1.0f;
                } else if (width < 0.75f) {
                    width = 0.75f;
                }
                int l10 = (z0.h.l(this) - z0.h.c(this, 12.0f)) / 2;
                View view = this.itemView;
                int i10 = R$id.recommendCoverImageView;
                ViewGroup.LayoutParams layoutParams = ((ImageLoaderView) view.findViewById(i10)).getLayoutParams();
                layoutParams.width = l10;
                layoutParams.height = (int) (l10 / width);
                ((ImageLoaderView) this.itemView.findViewById(i10)).setLayoutParams(layoutParams);
                if (feedRecommendResult.getPost().getVideo() == null && feedRecommendResult.getPost().getImageListCount() <= 1) {
                    ((ImageView) this.itemView.findViewById(R$id.videoOrMultiImageIcon)).setVisibility(8);
                } else {
                    View view2 = this.itemView;
                    int i11 = R$id.videoOrMultiImageIcon;
                    ((ImageView) view2.findViewById(i11)).setVisibility(0);
                    ((ImageView) this.itemView.findViewById(i11)).setImageResource(feedRecommendResult.getPost().getVideo() != null ? R$mipmap.icon_video_play : R$mipmap.icon_multi_images);
                }
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView, "itemView.recommendCoverImageView");
                ImageLoaderView.g(imageLoaderView, imageListFirst, null, null, 6, null);
            }
            String title2 = feedRecommendResult.getPost().getTitle();
            if (title2 == null || title2.length() == 0) {
                title = feedRecommendResult.getPost().getDescription();
            } else {
                title = feedRecommendResult.getPost().getTitle();
            }
            if (title == null || title.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.recommendTitle)).setVisibility(8);
            } else {
                View view3 = this.itemView;
                int i12 = R$id.recommendTitle;
                ((TextView) view3.findViewById(i12)).setText(title);
                ((TextView) this.itemView.findViewById(i12)).setVisibility(0);
            }
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.avatarImg);
            s.h(imageLoaderView2, "itemView.avatarImg");
            ImageLoaderView.g(imageLoaderView2, feedRecommendResult.getPost().getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.userNameTxt)).setText(feedRecommendResult.getPost().getUser().getName());
            View view4 = this.itemView;
            int i13 = R$id.linkcountTxt;
            TextView textView = (TextView) view4.findViewById(i13);
            int likeCount = feedRecommendResult.getPost().getLikeCount();
            Context context = ((TextView) this.itemView.findViewById(i13)).getContext();
            s.h(context, "itemView.linkcountTxt.context");
            textView.setText(m.e(likeCount, context));
            s(feedRecommendResult.getPost());
            r(feedRecommendResult.getLabelImage());
            String hotTag = feedRecommendResult.getPost().getHotTag();
            if (hotTag != null && !p.t(hotTag)) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this.itemView.findViewById(R$id.hotTagTxt)).setVisibility(8);
                return;
            }
            View view5 = this.itemView;
            int i14 = R$id.hotTagTxt;
            ((TextView) view5.findViewById(i14)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i14)).setText(feedRecommendResult.getPost().getHotTag());
        }
    }

    public final void r(ImageModel imageModel) {
        if (imageModel != null) {
            float width = imageModel.getHeight() != 0 ? imageModel.getWidth() / imageModel.getHeight() : 3.5f;
            int c4 = z0.h.c(this, 18.0f);
            View view = this.itemView;
            int i10 = R$id.label_img;
            ViewGroup.LayoutParams layoutParams = ((ImageLoaderView) view.findViewById(i10)).getLayoutParams();
            layoutParams.width = (int) (c4 * width);
            layoutParams.height = c4;
            ((ImageLoaderView) this.itemView.findViewById(i10)).setLayoutParams(layoutParams);
            ((ImageLoaderView) this.itemView.findViewById(i10)).setVisibility(0);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView, "itemView.label_img");
            ImageLoaderView.g(imageLoaderView, imageModel, null, null, 6, null);
            return;
        }
        ((ImageLoaderView) this.itemView.findViewById(R$id.label_img)).setVisibility(8);
    }

    public final void s(@NotNull FeedModel model) {
        s.i(model, "model");
        TextView textView = (TextView) this.itemView.findViewById(R$id.linkcountTxt);
        s.h(textView, "itemView.linkcountTxt");
        u.e(textView, model.getLiked() ? R$mipmap.icon_recommend_like_highlight : R$mipmap.icon_recommend_like, 0, 0, 0, 14, null);
    }
}
