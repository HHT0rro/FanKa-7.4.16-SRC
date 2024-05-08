package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ClipImageView extends ImageView {
    private Path dk;
    private RectF ej;

    /* renamed from: l, reason: collision with root package name */
    private Paint f38755l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f38756m;
    private float[] np;

    public ClipImageView(Context context) {
        super(context);
        this.f38756m = true;
        m(context);
    }

    public void m(Context context) {
        this.dk = new Path();
        this.ej = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f38756m) {
            this.dk.reset();
            this.ej.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.np;
            if (fArr != null) {
                this.dk.addRoundRect(this.ej, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.dk);
            Paint paint = this.f38755l;
            if (paint != null) {
                canvas.drawPath(this.dk, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Paint paint = new Paint(1);
        this.f38755l = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f38755l.setColor(i10);
    }

    public void setClip(boolean z10) {
        this.f38756m = z10;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.np = fArr;
    }

    public void setRoundRadius(int i10) {
        if (i10 > 0) {
            float f10 = i10;
            setRadius(new float[]{f10, f10, f10, f10, f10, f10, f10, f10});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38756m = true;
        m(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f38756m = true;
        m(context);
    }
}
