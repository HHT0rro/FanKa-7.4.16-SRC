package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.layout.FeedVideoContentLayout;
import com.cupidapp.live.feed.model.FeedShowCaseViewModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedShowCaseViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedShowCaseViewHolder extends FKBaseRecyclerViewHolder implements d {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14390c = new a(null);

    /* compiled from: FeedShowCaseViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedShowCaseViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedShowCaseViewHolder(z.b(parent, R$layout.layout_feed_show_case, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedShowCaseViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void a() {
        FeedVideoContentLayout feedVideoContentLayout = (FeedVideoContentLayout) this.itemView.findViewById(R$id.showCaseVideoLayout);
        if (feedVideoContentLayout != null) {
            feedVideoContentLayout.l();
        }
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void b() {
        FeedVideoContentLayout feedVideoContentLayout = (FeedVideoContentLayout) this.itemView.findViewById(R$id.showCaseVideoLayout);
        if (feedVideoContentLayout != null) {
            feedVideoContentLayout.k();
        }
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void c() {
        FeedVideoContentLayout feedVideoContentLayout = (FeedVideoContentLayout) this.itemView.findViewById(R$id.showCaseVideoLayout);
        if (feedVideoContentLayout != null) {
            feedVideoContentLayout.m();
        }
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void f() {
        FeedVideoContentLayout feedVideoContentLayout = (FeedVideoContentLayout) this.itemView.findViewById(R$id.showCaseVideoLayout);
        if (feedVideoContentLayout != null) {
            feedVideoContentLayout.n();
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedShowCaseViewModel) {
            FeedShowCaseViewModel feedShowCaseViewModel = (FeedShowCaseViewModel) obj;
            if (feedShowCaseViewModel.getFeedModel().getVideo() != null) {
                View view = this.itemView;
                int i10 = R$id.showCaseVideoLayout;
                ((FeedVideoContentLayout) view.findViewById(i10)).setVisibility(0);
                ((ImageLoaderView) this.itemView.findViewById(R$id.showCaseImageView)).setVisibility(8);
                ((FeedVideoContentLayout) this.itemView.findViewById(i10)).setFeedModel(feedShowCaseViewModel.getFeedModel());
                return;
            }
            View view2 = this.itemView;
            int i11 = R$id.showCaseImageView;
            ((ImageLoaderView) view2.findViewById(i11)).setVisibility(0);
            ((FeedVideoContentLayout) this.itemView.findViewById(R$id.showCaseVideoLayout)).setVisibility(8);
            ImageModel imageListFirst = feedShowCaseViewModel.getFeedModel().getImageListFirst();
            if (imageListFirst == null) {
                return;
            }
            ((ImageLoaderView) this.itemView.findViewById(i11)).setLayoutParams(new FrameLayout.LayoutParams(z0.h.l(this), imageListFirst.getScaleHeightByWidth(z0.h.l(this))));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i11);
            s.h(imageLoaderView, "itemView.showCaseImageView");
            ImageLoaderView.g(imageLoaderView, imageListFirst, null, null, 6, null);
        }
    }
}
