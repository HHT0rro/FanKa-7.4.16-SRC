package com.cupidapp.live.profile.view;

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
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ProfileMediaViewPagerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileMediaViewPagerLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f17862b;

    /* renamed from: c, reason: collision with root package name */
    public int f17863c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public List<AvatarProfileModel> f17864d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f17865e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f17866f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f17867g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17868h;

    /* compiled from: ProfileMediaViewPagerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
            if (motionEvent != null && motionEvent.getAction() == 1) {
                if (motionEvent.getX() < h.l(this) / 2) {
                    ProfileMediaViewPagerLayout.this.g(true);
                } else {
                    ProfileMediaViewPagerLayout.this.g(false);
                }
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMediaViewPagerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17868h = new LinkedHashMap();
        this.f17862b = 1;
        this.f17864d = new ArrayList();
        n();
    }

    private final int getCurrentItemPosition() {
        return ((ViewPager) b(R$id.userMediaViewPager)).getCurrentItem();
    }

    public static final void l(ProfileMediaViewPagerLayout this$0) {
        s.i(this$0, "this$0");
        this$0.o(this$0.f17863c);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f17868h;
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

    public final void g(boolean z10) {
        boolean i10;
        if (z10) {
            i10 = h();
        } else {
            i10 = i();
        }
        if (i10) {
            return;
        }
        if (z10) {
            ObjectAnimator objectAnimator = this.f17866f;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        } else {
            ObjectAnimator objectAnimator2 = this.f17867g;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            VibrationEffect createOneShot = VibrationEffect.createOneShot(20L, -1);
            Object systemService = getContext().getSystemService("vibrator");
            s.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(createOneShot);
            return;
        }
        Object systemService2 = getContext().getSystemService("vibrator");
        s.g(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService2).vibrate(20L);
    }

    public final boolean h() {
        if (getCurrentItemPosition() == 0) {
            return false;
        }
        ((ViewPager) b(R$id.userMediaViewPager)).setCurrentItem(getCurrentItemPosition() - 1, false);
        return true;
    }

    public final boolean i() {
        if (getCurrentItemPosition() >= this.f17862b - 1) {
            return false;
        }
        ((ViewPager) b(R$id.userMediaViewPager)).setCurrentItem(getCurrentItemPosition() + 1, false);
        return true;
    }

    public final void j(@Nullable Drawable drawable) {
        int c4;
        int i10 = R$id.profile_border_view;
        b(i10).setBackground(drawable);
        if (drawable == null) {
            b(i10).setVisibility(8);
            ((CardView) b(R$id.profile_media_parent_card_view)).setRadius(h.c(this, 12.0f));
            c4 = h.c(this, 8.0f);
        } else {
            b(i10).setVisibility(0);
            ((CardView) b(R$id.profile_media_parent_card_view)).setRadius(h.c(this, 16.0f));
            c4 = h.c(this, 14.0f);
        }
        TopIndicatorLayout topIndicatorLayout = (TopIndicatorLayout) b(R$id.topIndicatorLayout);
        s.h(topIndicatorLayout, "topIndicatorLayout");
        y.m(topIndicatorLayout, Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4), null, 8, null);
    }

    public final void k(@NotNull User user) {
        s.i(user, "user");
        List<AvatarProfileModel> list = null;
        if (!user.getAvatarProfile().isEmpty()) {
            list = CollectionsKt___CollectionsKt.z0(user.getAvatarProfile());
        } else if (user.getAvatarImage() != null) {
            ImageModel avatarImage = user.getAvatarImage();
            s.f(avatarImage);
            list = kotlin.collections.s.o(new AvatarProfileModel(null, avatarImage));
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        if (!s.d(list, this.f17864d)) {
            ((ViewPager) b(R$id.userMediaViewPager)).setAdapter(new ProfileMediaPagerAdapter(list));
            this.f17862b = list.size();
            if (list.size() > 1) {
                b(R$id.blur).setVisibility(0);
                ((TopIndicatorLayout) b(R$id.topIndicatorLayout)).setVisibility(0);
            } else {
                b(R$id.blur).setVisibility(8);
                ((TopIndicatorLayout) b(R$id.topIndicatorLayout)).setVisibility(8);
            }
            int i10 = R$id.topIndicatorLayout;
            ((TopIndicatorLayout) b(i10)).setPagerCount(list.size());
            ((TopIndicatorLayout) b(i10)).setCurrentPager(0);
            this.f17863c = 0;
            this.f17864d = list;
        }
        ((ViewPager) b(R$id.userMediaViewPager)).post(new Runnable() { // from class: com.cupidapp.live.profile.view.e
            @Override // java.lang.Runnable
            public final void run() {
                ProfileMediaViewPagerLayout.l(ProfileMediaViewPagerLayout.this);
            }
        });
        this.f17865e = user.userId();
    }

    public final void m() {
        this.f17866f = ObjectAnimator.ofFloat(this, (Property<ProfileMediaViewPagerLayout, Float>) View.TRANSLATION_X, 0.0f, h.c(this, 8.0f));
        this.f17867g = ObjectAnimator.ofFloat(this, (Property<ProfileMediaViewPagerLayout, Float>) View.TRANSLATION_X, 0.0f, -h.c(this, 8.0f));
        ObjectAnimator objectAnimator = this.f17866f;
        if (objectAnimator != null) {
            objectAnimator.setDuration(60L);
        }
        ObjectAnimator objectAnimator2 = this.f17866f;
        if (objectAnimator2 != null) {
            objectAnimator2.setRepeatCount(1);
        }
        ObjectAnimator objectAnimator3 = this.f17866f;
        if (objectAnimator3 != null) {
            objectAnimator3.setRepeatMode(2);
        }
        ObjectAnimator objectAnimator4 = this.f17867g;
        if (objectAnimator4 != null) {
            objectAnimator4.setDuration(60L);
        }
        ObjectAnimator objectAnimator5 = this.f17867g;
        if (objectAnimator5 != null) {
            objectAnimator5.setRepeatCount(1);
        }
        ObjectAnimator objectAnimator6 = this.f17867g;
        if (objectAnimator6 == null) {
            return;
        }
        objectAnimator6.setRepeatMode(2);
    }

    public final void n() {
        z.a(this, R$layout.layout_profile_media_view_pager, true);
        int i10 = R$id.userMediaViewPager;
        ((ViewPager) b(i10)).setOnTouchListener(new a());
        ((ViewPager) b(i10)).setOffscreenPageLimit(6);
        ((ViewPager) b(i10)).addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.cupidapp.live.profile.view.ProfileMediaViewPagerLayout$initView$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i11) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i11, float f10, int i12) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i11) {
                String str;
                ProfileMediaViewPagerLayout profileMediaViewPagerLayout = ProfileMediaViewPagerLayout.this;
                int i12 = R$id.topIndicatorLayout;
                ((TopIndicatorLayout) profileMediaViewPagerLayout.b(i12)).setCurrentPager(i11);
                ProfileMediaViewPagerLayout.this.p();
                ProfileMediaViewPagerLayout.this.o(i11);
                ProfileMediaViewPagerLayout.this.f17863c = i11;
                SensorsLogMatch sensorsLogMatch = SensorsLogMatch.f12215a;
                str = ProfileMediaViewPagerLayout.this.f17865e;
                if (str == null) {
                    str = "";
                }
                sensorsLogMatch.d(str, i11, ((TopIndicatorLayout) ProfileMediaViewPagerLayout.this.b(i12)).getPagerCount(), null, SensorPosition.Profile, SensorScene.Feed, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? null : null);
            }
        });
        m();
    }

    public final void o(int i10) {
        if (this.f17864d.get(i10).getAvatarVideo() != null) {
            View childAt = ((ViewPager) b(R$id.userMediaViewPager)).getChildAt(i10);
            SingleUserProfileMediaLayout singleUserProfileMediaLayout = childAt instanceof SingleUserProfileMediaLayout ? (SingleUserProfileMediaLayout) childAt : null;
            if (singleUserProfileMediaLayout != null) {
                singleUserProfileMediaLayout.d();
            }
        }
    }

    public final void p() {
        if (this.f17863c >= this.f17864d.size() || this.f17864d.get(this.f17863c).getAvatarVideo() == null) {
            return;
        }
        View childAt = ((ViewPager) b(R$id.userMediaViewPager)).getChildAt(this.f17863c);
        SingleUserProfileMediaLayout singleUserProfileMediaLayout = childAt instanceof SingleUserProfileMediaLayout ? (SingleUserProfileMediaLayout) childAt : null;
        if (singleUserProfileMediaLayout != null) {
            singleUserProfileMediaLayout.e();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMediaViewPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17868h = new LinkedHashMap();
        this.f17862b = 1;
        this.f17864d = new ArrayList();
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMediaViewPagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17868h = new LinkedHashMap();
        this.f17862b = 1;
        this.f17864d = new ArrayList();
        n();
    }
}
