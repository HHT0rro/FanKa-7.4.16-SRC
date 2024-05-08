package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Bitmap.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class BitmapKt {
    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap bitmap, @NotNull Function1<? super Canvas, p> block) {
        s.i(bitmap, "<this>");
        s.i(block, "block");
        block.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull Point p10) {
        int i10;
        s.i(bitmap, "<this>");
        s.i(p10, "p");
        int width = bitmap.getWidth();
        int i11 = p10.x;
        return (i11 >= 0 && i11 < width) && (i10 = p10.y) >= 0 && i10 < bitmap.getHeight();
    }

    @NotNull
    public static final Bitmap createBitmap(int i10, int i11, @NotNull Bitmap.Config config) {
        s.i(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, config);
        s.h(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        s.i(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, config);
        s.h(createBitmap, "createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(@NotNull Bitmap bitmap, int i10, int i11) {
        s.i(bitmap, "<this>");
        return bitmap.getPixel(i10, i11);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap bitmap, int i10, int i11, boolean z10) {
        s.i(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
        s.h(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z10 = true;
        }
        s.i(bitmap, "<this>");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
        s.h(createScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(@NotNull Bitmap bitmap, int i10, int i11, @ColorInt int i12) {
        s.i(bitmap, "<this>");
        bitmap.setPixel(i10, i11, i12);
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull PointF p10) {
        s.i(bitmap, "<this>");
        s.i(p10, "p");
        float f10 = p10.x;
        if (f10 >= 0.0f && f10 < bitmap.getWidth()) {
            float f11 = p10.y;
            if (f11 >= 0.0f && f11 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(26)
    @NotNull
    public static final Bitmap createBitmap(int i10, int i11, @NotNull Bitmap.Config config, boolean z10, @NotNull ColorSpace colorSpace) {
        s.i(config, "config");
        s.i(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
        s.h(createBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, boolean z10, ColorSpace colorSpace, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        if ((i12 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            s.h(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        s.i(config, "config");
        s.i(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
        s.h(createBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
