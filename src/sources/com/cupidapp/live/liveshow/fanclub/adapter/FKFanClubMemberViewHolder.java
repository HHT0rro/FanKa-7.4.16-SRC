package com.cupidapp.live.liveshow.fanclub.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import com.cupidapp.live.liveshow.fanclub.view.FKFanClubMedalLayout;
import com.cupidapp.live.liveshow.fanclub.view.FKFanClubMedalModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKFanClubMemberAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubMemberViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14956c = new a(null);

    /* compiled from: FKFanClubMemberAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFanClubMemberViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKFanClubMemberViewHolder(z.b(parent, R$layout.view_holder_fan_club_member, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFanClubMemberViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.fanClubMemberNameTextView)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.fanClubIntimacyTextView)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKFanClubMemberDataModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.fanClubMemberAvatarImageView);
            s.h(imageLoaderView, "itemView.fanClubMemberAvatarImageView");
            FKFanClubMemberDataModel fKFanClubMemberDataModel = (FKFanClubMemberDataModel) obj;
            ImageLoaderView.g(imageLoaderView, fKFanClubMemberDataModel.getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.fanClubMemberNameTextView)).setText(fKFanClubMemberDataModel.getUser().getName());
            ((FKFanClubMedalLayout) this.itemView.findViewById(R$id.fanClubMemberMedalLayout)).b(new FKFanClubMedalModel(fKFanClubMemberDataModel.getLevel(), fKFanClubMemberDataModel.getBadgeName(), fKFanClubMemberDataModel.getBadgeIcon(), fKFanClubMemberDataModel.getBadgeBgColor()));
            ((TextView) this.itemView.findViewById(R$id.fanClubIntimacyTextView)).setText(fKFanClubMemberDataModel.getFamiliarScoreFormatted());
        }
    }
}
