package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PorterDuff.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PorterDuffKt {
    @NotNull
    public static final PorterDuffColorFilter toColorFilter(@NotNull PorterDuff.Mode mode, int i10) {
        s.i(mode, "<this>");
        return new PorterDuffColorFilter(i10, mode);
    }

    @NotNull
    public static final PorterDuffXfermode toXfermode(@NotNull PorterDuff.Mode mode) {
        s.i(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
