package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: ProfileFriendPraiseViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileFriendPraiseViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17821c = new a(null);

    /* compiled from: ProfileFriendPraiseViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileFriendPraiseViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ProfileFriendPraiseViewHolder profileFriendPraiseViewHolder = new ProfileFriendPraiseViewHolder(z.b(parent, R$layout.view_holder_profile_friend_praise, false, 2, null));
            profileFriendPraiseViewHolder.q();
            return profileFriendPraiseViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileFriendPraiseViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ProfileFriendPraiseModel) {
            View view = this.itemView;
            int i10 = R$id.profile_friend_praise_title_text;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.profile_friend_praise_title_text");
            u.a(textView);
            View view2 = this.itemView;
            int i11 = R$id.profile_friend_praise_count_text;
            TextView textView2 = (TextView) view2.findViewById(i11);
            s.h(textView2, "itemView.profile_friend_praise_count_text");
            u.a(textView2);
            ProfileFriendPraiseModel profileFriendPraiseModel = (ProfileFriendPraiseModel) obj;
            ((TextView) this.itemView.findViewById(i11)).setText(this.itemView.getContext().getString(R$string.friend_praise_has_count, Integer.valueOf(profileFriendPraiseModel.getCount())));
            if (profileFriendPraiseModel.getCount() > 0) {
                this.itemView.findViewById(R$id.profile_friend_praise_bg).setBackgroundResource(R$drawable.shape_friend_praise_green_gradient_bg);
                View view3 = this.itemView;
                int i12 = R$id.profile_friend_praise_header_img;
                ((ImageView) view3.findViewById(i12)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(i12)).setImageResource(R$mipmap.icon_green_profile_friend_praise);
                ((TextView) this.itemView.findViewById(i10)).setText(profileFriendPraiseModel.getContent());
                ((TextView) this.itemView.findViewById(R$id.profile_friend_praise_desc_text)).setVisibility(8);
                ((ImageView) this.itemView.findViewById(R$id.profile_friend_praise_arrow_img)).setImageResource(R$mipmap.ic_black_arrow_right);
                ((ImageView) this.itemView.findViewById(R$id.profile_friend_praise_mark_img)).setVisibility(0);
                return;
            }
            if (profileFriendPraiseModel.getMe()) {
                this.itemView.findViewById(R$id.profile_friend_praise_bg).setBackgroundResource(R$drawable.shape_friend_praise_green_gradient_bg);
                ((ImageView) this.itemView.findViewById(R$id.profile_friend_praise_header_img)).setVisibility(8);
                ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.invite_friend_praise));
                ((TextView) this.itemView.findViewById(R$id.profile_friend_praise_desc_text)).setVisibility(8);
                ((ImageView) this.itemView.findViewById(R$id.profile_friend_praise_arrow_img)).setImageResource(R$mipmap.icon_friend_praise_add);
                ((ImageView) this.itemView.findViewById(R$id.profile_friend_praise_mark_img)).setVisibility(0);
                return;
            }
            this.itemView.findViewById(R$id.profile_friend_praise_bg).setBackgroundResource(R$drawable.shape_white_bg_twelve_corners);
            View view4 = this.itemView;
            int i13 = R$id.profile_friend_praise_header_img;
            ((ImageView) view4.findViewById(i13)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(i13)).setImageResource(R$mipmap.icon_gray_profile_friend_praise);
            ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.go_and_praise_him));
            View view5 = this.itemView;
            int i14 = R$id.profile_friend_praise_desc_text;
            ((TextView) view5.findViewById(i14)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i14)).setText(this.itemView.getContext().getString(R$string.your_praise_has_chance_to_show_up_here));
            ((ImageView) this.itemView.findViewById(R$id.profile_friend_praise_arrow_img)).setImageResource(R$mipmap.icon_friend_praise_add);
            ((ImageView) this.itemView.findViewById(R$id.profile_friend_praise_mark_img)).setVisibility(8);
        }
    }
}
