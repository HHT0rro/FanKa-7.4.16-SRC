package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Half.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class HalfKt {
    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(short s2) {
        Half valueOf = Half.valueOf(s2);
        s.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(float f10) {
        Half valueOf = Half.valueOf(f10);
        s.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(@NotNull String str) {
        s.i(str, "<this>");
        Half valueOf = Half.valueOf(str);
        s.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    @NotNull
    public static final Half toHalf(double d10) {
        Half valueOf = Half.valueOf((float) d10);
        s.h(valueOf, "valueOf(this)");
        return valueOf;
    }
}
