package com.huawei.uikit.hwviewpager.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.agdpro.R$dimen;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final int f35432a = 107;

    /* renamed from: b, reason: collision with root package name */
    public static final int f35433b = 300;

    /* renamed from: c, reason: collision with root package name */
    public static final int f35434c = 2;

    /* renamed from: d, reason: collision with root package name */
    public Paint f35435d;

    /* renamed from: e, reason: collision with root package name */
    public int f35436e;

    /* renamed from: f, reason: collision with root package name */
    public HwViewPager f35437f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f35438g;

    /* renamed from: h, reason: collision with root package name */
    public int f35439h;

    /* renamed from: i, reason: collision with root package name */
    public int f35440i;

    /* renamed from: j, reason: collision with root package name */
    public int f35441j;

    /* renamed from: k, reason: collision with root package name */
    public int f35442k;

    /* renamed from: l, reason: collision with root package name */
    public int f35443l;

    public a(int i10, @NonNull HwViewPager hwViewPager) {
        this.f35437f = hwViewPager;
        Paint paint = new Paint();
        this.f35435d = paint;
        paint.setColor(i10);
        this.f35435d.setMaskFilter(new BlurMaskFilter(107.0f, BlurMaskFilter.Blur.NORMAL));
        this.f35435d.setAntiAlias(true);
        Context context = hwViewPager.getContext();
        if (context != null) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.hwviewpager_shadow_width);
            this.f35440i = dimensionPixelSize;
            this.f35441j = dimensionPixelSize / 2;
        }
        this.f35438g = Bitmap.createBitmap(this.f35440i, this.f35437f.getHeight(), Bitmap.Config.RGB_565);
        this.f35442k = this.f35437f.getTop();
        this.f35443l = this.f35437f.getBottom();
    }

    private void a(@NonNull Canvas canvas, int i10) {
        canvas.clipRect(this.f35436e, this.f35442k, i10, this.f35443l);
        canvas.drawBitmap(this.f35438g, this.f35436e - this.f35441j, this.f35442k, this.f35435d);
    }

    private void b(@NonNull Canvas canvas, int i10) {
        canvas.clipRect(i10, this.f35442k, canvas.getWidth() - this.f35436e, this.f35443l);
        canvas.drawBitmap(this.f35438g, (canvas.getWidth() - this.f35436e) - this.f35441j, this.f35442k, this.f35435d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f35437f.getAdapter() == null) {
            return;
        }
        if (this.f35437f.isSupportLoop() || this.f35439h != r0.getCount() - 1) {
            if (this.f35437f.getReverseDrawingOrder()) {
                if (this.f35436e > 0) {
                    if (this.f35437f.isRtlLayout()) {
                        a(canvas, this.f35436e + 300);
                        return;
                    } else {
                        b(canvas, (canvas.getWidth() - this.f35436e) - 300);
                        return;
                    }
                }
                return;
            }
            if (this.f35437f.isRtlLayout()) {
                a(canvas, this.f35436e - 300);
            } else {
                b(canvas, (canvas.getWidth() - this.f35436e) + 300);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f35435d.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f35438g = Bitmap.createBitmap(this.f35440i, this.f35437f.getHeight(), Bitmap.Config.RGB_565);
        this.f35442k = this.f35437f.getTop();
        this.f35443l = this.f35437f.getBottom();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f35435d.setColorFilter(colorFilter);
    }

    public void a(int i10, int i11) {
        this.f35439h = i10;
        if (!this.f35437f.getReverseDrawingOrder()) {
            this.f35436e = i11;
        } else if (i11 < 0) {
            this.f35436e = this.f35437f.getWidth() + i11;
        } else {
            this.f35436e = i11;
        }
        invalidateSelf();
    }
}
