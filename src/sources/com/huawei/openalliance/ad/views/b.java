package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.huawei.openalliance.ad.utils.ay;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends ImageSpan {
    public int Code;
    private WeakReference<Drawable> I;
    public int V;

    public b(Context context, Bitmap bitmap, int i10, int i11, int i12) {
        super(context, bitmap, i10);
        Code(i11, i12);
    }

    public b(Drawable drawable, int i10, int i11, int i12) {
        super(drawable, i10);
        Code(i11, i12);
    }

    private Drawable Code() {
        WeakReference<Drawable> weakReference = this.I;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        this.I = new WeakReference<>(drawable2);
        return drawable2;
    }

    private void Code(int i10, int i11) {
        if (ay.I()) {
            this.Code = i11;
            this.V = i10;
        } else {
            this.Code = i10;
            this.V = i11;
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        Drawable Code = Code();
        canvas.save();
        canvas.translate(this.Code + f10, (i12 + ((i14 - i12) / 2)) - (Code.getBounds().height() / 2));
        Code.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        return this.Code + super.getSize(paint, charSequence, i10, i11, fontMetricsInt) + this.V;
    }
}
