package com.cupidapp.live.match.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.match.model.NearMatchModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: NearbyMatchItemViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyMatchItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16809e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final int f16810c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16811d;

    /* compiled from: NearbyMatchItemViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NearbyMatchItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new NearbyMatchItemViewHolder(z.b(parent, R$layout.item_near_by_match, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyMatchItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f16810c = (h.l(this) - h.c(this, 5.0f)) / 4;
        this.f16811d = (int) ((r2 * 122) / 102.0f);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearMatchModel) {
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            y.n(itemView, Integer.valueOf(this.f16810c), Integer.valueOf(this.f16811d));
            NearMatchModel nearMatchModel = (NearMatchModel) obj;
            if (nearMatchModel.getHide()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.userAvatarView);
                s.h(imageLoaderView, "itemView.userAvatarView");
                User user = nearMatchModel.getUser();
                ImageLoaderView.g(imageLoaderView, user != null ? user.getAvatarImage() : null, new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                ((TextView) this.itemView.findViewById(R$id.userNameTextView)).setVisibility(8);
                ((UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView)).setVisibility(8);
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.userAvatarView);
                s.h(imageLoaderView2, "itemView.userAvatarView");
                User user2 = nearMatchModel.getUser();
                ImageLoaderView.g(imageLoaderView2, user2 != null ? user2.getAvatarImage() : null, null, null, 6, null);
                View view = this.itemView;
                int i10 = R$id.userNameTextView;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                TextView textView = (TextView) this.itemView.findViewById(i10);
                User user3 = nearMatchModel.getUser();
                textView.setText(user3 != null ? user3.getName() : null);
                View view2 = this.itemView;
                int i11 = R$id.vipIconImageView;
                ((UserIconViewLayout) view2.findViewById(i11)).setVisibility(0);
                UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(i11);
                s.h(userIconViewLayout, "itemView.vipIconImageView");
                User user4 = nearMatchModel.getUser();
                UserIconViewLayout.d(userIconViewLayout, user4 != null ? user4.getUserVipModel() : null, SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            }
            String locationInfo = nearMatchModel.getLocationInfo();
            if (locationInfo == null || locationInfo.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.distanceTextView)).setVisibility(8);
            } else {
                View view3 = this.itemView;
                int i12 = R$id.distanceTextView;
                ((TextView) view3.findViewById(i12)).setText(nearMatchModel.getLocationInfo());
                ((TextView) this.itemView.findViewById(i12)).setVisibility(0);
            }
            ((ImageView) this.itemView.findViewById(R$id.nearbyUserOnlineView)).setVisibility(nearMatchModel.getOnline() ? 0 : 8);
        }
    }
}
