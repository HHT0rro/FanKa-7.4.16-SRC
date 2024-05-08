package com.cupidapp.live.base.view.indicator.scroll;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: ScrollingPagerIndicator.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ScrollingPagerIndicator extends View {

    /* renamed from: b, reason: collision with root package name */
    public int f12802b;

    /* renamed from: c, reason: collision with root package name */
    public int f12803c;

    /* renamed from: d, reason: collision with root package name */
    public int f12804d;

    /* renamed from: e, reason: collision with root package name */
    public int f12805e;

    /* renamed from: f, reason: collision with root package name */
    public int f12806f;

    /* renamed from: g, reason: collision with root package name */
    public int f12807g;

    /* renamed from: h, reason: collision with root package name */
    public int f12808h;

    /* renamed from: i, reason: collision with root package name */
    public float f12809i;

    /* renamed from: j, reason: collision with root package name */
    public float f12810j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f12811k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public SparseArray<Float> f12812l;

    /* renamed from: m, reason: collision with root package name */
    public int f12813m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f12814n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public ArgbEvaluator f12815o;

    /* renamed from: p, reason: collision with root package name */
    @ColorInt
    public int f12816p;

    /* renamed from: q, reason: collision with root package name */
    @ColorInt
    public int f12817q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12818r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public Runnable f12819s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public a<?> f12820t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f12821u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12822v = new LinkedHashMap();

    /* compiled from: ScrollingPagerIndicator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a<T> {
        void a();

        void b(@NotNull ScrollingPagerIndicator scrollingPagerIndicator, T t2);
    }

    public ScrollingPagerIndicator(@Nullable Context context) {
        super(context);
        this.f12806f = 1;
        this.f12807g = 1;
        this.f12811k = kotlin.c.b(new Function0<Float>() { // from class: com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator$firstDotOffset$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                boolean z10;
                int i10;
                int i11;
                int i12;
                int i13;
                z10 = ScrollingPagerIndicator.this.f12818r;
                if (z10) {
                    i12 = ScrollingPagerIndicator.this.f12813m;
                    i13 = ScrollingPagerIndicator.this.f12807g;
                    if (i12 > i13) {
                        i11 = 0;
                        return Float.valueOf(i11);
                    }
                }
                i10 = ScrollingPagerIndicator.this.f12805e;
                i11 = i10 / 2;
                return Float.valueOf(i11);
            }
        });
        this.f12814n = kotlin.c.b(ScrollingPagerIndicator$paint$2.INSTANCE);
        this.f12815o = new ArgbEvaluator();
        n(context, null);
    }

    private final int getDotCount() {
        if (this.f12818r && this.f12813m > this.f12807g) {
            return this.f12802b;
        }
        return this.f12813m;
    }

    private final float getFirstDotOffset() {
        return ((Number) this.f12811k.getValue()).floatValue();
    }

    private final Paint getPaint() {
        return (Paint) this.f12814n.getValue();
    }

    public static final void i(ScrollingPagerIndicator this$0, Object obj, a attacher) {
        s.i(this$0, "this$0");
        s.i(attacher, "$attacher");
        this$0.f12813m = -1;
        this$0.h(obj, attacher);
    }

    public static /* synthetic */ void setCurrentPosition$default(ScrollingPagerIndicator scrollingPagerIndicator, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        scrollingPagerIndicator.setCurrentPosition(i10);
    }

    public static /* synthetic */ void setVisibleDotCount$default(ScrollingPagerIndicator scrollingPagerIndicator, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        scrollingPagerIndicator.setVisibleDotCount(i10);
    }

    public static /* synthetic */ void setVisibleDotThreshold$default(ScrollingPagerIndicator scrollingPagerIndicator, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        scrollingPagerIndicator.setVisibleDotThreshold(i10);
    }

    public final void f(float f10, int i10) {
        int i11 = this.f12813m;
        int i12 = this.f12807g;
        if (i11 <= i12) {
            this.f12809i = 0.0f;
            return;
        }
        if (!this.f12818r && i11 > i12) {
            float f11 = 2;
            this.f12809i = (l(i10) + (this.f12806f * f10)) - (this.f12810j / f11);
            int i13 = this.f12807g / 2;
            float l10 = l((getDotCount() - 1) - i13);
            if (this.f12809i + (this.f12810j / f11) < l(i13)) {
                this.f12809i = l(i13) - (this.f12810j / f11);
                return;
            }
            float f12 = this.f12809i;
            float f13 = this.f12810j;
            if (f12 + (f13 / f11) > l10) {
                this.f12809i = l10 - (f13 / f11);
                return;
            }
            return;
        }
        this.f12809i = (l(this.f12802b / 2) + (this.f12806f * f10)) - (this.f12810j / 2);
    }

    public final void g(@NotNull ViewPager2 pager) {
        s.i(pager, "pager");
        h(pager, new ViewPager2Attacher());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void h(final T t2, @NotNull final a<T> attacher) {
        s.i(attacher, "attacher");
        k();
        attacher.b(this, t2);
        this.f12820t = attacher;
        this.f12819s = new Runnable() { // from class: com.cupidapp.live.base.view.indicator.scroll.c
            @Override // java.lang.Runnable
            public final void run() {
                ScrollingPagerIndicator.i(ScrollingPagerIndicator.this, t2, attacher);
            }
        };
    }

    @ColorInt
    public final int j(float f10) {
        Object evaluate = this.f12815o.evaluate(f10, Integer.valueOf(this.f12816p), Integer.valueOf(this.f12817q));
        s.g(evaluate, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) evaluate).intValue();
    }

    public final void k() {
        a<?> aVar = this.f12820t;
        if (aVar != null) {
            if (aVar != null) {
                aVar.a();
            }
            this.f12820t = null;
            this.f12819s = null;
        }
        this.f12821u = false;
    }

    public final float l(int i10) {
        return getFirstDotOffset() + (i10 * this.f12806f);
    }

    public final float m(int i10) {
        SparseArray<Float> sparseArray = this.f12812l;
        Float f10 = sparseArray != null ? sparseArray.get(i10) : null;
        if (f10 == null) {
            return 0.0f;
        }
        return f10.floatValue();
    }

    public final void n(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingPagerIndicator) : null;
        if (obtainStyledAttributes == null) {
            return;
        }
        this.f12816p = obtainStyledAttributes.getColor(0, -2088928);
        this.f12817q = obtainStyledAttributes.getColor(2, -1);
        this.f12804d = obtainStyledAttributes.getDimensionPixelSize(4, h.c(this, 6.0f));
        this.f12805e = obtainStyledAttributes.getDimensionPixelSize(3, h.c(this, 6.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        this.f12803c = dimensionPixelSize <= this.f12804d ? dimensionPixelSize : -1;
        this.f12806f = obtainStyledAttributes.getDimensionPixelSize(5, h.c(this, 4.0f)) + this.f12804d;
        this.f12818r = obtainStyledAttributes.getBoolean(6, false);
        int i10 = obtainStyledAttributes.getInt(7, 9);
        setVisibleDotCount(i10);
        this.f12808h = obtainStyledAttributes.getInt(8, 2);
        obtainStyledAttributes.recycle();
        getPaint().setAntiAlias(true);
        if (isInEditMode()) {
            setDotCount(i10);
            p(i10 / 2, 0.0f);
        }
    }

    public final void o(int i10) {
        if (this.f12813m == i10 && this.f12821u) {
            return;
        }
        this.f12813m = i10;
        this.f12821u = true;
        this.f12812l = new SparseArray<>();
        if (i10 < this.f12808h) {
            requestLayout();
            invalidate();
        } else {
            this.f12810j = ((this.f12807g - 1) * this.f12806f) + this.f12805e;
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        float m10;
        int i10;
        s.i(canvas, "canvas");
        int dotCount = getDotCount();
        if (dotCount < this.f12808h) {
            return;
        }
        int i11 = this.f12806f;
        float f10 = (((r4 - this.f12804d) / 2) + i11) * 0.7f;
        float f11 = this.f12805e / 2;
        float f12 = i11 * 0.85714287f;
        int firstDotOffset = ((int) (this.f12809i - getFirstDotOffset())) / this.f12806f;
        int l10 = (((int) ((this.f12809i + this.f12810j) - l(firstDotOffset))) / this.f12806f) + firstDotOffset;
        if (firstDotOffset == 0 && l10 + 1 > dotCount) {
            l10 = dotCount - 1;
        }
        if (firstDotOffset > l10) {
            return;
        }
        while (true) {
            float l11 = l(firstDotOffset);
            float f13 = this.f12809i;
            if (l11 >= f13) {
                float f14 = this.f12810j;
                if (l11 < f13 + f14) {
                    if (!this.f12818r || this.f12813m <= this.f12807g) {
                        m10 = m(firstDotOffset);
                    } else {
                        float f15 = f13 + (f14 / 2);
                        m10 = (l11 < f15 - f12 || l11 > f15) ? (l11 <= f15 || l11 >= f15 + f12) ? 0.0f : 1 - ((l11 - f15) / f12) : ((l11 - f15) + f12) / f12;
                    }
                    float f16 = this.f12804d + ((this.f12805e - r11) * m10);
                    if (this.f12813m > this.f12807g) {
                        float f17 = (this.f12818r || !(firstDotOffset == 0 || firstDotOffset == dotCount + (-1))) ? f10 : f11;
                        int width = getWidth();
                        float f18 = this.f12809i;
                        if (l11 - f18 < f17) {
                            float f19 = ((l11 - f18) * f16) / f17;
                            i10 = this.f12803c;
                            if (f19 > i10) {
                                if (f19 < f16) {
                                    f16 = f19;
                                }
                            }
                            f16 = i10;
                        } else {
                            float f20 = width;
                            if (l11 - f18 > f20 - f17) {
                                float f21 = ((((-l11) + f18) + f20) * f16) / f17;
                                i10 = this.f12803c;
                                if (f21 > i10) {
                                    if (f21 < f16) {
                                        f16 = f21;
                                    }
                                }
                                f16 = i10;
                            }
                        }
                    }
                    getPaint().setColor(j(m10));
                    canvas.drawCircle(l11 - this.f12809i, getMeasuredHeight() / 2, f16 / 2, getPaint());
                }
            }
            if (firstDotOffset == l10) {
                return;
            } else {
                firstDotOffset++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r4 = r3.isInEditMode()
            if (r4 == 0) goto L12
            int r4 = r3.f12807g
            int r4 = r4 + (-1)
            int r0 = r3.f12806f
            int r4 = r4 * r0
            int r0 = r3.f12805e
        L10:
            int r4 = r4 + r0
            goto L25
        L12:
            int r4 = r3.f12813m
            int r0 = r3.f12807g
            if (r4 < r0) goto L1c
            float r4 = r3.f12810j
            int r4 = (int) r4
            goto L25
        L1c:
            int r4 = r4 + (-1)
            int r0 = r3.f12806f
            int r4 = r4 * r0
            int r0 = r3.f12805e
            goto L10
        L25:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r1 = r3.f12805e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r2) goto L39
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L3d
            r5 = r1
            goto L3d
        L39:
            int r5 = java.lang.Math.min(r1, r5)
        L3d:
            r3.setMeasuredDimension(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator.onMeasure(int, int):void");
    }

    public final void p(int i10, float f10) {
        int i11;
        if (f10 >= 0.0f && f10 <= 1.0f) {
            if (i10 >= 0 && (i10 == 0 || i10 < this.f12813m)) {
                if (!this.f12818r || ((i11 = this.f12813m) <= this.f12807g && i11 > 1)) {
                    SparseArray<Float> sparseArray = this.f12812l;
                    if (sparseArray != null) {
                        sparseArray.clear();
                    }
                    r(i10, f10);
                    int i12 = this.f12813m;
                    if (i10 < i12 - 1) {
                        r(i10 + 1, 1 - f10);
                    } else if (i12 > 1) {
                        r(0, 1 - f10);
                    }
                    invalidate();
                }
                f(f10, i10);
                invalidate();
                return;
            }
            throw new IndexOutOfBoundsException("page  必须是 [0, adapter.getItemCount())");
        }
        throw new IllegalArgumentException("Offset 必须是 [0, 1]".toString());
    }

    public final void q() {
        Runnable runnable = this.f12819s;
        if (runnable != null) {
            if (runnable != null) {
                runnable.run();
            }
            invalidate();
        }
    }

    public final void r(int i10, float f10) {
        if (this.f12812l == null || getDotCount() == 0) {
            return;
        }
        s(i10, 1 - Math.abs(f10));
    }

    public final void s(int i10, float f10) {
        if (f10 == 0.0f) {
            SparseArray<Float> sparseArray = this.f12812l;
            if (sparseArray != null) {
                sparseArray.remove(i10);
                return;
            }
            return;
        }
        SparseArray<Float> sparseArray2 = this.f12812l;
        if (sparseArray2 != null) {
            sparseArray2.put(i10, Float.valueOf(f10));
        }
    }

    public final void setCurrentPosition(int i10) {
        if (i10 != 0 && (i10 < 0 || i10 >= this.f12813m)) {
            throw new IndexOutOfBoundsException("Position必须是 [0, adapter.getItemCount()]");
        }
        if (this.f12813m == 0) {
            return;
        }
        f(0.0f, i10);
        t(i10);
    }

    public final void setDotColor(@ColorInt int i10) {
        this.f12816p = i10;
        invalidate();
    }

    public final void setDotCount(int i10) {
        o(i10);
    }

    public final void setLooped(boolean z10) {
        this.f12818r = z10;
        q();
        invalidate();
    }

    public final void setSelectedDotColor(@ColorInt int i10) {
        this.f12817q = i10;
        invalidate();
    }

    public final void setVisibleDotCount(int i10) {
        if (i10 % 2 != 0) {
            this.f12807g = i10;
            this.f12802b = i10 + 2;
            if (this.f12819s != null) {
                q();
                return;
            } else {
                requestLayout();
                return;
            }
        }
        throw new IllegalArgumentException("visibleDotCount 必须为奇数".toString());
    }

    public final void setVisibleDotThreshold(int i10) {
        this.f12808h = i10;
        if (this.f12819s != null) {
            q();
        } else {
            requestLayout();
        }
    }

    public final void t(int i10) {
        if (!this.f12818r || this.f12813m < this.f12807g) {
            SparseArray<Float> sparseArray = this.f12812l;
            if (sparseArray != null) {
                sparseArray.clear();
            }
            SparseArray<Float> sparseArray2 = this.f12812l;
            if (sparseArray2 != null) {
                sparseArray2.put(i10, Float.valueOf(1.0f));
            }
            invalidate();
        }
    }

    public ScrollingPagerIndicator(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12806f = 1;
        this.f12807g = 1;
        this.f12811k = kotlin.c.b(new Function0<Float>() { // from class: com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator$firstDotOffset$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                boolean z10;
                int i10;
                int i11;
                int i12;
                int i13;
                z10 = ScrollingPagerIndicator.this.f12818r;
                if (z10) {
                    i12 = ScrollingPagerIndicator.this.f12813m;
                    i13 = ScrollingPagerIndicator.this.f12807g;
                    if (i12 > i13) {
                        i11 = 0;
                        return Float.valueOf(i11);
                    }
                }
                i10 = ScrollingPagerIndicator.this.f12805e;
                i11 = i10 / 2;
                return Float.valueOf(i11);
            }
        });
        this.f12814n = kotlin.c.b(ScrollingPagerIndicator$paint$2.INSTANCE);
        this.f12815o = new ArgbEvaluator();
        n(context, attributeSet);
    }

    public ScrollingPagerIndicator(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12806f = 1;
        this.f12807g = 1;
        this.f12811k = kotlin.c.b(new Function0<Float>() { // from class: com.cupidapp.live.base.view.indicator.scroll.ScrollingPagerIndicator$firstDotOffset$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                boolean z10;
                int i102;
                int i11;
                int i12;
                int i13;
                z10 = ScrollingPagerIndicator.this.f12818r;
                if (z10) {
                    i12 = ScrollingPagerIndicator.this.f12813m;
                    i13 = ScrollingPagerIndicator.this.f12807g;
                    if (i12 > i13) {
                        i11 = 0;
                        return Float.valueOf(i11);
                    }
                }
                i102 = ScrollingPagerIndicator.this.f12805e;
                i11 = i102 / 2;
                return Float.valueOf(i11);
            }
        });
        this.f12814n = kotlin.c.b(ScrollingPagerIndicator$paint$2.INSTANCE);
        this.f12815o = new ArgbEvaluator();
        n(context, attributeSet);
    }
}
