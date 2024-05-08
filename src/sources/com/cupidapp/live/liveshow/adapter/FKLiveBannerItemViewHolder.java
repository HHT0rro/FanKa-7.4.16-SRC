package com.cupidapp.live.liveshow.adapter;

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

/* compiled from: FKLiveBannerViwPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBannerItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14802c = new a(null);

    /* compiled from: FKLiveBannerViwPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveBannerItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveBannerItemViewHolder(z.b(parent, R$layout.view_holder_live_banner_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBannerItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AdModel) {
            int l10 = h.l(this) - h.c(this, 2.0f);
            View view = this.itemView;
            int i10 = R$id.liveBannerItemImageView;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView, "itemView.liveBannerItemImageView");
            AdModel adModel = (AdModel) obj;
            y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf(adModel.getImage().getScaleHeightByWidth(l10)));
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.liveBannerItemImageView");
            ImageLoaderView.g(imageLoaderView2, adModel.getImage(), null, null, 6, null);
        }
    }
}
