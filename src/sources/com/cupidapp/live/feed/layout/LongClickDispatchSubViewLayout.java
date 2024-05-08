package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LongClickDispatchSubViewLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LongClickDispatchSubViewLayout extends ConstraintLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f14524b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Runnable f14525c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14526d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongClickDispatchSubViewLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14526d = new LinkedHashMap();
        this.f14525c = new Runnable() { // from class: com.cupidapp.live.feed.layout.k
            @Override // java.lang.Runnable
            public final void run() {
                LongClickDispatchSubViewLayout.b(LongClickDispatchSubViewLayout.this);
            }
        };
    }

    public static final void b(LongClickDispatchSubViewLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f14524b = this$0.performLongClick();
    }

    public final void c() {
        removeCallbacks(this.f14525c);
    }

    public final void d() {
        postDelayed(this.f14525c, ViewConfiguration.getLongPressTimeout());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        kotlin.jvm.internal.s.i(ev, "ev");
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.f14524b = false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev);
        if (actionMasked == 0 && isLongClickable()) {
            d();
        }
        if (ev.getActionMasked() == 1 || ev.getActionMasked() == 3) {
            c();
        }
        return dispatchTouchEvent;
    }

    public final boolean getMLongPressTriggered() {
        return this.f14524b;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev) {
        kotlin.jvm.internal.s.i(ev, "ev");
        if (this.f14524b && ev.getActionMasked() == 1) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (this.f14524b && event.getActionMasked() == 1) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public final void setMLongPressTriggered(boolean z10) {
        this.f14524b = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongClickDispatchSubViewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14526d = new LinkedHashMap();
        this.f14525c = new Runnable() { // from class: com.cupidapp.live.feed.layout.k
            @Override // java.lang.Runnable
            public final void run() {
                LongClickDispatchSubViewLayout.b(LongClickDispatchSubViewLayout.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongClickDispatchSubViewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14526d = new LinkedHashMap();
        this.f14525c = new Runnable() { // from class: com.cupidapp.live.feed.layout.k
            @Override // java.lang.Runnable
            public final void run() {
                LongClickDispatchSubViewLayout.b(LongClickDispatchSubViewLayout.this);
            }
        };
    }
}
