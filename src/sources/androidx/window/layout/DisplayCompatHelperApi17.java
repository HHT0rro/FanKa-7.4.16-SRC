package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: DisplayCompatHelper.kt */
@RequiresApi(17)
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class DisplayCompatHelperApi17 {

    @NotNull
    public static final DisplayCompatHelperApi17 INSTANCE = new DisplayCompatHelperApi17();

    private DisplayCompatHelperApi17() {
    }

    public final void getRealSize(@NotNull Display display, @NotNull Point point) {
        s.i(display, "display");
        s.i(point, "point");
        display.getRealSize(point);
    }
}
