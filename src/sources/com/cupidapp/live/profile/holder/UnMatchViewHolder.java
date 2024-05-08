package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: UnMatchViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnMatchViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17831c = new a(null);

    /* compiled from: UnMatchViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UnMatchViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new UnMatchViewHolder(z.b(parent, R$layout.item_un_match, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnMatchViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof User) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.avatarImageView);
            s.h(imageLoaderView, "itemView.avatarImageView");
            User user = (User) obj;
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.userNameTextView;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i10)).setText(user.getName());
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vip_img);
            s.h(userIconViewLayout, "itemView.vip_img");
            UserIconViewLayout.d(userIconViewLayout, user.getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            v(user.getSummaryInfo());
            t(user);
            u(user.getSuperLikedByMeCombos());
        }
    }

    public final void r(@NotNull List<String> selectedIds) {
        s.i(selectedIds, "selectedIds");
        if (o() instanceof User) {
            CheckBox checkBox = (CheckBox) this.itemView.findViewById(R$id.item_match_select_cb);
            Object o10 = o();
            s.g(o10, "null cannot be cast to non-null type com.cupidapp.live.profile.model.User");
            checkBox.setChecked(selectedIds.contains(((User) o10).userId()));
        }
    }

    public final void s(boolean z10) {
        if (z10) {
            ((CheckBox) this.itemView.findViewById(R$id.item_match_select_cb)).setVisibility(0);
        } else {
            ((CheckBox) this.itemView.findViewById(R$id.item_match_select_cb)).setVisibility(8);
        }
    }

    public final void t(User user) {
        String str;
        String location = user.getLocation();
        boolean z10 = true;
        if (location == null || location.length() == 0) {
            String lastOnline = user.getLastOnline();
            if (lastOnline == null || lastOnline.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.locationAndActiveTimeTextView)).setVisibility(8);
                return;
            }
        }
        View view = this.itemView;
        int i10 = R$id.locationAndActiveTimeTextView;
        ((TextView) view.findViewById(i10)).setVisibility(0);
        String location2 = user.getLocation();
        if (!(location2 == null || location2.length() == 0)) {
            ((TextView) this.itemView.findViewById(i10)).setCompoundDrawablesWithIntrinsicBounds(R$mipmap.icon_userlist_location, 0, 0, 0);
            String lastOnline2 = user.getLastOnline();
            if (!(lastOnline2 == null || lastOnline2.length() == 0)) {
                str = this.itemView.getContext().getString(R$string.location_and_active_time, user.getLocation(), user.getLastOnline());
            } else {
                str = user.getLocation();
            }
        } else {
            String lastOnline3 = user.getLastOnline();
            if (lastOnline3 != null && lastOnline3.length() != 0) {
                z10 = false;
            }
            if (z10) {
                str = "";
            } else {
                ((TextView) this.itemView.findViewById(i10)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                str = user.getLastOnline();
            }
        }
        s.h(str, "if (!model.location.isNu…         \"\"\n            }");
        ((TextView) this.itemView.findViewById(i10)).setText(str);
    }

    public final void u(Integer num) {
        ((SuperLikeTagView) this.itemView.findViewById(R$id.item_super_like_img)).c(num);
    }

    public final void v(String str) {
        if (str == null || str.length() == 0) {
            ((TextView) this.itemView.findViewById(R$id.userInfoTextView)).setVisibility(8);
            return;
        }
        View view = this.itemView;
        int i10 = R$id.userInfoTextView;
        ((TextView) view.findViewById(i10)).setVisibility(0);
        ((TextView) this.itemView.findViewById(i10)).setText(str);
    }
}
