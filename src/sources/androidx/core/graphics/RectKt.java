package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Rect.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RectKt {
    @NotNull
    public static final Rect and(@NotNull Rect rect, @NotNull Rect r10) {
        s.i(rect, "<this>");
        s.i(r10, "r");
        Rect rect2 = new Rect(rect);
        rect2.intersect(r10);
        return rect2;
    }

    public static final int component1(@NotNull Rect rect) {
        s.i(rect, "<this>");
        return rect.left;
    }

    public static final int component2(@NotNull Rect rect) {
        s.i(rect, "<this>");
        return rect.top;
    }

    public static final int component3(@NotNull Rect rect) {
        s.i(rect, "<this>");
        return rect.right;
    }

    public static final int component4(@NotNull Rect rect) {
        s.i(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean contains(@NotNull Rect rect, @NotNull Point p10) {
        s.i(rect, "<this>");
        s.i(p10, "p");
        return rect.contains(p10.x, p10.y);
    }

    @NotNull
    public static final Region minus(@NotNull Rect rect, @NotNull Rect r10) {
        s.i(rect, "<this>");
        s.i(r10, "r");
        Region region = new Region(rect);
        region.op(r10, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Rect or(@NotNull Rect rect, @NotNull Rect r10) {
        s.i(rect, "<this>");
        s.i(r10, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r10);
        return rect2;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, @NotNull Rect r10) {
        s.i(rect, "<this>");
        s.i(r10, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r10);
        return rect2;
    }

    @NotNull
    public static final Rect times(@NotNull Rect rect, int i10) {
        s.i(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.top *= i10;
        rect2.left *= i10;
        rect2.right *= i10;
        rect2.bottom *= i10;
        return rect2;
    }

    @NotNull
    public static final Rect toRect(@NotNull RectF rectF) {
        s.i(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @NotNull
    public static final RectF toRectF(@NotNull Rect rect) {
        s.i(rect, "<this>");
        return new RectF(rect);
    }

    @NotNull
    public static final Region toRegion(@NotNull Rect rect) {
        s.i(rect, "<this>");
        return new Region(rect);
    }

    @NotNull
    public static final RectF transform(@NotNull RectF rectF, @NotNull Matrix m10) {
        s.i(rectF, "<this>");
        s.i(m10, "m");
        m10.mapRect(rectF);
        return rectF;
    }

    @NotNull
    public static final Region xor(@NotNull Rect rect, @NotNull Rect r10) {
        s.i(rect, "<this>");
        s.i(r10, "r");
        Region region = new Region(rect);
        region.op(r10, Region.Op.XOR);
        return region;
    }

    public static final float component1(@NotNull RectF rectF) {
        s.i(rectF, "<this>");
        return rectF.left;
    }

    public static final float component2(@NotNull RectF rectF) {
        s.i(rectF, "<this>");
        return rectF.top;
    }

    public static final float component3(@NotNull RectF rectF) {
        s.i(rectF, "<this>");
        return rectF.right;
    }

    public static final float component4(@NotNull RectF rectF) {
        s.i(rectF, "<this>");
        return rectF.bottom;
    }

    public static final boolean contains(@NotNull RectF rectF, @NotNull PointF p10) {
        s.i(rectF, "<this>");
        s.i(p10, "p");
        return rectF.contains(p10.x, p10.y);
    }

    @NotNull
    public static final Region toRegion(@NotNull RectF rectF) {
        s.i(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @NotNull
    public static final RectF and(@NotNull RectF rectF, @NotNull RectF r10) {
        s.i(rectF, "<this>");
        s.i(r10, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.intersect(r10);
        return rectF2;
    }

    @NotNull
    public static final Region minus(@NotNull RectF rectF, @NotNull RectF r10) {
        s.i(rectF, "<this>");
        s.i(r10, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r10.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final RectF or(@NotNull RectF rectF, @NotNull RectF r10) {
        s.i(rectF, "<this>");
        s.i(r10, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r10);
        return rectF2;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, @NotNull RectF r10) {
        s.i(rectF, "<this>");
        s.i(r10, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r10);
        return rectF2;
    }

    @NotNull
    public static final Region xor(@NotNull RectF rectF, @NotNull RectF r10) {
        s.i(rectF, "<this>");
        s.i(r10, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r10.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, int i10) {
        s.i(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.offset(i10, i10);
        return rect2;
    }

    @NotNull
    public static final RectF times(@NotNull RectF rectF, float f10) {
        s.i(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, float f10) {
        s.i(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f10, f10);
        return rectF2;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect rect, @NotNull Point xy) {
        s.i(rect, "<this>");
        s.i(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(xy.x, xy.y);
        return rect2;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect rect, int i10) {
        s.i(rect, "<this>");
        Rect rect2 = new Rect(rect);
        int i11 = -i10;
        rect2.offset(i11, i11);
        return rect2;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF rectF, @NotNull PointF xy) {
        s.i(rectF, "<this>");
        s.i(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(xy.x, xy.y);
        return rectF2;
    }

    @NotNull
    public static final RectF times(@NotNull RectF rectF, int i10) {
        s.i(rectF, "<this>");
        float f10 = i10;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f10;
        rectF2.left *= f10;
        rectF2.right *= f10;
        rectF2.bottom *= f10;
        return rectF2;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF rectF, float f10) {
        s.i(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f11 = -f10;
        rectF2.offset(f11, f11);
        return rectF2;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect rect, @NotNull Point xy) {
        s.i(rect, "<this>");
        s.i(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-xy.x, -xy.y);
        return rect2;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF rectF, @NotNull PointF xy) {
        s.i(rectF, "<this>");
        s.i(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-xy.x, -xy.y);
        return rectF2;
    }
}
