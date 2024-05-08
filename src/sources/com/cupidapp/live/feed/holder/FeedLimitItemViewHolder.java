package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.UserWithPostLimitStatusModel;
import com.cupidapp.live.profile.model.PostLimitReadStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedLimitItemViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedLimitItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14383c = new a(null);

    /* compiled from: FeedLimitItemViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedLimitItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedLimitItemViewHolder(z.b(parent, R$layout.item_feed_limit, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedLimitItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof UserWithPostLimitStatusModel) {
            UserWithPostLimitStatusModel userWithPostLimitStatusModel = (UserWithPostLimitStatusModel) obj;
            r(userWithPostLimitStatusModel);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.item_user_avatar);
            s.h(imageLoaderView, "itemView.item_user_avatar");
            ImageLoaderView.g(imageLoaderView, userWithPostLimitStatusModel.getAvatarImage(), null, null, 6, null);
            boolean z10 = true;
            if (com.cupidapp.live.profile.logic.c.f17839a.a(userWithPostLimitStatusModel.getId())) {
                View view = this.itemView;
                int i10 = R$id.item_name;
                ((TextView) view.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.limit_post));
                ((TextView) this.itemView.findViewById(i10)).getPaint().setFakeBoldText(true);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.item_name;
                ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(s.d(userWithPostLimitStatusModel.getReadStatus(), PostLimitReadStatus.UnRead.getValue()));
                ((TextView) this.itemView.findViewById(i11)).setText(userWithPostLimitStatusModel.getName());
                ((TextView) this.itemView.findViewById(i11)).setTextColor(s.d(userWithPostLimitStatusModel.getReadStatus(), PostLimitReadStatus.Read.getValue()) ? -5658199 : -15066598);
            }
            String avatarInfo = userWithPostLimitStatusModel.getAvatarInfo();
            if (avatarInfo != null && avatarInfo.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this.itemView.findViewById(R$id.avatar_msg_txt)).setVisibility(8);
                return;
            }
            View view3 = this.itemView;
            int i12 = R$id.avatar_msg_txt;
            ((TextView) view3.findViewById(i12)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i12)).setText(userWithPostLimitStatusModel.getAvatarInfo());
        }
    }

    public final void r(UserWithPostLimitStatusModel userWithPostLimitStatusModel) {
        Integer readStatus = userWithPostLimitStatusModel.getReadStatus();
        if (s.d(readStatus, PostLimitReadStatus.Read.getValue())) {
            ((ImageView) this.itemView.findViewById(R$id.add_state_img)).setVisibility(4);
            View view = this.itemView;
            int i10 = R$id.item_unread_circle;
            view.findViewById(i10).setVisibility(0);
            this.itemView.findViewById(i10).setBackgroundResource(R$mipmap.icon_already_read_circle);
            return;
        }
        if (s.d(readStatus, PostLimitReadStatus.UnRead.getValue())) {
            ((ImageView) this.itemView.findViewById(R$id.add_state_img)).setVisibility(4);
            View view2 = this.itemView;
            int i11 = R$id.item_unread_circle;
            view2.findViewById(i11).setVisibility(0);
            this.itemView.findViewById(i11).setBackgroundResource(R$mipmap.icon_limit_unread);
            return;
        }
        this.itemView.findViewById(R$id.item_unread_circle).setVisibility(4);
        if (com.cupidapp.live.profile.logic.c.f17839a.a(userWithPostLimitStatusModel.getId())) {
            ((ImageView) this.itemView.findViewById(R$id.add_state_img)).setVisibility(0);
        } else {
            ((ImageView) this.itemView.findViewById(R$id.add_state_img)).setVisibility(4);
        }
    }
}
