package com.cupidapp.live.club.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import com.cupidapp.live.profile.model.VipIconSize;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.y;
import z0.z;

/* compiled from: ClubChatLeftUserInfoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatLeftUserInfoLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f13638b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13639c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatLeftUserInfoLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13639c = new LinkedHashMap();
        this.f13638b = z0.h.c(this, 12.0f);
        h(this, context, null, 2, null);
    }

    public static /* synthetic */ void e(ClubChatLeftUserInfoLayout clubChatLeftUserInfoLayout, User user, ImageModel imageModel, ImageModel imageModel2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        clubChatLeftUserInfoLayout.d(user, imageModel, imageModel2, z10);
    }

    public static /* synthetic */ void h(ClubChatLeftUserInfoLayout clubChatLeftUserInfoLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        clubChatLeftUserInfoLayout.g(context, attributeSet);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13639c;
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

    public final void b(ImageModel imageModel) {
        if (imageModel == null) {
            ((ImageLoaderView) a(R$id.common_user_club_level_img_view)).setVisibility(8);
            return;
        }
        int i10 = R$id.common_user_club_level_img_view;
        ((ImageLoaderView) a(i10)).setVisibility(0);
        int scaleWidthByHeight = imageModel.getScaleWidthByHeight(this.f13638b);
        ImageLoaderView common_user_club_level_img_view = (ImageLoaderView) a(i10);
        s.h(common_user_club_level_img_view, "common_user_club_level_img_view");
        y.o(common_user_club_level_img_view, Integer.valueOf(scaleWidthByHeight), null, 2, null);
        ImageLoaderView common_user_club_level_img_view2 = (ImageLoaderView) a(i10);
        s.h(common_user_club_level_img_view2, "common_user_club_level_img_view");
        ImageLoaderView.g(common_user_club_level_img_view2, imageModel, null, null, 6, null);
    }

    public final void c(ImageModel imageModel) {
        if (imageModel == null) {
            ((ImageLoaderView) a(R$id.common_user_club_medal_img_view)).setVisibility(8);
            return;
        }
        int i10 = R$id.common_user_club_medal_img_view;
        ((ImageLoaderView) a(i10)).setVisibility(0);
        ImageLoaderView common_user_club_medal_img_view = (ImageLoaderView) a(i10);
        s.h(common_user_club_medal_img_view, "common_user_club_medal_img_view");
        ImageLoaderView.g(common_user_club_medal_img_view, imageModel, null, null, 6, null);
        int scaleWidthByHeight = imageModel.getScaleWidthByHeight(this.f13638b);
        ImageLoaderView common_user_club_medal_img_view2 = (ImageLoaderView) a(i10);
        s.h(common_user_club_medal_img_view2, "common_user_club_medal_img_view");
        y.o(common_user_club_medal_img_view2, Integer.valueOf(scaleWidthByHeight), null, 2, null);
    }

    public final void d(@Nullable User user, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, boolean z10) {
        y.o(this, null, Integer.valueOf(this.f13638b), 1, null);
        if (z10) {
            int i10 = R$id.common_user_name_text_view;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(t.p(user != null ? user.getName() : null, 10, null, 2, null));
        } else {
            int i11 = R$id.common_user_name_text_view;
            ((TextView) a(i11)).setVisibility(8);
            ((TextView) a(i11)).setText((CharSequence) null);
        }
        f(user != null ? user.getUserVipModel() : null);
        c(imageModel);
        b(imageModel2);
    }

    public final void f(UserVipDetailModel userVipDetailModel) {
        if (userVipDetailModel == null) {
            ((ImageView) a(R$id.common_user_vip_img_view)).setVisibility(8);
            return;
        }
        if (i(userVipDetailModel)) {
            Integer vipIcon = userVipDetailModel.getVipIcon(VipIconSize.BIG);
            if (vipIcon != null && vipIcon.intValue() > 0) {
                int i10 = R$id.common_user_vip_img_view;
                ((ImageView) a(i10)).setVisibility(0);
                ((ImageView) a(i10)).setImageResource(vipIcon.intValue());
                int intrinsicWidth = ((ImageView) a(i10)).getDrawable().getIntrinsicWidth();
                int intrinsicHeight = (intrinsicWidth * this.f13638b) / ((ImageView) a(i10)).getDrawable().getIntrinsicHeight();
                ImageView common_user_vip_img_view = (ImageView) a(i10);
                s.h(common_user_vip_img_view, "common_user_vip_img_view");
                y.o(common_user_vip_img_view, Integer.valueOf(intrinsicHeight), null, 2, null);
                return;
            }
            ((ImageView) a(R$id.common_user_vip_img_view)).setVisibility(8);
            return;
        }
        ((ImageView) a(R$id.common_user_vip_img_view)).setVisibility(8);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        z.a(this, R$layout.layout_club_chat_left_user_info, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClubChatLeftUserInfoLayout);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…ubChatLeftUserInfoLayout)");
        this.f13638b = obtainStyledAttributes.getDimensionPixelSize(0, this.f13638b);
        obtainStyledAttributes.recycle();
    }

    public final boolean i(UserVipDetailModel userVipDetailModel) {
        return !userVipDetailModel.getVipIconHide() && (userVipDetailModel.getVip() || userVipDetailModel.getAnnualVip() || userVipDetailModel.getAnnualSvip() || userVipDetailModel.getSVip() || userVipDetailModel.getSsvip() || userVipDetailModel.getAnnualSsvip());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatLeftUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13639c = new LinkedHashMap();
        this.f13638b = z0.h.c(this, 12.0f);
        g(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubChatLeftUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13639c = new LinkedHashMap();
        this.f13638b = z0.h.c(this, 12.0f);
        g(context, attributeSet);
    }
}
