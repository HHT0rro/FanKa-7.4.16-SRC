package com.cupidapp.live.base.view.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: GradientBubbleView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GradientBubbleView extends View {

    /* renamed from: b, reason: collision with root package name */
    public final int f12637b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12638c;

    /* renamed from: d, reason: collision with root package name */
    public float f12639d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Path f12640e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final RectF f12641f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public RectF f12642g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public RectF f12643h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public RectF f12644i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public RectF f12645j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f12646k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public GuideBubbleArrowPos f12647l;

    /* renamed from: m, reason: collision with root package name */
    @ColorInt
    @NotNull
    public final List<Integer> f12648m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12649n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12650o = new LinkedHashMap();

    /* compiled from: GradientBubbleView.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12651a;

        static {
            int[] iArr = new int[GuideBubbleArrowPos.values().length];
            try {
                iArr[GuideBubbleArrowPos.TOP_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuideBubbleArrowPos.BOTTOM_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f12651a = iArr;
        }
    }

    public GradientBubbleView(@Nullable Context context) {
        super(context);
        this.f12637b = h.c(this, 10.0f);
        this.f12638c = h.c(this, 5.0f);
        this.f12639d = h.c(this, 6.0f);
        this.f12640e = new Path();
        this.f12641f = new RectF();
        this.f12642g = new RectF();
        this.f12643h = new RectF();
        this.f12644i = new RectF();
        this.f12645j = new RectF();
        this.f12646k = c.b(GradientBubbleView$mPaint$2.INSTANCE);
        this.f12647l = GuideBubbleArrowPos.TOP_CENTER;
        this.f12648m = s.o(-33244, -49088);
        this.f12649n = true;
    }

    private final Paint getMPaint() {
        return (Paint) this.f12646k.getValue();
    }

    public final void a(@NotNull GuideBubbleArrowPos arrowPos, int i10, @ColorInt @NotNull List<Integer> colors) {
        kotlin.jvm.internal.s.i(arrowPos, "arrowPos");
        kotlin.jvm.internal.s.i(colors, "colors");
        this.f12639d = i10;
        this.f12647l = arrowPos;
        this.f12648m.clear();
        this.f12648m.addAll(colors);
        this.f12649n = true;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        this.f12641f.set(0.0f, 0.0f, getWidth(), getHeight());
        int i10 = a.f12651a[this.f12647l.ordinal()];
        if (i10 == 1) {
            RectF rectF = this.f12642g;
            RectF rectF2 = this.f12641f;
            float f10 = rectF2.left;
            float f11 = rectF2.top;
            int i11 = this.f12638c;
            float f12 = this.f12639d;
            float f13 = 2;
            rectF.set(f10, i11 + f11, (f12 * f13) + f10, f11 + i11 + (f12 * f13));
            RectF rectF3 = this.f12643h;
            RectF rectF4 = this.f12641f;
            float f14 = rectF4.right;
            float f15 = this.f12639d;
            float f16 = rectF4.top;
            int i12 = this.f12638c;
            rectF3.set(f14 - (f15 * f13), i12 + f16, f14, f16 + i12 + (f15 * f13));
            RectF rectF5 = this.f12644i;
            RectF rectF6 = this.f12641f;
            float f17 = rectF6.right;
            float f18 = this.f12639d;
            float f19 = rectF6.bottom;
            rectF5.set(f17 - (f18 * f13), f19 - (f18 * f13), f17, f19);
            RectF rectF7 = this.f12645j;
            RectF rectF8 = this.f12641f;
            float f20 = rectF8.left;
            float f21 = rectF8.bottom;
            float f22 = this.f12639d;
            rectF7.set(f20, f21 - (f22 * f13), (f22 * f13) + f20, f21);
        } else if (i10 == 2) {
            RectF rectF9 = this.f12642g;
            RectF rectF10 = this.f12641f;
            float f23 = rectF10.left;
            float f24 = rectF10.top;
            float f25 = this.f12639d;
            float f26 = 2;
            rectF9.set(f23, f24, (f25 * f26) + f23, (f25 * f26) + f24);
            RectF rectF11 = this.f12643h;
            RectF rectF12 = this.f12641f;
            float f27 = rectF12.right;
            float f28 = this.f12639d;
            float f29 = rectF12.top;
            rectF11.set(f27 - (f28 * f26), f29, f27, (f28 * f26) + f29);
            RectF rectF13 = this.f12644i;
            RectF rectF14 = this.f12641f;
            float f30 = rectF14.right;
            float f31 = this.f12639d;
            float f32 = rectF14.bottom;
            int i13 = this.f12638c;
            rectF13.set(f30 - (f31 * f26), (f32 - (f31 * f26)) - i13, f30, f32 - i13);
            RectF rectF15 = this.f12645j;
            RectF rectF16 = this.f12641f;
            float f33 = rectF16.left;
            float f34 = rectF16.bottom;
            float f35 = this.f12639d;
            int i14 = this.f12638c;
            rectF15.set(f33, (f34 - (f35 * f26)) - i14, (f35 * f26) + f33, f34 - i14);
        }
        if (this.f12642g.isEmpty() || this.f12643h.isEmpty() || this.f12644i.isEmpty() || this.f12645j.isEmpty() || this.f12641f.isEmpty()) {
            return;
        }
        this.f12640e.reset();
        Path path = this.f12640e;
        RectF rectF17 = this.f12641f;
        path.moveTo(rectF17.left, rectF17.bottom - this.f12639d);
        this.f12640e.arcTo(this.f12642g, 180.0f, 90.0f);
        if (this.f12647l == GuideBubbleArrowPos.TOP_CENTER) {
            float f36 = 2;
            this.f12640e.lineTo((this.f12641f.width() - this.f12637b) / f36, this.f12641f.top + this.f12638c);
            this.f12640e.lineTo(this.f12641f.width() / f36, this.f12641f.top);
            this.f12640e.lineTo((this.f12641f.width() + this.f12637b) / f36, this.f12641f.top + this.f12638c);
        }
        this.f12640e.arcTo(this.f12643h, 270.0f, 90.0f);
        this.f12640e.arcTo(this.f12644i, 0.0f, 90.0f);
        if (this.f12647l == GuideBubbleArrowPos.BOTTOM_CENTER) {
            float f37 = 2;
            this.f12640e.lineTo((this.f12641f.width() + this.f12637b) / f37, this.f12641f.bottom - this.f12638c);
            this.f12640e.lineTo(this.f12641f.width() / f37, this.f12641f.bottom);
            this.f12640e.lineTo((this.f12641f.width() - this.f12637b) / f37, this.f12641f.bottom - this.f12638c);
        }
        this.f12640e.arcTo(this.f12645j, 90.0f, 90.0f);
        this.f12640e.close();
        if (this.f12649n) {
            getMPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, CollectionsKt___CollectionsKt.w0(this.f12648m), (float[]) null, Shader.TileMode.CLAMP));
            this.f12649n = false;
        }
        if (canvas != null) {
            canvas.drawPath(this.f12640e, getMPaint());
        }
    }

    public GradientBubbleView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12637b = h.c(this, 10.0f);
        this.f12638c = h.c(this, 5.0f);
        this.f12639d = h.c(this, 6.0f);
        this.f12640e = new Path();
        this.f12641f = new RectF();
        this.f12642g = new RectF();
        this.f12643h = new RectF();
        this.f12644i = new RectF();
        this.f12645j = new RectF();
        this.f12646k = c.b(GradientBubbleView$mPaint$2.INSTANCE);
        this.f12647l = GuideBubbleArrowPos.TOP_CENTER;
        this.f12648m = s.o(-33244, -49088);
        this.f12649n = true;
    }

    public GradientBubbleView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12637b = h.c(this, 10.0f);
        this.f12638c = h.c(this, 5.0f);
        this.f12639d = h.c(this, 6.0f);
        this.f12640e = new Path();
        this.f12641f = new RectF();
        this.f12642g = new RectF();
        this.f12643h = new RectF();
        this.f12644i = new RectF();
        this.f12645j = new RectF();
        this.f12646k = c.b(GradientBubbleView$mPaint$2.INSTANCE);
        this.f12647l = GuideBubbleArrowPos.TOP_CENTER;
        this.f12648m = s.o(-33244, -49088);
        this.f12649n = true;
    }
}
