package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.MatchMarketingModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SwipeCardMarketingPositionViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwipeCardMarketingPositionViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16824c = new a(null);

    /* compiled from: SwipeCardMarketingPositionViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SwipeCardMarketingPositionViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SwipeCardMarketingPositionViewHolder(z.b(parent, R$layout.view_holder_swipe_card_marketing_position, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeCardMarketingPositionViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.marketing_skip_txt);
        s.h(textView, "itemView.marketing_skip_txt");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.marketing_see_txt);
        s.h(textView2, "itemView.marketing_see_txt");
        u.a(textView2);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MatchMarketingModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.marketing_bg_img);
            s.h(imageLoaderView, "itemView.marketing_bg_img");
            MatchMarketingModel matchMarketingModel = (MatchMarketingModel) obj;
            ImageLoaderView.g(imageLoaderView, matchMarketingModel.getBackgroundImage(), null, null, 6, null);
            if (matchMarketingModel.getOverlayImage() != null) {
                int scaleHeightByWidth = matchMarketingModel.getOverlayImage().getScaleHeightByWidth(h.l(this));
                View view = this.itemView;
                int i10 = R$id.marketing_over_img;
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) view.findViewById(i10);
                s.h(imageLoaderView2, "itemView.marketing_over_img");
                y.o(imageLoaderView2, null, Integer.valueOf(scaleHeightByWidth), 1, null);
                ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView3, "itemView.marketing_over_img");
                ImageLoaderView.g(imageLoaderView3, matchMarketingModel.getOverlayImage(), null, null, 6, null);
            }
            ((TextView) this.itemView.findViewById(R$id.marketing_title_txt)).setText(matchMarketingModel.getTitle());
            ((TextView) this.itemView.findViewById(R$id.marketing_desc_txt)).setText(matchMarketingModel.getDesc());
            if (matchMarketingModel.getButtonImage() != null) {
                View view2 = this.itemView;
                int i11 = R$id.marketing_btn_img;
                ((ImageLoaderView) view2.findViewById(i11)).setVisibility(0);
                int scaleWidthByHeight = matchMarketingModel.getButtonImage().getScaleWidthByHeight(h.c(this, 48.0f));
                ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(i11);
                s.h(imageLoaderView4, "itemView.marketing_btn_img");
                y.o(imageLoaderView4, Integer.valueOf(scaleWidthByHeight), null, 2, null);
                ImageLoaderView imageLoaderView5 = (ImageLoaderView) this.itemView.findViewById(i11);
                s.h(imageLoaderView5, "itemView.marketing_btn_img");
                ImageLoaderView.g(imageLoaderView5, matchMarketingModel.getButtonImage(), null, null, 6, null);
            } else {
                ((ImageLoaderView) this.itemView.findViewById(R$id.marketing_btn_img)).setVisibility(4);
            }
            ((TextView) this.itemView.findViewById(R$id.marketing_skip_txt)).setText(matchMarketingModel.getNopeText());
            ((TextView) this.itemView.findViewById(R$id.marketing_see_txt)).setText(matchMarketingModel.getAlohaText());
        }
    }

    public final void r(boolean z10) {
        ((ImageView) this.itemView.findViewById(R$id.marketing_cancel_img)).setVisibility(z10 ? 0 : 8);
    }
}
