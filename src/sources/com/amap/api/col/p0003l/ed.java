package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* compiled from: BlankView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ed extends View {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5438a = Color.argb(255, 235, 235, 235);

    /* renamed from: b, reason: collision with root package name */
    public static final int f5439b = Color.argb(255, 21, 21, 21);

    /* renamed from: c, reason: collision with root package name */
    private Paint f5440c;

    public ed(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f5440c = paint;
        paint.setAntiAlias(true);
        this.f5440c.setColor(f5438a);
    }

    public final void a(int i10) {
        Paint paint = this.f5440c;
        if (paint != null) {
            paint.setColor(i10);
            try {
                postInvalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f5440c);
    }

    public final void a() {
        setVisibility(8);
    }
}
