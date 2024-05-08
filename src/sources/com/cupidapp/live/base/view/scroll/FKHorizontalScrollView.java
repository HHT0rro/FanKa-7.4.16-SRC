package com.cupidapp.live.base.view.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.view.scroll.FKHorizontalScrollView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKHorizontalScrollView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f12892b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public ScrollType f12893c;

    /* renamed from: d, reason: collision with root package name */
    public int f12894d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Runnable f12895e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12896f = new LinkedHashMap();

    /* compiled from: FKHorizontalScrollView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ScrollType {
        IDLE,
        TOUCH_SCROLL,
        FLING
    }

    /* compiled from: FKHorizontalScrollView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(@NotNull ScrollType scrollType);
    }

    public FKHorizontalScrollView(@Nullable Context context) {
        super(context);
        this.f12893c = ScrollType.IDLE;
        this.f12894d = -9999999;
        this.f12895e = new Runnable() { // from class: u1.a
            @Override // java.lang.Runnable
            public final void run() {
                FKHorizontalScrollView.c(FKHorizontalScrollView.this);
            }
        };
    }

    public static final void c(FKHorizontalScrollView this$0) {
        s.i(this$0, "this$0");
        this$0.b();
    }

    public final void b() {
        if (getScrollX() == this.f12894d) {
            ScrollType scrollType = ScrollType.IDLE;
            this.f12893c = scrollType;
            a aVar = this.f12892b;
            if (aVar != null) {
                aVar.a(scrollType);
            }
            AppApplication.f11612d.h().j().removeCallbacks(this.f12895e);
            return;
        }
        ScrollType scrollType2 = ScrollType.FLING;
        this.f12893c = scrollType2;
        a aVar2 = this.f12892b;
        if (aVar2 != null) {
            aVar2.a(scrollType2);
        }
        this.f12894d = getScrollX();
        AppApplication.f11612d.h().j().postDelayed(this.f12895e, 50L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AppApplication.f11612d.h().j().removeCallbacks(this.f12895e);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            ScrollType scrollType = ScrollType.TOUCH_SCROLL;
            this.f12893c = scrollType;
            a aVar = this.f12892b;
            if (aVar != null) {
                aVar.a(scrollType);
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            AppApplication.f11612d.h().j().post(this.f12895e);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setScrollViewListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f12892b = listener;
    }

    public FKHorizontalScrollView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12893c = ScrollType.IDLE;
        this.f12894d = -9999999;
        this.f12895e = new Runnable() { // from class: u1.a
            @Override // java.lang.Runnable
            public final void run() {
                FKHorizontalScrollView.c(FKHorizontalScrollView.this);
            }
        };
    }

    public FKHorizontalScrollView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12893c = ScrollType.IDLE;
        this.f12894d = -9999999;
        this.f12895e = new Runnable() { // from class: u1.a
            @Override // java.lang.Runnable
            public final void run() {
                FKHorizontalScrollView.c(FKHorizontalScrollView.this);
            }
        };
    }
}
