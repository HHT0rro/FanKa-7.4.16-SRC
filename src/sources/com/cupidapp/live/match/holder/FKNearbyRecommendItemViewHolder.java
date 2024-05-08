package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.match.model.NearbyUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKNearbyRecommendItemViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearbyRecommendItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16792c = new a(null);

    /* compiled from: FKNearbyRecommendItemViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKNearbyRecommendItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKNearbyRecommendItemViewHolder(z.b(parent, R$layout.view_holder_nearby_recommend_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearbyRecommendItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearbyUserModel) {
            float l10 = (h.l(this) - (h.c(this, 1.0f) * 4)) / 4.2f;
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            y.n(itemView, Integer.valueOf((int) l10), Integer.valueOf((int) ((l10 / 3.0f) * 4)));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.recommendUserAvatar);
            s.h(imageLoaderView, "itemView.recommendUserAvatar");
            NearbyUserModel nearbyUserModel = (NearbyUserModel) obj;
            ImageLoaderView.g(imageLoaderView, nearbyUserModel.getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.recommendCityName)).setText(nearbyUserModel.getName());
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
            s.h(userIconViewLayout, "itemView.vipIconImageView");
            UserIconViewLayout.d(userIconViewLayout, nearbyUserModel.getVipModel(), SensorPosition.Nearby, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            String travelCity = nearbyUserModel.getTravelCity();
            if (!(travelCity == null || travelCity.length() == 0)) {
                ((ImageView) this.itemView.findViewById(R$id.travel_tag_img)).setVisibility(0);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.travel_tag_img)).setVisibility(8);
            }
        }
    }
}
