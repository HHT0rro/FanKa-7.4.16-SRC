package com.cupidapp.live.hashtag.detail;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.m;
import z0.u;
import z0.z;

/* compiled from: HashTagViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14695c = new a(null);

    /* compiled from: HashTagViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new HashTagViewHolder(z.b(parent, R$layout.view_holder_hashtag, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashTagViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        p pVar;
        String title;
        if (obj instanceof FeedModel) {
            FeedModel feedModel = (FeedModel) obj;
            ImageModel imageListFirst = feedModel.getImageListFirst();
            boolean z10 = true;
            if (imageListFirst != null) {
                float width = imageListFirst.getWidth() / imageListFirst.getHeight();
                if (width > 1.0f) {
                    width = 1.0f;
                } else if (width < 0.75f) {
                    width = 0.75f;
                }
                s(width);
                if (feedModel.getVideo() == null && feedModel.getImageListCount() <= 1) {
                    ((ImageView) this.itemView.findViewById(R$id.videoOrMultiImageIcon)).setVisibility(8);
                } else {
                    View view = this.itemView;
                    int i10 = R$id.videoOrMultiImageIcon;
                    ((ImageView) view.findViewById(i10)).setVisibility(0);
                    ((ImageView) this.itemView.findViewById(i10)).setImageResource(feedModel.getVideo() != null ? R$mipmap.icon_video_play : R$mipmap.icon_multi_images);
                }
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.hashtagCoverImageView);
                s.h(imageLoaderView, "itemView.hashtagCoverImageView");
                ImageLoaderView.g(imageLoaderView, imageListFirst, null, null, 6, null);
                pVar = p.f51048a;
            } else {
                pVar = null;
            }
            if (pVar == null) {
                s(0.75f);
            }
            String hotTag = feedModel.getHotTag();
            if (hotTag == null || kotlin.text.p.t(hotTag)) {
                ((TextView) this.itemView.findViewById(R$id.hotTagTxt)).setVisibility(8);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.hotTagTxt;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(feedModel.getHotTag());
            }
            TextView textView = (TextView) this.itemView.findViewById(R$id.hashtagTitle);
            String title2 = feedModel.getTitle();
            if (title2 != null && title2.length() != 0) {
                z10 = false;
            }
            if (z10) {
                title = feedModel.getDescription();
            } else {
                title = feedModel.getTitle();
            }
            textView.setText(title);
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.avatarImg);
            s.h(imageLoaderView2, "itemView.avatarImg");
            ImageLoaderView.g(imageLoaderView2, feedModel.getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.userNameTxt)).setText(feedModel.getUser().getName());
            View view3 = this.itemView;
            int i12 = R$id.linkcountTxt;
            TextView textView2 = (TextView) view3.findViewById(i12);
            int likeCount = feedModel.getLikeCount();
            Context context = ((TextView) this.itemView.findViewById(i12)).getContext();
            s.h(context, "itemView.linkcountTxt.context");
            textView2.setText(m.e(likeCount, context));
            r(feedModel);
        }
    }

    public final void r(@NotNull FeedModel model) {
        s.i(model, "model");
        TextView textView = (TextView) this.itemView.findViewById(R$id.linkcountTxt);
        s.h(textView, "itemView.linkcountTxt");
        u.e(textView, model.getLiked() ? R$mipmap.icon_recommend_like_highlight : R$mipmap.icon_recommend_like, 0, 0, 0, 14, null);
    }

    public final void s(float f10) {
        int l10 = (h.l(this) - h.c(this, 12.0f)) / 2;
        View view = this.itemView;
        int i10 = R$id.hashtagCoverImageView;
        ViewGroup.LayoutParams layoutParams = ((ImageLoaderView) view.findViewById(i10)).getLayoutParams();
        layoutParams.width = l10;
        layoutParams.height = (int) (l10 / f10);
        ((ImageLoaderView) this.itemView.findViewById(i10)).setLayoutParams(layoutParams);
    }
}
