package qb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGABitmapDecoder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class c<T> {
    @Nullable
    public final Bitmap a(T t2, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = i10 > 0 && i11 > 0;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap b4 = b(t2, options);
        if (!options.inJustDecodeBounds) {
            return b4;
        }
        options.inSampleSize = a.f53191a.a(options, i10, i11);
        options.inJustDecodeBounds = false;
        return b(t2, options);
    }

    @Nullable
    public abstract Bitmap b(T t2, @NotNull BitmapFactory.Options options);
}
