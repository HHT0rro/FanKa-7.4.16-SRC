package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.e0;
import kotlin.collections.t;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeRefreshLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSwipeRefreshLayout extends SwipeRefreshLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f12522b;

    /* renamed from: c, reason: collision with root package name */
    public int f12523c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12524d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12525e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12526f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeRefreshLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12526f = new LinkedHashMap();
        setColorSchemeColors(-15066598);
    }

    public final boolean getLock() {
        return this.f12524d;
    }

    public final boolean getResult() {
        return this.f12525e;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        this.f12525e = onInterceptTouchEvent;
        if (onInterceptTouchEvent) {
            IntRange intRange = new IntRange(0, getChildCount());
            ArrayList arrayList = new ArrayList(t.t(intRange, 10));
            Iterator<Integer> iterator2 = intRange.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(getChildAt(((e0) iterator2).nextInt()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (obj instanceof CoordinatorLayout) {
                    arrayList2.add(obj);
                }
            }
            Iterator<E> iterator22 = arrayList2.iterator2();
            while (iterator22.hasNext()) {
                if (!(((CoordinatorLayout) iterator22.next()).getChildAt(0).getY() == 0.0f)) {
                    this.f12525e = false;
                }
            }
        }
        if (motionEvent != null) {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12522b = x10;
                this.f12523c = y10;
            } else if (action == 2) {
                int i10 = x10 - this.f12522b;
                int i11 = y10 - this.f12523c;
                if (Math.abs(i10) > Math.abs(i11) && Math.abs(i10) - Math.abs(i11) > 2) {
                    this.f12525e = false;
                }
            }
            this.f12522b = x10;
            this.f12523c = y10;
        }
        return this.f12525e;
    }

    public final void setLock(boolean z10) {
        this.f12524d = z10;
    }

    public final void setResult(boolean z10) {
        this.f12525e = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeRefreshLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12526f = new LinkedHashMap();
        setColorSchemeColors(-15066598);
    }
}
