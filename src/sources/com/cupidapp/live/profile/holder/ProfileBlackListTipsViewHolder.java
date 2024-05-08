package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ProfileBlackListTipsViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileBlackListTipsViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17819c = new a(null);

    /* compiled from: ProfileBlackListTipsViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileBlackListTipsViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ProfileBlackListTipsViewHolder profileBlackListTipsViewHolder = new ProfileBlackListTipsViewHolder(z.b(parent, R$layout.view_holder_profile_black_list_tips, false, 2, null));
            profileBlackListTipsViewHolder.q();
            return profileBlackListTipsViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileBlackListTipsViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        super.n(obj);
        if (obj instanceof ProfileBlackListTipsViewModel) {
            ((RelativeLayout) this.itemView.findViewById(R$id.youAddUserToBlackListLayout)).setVisibility(((ProfileBlackListTipsViewModel) obj).getBlock() ? 0 : 8);
        }
    }
}
