package com.cupidapp.live.liveshow.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveConnectType;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveUserRankView;
import com.cupidapp.live.profile.model.User;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveConnectUserViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveConnectUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14811c = new a(null);

    /* compiled from: FKLiveConnectUserViewPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveConnectUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveConnectUserViewHolder(z.b(parent, R$layout.view_holder_live_connect_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveConnectUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        y.o(itemView, Integer.valueOf((h.l(this) - h.c(this, 38.0f)) / 4), null, 2, null);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveRequestViewModel) {
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            FKLiveRequestViewModel fKLiveRequestViewModel = (FKLiveRequestViewModel) obj;
            y.i(itemView, (r18 & 1) != 0 ? 0.0f : h.c(this, 8.0f), r.e(Integer.valueOf(fKLiveRequestViewModel.isChecked() ? -1800 : 0)), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : fKLiveRequestViewModel.isChecked() ? Integer.valueOf(h.c(this, 1.5f)) : null, (r18 & 16) != 0 ? null : fKLiveRequestViewModel.isChecked() ? -49088 : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            User user = fKLiveRequestViewModel.getRequestModel().getUser();
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.connect_user_avatar_imageview);
            s.h(imageLoaderView, "itemView.connect_user_avatar_imageview");
            ImageLoaderView.g(imageLoaderView, user != null ? user.getAvatarImage() : null, null, null, 6, null);
            ((FKLiveUserRankView) this.itemView.findViewById(R$id.connect_user_rank_view)).h(user != null ? user.getLevelIcon() : null);
            ((TextView) this.itemView.findViewById(R$id.connect_user_name_textview)).setText(user != null ? user.getName() : null);
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.connect_mark_imageview);
            String connectType = fKLiveRequestViewModel.getRequestModel().getConnectType();
            boolean d10 = s.d(connectType, LiveConnectType.VideoConnect.getType());
            int i10 = R$mipmap.icon_video_connect;
            if (!d10 && s.d(connectType, LiveConnectType.VoiceConnect.getType())) {
                i10 = R$mipmap.icon_voice_connect;
            }
            imageView.setImageResource(i10);
        }
    }
}
