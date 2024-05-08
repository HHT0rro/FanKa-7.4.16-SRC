package com.cupidapp.live.club.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NestedScrollableHostLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NestedScrollableHostLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f13651b;

    /* renamed from: c, reason: collision with root package name */
    public float f13652c;

    /* renamed from: d, reason: collision with root package name */
    public float f13653d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13654e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHostLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13654e = new LinkedHashMap();
        this.f13651b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x000d, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto Lc
            android.view.View r0 = (android.view.View) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            if (r0 == 0) goto L1e
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 != 0) goto L1e
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto Lc
            android.view.View r0 = (android.view.View) r0
            goto Ld
        L1e:
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L25
            r2 = r0
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.club.view.NestedScrollableHostLayout.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    public final boolean a(int i10, float f10) {
        int i11 = -((int) Math.signum(f10));
        if (i10 == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i11);
            }
            return false;
        }
        if (i10 == 1) {
            View child2 = getChild();
            if (child2 != null) {
                return child2.canScrollVertically(i11);
            }
            return false;
        }
        throw new IllegalArgumentException();
    }

    public final void b(MotionEvent motionEvent) {
        ViewPager2 parentViewPager = getParentViewPager();
        if (parentViewPager != null) {
            int orientation = parentViewPager.getOrientation();
            if (a(orientation, -1.0f) || a(orientation, 1.0f)) {
                if (motionEvent.getAction() == 0) {
                    this.f13652c = motionEvent.getX();
                    this.f13653d = motionEvent.getY();
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return;
                }
                if (motionEvent.getAction() == 2) {
                    float x10 = motionEvent.getX() - this.f13652c;
                    float y10 = motionEvent.getY() - this.f13653d;
                    boolean z10 = orientation == 0;
                    float abs = Math.abs(x10) * (z10 ? 0.5f : 1.0f);
                    float abs2 = Math.abs(y10) * (z10 ? 1.0f : 0.5f);
                    int i10 = this.f13651b;
                    if (abs > i10 || abs2 > i10) {
                        if (z10 == (abs2 > abs)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return;
                        }
                        if (!z10) {
                            x10 = y10;
                        }
                        if (a(orientation, x10)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e2) {
        s.i(e2, "e");
        b(e2);
        return super.onInterceptTouchEvent(e2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHostLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13654e = new LinkedHashMap();
        this.f13651b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
