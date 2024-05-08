package androidx.window.layout;

import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: DisplayCompatHelper.kt */
@RequiresApi(28)
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class DisplayCompatHelperApi28 {

    @NotNull
    public static final DisplayCompatHelperApi28 INSTANCE = new DisplayCompatHelperApi28();

    private DisplayCompatHelperApi28() {
    }

    public final int safeInsetBottom(@NotNull DisplayCutout displayCutout) {
        s.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int safeInsetLeft(@NotNull DisplayCutout displayCutout) {
        s.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int safeInsetRight(@NotNull DisplayCutout displayCutout) {
        s.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int safeInsetTop(@NotNull DisplayCutout displayCutout) {
        s.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
