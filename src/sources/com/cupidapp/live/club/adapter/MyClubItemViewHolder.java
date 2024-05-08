package com.cupidapp.live.club.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.club.model.ClubModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MyClubAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MyClubItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13518c = new a(null);

    /* compiled from: MyClubAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MyClubItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new MyClubItemViewHolder(z.b(parent, R$layout.view_holder_my_club_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyClubItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ClubModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.my_club_imageview);
            s.h(imageLoaderView, "itemView.my_club_imageview");
            ClubModel clubModel = (ClubModel) obj;
            ImageLoaderView.g(imageLoaderView, clubModel.getGroupAvatar(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.my_club_name_textview)).setText(clubModel.getGroupName());
            View findViewById = this.itemView.findViewById(R$id.my_club_unread_view);
            s.h(findViewById, "itemView.my_club_unread_view");
            Boolean redDot = clubModel.getRedDot();
            findViewById.setVisibility(redDot != null ? redDot.booleanValue() : false ? 0 : 8);
        }
    }
}
