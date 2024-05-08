package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PreviewMask extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41149a = PreviewMask.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private static final int f41150b = Color.argb(0, 0, 0, 0);

    /* renamed from: c, reason: collision with root package name */
    private HeadBorderView f41151c;

    /* renamed from: d, reason: collision with root package name */
    private int f41152d;

    public PreviewMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HeadBorderView headBorderView = new HeadBorderView(context.getApplicationContext());
        this.f41151c = headBorderView;
        addView(headBorderView, layoutParams);
        this.f41152d = f41150b;
        setWillNotDraw(false);
    }

    public HeadBorderView a() {
        return this.f41151c;
    }

    public void b() {
        this.f41152d = f41150b;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setReflectColor(int i10) {
        this.f41152d = i10;
        this.f41151c.b(i10);
        invalidate();
    }
}
