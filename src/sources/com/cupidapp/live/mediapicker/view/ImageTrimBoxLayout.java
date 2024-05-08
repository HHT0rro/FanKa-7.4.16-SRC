package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageTrimBoxLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageTrimBoxLayout extends View {

    /* renamed from: b, reason: collision with root package name */
    public Paint f17406b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f17407c;

    /* renamed from: d, reason: collision with root package name */
    public final float f17408d;

    /* renamed from: e, reason: collision with root package name */
    public float f17409e;

    /* renamed from: f, reason: collision with root package name */
    public float f17410f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17411g = new LinkedHashMap();

    public ImageTrimBoxLayout(@Nullable Context context) {
        super(context);
        float c4 = z0.h.c(this, 324.0f);
        this.f17408d = c4;
        this.f17409e = c4;
        this.f17410f = c4;
        d(this, null, 1, null);
    }

    public static /* synthetic */ void d(ImageTrimBoxLayout imageTrimBoxLayout, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            attributeSet = null;
        }
        imageTrimBoxLayout.c(attributeSet);
    }

    public final void a(int i10) {
        Paint paint = this.f17406b;
        if (paint == null) {
            s.A("trimLinePaint");
            paint = null;
        }
        paint.setColor(i10);
        invalidate();
    }

    public final void b(float f10, int i10) {
        Paint paint = this.f17406b;
        if (paint == null) {
            s.A("trimLinePaint");
            paint = null;
        }
        paint.setShadowLayer(z0.h.c(this, f10), 0.0f, 0.0f, i10);
        invalidate();
    }

    public final void c(AttributeSet attributeSet) {
        Context context = getContext();
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.ImageTrimBoxLayout) : null;
        int a10 = com.cupidapp.live.base.utils.h.a(-16777216, 0.8f);
        if (obtainStyledAttributes != null) {
            a10 = obtainStyledAttributes.getColor(0, a10);
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        paint.setColor(a10);
        paint.setStyle(Paint.Style.FILL);
        this.f17407c = paint;
        Paint paint2 = new Paint(1);
        paint2.setStrokeWidth(z0.h.c(paint2, 3.0f));
        paint2.setColor(-14522);
        paint2.setStyle(Paint.Style.STROKE);
        this.f17406b = paint2;
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        Paint paint;
        Paint paint2;
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        setLayerType(1, null);
        float width = (getWidth() - this.f17409e) / 2.0f;
        float height = getHeight();
        float f10 = this.f17410f;
        float f11 = (height - f10) / 2.0f;
        float f12 = width + this.f17409e;
        float f13 = f11 + f10;
        canvas.save();
        canvas.clipRect(width, f11, f12, f13, Region.Op.DIFFERENCE);
        float width2 = getWidth();
        float height2 = getHeight();
        Paint paint3 = this.f17407c;
        if (paint3 == null) {
            s.A("trimCoverPaint");
            paint = null;
        } else {
            paint = paint3;
        }
        canvas.drawRect(0.0f, 0.0f, width2, height2, paint);
        canvas.restore();
        Paint paint4 = this.f17406b;
        if (paint4 == null) {
            s.A("trimLinePaint");
            paint2 = null;
        } else {
            paint2 = paint4;
        }
        canvas.drawRect(width, f11, f12, f13, paint2);
    }

    public final void setTrimBoxSize(float f10) {
        setTrimBoxSize(f10, f10);
    }

    public final void setTrimBoxSize(float f10, float f11) {
        this.f17409e = f10;
        this.f17410f = f11;
        invalidate();
    }

    public ImageTrimBoxLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        float c4 = z0.h.c(this, 324.0f);
        this.f17408d = c4;
        this.f17409e = c4;
        this.f17410f = c4;
        c(attributeSet);
    }

    public ImageTrimBoxLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        float c4 = z0.h.c(this, 324.0f);
        this.f17408d = c4;
        this.f17409e = c4;
        this.f17410f = c4;
        c(attributeSet);
    }
}
