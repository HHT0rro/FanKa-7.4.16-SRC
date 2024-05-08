package com.cupidapp.live.liveshow.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.LivePrivilegeType;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.LiveShowCoverTagView;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKRecommendLiveListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKRecommendLiveListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16053c = new a(null);

    /* compiled from: FKRecommendLiveListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKRecommendLiveListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKRecommendLiveListViewHolder(z.b(parent, R$layout.view_holder_recommend_live_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKRecommendLiveListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof FKRecommendLiveShowModel) {
            FKRecommendLiveShowModel fKRecommendLiveShowModel = (FKRecommendLiveShowModel) obj;
            LiveShowModel liveShow = fKRecommendLiveShowModel.getLiveShow();
            int l10 = (h.l(this) - h.c(this, 3.0f)) / 2;
            View view = this.itemView;
            int i10 = R$id.recommendLiveCoverImageView;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView, "itemView.recommendLiveCoverImageView");
            y.n(imageLoaderView, Integer.valueOf(l10), Integer.valueOf(l10));
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.recommendLiveCoverImageView");
            ImageLoaderView.g(imageLoaderView2, liveShow.getCoverImage(), null, null, 6, null);
            Drawable background = this.itemView.findViewById(R$id.recommendLiveShadowView).getBackground();
            GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
            float c4 = h.c(this, 2.0f);
            if (gradientDrawable != null) {
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, c4, c4, c4, c4});
            }
            ((TextView) this.itemView.findViewById(R$id.recommendLiveTitleTextView)).setText(liveShow.getTitle());
            ((TextView) this.itemView.findViewById(R$id.recommendUserNameTextView)).setText(liveShow.getUser().getName());
            ((TextView) this.itemView.findViewById(R$id.live_heat_textView)).setText(liveShow.getFormatHeatValue());
            if (liveShow.getDeco() == null) {
                ((ImageLoaderView) this.itemView.findViewById(R$id.recommendLiveTagImageView)).setVisibility(4);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.recommendLiveTagImageView;
                ((ImageLoaderView) view2.findViewById(i11)).setVisibility(0);
                ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i11);
                s.h(imageLoaderView3, "itemView.recommendLiveTagImageView");
                ImageLoaderView.g(imageLoaderView3, liveShow.getDeco().getIconImage(), null, null, 6, null);
            }
            if (liveShow.getLevelBadgeImage() != null) {
                View view3 = this.itemView;
                int i12 = R$id.recommendLiveBadgeImageView;
                ((ImageLoaderView) view3.findViewById(i12)).setVisibility(0);
                View view4 = this.itemView;
                int i13 = R$id.recommendLiveLevelText;
                ((TextView) view4.findViewById(i13)).setVisibility(0);
                int scaleWidthByHeight = liveShow.getLevelBadgeImage().getScaleWidthByHeight(h.c(this, 12.0f));
                ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(i12);
                s.h(imageLoaderView4, "itemView.recommendLiveBadgeImageView");
                y.o(imageLoaderView4, Integer.valueOf(scaleWidthByHeight), null, 2, null);
                ImageLoaderView imageLoaderView5 = (ImageLoaderView) this.itemView.findViewById(i12);
                s.h(imageLoaderView5, "itemView.recommendLiveBadgeImageView");
                ImageLoaderView.g(imageLoaderView5, liveShow.getLevelBadgeImage(), null, null, 6, null);
                TextView textView = (TextView) this.itemView.findViewById(i13);
                s.h(textView, "itemView.recommendLiveLevelText");
                u.a(textView);
                ((TextView) this.itemView.findViewById(i13)).setText(String.valueOf(liveShow.getAnchorLevel()));
            } else {
                ((ImageLoaderView) this.itemView.findViewById(R$id.recommendLiveBadgeImageView)).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.recommendLiveLevelText)).setVisibility(8);
            }
            if (liveShow.getAnchorPrivilegeType() == null) {
                ((TextView) this.itemView.findViewById(R$id.recommendLivePrivilegeIconView)).setVisibility(8);
            } else {
                View view5 = this.itemView;
                int i14 = R$id.recommendLivePrivilegeIconView;
                ((TextView) view5.findViewById(i14)).setVisibility(0);
                Integer anchorPrivilegeType = liveShow.getAnchorPrivilegeType();
                int type = LivePrivilegeType.ExposureType.getType();
                if (anchorPrivilegeType != null && anchorPrivilegeType.intValue() == type) {
                    ((TextView) this.itemView.findViewById(i14)).setText(this.itemView.getContext().getString(R$string.rising_star_anchor));
                } else {
                    int type2 = LivePrivilegeType.RecommendType.getType();
                    if (anchorPrivilegeType != null && anchorPrivilegeType.intValue() == type2) {
                        ((TextView) this.itemView.findViewById(i14)).setText(this.itemView.getContext().getString(R$string.popular_recommendation));
                    }
                }
            }
            ((LiveShowCoverTagView) this.itemView.findViewById(R$id.live_cover_tag_view)).b(liveShow.getCoverTag(), h.c(this, 20.0f));
            if (liveShow.getRedPacketInfo() != null) {
                View view6 = this.itemView;
                int i15 = R$id.red_envelope_tag_imageview;
                ImageLoaderView imageLoaderView6 = (ImageLoaderView) view6.findViewById(i15);
                s.h(imageLoaderView6, "itemView.red_envelope_tag_imageview");
                imageLoaderView6.setVisibility(0);
                ImageLoaderView imageLoaderView7 = (ImageLoaderView) this.itemView.findViewById(i15);
                s.h(imageLoaderView7, "itemView.red_envelope_tag_imageview");
                ImageLoaderView.g(imageLoaderView7, liveShow.getRedPacketInfo().getRedPacketIcon(), null, null, 6, null);
            } else {
                ImageLoaderView imageLoaderView8 = (ImageLoaderView) this.itemView.findViewById(R$id.red_envelope_tag_imageview);
                s.h(imageLoaderView8, "itemView.red_envelope_tag_imageview");
                imageLoaderView8.setVisibility(8);
            }
            ((LiveCoverOperationLayout) this.itemView.findViewById(R$id.live_operation_layout)).e(liveShow.getCoverData(), fKRecommendLiveShowModel.getShowLiveData(), new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.viewholder.FKRecommendLiveListViewHolder$config$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z10) {
                    ((FKRecommendLiveShowModel) Object.this).setShowLiveData(z10);
                }
            });
        }
    }
}
