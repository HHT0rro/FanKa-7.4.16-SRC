package com.cupidapp.live.feed.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.layout.AdPostTagLayout;
import com.cupidapp.live.feed.model.FeedTabBtnModel;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: AdTagPostViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdTagPostViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14364c = new a(null);

    /* compiled from: AdTagPostViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AdTagPostViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AdTagPostViewHolder(z.b(parent, R$layout.item_ad_tag_post, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdTagPostViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AdTagPostUiModel) {
            AdTagPostUiModel adTagPostUiModel = (AdTagPostUiModel) obj;
            float f10 = 0.75f;
            if (adTagPostUiModel.getImage() != null) {
                float width = adTagPostUiModel.getImage().getWidth() / adTagPostUiModel.getImage().getHeight();
                if (width <= 1.0f) {
                    if (width >= 0.75f) {
                        f10 = width;
                    }
                    int l10 = (z0.h.l(this) - z0.h.c(this, 12.0f)) / 2;
                    View view = this.itemView;
                    int i10 = R$id.ad_tag_post_bg;
                    ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
                    s.h(imageLoaderView, "itemView.ad_tag_post_bg");
                    y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf((int) (l10 / f10)));
                    ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
                    s.h(imageLoaderView2, "itemView.ad_tag_post_bg");
                    ImageLoaderView.g(imageLoaderView2, adTagPostUiModel.getImage(), null, null, 6, null);
                    r(l10, adTagPostUiModel);
                }
            }
            f10 = 1.0f;
            int l102 = (z0.h.l(this) - z0.h.c(this, 12.0f)) / 2;
            View view2 = this.itemView;
            int i102 = R$id.ad_tag_post_bg;
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) view2.findViewById(i102);
            s.h(imageLoaderView3, "itemView.ad_tag_post_bg");
            y.n(imageLoaderView3, Integer.valueOf(l102), Integer.valueOf((int) (l102 / f10)));
            ImageLoaderView imageLoaderView22 = (ImageLoaderView) this.itemView.findViewById(i102);
            s.h(imageLoaderView22, "itemView.ad_tag_post_bg");
            ImageLoaderView.g(imageLoaderView22, adTagPostUiModel.getImage(), null, null, 6, null);
            r(l102, adTagPostUiModel);
        }
    }

    public final void r(int i10, AdTagPostUiModel adTagPostUiModel) {
        View findViewById;
        int c4 = (i10 - z0.h.c(this, 14.0f)) / 2;
        List<FeedTabBtnModel> tabList = adTagPostUiModel.getTabList();
        if (tabList != null) {
            int i11 = 0;
            for (FeedTabBtnModel feedTabBtnModel : tabList) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                FeedTabBtnModel feedTabBtnModel2 = feedTabBtnModel;
                if (i11 < 2) {
                    findViewById = this.itemView.findViewById(R$id.ad_tag_post_first);
                } else {
                    findViewById = this.itemView.findViewById(R$id.ad_tag_post_second);
                }
                Context context = this.itemView.getContext();
                s.h(context, "itemView.context");
                AdPostTagLayout adPostTagLayout = new AdPostTagLayout(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c4, c4);
                layoutParams.setMarginStart(z0.h.c(layoutParams, 2.0f));
                layoutParams.setMarginEnd(z0.h.c(layoutParams, 2.0f));
                adPostTagLayout.setLayoutParams(layoutParams);
                adPostTagLayout.f(feedTabBtnModel2.getIconImage(), feedTabBtnModel2.getTabName(), feedTabBtnModel2.getJumpUrl());
                ((LinearLayout) findViewById).addView(adPostTagLayout);
                i11 = i12;
            }
        }
    }
}
