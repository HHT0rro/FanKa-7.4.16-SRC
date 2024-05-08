package com.cupidapp.live.feed.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.AdModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: AdBannerViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdBannerItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14171c = new a(null);

    /* compiled from: AdBannerViewPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AdBannerItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AdBannerItemViewHolder(z.b(parent, R$layout.item_ad_banner, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBannerItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AdModel) {
            View view = this.itemView;
            int i10 = R$id.adBannerItemImg;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView, "itemView.adBannerItemImg");
            AdModel adModel = (AdModel) obj;
            ImageLoaderView.g(imageLoaderView, adModel.getImage(), null, null, 6, null);
            int l10 = h.l(this) - h.c(this, 8.0f);
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.adBannerItemImg");
            y.n(imageLoaderView2, Integer.valueOf(l10), Integer.valueOf(adModel.getImage().getScaleHeightByWidth(l10)));
        }
    }
}
