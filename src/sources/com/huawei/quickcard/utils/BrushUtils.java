package com.huawei.quickcard.utils;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BrushUtils {
    private static float a(@FloatRange(from = 0.0d) float f10, @FloatRange(from = 0.0d) float f11, @IntRange(from = 2) int i10) {
        return (f11 - (f10 * i10)) / (i10 - 1);
    }

    private static void a(@NonNull Paint paint, boolean z10) {
        if (z10) {
            paint.reset();
        }
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public static void configBrush(@NonNull Paint paint, int i10, float f10) {
        paint.setColor(i10);
        paint.setStrokeWidth(f10);
    }

    public static void initEraserBrush(@NonNull Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public static void initFillBrush(@NonNull Paint paint, boolean z10) {
        a(paint, z10);
        paint.setStyle(Paint.Style.FILL);
    }

    public static void initStrokeBrush(@NonNull Paint paint, boolean z10) {
        a(paint, z10);
        paint.setAntiAlias(true);
    }

    public static void makeDashedBrush(@NonNull Paint paint, @FloatRange(from = 0.0d) float f10) {
        paint.setPathEffect(new DashPathEffect(new float[]{2.0f * f10, f10}, 0.0f));
    }

    public static void makeDottedBrush(@NonNull Paint paint, @FloatRange(from = 0.0d) float f10, @FloatRange(from = 0.0d) float f11) {
        int a10 = a(f10, f11);
        if (a10 >= 2) {
            float a11 = a(f10, f11, a10);
            Path path = new Path();
            path.addCircle(0.0f, 0.0f, f10 / 2.0f, Path.Direction.CW);
            paint.setPathEffect(new PathDashPathEffect(path, a11 + f10, f10, PathDashPathEffect.Style.TRANSLATE));
        }
    }

    public static void makeStrokeBrush(@NonNull Paint paint) {
        paint.setPathEffect(null);
    }

    private static int a(@FloatRange(from = 0.0d) float f10, @FloatRange(from = 0.0d) float f11) {
        if (Float.compare(f10, 0.0f) == 0) {
            return 0;
        }
        int i10 = (int) (f11 / f10);
        if (i10 % 2 == 0) {
            return (i10 / 2) + 1;
        }
        return (i10 + 1) / 2;
    }
}
