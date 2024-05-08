package z0;

import android.content.res.ColorStateList;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: ImageViewExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class o {
    public static final void a(@NotNull ImageView imageView, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        kotlin.jvm.internal.s.i(imageView, "<this>");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f10);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public static final void b(@NotNull ImageView imageView, @ColorInt int i10) {
        kotlin.jvm.internal.s.i(imageView, "<this>");
        imageView.setImageTintList(ColorStateList.valueOf(i10));
    }
}
