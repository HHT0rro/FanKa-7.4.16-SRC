package com.cupidapp.live.base.view.drag;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseDragLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKBaseDragLayout extends FrameLayout {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f12765l = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public float f12766b;

    /* renamed from: c, reason: collision with root package name */
    public float f12767c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12768d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12769e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Rect f12770f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public r1.a f12771g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Rect f12772h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12773i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12774j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12775k;

    /* compiled from: FKBaseDragLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseDragLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12775k = new LinkedHashMap();
        this.f12773i = true;
        this.f12774j = true;
    }

    public final void a(Rect rect, float f10, float f11) {
        float max;
        float max2;
        if (rect == null) {
            setTranslationX(getTranslationX() + f10);
            setTranslationY(getTranslationY() + f11);
            return;
        }
        if (getX() >= ((float) rect.left) && getX() + ((float) getWidth()) <= ((float) rect.right) && getY() >= ((float) rect.top) && getY() + ((float) getHeight()) <= ((float) rect.bottom)) {
            if (f10 >= 0.0f) {
                max = Math.min(f10, rect.right - (getX() + getWidth()));
            } else {
                max = Math.max(f10, rect.left - getX());
            }
            setTranslationX(getTranslationX() + max);
            if (f11 >= 0.0f) {
                max2 = Math.min(f11, rect.bottom - (getY() + getHeight()));
            } else {
                max2 = Math.max(f11, rect.top - getY());
            }
            setTranslationY(getTranslationY() + max2);
        }
    }

    public final void b(Rect rect, MotionEvent motionEvent) {
        boolean e2;
        if (rect == null) {
            return;
        }
        if (this.f12773i) {
            e2 = c(rect, motionEvent);
        } else {
            e2 = e(rect);
        }
        if (e2 && !this.f12769e) {
            this.f12769e = true;
            n1.a.f52091a.a(getContext(), 50L);
            r1.a aVar = this.f12771g;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (e2 || !this.f12769e) {
            return;
        }
        this.f12769e = false;
        r1.a aVar2 = this.f12771g;
        if (aVar2 != null) {
            aVar2.e();
        }
    }

    public final boolean c(Rect rect, MotionEvent motionEvent) {
        return motionEvent.getRawX() > ((float) rect.left) && motionEvent.getRawX() < ((float) rect.right) && motionEvent.getRawY() > ((float) rect.top) && motionEvent.getRawY() < ((float) rect.bottom);
    }

    public final boolean d(Rect rect, float f10, float f11) {
        return f10 > ((float) rect.left) && f10 < ((float) rect.right) && f11 > ((float) rect.top) && f11 < ((float) rect.bottom);
    }

    public final boolean e(Rect rect) {
        return d(rect, getX(), getY()) || d(rect, getX() + ((float) getWidth()), getY()) || d(rect, getX(), getY() + ((float) getHeight())) || d(rect, getX() + ((float) getWidth()), getY() + ((float) getHeight()));
    }

    public final void f(boolean z10) {
        this.f12774j = z10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        r1.a aVar;
        if (motionEvent != null && this.f12774j) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f12766b = rawX;
                this.f12767c = rawY;
            } else if (action != 1) {
                if (action == 2) {
                    float f10 = rawX - this.f12766b;
                    float f11 = rawY - this.f12767c;
                    if (Math.abs(f10) > 1.0f || Math.abs(f11) > 1.0f) {
                        this.f12768d = true;
                        r1.a aVar2 = this.f12771g;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    }
                    a(this.f12772h, f10, f11);
                    this.f12766b = rawX;
                    this.f12767c = rawY;
                    b(this.f12770f, motionEvent);
                }
            } else if (this.f12768d) {
                this.f12768d = false;
                Rect rect = this.f12770f;
                if (rect != null) {
                    if (this.f12773i && c(rect, motionEvent)) {
                        r1.a aVar3 = this.f12771g;
                        if (aVar3 != null) {
                            aVar3.d();
                        }
                    } else if (!this.f12773i && e(rect) && (aVar = this.f12771g) != null) {
                        aVar.d();
                    }
                }
                r1.a aVar4 = this.f12771g;
                if (aVar4 != null) {
                    aVar4.c(true);
                }
            } else {
                r1.a aVar5 = this.f12771g;
                if (aVar5 != null) {
                    aVar5.c(false);
                }
            }
        }
        return true;
    }

    public final void setListener(@NotNull Rect deleteAreaRect, @Nullable Rect rect, boolean z10, @NotNull r1.a listener) {
        s.i(deleteAreaRect, "deleteAreaRect");
        s.i(listener, "listener");
        this.f12770f = deleteAreaRect;
        this.f12772h = rect;
        this.f12773i = z10;
        this.f12771g = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseDragLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12775k = new LinkedHashMap();
        this.f12773i = true;
        this.f12774j = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseDragLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12775k = new LinkedHashMap();
        this.f12773i = true;
        this.f12774j = true;
    }
}
