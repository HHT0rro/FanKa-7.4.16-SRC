package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Color.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(@NotNull Color color) {
        s.i(color, "<this>");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i10) {
        return (i10 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(@NotNull Color color) {
        s.i(color, "<this>");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i10) {
        return (i10 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(@NotNull Color color) {
        s.i(color, "<this>");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i10) {
        return (i10 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(@NotNull Color color) {
        s.i(color, "<this>");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i10) {
        return i10 & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i10, @NotNull ColorSpace.Named colorSpace) {
        s.i(colorSpace, "colorSpace");
        return Color.convert(i10, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j10) {
        return Color.alpha(j10);
    }

    public static final int getAlpha(@ColorInt int i10) {
        return (i10 >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j10) {
        return Color.blue(j10);
    }

    public static final int getBlue(@ColorInt int i10) {
        return i10 & 255;
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorSpace getColorSpace(long j10) {
        ColorSpace colorSpace = Color.colorSpace(j10);
        s.h(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j10) {
        return Color.green(j10);
    }

    public static final int getGreen(@ColorInt int i10) {
        return (i10 >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i10) {
        return Color.luminance(i10);
    }

    @RequiresApi(26)
    public static final float getRed(long j10) {
        return Color.red(j10);
    }

    public static final int getRed(@ColorInt int i10) {
        return (i10 >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j10) {
        return Color.isSrgb(j10);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j10) {
        return Color.isWideGamut(j10);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color plus(@NotNull Color color, @NotNull Color c4) {
        s.i(color, "<this>");
        s.i(c4, "c");
        Color compositeColors = ColorUtils.compositeColors(c4, color);
        s.h(compositeColors, "compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(@ColorInt int i10) {
        Color valueOf = Color.valueOf(i10);
        s.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j10) {
        return Color.toArgb(j10);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i10) {
        return Color.pack(i10);
    }

    @RequiresApi(26)
    public static final float component1(long j10) {
        return Color.red(j10);
    }

    @RequiresApi(26)
    public static final float component2(long j10) {
        return Color.green(j10);
    }

    @RequiresApi(26)
    public static final float component3(long j10) {
        return Color.blue(j10);
    }

    @RequiresApi(26)
    public static final float component4(long j10) {
        return Color.alpha(j10);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i10, @NotNull ColorSpace colorSpace) {
        s.i(colorSpace, "colorSpace");
        return Color.convert(i10, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j10) {
        return Color.luminance(j10);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(long j10) {
        Color valueOf = Color.valueOf(j10);
        s.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String str) {
        s.i(str, "<this>");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j10, @NotNull ColorSpace.Named colorSpace) {
        s.i(colorSpace, "colorSpace");
        return Color.convert(j10, ColorSpace.get(colorSpace));
    }

    @RequiresApi(26)
    public static final long convertTo(long j10, @NotNull ColorSpace colorSpace) {
        s.i(colorSpace, "colorSpace");
        return Color.convert(j10, colorSpace);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace.Named colorSpace) {
        s.i(color, "<this>");
        s.i(colorSpace, "colorSpace");
        Color convert = color.convert(ColorSpace.get(colorSpace));
        s.h(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace colorSpace) {
        s.i(color, "<this>");
        s.i(colorSpace, "colorSpace");
        Color convert = color.convert(colorSpace);
        s.h(convert, "convert(colorSpace)");
        return convert;
    }
}
