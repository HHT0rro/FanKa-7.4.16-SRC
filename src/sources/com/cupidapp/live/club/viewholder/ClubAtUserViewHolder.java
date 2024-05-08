package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ClubAtUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubAtUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13682c = new a(null);

    /* compiled from: ClubAtUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubAtUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ClubAtUserViewHolder(z.b(parent, R$layout.item_club_at_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubAtUserViewHolder(@NotNull View itemView) {
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
            ((TextView) this.itemView.findViewById(R$id.userNameTextView)).setText(user.getNickname());
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
}
