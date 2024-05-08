package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Context.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(@NotNull Context context, @Nullable AttributeSet attributeSet, @NotNull int[] attrs, @AttrRes int i10, @StyleRes int i11, @NotNull Function1<? super TypedArray, kotlin.p> block) {
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.i(attrs, "attrs");
        kotlin.jvm.internal.s.i(block, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i10, i11);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] attrs, int i10, int i11, Function1 block, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            attributeSet = null;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.i(attrs, "attrs");
        kotlin.jvm.internal.s.i(block, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i10, i11);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@NotNull Context context, @StyleRes int i10, @NotNull int[] attrs, @NotNull Function1<? super TypedArray, kotlin.p> block) {
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.i(attrs, "attrs");
        kotlin.jvm.internal.s.i(block, "block");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, attrs);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
