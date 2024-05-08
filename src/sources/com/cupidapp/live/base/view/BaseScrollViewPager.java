package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseScrollViewPager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseScrollViewPager extends ViewPager {

    /* renamed from: b, reason: collision with root package name */
    public boolean f12422b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12423c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseScrollViewPager(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12423c = new LinkedHashMap();
        this.f12422b = true;
    }

    public final boolean getCanScroll() {
        return this.f12422b;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        try {
            if (this.f12422b) {
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
        if (this.f12422b) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void setCanScroll(boolean z10) {
        this.f12422b = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseScrollViewPager(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(attrs, "attrs");
        this.f12423c = new LinkedHashMap();
        this.f12422b = true;
    }
}
