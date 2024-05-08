package com.cupidapp.live.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageTrimUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a0 f12283a = new a0();

    public final float a(float f10) {
        if (f10 < 0.0f) {
            return 0.0f;
        }
        if (f10 > 1.0f) {
            return 1.0f;
        }
        return f10;
    }

    @Nullable
    public final Bitmap b(@Nullable Context context, @NotNull RectF trimBoxRectF, @NotNull RectF imageBoundRectF, @Nullable String str, int i10, float f10) {
        Bitmap b4;
        int i11 = i10;
        kotlin.jvm.internal.s.i(trimBoxRectF, "trimBoxRectF");
        kotlin.jvm.internal.s.i(imageBoundRectF, "imageBoundRectF");
        Bitmap bitmap = null;
        if (context == null || str == null) {
            return null;
        }
        float f11 = imageBoundRectF.left;
        float f12 = trimBoxRectF.left;
        float width = f11 < f12 ? (f12 - f11) / imageBoundRectF.width() : 0.0f;
        float f13 = imageBoundRectF.right;
        float f14 = trimBoxRectF.right;
        float width2 = f13 > f14 ? (f14 - imageBoundRectF.left) / imageBoundRectF.width() : 1.0f;
        float f15 = imageBoundRectF.top;
        float f16 = trimBoxRectF.top;
        float height = f15 < f16 ? (f16 - f15) / imageBoundRectF.height() : 0.0f;
        float f17 = imageBoundRectF.bottom;
        float f18 = trimBoxRectF.bottom;
        float height2 = f17 > f18 ? (f18 - imageBoundRectF.top) / imageBoundRectF.height() : 1.0f;
        float a10 = a(width);
        float a11 = a(width2);
        float a12 = a(height);
        float a13 = a(height2);
        boolean z10 = ((imageBoundRectF.left > trimBoxRectF.left ? 1 : (imageBoundRectF.left == trimBoxRectF.left ? 0 : -1)) > 0 && (imageBoundRectF.right > trimBoxRectF.right ? 1 : (imageBoundRectF.right == trimBoxRectF.right ? 0 : -1)) < 0) || ((imageBoundRectF.top > trimBoxRectF.top ? 1 : (imageBoundRectF.top == trimBoxRectF.top ? 0 : -1)) > 0 && (imageBoundRectF.bottom > trimBoxRectF.bottom ? 1 : (imageBoundRectF.bottom == trimBoxRectF.bottom ? 0 : -1)) < 0);
        try {
            b4 = z0.f.b(context, str, a10, a12, a11, a13);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (b4 == null) {
            return null;
        }
        float width3 = i11 / b4.getWidth();
        if (width3 < 1.0f) {
            b4 = z0.f.u(b4, width3);
        }
        if (!z10) {
            return b4;
        }
        if (!z0.f.l(context, str).isVertical()) {
            i11 = Math.min(i11, b4.getWidth());
        }
        float f19 = i11;
        int i12 = (int) (f19 / f10);
        float width4 = f19 / trimBoxRectF.width();
        float height3 = i12 / trimBoxRectF.height();
        bitmap = z0.f.a(b4, i11, i12, new RectF((Math.max(imageBoundRectF.left, trimBoxRectF.left) - trimBoxRectF.left) * width4, (Math.max(imageBoundRectF.top, trimBoxRectF.top) - trimBoxRectF.top) * height3, (Math.min(imageBoundRectF.right, trimBoxRectF.right) - trimBoxRectF.left) * width4, (Math.min(imageBoundRectF.bottom, trimBoxRectF.bottom) - trimBoxRectF.top) * height3));
        b4.recycle();
        return bitmap;
    }
}
