package com.cupidapp.live.match.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.model.MatchGroupCampaignModel;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.u;
import z0.z;

/* compiled from: SwipeCardCampaignViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwipeCardCampaignViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16639c = new a(null);

    /* compiled from: SwipeCardCampaignViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SwipeCardCampaignViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new SwipeCardCampaignViewHolder(z.b(parent, R$layout.item_swipe_card_campaign, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeCardCampaignViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.see_more_detail_txt);
        s.h(textView, "itemView.see_more_detail_txt");
        u.a(textView);
        TextView textView2 = (TextView) itemView.findViewById(R$id.swipe_card_campaign_skip_btn);
        s.h(textView2, "itemView.swipe_card_campaign_skip_btn");
        u.a(textView2);
        TextView textView3 = (TextView) itemView.findViewById(R$id.swipe_card_campaign_see_btn);
        s.h(textView3, "itemView.swipe_card_campaign_see_btn");
        u.a(textView3);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MatchGroupCampaignModel) {
            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) obj;
            ((TextView) this.itemView.findViewById(R$id.activity_title_txt)).setText(matchGroupCampaignModel.getTitle());
            String desc = matchGroupCampaignModel.getDesc();
            boolean z10 = true;
            if (desc == null || desc.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.activity_subtitle_txt)).setVisibility(8);
                ((LinearLayout) this.itemView.findViewById(R$id.activity_date_location_layout)).setVisibility(0);
                List<String> tags = matchGroupCampaignModel.getTags();
                if (!(tags == null || tags.isEmpty())) {
                    View view = this.itemView;
                    int i10 = R$id.activity_date_txt;
                    ((TextView) view.findViewById(i10)).setVisibility(0);
                    ((TextView) this.itemView.findViewById(i10)).setText((CharSequence) CollectionsKt___CollectionsKt.T(matchGroupCampaignModel.getTags()));
                    if (matchGroupCampaignModel.getTags().size() < 2) {
                        ((TextView) this.itemView.findViewById(R$id.activity_location_txt)).setVisibility(8);
                    } else {
                        View view2 = this.itemView;
                        int i11 = R$id.activity_location_txt;
                        ((TextView) view2.findViewById(i11)).setVisibility(0);
                        ((TextView) this.itemView.findViewById(i11)).setText((CharSequence) CollectionsKt___CollectionsKt.e0(matchGroupCampaignModel.getTags()));
                    }
                } else {
                    String timeDesc = matchGroupCampaignModel.getTimeDesc();
                    if (!(timeDesc == null || timeDesc.length() == 0)) {
                        View view3 = this.itemView;
                        int i12 = R$id.activity_date_txt;
                        ((TextView) view3.findViewById(i12)).setVisibility(0);
                        ((TextView) this.itemView.findViewById(i12)).setText(matchGroupCampaignModel.getTimeDesc());
                    } else {
                        ((TextView) this.itemView.findViewById(R$id.activity_date_txt)).setVisibility(8);
                    }
                    String poiAddress = matchGroupCampaignModel.getPoiAddress();
                    if (poiAddress != null && poiAddress.length() != 0) {
                        z10 = false;
                    }
                    if (!z10) {
                        View view4 = this.itemView;
                        int i13 = R$id.activity_location_txt;
                        ((TextView) view4.findViewById(i13)).setVisibility(0);
                        ((TextView) this.itemView.findViewById(i13)).setText(matchGroupCampaignModel.getPoiAddress());
                    } else {
                        ((TextView) this.itemView.findViewById(R$id.activity_location_txt)).setVisibility(8);
                    }
                }
            } else {
                ((LinearLayout) this.itemView.findViewById(R$id.activity_date_location_layout)).setVisibility(8);
                View view5 = this.itemView;
                int i14 = R$id.activity_subtitle_txt;
                ((TextView) view5.findViewById(i14)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i14)).setText(matchGroupCampaignModel.getDesc());
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.activity_bg_img);
            s.h(imageLoaderView, "itemView.activity_bg_img");
            ImageLoaderView.g(imageLoaderView, matchGroupCampaignModel.getImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(0.0f, 0, 3, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.activity_img);
            s.h(imageLoaderView2, "itemView.activity_img");
            ImageLoaderView.g(imageLoaderView2, matchGroupCampaignModel.getImage(), null, null, 6, null);
            if (g.f52734a.L3()) {
                ((ImageView) this.itemView.findViewById(R$id.swipe_card_campaign_cancel_nope_btn)).setVisibility(0);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.swipe_card_campaign_cancel_nope_btn)).setVisibility(8);
            }
        }
    }

    public final void r(boolean z10) {
        if (z10 && g.f52734a.L3()) {
            ((ImageView) this.itemView.findViewById(R$id.swipe_card_campaign_cancel_nope_btn)).setVisibility(0);
        } else {
            ((ImageView) this.itemView.findViewById(R$id.swipe_card_campaign_cancel_nope_btn)).setVisibility(8);
        }
    }
}
