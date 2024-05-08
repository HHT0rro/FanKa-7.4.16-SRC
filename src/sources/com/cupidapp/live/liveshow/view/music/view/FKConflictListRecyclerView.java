package com.cupidapp.live.liveshow.view.music.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKConflictListRecyclerView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKConflictListRecyclerView extends RecyclerView {

    /* renamed from: b, reason: collision with root package name */
    public float f15806b;

    /* renamed from: c, reason: collision with root package name */
    public float f15807c;

    /* renamed from: d, reason: collision with root package name */
    public float f15808d;

    /* renamed from: e, reason: collision with root package name */
    public float f15809e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15810f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKConflictListRecyclerView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15810f = new LinkedHashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L7
            boolean r4 = super.dispatchTouchEvent(r4)
            return r4
        L7:
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L64
            if (r0 == r1) goto L5b
            r1 = 2
            if (r0 == r1) goto L17
            r1 = 3
            if (r0 == r1) goto L5b
            goto L77
        L17:
            float r0 = r4.getX()
            r3.f15808d = r0
            float r0 = r4.getY()
            r3.f15809e = r0
            float r1 = r3.f15807c
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r1 = r3.f15808d
            float r2 = r3.f15806b
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L49
            android.view.ViewParent r0 = r3.getParent()
            float r1 = r3.f15807c
            float r2 = r3.f15809e
            float r1 = r1 - r2
            int r1 = (int) r1
            boolean r1 = r3.canScrollVertically(r1)
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L77
        L49:
            android.view.ViewParent r0 = r3.getParent()
            float r1 = r3.f15806b
            float r2 = r3.f15808d
            float r1 = r1 - r2
            int r1 = (int) r1
            boolean r1 = r3.canScrollHorizontally(r1)
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L77
        L5b:
            android.view.ViewParent r0 = r3.getParent()
            r1 = 0
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L77
        L64:
            float r0 = r4.getX()
            r3.f15806b = r0
            float r0 = r4.getY()
            r3.f15807c = r0
            android.view.ViewParent r0 = r3.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L77:
            boolean r4 = super.dispatchTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.music.view.FKConflictListRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKConflictListRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15810f = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKConflictListRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15810f = new LinkedHashMap();
    }
}
