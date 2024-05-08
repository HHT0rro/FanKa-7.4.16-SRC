package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.match.model.NearbyListModel;
import com.cupidapp.live.match.model.NearbyUserModel;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByExposureUserLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByExposureUserLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final int f16980b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16981c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16982d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByExposureUserLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16982d = new LinkedHashMap();
        this.f16980b = (z0.h.l(this) - z0.h.c(this, 5.0f)) / 4;
        this.f16981c = (int) ((r2 * 122) / 102.0f);
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16982d;
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

    public final void b(@NotNull NearbyListModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        NearbyUserModel nearbyUser = model.getNearbyUser();
        if (nearbyUser.getHide()) {
            ImageLoaderView super_boost_user_avatar_imageview = (ImageLoaderView) a(R$id.super_boost_user_avatar_imageview);
            kotlin.jvm.internal.s.h(super_boost_user_avatar_imageview, "super_boost_user_avatar_imageview");
            ImageLoaderView.g(super_boost_user_avatar_imageview, nearbyUser.getAvatarImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(9.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
            TextView super_boost_user_name_textview = (TextView) a(R$id.super_boost_user_name_textview);
            kotlin.jvm.internal.s.h(super_boost_user_name_textview, "super_boost_user_name_textview");
            super_boost_user_name_textview.setVisibility(8);
            UserIconViewLayout nearby_boost_vip_imageview = (UserIconViewLayout) a(R$id.nearby_boost_vip_imageview);
            kotlin.jvm.internal.s.h(nearby_boost_vip_imageview, "nearby_boost_vip_imageview");
            nearby_boost_vip_imageview.setVisibility(8);
            String distance = nearbyUser.getDistance();
            if (!(distance == null || distance.length() == 0)) {
                int i10 = R$id.super_boost_distance_textview;
                TextView super_boost_distance_textview = (TextView) a(i10);
                kotlin.jvm.internal.s.h(super_boost_distance_textview, "super_boost_distance_textview");
                super_boost_distance_textview.setVisibility(0);
                ((TextView) a(i10)).setText(nearbyUser.getDistance());
                return;
            }
            TextView super_boost_distance_textview2 = (TextView) a(R$id.super_boost_distance_textview);
            kotlin.jvm.internal.s.h(super_boost_distance_textview2, "super_boost_distance_textview");
            super_boost_distance_textview2.setVisibility(8);
            return;
        }
        ImageLoaderView super_boost_user_avatar_imageview2 = (ImageLoaderView) a(R$id.super_boost_user_avatar_imageview);
        kotlin.jvm.internal.s.h(super_boost_user_avatar_imageview2, "super_boost_user_avatar_imageview");
        ImageLoaderView.g(super_boost_user_avatar_imageview2, nearbyUser.getAvatarImage(), null, null, 6, null);
        int i11 = R$id.super_boost_user_name_textview;
        TextView super_boost_user_name_textview2 = (TextView) a(i11);
        kotlin.jvm.internal.s.h(super_boost_user_name_textview2, "super_boost_user_name_textview");
        super_boost_user_name_textview2.setVisibility(0);
        ((TextView) a(i11)).setText(nearbyUser.getName());
        UserIconViewLayout nearby_boost_vip_imageview2 = (UserIconViewLayout) a(R$id.nearby_boost_vip_imageview);
        kotlin.jvm.internal.s.h(nearby_boost_vip_imageview2, "nearby_boost_vip_imageview");
        UserIconViewLayout.d(nearby_boost_vip_imageview2, nearbyUser.getVipModel(), SensorPosition.Nearby, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
        TextView super_boost_distance_textview3 = (TextView) a(R$id.super_boost_distance_textview);
        kotlin.jvm.internal.s.h(super_boost_distance_textview3, "super_boost_distance_textview");
        super_boost_distance_textview3.setVisibility(8);
    }

    public final void c() {
        z0.z.a(this, R$layout.layout_nearby_super_boost, true);
        ConstraintLayout super_boost_layout = (ConstraintLayout) a(R$id.super_boost_layout);
        kotlin.jvm.internal.s.h(super_boost_layout, "super_boost_layout");
        z0.y.n(super_boost_layout, Integer.valueOf(this.f16980b), Integer.valueOf(this.f16981c));
    }

    public final int getItemHeight() {
        return this.f16981c;
    }

    public final int getItemWidth() {
        return this.f16980b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByExposureUserLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16982d = new LinkedHashMap();
        this.f16980b = (z0.h.l(this) - z0.h.c(this, 5.0f)) / 4;
        this.f16981c = (int) ((r2 * 122) / 102.0f);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByExposureUserLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16982d = new LinkedHashMap();
        this.f16980b = (z0.h.l(this) - z0.h.c(this, 5.0f)) / 4;
        this.f16981c = (int) ((r2 * 122) / 102.0f);
        c();
    }
}
