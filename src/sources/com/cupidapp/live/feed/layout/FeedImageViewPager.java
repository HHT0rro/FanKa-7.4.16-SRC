package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.base.view.CanScrollLinearLayoutManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedImageViewPager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FeedImageViewPager extends ViewPager {

    /* renamed from: b, reason: collision with root package name */
    public boolean f14471b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super MotionEvent, Boolean> f14472c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14473d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedImageViewPager(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14473d = new LinkedHashMap();
        this.f14471b = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        if (getChildCount() > 1) {
            ViewParent parent = getParent();
            while (!(parent instanceof ViewPager) && parent != null) {
                parent = parent.getParent();
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean getCanScroll() {
        return this.f14471b;
    }

    @Nullable
    public final Function1<MotionEvent, Boolean> getCheckCanScroll() {
        return this.f14472c;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        Function1<? super MotionEvent, Boolean> function1 = this.f14472c;
        this.f14471b = function1 != null ? function1.invoke(motionEvent).booleanValue() : true;
        try {
            if (CanScrollLinearLayoutManager.f12424a.a()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        if (CanScrollLinearLayoutManager.f12424a.a()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void setCanScroll(boolean z10) {
        this.f14471b = z10;
    }

    public final void setCheckCanScroll(@Nullable Function1<? super MotionEvent, Boolean> function1) {
        this.f14472c = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedImageViewPager(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(attrs, "attrs");
        this.f14473d = new LinkedHashMap();
        this.f14471b = true;
    }
}
