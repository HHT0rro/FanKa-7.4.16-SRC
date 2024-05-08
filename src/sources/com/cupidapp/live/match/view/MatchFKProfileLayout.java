package com.cupidapp.live.match.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.liveshow.view.BannerLayout;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFKProfileLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFKProfileLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<kotlin.p> f16955b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function0<kotlin.p> f16956c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function2<? super Float, ? super Boolean, kotlin.p> f16957d;

    /* renamed from: e, reason: collision with root package name */
    public float f16958e;

    /* renamed from: f, reason: collision with root package name */
    public int f16959f;

    /* renamed from: g, reason: collision with root package name */
    public float f16960g;

    /* renamed from: h, reason: collision with root package name */
    public float f16961h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f16962i;

    /* renamed from: j, reason: collision with root package name */
    public long f16963j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16964k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16965l;

    /* renamed from: m, reason: collision with root package name */
    public int f16966m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public SensorPosition f16967n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16968o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchFKProfileLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16968o = new LinkedHashMap();
        this.f16967n = SensorPosition.NearbyCoverCard;
        o();
    }

    public static final void l(MatchFKProfileLayout this$0, boolean z10, NearbyUserProfileModel user) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(user, "$user");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((RelativeLayout) this$0.b(R$id.menuLayout), (Property<RelativeLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
        if (!z10) {
            ImageView imageView = (ImageView) this$0.b(R$id.arrowImageView);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView = (TextView) this$0.b(R$id.userNameTextView);
            if (textView != null) {
                textView.setText(user.getName());
            }
            int i10 = R$id.vipIconImageView;
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this$0.b(i10);
            if (userIconViewLayout != null) {
                UserIconViewLayout.d(userIconViewLayout, user.getVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            }
            UserIconViewLayout userIconViewLayout2 = (UserIconViewLayout) this$0.b(i10);
            if (userIconViewLayout2 != null) {
                userIconViewLayout2.e(user.getProfileLevelIcon());
            }
        } else {
            UserIconViewLayout userIconViewLayout3 = (UserIconViewLayout) this$0.b(R$id.vipIconImageView);
            if (userIconViewLayout3 != null) {
                userIconViewLayout3.e(null);
            }
        }
        int i11 = R$id.userSummaryTextView;
        TextView textView2 = (TextView) this$0.b(i11);
        if (textView2 != null) {
            textView2.setText(user.getSummary());
        }
        TextView textView3 = (TextView) this$0.b(i11);
        if (textView3 != null) {
            String summary = user.getSummary();
            textView3.setVisibility(summary == null || summary.length() == 0 ? 8 : 0);
        }
        TextView textView4 = (TextView) this$0.b(R$id.userAgeAndInfoTextView);
        if (textView4 != null) {
            textView4.setText(user.getBasicInfo());
        }
        List<ImageModel> avatarFeeds = user.getAvatarFeeds();
        if (avatarFeeds != null) {
            BannerLayout bannerLayout = (BannerLayout) this$0.b(R$id.imageBannerLayout);
            if (bannerLayout != null) {
                bannerLayout.setImageModelList(CollectionsKt___CollectionsKt.z0(avatarFeeds));
            }
            this$0.setGuideVisible(avatarFeeds.size());
        }
        this$0.h(user.getIndividuationFrameConfig());
    }

    private final void setGuideVisible(int i10) {
        int i11 = R$id.newMatchGuideLayout;
        if (((RoundedFrameLayout) b(i11)) == null) {
            return;
        }
        p1.g gVar = p1.g.f52734a;
        if (!kotlin.jvm.internal.s.d(gVar.u0().c(), Boolean.TRUE) || i10 <= 1) {
            return;
        }
        gVar.u0().d(Boolean.FALSE);
        ((RoundedFrameLayout) b(i11)).setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((RoundedFrameLayout) b(i11), (Property<RoundedFrameLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ((RoundedFrameLayout) b(i11)).setCornerRadius(z0.h.c(this, 15.0f), 0.0f, 0.0f, z0.h.c(this, 15.0f));
        ofFloat.start();
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f16968o;
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        Function2<? super Float, ? super Boolean, kotlin.p> function2;
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f16958e = motionEvent.getRawX();
            this.f16960g = motionEvent.getRawY();
            this.f16961h = motionEvent.getY();
            this.f16963j = System.currentTimeMillis();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            r(motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getY());
        } else if (valueOf != null && valueOf.intValue() == 2 && motionEvent.getRawY() > this.f16960g && (function2 = this.f16957d) != null) {
            function2.mo1743invoke(Float.valueOf(motionEvent.getRawY() - this.f16960g), Boolean.FALSE);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g(boolean z10) {
        boolean m10;
        if (z10) {
            m10 = ((BannerLayout) b(R$id.imageBannerLayout)).l();
        } else {
            m10 = ((BannerLayout) b(R$id.imageBannerLayout)).m();
        }
        if (m10) {
            return;
        }
        if (z10) {
            ObjectAnimator objectAnimator = this.f16964k;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        } else {
            ObjectAnimator objectAnimator2 = this.f16965l;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            VibrationEffect createOneShot = VibrationEffect.createOneShot(20L, -1);
            Object systemService = getContext().getSystemService("vibrator");
            kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(createOneShot);
            return;
        }
        Object systemService2 = getContext().getSystemService("vibrator");
        kotlin.jvm.internal.s.g(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService2).vibrate(20L);
    }

    @Nullable
    public final Function0<kotlin.p> getBackEvent() {
        return this.f16956c;
    }

    @Nullable
    public final Function0<kotlin.p> getMenuClick() {
        return this.f16955b;
    }

    @Nullable
    public final Function2<Float, Boolean, kotlin.p> getMoveEvent() {
        return this.f16957d;
    }

    public final void h(String str) {
        if (str == null || str.length() == 0) {
            i(null);
            return;
        }
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        imageLoaderUtil.h(context, str, new Function1<Drawable, kotlin.p>() { // from class: com.cupidapp.live.match.view.MatchFKProfileLayout$configNearbyProfileBorder$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Drawable drawable) {
                invoke2(drawable);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Drawable drawable) {
                MatchFKProfileLayout.this.i(drawable);
            }
        });
    }

    public final void i(Drawable drawable) {
        int i10 = R$id.nearby_profile_border_view;
        b(i10).setBackground(drawable);
        if (drawable == null) {
            b(i10).setVisibility(8);
            ((BannerLayout) b(R$id.imageBannerLayout)).n(z0.h.c(this, 8.0f));
            RelativeLayout menuLayout = (RelativeLayout) b(R$id.menuLayout);
            kotlin.jvm.internal.s.h(menuLayout, "menuLayout");
            z0.y.m(menuLayout, null, null, Integer.valueOf(z0.h.c(this, 0.0f)), null, 11, null);
            TextView profile_tip_txt = (TextView) b(R$id.profile_tip_txt);
            kotlin.jvm.internal.s.h(profile_tip_txt, "profile_tip_txt");
            z0.y.m(profile_tip_txt, null, Integer.valueOf(z0.h.c(this, 16.0f)), null, null, 13, null);
            return;
        }
        b(i10).setVisibility(0);
        ((BannerLayout) b(R$id.imageBannerLayout)).n(z0.h.c(this, 14.0f));
        RelativeLayout menuLayout2 = (RelativeLayout) b(R$id.menuLayout);
        kotlin.jvm.internal.s.h(menuLayout2, "menuLayout");
        z0.y.m(menuLayout2, null, null, Integer.valueOf(z0.h.c(this, 6.0f)), null, 11, null);
        TextView profile_tip_txt2 = (TextView) b(R$id.profile_tip_txt);
        kotlin.jvm.internal.s.h(profile_tip_txt2, "profile_tip_txt");
        z0.y.m(profile_tip_txt2, null, Integer.valueOf(z0.h.c(this, 26.0f)), null, null, 13, null);
    }

    public final void j(TipUiModel tipUiModel) {
        if (tipUiModel == null) {
            return;
        }
        int i10 = R$id.profile_tip_txt;
        ((TextView) b(i10)).setVisibility(0);
        ((TextView) b(i10)).setText(tipUiModel.getContent());
        TextView profile_tip_txt = (TextView) b(i10);
        kotlin.jvm.internal.s.h(profile_tip_txt, "profile_tip_txt");
        z0.u.a(profile_tip_txt);
        ((TextView) b(i10)).setTextColor(tipUiModel.getTxtColor());
        ((TextView) b(i10)).setBackgroundResource(tipUiModel.getBgDrawable());
    }

    public final void k(@NotNull final NearbyUserProfileModel user, final boolean z10) {
        kotlin.jvm.internal.s.i(user, "user");
        this.f16967n = SensorPosition.NearbyCoverCard;
        this.f16962i = user.getId();
        postDelayed(new Runnable() { // from class: com.cupidapp.live.match.view.w
            @Override // java.lang.Runnable
            public final void run() {
                MatchFKProfileLayout.l(MatchFKProfileLayout.this, z10, user);
            }
        }, 200L);
    }

    public final void m(View view) {
        this.f16964k = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0.0f, z0.h.c(this, 8.0f));
        this.f16965l = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, 0.0f, -z0.h.c(this, 8.0f));
        ObjectAnimator objectAnimator = this.f16964k;
        if (objectAnimator != null) {
            objectAnimator.setDuration(60L);
        }
        ObjectAnimator objectAnimator2 = this.f16964k;
        if (objectAnimator2 != null) {
            objectAnimator2.setRepeatCount(1);
        }
        ObjectAnimator objectAnimator3 = this.f16964k;
        if (objectAnimator3 != null) {
            objectAnimator3.setRepeatMode(2);
        }
        ObjectAnimator objectAnimator4 = this.f16965l;
        if (objectAnimator4 != null) {
            objectAnimator4.setDuration(60L);
        }
        ObjectAnimator objectAnimator5 = this.f16965l;
        if (objectAnimator5 != null) {
            objectAnimator5.setRepeatCount(1);
        }
        ObjectAnimator objectAnimator6 = this.f16965l;
        if (objectAnimator6 == null) {
            return;
        }
        objectAnimator6.setRepeatMode(2);
    }

    public final void n(ImageModel imageModel) {
        int i10 = R$id.imageBannerLayout;
        BannerLayout imageBannerLayout = (BannerLayout) b(i10);
        kotlin.jvm.internal.s.h(imageBannerLayout, "imageBannerLayout");
        BannerLayout.setBannerCorner$default(imageBannerLayout, z0.h.c(this, 18.0f), z0.h.c(this, 18.0f), 0.0f, 0.0f, 12, null);
        ((BannerLayout) b(i10)).setAutoScroll(false);
        ((BannerLayout) b(i10)).setRecyclerStyle(false);
        ((BannerLayout) b(i10)).setPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.cupidapp.live.match.view.MatchFKProfileLayout$initImageBanner$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i11) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i11, float f10, int i12) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i11) {
                int i12;
                if (i11 != 0) {
                    i12 = MatchFKProfileLayout.this.f16966m;
                    if (i11 > i12) {
                        MatchFKProfileLayout.this.p();
                    }
                }
                MatchFKProfileLayout.this.f16966m = i11;
            }
        });
        ((BannerLayout) b(i10)).setImageModelList(kotlin.collections.r.e(imageModel));
        ((BannerLayout) b(i10)).setTopIndicatorVisible();
    }

    public final void o() {
        z0.z.a(this, R$layout.layout_match_profile, true);
        ((RoundedFrameLayout) b(R$id.matchProfileCard)).setCornerRadius(z0.h.c(this, 16.0f));
        this.f16959f = z0.h.l(this);
        m(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        return true;
    }

    public final void p() {
        String str = this.f16962i;
        if (str != null) {
            int i10 = R$id.imageBannerLayout;
            int currentItemPosition = ((BannerLayout) b(i10)).getCurrentItemPosition();
            List<ImageModel> imageModelList = ((BannerLayout) b(i10)).getImageModelList();
            boolean z10 = false;
            if (currentItemPosition >= 0 && currentItemPosition < imageModelList.size()) {
                z10 = true;
            }
            if (z10) {
                SensorsLogMatch sensorsLogMatch = SensorsLogMatch.f12215a;
                int size = imageModelList.size();
                SensorPosition sensorPosition = this.f16967n;
                sensorsLogMatch.d(str, currentItemPosition, size, null, sensorPosition, SensorScene.Match, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? null : sensorPosition == SensorPosition.Match ? imageModelList.get(currentItemPosition).getImageId() : null);
            }
        }
    }

    public final boolean q() {
        int i10 = R$id.newMatchGuideLayout;
        if (((RoundedFrameLayout) b(i10)).getVisibility() != 0) {
            return false;
        }
        p1.g.f52734a.u0().d(Boolean.FALSE);
        ((RoundedFrameLayout) b(i10)).setVisibility(8);
        return true;
    }

    public final void r(float f10, float f11, float f12) {
        if (Math.abs(f10 - this.f16958e) < this.f16959f / 360 && Math.abs(f11 - this.f16960g) < this.f16959f / 360) {
            if (q()) {
                return;
            }
            if (getHeight() - f12 >= z0.h.c(this, 120.0f)) {
                if (System.currentTimeMillis() - this.f16963j <= 500) {
                    g(f10 < ((float) (this.f16959f / 2)));
                    return;
                }
                return;
            } else {
                Function0<kotlin.p> function0 = this.f16955b;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
        }
        float abs = Math.abs(f10 - this.f16958e);
        int i10 = this.f16959f;
        if (abs < i10 / 5 && f11 - this.f16960g > i10 / 5) {
            Function0<kotlin.p> function02 = this.f16956c;
            if (function02 != null) {
                function02.invoke();
                return;
            }
            return;
        }
        Function2<? super Float, ? super Boolean, kotlin.p> function2 = this.f16957d;
        if (function2 != null) {
            function2.mo1743invoke(Float.valueOf(0.0f), Boolean.TRUE);
        }
    }

    public final void setBackEvent(@Nullable Function0<kotlin.p> function0) {
        this.f16956c = function0;
    }

    public final void setData(@Nullable NearbyUserModel nearbyUserModel, @Nullable TipUiModel tipUiModel) {
        if ((nearbyUserModel != null ? nearbyUserModel.getAvatarImage() : null) == null) {
            return;
        }
        this.f16962i = nearbyUserModel.getId();
        n(nearbyUserModel.getAvatarImage());
        j(tipUiModel);
    }

    public final void setMenuClick(@Nullable Function0<kotlin.p> function0) {
        this.f16955b = function0;
    }

    public final void setMoveEvent(@Nullable Function2<? super Float, ? super Boolean, kotlin.p> function2) {
        this.f16957d = function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchFKProfileLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16968o = new LinkedHashMap();
        this.f16967n = SensorPosition.NearbyCoverCard;
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchFKProfileLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16968o = new LinkedHashMap();
        this.f16967n = SensorPosition.NearbyCoverCard;
        o();
    }
}
