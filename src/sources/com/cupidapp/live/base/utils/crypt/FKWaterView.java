package com.cupidapp.live.base.utils.crypt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKWaterView extends View {

    /* renamed from: b, reason: collision with root package name */
    public Paint f12286b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f12287c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f12288d;

    /* renamed from: e, reason: collision with root package name */
    public float f12289e;

    /* renamed from: f, reason: collision with root package name */
    public float f12290f;

    /* renamed from: g, reason: collision with root package name */
    public float f12291g;

    /* renamed from: h, reason: collision with root package name */
    public float f12292h;

    /* renamed from: i, reason: collision with root package name */
    public float f12293i;

    /* renamed from: j, reason: collision with root package name */
    public float f12294j;

    /* renamed from: k, reason: collision with root package name */
    public float f12295k;

    /* renamed from: l, reason: collision with root package name */
    public float f12296l;

    /* renamed from: m, reason: collision with root package name */
    public float f12297m;

    /* renamed from: n, reason: collision with root package name */
    public int f12298n;

    /* renamed from: o, reason: collision with root package name */
    public int f12299o;

    /* renamed from: p, reason: collision with root package name */
    public a f12300p;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
    }

    public FKWaterView(Context context) {
        super(context);
        this.f12289e = 0.0f;
        this.f12290f = 0.0f;
        this.f12291g = 0.0f;
        this.f12292h = 0.0f;
        this.f12293i = 0.0f;
        this.f12294j = 0.0f;
    }

    public static native byte[] onDeetory();

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f12286b.setAlpha((int) this.f12291g);
        this.f12287c.setAlpha((int) this.f12294j);
        float f10 = this.f12296l;
        canvas.drawCircle(f10, f10, this.f12289e, this.f12286b);
        float f11 = this.f12296l;
        canvas.drawCircle(f11, f11, this.f12292h, this.f12287c);
        float f12 = this.f12296l;
        canvas.drawCircle(f12, f12, this.f12295k, this.f12288d);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f12299o = View.MeasureSpec.getSize(i10);
        int size = View.MeasureSpec.getSize(i11);
        this.f12298n = size;
        this.f12296l = this.f12299o / 2;
        float f10 = size / 2;
        this.f12297m = f10;
        float f11 = this.f12295k;
        this.f12290f = f10 - f11;
        this.f12293i = f10 - f11;
        this.f12295k = 10.0f;
    }

    public void setEndListener(a aVar) {
        this.f12300p = aVar;
    }

    public FKWaterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12289e = 0.0f;
        this.f12290f = 0.0f;
        this.f12291g = 0.0f;
        this.f12292h = 0.0f;
        this.f12293i = 0.0f;
        this.f12294j = 0.0f;
        Paint paint = new Paint();
        this.f12286b = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint();
        this.f12287c = paint2;
        paint2.setColor(-1);
        Paint paint3 = new Paint();
        this.f12288d = paint3;
        paint3.setColor(-1);
        this.f12288d.setAlpha(100);
    }
}
