package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypedArray.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i10) {
        if (!typedArray.hasValue(i10)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getBoolean(i10, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getColor(i10, 0);
    }

    @NotNull
    public static final ColorStateList getColorStateListOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        ColorStateList colorStateList = typedArray.getColorStateList(i10);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimension(i10, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelOffset(i10, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelSize(i10, 0);
    }

    @NotNull
    public static final Drawable getDrawableOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        Drawable drawable = typedArray.getDrawable(i10);
        s.f(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getFloat(i10, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface getFontOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return TypedArrayApi26ImplKt.getFont(typedArray, i10);
    }

    public static final int getIntOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getInt(i10, 0);
    }

    public static final int getIntegerOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getInteger(i10, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getResourceId(i10, 0);
    }

    @NotNull
    public static final String getStringOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        String string = typedArray.getString(i10);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @NotNull
    public static final CharSequence[] getTextArrayOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        CharSequence[] textArray = typedArray.getTextArray(i10);
        s.h(textArray, "getTextArray(index)");
        return textArray;
    }

    @NotNull
    public static final CharSequence getTextOrThrow(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        CharSequence text = typedArray.getText(i10);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@NotNull TypedArray typedArray, @NotNull Function1<? super TypedArray, ? extends R> block) {
        s.i(typedArray, "<this>");
        s.i(block, "block");
        R invoke = block.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
