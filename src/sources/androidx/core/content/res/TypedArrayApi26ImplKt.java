package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypedArray.kt */
@RequiresApi(26)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class TypedArrayApi26ImplKt {

    @NotNull
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    @DoNotInline
    @NotNull
    public static final Typeface getFont(@NotNull TypedArray typedArray, @StyleableRes int i10) {
        s.i(typedArray, "typedArray");
        Typeface font = typedArray.getFont(i10);
        s.f(font);
        return font;
    }
}
