package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.flow.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowInfoTrackerImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final WindowBackend windowBackend;

    @NotNull
    private final WindowMetricsCalculator windowMetricsCalculator;

    /* compiled from: WindowInfoTrackerImpl.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WindowInfoTrackerImpl(@NotNull WindowMetricsCalculator windowMetricsCalculator, @NotNull WindowBackend windowBackend) {
        s.i(windowMetricsCalculator, "windowMetricsCalculator");
        s.i(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    @NotNull
    public kotlinx.coroutines.flow.c<WindowLayoutInfo> windowLayoutInfo(@NotNull Activity activity) {
        s.i(activity, "activity");
        return e.u(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, null));
    }
}
