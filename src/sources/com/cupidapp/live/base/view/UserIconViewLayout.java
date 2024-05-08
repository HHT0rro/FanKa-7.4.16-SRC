package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import com.cupidapp.live.profile.model.VipIconSize;
import com.huawei.quickcard.framework.bean.CardElement;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.x;
import z0.y;
import z0.z;

/* compiled from: UserIconViewLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserIconViewLayout extends FrameLayout {

    /* renamed from: b */
    @NotNull
    public VipIconSize f12588b;

    /* renamed from: c */
    @NotNull
    public Map<Integer, View> f12589c;

    /* compiled from: UserIconViewLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum VipIconPositionRef {
        Profile("profile"),
        Setting(com.alipay.sdk.sys.a.f4669j),
        Feed(IAdInterListener.AdProdType.PRODUCT_FEEDS),
        PostStream("postStream"),
        Splash("splash"),
        Other("other");


        @NotNull
        private final String value;

        VipIconPositionRef(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIconViewLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12589c = new LinkedHashMap();
        this.f12588b = VipIconSize.NORMAL;
        f(context, null);
    }

    public static /* synthetic */ void d(UserIconViewLayout userIconViewLayout, UserVipDetailModel userVipDetailModel, SensorPosition sensorPosition, VipIconPositionRef vipIconPositionRef, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            sensorPosition = null;
        }
        if ((i10 & 4) != 0) {
            vipIconPositionRef = VipIconPositionRef.Other;
        }
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        userIconViewLayout.c(userVipDetailModel, sensorPosition, vipIconPositionRef, z10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12589c;
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

    public final void b(@Nullable ImageModel imageModel) {
        if (imageModel == null) {
            ImageLoaderView club_medal_imageview = (ImageLoaderView) a(R$id.club_medal_imageview);
            kotlin.jvm.internal.s.h(club_medal_imageview, "club_medal_imageview");
            club_medal_imageview.setVisibility(8);
            return;
        }
        int i10 = R$id.club_medal_imageview;
        ImageLoaderView club_medal_imageview2 = (ImageLoaderView) a(i10);
        kotlin.jvm.internal.s.h(club_medal_imageview2, "club_medal_imageview");
        club_medal_imageview2.setVisibility(0);
        ImageLoaderView club_medal_imageview3 = (ImageLoaderView) a(i10);
        kotlin.jvm.internal.s.h(club_medal_imageview3, "club_medal_imageview");
        ImageLoaderView.g(club_medal_imageview3, imageModel, null, null, 6, null);
        int scaleWidthByHeight = imageModel.getScaleWidthByHeight(z0.h.c(this, 16.0f));
        ImageLoaderView club_medal_imageview4 = (ImageLoaderView) a(i10);
        kotlin.jvm.internal.s.h(club_medal_imageview4, "club_medal_imageview");
        y.o(club_medal_imageview4, Integer.valueOf(scaleWidthByHeight), null, 2, null);
    }

    public final void c(@Nullable UserVipDetailModel userVipDetailModel, @Nullable final SensorPosition sensorPosition, @NotNull final VipIconPositionRef ref, boolean z10) {
        kotlin.jvm.internal.s.i(ref, "ref");
        if (userVipDetailModel == null) {
            ((ImageView) a(R$id.user_vip_img)).setVisibility(8);
            return;
        }
        final ImageView imageView = (ImageView) a(R$id.user_vip_img);
        if (!userVipDetailModel.getVipIconHide() && (userVipDetailModel.getVip() || userVipDetailModel.getAnnualVip() || userVipDetailModel.getAnnualSvip() || userVipDetailModel.getSVip() || userVipDetailModel.getSsvip() || userVipDetailModel.getAnnualSsvip())) {
            Integer vipIcon = userVipDetailModel.getVipIcon(this.f12588b);
            if (vipIcon != null) {
                imageView.setImageResource(vipIcon.intValue());
            }
            imageView.setVisibility(0);
            if (z10) {
                kotlin.jvm.internal.s.h(imageView, "this");
                y.d(imageView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.base.view.UserIconViewLayout$configUserVipIcon$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                        invoke2(view);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view) {
                        ConstantsUrlModel urlModel;
                        ConstantsResult q10 = p1.g.f52734a.q();
                        String urlVipMe = (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlVipMe();
                        if (!(urlVipMe == null || urlVipMe.length() == 0)) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, ImageView.this.getContext(), x.a(urlVipMe, CardElement.Field.REF, ref.getValue()), null, 4, null);
                        }
                        SensorPosition sensorPosition2 = sensorPosition;
                        if (sensorPosition2 == null) {
                            sensorPosition2 = SensorPosition.Unknown;
                        }
                        z3.d.f54832a.j(sensorPosition2.getValue());
                    }
                });
            }
            setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }

    public final void e(@Nullable ImageModel imageModel) {
        int c4;
        ImageLoaderView configUserWealthLevelIcon$lambda$1 = (ImageLoaderView) a(R$id.user_wealth_level_img);
        if (imageModel == null) {
            configUserWealthLevelIcon$lambda$1.setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.f12588b == VipIconSize.BIG) {
            kotlin.jvm.internal.s.h(configUserWealthLevelIcon$lambda$1, "configUserWealthLevelIcon$lambda$1");
            c4 = z0.h.c(configUserWealthLevelIcon$lambda$1, 16.0f);
        } else {
            kotlin.jvm.internal.s.h(configUserWealthLevelIcon$lambda$1, "configUserWealthLevelIcon$lambda$1");
            c4 = z0.h.c(configUserWealthLevelIcon$lambda$1, 13.0f);
        }
        y.n(configUserWealthLevelIcon$lambda$1, Integer.valueOf(imageModel.getScaleWidthByHeight(c4)), Integer.valueOf(c4));
        ImageLoaderView.g(configUserWealthLevelIcon$lambda$1, imageModel, null, null, 6, null);
        configUserWealthLevelIcon$lambda$1.setVisibility(0);
    }

    public final void f(Context context, AttributeSet attributeSet) {
        z.a(this, R$layout.layout_user_icon, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UserIconViewLayout);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr…eable.UserIconViewLayout)");
        this.f12588b = obtainStyledAttributes.getBoolean(0, true) ? VipIconSize.BIG : VipIconSize.NORMAL;
        obtainStyledAttributes.recycle();
    }

    @NotNull
    public final VipIconSize getVipIconSize() {
        return this.f12588b;
    }

    public final void setVipIconSize(@NotNull VipIconSize vipIconSize) {
        kotlin.jvm.internal.s.i(vipIconSize, "<set-?>");
        this.f12588b = vipIconSize;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIconViewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12589c = new LinkedHashMap();
        this.f12588b = VipIconSize.NORMAL;
        f(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIconViewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12589c = new LinkedHashMap();
        this.f12588b = VipIconSize.NORMAL;
        f(context, attributeSet);
    }
}
