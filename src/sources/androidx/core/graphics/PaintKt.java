package androidx.core.graphics;

import android.graphics.Paint;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Paint.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PaintKt {
    public static final boolean setBlendMode(@NotNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        s.i(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
