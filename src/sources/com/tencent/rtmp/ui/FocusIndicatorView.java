package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FocusIndicatorView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final ScaleAnimation f45346a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f45347b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45348c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f45349d;

    public FocusIndicatorView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10 = this.f45348c / 2;
        Rect rect = this.f45349d;
        rect.left = i10;
        rect.top = i10;
        rect.right = getWidth() - i10;
        this.f45349d.bottom = getHeight() - i10;
        canvas.drawRect(this.f45349d, this.f45347b);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f45349d = new Rect();
        int i11 = (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.f45348c = i11;
        Paint paint = new Paint();
        this.f45347b = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i11);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f45346a = scaleAnimation;
        scaleAnimation.setDuration(200L);
    }
}
