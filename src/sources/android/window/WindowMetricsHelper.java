package android.window;

import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowMetrics;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WindowMetricsHelper {
    private WindowMetricsHelper() {
    }

    public static Rect getBoundsExcludingNavigationBarAndCutout(WindowMetrics windowMetrics) {
        WindowInsets windowInsets = windowMetrics.getWindowInsets();
        Rect result = new Rect(windowMetrics.getBounds());
        result.inset(windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout()));
        return result;
    }
}
