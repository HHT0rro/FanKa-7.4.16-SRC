package com.cupidapp.live.liveshow.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKFollowOrNearbyLiveShowAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveUserAvatarViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14827c = new a(null);

    /* compiled from: FKFollowOrNearbyLiveShowAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveUserAvatarViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveUserAvatarViewHolder(z.b(parent, R$layout.view_holder_user_avatar, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveUserAvatarViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKFollowOrNearbyLiveShowModel) {
            LiveShowModel liveShow = ((FKFollowOrNearbyLiveShowModel) obj).getLiveShow();
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.userAvatarView);
            s.h(imageLoaderView, "itemView.userAvatarView");
            ImageLoaderView.g(imageLoaderView, liveShow.getCoverImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.userNameTextView;
            boolean z10 = true;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i10)).setText(liveShow.getUser().getName());
            String locationInfo = liveShow.getLocationInfo();
            if (locationInfo != null && locationInfo.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this.itemView.findViewById(R$id.locationTextView)).setVisibility(8);
                return;
            }
            View view2 = this.itemView;
            int i11 = R$id.locationTextView;
            ((TextView) view2.findViewById(i11)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i11)).setText(liveShow.getLocationInfo());
        }
    }
}
