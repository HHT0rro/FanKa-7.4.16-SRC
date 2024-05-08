package com.cupidapp.live.base.view.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: BaseCircleProgressBar.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BaseCircleProgressBar extends View {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Paint f12862b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Paint f12863c;

    /* renamed from: d, reason: collision with root package name */
    public int f12864d;

    /* renamed from: e, reason: collision with root package name */
    public int f12865e;

    /* renamed from: f, reason: collision with root package name */
    public int f12866f;

    /* renamed from: g, reason: collision with root package name */
    public int f12867g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public RectF f12868h;

    /* renamed from: i, reason: collision with root package name */
    public float f12869i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12870j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCircleProgressBar(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12870j = new LinkedHashMap();
        b(this, context, null, 2, null);
    }

    public static /* synthetic */ void b(BaseCircleProgressBar baseCircleProgressBar, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        baseCircleProgressBar.a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BaseCircleProgressBar);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…le.BaseCircleProgressBar)");
        this.f12864d = obtainStyledAttributes.getDimensionPixelSize(2, h.c(this, 50.0f));
        this.f12865e = obtainStyledAttributes.getDimensionPixelSize(3, h.c(this, 2.0f));
        this.f12866f = obtainStyledAttributes.getColor(1, -14522);
        this.f12867g = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        paint.setStrokeWidth(this.f12865e);
        paint.setColor(this.f12866f);
        paint.setStyle(Paint.Style.STROKE);
        this.f12862b = paint;
        Paint paint2 = new Paint(1);
        paint2.setStrokeWidth(this.f12865e);
        paint2.setColor(this.f12867g);
        paint2.setStyle(Paint.Style.STROKE);
        this.f12863c = paint2;
        float f10 = this.f12865e / 2.0f;
        int i10 = this.f12864d;
        this.f12868h = new RectF(f10, f10, i10 - f10, i10 - f10);
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        RectF rectF;
        super.onDraw(canvas);
        if (this.f12867g != 0 && (rectF = this.f12868h) != null && this.f12863c != null && canvas != null) {
            s.f(rectF);
            Paint paint = this.f12863c;
            s.f(paint);
            canvas.drawArc(rectF, 270.0f, 360.0f, false, paint);
        }
        RectF rectF2 = this.f12868h;
        if (rectF2 == null || this.f12862b == null || canvas == null) {
            return;
        }
        s.f(rectF2);
        float f10 = this.f12869i;
        Paint paint2 = this.f12862b;
        s.f(paint2);
        canvas.drawArc(rectF2, 270.0f, f10, false, paint2);
    }

    public final void setBaseCircleProgress(int i10) {
        this.f12869i = (i10 * 360) / 100.0f;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCircleProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12870j = new LinkedHashMap();
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCircleProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12870j = new LinkedHashMap();
        a(context, attributeSet);
    }
}
