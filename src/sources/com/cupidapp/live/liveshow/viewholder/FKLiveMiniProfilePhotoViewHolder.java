package com.cupidapp.live.liveshow.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.video.AppVideoLayout;
import com.cupidapp.live.liveshow.model.MiniProfilePopularFeedModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKLiveMiniProfilePhotoViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveMiniProfilePhotoViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16044c = new a(null);

    /* compiled from: FKLiveMiniProfilePhotoViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveMiniProfilePhotoViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveMiniProfilePhotoViewHolder(z.b(parent, R$layout.view_holder_mini_profile_photo, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfilePhotoViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MiniProfilePopularFeedModel) {
            MiniProfilePopularFeedModel miniProfilePopularFeedModel = (MiniProfilePopularFeedModel) obj;
            if (miniProfilePopularFeedModel.getImage() == null) {
                return;
            }
            int l10 = h.l(this) - (h.c(this, 10.0f) * 2);
            int scaleHeightByWidth = miniProfilePopularFeedModel.getImage().getScaleHeightByWidth(l10);
            if (miniProfilePopularFeedModel.getVideo() != null) {
                View view = this.itemView;
                int i10 = R$id.miniProfilePhotoVideoLayout;
                ((AppVideoLayout) view.findViewById(i10)).setVisibility(0);
                ((ImageLoaderView) this.itemView.findViewById(R$id.miniProfilePhotoImage)).setVisibility(8);
                ViewGroup.LayoutParams layoutParams = ((AppVideoLayout) this.itemView.findViewById(i10)).getLayoutParams();
                layoutParams.width = l10;
                layoutParams.height = scaleHeightByWidth;
                float c4 = h.c(this, 5.0f);
                AppVideoLayout appVideoLayout = (AppVideoLayout) this.itemView.findViewById(i10);
                appVideoLayout.setTopLeftRadius(c4);
                appVideoLayout.setTopRightRadius(c4);
                appVideoLayout.setBottomLeftRadius(c4);
                appVideoLayout.setBottomRightRadius(c4);
                ((AppVideoLayout) this.itemView.findViewById(i10)).d(miniProfilePopularFeedModel.getVideo(), miniProfilePopularFeedModel.getImage());
            } else {
                ((AppVideoLayout) this.itemView.findViewById(R$id.miniProfilePhotoVideoLayout)).setVisibility(8);
                View view2 = this.itemView;
                int i11 = R$id.miniProfilePhotoImage;
                ((ImageLoaderView) view2.findViewById(i11)).setVisibility(0);
                ViewGroup.LayoutParams layoutParams2 = ((ImageLoaderView) this.itemView.findViewById(i11)).getLayoutParams();
                layoutParams2.width = l10;
                layoutParams2.height = scaleHeightByWidth;
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i11);
                s.h(imageLoaderView, "itemView.miniProfilePhotoImage");
                ImageLoaderView.g(imageLoaderView, miniProfilePopularFeedModel.getImage(), null, null, 6, null);
            }
            ((TextView) this.itemView.findViewById(R$id.photoDescription)).setText(miniProfilePopularFeedModel.getDescription());
        }
    }
}
