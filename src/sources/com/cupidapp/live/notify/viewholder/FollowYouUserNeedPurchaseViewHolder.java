package com.cupidapp.live.notify.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FollowYouUserNeedPurchaseViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowYouUserNeedPurchaseViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17576c = new a(null);

    /* compiled from: FollowYouUserNeedPurchaseViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String str;
        int i10;
        String num;
        if (obj instanceof User) {
            User user = (User) obj;
            str = "";
            if (user.getShowMosaic()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.attentionUserAvatarImageView);
                s.h(imageLoaderView, "itemView.attentionUserAvatarImageView");
                ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                View view = this.itemView;
                int i11 = R$id.attentionDistance;
                TextView textView = (TextView) view.findViewById(i11);
                if (user.getLocationInfo() != null) {
                    ((TextView) this.itemView.findViewById(i11)).setText(user.getLocationInfo());
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                textView.setVisibility(i10);
                ((TextView) this.itemView.findViewById(R$id.attentionUserName)).setVisibility(8);
                ((RelativeLayout) this.itemView.findViewById(R$id.relationLayout)).setVisibility(8);
                TextView textView2 = (TextView) this.itemView.findViewById(R$id.attentionUserAge);
                Integer age = user.getAge();
                if (age != null && (num = age.toString()) != null) {
                    str = num;
                }
                textView2.setText(str);
                this.itemView.findViewById(R$id.notify_attention_unread_red_dot).setVisibility(8);
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.attentionUserAvatarImageView);
                s.h(imageLoaderView2, "itemView.attentionUserAvatarImageView");
                ImageLoaderView.g(imageLoaderView2, user.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 520191, null), null, 4, null);
                ((TextView) this.itemView.findViewById(R$id.attentionDistance)).setVisibility(8);
                View view2 = this.itemView;
                int i12 = R$id.attentionUserName;
                ((TextView) view2.findViewById(i12)).setText(user.getName());
                ((TextView) this.itemView.findViewById(i12)).setVisibility(0);
                ((RelativeLayout) this.itemView.findViewById(R$id.relationLayout)).setVisibility(0);
                r(user);
                ((TextView) this.itemView.findViewById(R$id.attentionUserAge)).setText(user.getAge() != null ? this.itemView.getContext().getString(R$string.with_comma_at_the_start, user.getAge().toString()) : "");
            }
            ((SuperLikeTagView) this.itemView.findViewById(R$id.attention_super_like_me_img)).setVisibility(user.getSuperLikedMe() ? 0 : 8);
        }
    }

    public final void r(User user) {
        if (user.getMatch()) {
            ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.chatImageButton)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.followedImageButton)).setVisibility(8);
        } else if (user.getAloha()) {
            ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.chatImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.followedImageButton)).setVisibility(0);
        } else {
            ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.chatImageButton)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.followedImageButton)).setVisibility(8);
        }
    }
}
