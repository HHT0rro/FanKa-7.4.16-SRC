package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TrimDragLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TrimDragLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public GestureDetector f18233b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18234c;

    /* renamed from: d, reason: collision with root package name */
    public int f18235d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f18236e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18237f;

    /* compiled from: TrimDragLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent motionEvent, @Nullable MotionEvent motionEvent2, float f10, float f11) {
            if (TrimDragLayout.this.getWidth() <= 0 && TrimDragLayout.this.getHeight() <= 0) {
                return false;
            }
            if (TrimDragLayout.this.f18234c) {
                if (Math.abs(TrimDragLayout.this.getScrollY() + f11) < TrimDragLayout.this.f18235d) {
                    TrimDragLayout.this.scrollBy(0, (int) f11);
                } else {
                    int abs = TrimDragLayout.this.f18235d - Math.abs(TrimDragLayout.this.getScrollY());
                    if (abs > 0) {
                        int min = Math.min(abs, Math.abs((int) f11));
                        if (f11 <= 0.0f) {
                            min = -min;
                        }
                        TrimDragLayout.this.scrollBy(0, min);
                    }
                }
                Function1 function1 = TrimDragLayout.this.f18236e;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(TrimDragLayout.this.getScrollY()));
                }
            } else {
                if (Math.abs(TrimDragLayout.this.getScrollX() + f10) < TrimDragLayout.this.f18235d) {
                    TrimDragLayout.this.scrollBy((int) f10, 0);
                } else {
                    int abs2 = TrimDragLayout.this.f18235d - Math.abs(TrimDragLayout.this.getScrollX());
                    if (abs2 > 0) {
                        int min2 = Math.min(abs2, Math.abs((int) f10));
                        if (f10 <= 0.0f) {
                            min2 = -min2;
                        }
                        TrimDragLayout.this.scrollBy(min2, 0);
                    }
                }
                Function1 function12 = TrimDragLayout.this.f18236e;
                if (function12 != null) {
                    function12.invoke(Integer.valueOf(TrimDragLayout.this.getScrollX()));
                }
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrimDragLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18237f = new LinkedHashMap();
        this.f18234c = true;
        e();
    }

    public final void d(boolean z10, int i10, @Nullable Function1<? super Integer, p> function1) {
        this.f18234c = z10;
        this.f18235d = i10;
        this.f18236e = function1;
    }

    public final void e() {
        this.f18233b = new GestureDetector(getContext(), new a());
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        if (motionEvent == null || (gestureDetector = this.f18233b) == null) {
            return true;
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrimDragLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18237f = new LinkedHashMap();
        this.f18234c = true;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrimDragLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18237f = new LinkedHashMap();
        this.f18234c = true;
        e();
    }
}
