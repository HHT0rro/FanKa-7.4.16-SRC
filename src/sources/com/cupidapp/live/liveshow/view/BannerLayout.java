package com.cupidapp.live.liveshow.view;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import com.cupidapp.live.liveshow.adapter.FKLiveBannerPagerAdapter;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveBannerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BannerLayout extends RoundedFrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public int f15241h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public CountDownTimer f15242i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public FKLiveBannerPagerAdapter f15243j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f15244k;

    /* renamed from: l, reason: collision with root package name */
    public final long f15245l;

    /* renamed from: m, reason: collision with root package name */
    public final long f15246m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15247n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15248o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public ViewPager.OnPageChangeListener f15249p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f15250q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f15251r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15252s;

    /* compiled from: FKLiveBannerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f15253a;

        /* renamed from: b, reason: collision with root package name */
        public final int f15254b;

        public a(int i10, int i11) {
            this.f15253a = i10;
            this.f15254b = i11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f15253a == aVar.f15253a && this.f15254b == aVar.f15254b;
        }

        public int hashCode() {
            return (this.f15253a * 31) + this.f15254b;
        }

        @NotNull
        public String toString() {
            return "BannerPageState(coverNum=" + this.f15253a + ", coverIndex=" + this.f15254b + ")";
        }
    }

    /* compiled from: FKLiveBannerLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends CountDownTimer {
        public b(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            View findViewById;
            if (j10 == BannerLayout.this.f15246m) {
                return;
            }
            Context context = BannerLayout.this.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            boolean z10 = false;
            if (activity != null && (findViewById = activity.findViewById(16908290)) != null && !findViewById.isShown()) {
                z10 = true;
            }
            if (z10) {
                BannerLayout.this.r();
            } else {
                if (j10 > BannerLayout.this.f15245l - BannerLayout.this.f15246m) {
                    return;
                }
                BannerLayout bannerLayout = BannerLayout.this;
                int i10 = R$id.bannerContentViewPager;
                bannerLayout.f15241h = ((ViewPager) bannerLayout.d(i10)).getCurrentItem() + 1;
                ((ViewPager) BannerLayout.this.d(i10)).setCurrentItem(BannerLayout.this.f15241h % BannerLayout.this.getBannerAdapter().a().size());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15252s = new LinkedHashMap();
        this.f15243j = new FKLiveBannerPagerAdapter();
        this.f15245l = 360000000L;
        this.f15246m = HwCubicBezierInterpolator.f34870a;
        this.f15247n = true;
        this.f15248o = true;
        this.f15251r = true;
        o();
    }

    public static final boolean p(BannerLayout this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this$0.r();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        this$0.q();
        return false;
    }

    public static /* synthetic */ void setBannerCorner$default(BannerLayout bannerLayout, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        bannerLayout.setBannerCorner(f10, f11, f12, f13);
    }

    @Nullable
    public View d(int i10) {
        Map<Integer, View> map = this.f15252s;
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

    public final boolean getAutoScroll() {
        return this.f15247n;
    }

    @NotNull
    public final FKLiveBannerPagerAdapter getBannerAdapter() {
        return this.f15243j;
    }

    @NotNull
    public final a getBannerPageState() {
        return new a(getImageModelList().size(), getCurrentItemPosition() + 1);
    }

    public final int getCurrentItemPosition() {
        return ((ViewPager) d(R$id.bannerContentViewPager)).getCurrentItem();
    }

    @NotNull
    public final List<ImageModel> getImageModelList() {
        return this.f15243j.a();
    }

    @Nullable
    public final Function1<Integer, p> getListener() {
        return this.f15244k;
    }

    @Nullable
    public final Function1<Integer, p> getLiveBannerShowLoggerListener() {
        return this.f15250q;
    }

    @Nullable
    public final ViewPager.OnPageChangeListener getPageChangeListener() {
        return this.f15249p;
    }

    public final boolean getRecyclerStyle() {
        return this.f15248o;
    }

    public final boolean l() {
        if (getCurrentItemPosition() == 0) {
            return false;
        }
        ((ViewPager) d(R$id.bannerContentViewPager)).setCurrentItem(getCurrentItemPosition() - 1, false);
        return true;
    }

    public final boolean m() {
        if (getCurrentItemPosition() >= this.f15243j.a().size() - 1) {
            return false;
        }
        ((ViewPager) d(R$id.bannerContentViewPager)).setCurrentItem(getCurrentItemPosition() + 1, false);
        return true;
    }

    public final void n(int i10) {
        TopIndicatorLayout topIndicatorLayout = (TopIndicatorLayout) d(R$id.topIndicatorLayout);
        s.h(topIndicatorLayout, "topIndicatorLayout");
        y.m(topIndicatorLayout, Integer.valueOf(i10), Integer.valueOf(i10), Integer.valueOf(i10), null, 8, null);
    }

    public final void o() {
        z.a(this, R$layout.layout_banner, true);
        int i10 = R$id.bannerContentViewPager;
        ((ViewPager) d(i10)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean p10;
                p10 = BannerLayout.p(BannerLayout.this, view, motionEvent);
                return p10;
            }
        });
        ((ViewPager) d(i10)).setOffscreenPageLimit(6);
        ((ViewPager) d(i10)).addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.cupidapp.live.liveshow.view.BannerLayout$initView$2

            /* renamed from: b, reason: collision with root package name */
            public int f15256b;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i11) {
                int size;
                ViewPager.OnPageChangeListener pageChangeListener = BannerLayout.this.getPageChangeListener();
                if (pageChangeListener != null) {
                    pageChangeListener.onPageScrollStateChanged(i11);
                }
                if (i11 == 0 && BannerLayout.this.getRecyclerStyle() && (size = BannerLayout.this.getBannerAdapter().a().size()) != 0 && this.f15256b == size - 1) {
                    ((ViewPager) BannerLayout.this.d(R$id.bannerContentViewPager)).setCurrentItem(0, false);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i11, float f10, int i12) {
                ViewPager.OnPageChangeListener pageChangeListener = BannerLayout.this.getPageChangeListener();
                if (pageChangeListener != null) {
                    pageChangeListener.onPageScrolled(i11, f10, i12);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i11) {
                boolean z10;
                int size;
                z10 = BannerLayout.this.f15251r;
                if (z10 && i11 < BannerLayout.this.getBannerAdapter().a().size() - 1) {
                    if (i11 == size - 1) {
                        BannerLayout.this.f15251r = false;
                    }
                    Function1<Integer, p> liveBannerShowLoggerListener = BannerLayout.this.getLiveBannerShowLoggerListener();
                    if (liveBannerShowLoggerListener != null) {
                        liveBannerShowLoggerListener.invoke(Integer.valueOf(i11));
                    }
                }
                this.f15256b = i11;
                ((PagerIndicatorLayout) BannerLayout.this.d(R$id.pagerIndicatorLayout)).setCurrentPager(this.f15256b);
                ((TopIndicatorLayout) BannerLayout.this.d(R$id.topIndicatorLayout)).setCurrentPager(this.f15256b);
                ViewPager.OnPageChangeListener pageChangeListener = BannerLayout.this.getPageChangeListener();
                if (pageChangeListener != null) {
                    pageChangeListener.onPageSelected(i11);
                }
            }
        });
    }

    public final void q() {
        if (this.f15247n) {
            int i10 = R$id.bannerContentViewPager;
            if (((ViewPager) d(i10)).getAdapter() != null) {
                PagerAdapter adapter = ((ViewPager) d(i10)).getAdapter();
                if ((adapter != null ? adapter.getCount() : 0) <= 1) {
                    return;
                }
                r();
                this.f15242i = new b(this.f15245l, this.f15246m).start();
            }
        }
    }

    public final void r() {
        CountDownTimer countDownTimer = this.f15242i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f15242i = null;
    }

    public final void setAutoScroll(boolean z10) {
        this.f15247n = z10;
    }

    public final void setBannerAdapter(@NotNull FKLiveBannerPagerAdapter fKLiveBannerPagerAdapter) {
        s.i(fKLiveBannerPagerAdapter, "<set-?>");
        this.f15243j = fKLiveBannerPagerAdapter;
    }

    public final void setBannerCorner(float f10, float f11, float f12, float f13) {
        super.setTopLeftRadius(f10);
        super.setTopRightRadius(f11);
        super.setBottomLeftRadius(f12);
        super.setBottomRightRadius(f13);
    }

    public final void setBgColor(@ColorInt int i10) {
        ((RelativeLayout) d(R$id.bannerLayout)).setBackgroundColor(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setImageModelList(@NotNull List<ImageModel> imageModelList) {
        s.i(imageModelList, "imageModelList");
        this.f15251r = true;
        r();
        this.f15243j.a().clear();
        this.f15243j.c().clear();
        FKLiveBannerPagerAdapter fKLiveBannerPagerAdapter = new FKLiveBannerPagerAdapter();
        this.f15243j = fKLiveBannerPagerAdapter;
        fKLiveBannerPagerAdapter.d(this.f15244k);
        this.f15243j.a().addAll(imageModelList);
        if (imageModelList.size() > 1 && this.f15248o) {
            this.f15243j.a().add(CollectionsKt___CollectionsKt.T(imageModelList));
        }
        int i10 = R$id.bannerContentViewPager;
        ((ViewPager) d(i10)).setAdapter(this.f15243j);
        PagerAdapter adapter = ((ViewPager) d(i10)).getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        int i11 = R$id.pagerIndicatorLayout;
        ((PagerIndicatorLayout) d(i11)).setPagerCount(imageModelList.size());
        ((PagerIndicatorLayout) d(i11)).setCurrentPager(((ViewPager) d(i10)).getCurrentItem());
        int i12 = R$id.topIndicatorLayout;
        ((TopIndicatorLayout) d(i12)).setPagerCount(imageModelList.size());
        ((TopIndicatorLayout) d(i12)).setCurrentPager(((ViewPager) d(i10)).getCurrentItem());
        Function1<? super Integer, p> function1 = this.f15250q;
        if (function1 != null) {
            function1.invoke(0);
        }
        q();
    }

    public final void setListener(@Nullable Function1<? super Integer, p> function1) {
        this.f15244k = function1;
    }

    public final void setLiveBannerShowLoggerListener(@Nullable Function1<? super Integer, p> function1) {
        this.f15250q = function1;
    }

    public final void setPageChangeListener(@Nullable ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f15249p = onPageChangeListener;
    }

    public final void setRecyclerStyle(boolean z10) {
        this.f15248o = z10;
    }

    public final void setTopIndicatorVisible() {
        ((RelativeLayout) d(R$id.bannerLayout)).setBackground(ContextCompat.getDrawable(getContext(), R$color.app_transparent));
        d(R$id.blur).setVisibility(0);
        ((PagerIndicatorLayout) d(R$id.pagerIndicatorLayout)).setVisibility(8);
        ((TopIndicatorLayout) d(R$id.topIndicatorLayout)).setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15252s = new LinkedHashMap();
        this.f15243j = new FKLiveBannerPagerAdapter();
        this.f15245l = 360000000L;
        this.f15246m = HwCubicBezierInterpolator.f34870a;
        this.f15247n = true;
        this.f15248o = true;
        this.f15251r = true;
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15252s = new LinkedHashMap();
        this.f15243j = new FKLiveBannerPagerAdapter();
        this.f15245l = 360000000L;
        this.f15246m = HwCubicBezierInterpolator.f34870a;
        this.f15247n = true;
        this.f15248o = true;
        this.f15251r = true;
        o();
    }
}
