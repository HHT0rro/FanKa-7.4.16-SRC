package com.cupidapp.live.match.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$styleable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FKShadowLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    public final Paint f16859b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f16860c;

    /* renamed from: d, reason: collision with root package name */
    public int f16861d;

    /* renamed from: e, reason: collision with root package name */
    public float f16862e;

    /* renamed from: f, reason: collision with root package name */
    public float f16863f;

    /* renamed from: g, reason: collision with root package name */
    public float f16864g;

    /* renamed from: h, reason: collision with root package name */
    public int f16865h;

    /* renamed from: i, reason: collision with root package name */
    public int f16866i;

    public FKShadowLayout(Context context) {
        this(context, null);
    }

    public final float a(float f10) {
        return (f10 * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    public final void b(AttributeSet attributeSet) {
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.FKShadowLayout);
        if (obtainStyledAttributes != null) {
            this.f16861d = obtainStyledAttributes.getColor(0, getContext().getResources().getColor(17170444));
            this.f16862e = obtainStyledAttributes.getDimension(3, a(0.0f));
            this.f16863f = obtainStyledAttributes.getDimension(1, a(0.0f));
            this.f16864g = obtainStyledAttributes.getDimension(2, a(0.0f));
            this.f16865h = obtainStyledAttributes.getInt(5, 4369);
            this.f16866i = obtainStyledAttributes.getInt(4, 1);
            obtainStyledAttributes.recycle();
        }
        c();
    }

    public final void c() {
        this.f16859b.reset();
        this.f16859b.setAntiAlias(true);
        this.f16859b.setColor(0);
        this.f16859b.setShadowLayer(this.f16862e, this.f16863f, this.f16864g, this.f16861d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16859b.setAntiAlias(true);
        c();
        int i10 = this.f16866i;
        if (i10 == 1) {
            canvas.drawRect(this.f16860c, this.f16859b);
        } else if (i10 == 16) {
            canvas.drawCircle(this.f16860c.centerX(), this.f16860c.centerY(), Math.min(this.f16860c.width(), this.f16860c.height()) / 2.0f, this.f16859b);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        float f10;
        int i13;
        float f11;
        int i14;
        super.onMeasure(i10, i11);
        float a10 = this.f16862e + a(5.0f);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        getWidth();
        int i15 = this.f16865h;
        int i16 = 0;
        if ((i15 & 1) == 1) {
            i12 = (int) a10;
            f10 = a10;
        } else {
            i12 = 0;
            f10 = 0.0f;
        }
        if ((i15 & 16) == 16) {
            i13 = (int) a10;
            f11 = a10;
        } else {
            i13 = 0;
            f11 = 0.0f;
        }
        if ((i15 & 256) == 256) {
            measuredWidth = getMeasuredWidth() - a10;
            i14 = (int) a10;
        } else {
            i14 = 0;
        }
        if ((this.f16865h & 4096) == 4096) {
            measuredHeight = getMeasuredHeight() - a10;
            i16 = (int) a10;
        }
        float f12 = this.f16864g;
        if (f12 != 0.0f) {
            measuredHeight -= f12;
            i16 += (int) f12;
        }
        float f13 = this.f16863f;
        if (f13 != 0.0f) {
            measuredWidth -= f13;
            i14 += (int) f13;
        }
        RectF rectF = this.f16860c;
        rectF.left = f10;
        rectF.top = f11;
        rectF.right = measuredWidth;
        rectF.bottom = measuredHeight;
        setPadding(i12, i13, i14, i16);
        super.onMeasure(i10, i11);
    }

    public void setShadowColor(int i10) {
        this.f16861d = i10;
        requestLayout();
        postInvalidate();
    }

    public void setShadowRadius(float f10) {
        this.f16862e = f10;
        requestLayout();
        postInvalidate();
    }

    public FKShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FKShadowLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16859b = new Paint(1);
        this.f16860c = new RectF();
        this.f16861d = 0;
        this.f16862e = 0.0f;
        this.f16863f = 0.0f;
        this.f16864g = 0.0f;
        this.f16865h = 4369;
        this.f16866i = 1;
        b(attributeSet);
    }
}
