package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Region.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RegionKt {
    @NotNull
    public static final Region and(@NotNull Region region, @NotNull Rect r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(@NotNull Region region, @NotNull Point p10) {
        s.i(region, "<this>");
        s.i(p10, "p");
        return region.contains(p10.x, p10.y);
    }

    public static final void forEach(@NotNull Region region, @NotNull Function1<? super Rect, p> action) {
        s.i(region, "<this>");
        s.i(action, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                action.invoke(rect);
            }
        }
    }

    @NotNull
    public static final Iterator<Rect> iterator(@NotNull Region region) {
        s.i(region, "<this>");
        return new RegionKt$iterator$1(region);
    }

    @NotNull
    public static final Region minus(@NotNull Region region, @NotNull Rect r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region not(@NotNull Region region) {
        s.i(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region or(@NotNull Region region, @NotNull Rect r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.union(r10);
        return region2;
    }

    @NotNull
    public static final Region plus(@NotNull Region region, @NotNull Rect r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.union(r10);
        return region2;
    }

    @NotNull
    public static final Region unaryMinus(@NotNull Region region) {
        s.i(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region xor(@NotNull Region region, @NotNull Rect r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.XOR);
        return region2;
    }

    @NotNull
    public static final Region and(@NotNull Region region, @NotNull Region r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.INTERSECT);
        return region2;
    }

    @NotNull
    public static final Region minus(@NotNull Region region, @NotNull Region r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region or(@NotNull Region region, @NotNull Region r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.UNION);
        return region2;
    }

    @NotNull
    public static final Region plus(@NotNull Region region, @NotNull Region r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.UNION);
        return region2;
    }

    @NotNull
    public static final Region xor(@NotNull Region region, @NotNull Region r10) {
        s.i(region, "<this>");
        s.i(r10, "r");
        Region region2 = new Region(region);
        region2.op(r10, Region.Op.XOR);
        return region2;
    }
}
