package com.cupidapp.live.profile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.base.view.UserNameWithVipIconTextView;
import com.cupidapp.live.match.view.ZodiacElfMatchTipsLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserClubModel;
import com.cupidapp.live.profile.model.VipIconSize;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.x;
import z0.y;
import z0.z;

/* compiled from: ProfileUserInfoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileUserInfoLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17871b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileUserInfoLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17871b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17871b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(@NotNull User user) {
        s.i(user, "user");
        ((SuperLikeTagView) a(R$id.profile_super_liked_by_me_tag)).c(user.getSuperLikedByMeCombos());
        ImageView imageView = (ImageView) a(R$id.profile_travel_tag);
        String travelCity = user.getTravelCity();
        imageView.setVisibility(travelCity == null || travelCity.length() == 0 ? 8 : 0);
        UserClubModel groupInfo = user.getGroupInfo();
        ((UserNameWithVipIconTextView) a(R$id.userNameTextView)).c(user.getName(), VipIconSize.BIG, user.getUserVipModel(), SensorPosition.Profile, UserIconViewLayout.VipIconPositionRef.Profile, user.getProfileLevelIcon(), groupInfo != null ? groupInfo.getMedal() : null, groupInfo != null ? groupInfo.getMedalJumpUrl() : null, user.getOfficialAccountIcon());
        ((TextView) a(R$id.userInfoTextView)).setText(user.getUserProfileSummaryInfo());
        if ((groupInfo != null ? groupInfo.getIcon() : null) != null && user.getZodiacInfo() == null) {
            int i10 = R$id.profile_club_entrance_imageview;
            ImageLoaderView profile_club_entrance_imageview = (ImageLoaderView) a(i10);
            s.h(profile_club_entrance_imageview, "profile_club_entrance_imageview");
            profile_club_entrance_imageview.setVisibility(0);
            ImageLoaderView profile_club_entrance_imageview2 = (ImageLoaderView) a(i10);
            s.h(profile_club_entrance_imageview2, "profile_club_entrance_imageview");
            ImageLoaderView.g(profile_club_entrance_imageview2, groupInfo.getIcon(), null, null, 6, null);
            int scaleWidthByHeight = groupInfo.getIcon().getScaleWidthByHeight(h.c(this, 20.0f));
            ImageLoaderView profile_club_entrance_imageview3 = (ImageLoaderView) a(i10);
            s.h(profile_club_entrance_imageview3, "profile_club_entrance_imageview");
            y.o(profile_club_entrance_imageview3, Integer.valueOf(scaleWidthByHeight), null, 2, null);
        } else {
            ImageLoaderView profile_club_entrance_imageview4 = (ImageLoaderView) a(R$id.profile_club_entrance_imageview);
            s.h(profile_club_entrance_imageview4, "profile_club_entrance_imageview");
            profile_club_entrance_imageview4.setVisibility(8);
        }
        ((ZodiacElfMatchTipsLayout) a(R$id.profile_zodiac_elf_match_tips_layout)).b(user.getZodiacInfo());
    }

    public final void c() {
        z.a(this, R$layout.layout_profile_user_info, true);
        ImageView profile_travel_tag = (ImageView) a(R$id.profile_travel_tag);
        s.h(profile_travel_tag, "profile_travel_tag");
        y.d(profile_travel_tag, new Function1<View, p>() { // from class: com.cupidapp.live.profile.view.ProfileUserInfoLayout$initView$1
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
                ConstantsUrlModel urlModel;
                String travelH5Url;
                j.a aVar = j.f12156c;
                Context context = ProfileUserInfoLayout.this.getContext();
                ConstantsResult q10 = g.f52734a.q();
                j.a.b(aVar, context, (q10 == null || (urlModel = q10.getUrlModel()) == null || (travelH5Url = urlModel.getTravelH5Url()) == null) ? null : x.a(travelH5Url, "entrance_name", "PROFILE"), null, 4, null);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17871b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17871b = new LinkedHashMap();
        c();
    }
}
