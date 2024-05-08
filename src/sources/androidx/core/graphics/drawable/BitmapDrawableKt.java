package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: BitmapDrawable.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class BitmapDrawableKt {
    @NotNull
    public static final BitmapDrawable toDrawable(@NotNull Bitmap bitmap, @NotNull Resources resources) {
        s.i(bitmap, "<this>");
        s.i(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
