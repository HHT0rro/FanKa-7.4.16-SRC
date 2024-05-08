package ce;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Ranges.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m {
    public static final void a(boolean z10, @NotNull Number step) {
        s.i(step, "step");
        if (z10) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + ((Object) step) + '.');
    }
}
