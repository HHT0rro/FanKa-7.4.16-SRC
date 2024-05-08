package com.cupidapp.live.club.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.club.model.ClubEnterRequestStatus;
import com.cupidapp.live.club.model.ClubEnterRequestUserModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ClubEnterRequestViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubEnterRequestViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13690c = new a(null);

    /* compiled from: ClubEnterRequestViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubEnterRequestViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ClubEnterRequestViewHolder(z.b(parent, R$layout.view_holder_club_enter_request, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubEnterRequestViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ClubEnterRequestUserModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.club_enter_request_avatar_img);
            s.h(imageLoaderView, "itemView.club_enter_request_avatar_img");
            ClubEnterRequestUserModel clubEnterRequestUserModel = (ClubEnterRequestUserModel) obj;
            ImageLoaderView.g(imageLoaderView, clubEnterRequestUserModel.getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.club_enter_request_name_text)).setText(clubEnterRequestUserModel.getNickname());
            ((TextView) this.itemView.findViewById(R$id.club_enter_request_time_text)).setText(clubEnterRequestUserModel.getApplyTime());
            Integer applyStatus = clubEnterRequestUserModel.getApplyStatus();
            int value = ClubEnterRequestStatus.TO_CONFIRM.getValue();
            if (applyStatus != null && applyStatus.intValue() == value) {
                ((TextView) this.itemView.findViewById(R$id.club_enter_request_to_confirm_btn)).setVisibility(0);
                ((LinearLayout) this.itemView.findViewById(R$id.club_enter_request_already_agree_layout)).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.club_enter_request_invalid_text)).setVisibility(8);
                return;
            }
            int value2 = ClubEnterRequestStatus.ALREADY_CONFIRM.getValue();
            if (applyStatus != null && applyStatus.intValue() == value2) {
                ((TextView) this.itemView.findViewById(R$id.club_enter_request_to_confirm_btn)).setVisibility(8);
                ((LinearLayout) this.itemView.findViewById(R$id.club_enter_request_already_agree_layout)).setVisibility(0);
                ((TextView) this.itemView.findViewById(R$id.club_enter_request_invalid_text)).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.club_enter_request_confirm_name_text)).setText(clubEnterRequestUserModel.getConfirmNickname());
                return;
            }
            int value3 = ClubEnterRequestStatus.INVALID.getValue();
            if (applyStatus != null && applyStatus.intValue() == value3) {
                ((TextView) this.itemView.findViewById(R$id.club_enter_request_to_confirm_btn)).setVisibility(8);
                ((LinearLayout) this.itemView.findViewById(R$id.club_enter_request_already_agree_layout)).setVisibility(8);
                ((TextView) this.itemView.findViewById(R$id.club_enter_request_invalid_text)).setVisibility(0);
            }
        }
    }
}
