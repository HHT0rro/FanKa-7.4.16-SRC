package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.feed.FeedSensorType;
import com.cupidapp.live.feed.layout.FeedAdTipLayout;
import com.cupidapp.live.feed.layout.FeedUserInfoLayout;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.PostBoostModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: TrendFeedViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TrendFeedViewHolder extends BaseFeedViewHolder {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f14417m = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public boolean f14418j;

    /* renamed from: k, reason: collision with root package name */
    public int f14419k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public i f14420l;

    /* compiled from: TrendFeedViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TrendFeedViewHolder a(@NotNull ViewGroup parent, boolean z10, @NotNull c baseFeedListener, @Nullable FeedSensorContext feedSensorContext, int i10) {
            s.i(parent, "parent");
            s.i(baseFeedListener, "baseFeedListener");
            TrendFeedViewHolder trendFeedViewHolder = new TrendFeedViewHolder(z.b(parent, R$layout.view_holder_feed, false, 2, null));
            trendFeedViewHolder.f14418j = z10;
            trendFeedViewHolder.P(feedSensorContext);
            trendFeedViewHolder.L(baseFeedListener);
            trendFeedViewHolder.f14419k = i10;
            ViewGroup.LayoutParams layoutParams = trendFeedViewHolder.itemView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = z0.h.c(trendFeedViewHolder, 30.0f);
            }
            return trendFeedViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendFeedViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f14418j = true;
    }

    public static final void i0(final TrendFeedViewHolder this$0) {
        s.i(this$0, "this$0");
        p1.g.f52734a.m2(Boolean.FALSE);
        ((ImageView) this$0.itemView.findViewById(R$id.share_menu_tip)).setVisibility(0);
        i iVar = new i();
        this$0.f14420l = iVar;
        i.d(iVar, 5, 1, new Function0<p>() { // from class: com.cupidapp.live.feed.holder.TrendFeedViewHolder$showFeedTopTipPop$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i iVar2;
                ((ImageView) TrendFeedViewHolder.this.itemView.findViewById(R$id.share_menu_tip)).setVisibility(8);
                iVar2 = TrendFeedViewHolder.this.f14420l;
                if (iVar2 != null) {
                    iVar2.g();
                }
                TrendFeedViewHolder.this.f14420l = null;
            }
        }, null, 8, null);
    }

    public static final void k0(final TrendFeedViewHolder this$0) {
        s.i(this$0, "this$0");
        p1.g.f52734a.r2(Boolean.FALSE);
        ((ImageView) this$0.itemView.findViewById(R$id.focus_tip)).setVisibility(0);
        i iVar = new i();
        this$0.f14420l = iVar;
        i.d(iVar, 5, 1, new Function0<p>() { // from class: com.cupidapp.live.feed.holder.TrendFeedViewHolder$showFocusTipPop$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i iVar2;
                ((ImageView) TrendFeedViewHolder.this.itemView.findViewById(R$id.focus_tip)).setVisibility(8);
                iVar2 = TrendFeedViewHolder.this.f14420l;
                if (iVar2 != null) {
                    iVar2.g();
                }
                TrendFeedViewHolder.this.f14420l = null;
            }
        }, null, 8, null);
    }

    public final void c0(boolean z10) {
        ((ImageView) this.itemView.findViewById(R$id.ic_feed_spread)).setVisibility(z10 ? 0 : 8);
    }

    public final void d0(PostBoostModel postBoostModel, boolean z10, boolean z11, boolean z12) {
        ImageModel image;
        if (z10) {
            if (!z11 && !z12) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.feed_boost_img);
                s.h(imageLoaderView, "itemView.feed_boost_img");
                y.m(imageLoaderView, null, null, Integer.valueOf(z0.h.c(this, 12.0f)), null, 11, null);
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.feed_boost_img);
                s.h(imageLoaderView2, "itemView.feed_boost_img");
                y.m(imageLoaderView2, null, null, Integer.valueOf(z0.h.c(this, 48.0f)), null, 11, null);
            }
            int c4 = z0.h.c(this, 24.0f);
            int scaleWidthByHeight = (postBoostModel == null || (image = postBoostModel.getImage()) == null) ? 0 : image.getScaleWidthByHeight(c4);
            View view = this.itemView;
            int i10 = R$id.feed_boost_img;
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView3, "itemView.feed_boost_img");
            y.n(imageLoaderView3, Integer.valueOf(scaleWidthByHeight), Integer.valueOf(c4));
            ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView4, "itemView.feed_boost_img");
            ImageLoaderView.g(imageLoaderView4, postBoostModel != null ? postBoostModel.getImage() : null, null, null, 6, null);
            ((ImageLoaderView) this.itemView.findViewById(i10)).setVisibility(0);
            return;
        }
        ((ImageLoaderView) this.itemView.findViewById(R$id.feed_boost_img)).setVisibility(8);
    }

    public final void e0(FeedModel feedModel) {
        if (getAbsoluteAdapterPosition() == this.f14419k && !s.d(feedModel.getSensorFeedType(), FeedSensorType.SponsorPost.getValue())) {
            FeedSensorContext F = F();
            if ((F != null ? F.getPosition() : null) == SensorPosition.PostStream && com.cupidapp.live.profile.logic.c.f17839a.a(feedModel.getUser().userId()) && s.d(p1.g.f52734a.C(), Boolean.TRUE)) {
                h0();
                return;
            }
        }
        if (s.d(feedModel.getSensorFeedType(), FeedSensorType.SponsorPost.getValue()) || !feedModel.getUser().getFocus() || com.cupidapp.live.profile.logic.c.f17839a.a(feedModel.getUser().userId())) {
            return;
        }
        j0();
    }

    public final void f0() {
        FeedAdTipLayout feedAdTipLayout;
        View view = this.itemView;
        int i10 = R$id.feed_ad_tip_layout;
        FeedAdTipLayout feedAdTipLayout2 = (FeedAdTipLayout) view.findViewById(i10);
        boolean z10 = false;
        if (feedAdTipLayout2 != null && feedAdTipLayout2.getVisibility() == 0) {
            z10 = true;
        }
        if (!z10 || (feedAdTipLayout = (FeedAdTipLayout) this.itemView.findViewById(i10)) == null) {
            return;
        }
        feedAdTipLayout.l();
    }

    public final void g0(FeedModel feedModel) {
        ((TextView) this.itemView.findViewById(R$id.feed_top_tag)).setVisibility(s.d(feedModel.getDynamicTop(), Boolean.TRUE) ? 0 : 8);
    }

    public final void h0() {
        if (s.d(p1.g.f52734a.C(), Boolean.TRUE)) {
            FeedSensorContext F = F();
            if ((F != null ? F.getPosition() : null) == SensorPosition.PostStream) {
                ImageView imageView = (ImageView) ((FeedUserInfoLayout) this.itemView.findViewById(R$id.feedUserInfoLayout)).findViewById(R$id.feedShareButton);
                if (imageView != null) {
                    imageView.post(new Runnable() { // from class: com.cupidapp.live.feed.holder.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            TrendFeedViewHolder.i0(TrendFeedViewHolder.this);
                        }
                    });
                    return;
                }
                return;
            }
        }
        ((ImageView) this.itemView.findViewById(R$id.share_menu_tip)).setVisibility(8);
    }

    public final void j0() {
        if (s.d(p1.g.f52734a.H(), Boolean.TRUE)) {
            FeedSensorContext F = F();
            if ((F != null ? F.getPosition() : null) == SensorPosition.Feed) {
                ImageView imageView = (ImageView) ((FeedUserInfoLayout) this.itemView.findViewById(R$id.feedUserInfoLayout)).findViewById(R$id.focusTagImg);
                if (imageView != null) {
                    imageView.post(new Runnable() { // from class: com.cupidapp.live.feed.holder.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            TrendFeedViewHolder.k0(TrendFeedViewHolder.this);
                        }
                    });
                    return;
                }
                return;
            }
        }
        ((ImageView) this.itemView.findViewById(R$id.focus_tip)).setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c0, code lost:
    
        if (r8.canShowAdSpread(r0 != null ? r0.getPosition() : null) != false) goto L19;
     */
    @Override // com.cupidapp.live.feed.holder.BaseFeedViewHolder, com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(@org.jetbrains.annotations.Nullable java.lang.Object r8) {
        /*
            r7 = this;
            super.n(r8)
            boolean r0 = r8 instanceof com.cupidapp.live.feed.model.FeedModel
            if (r0 == 0) goto Lc6
            android.view.View r0 = r7.itemView
            int r1 = com.cupidapp.live.R$id.feedUserInfoLayout
            android.view.View r0 = r0.findViewById(r1)
            com.cupidapp.live.feed.layout.FeedUserInfoLayout r0 = (com.cupidapp.live.feed.layout.FeedUserInfoLayout) r0
            r2 = 0
            r0.setVisibility(r2)
            android.view.View r0 = r7.itemView
            android.view.View r0 = r0.findViewById(r1)
            com.cupidapp.live.feed.layout.FeedUserInfoLayout r0 = (com.cupidapp.live.feed.layout.FeedUserInfoLayout) r0
            boolean r3 = r7.f14418j
            r0.setDisplayAlohaBtn(r3)
            android.view.View r0 = r7.itemView
            android.view.View r0 = r0.findViewById(r1)
            com.cupidapp.live.feed.layout.FeedUserInfoLayout r0 = (com.cupidapp.live.feed.layout.FeedUserInfoLayout) r0
            com.cupidapp.live.base.sensorslog.FeedSensorContext r3 = r7.F()
            r0.setSensorContext(r3)
            android.view.View r0 = r7.itemView
            android.view.View r0 = r0.findViewById(r1)
            com.cupidapp.live.feed.layout.FeedUserInfoLayout r0 = (com.cupidapp.live.feed.layout.FeedUserInfoLayout) r0
            com.cupidapp.live.feed.model.FeedModel r8 = (com.cupidapp.live.feed.model.FeedModel) r8
            r0.setFeedUserInfo(r8)
            android.view.View r0 = r7.itemView
            int r1 = com.cupidapp.live.R$id.feedCommentListLayout
            android.view.View r0 = r0.findViewById(r1)
            com.cupidapp.live.feed.layout.FeedCommentListLayout r0 = (com.cupidapp.live.feed.layout.FeedCommentListLayout) r0
            r0.setVisibility(r2)
            android.view.View r0 = r7.itemView
            android.view.View r0 = r0.findViewById(r1)
            com.cupidapp.live.feed.layout.FeedCommentListLayout r0 = (com.cupidapp.live.feed.layout.FeedCommentListLayout) r0
            com.cupidapp.live.base.sensorslog.FeedSensorContext r1 = r7.F()
            r0.b(r8, r1)
            android.view.View r0 = r7.itemView
            int r1 = com.cupidapp.live.R$id.focus_tip
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1 = 8
            r0.setVisibility(r1)
            android.view.View r0 = r7.itemView
            int r3 = com.cupidapp.live.R$id.share_menu_tip
            android.view.View r0 = r0.findViewById(r3)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r1)
            r7.g0(r8)
            com.cupidapp.live.feed.model.PostBoostModel r0 = r8.getPostBoostInfo()
            boolean r1 = r8.canPostBoost()
            int r3 = r8.getImageListCount()
            r4 = 1
            if (r3 <= r4) goto L8a
            r3 = 1
            goto L8b
        L8a:
            r3 = 0
        L8b:
            java.lang.String r5 = r8.getType()
            com.cupidapp.live.feed.FeedType r6 = com.cupidapp.live.feed.FeedType.VideoPost
            java.lang.String r6 = r6.getValue()
            boolean r5 = kotlin.jvm.internal.s.d(r5, r6)
            r7.d0(r0, r1, r3, r5)
            r7.e0(r8)
            com.cupidapp.live.base.sensorslog.FeedSensorContext r0 = r7.F()
            r1 = 0
            if (r0 == 0) goto Lab
            com.cupidapp.live.base.sensorslog.SensorPosition r0 = r0.getPosition()
            goto Lac
        Lab:
            r0 = r1
        Lac:
            boolean r0 = r8.canShowPostSpread(r0)
            if (r0 != 0) goto Lc2
            com.cupidapp.live.base.sensorslog.FeedSensorContext r0 = r7.F()
            if (r0 == 0) goto Lbc
            com.cupidapp.live.base.sensorslog.SensorPosition r1 = r0.getPosition()
        Lbc:
            boolean r8 = r8.canShowAdSpread(r1)
            if (r8 == 0) goto Lc3
        Lc2:
            r2 = 1
        Lc3:
            r7.c0(r2)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.holder.TrendFeedViewHolder.n(java.lang.Object):void");
    }
}
