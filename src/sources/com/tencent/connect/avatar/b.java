package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends View {

    /* renamed from: a, reason: collision with root package name */
    private Rect f42535a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f42536b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f42536b = new Paint();
    }

    public Rect a() {
        if (this.f42535a == null) {
            this.f42535a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i10 = (measuredWidth - min) / 2;
            int i11 = (measuredHeight - min) / 2;
            this.f42535a.set(i10, i11, i10 + min, min + i11);
        }
        return this.f42535a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a10 = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f42536b.setStyle(Paint.Style.FILL);
        this.f42536b.setColor(Color.argb(100, 0, 0, 0));
        float f10 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f10, a10.top, this.f42536b);
        canvas.drawRect(0.0f, a10.bottom, f10, measuredHeight, this.f42536b);
        canvas.drawRect(0.0f, a10.top, a10.left, a10.bottom, this.f42536b);
        canvas.drawRect(a10.right, a10.top, f10, a10.bottom, this.f42536b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f42536b.setStyle(Paint.Style.STROKE);
        this.f42536b.setColor(-1);
        canvas.drawRect(a10.left, a10.top, a10.right - 1, a10.bottom, this.f42536b);
    }
}
