package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Point.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PointKt {
    public static final int component1(@NotNull Point point) {
        s.i(point, "<this>");
        return point.x;
    }

    public static final int component2(@NotNull Point point) {
        s.i(point, "<this>");
        return point.y;
    }

    @NotNull
    public static final Point div(@NotNull Point point, float f10) {
        s.i(point, "<this>");
        return new Point(Math.round(point.x / f10), Math.round(point.y / f10));
    }

    @NotNull
    public static final Point minus(@NotNull Point point, @NotNull Point p10) {
        s.i(point, "<this>");
        s.i(p10, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(-p10.x, -p10.y);
        return point2;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, @NotNull Point p10) {
        s.i(point, "<this>");
        s.i(p10, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(p10.x, p10.y);
        return point2;
    }

    @NotNull
    public static final Point times(@NotNull Point point, float f10) {
        s.i(point, "<this>");
        return new Point(Math.round(point.x * f10), Math.round(point.y * f10));
    }

    @NotNull
    public static final Point toPoint(@NotNull PointF pointF) {
        s.i(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @NotNull
    public static final PointF toPointF(@NotNull Point point) {
        s.i(point, "<this>");
        return new PointF(point);
    }

    @NotNull
    public static final Point unaryMinus(@NotNull Point point) {
        s.i(point, "<this>");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@NotNull PointF pointF) {
        s.i(pointF, "<this>");
        return pointF.x;
    }

    public static final float component2(@NotNull PointF pointF) {
        s.i(pointF, "<this>");
        return pointF.y;
    }

    @NotNull
    public static final PointF div(@NotNull PointF pointF, float f10) {
        s.i(pointF, "<this>");
        return new PointF(pointF.x / f10, pointF.y / f10);
    }

    @NotNull
    public static final PointF times(@NotNull PointF pointF, float f10) {
        s.i(pointF, "<this>");
        return new PointF(pointF.x * f10, pointF.y * f10);
    }

    @NotNull
    public static final PointF unaryMinus(@NotNull PointF pointF) {
        s.i(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, @NotNull PointF p10) {
        s.i(pointF, "<this>");
        s.i(p10, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(-p10.x, -p10.y);
        return pointF2;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, @NotNull PointF p10) {
        s.i(pointF, "<this>");
        s.i(p10, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(p10.x, p10.y);
        return pointF2;
    }

    @NotNull
    public static final Point minus(@NotNull Point point, int i10) {
        s.i(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        int i11 = -i10;
        point2.offset(i11, i11);
        return point2;
    }

    @NotNull
    public static final Point plus(@NotNull Point point, int i10) {
        s.i(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i10, i10);
        return point2;
    }

    @NotNull
    public static final PointF minus(@NotNull PointF pointF, float f10) {
        s.i(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f11 = -f10;
        pointF2.offset(f11, f11);
        return pointF2;
    }

    @NotNull
    public static final PointF plus(@NotNull PointF pointF, float f10) {
        s.i(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f10, f10);
        return pointF2;
    }
}
