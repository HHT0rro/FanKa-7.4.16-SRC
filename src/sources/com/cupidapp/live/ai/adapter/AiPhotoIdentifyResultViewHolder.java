package com.cupidapp.live.ai.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.ai.view.AiIdentifyPhotoPagerLayout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: AiPhotoIdentifyResultViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiPhotoIdentifyResultViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f11645c = new a(null);

    /* compiled from: AiPhotoIdentifyResultViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AiPhotoIdentifyResultViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AiPhotoIdentifyResultViewHolder(z.b(parent, R$layout.item_ai_identify_result, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiPhotoIdentifyResultViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearbyUserProfileModel) {
            View view = this.itemView;
            NearbyUserProfileModel nearbyUserProfileModel = (NearbyUserProfileModel) obj;
            ((AiIdentifyPhotoPagerLayout) view.findViewById(R$id.ai_identify_profile_layout)).m(nearbyUserProfileModel.getAvatarFeeds());
            int i10 = R$id.userNameTextView;
            TextView userNameTextView = (TextView) view.findViewById(i10);
            s.h(userNameTextView, "userNameTextView");
            u.a(userNameTextView);
            ((TextView) view.findViewById(i10)).setText(nearbyUserProfileModel.getName());
            int i11 = R$id.vipIconImageView;
            UserIconViewLayout vipIconImageView = (UserIconViewLayout) view.findViewById(i11);
            s.h(vipIconImageView, "vipIconImageView");
            UserIconViewLayout.d(vipIconImageView, nearbyUserProfileModel.getVipModel(), SensorPosition.AiIdentifyResult, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            ((UserIconViewLayout) view.findViewById(i11)).e(nearbyUserProfileModel.getProfileLevelIcon());
            int i12 = R$id.userSummaryTextView;
            ((TextView) view.findViewById(i12)).setText(nearbyUserProfileModel.getSummary());
            TextView textView = (TextView) view.findViewById(i12);
            String summary = nearbyUserProfileModel.getSummary();
            boolean z10 = true;
            textView.setVisibility(summary == null || summary.length() == 0 ? 8 : 0);
            ((TextView) view.findViewById(R$id.userAgeAndInfoTextView)).setText(nearbyUserProfileModel.getBasicInfo());
            String similarity = nearbyUserProfileModel.getSimilarity();
            if (similarity != null && similarity.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) view.findViewById(R$id.ai_ic_tag)).setVisibility(4);
                return;
            }
            int i13 = R$id.ai_ic_tag;
            ((TextView) view.findViewById(i13)).setVisibility(0);
            ((TextView) view.findViewById(i13)).setText(nearbyUserProfileModel.getSimilarity());
            TextView ai_ic_tag = (TextView) view.findViewById(i13);
            s.h(ai_ic_tag, "ai_ic_tag");
            u.a(ai_ic_tag);
        }
    }
}
