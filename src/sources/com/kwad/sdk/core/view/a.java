package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends ImageSpan {
    public a(@NonNull Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(@NonNull Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f10, (((i14 - i12) - drawable.getBounds().bottom) / 2) + i12);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(@NonNull Paint paint, CharSequence charSequence, int i10, int i11, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i12 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i13 = (bounds.bottom - bounds.top) / 2;
            int i14 = i12 / 4;
            int i15 = i13 - i14;
            int i16 = -(i13 + i14);
            fontMetricsInt.ascent = i16;
            fontMetricsInt.top = i16;
            fontMetricsInt.bottom = i15;
            fontMetricsInt.descent = i15;
        }
        return bounds.right;
    }
}
