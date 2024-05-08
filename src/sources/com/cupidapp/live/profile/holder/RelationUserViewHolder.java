package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import com.cupidapp.live.superlike.view.SuperLikeType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import z0.z;

/* compiled from: RelationUserViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RelationUserViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17830c = new a(null);

    /* compiled from: RelationUserViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RelationUserViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new RelationUserViewHolder(z.b(parent, R$layout.view_holder_relation_user, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationUserViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(@org.jetbrains.annotations.Nullable java.lang.Object r32) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.holder.RelationUserViewHolder.n(java.lang.Object):void");
    }

    public final void r(RelationUserUiModel relationUserUiModel) {
        String str;
        String location = relationUserUiModel.getLocation();
        boolean z10 = true;
        if (location == null || location.length() == 0) {
            String lastOnline = relationUserUiModel.getLastOnline();
            if (lastOnline == null || lastOnline.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.locationAndActiveTimeTextView)).setVisibility(8);
                return;
            }
        }
        View view = this.itemView;
        int i10 = R$id.locationAndActiveTimeTextView;
        ((TextView) view.findViewById(i10)).setVisibility(0);
        String location2 = relationUserUiModel.getLocation();
        if (!(location2 == null || location2.length() == 0)) {
            ((TextView) this.itemView.findViewById(i10)).setCompoundDrawablesWithIntrinsicBounds(R$mipmap.icon_userlist_location, 0, 0, 0);
            String lastOnline2 = relationUserUiModel.getLastOnline();
            if (!(lastOnline2 == null || lastOnline2.length() == 0)) {
                str = this.itemView.getContext().getString(R$string.location_and_active_time, relationUserUiModel.getLocation(), relationUserUiModel.getLastOnline());
            } else {
                str = relationUserUiModel.getLocation();
            }
        } else {
            String lastOnline3 = relationUserUiModel.getLastOnline();
            if (lastOnline3 != null && lastOnline3.length() != 0) {
                z10 = false;
            }
            if (z10) {
                str = "";
            } else {
                ((TextView) this.itemView.findViewById(i10)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                str = relationUserUiModel.getLastOnline();
            }
        }
        s.h(str, "if (!model.location.isNu…         \"\"\n            }");
        if (relationUserUiModel.getSecret()) {
            ((TextView) this.itemView.findViewById(i10)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            ((TextView) this.itemView.findViewById(i10)).setText(q1.d.f53006a.a(str, str));
        } else {
            ((TextView) this.itemView.findViewById(i10)).setText(str);
        }
    }

    public final void s(RelationType relationType, User user) {
        if (relationType != RelationType.Matched && !user.getMatch()) {
            if (relationType == RelationType.YouFollowed) {
                View view = this.itemView;
                int i10 = R$id.relation_super_like_img;
                ((SuperLikeTagView) view.findViewById(i10)).setType(SuperLikeType.SUPER_LIKE_BY_ME);
                ((SuperLikeTagView) this.itemView.findViewById(i10)).c(user.getSuperLikedByMeCombos());
                return;
            }
            if (relationType == RelationType.FollowYou) {
                if (user.isSuperlikeMe()) {
                    View view2 = this.itemView;
                    int i11 = R$id.relation_super_like_img;
                    ((SuperLikeTagView) view2.findViewById(i11)).setType(SuperLikeType.SUPER_LIKE_ME);
                    ((SuperLikeTagView) this.itemView.findViewById(i11)).c(user.getSuperLikedMeCombos());
                    return;
                }
                View view3 = this.itemView;
                int i12 = R$id.relation_super_like_img;
                ((SuperLikeTagView) view3.findViewById(i12)).setType(SuperLikeType.SUPER_LIKE_BY_ME);
                ((SuperLikeTagView) this.itemView.findViewById(i12)).c(user.getSuperLikedByMeCombos());
                return;
            }
            ((SuperLikeTagView) this.itemView.findViewById(R$id.relation_super_like_img)).setVisibility(8);
            return;
        }
        ((SuperLikeTagView) this.itemView.findViewById(R$id.relation_super_like_img)).setVisibility(8);
    }

    public final void t(String str) {
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
