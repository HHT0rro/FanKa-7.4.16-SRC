package com.cupidapp.live.base.view.zoom;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MathUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f13001a = new b();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final c f13002b = new c(16);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final e f13003c = new e(16);

    @NotNull
    public final PointF a(float f10, float f11, float f12, float f13) {
        return new PointF((f10 + f12) / 2.0f, (f11 + f13) / 2.0f);
    }

    public final float b(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        return (float) Math.sqrt((f14 * f14) + (f15 * f15));
    }

    @NotNull
    public final PointF c(@Nullable Matrix matrix) {
        if (matrix != null) {
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            return new PointF(fArr[0], fArr[4]);
        }
        return new PointF(0.0f, 0.0f);
    }

    @NotNull
    public final PointF d(@NotNull PointF point, @NotNull Matrix matrix) {
        s.i(point, "point");
        s.i(matrix, "matrix");
        float[] fArr = new float[2];
        float[] fArr2 = {point.x, point.y};
        Matrix f10 = f();
        matrix.invert(f10);
        f10.mapPoints(fArr, fArr2);
        e(f10);
        return new PointF(fArr[0], fArr[1]);
    }

    public final void e(@NotNull Matrix matrix) {
        s.i(matrix, "matrix");
        f13002b.a(matrix);
    }

    @NotNull
    public final Matrix f() {
        return f13002b.d();
    }

    @NotNull
    public final Matrix g(@Nullable Matrix matrix) {
        Matrix d10 = f13002b.d();
        if (matrix != null) {
            d10.set(matrix);
        }
        return d10;
    }

    public final void h(@NotNull RectF rectF) {
        s.i(rectF, "rectF");
        f13003c.a(rectF);
    }

    @NotNull
    public final RectF i() {
        return f13003c.d();
    }

    @NotNull
    public final RectF j(float f10, float f11, float f12, float f13) {
        RectF d10 = f13003c.d();
        d10.set(f10, f11, f12, f13);
        return d10;
    }
}
