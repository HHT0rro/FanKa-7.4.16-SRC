package com.cupidapp.live.notify.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.z;

/* compiled from: FollowYouNeedPurchaseViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowYouNeedPurchaseViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17575c = new a(null);

    /* compiled from: FollowYouNeedPurchaseViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FollowYouNeedPurchaseViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FollowYouNeedPurchaseViewHolder(z.b(parent, R$layout.view_holder_follow_you_need_purchase, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowYouNeedPurchaseViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        String str;
        int i10;
        if (obj instanceof User) {
            ((RoundedFrameLayout) this.itemView.findViewById(R$id.followRootLayout)).setCornerRadius(h.c(this, 8.0f));
            int l10 = (h.l(this) - (h.c(this, 8.0f) * 3)) / 2;
            this.itemView.setLayoutParams(new RelativeLayout.LayoutParams(l10, (l10 * 4) / 3));
            View view = this.itemView;
            int i11 = R$id.followUserName;
            TextView textView = (TextView) view.findViewById(i11);
            s.h(textView, "itemView.followUserName");
            u.a(textView);
            View view2 = this.itemView;
            int i12 = R$id.followDistance;
            TextView textView2 = (TextView) view2.findViewById(i12);
            s.h(textView2, "itemView.followDistance");
            u.a(textView2);
            View view3 = this.itemView;
            int i13 = R$id.followUserAge;
            TextView textView3 = (TextView) view3.findViewById(i13);
            s.h(textView3, "itemView.followUserAge");
            u.a(textView3);
            User user = (User) obj;
            if (user.getShowMosaic()) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.followUserAvatarImageView);
                s.h(imageLoaderView, "itemView.followUserAvatarImageView");
                ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                TextView textView4 = (TextView) this.itemView.findViewById(i12);
                if (user.getLocationInfo() != null) {
                    ((TextView) this.itemView.findViewById(i12)).setText(user.getLocationInfo());
                    i10 = 0;
                } else {
                    i10 = 4;
                }
                textView4.setVisibility(i10);
                ((TextView) this.itemView.findViewById(i11)).setVisibility(8);
                ((RelativeLayout) this.itemView.findViewById(R$id.relationLayout)).setVisibility(8);
                if (user.getAge() != null) {
                    ((TextView) this.itemView.findViewById(i13)).setVisibility(0);
                    TextView textView5 = (TextView) this.itemView.findViewById(i13);
                    y yVar = y.f51038a;
                    String string = this.itemView.getContext().getString(R$string.user_age);
                    s.h(string, "itemView.context.getString(R.string.user_age)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{user.getAge().toString()}, 1));
                    s.h(format, "format(format, *args)");
                    textView5.setText(format);
                } else {
                    ((TextView) this.itemView.findViewById(i13)).setVisibility(8);
                }
            } else {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.followUserAvatarImageView);
                s.h(imageLoaderView2, "itemView.followUserAvatarImageView");
                ImageLoaderView.g(imageLoaderView2, user.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 520191, null), null, 4, null);
                ((TextView) this.itemView.findViewById(i12)).setVisibility(4);
                ((TextView) this.itemView.findViewById(i11)).setText(user.getName());
                ((TextView) this.itemView.findViewById(i11)).setVisibility(0);
                ((RelativeLayout) this.itemView.findViewById(R$id.relationLayout)).setVisibility(0);
                r(user);
                TextView textView6 = (TextView) this.itemView.findViewById(i13);
                if (user.getAge() != null) {
                    y yVar2 = y.f51038a;
                    String string2 = this.itemView.getContext().getString(R$string.user_age);
                    s.h(string2, "itemView.context.getString(R.string.user_age)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{user.getAge().toString()}, 1));
                    s.h(format2, "format(format, *args)");
                    str = ", " + format2;
                } else {
                    str = "";
                }
                textView6.setText(str);
            }
            ((SuperLikeTagView) this.itemView.findViewById(R$id.follow_super_like_me_img)).c(user.getSuperLikedMeCombos());
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
