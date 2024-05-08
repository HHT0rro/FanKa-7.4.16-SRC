package com.cupidapp.live.consult.view;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.consult.model.ConsultBannerModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ConsultBannerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultBannerItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13839c = new a(null);

    /* compiled from: ConsultBannerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConsultBannerItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ConsultBannerItemViewHolder(z.b(parent, R$layout.view_holder_consult_banner_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultBannerItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        ImageModel bgImage;
        if (!(obj instanceof ConsultBannerModel) || (bgImage = ((ConsultBannerModel) obj).getBgImage()) == null) {
            return;
        }
        int l10 = h.l(this) - h.c(this, 8.0f);
        int scaleHeightByWidth = bgImage.getScaleHeightByWidth(l10);
        View view = this.itemView;
        int i10 = R$id.consult_banner_imageview;
        ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
        s.h(imageLoaderView, "itemView.consult_banner_imageview");
        y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf(scaleHeightByWidth));
        ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
        s.h(imageLoaderView2, "itemView.consult_banner_imageview");
        ImageLoaderView.g(imageLoaderView2, bgImage, null, null, 6, null);
    }
}
