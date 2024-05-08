package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: ClickChangePageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ClickChangePageLayout extends RoundedFrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public int f14436h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f14437i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Rect f14438j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14439k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickChangePageLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14439k = new LinkedHashMap();
        this.f14436h = 1;
        this.f14437i = kotlin.c.b(new Function0<com.cupidapp.live.feed.helper.b>() { // from class: com.cupidapp.live.feed.layout.ClickChangePageLayout$animatorHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.cupidapp.live.feed.helper.b invoke() {
                return new com.cupidapp.live.feed.helper.b(ClickChangePageLayout.this);
            }
        });
        j();
    }

    private final com.cupidapp.live.feed.helper.b getAnimatorHelper() {
        return (com.cupidapp.live.feed.helper.b) this.f14437i.getValue();
    }

    private final int getCurrentItemPosition() {
        return getViewPager2().getCurrentItem();
    }

    public final void c(boolean z10) {
        boolean g3;
        if (z10) {
            g3 = f();
        } else {
            g3 = g();
        }
        if (g3) {
            return;
        }
        if (z10) {
            if (e()) {
                getAnimatorHelper().c();
            }
        } else if (d()) {
            getAnimatorHelper().b();
        }
    }

    public abstract boolean d();

    public abstract boolean e();

    public final boolean f() {
        if (getCurrentItemPosition() == 0) {
            return false;
        }
        getViewPager2().setCurrentItem(getCurrentItemPosition() - 1, false);
        return true;
    }

    public final boolean g() {
        if (getCurrentItemPosition() >= this.f14436h - 1) {
            return false;
        }
        getViewPager2().setCurrentItem(getCurrentItemPosition() + 1, false);
        return true;
    }

    @NotNull
    public abstract TopIndicatorLayout getTopIndicatorLayout();

    @NotNull
    public abstract ViewPager2 getViewPager2();

    public final void h(@NotNull Rect clickableRangeRect) {
        kotlin.jvm.internal.s.i(clickableRangeRect, "clickableRangeRect");
        this.f14438j = clickableRangeRect;
    }

    public abstract int i();

    public final void j() {
        z.a(this, i(), true);
        getViewPager2().registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.feed.layout.ClickChangePageLayout$initView$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                ClickChangePageLayout.this.getTopIndicatorLayout().setCurrentPager(i10);
            }
        });
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            Rect rect = this.f14438j;
            if (rect == null || (motionEvent.getY() > ((float) rect.top) && motionEvent.getY() < ((float) rect.bottom) && motionEvent.getX() > ((float) rect.left) && motionEvent.getX() < ((float) rect.right))) {
                if (motionEvent.getX() < z0.h.l(this) / 2) {
                    c(true);
                } else {
                    c(false);
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setPagerSize(int i10) {
        this.f14436h = i10;
        if (i10 > 1) {
            getTopIndicatorLayout().setVisibility(0);
            getTopIndicatorLayout().setPagerCount(i10);
        } else {
            getTopIndicatorLayout().setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickChangePageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14439k = new LinkedHashMap();
        this.f14436h = 1;
        this.f14437i = kotlin.c.b(new Function0<com.cupidapp.live.feed.helper.b>() { // from class: com.cupidapp.live.feed.layout.ClickChangePageLayout$animatorHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.cupidapp.live.feed.helper.b invoke() {
                return new com.cupidapp.live.feed.helper.b(ClickChangePageLayout.this);
            }
        });
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickChangePageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14439k = new LinkedHashMap();
        this.f14436h = 1;
        this.f14437i = kotlin.c.b(new Function0<com.cupidapp.live.feed.helper.b>() { // from class: com.cupidapp.live.feed.layout.ClickChangePageLayout$animatorHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.cupidapp.live.feed.helper.b invoke() {
                return new com.cupidapp.live.feed.helper.b(ClickChangePageLayout.this);
            }
        });
        j();
    }
}
