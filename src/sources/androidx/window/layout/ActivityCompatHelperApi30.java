package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActivityCompatHelper.kt */
@RequiresApi(30)
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ActivityCompatHelperApi30 {

    @NotNull
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    @NotNull
    public final Rect currentWindowBounds(@NotNull Activity activity) {
        s.i(activity, "activity");
        Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        s.h(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }

    @NotNull
    public final Rect maximumWindowBounds(@NotNull Activity activity) {
        s.i(activity, "activity");
        Rect bounds = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        s.h(bounds, "activity.windowManager.maximumWindowMetrics.bounds");
        return bounds;
    }
}
