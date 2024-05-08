package com.cupidapp.live.profile.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.club.model.ClubMedalModel;
import com.cupidapp.live.profile.view.ClubMedalItemLayout;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: UserClubMedalViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserClubMedalViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17832d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final int f17833c;

    /* compiled from: UserClubMedalViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserClubMedalViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            UserClubMedalViewHolder userClubMedalViewHolder = new UserClubMedalViewHolder(z.b(parent, R$layout.view_holder_user_club_medal, false, 2, null));
            userClubMedalViewHolder.q();
            return userClubMedalViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserClubMedalViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        this.f17833c = (h.l(this) - h.c(this, 36.0f)) / 4;
        TextView textView = (TextView) itemView.findViewById(R$id.medal_textview);
        s.h(textView, "itemView.medal_textview");
        u.a(textView);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MedalListModel) {
            ((LinearLayout) this.itemView.findViewById(R$id.club_medal_layout)).removeAllViews();
            for (final ClubMedalModel clubMedalModel : ((MedalListModel) obj).getList()) {
                Context context = this.itemView.getContext();
                s.h(context, "itemView.context");
                ClubMedalItemLayout clubMedalItemLayout = new ClubMedalItemLayout(context);
                clubMedalItemLayout.b(clubMedalModel);
                y.d(clubMedalItemLayout, new Function1<View, p>() { // from class: com.cupidapp.live.profile.holder.UserClubMedalViewHolder$config$1$itemLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view) {
                        invoke2(view);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view) {
                        j.a.b(j.f12156c, UserClubMedalViewHolder.this.itemView.getContext(), clubMedalModel.getJumpUrl(), null, 4, null);
                    }
                });
                ((LinearLayout) this.itemView.findViewById(R$id.club_medal_layout)).addView(clubMedalItemLayout, this.f17833c, -2);
            }
        }
    }
}
