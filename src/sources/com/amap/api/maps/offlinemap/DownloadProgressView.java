package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.map3d.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DownloadProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f8262a;

    /* renamed from: b, reason: collision with root package name */
    private int f8263b;

    /* renamed from: c, reason: collision with root package name */
    private int f8264c;

    /* renamed from: d, reason: collision with root package name */
    private float f8265d;

    /* renamed from: e, reason: collision with root package name */
    private float f8266e;

    /* renamed from: f, reason: collision with root package name */
    private TextPaint f8267f;

    /* renamed from: g, reason: collision with root package name */
    private TextPaint f8268g;

    /* renamed from: h, reason: collision with root package name */
    private float f8269h;

    /* renamed from: i, reason: collision with root package name */
    private float f8270i;

    public DownloadProgressView(Context context) {
        super(context);
        this.f8263b = -65536;
        this.f8264c = -65536;
        this.f8265d = 0.0f;
        this.f8266e = 0.6f;
        a(null, 0);
    }

    private void a(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f8149a, i10, 0);
        this.f8262a = obtainStyledAttributes.getString(0);
        this.f8263b = obtainStyledAttributes.getColor(3, this.f8263b);
        this.f8265d = obtainStyledAttributes.getDimension(1, this.f8265d);
        this.f8264c = obtainStyledAttributes.getColor(2, this.f8264c);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f8267f = textPaint;
        textPaint.setFlags(1);
        this.f8267f.setTextAlign(Paint.Align.RIGHT);
        TextPaint textPaint2 = new TextPaint();
        this.f8268g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        a();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        String str = String.valueOf((int) (this.f8266e * 100.0f)) + "%";
        canvas.drawRect(new Rect(0, (int) (height * 0.8f), (int) (width * this.f8266e), height), this.f8268g);
        canvas.drawText(str, (int) (this.f8266e * r3), (int) (r1 - 3.0d), this.f8267f);
    }

    public void setProgress(int i10) {
        if (i10 > 100 || i10 < 0) {
            return;
        }
        this.f8266e = i10 / 100.0f;
        invalidate();
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8263b = -65536;
        this.f8264c = -65536;
        this.f8265d = 0.0f;
        this.f8266e = 0.6f;
        a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8263b = -65536;
        this.f8264c = -65536;
        this.f8265d = 0.0f;
        this.f8266e = 0.6f;
        a(attributeSet, i10);
    }

    private void a() {
        this.f8267f.setTextSize(this.f8265d);
        this.f8267f.setColor(this.f8263b);
        this.f8268g.setColor(this.f8264c);
        this.f8269h = this.f8267f.measureText(this.f8262a);
        this.f8270i = this.f8267f.getFontMetrics().bottom;
    }
}
