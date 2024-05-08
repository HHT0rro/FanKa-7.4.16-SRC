package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.match.model.NearbyListModel;
import com.cupidapp.live.match.model.NearbyUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKNearbyUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearbyUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16795c = new a(null);

    /* compiled from: FKNearbyUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKNearbyUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKNearbyUserViewHolder(z.b(parent, R$layout.view_holder_nearby_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearbyUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        int i10;
        if (obj instanceof NearbyListModel) {
            NearbyListModel nearbyListModel = (NearbyListModel) obj;
            NearbyUserModel nearbyUser = nearbyListModel.getNearbyUser();
            ((RoundedFrameLayout) this.itemView.findViewById(R$id.nearbyUserRootLayout)).setCornerRadius(h.c(this, 2.0f));
            float l10 = (h.l(this) - (h.c(this, 1.0f) * 4)) / 3.0f;
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            y.n(itemView, Integer.valueOf((int) l10), Integer.valueOf((int) ((l10 / 3.0f) * 4)));
            if (nearbyUser.getHide()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.userAvatarView);
                s.h(imageLoaderView, "itemView.userAvatarView");
                ImageLoaderView.g(imageLoaderView, nearbyUser.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                ((TextView) this.itemView.findViewById(R$id.userNameTextView)).setVisibility(8);
                ((UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView)).setVisibility(8);
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.userAvatarView);
                s.h(imageLoaderView2, "itemView.userAvatarView");
                ImageLoaderView.g(imageLoaderView2, nearbyUser.getAvatarImage(), null, null, 6, null);
                View view = this.itemView;
                int i11 = R$id.userNameTextView;
                ((TextView) view.findViewById(i11)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(nearbyUser.getName());
                View view2 = this.itemView;
                int i12 = R$id.vipIconImageView;
                ((UserIconViewLayout) view2.findViewById(i12)).setVisibility(0);
                UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(i12);
                s.h(userIconViewLayout, "itemView.vipIconImageView");
                UserIconViewLayout.d(userIconViewLayout, nearbyUser.getVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            }
            String distance = nearbyUser.getDistance();
            boolean z10 = true;
            if (distance == null || distance.length() == 0) {
                i10 = 8;
                ((TextView) this.itemView.findViewById(R$id.distanceTextView)).setVisibility(8);
            } else {
                i10 = 8;
                View view3 = this.itemView;
                int i13 = R$id.distanceTextView;
                ((TextView) view3.findViewById(i13)).setText(nearbyUser.getDistance());
                ((TextView) this.itemView.findViewById(i13)).setVisibility(0);
            }
            ((ImageView) this.itemView.findViewById(R$id.nearbyUserHotImageView)).setVisibility(nearbyUser.getHot() ? 0 : 8);
            ((ImageView) this.itemView.findViewById(R$id.nearbyUserOnlineView)).setVisibility(nearbyUser.getOnline() ? 0 : 8);
            String travelCity = nearbyListModel.getNearbyUser().getTravelCity();
            if (travelCity != null && travelCity.length() != 0) {
                z10 = false;
            }
            if (z10) {
                View view4 = this.itemView;
                int i14 = R$id.new_face_imageview;
                ((ImageView) view4.findViewById(i14)).setImageResource(R$mipmap.icon_nearby_new_face);
                ImageView imageView = (ImageView) this.itemView.findViewById(i14);
                s.h(imageView, "itemView.new_face_imageview");
                if (s.d(nearbyListModel.getNearbyUser().getNewHere(), Boolean.TRUE)) {
                    i10 = 0;
                }
                imageView.setVisibility(i10);
                return;
            }
            View view5 = this.itemView;
            int i15 = R$id.new_face_imageview;
            ((ImageView) view5.findViewById(i15)).setImageResource(R$mipmap.ic_near_travel);
            ImageView imageView2 = (ImageView) this.itemView.findViewById(i15);
            s.h(imageView2, "itemView.new_face_imageview");
            imageView2.setVisibility(0);
        }
    }
}
