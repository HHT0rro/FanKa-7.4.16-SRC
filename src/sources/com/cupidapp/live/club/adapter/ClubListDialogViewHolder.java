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
import z0.u;
import z0.z;

/* compiled from: ClubListDialogAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListDialogViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13515c = new a(null);

    /* compiled from: ClubListDialogAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubListDialogViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ClubListDialogViewHolder(z.b(parent, R$layout.view_holder_club_list_dialog, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubListDialogViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.club_name_textview);
        s.h(textView, "itemView.club_name_textview");
        u.a(textView);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ClubModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.club_avatar_imageview);
            s.h(imageLoaderView, "itemView.club_avatar_imageview");
            ClubModel clubModel = (ClubModel) obj;
            ImageLoaderView.g(imageLoaderView, clubModel.getGroupAvatar(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.club_name_textview)).setText(clubModel.getGroupName());
            ((TextView) this.itemView.findViewById(R$id.club_description_textview)).setText(clubModel.getGroupIntro());
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.club_medal_imageview);
            s.h(imageLoaderView2, "itemView.club_medal_imageview");
            ImageLoaderView.g(imageLoaderView2, clubModel.getMedalIcon(), null, null, 6, null);
            TextView textView = (TextView) this.itemView.findViewById(R$id.joined_textview);
            s.h(textView, "itemView.joined_textview");
            Boolean joined = clubModel.getJoined();
            textView.setVisibility(joined != null ? joined.booleanValue() : false ? 0 : 8);
        }
    }
}
