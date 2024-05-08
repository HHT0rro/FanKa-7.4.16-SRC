package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.cloud.huiyansdkface.facelight.c.a.i;
import com.tencent.cloud.huiyansdkface.facelight.common.RotateSetting;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PreviewFrameLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.g.c f41139a;

    /* renamed from: b, reason: collision with root package name */
    private float f41140b;

    /* renamed from: c, reason: collision with root package name */
    private double f41141c;

    /* renamed from: d, reason: collision with root package name */
    private int f41142d;

    /* renamed from: e, reason: collision with root package name */
    private int f41143e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f41144f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f41145g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f41146h;

    /* renamed from: i, reason: collision with root package name */
    private b f41147i;

    /* renamed from: j, reason: collision with root package name */
    private i f41148j;

    public PreviewFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41141c = 1.3333333333333333d;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.tencent.cloud.huiyansdkface.a.g.c cVar = new com.tencent.cloud.huiyansdkface.a.g.c(context.getApplicationContext());
        this.f41139a = cVar;
        addView(cVar, layoutParams);
        this.f41148j = new i(context);
        ImageView imageView = new ImageView(context.getApplicationContext());
        this.f41145g = imageView;
        imageView.setVisibility(8);
        addView(this.f41145g, layoutParams);
        ImageView imageView2 = new ImageView(context.getApplicationContext());
        this.f41144f = imageView2;
        imageView2.setVisibility(8);
        addView(this.f41144f, layoutParams);
        ImageView imageView3 = new ImageView(context.getApplicationContext());
        this.f41146h = imageView3;
        imageView3.setVisibility(8);
        addView(this.f41146h, layoutParams);
        b bVar = new b(context.getApplicationContext());
        this.f41147i = bVar;
        bVar.setVisibility(8);
        addView(this.f41147i, layoutParams);
    }

    public RectF a(Rect rect) {
        boolean z10;
        float left;
        float top;
        int videoRotate = RotateSetting.getVideoRotate();
        if (videoRotate == 0 || videoRotate == 180) {
            WLogger.d("PreviewFrameLayout", "PreviewFrameLayout landscape");
            z10 = true;
        } else {
            z10 = false;
        }
        float width = getWidth() / (z10 ? this.f41142d : this.f41143e);
        Matrix matrix = new Matrix();
        if (z10) {
            float height = getHeight() / this.f41143e;
            int left2 = (int) (getLeft() - (((getHeight() * this.f41141c) - getWidth()) / 2.0d));
            int top2 = getTop();
            matrix.postScale(height, height, 0.0f, 0.0f);
            left = left2;
            top = top2;
        } else {
            matrix.postScale(width, width, 0.0f, 0.0f);
            matrix.postScale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
            left = getLeft();
            top = getTop();
        }
        matrix.postTranslate(left, top);
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        return rectF;
    }

    public com.tencent.cloud.huiyansdkface.a.g.c a() {
        return this.f41139a;
    }

    public void a(int i10, int i11) {
        this.f41142d = i10;
        this.f41143e = i11;
        double d10 = i10 / i11;
        WLogger.d("PreviewFrameLayout", "setPreviewSize ratio=" + d10);
        setAspectRatio(d10);
    }

    public b b() {
        return this.f41147i;
    }

    public void c() {
        this.f41146h.setVisibility(0);
        this.f41146h.setBackgroundColor(-1726803180);
    }

    public i getVirtualPreviewImp() {
        return this.f41148j;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i12 = size - paddingLeft;
        int i13 = size2 - paddingTop;
        boolean z10 = i12 > i13;
        int i14 = z10 ? i12 : i13;
        if (z10) {
            i12 = i13;
        }
        double d10 = i14;
        double d11 = i12;
        double d12 = this.f41141c;
        if (d10 < d11 * d12) {
            i14 = (int) (d11 * d12);
        } else {
            i12 = (int) (d10 / d12);
        }
        if (z10) {
            int i15 = i14;
            i14 = i12;
            i12 = i15;
        }
        int i16 = i12 + paddingLeft;
        int i17 = i14 + paddingTop;
        float f10 = getContext().getResources().getDisplayMetrics().widthPixels * 0.72f;
        float f11 = this.f41140b;
        if (f11 != 0.0f) {
            f10 = f11;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f10, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (i17 * (f10 / i16)), 1073741824));
    }

    public void setAspectRatio(double d10) {
        WLogger.d("PreviewFrameLayout", "setAspectRatio ratio=" + d10);
        if (d10 <= ShadowDrawableWrapper.COS_45) {
            throw new IllegalArgumentException();
        }
        if (this.f41141c != d10) {
            this.f41141c = d10;
            requestLayout();
        }
    }

    public void setBlurImageView(Bitmap bitmap) {
        this.f41145g.setVisibility(0);
        this.f41145g.setImageBitmap(bitmap);
    }

    public void setCamViewWidth(float f10) {
        if (f10 < 0.0f) {
            this.f41140b = 0.0f;
        } else {
            this.f41140b = f10;
        }
    }
}
