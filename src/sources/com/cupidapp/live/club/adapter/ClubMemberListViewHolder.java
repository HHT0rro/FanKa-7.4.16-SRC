package com.cupidapp.live.club.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ClubMemberListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubMemberListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13517c = new a(null);

    /* compiled from: ClubMemberListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubMemberListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ClubMemberListViewHolder(z.b(parent, R$layout.view_holder_club_member_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubMemberListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof User) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.member_avatar_imageview);
            s.h(imageLoaderView, "itemView.member_avatar_imageview");
            User user = (User) obj;
            ImageLoaderView.g(imageLoaderView, user.getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.member_name_textview)).setText(user.getNickname());
            String location = user.getLocation();
            if (location == null || location.length() == 0) {
                TextView textView = (TextView) this.itemView.findViewById(R$id.distance_textview);
                s.h(textView, "itemView.distance_textview");
                textView.setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.distance_textview;
                TextView textView2 = (TextView) view.findViewById(i10);
                s.h(textView2, "itemView.distance_textview");
                textView2.setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(user.getLocation());
            }
        }
    }
}
